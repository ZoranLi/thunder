package com.xunlei.downloadprovider.download.player.a;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.xunlei.downloadprovider.player.a;

/* compiled from: PlayerMenuController */
final class ah implements OnSeekBarChangeListener {
    final /* synthetic */ af a;

    ah(af afVar) {
        this.a = afVar;
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        a.b("voice");
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        af.c;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            this.a.g = (float) i;
            af.b(this.a);
        }
    }
}
