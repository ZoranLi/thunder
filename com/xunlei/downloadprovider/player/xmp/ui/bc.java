package com.xunlei.downloadprovider.player.xmp.ui;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* compiled from: PlayerOperationViewDetail */
final class bc implements OnSeekBarChangeListener {
    final /* synthetic */ PlayerOperationViewDetail a;

    bc(PlayerOperationViewDetail playerOperationViewDetail) {
        this.a = playerOperationViewDetail;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.a.w != null) {
            this.a.w.a(z, i);
        }
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.a.e();
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        if (this.a.a.l()) {
            this.a.a();
        }
        this.a.a.a(seekBar.getProgress());
    }
}
