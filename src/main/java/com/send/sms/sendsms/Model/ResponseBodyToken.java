package com.send.sms.sendsms.Model;

public class ResponseBodyToken {
    private int status;
    private Data data;

    public ResponseBodyToken(int status, Data data) {
        this.status = status;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public ResponseBodyToken() {
    }

    @Override
    public String toString() {
        return "ResponseBodyToken{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
