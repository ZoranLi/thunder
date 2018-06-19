package com.xunlei.downloadprovider.download.player.a;

import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.player.a;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;

/* compiled from: GuideTipsController */
public class ae extends f implements OnClickListener {
    View a;

    public final void d() {
    }

    public ae(a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
    }

    private void b(boolean z) {
        if (z) {
            if (!this.a) {
                ((ViewStub) this.e.findViewById(R.id.stub_first_use)).inflate();
                this.a = this.e.findViewById(R.id.iv_first_use_tip);
                this.a.setOnClickListener(this);
            }
            this.a.setVisibility(0);
            return;
        }
        if (this.a) {
            this.a.setVisibility(8);
        }
        this.a = false;
        this.e.f();
        this.e.j();
    }

    private SharedPreferences m() {
        return n().getSharedPreferences("vod_player", 0);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_first_use_tip) {
            b(null);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (z) {
            z = m();
            if (z.getBoolean("is_show_default_player_tips", false)) {
                z = m();
                if (!z.getBoolean("is_show_first_downloading_play_tips", false)) {
                    XLToast.showToast(n(), n().getString(R.string.downloading_play_toast));
                    z = z.edit();
                    z.putBoolean("is_show_first_downloading_play_tips", true);
                    z.commit();
                }
            } else {
                z.edit().putBoolean("is_show_default_player_tips", true).apply();
                b(true);
            }
        }
    }
}
