package com.xunlei.common.new_ptl.pay.c.a;

import com.xunlei.common.new_ptl.pay.XLContractor;
import com.xunlei.common.new_ptl.pay.a.h;
import com.xunlei.common.new_ptl.pay.a.i;
import com.xunlei.common.new_ptl.pay.param.XLAliContractQueryParam;
import com.xunlei.common.new_ptl.pay.param.XLAliDisContractParam;
import com.xunlei.common.new_ptl.pay.param.XLAliPayContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;

/* compiled from: XLAliPayContractor */
public final class c implements XLContractor<XLAliPayContractParam, XLAliContractQueryParam, XLAliDisContractParam> {
    private i a = null;

    public final /* synthetic */ int userContract(Object obj, Object obj2) {
        XLAliPayContractParam xLAliPayContractParam = (XLAliPayContractParam) obj;
        h bVar = new b();
        bVar.a();
        bVar.a(xLAliPayContractParam);
        bVar.a(obj2);
        this.a.a(bVar);
        this.a.k().registerStatReq(bVar.b());
        return bVar.b();
    }

    public final /* synthetic */ int userDisContract(XLPayParam xLPayParam, Object obj) {
        XLAliDisContractParam xLAliDisContractParam = (XLAliDisContractParam) xLPayParam;
        h aVar = new a();
        aVar.a();
        aVar.a(xLAliDisContractParam);
        aVar.a(obj);
        this.a.a(aVar);
        this.a.k().registerStatReq(aVar.b());
        return aVar.b();
    }

    public final /* synthetic */ int userQuery(Object obj, Object obj2) {
        XLAliContractQueryParam xLAliContractQueryParam = (XLAliContractQueryParam) obj;
        h dVar = new d();
        dVar.a();
        dVar.a(xLAliContractQueryParam);
        dVar.a(obj2);
        this.a.a(dVar);
        this.a.k().registerStatReq(dVar.b());
        return dVar.b();
    }

    public c(i iVar) {
        this.a = iVar;
    }

    private int a(XLAliPayContractParam xLAliPayContractParam, Object obj) {
        h bVar = new b();
        bVar.a();
        bVar.a(xLAliPayContractParam);
        bVar.a(obj);
        this.a.a(bVar);
        this.a.k().registerStatReq(bVar.b());
        return bVar.b();
    }

    private int a(XLAliContractQueryParam xLAliContractQueryParam, Object obj) {
        h dVar = new d();
        dVar.a();
        dVar.a(xLAliContractQueryParam);
        dVar.a(obj);
        this.a.a(dVar);
        this.a.k().registerStatReq(dVar.b());
        return dVar.b();
    }

    private int a(XLAliDisContractParam xLAliDisContractParam, Object obj) {
        h aVar = new a();
        aVar.a();
        aVar.a(xLAliDisContractParam);
        aVar.a(obj);
        this.a.a(aVar);
        this.a.k().registerStatReq(aVar.b());
        return aVar.b();
    }
}
