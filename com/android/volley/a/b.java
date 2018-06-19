package com.android.volley.a;

import com.android.volley.toolbox.ad;
import com.android.volley.toolbox.al;
import com.android.volley.toolbox.am;
import com.android.volley.toolbox.e;
import com.android.volley.toolbox.f;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;

/* compiled from: URLEncodedUtils */
public final class b {
    private static final char[] a = new char[]{'&'};
    private static final BitSet b = new BitSet(256);
    private static final BitSet c = new BitSet(256);
    private static final BitSet d = new BitSet(256);
    private static final BitSet e = new BitSet(256);
    private static final BitSet f = new BitSet(256);
    private static final BitSet g = new BitSet(256);
    private static final BitSet h = new BitSet(256);

    static {
        int i;
        for (i = 97; i <= 122; i++) {
            b.set(i);
        }
        for (i = 65; i <= 90; i++) {
            b.set(i);
        }
        for (i = 48; i <= 57; i++) {
            b.set(i);
        }
        b.set(95);
        b.set(45);
        b.set(46);
        b.set(42);
        h.or(b);
        b.set(33);
        b.set(Opcodes.NOT_LONG);
        b.set(39);
        b.set(40);
        b.set(41);
        c.set(44);
        c.set(59);
        c.set(58);
        c.set(36);
        c.set(38);
        c.set(43);
        c.set(61);
        d.or(b);
        d.or(c);
        e.or(b);
        e.set(47);
        e.set(59);
        e.set(58);
        e.set(64);
        e.set(38);
        e.set(61);
        e.set(43);
        e.set(36);
        e.set(44);
        g.set(59);
        g.set(47);
        g.set(63);
        g.set(58);
        g.set(64);
        g.set(38);
        g.set(61);
        g.set(43);
        g.set(36);
        g.set(44);
        g.set(91);
        g.set(93);
        f.or(g);
        f.or(b);
    }

    public static List<al> a(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        ad adVar = ad.a;
        f fVar = new f(str.length());
        fVar.a(str);
        str = new am(fVar.length());
        List<al> arrayList = new ArrayList();
        while (!str.a()) {
            al a = ad.a(fVar, str, a);
            if (a.a().length() > 0) {
                arrayList.add(new e(a.a(), a.b()));
            }
        }
        return arrayList;
    }
}
