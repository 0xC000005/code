package org.tinylang.symbol;
/*
 ============================================================================
 Name       		: Symbol.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: 符号
 ============================================================================
 */

import org.tinylang.Klass;

public class Symbol {
	protected String name;
	private Klass type;
	private boolean isField;
	private int localIdentifier = -1;
	private int parameterListIdentifier = -1;

	public boolean isParameter() {
		return parameterListIdentifier != -1;
	}

	public void setParameterIdentifier(int parameterListIdentifier) {
		this.parameterListIdentifier = parameterListIdentifier;
	}

	public int getParameterListIdentifier() {
		return parameterListIdentifier;
	}

	public boolean isField() {
		return isField;
	}

	public boolean hasLocalIdentifier() {
		return localIdentifier != -1;
	}

	public int getLocalIdentifier() {
		assert localIdentifier >= 0;
		assert !isField;
		return localIdentifier;
	}

	public void setLocalIdentifier(int localIdentifier) {
		assert !isField;
		this.localIdentifier = localIdentifier;
	}

	public Symbol(String name, boolean isField) {
		this.name = name;
		this.isField = isField;
	}

	public Symbol(String name, Klass type, boolean isField) {
		this(name, isField);
		this.type = type;
	}

	public Klass getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		if (type != null)
			return '<' + getName() + ":" + type + '>';
		return getName();
	}
}
