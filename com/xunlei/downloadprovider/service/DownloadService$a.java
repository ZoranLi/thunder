package com.xunlei.downloadprovider.service;

import android.os.IBinder;
import android.os.RemoteException;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.ipc.a.a;
import com.xunlei.downloadprovider.ipc.b;
import java.util.ArrayList;
import java.util.List;

public class DownloadService$a extends a implements com.xunlei.downloadprovider.ipc.a {
    DownloadService$b a = new DownloadService$b(this.b);
    final /* synthetic */ DownloadService b;

    public final IBinder asBinder() {
        return this;
    }

    public DownloadService$a(DownloadService downloadService) {
        this.b = downloadService;
    }

    public final void a(long[] jArr) throws RemoteException {
        if (jArr != null) {
            if (jArr.length != 0) {
                List arrayList = new ArrayList();
                for (long valueOf : jArr) {
                    arrayList.add(Long.valueOf(valueOf));
                }
                n.a();
                n.a(arrayList);
            }
        }
    }

    public final void a(b bVar) throws RemoteException {
        n.a();
        if (!n.a(bVar)) {
            bVar.a(null);
        }
    }
}
