package com.baidu.mobads.vo;

import android.text.TextUtils;
import com.baidu.mobads.e.a;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import java.util.ArrayList;

public class c implements IXAdResponseInfo {
    private int a = 0;
    private Boolean b = Boolean.valueOf(false);
    private String c;
    private int d;
    private int e;
    private String f;
    private String g;
    private String h;
    private int i = -1;
    private int j = -1;
    private String k;
    private String l;
    private String m;
    private String n;
    private String o;
    private ArrayList<IXAdInstanceInfo> p = new ArrayList();
    private long q;

    public c(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r7.<init>();
        r0 = 0;
        r7.a = r0;
        r1 = java.lang.Boolean.valueOf(r0);
        r7.b = r1;
        r1 = -1;
        r7.i = r1;
        r7.j = r1;
        r2 = new java.util.ArrayList;
        r2.<init>();
        r7.p = r2;
        r7.o = r8;
        r2 = java.lang.System.currentTimeMillis();
        r7.q = r2;
        com.baidu.mobads.c.a.c = r8;
        r2 = new org.json.JSONObject;
        r2.<init>(r8);
        r8 = "ad";	 Catch:{ Exception -> 0x0047 }
        r8 = r2.getJSONArray(r8);	 Catch:{ Exception -> 0x0047 }
        if (r8 == 0) goto L_0x004e;	 Catch:{ Exception -> 0x0047 }
    L_0x002f:
        r3 = r0;	 Catch:{ Exception -> 0x0047 }
    L_0x0030:
        r4 = r8.length();	 Catch:{ Exception -> 0x0047 }
        if (r3 >= r4) goto L_0x004e;
    L_0x0036:
        r4 = r8.getJSONObject(r3);	 Catch:{ JSONException -> 0x0044 }
        r5 = r7.p;	 Catch:{ JSONException -> 0x0044 }
        r6 = new com.baidu.mobads.vo.XAdInstanceInfo;	 Catch:{ JSONException -> 0x0044 }
        r6.<init>(r4);	 Catch:{ JSONException -> 0x0044 }
        r5.add(r6);	 Catch:{ JSONException -> 0x0044 }
    L_0x0044:
        r3 = r3 + 1;
        goto L_0x0030;
    L_0x0047:
        r8 = new java.util.ArrayList;
        r8.<init>();
        r7.p = r8;
    L_0x004e:
        r8 = "n";
        r8 = r2.optInt(r8, r0);
        r7.a = r8;
        r8 = "x";
        r8 = r2.optInt(r8, r0);
        r7.d = r8;
        r8 = "y";
        r8 = r2.optInt(r8, r0);
        r7.e = r8;
        r8 = "m";
        r8 = r2.optInt(r8, r0);
        r3 = 1;
        if (r8 != r3) goto L_0x0070;
    L_0x006f:
        r0 = r3;
    L_0x0070:
        r8 = java.lang.Boolean.valueOf(r0);
        r7.b = r8;
        r8 = "u";
        r0 = "";
        r8 = r2.optString(r8, r0);
        r7.c = r8;
        r8 = "exp2";
        r0 = "{}";
        r8 = r2.optString(r8, r0);
        r7.f = r8;
        r8 = "ext_act";
        r0 = "{}";
        r8 = r2.optString(r8, r0);
        r7.g = r8;
        r8 = "lunpan";
        r8 = r2.optInt(r8, r1);
        r7.i = r8;
        r8 = "intIcon";
        r8 = r2.optInt(r8, r1);
        r7.j = r8;
        r8 = "ck";
        r0 = "";
        r8 = r2.optString(r8, r0);
        r7.k = r8;
        r8 = "req_id";
        r8 = r2.optString(r8);
        r7.l = r8;
        r8 = "error_code";
        r0 = "";
        r8 = r2.optString(r8, r0);
        r7.m = r8;
        r8 = "error_msg";
        r0 = "";
        r8 = r2.optString(r8, r0);
        r7.n = r8;
        r8 = "theme";	 Catch:{ JSONException -> 0x00d3 }
        r8 = r2.getString(r8);	 Catch:{ JSONException -> 0x00d3 }
        r7.h = r8;	 Catch:{ JSONException -> 0x00d3 }
        return;
    L_0x00d3:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.vo.c.<init>(java.lang.String):void");
    }

    public IXAdInstanceInfo getPrimaryAdInstanceInfo() {
        return this.p.size() > 0 ? (IXAdInstanceInfo) this.p.get(0) : null;
    }

    public int getAdsNum() {
        return this.a;
    }

    public void setAdsNum(int i) {
        this.a = i;
    }

    public Boolean getOpenPointModeForWall() {
        return this.b;
    }

    public void setOpenPointModeForWall(Boolean bool) {
        this.b = bool;
    }

    public String getPointUnitForWall() {
        return this.c;
    }

    public void setPointUnitForWall(String str) {
        this.c = str;
    }

    public int getLongitude() {
        return this.d;
    }

    public void setLongitude(int i) {
        this.d = i;
    }

    public int getLatitude() {
        return this.e;
    }

    public void setLatitude(int i) {
        this.e = i;
    }

    public String getExp2() {
        return this.f;
    }

    public void setExp2(String str) {
        this.f = str;
    }

    public String getExtentionActionExp() {
        return this.g;
    }

    public void setExtentionActionExp(String str) {
        this.g = str;
    }

    public String getDefaultFillInThemeForStaticAds() {
        return this.h;
    }

    public void setDefaultFillInThemeForStaticAds(String str) {
        this.h = str;
    }

    public int getLunpan() {
        return this.i;
    }

    public void setLunpan(int i) {
        this.i = i;
    }

    public int getIntIcon() {
        return this.j;
    }

    public void setIntIcon(int i) {
        this.j = i;
    }

    public String getBaiduidOfCookie() {
        return this.k;
    }

    public void setBaiduidOfCookie(String str) {
        this.k = str;
    }

    public String getRequestId() {
        return this.l;
    }

    public void setRequestId(String str) {
        this.l = str;
    }

    public String getErrorCode() {
        return this.m;
    }

    public void setErrorCode(String str) {
        this.m = str;
    }

    public String getErrorMessage() {
        if (!TextUtils.isEmpty(this.n)) {
            return this.n;
        }
        String a = a.a(this.m);
        if (a != null) {
            this.n = a;
        } else {
            this.n = "";
        }
        return this.n;
    }

    public void setErrorMessage(String str) {
        this.n = str;
    }

    public String getOriginResponseStr() {
        return this.o;
    }

    public void setOriginResponseStr(String str) {
        this.o = str;
    }

    public ArrayList<IXAdInstanceInfo> getAdInstanceList() {
        return this.p;
    }

    public void setAdInstanceList(ArrayList<IXAdInstanceInfo> arrayList) {
        this.p = arrayList;
    }

    public long getTimeStamp() {
        return this.q;
    }
}
