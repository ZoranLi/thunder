package com.tencent.bugly.proguard;

import java.util.ArrayList;

/* compiled from: BUGLY */
public final class bc extends m implements Cloneable {
    static ArrayList<bb> b;
    public ArrayList<bb> a = null;

    public final void a(StringBuilder stringBuilder, int i) {
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
    }

    public final void a(k kVar) {
        if (b == null) {
            b = new ArrayList();
            b.add(new bb());
        }
        this.a = (ArrayList) kVar.a(b, 0, true);
    }
}
