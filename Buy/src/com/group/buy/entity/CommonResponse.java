package com.group.buy.entity;


public class CommonResponse{
	private boolean success;
	private int code;
	private String msg;
	private String solution;
	private String subErrorCode;
	private String subErrorMsg;
	private Result result;

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
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

	public String getSubErrorCode() {
		return subErrorCode;
	}

	public void setSubErrorCode(String subErrorCode) {
		this.subErrorCode = subErrorCode;
	}

	public String getSubErrorMsg() {
		return subErrorMsg;
	}

	public void setSubErrorMsg(String subErrorMsg) {
		this.subErrorMsg = subErrorMsg;
	}
	
	public String toErrorMsg() {
		StringBuilder builder = new StringBuilder("");
		if (!success) {
			final String responseTag = this.getClass().getSimpleName();
			builder.append(responseTag + " Error[");
			builder.append("msg:" + msg + ",");
			builder.append("subErrorCode:" + subErrorCode + ",");
			builder.append("subErrorMsg:" + subErrorMsg + ",");
			builder.append("solution:" + solution );
			builder.append("]");
		}
		return builder.toString();
	}
	
	public String toSuccessMsg() {
		return "";
	}
}
