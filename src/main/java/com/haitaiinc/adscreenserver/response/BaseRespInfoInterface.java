package com.haitaiinc.adscreenserver.response;

public interface BaseRespInfoInterface {

    /**
     * 获取错误码
     * @return
     */
    int getResultCode();

    /**
     * 获取错误详细信息
     * @return
     */
    String getResultMsg();
}
