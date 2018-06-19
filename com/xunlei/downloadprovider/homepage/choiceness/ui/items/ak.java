package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.xunlei.android.shortvideo.ShortVideoInterface;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.a.h;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.homepage.redpacket.j;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.a;
import com.xunlei.downloadprovider.shortvideo.ui.c;
import com.xunlei.downloadprovider.shortvideo.ui.q;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* compiled from: ChoicenessUgcPlayerView */
public final class ak extends a<m> implements b<m> {
    private static boolean a = d.a().b.t();
    private m g;
    private i h;
    private com.xunlei.downloadprovider.homepage.choiceness.ui.b i;
    private com.xunlei.downloadprovider.homepage.choiceness.ui.b.a j = new am(this);

    public final boolean e() {
        return true;
    }

    public final /* synthetic */ void a(int i, i iVar, int i2, View view, e eVar) {
        Object obj = (m) eVar;
        if (this.g != obj) {
            iVar = this.i;
            iVar.f = null;
            iVar.a();
            iVar.d = false;
            ViewUtil.removeViewFromParent(iVar.e);
            iVar.e = null;
        }
        this.g = obj;
        if (obj.d == null && TextUtils.isEmpty(obj.o) == null) {
            super.a(i, obj.b, obj.a, new com.xunlei.downloadprovider.homepage.category.a(obj.o));
        } else {
            super.a(i, obj.b, obj.a, new com.xunlei.downloadprovider.homepage.choiceness.i());
        }
        getReportStrategy().b = obj;
        i = this.b.I;
        i.d = obj;
        i.a.setText(i.c.getString(R.string.choiceness_recommend_video_tag, new Object[]{obj.o}));
        i.b.setText(i.c.getString(R.string.choiceness_recommend_video_load_more, new Object[]{obj.o}));
        iVar = (i.d.d == null || TextUtils.isEmpty(obj.o) != null) ? 8 : null;
        i.a(iVar);
        if (obj.c != 0) {
            this.i.a(this.b.d, this.g, obj.c);
        }
        this.e = false;
        i = d.a().l.d();
        iVar = j.a().b(this.g.b.getVideoId());
        this.b.E.setVisibility(8);
        this.b.F.setVisibility(8);
        if (i != 0 && iVar != null) {
            this.b.s.setText("领红包");
            this.b.F.setVisibility(0);
            this.b.F.setImageResource(R.drawable.ic_share_red_packet_icon);
        }
    }

    public ak(Context context, i iVar, com.xunlei.downloadprovider.player.a.a aVar) {
        super(context, aVar);
        this.h = iVar;
        this.i = new com.xunlei.downloadprovider.homepage.choiceness.ui.b(context);
        this.i.g = this.j;
        this.b.D.setFrom("HOME");
    }

    protected final boolean a(boolean z, long j) {
        return !z && (System.currentTimeMillis() - j < true || a);
    }

    public final void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z) {
        if (!d.a().b.i() || !com.xunlei.xllib.android.b.f(getContext())) {
            super.a(baseVideoInfo, videoUserInfo, z);
        } else if (this.h.a != null) {
            baseVideoInfo = this.h.a;
            videoUserInfo = baseVideoInfo.indexOf(this.g);
            ArrayList arrayList = new ArrayList();
            arrayList.add(a(this.g, true));
            int size = baseVideoInfo.size();
            int i = videoUserInfo + 1;
            while (i < videoUserInfo + 5 && i < size) {
                e eVar = (e) baseVideoInfo.get(i);
                if (eVar.e()) {
                    arrayList.add(a((m) eVar, false));
                }
                i++;
            }
            com.xunlei.downloadprovider.player.xmp.ak.a().a(arrayList, new al(this, z));
        }
    }

    public final boolean a() {
        if (!super.a()) {
            return false;
        }
        com.xunlei.downloadprovider.e.a.a.a(getContext(), this.g != null ? this.g.b() : "", "video", "home");
        this.i.a(this.g, this.b.d, "like");
        if (getPlayer() != null) {
            getPlayer().b(true);
        }
        return true;
    }

    protected final boolean g() {
        if (!super.g()) {
            return false;
        }
        this.i.a(this.g, this.b.d, "like");
        return true;
    }

    public final void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z, From from, boolean z2) {
        super.a(baseVideoInfo, videoUserInfo, z, from, z2);
        this.h.c = null;
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer, int i) {
        super.a(thunderXmpPlayer, i);
        thunderXmpPlayer = thunderXmpPlayer.f.c();
        if (thunderXmpPlayer > null && i * 5 > thunderXmpPlayer * 3) {
            this.i.a(this.g, this.b.d, "play");
        }
        boolean z = false;
        if (j.a().c) {
            if (i > d.a().l.f() * 1000 && d.a().l.d() && !this.e && !j.a().b(this.c.getVideoId())) {
                this.b.F.setVisibility(8);
                this.e = true;
                super.a(1, 0, 1000);
                this.b.s.setText("领红包");
                super.a(0, 1, 1000);
                this.b.E.setVisibility(0);
                this.b.E.a();
                j.a().a(this.c.getVideoId());
            }
        } else if (d.a().l.d() && !j.a().c) {
            boolean[] zArr = new boolean[]{false};
            int dip2px = DipPixelUtil.dip2px(120.0f);
            this.b.t.getLocationOnScreen(new int[2]);
            int width = (this.b.t.getWidth() / 2) - (dip2px / 2);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 83;
            layoutParams.leftMargin = width;
            layoutParams.bottomMargin = DipPixelUtil.dip2px(10.0f);
            layoutParams.width = DipPixelUtil.dip2px(120.0f);
            layoutParams.height = DipPixelUtil.dip2px(82.0f);
            this.b.G.setLayoutParams(layoutParams);
            this.b.H.setLayoutParams(layoutParams);
            this.b.G.setVisibility(0);
            this.b.H.setVisibility(8);
            this.b.G.setImageAssetsFolder("lottie/homeshare2/images");
            this.b.G.setAnimation("lottie/homeshare2/data.json");
            this.b.H.setImageAssetsFolder("lottie/homeshare/images");
            this.b.H.setAnimation("lottie/homeshare/data.json");
            this.b.G.a();
            this.b.G.a.b.addUpdateListener(new q(this, zArr));
            this.b.G.a(new c(this));
            this.b.E.a(new com.xunlei.downloadprovider.shortvideo.ui.d(this));
            j.a().c = true;
            f.a(BrothersApplication.getApplicationInstance(), "key_is_choiceness_lottie_showed", true);
            j.a().a(this.c.getVideoId());
        }
        h a = h.a();
        m mVar = this.g;
        if (h.b() && mVar != null && thunderXmpPlayer >= null && i >= 0) {
            if ((a.b == 2 ? 1 : false) != 0) {
                boolean add;
                String videoId = mVar.b.getVideoId();
                if (a.d == null || !a.d.b.getVideoId().equals(videoId)) {
                    add = a.f.add(videoId);
                } else {
                    add = false;
                }
                if (add) {
                    new StringBuilder("handlePlayedVideosBeforeNextRound--is record success--videoId: ").append(mVar.b.getVideoId());
                }
                if (add) {
                    if ((((float) a.f.size()) > h.a ? 1 : false) != 0) {
                        a.c();
                    }
                }
            }
            if ((((float) i) * 1065353216) / ((float) thunderXmpPlayer) >= 1061997773 && h.b() != null) {
                if (a.b > null) {
                    z = true;
                }
                if (!z) {
                    a.a(1);
                    a.d = mVar;
                    XLThreadPool.execute(new com.xunlei.downloadprovider.homepage.choiceness.a.q(new com.xunlei.downloadprovider.homepage.choiceness.a.j(), mVar, new com.xunlei.downloadprovider.homepage.choiceness.a.i(a, mVar)));
                }
            }
        }
    }

    private static ShortVideoInterface.a a(m mVar, boolean z) {
        mVar = mVar.b;
        if (z) {
            return new ShortVideoInterface.a(mVar.getPlayUrl(), mVar.getGcid(), mVar.getTitle(), mVar.getDuration());
        }
        return new ShortVideoInterface.a(mVar.getPlayUrl(), mVar.getGcid(), mVar.getTitle(), mVar.getDuration(), 6);
    }
}
