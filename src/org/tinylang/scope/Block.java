package org.tinylang.scope;
/*
 ============================================================================
 Name       		: Block.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: 
 ============================================================================
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.tinylang.symbol.Symbol;

public class Block implements Scope{
	private Map<String, Symbol> locals = new HashMap<String, Symbol>();
	private Map<String, Symbol> initializedVariables = new HashMap<String, Symbol>();
	private Scope enclosingScope;
	private String scopeName = "local";

	public Block(Scope enclosingScope){
		this.enclosingScope = enclosingScope;
	}

    @Override public String getScopeName(){
    	return scopeName;
    }

    @Override public Scope getEnclosingScope(){
    	return enclosingScope;
    }

    @Override public void define(Symbol sym){
    	locals.put(sym.getName(), sym);
    }

    @Override public void initialize(Symbol sym){
        initializedVariables.put(sym.getName(), sym);
    }

    @Override public Symbol lookup(String name){
    	if(locals.containsKey(name)){
    		return locals.get(name);
    	}else{
    		return this.getEnclosingScope().lookup(name);
    	}
    }

	@Override public Symbol lookupLocally(String name){
		return locals.get(name);
	}
    
    @Override public boolean hasBeenInitialized(String name){
        if(initializedVariables.containsKey(name)){
            return true;
        }else{
            return this.getEnclosingScope().hasBeenInitialized(name);
        }
    }

    @Override public Set<Symbol> getInitializedVariables(){
        return new HashSet<Symbol>(this.initializedVariables.values());
    }
}
