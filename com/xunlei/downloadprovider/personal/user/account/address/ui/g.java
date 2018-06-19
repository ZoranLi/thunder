package com.xunlei.downloadprovider.personal.user.account.address.ui;

import android.location.Address;
import android.os.Bundle;
import android.os.Message;
import com.xunlei.downloadprovider.personal.user.account.m;
import java.util.List;

/* compiled from: UserRegionSelectProvinceActivity */
final class g implements Runnable {
    final /* synthetic */ double a;
    final /* synthetic */ double b;
    final /* synthetic */ UserRegionSelectProvinceActivity c;

    g(UserRegionSelectProvinceActivity userRegionSelectProvinceActivity, double d, double d2) {
        this.c = userRegionSelectProvinceActivity;
        this.a = d;
        this.b = d2;
    }

    public final void run() {
        String str;
        List a = this.c.a(this.a, this.b);
        String str2 = null;
        if (a == null || a.isEmpty()) {
            str = null;
        } else {
            Address address = (Address) a.get(0);
            new StringBuilder("address =").append(address);
            str2 = address.getAdminArea();
            str = m.a() ? address.getSubAdminArea() : address.getLocality();
        }
        Message obtain = Message.obtain();
        obtain.what = 1338;
        Bundle bundle = new Bundle(2);
        bundle.putString("extra_latitude", str2);
        bundle.putString("extra_longitude", str);
        obtain.setData(bundle);
        this.c.a.sendMessage(obtain);
    }
}
