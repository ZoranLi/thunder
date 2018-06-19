package mtopsdk.xstate.b;

import android.os.Build;
import android.os.Build.VERSION;
import com.alipay.sdk.util.h;
import com.umeng.message.proguard.k;
import mtopsdk.common.util.c;
import mtopsdk.common.util.j;

public final class a {
    private static c a = c.a();

    public static String a() {
        String str = "";
        try {
            String str2 = VERSION.RELEASE;
            String str3 = Build.MANUFACTURER;
            String str4 = Build.MODEL;
            StringBuilder stringBuilder = new StringBuilder("MTOPSDK/open_1.0.0");
            stringBuilder.append(" (");
            stringBuilder.append("Android");
            stringBuilder.append(h.b);
            stringBuilder.append(str2);
            stringBuilder.append(h.b);
            stringBuilder.append(str3);
            stringBuilder.append(h.b);
            stringBuilder.append(str4);
            stringBuilder.append(k.t);
            return stringBuilder.toString();
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("[getPhoneBaseInfo] error ---");
            stringBuilder2.append(th.toString());
            j.e(stringBuilder2.toString());
            return str;
        }
    }
}
