package com.alibaba.sdk.android.feedback.windvane;

import android.view.View;
import android.view.View.OnClickListener;

class h implements OnClickListener {
    final /* synthetic */ e a;

    h(e eVar) {
        this.a = eVar;
    }

    public void onClick(View view) {
        this.a.getActivity().finish();
    }
}
