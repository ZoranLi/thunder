package com.xunlei.downloadprovider.member.register.ui;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.settings.HelpActivity;

/* compiled from: MobileSetupActivity */
final class r extends ClickableSpan {
    final /* synthetic */ MobileSetupActivity a;

    r(MobileSetupActivity mobileSetupActivity) {
        this.a = mobileSetupActivity;
    }

    public final void onClick(View view) {
        HelpActivity.a(this.a, "file:///android_asset/reg_protocol/protocol.html", this.a.getString(R.string.register_user_protocol));
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setUnderlineText(false);
        textPaint.setColor(-15559434);
    }
}
