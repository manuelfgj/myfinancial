package com.manuelfgj.myfinancial.entities.enums;

public enum Type {
	
	MONEY(1),
	DEBIT(2),
	CREDIT(3);
	
	private int code;

	private Type(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static Type valueOf(int code) {
		for(Type value : Type.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
