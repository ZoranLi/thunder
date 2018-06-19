package com.xunlei.downloadprovider.discovery.kuainiao.a;

import android.os.Handler;
import com.xunlei.common.accelerator.XLAccelUtil;
import com.xunlei.common.accelerator.XLOnAccelListener;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.discovery.kuainiao.d;

/* compiled from: KuaiNiaoAccelerator */
final class c implements XLOnAccelListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void callBack(int i, int i2, String str) {
        switch (i) {
            case 4:
                b.a(this.a, 1);
                break;
            case 5:
                if (!(d.a().c == 0 || b.a(this.a) == 0)) {
                    b.a(this.a, 0);
                    b.e();
                    i = XLAccelUtil.getInstance().getAccelerator().getBandInfoObject();
                    if (i == 0 || i.mCurrentBandWidth == 0) {
                        this.a.a = BrothersApplication.getApplicationInstance().getResources().getString(R.string.kuainiao_original_speed);
                    } else {
                        this.a.a = ConvertUtil.byteConvert(i.mCurrentBandWidth.mDownStream * 1024);
                    }
                    if (AppStatusChgObserver.b().a != 0) {
                        new Handler().postDelayed(new d(this), 3000);
                    }
                    return;
                }
                break;
            default:
                break;
        }
    }
}
