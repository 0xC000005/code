package org.tinylang.cli;
/*
 ============================================================================
 Name       		: TinyLangCmd.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: 主程序
 ============================================================================
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.atn.PredictionMode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.tinylang.AssignmentListener;
import org.tinylang.ClassNamer;
import org.tinylang.ErrorPrinter;
import org.tinylang.InitializationBeforeUseChecker;
import org.tinylang.Klass;
import org.tinylang.TypeChecker;
import org.tinylang.UnderlineListener;
import org.tinylang.antlr.TinyLangLexer;
import org.tinylang.antlr.TinyLangParser;
import org.tinylang.gen.CodeGenerator;
import org.tinylang.scope.Scope;

public class TinyLangCmd {

	private static String inputFile = null;

	public static void main(String[] args) throws IOException, FileNotFoundException {
		if (args.length > 0) {
			inputFile = args[0];
		} else {
			inputFile = "code/CorrectPrograms/WithoutArrays/linkedlist.tl";
		}
		TinyLangLexer lexer = new TinyLangLexer(CharStreams.fromFileName(inputFile, Charset.forName("UTF-8")));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TinyLangParser parser = new TinyLangParser(tokens);
		Map<String, Klass> klasses = new HashMap<String, Klass>();
		ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
		ParseTreeProperty<Klass> callerTypes = new ParseTreeProperty<Klass>();
		parser.removeErrorListeners();
		parser.addErrorListener(new DiagnosticErrorListener());
		parser.getInterpreter().setPredictionMode(PredictionMode.LL_EXACT_AMBIG_DETECTION);
		parser.addErrorListener(new UnderlineListener());
		ParseTree tree = parser.goal();
		ErrorPrinter.exitOnErrors();
		ClassNamer namer = new ClassNamer(klasses, parser);
		ParseTreeWalker.DEFAULT.walk(namer, tree);
		ErrorPrinter.exitOnErrors();
		AssignmentListener assigner = new AssignmentListener(klasses, scopes, parser);
		ParseTreeWalker.DEFAULT.walk(assigner, tree);
		ErrorPrinter.exitOnErrors();
		TypeChecker typeChecker = new TypeChecker(klasses, scopes, callerTypes, parser);
		typeChecker.visit(tree);
		ErrorPrinter.exitOnErrors();
		InitializationBeforeUseChecker iBeforeUChecker = new InitializationBeforeUseChecker(klasses, scopes, parser);
		iBeforeUChecker.visit(tree);
		ErrorPrinter.exitOnErrors();
		CodeGenerator codeGenerator = new CodeGenerator(klasses, scopes, callerTypes, parser);
		System.out.println(tree.toStringTree(parser));
		ParseTreeWalker.DEFAULT.walk(codeGenerator, tree);
		
		
		//显示语法结构
		JFrame frame = new JFrame("ANTLR AST");
		JPanel panel = new JPanel();
		TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
		viewer.setScale(1.0);
		panel.add(viewer);
		JScrollPane scrollPanel = new JScrollPane(panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.getContentPane().add(scrollPanel);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800, 400);
		frame.setVisible(true);
	}

	public static String getFileName() {
		return inputFile;
	}
}
