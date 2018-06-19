package com.xunlei.downloadprovider.download.player.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.encrypt.URLCoder;
import com.xunlei.downloadprovider.g.a.b;
import com.xunlei.xllib.b.j;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: RecordPublishController */
final class at implements OnClickListener {
    final /* synthetic */ aq a;

    at(aq aqVar) {
        this.a = aqVar;
    }

    public final void onClick(View view) {
        view = this.a;
        boolean z = false;
        if (view.l) {
            if (view.r()) {
                view.c(false);
                return;
            }
        }
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        StringBuilder stringBuilder = new StringBuilder("XLrecorder");
        stringBuilder.append(format);
        stringBuilder.append(".tmp");
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(DownloadConfig.getRecordVideoPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(DownloadConfig.getRecordVideoPath());
        stringBuilder3.append(stringBuilder2);
        view.k = stringBuilder3.toString();
        if (new File(view.k).getParentFile().getUsableSpace() < 314572800) {
            if (view.n() != null) {
                XLToast.showToast(view.n(), "内存不足，清内存后使用");
            }
            return;
        }
        if (view.f() != null) {
            m f = view.f();
            format = view.k;
            if (f.a != null && f.a.a(format)) {
                z = true;
            }
            view.l = z;
            new StringBuilder("record started=>").append(view.l);
            if (view.l) {
                if (view.f().F()) {
                    view.f().B();
                }
                view.b(true);
                view.i.removeCallbacks(view.o);
                view.i.post(view.o);
                int k_ = view.f().k_();
                view.m = k_;
                view.j = k_;
                new StringBuilder("onStartRecord, mRecordStartPos : ").append(view.j);
                new StringBuilder("onStartRecord, mRecordStartPos : ").append(j.a((long) view.j));
                stringBuilder2 = "native";
                if (view.f().L()) {
                    stringBuilder2 = "bxbb";
                }
                b.a(URLCoder.encode(view.f().m(), null), stringBuilder2);
            } else {
                if (view.n() != null) {
                    XLToast.showToast(view.n(), "录制失败");
                }
            }
        }
    }
}
