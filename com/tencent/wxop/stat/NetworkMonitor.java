package com.tencent.wxop.stat;

public class NetworkMonitor {
    private long a = 0;
    private int b = 0;
    private String c = "";
    private int d = 0;
    private String e = "";

    public String getDomain() {
        return this.c;
    }

    public long getMillisecondsConsume() {
        return this.a;
    }

    public int getPort() {
        return this.d;
    }

    public String getRemoteIp() {
        return this.e;
    }

    public int getStatusCode() {
        return this.b;
    }

    public void setDomain(String str) {
        this.c = str;
    }

    public void setMillisecondsConsume(long j) {
        this.a = j;
    }

    public void setPort(int i) {
        this.d = i;
    }

    public void setRemoteIp(String str) {
        this.e = str;
    }

    public void setStatusCode(int i) {
        this.b = i;
    }

    public org.json.JSONObject toJSONObject() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "tm";	 Catch:{ JSONException -> 0x003c }
        r2 = r6.a;	 Catch:{ JSONException -> 0x003c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x003c }
        r1 = "st";	 Catch:{ JSONException -> 0x003c }
        r2 = r6.b;	 Catch:{ JSONException -> 0x003c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x003c }
        r1 = r6.c;	 Catch:{ JSONException -> 0x003c }
        if (r1 == 0) goto L_0x001e;	 Catch:{ JSONException -> 0x003c }
    L_0x0017:
        r1 = "dm";	 Catch:{ JSONException -> 0x003c }
        r2 = r6.c;	 Catch:{ JSONException -> 0x003c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x003c }
    L_0x001e:
        r1 = "pt";	 Catch:{ JSONException -> 0x003c }
        r2 = r6.d;	 Catch:{ JSONException -> 0x003c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x003c }
        r1 = r6.e;	 Catch:{ JSONException -> 0x003c }
        if (r1 == 0) goto L_0x0030;	 Catch:{ JSONException -> 0x003c }
    L_0x0029:
        r1 = "rip";	 Catch:{ JSONException -> 0x003c }
        r2 = r6.e;	 Catch:{ JSONException -> 0x003c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x003c }
    L_0x0030:
        r1 = "ts";	 Catch:{ JSONException -> 0x003c }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ JSONException -> 0x003c }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ JSONException -> 0x003c }
        r2 = r2 / r4;	 Catch:{ JSONException -> 0x003c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x003c }
    L_0x003c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.NetworkMonitor.toJSONObject():org.json.JSONObject");
    }
}
