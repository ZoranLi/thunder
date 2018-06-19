package com.xunlei.downloadprovider.download.player.a;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

/* compiled from: PlayerMenuController */
final class ak implements OnKeyListener {
    final /* synthetic */ af a;

    ak(af afVar) {
        this.a = afVar;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        switch (i) {
            case 24:
                this.a.g = this.a.g + 6.6666665f;
                if (this.a.g > 1120403456) {
                    this.a.g = 100.0f;
                }
                af.b(this.a);
                this.a.a((int) this.a.g);
                return true;
            case 25:
                this.a.g = this.a.g - 6.6666665f;
                if (this.a.g < 0) {
                    this.a.g = 0.0f;
                }
                af.b(this.a);
                this.a.a((int) this.a.g);
                return true;
            default:
                return null;
        }
    }
}
