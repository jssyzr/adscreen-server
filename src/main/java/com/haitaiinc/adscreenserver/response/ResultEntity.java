package com.haitaiinc.adscreenserver.response;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultEntity {
    private int code;
    private String message;
    private Object data;

    public ResultEntity(BaseRespInfoInterface errorInfoInterface){
        this.code = errorInfoInterface.getResultCode();
        this.message = errorInfoInterface.getResultMsg();
    }

    /**
     * 成功
     *
     * @return
     */
    public static ResultEntity success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ResultEntity success(Object data) {
        ResultEntity rb = new ResultEntity();
        rb.setCode(RespEnum.SUCCESS.getResultCode());
        rb.setMessage(RespEnum.SUCCESS.getResultMsg());
        rb.setData(data);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultEntity error(BaseRespInfoInterface errorInfo) {
        ResultEntity rb = new ResultEntity();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultEntity error(int code, String message) {
        ResultEntity rb = new ResultEntity();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

    /**
     * 失败
     */
    public static ResultEntity error( String message) {
        ResultEntity rb = new ResultEntity();
        rb.setCode(-1);
        rb.setMessage(message);
        rb.setData(null);
        return rb;
    }

    @Override
    public String toString() {
        String str = "";
        if(this.data instanceof String){
            str = "{\"code\":"+this.code+",\"message\":\""+this.message+"\",\"data\":"+this.data+"}";
        }else{
            str = JSONObject.toJSONString(this);
        }
        return str;
    }
}
