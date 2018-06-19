package android.support.v4.os;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;

public class UserManagerCompat {
    private UserManagerCompat() {
    }

    public static boolean isUserUnlocked(Context context) {
        return VERSION.SDK_INT >= 24 ? ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked() : true;
    }
}
