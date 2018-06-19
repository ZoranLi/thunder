package com.xunlei.downloadprovider.search.ui.search;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.h.k.a;

/* compiled from: SearchOperateActivity */
final class bl implements OnEditorActionListener {
    final /* synthetic */ SearchOperateActivity a;

    bl(SearchOperateActivity searchOperateActivity) {
        this.a = searchOperateActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return false;
        }
        i = SearchOperateActivity.a(this.a).getEditTextContent();
        if (TextUtils.isEmpty(i) != null) {
            keyEvent = bq.a().a;
            if (!keyEvent.equals("搜索或输入网址")) {
                i = keyEvent;
                keyEvent = 1;
                if (!TextUtils.isEmpty(i)) {
                    SearchOperateActivity.b(this.a, this.a.getString(R.string.search_input_empty_toast));
                } else if (SearchOperateActivity.i(this.a)) {
                    SearchOperateActivity.j(this.a).j();
                    this.a.a("keyin", i, keyEvent);
                    if (a.d(i)) {
                        if (keyEvent != 1) {
                            if (SearchOperateActivity.a(i)) {
                                com.xunlei.downloadprovider.search.c.a.a("keyin", i, "word", "zonghe", 0);
                            }
                        }
                        com.xunlei.downloadprovider.search.c.a.a("keyin", i, "word", "quanwang", keyEvent);
                    } else {
                        com.xunlei.downloadprovider.search.c.a.b("keyin", i, "website", "quanwang");
                    }
                    SearchOperateActivity.d(this.a).setVisibility(8);
                }
                return true;
            }
        }
        keyEvent = null;
        if (!TextUtils.isEmpty(i)) {
            SearchOperateActivity.b(this.a, this.a.getString(R.string.search_input_empty_toast));
        } else if (SearchOperateActivity.i(this.a)) {
            SearchOperateActivity.j(this.a).j();
            this.a.a("keyin", i, keyEvent);
            if (a.d(i)) {
                if (keyEvent != 1) {
                    if (SearchOperateActivity.a(i)) {
                        com.xunlei.downloadprovider.search.c.a.a("keyin", i, "word", "zonghe", 0);
                    }
                }
                com.xunlei.downloadprovider.search.c.a.a("keyin", i, "word", "quanwang", keyEvent);
            } else {
                com.xunlei.downloadprovider.search.c.a.b("keyin", i, "website", "quanwang");
            }
            SearchOperateActivity.d(this.a).setVisibility(8);
        }
        return true;
    }
}
