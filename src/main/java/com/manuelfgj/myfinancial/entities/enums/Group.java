package com.manuelfgj.myfinancial.entities.enums;

public enum Group {
	
	REVENUE_ENTRY(1),
	REVENUE_ECONOMY(2),
	EXPENSE_PERSONAL(1),
	EXPENSE_HOME(2),
	EXPENSE_EDUCATION(3),
	EXPENSE_HEALTH(4),
	EXPENSE_FOOD(5),
	EXPENSE_TRANSPORT(6),
	EXPENSE_OTHERS(7),
	EXPENSE_DEBIT(10),
	EXPENSE_CREDIT(11);
	
	private int code;

	private Group(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

	public static Group valueOf(int code) {
		for(Group value : Group.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
