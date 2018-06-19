package com.xunlei.downloadprovider.personal.user.account.address.ui;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.common.commonview.TitleBar;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BaseActivity;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.k;
import com.xunlei.downloadprovider.personal.user.account.address.a.f;
import com.xunlei.downloadprovider.personal.user.account.address.b.d;
import com.xunlei.downloadprovider.personal.user.account.address.c.a;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.xllib.android.b;
import java.util.List;
import java.util.Locale;

public class UserRegionSelectProvinceActivity extends BaseActivity implements LocationListener {
    private static boolean k;
    StaticHandler a = new StaticHandler(new i(this));
    private RecyclerView c;
    private TextView d;
    private List<a> e;
    private f f;
    private LoginHelper g = LoginHelper.a();
    private k h;
    private String i;
    private String j;
    private boolean l = false;
    private LocationManager m;

    public void onProviderEnabled(String str) {
    }

    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT < 23 || k != null) {
            k = true;
            b();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1337);
        }
        if (b.a(getApplicationContext()) != null) {
            m.a(getApplicationContext());
        }
        this.e = d.a().c();
        setContentView(R.layout.activity_user_region_select);
        bundle = new TitleBar((Activity) this);
        bundle.mTitle.setText(getResources().getString(R.string.user_account_item_name_address));
        bundle.mRight1.setVisibility(0);
        bundle = this.e;
        if (this.e != null) {
            this.c = (RecyclerView) findViewById(R.id.rcv_user_account_address);
            this.c.setLayoutManager(new LinearLayoutManager(this));
            this.f = new f(getApplicationContext(), bundle);
            this.c.setAdapter(this.f);
            bundle = LayoutInflater.from(this).inflate(R.layout.user_item_region_header, null);
            this.d = (TextView) bundle.findViewById(R.id.tv_user_location);
            this.f.a((View) bundle);
        }
        if (this.c != null) {
            this.c.addOnItemTouchListener(new a(this.c, new e(this)));
        }
    }

    protected void onResume() {
        super.onResume();
        a();
    }

    protected void onStart() {
        super.onStart();
    }

    protected void onDestroy() {
        super.onDestroy();
        d.d();
        this.g.b(this.h);
        if (this.m != null) {
            this.m.removeUpdates(this);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        com.xunlei.downloadprovider.personal.user.account.k.c("cancel");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
        r7 = this;
        r0 = r7.getApplicationContext();
        r0 = com.xunlei.xllib.android.b.a(r0);
        if (r0 == 0) goto L_0x006b;
    L_0x000a:
        r0 = r7.getApplicationContext();
        r0 = com.xunlei.downloadprovider.personal.user.account.m.a(r0);
        if (r0 == 0) goto L_0x0067;
    L_0x0014:
        r0 = k;
        if (r0 == 0) goto L_0x0067;
    L_0x0018:
        r0 = "location";
        r0 = r7.getSystemService(r0);
        r0 = (android.location.LocationManager) r0;
        r7.m = r0;
        r0 = r7.m;
        if (r0 == 0) goto L_0x0066;
    L_0x0026:
        r0 = r7.m;
        r1 = "network";
        r0 = r0.getProvider(r1);
        if (r0 != 0) goto L_0x003f;
    L_0x0030:
        r0 = r7.m;
        r1 = "gps";
        r0 = r0.getProvider(r1);
        if (r0 == 0) goto L_0x003b;
    L_0x003a:
        goto L_0x003f;
    L_0x003b:
        r7.b();
        goto L_0x0066;
    L_0x003f:
        r0 = 1;
        r1 = new java.lang.String[r0];
        r2 = "android.permission.ACCESS_FINE_LOCATION";
        r3 = 0;
        r1[r3] = r2;
        r1 = com.xunlei.downloadprovider.ad.c.b.g.a(r7, r1);
        if (r1 != 0) goto L_0x0059;
    L_0x004d:
        r0 = new java.lang.String[r0];
        r1 = "android.permission.ACCESS_COARSE_LOCATION";
        r0[r3] = r1;
        r0 = com.xunlei.downloadprovider.ad.c.b.g.a(r7, r0);
        if (r0 == 0) goto L_0x0066;
    L_0x0059:
        r1 = r7.m;
        r2 = "network";
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r6 = r7;
        r1.requestLocationUpdates(r2, r3, r5, r6);
        return;
    L_0x0066:
        return;
    L_0x0067:
        r7.b();
        return;
    L_0x006b:
        r7.b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.personal.user.account.address.ui.UserRegionSelectProvinceActivity.a():void");
    }

    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i == 1337) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                b();
            } else {
                k = true;
                a();
            }
        }
    }

    public void onLocationChanged(Location location) {
        XLThreadPool.execute(new g(this, location.getLatitude(), location.getLongitude()));
    }

    private void b() {
        if (!this.l) {
            LoginHelper.a().a(new h(this));
        }
    }

    public void onProviderDisabled(String str) {
        b();
    }

    private List<Address> a(double d, double d2) {
        try {
            return new Geocoder(this, Locale.getDefault()).getFromLocation(d, d2, 1);
        } catch (double d3) {
            d3.printStackTrace();
            b();
            return 0.0d;
        }
    }

    static /* synthetic */ void d(UserRegionSelectProvinceActivity userRegionSelectProvinceActivity) {
        userRegionSelectProvinceActivity.h = new f(userRegionSelectProvinceActivity);
        userRegionSelectProvinceActivity.g.a(userRegionSelectProvinceActivity.h);
    }

    static /* synthetic */ void a(UserRegionSelectProvinceActivity userRegionSelectProvinceActivity, String str, String str2) {
        if (str2 == null || str == null) {
            userRegionSelectProvinceActivity.b();
            return;
        }
        userRegionSelectProvinceActivity.j = str2;
        new StringBuilder("locality = ").append(userRegionSelectProvinceActivity.j);
        if (str.contains("省")) {
            str = str.substring(0, str.length() - 1);
            userRegionSelectProvinceActivity.i = str;
        }
        if (str2.contains("市")) {
            str2 = str2.substring(0, str2.length() - 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        str = stringBuilder.toString();
        str2 = ResourcesCompat.getDrawable(userRegionSelectProvinceActivity.getResources(), R.drawable.user_location_success_icon, null);
        if (str2 != null) {
            str2.setBounds(0, 0, str2.getMinimumWidth(), str2.getMinimumHeight());
            userRegionSelectProvinceActivity.d.setCompoundDrawables(str2, null, null, null);
            userRegionSelectProvinceActivity.d.setText(str);
        }
    }
}
