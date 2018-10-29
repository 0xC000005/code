package org.tinylang;
/*
 ============================================================================
 Name       		: AssignmentListener.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: 
 ============================================================================
 */

import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.tinylang.antlr.TinyLangBaseListener;
import org.tinylang.antlr.TinyLangParser;
import org.tinylang.scope.Block;
import org.tinylang.scope.Scope;
import org.tinylang.symbol.Symbol;

public class AssignmentListener extends TinyLangBaseListener {

	TinyLangParser parser;
	final Map<String, Klass> klasses;
	ParseTreeProperty<Scope> scopes;
	Scope currentScope = null;
	boolean isField;

	public AssignmentListener(final Map<String, Klass> klasses, ParseTreeProperty<Scope> scopes,
			TinyLangParser parser) {
		this.scopes = scopes;
		this.klasses = klasses;
		this.parser = parser;
	}

	private void saveScope(ParserRuleContext ctx, Scope s) {
		scopes.put(ctx, s);
	}

	@Override
	public void enterMainClass(TinyLangParser.MainClassContext ctx) {
		Klass klass = klasses.get(ctx.Identifier(0).getText());
		currentScope = klass;
		saveScope(ctx, currentScope);
	}

	@Override
	public void enterClassDeclaration(TinyLangParser.ClassDeclarationContext ctx) {
		Klass klass = klasses.get(ctx.Identifier(0).getText());
		currentScope = klass;
		saveScope(ctx, currentScope);
		Klass superKlass;
		if (ctx.Identifier().size() > 1) {
			superKlass = klasses.get(ctx.Identifier(1).getText());
			if (superKlass == null) {
				ErrorPrinter.printFileNameAndLineNumber(ctx.Identifier(1).getSymbol());
				System.err.println("error: cannot find symbol.");
				ErrorPrinter.underlineError(parser, ctx.Identifier(1).getSymbol());
				System.err.println("symbol:   class " + ctx.Identifier(1).getText());
			}
		} else {
			superKlass = null;
		}
		klass.setSuperKlass(superKlass);
		ErrorPrinter.reportCyclicInheritance(parser, ctx, klass);
	}

	@Override
	public void exitClassDeclaration(TinyLangParser.ClassDeclarationContext ctx) {
		currentScope = currentScope.getEnclosingScope();
	}

	@Override
	public void enterFieldDeclaration(TinyLangParser.FieldDeclarationContext ctx) {
		isField = true;
	}

	@Override
	public void exitFieldDeclaration(TinyLangParser.FieldDeclarationContext ctx) {
		isField = false;
	}

	@Override
	public void enterVarDeclaration(TinyLangParser.VarDeclarationContext ctx) {
		String typeName = ctx.type().getText();
		String varName = ctx.Identifier().getText();
		if (currentScope.lookupLocally(varName) != null) {
			ErrorPrinter.printSymbolAlreadyDefinedError(parser, ctx.Identifier().getSymbol(), "variable", varName,
					currentScope.getScopeName());
		}
		currentScope.define(new Symbol(varName, klasses.get(typeName), isField));
	}

	@Override
	public void enterMethodDeclaration(TinyLangParser.MethodDeclarationContext ctx) {
		Klass returnType = klasses.get(ctx.type().getText());
		if (returnType == null) {
			ErrorPrinter.printFullError(parser, ctx.type().Identifier().getSymbol(), "error: cannot find symbol.",
					"symbol:   class " + ctx.type().getText(), "location: class " + currentScope.getScopeName());
		}
		String methodName = Method.getMethodSignature(ctx);
		if (currentScope.lookupLocally(methodName) != null) {
			ErrorPrinter.printSymbolAlreadyDefinedError(parser, ctx.Identifier().getSymbol(), "method", methodName,
					currentScope.getScopeName());
		}
		Scope owner = currentScope;
		Method method = new Method(returnType, methodName, owner);
		currentScope.define(method);
		currentScope = method;
		saveScope(ctx, currentScope);
	}

	@Override
	public void exitMethodDeclaration(TinyLangParser.MethodDeclarationContext ctx) {
		currentScope = currentScope.getEnclosingScope();
	}

	@Override
	public void enterParameter(TinyLangParser.ParameterContext ctx) {
		Symbol parameter;
		Klass parameterType = klasses.get(ctx.type().getText());
		if (parameterType == null) {
			ErrorPrinter.printFullError(parser, ctx.type().Identifier().getSymbol(), "error: cannot find symbol.",
					"symbol:   class " + ctx.type().getText(),
					"location: class " + currentScope.getEnclosingScope().getScopeName());
		}

		parameter = new Symbol(ctx.Identifier().getText(), parameterType, false);
		((Method) currentScope).addParameter(parameter);
	}

	@Override
	public void enterNestedStatement(TinyLangParser.NestedStatementContext ctx) {
		enterScope(ctx);
	}

	@Override
	public void exitNestedStatement(TinyLangParser.NestedStatementContext ctx) {
		exitScope();
	}

	@Override
	public void enterIfBlock(TinyLangParser.IfBlockContext ctx) {
		enterScope(ctx);
	}

	@Override
	public void exitIfBlock(TinyLangParser.IfBlockContext ctx) {
		exitScope();
	}

	@Override
	public void enterElseBlock(TinyLangParser.ElseBlockContext ctx) {
		enterScope(ctx);
	}

	@Override
	public void exitElseBlock(TinyLangParser.ElseBlockContext ctx) {
		exitScope();
	}

	@Override
	public void enterWhileStatement(TinyLangParser.WhileStatementContext ctx) {
		enterScope(ctx);
	}

	@Override
	public void exitWhileStatement(TinyLangParser.WhileStatementContext ctx) {
		exitScope();
	}

	public void enterScope(ParserRuleContext ctx) {
		Block explicitScope = new Block(currentScope);
		currentScope = explicitScope;
		saveScope(ctx, currentScope);
	}

	public void exitScope() {
		currentScope = currentScope.getEnclosingScope();
	}
}
