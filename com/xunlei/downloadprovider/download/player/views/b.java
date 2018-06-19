package com.xunlei.downloadprovider.download.player.views;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: DownloadVodPlayerView */
final class b extends BroadcastReceiver {
    final /* synthetic */ DownloadVodPlayerView a;

    b(DownloadVodPlayerView downloadVodPlayerView) {
        this.a = downloadVodPlayerView;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        DownloadVodPlayerView.p();
        intent = context.hashCode();
        if (intent != -1248471500) {
            if (intent == 1891174264) {
                if (context.equals("ACTION_PLAYERVIEW_PROGRESS_BAR_StopTrackingTouch") != null) {
                    context = true;
                    switch (context) {
                        case null:
                            DownloadVodPlayerView.p();
                            this.a.k();
                            return;
                        case 1:
                            DownloadVodPlayerView.p();
                            this.a.j();
                            break;
                        default:
                            break;
                    }
                }
            }
        } else if (context.equals("ACTION_PLAYERVIEW_PROGRESS_BAR_StartTrackingTouch") != null) {
            context = null;
            switch (context) {
                case null:
                    DownloadVodPlayerView.p();
                    this.a.k();
                    return;
                case 1:
                    DownloadVodPlayerView.p();
                    this.a.j();
                    break;
                default:
                    break;
            }
        }
        context = -1;
        switch (context) {
            case null:
                DownloadVodPlayerView.p();
                this.a.k();
                return;
            case 1:
                DownloadVodPlayerView.p();
                this.a.j();
                break;
            default:
                break;
        }
    }
}
