package com.alipay.android.phone.mrpc.core;

import android.os.Looper;
import com.alipay.android.phone.mrpc.core.a.d;
import com.alipay.android.phone.mrpc.core.a.e;
import com.alipay.android.phone.mrpc.core.a.f;
import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.ResetCookie;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class z {
    private static final ThreadLocal<Object> a = new ThreadLocal();
    private static final ThreadLocal<Map<String, Object>> b = new ThreadLocal();
    private byte c = (byte) 0;
    private AtomicInteger d;
    private x e;

    public z(x xVar) {
        this.e = xVar;
        this.d = new AtomicInteger();
    }

    public final Object a(Method method, Object[] objArr) {
        Object obj = (Looper.myLooper() == null || Looper.myLooper() != Looper.getMainLooper()) ? null : 1;
        if (obj != null) {
            throw new IllegalThreadStateException("can't in main thread call rpc .");
        }
        OperationType operationType = (OperationType) method.getAnnotation(OperationType.class);
        boolean z = method.getAnnotation(ResetCookie.class) != null;
        Type genericReturnType = method.getGenericReturnType();
        method.getAnnotations();
        a.set(null);
        b.set(null);
        if (operationType == null) {
            throw new IllegalStateException("OperationType must be set.");
        }
        String value = operationType.value();
        int incrementAndGet = this.d.incrementAndGet();
        try {
            if (this.c == (byte) 0) {
                f eVar = new e(incrementAndGet, value, objArr);
                if (b.get() != null) {
                    eVar.a(b.get());
                }
                byte[] bArr = (byte[]) new j(this.e.a(), method, incrementAndGet, value, eVar.a(), z).a();
                b.set(null);
                Object a = new d(genericReturnType, bArr).a();
                if (genericReturnType != Void.TYPE) {
                    a.set(a);
                }
            }
            return a.get();
        } catch (RpcException e) {
            e.setOperationType(value);
            throw e;
        }
    }
}
