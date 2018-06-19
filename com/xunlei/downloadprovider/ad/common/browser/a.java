package com.xunlei.downloadprovider.ad.common.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.ad.common.report.ReportComponent.DeepLinkException;
import java.util.regex.Pattern;

/* compiled from: ADIntentUtils */
public final class a {
    private static final Pattern a = Pattern.compile("(?i)((?:http|https|ftp|file)://|(?:inline|data|about|javascript):)(.*)");
    private Activity b = null;

    public a(Activity activity) {
        this.b = activity;
    }

    public static void a(Context context, String str) throws DeepLinkException {
        Intent a = a(str);
        if (a(context.getPackageManager(), a)) {
            try {
                context.startActivity(a);
                return;
            } catch (Context context2) {
                context2.printStackTrace();
                throw new DeepLinkException(-1001);
            }
        }
        throw new DeepLinkException(-1002);
    }

    @NonNull
    public static Intent a(String str) throws DeepLinkException {
        try {
            str = Intent.parseUri(str, 1);
            str.setComponent(null);
            if (VERSION.SDK_INT >= 15) {
                str.setSelector(null);
            }
            str.setFlags(268435456);
            return str;
        } catch (String str2) {
            str2.printStackTrace();
            throw new DeepLinkException(-1000);
        }
    }

    private static boolean a(PackageManager packageManager, Intent intent) {
        return intent.resolveActivity(packageManager) != null ? true : null;
    }

    public static boolean a(PackageManager packageManager, String str) {
        try {
            return a(packageManager, a(str));
        } catch (PackageManager packageManager2) {
            packageManager2.printStackTrace();
            return null;
        }
    }

    public final boolean b(String str) throws DeepLinkException {
        if (c(str)) {
            return null;
        }
        a(this.b, str);
        return true;
    }

    public static boolean c(String str) {
        return a.matcher(str.toLowerCase()).matches() != null ? true : null;
    }
}
