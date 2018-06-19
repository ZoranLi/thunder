package com.xunlei.downloadprovider.shortvideo.videodetail.a;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.xunlei.downloadprovider.comment.entity.TargetCommentInfo;

/* compiled from: TaskCommentItemViewHolder */
final class av extends ClickableSpan {
    final /* synthetic */ TargetCommentInfo a;
    final /* synthetic */ ar b;

    av(ar arVar, TargetCommentInfo targetCommentInfo) {
        this.b = arVar;
        this.a = targetCommentInfo;
    }

    public final void onClick(View view) {
        if (this.b.f != null) {
            this.b.f.a(view, 16, this.a);
        }
    }

    public final void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(Color.parseColor("#405699"));
        textPaint.setUnderlineText(false);
    }
}
