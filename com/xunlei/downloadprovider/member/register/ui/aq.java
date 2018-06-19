package com.xunlei.downloadprovider.member.register.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.R;

/* compiled from: RegisterSuccessActivity */
final class aq implements OnClickListener {
    final /* synthetic */ RegisterSuccessActivity a;

    aq(RegisterSuccessActivity registerSuccessActivity) {
        this.a = registerSuccessActivity;
    }

    public final void onClick(View view) {
        if (this.a.s) {
            this.a.p.setEnabled(true);
        }
        switch (view.getId()) {
            case R.id.layout_btn_gender_male:
                RegisterSuccessActivity.b(this.a, true);
                return;
            case R.id.layout_btn_gender_female:
                RegisterSuccessActivity.b(this.a, false);
                break;
            default:
                break;
        }
    }
}
