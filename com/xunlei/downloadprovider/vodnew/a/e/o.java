package com.xunlei.downloadprovider.vodnew.a.e;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.SurfaceView;
import com.aplayer.aplayerandroid.APlayerAndroid.CONFIGID;
import com.aplayer.aplayerandroid.APlayerAndroid.Size;
import com.aplayer.aplayerandroid.APlayerAndroid.StatisticsInfo;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import java.io.FileDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: XLMediaPlayer */
public class o implements com.xunlei.downloadprovider.vodnew.a.d.c {
    private static final String u = "o";
    private static SparseArray<com.xunlei.downloadprovider.vodnew.a.d.c> v = new SparseArray();
    com.xunlei.downloadprovider.vodnew.a.d.a a = new com.xunlei.downloadprovider.vodnew.a.c.a();
    SurfaceView b;
    com.xunlei.downloadprovider.download.downloadvod.i c;
    VideoPlayRecord d;
    a e;
    int f = 0;
    int g = 0;
    int h = 0;
    e i;
    b j;
    a k;
    g l;
    i m;
    c n;
    d o;
    f p;
    h q;
    boolean r = false;
    boolean s = false;
    com.xunlei.downloadprovider.vodnew.a.d.a.d t = new y(this);
    private HashMap<Integer, String> w = new HashMap();
    private boolean x = false;
    private Handler y = new Handler(Looper.getMainLooper());
    private com.xunlei.downloadprovider.vodnew.a.d.a.d z = new z(this);

    /* compiled from: XLMediaPlayer */
    public interface a {
        void a(com.xunlei.downloadprovider.vodnew.a.d.c cVar, int i);
    }

    /* compiled from: XLMediaPlayer */
    public interface b {
        void a(com.xunlei.downloadprovider.vodnew.a.d.c cVar);
    }

    /* compiled from: XLMediaPlayer */
    public interface c {
        boolean a(com.xunlei.downloadprovider.vodnew.a.d.c cVar, int i, int i2);
    }

    /* compiled from: XLMediaPlayer */
    public interface d {
        void a(com.xunlei.downloadprovider.vodnew.a.d.c cVar);
    }

    /* compiled from: XLMediaPlayer */
    public interface e {
        void a(com.xunlei.downloadprovider.vodnew.a.d.c cVar);
    }

    /* compiled from: XLMediaPlayer */
    public interface f {
        void a(com.xunlei.downloadprovider.vodnew.a.d.c cVar);
    }

    /* compiled from: XLMediaPlayer */
    public interface g {
        void a(com.xunlei.downloadprovider.vodnew.a.d.c cVar);
    }

    /* compiled from: XLMediaPlayer */
    public interface h {
        void a(String str);
    }

    /* compiled from: XLMediaPlayer */
    public interface i {
        void a(com.xunlei.downloadprovider.vodnew.a.d.c cVar, int i, int i2, int i3);
    }

    public o() {
        this.a.a(false);
        this.a.a(209, "1");
        if (v == null) {
            v = new SparseArray();
        }
        v.append(c(), this);
        this.a.a(new s(this));
        this.a.a(new t(this));
        this.a.a(new u(this));
        this.a.a(new v(this));
        this.a.a(new w(this));
        this.a.a(new x(this));
        this.e = new d(this);
    }

    private static boolean H() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    final void a() {
        if (this.c.d() == null) {
            if (this.c.k() == null) {
                c(6);
                if (this.n != null) {
                    this.n.a(this, 2, 0);
                }
            }
        }
        this.a.a(new p(this));
        this.c.a(this.c.d());
        if (this.c.k() != null) {
            a(this.c.k());
            return;
        }
        if (this.c.d() != null) {
            b(this.c.d());
        }
    }

    public final int c() {
        return this.a.b();
    }

    public final void a(SurfaceView surfaceView) {
        this.b = surfaceView;
        this.a.a(surfaceView);
    }

    public final boolean a(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder("checkAndAdjustSurfaceViewSize, isHwDecord : ");
        stringBuilder.append(I());
        stringBuilder.append(" api_level : ");
        stringBuilder.append(VERSION.SDK_INT);
        if (I() && VERSION.SDK_INT < 20) {
            stringBuilder = new StringBuilder("checkAndAdjustSurfaceViewSize, apiLevel小于20且硬解,原始surfaceView大小为 width : ");
            stringBuilder.append(i);
            stringBuilder.append(" height : ");
            stringBuilder.append(i2);
            com.xunlei.downloadprovider.vodnew.a.a aVar = new com.xunlei.downloadprovider.vodnew.a.a();
            Size size = new Size();
            size.width = i;
            size.height = i2;
            i = this.a.a(size);
            aVar.a = i.width;
            aVar.b = i.height;
            i = new StringBuilder("checkAndAdjustSurfaceViewSize, apiLevel小于20且硬解,调整surfaceView大小为 width : ");
            i.append(aVar.a);
            i.append(" height : ");
            i.append(aVar.b);
            if (aVar.a > 0 && aVar.b > 0) {
                this.b.getLayoutParams().width = aVar.a;
                this.b.getLayoutParams().height = aVar.b;
                this.b.requestLayout();
                return true;
            }
        }
        return false;
    }

    public final void a(com.xunlei.downloadprovider.download.downloadvod.i iVar) {
        this.e.a(iVar);
    }

    public final void d() {
        this.e.c();
    }

    public final void e() {
        this.e.d();
    }

    public final void f() {
        this.e.e();
    }

    public final void g() {
        this.e.f();
    }

    public final void a(int i) {
        this.e.a(i);
    }

    public final n b() {
        StatisticsInfo l = this.a.l();
        if (l == null) {
            return null;
        }
        n nVar = new n();
        nVar.a = l.videoCodecName;
        nVar.b = l.audioCodecName;
        nVar.c = l.subtitleCodecName;
        nVar.d = l.containerName;
        nVar.e = l.error;
        nVar.f = l.streamType;
        nVar.g = l.isHwdecoder;
        nVar.h = l.videoFrameRate;
        return nVar;
    }

    public final void z() {
        this.a.q();
    }

    private boolean I() {
        return "1".equals(b((int) CONFIGID.HW_DECODER_ENABLE));
    }

    public final void A() {
        this.a.m();
    }

    public final void B() {
        this.a.n();
    }

    public final void h() {
        this.e.g();
    }

    public final void i() {
        this.e.h();
    }

    final void c(int i) {
        this.e = a.a(this, i);
        new StringBuilder("创建状态，setStateInner : ").append(this.e.b());
    }

    final void C() {
        new StringBuilder("closeInner, mIsOpenCalled : ").append(this.r);
        if (this.r) {
            this.a.a(this.z);
            Thread.currentThread().getId();
            this.a.d();
            this.s = true;
            this.r = false;
        }
    }

    final void b(String str) {
        if (!this.s) {
            if (H()) {
                this.a.a(str);
            } else {
                this.y.post(new q(this, str));
            }
            this.r = true;
        }
    }

    final void a(FileDescriptor fileDescriptor) {
        new StringBuilder("openInner, fileDescriptor, valid : ").append(fileDescriptor.valid());
        if (!this.s) {
            if (H()) {
                this.a.a(fileDescriptor);
            } else {
                this.y.post(new r(this, fileDescriptor));
            }
            this.r = true;
        }
    }

    final void D() {
        this.y.removeCallbacksAndMessages(null);
        C();
        c(4);
    }

    final void E() {
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.y.removeCallbacksAndMessages(null);
        C();
        c(1);
    }

    final void F() {
        this.y.removeCallbacksAndMessages(null);
        if (v != null) {
            v.delete(c());
        }
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.a.a();
        this.a.c();
        if (this.c != null) {
            this.c.i();
            this.c = null;
        }
        c(0);
    }

    public final void b(boolean z) {
        this.x = z;
    }

    public final int a(int i, String str) {
        Integer valueOf = Integer.valueOf(i);
        String str2 = (String) this.w.get(valueOf);
        if (str2 != null && str2.equals(str)) {
            return 0;
        }
        this.w.put(valueOf, str);
        int a = this.a.a(i, str);
        StringBuilder stringBuilder = new StringBuilder("setConfig, configID : ");
        stringBuilder.append(i);
        stringBuilder.append(" value : ");
        stringBuilder.append(str);
        stringBuilder.append(" ret : ");
        stringBuilder.append(a);
        return a;
    }

    public final void a(Map<Integer, String> map) {
        if (map != null) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                a(((Integer) entry.getKey()).intValue(), (String) entry.getValue());
            }
        }
    }

    public final String b(int i) {
        return this.a.b(i);
    }

    public final HashMap<Integer, String> j() {
        return this.w;
    }

    public final int k() {
        return this.a.i();
    }

    public final int l() {
        return this.a.j();
    }

    public final int m() {
        return this.b.getHeight();
    }

    public final int n() {
        return this.f;
    }

    public final int o() {
        return this.a.h();
    }

    public final int p() {
        return this.a.k();
    }

    public final boolean q() {
        return this.e.a() == 1;
    }

    public final boolean r() {
        return this.e.a() == 4;
    }

    public final boolean s() {
        return this.e.a() == 5;
    }

    public final boolean t() {
        return this.e.a() == 2;
    }

    public final boolean u() {
        return this.e.a() == 3;
    }

    public final boolean v() {
        return this.e.a() == 6;
    }

    public final boolean w() {
        return this.e.a() == 7;
    }

    public final boolean x() {
        return this.a.o();
    }

    public final boolean a(String str) {
        return this.a.b(str);
    }

    public final void y() {
        this.a.p();
    }

    public final void c(boolean z) {
        this.a.a(z);
    }

    public final void a(e eVar) {
        this.i = eVar;
    }

    public final void a(b bVar) {
        this.j = bVar;
    }

    public final void a(a aVar) {
        this.k = aVar;
    }

    public final void a(g gVar) {
        this.l = gVar;
    }

    public final void a(i iVar) {
        this.m = iVar;
    }

    public final void a(c cVar) {
        this.n = cVar;
    }

    public final void a(d dVar) {
        this.o = dVar;
    }

    public final void a(f fVar) {
        this.p = fVar;
    }

    public final void a(h hVar) {
        this.q = hVar;
    }

    public final void a(boolean z) {
        if (z) {
            if (this.b && this.b.getContext() && (this.b.getContext() instanceof Activity)) {
                ((Activity) this.b.getContext()).getWindow().addFlags(128);
            }
            return;
        }
        if (this.b && this.b.getContext() && (this.b.getContext() instanceof Activity)) {
            ((Activity) this.b.getContext()).getWindow().clearFlags(128);
        }
    }
}
