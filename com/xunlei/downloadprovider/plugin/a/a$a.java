package com.xunlei.downloadprovider.plugin.a;

import android.os.RemoteException;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.e;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.ipc.download.IPCTaskInfo;
import com.xunlei.downloadprovider.ipc.download.a.a;

/* compiled from: IDownloadTaskManagerImpl */
class a$a extends a {
    public static a$a a = new a$a();

    private a$a() {
    }

    public final IPCTaskInfo a(long j) throws RemoteException {
        n.a();
        j = n.f(j);
        if (j == null) {
            return 0;
        }
        IPCTaskInfo iPCTaskInfo = new IPCTaskInfo();
        iPCTaskInfo.a = j.getTaskId();
        iPCTaskInfo.b = j.mCID;
        iPCTaskInfo.c = j.mGCID;
        iPCTaskInfo.d = j.mInfoHash;
        iPCTaskInfo.e = j.mFileSize;
        iPCTaskInfo.f = j.mUrl;
        iPCTaskInfo.g = j.mRefUrl;
        iPCTaskInfo.h = j.mTitle;
        iPCTaskInfo.i = j.mLocalFileName;
        int i = 0;
        switch (e.a[j.mTaskType.ordinal()]) {
            case 1:
                break;
            case 2:
                i = 1;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 4;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 6;
                break;
            default:
                break;
        }
        iPCTaskInfo.j = i;
        iPCTaskInfo.k = j.getTaskStatus();
        iPCTaskInfo.l = j.mOriginalStatusCode;
        iPCTaskInfo.m = j.mDownloadedSize;
        iPCTaskInfo.n = j.mDownloadSpeed;
        iPCTaskInfo.o = j.mCreateTime;
        iPCTaskInfo.p = j.mLastModifiedTime;
        iPCTaskInfo.q = j.mDownloadDurationTime;
        iPCTaskInfo.r = j.mHasVipChannelSpeedup;
        iPCTaskInfo.s = j.mVipChannelStatus;
        iPCTaskInfo.t = j.mVipChannelStatusCode;
        iPCTaskInfo.u = j.mVipAcceleratedSpeed;
        iPCTaskInfo.v = j.mVipAcceleratedSize;
        return iPCTaskInfo;
    }

    public final void b(long j) throws RemoteException {
        n.a();
        n.b(j);
    }

    public final void c(long j) throws RemoteException {
        n.a();
        n.a(j);
    }

    public final void d(long j) throws RemoteException {
        n.a();
        n.a(j);
    }

    public final boolean e(long j) throws RemoteException {
        return com.xunlei.downloadprovider.download.c.a.a().a(j);
    }

    public final void f(long j) throws RemoteException {
        com.xunlei.downloadprovider.download.c.a.a().f(j);
    }

    public final boolean g(long j) throws RemoteException {
        n.a();
        TaskInfo f = n.f(j);
        if (f == null) {
            return 0;
        }
        return com.xunlei.downloadprovider.download.c.a.b(f);
    }

    public final void h(long j) throws RemoteException {
        n.a();
        TaskInfo f = n.f(j);
        if (f != null) {
            com.xunlei.downloadprovider.download.c.a.a().c(f);
        }
    }

    public final boolean i(long j) throws RemoteException {
        n.a();
        TaskInfo f = n.f(j);
        if (f == null) {
            return 0;
        }
        return com.xunlei.downloadprovider.download.c.a.a().d(f);
    }

    public final long j(long j) throws RemoteException {
        n.a();
        j = n.f(j);
        if (j == null) {
            return 0;
        }
        return k.i(j);
    }

    public final long k(long j) throws RemoteException {
        n.a();
        j = n.f(j);
        if (j == null) {
            return 0;
        }
        return k.j(j);
    }

    public final long[] a(long j, int i) throws RemoteException {
        n.a();
        return n.a(j, i);
    }

    public final void a(long j, int i, String str, long j2, int i2) {
        n.a();
        n.a(j, i, str, j2, i2);
    }
}
