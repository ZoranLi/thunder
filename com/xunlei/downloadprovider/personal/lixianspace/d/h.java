package com.xunlei.downloadprovider.personal.lixianspace.d;

import android.net.Uri;
import android.text.TextUtils;
import com.xunlei.downloadprovider.member.payment.network.BaseJsonRequest.IMethod;
import com.xunlei.downloadprovider.member.payment.network.d;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CreateLXTaskRequest */
public final class h extends a {

    /* compiled from: CreateLXTaskRequest */
    public static final class a {
        public String a;
        public long b = 0;
        public long[] c;
        private String d;
        private String e;
        private String f;

        public a(String str) {
            this.d = Uri.encode(str, "-![.:/,%?&=@|]");
        }

        final JSONObject a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", this.d);
                if (!TextUtils.isEmpty(this.e)) {
                    jSONObject.put("gcid", this.e);
                }
                if (!TextUtils.isEmpty(this.a)) {
                    jSONObject.put("filename", this.a);
                }
                if (this.b > 0) {
                    jSONObject.put("filesize", String.valueOf(this.b));
                }
                if (!TextUtils.isEmpty(this.f)) {
                    jSONObject.put("cid", this.f);
                }
                jSONObject.put("create_from", "2");
                JSONArray jSONArray = new JSONArray();
                if (this.c != null && this.c.length > 0) {
                    for (long put : this.c) {
                        jSONArray.put(put);
                    }
                }
                jSONObject.put("file_indexs", jSONArray);
                return jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public h(Object obj) {
        super(obj, IMethod.POST, "http://download.lixian.vip.xunlei.com/task/create");
    }

    public final void a(d dVar, a... aVarArr) {
        if (aVarArr != null) {
            if (aVarArr.length > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (a a : aVarArr) {
                        jSONArray.put(a.a());
                    }
                    aVarArr = new JSONObject();
                    aVarArr.put("tasks", jSONArray);
                    new StringBuilder("CreateLXTaskRequest==").append(aVarArr.toString());
                    a(aVarArr, dVar);
                } catch (d dVar2) {
                    dVar2.printStackTrace();
                }
            }
        }
    }
}
