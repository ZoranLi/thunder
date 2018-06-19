package com.xunlei.downloadprovider.download.downloadvod.a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.TextView;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.download.center.DownloadCenterActivity;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadVodNotifyManager */
final class h implements Runnable {
    final /* synthetic */ d a;

    h(d dVar) {
        this.a = dVar;
    }

    public final void run() {
        Activity c = AppStatusChgObserver.b().c();
        if (!d.b(c)) {
            if (this.a.h != null) {
                String str = c instanceof DownloadCenterActivity ? "dl_center" : DispatchConstants.OTHER;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a.a(this.a.h.mTitle));
                stringBuilder.append(" 可边下边播");
                CharSequence stringBuilder2 = stringBuilder.toString();
                try {
                    View decorView = c.getWindow().getDecorView();
                    ViewGroup viewGroup = (ViewGroup) decorView.findViewById(16908290);
                    a aVar = new a(viewGroup, LayoutInflater.from(decorView.getContext()).inflate(R.layout.layout_download_bxbb_notify_snackbar, viewGroup, false));
                    ((TextView) aVar.a.findViewById(R.id.tv_title)).setText(stringBuilder2);
                    aVar.d = new i(this, str);
                    aVar.b.addView(aVar.a);
                    LayoutParams layoutParams = aVar.a.getLayoutParams();
                    if (layoutParams instanceof FrameLayout.LayoutParams) {
                        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                        layoutParams2.gravity = 80;
                        aVar.a.setLayoutParams(layoutParams2);
                    }
                    aVar.b.removeCallbacks(aVar.c);
                    aVar.b.postDelayed(aVar.c, 5000);
                    a.p(str);
                } catch (Exception e) {
                    e.printStackTrace();
                    this.a.f();
                }
            }
        }
    }
}
