package com.huawei.hms.update.e;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import com.huawei.android.hms.base.R;

/* compiled from: InstallConfirm */
public class i extends b {
    protected AlertDialog a() {
        int i = R.string.hms_update_message_new;
        int i2 = R.string.hms_install;
        Builder builder = new Builder(f(), g());
        builder.setMessage(f().getString(i, new Object[]{f().getString(R.string.hms_update_title)}));
        builder.setPositiveButton(i2, new j(this));
        builder.setNegativeButton(R.string.hms_cancel, new k(this));
        return builder.create();
    }
}
