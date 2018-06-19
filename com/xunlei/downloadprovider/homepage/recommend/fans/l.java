package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.recommend.fans.a.h;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;

/* compiled from: FansAndFollowItemView */
public class l extends FrameLayout implements OnClickListener {
    private static final String k = "l";
    long a;
    TextView b;
    UserInfoTagView c;
    TextView d;
    ImageView e;
    TextView f;
    a g;
    int h;
    Context i;
    LoginHelper j = LoginHelper.a();

    public l(Context context, long j) {
        super(context);
        this.a = j;
        this.i = context;
        context = LayoutInflater.from(context).inflate(2130968869, this, true);
        this.b = (TextView) context.findViewById(2131887464);
        this.c = (UserInfoTagView) context.findViewById(2131886808);
        this.d = (TextView) context.findViewById(2131886947);
        this.e = (ImageView) context.findViewById(2131886384);
        this.f = (TextView) context.findViewById(2131887378);
        context.setOnClickListener(new m(this));
    }

    private void a() {
        if (this.g != null) {
            Context context = getContext();
            From from = From.FAN_LIST;
            if (this.h == 2) {
                from = From.FOLLOW_LIST;
            } else if (this.h == 3) {
                from = From.LIKE_LIST;
            }
            From from2 = from;
            m.a(context, this.g.b, this.g.c, this.g.e, this.g.f, from2);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.tv_follow) {
            if (this.g != null) {
                if (b.a().b(this.g.b) != null) {
                    a();
                    return;
                }
                a(this.g.b);
            }
        }
    }

    private void a(long j) {
        switch (this.h) {
            case 1:
                com.xunlei.downloadprovider.homepage.recommend.a.a(this.g.b, b(this.g.c), com.xunlei.downloadprovider.member.login.b.l.c());
                break;
            case 2:
                h.a(this.g.b, b(this.g.c), com.xunlei.downloadprovider.member.login.b.l.c());
                break;
            case 3:
                h.a(String.valueOf(j), b(this.g.c), com.xunlei.downloadprovider.member.login.b.l.c());
                break;
            default:
                break;
        }
        if (com.xunlei.downloadprovider.member.login.b.l.c()) {
            b.a().a(j, true, new n(this, j));
            return;
        }
        this.j.a(getContext(), new o(this, j), LoginFrom.CHANNEL_FLOW_FOLLOW, null);
        switch (this.h) {
            case 1:
                com.xunlei.downloadprovider.homepage.recommend.a.a(this.g.b, b(this.g.c), com.xunlei.downloadprovider.member.login.b.l.c(), "skip_login", null);
                return;
            case 2:
                h.a(this.g.b, b(this.g.c), com.xunlei.downloadprovider.member.login.b.l.c(), "skip_login", null);
                return;
            case 3:
                h.a(String.valueOf(j), b(this.g.c), com.xunlei.downloadprovider.member.login.b.l.c(), "skip_login", null);
                break;
            default:
                break;
        }
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
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.fans.l.b(java.lang.String):java.lang.String");
    }
}
