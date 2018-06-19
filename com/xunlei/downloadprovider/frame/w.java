package com.xunlei.downloadprovider.frame;

import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;

/* compiled from: MainTabActivity */
final class w extends BroadcastReceiver {
    final /* synthetic */ MainTabActivity a;

    w(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        if ("com.xunlei.downloadprovider.app.action.LIVE_DATA_UPDATED".equals(context)) {
            if ("xllive".equals(MainTabActivity.b(this.a).getCurrentTag()) == null) {
                MainTabActivity.a(this.a, intent.getIntExtra("follow_live_count", 0));
                MainTabActivity.a(this.a, "xllive", 0);
            }
        } else if ("action_enter_full_screen_mode".equals(context) != null) {
            context = this.a;
            context.d.setVisibility(8);
            if (!(context.j == null || context.j.isRunning() == null)) {
                context.j.cancel();
                context.j = null;
            }
            context.j = ObjectAnimator.ofFloat(context.d, View.TRANSLATION_Y, new float[]{(float) context.d.getHeight()});
            context.j.setDuration(300);
            context.j.start();
        } else if ("action_exit_full_screen_mode".equals(context) != null) {
            this.a.b();
        }
    }
}
