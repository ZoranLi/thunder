package com.igexin.push.e;

import android.content.ServiceConnection;
import com.igexin.sdk.aidl.IGexinMsgService;

public class b {
    private String a;
    private String b;
    private IGexinMsgService c;
    private ServiceConnection d;
    private String e;

    public String a() {
        return this.a;
    }

    public void a(ServiceConnection serviceConnection) {
        this.d = serviceConnection;
    }

    public void a(IGexinMsgService iGexinMsgService) {
        this.c = iGexinMsgService;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public IGexinMsgService c() {
        return this.c;
    }

    public void c(String str) {
        this.e = str;
    }

    public ServiceConnection d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }
}
