package com.taobao.tao.remotebusiness.listener;

import com.taobao.tao.remotebusiness.MtopBusiness;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import mtopsdk.mtop.common.k;

final class a implements InvocationHandler {
    private MtopFinishListenerImpl a;
    private MtopProgressListenerImpl b;
    private MtopBusiness c;
    private k d;

    public a(MtopBusiness mtopBusiness, k kVar) {
        this.a = new MtopFinishListenerImpl(mtopBusiness, kVar);
        this.c = mtopBusiness;
        this.d = kVar;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        if (method.getName().equals("onFinished")) {
            obj = this.a;
        } else {
            if (!method.getName().equals("onDataReceived")) {
                if (!method.getName().equals("onHeader")) {
                    return null;
                }
            }
            if (this.b == null) {
                this.b = new MtopProgressListenerImpl(this.c, this.d);
            }
            obj = this.b;
        }
        return method.invoke(obj, objArr);
    }
}
