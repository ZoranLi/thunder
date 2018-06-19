package com.xunlei.downloadprovider.download.tasklist.list.banner.b;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.list.banner.p;
import com.xunlei.downloadprovider.download.tasklist.list.banner.q;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.DownloadError.FailureCode;

/* compiled from: DownloadExceptionBannerPresenter */
public final class f implements p {
    private q a = null;
    private g b = null;

    public final a a(long j) {
        return null;
    }

    public final void a() {
    }

    public final void a(Context context) {
    }

    public final void a(RedPacketConditionsInfo redPacketConditionsInfo, DownloadTaskInfo downloadTaskInfo) {
    }

    public f(q qVar) {
        this.a = qVar;
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        boolean z;
        Context applicationInstance;
        String str;
        FailureCode a;
        Object obj;
        g gVar;
        d a2;
        long taskId;
        PreferenceHelper preferenceHelper;
        d.a();
        boolean a3 = d.a(downloadTaskInfo);
        d a4 = d.a();
        boolean z2 = false;
        if (!BannerManager.a().a(BannerManager$BannerType.TYPE_EXCEPTION, downloadTaskInfo.getTaskId())) {
            if (!a4.b(downloadTaskInfo)) {
                z = true;
                if (!!z && d.a().d.h()) {
                    if (this.b == null) {
                        d.a();
                        applicationInstance = BrothersApplication.getApplicationInstance();
                        if (TextUtils.isEmpty(downloadTaskInfo.mSearchName)) {
                            str = downloadTaskInfo.mSearchName;
                        } else {
                            str = com.xunlei.downloadprovider.download.util.a.a(com.xunlei.downloadprovider.download.util.a.a(downloadTaskInfo, applicationInstance));
                        }
                        CharSequence replaceAll = str.replaceAll("[^\\u4e00-\\u9fa5]", "");
                        a = DownloadError.a((TaskInfo) downloadTaskInfo);
                        obj = "";
                        if (a != null) {
                            switch (e.a[a.ordinal()]) {
                                case 1:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_connection_interruption));
                                    break;
                                case 2:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_link_failure));
                                    break;
                                case 3:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_link_failure));
                                    break;
                                case 4:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_link_failure));
                                    break;
                                case 5:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_link_failure));
                                    break;
                                case 6:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_magnet_link_parse_failure));
                                    break;
                                case 7:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_path_connot_be_written));
                                    break;
                                case 8:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_path_connot_be_written));
                                    break;
                                case 9:
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                    break;
                                default:
                                    obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_other_failure));
                                    break;
                            }
                        }
                        if (!TextUtils.isEmpty(obj) || TextUtils.isEmpty(replaceAll)) {
                            gVar = null;
                        } else {
                            gVar = new g();
                            gVar.a = str;
                            gVar.b = obj;
                        }
                        this.b = gVar;
                    }
                    if (!(this.b == null || TextUtils.isEmpty(this.b.a) || TextUtils.isEmpty(this.b.b))) {
                        this.a.a(downloadTaskInfo, this.b, a3);
                        d.a();
                        d.a(true, downloadTaskInfo.getTaskId(), this);
                        a2 = d.a();
                        if (a2.b == null) {
                            a2.b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "sp_exception_show");
                        }
                        if (downloadTaskInfo != null) {
                            StringBuilder stringBuilder;
                            taskId = downloadTaskInfo.getTaskId();
                            preferenceHelper = a2.b;
                            stringBuilder = new StringBuilder("taskId");
                            stringBuilder.append(downloadTaskInfo.getTaskId());
                            if (taskId == preferenceHelper.getLong(stringBuilder.toString(), -1)) {
                                z2 = true;
                            }
                        }
                        if (!z2) {
                            com.xunlei.downloadprovider.download.report.a.b("dl_fail");
                            a2 = d.a();
                            if (a2.b == null) {
                                a2.b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "sp_exception_show");
                            }
                            if (!(a2.b == null || downloadTaskInfo == null)) {
                                preferenceHelper = a2.b;
                                StringBuilder stringBuilder2 = new StringBuilder("taskId");
                                stringBuilder2.append(downloadTaskInfo.getTaskId());
                                preferenceHelper.putLong(stringBuilder2.toString(), downloadTaskInfo.getTaskId());
                            }
                        }
                    }
                }
                return;
            }
        }
        z = false;
        if (!z) {
            if (this.b == null) {
                d.a();
                applicationInstance = BrothersApplication.getApplicationInstance();
                if (TextUtils.isEmpty(downloadTaskInfo.mSearchName)) {
                    str = com.xunlei.downloadprovider.download.util.a.a(com.xunlei.downloadprovider.download.util.a.a(downloadTaskInfo, applicationInstance));
                } else {
                    str = downloadTaskInfo.mSearchName;
                }
                CharSequence replaceAll2 = str.replaceAll("[^\\u4e00-\\u9fa5]", "");
                a = DownloadError.a((TaskInfo) downloadTaskInfo);
                obj = "";
                if (a != null) {
                    switch (e.a[a.ordinal()]) {
                        case 1:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_connection_interruption));
                            break;
                        case 2:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_link_failure));
                            break;
                        case 3:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_link_failure));
                            break;
                        case 4:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_link_failure));
                            break;
                        case 5:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_link_failure));
                            break;
                        case 6:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_magnet_link_parse_failure));
                            break;
                        case 7:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_path_connot_be_written));
                            break;
                        case 8:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_path_connot_be_written));
                            break;
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            break;
                        default:
                            obj = String.valueOf(BrothersApplication.getApplicationInstance().getString(R.string.download_item_task_exception_tip_other_failure));
                            break;
                    }
                }
                if (TextUtils.isEmpty(obj)) {
                }
                gVar = null;
                this.b = gVar;
            }
            this.a.a(downloadTaskInfo, this.b, a3);
            d.a();
            d.a(true, downloadTaskInfo.getTaskId(), this);
            a2 = d.a();
            if (a2.b == null) {
                a2.b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "sp_exception_show");
            }
            if (downloadTaskInfo != null) {
                taskId = downloadTaskInfo.getTaskId();
                preferenceHelper = a2.b;
                stringBuilder = new StringBuilder("taskId");
                stringBuilder.append(downloadTaskInfo.getTaskId());
                if (taskId == preferenceHelper.getLong(stringBuilder.toString(), -1)) {
                    z2 = true;
                }
            }
            if (z2) {
                com.xunlei.downloadprovider.download.report.a.b("dl_fail");
                a2 = d.a();
                if (a2.b == null) {
                    a2.b = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "sp_exception_show");
                }
                preferenceHelper = a2.b;
                StringBuilder stringBuilder22 = new StringBuilder("taskId");
                stringBuilder22.append(downloadTaskInfo.getTaskId());
                preferenceHelper.putLong(stringBuilder22.toString(), downloadTaskInfo.getTaskId());
            }
        }
    }

    public final void b() {
        if (this.a != null) {
            this.a.a(8);
        }
        DownloadTaskInfo a = this.a.a();
        if (a != null) {
            d.a();
            d.a(false, a.getTaskId(), this);
            d a2 = d.a();
            if (a2.a == null) {
                a2.a = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "sp_exception_close");
            }
            if (a != null) {
                PreferenceHelper preferenceHelper = a2.a;
                StringBuilder stringBuilder = new StringBuilder("taskId");
                stringBuilder.append(a.getTaskId());
                preferenceHelper.putLong(stringBuilder.toString(), a.getTaskId());
            }
        }
    }
}
