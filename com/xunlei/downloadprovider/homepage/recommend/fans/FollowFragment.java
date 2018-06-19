package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a.e$e;
import com.xunlei.downloadprovider.search.ui.a.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FollowFragment extends BaseListFragment<a> implements e$e<List<a>, String, Boolean> {
    private static final String h = "FollowFragment";
    private com.xunlei.downloadprovider.homepage.recommend.fans.a.a i;
    private long j;
    private String k = "";
    private boolean l = false;
    private aa m;

    public final /* synthetic */ void a(Object obj, Object obj2, Object obj3) {
        List list = (List) obj;
        String str = (String) obj2;
        Boolean bool = (Boolean) obj3;
        this.l = false;
        if ((this.j == LoginHelper.a().g.c() ? 1 : false) != 0 || list == null || list.isEmpty() || list.size() <= 50 - this.c.getCount()) {
            a(list);
            if (bool.booleanValue() == null) {
                this.f = false;
            }
        } else {
            a((List) list.subList(0, 50 - this.c.getCount()));
            obj = "仅展示最新的50个关注";
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

    public static FollowFragment a(long j) {
        FollowFragment followFragment = new FollowFragment();
        Bundle bundle = new Bundle(1);
        bundle.putLong("arg_user_id", j);
        followFragment.setArguments(bundle);
        return followFragment;
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
        if (this.m == null) {
            this.m = new t(this);
        }
        ab.a().a(this.m);
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
        if (this.m != null) {
            ab.a().b(this.m);
        }
    }

    protected final e<a> i() {
        return new k(2, this.j, this);
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
        StringBuilder stringBuilder = new StringBuilder("loadFirstData mUserId=");
        stringBuilder.append(this.j);
        stringBuilder.append(",pageSize=");
        stringBuilder.append(this.a);
        j();
    }

    protected final void g() {
        super.g();
        StringBuilder stringBuilder = new StringBuilder("loadNextPageData mUserId=");
        stringBuilder.append(this.j);
        stringBuilder.append(",pageSize=");
        stringBuilder.append(this.a);
        stringBuilder.append(",offset=");
        stringBuilder.append(this.c.getCount());
        j();
    }

    private void j() {
        if (!this.l) {
            if (this.f) {
                this.l = true;
                com.xunlei.downloadprovider.homepage.recommend.fans.a.a aVar = this.i;
                long j = this.j;
                long j2 = (long) this.a;
                String str = this.k;
                StringBuilder stringBuilder = new StringBuilder("http://api-shoulei-ssl.xunlei.com/follow/follow_list_v3");
                stringBuilder.append("?uid=");
                stringBuilder.append(j);
                stringBuilder.append("&size=");
                stringBuilder.append(j2);
                stringBuilder.append("&cursor=");
                stringBuilder.append(str);
                new StringBuilder("getHotCampaignList url=").append(stringBuilder.toString());
                XLThreadPool.execute(new com.xunlei.downloadprovider.homepage.recommend.fans.a.e(aVar, stringBuilder, this));
            }
        }
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.c != null) {
                List<a> list = this.c.b;
                Object obj = null;
                if (list != null) {
                    for (a aVar : list) {
                        if (aVar.b == Long.valueOf(str).longValue()) {
                            obj = aVar;
                            break;
                        }
                    }
                    if (obj != null) {
                        list.remove(obj);
                        if (list.size() <= null) {
                            d();
                        } else if (list.size() <= 10) {
                            g();
                        }
                    }
                    this.c.notifyDataSetChanged();
                }
            }
        }
    }

    public final void b(List<String> list) {
        Collection arrayList = new ArrayList();
        for (String valueOf : list) {
            arrayList.add(b.a().c(Long.valueOf(valueOf).longValue()));
        }
        list = this.c;
        list.a();
        list.b.addAll(0, arrayList);
        list.notifyDataSetChanged();
    }

    public final void a() {
        this.l = false;
        e();
    }
}
