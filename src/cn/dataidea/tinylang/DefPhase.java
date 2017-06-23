package cn.dataidea.tinylang;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import cn.dataidea.tinylang.env.BuiltinTypeSymbol;
import cn.dataidea.tinylang.env.ClassSymbol;
import cn.dataidea.tinylang.env.GlobalScope;
import cn.dataidea.tinylang.env.LocalScope;
import cn.dataidea.tinylang.env.MethodSymbol;
import cn.dataidea.tinylang.env.Scope;
import cn.dataidea.tinylang.env.Symbol;
import cn.dataidea.tinylang.env.Type;
import cn.dataidea.tinylang.env.VariableSymbol;
import cn.dataidea.tinylang.gen.TinyBaseListener;
import cn.dataidea.tinylang.gen.TinyParser;

/**
 * <p> 符号分析 </p>
 * 
 * @author xiehui
 * @createTime 下午4:36:26
 * @version 1.0
 */
public class DefPhase extends TinyBaseListener {
	ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
	GlobalScope globals;
	Scope currentScope;
	ClassSymbol currentClass;
	boolean on_error = false;

	public DefPhase() {
		globals = new GlobalScope();
		initializeTypeSystem();
		currentScope = globals;
	}

	public void initializeTypeSystem() {
		globals.define(new BuiltinTypeSymbol("bool"));
		globals.define(new BuiltinTypeSymbol("int"));
		initializeClassSystem();
	}

	public Type getType(String name) {
		Symbol sym = globals.resolve(name);
		if (sym instanceof BuiltinTypeSymbol)
			return (Type) sym;
		else if (sym instanceof ClassSymbol)
			return (Type) sym;
		else
			return null;
	}

	void saveScope(ParseTree ctx, Scope s) {
		scopes.put(ctx, s);
	}

	public void enterLetInExp(TinyParser.LetInExpContext ctx) {
		LocalScope s = new LocalScope(currentScope);
		saveScope(ctx, s);
		if (currentScope.getScopeName() != "global") {
			int next_id = currentScope.getNextID();
			s.setNextID(next_id);
			System.out.println("Base id of " + s + " is " + next_id);
		}
		currentScope = s;
	}

	public void exitLetInExp(TinyParser.LetInExpContext ctx) {
		System.out.println("局部作用域: " + currentScope);
		int n = currentScope.getNextID();
		currentScope = currentScope.getEnclosingScope();
		if (currentScope.getScopeName() != "global") {
			int next_id = currentScope.getNextID();
			MethodSymbol fun = (MethodSymbol) currentScope;
			fun.setLocals(n - next_id);
		}
	}

	public void enterFun(TinyParser.FunContext ctx) {
		String name = ctx.ID().getText();
		String typeName = ctx.type().getText();
		Type type = getType(typeName);
		if (type != null) {
			MethodSymbol function = new MethodSymbol(name, type, currentScope);
			saveScope(ctx, function);
			int next_id = currentScope.getNextID();
			function.setNextID(next_id);
			System.out.println("Base id of " + function + " is " + next_id);
			currentScope = function;
		} else {
			System.err.println("[enterFun] invalid type: " + typeName + " of function " + name);
			on_error = true;
		}
	}

	public void exitFun(TinyParser.FunContext ctx) {
		System.out.println("定义函数 : " + currentScope);
		currentScope = currentScope.getEnclosingScope();
	}

	public void exitVardec(TinyParser.VardecContext ctx) {
		defineVar(ctx.type(), ctx.ID().getSymbol());
	}

	public void exitVarExp(TinyParser.VarExpContext ctx) {
		String name = ctx.ID().getText();
		Scope scope = currentScope;
		if (scope instanceof ClassSymbol) {
			scope = ((ClassSymbol) scope).initFunction();
		}

		Symbol var = scope.resolve(name);
		if (var == null) {
			System.err.println("此变量不存在 : " + name);
			on_error = true;
		} else if (!(var instanceof VariableSymbol)) {
			System.err.println(name + " 不是一个变量");
			on_error = true;
		}
	}

	public boolean on_error() {
		return on_error;
	} 

	public void initializeClassSystem() {
		ClassSymbol top = new ClassSymbol(ClassSymbol.top, globals, null);
		top.setNextID(1);
		globals.define(top);
	}

	public ClassSymbol getClass(String name) {
		Symbol cls = globals.resolve(name);
		if (cls instanceof ClassSymbol)
			return (ClassSymbol) cls;
		else
			return null;
	}

	public void enterDefcls(TinyParser.DefclsContext ctx) {
		assert (currentScope == globals);
		String parent;
		TinyParser.SupersContext p = ctx.supers();
		if (p != null)
			parent = p.ID().getText();
		else
			parent = ClassSymbol.top;
		ClassSymbol parentClass = getClass(parent);

		String name = ctx.ID().getText();
		ClassSymbol cls = new ClassSymbol(name, currentScope, parentClass);
		currentScope.define(cls);
		
		int next_id = parentClass.getNextID();
		cls.setNextID(next_id);
		System.out.println("Base id of class " + name + " is " + next_id);
		currentClass = cls;
		saveScope(ctx, cls);

		MethodSymbol function = new MethodSymbol(name + "_init", (Type) cls, currentClass);
		function.setNextID(1);
		currentScope.define(function);
		cls.setInitFunction(function);

		MethodSymbol newFun = new MethodSymbol(name + "_new", (Type) cls, currentClass);
		newFun.setNextID(1);
		currentScope.define(newFun);
		cls.setNewFunction(newFun);
		
		currentScope = function;
	}

	public void enterSlots(TinyParser.SlotsContext ctx) {
		currentScope = currentClass;
	}

	public void exitSlots(TinyParser.SlotsContext ctx) {
		System.out.println("定义类 : " + currentScope);
		currentScope = currentClass.initFunction();
	}

	public void exitDefcls(TinyParser.DefclsContext ctx) {
		MethodSymbol init = currentClass.initFunction();
		MethodSymbol nf = currentClass.newFunction();
		nf.setNextID(init.getNextID());
		System.out.println("定义构造函数 : " + currentScope);
		currentScope = globals;
	}

	void defineVar(TinyParser.TypeContext typeCtx, Token nameToken) {
		String name = nameToken.getText();
		String typeName = typeCtx.start.getText();
		System.out.println("定义变量 "+ name+" 类型 "+typeName);
		Type type = getType(typeName);
		if (type != null) {
			Symbol other = currentScope.resolve(name);
			if (other != null && currentScope == other.getScope()) {
				System.err.println("[defineVar] Duplicated variables found in current scope: " + name);
				on_error = true;
				return;
			} else if (currentScope instanceof ClassSymbol) {
				ClassSymbol cls = (ClassSymbol) currentScope;
				other = cls.resolveMember(name);
				if (other != null && currentScope == other.getScope()) {
					System.err.println("[defineVar] Duplicated slots found in current class: " + name);
					on_error = true;
					return;
				} else if (other != null && currentScope != other.getScope()) {
					System.out.println("重写父类 slot: " + name);
					return;
				}
			}
			VariableSymbol var = new VariableSymbol(name, type);
			currentScope.define(var);
			System.out.println("定义 slot/variable " + name + " in " + currentScope);
			if (currentScope instanceof MethodSymbol) {
				var.setInit(true);
			}
		} else {
			System.err.println("[defineVar] invalid type: " + typeName + " of variable " + name);
			on_error = true;
		}
	}
}
