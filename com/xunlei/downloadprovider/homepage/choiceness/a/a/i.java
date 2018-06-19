package com.xunlei.downloadprovider.homepage.choiceness.a.a;

import android.text.TextUtils;
import com.xunlei.downloadprovider.publiser.visitors.model.Gender;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: ChoicenessLiveInfo */
public final class i extends e {
    public String A;
    public String B;
    public String C;
    public String D;
    public VideoUserInfo E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private int L;
    private String M;
    private String N;
    private Gender O;
    private String P;
    public String a;
    public String b;
    public int c;
    public int d;
    public String n;
    public int o;
    public String p;
    public int q;
    public String r;
    public String s;
    public String t;
    public String u;
    public int v;
    public long w;
    public String x;
    public int y;
    public String z;

    public final boolean a() {
        return !TextUtils.isEmpty(this.P);
    }

    public static com.xunlei.downloadprovider.homepage.choiceness.a.a.i a(org.json.JSONObject r5) throws org.json.JSONException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new com.xunlei.downloadprovider.homepage.choiceness.a.a.i;
        r1.<init>();
        com.xunlei.downloadprovider.homepage.choiceness.a.a.e.a(r1, r5);
        r2 = "res_info";
        r2 = r5.getJSONObject(r2);
        r3 = "avatar_url";
        r3 = r2.optString(r3);
        r1.b = r3;
        r3 = "cover_item";
        r3 = r2.optString(r3);
        r1.F = r3;
        r3 = "expect_exposure_num";
        r3 = r2.optString(r3);
        r1.G = r3;
        r3 = "grayid";
        r3 = r2.optInt(r3);
        r1.o = r3;
        r3 = "hosttype";
        r3 = r2.optInt(r3);
        r1.c = r3;
        r3 = "icon";
        r3 = r2.optString(r3);
        r1.H = r3;
        r3 = "level";
        r3 = r2.optInt(r3);
        r1.d = r3;
        r3 = "livestat";
        r3 = r2.optString(r3);
        r1.n = r3;
        r3 = "nickname";
        r3 = r2.optString(r3);
        r3 = r3.trim();
        r1.p = r3;
        r3 = "push_start_time";
        r3 = r2.optString(r3);
        r1.I = r3;
        r3 = "push_end_time";
        r3 = r2.optString(r3);
        r1.J = r3;
        r3 = "push_status";
        r3 = r2.optString(r3);
        r1.K = r3;
        r3 = "recommend";
        r3 = r2.optInt(r3);
        r1.q = r3;
        r3 = "res_cover_url";
        r3 = r2.optString(r3);
        r1.r = r3;
        r3 = "res_title";
        r3 = r2.optString(r3);
        r1.t = r3;
        r3 = "room_info";
        r3 = r2.optString(r3);
        r1.u = r3;
        r3 = "room_onlinenum";
        r3 = r2.optInt(r3);
        r1.v = r3;
        r3 = "room_point";
        r3 = r2.optLong(r3);
        r1.w = r3;
        r3 = "room_status";
        r3 = r2.optInt(r3);
        r1.L = r3;
        r3 = "roomid";
        r3 = r2.optString(r3);
        r1.M = r3;
        r3 = "sdk_id";
        r3 = r2.optString(r3);
        r1.x = r3;
        r3 = "sign";
        r3 = r2.optInt(r3);
        r1.y = r3;
        r3 = "tag";
        r3 = r2.optString(r3);
        r1.N = r3;
        r3 = "userid";
        r3 = r2.optString(r3);
        r1.a = r3;
        r3 = "room_gif";
        r3 = r2.optString(r3);
        r1.s = r3;
        r3 = "newuser_gift";
        r3 = r2.isNull(r3);
        if (r3 == 0) goto L_0x00e7;
    L_0x00e6:
        goto L_0x00ed;
    L_0x00e7:
        r0 = "newuser_gift";
        r0 = r2.optString(r0);
    L_0x00ed:
        r1.P = r0;
        r0 = "user_info";
        r5 = r5.optJSONObject(r0);
        r0 = new com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
        r0.<init>();
        r5 = com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo.parseFrom(r0, r5);
        r1.E = r5;
        r5 = "sex";
        r5 = r2.optInt(r5);
        if (r5 > 0) goto L_0x010d;
    L_0x0108:
        r5 = com.xunlei.downloadprovider.publiser.visitors.model.Gender.UNKNOWN;
        r1.O = r5;
        goto L_0x0121;
    L_0x010d:
        r0 = 1;
        if (r5 != r0) goto L_0x0115;
    L_0x0110:
        r5 = com.xunlei.downloadprovider.publiser.visitors.model.Gender.MALE;
        r1.O = r5;
        goto L_0x0121;
    L_0x0115:
        r0 = 2;
        if (r5 != r0) goto L_0x011d;
    L_0x0118:
        r5 = com.xunlei.downloadprovider.publiser.visitors.model.Gender.FEMALE;
        r1.O = r5;
        goto L_0x0121;
    L_0x011d:
        r5 = com.xunlei.downloadprovider.publiser.visitors.model.Gender.UNKNOWN;
        r1.O = r5;
    L_0x0121:
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0157 }
        r0 = r1.u;	 Catch:{ Exception -> 0x0157 }
        r5.<init>(r0);	 Catch:{ Exception -> 0x0157 }
        r0 = "viewfinder";	 Catch:{ Exception -> 0x0157 }
        r5 = r5.optString(r0);	 Catch:{ Exception -> 0x0157 }
        r1.z = r5;	 Catch:{ Exception -> 0x0157 }
        r5 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0157 }
        r0 = r1.P;	 Catch:{ Exception -> 0x0157 }
        r5.<init>(r0);	 Catch:{ Exception -> 0x0157 }
        r0 = "title";	 Catch:{ Exception -> 0x0157 }
        r0 = r5.optString(r0);	 Catch:{ Exception -> 0x0157 }
        r1.A = r0;	 Catch:{ Exception -> 0x0157 }
        r0 = "subtitle";	 Catch:{ Exception -> 0x0157 }
        r0 = r5.optString(r0);	 Catch:{ Exception -> 0x0157 }
        r1.B = r0;	 Catch:{ Exception -> 0x0157 }
        r0 = "btnfont";	 Catch:{ Exception -> 0x0157 }
        r0 = r5.optString(r0);	 Catch:{ Exception -> 0x0157 }
        r1.C = r0;	 Catch:{ Exception -> 0x0157 }
        r0 = "imgurl";	 Catch:{ Exception -> 0x0157 }
        r5 = r5.optString(r0);	 Catch:{ Exception -> 0x0157 }
        r1.D = r5;	 Catch:{ Exception -> 0x0157 }
    L_0x0157:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.choiceness.a.a.i.a(org.json.JSONObject):com.xunlei.downloadprovider.homepage.choiceness.a.a.i");
    }
}
