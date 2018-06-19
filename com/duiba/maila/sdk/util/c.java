package com.duiba.maila.sdk.util;

import android.location.Location;

public final class c {
    private String a;
    private String b;
    private String c = String.valueOf(System.currentTimeMillis());

    public c(Location location) {
        this.a = String.valueOf(location.getLongitude());
        this.b = String.valueOf(location.getLatitude());
    }
}
