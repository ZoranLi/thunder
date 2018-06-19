package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ShortMovieDetailFragment */
final class bo extends BroadcastReceiver {
    final /* synthetic */ ShortMovieDetailFragment a;

    bo(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        if ("new_follow".equals(context) != null || "cancel_follow".equals(context) != null || "new_user_login_success".equals(context) != null || "user_logout".equals(context) != null) {
            this.a.a();
        }
    }
}
