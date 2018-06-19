package com.xunlei.downloadprovider.member.login.ui;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.widget.LinearLayout.LayoutParams;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.e.c;
import java.io.ByteArrayOutputStream;

/* compiled from: LoginActivity */
final class j implements c {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void a(int i, String str, byte[] bArr) {
        if (i == XLErrorCode.UNKNOWN_ERROR) {
            LoginActivity.c(this.a.a, R.string.user_account_getverifycode_error);
        }
        if (i != 0 || str == null || bArr == null) {
            LoginActivity.r(this.a.a).setImageResource(R.drawable.bg_validcode_fail);
            LoginActivity.s(this.a.a);
        } else {
            bArr = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (bArr == null) {
                LoginActivity.b(this.a.a, null);
                LoginActivity.r(this.a.a).setImageResource(R.drawable.bg_validcode_fail);
                LoginActivity.s(this.a.a);
                return;
            }
            LoginActivity.b(this.a.a, str);
            bArr.compress(CompressFormat.JPEG, 50, new ByteArrayOutputStream());
            LoginActivity.r(this.a.a).setImageBitmap(bArr);
            LoginActivity.a(this.a.a, LoginActivity.o(this.a.a).getVisibility() != 8 ? 1 : null);
            LoginActivity.o(this.a.a).setVisibility(0);
            ai.a(HubbleEventBuilder.build("android_user_login", "user_login_verify"));
            LoginActivity.t(this.a.a);
            LoginActivity.u(this.a.a).setVisibility(8);
            str = new LayoutParams(LoginActivity.v(this.a.a).getLayoutParams());
            str.setMargins(0, DipPixelUtil.dip2px(1099956224), 0, 0);
            LoginActivity.v(this.a.a).setLayoutParams(str);
            this.a.a.a(false, false);
            LoginActivity.b(this.a.a, LoginActivity.w(this.a.a));
            LoginActivity.b(this.a.a, 6);
        }
        LoginActivity.x(this.a.a).setVisibility(8);
    }
}
