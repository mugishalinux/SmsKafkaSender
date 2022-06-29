package com.send.sms.sendsms.Model;


public class SmsSender {
    private String msisdn ;
    private String message;
    private String msgRef;
    private String sender_id;

    public SmsSender(String msisdn, String message, String msgRef, String sender_id) {
        this.msisdn = msisdn;
        this.message = message;
        this.msgRef = msgRef;
        this.sender_id = sender_id;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsgRef() {
        return msgRef;
    }

    public void setMsgRef(String msgRef) {
        this.msgRef = msgRef;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }
}
