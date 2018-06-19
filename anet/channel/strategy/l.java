package anet.channel.strategy;

import android.content.Context;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.ALog;
import anet.channel.util.f;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Comparator;

/* compiled from: Taobao */
class l {
    private static File a = null;
    private static volatile boolean b = false;
    private static FileFilter c = new m();
    private static Comparator<File> d = new n();

    l() {
    }

    public static void a(Context context) {
        if (context != null) {
            try {
                File file = new File(context.getExternalFilesDir(null), "awcn_strategy");
                a = file;
                if (!a(file)) {
                    file = new File(context.getFilesDir(), "awcn_strategy");
                    a = file;
                    if (a(file) == null) {
                        ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, SharePatchInfo.OAT_DIR, a.getAbsolutePath());
                    }
                }
                if (GlobalAppRuntimeInfo.isTargetProcess() == null) {
                    context = GlobalAppRuntimeInfo.getCurrentProcess();
                    file = new File(a, context.substring(context.indexOf(58) + 1));
                    a = file;
                    if (a(file) == null) {
                        ALog.e("awcn.StrategySerializeHelper", "create directory failed!!!", null, SharePatchInfo.OAT_DIR, a.getAbsolutePath());
                    }
                }
                ALog.i("awcn.StrategySerializeHelper", "StrateyFolder", null, "path", a.getAbsolutePath());
                if (b != null) {
                    a();
                    b = false;
                    return;
                }
                c();
            } catch (Context context2) {
                ALog.e("awcn.StrategySerializeHelper", "StrategySerializeHelper initialize failed!!!", null, context2, new Object[0]);
            }
        }
    }

    private static boolean a(File file) {
        return (file == null || file.exists()) ? true : file.mkdir();
    }

    public static File a(String str) {
        a(a);
        return new File(a, str);
    }

    static synchronized void a() {
        synchronized (l.class) {
            ALog.i("awcn.StrategySerializeHelper", "clear start.", null, new Object[0]);
            if (a == null) {
                ALog.w("awcn.StrategySerializeHelper", "folder path not initialized, wait to clear", null, new Object[0]);
                b = true;
                return;
            }
            File[] listFiles = a.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file : listFiles) {
                if (file.isFile()) {
                    file.delete();
                }
            }
            ALog.i("awcn.StrategySerializeHelper", "clear end.", null, new Object[0]);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized java.io.File[] b() {
        /*
        r0 = anet.channel.strategy.l.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x001b }
        if (r1 != 0) goto L_0x000a;
    L_0x0007:
        r1 = 0;
        monitor-exit(r0);
        return r1;
    L_0x000a:
        r1 = a;	 Catch:{ all -> 0x001b }
        r2 = c;	 Catch:{ all -> 0x001b }
        r1 = r1.listFiles(r2);	 Catch:{ all -> 0x001b }
        if (r1 == 0) goto L_0x0019;
    L_0x0014:
        r2 = d;	 Catch:{ all -> 0x001b }
        java.util.Arrays.sort(r1, r2);	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r0);
        return r1;
    L_0x001b:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.l.b():java.io.File[]");
    }

    static synchronized void c() {
        synchronized (l.class) {
            File[] b = b();
            if (b == null) {
                return;
            }
            int i = 0;
            int i2 = 0;
            while (i < b.length) {
                File file = b[i];
                if (System.currentTimeMillis() - file.lastModified() >= 604800000) {
                    file.delete();
                } else if (!file.getName().equalsIgnoreCase("config")) {
                    int i3 = i2 + 1;
                    if (((long) i2) > 10) {
                        file.delete();
                    }
                    i2 = i3;
                }
                i++;
            }
        }
    }

    static synchronized void a(Serializable serializable, String str) {
        synchronized (l.class) {
            f.a(serializable, a(str));
        }
    }

    static synchronized <T> T b(String str) {
        synchronized (l.class) {
            str = f.a(a(str));
        }
        return str;
    }
}
