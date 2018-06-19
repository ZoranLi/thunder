package com.getui.gis.sdk.a;

import android.content.Context;
import com.xiaomi.push.service.av;
import java.io.InputStream;
import java.util.Properties;

public class a {
    private static a b;
    private boolean a = false;

    private a(Context context) {
        InputStream open;
        Properties properties = null;
        try {
            open = context.getAssets().open("gtc.config.properties");
        } catch (Throwable th) {
            com.getui.gis.sdk.b.a.a(th);
            open = null;
        }
        if (open != null) {
            try {
                Properties properties2 = new Properties();
                properties2.load(open);
                properties = properties2;
            } catch (Throwable th2) {
                com.getui.gis.sdk.b.a.a(th2);
            }
            if (properties != null) {
                try {
                    this.a = Boolean.parseBoolean(properties.getProperty("all_file_log", av.b));
                } catch (Throwable th22) {
                    com.getui.gis.sdk.b.a.a(th22);
                }
            }
        }
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
        return b;
    }

    public void a() {
        b.b = this.a;
    }
}
