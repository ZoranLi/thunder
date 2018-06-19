package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;

public final class EnvironmentCompat {
    public static final String MEDIA_UNKNOWN = "unknown";
    private static final String TAG = "EnvironmentCompat";

    public static String getStorageState(File file) {
        if (VERSION.SDK_INT >= 19) {
            return Environment.getStorageState(file);
        }
        try {
            if (file.getCanonicalPath().startsWith(Environment.getExternalStorageDirectory().getCanonicalPath()) != null) {
                return Environment.getExternalStorageState();
            }
        } catch (File file2) {
            new StringBuilder("Failed to resolve canonical path: ").append(file2);
        }
        return "unknown";
    }

    private EnvironmentCompat() {
    }
}
