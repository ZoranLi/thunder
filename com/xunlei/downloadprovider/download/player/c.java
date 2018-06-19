package com.xunlei.downloadprovider.download.player;

import android.graphics.Point;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.player.a;
import com.xunlei.downloadprovider.player.a.b;
import com.xunlei.xllib.android.d;
import java.io.File;

/* compiled from: PlayerStat */
public class c {
    private static final String m = "c";
    public long a;
    public long b;
    public i c;
    @Nullable
    public TaskInfo d;
    public BTSubTaskInfo e;
    public String f;
    public boolean g = false;
    public int h = 0;
    public long i;
    public String j = "manul";
    public long k = 0;
    public m l = null;

    public final String a() {
        return this.c != null ? this.c.d : "";
    }

    public final void b() {
        b d = d();
        if (d != null) {
            a.a(d.a, "play", d.b, d.z);
        }
        if (this.c != null && this.c.a != null) {
            com.xunlei.downloadprovider.download.report.a.a("dl_play_continue", this.c.a);
        }
    }

    public final void c() {
        b d = d();
        if (d != null) {
            a.a(d.a, "pause", d.b, d.z);
        }
        if (this.c != null && this.c.a != null) {
            com.xunlei.downloadprovider.download.report.a.a("dl_play_pause", this.c.a);
        }
    }

    public final b d() {
        if (this.c == null) {
            return null;
        }
        String str;
        int lastIndexOf;
        Object obj;
        Point e;
        StringBuilder stringBuilder;
        String stringBuilder2;
        File file;
        b bVar = new b();
        if (this.d != null) {
            bVar.g = this.d.getTaskDownloadUrl();
            bVar.f = this.d.mFileSize;
            bVar.v = this.d.getResourceGcid();
            bVar.w = this.d.mCID;
            bVar.z = this.d.mTaskType != null ? this.d.mTaskType.toString().toLowerCase() : "";
        }
        if (this.e != null) {
            bVar.f = this.e.mFileSize;
            bVar.v = this.e.mGCID;
            bVar.w = this.e.mCID;
        }
        bVar.a = a();
        bVar.l = this.f;
        bVar.k = this.i;
        if (this.d == null) {
            if (this.e == null) {
                str = "0";
                bVar.y = str;
                bVar.c = "player";
                if (this.c.g()) {
                    bVar.b = "bxbb";
                    if (!TextUtils.isEmpty(bVar.v)) {
                        bVar.x = LoginHelper.a().l() ? "1" : "0";
                    }
                } else {
                    bVar.b = "native";
                }
                if (this.l != null) {
                    bVar.h = this.l.m();
                    str = "unknown";
                    if (!TextUtils.isEmpty(bVar.h)) {
                        lastIndexOf = bVar.h.lastIndexOf(46);
                        if (lastIndexOf > 0) {
                            str = bVar.h.substring(lastIndexOf, bVar.h.length());
                        }
                    }
                    bVar.e = str;
                }
                bVar.t = this.a;
                bVar.d = this.j;
                if (this.l != null) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    m mVar = this.l;
                    obj = null;
                    stringBuilder3.append(mVar.a == null ? mVar.a.k() : 0);
                    stringBuilder3.append("*");
                    mVar = this.l;
                    stringBuilder3.append(mVar.a == null ? mVar.a.l() : 0);
                    bVar.i = stringBuilder3.toString();
                    if (this.l.n() != null) {
                        e = d.e(this.l.n());
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(e.x);
                        stringBuilder.append("*");
                        stringBuilder.append(e.y);
                        stringBuilder2 = stringBuilder.toString();
                        if (e.x < e.y) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(e.y);
                            stringBuilder.append("*");
                            stringBuilder.append(e.x);
                            stringBuilder2 = stringBuilder.toString();
                        }
                        bVar.j = stringBuilder2;
                    }
                    if (this.l.h() != null) {
                        if (this.l.h().h.getVisibility() == 0) {
                            obj = 1;
                        }
                        bVar.A = obj == null ? "open" : "close";
                    }
                    if (this.l.I()) {
                        if (this.l.K() != null) {
                            bVar.f = this.l.K().getStatSize();
                        } else if (!TextUtils.isEmpty(this.l.J())) {
                            file = new File(this.l.J());
                            if (file.exists()) {
                                bVar.f = file.length();
                            }
                        }
                    }
                }
                return bVar;
            }
        }
        str = "1";
        bVar.y = str;
        bVar.c = "player";
        if (this.c.g()) {
            bVar.b = "bxbb";
            if (TextUtils.isEmpty(bVar.v)) {
                if (LoginHelper.a().l()) {
                }
                bVar.x = LoginHelper.a().l() ? "1" : "0";
            }
        } else {
            bVar.b = "native";
        }
        if (this.l != null) {
            bVar.h = this.l.m();
            str = "unknown";
            if (TextUtils.isEmpty(bVar.h)) {
                lastIndexOf = bVar.h.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    str = bVar.h.substring(lastIndexOf, bVar.h.length());
                }
            }
            bVar.e = str;
        }
        bVar.t = this.a;
        bVar.d = this.j;
        if (this.l != null) {
            StringBuilder stringBuilder32 = new StringBuilder();
            m mVar2 = this.l;
            obj = null;
            if (mVar2.a == null) {
            }
            stringBuilder32.append(mVar2.a == null ? mVar2.a.k() : 0);
            stringBuilder32.append("*");
            mVar2 = this.l;
            if (mVar2.a == null) {
            }
            stringBuilder32.append(mVar2.a == null ? mVar2.a.l() : 0);
            bVar.i = stringBuilder32.toString();
            if (this.l.n() != null) {
                e = d.e(this.l.n());
                stringBuilder = new StringBuilder();
                stringBuilder.append(e.x);
                stringBuilder.append("*");
                stringBuilder.append(e.y);
                stringBuilder2 = stringBuilder.toString();
                if (e.x < e.y) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(e.y);
                    stringBuilder.append("*");
                    stringBuilder.append(e.x);
                    stringBuilder2 = stringBuilder.toString();
                }
                bVar.j = stringBuilder2;
            }
            if (this.l.h() != null) {
                if (this.l.h().h.getVisibility() == 0) {
                    obj = 1;
                }
                if (obj == null) {
                }
                bVar.A = obj == null ? "open" : "close";
            }
            if (this.l.I()) {
                if (this.l.K() != null) {
                    bVar.f = this.l.K().getStatSize();
                } else if (TextUtils.isEmpty(this.l.J())) {
                    file = new File(this.l.J());
                    if (file.exists()) {
                        bVar.f = file.length();
                    }
                }
            }
        }
        return bVar;
    }
}
