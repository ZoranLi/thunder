package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;

/* compiled from: DownloadDetailsActivityFragment */
final class ap extends BroadcastReceiver {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    ap(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!(intent == null || this.a.i == null)) {
            if ("float_player_close_action".equals(intent.getAction()) != null) {
                this.a.i.w();
                context = intent.getIntExtra("key_float_player_close_position", this.a.i.k_());
                DownloadDetailsActivityFragment.q;
                if (this.a.i.e() - context < 500) {
                    this.a.i.a(0);
                } else {
                    this.a.i.a(context);
                    this.a.i.G();
                }
                intent.setExtrasClassLoader(SubtitleManifest.class.getClassLoader());
                SubtitleManifest subtitleManifest = (SubtitleManifest) intent.getSerializableExtra("KEY_FLOAT_PLAYER_SubtitleManifest");
                boolean z = true;
                if (!(subtitleManifest == null || this.a.i.h() == null)) {
                    this.a.i.h().a(subtitleManifest, true, true, false);
                }
                context = AppStatusChgObserver.b().a;
                if (intent.getBooleanExtra("key_need_play_after_float", false) == null || context == null) {
                    z = false;
                }
                this.a.i.d = false;
                if (DownloadDetailsActivityFragment.n(this.a) == null && r0 && this.a.i != null && this.a.i.E() == null) {
                    DownloadDetailsActivityFragment.q;
                    this.a.c(true);
                    return;
                }
                this.a.i.C();
                if (!(this.a.l == null || this.a.i.h == null)) {
                    DownloadDetailsActivityFragment.q;
                    this.a.l.o();
                }
            } else if ("float_player_open_action".equals(intent.getAction()) != null) {
                DownloadDetailsActivityFragment.q;
                if (this.a.i != null) {
                    this.a.i.C();
                    this.a.i.v();
                }
            }
        }
    }
}
