package com.xunlei.common.new_ptl.pay.c;

import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.base.XLUtilTools;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.a.e;
import com.xunlei.common.new_ptl.pay.a.f;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.b.a.a;
import com.xunlei.common.new_ptl.pay.b.a.b;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLPriceParam;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* compiled from: XLPriceTask */
public class c extends h {
    private static final String e = "c";
    private XLPriceParam f = null;
    private e g = null;

    public final void c() {
        String a = this.g.a();
        String str = e;
        StringBuilder stringBuilder = new StringBuilder("generatePriceUrl param = ");
        stringBuilder.append(a);
        XLLog.v(str, stringBuilder.toString());
        byte[] bytes = a.getBytes();
        Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
        a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/price", bytes, headerArr, new b(this) {
            private /* synthetic */ c a;

            {
                this.a = r1;
            }

            public final void a(String str) {
                String g = c.e;
                StringBuilder stringBuilder = new StringBuilder("generatePriceUrl buffer = ");
                stringBuilder.append(str);
                XLLog.v(g, stringBuilder.toString());
                i.a().a(Integer.valueOf(536870913), Integer.valueOf(0), XLPayErrorCode.getErrorDesc(0), this.a.f(), Integer.valueOf(this.a.b()), XLUtilTools.parseJSONPString(str));
            }

            public final void a(Throwable th) {
                String g = c.e;
                StringBuilder stringBuilder = new StringBuilder("generatePriceUrl error = ");
                stringBuilder.append(th.getMessage());
                XLLog.e(g, stringBuilder.toString());
                i.a().a(Integer.valueOf(536870913), Integer.valueOf(h.a(th)), XLPayErrorCode.getErrorDesc(h.a(th)), this.a.f(), Integer.valueOf(this.a.b()), null);
            }
        });
    }

    public final void a(XLPayParam xLPayParam) {
        this.f = (XLPriceParam) xLPayParam;
        this.g = f.a(this.f);
    }

    public final XLPayParam d() {
        return this.f;
    }

    private void a(int i, String str) {
        i.a().a(Integer.valueOf(536870913), Integer.valueOf(i), XLPayErrorCode.getErrorDesc(i), f(), Integer.valueOf(b()), str);
    }
}
