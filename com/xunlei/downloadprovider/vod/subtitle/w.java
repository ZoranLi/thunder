package com.xunlei.downloadprovider.vod.subtitle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: VodPlayerSubtitlePopupWindow */
final class w implements OnItemClickListener {
    final /* synthetic */ u a;

    w(u uVar) {
        this.a = uVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.a.b != null) {
            if (this.a.g == i) {
                i = -1;
            }
            this.a.a(i, null);
        }
    }
}
