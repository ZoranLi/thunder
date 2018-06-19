package com.xunlei.common.new_ptl.pay.c.b;

import com.xunlei.common.new_ptl.pay.XLContractor;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLWxContractParam;
import com.xunlei.common.new_ptl.pay.param.XLWxContractQueryParam;
import com.xunlei.common.new_ptl.pay.param.XLWxDisContractParam;

/* compiled from: XLWxContractor */
public final class d implements XLContractor<XLWxContractParam, XLWxContractQueryParam, XLWxDisContractParam> {
    private i a = null;

    public final /* synthetic */ int userContract(Object obj, Object obj2) {
        XLWxContractParam xLWxContractParam = (XLWxContractParam) obj;
        h cVar = new c();
        cVar.a();
        cVar.a(xLWxContractParam);
        cVar.a(obj2);
        this.a.a(cVar);
        this.a.k().registerStatReq(cVar.b());
        return cVar.b();
    }

    public final /* synthetic */ int userDisContract(XLPayParam xLPayParam, Object obj) {
        XLWxDisContractParam xLWxDisContractParam = (XLWxDisContractParam) xLPayParam;
        h aVar = new a();
        aVar.a();
        aVar.a(xLWxDisContractParam);
        aVar.a(obj);
        this.a.a(aVar);
        this.a.k().registerStatReq(aVar.b());
        return aVar.b();
    }

    public final /* synthetic */ int userQuery(Object obj, Object obj2) {
        XLWxContractQueryParam xLWxContractQueryParam = (XLWxContractQueryParam) obj;
        h bVar = new b();
        bVar.a();
        bVar.a(xLWxContractQueryParam);
        bVar.a(obj2);
        this.a.a(bVar);
        this.a.k().registerStatReq(bVar.b());
        return bVar.b();
    }

    public d(i iVar) {
        this.a = iVar;
    }

    private int a(XLWxContractParam xLWxContractParam, Object obj) {
        h cVar = new c();
        cVar.a();
        cVar.a(xLWxContractParam);
        cVar.a(obj);
        this.a.a(cVar);
        this.a.k().registerStatReq(cVar.b());
        return cVar.b();
    }

    private int a(XLWxContractQueryParam xLWxContractQueryParam, Object obj) {
        h bVar = new b();
        bVar.a();
        bVar.a(xLWxContractQueryParam);
        bVar.a(obj);
        this.a.a(bVar);
        this.a.k().registerStatReq(bVar.b());
        return bVar.b();
    }

    private int a(XLWxDisContractParam xLWxDisContractParam, Object obj) {
        h aVar = new a();
        aVar.a();
        aVar.a(xLWxDisContractParam);
        aVar.a(obj);
        this.a.a(aVar);
        this.a.k().registerStatReq(aVar.b());
        return aVar.b();
    }
}
