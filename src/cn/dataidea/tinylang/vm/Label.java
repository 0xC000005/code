package cn.dataidea.tinylang.vm;

import java.util.*;

public class Label {
    String name;
    public int address;
    boolean isForwardRef = false;
    boolean isDefined = false;
    Vector<Integer> forwardReferences = null;

    public void addForwardReference(int address) {
	if (forwardReferences == null) {
	    forwardReferences = new Vector<Integer>();
	}
	forwardReferences.addElement(new Integer(address));
    }

    public void resolveForwardReferences(byte[] code) {
	isForwardRef = false;
	Vector<Integer> oprandsToPatch = forwardReferences;
	for (int addrToPatch : oprandsToPatch) {
	    Assembler.writeInt(code, addrToPatch, address);
	}
    }

    public String toString() {
	String refs = "";
	if (forwardReferences != null) {
	    refs = "[refs=" + forwardReferences.toString() + "]";
	}
	return name + "@" + address + refs;
    }

    // @formatter:off
    public Label(String name) { this.name = name; }
}
