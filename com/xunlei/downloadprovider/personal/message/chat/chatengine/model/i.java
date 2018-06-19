package com.xunlei.downloadprovider.personal.message.chat.chatengine.model;

/* compiled from: QueryParams */
public final class i {
    public int a = 1;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 20;
    public int f = 0;

    public final String a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z ? "" : "&");
        stringBuilder.append("begin=");
        stringBuilder.append(this.b);
        stringBuilder.append("&end=");
        stringBuilder.append(this.c);
        stringBuilder.append("&offset=");
        stringBuilder.append(this.d);
        stringBuilder.append("&limit=");
        stringBuilder.append(this.e);
        return stringBuilder.toString();
    }

    public final String a() {
        String str = "";
        if (this.e == -1) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(" LIMIT ");
        stringBuilder.append(this.e);
        stringBuilder.append(" OFFSET ");
        stringBuilder.append(this.d);
        return stringBuilder.toString();
    }

    public final boolean b() {
        new StringBuilder("checkMySelf queryParams: ").append(toString());
        if (this.b > this.c && this.b != 0 && this.c != 0) {
            return false;
        }
        if (this.e != -1 && this.e <= 0) {
            new StringBuilder("limit must bigger than zero! was: ").append(this.e);
            return false;
        } else if (this.d >= 0) {
            return true;
        } else {
            new StringBuilder("offset must bigger than zero! was: ").append(this.d);
            return false;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("QueryParams{begin=");
        stringBuilder.append(this.b);
        stringBuilder.append(", end=");
        stringBuilder.append(this.c);
        stringBuilder.append(", offset=");
        stringBuilder.append(this.d);
        stringBuilder.append(", limit=");
        stringBuilder.append(this.e);
        stringBuilder.append(", total=");
        stringBuilder.append(this.f);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
