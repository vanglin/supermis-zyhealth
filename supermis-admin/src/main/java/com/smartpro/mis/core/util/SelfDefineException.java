package com.smartpro.mis.core.util;

import com.smartpro.mis.core.exception.ServiceExceptionEnum;

public class SelfDefineException {

    private Integer code;

    private String message;

    public SelfDefineException(ServiceExceptionEnum serviceExceptionEnum) {
        this.code = serviceExceptionEnum.getCode();
        this.message = serviceExceptionEnum.getMessage();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
