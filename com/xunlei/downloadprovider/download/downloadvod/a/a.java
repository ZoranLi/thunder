package com.xunlei.downloadprovider.download.downloadvod.a;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/* compiled from: BxbbNotifySnackbar */
public final class a {
    View a;
    ViewGroup b;
    Runnable c = new b(this);
    OnClickListener d;

    public a(ViewGroup viewGroup, View view) {
        this.b = viewGroup;
        this.a = view;
        this.a.setOnClickListener(new c(this));
    }

    public final void a() {
        this.b.removeCallbacks(this.c);
        this.b.removeView(this.a);
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 18) {
                int i = 36;
                String str2 = "";
                StringBuilder stringBuilder = new StringBuilder();
                int i2 = 0;
                if (str.length() > 8) {
                    str2 = str.substring(str.length() - 8);
                    str = str.substring(0, str.length() - 8);
                }
                if (str.length() > 0) {
                    int i3 = -1;
                    while (i2 < str.length()) {
                        char charAt = str.charAt(i2);
                        i = charAt < 'Ā' ? i - 1 : i - 2;
                        if (i <= 0) {
                            i3 = i2;
                            break;
                        }
                        stringBuilder.append(charAt);
                        i2++;
                    }
                    if (i3 >= 0 && i3 < str.length() - 1) {
                        stringBuilder.append("...");
                    }
                }
                stringBuilder.append(str2);
                return stringBuilder.toString();
            }
        }
        return str;
    }
}
