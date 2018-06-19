package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.androidutil.ApkHelper;

/* compiled from: ChoicenessLivestreamItemView */
final class t implements OnClickListener {
    final /* synthetic */ ChoicenessLivestreamItemView a;

    t(ChoicenessLivestreamItemView choicenessLivestreamItemView) {
        this.a = choicenessLivestreamItemView;
    }

    public final void onClick(View view) {
        if (ApkHelper.isApkPackageInstalled(this.a.getContext(), "com.xunlei.tdlive") != null) {
            ApkHelper.launchAppByPackageName(this.a.getContext(), "com.xunlei.tdlive");
        } else {
            ChoicenessLivestreamItemView.d(this.a);
        }
    }
}
