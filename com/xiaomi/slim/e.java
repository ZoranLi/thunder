package com.xiaomi.slim;

import com.xiaomi.smack.a;
import com.xiaomi.smack.l;
import com.xiaomi.smack.packet.d;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;

public class e {
    private XmlPullParser a;

    e() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r3.<init>();
        r0 = org.xmlpull.v1.XmlPullParserFactory.newInstance();	 Catch:{ XmlPullParserException -> 0x0015 }
        r0 = r0.newPullParser();	 Catch:{ XmlPullParserException -> 0x0015 }
        r3.a = r0;	 Catch:{ XmlPullParserException -> 0x0015 }
        r0 = r3.a;	 Catch:{ XmlPullParserException -> 0x0015 }
        r1 = "http://xmlpull.org/v1/doc/features.html#process-namespaces";	 Catch:{ XmlPullParserException -> 0x0015 }
        r2 = 1;	 Catch:{ XmlPullParserException -> 0x0015 }
        r0.setFeature(r1, r2);	 Catch:{ XmlPullParserException -> 0x0015 }
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.slim.e.<init>():void");
    }

    d a(byte[] bArr, a aVar) {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return com.xiaomi.smack.util.a.a(this.a);
            }
            if (name.equals("iq")) {
                return com.xiaomi.smack.util.a.a(this.a, aVar);
            }
            if (name.equals("presence")) {
                return com.xiaomi.smack.util.a.b(this.a);
            }
            if (!this.a.getName().equals("stream")) {
                if (this.a.getName().equals("error")) {
                    throw new l(com.xiaomi.smack.util.a.c(this.a));
                } else if (this.a.getName().equals("warning")) {
                    this.a.next();
                    boolean equals = this.a.getName().equals("multi-login");
                } else {
                    this.a.getName().equals("bind");
                }
            }
        }
        return null;
    }
}
