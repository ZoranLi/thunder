package com.igexin.push.c;

public enum d {
    NORMAL(0),
    BACKUP(1),
    TRY_NORMAL(2);
    
    private int d;

    private d(int i) {
        this.d = -1;
        this.d = i;
    }

    public static d a(int i) {
        for (d dVar : a()) {
            if (dVar.b() == i) {
                return dVar;
            }
        }
        return null;
    }

    public static d[] a() {
        return (d[]) e.clone();
    }

    public final int b() {
        return this.d;
    }
}
