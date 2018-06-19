package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import android.content.DialogInterface.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.c.a;
import com.xunlei.downloadprovider.download.c.d;
import com.xunlei.downloadprovider.download.control.p;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.xllib.android.b;

/* compiled from: DownloadFreeTrialBanner */
final class e extends c {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        z = a.a();
        LoginHelper.a();
        if (l.b() != 0) {
            LoginHelper.a();
            if (l.b() != 0) {
                TaskInfo c = h.e().c(z.e);
                if (c != null && c.getTaskStatus() == 4) {
                    if (!b.a(BrothersApplication.getApplicationInstance())) {
                        XLToast.showToast(BrothersApplication.getApplicationInstance(), BrothersApplication.getApplicationInstance().getString(R.string.net_disable));
                    } else if (b.f(BrothersApplication.getApplicationInstance())) {
                        p.a().a(c, false);
                    } else {
                        OnClickListener bVar = new com.xunlei.downloadprovider.download.c.b(z, c);
                        i = BrothersApplication.getApplicationInstance();
                        XLAlertDialog xLAlertDialog = new XLAlertDialog(i);
                        xLAlertDialog.setMessage(i.getString(R.string.net_change_mobile_continus_tips));
                        xLAlertDialog.setCancelButtonText(i.getString(R.string.net_change_start_downloading));
                        xLAlertDialog.setConfirmButtonText(i.getString(R.string.net_change_close));
                        xLAlertDialog.setCanceledOnTouchOutside(true);
                        xLAlertDialog.setOnClickCancelButtonListener(new com.xunlei.downloadprovider.download.c.c(z, xLAlertDialog, bVar));
                        xLAlertDialog.setOnClickConfirmButtonListener(new d(z, xLAlertDialog));
                        xLAlertDialog.show();
                    }
                }
            }
            LoginHelper.a();
            if (l.b() == 0 || LoginHelper.a().l() == 0) {
                a.a().c();
                a.f();
                LoginHelper.a();
                if (l.b() != 0) {
                    a.a().d(z.e);
                    n.a();
                    i = n.f(z.e);
                    if (i != 0 && ((double) (((float) i.mDownloadedSize) / ((float) i.mFileSize))) < 0.7d) {
                        a.a().c(i.mDownloadedSize);
                        h.e().c(z.e).mIsEnteredHighSpeedTrial = true;
                        z.g(z.e);
                        a.a().c();
                    }
                }
            } else {
                if (z.b() != 0) {
                    z.b(z.e, a.c);
                    z.e();
                }
                z.d(-1);
                n.a();
                n.d(false);
            }
        }
    }
}
