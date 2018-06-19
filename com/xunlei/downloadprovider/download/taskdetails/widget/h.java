package com.xunlei.downloadprovider.download.taskdetails.widget;

import android.view.View;
import com.xunlei.downloadprovider.download.taskdetails.newui.DownloadDetailsActivityFragment;

/* compiled from: TaskExpendFloatingViewModel */
public final class h {
    public View a;
    public boolean b = false;
    public boolean c = false;
    private DownloadDetailsActivityFragment d;

    public h(View view, DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = view;
        this.d = downloadDetailsActivityFragment;
    }

    public final void a(boolean z) {
        this.c = z;
        if (z) {
            if (this.b) {
                a((int) false);
            }
            return;
        }
        a((int) true);
    }

    public final void a(int i) {
        if (this.a != null) {
            if (i == 0 && this.b && this.c && !this.d.n) {
                this.a.setVisibility(i);
                return;
            }
            this.a.setVisibility(8);
        }
    }

    public final void b(boolean z) {
        this.b = z;
        if (!z) {
            a((int) true);
        }
    }
}
