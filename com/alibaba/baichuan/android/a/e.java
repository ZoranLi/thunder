package com.alibaba.baichuan.android.a;

import com.alibaba.baichuan.android.trade.utils.g.a;
import com.alibaba.fastjson.JSONObject;
import com.tencent.connect.common.Constants;

public final class e {
    public static final e a = new e("0");
    public static final e b = new e(Constants.VIA_SHARE_TYPE_INFO);
    public static final e c = new e("2");
    public static final e d = new e("1");
    public static final e e = new e("4");
    public static final e f = new e("7");
    public String g = "";
    private JSONObject h = new JSONObject();
    private String i = Constants.VIA_SHARE_TYPE_INFO;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r1) {
        /*
        r0 = r1.hashCode();
        switch(r0) {
            case 48: goto L_0x004e;
            case 49: goto L_0x0044;
            case 50: goto L_0x003a;
            case 51: goto L_0x0030;
            case 52: goto L_0x0026;
            case 53: goto L_0x001c;
            case 54: goto L_0x0012;
            case 55: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0058;
    L_0x0008:
        r0 = "7";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0010:
        r1 = 7;
        goto L_0x0059;
    L_0x0012:
        r0 = "6";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x001a:
        r1 = 6;
        goto L_0x0059;
    L_0x001c:
        r0 = "5";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0024:
        r1 = 5;
        goto L_0x0059;
    L_0x0026:
        r0 = "4";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x002e:
        r1 = 4;
        goto L_0x0059;
    L_0x0030:
        r0 = "3";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0038:
        r1 = 3;
        goto L_0x0059;
    L_0x003a:
        r0 = "2";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0042:
        r1 = 2;
        goto L_0x0059;
    L_0x0044:
        r0 = "1";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x004c:
        r1 = 1;
        goto L_0x0059;
    L_0x004e:
        r0 = "0";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0058;
    L_0x0056:
        r1 = 0;
        goto L_0x0059;
    L_0x0058:
        r1 = -1;
    L_0x0059:
        switch(r1) {
            case 0: goto L_0x0074;
            case 1: goto L_0x0071;
            case 2: goto L_0x006e;
            case 3: goto L_0x006b;
            case 4: goto L_0x0068;
            case 5: goto L_0x0065;
            case 6: goto L_0x0062;
            case 7: goto L_0x005f;
            default: goto L_0x005c;
        };
    L_0x005c:
        r1 = "BC_UNKNOWN";
        return r1;
    L_0x005f:
        r1 = "BC_CLOSED";
        return r1;
    L_0x0062:
        r1 = "BC_FAILED";
        return r1;
    L_0x0065:
        r1 = "BC_TIMEOUT";
        return r1;
    L_0x0068:
        r1 = "BC_NO_PERMISSION";
        return r1;
    L_0x006b:
        r1 = "BC_UNKNOWN_ERR";
        return r1;
    L_0x006e:
        r1 = "BC_PARAM_ERR";
        return r1;
    L_0x0071:
        r1 = "BC_NO_HANDLER";
        return r1;
    L_0x0074:
        r1 = "BC_SUCCESS";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.a.e.b(java.lang.String):java.lang.String");
    }

    public final void a() {
        this.i = "0";
        this.g = b("0");
    }

    public final void a(String str) {
        this.i = str;
        this.g = b(str);
    }

    public final void a(String str, Object obj) {
        this.h.put(str, obj);
    }

    public final String b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.i);
            jSONObject.put("msg", this.g);
            jSONObject.put("data", this.h);
        } catch (Exception e) {
            e.getMessage();
            a.b();
        }
        return jSONObject.toString();
    }

    public e(String str) {
        this.g = str;
    }
}
