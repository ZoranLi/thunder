package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

public class TaskListFeedBottomView extends LinearLayout {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;

    public TaskListFeedBottomView(Context context) {
        this(context, null);
    }

    public TaskListFeedBottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TaskListFeedBottomView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        LayoutInflater.from(getContext()).inflate(R.layout.layout_task_list_feed_bottom, this);
        this.a = (TextView) findViewById(R.id.tv_source);
        this.b = (TextView) findViewById(R.id.tv_comment_count);
        this.c = (TextView) findViewById(R.id.tv_tmtp);
        this.d = (TextView) findViewById(R.id.tv_ad_source_tag);
    }

    public TextView getSourceTV() {
        return this.a;
    }

    public TextView getCommentCountTV() {
        return this.b;
    }

    public TextView getTmtpTV() {
        return this.c;
    }

    public TextView getAdSourceTagTV() {
        return this.d;
    }
}
