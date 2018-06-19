package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.xllib.android.b;

/* compiled from: HomeChoicenessFragment */
final class j implements OnClickListener {
    final /* synthetic */ HomeChoicenessFragment a;

    j(HomeChoicenessFragment homeChoicenessFragment) {
        this.a = homeChoicenessFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.b.setVisibility(8);
            this.a.a(ChoicenessReporter$RefreshType.manul_pull);
        }
    }
}
