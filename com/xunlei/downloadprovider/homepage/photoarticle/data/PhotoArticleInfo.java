package com.xunlei.downloadprovider.homepage.photoarticle.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class PhotoArticleInfo implements Parcelable {
    public static final Creator<PhotoArticleInfo> CREATOR = new a();
    public String a;
    public String b;
    public String c;
    public String d;
    public List<String> e;
    public long f;
    public boolean g;
    public int h;
    public int i;
    public int j;
    private ArrayList<String> k = new ArrayList();
    private int l;
    private long m;
    private long n;
    private int o;

    public int describeContents() {
        return 0;
    }

    public static com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo a(org.json.JSONObject r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r7 == 0) goto L_0x00c9;
    L_0x0003:
        r1 = r7.length();
        if (r1 != 0) goto L_0x000b;
    L_0x0009:
        goto L_0x00c9;
    L_0x000b:
        r1 = new com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;	 Catch:{ JSONException -> 0x00c8 }
        r1.<init>();	 Catch:{ JSONException -> 0x00c8 }
        r2 = "id";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.getString(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.a = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "status";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optInt(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.l = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "gcid";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optString(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.b = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "update_time";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optLong(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.m = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "pub_time";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optLong(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.n = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "uid";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optLong(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.f = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "title";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optString(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.c = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "poster";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optString(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.d = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "poster_list";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optJSONArray(r2);	 Catch:{ JSONException -> 0x00c8 }
        r3 = new java.util.ArrayList;	 Catch:{ JSONException -> 0x00c8 }
        r3.<init>();	 Catch:{ JSONException -> 0x00c8 }
        r1.e = r3;	 Catch:{ JSONException -> 0x00c8 }
        r3 = 0;	 Catch:{ JSONException -> 0x00c8 }
        if (r2 == 0) goto L_0x0079;	 Catch:{ JSONException -> 0x00c8 }
    L_0x0060:
        r4 = r2.length();	 Catch:{ JSONException -> 0x00c8 }
        if (r4 <= 0) goto L_0x0079;	 Catch:{ JSONException -> 0x00c8 }
    L_0x0066:
        r4 = r3;	 Catch:{ JSONException -> 0x00c8 }
    L_0x0067:
        r5 = r2.length();	 Catch:{ JSONException -> 0x00c8 }
        if (r4 >= r5) goto L_0x0079;	 Catch:{ JSONException -> 0x00c8 }
    L_0x006d:
        r5 = r1.e;	 Catch:{ JSONException -> 0x00c8 }
        r6 = r2.optString(r4);	 Catch:{ JSONException -> 0x00c8 }
        r5.add(r6);	 Catch:{ JSONException -> 0x00c8 }
        r4 = r4 + 1;	 Catch:{ JSONException -> 0x00c8 }
        goto L_0x0067;	 Catch:{ JSONException -> 0x00c8 }
    L_0x0079:
        r2 = "have_favorite";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optBoolean(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.g = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "play_count";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optInt(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.o = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "thumbup_count";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optInt(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.h = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "comment_count";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optInt(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.i = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "share_count";	 Catch:{ JSONException -> 0x00c8 }
        r2 = r7.optInt(r2);	 Catch:{ JSONException -> 0x00c8 }
        r1.j = r2;	 Catch:{ JSONException -> 0x00c8 }
        r2 = "tag";	 Catch:{ JSONException -> 0x00c8 }
        r7 = r7.optJSONArray(r2);	 Catch:{ JSONException -> 0x00c8 }
        if (r7 == 0) goto L_0x00c7;	 Catch:{ JSONException -> 0x00c8 }
    L_0x00a9:
        r2 = r7.length();	 Catch:{ JSONException -> 0x00c8 }
        if (r2 <= 0) goto L_0x00c7;	 Catch:{ JSONException -> 0x00c8 }
    L_0x00af:
        r2 = r7.length();	 Catch:{ JSONException -> 0x00c8 }
    L_0x00b3:
        if (r3 >= r2) goto L_0x00c7;	 Catch:{ JSONException -> 0x00c8 }
    L_0x00b5:
        r4 = r7.optString(r3);	 Catch:{ JSONException -> 0x00c8 }
        r5 = android.text.TextUtils.isEmpty(r4);	 Catch:{ JSONException -> 0x00c8 }
        if (r5 != 0) goto L_0x00c4;	 Catch:{ JSONException -> 0x00c8 }
    L_0x00bf:
        r5 = r1.k;	 Catch:{ JSONException -> 0x00c8 }
        r5.add(r4);	 Catch:{ JSONException -> 0x00c8 }
    L_0x00c4:
        r3 = r3 + 1;
        goto L_0x00b3;
    L_0x00c7:
        return r1;
    L_0x00c8:
        return r0;
    L_0x00c9:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo.a(org.json.JSONObject):com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo");
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
        parcel.writeStringList(this.k);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.l);
        parcel.writeLong(this.m);
        parcel.writeLong(this.n);
        parcel.writeLong(this.f);
        parcel.writeByte(this.g);
        parcel.writeInt(this.h);
        parcel.writeInt(this.o);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
    }

    protected PhotoArticleInfo(Parcel parcel) {
        this.a = parcel.readString();
        this.k = parcel.createStringArrayList();
        this.b = parcel.readString();
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.l = parcel.readInt();
        this.m = parcel.readLong();
        this.n = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readByte() != (byte) 0;
        this.h = parcel.readInt();
        this.o = parcel.readInt();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
    }
}
