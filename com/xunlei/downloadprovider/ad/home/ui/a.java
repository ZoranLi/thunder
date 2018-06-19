package com.xunlei.downloadprovider.ad.home.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeMediaADData;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.ad.home.ui.ADItemView.AD_LAYOUT_TYPE;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i$a;
import com.xunlei.downloadprovider.player.xmp.ui.MediaPlayerLoadingView;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ADGDTVideoItemBase */
public abstract class a<T extends a> extends FrameLayout implements OnClickListener, com.xunlei.downloadprovider.ad.common.adget.c.f.a, ADItemView, t, com.xunlei.downloadprovider.homepage.choiceness.ui.a.b<e>, i$a, com.xunlei.downloadprovider.player.a.b {
    protected Context a = null;
    protected i b;
    protected T c;
    protected l d;
    protected Rect e = new Rect();
    private String f = "ADGDTVideoItem";
    private com.xunlei.downloadprovider.player.a.a g;
    private int h;
    private String i;
    private e j;
    private boolean k = false;
    private NativeMediaADData l;
    private XLAlertDialog m = null;
    private long n;

    /* compiled from: ADGDTVideoItemBase */
    protected class a {
        View a;
        ImageView b;
        TextView c;
        TextView d;
        ImageView e;
        ImageView f;
        MediaPlayerLoadingView g;
        MediaView h;
        View i;
        TextView j;
        View k;
        final /* synthetic */ a l;

        protected a(a aVar) {
            this.l = aVar;
        }
    }

    /* compiled from: ADGDTVideoItemBase */
    protected class d extends a {
        final /* synthetic */ a q;

        protected d(a aVar) {
            this.q = aVar;
            super(aVar);
        }
    }

    /* compiled from: ADGDTVideoItemBase */
    protected class b extends d {
        TextView m;
        TextView n;
        TextView o;
        final /* synthetic */ a p;

        protected b(a aVar) {
            this.p = aVar;
            super(aVar);
        }
    }

    /* compiled from: ADGDTVideoItemBase */
    protected class c extends d {
        ImageView m;
        TextView n;
        final /* synthetic */ a o;

        protected c(a aVar) {
            this.o = aVar;
            super(aVar);
        }
    }

    protected abstract T e();

    public View getContainer() {
        return this;
    }

    protected void h() {
    }

    protected void i() {
    }

    public a(Context context, com.xunlei.downloadprovider.player.a.a aVar) {
        super(context);
        this.a = context;
        this.g = aVar;
        View inflate = LayoutInflater.from(this.a).inflate(getLayoutId(), this, true);
        this.c = e();
        a(inflate);
        this.c.f = (ImageView) inflate.findViewById(R.id.play_icon);
        this.c.h = (MediaView) inflate.findViewById(R.id.media_view_gdt);
        this.c.g = (MediaPlayerLoadingView) inflate.findViewById(R.id.loading_view);
        this.c.i = inflate.findViewById(R.id.item_player_container);
        this.c.j = (TextView) inflate.findViewById(R.id.btn_error);
        this.c.a.setOnClickListener(this);
        this.c.e.setOnClickListener(this);
        this.c.h.setOnClickListener(this);
        this.c.j.setOnClickListener(this);
    }

    protected void a(View view) {
        this.c.a = view.findViewById(R.id.root_view);
        this.c.d = (TextView) view.findViewById(R.id.item_title);
        this.c.e = (ImageView) view.findViewById(R.id.item_poster);
        this.c.b = (ImageView) findViewById(R.id.iv_avatar);
        this.c.c = (TextView) findViewById(R.id.tv_publisher_name);
    }

    public final void f() {
        m();
    }

    public final void a(int i, i iVar, int i2, View view, e eVar) {
        this.b = iVar;
        this.b.a(this);
        iVar = getViewPositionKey();
        this.h = i;
        this.j = eVar;
        setTag(R.id.position_layout, Integer.valueOf(i));
        if ((view instanceof ADItemView) != 0) {
            ADItemView aDItemView = (ADItemView) view;
            aDItemView.a(eVar.b());
            i = f.a(getContext().getApplicationContext()).c.a(eVar.b());
            if (this.d == 0 || i == 0 || this.d.G() != i.G() || iVar.equals(eVar.b()) == 0) {
                j();
                this.c.e.setImageResource(R.drawable.choiceness_icon_default);
                this.c.e.setTag(this.c.e.getId(), 0);
                this.c.e.setVisibility(null);
                this.c.h.setVisibility(8);
                this.c.f.setVisibility(8);
                this.c.j.setVisibility(8);
            }
            f.a(getContext()).a(eVar, aDItemView, this.b);
        }
    }

    public final void a(l lVar) {
        if (!com.xunlei.downloadprovider.ad.common.f.a(getContext()) && lVar != null) {
            this.d = lVar;
            setHubExtras(this.d);
            lVar = this.d.G();
            if (lVar instanceof NativeMediaADData) {
                NativeMediaADData nativeMediaADData = (NativeMediaADData) lVar;
                if (this.l != nativeMediaADData) {
                    this.l = nativeMediaADData;
                    if (q() != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        this.n = currentTimeMillis;
                        this.l.setMediaListener(new f(this, currentTimeMillis));
                    }
                }
            } else {
                this.l = null;
            }
            lVar = f.a(getContext().getApplicationContext()).c.c;
            if (!(lVar == null || lVar.contains(this.i))) {
                this.d.a(this);
                lVar.add(this.i);
            }
            g();
            if (q() == null) {
                this.c.e.setVisibility(0);
                this.c.h.setVisibility(8);
                this.c.f.setVisibility(8);
                this.c.j.setVisibility(8);
                this.c.g.b();
            } else if (r() != null) {
                if (s() != null) {
                    p();
                } else {
                    n();
                }
            } else if (s() != null) {
                o();
            } else {
                n();
            }
            if ((this.d instanceof com.xunlei.downloadprovider.ad.common.adget.c.f) != null) {
                ((com.xunlei.downloadprovider.ad.common.adget.c.f) this.d).a = this;
            }
        }
    }

    private void setHubExtras(l lVar) {
        Map hashMap = new HashMap();
        hashMap.put("contentlist", f.a(getContext().getApplicationContext()).c.b(getViewPositionKey()));
        hashMap.put("is_system_refresh", String.valueOf(lVar.B));
        lVar.E = hashMap;
        lVar.F = hashMap;
    }

    protected void g() {
        String[] a = u.a(this.d.j(), this.d.m());
        CharSequence charSequence = a[0];
        com.xunlei.downloadprovider.homepage.choiceness.b.a();
        com.xunlei.downloadprovider.homepage.choiceness.b.a(this.d.k(), this.c.b);
        this.c.c.setText(charSequence);
        this.c.d.setText(a[1]);
        com.xunlei.downloadprovider.homepage.choiceness.b.a().a(this.d.l(), this.c.e, null);
        h();
        i();
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == R.id.item_poster) {
            if (q() == null) {
                b("image");
            } else if (this.c.f.getVisibility() == null) {
                view = (com.xunlei.xllib.android.b.e(getContext()) == null || r() != null) ? null : true;
                if (view != null) {
                    a(new d(this), new e(this));
                    if (this.m != null) {
                        this.m.show();
                    }
                    return;
                }
                a(false);
            } else if (this.c.g.getVisibility() == null) {
            }
        } else if (view != R.id.root_view) {
            if (view != R.id.btn_error) {
                if (view == R.id.media_view_gdt) {
                }
            } else if (com.xunlei.xllib.android.b.e(getContext()) != null) {
                a(new b(this), new c(this));
            } else {
                l();
            }
        } else {
            b(DispatchConstants.OTHER);
        }
    }

    private void b(String str) {
        if (this.d != null) {
            com.xunlei.downloadprovider.ad.home.a.a(this.d, str);
            this.d.onClick(this);
        }
    }

    private void l() {
        if (q()) {
            if (!r()) {
                this.l.preLoadVideo();
                o();
            }
        }
    }

    private void a(boolean z) {
        if (q()) {
            if (!s()) {
                StringBuilder stringBuilder = new StringBuilder("posKey: ");
                stringBuilder.append(getViewPositionKey());
                stringBuilder.append(" startPlay isVideoAdLoaded: ");
                stringBuilder.append(r());
                stringBuilder.append(" auto: ");
                stringBuilder.append(z);
                this.k = z;
                if (!this.k && this.g) {
                    z = this.g.c;
                    if (z) {
                        z.c();
                        this.g.a(null);
                    }
                }
                if (r()) {
                    p();
                    this.l.bindView(this.c.h, true);
                    this.l.play();
                    this.l.setVolumeOn(this.k ^ true);
                } else {
                    l();
                }
                if (this.g) {
                    this.g.a((com.xunlei.downloadprovider.player.a.b) this);
                }
            }
        }
    }

    private void m() {
        if (q()) {
            if (s()) {
                StringBuilder stringBuilder = new StringBuilder("posKey: ");
                stringBuilder.append(getViewPositionKey());
                stringBuilder.append(" stopPlay isVideoAdLoaded: ");
                stringBuilder.append(r());
                n();
                if (r()) {
                    this.l.stop();
                }
                if (this.g != null) {
                    this.g.a(null);
                }
            }
        }
    }

    private void n() {
        this.c.f.setVisibility(0);
        this.c.e.setVisibility(0);
        this.c.g.b();
        this.c.h.setVisibility(8);
        this.c.j.setVisibility(8);
    }

    private void o() {
        this.c.g.a();
        this.c.e.setVisibility(0);
        this.c.f.setVisibility(8);
        this.c.h.setVisibility(8);
        this.c.j.setVisibility(8);
    }

    private void p() {
        this.c.h.setVisibility(0);
        this.c.f.setVisibility(8);
        this.c.e.setVisibility(8);
        this.c.j.setVisibility(8);
        this.c.g.b();
    }

    private boolean q() {
        return this.l != null && this.l.isVideoAD();
    }

    private boolean r() {
        return q() && this.l.isVideoLoaded();
    }

    public String getViewPositionKey() {
        return this.i;
    }

    public final String a(String str) {
        this.i = str;
        return str;
    }

    public AD_LAYOUT_TYPE getADType() {
        return AD_LAYOUT_TYPE.PLAY_VOD_TYPE_VIEW;
    }

    public View getPlayerContainerView() {
        return this.c.i;
    }

    public final boolean b() {
        a(true);
        return true;
    }

    public final boolean c() {
        m();
        return true;
    }

    public final void a(NativeMediaADData nativeMediaADData) {
        new StringBuilder("onADVideoLoaded (mMediaADData == sourceAD): ").append(this.l == nativeMediaADData);
        if (this.l == nativeMediaADData) {
            nativeMediaADData = new StringBuilder("onVideoLoadedCallback isVideoAdLoaded: ");
            nativeMediaADData.append(r());
            nativeMediaADData.append(" isActive(): ");
            nativeMediaADData.append(s());
            if (q() != null) {
                if (s() != null) {
                    if (r() != null) {
                        p();
                        this.l.bindView(this.c.h, true);
                        this.l.play();
                        this.l.setVolumeOn(this.k ^ true);
                    }
                }
            }
        }
    }

    public final void a(NativeMediaADData nativeMediaADData, int i) {
        StringBuilder stringBuilder = new StringBuilder("onADError errorCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" (mMediaADData == sourceAD): ");
        stringBuilder.append(this.l == nativeMediaADData);
        if (this.l == nativeMediaADData && i == 700) {
            nativeMediaADData = new StringBuilder("onVideoADLoadErrorCallback isVideoAdLoaded: ");
            nativeMediaADData.append(r());
            nativeMediaADData.append(" isActive(): ");
            nativeMediaADData.append(s());
            if (q() != null) {
                if (s() != null) {
                    this.c.e.setVisibility(0);
                    this.c.j.setVisibility(0);
                    this.c.f.setVisibility(8);
                    this.c.h.setVisibility(8);
                    this.c.g.b();
                }
            }
        }
    }

    private boolean s() {
        return this.g.b((com.xunlei.downloadprovider.player.a.b) this);
    }

    public final boolean d() {
        return q();
    }

    public int getPosition() {
        return this.h;
    }

    private void a(@NonNull DialogInterface.OnClickListener onClickListener, @NonNull DialogInterface.OnClickListener onClickListener2) {
        if (this.m == null) {
            this.m = new XLAlertDialog(this.a);
            this.m.setTitle((CharSequence) "温馨提示");
            this.m.setMessage((CharSequence) "当前为移动网络，开始播放视频？");
            this.m.setConfirmButtonText((CharSequence) "确认");
            this.m.setCancelButtonText((CharSequence) "取消");
        }
        this.m.setOnClickConfirmButtonListener(onClickListener);
        this.m.setOnClickCancelButtonListener(onClickListener2);
    }

    protected final void k() {
        if (this.m != null) {
            this.m.dismiss();
        }
    }

    protected void j() {
        this.c.b.setImageResource(R.drawable.feedflow_icon_default);
        this.c.b.setTag(this.c.b.getId(), null);
        this.c.c.setText("");
        this.c.d.setText("");
    }

    static /* synthetic */ boolean a(a aVar, long j) {
        return j == aVar.n ? true : null;
    }

    static /* synthetic */ void d(a aVar) {
        if (aVar.q()) {
            if (aVar.s()) {
                aVar.n();
                if (aVar.r()) {
                    aVar.l.stop();
                }
            }
        }
    }

    static /* synthetic */ void f(a aVar) {
        if (aVar.q()) {
            if (aVar.s()) {
                if (aVar.r()) {
                    aVar.p();
                    aVar.l.resume();
                    return;
                }
                aVar.o();
            }
        }
    }
}
