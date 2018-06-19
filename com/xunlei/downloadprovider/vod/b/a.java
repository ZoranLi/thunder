package com.xunlei.downloadprovider.vod.b;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonParser */
public final class a {
    public static <T> T a(Class<T> cls, JSONObject jSONObject) throws ClassNotFoundException, SecurityException, IllegalAccessException, InvocationTargetException, InstantiationException, JSONException {
        T newInstance = cls.newInstance();
        for (Field field : cls.getDeclaredFields()) {
            if (!field.isSynthetic()) {
                field.setAccessible(true);
                Class type = field.getType();
                if (type.isPrimitive()) {
                    a(newInstance, field, jSONObject.opt(field.getName()));
                } else {
                    Object newInstance2 = type.newInstance();
                    if (newInstance2 instanceof List) {
                        type = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                        JSONArray jSONArray = jSONObject.getJSONArray(field.getName());
                        for (int i = 0; i < jSONArray.length(); i++) {
                            ((List) newInstance2).add(a(type, jSONObject.getJSONArray(field.getName()).getJSONObject(i)));
                        }
                        a(newInstance, field, newInstance2);
                    } else if (newInstance2 instanceof String) {
                        a(newInstance, field, jSONObject.opt(field.getName()));
                    } else {
                        a(newInstance, field, a(type, jSONObject.getJSONObject(field.getName())));
                    }
                }
            }
        }
        return newInstance;
    }

    private static void a(java.lang.Object r6, java.lang.reflect.Field r7, java.lang.Object r8) throws java.lang.SecurityException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = 1;
        r2 = r6.getClass();	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r3 = new java.lang.StringBuilder;	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r4 = "set";	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r3.<init>(r4);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r4 = r7.getName();	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r4 = r4.substring(r0, r1);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r5 = java.util.Locale.getDefault();	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r4 = r4.toUpperCase(r5);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r3.append(r4);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r4 = r7.getName();	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r4 = r4.substring(r1);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r3.append(r4);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r3 = r3.toString();	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r4 = new java.lang.Class[r1];	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r5 = r7.getType();	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r4[r0] = r5;	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r2 = r2.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r2.setAccessible(r1);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r3 = new java.lang.Object[r1];	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r3[r0] = r8;	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        r2.invoke(r6, r3);	 Catch:{ NoSuchMethodException -> 0x0081, IllegalArgumentException -> 0x0046 }
        return;
    L_0x0046:
        r6 = move-exception;
        r2 = new java.lang.StringBuilder;
        r3 = "method [set";
        r2.<init>(r3);
        r3 = r7.getName();
        r0 = r3.substring(r0, r1);
        r3 = java.util.Locale.getDefault();
        r0 = r0.toUpperCase(r3);
        r2.append(r0);
        r7 = r7.getName();
        r7 = r7.substring(r1);
        r2.append(r7);
        r7 = "] illegal argument:";
        r2.append(r7);
        r2.append(r8);
        r7 = ",";
        r2.append(r7);
        r6 = r6.getMessage();
        r2.append(r6);
        return;
    L_0x0081:
        r6 = new java.lang.StringBuilder;
        r8 = "method [set";
        r6.<init>(r8);
        r8 = r7.getName();
        r8 = r8.substring(r0, r1);
        r0 = java.util.Locale.getDefault();
        r8 = r8.toUpperCase(r0);
        r6.append(r8);
        r7 = r7.getName();
        r7 = r7.substring(r1);
        r6.append(r7);
        r7 = "] not found";
        r6.append(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.vod.b.a.a(java.lang.Object, java.lang.reflect.Field, java.lang.Object):void");
    }
}
