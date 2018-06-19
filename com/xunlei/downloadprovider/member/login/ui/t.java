package com.xunlei.downloadprovider.member.login.ui;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.e.c;
import java.io.ByteArrayOutputStream;

/* compiled from: LoginActivity */
final class t implements c {
    final /* synthetic */ LoginActivity a;

    t(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    public final void a(int i, String str, byte[] bArr) {
        LoginActivity.D(this.a);
        if (i == XLErrorCode.UNKNOWN_ERROR) {
            LoginActivity.c(this.a, R.string.user_account_getverifycode_error);
        }
        LoginActivity.x(this.a).setVisibility(8);
        if (i != 0 || str == null || bArr == null) {
            LoginActivity.E(this.a);
            return;
        }
        LoginActivity.w(this.a).setText("");
        i = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (i == 0) {
            LoginActivity.b(this.a, null);
            LoginActivity.E(this.a);
            return;
        }
        LoginActivity.b(this.a, str);
        i.compress(CompressFormat.JPEG, 50, new ByteArrayOutputStream());
        LoginActivity.r(this.a).setImageBitmap(i);
        LoginActivity.F(this.a);
        LoginActivity.t(this.a);
    }
}
