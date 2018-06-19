package com.xunlei.downloadprovider.download.center.widget;

import android.os.Message;
import com.xunlei.common.commonview.DownloadEntranceView;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.task.h;

/* compiled from: DownloadEntranceMonitor */
public final class v extends as {
    private DownloadEntranceView c;

    public v(DownloadEntranceView downloadEntranceView) {
        this.c = downloadEntranceView;
    }

    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i != 942910) {
            switch (i) {
                case 113:
                    if (!this.c.isAnimating()) {
                        a(true);
                        break;
                    }
                    c().removeMessages(942910);
                    c().sendEmptyMessageDelayed(942910, 200);
                    return true;
                case 114:
                    i = message.arg1;
                    int i2 = message.arg2;
                    if (i2 != 0 || i == 0) {
                        if (i2 != 0) {
                            a(i2, false);
                            break;
                        }
                    }
                    this.c.showUnread();
                    break;
                    break;
                default:
                    break;
            }
        } else if (this.c.isAnimating()) {
            c().removeMessages(942910);
            c().sendEmptyMessageDelayed(942910, 200);
        } else {
            a(false);
        }
        return super.handleMessage(message);
    }

    public final void a() {
        a(false);
        super.a();
    }

    public final void b() {
        super.b();
        this.c.cancelNewTaskAnimation();
    }

    public final void a(boolean z) {
        h.e();
        int unfinishedUnIllegalCount = h.d().getUnfinishedUnIllegalCount();
        if (unfinishedUnIllegalCount > 0) {
            a(unfinishedUnIllegalCount, z);
            return;
        }
        n.a();
        if (n.m()) {
            this.c.showUnread();
        } else {
            this.c.showNothing();
        }
    }

    private void a(int i, boolean z) {
        if (z) {
            this.c.setNumTextAnimate(i);
        } else {
            this.c.setNumText(i);
        }
        this.c.clearUnread();
    }
}
