package com.getui.gtc.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.alipay.sdk.cons.c;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

public final class a implements Parcelable {
    public static final Creator CREATOR = new b();
    public String a;
    public SparseArray b;

    public final class a {
        public int a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public long g;
        public long h;
        public String i;
        public boolean j;
    }

    public interface b {
        void a(int i, a aVar);
    }

    public a() {
        this.b = new SparseArray();
    }

    protected a(Parcel parcel) {
        this.a = parcel.readString();
    }

    public static a a(JSONObject jSONObject) {
        try {
            a aVar = new a();
            aVar.a = jSONObject.getString("version");
            JSONArray jSONArray = jSONObject.getJSONArray("extensions");
            if (jSONArray == null || jSONArray.length() <= 0) {
                return aVar;
            }
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                a aVar2 = new a();
                aVar2.a = jSONObject2.getInt(AgooConstants.MESSAGE_ID);
                aVar2.b = jSONObject2.getString("version");
                aVar2.c = jSONObject2.getString(c.e);
                aVar2.d = jSONObject2.getString("cls_name");
                aVar2.i = jSONObject2.getString("url");
                aVar2.e = jSONObject2.getString("checksum");
                aVar2.f = jSONObject2.getString("key");
                if (jSONObject.has("isdestroy")) {
                    aVar2.j = jSONObject2.getBoolean("isdestroy");
                }
                if (jSONObject.has("effective")) {
                    String string = jSONObject.getString("effective");
                    long j = 0;
                    if (string != null && string.length() <= 13) {
                        j = Long.parseLong(string);
                    }
                    aVar2.h = j;
                }
                if (jSONObject.has("loadTime")) {
                    aVar2.g = jSONObject.getLong("loadTime");
                }
                aVar.a(aVar2.a, aVar2);
            }
            return aVar;
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            return null;
        }
    }

    public final a a(int i) {
        return (a) this.b.get(i);
    }

    public final void a(int i, a aVar) {
        this.b.put(i, aVar);
    }

    public final void a(b bVar) {
        try {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                int keyAt = this.b.keyAt(i);
                bVar.a(keyAt, (a) this.b.get(keyAt));
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public final void b(int i) {
        this.b.remove(i);
    }

    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = this.a;
            if (str != null) {
                jSONObject.put("version", str);
            }
            int size = this.b.size();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < size; i++) {
                a aVar = (a) this.b.get(this.b.keyAt(i));
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(AgooConstants.MESSAGE_ID, aVar.a);
                jSONObject2.put("version", aVar.b);
                jSONObject2.put(c.e, aVar.c);
                jSONObject2.put("cls_name", aVar.d);
                jSONObject2.put("url", aVar.i);
                jSONObject2.put("checksum", aVar.e);
                jSONObject2.put("isdestroy", aVar.j);
                jSONObject2.put("effective", aVar.h);
                jSONObject2.put("loadTime", aVar.g);
                jSONObject2.put("key", aVar.f);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("extensions", jSONArray);
            return jSONObject.toString();
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.a);
    }
}
