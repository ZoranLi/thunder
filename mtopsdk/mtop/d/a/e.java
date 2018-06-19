package mtopsdk.mtop.d.a;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;

public final class e {
    public static String a(Map map, String str) {
        if (map == null) {
            return null;
        }
        if (i.b(str)) {
            str = "utf-8";
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            try {
                String encode = URLEncoder.encode((String) entry.getKey(), str);
                String encode2 = URLEncoder.encode((String) entry.getValue(), str);
                stringBuilder.append(encode);
                stringBuilder.append("=");
                stringBuilder.append(encode2);
                if (it.hasNext()) {
                    stringBuilder.append("&");
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder2 = new StringBuilder("[createParamQueryStr]getQueryStr error ---");
                stringBuilder2.append(th.toString());
                j.e(stringBuilder2.toString());
            }
        }
        return stringBuilder.toString();
    }

    public static java.net.URL a(java.lang.String r3, java.util.Map r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = mtopsdk.common.util.i.b(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x000d;
    L_0x0007:
        r3 = "[initUrl]  baseUrl is blank, initUrl error";
        mtopsdk.common.util.j.e(r3);
        return r1;
    L_0x000d:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003b }
        r0.<init>(r3);	 Catch:{ Exception -> 0x003b }
        if (r4 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x003b }
    L_0x0014:
        r2 = "utf-8";	 Catch:{ Exception -> 0x003b }
        r4 = a(r4, r2);	 Catch:{ Exception -> 0x003b }
        r2 = mtopsdk.common.util.i.a(r4);	 Catch:{ Exception -> 0x003b }
        if (r2 == 0) goto L_0x0031;	 Catch:{ Exception -> 0x003b }
    L_0x0020:
        r2 = "?";	 Catch:{ Exception -> 0x003b }
        r3 = r3.indexOf(r2);	 Catch:{ Exception -> 0x003b }
        r2 = -1;	 Catch:{ Exception -> 0x003b }
        if (r3 != r2) goto L_0x0031;	 Catch:{ Exception -> 0x003b }
    L_0x0029:
        r3 = "?";	 Catch:{ Exception -> 0x003b }
        r0.append(r3);	 Catch:{ Exception -> 0x003b }
        r0.append(r4);	 Catch:{ Exception -> 0x003b }
    L_0x0031:
        r3 = new java.net.URL;	 Catch:{ Exception -> 0x003b }
        r4 = r0.toString();	 Catch:{ Exception -> 0x003b }
        r3.<init>(r4);	 Catch:{ Exception -> 0x003b }
        return r3;
    L_0x003b:
        r3 = "[initUrl]initUrl new URL error";
        mtopsdk.common.util.j.f(r3);
        r3 = r1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.d.a.e.a(java.lang.String, java.util.Map):java.net.URL");
    }
}
