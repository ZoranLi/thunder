package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.comment.entity.CommentInfo;

public class ChoicenessHotCommentView extends LinearLayout {
    public TextView a;
    public TextView b;
    public TextView c;
    public View d;

    public ChoicenessHotCommentView(Context context) {
        super(context);
        a(context);
    }

    public ChoicenessHotCommentView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChoicenessHotCommentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.choiceness_hot_comment_view, this, true);
        this.a = (TextView) findViewById(R.id.comment1);
        this.b = (TextView) findViewById(R.id.comment2);
        this.c = (TextView) findViewById(R.id.comment3);
        this.d = findViewById(R.id.tv_all_comment);
    }

    public void setMoreCommentClickListener(OnClickListener onClickListener) {
        this.d.setOnClickListener(onClickListener);
    }

    public static void a(TextView textView, CommentInfo commentInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(commentInfo.getUserName());
        stringBuilder.append("：");
        String stringBuilder2 = stringBuilder.toString();
        commentInfo = commentInfo.getContent();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(commentInfo);
        CharSequence spannableString = new SpannableString(stringBuilder3.toString());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3b424c")), 0, stringBuilder2.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#717a89")), stringBuilder2.length(), spannableString.length(), 33);
        textView.setText(spannableString);
    }
}
