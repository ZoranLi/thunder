package com.xunlei.downloadprovider.download.privatespace.ui;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: PrivateSpaceFindPwdActivity */
final class b implements OnClickListener {
    final /* synthetic */ PrivateSpaceFindPwdActivity a;

    b(PrivateSpaceFindPwdActivity privateSpaceFindPwdActivity) {
        this.a = privateSpaceFindPwdActivity;
    }

    public final void onClick(View view) {
        if (this.a.k.isSelected() != null) {
            this.a.e.setTransformationMethod(PasswordTransformationMethod.getInstance());
            this.a.k.setSelected(false);
        } else {
            this.a.e.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            this.a.k.setSelected(true);
        }
        this.a.e.setSelection(this.a.e.getText().length());
    }
}
