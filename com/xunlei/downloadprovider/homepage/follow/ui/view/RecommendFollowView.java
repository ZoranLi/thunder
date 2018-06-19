package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.personal.user.account.m;

public class RecommendFollowView extends RecommendFollowBaseView {
    private ImageView a;
    private ImageView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;

    public RecommendFollowView(Context context) {
        super(context);
        a(context);
    }

    public RecommendFollowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RecommendFollowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.follow_recommend_item, this, true);
        this.a = (ImageView) context.findViewById(R.id.iv_avatar);
        this.b = (ImageView) context.findViewById(R.id.iv_v_status);
        this.c = (TextView) context.findViewById(R.id.tv_title);
        this.d = (TextView) context.findViewById(R.id.tv_fans_count);
        this.e = (TextView) context.findViewById(R.id.tv_description);
        this.f = (TextView) context.findViewById(R.id.tv_follow);
    }

    public final void a(a aVar) {
        super.a(aVar);
        b.a();
        b.a(aVar.f, this.a);
        m.a(this.b, aVar.d, aVar.c);
        setOnClickListener(new aj(this, aVar));
        CharSequence charSequence = aVar.e;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = "迅雷用户";
        }
        this.c.setText(charSequence);
        this.e.setText(aVar.a());
        if (com.xunlei.downloadprovider.homepage.follow.b.a().b(aVar.b)) {
            a();
            return;
        }
        b();
        this.f.setOnClickListener(new ak(this, aVar));
    }

    public final void a() {
        this.f.setEnabled(false);
        this.f.setText("已关注");
    }

    public final void b() {
        this.f.setEnabled(true);
        this.f.setText("+ 关注");
    }
}
