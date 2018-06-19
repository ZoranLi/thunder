package com.xunlei.downloadprovider.personal.message;

import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: MessageItemFragment */
final class m implements a {
    final /* synthetic */ MessageItemFragment a;

    public final void a(String str) {
    }

    m(MessageItemFragment messageItemFragment) {
        this.a = messageItemFragment;
    }

    public final void a() {
        if (this.a.f != null) {
            this.a.f.notifyDataSetChanged();
        }
    }
}
