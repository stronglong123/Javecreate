package com.common.generate.javacreate.model;

/**
 * @author xialei
 * @date 2020/11/6 16:26
 */
public class WebsocketMsgDTO {

    /**
     * 业务类型
     */
    private String type;

    /**
     * 消息id
     */
    private Long msgId;

    /**
     * 消息内容
     */
    private String msgTxt;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getMsgTxt() {
        return msgTxt;
    }

    public void setMsgTxt(String msgTxt) {
        this.msgTxt = msgTxt;
    }
}
