package com.xunlei.downloadprovider.vodnew;

import com.xunlei.downloadprovider.database.a.a;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.s;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.personal.playrecord.v$a;
import com.xunlei.xllib.b.d;

/* compiled from: VodPlayerActivityFragment */
final class e implements v$a {
    final /* synthetic */ s a;
    final /* synthetic */ DownloadTaskInfo b;
    final /* synthetic */ VodPlayerActivityFragment c;

    e(VodPlayerActivityFragment vodPlayerActivityFragment, s sVar, DownloadTaskInfo downloadTaskInfo) {
        this.c = vodPlayerActivityFragment;
        this.a = sVar;
        this.b = downloadTaskInfo;
    }

    public final void a(a aVar) {
        Object<BTSubTaskInfo> g = this.a.g();
        VodPlayerActivityFragment.a(this.c, aVar);
        aVar = aVar == null ? -1 : aVar.d;
        BTSubTaskInfo bTSubTaskInfo = null;
        if (!d.a(g)) {
            for (BTSubTaskInfo bTSubTaskInfo2 : g) {
                if (k.c(bTSubTaskInfo2)) {
                    if (bTSubTaskInfo == null) {
                        bTSubTaskInfo = bTSubTaskInfo2;
                    }
                    if (bTSubTaskInfo2.mBTSubIndex == aVar) {
                        bTSubTaskInfo = bTSubTaskInfo2;
                        break;
                    }
                }
            }
        }
        if (bTSubTaskInfo != null) {
            aVar = new i(this.b, bTSubTaskInfo, VodPlayerActivityFragment.e(this.c));
            if (VodPlayerActivityFragment.f(this.c) == null) {
                VodPlayerActivityFragment.a(this.c, new a());
                VodPlayerActivityFragment.f(this.c).c = this.b.mInfoHash;
                VodPlayerActivityFragment.f(this.c).b = this.b.getTaskId();
            }
            VodPlayerActivityFragment.f(this.c).d = bTSubTaskInfo.mBTSubIndex;
            v.a().a(VodPlayerActivityFragment.f(this.c));
            if (this.c.getActivity() != null) {
                this.c.getActivity().runOnUiThread(new f(this, aVar));
            }
        }
    }
}
