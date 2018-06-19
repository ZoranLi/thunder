package com.tencent.smtt.utils;

import android.widget.TextView;

class h implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ f b;

    h(f fVar, int i) {
        this.b = fVar;
        this.a = i;
    }

    public void run() {
        TextView textView = this.b.e;
        StringBuilder stringBuilder = new StringBuilder("已下载");
        stringBuilder.append(this.a);
        stringBuilder.append("%");
        textView.setText(stringBuilder.toString());
    }
}
