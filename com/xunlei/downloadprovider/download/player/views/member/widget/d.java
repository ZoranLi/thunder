package com.xunlei.downloadprovider.download.player.views.member.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MemberActionView */
final class d implements OnClickListener {
    final /* synthetic */ MemberActionView a;

    d(MemberActionView memberActionView) {
        this.a = memberActionView;
    }

    public final void onClick(View view) {
        view = this.a.getTaskInfo();
        if (TextUtils.equals(this.a.getText(), "加速试用")) {
            MemberActionView.a(this.a, view);
        } else {
            MemberActionView.b(this.a, view);
        }
    }
}
