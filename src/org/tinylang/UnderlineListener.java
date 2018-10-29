package org.tinylang;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

/*
 ============================================================================
 Name       		: UnderlineListener.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: 
 ============================================================================
 */
public class UnderlineListener extends BaseErrorListener {
	@Override public void syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e){
        ErrorPrinter.printFileNameAndLineNumber((Token)offendingSymbol);
        System.err.println("line " + line + ":" + charPositionInLine + " " + msg);
        ErrorPrinter.underlineError(recognizer,(Token)offendingSymbol);
    }
}
