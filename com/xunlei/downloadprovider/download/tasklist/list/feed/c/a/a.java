package com.xunlei.downloadprovider.download.tasklist.list.feed.c.a;

import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import java.util.ArrayList;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TaskListFeedBaiduInfo */
public final class a extends com.xunlei.downloadprovider.download.tasklist.list.feed.c.a {
    public ArrayList<String> a = new ArrayList();
    public String b;
    public String c;
    public String d;
    private String n;
    private String o;

    public final String b() {
        return this.c;
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.o = jSONObject.optString("catInfo");
            aVar.c = jSONObject.optString(AgooConstants.MESSAGE_ID);
            aVar.d = jSONObject.optString("title");
            str = jSONObject.optJSONArray("images");
            aVar.b = jSONObject.optString("detailUrl");
            for (int i = 0; i < 20; i++) {
                CharSequence optString = str.optString(i);
                if (TextUtils.isEmpty(optString)) {
                    break;
                }
                aVar.a.add(optString);
            }
            if (aVar.a.size() < 3) {
                return null;
            }
            return aVar;
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static e a(a aVar) {
        return aVar == null ? null : new e(307, aVar, (long) com.xunlei.downloadprovider.download.tasklist.list.feed.c.a.a());
    }

    public final String c() {
        Object obj = this.o;
        if (TextUtils.isEmpty(obj)) {
            return this.n == null ? "" : this.n;
        } else {
            if (TextUtils.isEmpty(this.n)) {
                try {
                    this.n = new JSONObject(obj).optString(c.e);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return this.n == null ? "" : this.n;
        }
    }
}
