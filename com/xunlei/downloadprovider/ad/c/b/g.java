package com.xunlei.downloadprovider.ad.c.b;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import java.util.List;

/* compiled from: PermissionManager */
public final class g {

    /* compiled from: PermissionManager */
    public interface a {
        void a(List<String> list);

        void b();

        void c();
    }

    public static boolean a(Context context, String... strArr) {
        if (context == null) {
            return false;
        }
        if (strArr.length <= 0) {
            return true;
        }
        try {
            return ContextCompat.checkSelfPermission(context, strArr[0]) == null;
        } catch (Context context2) {
            context2.printStackTrace();
            return false;
        }
    }

    static void a(Object obj, String[] strArr) {
        a(obj);
        if (obj instanceof Activity) {
            ActivityCompat.requestPermissions((Activity) obj, strArr, 23);
            return;
        }
        if (obj instanceof Fragment) {
            ((Fragment) obj).requestPermissions(strArr, 23);
        }
    }

    static void a(Object obj) {
        if (!(obj instanceof Fragment) && (obj instanceof Activity) == null) {
            throw new IllegalArgumentException("Caller must be an Activity or a Fragment.");
        }
    }
}
