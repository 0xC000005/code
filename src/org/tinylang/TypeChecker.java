package org.tinylang;
/*
 ============================================================================
 Name       		: TypeChecker.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: Hello World in C, Ansi-style
 ============================================================================
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.tinylang.antlr.TinyLangBaseVisitor;
import org.tinylang.antlr.TinyLangParser;
import org.tinylang.scope.Scope;
import org.tinylang.symbol.Symbol;

public class TypeChecker extends TinyLangBaseVisitor<Klass> {
	private Map<String, Klass> klasses;
	private ParseTreeProperty<Scope> scopes;
	private Scope currentScope;
	private ParseTreeProperty<Klass> callerTypes;
	private TinyLangParser parser;
	private Klass INT;
	private Klass INTARRAY;
	private Klass BOOLEAN;

	public TypeChecker(final Map<String, Klass> klasses, ParseTreeProperty<Scope> scopes,
			ParseTreeProperty<Klass> callerTypes, TinyLangParser parser) {
		this.INT = klasses.get("int");
		this.klasses = klasses;
		this.scopes = scopes;
		this.callerTypes = callerTypes;
		this.INTARRAY = klasses.get("int[]");
		this.BOOLEAN = klasses.get("boolean");
		this.parser = parser;
	}

	@Override
	public Klass visitMainClass(TinyLangParser.MainClassContext ctx) {
		System.out.println("visitMainClass");
		return scopingCall(ctx);
	}

	@Override
	public Klass visitClassDeclaration(TinyLangParser.ClassDeclarationContext ctx) {
		System.out.println("visitClassDeclaration");
		return scopingCall(ctx);
	}

	@Override
	public Klass visitMethodDeclaration(TinyLangParser.MethodDeclarationContext ctx) {
		System.out.println("visitMethodDeclaration");
		currentScope = scopes.get(ctx);

		Klass originalKlass = ((Klass) (currentScope.getEnclosingScope())).getSuperKlass();
		Method originalMethod;
		if (originalKlass == null) {
			originalMethod = null;
		} else {
			originalMethod = (Method) originalKlass.lookup(currentScope.getScopeName());
		}

		Method currentMethod = (Method) currentScope;
		Klass currentKlass = (Klass) currentMethod.getEnclosingScope();
		if (originalMethod != null && originalMethod.getType() != currentMethod.getType()) {
			ErrorPrinter.printIncompatibleReturnTypeError(parser, ctx.Identifier().getSymbol(), originalKlass,
					currentKlass, originalMethod, currentMethod);
		}

		visitChildren(ctx);
		currentScope = currentScope.getEnclosingScope();
		return null;
	}

	@Override
	public Klass visitMethodBody(TinyLangParser.MethodBodyContext ctx) {
		System.out.println("visitMethodBody");
		for (TinyLangParser.LocalDeclarationContext pCtx : ctx.localDeclaration()) {
			visit(pCtx);
		}
		for (TinyLangParser.StatementContext pCtx : ctx.statement()) {
			visit(pCtx);
		}
		Klass formalReturnType = Scope.getEnclosingMethod(currentScope).getType();
		Klass actualReturnType = visit(ctx.expression());
		if (actualReturnType != null && !actualReturnType.isDescendantOf(formalReturnType)) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.RETURN().getSymbol(),
					formalReturnType.toString(), actualReturnType.toString());
		}
		return null;
	}

	@Override
	public Klass visitType(TinyLangParser.TypeContext ctx) {
		System.out.println("visitType");
		if (ctx.Identifier() != null) {
			String name = ctx.Identifier().getSymbol().getText();
			Klass var = klasses.get(name);
			if (var == null) {
				ErrorPrinter.printUnresolvedSymbolError(parser, ctx.Identifier().getSymbol(), "class",
						Scope.getEnclosingKlass(currentScope));
			}
			return var;
		}
		return null;
	}

	@Override
	public Klass visitIfElseStatement(TinyLangParser.IfElseStatementContext ctx) {
		System.out.println("visitIfElseStatement");
		Klass booleanExpression = visit(ctx.expression());
		visit(ctx.ifBlock());
		visit(ctx.elseBlock());
		if (booleanExpression != BOOLEAN) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.LP().getSymbol(),
					BOOLEAN.toString(), booleanExpression.toString());
		}
		return null;
	}

	@Override
	public Klass visitWhileStatement(TinyLangParser.WhileStatementContext ctx) {
		System.out.println("visitWhileStatement");
		Klass booleanExpression = visit(ctx.expression());
		visit(ctx.whileBlock());
		if (booleanExpression != BOOLEAN) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.LP().getSymbol(),
					BOOLEAN.toString(), booleanExpression.toString());
		}
		return null;
	}

	@Override
	public Klass visitPrintStatement(TinyLangParser.PrintStatementContext ctx) {
		System.out.println("visitPrintStatement");
		Klass printContents = visit(ctx.expression());
		if (printContents != null && printContents != INT) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.LP().getSymbol(),
					INT.toString(), printContents.toString());
		}
		return null;
	}

	@Override
	public Klass visitVariableAssignmentStatement(TinyLangParser.VariableAssignmentStatementContext ctx) {
		System.out.println("visitVariableAssignmentStatement");
		String name = ctx.Identifier().getSymbol().getText();
		Symbol var = currentScope.lookup(name);

		Klass rightSide = visit(ctx.expression());
		if (var == null) {
			ErrorPrinter.printUnresolvedSymbolError(parser, ctx.Identifier().getSymbol(), "variable",
					Scope.getEnclosingKlass(currentScope));
		} else if (rightSide != null && !rightSide.isDescendantOf(var.getType())) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.Identifier().getSymbol(),
					var.getType().toString(), (rightSide.toString()));
		}
		return null;
	}

	@Override
	public Klass visitArrayAssignmentStatement(TinyLangParser.ArrayAssignmentStatementContext ctx) {
		System.out.println("visitArrayAssignmentStatement");
		String name = ctx.Identifier().getSymbol().getText();
		Symbol var = currentScope.lookup(name);
		Klass index = visit(ctx.expression(0));
		Klass rightSide = visit(ctx.expression(1));
		if (var == null) {
			ErrorPrinter.printUnresolvedSymbolError(parser, ctx.Identifier().getSymbol(), "variable",
					Scope.getEnclosingKlass(currentScope));
		} else if (var.getType() != INTARRAY) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.LSB().getSymbol(),
					INTARRAY.toString(), (var.getType().toString()));
		} else if (rightSide != null && INT != rightSide) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.EQ().getSymbol(),
					INT.toString(), (rightSide.toString()));
		} else if (index != INT) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.LSB().getSymbol(),
					INT.toString(), index.toString());
		}
		return null;
	}

	@Override
	public Klass visitAndExpression(TinyLangParser.AndExpressionContext ctx) {
		System.out.println("visitAndExpression");
		ErrorPrinter.binaryOperatorTypeError(parser, ctx, ctx.AND().getSymbol(), visit(ctx.expression(0)),
				visit(ctx.expression(1)), BOOLEAN, BOOLEAN);
		return BOOLEAN;
	}

	@Override
	public Klass visitLtExpression(TinyLangParser.LtExpressionContext ctx) {
		System.out.println("visitLtExpression");
		ErrorPrinter.binaryOperatorTypeError(parser, ctx, ctx.LT().getSymbol(), visit(ctx.expression(0)),
				visit(ctx.expression(1)), INT, INT);
		return BOOLEAN;
	}

	@Override
	public Klass visitAddExpression(TinyLangParser.AddExpressionContext ctx) {
		System.out.println("visitAddExpression");
		ErrorPrinter.binaryOperatorTypeError(parser, ctx, ctx.PLUS().getSymbol(), visit(ctx.expression(0)),
				visit(ctx.expression(1)), INT, INT);
		return INT;
	}

	@Override
	public Klass visitSubExpression(TinyLangParser.SubExpressionContext ctx) {
		System.out.println("visitSubExpression");
		ErrorPrinter.binaryOperatorTypeError(parser, ctx, ctx.MINUS().getSymbol(), visit(ctx.expression(0)),
				visit(ctx.expression(1)), INT, INT);
		return INT;
	}

	@Override
	public Klass visitMulExpression(TinyLangParser.MulExpressionContext ctx) {
		System.out.println("visitMulExpression");
		ErrorPrinter.binaryOperatorTypeError(parser, ctx, ctx.TIMES().getSymbol(), visit(ctx.expression(0)),
				visit(ctx.expression(1)), INT, INT);
		return INT;
	}

	@Override
	public Klass visitPowExpression(TinyLangParser.PowExpressionContext ctx) {
		System.out.println("visitPowExpression");
		ErrorPrinter.binaryOperatorTypeError(parser, ctx, ctx.POWER().getSymbol(), visit(ctx.expression(0)),
				visit(ctx.expression(1)), INT, INT);
		return INT;
	}

	@Override
	public Klass visitArrayAccessExpression(TinyLangParser.ArrayAccessExpressionContext ctx) {
		System.out.println("visitArrayAccessExpression");
		Klass array = visit(ctx.expression(0));
		Klass index = visit(ctx.expression(1));
		if (array != INTARRAY) {
			ErrorPrinter.printFileNameAndLineNumber(ctx.LSB().getSymbol());
			System.err.println("error: array required, but " + array + " found");
			ErrorPrinter.underlineError(parser, ctx.LSB().getSymbol());
		}
		if (index != INT) {
			ErrorPrinter.printRequiredFoundError("error: incompatible type.", parser, ctx.LSB().getSymbol(),
					INT.toString(), index.toString());
		}
		return INT;
	}

	@Override
	public Klass visitArrayLengthExpression(TinyLangParser.ArrayLengthExpressionContext ctx) {
		System.out.println("visitArrayLengthExpression");
		Klass intArr = visit(ctx.expression());
		if (intArr != INTARRAY) {
			ErrorPrinter.printFileNameAndLineNumber(ctx.DOTLENGTH().getSymbol());
			System.err.println("error: bad operand type " + intArr + " for unary operator '.length'");
			ErrorPrinter.underlineError(parser, ctx.DOTLENGTH().getSymbol());
		}
		return INT;
	}

	@Override
	public Klass visitMethodCallExpression(TinyLangParser.MethodCallExpressionContext ctx) {
		System.out.println("visitMethodCallExpression");
		Klass type = visit(ctx.expression(0));
		callerTypes.put(ctx, type);
		if (type == null) {
			return null;
		}
		String methodName = ctx.Identifier().getText() + "()";
		Method method = (Method) (type.lookup(methodName));
		if (method == null) {
			ErrorPrinter.printUnresolvedSymbolError(parser, ctx.Identifier().getSymbol(), "method", type);
			return null;
		} else {
			List<Klass> parameterList = new ArrayList<Klass>();
			for (TinyLangParser.ExpressionContext expCtx : ctx.expression().subList(1, ctx.expression().size())) {
				parameterList.add(visit(expCtx));
			}
			List<Klass> parameterListDefinition = method.getParameterListDefinition();
			if (parameterListDefinition.size() != parameterList.size()) {
				ErrorPrinter.printRequiredFoundError(
						"error: method call parameters of method " + method.getName()
								+ " do not match method definition.",
						parser, ctx.Identifier().getSymbol(), parameterListDefinition.toString(),
						parameterList.toString());
				System.err.println("reason: actual and formal argument lists differ in length.");
				return method.getType();
			}
			for (int i = 0; i < parameterListDefinition.size(); i++) {
				if (!parameterList.get(i).isDescendantOf(parameterListDefinition.get(i))) {
					ErrorPrinter.printRequiredFoundError(
							"error: method call parameters of method " + method.getName()
									+ " do not match method definition.",
							parser, ctx.Identifier().getSymbol(), parameterListDefinition.toString(),
							parameterList.toString());
				}
			}
			return method.getType();
		}
	}

	@Override
	public Klass visitIntLitExpression(TinyLangParser.IntLitExpressionContext ctx) {
		visitChildren(ctx);
		return INT;
	}

	@Override
	public Klass visitBooleanLitExpression(TinyLangParser.BooleanLitExpressionContext ctx) {
		visitChildren(ctx);
		return BOOLEAN;
	}

	@Override
	public Klass visitIdentifierExpression(TinyLangParser.IdentifierExpressionContext ctx) {
		String name = ctx.Identifier().getSymbol().getText();
		Symbol var = currentScope.lookup(name);
		if (var == null) {
			ErrorPrinter.printUnresolvedSymbolError(parser, ctx.Identifier().getSymbol(), "variable",
					Scope.getEnclosingKlass(currentScope));
			return null;
		}
		return var.getType();
	}

	@Override
	public Klass visitThisExpression(TinyLangParser.ThisExpressionContext ctx) {
		visitChildren(ctx);
		return Scope.getEnclosingKlass(currentScope);
	}

	@Override
	public Klass visitArrayInstantiationExpression(TinyLangParser.ArrayInstantiationExpressionContext ctx) {
		Klass type = visit(ctx.expression());
		if (type != INT) {
			ErrorPrinter.printRequiredFoundError("error: incompatible types.", parser, ctx.LSB().getSymbol(),
					INT.toString(), type.toString());
		}
		return INTARRAY;
	}

	@Override
	public Klass visitObjectInstantiationExpression(TinyLangParser.ObjectInstantiationExpressionContext ctx) {
		Klass type = klasses.get(ctx.Identifier().getText());
		if (type == null) {
			ErrorPrinter.printUnresolvedSymbolError(parser, ctx.Identifier().getSymbol(), "class",
					Scope.getEnclosingKlass(currentScope));
		}
		return type;
	}

	@Override
	public Klass visitNotExpression(TinyLangParser.NotExpressionContext ctx) {
		Klass bool = visit(ctx.expression());
		if (bool != BOOLEAN) {
			ErrorPrinter.printFileNameAndLineNumber(ctx.NOT().getSymbol());
			System.err.println("error: bad operand type " + bool + " for unary operator '!'");
			ErrorPrinter.underlineError(parser, ctx.NOT().getSymbol());
		}
		return BOOLEAN;
	}

	@Override
	public Klass visitParenExpression(TinyLangParser.ParenExpressionContext ctx) {
		System.out.println("visitParenExpression");
		return visit(ctx.expression());
	}

	// ----------------------------------------------------------------------
	public Klass scopingCall(ParserRuleContext ctx) {
		currentScope = scopes.get(ctx);
		visitChildren(ctx);
		currentScope = currentScope.getEnclosingScope();
		return null;
	}
}
