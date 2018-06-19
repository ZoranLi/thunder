package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.homepage.choiceness.b.b;
import com.xunlei.downloadprovider.shortvideo.ui.s;

/* compiled from: ChoicenessPhotoArticleView */
final class ab implements b {
    final /* synthetic */ y a;

    ab(y yVar) {
        this.a = yVar;
    }

    public final void a(int i, int i2) {
        y yVar = this.a;
        int a = s.a();
        if (i != 0) {
            if (i2 != 0) {
                if (i > i2) {
                    i = (i2 * a) / i;
                } else {
                    int i3 = a;
                    a = (i * a) / i2;
                    i = i3;
                }
                i2 = yVar.a.g.getLayoutParams();
                i2.width = a;
                i2.height = i;
                yVar.a.g.setLayoutParams(i2);
            }
        }
        i = a;
        i2 = yVar.a.g.getLayoutParams();
        i2.width = a;
        i2.height = i;
        yVar.a.g.setLayoutParams(i2);
    }
}
