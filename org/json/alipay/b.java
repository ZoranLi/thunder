package org.json.alipay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class b {
    public static final Object a = new a();
    private Map b;

    private static final class a {
        private a() {
        }

        protected final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            if (obj != null) {
                if (obj != this) {
                    return false;
                }
            }
            return true;
        }

        public final String toString() {
            return "null";
        }
    }

    public b() {
        this.b = new HashMap();
    }

    public b(String str) {
        this(new c(str));
    }

    public b(Map map) {
        if (map == null) {
            map = new HashMap();
        }
        this.b = map;
    }

    public b(c cVar) {
        this();
        if (cVar.c() != '{') {
            throw cVar.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c = cVar.c();
            if (c == '\u0000') {
                throw cVar.a("A JSONObject text must end with '}'");
            } else if (c != '}') {
                cVar.a();
                String obj = cVar.d().toString();
                char c2 = cVar.c();
                if (c2 == '=') {
                    if (cVar.b() != '>') {
                        cVar.a();
                    }
                } else if (c2 != ':') {
                    throw cVar.a("Expected a ':' after a key");
                }
                Object d = cVar.d();
                if (obj != null) {
                    if (d != null) {
                        b(d);
                        this.b.put(obj, d);
                    } else {
                        this.b.remove(obj);
                    }
                    c = cVar.c();
                    if (c != ',' && c != ';') {
                        break;
                    } else if (cVar.c() != '}') {
                        cVar.a();
                    } else {
                        return;
                    }
                }
                throw new JSONException("Null key.");
            } else {
                return;
            }
        }
        if (c != '}') {
            throw cVar.a("Expected a ',' or '}'");
        }
    }

    static String a(Object obj) {
        if (obj != null) {
            if (!obj.equals(null)) {
                if (obj instanceof Number) {
                    obj = (Number) obj;
                    if (obj == null) {
                        throw new JSONException("Null pointer");
                    }
                    b(obj);
                    String obj2 = obj.toString();
                    if (obj2.indexOf(46) > 0 && obj2.indexOf(101) < 0 && obj2.indexOf(69) < 0) {
                        while (obj2.endsWith("0")) {
                            obj2 = obj2.substring(0, obj2.length() - 1);
                        }
                        if (obj2.endsWith(".")) {
                            obj2 = obj2.substring(0, obj2.length() - 1);
                        }
                    }
                    return obj2;
                }
                if (!((obj instanceof Boolean) || (obj instanceof b))) {
                    if (!(obj instanceof a)) {
                        return obj instanceof Map ? new b((Map) obj).toString() : obj instanceof Collection ? new a((Collection) obj).toString() : obj.getClass().isArray() ? new a(obj).toString() : c(obj.toString());
                    }
                }
                return obj.toString();
            }
        }
        return "null";
    }

    private static void b(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Double) {
            Double d = (Double) obj;
            if (d.isInfinite() || d.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        } else if (obj instanceof Float) {
            Float f = (Float) obj;
            if (f.isInfinite() || f.isNaN()) {
                throw new JSONException("JSON does not allow non-finite numbers.");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.lang.String r8) {
        /*
        if (r8 == 0) goto L_0x0099;
    L_0x0002:
        r0 = r8.length();
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        goto L_0x0099;
    L_0x000a:
        r0 = r8.length();
        r1 = new java.lang.StringBuffer;
        r2 = r0 + 4;
        r1.<init>(r2);
        r2 = 34;
        r1.append(r2);
        r3 = 0;
        r4 = r3;
    L_0x001c:
        if (r3 >= r0) goto L_0x0091;
    L_0x001e:
        r5 = r8.charAt(r3);
        r6 = 92;
        if (r5 == r2) goto L_0x0087;
    L_0x0026:
        r7 = 47;
        if (r5 == r7) goto L_0x0083;
    L_0x002a:
        if (r5 == r6) goto L_0x0087;
    L_0x002c:
        switch(r5) {
            case 8: goto L_0x007d;
            case 9: goto L_0x007a;
            case 10: goto L_0x0077;
            default: goto L_0x002f;
        };
    L_0x002f:
        switch(r5) {
            case 12: goto L_0x0074;
            case 13: goto L_0x0071;
            default: goto L_0x0032;
        };
    L_0x0032:
        r4 = 32;
        if (r5 < r4) goto L_0x0046;
    L_0x0036:
        r4 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        if (r5 < r4) goto L_0x003e;
    L_0x003a:
        r4 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        if (r5 < r4) goto L_0x0046;
    L_0x003e:
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        if (r5 < r4) goto L_0x008a;
    L_0x0042:
        r4 = 8448; // 0x2100 float:1.1838E-41 double:4.174E-320;
        if (r5 >= r4) goto L_0x008a;
    L_0x0046:
        r4 = new java.lang.StringBuilder;
        r6 = "000";
        r4.<init>(r6);
        r6 = java.lang.Integer.toHexString(r5);
        r4.append(r6);
        r4 = r4.toString();
        r6 = new java.lang.StringBuilder;
        r7 = "\\u";
        r6.<init>(r7);
        r7 = r4.length();
        r7 = r7 + -4;
        r4 = r4.substring(r7);
        r6.append(r4);
        r4 = r6.toString();
        goto L_0x007f;
    L_0x0071:
        r4 = "\\r";
        goto L_0x007f;
    L_0x0074:
        r4 = "\\f";
        goto L_0x007f;
    L_0x0077:
        r4 = "\\n";
        goto L_0x007f;
    L_0x007a:
        r4 = "\\t";
        goto L_0x007f;
    L_0x007d:
        r4 = "\\b";
    L_0x007f:
        r1.append(r4);
        goto L_0x008d;
    L_0x0083:
        r7 = 60;
        if (r4 != r7) goto L_0x008a;
    L_0x0087:
        r1.append(r6);
    L_0x008a:
        r1.append(r5);
    L_0x008d:
        r3 = r3 + 1;
        r4 = r5;
        goto L_0x001c;
    L_0x0091:
        r1.append(r2);
        r8 = r1.toString();
        return r8;
    L_0x0099:
        r8 = "\"\"";
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.b.c(java.lang.String):java.lang.String");
    }

    public final Object a(String str) {
        Object obj = str == null ? null : this.b.get(str);
        if (obj != null) {
            return obj;
        }
        StringBuilder stringBuilder = new StringBuilder("JSONObject[");
        stringBuilder.append(c(str));
        stringBuilder.append("] not found.");
        throw new JSONException(stringBuilder.toString());
    }

    public final Iterator a() {
        return this.b.keySet().iterator();
    }

    public final boolean b(String str) {
        return this.b.containsKey(str);
    }

    public java.lang.String toString() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.a();	 Catch:{ Exception -> 0x0049 }
        r1 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0049 }
        r2 = "{";	 Catch:{ Exception -> 0x0049 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0049 }
    L_0x000b:
        r2 = r0.hasNext();	 Catch:{ Exception -> 0x0049 }
        if (r2 == 0) goto L_0x003f;	 Catch:{ Exception -> 0x0049 }
    L_0x0011:
        r2 = r1.length();	 Catch:{ Exception -> 0x0049 }
        r3 = 1;	 Catch:{ Exception -> 0x0049 }
        if (r2 <= r3) goto L_0x001d;	 Catch:{ Exception -> 0x0049 }
    L_0x0018:
        r2 = 44;	 Catch:{ Exception -> 0x0049 }
        r1.append(r2);	 Catch:{ Exception -> 0x0049 }
    L_0x001d:
        r2 = r0.next();	 Catch:{ Exception -> 0x0049 }
        r3 = r2.toString();	 Catch:{ Exception -> 0x0049 }
        r3 = c(r3);	 Catch:{ Exception -> 0x0049 }
        r1.append(r3);	 Catch:{ Exception -> 0x0049 }
        r3 = 58;	 Catch:{ Exception -> 0x0049 }
        r1.append(r3);	 Catch:{ Exception -> 0x0049 }
        r3 = r4.b;	 Catch:{ Exception -> 0x0049 }
        r2 = r3.get(r2);	 Catch:{ Exception -> 0x0049 }
        r2 = a(r2);	 Catch:{ Exception -> 0x0049 }
        r1.append(r2);	 Catch:{ Exception -> 0x0049 }
        goto L_0x000b;	 Catch:{ Exception -> 0x0049 }
    L_0x003f:
        r0 = 125; // 0x7d float:1.75E-43 double:6.2E-322;	 Catch:{ Exception -> 0x0049 }
        r1.append(r0);	 Catch:{ Exception -> 0x0049 }
        r0 = r1.toString();	 Catch:{ Exception -> 0x0049 }
        return r0;
    L_0x0049:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.b.toString():java.lang.String");
    }
}
