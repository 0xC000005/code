package org.tinylang;
/*
 ============================================================================
 Name       		: InitializationBeforeUseChecker.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: 
 ============================================================================
 */

import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.tinylang.antlr.TinyLangBaseVisitor;
import org.tinylang.antlr.TinyLangParser;
import org.tinylang.scope.Scope;
import org.tinylang.symbol.Symbol;

public class InitializationBeforeUseChecker extends TinyLangBaseVisitor<Set<Symbol>> {
	TinyLangParser parser;
	final Map<String, Klass> klasses;
	ParseTreeProperty<Scope> scopes;
	Scope currentScope = null;

	public InitializationBeforeUseChecker(final Map<String, Klass> klasses, ParseTreeProperty<Scope> scopes,
			TinyLangParser parser) {
		this.scopes = scopes;
		this.klasses = klasses;
		this.parser = parser;
	}

	@Override
	public Set<Symbol> visitClassDeclaration(TinyLangParser.ClassDeclarationContext ctx) {
		enterScope(ctx);
		visitChildren(ctx);
		exitScope();
		return null;
	}

	@Override
	public Set<Symbol> visitMethodDeclaration(TinyLangParser.MethodDeclarationContext ctx) {
		enterScope(ctx);
		visitChildren(ctx);
		exitScope();
		return null;
	}

	@Override
	public Set<Symbol> visitIfElseStatement(TinyLangParser.IfElseStatementContext ctx) {
		visit(ctx.expression());
		Set<Symbol> initializedVariables = visit(ctx.ifBlock());
		initializedVariables.retainAll(visit(ctx.elseBlock()));
		for (Symbol sym : initializedVariables) {
			currentScope.initialize(sym);
		}
		return initializedVariables;
	}

	@Override
	public Set<Symbol> visitIfBlock(TinyLangParser.IfBlockContext ctx) {
		enterScope(ctx);
		visitChildren(ctx);
		Set<Symbol> ifInit = currentScope.getInitializedVariables();
		exitScope();
		return ifInit;
	}

	@Override
	public Set<Symbol> visitElseBlock(TinyLangParser.ElseBlockContext ctx) {
		enterScope(ctx);
		visitChildren(ctx);
		Set<Symbol> elseInit = currentScope.getInitializedVariables();
		exitScope();
		return elseInit;
	}

	@Override
	public Set<Symbol> visitWhileStatement(TinyLangParser.WhileStatementContext ctx) {
		enterScope(ctx);
		visitChildren(ctx);
		exitScope();
		return null;
	}

	@Override
	public Set<Symbol> visitVariableAssignmentStatement(TinyLangParser.VariableAssignmentStatementContext ctx) {
		Set<Symbol> sym = visitChildren(ctx);
		currentScope.initialize(currentScope.lookup(ctx.Identifier().getText()));
		return sym;
	}

	@Override
	public Set<Symbol> visitIdentifierExpression(TinyLangParser.IdentifierExpressionContext ctx) {
		String identifier = ctx.Identifier().getText();
		if (!currentScope.hasBeenInitialized(identifier)) {
			ErrorPrinter.printVariableMayNotHaveBeenInitializedError(parser, ctx.Identifier().getSymbol(), identifier);
		}
		return visitChildren(ctx);
	}

	public void enterScope(ParserRuleContext ctx) {
		currentScope = scopes.get(ctx);
	}

	private void exitScope() {
		currentScope = currentScope.getEnclosingScope();
	}
}
