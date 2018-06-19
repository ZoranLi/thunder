package me.iwf.photopicker.d;

import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import com.umeng.message.MsgConstant;

/* compiled from: PermissionsUtils */
public final class f {
    public static boolean a(Fragment fragment) {
        boolean z = ContextCompat.checkSelfPermission(fragment.getContext(), MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) == 0;
        if (!z) {
            fragment.requestPermissions(e.b, 3);
        }
        return z;
    }

    public static boolean b(Fragment fragment) {
        boolean z = ContextCompat.checkSelfPermission(fragment.getContext(), "android.permission.CAMERA") == 0;
        if (!z) {
            fragment.requestPermissions(e.a, 1);
        }
        return z;
    }
}
