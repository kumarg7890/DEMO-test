package com.example.dto;

public class ReturnDetail {

	private int code;
	private String message;
	private String detail;
	
	public int getCode() {
		return code;
	}
	public ReturnDetail setCode(int code) {
		this.code = code;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public ReturnDetail setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getDetail() {
		return detail;
	}
	public ReturnDetail setDetail(String detail) {
		this.detail = detail;
		return this;
	}
}
