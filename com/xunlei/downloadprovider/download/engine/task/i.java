package com.xunlei.downloadprovider.download.engine.task;

import android.app.Service;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.Toast;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.download.proguard.c;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.assistant.clipboardmonitor.j;
import com.xunlei.downloadprovider.download.engine.task.a.l;
import com.xunlei.downloadprovider.download.engine.task.a.p;
import com.xunlei.downloadprovider.download.engine.task.a.v;
import com.xunlei.downloadprovider.download.engine.task.a.w;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskExtraInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/* compiled from: DownloadEngine */
public class i extends l {
    private static final String n = "i";
    @Nullable
    Handler a;
    public p b;
    private long o;
    private long p;
    private Runnable q;

    /* compiled from: DownloadEngine */
    private class a implements Runnable {
        final /* synthetic */ i a;
        private int b;

        private a(i iVar) {
            this.a = iVar;
        }

        public final void run() {
            try {
                this.b++;
                if (this.b % 6 == 0) {
                    this.b = 0;
                    h.a();
                    h.c();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            j.a().b();
            i.g(this.a);
            if (this.a.q != null) {
                this.a.g.removeCallbacks(this.a.q);
                this.a.g.postDelayed(this, c.x);
            }
        }
    }

    /* compiled from: DownloadEngine */
    private class b extends com.xunlei.downloadprovider.download.engine.task.a.l.a {
        final /* synthetic */ i a;

        public b(i iVar) {
            this.a = iVar;
            super(iVar);
        }

        public final void a(Message message) {
            int i = message.what;
            if (i != 123) {
                switch (i) {
                    case Opcodes.FLOAT_TO_DOUBLE /*137*/:
                        this.a.a((m) message.obj);
                        return;
                    case Opcodes.DOUBLE_TO_INT /*138*/:
                        i.a(this.a, (w) message.obj);
                        return;
                    case Opcodes.DOUBLE_TO_LONG /*139*/:
                        i.b(this.a);
                        return;
                    default:
                        switch (i) {
                            case 1000:
                                i.a(this.a, (Handler) message.obj, message.arg1);
                                return;
                            case 1001:
                                i.a(this.a);
                                return;
                            default:
                                break;
                        }
                }
            }
            this.a.i();
        }
    }

    i(Service service) {
        super(service);
        this.o = 0;
        this.p = 0;
        this.b = new p(this.c);
        this.k = new j(this);
        this.i = new b(this);
        this.i.start();
        service = n.a();
        service.d = this.c;
        service.d.f.registerObserver(service.b);
        if (service.e != null && service.d != null) {
            service.a(service.e);
        }
    }

    protected final void a(List<TaskInfo> list) {
        if (list == null) {
            list = new ArrayList();
            list.addAll(g().h());
        }
        if (!list.isEmpty()) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (((TaskInfo) listIterator.next()).isTaskInvisible()) {
                    listIterator.remove();
                }
            }
        }
        if (this.a != null) {
            int size = list.size();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.o >= 3800 || size == 0) {
                this.a.obtainMessage(10000, 0, 0, list).sendToTarget();
                this.o = currentTimeMillis;
            }
        }
        g.a().a(this.c.g(100));
    }

    protected final void a(int i, TaskInfo taskInfo, int i2) {
        List list = this.b.b;
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (taskInfo.isTaskInvisible()) {
                if (g.a(taskInfo)) {
                    g a = g.a();
                    boolean contains = a.b.contains(Long.valueOf(taskInfo.getTaskId()));
                    if (taskInfo.getTaskStatus() == 8) {
                        if (!(i2 == 8 || i2 == 17 || i2 == -1 || contains)) {
                            a.b(taskInfo);
                        }
                    } else if (!(contains || taskInfo.getTaskStatus() == 17)) {
                        a.b(taskInfo);
                    }
                    if (taskInfo.getTaskStatus() == 8) {
                        a.c(taskInfo);
                    }
                }
                if (a.a().a(taskInfo)) {
                    a.a();
                    a.a(taskInfo, i2);
                }
            } else {
                Handler handler = (Handler) list.get(i3);
                handler.obtainMessage(108, i2, i, taskInfo).sendToTarget();
                Message obtainMessage = handler.obtainMessage(108, i2, i, taskInfo);
                Bundle bundle = new Bundle(1);
                bundle.putBoolean("hasBeforeState", true);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
                if (i == 8) {
                    h.a();
                    h.a(taskInfo);
                }
                a(null);
            }
        }
        if (taskInfo.isTaskInvisible() == 0) {
            this.b.c();
        }
    }

    final void a() {
        if (this.g != null) {
            this.g.sendEmptyMessage(123);
        }
    }

    public final void a(Handler handler) {
        if (this.g != null) {
            this.g.obtainMessage(1000, 122, 0, handler).sendToTarget();
        }
        this.c.b();
        com.xunlei.downloadprovider.download.c.a.a();
        com.xunlei.downloadprovider.download.c.a.f();
    }

    public final void b() {
        if (this.g != null) {
            this.g.obtainMessage(1001).sendToTarget();
            this.h.quit();
        }
        com.xunlei.downloadprovider.download.engine.task.a.c cVar = this.c;
        cVar.c.a();
        v vVar = cVar.a;
        a aVar = vVar.a;
        aVar.a = 0;
        aVar.b = 0;
        vVar.c = 0;
        synchronized (cVar.r) {
            for (TaskInfo taskInfo : cVar.r) {
                if (taskInfo != null && taskInfo.getTaskStatus() == 2) {
                    taskInfo.syncExtraInfo();
                    cVar.h.a(taskInfo.mExtraInfo);
                }
            }
        }
    }

    final boolean a(m mVar, long j) {
        new StringBuilder("commitDownloadTask  ").append(mVar);
        this.b.b();
        this.g.sendMessageDelayed(this.g.obtainMessage(Opcodes.FLOAT_TO_DOUBLE, mVar), j);
        return true;
    }

    public final boolean a(Uri uri, long[] jArr, String str, String str2, String str3, DownloadAdditionInfo downloadAdditionInfo) {
        this.b.b();
        return b(uri, jArr, str, str2, str3, downloadAdditionInfo) != -1 ? true : null;
    }

    public final void a(long j, long[] jArr) {
        StringBuilder stringBuilder = new StringBuilder("addBtSubTask  ");
        stringBuilder.append(j);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(Arrays.toString(jArr));
        this.b.b();
        b(j, jArr);
    }

    final boolean a(w wVar) {
        if (wVar != null) {
            if (this.g != null) {
                this.g.obtainMessage(Opcodes.DOUBLE_TO_INT, wVar).sendToTarget();
                return true;
            }
        }
        return null;
    }

    final boolean c() {
        if (this.g == null) {
            return false;
        }
        this.g.obtainMessage(Opcodes.DOUBLE_TO_LONG).sendToTarget();
        return true;
    }

    final void d() {
        this.c.j = true;
    }

    final TaskSpeedCountInfo a(long j) {
        TaskSpeedCountInfo a = this.c.a.a(j);
        if (a != null) {
            return a;
        }
        TaskExtraInfo a2 = com.xunlei.downloadprovider.download.engine.task.a.a.a.a().a(j);
        if (a2 == null) {
            return a;
        }
        a = new TaskSpeedCountInfo();
        a.mTaskId = j;
        a.mHighestSpeed = a2.mMaxDownloadSpeed;
        return a;
    }

    final void e() {
        com.xunlei.downloadprovider.download.engine.task.a.c cVar = this.c;
        if (!cVar.c.b()) {
            cVar.b();
        }
    }

    static /* synthetic */ void a(i iVar, Message message) {
        TaskInfo taskInfo = (TaskInfo) message.obj;
        g a;
        if (100 == message.what) {
            com.xunlei.downloadprovider.download.engine.task.a.c cVar = iVar.c;
            long taskId = taskInfo.getTaskId();
            if (cVar.h(taskId) == null) {
                cVar.a(new com.xunlei.downloadprovider.download.engine.task.a.a(taskId, taskInfo));
            }
            iVar.c.a(taskInfo);
            if (g.a(taskInfo)) {
                a = g.a();
                a.b(taskInfo.getTaskId());
                Context applicationInstance = BrothersApplication.getApplicationInstance();
                StringBuilder stringBuilder = new StringBuilder("开始下载");
                stringBuilder.append(taskInfo.mTitle);
                Toast.makeText(applicationInstance, stringBuilder.toString(), 1).show();
                a.b(taskInfo);
            }
            if (a.a().a(taskInfo)) {
                a.a();
                a.b();
            }
            if (taskInfo.getTaskStatus() == 0 || 2 == taskInfo.getTaskStatus() || 8 == taskInfo.getTaskStatus()) {
                iVar.c.a(taskInfo, taskInfo.getTaskStatus(), -1);
            }
        } else if (101 == message.what) {
            if (g.a(taskInfo)) {
                a = g.a();
                int i = message.arg1;
                if (taskInfo.getTaskStatus() != 8) {
                    if (!(taskInfo.getTaskStatus() == 4 || taskInfo.getTaskStatus() == 16)) {
                        if (taskInfo.getTaskStatus() != 2) {
                            if (i == -2) {
                                Toast.makeText(BrothersApplication.getApplicationInstance(), "正在努力下载，请耐心等待", 1).show();
                            }
                        }
                    }
                    a.b(taskInfo.getTaskId());
                    n.a();
                    n.b(false, new long[]{taskInfo.getTaskId()});
                    Toast.makeText(BrothersApplication.getApplicationInstance(), "正在努力下载，请耐心等待", 1).show();
                } else if (e.c(taskInfo.mLocalFileName)) {
                    g.a(BrothersApplication.getApplicationInstance(), taskInfo);
                } else {
                    a.b(taskInfo.getTaskId());
                    n.a();
                    n.a(false, new long[]{taskInfo.getTaskId()});
                    Context applicationInstance2 = BrothersApplication.getApplicationInstance();
                    StringBuilder stringBuilder2 = new StringBuilder("开始下载");
                    stringBuilder2.append(taskInfo.mTitle);
                    Toast.makeText(applicationInstance2, stringBuilder2.toString(), 1).show();
                }
            }
            if (a.a().a(taskInfo)) {
                a.a();
                int i2 = message.arg1;
                a.b(taskInfo);
            }
        }
        if (!taskInfo.isTaskInvisible()) {
            iVar.b.a(message, taskInfo);
        }
    }

    static /* synthetic */ void a(i iVar, Handler handler, int i) {
        iVar.c.c();
        if (iVar.q == null) {
            iVar.q = new a();
            if (iVar.g != null) {
                iVar.g.post(iVar.q);
            }
        }
        iVar.b(false);
        iVar.j.obtainMessage(122).sendToTarget();
        handler.obtainMessage(i).sendToTarget();
    }

    static /* synthetic */ void a(i iVar) {
        if (!(iVar.g == null || iVar.q == null)) {
            iVar.g.removeCallbacks(iVar.q);
        }
        iVar.q = null;
    }

    static /* synthetic */ void a(i iVar, w wVar) {
        if (wVar != null) {
            switch (wVar.a) {
                case 1:
                    iVar.a(wVar.b, (boolean) wVar.e);
                    return;
                case 2:
                    iVar.a((boolean) wVar.e);
                    return;
                case 3:
                    iVar.b(wVar.b, (boolean) wVar.e);
                    return;
                case 4:
                    iVar.c(wVar.b, wVar.f);
                    return;
                case 5:
                    iVar.a(wVar.c, (boolean) wVar.f);
                    return;
                case 6:
                    iVar.d(wVar.b, wVar.d);
                    return;
                case 7:
                    iVar.a(wVar.g, (boolean) wVar.d);
                    break;
                default:
                    break;
            }
        }
    }

    static /* synthetic */ void b(i iVar) {
        for (com.xunlei.downloadprovider.download.engine.task.a.a aVar : iVar.c.k.values()) {
            aVar.c.mShouldAutoSpeedup = false;
        }
    }

    static /* synthetic */ void g(i iVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - iVar.p >= 1200000) {
            iVar.p = currentTimeMillis;
            LoginHelper.a();
            if (com.xunlei.downloadprovider.member.login.b.l.b() != null) {
                n.a().a(LoginHelper.a());
            }
        }
    }
}
