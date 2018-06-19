package com.xunlei.downloadprovider.personal.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: MessageItemFragment */
final class f extends BroadcastReceiver {
    final /* synthetic */ MessageItemFragment a;

    f(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("following_id_list_loaded".equals(intent.getAction()) != null) {
            MessageItemFragment.c;
            if (this.a.f != null) {
                this.a.f.notifyDataSetChanged();
            }
        }
    }
}
