package mtopsdk.mtop.unit;

import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.f;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a.d;

public final class a {
    public static mtopsdk.mtop.unit.UserUnit a(java.lang.String r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = ",";
        r0 = r7.split(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x0060;
    L_0x0009:
        r2 = r0.length;
        if (r2 <= 0) goto L_0x0060;
    L_0x000c:
        r2 = r0.length;
        r3 = 0;
        r4 = r1;
    L_0x000f:
        if (r3 >= r2) goto L_0x0056;
    L_0x0011:
        r5 = r0[r3];
        r6 = "type=";	 Catch:{ Exception -> 0x0042 }
        r6 = r5.contains(r6);	 Catch:{ Exception -> 0x0042 }
        if (r6 == 0) goto L_0x0033;	 Catch:{ Exception -> 0x0042 }
    L_0x001b:
        r6 = 5;	 Catch:{ Exception -> 0x0042 }
        r5 = r5.substring(r6);	 Catch:{ Exception -> 0x0042 }
        r6 = mtopsdk.mtop.unit.UserUnit.UnitType.UNIT;	 Catch:{ Exception -> 0x0042 }
        r6 = r6.getUnitType();	 Catch:{ Exception -> 0x0042 }
        r5 = r6.equalsIgnoreCase(r5);	 Catch:{ Exception -> 0x0042 }
        if (r5 == 0) goto L_0x0030;	 Catch:{ Exception -> 0x0042 }
    L_0x002c:
        r5 = mtopsdk.mtop.unit.UserUnit.UnitType.UNIT;	 Catch:{ Exception -> 0x0042 }
    L_0x002e:
        r1 = r5;	 Catch:{ Exception -> 0x0042 }
        goto L_0x0053;	 Catch:{ Exception -> 0x0042 }
    L_0x0030:
        r5 = mtopsdk.mtop.unit.UserUnit.UnitType.CENTER;	 Catch:{ Exception -> 0x0042 }
        goto L_0x002e;	 Catch:{ Exception -> 0x0042 }
    L_0x0033:
        r6 = "prefix=";	 Catch:{ Exception -> 0x0042 }
        r6 = r5.contains(r6);	 Catch:{ Exception -> 0x0042 }
        if (r6 == 0) goto L_0x0053;	 Catch:{ Exception -> 0x0042 }
    L_0x003b:
        r6 = 7;	 Catch:{ Exception -> 0x0042 }
        r5 = r5.substring(r6);	 Catch:{ Exception -> 0x0042 }
        r4 = r5;
        goto L_0x0053;
    L_0x0042:
        r5 = new java.lang.StringBuilder;
        r6 = "[parseUserUnitInfo] parse x-m-update-unitinfo  header error,userUnitInfo=";
        r5.<init>(r6);
        r5.append(r7);
        r5 = r5.toString();
        mtopsdk.common.util.j.f(r8, r5);
    L_0x0053:
        r3 = r3 + 1;
        goto L_0x000f;
    L_0x0056:
        r7 = new mtopsdk.mtop.unit.UserUnit;
        r8 = mtopsdk.xstate.a.b();
        r7.<init>(r8, r1, r4);
        return r7;
    L_0x0060:
        r7 = r1;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.unit.a.a(java.lang.String, java.lang.String):mtopsdk.mtop.unit.UserUnit");
    }

    public static void a() {
        d a = d.a();
        if (d.j() == null) {
            try {
                ApiUnit apiUnit = (ApiUnit) f.a(d.b().getFilesDir(), "UNIT_SETTING_STORE.API_UNIT_ITEM");
                if (apiUnit != null) {
                    a.a(apiUnit);
                    if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
                        j.b("[loadUnitInfoFromLocalStore] load ApiUnit info from local Storage succeed.");
                    }
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("[loadUnitInfoFromLocalStore] parse apiUnit from local Storage error ---");
                stringBuilder.append(e.toString());
                j.e(stringBuilder.toString());
            }
        }
    }

    public static Map b(String str, String str2) {
        Map hashMap = new HashMap(2);
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split != null && split.length > 0) {
            for (String str3 : split) {
                try {
                    Object substring;
                    Object obj;
                    if (str3.contains("v=")) {
                        substring = str3.substring(2);
                        obj = "v=";
                    } else if (str3.contains("url=")) {
                        substring = str3.substring(4);
                        obj = "url=";
                    } else {
                    }
                    hashMap.put(obj, substring);
                } catch (Exception e) {
                    StringBuilder stringBuilder = new StringBuilder("[parseApiUnitInfoParams] parse x-m-update-unitapi  header error---");
                    stringBuilder.append(e.toString());
                    j.e(str2, stringBuilder.toString());
                }
            }
        }
        return hashMap;
    }
}
