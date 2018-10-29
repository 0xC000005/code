package org.tinylang.antlr;

// Generated from TinyLang.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinyLangParser}.
 */
public interface TinyLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(TinyLangParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(TinyLangParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(TinyLangParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(TinyLangParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(TinyLangParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(TinyLangParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(TinyLangParser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(TinyLangParser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#localDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalDeclaration(TinyLangParser.LocalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#localDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalDeclaration(TinyLangParser.LocalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(TinyLangParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(TinyLangParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(TinyLangParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(TinyLangParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(TinyLangParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(TinyLangParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(TinyLangParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(TinyLangParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(TinyLangParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(TinyLangParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TinyLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TinyLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nestedStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterNestedStatement(TinyLangParser.NestedStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nestedStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitNestedStatement(TinyLangParser.NestedStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifElseStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfElseStatement(TinyLangParser.IfElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifElseStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfElseStatement(TinyLangParser.IfElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(TinyLangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(TinyLangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPrintStatement(TinyLangParser.PrintStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPrintStatement(TinyLangParser.PrintStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableAssignmentStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVariableAssignmentStatement(TinyLangParser.VariableAssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableAssignmentStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVariableAssignmentStatement(TinyLangParser.VariableAssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssignmentStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignmentStatement(TinyLangParser.ArrayAssignmentStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssignmentStatement}
	 * labeled alternative in {@link TinyLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignmentStatement(TinyLangParser.ArrayAssignmentStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfBlock(TinyLangParser.IfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfBlock(TinyLangParser.IfBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void enterElseBlock(TinyLangParser.ElseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#elseBlock}.
	 * @param ctx the parse tree
	 */
	void exitElseBlock(TinyLangParser.ElseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyLangParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileBlock(TinyLangParser.WhileBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyLangParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileBlock(TinyLangParser.WhileBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLtExpression(TinyLangParser.LtExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ltExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLtExpression(TinyLangParser.LtExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectInstantiationExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterObjectInstantiationExpression(TinyLangParser.ObjectInstantiationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectInstantiationExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitObjectInstantiationExpression(TinyLangParser.ObjectInstantiationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayInstantiationExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayInstantiationExpression(TinyLangParser.ArrayInstantiationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayInstantiationExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayInstantiationExpression(TinyLangParser.ArrayInstantiationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPowExpression(TinyLangParser.PowExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPowExpression(TinyLangParser.PowExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(TinyLangParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(TinyLangParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpression(TinyLangParser.MethodCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpression(TinyLangParser.MethodCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(TinyLangParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(TinyLangParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanLitExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLitExpression(TinyLangParser.BooleanLitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanLitExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLitExpression(TinyLangParser.BooleanLitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(TinyLangParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(TinyLangParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLitExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntLitExpression(TinyLangParser.IntLitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLitExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntLitExpression(TinyLangParser.IntLitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(TinyLangParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(TinyLangParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(TinyLangParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(TinyLangParser.ArrayAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddExpression(TinyLangParser.AddExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddExpression(TinyLangParser.AddExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(TinyLangParser.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(TinyLangParser.ThisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLengthExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLengthExpression(TinyLangParser.ArrayLengthExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLengthExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLengthExpression(TinyLangParser.ArrayLengthExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpression(TinyLangParser.SubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpression(TinyLangParser.SubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mulExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMulExpression(TinyLangParser.MulExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mulExpression}
	 * labeled alternative in {@link TinyLangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMulExpression(TinyLangParser.MulExpressionContext ctx);
}