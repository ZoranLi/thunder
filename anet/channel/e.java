package anet.channel;

import anet.channel.util.AppLifecycle;

/* compiled from: Taobao */
class e implements Runnable {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public void run() {
        try {
            if (AppLifecycle.lastEnterBackgroundTime == 0 || System.currentTimeMillis() - AppLifecycle.lastEnterBackgroundTime <= 300000) {
                this.a.b.accsSessionManager.checkAndStartSession();
            } else {
                this.a.b.accsSessionManager.forceCloseSession(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            this.a.a = false;
        }
        this.a.a = false;
    }
}
