package com.xiaomi.push.service;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.service.XMPushService.h;
import com.xiaomi.push.service.ap.c;
import java.util.Collection;

public class v extends h {
    private XMPushService b;
    private byte[] c;
    private String d;
    private String e;
    private String f;

    public v(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.b = xMPushService;
        this.d = str;
        this.c = bArr;
        this.e = str2;
        this.f = str3;
    }

    public void a() {
        s a = t.a(this.b);
        if (a == null) {
            try {
                a = t.a(this.b, this.d, this.e, this.f);
            } catch (Throwable e) {
                b.a(e);
            }
        }
        if (a == null) {
            b.d("no account for mipush");
            w.a(this.b, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        ap.b a2;
        Collection c = ap.a().c("5");
        if (c.isEmpty()) {
            a2 = a.a(this.b);
            af.a(this.b, a2);
            ap.a().a(a2);
        } else {
            a2 = (ap.b) c.iterator().next();
        }
        if (this.b.f()) {
            try {
                if (a2.m == c.binded) {
                    af.a(this.b, this.d, this.c);
                    return;
                }
                if (a2.m == c.unbind) {
                    XMPushService xMPushService = this.b;
                    XMPushService xMPushService2 = this.b;
                    xMPushService2.getClass();
                    xMPushService.a(new a(xMPushService2, a2));
                }
                return;
            } catch (Exception e2) {
                b.a(e2);
                this.b.a(10, e2);
                return;
            }
        }
        this.b.a(true);
    }

    public String b() {
        return "register app";
    }
}
