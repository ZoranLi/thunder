package com.huawei.hms.update.a;

import com.huawei.hms.c.c;
import com.huawei.hms.support.log.a;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: FilelistResponse */
class d {
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private int h = 0;

    d() {
    }

    public String a() {
        return this.b;
    }

    public int b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.c;	 Catch:{ NumberFormatException -> 0x0007 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0007 }
        return r0;
    L_0x0007:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.a.d.b():int");
    }

    public String c() {
        return this.d;
    }

    public int d() {
        return this.h;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        stringBuilder.append("Name: ");
        stringBuilder.append(this.a);
        stringBuilder.append(", ");
        stringBuilder.append("File: ");
        stringBuilder.append(this.b);
        stringBuilder.append(", ");
        stringBuilder.append("Size: ");
        stringBuilder.append(this.c);
        stringBuilder.append(", ");
        stringBuilder.append("Hash: ");
        stringBuilder.append(this.d);
        stringBuilder.append(", ");
        stringBuilder.append("PackageName: ");
        stringBuilder.append(this.e);
        stringBuilder.append(", ");
        stringBuilder.append("PackageType: ");
        stringBuilder.append(this.f);
        stringBuilder.append(", ");
        stringBuilder.append("VersionName: ");
        stringBuilder.append(this.g);
        stringBuilder.append(", ");
        stringBuilder.append("VersionCode: ");
        stringBuilder.append(this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static d a(String str) {
        d dVar = new d();
        InputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes(Charset.defaultCharset()));
        try {
            str = XmlPullParserFactory.newInstance().newPullParser();
            str.setInput(byteArrayInputStream, "UTF-8");
            for (int eventType = str.getEventType(); eventType != 1; eventType = str.next()) {
                if (eventType == 2) {
                    a(dVar, str);
                }
            }
            return dVar;
        } catch (String str2) {
            dVar = "FilelistResponse";
            StringBuilder stringBuilder = new StringBuilder("In parseResponse, Failed to parse xml for get-filelist response.");
            stringBuilder.append(str2.getMessage());
            a.d(dVar, stringBuilder.toString());
            str2 = new d();
            return str2;
        } finally {
            c.a(byteArrayInputStream);
        }
    }

    private static void a(d dVar, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (xmlPullParser.getDepth() == 3 && com.alipay.sdk.cons.c.e.equals(name)) {
            dVar.a = xmlPullParser.nextText();
        }
        if (xmlPullParser.getDepth() == 4) {
            if ("spath".equals(name)) {
                dVar.b = xmlPullParser.nextText();
            } else if ("size".equals(name)) {
                dVar.c = xmlPullParser.nextText();
            } else if ("sha256".equals(name)) {
                dVar.d = xmlPullParser.nextText();
            } else if (Constants.KEY_PACKAGE_NAME.equals(name)) {
                dVar.e = xmlPullParser.nextText();
            } else if ("packageType".equals(name)) {
                dVar.f = xmlPullParser.nextText();
            } else if ("versionName".equals(name)) {
                dVar.g = xmlPullParser.nextText();
            } else if ("versionCode".equals(name)) {
                dVar.h = b(xmlPullParser.nextText());
            }
        }
    }

    private static int b(java.lang.String r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0005 }
        return r0;
    L_0x0005:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.a.d.b(java.lang.String):int");
    }
}
