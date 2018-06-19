package com.xunlei.downloadprovider.personal.lixianspace.b;

import android.os.Handler;
import android.os.Looper;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* compiled from: LXSpaceDataHelper */
public final class c {
    Handler a;
    List<a> b;
    public int c;
    public int d;

    /* compiled from: LXSpaceDataHelper */
    private static class a {
        private static final c a = new c();
    }

    private c() {
        this.a = new Handler(Looper.getMainLooper());
        this.c = 0;
        this.d = 0;
        LoginHelper.a().a(new d(this));
    }

    public final void a(a aVar) {
        if (aVar != null) {
            if (this.b == null) {
                this.b = new ArrayList(4);
            }
            if (!this.b.contains(aVar)) {
                this.b.add(aVar);
            }
        }
    }

    public final void b(a aVar) {
        if (!(aVar == null || this.b == null)) {
            if (!this.b.isEmpty()) {
                this.b.remove(aVar);
            }
        }
    }

    final void a(LXTaskInfo lXTaskInfo, int i, String str) {
        this.a.post(new e(this, lXTaskInfo, i, str));
    }

    final void a(List<LXTaskInfo> list, int i, String str) {
        this.a.post(new f(this, list, i, str));
    }

    final void a(int i, String str) {
        this.a.post(new g(this, i, str));
    }

    final void a(int i, String str, long j) {
        this.a.post(new h(this, j, i, str));
    }

    final void a(int i, String str, List<LXTaskInfo> list) {
        this.a.post(new i(this, list, i, str));
    }

    final void a(int i, String str, TorrentInfo torrentInfo) {
        this.a.post(new j(this, torrentInfo, i, str));
    }

    final void a(String str, int i, String str2, LXTaskInfo lXTaskInfo) {
        this.a.post(new k(this, str, i, str2, lXTaskInfo));
    }

    public final int a() {
        return !j.a().a.l() ? 0 : this.c;
    }

    final void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            int optInt = jSONObject.optInt("max_count");
            jSONObject = jSONObject.optInt("used_count");
            if (jSONObject >= null) {
                this.c = jSONObject;
            }
            if (optInt >= 0) {
                this.d = optInt;
            }
            a(null, "");
        }
    }

    public final boolean b() {
        return this.d > 0;
    }
}
