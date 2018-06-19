package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import anet.channel.util.ErrorConstant;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.k;
import com.xunlei.download.proguard.c;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

final class ag extends Handler {
    ag(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        StringBuilder stringBuilder;
        int i = message.what;
        boolean z = true;
        if (i != 108) {
            switch (i) {
                case 100:
                    boolean z2 = message.arg1 == 1;
                    boolean a = TbsDownloader.b(true, false);
                    if (message.obj != null && (message.obj instanceof TbsDownloaderCallback)) {
                        String str = TbsDownloader.LOGTAG;
                        stringBuilder = new StringBuilder("needDownload-onNeedDownloadFinish needStartDownload=");
                        stringBuilder.append(a);
                        TbsLog.i(str, stringBuilder.toString());
                        if (!a || z2) {
                            ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(a, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                        }
                    }
                    if (TbsShareManager.isThirdPartyApp(TbsDownloader.c) && a) {
                        TbsDownloader.startDownload(TbsDownloader.c);
                    }
                    return;
                case 101:
                    break;
                case 102:
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                    int a2 = TbsShareManager.isThirdPartyApp(TbsDownloader.c) ? TbsShareManager.a(TbsDownloader.c, false) : aj.a().i(TbsDownloader.c);
                    String str2 = TbsDownloader.LOGTAG;
                    StringBuilder stringBuilder2 = new StringBuilder("[TbsDownloader.handleMessage] localTbsVersion=");
                    stringBuilder2.append(a2);
                    TbsLog.i(str2, stringBuilder2.toString());
                    TbsDownloader.g.a(a2);
                    TbsLogReport.a(TbsDownloader.c).b();
                    return;
                case 103:
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                    if (message.arg1 == 0) {
                        aj.a().a((Context) message.obj, true);
                        return;
                    } else {
                        aj.a().a((Context) message.obj, false);
                        return;
                    }
                case 104:
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                    TbsLogReport.a(TbsDownloader.c).c();
                    return;
                default:
                    return;
            }
        }
        FileLock fileLock = null;
        stringBuilder = new StringBuilder("tbs_download_lock_file");
        stringBuilder.append(TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
        stringBuilder.append(c.n);
        FileOutputStream b = k.b(TbsDownloader.c, false, stringBuilder.toString());
        if (b != null) {
            fileLock = k.a(TbsDownloader.c, b);
            if (fileLock == null) {
                TbsLog.i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(ErrorConstant.ERROR_NO_STRATEGY);
                TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                return;
            }
        } else if (k.a(TbsDownloader.c)) {
            TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(ErrorConstant.ERROR_REQUEST_CANCEL);
            TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
            return;
        }
        boolean z3 = message.arg1 == 1;
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(TbsDownloader.c);
        if (TbsDownloader.c(false, z3, 108 == message.what)) {
            if (z3 && aj.a().a(TbsDownloader.c, TbsDownloadConfig.getInstance(TbsDownloader.c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                QbSdk.k.onDownloadFinish(122);
                instance.setDownloadInterruptCode(-213);
                TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                k.a(fileLock, b);
            } else if (instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                TbsDownloadConfig.getInstance(TbsDownloader.c).setDownloadInterruptCode(-215);
                ad b2 = TbsDownloader.g;
                if (108 != message.what) {
                    z = false;
                }
                b2.b(z3, z);
                TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                k.a(fileLock, b);
            }
        }
        QbSdk.k.onDownloadFinish(110);
        TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
        k.a(fileLock, b);
    }
}
