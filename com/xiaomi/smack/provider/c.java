package com.xiaomi.smack.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class c {
    private static c a;
    private Map<String, Object> b = new ConcurrentHashMap();
    private Map<String, Object> c = new ConcurrentHashMap();

    private c() {
        b();
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c();
            }
            cVar = a;
        }
        return cVar;
    }

    private String b(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<");
        stringBuilder.append(str);
        stringBuilder.append("/>");
        if (str != null) {
            stringBuilder.append("<");
            stringBuilder.append(str2);
            stringBuilder.append("/>");
        }
        return stringBuilder.toString();
    }

    private ClassLoader[] c() {
        r1 = new ClassLoader[2];
        int i = 0;
        r1[0] = c.class.getClassLoader();
        r1[1] = Thread.currentThread().getContextClassLoader();
        List arrayList = new ArrayList();
        while (i < 2) {
            Object obj = r1[i];
            if (obj != null) {
                arrayList.add(obj);
            }
            i++;
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public Object a(String str, String str2) {
        return this.b.get(b(str, str2));
    }

    public void a(String str, String str2, Object obj) {
        if ((obj instanceof b) || (obj instanceof Class)) {
            this.b.put(b(str, str2), obj);
            return;
        }
        throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
    }

    protected void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = r10.c();	 Catch:{ Exception -> 0x0108 }
        r1 = r0.length;	 Catch:{ Exception -> 0x0108 }
        r2 = 0;	 Catch:{ Exception -> 0x0108 }
    L_0x0006:
        if (r2 >= r1) goto L_0x0107;	 Catch:{ Exception -> 0x0108 }
    L_0x0008:
        r3 = r0[r2];	 Catch:{ Exception -> 0x0108 }
        r4 = "META-INF/smack.providers";	 Catch:{ Exception -> 0x0108 }
        r3 = r3.getResources(r4);	 Catch:{ Exception -> 0x0108 }
    L_0x0010:
        r4 = r3.hasMoreElements();	 Catch:{ Exception -> 0x0108 }
        if (r4 == 0) goto L_0x0103;	 Catch:{ Exception -> 0x0108 }
    L_0x0016:
        r4 = r3.nextElement();	 Catch:{ Exception -> 0x0108 }
        r4 = (java.net.URL) r4;	 Catch:{ Exception -> 0x0108 }
        r5 = 0;
        r4 = r4.openStream();	 Catch:{ all -> 0x00fd }
        r5 = org.xmlpull.v1.XmlPullParserFactory.newInstance();	 Catch:{ all -> 0x00fb }
        r5 = r5.newPullParser();	 Catch:{ all -> 0x00fb }
        r6 = "http://xmlpull.org/v1/doc/features.html#process-namespaces";	 Catch:{ all -> 0x00fb }
        r7 = 1;	 Catch:{ all -> 0x00fb }
        r5.setFeature(r6, r7);	 Catch:{ all -> 0x00fb }
        r6 = "UTF-8";	 Catch:{ all -> 0x00fb }
        r5.setInput(r4, r6);	 Catch:{ all -> 0x00fb }
        r6 = r5.getEventType();	 Catch:{ all -> 0x00fb }
    L_0x0038:
        r8 = 2;	 Catch:{ all -> 0x00fb }
        if (r6 != r8) goto L_0x00f0;	 Catch:{ all -> 0x00fb }
    L_0x003b:
        r6 = r5.getName();	 Catch:{ all -> 0x00fb }
        r8 = "iqProvider";	 Catch:{ all -> 0x00fb }
        r6 = r6.equals(r8);	 Catch:{ all -> 0x00fb }
        if (r6 == 0) goto L_0x0097;	 Catch:{ all -> 0x00fb }
    L_0x0047:
        r5.next();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r6 = r5.nextText();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r8 = r5.nextText();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r9 = r5.nextText();	 Catch:{ all -> 0x00fb }
        r6 = r10.b(r6, r8);	 Catch:{ all -> 0x00fb }
        r8 = r10.c;	 Catch:{ all -> 0x00fb }
        r8 = r8.containsKey(r6);	 Catch:{ all -> 0x00fb }
        if (r8 != 0) goto L_0x00f0;
    L_0x0071:
        r8 = java.lang.Class.forName(r9);	 Catch:{ ClassNotFoundException -> 0x0092 }
        r9 = com.xiaomi.smack.provider.a.class;	 Catch:{ ClassNotFoundException -> 0x0092 }
        r9 = r9.isAssignableFrom(r8);	 Catch:{ ClassNotFoundException -> 0x0092 }
        if (r9 == 0) goto L_0x0087;	 Catch:{ ClassNotFoundException -> 0x0092 }
    L_0x007d:
        r9 = r10.c;	 Catch:{ ClassNotFoundException -> 0x0092 }
        r8 = r8.newInstance();	 Catch:{ ClassNotFoundException -> 0x0092 }
    L_0x0083:
        r9.put(r6, r8);	 Catch:{ ClassNotFoundException -> 0x0092 }
        goto L_0x00f0;	 Catch:{ ClassNotFoundException -> 0x0092 }
    L_0x0087:
        r9 = com.xiaomi.smack.packet.b.class;	 Catch:{ ClassNotFoundException -> 0x0092 }
        r9 = r9.isAssignableFrom(r8);	 Catch:{ ClassNotFoundException -> 0x0092 }
        if (r9 == 0) goto L_0x00f0;	 Catch:{ ClassNotFoundException -> 0x0092 }
    L_0x008f:
        r9 = r10.c;	 Catch:{ ClassNotFoundException -> 0x0092 }
        goto L_0x0083;
    L_0x0092:
        r6 = move-exception;
    L_0x0093:
        r6.printStackTrace();	 Catch:{ all -> 0x00fb }
        goto L_0x00f0;	 Catch:{ all -> 0x00fb }
    L_0x0097:
        r6 = r5.getName();	 Catch:{ all -> 0x00fb }
        r8 = "extensionProvider";	 Catch:{ all -> 0x00fb }
        r6 = r6.equals(r8);	 Catch:{ all -> 0x00fb }
        if (r6 == 0) goto L_0x00f0;	 Catch:{ all -> 0x00fb }
    L_0x00a3:
        r5.next();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r6 = r5.nextText();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r8 = r5.nextText();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r5.next();	 Catch:{ all -> 0x00fb }
        r9 = r5.nextText();	 Catch:{ all -> 0x00fb }
        r6 = r10.b(r6, r8);	 Catch:{ all -> 0x00fb }
        r8 = r10.b;	 Catch:{ all -> 0x00fb }
        r8 = r8.containsKey(r6);	 Catch:{ all -> 0x00fb }
        if (r8 != 0) goto L_0x00f0;
    L_0x00cd:
        r8 = java.lang.Class.forName(r9);	 Catch:{ ClassNotFoundException -> 0x00ee }
        r9 = com.xiaomi.smack.provider.b.class;	 Catch:{ ClassNotFoundException -> 0x00ee }
        r9 = r9.isAssignableFrom(r8);	 Catch:{ ClassNotFoundException -> 0x00ee }
        if (r9 == 0) goto L_0x00e3;	 Catch:{ ClassNotFoundException -> 0x00ee }
    L_0x00d9:
        r9 = r10.b;	 Catch:{ ClassNotFoundException -> 0x00ee }
        r8 = r8.newInstance();	 Catch:{ ClassNotFoundException -> 0x00ee }
    L_0x00df:
        r9.put(r6, r8);	 Catch:{ ClassNotFoundException -> 0x00ee }
        goto L_0x00f0;	 Catch:{ ClassNotFoundException -> 0x00ee }
    L_0x00e3:
        r9 = com.xiaomi.smack.packet.e.class;	 Catch:{ ClassNotFoundException -> 0x00ee }
        r9 = r9.isAssignableFrom(r8);	 Catch:{ ClassNotFoundException -> 0x00ee }
        if (r9 == 0) goto L_0x00f0;	 Catch:{ ClassNotFoundException -> 0x00ee }
    L_0x00eb:
        r9 = r10.b;	 Catch:{ ClassNotFoundException -> 0x00ee }
        goto L_0x00df;
    L_0x00ee:
        r6 = move-exception;
        goto L_0x0093;
    L_0x00f0:
        r6 = r5.next();	 Catch:{ all -> 0x00fb }
        if (r6 != r7) goto L_0x0038;
    L_0x00f6:
        r4.close();	 Catch:{ Exception -> 0x0010 }
        goto L_0x0010;
    L_0x00fb:
        r0 = move-exception;
        goto L_0x00ff;
    L_0x00fd:
        r0 = move-exception;
        r4 = r5;
    L_0x00ff:
        r4.close();	 Catch:{ Exception -> 0x0102 }
    L_0x0102:
        throw r0;	 Catch:{ Exception -> 0x0108 }
    L_0x0103:
        r2 = r2 + 1;
        goto L_0x0006;
    L_0x0107:
        return;
    L_0x0108:
        r0 = move-exception;
        r0.printStackTrace();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.provider.c.b():void");
    }
}
