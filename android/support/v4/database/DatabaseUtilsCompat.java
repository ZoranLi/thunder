package android.support.v4.database;

import android.text.TextUtils;
import com.umeng.message.proguard.k;

public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    public static String concatenateWhere(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder(k.s);
        stringBuilder.append(str);
        stringBuilder.append(") AND (");
        stringBuilder.append(str2);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    public static String[] appendSelectionArgs(String[] strArr, String[] strArr2) {
        if (strArr != null) {
            if (strArr.length != 0) {
                Object obj = new String[(strArr.length + strArr2.length)];
                System.arraycopy(strArr, 0, obj, 0, strArr.length);
                System.arraycopy(strArr2, 0, obj, strArr.length, strArr2.length);
                return obj;
            }
        }
        return strArr2;
    }
}
