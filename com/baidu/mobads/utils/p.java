package com.baidu.mobads.utils;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build.VERSION;

class p implements Runnable {
    final /* synthetic */ SharedPreferences a;
    final /* synthetic */ String b;
    final /* synthetic */ o c;

    p(o oVar, SharedPreferences sharedPreferences, String str) {
        this.c = oVar;
        this.a = sharedPreferences;
        this.b = str;
    }

    @TargetApi(9)
    public void run() {
        if (VERSION.SDK_INT >= 9) {
            this.a.edit().putString("deviceid", this.b).apply();
        } else {
            this.a.edit().putString("deviceid", this.b).commit();
        }
    }
}
