package com.xunlei.downloadprovider.personal.a.f;

import android.text.TextUtils;
import android.widget.ImageView;
import com.android.volley.Request;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.net.volley.VolleyRequestManager;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import java.util.Calendar;
import java.util.regex.Pattern;

/* compiled from: UserCenterUtil */
public final class a {
    private static String a;

    public static int a(int i) {
        return i == 1 ? R.drawable.download_entrance_num_bkg_white_in_blue : i == 2 ? R.drawable.download_entrance_num_2digits_bkg_white_in_blue : R.drawable.download_entrance_num_3digits_bkg_white_in_blue;
    }

    public static long a(String str) {
        Calendar instance = Calendar.getInstance();
        instance.clear();
        if (TextUtils.isEmpty(str) || !Pattern.compile("[0-9]*").matcher(str).matches()) {
            return -1;
        }
        instance.set(Integer.parseInt(str.substring(0, 4)), Integer.parseInt(str.substring(4, 6)) - 1, Integer.parseInt(str.substring(6, 8)));
        long timeInMillis = instance.getTimeInMillis() - Calendar.getInstance().getTimeInMillis();
        long j = timeInMillis % 86400000;
        timeInMillis /= 86400000;
        return j > 0 ? timeInMillis + 1 : timeInMillis;
    }

    public static void a(String str, ImageView imageView) {
        Glide.with(imageView.getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.ic_default_gray).fallback(R.drawable.ic_default_gray).error(R.drawable.ic_default_gray).dontAnimate().into(imageView);
    }

    public static void a(String str, ImageView imageView, int i) {
        Glide.with(imageView.getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).error(i).dontAnimate().into(imageView);
    }

    public static java.lang.String a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x002a;
    L_0x0008:
        r0 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0026 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0026 }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x0026 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0026 }
        r2 = r2.signatures;	 Catch:{ NameNotFoundException -> 0x0026 }
        r0 = 0;	 Catch:{ NameNotFoundException -> 0x0026 }
        r2 = r2[r0];	 Catch:{ NameNotFoundException -> 0x0026 }
        r2 = r2.toByteArray();	 Catch:{ NameNotFoundException -> 0x0026 }
        r2 = com.xunlei.xllib.b.g.a(r2);	 Catch:{ NameNotFoundException -> 0x0026 }
        a = r2;	 Catch:{ NameNotFoundException -> 0x0026 }
        goto L_0x002a;
    L_0x0026:
        r2 = "e256aedc53fdacacc27c680bc4f2d6f2";
        a = r2;
    L_0x002a:
        r2 = a;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.a.f.a.a(android.content.Context):java.lang.String");
    }

    public static void a(StaticHandler staticHandler) {
        LoginHelper a = LoginHelper.a();
        if (l.c()) {
            com.android.volley.l mainThreadRequestQueue = VolleyRequestManager.getMainThreadRequestQueue();
            Request aVar = new com.xunlei.downloadprovider.personal.user.a(a.e(), new b(), new c());
            mainThreadRequestQueue.a(aVar);
            aVar.a = new d(a, staticHandler);
        }
    }
}
