package com.duiba.maila.sdk.a;

import com.duiba.maila.sdk.util.h;
import com.umeng.message.MsgConstant;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public final class c extends d {
    private StringBuffer a;
    private String b;
    private String c;
    private String d;

    public final String b() {
        return null;
    }

    public c() {
        StringBuilder stringBuilder = new StringBuilder("https://s.maila88.com/du-");
        stringBuilder.append(h.a());
        stringBuilder.append(".jpg");
        this.a = new StringBuffer(stringBuilder.toString());
    }

    public c(String str) {
        StringBuilder stringBuilder = new StringBuilder("https://s.maila88.com/du-");
        stringBuilder.append(h.a());
        stringBuilder.append(".jpg");
        this.a = new StringBuffer(stringBuilder.toString());
        this.b = str;
        str = new StringBuilder();
        str.append(System.currentTimeMillis());
        this.c = str.toString();
    }

    public final String a() {
        Map treeMap = new TreeMap();
        treeMap.put("key", h.b);
        treeMap.put("data", this.b.toString());
        treeMap.put(MsgConstant.KEY_TS, this.c);
        this.d = h.a(h.a(treeMap));
        try {
            this.b = URLEncoder.encode(h.a(this.b, "265VAvubZtBsCCwU"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        StringBuffer stringBuffer = this.a;
        StringBuilder stringBuilder = new StringBuilder("?data=");
        stringBuilder.append(this.b);
        stringBuilder.append("&");
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("ts=");
        stringBuilder.append(this.c);
        stringBuilder.append("&");
        stringBuffer.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("&token=");
        stringBuilder.append(this.d);
        stringBuffer.append(stringBuilder.toString());
        return this.a.toString();
    }
}
