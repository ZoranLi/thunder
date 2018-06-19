package com.xiaomi.slim;

import android.text.TextUtils;
import com.xiaomi.push.protobuf.b.c;
import com.xiaomi.push.service.ap.b;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

class a {
    public static void a(b bVar, String str, com.xiaomi.smack.a aVar) {
        Object obj;
        Object obj2;
        String str2;
        c cVar = new c();
        if (!TextUtils.isEmpty(bVar.c)) {
            cVar.a(bVar.c);
        }
        if (!TextUtils.isEmpty(bVar.f)) {
            cVar.d(bVar.f);
        }
        if (!TextUtils.isEmpty(bVar.g)) {
            cVar.e(bVar.g);
        }
        cVar.b(bVar.e ? "1" : "0");
        cVar.c(!TextUtils.isEmpty(bVar.d) ? bVar.d : "XIAOMI-SASL");
        b bVar2 = new b();
        bVar2.c(bVar.b);
        bVar2.a(Integer.parseInt(bVar.h));
        bVar2.b(bVar.a);
        bVar2.a("BIND", null);
        bVar2.a(bVar2.h());
        StringBuilder stringBuilder = new StringBuilder("[Slim]: bind id=");
        stringBuilder.append(bVar2.h());
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
        Map hashMap = new HashMap();
        hashMap.put("challenge", str);
        hashMap.put("token", bVar.c);
        hashMap.put("chid", bVar.h);
        hashMap.put("from", bVar.b);
        hashMap.put(AgooConstants.MESSAGE_ID, bVar2.h());
        hashMap.put("to", "xiaomi.com");
        if (bVar.e) {
            obj = "kick";
            obj2 = "1";
        } else {
            obj = "kick";
            obj2 = "0";
        }
        hashMap.put(obj, obj2);
        if (TextUtils.isEmpty(bVar.f)) {
            obj = "client_attrs";
            obj2 = "";
        } else {
            obj = "client_attrs";
            obj2 = bVar.f;
        }
        hashMap.put(obj, obj2);
        if (TextUtils.isEmpty(bVar.g)) {
            obj = "cloud_attrs";
            obj2 = "";
        } else {
            obj = "cloud_attrs";
            obj2 = bVar.g;
        }
        hashMap.put(obj, obj2);
        if (!bVar.d.equals("XIAOMI-PASS")) {
            if (!bVar.d.equals("XMPUSH-PASS")) {
                bVar.d.equals("XIAOMI-SASL");
                str2 = null;
                cVar.f(str2);
                bVar2.a(cVar.c(), null);
                aVar.b(bVar2);
            }
        }
        str2 = com.xiaomi.channel.commonutils.string.b.a(bVar.d, null, hashMap, bVar.i);
        cVar.f(str2);
        bVar2.a(cVar.c(), null);
        aVar.b(bVar2);
    }

    public static void a(String str, String str2, com.xiaomi.smack.a aVar) {
        b bVar = new b();
        bVar.c(str2);
        bVar.a(Integer.parseInt(str));
        bVar.a("UBND", null);
        aVar.b(bVar);
    }
}
