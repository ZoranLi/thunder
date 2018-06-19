package com.qq.e.comm.managers.status;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

class DeviceStatus$1 implements LocationListener {
    private /* synthetic */ LocationManager a;
    private /* synthetic */ DeviceStatus b;

    DeviceStatus$1(DeviceStatus deviceStatus, LocationManager locationManager) {
        this.b = deviceStatus;
        this.a = locationManager;
    }

    public void onLocationChanged(android.location.Location r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.b;	 Catch:{ Throwable -> 0x002f }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002f }
        r1.<init>();	 Catch:{ Throwable -> 0x002f }
        r2 = r5.getLatitude();	 Catch:{ Throwable -> 0x002f }
        r1.append(r2);	 Catch:{ Throwable -> 0x002f }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x002f }
        com.qq.e.comm.managers.status.DeviceStatus.a(r0, r1);	 Catch:{ Throwable -> 0x002f }
        r0 = r4.b;	 Catch:{ Throwable -> 0x002f }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x002f }
        r1.<init>();	 Catch:{ Throwable -> 0x002f }
        r2 = r5.getLongitude();	 Catch:{ Throwable -> 0x002f }
        r1.append(r2);	 Catch:{ Throwable -> 0x002f }
        r5 = r1.toString();	 Catch:{ Throwable -> 0x002f }
        com.qq.e.comm.managers.status.DeviceStatus.b(r0, r5);	 Catch:{ Throwable -> 0x002f }
        r5 = r4.a;	 Catch:{ Throwable -> 0x002f }
        r5.removeUpdates(r4);	 Catch:{ Throwable -> 0x002f }
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.status.DeviceStatus$1.onLocationChanged(android.location.Location):void");
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
