package com.xunlei.downloadprovider.download.player.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.bugly.crashreport.CrashReport;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.kernel.i;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.vod.dlna.b;

/* compiled from: DNLAController */
public class g extends f implements OnClickListener {
    private static final String a = "g";
    private ImageButton b = null;
    private a c;
    private BroadcastReceiver d = null;
    private Context g;
    private Handler h = new Handler(Looper.getMainLooper());
    private b i = null;

    /* compiled from: DNLAController */
    class a {
        String a;
        boolean b;
        final /* synthetic */ g c;

        a(g gVar) {
            this.c = gVar;
        }
    }

    public g(com.xunlei.downloadprovider.download.player.a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
        this.g = downloadVodPlayerView.getContext();
        this.b = (ImageButton) this.e.findViewById(R.id.btn_dlna);
        this.b.setOnClickListener(this);
        this.b.setVisibility(8);
        if (this.d == null) {
            this.d = new h(this);
            c.a(this.g, "ACTION_OnCompletion", this.d);
            c.a(this.g, "ACTION_OnPrepared", this.d);
        }
    }

    public final void b(boolean z) {
        if (this.b != null) {
            this.b.setVisibility(z ? false : true);
        }
    }

    private void m() {
        if (this.i != null) {
            b bVar = this.i;
            bVar.b = true;
            bVar.d();
            bVar.e();
            bVar.c();
            if (bVar.i != null && bVar.i.isShowing()) {
                bVar.i.dismiss();
            }
            bVar.e.clear();
            this.i = null;
        }
    }

    public final void a(boolean z) {
        super.a(z);
        b(z);
        if (!z) {
            m();
        }
    }

    public final void d() {
        if (this.d != null) {
            c.a(this.g, this.d);
        }
        m();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.btn_dlna) {
            this.e.e();
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_player", "player_dlna_click"));
            q.a().a((Activity) this.g, "com.xunlei.plugin.libdlna", new k(this));
        }
    }

    static /* synthetic */ a b(g gVar) {
        boolean I;
        Object J;
        a aVar = new a(gVar);
        String str = "";
        if (gVar.f() != null) {
            I = gVar.f().I();
            J = gVar.f().J();
        } else {
            J = str;
            I = false;
        }
        if (I) {
            J = i.a(gVar.g, J, false);
        }
        if (TextUtils.isEmpty(J) == null) {
            aVar.a = J;
            aVar.b = true;
        } else {
            aVar.b = false;
        }
        return aVar;
    }

    static /* synthetic */ void e(g gVar) {
        int k_;
        if (gVar.f() != null) {
            if (gVar.f().E()) {
                gVar.f().C();
                gVar.e.e();
            }
            k_ = gVar.f().k_();
        } else {
            k_ = 0;
        }
        if (gVar.i == null) {
            try {
                gVar.i = new b((Activity) gVar.g, new l(gVar));
            } catch (Throwable e) {
                e.printStackTrace();
                CrashReport.postCatchedException(e);
            }
        }
        if (gVar.i != null && gVar.c != null) {
            b bVar = gVar.i;
            String m = gVar.f() != null ? gVar.f().m() : "";
            gVar = gVar.c.a;
            bVar.f = null;
            bVar.h = m;
            bVar.g = gVar;
            bVar.d = k_;
            if (bVar.i != null && bVar.i.isShowing() == null && bVar.c.isFinishing() == null) {
                bVar.b();
                bVar.i.setContentView(bVar.a);
                bVar.a();
                if (com.xunlei.downloadprovider.vod.dlna.a.a().b() != null) {
                    try {
                        com.xunlei.downloadprovider.vod.dlna.a.a().b().c();
                    } catch (g gVar2) {
                        gVar2.printStackTrace();
                    }
                }
                bVar.i.show();
            }
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_player", "player_dlna_show"));
        }
    }
}
