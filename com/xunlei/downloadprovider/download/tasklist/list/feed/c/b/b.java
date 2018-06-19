package com.xunlei.downloadprovider.download.tasklist.list.feed.c.b;

import android.support.annotation.Nullable;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TouTiaoInfo */
public final class b {
    public long a;
    String b;
    public String c;
    public String d;
    String e;
    public String f;
    public String g;
    public long h;
    long i;
    String j;
    boolean k;
    long l;
    long m;
    public long n;
    public boolean o;
    public long p;
    int q = 0;
    public List<a> r;
    public JSONObject s;
    public final long t = System.currentTimeMillis();
    public long u = 0;

    /* compiled from: TouTiaoInfo */
    public static class a {
        public String a;
        public List<String> b;
        private int c;
        private int d;

        @Nullable
        public static a a(JSONObject jSONObject) {
            List list = null;
            if (jSONObject == null) {
                return null;
            }
            a aVar = new a();
            aVar.a = jSONObject.optString("url");
            aVar.c = jSONObject.optInt(SocializeProtocolConstants.WIDTH);
            aVar.d = jSONObject.optInt(SocializeProtocolConstants.HEIGHT);
            jSONObject = jSONObject.optJSONArray("url_list");
            if (jSONObject != null) {
                list = new ArrayList(jSONObject.length());
                for (int i = 1; i < jSONObject.length(); i++) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(i);
                    if (optJSONObject != null) {
                        list.add(optJSONObject.optString("url"));
                    }
                }
            }
            aVar.b = list;
            return aVar;
        }

        static /* synthetic */ List a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            List arrayList = new ArrayList(jSONArray.length());
            for (int i = 0; i < jSONArray.length(); i++) {
                a a = a(jSONArray.optJSONObject(i));
                if (a != null) {
                    arrayList.add(a);
                }
            }
            if (arrayList.isEmpty() != null) {
                return null;
            }
            return arrayList;
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("TouTiaoInfo{groupId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", desc='");
        stringBuilder.append(this.e);
        stringBuilder.append('\'');
        stringBuilder.append(", articleUrl='");
        stringBuilder.append(this.g);
        stringBuilder.append('\'');
        stringBuilder.append(", isAd=");
        stringBuilder.append(this.o);
        stringBuilder.append(", coverImageMode=");
        stringBuilder.append(this.q);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
