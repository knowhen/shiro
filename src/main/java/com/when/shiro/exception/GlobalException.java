package com.when.shiro.exception;

/**
 * @author: when
 * @create: 2018-11-07  10:07
 **/
public class GlobalException extends RuntimeException {
	private int code = 500;
	private String msg;

	public GlobalException(String msg) {
		super(msg);
		this.msg = msg;
	}

	public GlobalException(String msg, Throwable e) {
		super(msg, e);
		this.msg = msg;
	}

	public GlobalException(int code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}

	public GlobalException(int code, String msg, Throwable e) {
		super(msg, e);
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
