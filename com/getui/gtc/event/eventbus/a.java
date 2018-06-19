package com.getui.gtc.event.eventbus;

final class a implements Runnable {
    final j a = new j();
    final c b;

    a(c cVar) {
        this.b = cVar;
    }

    public final void run() {
        i a = this.a.a();
        if (a == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.b.a(a);
    }
}
