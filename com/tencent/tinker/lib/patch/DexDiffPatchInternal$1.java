package com.tencent.tinker.lib.patch;

import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import java.io.File;
import java.util.List;

/* compiled from: BUGLY */
final class DexDiffPatchInternal$1 implements ResultCallback {
    long startTime;
    final /* synthetic */ List val$failOptDexFile;
    final /* synthetic */ Throwable[] val$throwable;

    DexDiffPatchInternal$1(List list, Throwable[] thArr) {
        this.val$failOptDexFile = list;
        this.val$throwable = thArr;
    }

    public final void onStart(File file, File file2) {
        this.startTime = System.currentTimeMillis();
        TinkerLog.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", new Object[]{file.getPath(), Long.valueOf(file.length())});
    }

    public final void onSuccess(File file, File file2, File file3) {
        TinkerLog.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", new Object[]{file.getPath(), file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - this.startTime)});
    }

    public final void onFailed(File file, File file2, Throwable th) {
        TinkerLog.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", new Object[]{file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime)});
        this.val$failOptDexFile.add(file);
        this.val$throwable[0] = th;
    }
}
