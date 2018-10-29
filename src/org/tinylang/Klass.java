package org.tinylang;
/*
 ============================================================================
 Name       		: Klass.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: Hello World in C, Ansi-style
 ============================================================================
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.objectweb.asm.Type;
import org.tinylang.scope.Scope;
import org.tinylang.symbol.Symbol;

public class Klass implements Scope{
	private Klass superKlass;
	private String name;
	private Map<String, Symbol> symTable = new HashMap<String, Symbol>();
    public Klass(String name){
       this.name = name; 
    }
    public void setSuperKlass(Klass superKlass){
        this.superKlass = superKlass;
    }
    public Klass getSuperKlass(){
    	return this.superKlass;
    }
    @Override public String getScopeName(){
    	return name;
    }
    @Override public Scope getEnclosingScope(){return null;}
    @Override public void define(Symbol sym){
    	symTable.put(sym.getName(), sym);
    }
    @Override public void initialize(Symbol sym){
        assert false;
    }

    public boolean isDescendantOf(Klass other){
        if(this.superKlass==null&&other!=this){
            return false;
        }else if(other==this){
            return true;
        }else{
            return this.superKlass.isDescendantOf(other);
        }
    }
    @Override public Symbol lookup(String name){
    	Symbol symbol = null;
    	for(Klass klass = this; symbol==null&&klass!=null; klass=klass.getSuperKlass()){
    		symbol = klass.symTable.get(name);
    	}
    	return symbol;
    }
    @Override public Symbol lookupLocally(String name){
    	return symTable.get(name);
    }
        @Override public boolean hasBeenInitialized(String name){
        return this.lookup(name)!=null;
    }
    
    @Override public Set<Symbol> getInitializedVariables(){
        assert false;
        return null;
    }

    /**
     * @return The name of this klass
     */
    public String toString(){
    	return name;
    }

    /**
     * @return an asm Type representation of this class.
     */
    public Type asAsmType(){
        if(this.name.equals("int")){
            return Type.INT_TYPE;
        }else if(this.name.equals("boolean")){
            return Type.BOOLEAN_TYPE;
        }else if(this.name.equals("int[]")){
            return Type.getType(int[].class);
        }else{
            return Type.getType("L" + this.name + ";");
        }
    }
}
