package com.xunlei.downloadprovider.download.create;

import android.net.Uri;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;

class DownloadBtFileExplorerActivity$a {
    public long a;
    Uri b;
    String c;
    String d;
    String e;
    DownloadAdditionInfo f;
    public long[] g;
    final /* synthetic */ DownloadBtFileExplorerActivity h;

    public DownloadBtFileExplorerActivity$a(DownloadBtFileExplorerActivity downloadBtFileExplorerActivity, long j, long[] jArr, String str) {
        this.h = downloadBtFileExplorerActivity;
        this.a = -1;
        this.a = j;
        this.g = jArr;
        this.e = str;
    }

    public DownloadBtFileExplorerActivity$a(DownloadBtFileExplorerActivity downloadBtFileExplorerActivity, Uri uri, long[] jArr, String str, String str2, String str3, DownloadAdditionInfo downloadAdditionInfo) {
        this.h = downloadBtFileExplorerActivity;
        this.a = -1;
        this.a = -1;
        this.b = uri;
        this.c = str;
        this.d = str2;
        this.g = jArr;
        this.e = str3;
        this.f = downloadAdditionInfo;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void a(com.xunlei.downloadprovider.service.DownloadService r9) {
        /*
        r8 = this;
        r0 = 1;
        r1 = r8.a;	 Catch:{ Exception -> 0x006e }
        r3 = -1;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 == 0) goto L_0x0025;
    L_0x0009:
        r9 = r9.b();	 Catch:{ Exception -> 0x006e }
        r1 = r8.a;	 Catch:{ Exception -> 0x006e }
        r3 = r8.g;	 Catch:{ Exception -> 0x006e }
        r9 = r9.a;	 Catch:{ Exception -> 0x006e }
        r9.a(r1, r3);	 Catch:{ Exception -> 0x006e }
        com.xunlei.downloadprovider.download.engine.task.n.a();	 Catch:{ Exception -> 0x006e }
        r9 = new long[r0];	 Catch:{ Exception -> 0x006e }
        r1 = r8.a;	 Catch:{ Exception -> 0x006e }
        r3 = 0;
        r9[r3] = r1;	 Catch:{ Exception -> 0x006e }
        com.xunlei.downloadprovider.download.engine.task.n.b(r3, r9);	 Catch:{ Exception -> 0x006e }
        r9 = r0;
        goto L_0x0043;
    L_0x0025:
        r9 = r9.b();	 Catch:{ Exception -> 0x006e }
        r2 = r8.b;	 Catch:{ Exception -> 0x006e }
        r3 = r8.g;	 Catch:{ Exception -> 0x006e }
        r4 = r8.c;	 Catch:{ Exception -> 0x006e }
        r6 = r8.d;	 Catch:{ Exception -> 0x006e }
        r5 = r8.e;	 Catch:{ Exception -> 0x006e }
        r7 = r8.f;	 Catch:{ Exception -> 0x006e }
        r1 = r9.c;	 Catch:{ Exception -> 0x006e }
        if (r1 == 0) goto L_0x003d;
    L_0x0039:
        r1 = r9.c;	 Catch:{ Exception -> 0x006e }
        r1.c = r0;	 Catch:{ Exception -> 0x006e }
    L_0x003d:
        r1 = r9.a;	 Catch:{ Exception -> 0x006e }
        r9 = r1.a(r2, r3, r4, r5, r6, r7);	 Catch:{ Exception -> 0x006e }
    L_0x0043:
        if (r9 == 0) goto L_0x0048;
    L_0x0045:
        r9 = "task_success";
        goto L_0x004a;
    L_0x0048:
        r9 = "task_fail";
    L_0x004a:
        com.xunlei.downloadprovider.download.report.a.g(r9);	 Catch:{ Exception -> 0x006e }
        r9 = r8.d;	 Catch:{ Exception -> 0x006e }
        r9 = android.text.TextUtils.isEmpty(r9);	 Catch:{ Exception -> 0x006e }
        if (r9 == 0) goto L_0x0059;
    L_0x0055:
        r9 = "manual/manual_downloadedlist(bt)";
        r8.d = r9;	 Catch:{ Exception -> 0x006e }
    L_0x0059:
        r9 = r8.d;	 Catch:{ Exception -> 0x006e }
        com.xunlei.downloadprovider.download.engine.report.a.a(r9);	 Catch:{ Exception -> 0x006e }
        r9 = r8.h;
        r9 = r9.i;
        if (r9 == 0) goto L_0x0079;
    L_0x0064:
        r9 = r8.h;
        r9 = r9.i;
        r9.sendEmptyMessage(r0);
        return;
    L_0x006c:
        r9 = move-exception;
        goto L_0x007a;
    L_0x006e:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x006c }
        r9 = r8.h;
        r9 = r9.i;
        if (r9 == 0) goto L_0x0079;
    L_0x0078:
        goto L_0x0064;
    L_0x0079:
        return;
    L_0x007a:
        r1 = r8.h;
        r1 = r1.i;
        if (r1 == 0) goto L_0x0087;
    L_0x0080:
        r1 = r8.h;
        r1 = r1.i;
        r1.sendEmptyMessage(r0);
    L_0x0087:
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity$a.a(com.xunlei.downloadprovider.service.DownloadService):void");
    }
}
