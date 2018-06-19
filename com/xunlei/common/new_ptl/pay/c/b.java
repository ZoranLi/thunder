package com.xunlei.common.new_ptl.pay.c;

import android.text.TextUtils;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLAllContractResp.ContractedResult;
import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.a.e;
import com.xunlei.common.new_ptl.pay.a.f;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.b.a.a;
import com.xunlei.common.new_ptl.pay.param.XLContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* compiled from: XLContractQueryTask */
public class b extends h {
    private static final String e = "b";
    private static int h = 0;
    private static int i = 1;
    private XLContractParam f;
    private XLOnPayListener g;
    private int j;
    private e k;

    public b() {
        this.f = null;
        this.g = null;
        this.j = 0;
        this.k = null;
        this.a = 536870914;
    }

    public final void c() {
        if (this.j == 0) {
            String d = this.k.d(this.f.mPayType);
            String str = e;
            StringBuilder stringBuilder = new StringBuilder("generateQuerycontractUrl wx param = ");
            stringBuilder.append(d);
            XLLog.v(str, stringBuilder.toString());
            byte[] bytes = d.getBytes();
            Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
            a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/monthQuerySignServlet", bytes, headerArr, new 1(this));
        }
    }

    public final void a(XLPayParam xLPayParam) {
        this.f = (XLContractParam) xLPayParam;
        this.a = 536870914;
        this.k = f.a(this.f);
    }

    public final XLPayParam d() {
        return this.f;
    }

    private void b(XLOnPayListener xLOnPayListener) {
        this.g = xLOnPayListener;
    }

    private void h() {
        String d = this.k.d(this.f.mPayType);
        String str = e;
        StringBuilder stringBuilder = new StringBuilder("generateQuerycontractUrl wx param = ");
        stringBuilder.append(d);
        XLLog.v(str, stringBuilder.toString());
        byte[] bytes = d.getBytes();
        Header[] headerArr = new Header[]{new BasicHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)};
        a.a().a("https://agent-paycenter-ssl.xunlei.com/newsdk/monthQuerySignServlet", bytes, headerArr, new 1(this));
    }

    private void a(int i, List<ContractedResult> list) {
        XLAllContractResp xLAllContractResp = new XLAllContractResp();
        xLAllContractResp.mContractedLists = list;
        if (TextUtils.isEmpty(this.c) != null) {
            this.c = XLPayErrorCode.getErrorDesc(i);
        }
        if (this.g == null) {
            i.a().a(Integer.valueOf(this.a), Integer.valueOf(i), this.c, f(), Integer.valueOf(b()), xLAllContractResp);
            return;
        }
        this.g.onQueryContract(i, this.c, f(), b(), xLAllContractResp);
    }

    static /* synthetic */ void a(b bVar, int i, int i2, List list) {
        XLAllContractResp xLAllContractResp = new XLAllContractResp();
        xLAllContractResp.mContractedLists = list;
        if (TextUtils.isEmpty(bVar.c) != 0) {
            bVar.c = XLPayErrorCode.getErrorDesc(i);
        }
        if (bVar.g == 0) {
            i.a().a(Integer.valueOf(bVar.a), Integer.valueOf(i), bVar.c, bVar.f(), Integer.valueOf(bVar.b()), xLAllContractResp);
            return;
        }
        bVar.g.onQueryContract(i, bVar.c, bVar.f(), bVar.b(), xLAllContractResp);
    }
}
