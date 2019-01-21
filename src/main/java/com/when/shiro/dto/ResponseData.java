package com.when.shiro.dto;

/**
 * @author: when
 * @create: 2019-01-21  17:12
 **/
public class ResponseData {
	private int code;
	private String msg;
	private Object data;

	public ResponseData() {
	}

	public ResponseData(int code, String msg) {
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
