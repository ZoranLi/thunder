package com.xunlei.downloadprovider.download.create;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.ApkHelper$ApkInfo;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.ui.SceneUiStyle;
import com.xunlei.downloadprovider.cooperation.ui.dialog.CooperationDialogActivity;
import com.xunlei.downloadprovider.dialog.f;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.m;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.xllib.android.b;
import com.xunlei.xllib.android.b.a;

public class ThunderTaskInteractionFragment extends Fragment {
    public au a;
    Activity b;
    private f c;
    private f d = null;
    private d e = new d(new al(this));

    final void a(TaskInfo taskInfo, int i) {
        int i2 = 1;
        if (taskInfo.getTaskStatus() == 8 && taskInfo.mCheckApkOperateWhenCreate && e.e(taskInfo.mLocalFileName)) {
            if (e.c(taskInfo.mLocalFileName)) {
                Context b = b();
                String str = taskInfo.mLocalFileName;
                if (b != null) {
                    ApkHelper$ApkInfo apkInfo = ApkHelper.getApkInfo(b.getBaseContext(), str);
                    if (ApkHelper.compareLocalApp(b.getBaseContext(), apkInfo) == 4) {
                        String packageName = apkInfo.getPackageName();
                        if (packageName != null) {
                            ApkHelper.launchAppByPackageName(b.getBaseContext(), packageName);
                        }
                    } else if (str != null) {
                        com.xunlei.downloadprovider.download.openwith.d.a(b, str, false);
                    }
                }
                if (i2 != 0) {
                    a(i, taskInfo.getTaskId());
                } else {
                    c();
                }
            }
            n.a();
            n.a(false, new long[]{taskInfo.getTaskId()});
        }
        i2 = 0;
        if (i2 != 0) {
            c();
        } else {
            a(i, taskInfo.getTaskId());
        }
    }

    public static ThunderTaskInteractionFragment a() {
        return new ThunderTaskInteractionFragment();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.b = getActivity();
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onStart() {
        super.onStart();
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
    }

    public void onDetach() {
        super.onDetach();
        this.b = null;
    }

    public final void a(FragmentManager fragmentManager, au auVar) {
        fragmentManager.beginTransaction().add(this, "ThunderTaskInteractionFragment").commitAllowingStateLoss();
        this.a = auVar;
    }

    public final Activity b() {
        return this.b != null ? this.b : getActivity();
    }

    protected final void a(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    final void a(@NonNull DownData downData, @NonNull TaskStatInfo taskStatInfo, @Nullable c cVar) {
        at.a();
        m mVar = new m();
        mVar.a(downData.b, downData.a, downData.c, downData.a().e, taskStatInfo.a, downData.a());
        mVar.b = taskStatInfo;
        mVar.d = cVar;
        if (cVar == null) {
            mVar.d = this.e;
        }
        if (TextUtils.isEmpty(taskStatInfo.h) == null) {
            downData = taskStatInfo.a;
            cVar = taskStatInfo.h;
            downData = HubbleEventBuilder.build("android_download", "dl_create").add("from", downData).add("net_type", a.b(BrothersApplication.getApplicationInstance())).add("is_apk", "1");
            String str = "gameid";
            if (cVar == null) {
                cVar = "";
            }
            ThunderReport.reportEvent(downData.add(str, cVar));
        } else {
            com.xunlei.downloadprovider.download.engine.report.a.a(taskStatInfo.a);
        }
        downData = BrothersApplication.getApplicationInstance().getApplicationContext();
        if (DownloadConfig.isStoragePathExist(downData) == null) {
            a((boolean) null);
            XLToast.showToast(downData, downData.getString(R.string.xa_no_sd));
            com.xunlei.downloadprovider.download.engine.report.a.a(taskStatInfo.a, mVar.a.mDownloadUrl, 3, taskStatInfo);
        } else if (b.a(downData) == null) {
            downData = com.xunlei.downloadprovider.cooperation.ui.b.a(1007, 17);
            if (downData != null) {
                CooperationDialogActivity.a(b(), downData, SceneUiStyle.TWO_BUTTON, new am(this, mVar, taskStatInfo));
                return;
            }
            b(mVar, taskStatInfo);
        } else if (b.f(downData) != null) {
            b(mVar, taskStatInfo);
        } else {
            downData = com.xunlei.downloadprovider.cooperation.c.a().b(1008);
            CooperationItem a = com.xunlei.downloadprovider.cooperation.c.a().a(19);
            cVar = com.xunlei.downloadprovider.cooperation.ui.b.a(1008, 19);
            if (downData == null || a == null) {
                downData = BrothersApplication.getApplicationInstance().getApplicationContext();
                CharSequence string = downData.getString(R.string.net_change_mobile_createtask_tips);
                CharSequence string2 = downData.getString(R.string.net_change_confirm_createtask);
                downData = downData.getString(R.string.net_change_delay_downloading);
                OnClickListener aoVar = new ao(this, mVar, taskStatInfo);
                OnClickListener apVar = new ap(this, mVar, taskStatInfo);
                taskStatInfo = b();
                if (!(taskStatInfo == null || taskStatInfo.isFinishing())) {
                    if (this.c == null) {
                        this.c = new f(taskStatInfo);
                    }
                    this.c.b(string);
                    this.c.f();
                    this.c.e();
                    this.c.d(string2);
                    this.c.b(aoVar);
                    this.c.c(downData);
                    this.c.a(apVar);
                    if (this.c.isShowing() == null) {
                        try {
                            this.c.show();
                            return;
                        } catch (DownData downData2) {
                            downData2.printStackTrace();
                        }
                    }
                }
                return;
            }
            CooperationDialogActivity.a(b(), cVar, SceneUiStyle.THREE_BUTTON, new an(this, mVar, taskStatInfo));
        }
    }

    public final void a(int i, long j) {
        Context b = b();
        if (!(b == null || b.isFinishing() || i != -2)) {
            if (this.d == 0) {
                this.d = new f(b);
                this.d.k = 5;
            }
            if (this.d.isShowing() == 0) {
                this.d.c();
                this.d.d();
                this.d.b(new aq(this, j));
                this.d.a(new ar(this));
                this.d.setOnDismissListener(new as(this));
                try {
                    this.d.show();
                } catch (int i2) {
                    new StringBuilder("catched BadTokenException , msg : ").append(i2.getMessage());
                } catch (int i22) {
                    new StringBuilder("catched IllegalStateException , msg : ").append(i22.getMessage());
                }
            }
        }
    }

    private void c() {
        Activity b = b();
        if (b != null && (b instanceof ThunderTaskInteractionActivity) && !b.isFinishing()) {
            b.finish();
        }
    }

    public void onDestroy() {
        this.a = null;
        this.e.a();
        super.onDestroy();
    }

    private void b(@NonNull m mVar, @NonNull TaskStatInfo taskStatInfo) {
        mVar.b = taskStatInfo;
        n.a().a(mVar);
        a(true);
    }

    static /* synthetic */ void b(ThunderTaskInteractionFragment thunderTaskInteractionFragment, m mVar, TaskStatInfo taskStatInfo) {
        mVar.b = taskStatInfo;
        n.a().a(mVar);
        thunderTaskInteractionFragment.a(true);
    }
}
