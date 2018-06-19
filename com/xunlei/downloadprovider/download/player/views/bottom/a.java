package com.xunlei.downloadprovider.download.player.views.bottom;

import android.content.Context;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.c;

/* compiled from: PlayerBottomViewGroup */
final class a implements OnSeekBarChangeListener {
    final /* synthetic */ PlayerBottomViewGroup a;

    a(PlayerBottomViewGroup playerBottomViewGroup) {
        this.a = playerBottomViewGroup;
    }

    public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (this.a.f != null) {
            this.a.f.a(i, z);
        }
        this.a.i.setText(PlayerBottomViewGroup.a(i));
        PlayerBottomViewGroup.b;
        seekBar = new StringBuilder("progressbar  :--------   ");
        seekBar.append(i);
        seekBar.append("  max: ");
        seekBar.append(this.a.j.getMax());
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        this.a.n = true;
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        new StringBuilder("seekBar.getContext() : ").append(seekBar.getContext());
        c.a(applicationInstance, "ACTION_PLAYERVIEW_PROGRESS_BAR_StartTrackingTouch", null);
        if (this.a.f != null) {
            this.a.f.a(seekBar.getProgress());
        }
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        this.a.n = false;
        StringBuilder stringBuilder = new StringBuilder("seekBar.getContext()2 : ");
        stringBuilder.append(seekBar.getContext());
        stringBuilder.append("  progress: ");
        stringBuilder.append(seekBar.getProgress());
        c.a(BrothersApplication.getApplicationInstance(), "ACTION_PLAYERVIEW_PROGRESS_BAR_StopTrackingTouch", null);
        if (this.a.f != null) {
            this.a.f.b(seekBar.getProgress());
        }
    }
}
