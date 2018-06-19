package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import com.xunlei.downloadprovider.download.util.j;

/* compiled from: DetailBtSubTaskViewHolder */
final class i implements Runnable {
    final /* synthetic */ g a;

    i(g gVar) {
        this.a = gVar;
    }

    public final void run() {
        if (!this.a.f.g) {
            if (j.a().a) {
                long currentTimeMillis = System.currentTimeMillis();
                long j = j.a().b;
                if (currentTimeMillis - j > 1000) {
                    StringBuilder stringBuilder = new StringBuilder("进入编辑模式, currentMillis = ");
                    stringBuilder.append(currentTimeMillis);
                    stringBuilder.append(" dragViewOnScrollingStopTime = ");
                    stringBuilder.append(j);
                    j.a().a = false;
                    g.h(this.a);
                }
                return;
            }
            g.h(this.a);
        }
    }
}
