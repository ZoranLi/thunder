package com.xunlei.downloadprovider.homepage.choiceness.jointactivity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: JointActivityItemView */
final class j implements OnClickListener {
    final /* synthetic */ JointActivityItemView a;

    j(JointActivityItemView jointActivityItemView) {
        this.a = jointActivityItemView;
    }

    public final void onClick(View view) {
        if (this.a.a != null) {
            this.a.a.a();
        }
    }
}
