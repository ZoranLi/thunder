package com.tencent.bugly.proguard;

import com.xunlei.common.encrypt.CharsetConvert;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
public final class k {
    protected String a = CharsetConvert.GBK;
    private ByteBuffer b;

    /* compiled from: BUGLY */
    public static class a {
        public byte a;
        public int b;
    }

    public k(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    public k(byte[] bArr, int i) {
        this.b = ByteBuffer.wrap(bArr);
        this.b.position(i);
    }

    public final void a(byte[] bArr) {
        if (this.b != null) {
            this.b.clear();
        }
        this.b = ByteBuffer.wrap(bArr);
    }

    public static int a(a aVar, ByteBuffer byteBuffer) {
        byte b = byteBuffer.get();
        aVar.a = (byte) (b & 15);
        aVar.b = (b & 240) >> 4;
        if (aVar.b != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get();
        return 2;
    }

    public final void a(a aVar) {
        a(aVar, this.b);
    }

    private int b(a aVar) {
        return a(aVar, this.b.duplicate());
    }

    private void b(int i) {
        this.b.position(this.b.position() + i);
    }

    public final boolean a(int r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = new com.tencent.bugly.proguard.k$a;	 Catch:{ h -> 0x0025, h -> 0x0025 }
        r1.<init>();	 Catch:{ h -> 0x0025, h -> 0x0025 }
    L_0x0006:
        r2 = r5.b(r1);	 Catch:{ h -> 0x0025, h -> 0x0025 }
        r3 = r1.b;	 Catch:{ h -> 0x0025, h -> 0x0025 }
        if (r6 <= r3) goto L_0x001e;	 Catch:{ h -> 0x0025, h -> 0x0025 }
    L_0x000e:
        r3 = r1.a;	 Catch:{ h -> 0x0025, h -> 0x0025 }
        r4 = 11;	 Catch:{ h -> 0x0025, h -> 0x0025 }
        if (r3 != r4) goto L_0x0015;	 Catch:{ h -> 0x0025, h -> 0x0025 }
    L_0x0014:
        goto L_0x001e;	 Catch:{ h -> 0x0025, h -> 0x0025 }
    L_0x0015:
        r5.b(r2);	 Catch:{ h -> 0x0025, h -> 0x0025 }
        r2 = r1.a;	 Catch:{ h -> 0x0025, h -> 0x0025 }
        r5.a(r2);	 Catch:{ h -> 0x0025, h -> 0x0025 }
        goto L_0x0006;	 Catch:{ h -> 0x0025, h -> 0x0025 }
    L_0x001e:
        r1 = r1.b;	 Catch:{ h -> 0x0025, h -> 0x0025 }
        if (r6 != r1) goto L_0x0024;
    L_0x0022:
        r6 = 1;
        return r6;
    L_0x0024:
        return r0;
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.k.a(int):boolean");
    }

    public final void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.a);
        } while (aVar.a != (byte) 11);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.a);
    }

    private void a(byte b) {
        int i = 0;
        switch (b) {
            case (byte) 0:
                b(1);
                return;
            case (byte) 1:
                b(2);
                return;
            case (byte) 2:
                b(4);
                return;
            case (byte) 3:
                b(8);
                return;
            case (byte) 4:
                b(4);
                return;
            case (byte) 5:
                b(8);
                return;
            case (byte) 6:
                int i2 = this.b.get();
                if (i2 < (byte) 0) {
                    i2 += 256;
                }
                b(i2);
                return;
            case (byte) 7:
                b(this.b.getInt());
                return;
            case (byte) 8:
                b = a(0, 0, true);
                while (i < b * 2) {
                    b();
                    i++;
                }
                return;
            case (byte) 9:
                b = a(0, 0, true);
                byte b2;
                while (b2 < b) {
                    b();
                    b2++;
                }
                return;
            case (byte) 10:
                a();
                return;
            case (byte) 11:
            case (byte) 12:
                return;
            case (byte) 13:
                a aVar = new a();
                a(aVar);
                if (aVar.a != (byte) 0) {
                    StringBuilder stringBuilder = new StringBuilder("skipField with invalid type, type value: ");
                    stringBuilder.append(b);
                    stringBuilder.append(", ");
                    stringBuilder.append(aVar.a);
                    throw new h(stringBuilder.toString());
                }
                b(a(0, 0, true));
                return;
            default:
                throw new h("invalid type.");
        }
    }

    public final boolean a(boolean z, int i, boolean z2) {
        return a((byte) 0, i, z2) != 0;
    }

    public final byte a(byte b, int i, boolean z) {
        if (a(i) != 0) {
            a aVar = new a();
            a(aVar);
            b = aVar.a;
            if (b == (byte) 0) {
                return this.b.get();
            }
            if (b == (byte) 12) {
                return (byte) 0;
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return b;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final short a(short s, int i, boolean z) {
        if (a(i) != 0) {
            a aVar = new a();
            a(aVar);
            s = aVar.a;
            if (s == (short) 12) {
                return (short) 0;
            }
            switch (s) {
                case (short) 0:
                    return (short) this.b.get();
                case (short) 1:
                    return this.b.getShort();
                default:
                    throw new h("type mismatch.");
            }
        } else if (!z) {
            return s;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final int a(int i, int i2, boolean z) {
        if (a(i2) != 0) {
            a aVar = new a();
            a(aVar);
            i = aVar.a;
            if (i == 12) {
                return 0;
            }
            switch (i) {
                case 0:
                    return this.b.get();
                case 1:
                    return this.b.getShort();
                case 2:
                    return this.b.getInt();
                default:
                    throw new h("type mismatch.");
            }
        } else if (!z) {
            return i;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final long a(long j, int i, boolean z) {
        if (a(i) != 0) {
            a aVar = new a();
            a(aVar);
            j = aVar.a;
            if (j == 12) {
                return 0;
            }
            switch (j) {
                case 0:
                    return (long) this.b.get();
                case 1:
                    return (long) this.b.getShort();
                case 2:
                    return (long) this.b.getInt();
                case 3:
                    return this.b.getLong();
                default:
                    throw new h("type mismatch.");
            }
        } else if (!z) {
            return j;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final float a(float f, int i, boolean z) {
        if (a(i) != 0) {
            a aVar = new a();
            a(aVar);
            int i2 = aVar.a;
            if (i2 == 4) {
                return this.b.getFloat();
            }
            if (i2 == 12) {
                return 0.0f;
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return f;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final double a(double d, int i, boolean z) {
        if (a(i) != 0) {
            a aVar = new a();
            a(aVar);
            d = aVar.a;
            if (d == 12) {
                return 0.0d;
            }
            switch (d) {
                case 2.0E-323d:
                    return (double) this.b.getFloat();
                case 2.5E-323d:
                    return this.b.getDouble();
                default:
                    throw new h("type mismatch.");
            }
        } else if (!z) {
            return d;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final java.lang.String a(int r3, boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r3 = r2.a(r3);
        if (r3 == 0) goto L_0x0070;
    L_0x0006:
        r3 = new com.tencent.bugly.proguard.k$a;
        r3.<init>();
        r2.a(r3);
        r3 = r3.a;
        switch(r3) {
            case 6: goto L_0x0051;
            case 7: goto L_0x001b;
            default: goto L_0x0013;
        };
    L_0x0013:
        r3 = new com.tencent.bugly.proguard.h;
        r4 = "type mismatch.";
        r3.<init>(r4);
        throw r3;
    L_0x001b:
        r3 = r2.b;
        r3 = r3.getInt();
        r4 = 104857600; // 0x6400000 float:3.6111186E-35 double:5.1806538E-316;
        if (r3 > r4) goto L_0x003d;
    L_0x0025:
        if (r3 >= 0) goto L_0x0028;
    L_0x0027:
        goto L_0x003d;
    L_0x0028:
        r3 = new byte[r3];
        r4 = r2.b;
        r4.get(r3);
        r4 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0037 }
        r0 = r2.a;	 Catch:{ UnsupportedEncodingException -> 0x0037 }
        r4.<init>(r3, r0);	 Catch:{ UnsupportedEncodingException -> 0x0037 }
        goto L_0x007b;
    L_0x0037:
        r4 = new java.lang.String;
        r4.<init>(r3);
        goto L_0x007b;
    L_0x003d:
        r4 = new com.tencent.bugly.proguard.h;
        r0 = new java.lang.StringBuilder;
        r1 = "String too long: ";
        r0.<init>(r1);
        r0.append(r3);
        r3 = r0.toString();
        r4.<init>(r3);
        throw r4;
    L_0x0051:
        r3 = r2.b;
        r3 = r3.get();
        if (r3 >= 0) goto L_0x005b;
    L_0x0059:
        r3 = r3 + 256;
    L_0x005b:
        r3 = new byte[r3];
        r4 = r2.b;
        r4.get(r3);
        r4 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x006a }
        r0 = r2.a;	 Catch:{ UnsupportedEncodingException -> 0x006a }
        r4.<init>(r3, r0);	 Catch:{ UnsupportedEncodingException -> 0x006a }
        goto L_0x007b;
    L_0x006a:
        r4 = new java.lang.String;
        r4.<init>(r3);
        goto L_0x007b;
    L_0x0070:
        if (r4 == 0) goto L_0x007a;
    L_0x0072:
        r3 = new com.tencent.bugly.proguard.h;
        r4 = "require field not exist.";
        r3.<init>(r4);
        throw r3;
    L_0x007a:
        r4 = 0;
    L_0x007b:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.k.a(int, boolean):java.lang.String");
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 != null) {
            if (!map2.isEmpty()) {
                Entry entry = (Entry) map2.entrySet().iterator().next();
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (a(i) != 0) {
                    a aVar = new a();
                    a(aVar);
                    if (!aVar.a) {
                        throw new h("type mismatch.");
                    }
                    int a = a(0, 0, true);
                    if (a < 0) {
                        map2 = new StringBuilder("size invalid: ");
                        map2.append(a);
                        throw new h(map2.toString());
                    }
                    for (int i2 = 0; i2 < a; i2++) {
                        map.put(a(key, 0, true), a(value, 1, true));
                    }
                } else if (z) {
                    throw new h("require field not exist.");
                }
                return map;
            }
        }
        return new HashMap();
    }

    public final boolean[] a(boolean[] zArr, int i, boolean z) {
        if (a(i) != null) {
            a aVar = new a();
            a(aVar);
            if (aVar.a != 9) {
                throw new h("type mismatch.");
            }
            z = a(0, 0, true);
            if (z >= false) {
                i = new StringBuilder("size invalid: ");
                i.append(z);
                throw new h(i.toString());
            }
            boolean[] zArr2 = new boolean[z];
            for (boolean z2 = false; z2 < z; z2++) {
                zArr2[z2] = a(zArr2[0], 0, true);
            }
            return zArr2;
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final byte[] a(byte[] bArr, int i, boolean z) {
        if (a(i) != null) {
            a aVar = new a();
            a(aVar);
            z = aVar.a;
            if (z) {
                bArr = a(0, 0, true);
                if (bArr < null) {
                    z = new StringBuilder("size invalid: ");
                    z.append(bArr);
                    throw new h(z.toString());
                }
                i = new byte[bArr];
                for (z = false; z < bArr; z++) {
                    i[z] = a(i[0], 0, true);
                }
                return i;
            } else if (!z) {
                throw new h("type mismatch.");
            } else {
                a aVar2 = new a();
                a(aVar2);
                if (aVar2.a != (byte) 0) {
                    StringBuilder stringBuilder = new StringBuilder("type mismatch, tag: ");
                    stringBuilder.append(i);
                    stringBuilder.append(", type: ");
                    stringBuilder.append(aVar.a);
                    stringBuilder.append(", ");
                    stringBuilder.append(aVar2.a);
                    throw new h(stringBuilder.toString());
                }
                int a = a(0, 0, true);
                if (a < 0) {
                    StringBuilder stringBuilder2 = new StringBuilder("invalid size, tag: ");
                    stringBuilder2.append(i);
                    stringBuilder2.append(", type: ");
                    stringBuilder2.append(aVar.a);
                    stringBuilder2.append(", ");
                    stringBuilder2.append(aVar2.a);
                    stringBuilder2.append(", size: ");
                    stringBuilder2.append(a);
                    throw new h(stringBuilder2.toString());
                }
                bArr = new byte[a];
                this.b.get(bArr);
                return bArr;
            }
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final short[] a(short[] sArr, int i, boolean z) {
        if (a(i) != null) {
            a aVar = new a();
            a(aVar);
            if (aVar.a != 9) {
                throw new h("type mismatch.");
            }
            z = a(0, 0, true);
            if (z >= false) {
                i = new StringBuilder("size invalid: ");
                i.append(z);
                throw new h(i.toString());
            }
            short[] sArr2 = new short[z];
            for (boolean z2 = false; z2 < z; z2++) {
                sArr2[z2] = a(sArr2[0], 0, true);
            }
            return sArr2;
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final int[] a(int[] iArr, int i, boolean z) {
        if (a(i) != null) {
            a aVar = new a();
            a(aVar);
            if (aVar.a != 9) {
                throw new h("type mismatch.");
            }
            z = a(0, 0, true);
            if (z >= false) {
                i = new StringBuilder("size invalid: ");
                i.append(z);
                throw new h(i.toString());
            }
            int[] iArr2 = new int[z];
            for (boolean z2 = false; z2 < z; z2++) {
                iArr2[z2] = a(iArr2[0], 0, true);
            }
            return iArr2;
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final long[] a(long[] jArr, int i, boolean z) {
        if (a(i) != null) {
            a aVar = new a();
            a(aVar);
            if (aVar.a != 9) {
                throw new h("type mismatch.");
            }
            z = a(0, 0, true);
            if (z >= false) {
                i = new StringBuilder("size invalid: ");
                i.append(z);
                throw new h(i.toString());
            }
            long[] jArr2 = new long[z];
            for (boolean z2 = false; z2 < z; z2++) {
                jArr2[z2] = a(jArr2[0], 0, true);
            }
            return jArr2;
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final float[] a(float[] fArr, int i, boolean z) {
        if (a(i) != null) {
            a aVar = new a();
            a(aVar);
            if (aVar.a != 9) {
                throw new h("type mismatch.");
            }
            z = a(0, 0, true);
            if (z >= false) {
                i = new StringBuilder("size invalid: ");
                i.append(z);
                throw new h(i.toString());
            }
            float[] fArr2 = new float[z];
            for (boolean z2 = false; z2 < z; z2++) {
                fArr2[z2] = a(fArr2[0], 0, true);
            }
            return fArr2;
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final double[] a(double[] dArr, int i, boolean z) {
        if (a(i) != null) {
            a aVar = new a();
            a(aVar);
            if (aVar.a != 9) {
                throw new h("type mismatch.");
            }
            z = a(0, 0, true);
            if (z >= false) {
                i = new StringBuilder("size invalid: ");
                i.append(z);
                throw new h(i.toString());
            }
            double[] dArr2 = new double[z];
            for (boolean z2 = false; z2 < z; z2++) {
                dArr2[z2] = a(dArr2[0], 0, true);
            }
            return dArr2;
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr != null) {
            if (tArr.length != 0) {
                return b(tArr[0], i, z);
            }
        }
        throw new h("unable to get type of key and value.");
    }

    public final <T> List<T> a(List<T> list, int i, boolean z) {
        if (list != null) {
            if (!list.isEmpty()) {
                boolean z2 = false;
                list = b(list.get(0), i, z);
                if (list == null) {
                    return null;
                }
                i = new ArrayList();
                while (z2 < list.length) {
                    i.add(list[z2]);
                    z2++;
                }
                return i;
            }
        }
        return new ArrayList();
    }

    private <T> T[] b(T t, int i, boolean z) {
        if (a(i) != 0) {
            a aVar = new a();
            a(aVar);
            if (!aVar.a) {
                throw new h("type mismatch.");
            }
            int a = a(0, 0, true);
            if (a < 0) {
                i = new StringBuilder("size invalid: ");
                i.append(a);
                throw new h(i.toString());
            }
            Object[] objArr = (Object[]) Array.newInstance(t.getClass(), a);
            for (int i2 = 0; i2 < a; i2++) {
                objArr[i2] = a((Object) t, 0, true);
            }
            return objArr;
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final m a(m mVar, int i, boolean z) {
        if (a(i) != 0) {
            try {
                mVar = (m) mVar.getClass().newInstance();
                a aVar = new a();
                a(aVar);
                if (!aVar.a) {
                    throw new h("type mismatch.");
                }
                mVar.a(this);
                a();
                return mVar;
            } catch (m mVar2) {
                throw new h(mVar2.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(false, i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a((short) 0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a((float) null, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a(0.0d, i, z));
        }
        if (t instanceof String) {
            return String.valueOf(a(i, z));
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            return a((List) t, i, z);
        }
        if (t instanceof m) {
            return a((m) t, i, z);
        }
        if (t.getClass().isArray()) {
            if (!(t instanceof byte[])) {
                if (!(t instanceof Byte[])) {
                    if (t instanceof boolean[]) {
                        return a(null, i, z);
                    }
                    if (t instanceof short[]) {
                        return a(null, i, z);
                    }
                    if (t instanceof int[]) {
                        return a(null, i, z);
                    }
                    if (t instanceof long[]) {
                        return a(null, i, z);
                    }
                    if (t instanceof float[]) {
                        return a(null, i, z);
                    }
                    if (t instanceof double[]) {
                        return a(null, i, z);
                    }
                    return a((Object[]) t, i, z);
                }
            }
            return a(null, i, z);
        }
        throw new h("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.a = str;
        return null;
    }
}
