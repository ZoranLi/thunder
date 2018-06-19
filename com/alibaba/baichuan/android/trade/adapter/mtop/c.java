package com.alibaba.baichuan.android.trade.adapter.mtop;

import com.alibaba.baichuan.android.trade.adapter.mtop.b.a;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import mtopsdk.mtop.domain.MtopResponse;

final class c implements IRemoteBaseListener {
    final /* synthetic */ a a;
    final /* synthetic */ NetworkRequest b;
    final /* synthetic */ a c;

    c(a aVar, a aVar2, NetworkRequest networkRequest) {
        this.c = aVar;
        this.a = aVar2;
        this.b = networkRequest;
    }

    public final void onSuccess(int i, MtopResponse mtopResponse, mtopsdk.mtop.domain.a aVar, Object obj) {
        a.a(mtopResponse);
        this.a.a(a.b(mtopResponse));
    }

    public final void onError(int i, MtopResponse mtopResponse, Object obj) {
        a.a(mtopResponse);
        this.a.b(a.b(mtopResponse));
    }

    public final void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
        a.a(mtopResponse);
        this.a.b(a.b(mtopResponse));
    }
}
