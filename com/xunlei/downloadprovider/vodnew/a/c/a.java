package com.xunlei.downloadprovider.vodnew.a.c;

import android.view.SurfaceView;
import com.aplayer.aplayerandroid.APlayerAndroid;
import com.aplayer.aplayerandroid.APlayerAndroid.Size;
import com.aplayer.aplayerandroid.APlayerAndroid.StatisticsInfo;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.vodnew.a.d.a.b;
import com.xunlei.downloadprovider.vodnew.a.d.a.c;
import com.xunlei.downloadprovider.vodnew.a.d.a.d;
import com.xunlei.downloadprovider.vodnew.a.d.a.e;
import com.xunlei.downloadprovider.vodnew.a.d.a.f;
import com.xunlei.downloadprovider.vodnew.a.d.a.g;
import java.io.FileDescriptor;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: APlayerAndroidProxy */
public class a implements com.xunlei.downloadprovider.vodnew.a.d.a {
    private int a = 0;
    private APlayerAndroid b;
    private List<e> c = new CopyOnWriteArrayList();
    private List<b> d = new CopyOnWriteArrayList();
    private List<Object> e = new CopyOnWriteArrayList();
    private List<Object> f = new CopyOnWriteArrayList();
    private List<c> g = new CopyOnWriteArrayList();
    private List<d> h = new CopyOnWriteArrayList();
    private List<com.xunlei.downloadprovider.vodnew.a.d.a.a> i = new CopyOnWriteArrayList();
    private List<f> j = new CopyOnWriteArrayList();
    private List<Object> k = new CopyOnWriteArrayList();
    private List<Object> l = new CopyOnWriteArrayList();
    private List<g> m = new CopyOnWriteArrayList();

    public a() {
        synchronized (a.class) {
            this.b = new APlayerAndroid();
            this.b.setOnReCreateHwDecoderListener(new b(this));
            this.b.setOnFirstFrameRenderListener(new e(this));
            this.b.setOnOpenSuccessListener(new f(this));
            this.b.setOnPlayStateChangeListener(new g(this));
            this.b.setOnOpenCompleteListener(new h(this));
            this.b.setOnPlayCompleteListener(new i(this));
            this.b.setOnBufferListener(new j(this));
            this.b.setOnSeekCompleteListener(new k(this));
            this.b.setOnSurfaceDestroyListener(new l(this));
            this.b.setOnSystemPlayerFailListener(new c(this));
            this.b.setOnShowSubtitleListener(new d(this));
            this.a = APlayerAndroid.gObjId - 1;
        }
    }

    public final void a() {
        this.c.clear();
        this.d.clear();
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.k.clear();
        this.l.clear();
        this.m.clear();
    }

    public final int b() {
        return this.a;
    }

    public final void c() {
        a();
        this.b.destroy();
        l.a(this, "mSubtilteview");
        l.a(this, "mSurfaceview");
    }

    public final int a(SurfaceView surfaceView) {
        return this.b.setView(surfaceView);
    }

    public final int a(String str) {
        return this.b.open(str);
    }

    public final int a(FileDescriptor fileDescriptor) {
        return this.b.open(fileDescriptor);
    }

    public final int d() {
        return this.b.close();
    }

    public final int e() {
        return this.b.play();
    }

    public final int f() {
        return this.b.pause();
    }

    public final int g() {
        return this.b.getDuration();
    }

    public final int h() {
        return this.b.getPosition();
    }

    public final int a(int i) {
        return this.b.setPosition(i);
    }

    public final int i() {
        return this.b.getVideoWidth();
    }

    public final int j() {
        return this.b.getVideoHeight();
    }

    public final int k() {
        return this.b.getBufferProgress();
    }

    public final String b(int i) {
        return this.b.getConfig(i);
    }

    public final int a(int i, String str) {
        return this.b.setConfig(i, str);
    }

    public final StatisticsInfo l() {
        return this.b.getStatisticsInfo();
    }

    public final Size a(Size size) {
        return this.b.getAdjustSurfaceViewSize(size);
    }

    public final void m() {
        this.b.activityPause();
    }

    public final void n() {
        this.b.activityResume();
    }

    public final boolean b(String str) {
        return this.b.startRecord(str);
    }

    public final boolean o() {
        return this.b.isRecording();
    }

    public final void p() {
        this.b.endRecord();
    }

    public final void q() {
        this.b.stopRead(false);
    }

    public final void a(boolean z) {
        this.b.openLog(z);
    }

    public final void a(e eVar) {
        if (!this.c.contains(eVar)) {
            this.c.add(eVar);
        }
    }

    public final void a(b bVar) {
        if (!this.d.contains(bVar)) {
            this.d.add(bVar);
        }
    }

    public final void a(c cVar) {
        if (!this.g.contains(cVar)) {
            this.g.add(cVar);
        }
    }

    public final void b(c cVar) {
        this.g.remove(cVar);
    }

    public final void a(d dVar) {
        if (!this.h.contains(dVar)) {
            this.h.add(dVar);
        }
    }

    public final void b(d dVar) {
        this.h.remove(dVar);
    }

    public final void a(com.xunlei.downloadprovider.vodnew.a.d.a.a aVar) {
        if (!this.i.contains(aVar)) {
            this.i.add(aVar);
        }
    }

    public final void a(f fVar) {
        if (!this.j.contains(fVar)) {
            this.j.add(fVar);
        }
    }

    public final void a(g gVar) {
        if (!this.m.contains(gVar)) {
            this.m.add(gVar);
        }
    }
}
