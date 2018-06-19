package com.alipay.apmobilesecuritysdk.b;

public final class a {
    private static a b = new a();
    private int a = 0;

    public static a a() {
        return b;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int b() {
        return this.a;
    }

    public final String c() {
        if (com.alipay.b.a.a.a.a.b(null)) {
            return null;
        }
        switch (this.a) {
            case 1:
                return "http://mobilegw.stable.alipay.net/mgw.htm";
            case 2:
                return "https://mobilegw.alipay.com/mgw.htm";
            case 3:
                return "http://mobilegw-1-64.test.alipay.net/mgw.htm";
            case 4:
                return "http://mobilegw.aaa.alipay.net/mgw.htm";
            default:
                return "https://mobilegw.alipay.com/mgw.htm";
        }
    }
}
