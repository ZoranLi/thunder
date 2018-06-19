package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.xunlei.common.commonview.XLToast;

/* compiled from: CommentDialog */
final class f implements OnEditorActionListener {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return null;
        }
        if (TextUtils.isEmpty(this.a.a.getText().toString().trim()) == 0 && this.a.m.isEnabled() == 0) {
            return true;
        }
        if (TextUtils.isEmpty(this.a.a.getText().toString().trim()) != 0) {
            XLToast.showToast(this.a.getContext(), "请填写评论内容");
            return true;
        }
        if (this.a.u != 0) {
            this.a.u.onClick(textView);
        }
        return true;
    }
}
