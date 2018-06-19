package com.xunlei.downloadprovider.d.a;

import android.text.TextUtils;
import com.tencent.bugly.crashreport.CrashReport;
import org.json.JSONArray;

/* compiled from: JSONArrayStaticConfig */
public abstract class h extends a {
    public abstract void a(JSONArray jSONArray);

    public final /* bridge */ /* synthetic */ void f(String str) {
        super.f(str);
    }

    public final /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public final /* bridge */ /* synthetic */ String j() {
        return super.j();
    }

    public h(String str) {
        super(str);
    }

    protected final boolean a(boolean z, String str) {
        if (TextUtils.isEmpty(str)) {
            a(null);
            return false;
        }
        try {
            a(new JSONArray(str));
            return true;
        } catch (boolean z2) {
            CrashReport.postCatchedException(z2);
            a(null);
            return false;
        }
    }
}
