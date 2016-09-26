package cn.codeidea.tinylang.test;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import cn.codeidea.tinylang.lex.Lexer;
import cn.codeidea.tinylang.syntax.Syntax;
import cn.codeidea.tinylang.util.TinyLangUtil;

public class TestSyntax {

	@Test
	public void test() {
		File file = new File("template/hello.tl");
		byte[] buffer = new byte[(int) file.length()];
		try(FileInputStream fis = new FileInputStream(file)){
			fis.read(buffer);
			Lexer lexer = new Lexer(TinyLangUtil.getChars(buffer));
			Syntax syntax = new Syntax(lexer);
			syntax.translationUnit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
