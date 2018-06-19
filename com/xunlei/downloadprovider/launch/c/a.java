package com.xunlei.downloadprovider.launch.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.umeng.message.MsgConstant;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.l;
import com.xunlei.downloadprovider.launch.e.c;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: LaunchPermissionsManager */
public final class a {
    public static final String[] a = new String[]{MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE, MsgConstant.PERMISSION_READ_PHONE_STATE};
    protected Activity b;
    private com.xunlei.downloadprovider.launch.c.a.a c = null;
    private int d = 0;
    private boolean e = false;
    private Handler f = new Handler(Looper.getMainLooper());
    private a g;

    /* compiled from: LaunchPermissionsManager */
    public interface a {
        void a();
    }

    public a(Activity activity, a aVar) {
        this.b = activity;
        this.g = aVar;
    }

    public static int a(Context context) {
        if (VERSION.SDK_INT >= 23) {
            for (String checkSelfPermission : a) {
                int checkSelfPermission2 = context.checkSelfPermission(checkSelfPermission);
                if (checkSelfPermission2 == -1) {
                    return -1;
                }
                if (checkSelfPermission2 != 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public final void a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (80000 == i) {
            int i2;
            this.e = false;
            this.d++;
            StringBuilder stringBuilder = new StringBuilder("onRequestLaunchPermissionsResult: ");
            stringBuilder.append(Arrays.toString(strArr));
            stringBuilder.append(Arrays.toString(iArr));
            if (iArr.length > null) {
                strArr = iArr.length;
                int i3 = 0;
                i2 = i3;
                while (i3 < strArr) {
                    if (iArr[i3] != 0) {
                        i2 = -1;
                    }
                    i3++;
                }
            } else {
                i2 = 0;
            }
            strArr = a(this.b);
            if (!(strArr == null && i2 == 0)) {
                c.a(false);
                this.f.postDelayed(new b(this, i2), 500);
            }
            if (strArr == null) {
                i = ThunderReport.getHubbleDeviceId(this.b);
                ThunderReport.forceUpdateBaseParams(this.b);
                strArr = HubbleEventBuilder.build("android_launch", "update_guid");
                iArr = "guid_old";
                if (i == 0) {
                    i = "";
                }
                strArr.addString(iArr, i);
                i = com.xunlei.downloadprovider.launch.e.a.a(BrothersApplication.getApplicationInstance().getApplicationContext());
                strArr.addString("file_imei", i.a == null ? "" : i.a);
                strArr.addString("file_mac", i.b == null ? "" : i.b);
                strArr.addString("file_guid", i.c == null ? "" : i.c);
                ThunderReport.reportEvent(strArr);
                c.a(true);
                if (this.g != 0) {
                    this.g.a();
                }
            }
        }
    }

    public final int a(int i, int i2) {
        int i3 = 0;
        if (VERSION.SDK_INT < 23) {
            a();
            return 0;
        }
        int i4;
        Context context = this.b;
        String[] strArr = a;
        ArrayList arrayList = new ArrayList(2);
        int i5 = -1;
        if (VERSION.SDK_INT >= 23) {
            for (String str : strArr) {
                int checkSelfPermission = context.checkSelfPermission(str);
                if (checkSelfPermission == -1 || checkSelfPermission != 0) {
                    arrayList.add(str);
                }
            }
        }
        int i6 = 1;
        if (arrayList.isEmpty()) {
            if (l.b()) {
                if (i == 0) {
                    if (this.d != 0 || i2 != 1) {
                        i6 = 0;
                    }
                }
                if (this.e == 0 && r3 != 0) {
                    a(a);
                }
            }
            i5 = 0;
        } else {
            String[] strArr2 = (String[]) arrayList.toArray(new String[arrayList.size()]);
            i2 = strArr2.length;
            int i7 = 0;
            i4 = i7;
            while (i7 < i2) {
                String str2 = strArr2[i7];
                if (VERSION.SDK_INT >= 23 && this.b.shouldShowRequestPermissionRationale(str2)) {
                    i4++;
                }
                i7++;
            }
            if (i4 > 0) {
                if (this.c == null || !this.c.isShowing()) {
                    this.c = null;
                    this.c = new com.xunlei.downloadprovider.launch.c.a.a(this.b, new c(this, arrayList));
                    this.c.a(new d(this, strArr2));
                    this.c.show();
                }
            } else if (this.d == 0) {
                if (this.e == 0) {
                    a(strArr2);
                }
            } else if (this.c == 0 || this.c.isShowing() == 0) {
                this.c = null;
                this.c = new com.xunlei.downloadprovider.launch.c.a.a(this.b, new e(this, arrayList));
                this.c.a(new f(this));
                this.c.show();
            }
            i3 = 1;
        }
        if (i3 == 0) {
            a();
        }
        return i5;
    }

    private void a() {
        if (this.c != null && this.c.isShowing()) {
            this.c.dismiss();
            this.c = null;
        }
    }

    private void a(String[] strArr) {
        if (VERSION.SDK_INT >= 23) {
            this.e = true;
            if (l.b()) {
                this.b.requestPermissions(a, 80000);
                new StringBuilder("requestLaunchPermissions: ").append(Arrays.toString(a));
            } else {
                this.b.requestPermissions(strArr, 80000);
                new StringBuilder("requestLaunchPermissions: ").append(Arrays.toString(strArr));
            }
            ThunderReport.reportEvent(HubbleEventBuilder.build("android_launch", "authority_alert"));
        }
    }
}
