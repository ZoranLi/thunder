package com.xunlei.downloadprovider.vod.recordpublish;

import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a;
import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.b;
import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.c;
import java.util.List;

/* compiled from: VodPlayerTopicSelectActivity */
final class w implements c {
    final /* synthetic */ VodPlayerTopicSelectActivity a;

    w(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity) {
        this.a = vodPlayerTopicSelectActivity;
    }

    public final void a(List<a> list) {
        if (list.size() > 0) {
            this.a.k.addAll(list);
            this.a.l.notifyDataSetChanged();
            if (this.a.d != null) {
                list = this.a.d;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.d.getText());
                list.setText(stringBuilder.toString());
            }
        }
    }

    public final void a(b bVar) {
        new StringBuilder("request fail for errorcode=").append(bVar.b);
    }
}
