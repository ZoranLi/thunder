package com.xunlei.downloadprovider.web.website.fragment;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.xllib.b.d;
import java.util.List;

/* compiled from: CollectionAndHistoryFragment */
final class h implements MessageListener {
    final /* synthetic */ CollectionAndHistoryFragment a;

    h(CollectionAndHistoryFragment collectionAndHistoryFragment) {
        this.a = collectionAndHistoryFragment;
    }

    public final void handleMessage(Message message) {
        if (message != null && (message.obj instanceof List)) {
            List list = (List) message.obj;
            if (!this.a.h) {
                this.a.h = d.a(list) ^ true;
            }
            if (this.a.c != 1002) {
                if (this.a.c != 1003) {
                    this.a.g.a(list);
                    this.a.d();
                }
            }
            switch (message.what) {
                case 1:
                    if (d.a(list) == null) {
                        this.a.a = true;
                    } else {
                        this.a.a = false;
                    }
                    this.a.g.a(list);
                    break;
                case 2:
                    if (d.a(list) == null) {
                        this.a.b = true;
                    } else {
                        this.a.b = false;
                    }
                    message = this.a.g;
                    a aVar = message.d;
                    if (list != null) {
                        aVar.b.clear();
                        aVar.b.addAll(list);
                    }
                    message.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
            this.a.d();
        }
    }
}
