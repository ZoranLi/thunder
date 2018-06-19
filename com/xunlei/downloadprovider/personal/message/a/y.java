package com.xunlei.downloadprovider.personal.message.a;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;

/* compiled from: LikeVideoItemViewHolder */
public final class y extends ae {
    private final ImageView a;
    private final ImageView b;
    private ImageView c;
    private final TextView d;
    private final TextView e;
    private final LinearLayout f;
    private final TextView g;
    private final a h;
    private final View i;
    private MessageInfo j;

    public y(View view, a aVar) {
        super(view);
        this.h = aVar;
        this.i = view;
        this.a = (ImageView) view.findViewById(R.id.iv_avatar);
        this.b = (ImageView) view.findViewById(R.id.img_videoThumb);
        this.c = (ImageView) view.findViewById(R.id.iv_mark);
        this.d = (TextView) view.findViewById(R.id.tv_replyName);
        this.e = (TextView) view.findViewById(R.id.tv_time);
        this.f = (LinearLayout) view.findViewById(R.id.lin_root_view);
        this.g = (TextView) view.findViewById(R.id.tv_video_error);
        view.setOnClickListener(new z(this));
        view.setOnLongClickListener(new aa(this));
        this.d.setOnClickListener(new ab(this));
        this.a.setOnClickListener(new ac(this));
        this.b.setOnClickListener(new ad(this));
    }

    public final void a(MessageInfo messageInfo) {
        if (messageInfo != null) {
            if (messageInfo instanceof MessageInfo) {
                this.j = messageInfo;
                ae.a(this.j.getUserAvatar(), this.a);
                CharSequence videoErrorTextMes = this.j.getVideoErrorTextMes();
                if (TextUtils.isEmpty(videoErrorTextMes)) {
                    this.b.setVisibility(0);
                    this.c.setVisibility(0);
                    this.c.setImageResource(R.drawable.ic_message_center_mark_video);
                    this.g.setVisibility(8);
                    messageInfo = messageInfo.getmPoster();
                    ImageView imageView = this.b;
                    Glide.with(imageView.getContext()).load(messageInfo).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).dontAnimate().into(imageView);
                } else {
                    this.b.setVisibility(8);
                    this.c.setVisibility(8);
                    this.g.setVisibility(0);
                    this.g.setText(videoErrorTextMes);
                }
                this.d.setText(this.j.getUserName());
                long time = this.j.getTime();
                if (time > 0) {
                    this.e.setText(DateUtil.formatRelativeTime(time * 1000));
                } else {
                    this.e.setText("");
                }
                if (this.j.isHasRead() == null) {
                    this.f.setBackgroundColor(Color.parseColor("#f1fbff"));
                    return;
                } else {
                    this.f.setBackgroundResource(R.drawable.bg_normal_press_selector);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("itemData should be CommentInfo type");
    }
}
