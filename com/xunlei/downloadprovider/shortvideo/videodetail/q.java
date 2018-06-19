package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.content.Context;
import android.content.Intent;
import com.igexin.sdk.PushConsts;
import com.xunlei.downloadprovider.broadcast.b;

/* compiled from: ShortMovieDetailActivity */
final class q extends b {
    final /* synthetic */ ShortMovieDetailActivity a;

    q(ShortMovieDetailActivity shortMovieDetailActivity) {
        this.a = shortMovieDetailActivity;
    }

    public final void a(Context context, Intent intent) {
        if (this.a.f != null) {
            context = this.a.f;
            if (intent.getAction().equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE) && intent.getBooleanExtra("noConnectivity", false) == null) {
                context.b();
            }
        }
    }
}
