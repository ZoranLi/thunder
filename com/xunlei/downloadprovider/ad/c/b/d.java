package com.xunlei.downloadprovider.ad.c.b;

import android.location.Address;
import com.google.gson.Gson;
import com.xunlei.downloadprovider.ad.a;
import java.util.List;

/* compiled from: LocationModel */
final class d implements Runnable {
    final /* synthetic */ double a;
    final /* synthetic */ double b;

    d(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public final void run() {
        List a = b.b(this.a, this.b);
        if (a != null && !a.isEmpty()) {
            Address address = (Address) a.get(0);
            b.b;
            new StringBuilder("address =").append(address);
            String adminArea = address.getAdminArea();
            String locality = address.getLocality();
            b.b;
            StringBuilder stringBuilder = new StringBuilder("hdz-location province: ");
            stringBuilder.append(adminArea);
            stringBuilder.append(" city: ");
            stringBuilder.append(locality);
            a aVar = new a(this.a, this.b, address.getCountryName(), adminArea, locality);
            b.a().a = aVar;
            a.a().getSharedPreferences("init", 0).edit().putString("ad_location_info", new Gson().toJson((Object) aVar)).apply();
        }
    }
}
