package com.baidu.mobads.production.e;

import android.os.CountDownTimer;

class e extends CountDownTimer {
    final /* synthetic */ b a;

    e(b bVar, long j, long j2) {
        this.a = bVar;
        super(j, j2);
    }

    public void onTick(long j) {
        j = (int) (j / 1000);
        if (j > 5) {
            j = 5;
        }
        this.a.z.setText(String.valueOf(j));
    }

    public void onFinish() {
        this.a.x.d("CountDownTimer finished");
        this.a.u();
        this.a.h.stop();
    }
}
