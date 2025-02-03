package com.lzy.pnaWeb.common;

public enum ResultCode implements IErrorCode {
    SUCCESS(200, "Success"),
    FAILED(500, "Failed"),
    VALIDATE_FAILED(404, "Params error！"),
    UNAUTHORIZED(401, "Valid token！"),
    FORBIDDEN(403, "No Access！"),
    NOTEXIST(404, "No exist user！"),
    ERROR_USER_OR_PWD(500,"User or Pwd Error！");

    private Integer code;
    private String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
