package mtopsdk.mtop.util;

import android.os.Process;

final class g extends Thread {
    final /* synthetic */ f a;

    g(f fVar, Runnable runnable, String str) {
        this.a = fVar;
        super(runnable, str);
    }

    public final void run() {
        Process.setThreadPriority(this.a.a);
        super.run();
    }
}
