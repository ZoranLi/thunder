package com.xunlei.downloadprovider.player.xmp.ui;

import android.media.AudioManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;

/* compiled from: PlayerOperationViewDefault */
final class ap implements OnClickListener {
    final /* synthetic */ PlayerOperationViewDefault a;

    ap(PlayerOperationViewDefault playerOperationViewDefault) {
        this.a = playerOperationViewDefault;
    }

    public final void onClick(View view) {
        view = this.a.a.n();
        if (view != null) {
            boolean z = this.a.a.p;
            if (this.a.a.p) {
                AudioManager audioManager = (AudioManager) this.a.getContext().getSystemService("audio");
                if (audioManager.getStreamVolume(3) == 0) {
                    audioManager.setStreamVolume(3, audioManager.getStreamMaxVolume(3) / 3, 4);
                }
                this.a.a.d(z ^ 1);
                ChoicenessReporter.a(view.d, "sound_open", "");
                return;
            }
            this.a.a.d(z ^ 1);
            ChoicenessReporter.a(view.d, "sound_close", "");
        }
    }
}
