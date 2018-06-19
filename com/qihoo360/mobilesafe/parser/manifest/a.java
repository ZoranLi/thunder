package com.qihoo360.mobilesafe.parser.manifest;

import android.content.IntentFilter;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.qihoo360.mobilesafe.parser.manifest.a.b;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: XmlHandler */
final class a extends DefaultHandler {
    ArrayList<com.qihoo360.mobilesafe.parser.manifest.a.a> a;
    ArrayList<com.qihoo360.mobilesafe.parser.manifest.a.a> b;
    ArrayList<com.qihoo360.mobilesafe.parser.manifest.a.a> c;
    private String d;
    private com.qihoo360.mobilesafe.parser.manifest.a.a e;
    private IntentFilter f;
    private List<IntentFilter> g;
    private List<String> h;
    private List<String> i;
    private List<b> j;

    a() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void startElement(java.lang.String r1, java.lang.String r2, java.lang.String r3, org.xml.sax.Attributes r4) throws org.xml.sax.SAXException {
        /*
        r0 = this;
        super.startElement(r1, r2, r3, r4);
        r1 = r3.hashCode();
        switch(r1) {
            case -1655966961: goto L_0x0051;
            case -1422950858: goto L_0x0047;
            case -1029793847: goto L_0x003d;
            case -808719889: goto L_0x0033;
            case 3076010: goto L_0x0029;
            case 50511102: goto L_0x001f;
            case 130625071: goto L_0x0015;
            case 1984153269: goto L_0x000b;
            default: goto L_0x000a;
        };
    L_0x000a:
        goto L_0x005b;
    L_0x000b:
        r1 = "service";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x0013:
        r1 = 2;
        goto L_0x005c;
    L_0x0015:
        r1 = "manifest";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x001d:
        r1 = 0;
        goto L_0x005c;
    L_0x001f:
        r1 = "category";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x0027:
        r1 = 6;
        goto L_0x005c;
    L_0x0029:
        r1 = "data";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x0031:
        r1 = 7;
        goto L_0x005c;
    L_0x0033:
        r1 = "receiver";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x003b:
        r1 = 3;
        goto L_0x005c;
    L_0x003d:
        r1 = "intent-filter";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x0045:
        r1 = 4;
        goto L_0x005c;
    L_0x0047:
        r1 = "action";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x004f:
        r1 = 5;
        goto L_0x005c;
    L_0x0051:
        r1 = "activity";
        r1 = r3.equals(r1);
        if (r1 == 0) goto L_0x005b;
    L_0x0059:
        r1 = 1;
        goto L_0x005c;
    L_0x005b:
        r1 = -1;
    L_0x005c:
        switch(r1) {
            case 0: goto L_0x0177;
            case 1: goto L_0x0149;
            case 2: goto L_0x011b;
            case 3: goto L_0x00ed;
            case 4: goto L_0x00de;
            case 5: goto L_0x00c7;
            case 6: goto L_0x00b0;
            case 7: goto L_0x0061;
            default: goto L_0x005f;
        };
    L_0x005f:
        goto L_0x0180;
    L_0x0061:
        r1 = r0.j;
        if (r1 != 0) goto L_0x006c;
    L_0x0065:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.j = r1;
    L_0x006c:
        r1 = new com.qihoo360.mobilesafe.parser.manifest.a.b;
        r1.<init>();
        r2 = "android:scheme";
        r2 = r4.getValue(r2);
        r1.a = r2;
        r2 = "android:mimeType";
        r2 = r4.getValue(r2);
        r1.d = r2;
        r2 = "android:host";
        r2 = r4.getValue(r2);
        r1.b = r2;
        r2 = "android:port";
        r2 = r4.getValue(r2);
        r1.c = r2;
        r2 = "android:path";
        r2 = r4.getValue(r2);
        r1.e = r2;
        r2 = "android:pathPattern";
        r2 = r4.getValue(r2);
        r1.f = r2;
        r2 = "android:pathPrefix";
        r2 = r4.getValue(r2);
        r1.g = r2;
        r2 = r0.j;
        r2.add(r1);
        goto L_0x0180;
    L_0x00b0:
        r1 = r0.i;
        if (r1 != 0) goto L_0x00bb;
    L_0x00b4:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.i = r1;
    L_0x00bb:
        r1 = r0.i;
        r2 = "android:name";
        r2 = r4.getValue(r2);
        r1.add(r2);
        return;
    L_0x00c7:
        r1 = r0.h;
        if (r1 != 0) goto L_0x00d2;
    L_0x00cb:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.h = r1;
    L_0x00d2:
        r1 = r0.h;
        r2 = "android:name";
        r2 = r4.getValue(r2);
        r1.add(r2);
        return;
    L_0x00de:
        r1 = new android.content.IntentFilter;
        r1.<init>();
        r0.f = r1;
        r1 = r0.g;
        r2 = r0.f;
        r1.add(r2);
        return;
    L_0x00ed:
        r1 = r0.c;
        if (r1 != 0) goto L_0x00f8;
    L_0x00f1:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.c = r1;
    L_0x00f8:
        r1 = new com.qihoo360.mobilesafe.parser.manifest.a.a;
        r1.<init>();
        r0.e = r1;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.g = r1;
        r1 = r0.e;
        r2 = r0.g;
        r1.b = r2;
        r1 = r0.e;
        r2 = "android:name";
        r2 = r4.getValue(r2);
        r2 = r0.a(r2);
        r1.a = r2;
        return;
    L_0x011b:
        r1 = r0.b;
        if (r1 != 0) goto L_0x0126;
    L_0x011f:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.b = r1;
    L_0x0126:
        r1 = new com.qihoo360.mobilesafe.parser.manifest.a.a;
        r1.<init>();
        r0.e = r1;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.g = r1;
        r1 = r0.e;
        r2 = r0.g;
        r1.b = r2;
        r1 = r0.e;
        r2 = "android:name";
        r2 = r4.getValue(r2);
        r2 = r0.a(r2);
        r1.a = r2;
        return;
    L_0x0149:
        r1 = r0.a;
        if (r1 != 0) goto L_0x0154;
    L_0x014d:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.a = r1;
    L_0x0154:
        r1 = new com.qihoo360.mobilesafe.parser.manifest.a.a;
        r1.<init>();
        r0.e = r1;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.g = r1;
        r1 = r0.e;
        r2 = r0.g;
        r1.b = r2;
        r1 = r0.e;
        r2 = "android:name";
        r2 = r4.getValue(r2);
        r2 = r0.a(r2);
        r1.a = r2;
        return;
    L_0x0177:
        r1 = "package";
        r1 = r4.getValue(r1);
        r0.d = r1;
        return;
    L_0x0180:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.mobilesafe.parser.manifest.a.startElement(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes):void");
    }

    public final void endElement(String str, String str2, String str3) throws SAXException {
        String str4;
        int i;
        super.endElement(str, str2, str3);
        str = str3.hashCode();
        if (str != -1655966961) {
            if (str != -1029793847) {
                if (str != -808719889) {
                    if (str == 1984153269) {
                        if (str3.equals(NotificationCompat.CATEGORY_SERVICE) != null) {
                            str = 2;
                            switch (str) {
                                case null:
                                    if (this.h != null) {
                                        for (String str22 : this.h) {
                                            this.f.addAction(str22);
                                        }
                                    }
                                    if (this.i != null) {
                                        for (String str222 : this.i) {
                                            this.f.addCategory(str222);
                                        }
                                    }
                                    if (this.j != null) {
                                        for (b bVar : this.j) {
                                            if (TextUtils.isEmpty(bVar.a) == null) {
                                                this.f.addDataScheme(bVar.a);
                                            }
                                            if (TextUtils.isEmpty(bVar.b) == null && TextUtils.isEmpty(bVar.c) == null) {
                                                this.f.addDataAuthority(bVar.b, bVar.c);
                                            }
                                            if (TextUtils.isEmpty(bVar.e) == null) {
                                                str3 = this.f;
                                                str4 = bVar.e;
                                                i = (TextUtils.isEmpty(bVar.f) || !TextUtils.isEmpty(bVar.f)) ? TextUtils.isEmpty(bVar.g) ? 1 : 2 : 0;
                                                str3.addDataPath(str4, i);
                                            }
                                            try {
                                                if (TextUtils.isEmpty(bVar.d) == null) {
                                                    this.f.addDataType(bVar.d);
                                                }
                                            } catch (String str2222) {
                                                str2222.printStackTrace();
                                            }
                                        }
                                    }
                                    this.h = null;
                                    this.i = null;
                                    this.j = null;
                                    return;
                                case 1:
                                    this.a.add(this.e);
                                    return;
                                case 2:
                                    this.b.add(this.e);
                                    return;
                                case 3:
                                    this.c.add(this.e);
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                } else if (str3.equals("receiver") != null) {
                    str = 3;
                    switch (str) {
                        case null:
                            if (this.h != null) {
                                while (str.hasNext() != null) {
                                    this.f.addAction(str2222);
                                }
                            }
                            if (this.i != null) {
                                while (str.hasNext() != null) {
                                    this.f.addCategory(str2222);
                                }
                            }
                            if (this.j != null) {
                                for (b bVar2 : this.j) {
                                    if (TextUtils.isEmpty(bVar2.a) == null) {
                                        this.f.addDataScheme(bVar2.a);
                                    }
                                    this.f.addDataAuthority(bVar2.b, bVar2.c);
                                    if (TextUtils.isEmpty(bVar2.e) == null) {
                                        str3 = this.f;
                                        str4 = bVar2.e;
                                        if (TextUtils.isEmpty(bVar2.f)) {
                                            break;
                                        }
                                        if (TextUtils.isEmpty(bVar2.g)) {
                                        }
                                        str3.addDataPath(str4, i);
                                    }
                                    if (TextUtils.isEmpty(bVar2.d) == null) {
                                        this.f.addDataType(bVar2.d);
                                    }
                                    break;
                                }
                            }
                            this.h = null;
                            this.i = null;
                            this.j = null;
                            return;
                        case 1:
                            this.a.add(this.e);
                            return;
                        case 2:
                            this.b.add(this.e);
                            return;
                        case 3:
                            this.c.add(this.e);
                            break;
                        default:
                            break;
                    }
                }
            } else if (str3.equals("intent-filter") != null) {
                str = null;
                switch (str) {
                    case null:
                        if (this.h != null) {
                            while (str.hasNext() != null) {
                                this.f.addAction(str2222);
                            }
                        }
                        if (this.i != null) {
                            while (str.hasNext() != null) {
                                this.f.addCategory(str2222);
                            }
                        }
                        if (this.j != null) {
                            for (b bVar22 : this.j) {
                                if (TextUtils.isEmpty(bVar22.a) == null) {
                                    this.f.addDataScheme(bVar22.a);
                                }
                                this.f.addDataAuthority(bVar22.b, bVar22.c);
                                if (TextUtils.isEmpty(bVar22.e) == null) {
                                    str3 = this.f;
                                    str4 = bVar22.e;
                                    if (TextUtils.isEmpty(bVar22.f)) {
                                        break;
                                    }
                                    if (TextUtils.isEmpty(bVar22.g)) {
                                    }
                                    str3.addDataPath(str4, i);
                                }
                                if (TextUtils.isEmpty(bVar22.d) == null) {
                                    this.f.addDataType(bVar22.d);
                                }
                                break;
                            }
                        }
                        this.h = null;
                        this.i = null;
                        this.j = null;
                        return;
                    case 1:
                        this.a.add(this.e);
                        return;
                    case 2:
                        this.b.add(this.e);
                        return;
                    case 3:
                        this.c.add(this.e);
                        break;
                    default:
                        break;
                }
            }
        } else if (str3.equals("activity") != null) {
            str = 1;
            switch (str) {
                case null:
                    if (this.h != null) {
                        while (str.hasNext() != null) {
                            this.f.addAction(str2222);
                        }
                    }
                    if (this.i != null) {
                        while (str.hasNext() != null) {
                            this.f.addCategory(str2222);
                        }
                    }
                    if (this.j != null) {
                        for (b bVar222 : this.j) {
                            if (TextUtils.isEmpty(bVar222.a) == null) {
                                this.f.addDataScheme(bVar222.a);
                            }
                            this.f.addDataAuthority(bVar222.b, bVar222.c);
                            if (TextUtils.isEmpty(bVar222.e) == null) {
                                str3 = this.f;
                                str4 = bVar222.e;
                                if (TextUtils.isEmpty(bVar222.f)) {
                                    break;
                                }
                                if (TextUtils.isEmpty(bVar222.g)) {
                                }
                                str3.addDataPath(str4, i);
                            }
                            if (TextUtils.isEmpty(bVar222.d) == null) {
                                this.f.addDataType(bVar222.d);
                            }
                            break;
                        }
                    }
                    this.h = null;
                    this.i = null;
                    this.j = null;
                    return;
                case 1:
                    this.a.add(this.e);
                    return;
                case 2:
                    this.b.add(this.e);
                    return;
                case 3:
                    this.c.add(this.e);
                    break;
                default:
                    break;
            }
        }
        str = -1;
        switch (str) {
            case null:
                if (this.h != null) {
                    while (str.hasNext() != null) {
                        this.f.addAction(str2222);
                    }
                }
                if (this.i != null) {
                    while (str.hasNext() != null) {
                        this.f.addCategory(str2222);
                    }
                }
                if (this.j != null) {
                    for (b bVar2222 : this.j) {
                        if (TextUtils.isEmpty(bVar2222.a) == null) {
                            this.f.addDataScheme(bVar2222.a);
                        }
                        this.f.addDataAuthority(bVar2222.b, bVar2222.c);
                        if (TextUtils.isEmpty(bVar2222.e) == null) {
                            str3 = this.f;
                            str4 = bVar2222.e;
                            if (TextUtils.isEmpty(bVar2222.f)) {
                                break;
                            }
                            if (TextUtils.isEmpty(bVar2222.g)) {
                            }
                            str3.addDataPath(str4, i);
                        }
                        if (TextUtils.isEmpty(bVar2222.d) == null) {
                            this.f.addDataType(bVar2222.d);
                        }
                        break;
                    }
                }
                this.h = null;
                this.i = null;
                this.j = null;
                return;
            case 1:
                this.a.add(this.e);
                return;
            case 2:
                this.b.add(this.e);
                return;
            case 3:
                this.c.add(this.e);
                break;
            default:
                break;
        }
    }

    private String a(String str) {
        if (!str.startsWith(".")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.d);
        stringBuilder.append(str);
        return stringBuilder.toString().intern();
    }
}
