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
import com.xunlei.downloadprovider.personal.message.data.vo.MessageInfo;
import com.xunlei.downloadprovider.personal.message.e.a;

/* compiled from: BaseLikeViewHolder */
public class m extends ae {
    protected a a;
    protected MessageInfo b;
    private ViewGroup c = null;
    @LayoutRes
    private int d;
    private ImageView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;

    public m(View view, @LayoutRes int i, a aVar) {
        super(view);
        this.d = i;
        this.a = aVar;
    }

    protected void a() {
        this.e = (ImageView) this.itemView.findViewById(R.id.iv_avatar);
        this.f = (TextView) this.itemView.findViewById(R.id.tv_replyName);
        this.g = (TextView) this.itemView.findViewById(R.id.tv_time);
        this.h = (LinearLayout) this.itemView.findViewById(R.id.lin_root_view);
        this.c = (ViewGroup) c();
        View.inflate(this.itemView.getContext(), this.d, this.c);
    }

    protected void b() {
        this.itemView.setOnClickListener(new n(this));
        this.itemView.setOnLongClickListener(new o(this));
        this.f.setOnClickListener(new p(this));
        this.e.setOnClickListener(new q(this));
    }

    public void a(MessageInfo messageInfo) {
        if (messageInfo == null) {
            throw new IllegalArgumentException("itemData should be CommentInfo type");
        }
        this.b = messageInfo;
        ae.a(this.b.getUserAvatar(), this.e);
        this.f.setText(this.b.getUserName());
        long time = this.b.getTime();
        if (time > 0) {
            this.g.setText(DateUtil.formatRelativeTime(time * 1000));
        } else {
            this.g.setText("");
        }
        if (this.b.isHasRead() == null) {
            this.h.setBackgroundColor(Color.parseColor("#f1fbff"));
        } else {
            this.h.setBackgroundResource(R.drawable.bg_normal_press_selector);
        }
    }
}
