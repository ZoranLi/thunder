package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.os.Process;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.ui.a;
import com.tencent.bugly.beta.ui.e;
import com.tencent.bugly.beta.ui.f;
import com.tencent.bugly.beta.ui.g;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;

/* compiled from: BUGLY */
public class b implements OnClickListener {
    final int a;
    final Object[] b;

    public b(int i, Object... objArr) {
        this.a = i;
        this.b = objArr;
    }

    public void onClick(View view) {
        try {
            h hVar;
            switch (this.a) {
                case 1:
                    if (((ViewGroup) r1.b[1]).getChildCount() <= 0) {
                        ((Activity) r1.b[0]).finish();
                        an.a("BetaAct closed by empty view", new Object[0]);
                        return;
                    }
                    break;
                case 2:
                    ((a) r1.b[0]).a();
                    return;
                case 3:
                    if (r1.b[1] != null) {
                        ((DownloadTask) r1.b[1]).download();
                    }
                    ((a) r1.b[0]).a();
                    return;
                case 4:
                    hVar = (h) r1.b[0];
                    DownloadTask downloadTask = hVar.q;
                    y yVar = hVar.p;
                    BetaReceiver.addTask(downloadTask);
                    if (hVar.r != null) {
                        hVar.r.run();
                    }
                    if (downloadTask.getStatus() == 1 && a.a(e.E.s, downloadTask.getSaveFile(), yVar.f.a)) {
                        p.a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0, yVar.e, yVar.m, yVar.p, null));
                    } else {
                        int a = a.a(e.E.s);
                        if (!(a == 4 || a == 3)) {
                            if (a != 2) {
                                downloadTask.download();
                            }
                        }
                        com.tencent.bugly.beta.ui.b fVar = new f();
                        fVar.n = downloadTask;
                        g.a(fVar, true);
                    }
                    if (yVar.g != (byte) 2) {
                        hVar.a();
                    }
                    return;
                case 5:
                    hVar = (h) r1.b[0];
                    DownloadTask downloadTask2 = hVar.q;
                    BetaReceiver.netListeners.remove(downloadTask2.getDownloadUrl());
                    downloadTask2.stop();
                    hVar.a(downloadTask2);
                    return;
                case 6:
                    hVar = (h) r1.b[0];
                    if (hVar.s != null) {
                        hVar.s.run();
                    }
                    hVar.a();
                    return;
                case 7:
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                    return;
                case 8:
                    ((e) r1.b[0]).a();
                    break;
                default:
                    break;
            }
        } catch (Throwable e) {
            Throwable th = e;
            if (!an.b(th)) {
                th.printStackTrace();
            }
        }
    }
}
