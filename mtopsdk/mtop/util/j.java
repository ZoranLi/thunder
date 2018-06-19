package mtopsdk.mtop.util;

import com.alibaba.fastjson.a;
import com.alipay.sdk.util.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.Map.Entry;

public final class j {
    private static String a(Map map) {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("{");
        if (!map.isEmpty()) {
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                if (!(str == null || str2 == null)) {
                    try {
                        stringBuilder.append(a.toJSONString(str));
                        stringBuilder.append(Constants.COLON_SEPARATOR);
                        stringBuilder.append(a.toJSONString(str2));
                        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    } catch (Throwable th) {
                        StringBuilder stringBuilder2 = new StringBuilder("[converMapToDataStr] convert key=");
                        stringBuilder2.append(str);
                        stringBuilder2.append(",value=");
                        stringBuilder2.append(str2);
                        stringBuilder2.append(" to dataStr error ---");
                        stringBuilder2.append(th.toString());
                        mtopsdk.common.util.j.e(stringBuilder2.toString());
                    }
                }
            }
            int length = stringBuilder.length();
            if (length > 1) {
                stringBuilder.deleteCharAt(length - 1);
            }
        }
        stringBuilder.append(h.d);
        return stringBuilder.toString();
    }

    public static void a(mtopsdk.mtop.domain.MtopRequest r7, java.lang.Object r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.HashMap;	 Catch:{ Exception -> 0x00e1 }
        r0.<init>();	 Catch:{ Exception -> 0x00e1 }
        r1 = r8.getClass();	 Catch:{ Exception -> 0x00e1 }
        r2 = new java.util.HashSet;	 Catch:{ Exception -> 0x00e1 }
        r2.<init>();	 Catch:{ Exception -> 0x00e1 }
        r3 = r1.getFields();	 Catch:{ Exception -> 0x00e1 }
        r3 = java.util.Arrays.asList(r3);	 Catch:{ Exception -> 0x00e1 }
        r2.addAll(r3);	 Catch:{ Exception -> 0x00e1 }
        r1 = r1.getDeclaredFields();	 Catch:{ Exception -> 0x00e1 }
        r1 = java.util.Arrays.asList(r1);	 Catch:{ Exception -> 0x00e1 }
        r2.addAll(r1);	 Catch:{ Exception -> 0x00e1 }
        r1 = r2.iterator();	 Catch:{ Exception -> 0x00e1 }
    L_0x0028:
        r2 = r1.hasNext();	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x00d7;	 Catch:{ Exception -> 0x00e1 }
    L_0x002e:
        r2 = r1.next();	 Catch:{ Exception -> 0x00e1 }
        r2 = (java.lang.reflect.Field) r2;	 Catch:{ Exception -> 0x00e1 }
        r3 = r2.getName();	 Catch:{ Exception -> 0x00e1 }
        r4 = "$";	 Catch:{ Exception -> 0x00e1 }
        r4 = r3.indexOf(r4);	 Catch:{ Exception -> 0x00e1 }
        r5 = -1;	 Catch:{ Exception -> 0x00e1 }
        if (r4 != r5) goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x0041:
        r4 = "serialVersionUID";	 Catch:{ Exception -> 0x00e1 }
        r4 = r3.equals(r4);	 Catch:{ Exception -> 0x00e1 }
        if (r4 != 0) goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x0049:
        r4 = "ORIGINALJSON";	 Catch:{ Exception -> 0x00e1 }
        r4 = r3.equals(r4);	 Catch:{ Exception -> 0x00e1 }
        if (r4 != 0) goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x0051:
        r4 = 1;	 Catch:{ Exception -> 0x00e1 }
        r2.setAccessible(r4);	 Catch:{ Exception -> 0x00e1 }
        r5 = "API_NAME";	 Catch:{ Exception -> 0x00e1 }
        r5 = r3.equals(r5);	 Catch:{ Exception -> 0x00e1 }
        if (r5 == 0) goto L_0x006b;	 Catch:{ Exception -> 0x00e1 }
    L_0x005d:
        r2 = r2.get(r8);	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x0063:
        r2 = r2.toString();	 Catch:{ Exception -> 0x00e1 }
        r7.setApiName(r2);	 Catch:{ Exception -> 0x00e1 }
        goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x006b:
        r5 = "VERSION";	 Catch:{ Exception -> 0x00e1 }
        r5 = r3.equals(r5);	 Catch:{ Exception -> 0x00e1 }
        if (r5 == 0) goto L_0x0081;	 Catch:{ Exception -> 0x00e1 }
    L_0x0073:
        r2 = r2.get(r8);	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x0079:
        r2 = r2.toString();	 Catch:{ Exception -> 0x00e1 }
        r7.setVersion(r2);	 Catch:{ Exception -> 0x00e1 }
        goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x0081:
        r5 = "NEED_ECODE";	 Catch:{ Exception -> 0x00e1 }
        r5 = r3.equals(r5);	 Catch:{ Exception -> 0x00e1 }
        r6 = 0;	 Catch:{ Exception -> 0x00e1 }
        if (r5 == 0) goto L_0x00a0;	 Catch:{ Exception -> 0x00e1 }
    L_0x008a:
        r2 = r2.getBoolean(r8);	 Catch:{ Exception -> 0x00e1 }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x009b;	 Catch:{ Exception -> 0x00e1 }
    L_0x0094:
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x009b;	 Catch:{ Exception -> 0x00e1 }
    L_0x009a:
        goto L_0x009c;	 Catch:{ Exception -> 0x00e1 }
    L_0x009b:
        r4 = r6;	 Catch:{ Exception -> 0x00e1 }
    L_0x009c:
        r7.setNeedEcode(r4);	 Catch:{ Exception -> 0x00e1 }
        goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x00a0:
        r5 = "NEED_SESSION";	 Catch:{ Exception -> 0x00e1 }
        r5 = r3.equals(r5);	 Catch:{ Exception -> 0x00e1 }
        if (r5 == 0) goto L_0x00bf;	 Catch:{ Exception -> 0x00e1 }
    L_0x00a8:
        r2 = r2.getBoolean(r8);	 Catch:{ Exception -> 0x00e1 }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x00b9;	 Catch:{ Exception -> 0x00e1 }
    L_0x00b2:
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x00b9;	 Catch:{ Exception -> 0x00e1 }
    L_0x00b8:
        goto L_0x00ba;	 Catch:{ Exception -> 0x00e1 }
    L_0x00b9:
        r4 = r6;	 Catch:{ Exception -> 0x00e1 }
    L_0x00ba:
        r7.setNeedSession(r4);	 Catch:{ Exception -> 0x00e1 }
        goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x00bf:
        r2 = r2.get(r8);	 Catch:{ Exception -> 0x00e1 }
        if (r2 == 0) goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x00c5:
        r4 = r2 instanceof java.lang.String;	 Catch:{ Exception -> 0x00e1 }
        if (r4 == 0) goto L_0x00d2;	 Catch:{ Exception -> 0x00e1 }
    L_0x00c9:
        r2 = r2.toString();	 Catch:{ Exception -> 0x00e1 }
    L_0x00cd:
        r0.put(r3, r2);	 Catch:{ Exception -> 0x00e1 }
        goto L_0x0028;	 Catch:{ Exception -> 0x00e1 }
    L_0x00d2:
        r2 = com.alibaba.fastjson.a.toJSONString(r2);	 Catch:{ Exception -> 0x00e1 }
        goto L_0x00cd;	 Catch:{ Exception -> 0x00e1 }
    L_0x00d7:
        r7.dataParams = r0;	 Catch:{ Exception -> 0x00e1 }
        r8 = a(r0);	 Catch:{ Exception -> 0x00e1 }
        r7.setData(r8);	 Catch:{ Exception -> 0x00e1 }
        return;
    L_0x00e1:
        r7 = "parseParams failed.";
        mtopsdk.common.util.j.f(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.util.j.a(mtopsdk.mtop.domain.MtopRequest, java.lang.Object):void");
    }
}
