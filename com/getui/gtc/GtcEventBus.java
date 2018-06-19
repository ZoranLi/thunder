package com.getui.gtc;

import com.getui.gtc.event.eventbus.a.b;
import com.getui.gtc.event.eventbus.c;
import com.getui.gtc.event.eventbus.g;
import com.getui.gtc.event.eventbus.l;
import com.getui.gtc.event.eventbus.m;
import com.getui.gtc.event.eventbus.m.a;
import java.util.List;

public class GtcEventBus {
    public static void postEvent(Object obj) {
        try {
            c.a().b(obj);
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public static void register(Object obj) {
        try {
            c a = c.a();
            Class cls = obj.getClass();
            m mVar = a.c;
            List list = (List) m.a.get(cls);
            if (list == null) {
                a a2;
                if (mVar.c) {
                    a2 = m.a();
                    a2.a(cls);
                    while (a2.f != null) {
                        mVar.b(a2);
                        a2.a();
                    }
                } else {
                    a2 = m.a();
                    a2.a(cls);
                    while (a2.f != null) {
                        com.getui.gtc.event.eventbus.a.a c;
                        int i;
                        if (!(a2.h == null || a2.h.c() == null)) {
                            c = a2.h.c();
                            if (a2.f == c.a()) {
                                a2.h = c;
                                if (a2.h == null) {
                                    for (l lVar : a2.h.b()) {
                                        if (a2.a(lVar.a, lVar.c)) {
                                            a2.a.add(lVar);
                                        }
                                    }
                                } else {
                                    mVar.b(a2);
                                }
                                a2.a();
                            }
                        }
                        if (mVar.b != null) {
                            for (b a3 : mVar.b) {
                                com.getui.gtc.event.eventbus.a.a a4 = a3.a();
                                if (a4 != null) {
                                    c = a4;
                                    break;
                                }
                            }
                        }
                        c = null;
                        a2.h = c;
                        if (a2.h == null) {
                            mVar.b(a2);
                        } else {
                            for (i = 0; i < r6; i++) {
                                if (a2.a(lVar.a, lVar.c)) {
                                    a2.a.add(lVar);
                                }
                            }
                        }
                        a2.a();
                    }
                }
                list = m.a(a2);
                if (list.isEmpty()) {
                    StringBuilder stringBuilder = new StringBuilder("Subscriber ");
                    stringBuilder.append(cls);
                    stringBuilder.append(" and its super classes have no public methods with the @Subscribe annotation");
                    throw new g(stringBuilder.toString());
                }
                m.a.put(cls, list);
            }
            synchronized (a) {
                for (l a5 : r4) {
                    a.a(obj, a5);
                }
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }

    public static void unregister(Object obj) {
        try {
            c.a().a(obj);
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
    }
}
