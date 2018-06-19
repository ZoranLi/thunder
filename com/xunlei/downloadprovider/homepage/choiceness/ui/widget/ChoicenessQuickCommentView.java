package com.xunlei.downloadprovider.homepage.choiceness.ui.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.QuickCommentView;

public class ChoicenessQuickCommentView extends LinearLayout {
    private QuickCommentView a;

    public ChoicenessQuickCommentView(Context context) {
        super(context);
        a(context);
    }

    public ChoicenessQuickCommentView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChoicenessQuickCommentView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.choiceness_quick_comment_view, this, true);
        this.a = (QuickCommentView) findViewById(R.id.quick_comment);
    }

    public QuickCommentView getQuickCommentView() {
        return this.a;
    }
}
