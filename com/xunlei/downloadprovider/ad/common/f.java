package com.xunlei.downloadprovider.ad.common;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import anet.channel.util.ErrorConstant;
import com.android.volley.VolleyError;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.ad.a;
import com.xunlei.downloadprovider.ad.common.CommonConst.AD_SYSTEM_TYPE;
import com.xunlei.downloadprovider.ad.common.adget.l;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* compiled from: CommonUtil */
public final class f {
    public static float a(float f) {
        return f <= 0.0f ? 4.5f : f;
    }

    public static int a(VolleyError volleyError) {
        if (volleyError != null) {
            volleyError = volleyError.networkResponse;
            if (volleyError != null) {
                return volleyError.a;
            }
        }
        return ErrorConstant.ERROR_TNET_EXCEPTION;
    }

    public static String b(VolleyError volleyError) {
        return volleyError != null ? volleyError.getClass().getSimpleName() : "";
    }

    public static boolean a() {
        String c = c();
        if (!c.equals("0")) {
            if (!c.equals("1")) {
                return false;
            }
        }
        return true;
    }

    public static <T> T a(Map<T, Integer> map, T t) {
        int i = 0;
        int i2 = 0;
        for (Object obj : map.keySet()) {
            i2 += ((Integer) map.get(obj)).intValue();
        }
        if (i2 != 100) {
            return t;
        }
        i2 = map.keySet().size();
        Object[] objArr = new Object[map.keySet().size()];
        int[] iArr = new int[i2];
        List arrayList = new ArrayList();
        arrayList.addAll(map.keySet());
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = arrayList.get(i3);
            if (i3 > 0) {
                iArr[i3] = iArr[i3 - 1] + ((Integer) map.get(objArr[i3])).intValue();
            } else {
                iArr[i3] = ((Integer) map.get(objArr[i3])).intValue();
            }
        }
        map = new Random().nextInt(100) + 1;
        while (i < i2) {
            if (i == 0 && map <= iArr[i]) {
                return objArr[i];
            }
            if (i > 0 && iArr[i - 1] < map && map <= iArr[i]) {
                return objArr[i];
            }
            i++;
        }
        return t;
    }

    public static float b() {
        Float f = (Float) a(CommonConst.a, Float.valueOf(5.0f));
        if (f != null) {
            return f.floatValue();
        }
        return 5.0f;
    }

    public static String a(@NonNull l lVar, int i) {
        return String.format(a.a().getString(i), new Object[]{lVar.z()});
    }

    public static boolean a(l lVar) {
        return (lVar == null || lVar.c() != AD_SYSTEM_TYPE.SOURCE_XUNLEI_FLAG) ? null : true;
    }

    public static boolean b(l lVar) {
        return (lVar == null || lVar.c() != AD_SYSTEM_TYPE.SOURCE_BAIDU_FLAG || !b.e(a.a()) || lVar.w() == null) ? null : true;
    }

    @NonNull
    public static String c() {
        String hubbleDeviceGUID = AndroidConfig.getHubbleDeviceGUID();
        String str = "0";
        if (TextUtils.isEmpty(hubbleDeviceGUID) || 4 > hubbleDeviceGUID.length()) {
            return str;
        }
        try {
            hubbleDeviceGUID = hubbleDeviceGUID.substring(hubbleDeviceGUID.length() - 4, hubbleDeviceGUID.length() - 3);
        } catch (IndexOutOfBoundsException e) {
            new StringBuilder("guid substring error: ").append(e.getLocalizedMessage());
            hubbleDeviceGUID = str;
        }
        return hubbleDeviceGUID;
    }

    public static void d() {
        if (e()) {
            throw new IllegalArgumentException("You can not call this method on main thread");
        }
    }

    public static boolean e() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean a(Context context) {
        return context instanceof Activity ? a((Activity) context) : true;
    }

    public static boolean a(Activity activity) {
        if (activity == null) {
            return true;
        }
        if (VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        return activity.isFinishing();
    }
}
