package com.xunlei.common.base.permission;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build.VERSION;
import com.xunlei.common.base.XLLog;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class XLAndroidPermissionManager {
    private static final int REQUEST_CODE_PERMISSION = 56;
    private static final int REQUEST_CODE_SETTING = 57;
    private static final String TAG = "AcpManager";
    private Activity mActivity;
    private XLAndroidPermissionListener mCallback;
    private Context mContext;
    private final List<String> mDeniedPermissions = new LinkedList();
    private final Set<String> mManifestPermissions = new HashSet(1);
    private XLAndroidPermissionOptions mOptions;
    private XLAndroidPermissionService mService;

    XLAndroidPermissionManager(Context context) {
        this.mContext = context;
        this.mService = new XLAndroidPermissionService();
        getManifestPermissions();
    }

    private synchronized void getManifestPermissions() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 4096);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo != null) {
            String[] strArr = packageInfo.requestedPermissions;
            if (strArr != null) {
                for (Object add : strArr) {
                    this.mManifestPermissions.add(add);
                }
            }
        }
    }

    private synchronized void checkSelfPermission() {
        this.mDeniedPermissions.clear();
        if (VERSION.SDK_INT < 23) {
            XLLog.i(TAG, "Build.VERSION.SDK_INT < Build.VERSION_CODES.M");
            if (this.mCallback != null) {
                this.mCallback.onGranted();
            }
            onDestroy();
            return;
        }
        for (String str : this.mOptions.getPermissions()) {
            if (this.mManifestPermissions.contains(str)) {
                int checkSelfPermission = this.mService.checkSelfPermission(this.mContext, str);
                String str2 = TAG;
                StringBuilder stringBuilder = new StringBuilder("checkSelfPermission = ");
                stringBuilder.append(checkSelfPermission);
                XLLog.i(str2, stringBuilder.toString());
                if (checkSelfPermission == -1) {
                    this.mDeniedPermissions.add(str);
                }
            }
        }
        if (this.mDeniedPermissions.isEmpty()) {
            XLLog.i(TAG, "mDeniedPermissions.isEmpty()");
            if (this.mCallback != null) {
                this.mCallback.onGranted();
            }
            onDestroy();
        } else if (isNotRequestPermission((String[]) this.mDeniedPermissions.toArray(new String[this.mDeniedPermissions.size()]))) {
            XLLog.i(TAG, "mDeniedPermissions.isNotRequestPermission");
            if (this.mCallback != null) {
                this.mCallback.onDenied(this.mDeniedPermissions);
            }
            onDestroy();
        } else {
            startAcpActivity();
        }
    }

    private synchronized void startAcpActivity() {
        Intent intent = new Intent(this.mContext, XLAndroidPermissionActivity.class);
        intent.addFlags(268435456);
        this.mContext.startActivity(intent);
    }

    private synchronized void showRationalDialog(final String[] strArr) {
        new Builder(this.mActivity).setMessage(this.mOptions.getRationalMessage()).setCancelable(false).setPositiveButton(this.mOptions.getRationalBtnText(), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                XLAndroidPermissionManager.this.requestPermissions(strArr);
            }
        }).show();
    }

    private synchronized void requestPermissions(String[] strArr) {
        this.mService.requestPermissions(this.mActivity, strArr, 56);
    }

    private synchronized void showDeniedDialog(final List<String> list) {
        new Builder(this.mActivity).setMessage(this.mOptions.getDeniedMessage()).setCancelable(false).setNegativeButton(this.mOptions.getDeniedCloseBtn(), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                if (XLAndroidPermissionManager.this.mCallback != null) {
                    XLAndroidPermissionManager.this.mCallback.onDenied(list);
                }
                XLAndroidPermissionManager.this.onDestroy();
            }
        }).setPositiveButton(this.mOptions.getDeniedSettingBtn(), new OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                XLAndroidPermissionManager.this.startSetting();
            }
        }).show();
    }

    private void onDestroy() {
        if (this.mActivity != null) {
            this.mActivity.finish();
            this.mActivity = null;
        }
        this.mCallback = null;
    }

    private void startSetting() {
        Intent settingIntent;
        if (XLAndroidPermissionMiuiOs.isMIUI()) {
            settingIntent = XLAndroidPermissionMiuiOs.getSettingIntent(this.mActivity);
            if (XLAndroidPermissionMiuiOs.isIntentAvailable(this.mActivity, settingIntent)) {
                this.mActivity.startActivityForResult(settingIntent, 57);
                return;
            }
        }
        try {
            settingIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            StringBuilder stringBuilder = new StringBuilder("package:");
            stringBuilder.append(this.mActivity.getPackageName());
            this.mActivity.startActivityForResult(settingIntent.setData(Uri.parse(stringBuilder.toString())), 57);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            try {
                this.mActivity.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 57);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private boolean isPermissionRequested(String str) {
        SharedPreferences sharedPreferences = this.mActivity.getApplicationContext().getSharedPreferences("xl-acc-pr-data", 0);
        if (sharedPreferences == null || sharedPreferences.getInt(str, 0) == null) {
            return false;
        }
        return true;
    }

    private void savePermissionRequestData(String str, int i) {
        Editor edit = this.mActivity.getApplicationContext().getSharedPreferences("xl-acc-pr-data", 0).edit();
        edit.putInt("version", 1001);
        edit.putInt(str, i);
        edit.apply();
    }

    private void savePermissionRequestData(String[] strArr, int[] iArr) {
        int i = 0;
        Editor edit = this.mActivity.getApplicationContext().getSharedPreferences("xl-acc-pr-data", 0).edit();
        edit.putInt("version", 1001);
        while (i < strArr.length) {
            edit.putInt(strArr[i], iArr[i]);
            i++;
        }
        edit.apply();
    }

    private boolean isNotRequestPermission(String[] strArr) {
        SharedPreferences sharedPreferences = this.mContext.getApplicationContext().getSharedPreferences("xl-acc-pr-data", 0);
        if (sharedPreferences == null) {
            return true;
        }
        boolean z = true;
        for (String str : strArr) {
            z = z && sharedPreferences.getInt(str, 0) == 2;
        }
        return z;
    }

    synchronized void request(XLAndroidPermissionOptions xLAndroidPermissionOptions, XLAndroidPermissionListener xLAndroidPermissionListener) {
        this.mCallback = xLAndroidPermissionListener;
        this.mOptions = xLAndroidPermissionOptions;
        checkSelfPermission();
    }

    synchronized void checkRequestPermissionRationale(Activity activity) {
        this.mActivity = activity;
        int[] iArr = new int[this.mDeniedPermissions.size()];
        boolean z = false;
        boolean z2 = z;
        int i = z2;
        for (String str : this.mDeniedPermissions) {
            boolean isPermissionRequested;
            int i2;
            boolean shouldShowRequestPermissionRationale = this.mService.shouldShowRequestPermissionRationale(this.mActivity, str);
            if (!z) {
                if (!shouldShowRequestPermissionRationale) {
                    z = false;
                    isPermissionRequested = isPermissionRequested(str);
                    if (!z2) {
                        if (isPermissionRequested) {
                            z2 = false;
                            if (isPermissionRequested || shouldShowRequestPermissionRationale) {
                                i2 = i + 1;
                                iArr[i] = 1;
                            } else {
                                i2 = i + 1;
                                iArr[i] = 2;
                            }
                            i = i2;
                        }
                    }
                    z2 = true;
                    if (isPermissionRequested) {
                    }
                    i2 = i + 1;
                    iArr[i] = 1;
                    i = i2;
                }
            }
            z = true;
            isPermissionRequested = isPermissionRequested(str);
            if (z2) {
                if (isPermissionRequested) {
                    z2 = false;
                    if (isPermissionRequested) {
                    }
                    i2 = i + 1;
                    iArr[i] = 1;
                    i = i2;
                }
            }
            z2 = true;
            if (isPermissionRequested) {
            }
            i2 = i + 1;
            iArr[i] = 1;
            i = i2;
        }
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder("rationale = ");
        stringBuilder.append(z);
        XLLog.i(str2, stringBuilder.toString());
        String[] strArr = (String[]) this.mDeniedPermissions.toArray(new String[this.mDeniedPermissions.size()]);
        savePermissionRequestData(strArr, iArr);
        if (!z2 || z) {
            requestPermissions(strArr);
            return;
        }
        if (this.mCallback != null) {
            this.mCallback.onDenied(this.mDeniedPermissions);
        }
        onDestroy();
    }

    synchronized void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 56) {
            i = new LinkedList();
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                Object obj = strArr[i2];
                if (iArr[i2] == 0) {
                    i.add(obj);
                } else {
                    linkedList.add(obj);
                }
            }
            if (i.isEmpty() != 0 || linkedList.isEmpty() == 0) {
                if (this.mCallback != 0) {
                    this.mCallback.onDenied(linkedList);
                }
            } else if (this.mCallback != 0) {
                this.mCallback.onGranted();
            }
            onDestroy();
        }
    }

    synchronized void onActivityResult(int i, int i2, Intent intent) {
        if (!(this.mCallback == 0 || this.mOptions == 0)) {
            if (i == 57) {
                checkSelfPermission();
                return;
            }
        }
        onDestroy();
    }
}
