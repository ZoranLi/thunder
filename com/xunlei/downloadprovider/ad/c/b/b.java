package com.xunlei.downloadprovider.ad.c.b;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.ad.a;
import java.util.List;
import java.util.Locale;

/* compiled from: LocationModel */
public class b {
    private static final String b = "b";
    private static b c;
    public a a = null;

    private b() {
    }

    public static b a() {
        if (c == null) {
            c = new b();
        }
        return c;
    }

    public static void a(Location location) {
        location.getProvider();
        XLThreadPool.execute(new d(location.getLatitude(), location.getLongitude()));
    }

    private static List<Address> b(double d, double d2) {
        try {
            return new Geocoder(a.a(), Locale.getDefault()).getFromLocation(d, d2, 1);
        } catch (double d3) {
            d3.printStackTrace();
            return 0.0d;
        }
    }

    static /* synthetic */ String a(Context context, String str) {
        context = context.getSharedPreferences("init", 0);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(str, ""));
        return stringBuilder.toString();
    }
}
