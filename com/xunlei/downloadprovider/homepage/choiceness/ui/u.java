package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.homepage.choiceness.b;

/* compiled from: HomeChoicenessFragment */
final class u extends BroadcastReceiver {
    final /* synthetic */ HomeChoicenessFragment a;

    u(HomeChoicenessFragment homeChoicenessFragment) {
        this.a = homeChoicenessFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("following_id_list_loaded".equals(intent.getAction()) != null) {
            if (this.a.f != null) {
                this.a.f.a(this.a.h.e);
            }
        } else if ("user_logout".equals(intent.getAction()) != null) {
            if (this.a.f != null) {
                this.a.f.c();
            }
        } else if ("live_viewfinder_show".equals(intent.getAction()) != null) {
            if (this.a.f != null) {
                this.a.d.setVisibility(0);
                b.a().a(intent.getStringExtra("live_player_image"), this.a.d, null);
            }
        } else if (!("live_viewfinder_hide".equals(intent.getAction()) == null || this.a.f == null)) {
            this.a.d.setVisibility(8);
        }
    }
}
