package cn.dataidea.tinylang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import cn.dataidea.tinylang.gen.TinyLexer;
import cn.dataidea.tinylang.gen.TinyParser;

/**
*<p>tinylang 主程序</p>
*@author xiehui
*@createTime 上午11:22:22
*@version 1.0
*/
public class Main {

	public static void main(String[] args) throws Exception {
		CharStream input = CharStreams.fromFileName("code/hello.tl");
		TinyLexer lexer = new TinyLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TinyParser parser = new TinyParser(tokens);
		parser.setErrorHandler(new ErrorStrategy());
		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();
		System.out.println("1. LISP-style parsing tree:");
		System.out.println(tree.toStringTree(parser));
	}

}
