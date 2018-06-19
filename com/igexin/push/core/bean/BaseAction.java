package com.igexin.push.core.bean;

public class BaseAction {
    private String a;
    private String b;
    private String c;
    private boolean d = true;

    public String getActionId() {
        return this.a;
    }

    public String getDoActionId() {
        return this.c;
    }

    public String getType() {
        return this.b;
    }

    public boolean isSupportExt() {
        return this.d;
    }

    public void setActionId(String str) {
        this.a = str;
    }

    public void setDoActionId(String str) {
        this.c = str;
    }

    public void setSupportExt(boolean z) {
        this.d = z;
    }

    public void setType(String str) {
        this.b = str;
    }
}
