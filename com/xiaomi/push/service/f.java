package com.xiaomi.push.service;

import com.xiaomi.smack.packet.a;
import com.xiaomi.smack.provider.b;
import com.xiaomi.smack.provider.c;
import com.xiaomi.smack.util.d;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class f implements b {
    public static a a(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() != 2) {
            return null;
        }
        String[] strArr;
        String str;
        List list;
        String[] strArr2;
        String name = xmlPullParser.getName();
        String namespace = xmlPullParser.getNamespace();
        if (xmlPullParser.getAttributeCount() > 0) {
            String[] strArr3 = new String[xmlPullParser.getAttributeCount()];
            String[] strArr4 = new String[xmlPullParser.getAttributeCount()];
            for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                strArr3[i] = xmlPullParser.getAttributeName(i);
                strArr4[i] = d.b(xmlPullParser.getAttributeValue(i));
            }
            strArr = strArr3;
            str = null;
            list = str;
            strArr2 = strArr4;
        } else {
            strArr = null;
            strArr2 = strArr;
            str = strArr2;
            list = str;
        }
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3) {
                return new a(name, namespace, strArr, strArr2, str, list);
            }
            if (next == 4) {
                str = xmlPullParser.getText().trim();
            } else if (next == 2) {
                if (list == null) {
                    list = new ArrayList();
                }
                a a = a(xmlPullParser);
                if (a != null) {
                    list.add(a);
                }
            }
        }
    }

    public void a() {
        c.a().a("all", "xm:chat", this);
    }

    public a b(XmlPullParser xmlPullParser) {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1 && eventType != 2) {
            eventType = xmlPullParser.next();
        }
        return eventType == 2 ? a(xmlPullParser) : null;
    }
}
