package com.xiaomi.smack.packet;

import com.umeng.message.proguard.k;

public class g {
    private String a;

    public g(String str) {
        this.a = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream:error (");
        stringBuilder.append(this.a);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
