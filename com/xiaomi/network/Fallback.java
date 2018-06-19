package com.xiaomi.network;

import android.text.TextUtils;
import com.alipay.sdk.app.statistic.c;
import com.umeng.message.MsgConstant;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class Fallback {
    public String a = "";
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    protected String h;
    private long i;
    private ArrayList<c> j = new ArrayList();
    private String k;
    private double l = 0.1d;
    private String m = "s.mi1.cc";
    private long n = 86400000;

    public Fallback(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.i = System.currentTimeMillis();
        this.j.add(new c(str, -1));
        this.a = HostManager.getActiveNetworkLabel();
        this.b = str;
    }

    private synchronized void d(String str) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(((c) it.next()).a, str)) {
                it.remove();
            }
        }
    }

    public synchronized Fallback a(JSONObject jSONObject) {
        this.a = jSONObject.optString(c.a);
        this.n = jSONObject.getLong("ttl");
        this.l = jSONObject.getDouble("pct");
        this.i = jSONObject.getLong(MsgConstant.KEY_TS);
        this.d = jSONObject.optString("city");
        this.c = jSONObject.optString("prv");
        this.g = jSONObject.optString("cty");
        this.e = jSONObject.optString("isp");
        this.f = jSONObject.optString("ip");
        this.b = jSONObject.optString("host");
        this.h = jSONObject.optString("xf");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            a(new c().a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    public ArrayList<String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the url is empty.");
        }
        URL url = new URL(str);
        if (TextUtils.equals(url.getHost(), this.b)) {
            ArrayList<String> arrayList = new ArrayList();
            Iterator it = a(true).iterator();
            while (it.hasNext()) {
                Host a = Host.a((String) it.next(), url.getPort());
                arrayList.add(new URL(url.getProtocol(), a.b(), a.a(), url.getFile()).toString());
            }
            return arrayList;
        }
        throw new IllegalArgumentException("the url is not supported by the fallback");
    }

    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        c[] cVarArr = new c[this.j.size()];
        this.j.toArray(cVarArr);
        Arrays.sort(cVarArr);
        arrayList = new ArrayList();
        for (c cVar : cVarArr) {
            Object obj;
            if (z) {
                obj = cVar.a;
            } else {
                int indexOf = cVar.a.indexOf(Constants.COLON_SEPARATOR);
                obj = indexOf != -1 ? cVar.a.substring(0, indexOf) : cVar.a;
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public void a(double d) {
        this.l = d;
    }

    public void a(long j) {
        if (j <= 0) {
            StringBuilder stringBuilder = new StringBuilder("the duration is invalid ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.n = j;
    }

    synchronized void a(c cVar) {
        d(cVar.a);
        this.j.add(cVar);
    }

    public void a(String str, int i, long j, long j2, Exception exception) {
        a(str, new AccessHistory(i, j, j2, exception));
    }

    public void a(java.lang.String r8, long r9, long r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x000f }
        r0.<init>(r8);	 Catch:{ MalformedURLException -> 0x000f }
        r2 = r0.getHost();	 Catch:{ MalformedURLException -> 0x000f }
        r1 = r7;	 Catch:{ MalformedURLException -> 0x000f }
        r3 = r9;	 Catch:{ MalformedURLException -> 0x000f }
        r5 = r11;	 Catch:{ MalformedURLException -> 0x000f }
        r1.b(r2, r3, r5);	 Catch:{ MalformedURLException -> 0x000f }
    L_0x000f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.Fallback.a(java.lang.String, long, long):void");
    }

    public void a(java.lang.String r9, long r10, long r12, java.lang.Exception r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0010 }
        r0.<init>(r9);	 Catch:{ MalformedURLException -> 0x0010 }
        r2 = r0.getHost();	 Catch:{ MalformedURLException -> 0x0010 }
        r1 = r8;	 Catch:{ MalformedURLException -> 0x0010 }
        r3 = r10;	 Catch:{ MalformedURLException -> 0x0010 }
        r5 = r12;	 Catch:{ MalformedURLException -> 0x0010 }
        r7 = r14;	 Catch:{ MalformedURLException -> 0x0010 }
        r1.b(r2, r3, r5, r7);	 Catch:{ MalformedURLException -> 0x0010 }
    L_0x0010:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.network.Fallback.a(java.lang.String, long, long, java.lang.Exception):void");
    }

    public synchronized void a(String str, AccessHistory accessHistory) {
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (TextUtils.equals(str, cVar.a)) {
                cVar.a(accessHistory);
                return;
            }
        }
    }

    public synchronized void a(String[] strArr) {
        int length;
        int size = this.j.size() - 1;
        while (true) {
            int i = 0;
            if (size < 0) {
                break;
            }
            length = strArr.length;
            while (i < length) {
                if (TextUtils.equals(((c) this.j.get(size)).a, strArr[i])) {
                    this.j.remove(size);
                    break;
                }
                i++;
            }
            size--;
        }
        Iterator it = this.j.iterator();
        length = 0;
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.b > length) {
                length = cVar.b;
            }
        }
        while (i < strArr.length) {
            a(new c(strArr[i], (strArr.length + length) - i));
            i++;
        }
    }

    public boolean a() {
        return TextUtils.equals(this.a, HostManager.getActiveNetworkLabel());
    }

    public boolean a(Fallback fallback) {
        return TextUtils.equals(this.a, fallback.a);
    }

    public synchronized void b(String str) {
        a(new c(str));
    }

    public void b(String str, long j, long j2) {
        a(str, 0, j, j2, null);
    }

    public void b(String str, long j, long j2, Exception exception) {
        a(str, -1, j, j2, exception);
    }

    public boolean b() {
        return System.currentTimeMillis() - this.i < this.n;
    }

    public void c(String str) {
        this.m = str;
    }

    boolean c() {
        long j = 864000000;
        if (864000000 < this.n) {
            j = this.n;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.i <= j) {
            if (currentTimeMillis - this.i <= this.n || !this.a.startsWith("WIFI-")) {
                return false;
            }
        }
        return true;
    }

    public synchronized ArrayList<String> d() {
        return a(false);
    }

    public synchronized String e() {
        if (!TextUtils.isEmpty(this.k)) {
            return this.k;
        } else if (TextUtils.isEmpty(this.e)) {
            return "hardcode_isp";
        } else {
            this.k = d.a(new String[]{this.e, this.c, this.d, this.g, this.f}, "_");
            return this.k;
        }
    }

    public synchronized JSONObject f() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put(c.a, this.a);
        jSONObject.put("ttl", this.n);
        jSONObject.put("pct", this.l);
        jSONObject.put(MsgConstant.KEY_TS, this.i);
        jSONObject.put("city", this.d);
        jSONObject.put("prv", this.c);
        jSONObject.put("cty", this.g);
        jSONObject.put("isp", this.e);
        jSONObject.put("ip", this.f);
        jSONObject.put("host", this.b);
        jSONObject.put("xf", this.h);
        JSONArray jSONArray = new JSONArray();
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            jSONArray.put(((c) it.next()).a());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a);
        stringBuilder.append("\n");
        stringBuilder.append(e());
        Iterator it = this.j.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            stringBuilder.append("\n");
            stringBuilder.append(cVar.toString());
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
