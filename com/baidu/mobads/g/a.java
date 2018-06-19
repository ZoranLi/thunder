package com.baidu.mobads.g;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class a {
    private static IXAdContainerFactory e;
    public double a = 0.1d;
    private Context b;
    private Class<?> c = null;
    private double d;
    private Boolean f;
    private IXAdLogger g = XAdSDKFoundationFacade.getInstance().getAdLogger();

    public a(Class<?> cls, Context context, double d, Boolean bool) {
        this.c = cls;
        this.b = context;
        this.d = d;
        this.f = bool;
    }

    public IXAdContainerFactory a() {
        if (e == null) {
            try {
                e = (IXAdContainerFactory) this.c.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.b});
                this.a = e.getRemoteVersion();
                e.setDebugMode(this.f);
                e.handleShakeVersion(this.d, "8.7036");
            } catch (Throwable th) {
                this.g.w("XAdContainerFactoryBuilder", th.getMessage());
                StringBuilder stringBuilder = new StringBuilder("newXAdContainerFactory() failed, possibly API incompatible: ");
                stringBuilder.append(th.getMessage());
                com.baidu.mobads.g.g.a aVar = new com.baidu.mobads.g.g.a(stringBuilder.toString());
            }
        }
        return e;
    }

    public void b() {
        e = null;
    }
}
