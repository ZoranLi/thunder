package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.a.b;

/* compiled from: DialogListAdapter */
final class c implements OnLongClickListener {
    final /* synthetic */ b a;
    final /* synthetic */ a b;

    c(a aVar, b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public final boolean onLongClick(View view) {
        a.b(this.b, this.a);
        return true;
    }
}
