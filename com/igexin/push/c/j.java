package com.igexin.push.c;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.igexin.b.a.c.a;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    private static final String a = "com.igexin.push.c.j";
    private String b;
    private String c;
    private int d;
    private long e = 2147483647L;
    private long f = -1;
    private boolean g = true;
    private int h;
    private int i;
    private int j = 3;

    public j(String str, int i) {
        this.b = str;
        this.d = i;
    }

    private void j() {
        this.c = null;
        this.h = 0;
        this.g = true;
    }

    private boolean k() {
        return this.c != null && System.currentTimeMillis() - this.f <= f.b && this.h < this.j;
    }

    public synchronized String a() {
        return this.b;
    }

    public void a(int i) {
        this.d = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public synchronized void a(String str) {
        this.b = str;
    }

    public synchronized void a(String str, long j, long j2) {
        this.c = str;
        this.e = j;
        this.f = j2;
        this.h = 0;
        this.i = 0;
        this.g = false;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public synchronized String b(boolean z) {
        StringBuilder stringBuilder;
        String stringBuilder2;
        if (k()) {
            if (z) {
                this.h++;
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|disc network, ipFailedCnt++  = ");
                stringBuilder.append(this.h);
                stringBuilder2 = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|disc user, ipFailedCnt =  ");
                stringBuilder.append(this.h);
                stringBuilder2 = stringBuilder.toString();
            }
            a.b(stringBuilder2);
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|disc, ip is valid, use ip = ");
            stringBuilder.append(this.c);
            a.b(stringBuilder.toString());
            this.g = false;
            return this.c;
        }
        j();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(a);
        stringBuilder3.append("|disc, ip is invalid, use domain = ");
        stringBuilder3.append(this.b);
        a.b(stringBuilder3.toString());
        if (z) {
            this.i++;
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|disc network, domainFailedCnt++ = ");
            stringBuilder.append(this.i);
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|disc user, domainFailedCnt =  ");
            stringBuilder.append(this.i);
            stringBuilder2 = stringBuilder.toString();
        }
        a.b(stringBuilder2);
        return this.b;
    }

    public synchronized void b() {
        this.c = null;
        this.e = 2147483647L;
        this.f = -1;
        this.g = true;
        this.h = 0;
    }

    public synchronized void b(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.j = i;
    }

    public void b(long j) {
        this.f = j;
    }

    public void b(String str) {
        this.c = str;
    }

    public String c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public synchronized long e() {
        return this.e;
    }

    public synchronized boolean f() {
        if (k()) {
            return true;
        }
        if (this.i < this.j) {
            return true;
        }
        this.i = 0;
        return false;
    }

    public synchronized String g() {
        if (k()) {
            this.g = false;
            return this.c;
        }
        j();
        return this.b;
    }

    public synchronized void h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|register or login success, reset ipFailedCnt + domainFailedCnt");
        a.b(stringBuilder.toString());
        this.h = 0;
        this.i = 0;
    }

    public JSONObject i() {
        if (this.b == null || this.c == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DispatchConstants.DOMAIN, this.b);
            jSONObject.put("ip", this.c);
            if (this.e != 2147483647L) {
                jSONObject.put("consumeTime", this.e);
            }
            jSONObject.put("port", this.d);
            if (this.f != -1) {
                jSONObject.put("detectSuccessTime", this.f);
            }
            jSONObject.put("isDomain", this.g);
            jSONObject.put("connectTryCnt", this.j);
            return jSONObject;
        } catch (JSONException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(e.toString());
            a.b(stringBuilder.toString());
            return null;
        }
    }
}
