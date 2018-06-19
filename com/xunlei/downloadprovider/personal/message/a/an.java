package com.xunlei.downloadprovider.personal.message.a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.personal.message.JustifyTextView;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;

/* compiled from: ReplyVideoItemViewHolder */
public final class an extends ae {
    private final TextView a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private TextView e;
    private JustifyTextView f;
    private TextView g;
    private TextView h;
    private final LinearLayout i;
    private a j;
    private View k;
    private MessageInfo l;

    public an(View view, a aVar) {
        super(view);
        this.j = aVar;
        this.k = view;
        this.b = (ImageView) view.findViewById(R.id.iv_avatar);
        this.c = (ImageView) view.findViewById(R.id.img_videoThumb);
        this.d = (ImageView) view.findViewById(R.id.iv_mark);
        this.e = (TextView) view.findViewById(R.id.tv_replyName);
        this.f = (JustifyTextView) view.findViewById(R.id.tv_replayContent);
        this.g = (TextView) view.findViewById(R.id.tv_time);
        this.h = (TextView) view.findViewById(R.id.tv_reply);
        this.i = (LinearLayout) view.findViewById(R.id.lin_root_view);
        this.a = (TextView) view.findViewById(R.id.tv_video_error);
        view.setOnClickListener(new ao(this));
        view.setOnLongClickListener(new ap(this));
        this.e.setOnClickListener(new aq(this));
        this.b.setOnClickListener(new ar(this));
        this.c.setOnClickListener(new as(this));
        this.h.setOnClickListener(new at(this));
    }

    public final void a(MessageInfo messageInfo) {
        if (messageInfo != null) {
            if (messageInfo instanceof MessageInfo) {
                this.l = messageInfo;
                ae.a(this.l.getUserAvatar(), this.b);
                CharSequence videoErrorTextMes = this.l.getVideoErrorTextMes();
                if (TextUtils.isEmpty(videoErrorTextMes)) {
                    this.c.setVisibility(0);
                    this.d.setVisibility(0);
                    this.d.setImageResource(R.drawable.ic_message_center_mark_video);
                    this.a.setVisibility(8);
                    b.a().a(messageInfo.getmPoster(), this.c, null);
                } else {
                    this.c.setVisibility(8);
                    this.d.setVisibility(8);
                    this.a.setVisibility(0);
                    this.a.setText(videoErrorTextMes);
                }
                this.e.setText(this.l.getUserName());
                this.f.setText(this.l.getContent());
                long time = this.l.getTime();
                if (time > 0) {
                    this.g.setText(DateUtil.formatRelativeTime(time * 1000));
                } else {
                    this.g.setText("");
                }
                if (this.l.isHasRead() == null) {
                    this.i.setBackgroundColor(Color.parseColor("#f1fbff"));
                    return;
                } else {
                    this.i.setBackgroundResource(R.drawable.bg_normal_press_selector);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("itemData should be CommentInfo type");
    }
}
