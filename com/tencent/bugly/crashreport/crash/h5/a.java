package com.tencent.bugly.crashreport.crash.h5;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
public class a {
    public String a = null;
    public String b = null;
    public String c = null;
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = null;
    public String h = null;
    public String i = null;
    public long j = 0;
    public long k = 0;

    public Map<String, String> a() {
        Map<String, String> linkedHashMap = new LinkedHashMap();
        if (this.a != null) {
            linkedHashMap.put("[JS] projectRoot", this.a);
        }
        if (this.b != null) {
            linkedHashMap.put("[JS] context", this.b);
        }
        if (this.c != null) {
            linkedHashMap.put("[JS] url", this.c);
        }
        if (this.d != null) {
            linkedHashMap.put("[JS] userAgent", this.d);
        }
        if (this.i != null) {
            linkedHashMap.put("[JS] file", this.i);
        }
        if (this.j != 0) {
            linkedHashMap.put("[JS] lineNumber", Long.toString(this.j));
        }
        return linkedHashMap;
    }
}
