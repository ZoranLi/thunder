package com.xunlei.downloadprovider.launch.dispatch;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xunlei.downloadprovider.download.b;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovider.web.a;

/* compiled from: ClipboardDISP */
public final class f extends b {
    private Intent a;

    protected final boolean a(Intent intent) {
        this.a = intent;
        if (this.a == null || this.a.getIntExtra("dispatch_from_key", -1) != 1117) {
            return null;
        }
        this.a = intent;
        return true;
    }

    protected final void a(Context context) {
        int intExtra = this.a.getIntExtra("type", -1);
        if (intExtra == 2) {
            String stringExtra = this.a.getStringExtra("url");
            a.a();
            a.a(context, stringExtra, false, BrowserFrom.THIRDAPP_URL_INPUT);
            return;
        }
        if (intExtra == 1) {
            stringExtra = this.a.getStringExtra("url");
            boolean booleanExtra = this.a.getBooleanExtra("isAutoComplemented", false);
            String stringExtra2 = this.a.getStringExtra("origins");
            if (TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = "out_app/out_app_paste";
            }
            b.a(context, stringExtra, stringExtra2, "out_app", booleanExtra);
        }
    }
}
