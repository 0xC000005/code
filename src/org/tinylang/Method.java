package org.tinylang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.tinylang.antlr.TinyLangParser;
import org.tinylang.scope.Scope;
import org.tinylang.symbol.Symbol;

/*
 ============================================================================
 Name       		: Method.java
 Author      		: 0xC000005
 Date               : 2018年10月26日
 Version     	 	: 1.0
 Copyright   	: The MIT License (MIT)
 Description 	: 
 ============================================================================
 */

public class Method extends Symbol implements Scope{
	private LinkedHashMap<String, Symbol> parameters = new LinkedHashMap<String, Symbol>();
	private Scope owner;
	//private Scope body;
	private Map<String, Symbol> locals = new HashMap<String, Symbol>();
	private Map<String, Symbol> initializedVariables = new HashMap<String, Symbol>();

	public Method(Klass returnType, String name, Scope owner){
		super(name, returnType, true);
		this.owner=owner;
	}
	
	@Override public String getScopeName(){
		return this.name;
	}
	
	@Override public Scope getEnclosingScope(){
		return owner;
	}
	
	@Override public void define(Symbol sym){
		locals.put(sym.getName(), sym);
	}

    @Override public void initialize(Symbol sym){
        initializedVariables.put(sym.getName(), sym);
    }

	@Override public Symbol lookup(String name){
		if(parameters.containsKey(name)){
			return parameters.get(name);
		}else if(locals.containsKey(name)){
			return locals.get(name);
		}else{
			return this.getEnclosingScope().lookup(name);
		}
	}

	@Override public Symbol lookupLocally(String name){
		if(parameters.containsKey(name)){
			return parameters.get(name);
		}else{
			return locals.get(name);
		}
	}

    @Override public boolean hasBeenInitialized(String name){
        if(initializedVariables.containsKey(name) || parameters.containsKey(name)){
            return true;
    	}else{
            return this.getEnclosingScope().hasBeenInitialized(name);
        }
    }

    @Override public Set<Symbol> getInitializedVariables(){
        return new HashSet<Symbol>(this.initializedVariables.values());
    }

	public void addParameter(Symbol parameter){
		parameters.put(parameter.getName(), parameter);
	}
	
	public List<Symbol> getParameterList(){
		return new ArrayList<Symbol>(parameters.values());
	}
	
	public List<Klass> getParameterListDefinition(){
		List<Symbol> parameterList = getParameterList();
		List<Klass> parameterListDefinition = new ArrayList<Klass>();
		for(Symbol var: parameterList){
			parameterListDefinition.add(var.getType());
		}
		return parameterListDefinition;
	}

	public String toString(){
		return name;
	}
	
	public String fullName(){
		String fullName = this.getType().toString() + " ";
		fullName += name;
		fullName = fullName.substring(0, fullName.length()-1);
		boolean hasParameter = false;
		for(Symbol parameter : parameters.values()){
			fullName += parameter.getType().getScopeName() + ", ";
			hasParameter=true;
		}
		if(hasParameter){
			fullName = fullName.substring(0, fullName.length()-2);
		}
		fullName += ")";
		return fullName;
	}
	public org.objectweb.asm.commons.Method asAsmMethod(){
		return org.objectweb.asm.commons.Method.getMethod(this.fullName(), true);
	
	}
	public static String getMethodSignature(TinyLangParser.MethodDeclarationContext ctx){
		return ctx.Identifier().getText() + "()";
	}
}