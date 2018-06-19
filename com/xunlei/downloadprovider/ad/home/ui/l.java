package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.baidu.mobad.feeds.NativeResponse;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.ad.home.ui.ADItemView.AD_LAYOUT_TYPE;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.g;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.player.xmp.ui.item.BasePlayerView;
import com.xunlei.downloadprovider.player.xmp.y;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.xllib.b.j;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: ADPlayVodItemBase */
public abstract class l<T extends a> extends BasePlayerView implements ADItemView, t, com.xunlei.downloadprovider.homepage.choiceness.ui.a.b<e>, com.xunlei.downloadprovider.player.a.b {
    protected i a;
    protected T b;
    protected com.xunlei.downloadprovider.ad.common.adget.l c;
    private com.xunlei.downloadprovider.player.a.a d;
    private final String e = f.a;
    private int f;
    private String g;
    private e h;

    /* compiled from: ADPlayVodItemBase */
    protected class a {
        TextView a;
        TextView b;
        FrameLayout c;
        ImageView d;
        ImageView e;
        ImageView f;
        TextView g;
        View h;
        final /* synthetic */ l i;

        protected a(l lVar) {
            this.i = lVar;
        }
    }

    /* compiled from: ADPlayVodItemBase */
    protected class b extends a {
        final /* synthetic */ l j;

        protected b(l lVar) {
            this.j = lVar;
            super(lVar);
        }
    }

    /* compiled from: ADPlayVodItemBase */
    protected class c extends b {
        TextView k;
        TextView l;
        TextView m;
        final /* synthetic */ l n;

        protected c(l lVar) {
            this.n = lVar;
            super(lVar);
        }
    }

    /* compiled from: ADPlayVodItemBase */
    protected class d extends b {
        ImageView k;
        TextView l;
        final /* synthetic */ l m;

        protected d(l lVar) {
            this.m = lVar;
            super(lVar);
        }
    }

    protected abstract T a();

    protected void c(com.xunlei.downloadprovider.ad.common.adget.l lVar) {
    }

    public final boolean d() {
        return true;
    }

    public View getContainer() {
        return this;
    }

    protected void h() {
    }

    public l(Context context, com.xunlei.downloadprovider.player.a.a aVar) {
        super(context);
        this.d = aVar;
        inflate(context, getLayoutId(), this);
        this.b = a();
        e();
        this.b.c = (FrameLayout) findViewById(R.id.item_player_container);
        this.b.d = (ImageView) findViewById(R.id.item_poster);
        this.b.e = (ImageView) findViewById(R.id.play_icon);
        this.b.b = (TextView) findViewById(R.id.item_duration);
    }

    protected void e() {
        this.b.a = (TextView) findViewById(R.id.item_title);
        this.b.f = (ImageView) findViewById(R.id.iv_avatar);
        this.b.g = (TextView) findViewById(R.id.tv_publisher_name);
    }

    protected final boolean f() {
        m();
        return true;
    }

    protected final boolean g() {
        m();
        return true;
    }

    private void m() {
        com.xunlei.downloadprovider.ad.home.a.a(this.c, DispatchConstants.OTHER);
        if (this.c instanceof com.xunlei.downloadprovider.ad.common.adget.a.d) {
            ((NativeResponse) this.c.G()).handleClick(this);
            this.c.K();
            this.c.h();
            this.c.g();
            return;
        }
        this.c.K();
        if (this.c instanceof com.xunlei.downloadprovider.ad.common.adget.b) {
            ((com.xunlei.downloadprovider.ad.common.adget.b) this.c).h();
        }
        f.a(getContext()).c.d = this.c;
        this.a.c = false;
        com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a aVar = new com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.a();
        aVar.u = From.HOME_PAGE_AD;
        aVar.a = this.c.a();
        aVar.b = this.c.a();
        aVar.c = this.c.m();
        aVar.d = this.c.b();
        aVar.e = this.c.l();
        VideoUserInfo videoUserInfo = new VideoUserInfo();
        videoUserInfo.setPortraitUrl(this.c.k());
        videoUserInfo.setNickname(this.c.j());
        aVar.w = videoUserInfo;
        a(aVar);
    }

    public final void a(int i, i iVar, int i2, View view, e eVar) {
        this.a = iVar;
        this.f = i;
        this.h = eVar;
        setTag(R.id.position_layout, Integer.valueOf(i));
        if ((view instanceof ADItemView) != 0) {
            i = getViewPositionKey();
            ADItemView aDItemView = (ADItemView) view;
            aDItemView.a(eVar.b());
            com.xunlei.downloadprovider.ad.common.adget.l a = f.a(getContext().getApplicationContext()).c.a(eVar.b());
            if (this.c == null || a == null || this.c.G() != a.G() || i.equals(eVar.b()) == 0) {
                i();
            }
            f.a(getContext()).a(eVar, aDItemView, iVar);
        }
        view.setOnClickListener(new m(this));
    }

    private void n() {
        if (this.b != null) {
            this.b.d.setVisibility(0);
            this.b.e.setVisibility(0);
            this.b.b.setVisibility(0);
        }
    }

    private void o() {
        if (this.c != null) {
            String a = this.c.a();
            ThunderXmpPlayer j = j();
            y yVar = new y(a, this.c.b(), this.c.j());
            yVar.k = "homepage_ad";
            yVar.g = true;
            yVar.p = this.b.d.getScaleType();
            yVar.a(this.b.d.getDrawable());
            yVar.e = this.c.v();
            yVar.o = this.c.l();
            yVar.h = false;
            if (j.m()) {
                j.e();
            } else {
                j.a(yVar);
            }
            if (this.c instanceof com.xunlei.downloadprovider.ad.common.adget.a.d) {
                ((com.xunlei.downloadprovider.ad.common.adget.a.d) this.c).a(BrothersApplication.getApplicationInstance());
            }
        }
    }

    public String getViewPositionKey() {
        return this.g;
    }

    public final String a(String str) {
        this.g = str;
        return str;
    }

    public AD_LAYOUT_TYPE getADType() {
        return AD_LAYOUT_TYPE.PLAY_VOD_TYPE_VIEW;
    }

    public final void a(com.xunlei.downloadprovider.ad.common.adget.l lVar) {
        if (!com.xunlei.downloadprovider.ad.common.f.a(getContext())) {
            if (this.c != lVar) {
                this.c = lVar;
                setHubExtras(this.c);
                if (this.c == null || this.c.v() == 0) {
                    this.b.b.setVisibility(8);
                } else {
                    this.b.b.setVisibility(0);
                    this.b.b.setText(j.a(TimeUnit.SECONDS.toMillis((long) this.c.v())));
                }
                if (this.d.b((com.xunlei.downloadprovider.player.a.b) this)) {
                    o();
                } else {
                    if (this.d != null) {
                        this.d.a(null);
                    }
                    n();
                }
            }
            Set set = f.a(getContext()).c.c;
            if (!(set == null || set.contains(this.g))) {
                set.add(this.g);
                lVar.a(this);
            }
            b(lVar);
        }
    }

    protected void b(com.xunlei.downloadprovider.ad.common.adget.l lVar) {
        if (!TextUtils.isEmpty(lVar.l())) {
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(this.c.l(), this.b.d, null);
        }
        String[] a = u.a(lVar.j(), lVar.m());
        CharSequence charSequence = a[0];
        if (this.c != null) {
            com.xunlei.downloadprovider.homepage.choiceness.b.a();
            com.xunlei.downloadprovider.homepage.choiceness.b.a(this.c.k(), this.b.f);
            this.b.g.setText(charSequence);
        }
        this.b.a.setText(a[1]);
        h();
        c(lVar);
    }

    protected final void d(com.xunlei.downloadprovider.ad.common.adget.l lVar) {
        if (lVar != null) {
            com.xunlei.downloadprovider.ad.home.a.a(lVar, "button");
            if ((lVar instanceof com.xunlei.downloadprovider.ad.common.adget.a.d) && lVar.G() != null && (lVar.G() instanceof NativeResponse)) {
                try {
                    NativeResponse nativeResponse = (NativeResponse) lVar.G();
                    Method declaredMethod = nativeResponse.getClass().getDeclaredMethod("handleClickDownloadDirect", new Class[]{View.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(nativeResponse, new Object[]{this});
                    lVar.h();
                    lVar.K();
                    lVar.g();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                lVar.onClick(this);
            }
            if (lVar.w() && lVar.c() == AD_SYSTEM_TYPE.SOURCE_XUNLEI_FLAG) {
                String s = lVar.s();
                if (!TextUtils.isEmpty(s)) {
                    this.a.c = false;
                    DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
                    downloadAdditionInfo.b = lVar.p();
                    downloadAdditionInfo.a = lVar.o();
                    downloadAdditionInfo.f = true;
                    TaskStatInfo taskStatInfo = new TaskStatInfo(com.xunlei.downloadprovider.ad.common.c.a.a(lVar), s, null);
                    g.a();
                    g.a(s, lVar.o(), taskStatInfo, downloadAdditionInfo);
                }
            }
        }
    }

    public void i() {
        this.c = null;
        a aVar = this.b;
        aVar.f.setImageResource(R.drawable.feedflow_icon_default);
        aVar.f.setTag(aVar.f.getId(), null);
        aVar.g.setText("");
        this.b.a.setText("");
        com.xunlei.downloadprovider.homepage.choiceness.b.a().a("", this.b.d, null);
    }

    public ViewGroup getContainerLayout() {
        return this.b.c;
    }

    protected final void c(ThunderXmpPlayer thunderXmpPlayer) {
        super.c(thunderXmpPlayer);
        thunderXmpPlayer.v = false;
        thunderXmpPlayer.c(new n(this, thunderXmpPlayer));
        thunderXmpPlayer.a(new o(this, thunderXmpPlayer));
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        if (this.b != null) {
            this.b.d.setVisibility(4);
            this.b.e.setVisibility(8);
            this.b.b.setVisibility(8);
        }
        if (this.d != null) {
            this.d.a((com.xunlei.downloadprovider.player.a.b) this);
        }
    }

    public final void b(ThunderXmpPlayer thunderXmpPlayer) {
        super.b(thunderXmpPlayer);
        n();
        if (this.d != null) {
            this.d.a(null);
        }
    }

    public final boolean b() {
        o();
        return true;
    }

    public final boolean c() {
        if (getPlayer() != null) {
            getPlayer().r();
        }
        return true;
    }

    public View getPlayerContainerView() {
        return this.b.c;
    }

    public int getPosition() {
        return this.f;
    }

    public ControlType getPlayerControllerType() {
        return ControlType.AUTO_PLAY;
    }

    public PlayerTag getPlayerTag() {
        return PlayerTag.HOME;
    }

    public int getListPosition() {
        return this.f;
    }

    private void setHubExtras(com.xunlei.downloadprovider.ad.common.adget.l lVar) {
        Map hashMap = new HashMap();
        hashMap.put("contentlist", f.a(getContext().getApplicationContext()).c.b(getViewPositionKey()));
        hashMap.put("is_system_refresh", String.valueOf(lVar.B));
        lVar.E = hashMap;
        lVar.F = hashMap;
    }
}
