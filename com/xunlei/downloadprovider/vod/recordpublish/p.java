package com.xunlei.downloadprovider.vod.recordpublish;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.downloadprovider.g.a.b;

/* compiled from: VodPlayerTopicSelectActivity */
final class p implements OnClickListener {
    final /* synthetic */ VodPlayerTopicSelectActivity a;

    p(VodPlayerTopicSelectActivity vodPlayerTopicSelectActivity) {
        this.a = vodPlayerTopicSelectActivity;
    }

    public final void onClick(View view) {
        TextView textView = (TextView) view;
        this.a.a();
        view = textView.getText().toString();
        if (!TextUtils.isEmpty(view)) {
            if (view.startsWith("#") && view.length() > 1) {
                view = view.substring(1, view.length());
            }
            if (view.endsWith("#") && view.length() > 1) {
                view = view.substring(0, view.length() - 1);
            }
            this.a.a((String) view, 0);
            b.b("search", URLCoder.encode(view, null));
        }
    }
}
