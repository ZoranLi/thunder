package com.xunlei.downloadprovider.personal.message.a;

import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.JustifyTextView;
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;

/* compiled from: BaseCommentViewHolder */
public abstract class g extends ae {
    protected a a;
    protected MessageInfo b;
    private ViewGroup c = null;
    @LayoutRes
    private int d;
    private ImageView e;
    private TextView f;
    private JustifyTextView g;
    private TextView h;
    private TextView i;
    private LinearLayout j;

    public g(View view, @LayoutRes int i, a aVar) {
        super(view);
        this.d = i;
        this.a = aVar;
    }

    protected void a() {
        this.e = (ImageView) this.itemView.findViewById(R.id.iv_avatar);
        this.f = (TextView) this.itemView.findViewById(R.id.tv_replyName);
        this.g = (JustifyTextView) this.itemView.findViewById(R.id.tv_replayContent);
        this.h = (TextView) this.itemView.findViewById(R.id.tv_time);
        this.i = (TextView) this.itemView.findViewById(R.id.tv_reply);
        this.j = (LinearLayout) this.itemView.findViewById(R.id.lin_root_view);
        this.c = (ViewGroup) c();
        View.inflate(this.itemView.getContext(), this.d, this.c);
    }

    protected void b() {
        this.itemView.setOnClickListener(new h(this));
        this.itemView.setOnLongClickListener(new i(this));
        this.f.setOnClickListener(new j(this));
        this.e.setOnClickListener(new k(this));
        this.i.setOnClickListener(new l(this));
    }

    public void a(MessageInfo messageInfo) {
        if (messageInfo == null) {
            throw new IllegalArgumentException("itemData should be CommentInfo type");
        }
        this.b = messageInfo;
        ae.a(this.b.getUserAvatar(), this.e);
        this.f.setText(this.b.getUserName());
        this.g.setText(this.b.getContent());
        long time = this.b.getTime();
        if (time > 0) {
            this.h.setText(DateUtil.formatRelativeTime(time * 1000));
        } else {
            this.h.setText("");
        }
        if (this.b.isHasRead() == null) {
            this.j.setBackgroundColor(Color.parseColor("#f1fbff"));
        } else {
            this.j.setBackgroundResource(R.drawable.bg_normal_press_selector);
        }
    }
}
