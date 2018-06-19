package com.taobao.accs.net;

import com.taobao.accs.data.Message;

/* compiled from: Taobao */
class s implements Runnable {
    final /* synthetic */ Message a;
    final /* synthetic */ boolean b;
    final /* synthetic */ r c;

    s(r rVar, Message message, boolean z) {
        this.c = rVar;
        this.a = message;
        this.b = z;
    }

    public void run() {
        synchronized (this.c.t) {
            this.c.a(this.a);
            if (this.c.t.size() == 0) {
                this.c.t.add(this.a);
            } else {
                Message message = (Message) this.c.t.getFirst();
                if (this.a.a() != 1) {
                    if (this.a.a() != 0) {
                        if (this.a.a() != 2 || message.a() != 2) {
                            this.c.t.addLast(this.a);
                        } else if (!message.d && this.a.d) {
                            this.c.t.removeFirst();
                            this.c.t.addFirst(this.a);
                        }
                    }
                }
                this.c.t.addLast(this.a);
                if (message.a() == 2) {
                    this.c.t.removeFirst();
                }
            }
            if (this.b || this.c.s == 3) {
                try {
                    this.c.t.notifyAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
