package cn.dataidea.tinylang;

import java.io.*;
import java.nio.file.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import cn.dataidea.tinylang.gen.*;
import cn.dataidea.tinylang.vm.*;

/**
 * <p>
 * tinylang 主程序
 * </p>
 * 
 * @author xiehui
 * @createTime 上午11:22:22
 * @version 1.0
 */

public final class Main {
	public static void main(String[] args) throws Exception {
		Interpreter vm;
		CharStream input = null;
		String sourceFile, objectFile;

		sourceFile = "code/class7.tl";
		if (sourceFile.matches("(.*)\\.tl$")) {
			input = CharStreams.fromFileName(sourceFile); // ANTLR 4.7
			vm = compile(input);
			Path p = Paths.get(sourceFile);
			objectFile = p.getFileName().toString().replace(".tl", ".bin");
			save(vm, objectFile);
			System.out.println("8. Run bytecode:");
			vm.exec();
		} else if (sourceFile.matches("(.*)\\.bin$")) {
			vm = load(sourceFile);
			vm.setTrace(false);
			run(vm);
		} else
			System.err.println("Unknown file format");

	}

	protected static Interpreter compile(CharStream input) {
		TinyLexer lexer = new TinyLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		TinyParser parser = new TinyParser(tokens);
		parser.setErrorHandler(new ErrorStrategy());

		ParseTree tree = parser.prog();
		ParseTreeWalker walker = new ParseTreeWalker();

		System.out.println("1. LISP-style parsing tree:");
		System.out.println(tree.toStringTree(parser));

		System.out.println("2. Count nodes and terminals:");
		CountPhase count = new CountPhase();
		walker.walk(count, tree);
		System.out.println("number of nodes: " + count.nodes);
		System.out.println("number of terminals: " + count.terms);

		System.out.println("3. Symbol Analysis:");
		DefPhase def = new DefPhase();
		walker.walk(def, tree);
		if (def.on_error) {
			throw new RuntimeException("DefPhase failed.");
		}
		RefPhase ref = new RefPhase(def);
		walker.walk(ref, tree);
		if (ref.on_error) {
			throw new RuntimeException("RefPhase failed.");
		}
		System.out.println(" done.");

		System.out.println("4. Type Analysis:");
		TypePhase typ = new TypePhase(def);
		walker.walk(typ, tree);
		if (typ.on_error) {
			throw new RuntimeException("TypPhase failed.");
		}

		System.out.println("5. Emit Bytecode:");
		EmitPhase emit = new EmitPhase(typ);
		emit.visit(tree);
		if (emit.on_error) {
			throw new RuntimeException("EmitPhase failed.");
		}
		Assembler assem = emit.assem;
		System.out.println(assem.getInstrs() + " instructs generated totally.");

		System.out.println("6. Disassemble Bytecode:");
		Disassembler disasm = new Disassembler(assem);
		disasm.disassemble();
		Interpreter vm = new Interpreter(assem);
		return vm;
	}

	protected static Interpreter load(String fileName) {
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(new FileInputStream(new File(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Interpreter vm = null;
		try {
			vm = (Interpreter) input.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return vm;
	}

	protected static void save(Interpreter vm, String fileName) {
		System.out.print("7. Write bytecode into: ");
		String objectFile = fileName;
		ObjectOutput output = null;
		try {
			output = new ObjectOutputStream(new FileOutputStream(objectFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			output.writeObject(vm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(objectFile);
	}

	protected static void run(Interpreter vm) {
		vm.setTrace(true);
		vm.disassemble();
		vm.exec();
	}
}
