package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BUGLY */
public final class i {
    private StringBuilder a;
    private int b = 0;

    private void a(String str) {
        for (int i = 0; i < this.b; i++) {
            this.a.append('\t');
        }
        if (str != null) {
            StringBuilder stringBuilder = this.a;
            stringBuilder.append(str);
            stringBuilder.append(": ");
        }
    }

    public i(StringBuilder stringBuilder, int i) {
        this.a = stringBuilder;
        this.b = i;
    }

    public final i a(boolean z, String str) {
        a(str);
        str = this.a;
        str.append(z ? true : true);
        str.append(true);
        return this;
    }

    public final i a(byte b, String str) {
        a(str);
        str = this.a;
        str.append(b);
        str.append((byte) 10);
        return this;
    }

    public final i a(char c, String str) {
        a(str);
        str = this.a;
        str.append(c);
        str.append('\n');
        return this;
    }

    public final i a(short s, String str) {
        a(str);
        str = this.a;
        str.append(s);
        str.append((short) 10);
        return this;
    }

    public final i a(int i, String str) {
        a(str);
        str = this.a;
        str.append(i);
        str.append(10);
        return this;
    }

    public final i a(long j, String str) {
        a(str);
        str = this.a;
        str.append(j);
        str.append(10);
        return this;
    }

    public final i a(float f, String str) {
        a(str);
        str = this.a;
        str.append(f);
        str.append(1.4E-44f);
        return this;
    }

    public final i a(double d, String str) {
        a(str);
        str = this.a;
        str.append(d);
        str.append(4.9E-323d);
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.a.append("null\n");
        } else {
            str2 = this.a;
            str2.append(str);
            str2.append('\n');
        }
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.a.append("null\n");
            return this;
        } else if (bArr.length == null) {
            str = this.a;
            str.append(bArr.length);
            str.append(", []\n");
            return this;
        } else {
            str = this.a;
            str.append(bArr.length);
            str.append(", [\n");
            str = new i(this.a, this.b + 1);
            for (byte a : bArr) {
                str.a(a, null);
            }
            a(']', null);
            return this;
        }
    }

    public final i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.a.append("null\n");
            return this;
        } else if (sArr.length == null) {
            str = this.a;
            str.append(sArr.length);
            str.append(", []\n");
            return this;
        } else {
            str = this.a;
            str.append(sArr.length);
            str.append(", [\n");
            str = new i(this.a, this.b + 1);
            for (short a : sArr) {
                str.a(a, null);
            }
            a(']', null);
            return this;
        }
    }

    public final i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.a.append("null\n");
            return this;
        } else if (iArr.length == null) {
            str = this.a;
            str.append(iArr.length);
            str.append(", []\n");
            return this;
        } else {
            str = this.a;
            str.append(iArr.length);
            str.append(", [\n");
            str = new i(this.a, this.b + 1);
            for (int a : iArr) {
                str.a(a, null);
            }
            a(']', null);
            return this;
        }
    }

    public final i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.a.append("null\n");
            return this;
        } else if (jArr.length == null) {
            str = this.a;
            str.append(jArr.length);
            str.append(", []\n");
            return this;
        } else {
            str = this.a;
            str.append(jArr.length);
            str.append(", [\n");
            str = new i(this.a, this.b + 1);
            for (long a : jArr) {
                str.a(a, null);
            }
            a(']', null);
            return this;
        }
    }

    public final i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.a.append("null\n");
            return this;
        } else if (fArr.length == null) {
            str = this.a;
            str.append(fArr.length);
            str.append(", []\n");
            return this;
        } else {
            str = this.a;
            str.append(fArr.length);
            str.append(", [\n");
            str = new i(this.a, this.b + 1);
            for (float a : fArr) {
                str.a(a, null);
            }
            a(']', null);
            return this;
        }
    }

    public final i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.a.append("null\n");
            return this;
        } else if (dArr.length == null) {
            str = this.a;
            str.append(dArr.length);
            str.append(", []\n");
            return this;
        } else {
            str = this.a;
            str.append(dArr.length);
            str.append(", [\n");
            str = new i(this.a, this.b + 1);
            for (double a : dArr) {
                str.a(a, null);
            }
            a(']', null);
            return this;
        }
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.a.append("null\n");
            return this;
        } else if (map.isEmpty() != null) {
            str = this.a;
            str.append(map.size());
            str.append(", {}\n");
            return this;
        } else {
            str = this.a;
            str.append(map.size());
            str.append(", {\n");
            str = new i(this.a, this.b + 1);
            i iVar = new i(this.a, this.b + 2);
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                str.a('(', null);
                iVar.a(entry.getKey(), null);
                iVar.a(entry.getValue(), null);
                str.a(')', null);
            }
            a('}', null);
            return this;
        }
    }

    public final <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.a.append("null\n");
            return this;
        } else if (tArr.length == null) {
            str = this.a;
            str.append(tArr.length);
            str.append(", []\n");
            return this;
        } else {
            str = this.a;
            str.append(tArr.length);
            str.append(", [\n");
            str = new i(this.a, this.b + 1);
            for (Object a : tArr) {
                str.a(a, null);
            }
            a(']', null);
            return this;
        }
    }

    public final <T> i a(Collection<T> collection, String str) {
        if (collection != null) {
            return a(collection.toArray(), str);
        }
        a(str);
        this.a.append("null\t");
        return this;
    }

    public final <T> i a(T t, String str) {
        if (t == null) {
            this.a.append("null\n");
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            a((List) t, str);
        } else if (t instanceof m) {
            a((m) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((boolean[]) t, str);
        } else if (t instanceof short[]) {
            a((short[]) t, str);
        } else if (t instanceof int[]) {
            a((int[]) t, str);
        } else if (t instanceof long[]) {
            a((long[]) t, str);
        } else if (t instanceof float[]) {
            a((float[]) t, str);
        } else if (t instanceof double[]) {
            a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            a((Object[]) t, str);
        } else {
            throw new j("write object error: unsupport type.");
        }
        return this;
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            mVar = this.a;
            mVar.append('\t');
            mVar.append("null");
        } else {
            mVar.a(this.a, this.b + 1);
        }
        a('}', null);
        return this;
    }
}
