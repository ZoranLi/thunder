package com.xunlei.downloadprovider.homepage.youliao;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.c.b.b;
import com.xunlei.downloadprovider.ad.c.b.e;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.frame.BasePageFragment;
import com.xunlei.downloadprovider.frame.f;
import com.xunlei.downloadprovider.homepage.a;
import com.xunlei.downloadprovider.homepage.choiceness.ui.RefreshPromptView;
import com.xunlei.downloadprovider.homepage.youliao.data.h;
import com.xunlei.downloadprovider.homepage.youliao.data.i;
import com.xunlei.downloadprovider.homepage.youliao.data.k;
import com.xunlei.downloadprovider.homepage.youliao.flow.c;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;
import java.util.List;

public class YouliaoVideoFragment extends BasePageFragment implements f {
    public static double a = -1.0d;
    public static double b = -1.0d;
    private ImageView c;
    private XRecyclerView d;
    private c e;
    private final i f = new i();
    private RefreshPromptView g;
    private ErrorBlankView h;
    private a i;
    private boolean j = true;
    private a.a k = new b(this);
    private boolean l = false;
    private e m = null;

    protected String getTabId() {
        return "youliao";
    }

    static {
        com.xunlei.downloadprovider.ad.c.b.a aVar = b.a().a;
        if (aVar != null) {
            a = aVar.a;
            b = aVar.b;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.i = new a(this.k);
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_youliao_video, viewGroup, false);
        this.g = (RefreshPromptView) layoutInflater.findViewById(R.id.refresh_prompt);
        this.g.setTranslationY((float) (-DipPixelUtil.dip2px(37.0f)));
        this.h = (ErrorBlankView) layoutInflater.findViewById(R.id.error_layout);
        this.h.setVisibility(8);
        this.h.setActionButtonListener(new d(this));
        this.d = (XRecyclerView) layoutInflater.findViewById(R.id.recyclerView);
        this.d.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.d.setItemAnimator(null);
        this.e = new c(this.i);
        this.d.setAdapter(this.e);
        if (d.a().r.a() != -1 && d.a().r.c().equals("") == null) {
            this.c = new ImageView(getContext());
            viewGroup = new LayoutParams(com.xunlei.xllib.android.d.a(getContext()), -2);
            this.c.setAdjustViewBounds(true);
            int dip2px = DipPixelUtil.dip2px(7.0f);
            this.c.setPadding(dip2px, DipPixelUtil.dip2px(5.0f), dip2px, 0);
            this.c.setLayoutParams(viewGroup);
            Glide.with(getApplicationContext()).load(d.a().r.c()).diskCacheStrategy(DiskCacheStrategy.SOURCE).dontAnimate().bitmapTransform(new Transformation[]{new com.xunlei.downloadprovider.h.a.a.c(getContext(), 6)}).fallback(R.drawable.youliao_video_round_corner_poster_default).error(R.drawable.youliao_video_round_corner_poster_default).placeholder(R.drawable.youliao_video_round_corner_poster_default).into(this.c);
            this.c.setOnClickListener(new g(this));
        }
        this.d.setPullRefreshEnabled(true);
        this.d.setLoadingMoreEnabled(true);
        this.d.setRestCountForLoadMore(7);
        this.d.addOnScrollListener(new e(this));
        this.d.setLoadingListener(new f(this));
        return layoutInflater;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onMainTabClick(boolean z) {
        super.onMainTabClick(z);
        if (!z && this.mIsUserVisible) {
            b();
        }
    }

    public final void a() {
        b();
    }

    public void onUserVisible(boolean z) {
        super.onUserVisible(z);
        if (z) {
            this.m = new e((Fragment) this);
            this.m.a();
            this.m.a = new c(this);
            this.m.a(true);
            this.j = false;
            z = this.f;
            com.xunlei.downloadprovider.search.b.b iVar = new i(this);
            i.a();
            com.xunlei.downloadprovider.homepage.youliao.data.d dVar = z.a;
            com.xunlei.downloadprovider.search.b.b kVar = new k(z, iVar);
            z = com.xunlei.downloadprovider.homepage.youliao.data.d.a("http://api-shoulei-ssl.xunlei.com/cataract/api/v2/youliao_timelines", dVar.a);
            StringBuilder stringBuilder = new StringBuilder("loadCachePageData(");
            stringBuilder.append(dVar.a);
            stringBuilder.append(") url = ");
            stringBuilder.append(z);
            if (!dVar.b) {
                XLThreadPool.execute(new h(dVar, kVar));
            }
        }
        if (this.i) {
            this.i.a();
        }
        if (this.e) {
            z = this.e;
            z.c = true;
            z.a(z.a, false);
        }
    }

    public void onExitApp() {
        super.onExitApp();
        this.i.b();
    }

    public void onUserInvisible(boolean z) {
        super.onUserInvisible(z);
        if (this.e) {
            z = this.e;
            z.d.clear();
            z.c = false;
            z.a(true);
        }
        if (this.i && !this.i.a && this.k) {
            this.k.c();
        }
    }

    public final void b() {
        if (this.d != null) {
            this.d.scrollToPosition(0);
            this.d.d();
        }
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.m != null) {
            this.m.a(i, strArr, iArr);
        }
    }

    static /* synthetic */ void a(YouliaoVideoFragment youliaoVideoFragment, List list, boolean z) {
        if (youliaoVideoFragment.d != null) {
            youliaoVideoFragment.d.postDelayed(new l(youliaoVideoFragment, list, z), z ? 200 : 1000);
        }
    }

    static /* synthetic */ void a(YouliaoVideoFragment youliaoVideoFragment, int i) {
        if (youliaoVideoFragment.g != null) {
            youliaoVideoFragment.g.a(i);
        }
    }

    static /* synthetic */ void a(Location location) {
        if (location != null) {
            a = location.getLatitude();
            b = location.getLongitude();
        }
    }

    static /* synthetic */ void m(YouliaoVideoFragment youliaoVideoFragment) {
        if (youliaoVideoFragment.m != null) {
            youliaoVideoFragment.m.d();
            youliaoVideoFragment.m = null;
        }
    }
}
