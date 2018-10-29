package org.tinylang.scope;

import java.util.Set;

import org.tinylang.Klass;
import org.tinylang.Method;
import org.tinylang.symbol.Symbol;

/*
 ============================================================================
 Name       		: Scope.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: 
 ============================================================================
 */

public interface Scope {

    public String getScopeName();
    public Scope getEnclosingScope();
    public void define(Symbol sym);
    public void initialize(Symbol sym);
    public Symbol lookup(String name);
    public Symbol lookupLocally(String name);
    public boolean hasBeenInitialized(String name);
    public Set<Symbol> getInitializedVariables();
	public static Klass getEnclosingKlass(Scope scope){
		while(!(scope instanceof Klass)){
			scope=scope.getEnclosingScope();
		}
		return (Klass)scope;//The outermost scope will always be a class.
	}
    public static Method getEnclosingMethod(Scope scope){
        while(!(scope instanceof Method)){
            scope = scope.getEnclosingScope();
        }
        return (Method)scope;
    }
}
