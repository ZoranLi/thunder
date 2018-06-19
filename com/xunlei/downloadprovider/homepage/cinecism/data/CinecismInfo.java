package com.xunlei.downloadprovider.homepage.cinecism.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class CinecismInfo implements Parcelable {
    public static final Creator<CinecismInfo> CREATOR = new a();
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public int l;
    public String m;
    public String n;
    public List<String> o;
    public int p;
    private String q;
    private int r;
    private int s;
    private int t;

    public int describeContents() {
        return 0;
    }

    public static com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo a(org.json.JSONObject r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r6 == 0) goto L_0x00da;
    L_0x0003:
        r1 = r6.length();
        if (r1 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x00da;
    L_0x000b:
        r1 = new com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;	 Catch:{ JSONException -> 0x00d9 }
        r1.<init>();	 Catch:{ JSONException -> 0x00d9 }
        r2 = "id";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.getString(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.a = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "body_url";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optString(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.q = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "title";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optString(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.b = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "summary";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optString(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.c = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "cover_url";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optString(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.d = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "uid";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optLong(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.e = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "have_fav";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optBoolean(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.f = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "fav_count";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.g = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "comment_count";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.h = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "share_count";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.i = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "show_count";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.j = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "create_time";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optLong(r2);	 Catch:{ JSONException -> 0x00d9 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ JSONException -> 0x00d9 }
        r2 = r2 * r4;	 Catch:{ JSONException -> 0x00d9 }
        r1.k = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "status";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.l = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "lock_status";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.r = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "media_id";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.s = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "tag";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optString(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.m = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "activity_id";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2);	 Catch:{ JSONException -> 0x00d9 }
        r1.t = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "image_num";	 Catch:{ JSONException -> 0x00d9 }
        r3 = 0;	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optInt(r2, r3);	 Catch:{ JSONException -> 0x00d9 }
        r1.p = r2;	 Catch:{ JSONException -> 0x00d9 }
        r2 = "media_info";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r6.optJSONObject(r2);	 Catch:{ JSONException -> 0x00d9 }
        if (r2 == 0) goto L_0x00b4;	 Catch:{ JSONException -> 0x00d9 }
    L_0x00ac:
        r4 = "name";	 Catch:{ JSONException -> 0x00d9 }
        r2 = r2.optString(r4);	 Catch:{ JSONException -> 0x00d9 }
        r1.n = r2;	 Catch:{ JSONException -> 0x00d9 }
    L_0x00b4:
        r2 = "poster_list";	 Catch:{ JSONException -> 0x00d9 }
        r6 = r6.optJSONArray(r2);	 Catch:{ JSONException -> 0x00d9 }
        if (r6 == 0) goto L_0x00d8;	 Catch:{ JSONException -> 0x00d9 }
    L_0x00bc:
        r2 = r6.length();	 Catch:{ JSONException -> 0x00d9 }
        if (r3 >= r2) goto L_0x00d8;	 Catch:{ JSONException -> 0x00d9 }
    L_0x00c2:
        r2 = r6.getString(r3);	 Catch:{ JSONException -> 0x00d9 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ JSONException -> 0x00d9 }
        if (r2 != 0) goto L_0x00d5;	 Catch:{ JSONException -> 0x00d9 }
    L_0x00cc:
        r2 = r1.o;	 Catch:{ JSONException -> 0x00d9 }
        r4 = r6.getString(r3);	 Catch:{ JSONException -> 0x00d9 }
        r2.add(r4);	 Catch:{ JSONException -> 0x00d9 }
    L_0x00d5:
        r3 = r3 + 1;
        goto L_0x00bc;
    L_0x00d8:
        return r1;
    L_0x00d9:
        return r0;
    L_0x00da:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo.a(org.json.JSONObject):com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo");
    }

    public CinecismInfo() {
        this.o = new ArrayList();
    }

    private CinecismInfo(Parcel parcel) {
        this.o = new ArrayList();
        this.a = parcel.readString();
        this.q = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readLong();
        this.f = parcel.readByte() != (byte) 0;
        this.g = parcel.readInt();
        this.h = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = parcel.readLong();
        this.l = parcel.readInt();
        this.r = parcel.readInt();
        this.s = parcel.readInt();
        this.m = parcel.readString();
        this.t = parcel.readInt();
        this.n = parcel.readString();
        this.o = parcel.createStringArrayList();
        this.p = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeString(this.q);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeLong(this.e);
        parcel.writeByte((byte) this.f);
        parcel.writeInt(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        parcel.writeLong(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.r);
        parcel.writeInt(this.s);
        parcel.writeString(this.m);
        parcel.writeInt(this.t);
        parcel.writeString(this.n);
        parcel.writeStringList(this.o);
        parcel.writeInt(this.p);
    }
}
