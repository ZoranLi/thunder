package com.qihoo360.loader2;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Intent;
import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.qihoo360.i.IPluginManager;
import com.qihoo360.replugin.b.c;
import com.qihoo360.replugin.g;
import com.qihoo360.replugin.model.PluginInfo;
import com.qihoo360.replugin.packages.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PluginProcessMain */
public final class ac {
    static HashMap<String, IBinder> a = new HashMap();
    private static j b;
    private static j c;
    private static final b[] d = new b[2];
    private static final Map<String, a> e = new HashMap();
    private static final Object f = new Object();
    private static boolean g;
    private static long h;
    private static final Runnable i = new ad();

    /* compiled from: PluginProcessMain */
    private static final class a implements DeathRecipient {
        String a;
        String b;
        int c;
        int d;
        IBinder e;
        i f;
        private final d g;

        public a(d dVar) {
            this.g = dVar;
        }

        public final void binderDied() {
            ac.a(this, this.g);
        }

        public final String toString() {
            if (!c.a) {
                return super.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append(" {name=");
            stringBuilder.append(this.a);
            stringBuilder.append(" plugin=");
            stringBuilder.append(this.b);
            stringBuilder.append(" pid=");
            stringBuilder.append(this.c);
            stringBuilder.append(" index=");
            stringBuilder.append(this.d);
            stringBuilder.append(" binder=");
            stringBuilder.append(this.e);
            stringBuilder.append(" client=");
            stringBuilder.append(this.f);
            stringBuilder.append(h.d);
            return stringBuilder.toString();
        }
    }

    /* compiled from: PluginProcessMain */
    private static final class b {
        final int a;
        int b = 0;
        long c;
        String d;
        int e;
        IBinder f;
        i g;
        int h;
        int i;
        int j;

        b(int i) {
            this.a = i;
        }

        final void a(String str) {
            this.b = 1;
            this.c = System.currentTimeMillis();
            this.d = str;
            this.e = 0;
            this.f = null;
            this.g = null;
            this.h = 0;
            this.i = 0;
            this.j = 0;
        }

        final void a() {
            this.b = 4;
            this.e = 0;
            this.f = null;
            this.g = null;
        }

        public final String toString() {
            if (!c.a) {
                return super.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append(" {index=");
            stringBuilder.append(this.a);
            stringBuilder.append(" state=");
            stringBuilder.append(this.b);
            stringBuilder.append(" mobified=");
            stringBuilder.append(this.c);
            stringBuilder.append(" plugin=");
            stringBuilder.append(this.d);
            stringBuilder.append(" pid=");
            stringBuilder.append(this.e);
            stringBuilder.append(" binder=");
            stringBuilder.append(this.f);
            stringBuilder.append(" client=");
            stringBuilder.append(this.g);
            stringBuilder.append(" activities=");
            stringBuilder.append(this.h);
            stringBuilder.append(" services=");
            stringBuilder.append(this.i);
            stringBuilder.append(" binders=");
            stringBuilder.append(this.j);
            stringBuilder.append(h.d);
            return stringBuilder.toString();
        }
    }

    static final void e() {
    }

    static /* synthetic */ void f() {
    }

    static {
        for (int i = 0; i < 2; i++) {
            d[i] = new b(i);
        }
    }

    static final String a() {
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        Iterator it = e.values().iterator();
        while (true) {
            int i = 0;
            if (!it.hasNext()) {
                break;
            }
            try {
                i iVar = ((a) it.next()).f;
                if (iVar != null) {
                    Object e = iVar.e();
                    if (!TextUtils.isEmpty(e)) {
                        JSONArray jSONArray3 = new JSONArray(e);
                        int length = jSONArray3.length();
                        if (length > 0) {
                            for (int i2 = 0; i2 < length; i2++) {
                                jSONArray.put(jSONArray3.getJSONObject(i2));
                            }
                        }
                    }
                    Object d = iVar.d();
                    if (!TextUtils.isEmpty(d)) {
                        JSONArray jSONArray4 = new JSONArray(d);
                        int length2 = jSONArray4.length();
                        if (length2 > 0) {
                            while (i < length2) {
                                jSONArray2.put(jSONArray4.getJSONObject(i));
                                i++;
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        JSONArray jSONArray5 = new JSONArray();
        for (PluginInfo pluginInfo : m.a(false)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(pluginInfo.getName(), pluginInfo.toString());
                jSONArray5.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("activity", jSONArray);
            jSONObject2.put(NotificationCompat.CATEGORY_SERVICE, jSONArray2);
            jSONObject2.put(IPluginManager.KEY_PLUGIN, jSONArray5);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject2.toString();
    }

    static final void a(j jVar) {
        b = jVar;
        try {
            com.qihoo360.replugin.packages.c.a(b);
        } catch (j jVar2) {
            jVar2.printStackTrace();
        }
    }

    public static final j c() {
        if (b != null) {
            return b;
        }
        if (c == null) {
            if (c.a && com.qihoo360.replugin.a.b.e) {
                c.d("ws001", "插件框架未正常初始化");
                throw new RuntimeException("插件框架未正常初始化");
            }
            b();
        }
        return c;
    }

    public static final long d() {
        long j;
        synchronized (f) {
            if (!g) {
                g = true;
                if (com.qihoo360.replugin.a.b.e) {
                    h = System.currentTimeMillis();
                    if (c.a) {
                        StringBuilder stringBuilder = new StringBuilder("generate cookie: ");
                        stringBuilder.append(h);
                        c.a("ws001", stringBuilder.toString());
                    }
                }
            }
            j = h;
        }
        return j;
    }

    static final i a(String str, int i, PluginBinderInfo pluginBinderInfo) {
        synchronized (d) {
            for (a aVar : e.values()) {
                if (i == -1) {
                    if (TextUtils.equals(aVar.b, "ui")) {
                    }
                } else if (com.qihoo360.replugin.component.process.a.a(i)) {
                    if (TextUtils.equals(aVar.b, c(i))) {
                    }
                } else if (TextUtils.equals(aVar.b, str)) {
                }
                if (a(aVar) == null) {
                    return null;
                } else if (aVar.e.pingBinder() == null) {
                    return null;
                } else {
                    pluginBinderInfo.b = aVar.c;
                    pluginBinderInfo.c = aVar.d;
                    str = aVar.f;
                    return str;
                }
            }
            return null;
        }
    }

    private static String c(int i) {
        StringBuilder stringBuilder = new StringBuilder(":p");
        stringBuilder.append(i + 100);
        return stringBuilder.toString();
    }

    static final i a(int i, PluginBinderInfo pluginBinderInfo) {
        synchronized (d) {
            for (a aVar : e.values()) {
                if (aVar.c == i) {
                    if (a(aVar) == 0) {
                        return null;
                    } else if (aVar.e.pingBinder() == 0) {
                        return null;
                    } else {
                        pluginBinderInfo.b = aVar.c;
                        pluginBinderInfo.c = aVar.d;
                        i = aVar.f;
                        return i;
                    }
                }
            }
            return null;
        }
    }

    static final void a(String str, Intent intent, boolean z) {
        synchronized (d) {
            for (a aVar : e.values()) {
                if ((str == null || str.length() <= 0 || TextUtils.equals(aVar.a, str)) && a(aVar)) {
                    if (c.a) {
                        StringBuilder stringBuilder = new StringBuilder("sendIntent2Process name=");
                        stringBuilder.append(aVar.a);
                        c.a("ws001", stringBuilder.toString());
                    }
                    if (z) {
                        try {
                            aVar.f.b(intent);
                        } catch (Throwable th) {
                            stringBuilder = new StringBuilder("s.i2pr e: n=");
                            stringBuilder.append(aVar.a);
                            stringBuilder.append(": ");
                            stringBuilder.append(th.getMessage());
                        }
                    } else {
                        aVar.f.a(intent);
                    }
                }
            }
        }
    }

    static final void b(String str, Intent intent, boolean z) {
        if (str != null) {
            if (str.length() > 0) {
                synchronized (d) {
                    for (a aVar : e.values()) {
                        if (TextUtils.equals(aVar.b, str) && a(aVar)) {
                            if (z) {
                                try {
                                    aVar.f.b(intent);
                                } catch (Throwable th) {
                                    new StringBuilder("s.i2pl e: ").append(th.getMessage());
                                }
                            } else {
                                aVar.f.a(intent);
                            }
                        }
                    }
                }
            }
        }
    }

    static final boolean a(String str) {
        synchronized (d) {
            for (a aVar : e.values()) {
                if (TextUtils.equals(aVar.a, str)) {
                    str = a(aVar);
                    return str;
                }
            }
            return null;
        }
    }

    private static boolean a(a aVar) {
        if (!(aVar == null || aVar.e == null)) {
            if (aVar.f != null) {
                if (aVar.e.isBinderAlive() == null) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    @Deprecated
    static final int a(String str, int i) {
        if (!"ui".equals(str)) {
            if (i != -1) {
                if (com.qihoo360.replugin.component.process.a.a(i)) {
                    return i;
                }
                if (ai.a(str) == 0) {
                    if (c.a != 0) {
                        StringBuilder stringBuilder = new StringBuilder("alloc process: plugin not found: name=");
                        stringBuilder.append(str);
                        c.a("ws001", stringBuilder.toString());
                    }
                    return Integer.MIN_VALUE;
                }
                synchronized (d) {
                    str = c(str);
                }
                return str;
            }
        }
        return -1;
    }

    static final String a(int i, String str, int i2, IBinder iBinder, i iVar, String str2, d dVar) {
        String str3;
        synchronized (d) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("attach process: pid=");
                stringBuilder.append(i);
                stringBuilder.append(" index=");
                stringBuilder.append(i2);
                stringBuilder.append(" binder=");
                stringBuilder.append(iVar);
                c.a("ws001", stringBuilder.toString());
            }
            str3 = null;
            if (i2 == -1) {
                if (c.a != null) {
                    c.a("ws001", "attach process: ui");
                }
                str3 = "ui";
            } else if (com.qihoo360.replugin.component.process.a.a(i2)) {
                str3 = c(i2);
            } else if (aa.b(i2)) {
                b bVar = d[i2];
                if (!TextUtils.isEmpty(str2)) {
                    if (c.a) {
                        c.a("ws001", "attach process: allocate now");
                    }
                    bVar.a(str2);
                }
                if (bVar.b == 1) {
                    bVar.b = 2;
                    bVar.e = i;
                    bVar.f = iBinder;
                    bVar.g = iVar;
                    str3 = bVar.d;
                } else if (c.a != null) {
                    StringBuilder stringBuilder2 = new StringBuilder("attach process: state not allocated: state=");
                    stringBuilder2.append(bVar.b);
                    c.a("ws001", stringBuilder2.toString());
                }
            } else if (c.a != null) {
                StringBuilder stringBuilder3 = new StringBuilder("attach process: invalid index=");
                stringBuilder3.append(i2);
                c.a("ws001", stringBuilder3.toString());
            }
            str2 = new a(dVar);
            str2.a = str;
            str2.b = str3;
            str2.c = i;
            str2.d = i2;
            str2.e = iBinder;
            str2.f = iVar;
            e.put(str, str2);
            try {
                str2.e.linkToDeath(str2, null);
            } catch (int i3) {
                new StringBuilder("ap l2d: ").append(i3.getMessage());
            }
        }
        return str3;
    }

    static final boolean a(int i, int i2, String str, String str2, String str3) {
        synchronized (d) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("reg activity: pid=");
                stringBuilder.append(i);
                stringBuilder.append(" index=");
                stringBuilder.append(i2);
                stringBuilder.append(" plugin=");
                stringBuilder.append(str);
                stringBuilder.append(" activity=");
                stringBuilder.append(str2);
                stringBuilder.append(" container=");
                stringBuilder.append(str3);
                c.a("ws001", stringBuilder.toString());
            }
            i = 1;
            if (i2 >= 0) {
                if (i2 < d.length) {
                    i2 = d[i2];
                    i2.h += 1;
                    i2.c = System.currentTimeMillis();
                    if (c.a != null) {
                        str2 = new StringBuilder("activities=");
                        str2.append(i2.h);
                        str2.append(" services=");
                        str2.append(i2.i);
                        str2.append(" binders=");
                        str2.append(i2.j);
                        c.a("ws001", str2.toString());
                    }
                }
            }
            if (c.a != 0) {
                str = new StringBuilder("reg activity: invalid index=");
                str.append(i2);
                c.a("ws001", str.toString());
            }
            i = 0;
        }
        return i;
    }

    static final boolean b(int i, int i2, String str, String str2, String str3) {
        synchronized (d) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("unreg activity: pid=");
                stringBuilder.append(i);
                stringBuilder.append(" index=");
                stringBuilder.append(i2);
                stringBuilder.append(" plugin=");
                stringBuilder.append(str);
                stringBuilder.append(" activity=");
                stringBuilder.append(str2);
                stringBuilder.append(" container=");
                stringBuilder.append(str3);
                c.a("ws001", stringBuilder.toString());
            }
            i = 1;
            if (i2 >= 0) {
                if (i2 < d.length) {
                    i2 = d[i2];
                    i2.h -= 1;
                    i2.c = System.currentTimeMillis();
                    if (c.a != null) {
                        str2 = new StringBuilder("activities=");
                        str2.append(i2.h);
                        str2.append(" services=");
                        str2.append(i2.i);
                        str2.append(" binders=");
                        str2.append(i2.j);
                        c.a("ws001", str2.toString());
                    }
                }
            }
            if (c.a != 0) {
                str = new StringBuilder("unreg activity: invalid index=");
                str.append(i2);
                c.a("ws001", str.toString());
            }
            i = 0;
        }
        return i;
    }

    static final boolean a(int i, int i2, String str, String str2) {
        synchronized (d) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("reg service: pid=");
                stringBuilder.append(i);
                stringBuilder.append(" index=");
                stringBuilder.append(i2);
                stringBuilder.append(" plugin=");
                stringBuilder.append(str);
                stringBuilder.append(" service=");
                stringBuilder.append(str2);
                c.a("ws001", stringBuilder.toString());
            }
            i = 1;
            if (i2 >= 0) {
                if (i2 < d.length) {
                    i2 = d[i2];
                    i2.i += 1;
                    i2.c = System.currentTimeMillis();
                    if (c.a != null) {
                        str2 = new StringBuilder("activities=");
                        str2.append(i2.h);
                        str2.append(" services=");
                        str2.append(i2.i);
                        str2.append(" binders=");
                        str2.append(i2.j);
                        c.a("ws001", str2.toString());
                    }
                }
            }
            if (c.a != 0) {
                str = new StringBuilder("reg service: invalid index=");
                str.append(i2);
                c.a("ws001", str.toString());
            }
            i = 0;
        }
        return i;
    }

    static final boolean b(int i, int i2, String str, String str2) {
        synchronized (d) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("unreg service: pid=");
                stringBuilder.append(i);
                stringBuilder.append(" index=");
                stringBuilder.append(i2);
                stringBuilder.append(" plugin=");
                stringBuilder.append(str);
                stringBuilder.append(" service=");
                stringBuilder.append(str2);
                c.a("ws001", stringBuilder.toString());
            }
            i = 1;
            if (i2 >= 0) {
                if (i2 < d.length) {
                    i2 = d[i2];
                    i2.i -= 1;
                    i2.c = System.currentTimeMillis();
                    if (c.a != null) {
                        str2 = new StringBuilder("activities=");
                        str2.append(i2.h);
                        str2.append(" services=");
                        str2.append(i2.i);
                        str2.append(" binders=");
                        str2.append(i2.j);
                        c.a("ws001", str2.toString());
                    }
                }
            }
            if (c.a != 0) {
                str = new StringBuilder("unreg service: invalid index=");
                str.append(i2);
                c.a("ws001", str.toString());
            }
            i = 0;
        }
        return i;
    }

    static final void a(int i, IBinder iBinder) {
        synchronized (d) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("reg binder: pid=");
                stringBuilder.append(i);
                stringBuilder.append(" binder=");
                stringBuilder.append(iBinder);
                c.a("ws001", stringBuilder.toString());
            }
            iBinder = d;
            int length = iBinder.length;
            int i2 = 0;
            while (i2 < length) {
                b bVar = iBinder[i2];
                if (bVar.e == i) {
                    bVar.j++;
                    bVar.c = System.currentTimeMillis();
                    if (c.a != 0) {
                        iBinder = new StringBuilder("activities=");
                        iBinder.append(bVar.h);
                        iBinder.append(" services=");
                        iBinder.append(bVar.i);
                        iBinder.append(" binders=");
                        iBinder.append(bVar.j);
                        c.a("ws001", iBinder.toString());
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    static final void b(int i, IBinder iBinder) {
        synchronized (d) {
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("unreg binder: pid=");
                stringBuilder.append(i);
                stringBuilder.append(" binder=");
                stringBuilder.append(iBinder);
                c.a("ws001", stringBuilder.toString());
            }
            iBinder = d;
            int length = iBinder.length;
            int i2 = 0;
            while (i2 < length) {
                b bVar = iBinder[i2];
                if (bVar.e == i) {
                    bVar.j--;
                    bVar.c = System.currentTimeMillis();
                    if (c.a != 0) {
                        iBinder = new StringBuilder("activities=");
                        iBinder.append(bVar.h);
                        iBinder.append(" services=");
                        iBinder.append(bVar.i);
                        iBinder.append(" binders=");
                        iBinder.append(bVar.j);
                        c.a("ws001", iBinder.toString());
                    }
                } else {
                    i2++;
                }
            }
        }
    }

    static final int a(int i) {
        synchronized (d) {
            for (b bVar : d) {
                if (bVar.a == i) {
                    i = bVar.j;
                    break;
                }
            }
            i = -1;
        }
        return i;
    }

    @Deprecated
    private static final int c(String str) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("alloc plugin process: plugin=");
            stringBuilder.append(str);
            c.a("ws001", stringBuilder.toString());
        }
        List a = com.qihoo360.replugin.a.a.a(g.a());
        if (a != null) {
            if (!a.isEmpty()) {
                int i;
                b bVar;
                StringBuilder stringBuilder2;
                int i2;
                int i3 = 0;
                for (b bVar2 : d) {
                    if (TextUtils.equals(str, bVar2.d)) {
                        if (c.a) {
                            stringBuilder2 = new StringBuilder("alloc plugin process: found saved plugin process: index=");
                            stringBuilder2.append(bVar2.a);
                            stringBuilder2.append(" p=");
                            stringBuilder2.append(str);
                            c.a("ws001", stringBuilder2.toString());
                        }
                        if (bVar2.b == 0 || bVar2.b == 4) {
                            bVar2.a(str);
                            int a2 = a(a, bVar2.a);
                            if (a2 > 0) {
                                Process.killProcess(a2);
                                d(a2);
                            }
                        }
                        if (c.a) {
                            stringBuilder = new StringBuilder("used st=");
                            stringBuilder.append(bVar2.b);
                            stringBuilder.append(" i=");
                            stringBuilder.append(bVar2.a);
                            stringBuilder.append(" p=");
                            stringBuilder.append(str);
                            c.b("ws001", stringBuilder.toString());
                        }
                        return bVar2.a;
                    }
                }
                for (b bVar22 : d) {
                    if (bVar22.b == 0) {
                        if (c.a) {
                            stringBuilder2 = new StringBuilder("alloc plugin process: found unused plugin process: index=");
                            stringBuilder2.append(bVar22.a);
                            c.a("ws001", stringBuilder2.toString());
                            stringBuilder2 = new StringBuilder("free st=");
                            stringBuilder2.append(bVar22.b);
                            stringBuilder2.append(" i=");
                            stringBuilder2.append(bVar22.a);
                            stringBuilder2.append(" p=");
                            stringBuilder2.append(str);
                            stringBuilder2.append(" orig.p=");
                            stringBuilder2.append(bVar22.d);
                            c.b("ws001", stringBuilder2.toString());
                        }
                        bVar22.a(str);
                        str = a(a, bVar22.a);
                        if (str > null) {
                            Process.killProcess(str);
                            d(str);
                        }
                        return bVar22.a;
                    }
                }
                for (b bVar222 : d) {
                    if (bVar222.b == 4) {
                        if (c.a) {
                            stringBuilder2 = new StringBuilder("alloc plugin process: found stoped plugin process: index=");
                            stringBuilder2.append(bVar222.a);
                            c.a("ws001", stringBuilder2.toString());
                            stringBuilder2 = new StringBuilder("stoped st=");
                            stringBuilder2.append(bVar222.b);
                            stringBuilder2.append(" i=");
                            stringBuilder2.append(bVar222.a);
                            stringBuilder2.append(" orig.p=");
                            stringBuilder2.append(bVar222.d);
                            c.b("ws001", stringBuilder2.toString());
                        }
                        bVar222.a(str);
                        str = a(a, bVar222.a);
                        if (str > null) {
                            Process.killProcess(str);
                            d(str);
                        }
                        return bVar222.a;
                    }
                }
                long j = Long.MAX_VALUE;
                int i4 = -1;
                long j2 = Long.MAX_VALUE;
                for (b bVar3 : d) {
                    if (bVar3.b == 1 && bVar3.c < r9) {
                        i4 = bVar3.a;
                        j2 = bVar3.c;
                    }
                }
                if (i4 < 0 || System.currentTimeMillis() - r9 <= 10000) {
                    int length;
                    i2 = -1;
                    long j3 = Long.MAX_VALUE;
                    for (b bVar4 : d) {
                        if (bVar4.h <= 0 && bVar4.i <= 0 && bVar4.j <= 0 && bVar4.c < r7) {
                            i2 = bVar4.a;
                            j3 = bVar4.c;
                        }
                    }
                    b bVar5;
                    if (i2 >= 0) {
                        bVar5 = d[i2];
                        if (c.a) {
                            stringBuilder2 = new StringBuilder("alloc plugin process: plugin processes busy, reuse process which components is empty: index=");
                            stringBuilder2.append(bVar5.a);
                            c.a("ws001", stringBuilder2.toString());
                        }
                        new StringBuilder("ppr r & k i: ").append(bVar5.e);
                        stringBuilder = new StringBuilder("force empty st=");
                        stringBuilder.append(bVar5.b);
                        stringBuilder.append(" i=");
                        stringBuilder.append(bVar5.a);
                        stringBuilder.append(" orig.p=");
                        stringBuilder.append(bVar5.d);
                        Process.killProcess(bVar5.e);
                        d(bVar5.e);
                        bVar5.a();
                        bVar5.a(str);
                        return bVar5.a;
                    }
                    b[] bVarArr = d;
                    length = bVarArr.length;
                    i = 0;
                    while (i3 < length) {
                        bVar222 = bVarArr[i3];
                        if (bVar222.c < j) {
                            i = bVar222.a;
                            j = bVar222.c;
                        }
                        i3++;
                    }
                    bVar5 = d[i];
                    if (c.a) {
                        stringBuilder2 = new StringBuilder("alloc plugin process: plugin processes busy, reuse process which earliest allocated: index=");
                        stringBuilder2.append(bVar5.a);
                        c.a("ws001", stringBuilder2.toString());
                    }
                    new StringBuilder("ppr r & k i: ").append(bVar5.e);
                    stringBuilder = new StringBuilder("force earliest st=");
                    stringBuilder.append(bVar5.b);
                    stringBuilder.append(" i=");
                    stringBuilder.append(bVar5.a);
                    stringBuilder.append(" orig.p=");
                    stringBuilder.append(bVar5.d);
                    Process.killProcess(bVar5.e);
                    d(bVar5.e);
                    bVar5.a();
                    bVar5.a(str);
                    return bVar5.a;
                }
                b bVar6 = d[i4];
                if (c.a) {
                    StringBuilder stringBuilder3 = new StringBuilder("alloc plugin process: plugin processes maybe busy, reuse process which allocating and expired: index=");
                    stringBuilder3.append(bVar6.a);
                    c.a("ws001", stringBuilder3.toString());
                    stringBuilder3 = new StringBuilder("force maybe st=");
                    stringBuilder3.append(bVar6.b);
                    stringBuilder3.append(" i=");
                    stringBuilder3.append(bVar6.a);
                    stringBuilder3.append(" orig.p=");
                    stringBuilder3.append(bVar6.d);
                    c.b("ws001", stringBuilder3.toString());
                }
                bVar6.a();
                bVar6.a(str);
                str = a(a, bVar6.a);
                if (str > null) {
                    Process.killProcess(str);
                    d(str);
                }
                return bVar6.a;
            }
        }
        if (c.a) {
            c.a("ws001", "alloc plugin process: get running processes is empty");
            stringBuilder = new StringBuilder("get list exception p=");
            stringBuilder.append(str);
            c.b("ws001", stringBuilder.toString());
        }
        return Integer.MIN_VALUE;
    }

    private static final void d(int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        r1 = r0;
    L_0x0002:
        r2 = 10;
        if (r1 >= r2) goto L_0x0038;
    L_0x0006:
        r2 = 100;
        java.lang.Thread.sleep(r2, r0);	 Catch:{ Throwable -> 0x000b }
    L_0x000b:
        r2 = com.qihoo360.replugin.g.a();
        r2 = com.qihoo360.replugin.a.a.a(r2);
        if (r2 == 0) goto L_0x0035;
    L_0x0015:
        r3 = r2.isEmpty();
        if (r3 != 0) goto L_0x0035;
    L_0x001b:
        r2 = r2.iterator();
        r3 = r0;
    L_0x0020:
        r4 = r2.hasNext();
        if (r4 == 0) goto L_0x0032;
    L_0x0026:
        r4 = r2.next();
        r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4;
        r4 = r4.pid;
        if (r4 != r5) goto L_0x0020;
    L_0x0030:
        r3 = 1;
        goto L_0x0020;
    L_0x0032:
        if (r3 != 0) goto L_0x0035;
    L_0x0034:
        return;
    L_0x0035:
        r1 = r1 + 1;
        goto L_0x0002;
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.loader2.ac.d(int):void");
    }

    private static final int a(List<RunningAppProcessInfo> list, int i) {
        for (RunningAppProcessInfo runningAppProcessInfo : list) {
            if (runningAppProcessInfo.uid == aa.a && aa.a(runningAppProcessInfo.processName) == i) {
                return runningAppProcessInfo.pid;
            }
        }
        return -1;
    }

    private static final void b(a aVar, d dVar) {
        for (a aVar2 : e.values()) {
            if (aVar2 == aVar) {
                e.remove(aVar2.a);
                break;
            }
        }
        for (b bVar : d) {
            if (bVar.f == aVar.e) {
                bVar.a();
                break;
            }
        }
        aVar = aVar.a;
        synchronized (d.a) {
            dVar.b.remove(aVar);
            if (c.a) {
                StringBuilder stringBuilder = new StringBuilder("onClientProcessKilled: Killed! process=");
                stringBuilder.append(aVar);
                stringBuilder.append("; remains=");
                stringBuilder.append(dVar.b);
                c.a("PluginManagerServer", stringBuilder.toString());
            }
        }
    }

    static final void b() {
        IBinder a = ag.a(n.a);
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("host binder = ");
            stringBuilder.append(a);
            c.a("ws001", stringBuilder.toString());
        }
        if (a == null) {
            System.exit(1);
        }
        try {
            a.linkToDeath(new ae(), 0);
        } catch (RemoteException e) {
            new StringBuilder("p.p p.h l2a: ").append(e.getMessage());
            System.exit(1);
        }
        c = com.qihoo360.loader2.j.a.a(a);
        if (c.a) {
            stringBuilder = new StringBuilder("host binder.i = ");
            stringBuilder.append(c);
            c.a("ws001", stringBuilder.toString());
        }
        try {
            com.qihoo360.replugin.packages.c.a(c);
            com.qihoo360.replugin.packages.c.d();
        } catch (RemoteException e2) {
            new StringBuilder("p.p p.h l3a: ").append(e2.getMessage());
            System.exit(1);
        }
        n.b.c();
    }

    static final int b(String str) {
        if (TextUtils.equals(str, com.qihoo360.replugin.a.b.a)) {
            return com.qihoo360.replugin.a.b.b;
        }
        synchronized (d) {
            for (a aVar : e.values()) {
                if (TextUtils.equals(aVar.a, str) && a(aVar)) {
                    str = aVar.c;
                    return str;
                }
            }
            return -1;
        }
    }

    static final String b(int i) {
        if (i == com.qihoo360.replugin.a.b.b) {
            return com.qihoo360.replugin.a.b.a;
        }
        synchronized (d) {
            for (a aVar : e.values()) {
                if (aVar.c == i && a(aVar)) {
                    i = aVar.a;
                    return i;
                }
            }
            return 0;
        }
    }

    static /* synthetic */ void a(a aVar, d dVar) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("plugin process has died: plugin=");
            stringBuilder.append(aVar.b);
            stringBuilder.append(" index=");
            stringBuilder.append(aVar.d);
            stringBuilder.append(" pid=");
            stringBuilder.append(aVar.c);
            c.a("ws001", stringBuilder.toString());
        }
        synchronized (d) {
            b(aVar, dVar);
        }
    }
}
