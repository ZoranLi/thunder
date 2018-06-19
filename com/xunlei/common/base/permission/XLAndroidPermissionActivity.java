package com.xunlei.common.base.permission;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class XLAndroidPermissionActivity extends FragmentActivity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(16);
        if (bundle == null) {
            XLAndroidPermission.getInstance(this).getAcpManager().checkRequestPermissionRationale(this);
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        XLAndroidPermission.getInstance(this).getAcpManager().checkRequestPermissionRationale(this);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        XLAndroidPermission.getInstance(this).getAcpManager().onRequestPermissionsResult(i, strArr, iArr);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        XLAndroidPermission.getInstance(this).getAcpManager().onActivityResult(i, i2, intent);
    }
}
