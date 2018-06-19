package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;

public class RecommendFollowLiveView extends RecommendFollowBaseView {
    private ImageView a;
    private TextView b;
    private TextView c;
    private View d;
    private ImageView e;
    private TextView f;
    private TextView g;

    public RecommendFollowLiveView(Context context) {
        super(context);
        a(context);
    }

    public RecommendFollowLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RecommendFollowLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.follow_recommend_live_item, this, true);
        this.a = (ImageView) context.findViewById(R.id.iv_avatar);
        this.b = (TextView) context.findViewById(R.id.tv_title);
        this.c = (TextView) context.findViewById(R.id.tv_online_num);
        this.d = context.findViewById(R.id.layout_live_status);
        this.e = (ImageView) context.findViewById(R.id.iv_live_status_anim);
        ((AnimationDrawable) this.e.getDrawable()).start();
        this.f = (TextView) context.findViewById(R.id.tv_description);
        this.g = (TextView) context.findViewById(R.id.tv_follow);
    }

    public final void a(a aVar) {
        super.a(aVar);
        b.a();
        b.a(aVar.f, this.a);
        setOnClickListener(new ah(this, aVar));
        CharSequence charSequence = aVar.e;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "迅雷用户";
        }
        this.b.setText(charSequence);
        this.f.setText(aVar.k);
        if (aVar.j) {
            setOnlineNum(aVar.l);
            this.d.setVisibility(0);
            this.g.setVisibility(8);
            return;
        }
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        this.g.setVisibility(0);
        if (com.xunlei.downloadprovider.homepage.follow.b.a().b(aVar.b)) {
            a();
            return;
        }
        b();
        this.g.setOnClickListener(new ai(this, aVar));
    }

    protected final void a() {
        this.g.setEnabled(false);
        this.g.setText("已关注");
    }

    protected final void b() {
        this.g.setEnabled(true);
        this.g.setText("+ 关注");
    }

    private void setOnlineNum(int i) {
        if (i > 0) {
            this.c.setVisibility(0);
            CharSequence spannableString = new SpannableString(String.valueOf(i));
            spannableString.setSpan(new ForegroundColorSpan(Color.argb(255, 255, 44, 85)), 0, spannableString.length(), 33);
            this.c.setText(spannableString);
            this.c.append("人在看");
            return;
        }
        this.c.setVisibility(8);
    }

    private void setFansCount(int i) {
        if (i > 0) {
            TextView textView = this.c;
            StringBuilder stringBuilder = new StringBuilder("粉丝: ");
            stringBuilder.append(i);
            textView.setText(stringBuilder.toString());
            return;
        }
        this.c.setVisibility(8);
    }
}
