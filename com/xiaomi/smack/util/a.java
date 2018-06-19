package com.xiaomi.smack.util;

import com.qihoo360.replugin.RePlugin;
import com.xiaomi.push.service.f;
import com.xiaomi.smack.packet.b;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.packet.g;
import com.xiaomi.smack.packet.h;
import com.xiaomi.smack.provider.c;
import com.xunlei.download.DownloadManager;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class a {
    private static XmlPullParser a;

    public static com.xiaomi.smack.packet.a a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a = c.a().a("all", "xm:chat");
        return (a == null || !(a instanceof f)) ? null : ((f) a).b(xmlPullParser);
    }

    public static b a(XmlPullParser xmlPullParser, com.xiaomi.smack.a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", AgooConstants.MESSAGE_ID);
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        com.xiaomi.smack.packet.b.a a = com.xiaomi.smack.packet.b.a.a(xmlPullParser.getAttributeValue("", "type"));
        Map hashMap = new HashMap();
        Object obj = null;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        b bVar = null;
        h hVar = bVar;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    hVar = d(xmlPullParser);
                } else {
                    bVar = new b();
                    bVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                obj = 1;
            }
        }
        if (bVar == null) {
            if (com.xiaomi.smack.packet.b.a.a != a) {
                if (com.xiaomi.smack.packet.b.a.b != a) {
                    bVar = new c();
                }
            }
            d bVar2 = new b();
            bVar2.k(attributeValue);
            bVar2.m(attributeValue3);
            bVar2.n(attributeValue2);
            bVar2.a(com.xiaomi.smack.packet.b.a.d);
            bVar2.l(attributeValue4);
            bVar2.a(new h(com.xiaomi.smack.packet.h.a.e));
            aVar.a(bVar2);
            com.xiaomi.channel.commonutils.logger.b.d("iq usage error. send packet in packet parser.");
            return null;
        }
        bVar.k(attributeValue);
        bVar.m(attributeValue2);
        bVar.l(attributeValue4);
        bVar.n(attributeValue3);
        bVar.a(a);
        bVar.a(hVar);
        bVar.a(hashMap);
        return bVar;
    }

    public static com.xiaomi.smack.packet.d a(org.xmlpull.v1.XmlPullParser r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "1";
        r1 = "";
        r2 = "s";
        r1 = r14.getAttributeValue(r1, r2);
        r0 = r0.equals(r1);
        r1 = 3;
        r2 = 2;
        r3 = 0;
        r4 = 1;
        r5 = 0;
        if (r0 == 0) goto L_0x00f4;
    L_0x0015:
        r0 = "";
        r6 = "chid";
        r0 = r14.getAttributeValue(r0, r6);
        r6 = "";
        r7 = "id";
        r6 = r14.getAttributeValue(r6, r7);
        r7 = "";
        r8 = "from";
        r7 = r14.getAttributeValue(r7, r8);
        r8 = "";
        r9 = "to";
        r8 = r14.getAttributeValue(r8, r9);
        r9 = "";
        r10 = "type";
        r9 = r14.getAttributeValue(r9, r10);
        r10 = com.xiaomi.push.service.ap.a();
        r10 = r10.b(r0, r8);
        if (r10 != 0) goto L_0x004f;
    L_0x0047:
        r10 = com.xiaomi.push.service.ap.a();
        r10 = r10.b(r0, r7);
    L_0x004f:
        if (r10 != 0) goto L_0x0059;
    L_0x0051:
        r14 = new com.xiaomi.smack.l;
        r0 = "the channel id is wrong while receiving a encrypted message";
        r14.<init>(r0);
        throw r14;
    L_0x0059:
        r11 = r5;
    L_0x005a:
        if (r3 != 0) goto L_0x00e9;
    L_0x005c:
        r12 = r14.next();
        if (r12 != r2) goto L_0x00d8;
    L_0x0062:
        r11 = r14.getName();
        r12 = "s";
        r11 = r12.equals(r11);
        if (r11 != 0) goto L_0x0076;
    L_0x006e:
        r14 = new com.xiaomi.smack.l;
        r0 = "error while receiving a encrypted message with wrong format";
        r14.<init>(r0);
        throw r14;
    L_0x0076:
        r11 = r14.next();
        r12 = 4;
        if (r11 == r12) goto L_0x0085;
    L_0x007d:
        r14 = new com.xiaomi.smack.l;
        r0 = "error while receiving a encrypted message with wrong format";
        r14.<init>(r0);
        throw r14;
    L_0x0085:
        r11 = r14.getText();
        r12 = "5";
        r12 = r12.equals(r0);
        if (r12 != 0) goto L_0x00b3;
    L_0x0091:
        r12 = "6";
        r12 = r12.equals(r0);
        if (r12 == 0) goto L_0x009a;
    L_0x0099:
        goto L_0x00b3;
    L_0x009a:
        r12 = r10.i;
        r12 = com.xiaomi.push.service.aw.a(r12, r6);
        r11 = com.xiaomi.push.service.aw.a(r12, r11);
        a(r11);
        r11 = a;
        r11.next();
        r11 = a;
        r11 = a(r11);
        goto L_0x005a;
    L_0x00b3:
        r14 = new com.xiaomi.smack.packet.c;
        r14.<init>();
        r14.l(r0);
        r14.b(r4);
        r14.n(r7);
        r14.m(r8);
        r14.k(r6);
        r14.f(r9);
        r0 = new com.xiaomi.smack.packet.a;
        r1 = "s";
        r0.<init>(r1, r5, r5, r5);
        r0.b(r11);
        r14.a(r0);
        return r14;
    L_0x00d8:
        if (r12 != r1) goto L_0x005a;
    L_0x00da:
        r12 = r14.getName();
        r13 = "message";
        r12 = r12.equals(r13);
        if (r12 == 0) goto L_0x005a;
    L_0x00e6:
        r3 = r4;
        goto L_0x005a;
    L_0x00e9:
        if (r11 == 0) goto L_0x00ec;
    L_0x00eb:
        return r11;
    L_0x00ec:
        r14 = new com.xiaomi.smack.l;
        r0 = "error while receiving a encrypted message with wrong format";
        r14.<init>(r0);
        throw r14;
    L_0x00f4:
        r0 = new com.xiaomi.smack.packet.c;
        r0.<init>();
        r6 = "";
        r7 = "id";
        r6 = r14.getAttributeValue(r6, r7);
        if (r6 != 0) goto L_0x0105;
    L_0x0103:
        r6 = "ID_NOT_AVAILABLE";
    L_0x0105:
        r0.k(r6);
        r6 = "";
        r7 = "to";
        r6 = r14.getAttributeValue(r6, r7);
        r0.m(r6);
        r6 = "";
        r7 = "from";
        r6 = r14.getAttributeValue(r6, r7);
        r0.n(r6);
        r6 = "";
        r7 = "chid";
        r6 = r14.getAttributeValue(r6, r7);
        r0.l(r6);
        r6 = "";
        r7 = "appid";
        r6 = r14.getAttributeValue(r6, r7);
        r0.a(r6);
        r6 = "";	 Catch:{ Exception -> 0x013d }
        r7 = "transient";	 Catch:{ Exception -> 0x013d }
        r6 = r14.getAttributeValue(r6, r7);	 Catch:{ Exception -> 0x013d }
        goto L_0x013e;
    L_0x013d:
        r6 = r5;
    L_0x013e:
        r7 = "";	 Catch:{ Exception -> 0x014f }
        r8 = "seq";	 Catch:{ Exception -> 0x014f }
        r7 = r14.getAttributeValue(r7, r8);	 Catch:{ Exception -> 0x014f }
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Exception -> 0x014f }
        if (r8 != 0) goto L_0x014f;	 Catch:{ Exception -> 0x014f }
    L_0x014c:
        r0.b(r7);	 Catch:{ Exception -> 0x014f }
    L_0x014f:
        r7 = "";	 Catch:{ Exception -> 0x0160 }
        r8 = "mseq";	 Catch:{ Exception -> 0x0160 }
        r7 = r14.getAttributeValue(r7, r8);	 Catch:{ Exception -> 0x0160 }
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Exception -> 0x0160 }
        if (r8 != 0) goto L_0x0160;	 Catch:{ Exception -> 0x0160 }
    L_0x015d:
        r0.c(r7);	 Catch:{ Exception -> 0x0160 }
    L_0x0160:
        r7 = "";	 Catch:{ Exception -> 0x0171 }
        r8 = "fseq";	 Catch:{ Exception -> 0x0171 }
        r7 = r14.getAttributeValue(r7, r8);	 Catch:{ Exception -> 0x0171 }
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Exception -> 0x0171 }
        if (r8 != 0) goto L_0x0171;	 Catch:{ Exception -> 0x0171 }
    L_0x016e:
        r0.d(r7);	 Catch:{ Exception -> 0x0171 }
    L_0x0171:
        r7 = "";	 Catch:{ Exception -> 0x0182 }
        r8 = "status";	 Catch:{ Exception -> 0x0182 }
        r7 = r14.getAttributeValue(r7, r8);	 Catch:{ Exception -> 0x0182 }
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Exception -> 0x0182 }
        if (r8 != 0) goto L_0x0182;	 Catch:{ Exception -> 0x0182 }
    L_0x017f:
        r0.e(r7);	 Catch:{ Exception -> 0x0182 }
    L_0x0182:
        r7 = android.text.TextUtils.isEmpty(r6);
        if (r7 != 0) goto L_0x0192;
    L_0x0188:
        r7 = "true";
        r6 = r6.equalsIgnoreCase(r7);
        if (r6 == 0) goto L_0x0192;
    L_0x0190:
        r6 = r4;
        goto L_0x0193;
    L_0x0192:
        r6 = r3;
    L_0x0193:
        r0.a(r6);
        r6 = "";
        r7 = "type";
        r6 = r14.getAttributeValue(r6, r7);
        r0.f(r6);
        r6 = f(r14);
        if (r6 == 0) goto L_0x01b7;
    L_0x01a7:
        r7 = "";
        r8 = r6.trim();
        r7 = r7.equals(r8);
        if (r7 != 0) goto L_0x01b7;
    L_0x01b3:
        r0.j(r6);
        goto L_0x01ba;
    L_0x01b7:
        com.xiaomi.smack.packet.d.u();
    L_0x01ba:
        if (r3 != 0) goto L_0x023f;
    L_0x01bc:
        r6 = r14.next();
        if (r6 != r2) goto L_0x022e;
    L_0x01c2:
        r6 = r14.getName();
        r7 = r14.getNamespace();
        r8 = android.text.TextUtils.isEmpty(r7);
        if (r8 == 0) goto L_0x01d2;
    L_0x01d0:
        r7 = "xm";
    L_0x01d2:
        r8 = "subject";
        r8 = r6.equals(r8);
        if (r8 == 0) goto L_0x01e5;
    L_0x01da:
        f(r14);
        r6 = e(r14);
        r0.g(r6);
        goto L_0x01ba;
    L_0x01e5:
        r8 = "body";
        r8 = r6.equals(r8);
        if (r8 == 0) goto L_0x0207;
    L_0x01ed:
        r6 = "";
        r7 = "encode";
        r6 = r14.getAttributeValue(r6, r7);
        r7 = e(r14);
        r8 = android.text.TextUtils.isEmpty(r6);
        if (r8 != 0) goto L_0x0203;
    L_0x01ff:
        r0.a(r7, r6);
        goto L_0x01ba;
    L_0x0203:
        r0.h(r7);
        goto L_0x01ba;
    L_0x0207:
        r8 = "thread";
        r8 = r6.equals(r8);
        if (r8 == 0) goto L_0x0216;
    L_0x020f:
        if (r5 != 0) goto L_0x01ba;
    L_0x0211:
        r5 = r14.nextText();
        goto L_0x01ba;
    L_0x0216:
        r8 = "error";
        r8 = r6.equals(r8);
        if (r8 == 0) goto L_0x0226;
    L_0x021e:
        r6 = d(r14);
        r0.a(r6);
        goto L_0x01ba;
    L_0x0226:
        r6 = a(r6, r7, r14);
        r0.a(r6);
        goto L_0x01ba;
    L_0x022e:
        if (r6 != r1) goto L_0x01ba;
    L_0x0230:
        r6 = r14.getName();
        r7 = "message";
        r6 = r6.equals(r7);
        if (r6 == 0) goto L_0x01ba;
    L_0x023c:
        r3 = r4;
        goto L_0x01ba;
    L_0x023f:
        r0.i(r5);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.util.a.a(org.xmlpull.v1.XmlPullParser):com.xiaomi.smack.packet.d");
    }

    private static void a(byte[] bArr) {
        if (a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static com.xiaomi.smack.packet.f b(org.xmlpull.v1.XmlPullParser r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xiaomi.smack.packet.f.b.available;
        r1 = "";
        r2 = "type";
        r1 = r7.getAttributeValue(r1, r2);
        if (r1 == 0) goto L_0x002d;
    L_0x000c:
        r2 = "";
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x002d;
    L_0x0014:
        r2 = com.xiaomi.smack.packet.f.b.valueOf(r1);	 Catch:{ IllegalArgumentException -> 0x001a }
        r0 = r2;
        goto L_0x002d;
    L_0x001a:
        r2 = java.lang.System.err;
        r3 = new java.lang.StringBuilder;
        r4 = "Found invalid presence type ";
        r3.<init>(r4);
        r3.append(r1);
        r1 = r3.toString();
        r2.println(r1);
    L_0x002d:
        r1 = new com.xiaomi.smack.packet.f;
        r1.<init>(r0);
        r0 = "";
        r2 = "to";
        r0 = r7.getAttributeValue(r0, r2);
        r1.m(r0);
        r0 = "";
        r2 = "from";
        r0 = r7.getAttributeValue(r0, r2);
        r1.n(r0);
        r0 = "";
        r2 = "chid";
        r0 = r7.getAttributeValue(r0, r2);
        r1.l(r0);
        r0 = "";
        r2 = "id";
        r0 = r7.getAttributeValue(r0, r2);
        if (r0 != 0) goto L_0x005f;
    L_0x005d:
        r0 = "ID_NOT_AVAILABLE";
    L_0x005f:
        r1.k(r0);
        r0 = 0;
        r2 = r0;
    L_0x0064:
        if (r2 != 0) goto L_0x00ef;
    L_0x0066:
        r3 = r7.next();
        r4 = 2;
        if (r3 != r4) goto L_0x00dd;
    L_0x006d:
        r3 = r7.getName();
        r4 = r7.getNamespace();
        r5 = "status";
        r5 = r3.equals(r5);
        if (r5 == 0) goto L_0x0085;
    L_0x007d:
        r3 = r7.nextText();
        r1.a(r3);
        goto L_0x0064;
    L_0x0085:
        r5 = "priority";
        r5 = r3.equals(r5);
        if (r5 == 0) goto L_0x009d;
    L_0x008d:
        r3 = r7.nextText();	 Catch:{ NumberFormatException -> 0x0064, IllegalArgumentException -> 0x0099 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0064, IllegalArgumentException -> 0x0099 }
        r1.a(r3);	 Catch:{ NumberFormatException -> 0x0064, IllegalArgumentException -> 0x0099 }
        goto L_0x0064;
    L_0x0099:
        r1.a(r0);
        goto L_0x0064;
    L_0x009d:
        r5 = "show";
        r5 = r3.equals(r5);
        if (r5 == 0) goto L_0x00c5;
    L_0x00a5:
        r3 = r7.nextText();
        r4 = com.xiaomi.smack.packet.f.a.valueOf(r3);	 Catch:{ IllegalArgumentException -> 0x00b1 }
        r1.a(r4);	 Catch:{ IllegalArgumentException -> 0x00b1 }
        goto L_0x0064;
    L_0x00b1:
        r4 = java.lang.System.err;
        r5 = new java.lang.StringBuilder;
        r6 = "Found invalid presence mode ";
        r5.<init>(r6);
        r5.append(r3);
        r3 = r5.toString();
        r4.println(r3);
        goto L_0x0064;
    L_0x00c5:
        r5 = "error";
        r5 = r3.equals(r5);
        if (r5 == 0) goto L_0x00d5;
    L_0x00cd:
        r3 = d(r7);
        r1.a(r3);
        goto L_0x0064;
    L_0x00d5:
        r3 = a(r3, r4, r7);
        r1.a(r3);
        goto L_0x0064;
    L_0x00dd:
        r4 = 3;
        if (r3 != r4) goto L_0x0064;
    L_0x00e0:
        r3 = r7.getName();
        r4 = "presence";
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0064;
    L_0x00ec:
        r2 = 1;
        goto L_0x0064;
    L_0x00ef:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.util.a.b(org.xmlpull.v1.XmlPullParser):com.xiaomi.smack.packet.f");
    }

    public static g c(XmlPullParser xmlPullParser) {
        g gVar = null;
        Object obj = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                gVar = new g(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                obj = 1;
            }
        }
        return gVar;
    }

    public static h d(XmlPullParser xmlPullParser) {
        String str = RePlugin.PROCESS_UI;
        List arrayList = new ArrayList();
        Object obj = null;
        String str2 = str;
        String str3 = null;
        String str4 = str3;
        for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
            if (xmlPullParser.getAttributeName(i).equals("code")) {
                str2 = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i).equals(DownloadManager.COLUMN_REASON)) {
                str4 = xmlPullParser.getAttributeValue("", DownloadManager.COLUMN_REASON);
            }
        }
        str = null;
        String str5 = str;
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    obj = 1;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new h(Integer.parseInt(str2), str3 == null ? "cancel" : str3, str4, str, str5, arrayList);
    }

    private static String e(XmlPullParser xmlPullParser) {
        String str = "";
        int depth = xmlPullParser.getDepth();
        while (true) {
            if (xmlPullParser.next() == 3) {
                if (xmlPullParser.getDepth() == depth) {
                    return str;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(xmlPullParser.getText());
            str = stringBuilder.toString();
        }
    }

    private static String f(XmlPullParser xmlPullParser) {
        int i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            String attributeName = xmlPullParser.getAttributeName(i);
            if (!"xml:lang".equals(attributeName)) {
                if (!"lang".equals(attributeName) || !"xml".equals(xmlPullParser.getAttributePrefix(i))) {
                    i++;
                }
            }
            return xmlPullParser.getAttributeValue(i);
        }
        return null;
    }
}
