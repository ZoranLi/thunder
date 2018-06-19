package com.xunlei.downloadprovider.personal.settings;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: SettingsIndexActivity */
final class ac implements OnClickListener {
    final /* synthetic */ SettingsIndexActivity a;

    ac(SettingsIndexActivity settingsIndexActivity) {
        this.a = settingsIndexActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.a.q != null) {
            this.a.q.dismiss();
        }
    }
}
