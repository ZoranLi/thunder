package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class a {
    private ArrayList a;

    public a() {
        this.a = new ArrayList();
    }

    public a(Object obj) {
        this();
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                this.a.add(Array.get(obj, i));
            }
            return;
        }
        throw new JSONException("JSONArray initial value should be a string or collection or array.");
    }

    public a(String str) {
        this(new c(str));
    }

    public a(Collection collection) {
        this.a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a(c cVar) {
        this();
        char c = cVar.c();
        if (c == '[') {
            c = ']';
        } else if (c == '(') {
            c = ')';
        } else {
            throw cVar.a("A JSONArray text must start with '['");
        }
        if (cVar.c() != ']') {
            do {
                ArrayList arrayList;
                Object obj;
                cVar.a();
                if (cVar.c() == ',') {
                    cVar.a();
                    arrayList = this.a;
                    obj = null;
                } else {
                    cVar.a();
                    arrayList = this.a;
                    obj = cVar.d();
                }
                arrayList.add(obj);
                char c2 = cVar.c();
                if (c2 != ')') {
                    if (c2 != ',' && c2 != ';') {
                        if (c2 != ']') {
                            throw cVar.a("Expected a ',' or ']'");
                        }
                    }
                }
                if (c != c2) {
                    StringBuilder stringBuilder = new StringBuilder("Expected a '");
                    stringBuilder.append(new Character(c));
                    stringBuilder.append("'");
                    throw cVar.a(stringBuilder.toString());
                }
                return;
            } while (cVar.c() != ']');
        }
    }

    private String a(String str) {
        int size = this.a.size();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.a(this.a.get(i)));
        }
        return stringBuffer.toString();
    }

    public final int a() {
        return this.a.size();
    }

    public final Object a(int i) {
        Object obj;
        if (i >= 0) {
            if (i < this.a.size()) {
                obj = this.a.get(i);
                if (obj == null) {
                    return obj;
                }
                StringBuilder stringBuilder = new StringBuilder("JSONArray[");
                stringBuilder.append(i);
                stringBuilder.append("] not found.");
                throw new JSONException(stringBuilder.toString());
            }
        }
        obj = null;
        if (obj == null) {
            return obj;
        }
        StringBuilder stringBuilder2 = new StringBuilder("JSONArray[");
        stringBuilder2.append(i);
        stringBuilder2.append("] not found.");
        throw new JSONException(stringBuilder2.toString());
    }

    public java.lang.String toString() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x001a }
        r1 = "[";	 Catch:{ Exception -> 0x001a }
        r0.<init>(r1);	 Catch:{ Exception -> 0x001a }
        r1 = ",";	 Catch:{ Exception -> 0x001a }
        r1 = r2.a(r1);	 Catch:{ Exception -> 0x001a }
        r0.append(r1);	 Catch:{ Exception -> 0x001a }
        r1 = 93;	 Catch:{ Exception -> 0x001a }
        r0.append(r1);	 Catch:{ Exception -> 0x001a }
        r0 = r0.toString();	 Catch:{ Exception -> 0x001a }
        return r0;
    L_0x001a:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.a.toString():java.lang.String");
    }
}
