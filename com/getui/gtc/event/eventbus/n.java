package com.getui.gtc.event.eventbus;

final class n {
    final Object a;
    final l b;
    volatile boolean c = true;

    n(Object obj, l lVar) {
        this.a = obj;
        this.b = lVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.a == nVar.a && this.b.equals(nVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() + this.b.f.hashCode();
    }
}
