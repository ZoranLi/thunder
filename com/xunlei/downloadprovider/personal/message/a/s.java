package com.xunlei.downloadprovider.personal.message.a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;

/* compiled from: LikeItemViewHolder */
public final class s extends ae {
    private final ImageView a;
    private final TextView b;
    private final TextView c;
    private final TextView d;
    private final LinearLayout e;
    private final a f;
    private final View g;
    private MessageInfo h;
    private TextView i;

    public s(View view, a aVar) {
        super(view);
        this.f = aVar;
        this.g = view;
        this.a = (ImageView) view.findViewById(R.id.iv_avatar);
        this.b = (TextView) view.findViewById(R.id.tv_content);
        this.c = (TextView) view.findViewById(R.id.tv_replyName);
        this.d = (TextView) view.findViewById(R.id.tv_time);
        this.e = (LinearLayout) view.findViewById(R.id.lin_root_view);
        this.i = (TextView) view.findViewById(R.id.tv_video_error);
        view.setOnClickListener(new t(this));
        view.setOnLongClickListener(new u(this));
        this.c.setOnClickListener(new v(this));
        this.a.setOnClickListener(new w(this));
        this.b.setOnClickListener(new x(this));
    }

    public final void a(MessageInfo messageInfo) {
        if (messageInfo != null) {
            if (messageInfo instanceof MessageInfo) {
                this.h = messageInfo;
                ae.a(this.h.getUserAvatar(), this.a);
                messageInfo = this.h.getVideoErrorTextMes();
                if (TextUtils.isEmpty(messageInfo)) {
                    this.b.setVisibility(0);
                    this.i.setVisibility(8);
                    messageInfo = this.h.getTargetCommentInfo();
                    if (messageInfo != null) {
                        messageInfo = messageInfo.getContent();
                        if (TextUtils.isEmpty(messageInfo)) {
                            this.b.setText("    ");
                        } else {
                            this.b.setText(messageInfo);
                        }
                    } else {
                        this.b.setText("    ");
                    }
                } else {
                    this.b.setVisibility(8);
                    this.i.setVisibility(0);
                    this.i.setText(messageInfo);
                }
                if (this.h.getId() > 0) {
                    this.c.setText(this.h.getUserName());
                }
                long time = this.h.getTime();
                if (time > 0) {
                    this.d.setText(DateUtil.formatRelativeTime(time * 1000));
                } else {
                    this.d.setText("");
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
