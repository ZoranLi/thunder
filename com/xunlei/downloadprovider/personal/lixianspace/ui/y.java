package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.personal.lixianspace.b.b;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.d.p;

/* compiled from: LXSpaceCreateUrlTaskActivity */
final class y extends b {
    final /* synthetic */ LXSpaceCreateUrlTaskActivity a;

    y(LXSpaceCreateUrlTaskActivity lXSpaceCreateUrlTaskActivity) {
        this.a = lXSpaceCreateUrlTaskActivity;
    }

    public final void a(LXTaskInfo lXTaskInfo, int i, String str) {
        this.a.b();
        if ((i == 0 ? true : null) == null) {
            this.a.d.setEnabled(false);
            if (TextUtils.isEmpty(str)) {
                str = p.a(i);
            }
            if (!(i == 222 || i == 223)) {
                if (i != 234) {
                    XLToast.showToast(this.a, str);
                    this.a.c.setText("");
                    this.a.c.setVisibility(8);
                    return;
                }
            }
            this.a.c.setText(str);
            this.a.c.setVisibility(0);
            return;
        }
        this.a.finish();
    }
}
