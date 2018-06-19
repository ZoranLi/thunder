package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.downloadprovider.database.a.a;
import com.xunlei.downloadprovider.download.downloadvod.TaskPlayInfo;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.personal.playrecord.v$a;
import com.xunlei.xllib.b.d;

/* compiled from: DownloadDetailsActivityFragment */
final class af implements v$a {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ DownloadDetailsActivityFragment c;

    af(DownloadDetailsActivityFragment downloadDetailsActivityFragment, boolean z, boolean z2) {
        this.c = downloadDetailsActivityFragment;
        this.a = z;
        this.b = z2;
    }

    public final void a(a aVar) {
        Object<BTSubTaskInfo> g = this.c.g.g();
        if (this.c.p != null) {
            TaskPlayInfo taskPlayInfo = this.c.p.c;
            if (taskPlayInfo != null) {
                for (BTSubTaskInfo bTSubTaskInfo : g) {
                    if (bTSubTaskInfo.mLocalFileName.equals(taskPlayInfo.mLocalFileName)) {
                        return;
                    }
                }
            }
        }
        this.c.B = aVar;
        aVar = aVar == null ? -1 : aVar.d;
        BTSubTaskInfo bTSubTaskInfo2 = null;
        if (!d.a(g)) {
            for (BTSubTaskInfo bTSubTaskInfo3 : g) {
                if (k.c(bTSubTaskInfo3)) {
                    if (bTSubTaskInfo2 == null) {
                        bTSubTaskInfo2 = bTSubTaskInfo3;
                    }
                    if (bTSubTaskInfo3.mBTSubIndex == aVar) {
                        bTSubTaskInfo2 = bTSubTaskInfo3;
                        break;
                    }
                }
            }
        }
        if (bTSubTaskInfo2 != null) {
            this.c.p = new i(this.c.f, bTSubTaskInfo2, "download_detail_new");
            if (this.c.B == null) {
                this.c.B = new a();
                this.c.B.c = this.c.f.mInfoHash;
                this.c.B.b = this.c.f.getTaskId();
            }
            this.c.B.d = bTSubTaskInfo2.mBTSubIndex;
        }
        if (this.c.getActivity() != null) {
            this.c.getActivity().runOnUiThread(new ag(this));
        }
    }
}
