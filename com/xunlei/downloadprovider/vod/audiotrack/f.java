package com.xunlei.downloadprovider.vod.audiotrack;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* compiled from: VodPlayerAudioTrackPopupWindow */
final class f implements OnItemClickListener {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.a.b != null && this.a.f != i) {
            this.a.a(i, null);
        }
    }
}
