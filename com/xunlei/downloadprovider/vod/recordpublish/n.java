package com.xunlei.downloadprovider.vod.recordpublish;

import android.graphics.Rect;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.taobao.accs.AccsClientConfig;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.g.a.b;

/* compiled from: VodPlayerPublishActivity */
final class n implements OnGlobalLayoutListener {
    final /* synthetic */ int a;
    final /* synthetic */ int b;
    final /* synthetic */ VodPlayerPublishActivity c;

    n(VodPlayerPublishActivity vodPlayerPublishActivity, int i, int i2) {
        this.c = vodPlayerPublishActivity;
        this.a = i;
        this.b = i2;
    }

    public final void onGlobalLayout() {
        Rect rect = new Rect();
        this.c.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = this.a - rect.height();
        if (height > this.a / 3) {
            this.c.c.setBackgroundColor(this.c.getResources().getColor(R.color.vod_player_record_publish_cover));
            this.c.c.scrollTo(0, height - this.b);
            if (!this.c.isFinishing()) {
                b.a("play_record", "title", AccsClientConfig.DEFAULT_CONFIGTAG);
            }
            return;
        }
        this.c.c.setBackgroundColor(0);
        this.c.c.scrollTo(0, 0);
        this.c.c();
    }
}
