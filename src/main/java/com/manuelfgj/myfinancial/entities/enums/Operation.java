package com.manuelfgj.myfinancial.entities.enums;

public enum Operation {
	
	REVENUE(1),
	EXPENSE(2);
	
	private int code;

	private Operation(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static Operation valueOf(int code) {
		for(Operation value : Operation.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
