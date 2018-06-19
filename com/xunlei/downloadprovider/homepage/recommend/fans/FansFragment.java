package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils.TruncateAt;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a.e$e;
import com.xunlei.downloadprovider.search.ui.a.e;
import java.util.List;

public class FansFragment extends BaseListFragment<a> implements e$e<List<a>, String, Boolean> {
    private static final String h = "FansFragment";
    private com.xunlei.downloadprovider.homepage.recommend.fans.a.a i;
    private long j;
    private String k;
    private aa l;

    public final /* synthetic */ void a(Object obj, Object obj2, Object obj3) {
        List list = (List) obj;
        String str = (String) obj2;
        Boolean bool = (Boolean) obj3;
        if ((this.j == LoginHelper.a().g.c() ? 1 : false) != 0 || list == null || list.isEmpty() || list.size() <= 50 - this.c.getCount()) {
            a(list);
            if (bool.booleanValue() == null) {
                this.f = false;
            }
        } else {
            a((List) list.subList(0, 50 - this.c.getCount()));
            obj = "仅展示最新的50个粉丝";
            if (this.b != null) {
                obj3 = new TextView(getContext());
                obj3.setTextColor(Color.parseColor("#979ba1"));
                obj3.setTextSize(13.0f);
                obj3.setGravity(17);
                obj3.setMaxLines(1);
                obj3.setEllipsize(TruncateAt.END);
                int dip2px = DipPixelUtil.dip2px(20.0f);
                obj3.setPadding(0, dip2px, 0, dip2px);
                obj3.setText(obj);
                obj3.setLayoutParams(new LayoutParams(-1, -2));
                obj3.setBackgroundColor(-1);
                ((ListView) this.b.getRefreshableView()).addFooterView(obj3);
            }
            this.f = false;
        }
        this.k = str;
    }

    public static FansFragment a(long j) {
        FansFragment fansFragment = new FansFragment();
        Bundle bundle = new Bundle(1);
        bundle.putLong("arg_user_id", j);
        fansFragment.setArguments(bundle);
        return fansFragment;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null) {
            this.j = bundle.getLong("arg_user_id", -1);
        }
        if (this.j == -1) {
            throw new IllegalArgumentException("User ID is INVALID");
        }
        if (this.l == null) {
            this.l = new p(this);
        }
        ab.a().a(this.l);
    }

    public void onResume() {
        super.onResume();
        this.g = false;
    }

    public void onPause() {
        super.onPause();
        this.g = true;
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.l != null) {
            ab.a().b(this.l);
        }
    }

    protected final e<a> i() {
        return new k(1, this.j, this);
    }

    protected final void b() {
        super.b();
        this.b.setMode(Mode.DISABLED);
        this.i = new com.xunlei.downloadprovider.homepage.recommend.fans.a.a();
        f();
    }

    protected final void f() {
        super.f();
        c();
        StringBuilder stringBuilder = new StringBuilder("loadFirstData---------------------------------=mUserId=");
        stringBuilder.append(this.j);
        stringBuilder.append(",pageSize=");
        stringBuilder.append(this.a);
        this.i.a(this.j, (long) this.a, this.k, this);
    }

    protected final void g() {
        super.g();
        StringBuilder stringBuilder = new StringBuilder("loadNextPageData---------------------------------=mUserId=");
        stringBuilder.append(this.j);
        stringBuilder.append(",pageSize=");
        stringBuilder.append(this.a);
        stringBuilder.append(",offset=");
        stringBuilder.append(this.c.getCount());
        this.i.a(this.j, (long) this.a, this.k, this);
    }

    public final void a() {
        e();
    }
}
