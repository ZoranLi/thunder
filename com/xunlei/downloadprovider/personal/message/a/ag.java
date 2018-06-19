package com.xunlei.downloadprovider.personal.message.a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.JustifyTextView;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;

/* compiled from: ReplyItemViewHolder */
public final class ag extends ae {
    private ImageView a;
    private TextView b;
    private TextView c;
    private JustifyTextView d;
    private TextView e;
    private TextView f;
    private a g;
    private View h;
    private MessageInfo i;
    private LinearLayout j;
    private TextView k;

    public ag(View view, a aVar) {
        super(view);
        this.g = aVar;
        this.h = view;
        this.a = (ImageView) view.findViewById(R.id.iv_avatar);
        this.b = (TextView) view.findViewById(R.id.tv_content);
        this.c = (TextView) view.findViewById(R.id.tv_replyName);
        this.d = (JustifyTextView) view.findViewById(R.id.tv_replayContent);
        this.e = (TextView) view.findViewById(R.id.tv_time);
        this.f = (TextView) view.findViewById(R.id.tv_reply);
        this.j = (LinearLayout) view.findViewById(R.id.lin_root_view);
        this.k = (TextView) view.findViewById(R.id.tv_video_error);
        view.setOnClickListener(new ah(this));
        view.setOnLongClickListener(new ai(this));
        this.c.setOnClickListener(new aj(this));
        this.a.setOnClickListener(new ak(this));
        this.b.setOnClickListener(new al(this));
        this.f.setOnClickListener(new am(this));
    }

    public final void a(MessageInfo messageInfo) {
        if (messageInfo != null) {
            if (messageInfo instanceof MessageInfo) {
                this.i = messageInfo;
                ae.a(this.i.getUserAvatar(), this.a);
                messageInfo = this.i.getVideoErrorTextMes();
                if (TextUtils.isEmpty(messageInfo)) {
                    this.b.setVisibility(0);
                    this.k.setVisibility(8);
                    messageInfo = this.i.getTargetCommentInfo().getContent();
                    if (TextUtils.isEmpty(messageInfo)) {
                        this.b.setText("    ");
                    } else {
                        this.b.setText(messageInfo);
                    }
                } else {
                    this.b.setVisibility(8);
                    this.k.setVisibility(0);
                    this.k.setText(messageInfo);
                }
                if (this.i.getId() > 0) {
                    this.c.setText(this.i.getUserName());
                    this.d.setText(this.i.getContent());
                    long time = this.i.getTime();
                    if (time > 0) {
                        this.e.setText(DateUtil.formatRelativeTime(time * 1000));
                    } else {
                        this.e.setText("");
                    }
                }
                if (this.i.isHasRead() == null) {
                    this.j.setBackgroundColor(Color.parseColor("#f1fbff"));
                    return;
                } else {
                    this.j.setBackgroundResource(R.drawable.bg_normal_press_selector);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("itemData should be CommentInfo type");
    }
}
