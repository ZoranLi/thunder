package com.xunlei.downloadprovider.publiser.common.guide.interesttag;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.xunlei.downloadprovider.publiser.common.guide.interesttag.a.b;

/* compiled from: GuideInterestTagActivity */
final class a implements OnCheckedChangeListener {
    final /* synthetic */ GuideInterestTagActivity a;

    a(GuideInterestTagActivity guideInterestTagActivity) {
        this.a = guideInterestTagActivity;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        compoundButton = compoundButton.getTag();
        if (compoundButton instanceof b) {
            this.a.a.a((b) compoundButton, z);
        }
    }
}
