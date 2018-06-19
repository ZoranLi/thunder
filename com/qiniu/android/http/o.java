package com.qiniu.android.http;

import com.qiniu.android.a.a;
import com.qiniu.android.a.b;
import com.qiniu.android.c.s;
import com.tencent.smtt.utils.TbsLog;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.tdlive.protocol.XLLiveRequest;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: ResponseInfo */
public final class o {
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final String g;
    public final String h;
    public final int i;
    public final String j;
    public final String k = r.a().a;
    public final long l = (System.currentTimeMillis() / 1000);
    public final long m;
    public final s n;
    public final long o;
    public final JSONObject p;

    private o(JSONObject jSONObject, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, long j, long j2, String str7, s sVar, long j3) {
        this.p = jSONObject;
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.g = str4;
        this.j = str5;
        this.f = j;
        this.e = str7;
        this.h = str6;
        this.i = i2;
        this.m = j2;
        this.n = sVar;
        this.o = j3;
    }

    public static o a(JSONObject jSONObject, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, long j, long j2, String str7, s sVar, long j3) {
        s sVar2;
        s sVar3 = sVar;
        String str8 = str6.split(Constants.COLON_SEPARATOR)[0];
        String substring = str8.substring(Math.max(0, str8.indexOf("/") + 1));
        o oVar = r0;
        o oVar2 = new o(jSONObject, i, str, str2, str3, str4, str5, substring, i2, j, j2, str7, sVar3, j3);
        if (a.a) {
            sVar2 = sVar;
        } else {
            sVar2 = sVar;
            if (sVar2 == null) {
                return oVar;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        o oVar3 = oVar;
        stringBuilder.append(oVar3.l);
        o oVar4 = oVar3;
        b.a(sVar2, new p(i, str, str4, substring, i2, j, stringBuilder.toString(), j2, str5, j3));
        return oVar4;
    }

    public static o a(String str) {
        return a(null, -5, "", "", "", "", "", "", 80, 0, 0, str, null, 0);
    }

    public static o a(Exception exception, s sVar) {
        return a(null, -3, "", "", "", "", "", "", 80, 0, 0, exception.getMessage(), sVar, 0);
    }

    public final boolean a() {
        return this.a == -2;
    }

    public final boolean b() {
        return this.a == 200 && this.e == null && (e() || this.p != null);
    }

    public final boolean c() {
        if (!(this.a == -1 || this.a == -1003 || this.a == XLLiveRequest.ERROR_ALEARDY_FOLLOW || this.a == -1001)) {
            if (this.a != XLLiveRequest.ERROR_NOT_FOLLOW) {
                return false;
            }
        }
        return true;
    }

    public final boolean d() {
        if (!a()) {
            boolean z;
            if (!c()) {
                z = (this.a >= 500 && this.a < 600 && this.a != 579) || this.a == TbsLog.TBSLOG_CODE_SDK_SELF_MODE;
                if (!z) {
                    z = false;
                    if (!(z || this.a == 406 || (this.a == 200 && this.e != null))) {
                        z = this.a >= 500 && this.a >= 200 && !e() && this.p == null;
                        if (z || (this.n.d.equals("") ^ 1) != 0) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            z = true;
            if (this.a >= 500) {
            }
            if (z) {
            }
        }
        return false;
    }

    public final String toString() {
        return String.format(Locale.ENGLISH, "{ver:%s,ResponseInfo:%s,status:%d, reqId:%s, xlog:%s, xvia:%s, host:%s, path:%s, ip:%s, port:%d, duration:%d s, time:%d, sent:%d,error:%s}", new Object[]{"7.3.9", this.k, Integer.valueOf(this.a), this.b, this.c, this.d, this.g, this.j, this.h, Integer.valueOf(this.i), Long.valueOf(this.f), Long.valueOf(this.l), Long.valueOf(this.m), this.e});
    }

    public final boolean e() {
        return this.b != null;
    }
}
