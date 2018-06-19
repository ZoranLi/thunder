package com.xunlei.downloadprovider.personal.message;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: MessageItemFragment */
final class s implements a {
    final /* synthetic */ MessageItemFragment a;

    s(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void a() {
        if (this.a.f != null) {
            this.a.f.notifyDataSetChanged();
        }
    }

    public final void a(String str) {
        XLToast.showToast(this.a.getContext(), com.xunlei.downloadprovider.homepage.follow.a.a(str));
    }
}
