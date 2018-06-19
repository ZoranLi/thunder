package com.xunlei.downloadprovider.dialog;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* compiled from: DialogController */
public final class a {
    private static a d;
    private Map<Integer, Integer> a = new HashMap();
    private int b;
    private Stack<Integer> c;

    private a() {
        this.a.put(Integer.valueOf(-1), Integer.valueOf(Integer.MAX_VALUE));
        this.a.put(Integer.valueOf(13), Integer.valueOf(0));
        this.a.put(Integer.valueOf(1), Integer.valueOf(1));
        this.a.put(Integer.valueOf(2), Integer.valueOf(1));
        this.a.put(Integer.valueOf(3), Integer.valueOf(1));
        this.a.put(Integer.valueOf(4), Integer.valueOf(2));
        this.a.put(Integer.valueOf(5), Integer.valueOf(2));
        this.a.put(Integer.valueOf(6), Integer.valueOf(2));
        this.a.put(Integer.valueOf(7), Integer.valueOf(3));
        this.a.put(Integer.valueOf(8), Integer.valueOf(4));
        this.a.put(Integer.valueOf(9), Integer.valueOf(4));
        this.a.put(Integer.valueOf(10), Integer.valueOf(4));
        this.a.put(Integer.valueOf(11), Integer.valueOf(4));
        this.a.put(Integer.valueOf(12), Integer.valueOf(4));
        this.a.put(Integer.valueOf(14), Integer.valueOf(4));
        this.b = Integer.MAX_VALUE;
        this.c = new Stack();
    }

    public static a a() {
        if (d == null) {
            d = new a();
        }
        return d;
    }

    public final boolean a(int i) {
        boolean b = b();
        boolean z = true;
        if (b) {
            if (i <= 0) {
                z = this.c.isEmpty();
            } else if (((Integer) this.a.get(Integer.valueOf(i))).intValue() >= this.b) {
                z = false;
            }
            StringBuilder stringBuilder = new StringBuilder("Try to show dialog=");
            stringBuilder.append(i);
            stringBuilder.append(" ");
            stringBuilder.append(z);
            return z;
        }
        StringBuilder stringBuilder2 = new StringBuilder("Try to show dialog=");
        stringBuilder2.append(i);
        stringBuilder2.append(" true isAboveMainActivity=");
        stringBuilder2.append(b);
        return true;
    }

    public final void a(int i, boolean z) {
        if (z) {
            this.c.push(Integer.valueOf(i));
            this.b = ((Integer) this.a.get(Integer.valueOf(i))).intValue();
        } else if (!this.c.isEmpty()) {
            this.c.pop();
            if (this.c.isEmpty()) {
                this.b = Integer.MAX_VALUE;
            } else {
                this.b = ((Integer) this.a.get(Integer.valueOf(((Integer) this.c.peek()).intValue()))).intValue();
            }
        }
        StringBuilder stringBuilder = new StringBuilder("dialog=");
        stringBuilder.append(i);
        stringBuilder.append(" showStatus=");
        stringBuilder.append(z);
        stringBuilder.append(" highestPriority=");
        stringBuilder.append(this.b);
    }

    private static boolean b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.downloadprovider.app.AppStatusChgObserver.b();	 Catch:{ ClassNotFoundException -> 0x001d }
        r0 = r0.c();	 Catch:{ ClassNotFoundException -> 0x001d }
        r1 = new java.lang.StringBuilder;	 Catch:{ ClassNotFoundException -> 0x001d }
        r2 = "TopActivity=";	 Catch:{ ClassNotFoundException -> 0x001d }
        r1.<init>(r2);	 Catch:{ ClassNotFoundException -> 0x001d }
        r1.append(r0);	 Catch:{ ClassNotFoundException -> 0x001d }
        r1 = "com.xunlei.downloadprovider.frame.MainTabActivity";	 Catch:{ ClassNotFoundException -> 0x001d }
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x001d }
        r0 = r1.isInstance(r0);	 Catch:{ ClassNotFoundException -> 0x001d }
        return r0;
    L_0x001d:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.dialog.a.b():boolean");
    }
}
