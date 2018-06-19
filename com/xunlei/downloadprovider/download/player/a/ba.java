package com.xunlei.downloadprovider.download.player.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.xunlei.common.commonview.NumberView;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.player.a;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleInfo;
import com.xunlei.downloadprovider.vod.subtitle.SubtitleManifest;
import com.xunlei.downloadprovider.vod.subtitle.s;
import com.xunlei.downloadprovider.vod.subtitle.u;
import com.xunlei.downloadprovider.vodnew.a.d.b;
import com.xunlei.downloadprovider.vodnew.a.d.c;
import java.util.List;

/* compiled from: SubtitleController */
public class ba extends f implements OnClickListener {
    private static final String m = "ba";
    c a;
    b b = null;
    public SubtitleManifest c;
    SubtitleInfo d = null;
    Context g;
    public View h;
    TextView i;
    public String j = "nofit";
    public String k = "close";
    public String l = "close";
    private NumberView n;
    private u o;
    private s p;
    private BroadcastReceiver q = null;
    private Handler r = new Handler(Looper.getMainLooper());
    private a s;
    private boolean t = false;
    private boolean u = false;
    private PopupWindow v = null;
    private boolean w = true;

    public ba(a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
        this.g = downloadVodPlayerView.getContext();
        this.a = aVar.f().a;
        if ((this.a instanceof b) != null) {
            this.b = (b) this.a;
            this.o = new u(this.g);
            this.p = new s(this.g);
            this.i = (TextView) this.e.findViewById(R.id.subtitle_display_textview);
            this.h = this.e.findViewById(R.id.subtitle_button);
            this.n = (NumberView) this.e.findViewById(R.id.subtitle_number_view);
            this.h.setOnClickListener(this);
            this.n.setOnClickListener(this);
            x();
            this.o.b = new bk(this);
            this.o.setOnDismissListener(new bl(this));
            downloadVodPlayerView = this.p;
            Object bmVar = new bm(this);
            downloadVodPlayerView.a.setValueChangeListener(bmVar);
            downloadVodPlayerView.b = bmVar;
            if (this.q == null) {
                this.q = new bb(this);
                com.xunlei.downloadprovider.h.c.a(this.g, "ACTION_OnCompletion", this.q);
                com.xunlei.downloadprovider.h.c.a(this.g, "ACTION_OnPrepared", this.q);
            }
            this.b.a(new bf(this));
            this.b.a(new bg(this));
            this.b.a(new bh(this));
            this.a.a(new bi(this));
            this.e.setOnUiChangeListener(new bj(this));
        }
        this.s = aVar;
    }

    final String m() {
        return f() != null ? f().r() : "";
    }

    final String r() {
        if (f() == null) {
            return "";
        }
        m f = f();
        if (f.b == null) {
            return "";
        }
        i iVar = f.b;
        return iVar.c != null ? iVar.c.mCID : "";
    }

    final int s() {
        return f() != null ? f().e() : 0;
    }

    final String t() {
        return f() != null ? f().m() : "";
    }

    private void x() {
        if (A() && this.f) {
            b(true);
        } else {
            b(false);
        }
    }

    public final void u() {
        this.p.a(this.e, this.d != null ? this.d.getOffset() : 0, this.c.getSubtitleColor());
    }

    public final void a(SubtitleManifest subtitleManifest, boolean z, boolean z2, boolean z3) {
        int defaultIndex;
        this.w = true;
        this.c = subtitleManifest;
        u uVar = this.o;
        List subtitleList = subtitleManifest.getSubtitleList();
        b bVar = uVar.a;
        bVar.a = subtitleList;
        bVar.notifyDataSetChanged();
        this.i.setTextColor(subtitleManifest.getSubtitleColor());
        if (this.c.getIsSubtitleManifestShowed() == null && this.c.getNetSubtitleCount() > null) {
            a(this.c.getListCount());
            this.n.setNumText(this.c.getListCount());
            this.c.setIsSubtitleManifestShowed(true);
            y();
        }
        if (z) {
            defaultIndex = this.c.getDefaultIndex();
            if (defaultIndex != true && defaultIndex < this.c.getSubtitleList().size()) {
                this.w = z3;
                b(defaultIndex);
                return;
            }
        }
        if (z2) {
            defaultIndex = this.c.getLocalDefaultIndex();
            if (defaultIndex != true && defaultIndex < this.c.getSubtitleList().size()) {
                this.w = z3;
                b(defaultIndex);
            }
        }
    }

    private void z() {
        if (this.v != null && this.v.isShowing()) {
            this.v.dismiss();
        }
        this.v = null;
    }

    final boolean v() {
        return o() != null ? o().isFinishing() : false;
    }

    private boolean A() {
        if (!(p() == null || p().f() == null)) {
            m f = p().f();
            if (f != null) {
                TaskPlayInfo N = f.N();
                if (N != null) {
                    if (N.mIsLocalPlay) {
                        return d.a().i.c();
                    }
                    return d.a().i.b();
                }
            }
        }
        return false;
    }

    private void B() {
        if (this.o != null && this.o.isShowing()) {
            this.o.dismiss();
        }
        if (this.p != null && this.p.isShowing()) {
            this.p.dismiss();
        }
    }

    public final void n_() {
        super.n_();
        this.b.a();
        B();
    }

    public final void d() {
        if (this.q != null) {
            com.xunlei.downloadprovider.h.c.a(this.g, this.q);
        }
        this.b.a(m(), t(), s());
    }

    public final void a(int i, int i2, Intent intent) {
        StringBuilder stringBuilder = new StringBuilder("onActivityResult, requestCode : ");
        stringBuilder.append(i);
        stringBuilder.append(" resultCode : ");
        stringBuilder.append(i2);
        if (i == 790) {
            if (i2 == -1) {
                Uri data = intent.getData();
                new StringBuilder("select file uri=>").append(data);
                if (this.b == 0) {
                    i2 = 0;
                } else {
                    i2 = this.b.a(data);
                }
                if (i2 == 0) {
                    XLToast.showToast(this.g, "无效的字幕文件");
                    return;
                }
                i = this.b.a(r(), t(), data);
                if (i >= 0) {
                    this.r.post(new bd(this, i));
                }
            }
        }
    }

    private void b(boolean z) {
        int i = 8;
        this.h.setVisibility(z ? 0 : 8);
        NumberView numberView = this.n;
        if (z) {
            i = 0;
        }
        numberView.setVisibility(i);
    }

    public final void a(int i) {
        this.n.setNumText(i);
    }

    private void b(int i) {
        this.o.a(i, true);
    }

    public final void a(boolean z) {
        super.a(z);
        if (!z) {
            B();
            z();
        } else if (!(TextUtils.isEmpty(r()) && TextUtils.isEmpty(t())) && A() && this.t && !this.u) {
            this.u = true;
            this.b.a(r(), t());
            y();
        }
        if (this.h != null) {
            x();
            if (z) {
                this.i.setTextSize(22.0f);
                this.i.setPadding(0, 0, 0, (int) this.g.getResources().getDimension(R.dimen.subtitle_padding_normal));
                return;
            }
            this.i.setTextSize(15.0f);
            this.i.setPadding(0, 0, 0, (int) this.g.getResources().getDimension(R.dimen.subtitle_padding_xsmall));
        }
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == R.id.subtitle_button || view == R.id.subtitle_number_view) {
            this.e.e();
            this.r.postDelayed(new be(this), 100);
        }
    }

    private void y() {
        boolean z = false;
        SharedPreferences sharedPreferences = this.g.getSharedPreferences("vod_player", 0);
        boolean z2 = sharedPreferences.getBoolean("KEY_Subtitle_First_Use_Tips_Shown", false);
        boolean z3 = this.e.e;
        boolean isNumberShowing = this.n.isNumberShowing();
        if (this.h.getVisibility() == 0) {
            z = true;
        }
        boolean g = this.e.g();
        this.e.j();
        if (g && isNumberShowing && !z2 && z3 && r2 && !v()) {
            this.r.postDelayed(new bc(this, sharedPreferences), 100);
        }
    }
}
