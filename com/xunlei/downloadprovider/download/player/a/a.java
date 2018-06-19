package com.xunlei.downloadprovider.download.player.a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.vod.audiotrack.b;
import com.xunlei.downloadprovider.vod.audiotrack.e;
import com.xunlei.downloadprovider.vodnew.a.e.o;
import java.util.List;

/* compiled from: AudioTrackController */
public class a extends f implements OnClickListener {
    private static final String b = "a";
    public int a = -1;
    private ImageView c;
    private e d;
    private b g = new b();
    private o.e h = new b(this);

    public final void d() {
    }

    public a(com.xunlei.downloadprovider.download.player.a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
        this.c = (ImageView) downloadVodPlayerView.findViewById(R.id.btn_audiotrack);
        this.c.setOnClickListener(this);
        this.c.setVisibility(8);
        if (n() != null) {
            this.d = new e(n());
            this.d.b = new c(this);
            this.d.setOnDismissListener(new d(this));
        }
        if (aVar != null && aVar.f() != null) {
            aVar.f().a(this.h);
        }
    }

    private void r() {
        boolean g = d.a().i.g();
        List a;
        if (f() != null) {
            a = this.g.a(f().a);
            new StringBuilder("setAudioTrackBtnShow, 音轨数目： ").append(a.size());
        } else {
            a = null;
        }
        if (!g || r1 == null || r1.size() < 2 || !this.f) {
            this.c.setVisibility(8);
            return;
        }
        this.c.setVisibility(0);
        String str = "unknown";
        if (f() != null) {
            String m = f().m();
            if (!TextUtils.isEmpty(m)) {
                int lastIndexOf = m.lastIndexOf(46);
                if (lastIndexOf >= 0) {
                    str = m.substring(lastIndexOf, m.length());
                }
            }
        }
        StatEvent build = HubbleEventBuilder.build("android_play", "player_audioselect_show");
        build.add("suffix", str);
        ThunderReport.reportEvent(build);
    }

    public final void a(List<com.xunlei.downloadprovider.vod.audiotrack.a> list) {
        if (a() != null) {
            this.a = a().audioTrackIndex;
        }
        a aVar = this.d.a;
        aVar.a = list;
        aVar.notifyDataSetChanged();
        this.d.a(this.e);
        if (this.a >= 0) {
            int i;
            int i2 = this.a;
            if (list != null) {
                i = 0;
                while (i < list.size()) {
                    if (((com.xunlei.downloadprovider.vod.audiotrack.a) list.get(i)).a == i2) {
                        break;
                    }
                    i++;
                }
            }
            i = -1;
            if (i >= 0) {
                this.d.a(i, true);
                return;
            } else {
                this.d.a(0, true);
                return;
            }
        }
        this.d.a(0, true);
    }

    public final void a(boolean z) {
        super.a(z);
        if (!z && this.d && this.d.isShowing()) {
            this.d.dismiss();
        }
        r();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_audiotrack) {
            if (this.e != null) {
                this.e.postDelayed(new e(this), 100);
            }
        }
    }
}
