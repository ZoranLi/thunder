package com.ta.utdid2.android.utils;

import java.util.Random;

public class PhoneInfoUtils {
    public static final String getUniqueID() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        Object bytes = IntUtils.getBytes(currentTimeMillis);
        Object bytes2 = IntUtils.getBytes(nanoTime);
        Object bytes3 = IntUtils.getBytes(nextInt);
        Object bytes4 = IntUtils.getBytes(nextInt2);
        Object obj = new byte[16];
        System.arraycopy(bytes, 0, obj, 0, 4);
        System.arraycopy(bytes2, 0, obj, 4, 4);
        System.arraycopy(bytes3, 0, obj, 8, 4);
        System.arraycopy(bytes4, 0, obj, 12, 4);
        return Base64.encodeToString(obj, 2);
    }

    public static java.lang.String getImei(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r1 == 0) goto L_0x0011;
    L_0x0002:
        r0 = "phone";	 Catch:{ Exception -> 0x0011 }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x0011 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0011 }
        if (r1 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x0011 }
    L_0x000c:
        r1 = r1.getDeviceId();	 Catch:{ Exception -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r1 = 0;
    L_0x0012:
        r0 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x001c;
    L_0x0018:
        r1 = getUniqueID();
    L_0x001c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.PhoneInfoUtils.getImei(android.content.Context):java.lang.String");
    }

    public static java.lang.String getImsi(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r1 == 0) goto L_0x0011;
    L_0x0002:
        r0 = "phone";	 Catch:{ Exception -> 0x0011 }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x0011 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0011 }
        if (r1 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x0011 }
    L_0x000c:
        r1 = r1.getSubscriberId();	 Catch:{ Exception -> 0x0011 }
        goto L_0x0012;
    L_0x0011:
        r1 = 0;
    L_0x0012:
        r0 = com.ta.utdid2.android.utils.StringUtils.isEmpty(r1);
        if (r0 == 0) goto L_0x001c;
    L_0x0018:
        r1 = getUniqueID();
    L_0x001c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.PhoneInfoUtils.getImsi(android.content.Context):java.lang.String");
    }
}
