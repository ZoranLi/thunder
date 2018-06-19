package com.xunlei.downloadprovider.pushmessage;

import java.util.ArrayList;
import java.util.List;

/* compiled from: Subject */
public abstract class o {
    protected List<c> a = new ArrayList();

    public final void a(c cVar) {
        this.a.add(cVar);
        System.out.println("Attached an observer");
    }

    public final void b(c cVar) {
        this.a.remove(cVar);
    }
}
