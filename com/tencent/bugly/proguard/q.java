package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.download.a;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.xiaomi.push.service.av;
import java.io.File;

/* compiled from: BUGLY */
public class q {
    public static q a = new q();
    public BetaGrayStrategy b;
    public DownloadTask c;
    public final Handler d = new Handler(Looper.getMainLooper());
    private DownloadListener e = new a(4, this, Integer.valueOf(0));

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(int r3, com.tencent.bugly.proguard.y r4, boolean r5) {
        /*
        r2 = this;
        monitor-enter(r2);
        r4 = r2.a(r4);	 Catch:{ all -> 0x00b5 }
        r2.b = r4;	 Catch:{ all -> 0x00b5 }
        if (r3 != 0) goto L_0x00b3;
    L_0x0009:
        r3 = r2.b;	 Catch:{ all -> 0x00b5 }
        if (r3 != 0) goto L_0x000f;
    L_0x000d:
        goto L_0x00b3;
    L_0x000f:
        r3 = r2.b;	 Catch:{ all -> 0x00b5 }
        if (r3 == 0) goto L_0x00b1;
    L_0x0013:
        r3 = r2.b;	 Catch:{ all -> 0x00b5 }
        r3 = r3.a;	 Catch:{ all -> 0x00b5 }
        if (r3 == 0) goto L_0x00b1;
    L_0x0019:
        r3 = r2.b;	 Catch:{ all -> 0x00b5 }
        r3 = r3.a;	 Catch:{ all -> 0x00b5 }
        r3 = r3.f;	 Catch:{ all -> 0x00b5 }
        if (r3 == 0) goto L_0x00b1;
    L_0x0021:
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r3 = r3.G;	 Catch:{ all -> 0x00b5 }
        if (r3 == 0) goto L_0x0086;
    L_0x0027:
        r4 = r3.exists();	 Catch:{ all -> 0x00b5 }
        if (r4 == 0) goto L_0x0086;
    L_0x002d:
        r4 = r2.b;	 Catch:{ all -> 0x00b5 }
        r4 = r4.a;	 Catch:{ all -> 0x00b5 }
        r4 = r4.f;	 Catch:{ all -> 0x00b5 }
        r4 = r4.a;	 Catch:{ all -> 0x00b5 }
        r0 = "SHA";
        r4 = com.tencent.bugly.beta.global.a.a(r3, r4, r0);	 Catch:{ all -> 0x00b5 }
        if (r4 == 0) goto L_0x0086;
    L_0x003d:
        r4 = "patch has downloaded!";
        r5 = 0;
        r0 = new java.lang.Object[r5];	 Catch:{ all -> 0x00b5 }
        com.tencent.bugly.proguard.an.a(r4, r0);	 Catch:{ all -> 0x00b5 }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r4 = r4.N;	 Catch:{ all -> 0x00b5 }
        if (r4 != 0) goto L_0x0084;
    L_0x004b:
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r4 = r4.O;	 Catch:{ all -> 0x00b5 }
        r0 = 3;
        if (r4 > r0) goto L_0x0084;
    L_0x0052:
        r4 = "patch has downloaded but not patched execute patch!";
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00b5 }
        com.tencent.bugly.proguard.an.a(r4, r5);	 Catch:{ all -> 0x00b5 }
        r4 = "PATCH_MAX_TIMES";
        r5 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r0 = r5.O;	 Catch:{ all -> 0x00b5 }
        r1 = r0 + 1;
        r5.O = r1;	 Catch:{ all -> 0x00b5 }
        r5 = java.lang.String.valueOf(r0);	 Catch:{ all -> 0x00b5 }
        com.tencent.bugly.beta.global.a.a(r4, r5);	 Catch:{ all -> 0x00b5 }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r4 = r4.H;	 Catch:{ all -> 0x00b5 }
        com.tencent.bugly.beta.global.a.a(r3, r4);	 Catch:{ all -> 0x00b5 }
        r3 = com.tencent.bugly.beta.tinker.TinkerManager.getInstance();	 Catch:{ all -> 0x00b5 }
        r4 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r4 = r4.H;	 Catch:{ all -> 0x00b5 }
        r4 = r4.getAbsolutePath();	 Catch:{ all -> 0x00b5 }
        r5 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r5 = r5.U;	 Catch:{ all -> 0x00b5 }
        r3.onDownloadSuccess(r4, r5);	 Catch:{ all -> 0x00b5 }
    L_0x0084:
        monitor-exit(r2);
        return;
    L_0x0086:
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r3 = r3.V;	 Catch:{ all -> 0x00b5 }
        if (r3 == 0) goto L_0x00a0;
    L_0x008c:
        r3 = r2.b;	 Catch:{ all -> 0x00b5 }
        r3 = r3.a;	 Catch:{ all -> 0x00b5 }
        r3 = r3.b();	 Catch:{ all -> 0x00b5 }
        if (r3 == 0) goto L_0x00a0;
    L_0x0096:
        r4 = r2.d;	 Catch:{ all -> 0x00b5 }
        r0 = new com.tencent.bugly.proguard.q$1;	 Catch:{ all -> 0x00b5 }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x00b5 }
        r4.post(r0);	 Catch:{ all -> 0x00b5 }
    L_0x00a0:
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r3 = r3.X;	 Catch:{ all -> 0x00b5 }
        if (r3 != 0) goto L_0x00a8;
    L_0x00a6:
        if (r5 == 0) goto L_0x00b1;
    L_0x00a8:
        r3 = com.tencent.bugly.beta.global.e.E;	 Catch:{ all -> 0x00b5 }
        r3 = r3.Y;	 Catch:{ all -> 0x00b5 }
        if (r3 == 0) goto L_0x00b1;
    L_0x00ae:
        r2.a();	 Catch:{ all -> 0x00b5 }
    L_0x00b1:
        monitor-exit(r2);
        return;
    L_0x00b3:
        monitor-exit(r2);
        return;
    L_0x00b5:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.q.a(int, com.tencent.bugly.proguard.y, boolean):void");
    }

    public BetaGrayStrategy a(y yVar) {
        File file;
        y yVar2 = yVar;
        BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("st.bch", BetaGrayStrategy.CREATOR);
        if (betaGrayStrategy == null || betaGrayStrategy.a == null) {
            com.tencent.bugly.beta.global.a.a("st.bch");
            betaGrayStrategy = null;
        }
        if (yVar2 != null) {
            if (!(yVar2.n == 1 || betaGrayStrategy == null || TextUtils.isEmpty(betaGrayStrategy.a.m) || !TextUtils.equals(yVar2.m, betaGrayStrategy.a.m))) {
                boolean z;
                p pVar = p.a;
                w wVar = r6;
                w wVar2 = new w("recall", System.currentTimeMillis(), (byte) 0, 0, null, betaGrayStrategy.a.m, betaGrayStrategy.a.p, null);
                pVar.a(wVar);
                com.tencent.bugly.beta.global.a.a("st.bch");
                e.E.p.a(betaGrayStrategy.a.f.b, e.E.I.getAbsolutePath(), null, betaGrayStrategy.a.f.a).delete(true);
                file = e.E.H;
                if (file != null && file.exists() && file.delete()) {
                    an.a("delete tmpPatchFile", new Object[0]);
                }
                file = e.E.G;
                if (file != null && file.exists() && file.delete()) {
                    z = false;
                    an.a("delete patchFile", new Object[0]);
                } else {
                    z = false;
                }
                com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", true);
                an.a("patch rollback", new Object[z]);
                if (ap.b(e.E.s)) {
                    TinkerManager.getInstance().onPatchRollback(z);
                } else {
                    TinkerManager.getInstance().onPatchRollback(true);
                }
                betaGrayStrategy = null;
            }
            if (yVar2.n != 1) {
                yVar2 = null;
            }
        }
        if (yVar2 == null) {
            return (betaGrayStrategy == null || betaGrayStrategy.a == null || betaGrayStrategy.a.p != 3) ? null : betaGrayStrategy;
        } else {
            Parcelable betaGrayStrategy2 = new BetaGrayStrategy();
            betaGrayStrategy2.a = yVar2;
            betaGrayStrategy2.e = System.currentTimeMillis();
            if (betaGrayStrategy != null && (!TextUtils.equals(betaGrayStrategy.a.f.b, yVar2.f.b) || (yVar2.l != null && TextUtils.equals((CharSequence) yVar2.l.get("H1"), av.b)))) {
                e.E.M = (String) yVar2.l.get("H2");
                e.E.p.a(betaGrayStrategy.a.f.b, e.E.I.getAbsolutePath(), null, null).delete(true);
                if (betaGrayStrategy.a.p == 3) {
                    file = e.E.H;
                    if (file != null && file.exists() && file.delete()) {
                        an.a("delete tmpPatchFile", new Object[0]);
                    }
                    file = e.E.G;
                    if (file != null && file.exists() && file.delete()) {
                        e.E.L = "";
                        an.a("delete patchFile", new Object[0]);
                    }
                }
            }
            com.tencent.bugly.beta.global.a.a("st.bch", betaGrayStrategy2);
            an.a("onUpgradeReceived: %s [type: %d]", yVar2, Integer.valueOf(yVar2.p));
            return betaGrayStrategy2;
        }
    }

    private void a() {
        if (this.b != null) {
            if (this.c == null) {
                this.c = e.E.p.a(this.b.a.f.b, e.E.I.getAbsolutePath(), null, this.b.a.f.a);
            }
            if (this.c != null) {
                this.c.addListener(this.e);
                this.c.setNeededNotify(false);
                this.c.download();
            }
        }
    }
}
