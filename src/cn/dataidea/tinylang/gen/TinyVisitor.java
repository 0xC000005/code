package cn.dataidea.tinylang.gen;

// Generated from Tiny.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TinyParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TinyVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TinyParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(TinyParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code codeBody}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCodeBody(TinyParser.CodeBodyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code globalVar}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalVar(TinyParser.GlobalVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDef}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(TinyParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleExp(TinyParser.SingleExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetInExp(TinyParser.LetInExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#defcls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefcls(TinyParser.DefclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#supers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSupers(TinyParser.SupersContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#slots}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlots(TinyParser.SlotsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slotNoInit}
	 * labeled alternative in {@link TinyParser#slotd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotNoInit(TinyParser.SlotNoInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slotInit}
	 * labeled alternative in {@link TinyParser#slotd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotInit(TinyParser.SlotInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#let}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet(TinyParser.LetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link TinyParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignment(TinyParser.VarAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funDeclaration}
	 * labeled alternative in {@link TinyParser#dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunDeclaration(TinyParser.FunDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(TinyParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#varasm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarasm(TinyParser.VarasmContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#vardec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardec(TinyParser.VardecContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(TinyParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(TinyParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(TinyParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link TinyParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(TinyParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBaseExp(TinyParser.BaseExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExp(TinyParser.ClassExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExp(TinyParser.VarExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntVal(TinyParser.IntValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodExp(TinyParser.MethodExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code slotExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSlotExp(TinyParser.SlotExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExp(TinyParser.IfExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExp(TinyParser.PrintExpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolVal(TinyParser.BoolValContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunExp(TinyParser.FunExpContext ctx);
}