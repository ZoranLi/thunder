package com.xunlei.downloadprovider.ad.taskdetailnew;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.f;

/* compiled from: TaskDetailNewImageAdController */
final class g implements OnClickListener {
    final /* synthetic */ f a;

    g(f fVar) {
        this.a = fVar;
    }

    public final void onClick(View view) {
        if (this.a.e != null) {
            this.a.b(this.a.e);
            this.a.e.onClick(view);
            if (f.a(this.a.e) != null && this.a.e.u() == 2) {
                f.a(this.a.e);
            }
        }
    }
}
