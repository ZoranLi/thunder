package com.xunlei.downloadprovider.download.player.a;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.xunlei.downloadprovider.player.a;

/* compiled from: PlayerMenuController */
final class ai implements OnSeekBarChangeListener {
    final /* synthetic */ af a;

    public final void onStartTrackingTouch(SeekBar seekBar) {
    }

    ai(af afVar) {
        this.a = afVar;
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        a.b("brightness");
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.a.h = (float) i;
            af.c(this.a);
        }
    }
}
