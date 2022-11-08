package kr.re.etri.advcloud.controller;

import kr.re.etri.advcloud.common.base.BaseObject;

@SuppressWarnings("serial")
public class ApiResponseMessage extends BaseObject {
    
	private boolean success;
    private Object data;
    private String errorMessage;

    public ApiResponseMessage(boolean success) {
        this.success = success;
    }
    
    public ApiResponseMessage(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
    
    public ApiResponseMessage(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
