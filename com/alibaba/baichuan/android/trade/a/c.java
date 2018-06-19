package com.alibaba.baichuan.android.trade.a;

import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.adapter.mtop.NetworkRequest;
import com.alibaba.baichuan.android.trade.adapter.mtop.NetworkResponse;
import com.alibaba.baichuan.android.trade.adapter.mtop.a;
import com.alibaba.baichuan.android.trade.adapter.ut.e;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.Map;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.MtopResponse;

public abstract class c {
    protected String a = "";
    protected String b = "1.0";
    protected boolean c = false;
    protected Boolean d = Boolean.valueOf(false);
    protected boolean e = false;
    protected boolean f = true;
    protected int g = -1;

    public final NetworkRequest b(Map map) {
        NetworkRequest networkRequest = new NetworkRequest();
        networkRequest.apiName = this.a;
        networkRequest.apiVersion = this.b;
        networkRequest.needLogin = this.c;
        networkRequest.needWua = this.d.booleanValue();
        networkRequest.needAuth = this.e;
        networkRequest.isPost = this.f;
        networkRequest.timeOut = this.g;
        networkRequest.requestType = networkRequest.hashCode();
        networkRequest.paramMap = map;
        return networkRequest;
    }

    public final NetworkResponse a(Map map) {
        a aVar = a.a;
        NetworkRequest b = b(map);
        MtopBusiness build = MtopBusiness.build(a.a(b), com.alibaba.baichuan.android.trade.e.a.g().e());
        if (b.needWua) {
            build.useWua();
        }
        if (b.needAuth && !AlibcContext.i) {
            build.setNeedAuth(b.authParams, true);
        }
        if (b.isPost != null) {
            build.reqMethod(MethodEnum.POST);
        }
        MtopResponse syncRequest = build.syncRequest();
        a.a(syncRequest);
        if (syncRequest.isApiSuccess()) {
            e.a("InvokeMtop");
        } else {
            String str;
            String retCode = syncRequest.getRetCode();
            StringBuilder stringBuilder = new StringBuilder("errmsg = ");
            stringBuilder.append(syncRequest.getRetMsg());
            stringBuilder.append(" ,api = ");
            stringBuilder.append(syncRequest.getApi());
            String stringBuilder2 = stringBuilder.toString();
            if (syncRequest.isSessionInvalid()) {
                str = "session 失效， do autologin or login business";
            } else {
                if (!(syncRequest.isSystemError() || syncRequest.isNetworkError() || syncRequest.isExpiredRequest() || syncRequest.is41XResult() || syncRequest.isApiLockedResult())) {
                    if (!syncRequest.isMtopSdkError()) {
                        str = "业务错误 ";
                    }
                }
                str = "系统错误，网络错误，防刷，防雪崩 ";
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append(stringBuilder2);
            stringBuilder2 = stringBuilder3.toString();
            stringBuilder3 = new StringBuilder("1501");
            stringBuilder3.append(retCode);
            e.b("InvokeMtop", stringBuilder2, stringBuilder3.toString());
        }
        return a.b(syncRequest);
    }
}
