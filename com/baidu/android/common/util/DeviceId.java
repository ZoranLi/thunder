package com.baidu.android.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.security.AESUtil;
import com.baidu.android.common.security.Base64;
import com.baidu.android.common.security.MD5Util;
import com.baidu.android.common.security.SHA1Util;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.security.PublicKey;
import java.util.List;
import java.util.UUID;
import javax.crypto.Cipher;
import org.json.JSONObject;

public final class DeviceId {
    private static final String ACTION_GLAXY_CUID = "com.baidu.intent.action.GALAXY";
    private static final String AES_KEY = "30212102dicudiab";
    private static final boolean DEBUG = false;
    private static final String DEFAULT_TM_DEVICEID = "";
    private static final String EXT_DIR = "backups/.SystemConfig";
    private static final String EXT_FILE = ".cuid";
    private static final String EXT_FILE_V2 = ".cuid2";
    private static final String KEY_DEVICE_ID = "com.baidu.deviceid";
    private static final String KEY_DEVICE_ID_V2 = "com.baidu.deviceid.v2";
    private static final String KEY_IMEI = "bd_setting_i";
    private static final String META_KEY_GALAXY_SF = "galaxy_sf";
    private static final String META_KEY_GLAXY_DATA = "galaxy_data";
    private static final String OLD_EXT_DIR = "baidu";
    private static final String RSA_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final int SDK_ANDROID_M = 23;
    private static final String SELF_CUID_FILE = "libcuid.so";
    private static final int STORAGE_SDCARD_V1 = 4;
    private static final int STORAGE_SDCARD_V2 = 8;
    private static final int STORAGE_SELF_FILE = 16;
    private static final int STORAGE_SYSTEM_SETTING_V1 = 1;
    private static final int STORAGE_SYSTEM_SETTING_V2 = 2;
    private static final String TAG = "DeviceId";
    private static CUIDInfo sCachedCuidInfo;
    private final Context mContext;
    private PublicKey mPublicKey;
    private int mSaveMask = 0;

    private static class CUIDBuddyInfo {
        public ApplicationInfo appInfo;
        public boolean isSelf;
        public int priority;
        public boolean sigMatched;

        private CUIDBuddyInfo() {
            this.priority = 0;
            this.sigMatched = false;
            this.isSelf = false;
        }
    }

    private static class CUIDInfo {
        private static final int VERSION = 2;
        public String deviceId;
        public String imei;
        public int version;

        private CUIDInfo() {
            this.version = 2;
        }

        public static CUIDInfo createFromJson(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                Object string = jSONObject.getString("deviceid");
                String string2 = jSONObject.getString("imei");
                int i = jSONObject.getInt("ver");
                if (!(TextUtils.isEmpty(string) || string2 == null)) {
                    CUIDInfo cUIDInfo = new CUIDInfo();
                    cUIDInfo.deviceId = string;
                    cUIDInfo.imei = string2;
                    cUIDInfo.version = i;
                    return cUIDInfo;
                }
            } catch (Throwable e) {
                DeviceId.handleThrowable(e);
            }
            return null;
        }

        public String getFinalCUID() {
            String str = this.imei;
            if (TextUtils.isEmpty(str)) {
                str = "0";
            }
            str = new StringBuffer(str).reverse().toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.deviceId);
            stringBuilder.append("|");
            stringBuilder.append(str);
            return stringBuilder.toString();
        }

        public String toPersitString() {
            try {
                return new JSONObject().put("deviceid", this.deviceId).put("imei", this.imei).put("ver", this.version).toString();
            } catch (Throwable e) {
                DeviceId.handleThrowable(e);
                return null;
            }
        }
    }

    private DeviceId(Context context) {
        this.mContext = context.getApplicationContext();
        initPublicKey();
    }

    private static String byte2hex(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("Argument b ( byte array ) is null! ");
        }
        String str = "";
        for (byte b : bArr) {
            StringBuilder stringBuilder;
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                str = "0";
            } else {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(str);
            stringBuilder.append(toHexString);
            str = stringBuilder.toString();
        }
        return str.toLowerCase();
    }

    private boolean checkSelfPermission(String str) {
        return this.mContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }

    private java.util.List<com.baidu.android.common.util.DeviceId.CUIDBuddyInfo> collectBuddyInfos(android.content.Intent r13, boolean r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r12 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r12.mContext;
        r1 = r1.getPackageManager();
        r2 = 0;
        r13 = r1.queryBroadcastReceivers(r13, r2);
        if (r13 == 0) goto L_0x00f3;
    L_0x0012:
        r13 = r13.iterator();
    L_0x0016:
        r3 = r13.hasNext();
        if (r3 == 0) goto L_0x00f3;
    L_0x001c:
        r3 = r13.next();
        r3 = (android.content.pm.ResolveInfo) r3;
        r4 = r3.activityInfo;
        if (r4 == 0) goto L_0x0016;
    L_0x0026:
        r4 = r3.activityInfo;
        r4 = r4.applicationInfo;
        if (r4 == 0) goto L_0x0016;
    L_0x002c:
        r4 = new android.content.ComponentName;	 Catch:{ Exception -> 0x0016 }
        r5 = r3.activityInfo;	 Catch:{ Exception -> 0x0016 }
        r5 = r5.packageName;	 Catch:{ Exception -> 0x0016 }
        r6 = r3.activityInfo;	 Catch:{ Exception -> 0x0016 }
        r6 = r6.name;	 Catch:{ Exception -> 0x0016 }
        r4.<init>(r5, r6);	 Catch:{ Exception -> 0x0016 }
        r5 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0016 }
        r4 = r1.getReceiverInfo(r4, r5);	 Catch:{ Exception -> 0x0016 }
        r4 = r4.metaData;	 Catch:{ Exception -> 0x0016 }
        if (r4 != 0) goto L_0x0044;	 Catch:{ Exception -> 0x0016 }
    L_0x0043:
        goto L_0x0016;	 Catch:{ Exception -> 0x0016 }
    L_0x0044:
        r5 = "galaxy_data";	 Catch:{ Exception -> 0x0016 }
        r5 = r4.getString(r5);	 Catch:{ Exception -> 0x0016 }
        r6 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x0016 }
        if (r6 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x0016 }
    L_0x0050:
        goto L_0x0016;	 Catch:{ Exception -> 0x0016 }
    L_0x0051:
        r6 = "utf-8";	 Catch:{ Exception -> 0x0016 }
        r5 = r5.getBytes(r6);	 Catch:{ Exception -> 0x0016 }
        r5 = com.baidu.android.common.security.Base64.decode(r5);	 Catch:{ Exception -> 0x0016 }
        r6 = new java.lang.String;	 Catch:{ Exception -> 0x0016 }
        r6.<init>(r5);	 Catch:{ Exception -> 0x0016 }
        r7 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0016 }
        r7.<init>(r6);	 Catch:{ Exception -> 0x0016 }
        r6 = new com.baidu.android.common.util.DeviceId$CUIDBuddyInfo;	 Catch:{ Exception -> 0x0016 }
        r8 = 0;	 Catch:{ Exception -> 0x0016 }
        r6.<init>();	 Catch:{ Exception -> 0x0016 }
        r8 = "priority";	 Catch:{ Exception -> 0x0016 }
        r8 = r7.getInt(r8);	 Catch:{ Exception -> 0x0016 }
        r6.priority = r8;	 Catch:{ Exception -> 0x0016 }
        r8 = r3.activityInfo;	 Catch:{ Exception -> 0x0016 }
        r8 = r8.applicationInfo;	 Catch:{ Exception -> 0x0016 }
        r6.appInfo = r8;	 Catch:{ Exception -> 0x0016 }
        r8 = r12.mContext;	 Catch:{ Exception -> 0x0016 }
        r8 = r8.getPackageName();	 Catch:{ Exception -> 0x0016 }
        r9 = r3.activityInfo;	 Catch:{ Exception -> 0x0016 }
        r9 = r9.applicationInfo;	 Catch:{ Exception -> 0x0016 }
        r9 = r9.packageName;	 Catch:{ Exception -> 0x0016 }
        r8 = r8.equals(r9);	 Catch:{ Exception -> 0x0016 }
        r9 = 1;	 Catch:{ Exception -> 0x0016 }
        if (r8 == 0) goto L_0x008e;	 Catch:{ Exception -> 0x0016 }
    L_0x008c:
        r6.isSelf = r9;	 Catch:{ Exception -> 0x0016 }
    L_0x008e:
        if (r14 == 0) goto L_0x00ee;	 Catch:{ Exception -> 0x0016 }
    L_0x0090:
        r8 = "galaxy_sf";	 Catch:{ Exception -> 0x0016 }
        r4 = r4.getString(r8);	 Catch:{ Exception -> 0x0016 }
        r8 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x0016 }
        if (r8 != 0) goto L_0x00ee;	 Catch:{ Exception -> 0x0016 }
    L_0x009c:
        r3 = r3.activityInfo;	 Catch:{ Exception -> 0x0016 }
        r3 = r3.applicationInfo;	 Catch:{ Exception -> 0x0016 }
        r3 = r3.packageName;	 Catch:{ Exception -> 0x0016 }
        r8 = 64;	 Catch:{ Exception -> 0x0016 }
        r3 = r1.getPackageInfo(r3, r8);	 Catch:{ Exception -> 0x0016 }
        r8 = "sigs";	 Catch:{ Exception -> 0x0016 }
        r7 = r7.getJSONArray(r8);	 Catch:{ Exception -> 0x0016 }
        r8 = r7.length();	 Catch:{ Exception -> 0x0016 }
        r8 = new java.lang.String[r8];	 Catch:{ Exception -> 0x0016 }
        r10 = r2;	 Catch:{ Exception -> 0x0016 }
    L_0x00b5:
        r11 = r8.length;	 Catch:{ Exception -> 0x0016 }
        if (r10 >= r11) goto L_0x00c1;	 Catch:{ Exception -> 0x0016 }
    L_0x00b8:
        r11 = r7.getString(r10);	 Catch:{ Exception -> 0x0016 }
        r8[r10] = r11;	 Catch:{ Exception -> 0x0016 }
        r10 = r10 + 1;	 Catch:{ Exception -> 0x0016 }
        goto L_0x00b5;	 Catch:{ Exception -> 0x0016 }
    L_0x00c1:
        r3 = r3.signatures;	 Catch:{ Exception -> 0x0016 }
        r3 = r12.formatAndroidSigArray(r3);	 Catch:{ Exception -> 0x0016 }
        r3 = r12.isSigsEqual(r8, r3);	 Catch:{ Exception -> 0x0016 }
        if (r3 == 0) goto L_0x00ee;	 Catch:{ Exception -> 0x0016 }
    L_0x00cd:
        r3 = r4.getBytes();	 Catch:{ Exception -> 0x0016 }
        r3 = com.baidu.android.common.security.Base64.decode(r3);	 Catch:{ Exception -> 0x0016 }
        r4 = r12.mPublicKey;	 Catch:{ Exception -> 0x0016 }
        r3 = decryptByPublicKey(r3, r4);	 Catch:{ Exception -> 0x0016 }
        r4 = com.baidu.android.common.security.SHA1Util.sha1(r5);	 Catch:{ Exception -> 0x0016 }
        if (r3 == 0) goto L_0x00e9;	 Catch:{ Exception -> 0x0016 }
    L_0x00e1:
        r3 = java.util.Arrays.equals(r3, r4);	 Catch:{ Exception -> 0x0016 }
        if (r3 == 0) goto L_0x00e9;	 Catch:{ Exception -> 0x0016 }
    L_0x00e7:
        r3 = r9;	 Catch:{ Exception -> 0x0016 }
        goto L_0x00ea;	 Catch:{ Exception -> 0x0016 }
    L_0x00e9:
        r3 = r2;	 Catch:{ Exception -> 0x0016 }
    L_0x00ea:
        if (r3 == 0) goto L_0x00ee;	 Catch:{ Exception -> 0x0016 }
    L_0x00ec:
        r6.sigMatched = r9;	 Catch:{ Exception -> 0x0016 }
    L_0x00ee:
        r0.add(r6);	 Catch:{ Exception -> 0x0016 }
        goto L_0x0016;
    L_0x00f3:
        r13 = new com.baidu.android.common.util.DeviceId$1;
        r13.<init>();
        java.util.Collections.sort(r0, r13);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.util.DeviceId.collectBuddyInfos(android.content.Intent, boolean):java.util.List<com.baidu.android.common.util.DeviceId$CUIDBuddyInfo>");
    }

    private static byte[] decryptByPublicKey(byte[] bArr, PublicKey publicKey) throws Exception {
        Cipher instance = Cipher.getInstance(RSA_ALGORITHM);
        instance.init(2, publicKey);
        return instance.doFinal(bArr);
    }

    private static String decryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(str.getBytes())));
        } catch (Throwable e) {
            handleThrowable(e);
            return "";
        }
    }

    private static String encryptCUIDInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Base64.encode(AESUtil.encrypt(AES_KEY, AES_KEY, str.getBytes()), "utf-8");
        } catch (Throwable e) {
            handleThrowable(e);
            return "";
        }
    }

    private String[] formatAndroidSigArray(Signature[] signatureArr) {
        String[] strArr = new String[signatureArr.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = byte2hex(SHA1Util.sha1(signatureArr[i].toByteArray()));
        }
        return strArr;
    }

    public static String getAndroidId(Context context) {
        Object string = Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public static String getCUID(Context context) {
        return getOrCreateCUIDInfo(context).getFinalCUID();
    }

    private CUIDInfo getCUIDInfo() {
        boolean z;
        int i;
        File file;
        String str;
        CUIDInfo createFromJson;
        List<CUIDBuddyInfo> collectBuddyInfos;
        String str2;
        File filesDir;
        File file2;
        boolean checkSelfPermission;
        String str3;
        String androidId;
        File file3;
        File file4;
        List collectBuddyInfos2 = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID).setPackage(this.mContext.getPackageName()), true);
        int i2 = 0;
        if (collectBuddyInfos2 != null) {
            if (collectBuddyInfos2.size() != 0) {
                CUIDBuddyInfo cUIDBuddyInfo = (CUIDBuddyInfo) collectBuddyInfos2.get(0);
                z = cUIDBuddyInfo.sigMatched;
                if (!cUIDBuddyInfo.sigMatched) {
                    for (i = 0; i < 3; i++) {
                        Log.w(TAG, "galaxy config err, In the release version of the signature should be matched");
                    }
                }
                file = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
                str = null;
                createFromJson = file.exists() ? CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file))) : null;
                if (createFromJson == null) {
                    this.mSaveMask |= 16;
                    collectBuddyInfos = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID), z);
                    if (collectBuddyInfos != null) {
                        str2 = "files";
                        filesDir = this.mContext.getFilesDir();
                        if (!str2.equals(filesDir.getName())) {
                            str2 = TAG;
                            StringBuilder stringBuilder = new StringBuilder("fetal error:: app files dir name is unexpectedly :: ");
                            stringBuilder.append(filesDir.getAbsolutePath());
                            Log.e(str2, stringBuilder.toString());
                            str2 = filesDir.getName();
                        }
                        for (CUIDBuddyInfo cUIDBuddyInfo2 : collectBuddyInfos) {
                            if (!cUIDBuddyInfo2.isSelf) {
                                file2 = new File(new File(cUIDBuddyInfo2.appInfo.dataDir, str2), SELF_CUID_FILE);
                                if (file2.exists()) {
                                    createFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file2)));
                                    if (createFromJson == null) {
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        }
                    }
                }
                if (createFromJson == null) {
                    createFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue(KEY_DEVICE_ID_V2)));
                }
                checkSelfPermission = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
                if (createFromJson == null && checkSelfPermission) {
                    this.mSaveMask |= 2;
                    createFromJson = getCuidInfoFromExternalV2();
                }
                if (createFromJson == null) {
                    this.mSaveMask |= 8;
                    createFromJson = getCUidInfoFromSystemSettingV1();
                }
                if (createFromJson == null || !checkSelfPermission) {
                    str3 = null;
                } else {
                    this.mSaveMask |= 1;
                    String iMEIFromSystem = getIMEIFromSystem("");
                    i2 = 1;
                    str3 = iMEIFromSystem;
                    createFromJson = getExternalV1DeviceId(iMEIFromSystem);
                }
                if (createFromJson == null) {
                    this.mSaveMask |= 4;
                    if (i2 == 0) {
                        str3 = getIMEIFromSystem("");
                    }
                    createFromJson = new CUIDInfo();
                    androidId = getAndroidId(this.mContext);
                    if (VERSION.SDK_INT >= 23) {
                        str2 = UUID.randomUUID().toString();
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str3);
                        stringBuilder2.append(androidId);
                        stringBuilder2.append(str2);
                        androidId = stringBuilder2.toString();
                    } else {
                        StringBuilder stringBuilder3 = new StringBuilder("com.baidu");
                        stringBuilder3.append(androidId);
                        androidId = stringBuilder3.toString();
                    }
                    createFromJson.deviceId = MD5Util.toMd5(androidId.getBytes(), true);
                    createFromJson.imei = str3;
                }
                file3 = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
                if (!((this.mSaveMask & 16) == 0 && file3.exists())) {
                    if (TextUtils.isEmpty(null)) {
                        str = encryptCUIDInfo(createFromJson.toPersitString());
                    }
                    writeToCuidFile(str);
                }
                checkSelfPermission = hasWriteSettingsPermission();
                if (checkSelfPermission && ((this.mSaveMask & 2) != 0 || TextUtils.isEmpty(getSystemSettingValue(KEY_DEVICE_ID_V2)))) {
                    if (TextUtils.isEmpty(str)) {
                        str = encryptCUIDInfo(createFromJson.toPersitString());
                    }
                    tryPutSystemSettingValue(KEY_DEVICE_ID_V2, str);
                }
                if (checkSelfPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                    File file5 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
                    if (!((this.mSaveMask & 8) == 0 && file5.exists())) {
                        if (TextUtils.isEmpty(str)) {
                            str = encryptCUIDInfo(createFromJson.toPersitString());
                        }
                        setExternalV2DeviceId(str);
                    }
                }
                if (checkSelfPermission && ((1 & this.mSaveMask) != 0 || TextUtils.isEmpty(getSystemSettingValue(KEY_DEVICE_ID)))) {
                    tryPutSystemSettingValue(KEY_DEVICE_ID, createFromJson.deviceId);
                    tryPutSystemSettingValue(KEY_IMEI, createFromJson.imei);
                }
                if (checkSelfPermission && !TextUtils.isEmpty(createFromJson.imei)) {
                    file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
                    if (!((this.mSaveMask & 2) == 0 && file4.exists())) {
                        setExternalDeviceId(createFromJson.imei, createFromJson.deviceId);
                    }
                }
                return createFromJson;
            }
        }
        for (i = 0; i < 3; i++) {
            Log.w(TAG, "galaxy lib host missing meta-data,make sure you know the right way to integrate galaxy");
        }
        z = false;
        file = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
        str = null;
        if (file.exists()) {
        }
        if (createFromJson == null) {
            this.mSaveMask |= 16;
            collectBuddyInfos = collectBuddyInfos(new Intent(ACTION_GLAXY_CUID), z);
            if (collectBuddyInfos != null) {
                str2 = "files";
                filesDir = this.mContext.getFilesDir();
                if (str2.equals(filesDir.getName())) {
                    str2 = TAG;
                    StringBuilder stringBuilder4 = new StringBuilder("fetal error:: app files dir name is unexpectedly :: ");
                    stringBuilder4.append(filesDir.getAbsolutePath());
                    Log.e(str2, stringBuilder4.toString());
                    str2 = filesDir.getName();
                }
                for (CUIDBuddyInfo cUIDBuddyInfo22 : collectBuddyInfos) {
                    if (!cUIDBuddyInfo22.isSelf) {
                        file2 = new File(new File(cUIDBuddyInfo22.appInfo.dataDir, str2), SELF_CUID_FILE);
                        if (file2.exists()) {
                            createFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getFileContent(file2)));
                            if (createFromJson == null) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        if (createFromJson == null) {
            createFromJson = CUIDInfo.createFromJson(decryptCUIDInfo(getSystemSettingValue(KEY_DEVICE_ID_V2)));
        }
        checkSelfPermission = checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
        this.mSaveMask |= 2;
        createFromJson = getCuidInfoFromExternalV2();
        if (createFromJson == null) {
            this.mSaveMask |= 8;
            createFromJson = getCUidInfoFromSystemSettingV1();
        }
        if (createFromJson == null) {
        }
        str3 = null;
        if (createFromJson == null) {
            this.mSaveMask |= 4;
            if (i2 == 0) {
                str3 = getIMEIFromSystem("");
            }
            createFromJson = new CUIDInfo();
            androidId = getAndroidId(this.mContext);
            if (VERSION.SDK_INT >= 23) {
                StringBuilder stringBuilder32 = new StringBuilder("com.baidu");
                stringBuilder32.append(androidId);
                androidId = stringBuilder32.toString();
            } else {
                str2 = UUID.randomUUID().toString();
                StringBuilder stringBuilder22 = new StringBuilder();
                stringBuilder22.append(str3);
                stringBuilder22.append(androidId);
                stringBuilder22.append(str2);
                androidId = stringBuilder22.toString();
            }
            createFromJson.deviceId = MD5Util.toMd5(androidId.getBytes(), true);
            createFromJson.imei = str3;
        }
        file3 = new File(this.mContext.getFilesDir(), SELF_CUID_FILE);
        if (TextUtils.isEmpty(null)) {
            str = encryptCUIDInfo(createFromJson.toPersitString());
        }
        writeToCuidFile(str);
        checkSelfPermission = hasWriteSettingsPermission();
        if (TextUtils.isEmpty(str)) {
            str = encryptCUIDInfo(createFromJson.toPersitString());
        }
        tryPutSystemSettingValue(KEY_DEVICE_ID_V2, str);
        if (checkSelfPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
            File file52 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
            if (TextUtils.isEmpty(str)) {
                str = encryptCUIDInfo(createFromJson.toPersitString());
            }
            setExternalV2DeviceId(str);
        }
        tryPutSystemSettingValue(KEY_DEVICE_ID, createFromJson.deviceId);
        tryPutSystemSettingValue(KEY_IMEI, createFromJson.imei);
        file4 = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid");
        setExternalDeviceId(createFromJson.imei, createFromJson.deviceId);
        return createFromJson;
    }

    private CUIDInfo getCUidInfoFromSystemSettingV1() {
        Object systemSettingValue = getSystemSettingValue(KEY_DEVICE_ID);
        String systemSettingValue2 = getSystemSettingValue(KEY_IMEI);
        if (TextUtils.isEmpty(systemSettingValue2)) {
            systemSettingValue2 = getIMEIFromSystem("");
            if (!TextUtils.isEmpty(systemSettingValue2)) {
                tryPutSystemSettingValue(KEY_IMEI, systemSettingValue2);
            }
        }
        if (TextUtils.isEmpty(systemSettingValue)) {
            String androidId = getAndroidId(this.mContext);
            StringBuilder stringBuilder = new StringBuilder("com.baidu");
            stringBuilder.append(systemSettingValue2);
            stringBuilder.append(androidId);
            systemSettingValue = getSystemSettingValue(MD5Util.toMd5(stringBuilder.toString().getBytes(), true));
        }
        if (TextUtils.isEmpty(systemSettingValue)) {
            return null;
        }
        CUIDInfo cUIDInfo = new CUIDInfo();
        cUIDInfo.deviceId = systemSettingValue;
        cUIDInfo.imei = systemSettingValue2;
        return cUIDInfo;
    }

    private CUIDInfo getCuidInfoFromExternalV2() {
        File file = new File(Environment.getExternalStorageDirectory(), "backups/.SystemConfig/.cuid2");
        if (file.exists()) {
            Object fileContent = getFileContent(file);
            if (!TextUtils.isEmpty(fileContent)) {
                try {
                    return CUIDInfo.createFromJson(new String(AESUtil.decrypt(AES_KEY, AES_KEY, Base64.decode(fileContent.getBytes()))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static String getDeviceID(Context context) {
        return getOrCreateCUIDInfo(context).deviceId;
    }

    private com.baidu.android.common.util.DeviceId.CUIDInfo getExternalV1DeviceId(java.lang.String r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r10 = this;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 0;
        r2 = 1;
        r3 = 23;
        if (r0 >= r3) goto L_0x000a;
    L_0x0008:
        r0 = r2;
        goto L_0x000b;
    L_0x000a:
        r0 = r1;
    L_0x000b:
        r3 = 0;
        if (r0 == 0) goto L_0x0015;
    L_0x000e:
        r4 = android.text.TextUtils.isEmpty(r11);
        if (r4 == 0) goto L_0x0015;
    L_0x0014:
        return r3;
    L_0x0015:
        r4 = "";
        r5 = new java.io.File;
        r6 = android.os.Environment.getExternalStorageDirectory();
        r7 = "baidu/.cuid";
        r5.<init>(r6, r7);
        r6 = r5.exists();
        if (r6 != 0) goto L_0x0035;
    L_0x0028:
        r5 = new java.io.File;
        r6 = android.os.Environment.getExternalStorageDirectory();
        r7 = "backups/.SystemConfig/.cuid";
        r5.<init>(r6, r7);
        r6 = r2;
        goto L_0x0036;
    L_0x0035:
        r6 = r1;
    L_0x0036:
        r7 = new java.io.FileReader;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r5 = new java.io.BufferedReader;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r5.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7.<init>();	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0045:
        r8 = r5.readLine();	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        if (r8 == 0) goto L_0x0054;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x004b:
        r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r8 = "\r\n";	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7.append(r8);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        goto L_0x0045;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0054:
        r5.close();	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r5 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r8 = "30212102dicudiab";	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r9 = "30212102dicudiab";	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7 = r7.toString();	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7 = r7.getBytes();	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7 = com.baidu.android.common.security.Base64.decode(r7);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7 = com.baidu.android.common.security.AESUtil.decrypt(r8, r9, r7);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r5.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r7 = "=";	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r5 = r5.split(r7);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        if (r5 == 0) goto L_0x0094;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0078:
        r7 = r5.length;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r8 = 2;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        if (r7 != r8) goto L_0x0094;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x007c:
        if (r0 == 0) goto L_0x0086;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x007e:
        r1 = r5[r1];	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r1 = r11.equals(r1);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        if (r1 != 0) goto L_0x0091;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0086:
        if (r0 != 0) goto L_0x0094;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0088:
        r0 = android.text.TextUtils.isEmpty(r11);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        if (r0 == 0) goto L_0x0091;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x008e:
        r0 = r5[r2];	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r11 = r0;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0091:
        r0 = r5[r2];	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
        r4 = r0;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0094:
        if (r6 != 0) goto L_0x0099;	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0096:
        setExternalDeviceId(r11, r4);	 Catch:{ FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099, FileNotFoundException -> 0x0099 }
    L_0x0099:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 != 0) goto L_0x00a9;
    L_0x009f:
        r0 = new com.baidu.android.common.util.DeviceId$CUIDInfo;
        r0.<init>();
        r0.deviceId = r4;
        r0.imei = r11;
        return r0;
    L_0x00a9:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.util.DeviceId.getExternalV1DeviceId(java.lang.String):com.baidu.android.common.util.DeviceId$CUIDInfo");
    }

    private static String getFileContent(File file) {
        Throwable e;
        FileReader fileReader;
        try {
            fileReader = new FileReader(file);
            try {
                char[] cArr = new char[8192];
                CharArrayWriter charArrayWriter = new CharArrayWriter();
                while (true) {
                    int read = fileReader.read(cArr);
                    if (read > 0) {
                        charArrayWriter.write(cArr, 0, read);
                    } else {
                        String charArrayWriter2 = charArrayWriter.toString();
                        try {
                            fileReader.close();
                            return charArrayWriter2;
                        } catch (Throwable e2) {
                            handleThrowable(e2);
                            return charArrayWriter2;
                        }
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    handleThrowable(e);
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                            return null;
                        } catch (Throwable e4) {
                            handleThrowable(e4);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e4 = th;
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable e22) {
                            handleThrowable(e22);
                        }
                    }
                    throw e4;
                }
            }
        } catch (Exception e5) {
            e4 = e5;
            fileReader = null;
            handleThrowable(e4);
            if (fileReader != null) {
                fileReader.close();
                return null;
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileReader = null;
            if (fileReader != null) {
                fileReader.close();
            }
            throw e4;
        }
    }

    public static String getIMEI(Context context) {
        return getOrCreateCUIDInfo(context).imei;
    }

    private String getIMEIFromSystem(String str) {
        String str2 = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.mContext.getSystemService("phone");
            if (telephonyManager != null) {
                str2 = telephonyManager.getDeviceId();
            }
        } catch (Throwable e) {
            Log.e(TAG, "Read IMEI failed", e);
        }
        CharSequence imeiCheck = imeiCheck(str2);
        return TextUtils.isEmpty(imeiCheck) ? str : imeiCheck;
    }

    private static CUIDInfo getOrCreateCUIDInfo(Context context) {
        if (sCachedCuidInfo == null) {
            synchronized (CUIDInfo.class) {
                if (sCachedCuidInfo == null) {
                    SystemClock.uptimeMillis();
                    sCachedCuidInfo = new DeviceId(context).getCUIDInfo();
                    SystemClock.uptimeMillis();
                }
            }
        }
        return sCachedCuidInfo;
    }

    private String getSystemSettingValue(String str) {
        try {
            return System.getString(this.mContext.getContentResolver(), str);
        } catch (Throwable e) {
            handleThrowable(e);
            return null;
        }
    }

    private static void handleThrowable(Throwable th) {
    }

    private boolean hasReadImeiPermission() {
        return checkSelfPermission(MsgConstant.PERMISSION_READ_PHONE_STATE);
    }

    private boolean hasWriteSettingsPermission() {
        return checkSelfPermission("android.permission.WRITE_SETTINGS");
    }

    private static String imeiCheck(String str) {
        return (str == null || !str.contains(Constants.COLON_SEPARATOR)) ? str : "";
    }

    private void initPublicKey() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ Exception -> 0x0036, all -> 0x0027 }
        r2 = com.baidu.android.common.util.CuidCertStore.getCertBytes();	 Catch:{ Exception -> 0x0036, all -> 0x0027 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0036, all -> 0x0027 }
        r0 = "X.509";	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r0 = java.security.cert.CertificateFactory.getInstance(r0);	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r0 = r0.generateCertificate(r1);	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r0 = r0.getPublicKey();	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r4.mPublicKey = r0;	 Catch:{ Exception -> 0x0025, all -> 0x0023 }
        r1.close();	 Catch:{ Exception -> 0x001e }
        return;
    L_0x001e:
        r0 = move-exception;
        handleThrowable(r0);
        return;
    L_0x0023:
        r0 = move-exception;
        goto L_0x002b;
    L_0x0025:
        r0 = r1;
        goto L_0x0036;
    L_0x0027:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x002b:
        if (r1 == 0) goto L_0x0035;
    L_0x002d:
        r1.close();	 Catch:{ Exception -> 0x0031 }
        goto L_0x0035;
    L_0x0031:
        r1 = move-exception;
        handleThrowable(r1);
    L_0x0035:
        throw r0;
    L_0x0036:
        if (r0 == 0) goto L_0x0040;
    L_0x0038:
        r0.close();	 Catch:{ Exception -> 0x003c }
        return;
    L_0x003c:
        r0 = move-exception;
        handleThrowable(r0);
    L_0x0040:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.util.DeviceId.initPublicKey():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean isSigsEqual(java.lang.String[] r6, java.lang.String[] r7) {
        /*
        r5 = this;
        r0 = 0;
        if (r6 == 0) goto L_0x0030;
    L_0x0003:
        if (r7 == 0) goto L_0x0030;
    L_0x0005:
        r1 = r6.length;
        r2 = r7.length;
        if (r1 == r2) goto L_0x000a;
    L_0x0009:
        return r0;
    L_0x000a:
        r1 = new java.util.HashSet;
        r1.<init>();
        r2 = r6.length;
        r3 = r0;
    L_0x0011:
        if (r3 >= r2) goto L_0x001b;
    L_0x0013:
        r4 = r6[r3];
        r1.add(r4);
        r3 = r3 + 1;
        goto L_0x0011;
    L_0x001b:
        r6 = new java.util.HashSet;
        r6.<init>();
        r2 = r7.length;
    L_0x0021:
        if (r0 >= r2) goto L_0x002b;
    L_0x0023:
        r3 = r7[r0];
        r6.add(r3);
        r0 = r0 + 1;
        goto L_0x0021;
    L_0x002b:
        r6 = r1.equals(r6);
        return r6;
    L_0x0030:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.util.DeviceId.isSigsEqual(java.lang.String[], java.lang.String[]):boolean");
    }

    private static void setExternalDeviceId(java.lang.String r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r7);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r7);
        r7 = "=";
        r0.append(r7);
        r0.append(r8);
        r7 = new java.io.File;
        r8 = android.os.Environment.getExternalStorageDirectory();
        r1 = "backups/.SystemConfig";
        r7.<init>(r8, r1);
        r8 = new java.io.File;
        r1 = ".cuid";
        r8.<init>(r7, r1);
        r1 = r7.exists();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        if (r1 == 0) goto L_0x006b;	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
    L_0x002f:
        r1 = r7.isDirectory();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        if (r1 != 0) goto L_0x006b;	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
    L_0x0035:
        r1 = new java.util.Random;	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r1.<init>();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r2 = r7.getParentFile();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r3 = r7.getName();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
    L_0x0042:
        r4 = new java.io.File;	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r5.<init>();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r5.append(r3);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r6 = r1.nextInt();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r5.append(r6);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r6 = ".tmp";	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r5.append(r6);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r4.<init>(r2, r5);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r5 = r4.exists();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        if (r5 != 0) goto L_0x0042;	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
    L_0x0065:
        r7.renameTo(r4);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r4.delete();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
    L_0x006b:
        r7.mkdirs();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r7 = new java.io.FileWriter;	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r1 = 0;	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r7.<init>(r8, r1);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r8 = "30212102dicudiab";	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r1 = "30212102dicudiab";	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r0 = r0.getBytes();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r8 = com.baidu.android.common.security.AESUtil.encrypt(r8, r1, r0);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r0 = "utf-8";	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r8 = com.baidu.android.common.security.Base64.encode(r8, r0);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r7.write(r8);	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r7.flush();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
        r7.close();	 Catch:{ IOException -> 0x0093, IOException -> 0x0093 }
    L_0x0093:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.util.DeviceId.setExternalDeviceId(java.lang.String, java.lang.String):void");
    }

    private static void setExternalV2DeviceId(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new java.io.File;
        r1 = android.os.Environment.getExternalStorageDirectory();
        r2 = "backups/.SystemConfig";
        r0.<init>(r1, r2);
        r1 = new java.io.File;
        r2 = ".cuid2";
        r1.<init>(r0, r2);
        r2 = r0.exists();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        if (r2 == 0) goto L_0x0054;	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
    L_0x0018:
        r2 = r0.isDirectory();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        if (r2 != 0) goto L_0x0054;	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
    L_0x001e:
        r2 = new java.util.Random;	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r2.<init>();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r3 = r0.getParentFile();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r4 = r0.getName();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
    L_0x002b:
        r5 = new java.io.File;	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r6 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r6.<init>();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r6.append(r4);	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r7 = r2.nextInt();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r6.append(r7);	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r7 = ".tmp";	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r6.append(r7);	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r6 = r6.toString();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r5.<init>(r3, r6);	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r6 = r5.exists();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        if (r6 != 0) goto L_0x002b;	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
    L_0x004e:
        r0.renameTo(r5);	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r5.delete();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
    L_0x0054:
        r0.mkdirs();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r0 = new java.io.FileWriter;	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r2 = 0;	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r0.write(r8);	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r0.flush();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
        r0.close();	 Catch:{ IOException -> 0x0066, IOException -> 0x0066 }
    L_0x0066:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.util.DeviceId.setExternalV2DeviceId(java.lang.String):void");
    }

    private boolean tryPutSystemSettingValue(String str, String str2) {
        try {
            return System.putString(this.mContext.getContentResolver(), str, str2);
        } catch (Throwable e) {
            handleThrowable(e);
            return false;
        }
    }

    private boolean writeToCuidFile(String str) {
        Throwable e;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream openFileOutput = this.mContext.openFileOutput(SELF_CUID_FILE, 1);
            try {
                openFileOutput.write(str.getBytes());
                openFileOutput.flush();
                if (openFileOutput != null) {
                    try {
                        openFileOutput.close();
                        return true;
                    } catch (Throwable e2) {
                        handleThrowable(e2);
                    }
                }
                return true;
            } catch (Exception e3) {
                e2 = e3;
                fileOutputStream = openFileOutput;
                try {
                    handleThrowable(e2);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e22) {
                            handleThrowable(e22);
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e4) {
                            handleThrowable(e4);
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                fileOutputStream = openFileOutput;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e22;
            }
        } catch (Exception e5) {
            e22 = e5;
            handleThrowable(e22);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return false;
        }
    }

    private static void writeToFile(File file, byte[] bArr) {
        Throwable e;
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.flush();
                try {
                    fileOutputStream2.close();
                } catch (Throwable e2) {
                    handleThrowable(e2);
                }
            } catch (IOException e3) {
                e2 = e3;
                fileOutputStream = fileOutputStream2;
                handleThrowable(e2);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22) {
                        handleThrowable(e22);
                    }
                }
            } catch (SecurityException e4) {
                e22 = e4;
                fileOutputStream = fileOutputStream2;
                try {
                    handleThrowable(e22);
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e222) {
                            handleThrowable(e222);
                        }
                    }
                } catch (Throwable th) {
                    e222 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e5) {
                            handleThrowable(e5);
                        }
                    }
                    throw e222;
                }
            } catch (Throwable th2) {
                e222 = th2;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e222;
            }
        } catch (IOException e6) {
            e222 = e6;
            handleThrowable(e222);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (SecurityException e7) {
            e222 = e7;
            handleThrowable(e222);
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }
}
