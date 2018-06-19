package com.igexin.assist;

import android.content.Context;

public class MessageBean {
    private Context context;
    private Object message;
    private String messageSource;
    private String messageType;

    public MessageBean(Context context, String str, Object obj) {
        this.messageType = str;
        this.message = obj;
        this.context = context;
    }

    public Context getContext() {
        return this.context;
    }

    public Object getMessage() {
        return this.message;
    }

    public String getMessageSource() {
        return this.messageSource;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public Object getObjectMessage() {
        return this.message;
    }

    public String getStringMessage() {
        return this.message instanceof String ? (String) this.message : null;
    }

    public void setMessageSource(String str) {
        this.messageSource = str;
    }
}
