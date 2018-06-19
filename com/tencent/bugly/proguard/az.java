package com.tencent.bugly.proguard;

import java.util.ArrayList;

/* compiled from: BUGLY */
public final class az extends m implements Cloneable {
    static ArrayList<String> c;
    public String a = "";
    public ArrayList<String> b = null;

    public final void a(StringBuilder stringBuilder, int i) {
    }

    public final void a(l lVar) {
        lVar.a(this.a, 0);
        if (this.b != null) {
            lVar.a(this.b, 1);
        }
    }

    public final void a(k kVar) {
        this.a = kVar.a(0, true);
        if (c == null) {
            c = new ArrayList();
            c.add("");
        }
        this.b = (ArrayList) kVar.a(c, 1, false);
    }
}
