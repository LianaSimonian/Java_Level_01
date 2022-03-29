package com.aca.homework.week10.object.factory;

public class ServletRequestImpl implements ServletRequest {
    private String body;
    private int contentLength;

    public ServletRequestImpl() {
    }

    @Override
    public int getContentLength() {
        return contentLength;
    }

    @Override
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }
}
