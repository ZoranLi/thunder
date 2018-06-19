package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.a;
import com.alibaba.fastjson.c.e;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a.c;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: DateCodec */
public final class v extends c implements r, ao {
    public static final v a = new v();

    public final int e_() {
        return 2;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        af afVar2 = afVar;
        Object obj3 = obj;
        ax axVar = afVar2.a;
        if (obj3 == null) {
            axVar.write("null");
            return;
        }
        Date date;
        if (obj3 instanceof Date) {
            date = (Date) obj3;
        } else {
            date = j.i(obj);
        }
        if (axVar.b(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat a = afVar.a();
            if (a == null) {
                a = new SimpleDateFormat(a.DEFFAULT_DATE_FORMAT, afVar2.o);
                a.setTimeZone(afVar2.n);
            }
            axVar.b(a.format(date));
        } else if (!axVar.b(SerializerFeature.WriteClassName) || obj.getClass() == type) {
            long time = date.getTime();
            if (axVar.b(SerializerFeature.UseISO8601DateFormat)) {
                char[] toCharArray;
                int i2 = axVar.b(SerializerFeature.UseSingleQuotes) ? 39 : 34;
                axVar.write(i2);
                Calendar instance = Calendar.getInstance(afVar2.n, afVar2.o);
                instance.setTimeInMillis(time);
                int i3 = instance.get(1);
                int i4 = instance.get(2) + 1;
                int i5 = instance.get(5);
                int i6 = instance.get(11);
                int i7 = instance.get(12);
                int i8 = instance.get(13);
                int i9 = instance.get(14);
                if (i9 != 0) {
                    toCharArray = "0000-00-00T00:00:00.000".toCharArray();
                    e.a(i9, 23, toCharArray);
                    e.a(i8, 19, toCharArray);
                    e.a(i7, 16, toCharArray);
                    e.a(i6, 13, toCharArray);
                    e.a(i5, 10, toCharArray);
                    e.a(i4, 7, toCharArray);
                    e.a(i3, 4, toCharArray);
                } else if (i8 == 0 && i7 == 0 && i6 == 0) {
                    toCharArray = "0000-00-00".toCharArray();
                    e.a(i5, 10, toCharArray);
                    e.a(i4, 7, toCharArray);
                    e.a(i3, 4, toCharArray);
                } else {
                    toCharArray = "0000-00-00T00:00:00".toCharArray();
                    e.a(i8, 19, toCharArray);
                    e.a(i7, 16, toCharArray);
                    e.a(i6, 13, toCharArray);
                    e.a(i5, 10, toCharArray);
                    e.a(i4, 7, toCharArray);
                    e.a(i3, 4, toCharArray);
                }
                axVar.write(toCharArray);
                int rawOffset = instance.getTimeZone().getRawOffset() / 3600000;
                if (rawOffset == 0) {
                    axVar.write(90);
                } else {
                    if (rawOffset > 0) {
                        axVar.write(43);
                        axVar.a(String.format("%02d", new Object[]{Integer.valueOf(rawOffset)}));
                    } else {
                        axVar.write(45);
                        axVar.a(String.format("%02d", new Object[]{Integer.valueOf(-rawOffset)}));
                    }
                    axVar.a((CharSequence) ":00");
                }
                axVar.write(i2);
                return;
            }
            axVar.a(time);
        } else if (obj.getClass() == Date.class) {
            axVar.write("new Date(");
            axVar.a(((Date) obj3).getTime(), ')');
        } else {
            axVar.write(123);
            axVar.d(a.DEFAULT_TYPE_KEY);
            afVar2.a(obj.getClass().getName());
            axVar.a("val", ((Date) obj3).getTime());
            axVar.write(125);
        }
    }

    protected final <T> T b(com.alibaba.fastjson.parser.a r3, java.lang.reflect.Type r4, java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Date;
        if (r1 == 0) goto L_0x0009;
    L_0x0008:
        return r5;
    L_0x0009:
        r1 = r5 instanceof java.lang.Number;
        if (r1 == 0) goto L_0x0019;
    L_0x000d:
        r3 = new java.util.Date;
        r5 = (java.lang.Number) r5;
        r4 = r5.longValue();
        r3.<init>(r4);
        return r3;
    L_0x0019:
        r1 = r5 instanceof java.lang.String;
        if (r1 == 0) goto L_0x006d;
    L_0x001d:
        r5 = (java.lang.String) r5;
        r1 = r5.length();
        if (r1 != 0) goto L_0x0026;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = new com.alibaba.fastjson.parser.d;
        r0.<init>(r5);
        r1 = 0;
        r1 = r0.b(r1);	 Catch:{ all -> 0x0068 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ all -> 0x0068 }
    L_0x0032:
        r3 = r0.C();	 Catch:{ all -> 0x0068 }
        r5 = java.util.Calendar.class;	 Catch:{ all -> 0x0068 }
        if (r4 != r5) goto L_0x003e;
    L_0x003a:
        r0.close();
        return r3;
    L_0x003e:
        r3 = r3.getTime();	 Catch:{ all -> 0x0068 }
        r0.close();
        return r3;
    L_0x0046:
        r0.close();
        r4 = r5.length();
        r0 = r3.d;
        r0 = r0.length();
        if (r4 != r0) goto L_0x005e;
    L_0x0055:
        r3 = r3.a();
        r3 = r3.parse(r5);	 Catch:{ ParseException -> 0x005e }
        return r3;
    L_0x005e:
        r3 = java.lang.Long.parseLong(r5);
        r5 = new java.util.Date;
        r5.<init>(r3);
        return r5;
    L_0x0068:
        r3 = move-exception;
        r0.close();
        throw r3;
    L_0x006d:
        r3 = new com.alibaba.fastjson.JSONException;
        r4 = "parse error";
        r3.<init>(r4);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.v.b(com.alibaba.fastjson.parser.a, java.lang.reflect.Type, java.lang.Object):T");
    }
}
