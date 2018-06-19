package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.android.utils.Base64;
import com.ta.utdid2.android.utils.StringUtils;
import com.ta.utdid2.core.persistent.PersistentConfiguration;
import java.io.File;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class UTUtdid {
    private static final Object CREATE_LOCK = new Object();
    private static final String HMAC_KEY = "d6fc3a4a06adbde89223bvefedc24fecde188aaa9161";
    private static final String S_GLOBAL_PERSISTENT_CONFIG_DIR;
    private static final String S_GLOBAL_PERSISTENT_CONFIG_KEY = "Alvin2";
    private static final String S_LOCAL_STORAGE_KEY = "ContextData";
    private static final String S_LOCAL_STORAGE_NAME = ".DataStorage";
    static final String UM_SETTINGS_STORAGE = "dxCRMxhQkdGePGnp";
    static final String UM_SETTINGS_STORAGE_NEW = "mqBRboGZkQPcAkyk";
    private static UTUtdid s_umutdid;
    private String mCBDomain = "xx_utdid_domain";
    private String mCBKey = "xx_utdid_key";
    private Context mContext = null;
    private PersistentConfiguration mPC = null;
    private Pattern mPattern = Pattern.compile("[^0-9a-zA-Z=/+]+");
    private PersistentConfiguration mTaoPC = null;
    private String mUtdid = null;
    private UTUtdidHelper mUtdidHelper = null;

    static {
        StringBuilder stringBuilder = new StringBuilder(".UTSystemConfig");
        stringBuilder.append(File.separator);
        stringBuilder.append("Global");
        S_GLOBAL_PERSISTENT_CONFIG_DIR = stringBuilder.toString();
    }

    public UTUtdid(Context context) {
        this.mContext = context;
        this.mTaoPC = new PersistentConfiguration(context, S_GLOBAL_PERSISTENT_CONFIG_DIR, S_GLOBAL_PERSISTENT_CONFIG_KEY, false, true);
        this.mPC = new PersistentConfiguration(context, S_LOCAL_STORAGE_NAME, S_LOCAL_STORAGE_KEY, false, true);
        this.mUtdidHelper = new UTUtdidHelper();
        this.mCBKey = String.format("K_%d", new Object[]{Integer.valueOf(StringUtils.hashCode(this.mCBKey))});
        this.mCBDomain = String.format("D_%d", new Object[]{Integer.valueOf(StringUtils.hashCode(this.mCBDomain))});
    }

    private void _removeIllegalKeys() {
        if (this.mTaoPC != null) {
            if (StringUtils.isEmpty(this.mTaoPC.getString("UTDID2"))) {
                String string = this.mTaoPC.getString("UTDID");
                if (!StringUtils.isEmpty(string)) {
                    saveUtdidToTaoPPC(string);
                }
            }
            Object obj = null;
            if (!StringUtils.isEmpty(this.mTaoPC.getString("DID"))) {
                this.mTaoPC.remove("DID");
                obj = 1;
            }
            if (!StringUtils.isEmpty(this.mTaoPC.getString("EI"))) {
                this.mTaoPC.remove("EI");
                obj = 1;
            }
            if (!StringUtils.isEmpty(this.mTaoPC.getString("SI"))) {
                this.mTaoPC.remove("SI");
                obj = 1;
            }
            if (obj != null) {
                this.mTaoPC.commit();
            }
        }
    }

    public static UTUtdid instance(Context context) {
        if (context != null && s_umutdid == null) {
            synchronized (CREATE_LOCK) {
                if (s_umutdid == null) {
                    UTUtdid uTUtdid = new UTUtdid(context);
                    s_umutdid = uTUtdid;
                    uTUtdid._removeIllegalKeys();
                }
            }
        }
        return s_umutdid;
    }

    private void saveUtdidToTaoPPC(String str) {
        if (isValidUTDID(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && this.mTaoPC != null) {
                this.mTaoPC.putString("UTDID2", str);
                this.mTaoPC.commit();
            }
        }
    }

    private void saveUtdidToLocalStorage(String str) {
        if (str != null && this.mPC != null && !str.equals(this.mPC.getString(this.mCBKey))) {
            this.mPC.putString(this.mCBKey, str);
            this.mPC.commit();
        }
    }

    private void saveUtdidToNewSettings(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.mContext;
        r1 = "android.permission.WRITE_SETTINGS";
        r0 = r0.checkCallingOrSelfPermission(r1);
        if (r0 != 0) goto L_0x004b;
    L_0x000a:
        r0 = r3.isValidUTDID(r4);
        if (r0 == 0) goto L_0x004b;
    L_0x0010:
        r0 = "\n";
        r0 = r4.endsWith(r0);
        if (r0 == 0) goto L_0x0023;
    L_0x0018:
        r0 = 0;
        r1 = r4.length();
        r1 = r1 + -1;
        r4 = r4.substring(r0, r1);
    L_0x0023:
        r0 = 24;
        r1 = r4.length();
        if (r0 != r1) goto L_0x004b;
    L_0x002b:
        r0 = 0;
        r1 = r3.mContext;	 Catch:{ Exception -> 0x0039 }
        r1 = r1.getContentResolver();	 Catch:{ Exception -> 0x0039 }
        r2 = "mqBRboGZkQPcAkyk";	 Catch:{ Exception -> 0x0039 }
        r1 = android.provider.Settings.System.getString(r1, r2);	 Catch:{ Exception -> 0x0039 }
        r0 = r1;
    L_0x0039:
        r0 = r3.isValidUTDID(r0);
        if (r0 != 0) goto L_0x004b;
    L_0x003f:
        r0 = r3.mContext;	 Catch:{ Exception -> 0x004b }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x004b }
        r1 = "mqBRboGZkQPcAkyk";	 Catch:{ Exception -> 0x004b }
        android.provider.Settings.System.putString(r0, r1, r4);	 Catch:{ Exception -> 0x004b }
        return;
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.device.UTUtdid.saveUtdidToNewSettings(java.lang.String):void");
    }

    private void syncUTDIDToSettings(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.mContext;	 Catch:{ Exception -> 0x000d }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x000d }
        r1 = "dxCRMxhQkdGePGnp";	 Catch:{ Exception -> 0x000d }
        r0 = android.provider.Settings.System.getString(r0, r1);	 Catch:{ Exception -> 0x000d }
        goto L_0x000e;
    L_0x000d:
        r0 = 0;
    L_0x000e:
        r0 = r3.equals(r0);
        if (r0 != 0) goto L_0x0020;
    L_0x0014:
        r0 = r2.mContext;	 Catch:{ Exception -> 0x0020 }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x0020 }
        r1 = "dxCRMxhQkdGePGnp";	 Catch:{ Exception -> 0x0020 }
        android.provider.Settings.System.putString(r0, r1, r3);	 Catch:{ Exception -> 0x0020 }
        return;
    L_0x0020:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.device.UTUtdid.syncUTDIDToSettings(java.lang.String):void");
    }

    private void saveUtdidToSettings(String str) {
        if (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_SETTINGS") == 0 && str != null) {
            syncUTDIDToSettings(str);
        }
    }

    private String getUtdidFromTaoPPC() {
        if (this.mTaoPC != null) {
            String string = this.mTaoPC.getString("UTDID2");
            if (!(StringUtils.isEmpty(string) || this.mUtdidHelper.packUtdidStr(string) == null)) {
                return string;
            }
        }
        return null;
    }

    private boolean isValidUTDID(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            return 24 == str.length() && this.mPattern.matcher(str).find() == null;
        }
    }

    public synchronized java.lang.String getValue() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.mUtdid;	 Catch:{ all -> 0x0119 }
        if (r0 == 0) goto L_0x0009;	 Catch:{ all -> 0x0119 }
    L_0x0005:
        r0 = r6.mUtdid;	 Catch:{ all -> 0x0119 }
        monitor-exit(r6);
        return r0;
    L_0x0009:
        r0 = "";	 Catch:{ all -> 0x0119 }
        r1 = r6.mContext;	 Catch:{ Exception -> 0x0018 }
        r1 = r1.getContentResolver();	 Catch:{ Exception -> 0x0018 }
        r2 = "mqBRboGZkQPcAkyk";	 Catch:{ Exception -> 0x0018 }
        r1 = android.provider.Settings.System.getString(r1, r2);	 Catch:{ Exception -> 0x0018 }
        r0 = r1;
    L_0x0018:
        r1 = r6.isValidUTDID(r0);	 Catch:{ all -> 0x0119 }
        if (r1 == 0) goto L_0x0020;
    L_0x001e:
        monitor-exit(r6);
        return r0;
    L_0x0020:
        r0 = new com.ta.utdid2.device.UTUtdidHelper2;	 Catch:{ all -> 0x0119 }
        r0.<init>();	 Catch:{ all -> 0x0119 }
        r1 = 0;
        r2 = 0;
        r3 = r6.mContext;	 Catch:{ Exception -> 0x0034 }
        r3 = r3.getContentResolver();	 Catch:{ Exception -> 0x0034 }
        r4 = "dxCRMxhQkdGePGnp";	 Catch:{ Exception -> 0x0034 }
        r3 = android.provider.Settings.System.getString(r3, r4);	 Catch:{ Exception -> 0x0034 }
        goto L_0x0035;
    L_0x0034:
        r3 = r2;
    L_0x0035:
        r4 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r3);	 Catch:{ all -> 0x0119 }
        if (r4 != 0) goto L_0x008d;	 Catch:{ all -> 0x0119 }
    L_0x003b:
        r4 = r0.dePackWithBase64(r3);	 Catch:{ all -> 0x0119 }
        r5 = r6.isValidUTDID(r4);	 Catch:{ all -> 0x0119 }
        if (r5 == 0) goto L_0x004a;	 Catch:{ all -> 0x0119 }
    L_0x0045:
        r6.saveUtdidToNewSettings(r4);	 Catch:{ all -> 0x0119 }
        monitor-exit(r6);
        return r4;
    L_0x004a:
        r4 = r0.dePack(r3);	 Catch:{ all -> 0x0119 }
        r5 = r6.isValidUTDID(r4);	 Catch:{ all -> 0x0119 }
        if (r5 == 0) goto L_0x0070;	 Catch:{ all -> 0x0119 }
    L_0x0054:
        r5 = r6.mUtdidHelper;	 Catch:{ all -> 0x0119 }
        r4 = r5.packUtdidStr(r4);	 Catch:{ all -> 0x0119 }
        r5 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r4);	 Catch:{ all -> 0x0119 }
        if (r5 != 0) goto L_0x0070;	 Catch:{ all -> 0x0119 }
    L_0x0060:
        r6.saveUtdidToSettings(r4);	 Catch:{ all -> 0x0119 }
        r4 = r6.mContext;	 Catch:{ Exception -> 0x0070 }
        r4 = r4.getContentResolver();	 Catch:{ Exception -> 0x0070 }
        r5 = "dxCRMxhQkdGePGnp";	 Catch:{ Exception -> 0x0070 }
        r4 = android.provider.Settings.System.getString(r4, r5);	 Catch:{ Exception -> 0x0070 }
        r3 = r4;
    L_0x0070:
        r4 = r6.mUtdidHelper;	 Catch:{ all -> 0x0119 }
        r4 = r4.dePack(r3);	 Catch:{ all -> 0x0119 }
        r5 = r6.isValidUTDID(r4);	 Catch:{ all -> 0x0119 }
        if (r5 == 0) goto L_0x008e;	 Catch:{ all -> 0x0119 }
    L_0x007c:
        r6.mUtdid = r4;	 Catch:{ all -> 0x0119 }
        r6.saveUtdidToTaoPPC(r4);	 Catch:{ all -> 0x0119 }
        r6.saveUtdidToLocalStorage(r3);	 Catch:{ all -> 0x0119 }
        r0 = r6.mUtdid;	 Catch:{ all -> 0x0119 }
        r6.saveUtdidToNewSettings(r0);	 Catch:{ all -> 0x0119 }
        r0 = r6.mUtdid;	 Catch:{ all -> 0x0119 }
        monitor-exit(r6);
        return r0;
    L_0x008d:
        r1 = 1;
    L_0x008e:
        r3 = r6.getUtdidFromTaoPPC();	 Catch:{ all -> 0x0119 }
        r4 = r6.isValidUTDID(r3);	 Catch:{ all -> 0x0119 }
        if (r4 == 0) goto L_0x00ad;	 Catch:{ all -> 0x0119 }
    L_0x0098:
        r0 = r6.mUtdidHelper;	 Catch:{ all -> 0x0119 }
        r0 = r0.packUtdidStr(r3);	 Catch:{ all -> 0x0119 }
        if (r1 == 0) goto L_0x00a3;	 Catch:{ all -> 0x0119 }
    L_0x00a0:
        r6.saveUtdidToSettings(r0);	 Catch:{ all -> 0x0119 }
    L_0x00a3:
        r6.saveUtdidToNewSettings(r3);	 Catch:{ all -> 0x0119 }
        r6.saveUtdidToLocalStorage(r0);	 Catch:{ all -> 0x0119 }
        r6.mUtdid = r3;	 Catch:{ all -> 0x0119 }
        monitor-exit(r6);
        return r3;
    L_0x00ad:
        r3 = r6.mPC;	 Catch:{ all -> 0x0119 }
        r4 = r6.mCBKey;	 Catch:{ all -> 0x0119 }
        r3 = r3.getString(r4);	 Catch:{ all -> 0x0119 }
        r4 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r3);	 Catch:{ all -> 0x0119 }
        if (r4 != 0) goto L_0x00ed;	 Catch:{ all -> 0x0119 }
    L_0x00bb:
        r0 = r0.dePack(r3);	 Catch:{ all -> 0x0119 }
        r4 = r6.isValidUTDID(r0);	 Catch:{ all -> 0x0119 }
        if (r4 != 0) goto L_0x00cb;	 Catch:{ all -> 0x0119 }
    L_0x00c5:
        r0 = r6.mUtdidHelper;	 Catch:{ all -> 0x0119 }
        r0 = r0.dePack(r3);	 Catch:{ all -> 0x0119 }
    L_0x00cb:
        r3 = r6.isValidUTDID(r0);	 Catch:{ all -> 0x0119 }
        if (r3 == 0) goto L_0x00ed;	 Catch:{ all -> 0x0119 }
    L_0x00d1:
        r3 = r6.mUtdidHelper;	 Catch:{ all -> 0x0119 }
        r3 = r3.packUtdidStr(r0);	 Catch:{ all -> 0x0119 }
        r4 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r0);	 Catch:{ all -> 0x0119 }
        if (r4 != 0) goto L_0x00ed;	 Catch:{ all -> 0x0119 }
    L_0x00dd:
        r6.mUtdid = r0;	 Catch:{ all -> 0x0119 }
        if (r1 == 0) goto L_0x00e4;	 Catch:{ all -> 0x0119 }
    L_0x00e1:
        r6.saveUtdidToSettings(r3);	 Catch:{ all -> 0x0119 }
    L_0x00e4:
        r0 = r6.mUtdid;	 Catch:{ all -> 0x0119 }
        r6.saveUtdidToTaoPPC(r0);	 Catch:{ all -> 0x0119 }
        r0 = r6.mUtdid;	 Catch:{ all -> 0x0119 }
        monitor-exit(r6);
        return r0;
    L_0x00ed:
        r0 = r6._generateUtdid();	 Catch:{ Exception -> 0x0113 }
        if (r0 == 0) goto L_0x0117;	 Catch:{ Exception -> 0x0113 }
    L_0x00f3:
        r3 = 2;	 Catch:{ Exception -> 0x0113 }
        r3 = com.ta.utdid2.android.utils.Base64.encodeToString(r0, r3);	 Catch:{ Exception -> 0x0113 }
        r6.mUtdid = r3;	 Catch:{ Exception -> 0x0113 }
        r3 = r6.mUtdid;	 Catch:{ Exception -> 0x0113 }
        r6.saveUtdidToTaoPPC(r3);	 Catch:{ Exception -> 0x0113 }
        r3 = r6.mUtdidHelper;	 Catch:{ Exception -> 0x0113 }
        r0 = r3.pack(r0);	 Catch:{ Exception -> 0x0113 }
        if (r0 == 0) goto L_0x010f;	 Catch:{ Exception -> 0x0113 }
    L_0x0107:
        if (r1 == 0) goto L_0x010c;	 Catch:{ Exception -> 0x0113 }
    L_0x0109:
        r6.saveUtdidToSettings(r0);	 Catch:{ Exception -> 0x0113 }
    L_0x010c:
        r6.saveUtdidToLocalStorage(r0);	 Catch:{ Exception -> 0x0113 }
    L_0x010f:
        r0 = r6.mUtdid;	 Catch:{ Exception -> 0x0113 }
        monitor-exit(r6);
        return r0;
    L_0x0113:
        r0 = move-exception;
        r0.printStackTrace();	 Catch:{ all -> 0x0119 }
    L_0x0117:
        monitor-exit(r6);
        return r2;
    L_0x0119:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.device.UTUtdid.getValue():java.lang.String");
    }

    private final byte[] _generateUtdid() throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new java.io.ByteArrayOutputStream;
        r0.<init>();
        r1 = java.lang.System.currentTimeMillis();
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = r1 / r3;
        r1 = (int) r1;
        r2 = new java.util.Random;
        r2.<init>();
        r2 = r2.nextInt();
        r1 = com.ta.utdid2.android.utils.IntUtils.getBytes(r1);
        r2 = com.ta.utdid2.android.utils.IntUtils.getBytes(r2);
        r3 = 4;
        r4 = 0;
        r0.write(r1, r4, r3);
        r0.write(r2, r4, r3);
        r1 = 3;
        r0.write(r1);
        r0.write(r4);
        r1 = r5.mContext;	 Catch:{ Exception -> 0x0034 }
        r1 = com.ta.utdid2.android.utils.PhoneInfoUtils.getImei(r1);	 Catch:{ Exception -> 0x0034 }
        goto L_0x0049;
    L_0x0034:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = new java.util.Random;
        r2.<init>();
        r2 = r2.nextInt();
        r1.append(r2);
        r1 = r1.toString();
    L_0x0049:
        r1 = com.ta.utdid2.android.utils.StringUtils.hashCode(r1);
        r1 = com.ta.utdid2.android.utils.IntUtils.getBytes(r1);
        r0.write(r1, r4, r3);
        r1 = r0.toByteArray();
        r1 = _calcHmac(r1);
        r1 = com.ta.utdid2.android.utils.StringUtils.hashCode(r1);
        r1 = com.ta.utdid2.android.utils.IntUtils.getBytes(r1);
        r0.write(r1);
        r0 = r0.toByteArray();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.device.UTUtdid._generateUtdid():byte[]");
    }

    private static String _calcHmac(byte[] bArr) throws Exception {
        String str = HMAC_KEY;
        Mac instance = Mac.getInstance("HmacSHA1");
        instance.init(new SecretKeySpec(str.getBytes(), instance.getAlgorithm()));
        return Base64.encodeToString(instance.doFinal(bArr), 2);
    }
}
