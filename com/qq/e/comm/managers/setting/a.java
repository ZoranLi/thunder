package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.qq.e.comm.constants.Constants.KEYS;
import com.qq.e.comm.constants.Constants.SETTING;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONObject;

public class a {
    JSONObject a;

    public a() {
        this.a = new JSONObject();
    }

    public a(String str) {
        this();
        StringBuilder stringBuilder = new StringBuilder("Initialize GDTAPPSetting,Json=");
        stringBuilder.append(str);
        GDTLogger.d(stringBuilder.toString());
        if (!StringUtil.isEmpty(str)) {
            try {
                this.a = new JSONObject(str);
            } catch (Throwable e) {
                GDTLogger.e("JsonException While build GDTAPPSetting Instance from JSON", e);
            }
        }
    }

    private static android.util.Pair<java.lang.String, java.lang.String> a(android.content.Context r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "e_qq_com_setting";
        r1 = 0;
        r4 = r4.getDir(r0, r1);
        r0 = r4.exists();
        r1 = 0;
        if (r0 == 0) goto L_0x0055;
    L_0x000e:
        r0 = new java.io.File;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r5);
        r3 = ".sig";
        r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r4, r2);
        r2 = new java.io.File;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r5);
        r5 = ".cfg";
        r3.append(r5);
        r5 = r3.toString();
        r2.<init>(r4, r5);
        r4 = r0.exists();
        if (r4 == 0) goto L_0x0055;
    L_0x0040:
        r4 = r2.exists();
        if (r4 != 0) goto L_0x0047;
    L_0x0046:
        return r1;
    L_0x0047:
        r4 = new android.util.Pair;	 Catch:{ IOException -> 0x0055 }
        r5 = com.qq.e.comm.util.StringUtil.readAll(r0);	 Catch:{ IOException -> 0x0055 }
        r0 = com.qq.e.comm.util.StringUtil.readAll(r2);	 Catch:{ IOException -> 0x0055 }
        r4.<init>(r5, r0);	 Catch:{ IOException -> 0x0055 }
        return r4;
    L_0x0055:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.setting.a.a(android.content.Context, java.lang.String):android.util.Pair<java.lang.String, java.lang.String>");
    }

    public static com.qq.e.comm.a a(Context context) {
        Pair a = a(context, SETTING.DEV_CLOUD_SETTING);
        if (a == null) {
            return null;
        }
        try {
            if (com.qq.e.comm.util.a.a().a((String) a.first, (String) a.second)) {
                return new com.qq.e.comm.a((String) a.first, new a(new String(Base64.decode((String) a.second, 0), "UTF-8")));
            }
            GDTLogger.e("verify local dev cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.e("exception while loading local dev cloud setting", th);
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return a(context, SETTING.SDK_CLOUD_SETTING, str, str2);
    }

    private static boolean a(Context context, String str, String str2, String str3) {
        String str4;
        Object[] objArr;
        if (StringUtil.isEmpty(str2) || StringUtil.isEmpty(str3)) {
            str4 = "Fail to update Cloud setting due to sig or setting is empty,name=%s\tsig=%s\tsetting=%s";
            objArr = new Object[]{str, str2, str3};
        } else if (com.qq.e.comm.util.a.a().a(str2, str3)) {
            return b(context, str, str2, str3);
        } else {
            str4 = "Fail to update Cloud setting due to sig verify fail,name=%s\tsig=%s\tsetting=%s";
            objArr = new Object[]{str, str2, str3};
        }
        GDTLogger.e(String.format(str4, objArr));
        return false;
    }

    public static d b(Context context) {
        Pair a = a(context, SETTING.SDK_CLOUD_SETTING);
        if (a == null) {
            return null;
        }
        try {
            if (com.qq.e.comm.util.a.a().a((String) a.first, (String) a.second)) {
                return new d((String) a.first, new c(new String(Base64.decode((String) a.second, 0), "UTF-8")), (byte) 0);
            }
            GDTLogger.e("verify local sdk cloud setting fail");
            return null;
        } catch (Throwable th) {
            GDTLogger.e("exception while loading local sdk cloud setting", th);
            return null;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        return a(context, SETTING.DEV_CLOUD_SETTING, str, str2);
    }

    private static boolean b(android.content.Context r5, java.lang.String r6, java.lang.String r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "e_qq_com_setting";
        r1 = 0;
        r5 = r5.getDir(r0, r1);
        r0 = r5.exists();
        if (r0 != 0) goto L_0x0010;
    L_0x000d:
        r5.mkdirs();
    L_0x0010:
        r0 = new java.io.File;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r6);
        r3 = ".cfg";
        r2.append(r3);
        r2 = r2.toString();
        r0.<init>(r5, r2);
        r2 = new java.io.File;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r6);
        r6 = ".sig";
        r3.append(r6);
        r6 = r3.toString();
        r2.<init>(r5, r6);
        r5 = 0;
        r6 = new java.io.FileWriter;	 Catch:{ Exception -> 0x0065, all -> 0x0062 }
        r6.<init>(r0);	 Catch:{ Exception -> 0x0065, all -> 0x0062 }
        r6.write(r8);	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r8 = new java.io.FileWriter;	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r8.<init>(r2);	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r8.write(r7);	 Catch:{ Exception -> 0x0060, all -> 0x0055 }
        r6.close();	 Catch:{ Exception -> 0x0053 }
        r8.close();	 Catch:{ Exception -> 0x0053 }
    L_0x0053:
        r5 = 1;
        return r5;
    L_0x0055:
        r5 = move-exception;
        r4 = r6;
        r6 = r5;
        r5 = r4;
        goto L_0x0078;
    L_0x005a:
        r7 = move-exception;
        r8 = r5;
        r5 = r6;
        r6 = r7;
        goto L_0x0078;
    L_0x005f:
        r8 = r5;
    L_0x0060:
        r5 = r6;
        goto L_0x0066;
    L_0x0062:
        r6 = move-exception;
        r8 = r5;
        goto L_0x0078;
    L_0x0065:
        r8 = r5;
    L_0x0066:
        r0.delete();	 Catch:{ all -> 0x0077 }
        r2.delete();	 Catch:{ all -> 0x0077 }
        if (r5 == 0) goto L_0x0071;
    L_0x006e:
        r5.close();	 Catch:{ Exception -> 0x0076 }
    L_0x0071:
        if (r8 == 0) goto L_0x0076;	 Catch:{ Exception -> 0x0076 }
    L_0x0073:
        r8.close();	 Catch:{ Exception -> 0x0076 }
    L_0x0076:
        return r1;
    L_0x0077:
        r6 = move-exception;
    L_0x0078:
        if (r5 == 0) goto L_0x007d;
    L_0x007a:
        r5.close();	 Catch:{ Exception -> 0x0082 }
    L_0x007d:
        if (r8 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x0082 }
    L_0x007f:
        r8.close();	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.setting.a.b(android.content.Context, java.lang.String, java.lang.String, java.lang.String):boolean");
    }

    final Object a(String str) {
        return this.a.opt(str);
    }

    final Object a(String str, String str2) {
        JSONObject optJSONObject = this.a.optJSONObject(KEYS.PLACEMENTS);
        JSONObject optJSONObject2 = optJSONObject != null ? optJSONObject.optJSONObject(str2) : null;
        return optJSONObject2 != null ? optJSONObject2.opt(str) : null;
    }
}
