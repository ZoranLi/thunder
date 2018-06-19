package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import java.util.Comparator;

/* compiled from: QuickCommentView */
final class f implements Comparator<p> {
    final /* synthetic */ QuickCommentView a;

    f(QuickCommentView quickCommentView) {
        this.a = quickCommentView;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        p pVar = (p) obj2;
        obj = ((p) obj).b;
        obj2 = pVar.b;
        if (obj.length() < obj2.length()) {
            return -1;
        }
        return (obj.length() == obj2.length() || obj.length() <= obj2.length()) ? null : 1;
    }
}
