package cn.dataidea.tinylang;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import cn.dataidea.tinylang.gen.TinyBaseListener;

/**
*<p>  终止符及节点统计 </p>
*@author xiehui
*@createTime 下午3:00:53
*@version 1.0
*/
public class CountPhase extends TinyBaseListener{
	 int nodes;
	 int terms;
	
	
	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		super.enterEveryRule(ctx);
		nodes++;
	
	}
	@Override
	public void visitTerminal(TerminalNode node) {
		super.visitTerminal(node);
		terms++;
	}
	public int getNodes() {
		return nodes;
	}
	public int getTerms() {
		return terms;
	}
	
}
