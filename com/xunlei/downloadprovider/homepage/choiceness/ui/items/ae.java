package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;

/* compiled from: ChoicenessPhotoArticleView */
final class ae implements e {
    final /* synthetic */ y a;

    ae(y yVar) {
        this.a = yVar;
    }

    public final void a(String str, int i) {
        if (this.a.d != null) {
            if (this.a.a != null) {
                PhotoArticleInfo photoArticleInfo = this.a.d.a;
                if (TextUtils.equals(str, photoArticleInfo.a) != null) {
                    photoArticleInfo.h = i + 1;
                    photoArticleInfo.g = true;
                    y.b(this.a.a, photoArticleInfo);
                }
            }
        }
    }
}
