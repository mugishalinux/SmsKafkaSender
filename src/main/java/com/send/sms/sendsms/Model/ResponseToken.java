package com.send.sms.sendsms.Model;

public class ResponseToken {

    private String expires_at;
    private String access_token;
    private String refresh_token;

    public ResponseToken() {

    }

    public ResponseToken(String expires_at, String access_token, String refresh_token) {
        this.expires_at = expires_at;
        this.access_token = access_token;
        this.refresh_token = refresh_token;
    }

    public String getExpires_at() {
        return expires_at;
    }

    public void setExpires_at(String expires_at) {
        this.expires_at = expires_at;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    @Override
    public String toString() {
        return "ResponseToken{" +
                "expires_at='" + expires_at + '\'' +
                ", access_token='" + access_token + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                '}';
    }
}
