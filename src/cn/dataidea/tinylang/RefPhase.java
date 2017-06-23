package cn.dataidea.tinylang;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

import cn.dataidea.tinylang.env.BuiltinTypeSymbol;
import cn.dataidea.tinylang.env.ClassSymbol;
import cn.dataidea.tinylang.env.GenericFunction;
import cn.dataidea.tinylang.env.GlobalScope;
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
 * @createTime 下午4:28:07
 * @version 1.0
 */
public class RefPhase extends TinyBaseListener {
	ParseTreeProperty<Scope> scopes;
	GlobalScope globals;
	Scope currentScope;
	ClassSymbol currentClass;
	boolean on_error = false;

	public RefPhase(DefPhase def) {
		this.globals = def.globals;
		this.scopes = def.scopes;
		currentScope = globals;
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

	public void enterLetInExp(TinyParser.LetInExpContext ctx) {
		currentScope = scopes.get(ctx);
	}

	public void exitLetInExp(TinyParser.LetInExpContext ctx) {
		currentScope = currentScope.getEnclosingScope();
	}

	public void exitFunExp(TinyParser.FunExpContext ctx) {
		String name = ctx.ID().getSymbol().getText();
		Symbol fun = currentScope.resolve(name);
		if (fun == null) {
			System.err.println("no such function: " + name);
			on_error = true;
		} else if (!(fun instanceof GenericFunction)) {
			System.err.println(name + " is not a function");
			on_error = true;
		}
	}

	public void exitVarasm(TinyParser.VarasmContext ctx) {
		String name = ctx.vardec().ID().getText();
		VariableSymbol var;
		if (currentScope.getEnclosingScope() instanceof ClassSymbol) {
			ClassSymbol cls = (ClassSymbol) currentScope.getEnclosingScope();
			var = (VariableSymbol) cls.resolveMember(name);
		} else
			var = (VariableSymbol) currentScope.resolve(name);
		var.setInit(true);
	}

	public void exitVarExp(TinyParser.VarExpContext ctx) {
		String name = ctx.ID().getText();
		Symbol sym = currentScope.resolve(name);
		if (sym instanceof VariableSymbol) {
			VariableSymbol var = (VariableSymbol) sym;
			if (!var.initp()) {
				System.err.println("[exitVarExp] access to uninitialized variable: " + name);
				on_error = true;
			}
		} else {
			System.err.println("[exitVarExp] no such variable: " + name);
			on_error = true;
		}
	}

	public boolean on_error() {
		return on_error;
	} 

	public void enterFun(TinyParser.FunContext ctx) {
		String name = ctx.ID().getText();
		MethodSymbol method = (MethodSymbol) scopes.get(ctx);
		Symbol sym = currentScope.resolve(name);
		if (sym == null) {
			GenericFunction gf = new GenericFunction(name, currentScope, method.nargs());
			System.out.println("created new generic function: " + name);
			currentScope.define(gf);
			sym = (Symbol) gf;
		}
		if (sym instanceof GenericFunction) {
			GenericFunction gf = (GenericFunction) sym;
			String cname = method.getName();
			boolean flag = gf.addMethod(method);
			if (flag)
				System.out.println("added new method " + cname + " into generic function " + gf.getName());
			else {
				System.err.println("[enterFun] error when adding new method into gf");
				on_error = true;
			}
		} else {
			System.err.println("[enterFun] non-function symbol detected:" + name);
			on_error = true;
		}
		currentScope = scopes.get(ctx);
	}

	public void exitFun(TinyParser.FunContext ctx) {
		currentScope = currentScope.getEnclosingScope();
	}

	public void enterDefcls(TinyParser.DefclsContext ctx) {
		String name = ctx.ID().getText();
		ClassSymbol cls = (ClassSymbol) globals.resolve(name);
		MethodSymbol function = cls.initFunction();
		currentScope = function;
		currentClass = cls;
	}

	public void exitDefcls(TinyParser.DefclsContext ctx) {
		currentScope = globals;
	}
}
