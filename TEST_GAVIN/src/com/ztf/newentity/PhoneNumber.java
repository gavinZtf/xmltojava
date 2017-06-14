package com.ztf.newentity;

public class PhoneNumber {
	private int code;
	private String number;

	public PhoneNumber() {
		super();
	}

	public PhoneNumber(int code, String number) {
		super();
		this.code = code;
		this.number = number;
	}

	// ... constructors and methods
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
}
