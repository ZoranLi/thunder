package com.xunlei.download.proguard;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: Headers */
public final class ae {
    private final String[] a;

    /* compiled from: Headers */
    public static final class a {
        private final List<String> a = new ArrayList(20);

        final a a(String str) {
            int indexOf = str.indexOf(Constants.COLON_SEPARATOR, 1);
            if (indexOf != -1) {
                return c(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(Constants.COLON_SEPARATOR)) {
                return c("", str.substring(1));
            }
            return c("", str);
        }

        public final a b(String str) {
            int indexOf = str.indexOf(Constants.COLON_SEPARATOR);
            if (indexOf != -1) {
                return a(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            StringBuilder stringBuilder = new StringBuilder("Unexpected header: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public final a a(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            } else {
                if (str.length() != 0 && str.indexOf(0) == -1) {
                    if (str2.indexOf(0) == -1) {
                        return c(str, str2);
                    }
                }
                StringBuilder stringBuilder = new StringBuilder("Unexpected header: ");
                stringBuilder.append(str);
                stringBuilder.append(": ");
                stringBuilder.append(str2);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
        }

        private a c(String str, String str2) {
            this.a.add(str);
            this.a.add(str2.trim());
            return this;
        }

        public final a c(String str) {
            int i = 0;
            while (i < this.a.size()) {
                if (str.equalsIgnoreCase((String) this.a.get(i))) {
                    this.a.remove(i);
                    this.a.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public final a b(String str, String str2) {
            c(str);
            a(str, str2);
            return this;
        }

        public final String d(String str) {
            for (int size = this.a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase((String) this.a.get(size))) {
                    return (String) this.a.get(size + 1);
                }
            }
            return null;
        }

        public final ae a() {
            return new ae();
        }
    }

    private ae(a aVar) {
        this.a = (String[]) aVar.a.toArray(new String[aVar.a.size()]);
    }

    private ae(String[] strArr) {
        this.a = strArr;
    }

    public final String a(String str) {
        return a(this.a, str);
    }

    public final java.lang.Long a(java.lang.String r3, long r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.a;	 Catch:{ NumberFormatException -> 0x000f }
        r3 = a(r0, r3);	 Catch:{ NumberFormatException -> 0x000f }
        r0 = java.lang.Long.parseLong(r3);	 Catch:{ NumberFormatException -> 0x000f }
        r3 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x000f }
        return r3;
    L_0x000f:
        r3 = java.lang.Long.valueOf(r4);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.ae.a(java.lang.String, long):java.lang.Long");
    }

    public final Date b(String str) {
        str = a(str);
        return str != null ? af.a(str) : null;
    }

    public final int a() {
        return this.a.length / 2;
    }

    public final String a(int i) {
        i *= 2;
        if (i >= 0) {
            if (i < this.a.length) {
                return this.a[i];
            }
        }
        return 0;
    }

    public final String b(int i) {
        i = (i * 2) + 1;
        if (i >= 0) {
            if (i < this.a.length) {
                return this.a[i];
            }
        }
        return 0;
    }

    public final Set<String> b() {
        Set treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int a = a();
        for (int i = 0; i < a; i++) {
            treeSet.add(a(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public final List<String> c(String str) {
        int a = a();
        List list = null;
        for (int i = 0; i < a; i++) {
            if (str.equalsIgnoreCase(a(i))) {
                if (list == null) {
                    list = new ArrayList(2);
                }
                list.add(b(i));
            }
        }
        if (list != null) {
            return Collections.unmodifiableList(list);
        }
        return Collections.emptyList();
    }

    public final a c() {
        a aVar = new a();
        Collections.addAll(aVar.a, this.a);
        return aVar;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int a = a();
        for (int i = 0; i < a; i++) {
            stringBuilder.append(a(i));
            stringBuilder.append(": ");
            stringBuilder.append(b(i));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static String a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static ae a(String... strArr) {
        if (strArr != null) {
            if (strArr.length % 2 == 0) {
                int i;
                strArr = (String[]) strArr.clone();
                for (i = 0; i < strArr.length; i++) {
                    if (strArr[i] == null) {
                        throw new IllegalArgumentException("Headers cannot be null");
                    }
                    strArr[i] = strArr[i].trim();
                }
                i = 0;
                while (i < strArr.length) {
                    String str = strArr[i];
                    String str2 = strArr[i + 1];
                    if (str.length() != 0 && str.indexOf(0) == -1) {
                        if (str2.indexOf(0) == -1) {
                            i += 2;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("Unexpected header: ");
                    stringBuilder.append(str);
                    stringBuilder.append(": ");
                    stringBuilder.append(str2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                return new ae(strArr);
            }
        }
        throw new IllegalArgumentException("Expected alternating header names and values");
    }

    public static ae a(Map<String, String> map) {
        if (map == null) {
            throw new IllegalArgumentException("Expected map with header names and values");
        }
        String[] strArr = new String[(map.size() * 2)];
        map = map.entrySet().iterator();
        int i = 0;
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            if (entry.getKey() != null) {
                if (entry.getValue() != null) {
                    String trim = ((String) entry.getKey()).trim();
                    String trim2 = ((String) entry.getValue()).trim();
                    if (trim.length() != 0 && trim.indexOf(0) == -1) {
                        if (trim2.indexOf(0) == -1) {
                            strArr[i] = trim;
                            strArr[i + 1] = trim2;
                            i += 2;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("Unexpected header: ");
                    stringBuilder.append(trim);
                    stringBuilder.append(": ");
                    stringBuilder.append(trim2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
            }
            throw new IllegalArgumentException("Headers cannot be null");
        }
        return new ae(strArr);
    }
}
