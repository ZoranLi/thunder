package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MessageCodec */
public class f {
    public com.huawei.hms.core.aidl.IMessageEntity a(android.os.Bundle r8, com.huawei.hms.core.aidl.IMessageEntity r9) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        if (r8 != 0) goto L_0x0003;
    L_0x0002:
        return r9;
    L_0x0003:
        r0 = r9.getClass();
    L_0x0007:
        if (r0 == 0) goto L_0x0035;
    L_0x0009:
        r1 = r0.getDeclaredFields();
        r2 = r1.length;
        r3 = 0;
    L_0x000f:
        if (r3 >= r2) goto L_0x0030;
    L_0x0011:
        r4 = r1[r3];
        r5 = com.huawei.hms.core.aidl.a.a.class;
        r5 = r4.isAnnotationPresent(r5);
        if (r5 == 0) goto L_0x002d;
    L_0x001b:
        r7.a(r9, r4, r8);	 Catch:{ IllegalAccessException -> 0x001f, IllegalAccessException -> 0x001f }
        goto L_0x002d;
    L_0x001f:
        r5 = new java.lang.StringBuilder;
        r6 = "decode, set value of the field exception, field name:";
        r5.<init>(r6);
        r4 = r4.getName();
        r5.append(r4);
    L_0x002d:
        r3 = r3 + 1;
        goto L_0x000f;
    L_0x0030:
        r0 = r0.getSuperclass();
        goto L_0x0007;
    L_0x0035:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.core.aidl.f.a(android.os.Bundle, com.huawei.hms.core.aidl.IMessageEntity):com.huawei.hms.core.aidl.IMessageEntity");
    }

    private void a(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        bundle = a(field, bundle);
        if (bundle != null) {
            boolean isAccessible = field.isAccessible();
            field.setAccessible(true);
            field.set(iMessageEntity, bundle);
            field.setAccessible(isAccessible);
        }
    }

    private java.lang.Object a(java.lang.reflect.Field r4, android.os.Bundle r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r4.getName();
        r5 = r5.get(r0);
        r0 = r5 instanceof android.os.Bundle;
        if (r0 == 0) goto L_0x0037;
    L_0x000c:
        r0 = r5;	 Catch:{ Exception -> 0x0035 }
        r0 = (android.os.Bundle) r0;	 Catch:{ Exception -> 0x0035 }
        r1 = "_val_type_";	 Catch:{ Exception -> 0x0035 }
        r2 = -1;	 Catch:{ Exception -> 0x0035 }
        r1 = r0.getInt(r1, r2);	 Catch:{ Exception -> 0x0035 }
        r2 = 1;	 Catch:{ Exception -> 0x0035 }
        if (r1 != r2) goto L_0x0022;	 Catch:{ Exception -> 0x0035 }
    L_0x0019:
        r4 = r4.getGenericType();	 Catch:{ Exception -> 0x0035 }
        r4 = r3.a(r4, r0);	 Catch:{ Exception -> 0x0035 }
        return r4;	 Catch:{ Exception -> 0x0035 }
    L_0x0022:
        if (r1 != 0) goto L_0x0037;	 Catch:{ Exception -> 0x0035 }
    L_0x0024:
        r4 = r4.getType();	 Catch:{ Exception -> 0x0035 }
        r4 = r4.newInstance();	 Catch:{ Exception -> 0x0035 }
        r4 = (com.huawei.hms.core.aidl.IMessageEntity) r4;	 Catch:{ Exception -> 0x0035 }
        r5 = (android.os.Bundle) r5;	 Catch:{ Exception -> 0x0035 }
        r4 = r3.a(r5, r4);	 Catch:{ Exception -> 0x0035 }
        return r4;
    L_0x0035:
        r4 = 0;
        return r4;
    L_0x0037:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.core.aidl.f.a(java.lang.reflect.Field, android.os.Bundle):java.lang.Object");
    }

    protected List<Object> a(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        List<Object> arrayList = new ArrayList();
        for (bundle = bundle.getBundle("_next_item_"); bundle != null; bundle = bundle.getBundle("_next_item_")) {
            Object obj = bundle.get("_value_");
            if (!(obj.getClass().isPrimitive() || (obj instanceof String))) {
                if (!(obj instanceof Serializable)) {
                    if (obj instanceof Bundle) {
                        Bundle bundle2 = (Bundle) obj;
                        int i = bundle2.getInt("_val_type_", -1);
                        if (i == 1) {
                            throw new InstantiationException("Nested List can not be supported");
                        } else if (i == 0) {
                            arrayList.add(a(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                        } else {
                            throw new InstantiationException("Unknown type can not be supported");
                        }
                    }
                    continue;
                }
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    public android.os.Bundle a(com.huawei.hms.core.aidl.IMessageEntity r8, android.os.Bundle r9) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r7 = this;
        r0 = r8.getClass();
    L_0x0004:
        if (r0 == 0) goto L_0x0032;
    L_0x0006:
        r1 = r0.getDeclaredFields();
        r2 = r1.length;
        r3 = 0;
    L_0x000c:
        if (r3 >= r2) goto L_0x002d;
    L_0x000e:
        r4 = r1[r3];
        r5 = com.huawei.hms.core.aidl.a.a.class;
        r5 = r4.isAnnotationPresent(r5);
        if (r5 == 0) goto L_0x002a;
    L_0x0018:
        r7.b(r8, r4, r9);	 Catch:{ IllegalAccessException -> 0x001c, IllegalAccessException -> 0x001c }
        goto L_0x002a;
    L_0x001c:
        r5 = new java.lang.StringBuilder;
        r6 = "encode, get value of the field exception, field name: ";
        r5.<init>(r6);
        r4 = r4.getName();
        r5.append(r4);
    L_0x002a:
        r3 = r3 + 1;
        goto L_0x000c;
    L_0x002d:
        r0 = r0.getSuperclass();
        goto L_0x0004;
    L_0x0032:
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.core.aidl.f.a(com.huawei.hms.core.aidl.IMessageEntity, android.os.Bundle):android.os.Bundle");
    }

    private void b(IMessageEntity iMessageEntity, Field field, Bundle bundle) throws IllegalAccessException {
        boolean isAccessible = field.isAccessible();
        field.setAccessible(true);
        a(field.getName(), field.get(iMessageEntity), bundle);
        field.setAccessible(isAccessible);
    }

    protected void a(String str, Object obj, Bundle bundle) {
        if (obj != null && !b(str, obj, bundle)) {
            if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof List) {
                a(str, (List) obj, bundle);
            } else if (obj instanceof Serializable) {
                bundle.putSerializable(str, (Serializable) obj);
            } else if (obj instanceof IMessageEntity) {
                obj = a((IMessageEntity) obj, new Bundle());
                obj.putInt("_val_type_", 0);
                bundle.putBundle(str, obj);
            }
        }
    }

    protected void a(String str, List list, Bundle bundle) {
        Bundle bundle2 = null;
        for (Object next : list) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(str, bundle2);
                bundle2.putInt("_val_type_", 1);
            }
            bundle2 = a("_value_", bundle2, next);
        }
    }

    private Bundle a(String str, Bundle bundle, Object obj) {
        Bundle bundle2 = new Bundle();
        a(str, obj, bundle2);
        bundle.putBundle("_next_item_", bundle2);
        return bundle2;
    }

    private boolean b(String str, Object obj, Bundle bundle) {
        if (obj instanceof String) {
            bundle.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            bundle.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            bundle.putShort(str, ((Short) obj).shortValue());
        } else if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Float) {
            bundle.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (!(obj instanceof Boolean)) {
            return null;
        } else {
            bundle.putBoolean(str, ((Boolean) obj).booleanValue());
        }
        return true;
    }
}
