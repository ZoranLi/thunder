package com.xunlei.downloadprovider.download.privatespace;

import com.xunlei.downloadprovider.download.engine.kernel.g;
import java.io.File;

/* compiled from: PrivateSpaceMgr */
final class al implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ long b;
    final /* synthetic */ PrivateSpaceMgr c;

    al(PrivateSpaceMgr privateSpaceMgr, String str, long j) {
        this.c = privateSpaceMgr;
        this.a = str;
        this.b = j;
    }

    public final void run() {
        File file = new File(this.a);
        if (file.exists()) {
            try {
                File e = v.e();
                int c = g.b().moveTask(this.b, e.getPath());
                StringBuilder stringBuilder = new StringBuilder("[moveFileToPrivateSpace] sourceFilePath");
                stringBuilder.append(this.a);
                stringBuilder.append(" ,result=");
                stringBuilder.append(c);
                if (c == 200) {
                    File file2 = new File(e.getPath(), file.getName());
                    PrivateSpaceMgr.a(this.c, this.a, file2.getPath());
                    PrivateSpaceMgr.a(file, file2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
