package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.a.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: SampleRules */
public class j {
    public static final String a = null;
    private static j d;
    public Map<f, g> b = new HashMap();
    public String c;
    private int e;

    private j() {
        for (f fVar : f.a()) {
            if (fVar == f.ALARM) {
                this.b.put(fVar, new f(fVar, fVar.e()));
            } else {
                this.b.put(fVar, new g(fVar, fVar.e()));
            }
        }
    }

    public static j a() {
        if (d == null) {
            synchronized (j.class) {
                if (d == null) {
                    d = new j();
                }
            }
        }
        return d;
    }

    public static boolean a(f fVar, String str, String str2) {
        return a().b(fVar, str, str2, null);
    }

    public static boolean a(f fVar, String str, String str2, Map<String, String> map) {
        return a().b(fVar, str, str2, map);
    }

    public static boolean a(String str, String str2, Boolean bool, Map<String, String> map) {
        j a = a();
        g gVar = (g) a.b.get(f.ALARM);
        return (gVar == null || !(gVar instanceof f)) ? null : ((f) gVar).a(a.e, str, str2, bool, map);
    }

    private boolean b(f fVar, String str, String str2, Map<String, String> map) {
        g gVar = (g) this.b.get(fVar);
        return gVar != null ? gVar.a(this.e, str, str2, map) : null;
    }

    public final void b() {
        this.e = new Random(System.currentTimeMillis()).nextInt(10000);
    }

    public final void a(f fVar, int i) {
        g gVar = (g) this.b.get(fVar);
        if (gVar != null) {
            gVar.b(i);
        }
    }
}
