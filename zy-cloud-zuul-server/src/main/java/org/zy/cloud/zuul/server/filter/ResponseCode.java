package org.zy.cloud.zuul.server.filter;

public enum ResponseCode {

	SUCCESS(200, "SUCCESS"), FAILURE(500, "SUCCESS");

	private long code;
	private String msg;

	public long getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	private ResponseCode(long code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}