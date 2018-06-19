package com.xunlei.downloadprovider.download.taskdetails.items;

import com.xunlei.downloadprovider.download.util.j;

/* compiled from: DetailBtTaskSubFileViewHolder */
final class e implements Runnable {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
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
                    b.h(this.a);
                }
                return;
            }
            b.h(this.a);
        }
    }
}
