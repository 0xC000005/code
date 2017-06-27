package cn.dataidea.tinylang;

import org.antlr.v4.runtime.*;

public class ErrorStrategy extends DefaultErrorStrategy {
	public void recover(Parser recognizer, RecognitionException e) {
		throw new RuntimeException(e);
	}

	public Token recoverInline(Parser recognizer) throws RecognitionException {
		throw new RuntimeException(new InputMismatchException(recognizer));
	}

	public void sync(Parser recognizer) {
	}
}
