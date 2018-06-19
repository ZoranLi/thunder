package com.xunlei.downloadprovider.pushmessage.umeng;

import com.umeng.message.tag.TagManager.TagListCallBack;
import com.xunlei.downloadprovider.pushmessage.e;
import java.util.Arrays;
import java.util.List;

/* compiled from: UmengPushManager */
final class d implements TagListCallBack {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final void onMessage(boolean z, List<String> list) {
        z = e.a;
        new StringBuilder("original umeng tags.size: ").append(list == null ? 0 : list.size());
        z = e.a;
        new StringBuilder("original umeng tags: ").append(list == null ? "null" : Arrays.toString(list.toArray()));
    }
}
