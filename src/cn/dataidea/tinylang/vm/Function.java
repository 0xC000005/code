package cn.dataidea.tinylang.vm;

import java.io.*;

public class Function implements Serializable {
	private static final long serialVersionUID = 1L;
	String name;
	int nargs;
	int nlocals;
	int address;

	public Function(String name, int nargs, int nlocals, int address) {
		this.name = name;
		this.nargs = nargs;
		this.nlocals = nlocals;
		this.address = address;
	}

	public Function(String name) {
		this.name = name;
	}

	public int hashCode() {
		return name.hashCode();
	}

	public boolean equals(Object o) {
		return (o instanceof Function) && name.equals(((Function) o).name);
	}

	public String toString() {
		return "Function{name='" + name + "', args=" + nargs + ", locals=" + nlocals + ", address=" + address + "}";
	}
}
