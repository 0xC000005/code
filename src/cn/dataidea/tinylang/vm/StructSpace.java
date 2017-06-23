package cn.dataidea.tinylang.vm;

import java.util.Arrays;

public class StructSpace {
	Object[] fields;

	public StructSpace(int nfields) {
		fields = new Object[nfields];
	}

	public String toString() {
		return Arrays.toString(fields);
	}
}
