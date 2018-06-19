package com.xunlei.downloadprovider.ad.taskdetail.view;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.downloadprovider.download.taskdetails.TaskDetailFragment;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;

/* compiled from: AbstractTaskDetailAdView */
public abstract class a extends FrameLayout {
    private static final String c = "a";
    protected Context a = null;
    protected l b = null;
    private XLAlertDialog d = null;
    private com.xunlei.downloadprovider.ad.taskdetail.a e = null;
    private DownloadTaskInfo f = null;

    public abstract void a(@NonNull l lVar);

    protected void b() {
    }

    public abstract void d();

    public abstract String getAdUIStyle();

    public a(Context context) {
        super(context);
        this.a = context;
    }

    protected final void a() {
        b();
        c();
        d();
    }

    protected void c() {
        OnClickListener bVar = new b(this);
        OnClickListener cVar = new c(this);
        if (this.d == null) {
            this.d = new XLAlertDialog(this.a);
            this.d.setTitle((CharSequence) "温馨提示");
            this.d.setMessage((CharSequence) "当前为移动网络，开始下载/安装应用？");
            this.d.setConfirmButtonText((CharSequence) "确认");
            this.d.setCancelButtonText((CharSequence) "取消");
        }
        this.d.setOnClickConfirmButtonListener(bVar);
        this.d.setOnClickCancelButtonListener(cVar);
    }

    public void setDownloadTaskInfo(DownloadTaskInfo downloadTaskInfo) {
        this.f = downloadTaskInfo;
    }

    protected int getBottomMarginWhileShow() {
        return (this.f == null || !k.e(this.f) || TaskDetailFragment.a(this.f)) ? 0 : DipPixelUtil.dip2px(5.0f);
    }

    protected int getBottomMarginWhileHide() {
        return (this.f == null || !k.e(this.f)) ? 0 : DipPixelUtil.dip2px(5.0f);
    }

    protected final void b(@NonNull l lVar) {
        if (this.e != null) {
            this.e.a(this, lVar);
        }
    }

    protected final void c(l lVar) {
        if (this.e != null && lVar != null) {
            this.e.b(this, lVar);
        }
    }

    public void setAdController(com.xunlei.downloadprovider.ad.taskdetail.a aVar) {
        this.e = aVar;
    }

    protected final void e() {
        if (this.d != null) {
            this.d.show();
        }
    }

    protected final void f() {
        if (this.d != null) {
            this.d.dismiss();
        }
    }
}
