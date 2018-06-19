package com.xunlei.common.new_ptl.pay.a;

import com.xunlei.common.new_ptl.pay.XLContractor;
import com.xunlei.common.new_ptl.pay.c.a.c;
import com.xunlei.common.new_ptl.pay.c.b.d;

/* compiled from: XLContractorFactory */
public class a {
    public String a;
    public String b;
    public String c;

    public static XLContractor a(int i) {
        switch (i) {
            case 4096:
                return new c(i.a());
            case 4097:
                return new d(i.a());
            default:
                return 0;
        }
    }

    public a(String str, String str2, String str3) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.a = str;
        this.b = str2;
        this.c = str3;
    }
}
