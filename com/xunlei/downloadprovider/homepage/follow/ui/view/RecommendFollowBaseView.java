package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.ui.view.ViewHolder.From;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;

public abstract class RecommendFollowBaseView extends FrameLayout {
    private a a;
    private From b;
    private com.xunlei.downloadprovider.homepage.follow.b.a c;
    private aa d = new w(this);

    public interface a {
        void a();
    }

    protected abstract void a();

    protected abstract void b();

    public RecommendFollowBaseView(Context context) {
        super(context);
    }

    public RecommendFollowBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RecommendFollowBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setFrom(From from) {
        this.b = from;
    }

    public void a(com.xunlei.downloadprovider.homepage.follow.b.a aVar) {
        this.c = aVar;
    }

    protected final void a(Context context, com.xunlei.downloadprovider.homepage.follow.b.a aVar) {
        LoginHelper.a();
        if (l.c()) {
            c(aVar);
            return;
        }
        a(aVar, false, "skip_login", "");
        LoginHelper.a().a(context, new u(this, context, aVar), LoginFrom.FOLLOW_TAB, null);
    }

    public void setOnFollowSuccessListener(a aVar) {
        this.a = aVar;
    }

    private void a(com.xunlei.downloadprovider.homepage.follow.b.a aVar, boolean z, String str, String str2) {
        if (this.b != null) {
            switch (x.a[this.b.ordinal()]) {
                case 1:
                    ad.a(aVar.b, aVar.c, z, str, str2);
                    return;
                case 2:
                    ad.b(aVar.b, aVar.c, z, str, str2);
                    break;
                default:
                    break;
            }
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        ab.a().a(this.d);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ab.a().b(this.d);
    }

    public final void c() {
        if (this.c != null) {
            if (b.a().b(this.c.b)) {
                a();
            } else {
                b();
            }
        }
    }

    protected final void b(com.xunlei.downloadprovider.homepage.follow.b.a aVar) {
        long j = aVar.b;
        if ("rad".equals(aVar.c) && aVar.j) {
            String str;
            switch (x.a[this.b.ordinal()]) {
                case 1:
                    str = XLLiveRoomPlayFrom.FOLLOW_TAB;
                    break;
                case 2:
                    str = XLLiveRoomPlayFrom.FOLLOW_TAB_LIST_REC_ITEM;
                    break;
                default:
                    str = XLLiveRoomPlayFrom.FOLLOW_TAB;
                    break;
            }
            com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(getContext(), aVar.n, str);
        } else {
            PublisherActivity.From from;
            long j2 = aVar.b;
            String str2 = aVar.e;
            String str3 = aVar.f;
            switch (x.a[this.b.ordinal()]) {
                case 1:
                    from = PublisherActivity.From.FOLLOW_TAB;
                    break;
                case 2:
                case 4:
                    from = PublisherActivity.From.FOLLOW_TAB_LIST;
                    break;
                case 3:
                    from = PublisherActivity.From.HOME_REC_FOLLOW;
                    break;
                default:
                    from = null;
                    break;
            }
            m.a(getContext(), j2, aVar.c, str2, str3, from);
        }
        ad.a(this.b.toString(), j, aVar.c, aVar.j);
    }

    private void c(com.xunlei.downloadprovider.homepage.follow.b.a aVar) {
        long j = aVar.b;
        a();
        b.a().a(j, true, new v(this, aVar));
    }
}
