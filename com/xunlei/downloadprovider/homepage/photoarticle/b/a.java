package com.xunlei.downloadprovider.homepage.photoarticle.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.aq;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;

/* compiled from: ArticleTitleViewHolder */
public final class a extends aq {
    private TextView a;

    public a(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.article_title);
    }

    public final void a(aw awVar) {
        String str = (String) awVar.b;
        if (!TextUtils.isEmpty(str)) {
            this.a.setText(str);
        }
    }
}
