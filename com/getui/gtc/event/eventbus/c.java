package com.getui.gtc.event.eventbus;

import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

public class c {
    public static String a = "EventBus";
    static volatile c b;
    private static final f e = new f();
    private static final Map f = new HashMap();
    public final m c;
    final ExecutorService d;
    private final Map g;
    private final Map h;
    private final Map i;
    private final ThreadLocal j;
    private final h k;
    private final b l;
    private final a m;
    private final boolean n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final boolean s;
    private final int t;

    final class a {
        final List a = new ArrayList();
        boolean b;
        boolean c;
        n d;
        Object e;
        boolean f;

        a() {
        }
    }

    public c() {
        this(e);
    }

    private c(f fVar) {
        this.j = new d(this);
        this.g = new HashMap();
        this.h = new HashMap();
        this.i = new ConcurrentHashMap();
        this.k = new h(this, Looper.getMainLooper());
        this.l = new b(this);
        this.m = new a(this);
        this.t = fVar.j != null ? fVar.j.size() : 0;
        this.c = new m(fVar.j, fVar.h, fVar.g);
        this.o = fVar.a;
        this.p = fVar.b;
        this.q = fVar.c;
        this.r = fVar.d;
        this.n = fVar.e;
        this.s = fVar.f;
        this.d = fVar.i;
    }

    public static c a() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    private static List a(Class cls) {
        List list;
        synchronized (f) {
            list = (List) f.get(cls);
            if (list == null) {
                list = new ArrayList();
                for (Class cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, cls2.getInterfaces());
                }
                f.put(cls, list);
            }
        }
        return list;
    }

    private void a(n nVar, Object obj) {
        if (obj != null) {
            a(nVar, obj, Looper.getMainLooper() == Looper.myLooper());
        }
    }

    private void a(n nVar, Object obj, boolean z) {
        i a;
        Runnable runnable;
        switch (e.a[nVar.b.b.ordinal()]) {
            case 1:
                b(nVar, obj);
                return;
            case 2:
                if (z) {
                    b(nVar, obj);
                    return;
                }
                h hVar = this.k;
                a = i.a(nVar, obj);
                synchronized (hVar) {
                    hVar.a.a(a);
                    if (!hVar.b) {
                        hVar.b = true;
                        if (!hVar.sendMessage(hVar.obtainMessage())) {
                            throw new g("Could not send handler message");
                        }
                    }
                }
                return;
            case 3:
                if (z) {
                    runnable = this.l;
                    a = i.a(nVar, obj);
                    synchronized (runnable) {
                        runnable.a.a(a);
                        if (!runnable.c) {
                            runnable.c = true;
                            runnable.b.d.execute(runnable);
                        }
                    }
                    return;
                }
                b(nVar, obj);
                return;
            case 4:
                runnable = this.m;
                runnable.a.a(i.a(nVar, obj));
                runnable.b.d.execute(runnable);
                return;
            default:
                StringBuilder stringBuilder = new StringBuilder("Unknown thread mode: ");
                stringBuilder.append(nVar.b.b);
                throw new IllegalStateException(stringBuilder.toString());
        }
    }

    private static void a(List list, Class[] clsArr) {
        for (Class cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    private boolean a(Object obj, a aVar, Class cls) {
        synchronized (this) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.g.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        loop0:
        while (it.hasNext()) {
            boolean z = (n) it.next();
            aVar.e = obj;
            aVar.d = z;
            try {
                a((n) z, obj, aVar.c);
                z = aVar.f;
                continue;
            } finally {
                aVar.e = null;
                aVar.d = null;
                aVar.f = false;
            }
            if (z) {
                break loop0;
            }
        }
        return true;
    }

    private void b(n nVar, Object obj) {
        try {
            nVar.b.a.invoke(nVar.a, new Object[]{obj});
        } catch (InvocationTargetException e) {
            Throwable cause = e.getCause();
            if (obj instanceof k) {
                if (this.o) {
                }
            } else if (this.n) {
                throw new g("Invoking subscriber failed", cause);
            } else if (this.q) {
                b(new k(this, cause, obj, nVar.a));
            }
        } catch (Throwable e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        }
    }

    final void a(i iVar) {
        Object obj = iVar.a;
        n nVar = iVar.b;
        i.a(iVar);
        if (nVar.c) {
            b(nVar, obj);
        }
    }

    public final synchronized void a(Object obj) {
        List<Class> list = (List) this.h.get(obj);
        if (list != null) {
            for (Class cls : list) {
                List list2 = (List) this.g.get(cls);
                if (list2 != null) {
                    int size = list2.size();
                    int i = 0;
                    while (i < size) {
                        n nVar = (n) list2.get(i);
                        if (nVar.a == obj) {
                            nVar.c = false;
                            list2.remove(i);
                            i--;
                            size--;
                        }
                        i++;
                    }
                }
            }
            this.h.remove(obj);
        }
    }

    public final void a(Object obj, l lVar) {
        Class cls = lVar.c;
        n nVar = new n(obj, lVar);
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.g.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.g.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(nVar)) {
            StringBuilder stringBuilder = new StringBuilder("Subscriber ");
            stringBuilder.append(obj.getClass());
            stringBuilder.append(" already registered to event ");
            stringBuilder.append(cls);
            throw new g(stringBuilder.toString());
        }
        int size = copyOnWriteArrayList.size();
        int i = 0;
        while (i <= size) {
            if (i != size) {
                if (lVar.d <= ((n) copyOnWriteArrayList.get(i)).b.d) {
                    i++;
                }
            }
            copyOnWriteArrayList.add(i, nVar);
            break;
        }
        List list = (List) this.h.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.h.put(obj, list);
        }
        list.add(cls);
        if (lVar.e) {
            if (this.s) {
                for (Entry entry : this.i.entrySet()) {
                    if (cls.isAssignableFrom((Class) entry.getKey())) {
                        a(nVar, entry.getValue());
                    }
                }
                return;
            }
            a(nVar, this.i.get(cls));
        }
    }

    public final void b(Object obj) {
        a aVar = (a) this.j.get();
        List list = aVar.a;
        list.add(obj);
        if (!aVar.b) {
            aVar.c = Looper.getMainLooper() == Looper.myLooper();
            aVar.b = true;
            if (aVar.f) {
                throw new g("Internal error. Abort state was not reset");
            }
            while (!list.isEmpty()) {
                try {
                    int i;
                    obj = list.remove(0);
                    Class cls = obj.getClass();
                    if (this.s) {
                        List a = a(cls);
                        int i2 = 0;
                        i = i2;
                        while (i2 < a.size()) {
                            i |= a(obj, aVar, (Class) a.get(i2));
                            i2++;
                        }
                    } else {
                        i = a(obj, aVar, cls);
                    }
                    if (i == 0 && this.r && cls != NoSubscriberEvent.class && cls != k.class) {
                        b(new NoSubscriberEvent(this, obj));
                    }
                } finally {
                    aVar.b = false;
                    aVar.c = false;
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("EventBus[indexCount=");
        stringBuilder.append(this.t);
        stringBuilder.append(", eventInheritance=");
        stringBuilder.append(this.s);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
