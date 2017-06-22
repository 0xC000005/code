package cn.dataidea.tinylang.gen;

// Generated from Tiny.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinyParser}.
 */
public interface TinyListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinyParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(TinyParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(TinyParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code codeBody}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 */
	void enterCodeBody(TinyParser.CodeBodyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code codeBody}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 */
	void exitCodeBody(TinyParser.CodeBodyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code globalVar}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 */
	void enterGlobalVar(TinyParser.GlobalVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code globalVar}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 */
	void exitGlobalVar(TinyParser.GlobalVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDef}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(TinyParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDef}
	 * labeled alternative in {@link TinyParser#block}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(TinyParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 */
	void enterSingleExp(TinyParser.SingleExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleExp}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 */
	void exitSingleExp(TinyParser.SingleExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 */
	void enterLetInExp(TinyParser.LetInExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code letInExp}
	 * labeled alternative in {@link TinyParser#body}.
	 * @param ctx the parse tree
	 */
	void exitLetInExp(TinyParser.LetInExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#defcls}.
	 * @param ctx the parse tree
	 */
	void enterDefcls(TinyParser.DefclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#defcls}.
	 * @param ctx the parse tree
	 */
	void exitDefcls(TinyParser.DefclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#supers}.
	 * @param ctx the parse tree
	 */
	void enterSupers(TinyParser.SupersContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#supers}.
	 * @param ctx the parse tree
	 */
	void exitSupers(TinyParser.SupersContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#slots}.
	 * @param ctx the parse tree
	 */
	void enterSlots(TinyParser.SlotsContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#slots}.
	 * @param ctx the parse tree
	 */
	void exitSlots(TinyParser.SlotsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slotNoInit}
	 * labeled alternative in {@link TinyParser#slotd}.
	 * @param ctx the parse tree
	 */
	void enterSlotNoInit(TinyParser.SlotNoInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slotNoInit}
	 * labeled alternative in {@link TinyParser#slotd}.
	 * @param ctx the parse tree
	 */
	void exitSlotNoInit(TinyParser.SlotNoInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slotInit}
	 * labeled alternative in {@link TinyParser#slotd}.
	 * @param ctx the parse tree
	 */
	void enterSlotInit(TinyParser.SlotInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slotInit}
	 * labeled alternative in {@link TinyParser#slotd}.
	 * @param ctx the parse tree
	 */
	void exitSlotInit(TinyParser.SlotInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#let}.
	 * @param ctx the parse tree
	 */
	void enterLet(TinyParser.LetContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#let}.
	 * @param ctx the parse tree
	 */
	void exitLet(TinyParser.LetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link TinyParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignment(TinyParser.VarAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link TinyParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignment(TinyParser.VarAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funDeclaration}
	 * labeled alternative in {@link TinyParser#dec}.
	 * @param ctx the parse tree
	 */
	void enterFunDeclaration(TinyParser.FunDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funDeclaration}
	 * labeled alternative in {@link TinyParser#dec}.
	 * @param ctx the parse tree
	 */
	void exitFunDeclaration(TinyParser.FunDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(TinyParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(TinyParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#varasm}.
	 * @param ctx the parse tree
	 */
	void enterVarasm(TinyParser.VarasmContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#varasm}.
	 * @param ctx the parse tree
	 */
	void exitVarasm(TinyParser.VarasmContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#vardec}.
	 * @param ctx the parse tree
	 */
	void enterVardec(TinyParser.VardecContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#vardec}.
	 * @param ctx the parse tree
	 */
	void exitVardec(TinyParser.VardecContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TinyParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TinyParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(TinyParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(TinyParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(TinyParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(TinyParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinyParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(TinyParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinyParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(TinyParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBaseExp(TinyParser.BaseExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code baseExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBaseExp(TinyParser.BaseExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterClassExp(TinyParser.ClassExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitClassExp(TinyParser.ClassExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterVarExp(TinyParser.VarExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitVarExp(TinyParser.VarExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIntVal(TinyParser.IntValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intVal}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIntVal(TinyParser.IntValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterMethodExp(TinyParser.MethodExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitMethodExp(TinyParser.MethodExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code slotExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterSlotExp(TinyParser.SlotExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code slotExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitSlotExp(TinyParser.SlotExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterIfExp(TinyParser.IfExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitIfExp(TinyParser.IfExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterPrintExp(TinyParser.PrintExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitPrintExp(TinyParser.PrintExpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterBoolVal(TinyParser.BoolValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolVal}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitBoolVal(TinyParser.BoolValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void enterFunExp(TinyParser.FunExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funExp}
	 * labeled alternative in {@link TinyParser#value}.
	 * @param ctx the parse tree
	 */
	void exitFunExp(TinyParser.FunExpContext ctx);
}