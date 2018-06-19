package com.qihoo360.loader2;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.qihoo360.i.Factory;
import com.qihoo360.i.Factory2;
import com.qihoo360.i.IPluginManager;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.a.b;
import com.qihoo360.replugin.b.a;
import com.qihoo360.replugin.b.c;
import java.util.HashMap;

/* compiled from: PMF */
public final class n {
    static Context a;
    public static aj b;

    public static final void a() {
        aj ajVar = b;
        ajVar.d = aj.class.getClassLoader();
        for (o a : ajVar.e.values()) {
            a.a(ajVar.a, ajVar.d, ajVar.n);
        }
        if (aa.a() && !TextUtils.isEmpty(ajVar.h)) {
            o oVar = (o) ajVar.e.get(ajVar.h);
            if (oVar != null) {
                boolean a2 = oVar.a(3, true);
                if (!a2 && c.a) {
                    StringBuilder stringBuilder = new StringBuilder("failed to load default plugin=");
                    stringBuilder.append(ajVar.h);
                    c.a("ws001", stringBuilder.toString());
                }
                if (a2) {
                    ajVar.i = oVar;
                    ajVar.m.c = oVar;
                }
            }
        }
    }

    public static final void a(Activity activity, Intent intent) {
        activity.finish();
        try {
            CharSequence className;
            y yVar = new y(intent);
            ComponentName component = yVar.a.getComponent();
            if (component != null) {
                className = component.getClassName();
            } else {
                className = null;
            }
            if (TextUtils.isEmpty(className)) {
                new StringBuilder("f.a f: orig=nul i=").append(intent);
                return;
            }
            String e = yVar.e();
            if (TextUtils.isEmpty(e)) {
                new StringBuilder("f.a f: c=nul i=").append(intent);
                return;
            }
            String a = yVar.a();
            if (TextUtils.isEmpty(a)) {
                new StringBuilder("f.a f: n=nul i=").append(intent);
                return;
            }
            String b = yVar.b();
            if (TextUtils.isEmpty(b)) {
                new StringBuilder("f.a f: t=nul i=").append(intent);
                return;
            }
            int c = yVar.c();
            if (aa.a(c)) {
                c = yVar.a("counter:", 0);
                if (c >= 0) {
                    if (c < 10) {
                        a aVar;
                        a aVar2;
                        yVar.a(c + 1);
                        t tVar = b.m.b;
                        synchronized (tVar.a) {
                            HashMap hashMap = tVar.b;
                            aVar = (a) hashMap.get(className);
                            aVar2 = (a) hashMap.get(e);
                        }
                        if (aVar != null && aVar2 != null) {
                            if (aVar2.b == 0) {
                                a.a(aVar2, a, b);
                            } else if (!a.b(aVar2, a, b)) {
                                a.a(aVar2);
                                a.a(aVar2, a, b);
                            }
                            if (aVar != aVar2) {
                                if (c.a) {
                                    StringBuilder stringBuilder = new StringBuilder("forward fly: container=");
                                    stringBuilder.append(e);
                                    stringBuilder.append(" plugin=");
                                    stringBuilder.append(a);
                                    stringBuilder.append(" activity=");
                                    stringBuilder.append(b);
                                    c.b("ws001", stringBuilder.toString());
                                }
                                aVar.b = 0;
                                aVar.c = null;
                                aVar.d = null;
                                aVar.a();
                                aVar.e = System.currentTimeMillis();
                            } else if (c.a) {
                                StringBuilder stringBuilder2 = new StringBuilder("forward registered: container=");
                                stringBuilder2.append(e);
                                stringBuilder2.append(" plugin=");
                                stringBuilder2.append(a);
                                stringBuilder2.append(" activity=");
                                stringBuilder2.append(b);
                                c.b("ws001", stringBuilder2.toString());
                            }
                            y yVar2 = new y(intent);
                            yVar2.a("plugin:", aVar2.c);
                            yVar2.a("activity:", aVar2.d);
                            yVar2.d();
                            yVar2.a("container:", aVar2.a);
                            intent.putExtra(IPluginManager.KEY_COMPATIBLE, true);
                            intent.setComponent(new ComponentName(b.c, aVar2.a));
                            activity.startActivity(intent);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            activity = new StringBuilder("f.a f: p=");
            activity.append(c);
            activity.append(" i=");
            activity.append(intent);
        } catch (Activity activity2) {
            new StringBuilder("f.a f: ").append(activity2.getMessage());
        }
    }

    public static final void a(Application application) {
        a = application;
        aa.b();
        aj ajVar = new aj(application);
        b = ajVar;
        RePlugin.getConfig();
        if (a.a) {
            if (b.e) {
                ajVar.a();
            } else {
                ajVar.b();
            }
        } else if (b.f) {
            ajVar.a();
            b.c();
        } else {
            ajVar.b();
        }
        ai.a(ajVar.e);
        if (c.a) {
            for (o oVar : ajVar.e.values()) {
                StringBuilder stringBuilder = new StringBuilder("plugin: p=");
                stringBuilder.append(oVar.h);
                c.a("ws001", stringBuilder.toString());
            }
        }
        Factory.sPluginManager = b.n;
        Factory2.sPLProxy = b.o;
        com.qihoo360.a.a.b.a(application);
    }
}
