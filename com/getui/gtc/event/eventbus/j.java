package com.getui.gtc.event.eventbus;

final class j {
    private i a;
    private i b;

    j() {
    }

    final synchronized i a() {
        i iVar;
        iVar = this.a;
        if (this.a != null) {
            this.a = this.a.c;
            if (this.a == null) {
                this.b = null;
            }
        }
        return iVar;
    }

    final synchronized void a(i iVar) {
        if (iVar == null) {
            throw new NullPointerException("null cannot be enqueued");
        }
        if (this.b != null) {
            this.b.c = iVar;
            this.b = iVar;
        } else if (this.a == null) {
            this.b = iVar;
            this.a = iVar;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
        notifyAll();
    }

    final synchronized i b() {
        while (this.a == null) {
            wait(1000);
        }
        return a();
    }
}
