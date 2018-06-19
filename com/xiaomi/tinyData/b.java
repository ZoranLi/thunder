package com.xiaomi.tinyData;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.be;
import com.xiaomi.push.service.bf;
import com.xiaomi.xmpush.thrift.f;
import java.util.HashMap;
import java.util.Map;

public class b {
    private static b a;
    private final Context b;
    private Map<String, c> c = new HashMap();

    private b(Context context) {
        this.b = context;
    }

    public static b a(Context context) {
        if (context == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    c a() {
        c cVar = (c) this.c.get("UPLOADER_PUSH_CHANNEL");
        if (cVar != null) {
            return cVar;
        }
        cVar = (c) this.c.get("UPLOADER_HTTP");
        return cVar != null ? cVar : null;
    }

    public void a(c cVar, String str) {
        if (cVar == null) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            b().put(str, cVar);
        }
    }

    public boolean a(f fVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.channel.commonutils.logger.b.a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (be.a(fVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(fVar.m())) {
                fVar.f(be.a());
            }
            fVar.g(str);
            bf.a(this.b, fVar);
            return true;
        }
    }

    Map<String, c> b() {
        return this.c;
    }
}
