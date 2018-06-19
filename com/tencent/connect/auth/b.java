package com.tencent.connect.auth;

import com.tencent.tauth.IUiListener;
import java.util.HashMap;

/* compiled from: ProGuard */
public class b {
    public static b a = null;
    static final /* synthetic */ boolean d = true;
    private static int e;
    public HashMap<String, a> b = new HashMap();
    public final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /* compiled from: ProGuard */
    public static class a {
        public IUiListener a;
        public a b;
        public String c;
    }

    public static b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public static int b() {
        int i = e + 1;
        e = i;
        return i;
    }

    public String a(a aVar) {
        int b = b();
        try {
            this.b.put(String.valueOf(b), aVar);
        } catch (a aVar2) {
            aVar2.printStackTrace();
        }
        return String.valueOf(b);
    }

    public String c() {
        int ceil = (int) Math.ceil((Math.random() * 20.0d) + 3.0d);
        char[] toCharArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = toCharArray.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < ceil; i++) {
            stringBuffer.append(toCharArray[(int) (Math.random() * ((double) length))]);
        }
        return stringBuffer.toString();
    }
}
