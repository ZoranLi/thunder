package com.xunlei.downloadprovider.personal.settings;

import com.xunlei.common.concurrent.XLCommandListener;
import com.xunlei.common.concurrent.XLCommandResult;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.b.e;

/* compiled from: SettingsIndexActivity */
final class x implements XLCommandListener {
    final /* synthetic */ SettingsIndexActivity a;

    x(SettingsIndexActivity settingsIndexActivity) {
        this.a = settingsIndexActivity;
    }

    public final void onResponse(XLCommandResult xLCommandResult) {
        if (!(xLCommandResult == null || xLCommandResult.data == null)) {
            if (xLCommandResult.isSuccessful()) {
                if (((Long) xLCommandResult.data).longValue() > 0 && this.a.h != null) {
                    this.a.h.setVisibility(0);
                    if (this.a.getBaseContext() != null) {
                        this.a.h.setText(this.a.getString(R.string.clean_room_rb_size, new Object[]{e.a(r0, 1)}));
                    }
                } else if (this.a.h != null) {
                    this.a.h.setVisibility(8);
                }
            }
        }
    }
}
