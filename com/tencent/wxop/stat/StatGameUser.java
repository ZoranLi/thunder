package com.tencent.wxop.stat;

public class StatGameUser implements Cloneable {
    private String a = "";
    private String b = "";
    private String c = "";

    public StatGameUser(String str, String str2, String str3) {
        this.b = str;
        this.a = str2;
        this.c = str3;
    }

    public com.tencent.wxop.stat.StatGameUser clone() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x0007 }
        r0 = (com.tencent.wxop.stat.StatGameUser) r0;	 Catch:{ CloneNotSupportedException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.StatGameUser.clone():com.tencent.wxop.stat.StatGameUser");
    }

    public String getAccount() {
        return this.b;
    }

    public String getLevel() {
        return this.c;
    }

    public String getWorldName() {
        return this.a;
    }

    public void setAccount(String str) {
        this.b = str;
    }

    public void setLevel(String str) {
        this.c = str;
    }

    public void setWorldName(String str) {
        this.a = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("StatGameUser [worldName=");
        stringBuilder.append(this.a);
        stringBuilder.append(", account=");
        stringBuilder.append(this.b);
        stringBuilder.append(", level=");
        stringBuilder.append(this.c);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
