package com.tencent.bugly.beta.download;

import android.content.Context;
import android.content.Intent;
import com.tencent.bugly.beta.global.a;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.c;
import com.tencent.bugly.beta.ui.g;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.proguard.an;
import com.tencent.open.SocialConstants;

/* compiled from: BUGLY */
class BetaReceiver$1 implements Runnable {
    final /* synthetic */ Intent a;
    final /* synthetic */ Context b;
    final /* synthetic */ BetaReceiver c;

    BetaReceiver$1(BetaReceiver betaReceiver, Intent intent, Context context) {
        this.c = betaReceiver;
        this.a = intent;
        this.b = context;
    }

    public void run() {
        try {
            if (this.a.getAction().equals(BetaReceiver.CONNECTIVITY_CHANGE)) {
                int i = BetaReceiver.netStatus;
                BetaReceiver.netStatus = a.a(this.b);
                for (c a : BetaReceiver.netListeners.values()) {
                    a.a(i, BetaReceiver.netStatus);
                }
                return;
            }
            if (this.a.getAction().equals(c.a.c)) {
                switch (this.a.getIntExtra(SocialConstants.TYPE_REQUEST, -1)) {
                    case 1:
                        DownloadTask downloadTask = c.a.b;
                        if (downloadTask != null) {
                            switch (downloadTask.getStatus()) {
                                case 0:
                                case 3:
                                case 4:
                                case 5:
                                    BetaReceiver.addTask(downloadTask);
                                    downloadTask.download();
                                    break;
                                case 1:
                                    a.a(e.E.s, downloadTask.getSaveFile(), downloadTask.getMD5());
                                    break;
                                case 2:
                                    BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                                    downloadTask.stop();
                                    break;
                                default:
                                    break;
                            }
                            if (com.tencent.bugly.beta.upgrade.c.a.e == null && h.v != null) {
                                h.v.a(downloadTask);
                            }
                            return;
                        }
                        return;
                    case 2:
                        g.a(c.a.e, true, true, 0);
                        break;
                    default:
                        break;
                }
            }
        } catch (Throwable e) {
            if (!an.b(e)) {
                e.printStackTrace();
            }
        }
    }
}
