package com.xunlei.downloadprovider.personal.message;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.b;

/* compiled from: MessageItemFragment */
final class o implements OnClickListener {
    final /* synthetic */ long a;
    final /* synthetic */ MessageItemFragment b;

    o(MessageItemFragment messageItemFragment, long j) {
        this.b = messageItemFragment;
        this.a = j;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        b.a().a(this.a, new s(this.b));
    }
}
