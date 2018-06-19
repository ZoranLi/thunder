package com.xunlei.downloadprovider.cooperation.ui.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.data.CooperationData;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.ui.SceneUiStyle;
import com.xunlei.downloadprovider.cooperation.ui.a;
import com.xunlei.downloadprovider.cooperation.ui.b;
import com.xunlei.downloadprovider.dialog.f;
import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.task.info.DownloadAdditionInfo;
import com.xunlei.downloadprovider.download.report.c;
import com.xunlei.xllib.android.XLIntent;

public class CooperationDialogActivity extends FragmentActivity {
    private static a f;
    private f a;
    private f b;
    private CooperationData c;
    private int d;
    private SceneUiStyle e;

    public static void a(Context context, CooperationData cooperationData, SceneUiStyle sceneUiStyle, a aVar) {
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(context, CooperationDialogActivity.class);
        xLIntent.putExtra("cooperation_data", cooperationData);
        xLIntent.putExtra("cooperation_type", 1);
        xLIntent.putExtra("cooperation_style", sceneUiStyle);
        xLIntent.addFlags(268435456);
        f = aVar;
        context.startActivity(xLIntent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = getIntent().getIntExtra("cooperation_type", 1);
        this.c = (CooperationData) getIntent().getSerializableExtra("cooperation_data");
        this.e = (SceneUiStyle) getIntent().getSerializableExtra("cooperation_style");
        if (this.d == 1) {
            bundle = this.c;
            SceneUiStyle sceneUiStyle = this.e;
            if (bundle != null) {
                this.a = new f(this, sceneUiStyle);
                this.a.a(bundle.mCooperationScene, bundle.mCooperationItem, "继续播放");
                this.a.b = f;
                this.a.setOnDismissListener(new a(this));
                this.a.show();
            }
        } else if (this.d != 2 || this.c.mCooperationItem == null) {
            finish();
        } else {
            bundle = this.c.mCooperationItem;
            if (this.b != null) {
                if (this.b.isShowing()) {
                    this.b.dismiss();
                }
                this.b = null;
            }
            this.b = new f(this);
            this.b.setTitle(bundle.getTitle());
            this.b.b(bundle.getAppDescription());
            this.b.c("取消");
            this.b.d("确认");
            OnClickListener bVar = new b(this, bundle);
            OnClickListener cVar = new c(this, bundle);
            this.b.a(bVar);
            this.b.b(cVar);
            this.b.setOnDismissListener(new d(this));
            this.b.show();
            com.xunlei.downloadprovider.cooperation.a.a.a(bundle.getDisplayLocationName(), bundle.getAppPackageName());
        }
    }

    static void a(CooperationItem cooperationItem) {
        b.a();
        if (b.a(cooperationItem)) {
            b.a();
            b.a(BrothersApplication.getApplicationInstance(), cooperationItem.getAppName());
            return;
        }
        DownloadAdditionInfo downloadAdditionInfo = new DownloadAdditionInfo();
        downloadAdditionInfo.b = TextUtils.isEmpty(cooperationItem.getAppSelfIconUrl()) ? cooperationItem.getAppIconUrl() : cooperationItem.getAppSelfIconUrl();
        downloadAdditionInfo.a = cooperationItem.getAppName();
        downloadAdditionInfo.f = true;
        String appDownloadUrl = cooperationItem.getAppDownloadUrl();
        TaskStatInfo taskStatInfo = new TaskStatInfo(appDownloadUrl, null);
        taskStatInfo.a = c.a(cooperationItem.getDisplayLocationName(), cooperationItem.getAppPackageName());
        cooperationItem = downloadAdditionInfo.a;
        if (!TextUtils.isEmpty(downloadAdditionInfo.a)) {
            cooperationItem = new StringBuilder();
            cooperationItem.append(downloadAdditionInfo.a);
            cooperationItem.append(ShareConstants.PATCH_SUFFIX);
            cooperationItem = cooperationItem.toString();
        }
        com.xunlei.downloadprovider.download.c.a(appDownloadUrl, cooperationItem, 0, "", taskStatInfo, downloadAdditionInfo, null);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}
