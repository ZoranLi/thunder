package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;

/* compiled from: TaskCommentItemViewHolderNew */
final class bi extends ClickableSpan {
    final /* synthetic */ TargetCommentInfo a;
    final /* synthetic */ be b;

    bi(be beVar, TargetCommentInfo targetCommentInfo) {
        this.b = beVar;
        this.a = targetCommentInfo;
    }

    public final void onClick(View view) {
        if (this.b.g != null) {
            this.b.g.a(view, 16, this.a);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(Color.parseColor("#4677BC"));
        textPaint.setUnderlineText(false);
    }
}
