package com.alibaba.sdk.android.feedback.windvane;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.alibaba.sdk.android.feedback.xblink.f.c;
import com.alibaba.sdk.android.feedback.xblink.f.m;

public class l {
    public static int a = 3001;
    public static int b = 3002;
    private static final String c = "l";
    private Activity d;
    private Object e = null;
    private View f;
    private boolean g = false;

    public l(Activity activity, View view) {
        this.d = activity;
        this.f = view;
    }

    public void a(int i, int i2, Intent intent) {
        m mVar = new m();
        StringBuilder stringBuilder = new StringBuilder("take bar scan callback,requestCode: ");
        stringBuilder.append(i);
        stringBuilder.append(";resultCode: ");
        stringBuilder.append(i2);
    }

    public boolean a() {
        return this.g;
    }

    public void b() {
        if (this.e != null) {
            m mVar = new m();
            mVar.a();
            c.a(this.e, "WXPageAction.onBack", mVar.b());
        }
    }
}
