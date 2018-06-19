package com.xunlei.downloadprovider.vod.floatwindow;

import android.media.AudioManager.OnAudioFocusChangeListener;

/* compiled from: VodPlayerFloatWindow */
final class n implements OnAudioFocusChangeListener {
    final /* synthetic */ a a;

    n(a aVar) {
        this.a = aVar;
    }

    public final void onAudioFocusChange(int i) {
        if (i == -2) {
            a.v;
            if (!(this.a.g == 0 || this.a.g.t() == 0)) {
                this.a.c();
            }
        } else if (i == 1) {
            a.v;
            if (this.a.g != 0 && this.a.g.t() == 0 && this.a.k == 0) {
                this.a.b();
            }
        } else if (i == -1) {
            a.v;
            if (!(this.a.g == 0 || this.a.g.t() == 0)) {
                this.a.c();
            }
        }
    }
}
