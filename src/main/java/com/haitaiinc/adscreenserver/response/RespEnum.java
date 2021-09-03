package com.haitaiinc.adscreenserver.response;

public enum RespEnum implements BaseRespInfoInterface {
    SUCCESS(20000,"成功"),
    NO_AUTH(20001,"无访问权限"),
    USER_NONE(20002,"用户不存在"),
    USER_PWD_ERROR(20003,"用户名密码错误"),
    BODY_NOT_MATCH(20004,"请求数据格式不符"),
    NOT_FOUND(404, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误!"),
    SERVER_BUSY(503,"服务器正忙，请稍后再试!")
    ;

    private int resultCode;
    private String resultMsg;

    RespEnum(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    @Override
    public int getResultCode() {
        return resultCode;
    }

    @Override
    public String getResultMsg() {
        return resultMsg;
    }
}
