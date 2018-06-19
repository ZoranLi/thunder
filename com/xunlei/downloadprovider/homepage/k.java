package com.xunlei.downloadprovider.homepage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: HomeFragment */
final class k extends BroadcastReceiver {
    final /* synthetic */ HomeFragment a;

    k(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        context = intent.getAction();
        if ("com.xunlei.downloadprovider.app.action.FOLLOW_DATA_UPDATED".equals(context) != null) {
            if (this.a.o == null) {
                if ("follow".equals(this.a.n) == null) {
                    this.a.c(false);
                }
            }
        } else if ("com.xunlei.downloadprovider.app.action.LIVE_DATA_UPDATED".equals(context) != null) {
            if (this.a.o == null) {
                if ("follow".equals(this.a.n) == null) {
                    this.a.c(true);
                }
            }
        } else if ("action_enter_full_screen_mode".equals(context) != null) {
            if (!(this.a.i == null || this.a.b == null)) {
                if (this.a.j != null) {
                    context = this.a.r;
                    if (context.h != null) {
                        context.g = true;
                        context.i.setVisibility(8);
                        context.k.setTranslationY(0.0f);
                        context.a(0);
                    }
                    this.a.b.setScrollble(false);
                    this.a.j.setVisibility(8);
                }
            }
        } else if ("action_exit_full_screen_mode".equals(context) != null) {
            if (!(this.a.i == null || this.a.b == null)) {
                if (this.a.j != null) {
                    this.a.r.a();
                    this.a.b.setScrollble(true);
                    this.a.j.setVisibility(0);
                }
            }
        } else if ("action_move_up".equals(context) != null) {
            context = this.a.r;
            if (context.h != null) {
                context.a(false);
                context.c = true;
            }
        } else {
            if ("action_move_down".equals(context) != null) {
                context = this.a.r;
                if (context.h != null) {
                    context.a(true);
                    context.c = false;
                }
            }
        }
    }
}
