package com.xunlei.downloadprovider.publiser.common.recommendfollow;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;

public class FollowRecommendItemView extends FrameLayout implements OnClickListener {
    private static final String b = "FollowRecommendItemView";
    View a;
    private TextView c;
    private TextView d;
    private ImageView e;
    private ImageView f;
    private TextView g;
    private ImageView h;
    private a i;
    private String j;

    public FollowRecommendItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public FollowRecommendItemView(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.layout_follow_recommend_item, this, true);
        this.c = (TextView) context.findViewById(R.id.tv_replyContent);
        this.d = (TextView) context.findViewById(R.id.tv_time);
        this.e = (ImageView) context.findViewById(R.id.iv_avatar);
        this.f = (ImageView) context.findViewById(R.id.iv_live);
        this.g = (TextView) context.findViewById(R.id.tv_attention);
        this.h = (ImageView) context.findViewById(R.id.iv_v_status);
        this.a = context.findViewById(R.id.line);
        context.setOnClickListener(new a(this));
        this.g.setOnClickListener(this);
    }

    public final void a(a aVar, String str) {
        if (aVar != null) {
            this.j = str;
            this.i = aVar;
            this.c.setVisibility(0);
            if (TextUtils.isEmpty(aVar.e) == null) {
                this.c.setText(aVar.e);
            } else {
                this.c.setText("迅雷用户");
            }
            if (TextUtils.isEmpty(aVar.a()) == null) {
                this.d.setVisibility(0);
                this.d.setText(aVar.a());
            } else {
                this.d.setVisibility(8);
            }
            if (TextUtils.isEmpty(aVar.f) == null) {
                b.a();
                b.a(aVar.f, this.e, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new, R.drawable.ic_default_avatar_new);
            } else {
                this.e.setImageResource(R.drawable.ic_default_avatar_new);
            }
            if (aVar.b != 0) {
                if (LoginHelper.a().g.c() != aVar.b) {
                    if (com.xunlei.downloadprovider.homepage.follow.b.a().b(aVar.b) != null) {
                        this.g.setVisibility(0);
                        this.g.setBackgroundResource(R.drawable.follow_recommend_btn_selector);
                        this.g.setText("已关注");
                        this.g.setTextColor(Color.parseColor("#e8e8e8"));
                    } else {
                        this.g.setVisibility(0);
                        this.g.setBackgroundResource(R.drawable.btn_follow_selector);
                        this.g.setTextColor(Color.parseColor("#1aa3ff"));
                        this.g.setText("+ 关注");
                    }
                    this.g.setOnClickListener(this);
                    if ("rad".equals(aVar.c) == null) {
                        this.f.setVisibility(0);
                        if (TextUtils.isEmpty(aVar.k) != null) {
                            this.d.setVisibility(0);
                            this.d.setText(aVar.k);
                        } else {
                            this.d.setVisibility(8);
                        }
                    } else {
                        this.f.setVisibility(8);
                    }
                    m.a(this.h, aVar.d, aVar.c);
                }
            }
            this.g.setVisibility(8);
            this.g.setOnClickListener(this);
            if ("rad".equals(aVar.c) == null) {
                this.f.setVisibility(8);
            } else {
                this.f.setVisibility(0);
                if (TextUtils.isEmpty(aVar.k) != null) {
                    this.d.setVisibility(8);
                } else {
                    this.d.setVisibility(0);
                    this.d.setText(aVar.k);
                }
            }
            m.a(this.h, aVar.d, aVar.c);
        }
    }

    private void a() {
        if (this.i != null) {
            getContext();
            m.a(getContext(), this.i.b, this.i.c, this.i.e, this.i.f, From.FOLLOWRECOMMEND);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_attention) {
            if (this.i != null) {
                if (com.xunlei.downloadprovider.homepage.follow.b.a().b(this.i.b) != null) {
                    a();
                    long j = this.i.b;
                    b(this.i.c);
                    LoginHelper.a();
                    j.a(j, l.c(), this.j);
                    return;
                }
                a(this.i.b);
            }
        }
    }

    private void a(long j) {
        LoginHelper.a();
        if (l.c()) {
            com.xunlei.downloadprovider.homepage.follow.b.a().a(j, true, new b(this));
            return;
        }
        LoginHelper.a().a(getContext(), new c(this, j), LoginFrom.CHANNEL_FLOW_FOLLOW, null);
        j.a(this.i.b, "skip_login", null, this.j);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String b(java.lang.String r1) {
        /*
        r0 = r1.hashCode();
        switch(r0) {
            case -153325523: goto L_0x003a;
            case 110877: goto L_0x0030;
            case 111357: goto L_0x0026;
            case 112661: goto L_0x001c;
            case 307926738: goto L_0x0012;
            case 1261512242: goto L_0x0008;
            default: goto L_0x0007;
        };
    L_0x0007:
        goto L_0x0044;
    L_0x0008:
        r0 = "yl_nvshen";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x0010:
        r1 = 5;
        goto L_0x0045;
    L_0x0012:
        r0 = "yl_daren";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x001a:
        r1 = 3;
        goto L_0x0045;
    L_0x001c:
        r0 = "rad";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x0024:
        r1 = 2;
        goto L_0x0045;
    L_0x0026:
        r0 = "pub";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x002e:
        r1 = 0;
        goto L_0x0045;
    L_0x0030:
        r0 = "per";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x0038:
        r1 = 1;
        goto L_0x0045;
    L_0x003a:
        r0 = "yl_nanshen";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0044;
    L_0x0042:
        r1 = 4;
        goto L_0x0045;
    L_0x0044:
        r1 = -1;
    L_0x0045:
        switch(r1) {
            case 0: goto L_0x0054;
            case 1: goto L_0x0051;
            case 2: goto L_0x004e;
            case 3: goto L_0x004b;
            case 4: goto L_0x004b;
            case 5: goto L_0x004b;
            default: goto L_0x0048;
        };
    L_0x0048:
        r1 = "personal";
        return r1;
    L_0x004b:
        r1 = "youliao_talent";
        return r1;
    L_0x004e:
        r1 = "per_host";
        return r1;
    L_0x0051:
        r1 = "personal";
        return r1;
    L_0x0054:
        r1 = "channel";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.common.recommendfollow.FollowRecommendItemView.b(java.lang.String):java.lang.String");
    }
}
