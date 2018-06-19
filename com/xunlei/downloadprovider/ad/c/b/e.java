package com.xunlei.downloadprovider.ad.c.b;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LocationProvider */
public class e implements LocationListener, com.xunlei.downloadprovider.ad.c.b.g.a {
    private static final String b = "e";
    private static final String[] e = new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    public a a = null;
    private LocationManager c = null;
    private Object d = null;

    /* compiled from: LocationProvider */
    public interface a {
        void a();

        void a(Location location);
    }

    public void onProviderDisabled(String str) {
    }

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public final void a() {
        this.c = (LocationManager) a(this.d).getSystemService("location");
    }

    public e(@NonNull Activity activity) {
        this.d = activity;
    }

    public e(@NonNull Fragment fragment) {
        this.d = fragment;
    }

    private static Activity a(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return obj instanceof Fragment ? ((Fragment) obj).getActivity() : null;
    }

    public final void a(List<String> list) {
        for (Object contains : e) {
            if (!list.contains(contains)) {
                b(false);
                break;
            }
        }
        b(true);
        f.a("sure");
    }

    public final void b() {
        a(1000, "onPermissionsDenied");
        f.a("cancel");
    }

    public final void c() {
        a(1002, "onPermissionRequestRejected");
        f.a("cancel");
    }

    public final void a(boolean z) {
        if (g.a(a(this.d), e)) {
            e();
        } else if (z) {
            Object obj = this.d;
            String[] strArr = e;
            g.a(obj);
            int length = strArr.length;
            int i = 0;
            int i2 = i;
            while (i < length) {
                String str = strArr[i];
                if (i2 == 0) {
                    boolean shouldShowRequestPermissionRationale = obj instanceof Activity ? ActivityCompat.shouldShowRequestPermissionRationale((Activity) obj, str) : obj instanceof Fragment ? ((Fragment) obj).shouldShowRequestPermissionRationale(str) : false;
                    if (!shouldShowRequestPermissionRationale) {
                        i2 = false;
                        i++;
                    }
                }
                i2 = 1;
                i++;
            }
            if (i2 == 0 || TextUtils.isEmpty(null)) {
                g.a(obj, strArr);
            } else {
                Context activity = obj instanceof Activity ? (Activity) obj : obj instanceof Fragment ? ((Fragment) obj).getActivity() : null;
                XLAlertDialog xLAlertDialog = new XLAlertDialog(activity);
                xLAlertDialog.setTitle(null);
                xLAlertDialog.setCancelable(false);
                xLAlertDialog.setOnClickConfirmButtonListener(new h(obj, strArr));
                xLAlertDialog.setOnClickCancelButtonListener(new i(this));
                xLAlertDialog.show();
            }
            StatEvent build = HubbleEventBuilder.build("android_alert", "alert_location_pop_show");
            build.add("from", "youliao");
            f.a(build);
        } else {
            a(true, "no permission");
        }
    }

    private void b(boolean z) {
        if (z) {
            e();
        } else {
            a(true, "locationPermissionGranted but no permission");
        }
    }

    public final void a(int i, String[] strArr, int[] iArr) {
        Object obj = this.d;
        if (i == 23) {
            g.a(obj);
            i = new ArrayList();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                Object obj2 = strArr[i2];
                if (iArr[i2] == 0) {
                    i.add(obj2);
                } else {
                    arrayList.add(obj2);
                }
            }
            if (i.isEmpty() == null) {
                a(i);
            }
            if (arrayList.isEmpty() == 0) {
                b();
            }
        }
    }

    public void onLocationChanged(Location location) {
        StringBuilder stringBuilder = new StringBuilder("hdz-location onLocationChanged lat: ");
        stringBuilder.append(location.getLatitude());
        stringBuilder.append(" lon: ");
        stringBuilder.append(location.getLongitude());
        stringBuilder = new StringBuilder("Latitude:");
        stringBuilder.append(location.getLatitude());
        stringBuilder.append(",Longitude:");
        stringBuilder.append(location.getLongitude());
        ThunderReport.setShouleiLocation(stringBuilder.toString());
        if (this.a != null) {
            this.a.a(location);
        }
    }

    private void a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("onLocationFailCallback. errorCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" errorMsg: ");
        stringBuilder.append(str);
        if (this.a != 0) {
            this.a.a();
        }
    }

    private void e() {
        try {
            if (g.a(a(this.d), e)) {
                if (this.c != null) {
                    try {
                        Criteria criteria = new Criteria();
                        criteria.setAccuracy(2);
                        criteria.setHorizontalAccuracy(2);
                        criteria.setVerticalAccuracy(2);
                        criteria.setBearingAccuracy(2);
                        criteria.setSpeedAccuracy(2);
                        criteria.setPowerRequirement(2);
                        this.c.requestSingleUpdate(criteria, this, null);
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        boolean isProviderEnabled = this.c.isProviderEnabled("gps");
                        if (this.c.isProviderEnabled("network")) {
                            this.c.requestSingleUpdate("network", this, null);
                            return;
                        } else if (isProviderEnabled) {
                            this.c.requestSingleUpdate("gps", this, null);
                            return;
                        } else {
                            a(1001, "任何provider都不能使用");
                        }
                    }
                }
                return;
            }
            a(1000, "没有获取全部定位权限");
        } catch (Exception e2) {
            a(-1, e2.getLocalizedMessage());
            e2.printStackTrace();
        }
    }

    public final void d() {
        if (this.c != null && g.a(a(this.d), e)) {
            this.c.removeUpdates(this);
        }
    }
}
