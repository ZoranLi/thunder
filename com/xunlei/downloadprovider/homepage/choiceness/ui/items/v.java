package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xunlei.downloadprovider.launch.b.a;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;

/* compiled from: ChoicenessLivestreamItemView */
final class v extends BroadcastReceiver {
    final /* synthetic */ ChoicenessLivestreamItemView a;

    v(ChoicenessLivestreamItemView choicenessLivestreamItemView) {
        this.a = choicenessLivestreamItemView;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("com.xunlei.action.ACTION_VOLUME_UP_KEY_DOWN".equals(intent.getAction()) != null) {
            a.a().enableLivePlaySpk(this.a.getContext(), this.a.c.l, true);
            if (ChoicenessLivestreamItemView.h() != null) {
                ThunderXmpPlayer.d();
            }
        }
    }
}
