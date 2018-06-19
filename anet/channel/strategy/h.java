package anet.channel.strategy;

/* compiled from: Taobao */
class h implements Runnable {
    final /* synthetic */ g a;

    h(g gVar) {
        this.a = gVar;
    }

    public void run() {
        if (!this.a.a()) {
            this.a.a.c();
        }
    }
}
