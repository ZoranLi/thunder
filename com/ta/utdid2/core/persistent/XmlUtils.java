package com.ta.utdid2.core.persistent;

import android.util.Xml;
import com.alipay.sdk.cons.c;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class XmlUtils {
    XmlUtils() {
    }

    public static void skipCurrentTag(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    public static final int convertValueToList(CharSequence charSequence, String[] strArr, int i) {
        if (charSequence != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (charSequence.equals(strArr[i2])) {
                    return i2;
                }
            }
        }
        return i;
    }

    public static final boolean convertValueToBoolean(CharSequence charSequence, boolean z) {
        if (charSequence == null) {
            return z;
        }
        if (!(charSequence.equals("1") || charSequence.equals("true"))) {
            if (charSequence.equals("TRUE") == null) {
                charSequence = null;
                return charSequence;
            }
        }
        charSequence = true;
        return charSequence;
    }

    public static final int convertValueToInt(CharSequence charSequence, int i) {
        if (charSequence == null) {
            return i;
        }
        int i2;
        int i3;
        charSequence = charSequence.toString();
        i = charSequence.length();
        int i4 = 10;
        if ('-' == charSequence.charAt(0)) {
            i2 = -1;
            i3 = 1;
        } else {
            i3 = 0;
            i2 = 1;
        }
        if ('0' != charSequence.charAt(i3)) {
            if ('#' == charSequence.charAt(i3)) {
                i3++;
            }
            return Integer.parseInt(charSequence.substring(i3), i4) * i2;
        } else if (i3 == i - 1) {
            return 0;
        } else {
            i = i3 + 1;
            char charAt = charSequence.charAt(i);
            if ('x' != charAt) {
                if ('X' != charAt) {
                    i4 = 8;
                    i3 = i;
                    return Integer.parseInt(charSequence.substring(i3), i4) * i2;
                }
            }
            i3 += 2;
        }
        i4 = 16;
        return Integer.parseInt(charSequence.substring(i3), i4) * i2;
    }

    public static final int convertValueToUnsignedInt(String str, int i) {
        return str == null ? i : parseUnsignedIntAttribute(str);
    }

    public static final int parseUnsignedIntAttribute(CharSequence charSequence) {
        charSequence = charSequence.toString();
        int length = charSequence.length();
        int i = 0;
        int i2 = 16;
        if ('0' == charSequence.charAt(0)) {
            if (length - 1 == 0) {
                return 0;
            }
            char charAt = charSequence.charAt(1);
            if ('x' != charAt) {
                if ('X' != charAt) {
                    i2 = 8;
                }
            }
            i = 2;
            return (int) Long.parseLong(charSequence.substring(i), i2);
        } else if ('#' != charSequence.charAt(0)) {
            i2 = 10;
            return (int) Long.parseLong(charSequence.substring(i), i2);
        }
        i = 1;
        return (int) Long.parseLong(charSequence.substring(i), i2);
    }

    public static final void writeMapXml(Map map, OutputStream outputStream) throws XmlPullParserException, IOException {
        XmlSerializer fastXmlSerializer = new FastXmlSerializer();
        fastXmlSerializer.setOutput(outputStream, "utf-8");
        fastXmlSerializer.startDocument(null, Boolean.valueOf(true));
        fastXmlSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeMapXml(map, null, fastXmlSerializer);
        fastXmlSerializer.endDocument();
    }

    public static final void writeListXml(List list, OutputStream outputStream) throws XmlPullParserException, IOException {
        XmlSerializer newSerializer = Xml.newSerializer();
        newSerializer.setOutput(outputStream, "utf-8");
        newSerializer.startDocument(null, Boolean.valueOf(true));
        newSerializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        writeListXml(list, null, newSerializer);
        newSerializer.endDocument();
    }

    public static final void writeMapXml(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (map == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "map");
        if (str != null) {
            xmlSerializer.attribute(null, c.e, str);
        }
        for (Entry entry : map.entrySet()) {
            writeValueXml(entry.getValue(), (String) entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag(null, "map");
    }

    public static final void writeListXml(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (list == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "list");
        if (str != null) {
            xmlSerializer.attribute(null, c.e, str);
        }
        str = list.size();
        for (int i = 0; i < str; i++) {
            writeValueXml(list.get(i), null, xmlSerializer);
        }
        xmlSerializer.endTag(null, "list");
    }

    public static final void writeByteArrayXml(byte[] bArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (bArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute(null, c.e, str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(str));
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            int i = b >> 4;
            stringBuilder.append(i >= 10 ? (i + 97) - 10 : i + 48);
            int i2 = b & 255;
            stringBuilder.append(i2 >= 10 ? (97 + i2) - 10 : 48 + i2);
        }
        xmlSerializer.text(stringBuilder.toString());
        xmlSerializer.endTag(null, "byte-array");
    }

    public static final void writeIntArrayXml(int[] iArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (iArr == null) {
            xmlSerializer.startTag(null, "null");
            xmlSerializer.endTag(null, "null");
            return;
        }
        xmlSerializer.startTag(null, "int-array");
        if (str != null) {
            xmlSerializer.attribute(null, c.e, str);
        }
        xmlSerializer.attribute(null, "num", Integer.toString(str));
        for (int num : iArr) {
            xmlSerializer.startTag(null, "item");
            xmlSerializer.attribute(null, RequestHeaders.COLUMN_VALUE, Integer.toString(num));
            xmlSerializer.endTag(null, "item");
        }
        xmlSerializer.endTag(null, "int-array");
    }

    public static final void writeValueXml(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (obj == null) {
            xmlSerializer.startTag(null, "null");
            if (str != null) {
                xmlSerializer.attribute(null, c.e, str);
            }
            xmlSerializer.endTag(null, "null");
        } else if (obj instanceof String) {
            xmlSerializer.startTag(null, "string");
            if (str != null) {
                xmlSerializer.attribute(null, c.e, str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag(null, "string");
        } else {
            String str2;
            if (obj instanceof Integer) {
                str2 = "int";
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = "float";
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (obj instanceof Boolean) {
                str2 = "boolean";
            } else if (obj instanceof byte[]) {
                writeByteArrayXml((byte[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof int[]) {
                writeIntArrayXml((int[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof Map) {
                writeMapXml((Map) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof List) {
                writeListXml((List) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof CharSequence) {
                xmlSerializer.startTag(null, "string");
                if (str != null) {
                    xmlSerializer.attribute(null, c.e, str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag(null, "string");
                return;
            } else {
                xmlSerializer = new StringBuilder("writeValueXml: unable to write value ");
                xmlSerializer.append(obj);
                throw new RuntimeException(xmlSerializer.toString());
            }
            xmlSerializer.startTag(null, str2);
            if (str != null) {
                xmlSerializer.attribute(null, c.e, str);
            }
            xmlSerializer.attribute(null, RequestHeaders.COLUMN_VALUE, obj.toString());
            xmlSerializer.endTag(null, str2);
        }
    }

    public static final HashMap readMapXml(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (HashMap) readValueXml(newPullParser, new String[1]);
    }

    public static final ArrayList readListXml(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(inputStream, null);
        return (ArrayList) readValueXml(newPullParser, new String[1]);
    }

    public static final HashMap readThisMapXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                Object readThisValueXml = readThisValueXml(xmlPullParser, strArr);
                if (strArr[0] != null) {
                    hashMap.put(strArr[0], readThisValueXml);
                } else {
                    strArr = new StringBuilder("Map value without name attribute: ");
                    strArr.append(xmlPullParser.getName());
                    throw new XmlPullParserException(strArr.toString());
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str) != null) {
                    return hashMap;
                }
                StringBuilder stringBuilder = new StringBuilder("Expected ");
                stringBuilder.append(str);
                stringBuilder.append(" end tag at: ");
                stringBuilder.append(xmlPullParser.getName());
                throw new XmlPullParserException(stringBuilder.toString());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        strArr = new StringBuilder("Document ended before ");
        strArr.append(str);
        strArr.append(" end tag");
        throw new XmlPullParserException(strArr.toString());
    }

    public static final ArrayList readThisListXml(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(readThisValueXml(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str) != null) {
                    return arrayList;
                }
                StringBuilder stringBuilder = new StringBuilder("Expected ");
                stringBuilder.append(str);
                stringBuilder.append(" end tag at: ");
                stringBuilder.append(xmlPullParser.getName());
                throw new XmlPullParserException(stringBuilder.toString());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        strArr = new StringBuilder("Document ended before ");
        strArr.append(str);
        strArr.append(" end tag");
        throw new XmlPullParserException(strArr.toString());
    }

    public static final int[] readThisIntArrayXml(org.xmlpull.v1.XmlPullParser r4, java.lang.String r5, java.lang.String[] r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = "num";	 Catch:{ NullPointerException -> 0x00bb, NumberFormatException -> 0x00b3 }
        r0 = 0;	 Catch:{ NullPointerException -> 0x00bb, NumberFormatException -> 0x00b3 }
        r6 = r4.getAttributeValue(r0, r6);	 Catch:{ NullPointerException -> 0x00bb, NumberFormatException -> 0x00b3 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NullPointerException -> 0x00bb, NumberFormatException -> 0x00b3 }
        r6 = new int[r6];
        r1 = 0;
        r2 = r4.getEventType();
    L_0x0012:
        r3 = 2;
        if (r2 != r3) goto L_0x0056;
    L_0x0015:
        r2 = r4.getName();
        r3 = "item";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003e;
    L_0x0021:
        r2 = "value";	 Catch:{ NullPointerException -> 0x0036, NumberFormatException -> 0x002e }
        r2 = r4.getAttributeValue(r0, r2);	 Catch:{ NullPointerException -> 0x0036, NumberFormatException -> 0x002e }
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NullPointerException -> 0x0036, NumberFormatException -> 0x002e }
        r6[r1] = r2;	 Catch:{ NullPointerException -> 0x0036, NumberFormatException -> 0x002e }
        goto L_0x0093;
    L_0x002e:
        r4 = new org.xmlpull.v1.XmlPullParserException;
        r5 = "Not a number in value attribute in item";
        r4.<init>(r5);
        throw r4;
    L_0x0036:
        r4 = new org.xmlpull.v1.XmlPullParserException;
        r5 = "Need value attribute in item";
        r4.<init>(r5);
        throw r4;
    L_0x003e:
        r5 = new org.xmlpull.v1.XmlPullParserException;
        r6 = new java.lang.StringBuilder;
        r0 = "Expected item tag at: ";
        r6.<init>(r0);
        r4 = r4.getName();
        r6.append(r4);
        r4 = r6.toString();
        r5.<init>(r4);
        throw r5;
    L_0x0056:
        r3 = 3;
        if (r2 != r3) goto L_0x0093;
    L_0x0059:
        r2 = r4.getName();
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x0064;
    L_0x0063:
        return r6;
    L_0x0064:
        r2 = r4.getName();
        r3 = "item";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0073;
    L_0x0070:
        r1 = r1 + 1;
        goto L_0x0093;
    L_0x0073:
        r6 = new org.xmlpull.v1.XmlPullParserException;
        r0 = new java.lang.StringBuilder;
        r1 = "Expected ";
        r0.<init>(r1);
        r0.append(r5);
        r5 = " end tag at: ";
        r0.append(r5);
        r4 = r4.getName();
        r0.append(r4);
        r4 = r0.toString();
        r6.<init>(r4);
        throw r6;
    L_0x0093:
        r2 = r4.next();
        r3 = 1;
        if (r2 != r3) goto L_0x0012;
    L_0x009a:
        r4 = new org.xmlpull.v1.XmlPullParserException;
        r6 = new java.lang.StringBuilder;
        r0 = "Document ended before ";
        r6.<init>(r0);
        r6.append(r5);
        r5 = " end tag";
        r6.append(r5);
        r5 = r6.toString();
        r4.<init>(r5);
        throw r4;
    L_0x00b3:
        r4 = new org.xmlpull.v1.XmlPullParserException;
        r5 = "Not a number in num attribute in byte-array";
        r4.<init>(r5);
        throw r4;
    L_0x00bb:
        r4 = new org.xmlpull.v1.XmlPullParserException;
        r5 = "Need num attribute in byte-array";
        r4.<init>(r5);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.XmlUtils.readThisIntArrayXml(org.xmlpull.v1.XmlPullParser, java.lang.String, java.lang.String[]):int[]");
    }

    public static final java.lang.Object readValueXml(org.xmlpull.v1.XmlPullParser r2, java.lang.String[] r3) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getEventType();
    L_0x0004:
        r1 = 2;
        if (r0 != r1) goto L_0x000c;
    L_0x0007:
        r2 = readThisValueXml(r2, r3);
        return r2;
    L_0x000c:
        r1 = 3;
        if (r0 != r1) goto L_0x0027;
    L_0x000f:
        r3 = new org.xmlpull.v1.XmlPullParserException;
        r0 = new java.lang.StringBuilder;
        r1 = "Unexpected end tag at: ";
        r0.<init>(r1);
        r2 = r2.getName();
        r0.append(r2);
        r2 = r0.toString();
        r3.<init>(r2);
        throw r3;
    L_0x0027:
        r1 = 4;
        if (r0 != r1) goto L_0x0042;
    L_0x002a:
        r3 = new org.xmlpull.v1.XmlPullParserException;
        r0 = new java.lang.StringBuilder;
        r1 = "Unexpected text: ";
        r0.<init>(r1);
        r2 = r2.getText();
        r0.append(r2);
        r2 = r0.toString();
        r3.<init>(r2);
        throw r3;
    L_0x0042:
        r0 = r2.next();	 Catch:{ Exception -> 0x0051 }
        r1 = 1;
        if (r0 != r1) goto L_0x0004;
    L_0x0049:
        r2 = new org.xmlpull.v1.XmlPullParserException;
        r3 = "Unexpected end of document";
        r2.<init>(r3);
        throw r2;
    L_0x0051:
        r3 = new org.xmlpull.v1.XmlPullParserException;
        r0 = new java.lang.StringBuilder;
        r1 = "Unexpected call next(): ";
        r0.<init>(r1);
        r2 = r2.getName();
        r0.append(r2);
        r2 = r0.toString();
        r3.<init>(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.core.persistent.XmlUtils.readValueXml(org.xmlpull.v1.XmlPullParser, java.lang.String[]):java.lang.Object");
    }

    private static final Object readThisValueXml(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        StringBuilder stringBuilder;
        Object obj = null;
        String attributeValue = xmlPullParser.getAttributeValue(null, c.e);
        String name = xmlPullParser.getName();
        if (!name.equals("null")) {
            if (name.equals("string")) {
                obj = "";
                while (true) {
                    int next = xmlPullParser.next();
                    if (next == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    } else if (next == 3) {
                        break;
                    } else if (next == 4) {
                        StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(obj));
                        stringBuilder2.append(xmlPullParser.getText());
                        obj = stringBuilder2.toString();
                    } else if (next == 2) {
                        stringBuilder = new StringBuilder("Unexpected start tag in <string>: ");
                        stringBuilder.append(xmlPullParser.getName());
                        throw new XmlPullParserException(stringBuilder.toString());
                    }
                }
                if (xmlPullParser.getName().equals("string")) {
                    strArr[0] = attributeValue;
                    return obj;
                }
                stringBuilder = new StringBuilder("Unexpected end tag in <string>: ");
                stringBuilder.append(xmlPullParser.getName());
                throw new XmlPullParserException(stringBuilder.toString());
            } else if (name.equals("int")) {
                obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue(null, RequestHeaders.COLUMN_VALUE)));
            } else if (name.equals("long")) {
                obj = Long.valueOf(xmlPullParser.getAttributeValue(null, RequestHeaders.COLUMN_VALUE));
            } else {
                Float f;
                if (name.equals("float")) {
                    f = new Float(xmlPullParser.getAttributeValue(null, RequestHeaders.COLUMN_VALUE));
                } else if (name.equals("double")) {
                    f = new Double(xmlPullParser.getAttributeValue(null, RequestHeaders.COLUMN_VALUE));
                } else if (name.equals("boolean")) {
                    obj = Boolean.valueOf(xmlPullParser.getAttributeValue(null, RequestHeaders.COLUMN_VALUE));
                } else if (name.equals("int-array")) {
                    xmlPullParser.next();
                    xmlPullParser = readThisIntArrayXml(xmlPullParser, "int-array", strArr);
                    strArr[0] = attributeValue;
                    return xmlPullParser;
                } else if (name.equals("map")) {
                    xmlPullParser.next();
                    xmlPullParser = readThisMapXml(xmlPullParser, "map", strArr);
                    strArr[0] = attributeValue;
                    return xmlPullParser;
                } else if (name.equals("list")) {
                    xmlPullParser.next();
                    xmlPullParser = readThisListXml(xmlPullParser, "list", strArr);
                    strArr[0] = attributeValue;
                    return xmlPullParser;
                } else {
                    strArr = new StringBuilder("Unknown tag: ");
                    strArr.append(name);
                    throw new XmlPullParserException(strArr.toString());
                }
                obj = f;
            }
        }
        int next2;
        do {
            next2 = xmlPullParser.next();
            if (next2 == 1) {
                strArr = new StringBuilder("Unexpected end of document in <");
                strArr.append(name);
                strArr.append(">");
                throw new XmlPullParserException(strArr.toString());
            } else if (next2 == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return obj;
                }
                stringBuilder = new StringBuilder("Unexpected end tag in <");
                stringBuilder.append(name);
                stringBuilder.append(">: ");
                stringBuilder.append(xmlPullParser.getName());
                throw new XmlPullParserException(stringBuilder.toString());
            } else if (next2 == 4) {
                stringBuilder = new StringBuilder("Unexpected text in <");
                stringBuilder.append(name);
                stringBuilder.append(">: ");
                stringBuilder.append(xmlPullParser.getName());
                throw new XmlPullParserException(stringBuilder.toString());
            }
        } while (next2 != 2);
        stringBuilder = new StringBuilder("Unexpected start tag in <");
        stringBuilder.append(name);
        stringBuilder.append(">: ");
        stringBuilder.append(xmlPullParser.getName());
        throw new XmlPullParserException(stringBuilder.toString());
    }

    public static final void beginDocument(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        } else if (!xmlPullParser.getName().equals(str)) {
            StringBuilder stringBuilder = new StringBuilder("Unexpected start tag: found ");
            stringBuilder.append(xmlPullParser.getName());
            stringBuilder.append(", expected ");
            stringBuilder.append(str);
            throw new XmlPullParserException(stringBuilder.toString());
        }
    }

    public static final void nextElement(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                return;
            }
        } while (next != 1);
    }
}
