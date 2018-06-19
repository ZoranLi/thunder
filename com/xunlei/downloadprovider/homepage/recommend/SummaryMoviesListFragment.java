package com.xunlei.downloadprovider.homepage.recommend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.ad.feedvideo.a;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.frame.BasePageFragment;
import com.xunlei.downloadprovider.frame.f;
import com.xunlei.downloadprovider.homepage.recommend.VideoFeedReporter.RefreshType;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

public class SummaryMoviesListFragment extends BasePageFragment implements f {
    private b a = null;
    private boolean b;

    protected String getTabId() {
        return "short_movie";
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onUserVisible(boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        super.onUserVisible(r6);
        r0 = 1;
        if (r6 == 0) goto L_0x004e;
    L_0x0006:
        r6 = com.xunlei.downloadprovider.homepage.recommend.feed.a.a();
        r1 = new com.xunlei.downloadprovider.homepage.recommend.o;
        r1.<init>(r5);
        r2 = r6.b;
        if (r2 == 0) goto L_0x004e;
    L_0x0013:
        r2 = r6.b;
        r3 = "feed_video_list";
        r4 = "";
        r2 = r2.getString(r3, r4);
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x003c }
        r3.<init>(r2);	 Catch:{ JSONException -> 0x003c }
        r2 = com.xunlei.downloadprovider.homepage.recommend.feed.o.a(r0, r3);	 Catch:{ JSONException -> 0x003c }
        r3 = r6.d;	 Catch:{ JSONException -> 0x003c }
        r3.clear();	 Catch:{ JSONException -> 0x003c }
        r3 = r2.a();	 Catch:{ JSONException -> 0x003c }
        if (r3 == 0) goto L_0x004e;	 Catch:{ JSONException -> 0x003c }
    L_0x0031:
        r3 = r6.d;	 Catch:{ JSONException -> 0x003c }
        r2 = r2.a;	 Catch:{ JSONException -> 0x003c }
        r3.addAll(r2);	 Catch:{ JSONException -> 0x003c }
        r1.a();	 Catch:{ JSONException -> 0x003c }
        goto L_0x004e;
    L_0x003c:
        r1 = r6.b;
        if (r1 == 0) goto L_0x004e;
    L_0x0040:
        r6 = r6.b;
        r6 = r6.edit();
        r1 = "feed_video_list";
        r6.remove(r1);
        r6.apply();
    L_0x004e:
        r6 = r5.a;
        if (r6 == 0) goto L_0x0069;
    L_0x0052:
        r6 = r5.a;
        r1 = r5.b;
        r6.c = r0;
        r0 = r6.b;
        r0.a();
        r0 = r6.a;
        if (r0 == 0) goto L_0x0066;
    L_0x0061:
        r6 = r6.a;
        r6.a(r1);
    L_0x0066:
        r6 = 0;
        r5.b = r6;
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.SummaryMoviesListFragment.onUserVisible(boolean):void");
    }

    public void onPageSelected() {
        super.onPageSelected();
        a b = a.b();
        b.h = true;
        if (b.j) {
            if (!a.d(b.g)) {
                b.a();
                b.b(b.g);
            }
            b.j = false;
        }
        if (b.f != null && !a.c(b.g)) {
            a.b().a(b.g);
            if (b.i.get() != null) {
                b.f.a((View) b.i.get());
            }
        }
    }

    public void onUserInvisible(boolean z) {
        super.onUserInvisible(z);
        if (this.a) {
            z = this.a;
            z.c = false;
            z.b.b();
            if (z.a != null) {
                z.a.c();
            }
        }
    }

    public void onExitApp() {
        super.onExitApp();
        if (this.a != null) {
            this.a.b.b();
        }
    }

    public void onMainTabClick(boolean z) {
        super.onMainTabClick(z);
        this.b = z;
        if (z) {
            ak.a().c(PlayerTag.FEED);
            return;
        }
        if (this.a) {
            this.a.setRefreshType(RefreshType.single_click_bottom_rec);
            this.a.a();
        }
    }

    public boolean onBackPressed() {
        VideoFeedReporter.a(d.a().b.a());
        return super.onBackPressed();
    }

    public final void a() {
        if (this.a != null) {
            this.a.setRefreshType(RefreshType.single_click_top_tab);
            this.a.a();
        }
    }

    protected void onFullScreenChange(boolean z) {
        super.onFullScreenChange(z);
        if (this.a) {
            z = this.a;
            if (z.a != null) {
                z.a.d();
            }
        }
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.a = new b(viewGroup.getContext(), this);
        return this.a;
    }
}
