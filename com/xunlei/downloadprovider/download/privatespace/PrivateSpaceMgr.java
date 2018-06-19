package com.xunlei.downloadprovider.download.privatespace;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.xllib.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class PrivateSpaceMgr {
    private static PrivateSpaceMgr d;
    public HashMap<Long, TaskInfo> a = new HashMap(8);
    public ArrayList<a> b;
    private LockState c = LockState.hide;
    private com.xunlei.downloadprovider.app.AppStatusChgObserver.a e = new ak(this);

    private enum LockState {
        hide,
        show
    }

    public interface a {
        void a();

        void a(long j);

        void a(long j, boolean z);

        void b();
    }

    public static class b implements a {
        public void a() {
        }

        public void a(long j) {
        }

        public void a(long j, boolean z) {
        }

        public void b() {
        }
    }

    public static PrivateSpaceMgr a() {
        if (d == null) {
            synchronized (PrivateSpaceMgr.class) {
                if (d == null) {
                    d = new PrivateSpaceMgr();
                }
            }
        }
        return d;
    }

    private PrivateSpaceMgr() {
        if (i()) {
            n.a();
            Object<z> g = n.g(300);
            if (!d.a(g)) {
                for (z zVar : g) {
                    if (zVar != null) {
                        b(zVar.c());
                    }
                }
            }
        }
        new StringBuilder("size ===").append(this.a.size());
        AppStatusChgObserver.b().a(this.e);
    }

    public static boolean b() {
        LoginHelper.a();
        return l.c() && v.a().b();
    }

    private void a(LockState lockState) {
        if (!(lockState == null || this.c == lockState)) {
            this.c = lockState;
        }
    }

    public final void c() {
        a(LockState.hide);
        g();
    }

    public final void a(Activity activity) {
        a();
        if (!b()) {
            return;
        }
        if (a().a.size() > 0 || !a().f() || activity == null) {
            a();
            if (v.a().d()) {
                ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_prispace_view_show"));
                a((Context) activity, null);
                return;
            } else if (f() != null) {
                d();
                return;
            } else {
                activity = HubbleEventBuilder.build("android_dl_center_action", "dl_center_act_click");
                activity.addString("clickid", "top_act_lockclose");
                ThunderReport.reportEvent(activity);
                c();
                return;
            }
        }
        XLToast.showToast(activity, activity.getString(R.string.has_empty_private_space_task));
        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_prispace_no_hide_toast"));
    }

    public final void a(boolean r9) {
        /* JADX: method processing error */
/*
Error: java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:410)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.fixIterableType(LoopRegionVisitor.java:308)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkIterableForEach(LoopRegionVisitor.java:249)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:68)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        if (r9 == 0) goto L_0x0020;
    L_0x0002:
        r9 = com.xunlei.downloadprovider.download.privatespace.v.a();
        r0 = com.xunlei.downloadprovider.download.privatespace.v.c();
        r1 = r9.b;
        r2 = 1;
        r0 = r1.putBoolean(r0, r2);
        r0.commit();
        r0 = new com.xunlei.downloadprovider.download.privatespace.x;
        r0.<init>(r9);
        com.xunlei.common.concurrent.XLThreadPool.execute(r0);
        r8.c();
        return;
    L_0x0020:
        r9 = com.xunlei.downloadprovider.download.privatespace.v.a();
        r0 = r9.b;
        r0 = r0.clear();
        r0.commit();
        r0 = new com.xunlei.downloadprovider.download.privatespace.z;
        r0.<init>(r9);
        com.xunlei.common.concurrent.XLThreadPool.execute(r0);
        r9 = r8.a;
        r9 = r9.values();
        r0 = new java.lang.StringBuilder;
        r1 = "clearAll-----------";
        r0.<init>(r1);
        r1 = r9.size();
        r0.append(r1);
        r0 = com.xunlei.xllib.b.d.a(r9);
        if (r0 != 0) goto L_0x0093;
    L_0x004f:
        r9 = r9.iterator();
    L_0x0053:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x0093;
    L_0x0059:
        r0 = r9.next();
        r0 = (com.xunlei.downloadprovider.download.engine.task.info.TaskInfo) r0;
        r1 = r0.getCustomFlags();
        r3 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        r3 = 100;
        r6 = 0;
        if (r5 == 0) goto L_0x007a;
    L_0x006d:
        r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1));
        if (r5 != 0) goto L_0x0072;
    L_0x0071:
        goto L_0x007a;
    L_0x0072:
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 != 0) goto L_0x0077;
    L_0x0076:
        goto L_0x007b;
    L_0x0077:
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        goto L_0x007b;
    L_0x007a:
        r3 = r6;
    L_0x007b:
        r0.setCustomFlags(r3);
        r1 = com.xunlei.downloadprovider.download.engine.task.n.a();
        r5 = r0.getTaskId();
        r1.b(r5, r3);
        r1 = r0.getTaskId();
        r0 = r0.mLocalFileName;
        r8.b(r1, r0);
        goto L_0x0053;
    L_0x0093:
        r9 = r8.a;
        r9.clear();
        r8.k();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr.a(boolean):void");
    }

    public final void e() {
        v.a().a(true);
        c();
    }

    public final boolean f() {
        return this.c == LockState.hide;
    }

    public final boolean a(TaskInfo taskInfo) {
        return (taskInfo == null || this.a.get(Long.valueOf(taskInfo.getTaskId())) == null) ? null : true;
    }

    public final boolean a(VideoPlayRecord videoPlayRecord) {
        if (!f() || videoPlayRecord == null) {
            return false;
        }
        if (TextUtils.isEmpty(videoPlayRecord.e)) {
            videoPlayRecord = videoPlayRecord.l;
        } else {
            videoPlayRecord = videoPlayRecord.e;
        }
        if (TextUtils.isEmpty(videoPlayRecord)) {
            return false;
        }
        String substring = (!videoPlayRecord.contains("/") || videoPlayRecord.endsWith("/")) ? videoPlayRecord : videoPlayRecord.substring(videoPlayRecord.lastIndexOf("/") + 1);
        if (!this.a.isEmpty()) {
            for (TaskInfo taskInfo : this.a.values()) {
                if ((!TextUtils.isEmpty(taskInfo.mLocalFileName) && videoPlayRecord.contains(taskInfo.mLocalFileName)) || videoPlayRecord.equals(taskInfo.getTaskDownloadUrl()) || taskInfo.mLocalFileName.endsWith(substring)) {
                    return true;
                }
                if (a(substring, taskInfo.mLocalFileName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void b(TaskInfo taskInfo) {
        if (taskInfo != null) {
            this.a.put(Long.valueOf(taskInfo.getTaskId()), taskInfo);
            if (taskInfo.getCustomFlags() != 300) {
                n.a().b(taskInfo.getTaskId(), 300);
            }
        }
    }

    public final void a(long j) {
        TaskInfo taskInfo = (TaskInfo) this.a.remove(Long.valueOf(j));
        if (taskInfo != null) {
            long customFlags = taskInfo.getCustomFlags();
            long j2 = 100;
            if (customFlags != 300) {
                if (customFlags != 0) {
                    if (customFlags != 100) {
                        j2 = 200;
                    }
                    n.a().b(j, j2);
                }
            }
            j2 = 0;
            n.a().b(j, j2);
        }
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
        if (this.b != null) {
            if (!d.a(this.b)) {
                this.b.remove(aVar);
            }
        }
    }

    public final void g() {
        if (this.b != null) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a();
            }
        }
    }

    public static void a(Context context, String str, f fVar) {
        if (context != null) {
            LoginHelper.a();
            if (l.c()) {
                c(context, str, fVar);
            } else {
                LoginHelper.a().a(context, new aj(context, str, fVar), LoginFrom.DLCENTER_DETAIL_PACKET, null);
            }
        }
    }

    private static void c(Context context, String str, f fVar) {
        if (!LoginHelper.a().l()) {
            a();
            j();
            new g(context).show();
        } else if (v.a().d()) {
            a(context, fVar);
        } else {
            k kVar = new k(context, str);
            kVar.a = fVar;
            kVar.show();
        }
    }

    private static void a(Context context, f fVar) {
        ao aoVar = new ao(context);
        aoVar.c = fVar;
        aoVar.show();
    }

    public static boolean h() {
        return v.a().d();
    }

    public final void a(long j, boolean z) {
        if (!d.a(this.b)) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(j, z);
            }
        }
    }

    public static boolean i() {
        v a = v.a();
        Map all = a.a.getAll();
        if (all == null || all.isEmpty()) {
            return false;
        }
        boolean z = false;
        for (String str : all.keySet()) {
            if (str.endsWith("open_private_space")) {
                z = a.a.getBoolean(str, false);
                if (z) {
                    return z;
                }
            }
        }
        return z;
    }

    private void k() {
        if (!d.a(this.b)) {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                aVar.b();
                aVar.a();
            }
        }
    }

    public final void a(long j, @NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            XLThreadPool.execute(new al(this, str, j));
        }
    }

    public final void b(long j, @NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            XLThreadPool.execute(new am(this, str, j));
        }
    }

    public static void a(Activity activity, String str) {
        a();
        if (b()) {
            str = HubbleEventBuilder.build("android_dl_center_action", "dl_center_act_click");
            str.addString("clickid", "top_act_prispace_close");
            ThunderReport.reportEvent(str);
            an.b("close");
            new a(activity).show();
            return;
        }
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_act_click");
        build.addString("clickid", "top_act_prispace_open");
        ThunderReport.reportEvent(build);
        a((Context) activity, str, null);
    }

    private static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                File file = new File(str2);
                if (!(file.exists() == null || file.isDirectory() == null)) {
                    str2 = file.listFiles();
                    if (str2 != null && str2.length > 0) {
                        for (File file2 : str2) {
                            if (file2 != null) {
                                if (TextUtils.equals(str, file2.getName())) {
                                    new StringBuilder("match sub file=").append(file2.getPath());
                                    return true;
                                } else if (file2.isDirectory() && a(str, file2.getPath())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }
        }
        return false;
    }

    public final void d() {
        StatEvent build = HubbleEventBuilder.build("android_dl_center_action", "dl_center_act_click");
        build.addString("clickid", "top_act_lockopen");
        ThunderReport.reportEvent(build);
        a(LockState.show);
        g();
    }

    public static void j() {
        boolean z;
        if (!LoginHelper.a().g.g()) {
            int f = LoginHelper.a().g.f();
            StringBuilder stringBuilder = new StringBuilder("memberType====");
            stringBuilder.append(f);
            stringBuilder.append(" ,isVip===");
            stringBuilder.append(LoginHelper.a().l());
            if (f > 0 && !LoginHelper.a().l()) {
                z = true;
                if (z) {
                    a().a(false);
                }
            }
        }
        z = false;
        if (z) {
            a().a(false);
        }
    }

    static /* synthetic */ void a(PrivateSpaceMgr privateSpaceMgr, String str, String str2) {
        PrivateSpaceMgr<TaskInfo> values = privateSpaceMgr.a.values();
        if (!d.a(values)) {
            for (TaskInfo taskInfo : values) {
                if (taskInfo != null && TextUtils.equals(taskInfo.mLocalFileName, str)) {
                    StringBuilder stringBuilder = new StringBuilder("[resetFilePath] id=");
                    stringBuilder.append(taskInfo.getTaskId());
                    stringBuilder.append(" ,mLocalFileName=");
                    stringBuilder.append(taskInfo.mLocalFileName);
                    stringBuilder.append(" ,targetFilePath=");
                    stringBuilder.append(str2);
                    taskInfo.mLocalFileName = str2;
                }
            }
        }
    }

    static /* synthetic */ void a(File file, File file2) {
        if (file2.isFile()) {
            v.a().a(file.getPath(), file2.getPath());
            return;
        }
        file2 = file2.listFiles();
        if (file2 != null && file2.length > 0) {
            for (File file3 : file2) {
                if (file3 != null) {
                    Object trim = file3.getName().trim();
                    if (!TextUtils.isEmpty(trim)) {
                        String path = file3.getPath();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(file.getPath());
                        stringBuilder.append("/");
                        stringBuilder.append(trim);
                        String stringBuilder2 = stringBuilder.toString();
                        stringBuilder = new StringBuilder("newPlayUrl=");
                        stringBuilder.append(path);
                        stringBuilder.append(" ,oldPlayUrl=");
                        stringBuilder.append(stringBuilder2);
                        v.a().a(stringBuilder2, path);
                    }
                }
            }
        }
    }
}
