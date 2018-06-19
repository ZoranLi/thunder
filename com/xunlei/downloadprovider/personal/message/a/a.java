package com.xunlei.downloadprovider.personal.message.a;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;

/* compiled from: AttentionItemViewHolder */
public final class a extends ae {
    private final ImageView a;
    private final TextView b;
    private final TextView c;
    private final TextView d;
    private final LinearLayout e;
    private final com.xunlei.downloadprovider.personal.message.e.a f;
    private final View g;
    private MessageInfo h;

    public a(View view, com.xunlei.downloadprovider.personal.message.e.a aVar) {
        super(view);
        this.f = aVar;
        this.g = view;
        this.a = (ImageView) view.findViewById(R.id.iv_avatar);
        this.b = (TextView) view.findViewById(R.id.tv_attention);
        this.c = (TextView) view.findViewById(R.id.tv_replyName);
        this.d = (TextView) view.findViewById(R.id.tv_time);
        this.e = (LinearLayout) view.findViewById(R.id.lin_root_view);
        view.setOnClickListener(new b(this));
        view.setOnLongClickListener(new c(this));
        this.c.setOnClickListener(new d(this));
        this.a.setOnClickListener(new e(this));
    }

    public final void a(MessageInfo messageInfo) {
        if (messageInfo != null) {
            if (messageInfo instanceof MessageInfo) {
                this.h = messageInfo;
                ae.a(this.h.getUserAvatar(), this.a);
                this.h.getIsFollow();
                if (b.a().b(this.h.getUserId()) != null) {
                    this.b.setVisibility(0);
                    this.b.setBackgroundResource(R.drawable.btn_unfollow_selector2);
                    this.b.setText("已关注");
                } else {
                    this.b.setVisibility(0);
                    this.b.setBackgroundResource(R.drawable.btn_follow_selector2);
                    this.b.setText("+ 关注");
                }
                this.b.setOnClickListener(new f(this));
                if (this.h.getTargetCommentInfo() != null) {
                    this.c.setText(this.h.getUserName());
                    long time = this.h.getTime();
                    if (time > 0) {
                        this.d.setText(DateUtil.formatRelativeTime(time * 1000));
                    } else {
                        this.d.setText("");
                    }
                }
                if (this.h.isHasRead() == null) {
                    this.e.setBackgroundColor(Color.parseColor("#f1fbff"));
                    return;
                } else {
                    this.e.setBackgroundResource(R.drawable.bg_normal_press_selector);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("itemData should be CommentInfo type");
    }
}
