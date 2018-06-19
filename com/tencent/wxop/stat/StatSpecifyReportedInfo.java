package com.tencent.wxop.stat;

public class StatSpecifyReportedInfo {
    private String a = null;
    private String b = null;
    private String c = null;
    private boolean d = false;
    private boolean e = false;

    public String getAppKey() {
        return this.a;
    }

    public String getInstallChannel() {
        return this.b;
    }

    public String getVersion() {
        return this.c;
    }

    public boolean isImportant() {
        return this.e;
    }

    public boolean isSendImmediately() {
        return this.d;
    }

    public void setAppKey(String str) {
        this.a = str;
    }

    public void setImportant(boolean z) {
        this.e = z;
    }

    public void setInstallChannel(String str) {
        this.b = str;
    }

    public void setSendImmediately(boolean z) {
        this.d = z;
    }

    public void setVersion(String str) {
        this.c = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatSpecifyReportedInfo [appKey=");
        stringBuilder.append(this.a);
        stringBuilder.append(", installChannel=");
        stringBuilder.append(this.b);
        stringBuilder.append(", version=");
        stringBuilder.append(this.c);
        stringBuilder.append(", sendImmediately=");
        stringBuilder.append(this.d);
        stringBuilder.append(", isImportant=");
        stringBuilder.append(this.e);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
