package org.tinylang;
/*
 ============================================================================
 Name       		: ClassNamer.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: Hello World in C, Ansi-style
 ============================================================================
 */

import java.util.Map;

import org.tinylang.antlr.TinyLangBaseListener;
import org.tinylang.antlr.TinyLangParser;

public class ClassNamer extends TinyLangBaseListener {
	private Map<String, Klass> klasses;

	private TinyLangParser parser;

	public ClassNamer(Map<String, Klass> klasses, TinyLangParser parser) {
		this.klasses = klasses;
		this.parser = parser;
	}

	@Override
	public void enterClassDeclaration(TinyLangParser.ClassDeclarationContext ctx) {
		Klass currentKlass = new Klass(ctx.Identifier(0).getText());
		if (klasses.put(currentKlass.getScopeName(), currentKlass) != null) {
			ErrorPrinter.printDuplicateClassError(parser, ctx.Identifier(0).getSymbol(), currentKlass.getScopeName());
		}
	}

	@Override
	public void enterMainClass(TinyLangParser.MainClassContext ctx) {
		Klass currentKlass;
		currentKlass = new Klass("int[]");
		klasses.put(currentKlass.getScopeName(), currentKlass);
		currentKlass = new Klass("int");
		klasses.put(currentKlass.getScopeName(), currentKlass);

		currentKlass = new Klass("boolean");
		klasses.put(currentKlass.getScopeName(), currentKlass);

		currentKlass = new Klass(ctx.Identifier(0).getText());
		klasses.put(currentKlass.getScopeName(), currentKlass);
	}
}