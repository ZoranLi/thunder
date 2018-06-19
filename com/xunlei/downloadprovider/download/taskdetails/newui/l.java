package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.animation.ValueAnimator;
import android.view.ViewGroup.LayoutParams;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import com.xunlei.downloadprovider.vodnew.a.d.c;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;

/* compiled from: DownloadDetailsActivityFragment */
final class l implements e {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    l(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void a(c cVar) {
        DownloadDetailsActivityFragment.q;
        if (this.a.m != null && this.a.m.isStarted()) {
            this.a.m.cancel();
        }
        if (this.a.p == null || !this.a.p.e()) {
            if (!this.a.n) {
                DownloadDetailsActivityFragment downloadDetailsActivityFragment = this.a;
                if (cVar != null) {
                    int k = cVar.k();
                    int l = cVar.l();
                    cVar = cVar.m();
                    LayoutParams layoutParams = downloadDetailsActivityFragment.k.getLayoutParams();
                    if (!(l == 0 || k == 0)) {
                        k = (int) (((float) ((l * DownloadDetailsActivityFragment.a) / k)) + PayBaseConstants.HALF_OF_FLOAT);
                        if (k < DownloadDetailsActivityFragment.c) {
                            k = DownloadDetailsActivityFragment.c;
                        } else if (k > DownloadDetailsActivityFragment.b) {
                            k = DownloadDetailsActivityFragment.b;
                        }
                        layoutParams.height = k;
                        if (layoutParams.height - cVar > 1) {
                            k = layoutParams.height;
                            downloadDetailsActivityFragment.m = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                            downloadDetailsActivityFragment.m.setDuration(300);
                            StringBuilder stringBuilder = new StringBuilder("animationmPlayerContainerLayout,  sourceHeight:  ");
                            stringBuilder.append(cVar);
                            stringBuilder.append(" targetHeight: ");
                            stringBuilder.append(k);
                            downloadDetailsActivityFragment.m.addUpdateListener(new x(downloadDetailsActivityFragment, cVar, k, layoutParams));
                            downloadDetailsActivityFragment.m.start();
                        }
                    }
                }
            }
            return;
        }
        DownloadDetailsActivityFragment.q;
    }
}
