package com.xunlei.common.new_ptl.member.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;

/* compiled from: XLDeviceInfo */
public class g {
    private i a;
    private Context b;
    private boolean c;
    private boolean d;
    private int e;
    private BroadcastReceiver f;

    public static String a() {
        return VERSION.RELEASE;
    }

    public static String b() {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "NONE" : str;
    }

    public static String c() {
        String toLowerCase = Build.MANUFACTURER.toLowerCase();
        String toLowerCase2 = Build.MODEL.toLowerCase();
        if (toLowerCase2.startsWith(toLowerCase)) {
            return a(toLowerCase2);
        }
        Object a = a(toLowerCase);
        if (TextUtils.isEmpty(a)) {
            return a(toLowerCase2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append(" ");
        stringBuilder.append(a(toLowerCase2));
        return stringBuilder.toString();
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "NONE";
        }
        String str2 = "";
        Object obj = 1;
        for (char c : str.toCharArray()) {
            if (obj == null || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    obj = 1;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str2);
                stringBuilder.append(c);
                str2 = stringBuilder.toString();
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str2);
                stringBuilder2.append(Character.toUpperCase(c));
                str2 = stringBuilder2.toString();
                obj = null;
            }
        }
        return str2;
    }

    public g(i iVar, Context context) {
        this.a = null;
        this.b = null;
        this.c = false;
        this.d = true;
        this.e = 0;
        this.f = new k(this);
        this.a = iVar;
        this.b = context;
    }

    public void d() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        this.b.registerReceiver(this.f, intentFilter);
    }

    public void e() {
        if (this.f != null) {
            this.b.unregisterReceiver(this.f);
        }
    }

    private void a(boolean z, NetworkInfo networkInfo) {
        if (this.d) {
            this.a.a(z);
            this.d = null;
        } else {
            int i = -1;
            if (networkInfo != null) {
                i = networkInfo.getType();
            }
            if (!(this.c == z && this.e == i)) {
                this.a.a(z);
                this.e = i;
            }
        }
        this.c = z;
    }

    static /* synthetic */ void a(g gVar, boolean z, NetworkInfo networkInfo) {
        if (gVar.d) {
            gVar.a.a(z);
            gVar.d = null;
        } else {
            int i = -1;
            if (networkInfo != null) {
                i = networkInfo.getType();
            }
            if (!(gVar.c == z && gVar.e == i)) {
                gVar.a.a(z);
                gVar.e = i;
            }
        }
        gVar.c = z;
    }
}
