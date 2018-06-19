package com.xunlei.downloadprovider.download.player.a;

import com.xunlei.xllib.b.j;

/* compiled from: RecordPublishController */
final class ar implements Runnable {
    final /* synthetic */ aq a;

    ar(aq aqVar) {
        this.a = aqVar;
    }

    public final void run() {
        if (this.a.f() != null && this.a.f().m_()) {
            CharSequence stringBuilder;
            int k_ = this.a.f().k_() - this.a.j;
            if (k_ >= aq.q * 1000) {
                aq.p;
                new StringBuilder("mRecordingUpdateRunnalbe, stopRecord，recordTime : ").append(j.a((long) k_));
                k_ = aq.q * 1000;
                this.a.c(false);
            }
            aq aqVar = this.a;
            if (k_ >= aq.a * 1000) {
                aqVar.d.setVisibility(8);
                aqVar.b.setProgress(k_);
                StringBuilder stringBuilder2 = new StringBuilder("正在录制视频 ");
                stringBuilder2.append(j.a((long) k_));
                stringBuilder = stringBuilder2.toString();
                if (!aqVar.g.c.isEnabled()) {
                    aqVar.g.setRecordBtnEnabled(true);
                    aqVar.g.setRecordBtnSelected(true);
                    if (aqVar.h == null) {
                        aqVar.h = new au(aqVar);
                    }
                    aqVar.i.removeCallbacks(aqVar.h);
                    aqVar.i.post(aqVar.h);
                }
            } else {
                aqVar.g.setRecordBtnSelected(false);
                aqVar.g.setRecordBtnEnabled(false);
                aqVar.b.setSecondaryProgress(k_);
                aqVar.b.setProgress(0);
                stringBuilder = String.format("录制%s秒即可分享", new Object[]{Integer.valueOf(aq.a)});
            }
            aqVar.c.setText(stringBuilder);
            this.a.i.removeCallbacks(this);
            this.a.i.postDelayed(this, 500);
        }
    }
}
