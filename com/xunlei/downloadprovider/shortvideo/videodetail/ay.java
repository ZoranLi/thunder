package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: ShortMovieDetailFragment */
final class ay extends BroadcastReceiver {
    final /* synthetic */ ShortMovieDetailFragment a;

    ay(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("action_comment_zan_state_changed".contentEquals(intent.getAction()) != null) {
            context = ShortMovieDetailFragment.a;
            ShortMovieDetailFragment.a(this.a, intent);
        }
    }
}
