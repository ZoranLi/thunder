package com.tencent.tinker.lib.tinker;

import android.content.Context;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.tinker.Tinker.Builder;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.TinkerLog.TinkerLogImp;
import com.tencent.tinker.loader.app.ApplicationLike;

/* compiled from: BUGLY */
public class TinkerInstaller {
    private static final String TAG = "Tinker.TinkerInstaller";

    public static Tinker install(ApplicationLike applicationLike) {
        Tinker build = new Builder(applicationLike.getApplication()).build();
        Tinker.create(build);
        build.install(applicationLike.getTinkerResultIntent());
        return build;
    }

    public static Tinker install(ApplicationLike applicationLike, LoadReporter loadReporter, PatchReporter patchReporter, PatchListener patchListener, Class<? extends AbstractResultService> cls, AbstractPatch abstractPatch) {
        loadReporter = new Builder(applicationLike.getApplication()).tinkerFlags(applicationLike.getTinkerFlags()).loadReport(loadReporter).listener(patchListener).patchReporter(patchReporter).tinkerLoadVerifyFlag(Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag())).build();
        Tinker.create(loadReporter);
        loadReporter.install(applicationLike.getTinkerResultIntent(), cls, abstractPatch);
        return loadReporter;
    }

    public static void cleanPatch(Context context) {
        Tinker.with(context).cleanPatch();
    }

    public static void onReceiveUpgradePatch(Context context, String str) {
        Tinker.with(context).getPatchListener().onPatchReceived(str);
    }

    public static void setLogIml(TinkerLogImp tinkerLogImp) {
        TinkerLog.setTinkerLogImp(tinkerLogImp);
    }
}
