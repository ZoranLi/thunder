package com.xunlei.downloadprovider.player.xmp.ui;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* compiled from: PlayerOperationViewDefault */
final class aq implements OnSeekBarChangeListener {
    final /* synthetic */ PlayerOperationViewDefault a;

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    aq(PlayerOperationViewDefault playerOperationViewDefault) {
        this.a = playerOperationViewDefault;
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.a.a();
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.a.b();
        this.a.a.a(seekBar.getProgress());
    }
}
