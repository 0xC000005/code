package cn.codeidea.tinylang.test;

import java.io.File;
import java.io.FileInputStream;

import org.junit.Test;

import cn.codeidea.tinylang.lex.Lexer;
import cn.codeidea.tinylang.lex.Token;
import cn.codeidea.tinylang.lex.TokenType;
import cn.codeidea.tinylang.util.TinyLangUtil;

public class TestLexer {

	@Test
	public void testLexer() {
		File file = new File("template/hello.tl");
		byte[] buffer = new byte[(int) file.length()];
		try(FileInputStream fis = new FileInputStream(file)){
			fis.read(buffer);
			Lexer lexer = new Lexer(TinyLangUtil.getChars(buffer));
			lexer.getch();
			Token token = null;
			do{
				token = lexer.getToken();
				System.out.println(token);
			}while(token.type != TokenType.EOF);
			System.out.println("代码行数为 ： "+lexer.getLine());
		}catch(Exception e){

		}
	}

}
