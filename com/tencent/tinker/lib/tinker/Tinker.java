package com.tencent.tinker.lib.tinker;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.listener.PatchListener;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.util.TinkerLog;
import com.tencent.tinker.lib.util.TinkerServiceInternals;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* compiled from: BUGLY */
public class Tinker {
    private static final String TAG = "Tinker.Tinker";
    private static boolean sInstalled = false;
    private static Tinker sInstance;
    final Context context;
    final boolean isMainProcess;
    final boolean isPatchProcess;
    final PatchListener listener;
    final LoadReporter loadReporter;
    private boolean loaded;
    final File patchDirectory;
    final File patchInfoFile;
    final File patchInfoLockFile;
    final PatchReporter patchReporter;
    int tinkerFlags;
    TinkerLoadResult tinkerLoadResult;
    final boolean tinkerLoadVerifyFlag;

    /* compiled from: BUGLY */
    public static class Builder {
        private final Context context;
        private PatchListener listener;
        private LoadReporter loadReporter;
        private final boolean mainProcess;
        private File patchDirectory;
        private File patchInfoFile;
        private File patchInfoLockFile;
        private final boolean patchProcess;
        private PatchReporter patchReporter;
        private int status = -1;
        private Boolean tinkerLoadVerifyFlag;

        public Builder(Context context) {
            if (context == null) {
                throw new TinkerRuntimeException("Context must not be null.");
            }
            this.context = context;
            this.mainProcess = ShareTinkerInternals.isInMainProcess(context);
            this.patchProcess = TinkerServiceInternals.isInTinkerPatchServiceProcess(context);
            this.patchDirectory = SharePatchFileUtil.getPatchDirectory(context);
            if (this.patchDirectory == null) {
                TinkerLog.e(Tinker.TAG, "patchDirectory is null!", new Object[0]);
                return;
            }
            this.patchInfoFile = SharePatchFileUtil.getPatchInfoFile(this.patchDirectory.getAbsolutePath());
            this.patchInfoLockFile = SharePatchFileUtil.getPatchInfoLockFile(this.patchDirectory.getAbsolutePath());
            TinkerLog.w(Tinker.TAG, "tinker patch directory: %s", this.patchDirectory);
        }

        public Builder tinkerFlags(int i) {
            if (this.status != -1) {
                throw new TinkerRuntimeException("tinkerFlag is already set.");
            }
            this.status = i;
            return this;
        }

        public Builder tinkerLoadVerifyFlag(Boolean bool) {
            if (bool == null) {
                throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
            } else if (this.tinkerLoadVerifyFlag != null) {
                throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
            } else {
                this.tinkerLoadVerifyFlag = bool;
                return this;
            }
        }

        public Builder loadReport(LoadReporter loadReporter) {
            if (loadReporter == null) {
                throw new TinkerRuntimeException("loadReporter must not be null.");
            } else if (this.loadReporter != null) {
                throw new TinkerRuntimeException("loadReporter is already set.");
            } else {
                this.loadReporter = loadReporter;
                return this;
            }
        }

        public Builder patchReporter(PatchReporter patchReporter) {
            if (patchReporter == null) {
                throw new TinkerRuntimeException("patchReporter must not be null.");
            } else if (this.patchReporter != null) {
                throw new TinkerRuntimeException("patchReporter is already set.");
            } else {
                this.patchReporter = patchReporter;
                return this;
            }
        }

        public Builder listener(PatchListener patchListener) {
            if (patchListener == null) {
                throw new TinkerRuntimeException("listener must not be null.");
            } else if (this.listener != null) {
                throw new TinkerRuntimeException("listener is already set.");
            } else {
                this.listener = patchListener;
                return this;
            }
        }

        public Tinker build() {
            if (this.status == -1) {
                this.status = 7;
            }
            if (this.loadReporter == null) {
                this.loadReporter = new DefaultLoadReporter(this.context);
            }
            if (this.patchReporter == null) {
                this.patchReporter = new DefaultPatchReporter(this.context);
            }
            if (this.listener == null) {
                this.listener = new DefaultPatchListener(this.context);
            }
            if (this.tinkerLoadVerifyFlag == null) {
                this.tinkerLoadVerifyFlag = Boolean.valueOf(false);
            }
            return new Tinker(this.context, this.status, this.loadReporter, this.patchReporter, this.listener, this.patchDirectory, this.patchInfoFile, this.patchInfoLockFile, this.mainProcess, this.patchProcess, this.tinkerLoadVerifyFlag.booleanValue());
        }
    }

    private Tinker(Context context, int i, LoadReporter loadReporter, PatchReporter patchReporter, PatchListener patchListener, File file, File file2, File file3, boolean z, boolean z2, boolean z3) {
        this.loaded = false;
        this.context = context;
        this.listener = patchListener;
        this.loadReporter = loadReporter;
        this.patchReporter = patchReporter;
        this.tinkerFlags = i;
        this.patchDirectory = file;
        this.patchInfoFile = file2;
        this.patchInfoLockFile = file3;
        this.isMainProcess = z;
        this.tinkerLoadVerifyFlag = z3;
        this.isPatchProcess = z2;
    }

    public static Tinker with(Context context) {
        if (sInstalled) {
            if (sInstance == null) {
                synchronized (Tinker.class) {
                    if (sInstance == null) {
                        sInstance = new Builder(context).build();
                    }
                }
            }
            return sInstance;
        }
        throw new TinkerRuntimeException("you must install tinker before get tinker sInstance");
    }

    public static void create(Tinker tinker) {
        if (sInstance != null) {
            throw new TinkerRuntimeException("Tinker instance is already set.");
        }
        sInstance = tinker;
    }

    public static boolean isTinkerInstalled() {
        return sInstalled;
    }

    public void install(Intent intent, Class<? extends AbstractResultService> cls, AbstractPatch abstractPatch) {
        sInstalled = true;
        TinkerPatchService.setPatchProcessor(abstractPatch, cls);
        TinkerLog.i(TAG, "try to install tinker, isEnable: %b, version: %s", Boolean.valueOf(isTinkerEnabled()), "1.9.1");
        if (isTinkerEnabled() == null) {
            TinkerLog.e(TAG, "tinker is disabled", new Object[0]);
        } else if (intent == null) {
            throw new TinkerRuntimeException("intentResult must not be null.");
        } else {
            this.tinkerLoadResult = new TinkerLoadResult();
            this.tinkerLoadResult.parseTinkerResult(getContext(), intent);
            this.loadReporter.onLoadResult(this.patchDirectory, this.tinkerLoadResult.loadCode, this.tinkerLoadResult.costTime);
            if (this.loaded == null) {
                TinkerLog.w(TAG, "tinker load fail!", new Object[0]);
            }
        }
    }

    public void setPatchServiceNotificationId(int i) {
        TinkerPatchService.setTinkerNotificationId(i);
    }

    public TinkerLoadResult getTinkerLoadResultIfPresent() {
        return this.tinkerLoadResult;
    }

    public void install(Intent intent) {
        install(intent, DefaultTinkerResultService.class, new UpgradePatch());
    }

    public Context getContext() {
        return this.context;
    }

    public boolean isMainProcess() {
        return this.isMainProcess;
    }

    public boolean isPatchProcess() {
        return this.isPatchProcess;
    }

    public void setTinkerDisable() {
        this.tinkerFlags = 0;
    }

    public LoadReporter getLoadReporter() {
        return this.loadReporter;
    }

    public PatchReporter getPatchReporter() {
        return this.patchReporter;
    }

    public boolean isTinkerEnabled() {
        return ShareTinkerInternals.isTinkerEnabled(this.tinkerFlags);
    }

    public boolean isTinkerLoaded() {
        return this.loaded;
    }

    public void setTinkerLoaded(boolean z) {
        this.loaded = z;
    }

    public boolean isTinkerLoadVerify() {
        return this.tinkerLoadVerifyFlag;
    }

    public boolean isEnabledForDex() {
        return ShareTinkerInternals.isTinkerEnabledForDex(this.tinkerFlags);
    }

    public boolean isEnabledForNativeLib() {
        return ShareTinkerInternals.isTinkerEnabledForNativeLib(this.tinkerFlags);
    }

    public boolean isEnabledForResource() {
        return ShareTinkerInternals.isTinkerEnabledForResource(this.tinkerFlags);
    }

    public File getPatchDirectory() {
        return this.patchDirectory;
    }

    public File getPatchInfoFile() {
        return this.patchInfoFile;
    }

    public File getPatchInfoLockFile() {
        return this.patchInfoLockFile;
    }

    public PatchListener getPatchListener() {
        return this.listener;
    }

    public int getTinkerFlags() {
        return this.tinkerFlags;
    }

    public void cleanPatch() {
        if (this.patchDirectory != null) {
            if (isTinkerLoaded()) {
                TinkerLog.e(TAG, "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
            }
            SharePatchFileUtil.deleteDir(this.patchDirectory);
        }
    }

    public void rollbackPatch() {
        if (isTinkerLoaded()) {
            ShareTinkerInternals.killAllOtherProcess(this.context);
            cleanPatch();
            Process.killProcess(Process.myPid());
            return;
        }
        TinkerLog.w(TAG, "rollbackPatch: tinker is not loaded, just return", new Object[0]);
    }

    public void cleanPatchByVersion(String str) {
        if (this.patchDirectory != null) {
            if (str != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.patchDirectory.getAbsolutePath());
                stringBuilder.append("/");
                stringBuilder.append(str);
                SharePatchFileUtil.deleteDir(stringBuilder.toString());
            }
        }
    }

    public long getTinkerRomSpace() {
        if (this.patchDirectory == null) {
            return 0;
        }
        return SharePatchFileUtil.getFileOrDirectorySize(this.patchDirectory) / 1024;
    }

    public void cleanPatchByVersion(File file) {
        if (!(this.patchDirectory == null || file == null)) {
            if (file.exists()) {
                cleanPatchByVersion(SharePatchFileUtil.getPatchVersionDirectory(SharePatchFileUtil.getMD5(file)));
            }
        }
    }
}
