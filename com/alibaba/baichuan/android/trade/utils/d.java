package com.alibaba.baichuan.android.trade.utils;

import android.app.AlertDialog.Builder;

final class d implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;

    d(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void run() {
        Builder builder = new Builder(c.a());
        StringBuilder stringBuilder = new StringBuilder("class = ");
        stringBuilder.append(this.a);
        stringBuilder.append("\nmethod = ");
        stringBuilder.append(this.b);
        stringBuilder.append("\nerrMsg = ");
        stringBuilder.append(this.c);
        builder.setMessage(stringBuilder.toString());
        builder.setTitle("执行过程参数发生错误");
        builder.show();
    }
}
