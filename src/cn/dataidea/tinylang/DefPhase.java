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
		globals = new GlobalScope(); 	// 准备全局作用域
		initializeTypeSystem(); 				// 初始化类型系统
		currentScope = globals; 			// 作用域初始化为全局作用域
	}
    
	/**
	 * 初始化类型系统
	 */
	public void initializeTypeSystem() {
		globals.define(new BuiltinTypeSymbol("bool")); // bool 类型
		globals.define(new BuiltinTypeSymbol("int"));    // 整型
		initializeClassSystem();
	}
	
	/**
	 * 定义类系统, 创建一个顶级类
	 */
	public void initializeClassSystem() {
		ClassSymbol top = new ClassSymbol(ClassSymbol.top, globals, null);
		top.setID(1);
		globals.define(top);
	}
	
	/**
	 * 通过符号名称获取符号类型
	 * @param name 符号名称
	 * @return
	 */
	public Type getType(String name) {
		Symbol sym = globals.resolve(name);
		if (sym instanceof BuiltinTypeSymbol)
			return (Type) sym;
		else if (sym instanceof ClassSymbol)
			return (Type) sym;
		else
			return null;
	}

	/**
	 * 保存作用域
	 * @param ctx
	 * @param s
	 */
	void saveScope(ParseTree ctx, Scope s) {
		scopes.put(ctx, s);
	}

	public void enterLetInExp(TinyParser.LetInExpContext ctx) {
		LocalScope s = new LocalScope(currentScope);
		saveScope(ctx, s);
		if (currentScope.getScopeName() != "global") {
			int id = currentScope.getID();
			s.setID(id);
		}
		currentScope = s;
	}

	public void exitLetInExp(TinyParser.LetInExpContext ctx) {
		System.out.println("let :  " + currentScope+"  id  is " + currentScope.getID() );
		int n = currentScope.getID();
		currentScope = currentScope.getEnclosingScope();
		if (currentScope.getScopeName() != "global") {
			int id = currentScope.getID();
			MethodSymbol fun = (MethodSymbol) currentScope;
			fun.setLocals(n - id);
		}
	}

	public void enterFun(TinyParser.FunContext ctx) {
		String name = ctx.ID().getText();
		String typeName = ctx.type().getText();
		Type type = getType(typeName);
		if (type != null) {
			MethodSymbol function = new MethodSymbol(name, type, currentScope);
			saveScope(ctx, function);
			int id = currentScope.getID();
			function.setID(id);
			currentScope = function;
		} else {
			System.err.println("[enterFun] invalid type: " + typeName + " of function " + name);
			on_error = true;
		}
	}

	public void exitFun(TinyParser.FunContext ctx) {
		System.out.println("function  :  " + currentScope+" id  is " +currentScope.getID());
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
		    System.err.println("no such variable: " + name);
		    on_error = true;
		} else if (!(var instanceof VariableSymbol)) {
		    System.err.println(name + " is not a variable");
		    on_error = true;
		}
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
		
		int id = parentClass.getID();
		cls.setID(id);
		System.out.println( "[ class : "+name + " ] id  is " + id);
		currentClass = cls;
		saveScope(ctx, cls);
        
		MethodSymbol function = new MethodSymbol(name + "_init", (Type) cls, currentClass);
		function.setID(1);
		currentScope.define(function);
		cls.setInitFunction(function);

		MethodSymbol newFun = new MethodSymbol(name + "_new", (Type) cls, currentClass);
		newFun.setID(1);
		currentScope.define(newFun);
		cls.setNewFunction(newFun);
		
		currentScope = function;
	}

	public void exitDefcls(TinyParser.DefclsContext ctx) {
		MethodSymbol init = currentClass.initFunction();
		MethodSymbol nf = currentClass.newFunction();
		nf.setID(init.getID());
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
					return;
				}
			}
			VariableSymbol var = new VariableSymbol(name, type);
			currentScope.define(var);
			if (currentScope instanceof MethodSymbol) {
				var.setInit(true);
			}
		} else {
			System.err.println("[defineVar] invalid type: " + typeName + " of variable " + name);
			on_error = true;
		}
	}
	
	public void enterSlots(TinyParser.SlotsContext ctx) {
		currentScope = currentClass;
	}

	public void exitSlots(TinyParser.SlotsContext ctx) {
		currentScope = currentClass.initFunction();
	}
	
	public boolean on_error() {
		return on_error;
	} 

	public ClassSymbol getClass(String name) {
		Symbol cls = globals.resolve(name);
		if (cls instanceof ClassSymbol)
			return (ClassSymbol) cls;
		else
			return null;
	}

}
