package com.alibaba.fastjson.serializer;

import com.xiaomi.push.service.av;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: PrimitiveArraySerializer */
public final class ap implements ao {
    public static ap a = new ap();

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj != null) {
            int i2 = 0;
            if ((obj instanceof int[]) != null) {
                int[] iArr = (int[]) obj;
                afVar.write(91);
                while (i2 < iArr.length) {
                    if (i2 != 0) {
                        afVar.write(44);
                    }
                    afVar.a(iArr[i2]);
                    i2++;
                }
                afVar.write(93);
            } else if ((obj instanceof short[]) != null) {
                short[] sArr = (short[]) obj;
                afVar.write(91);
                while (i2 < sArr.length) {
                    if (i2 != 0) {
                        afVar.write(44);
                    }
                    afVar.a(sArr[i2]);
                    i2++;
                }
                afVar.write(93);
            } else if ((obj instanceof long[]) != null) {
                long[] jArr = (long[]) obj;
                afVar.write(91);
                while (i2 < jArr.length) {
                    if (i2 != 0) {
                        afVar.write(44);
                    }
                    afVar.a(jArr[i2]);
                    i2++;
                }
                afVar.write(93);
            } else if ((obj instanceof boolean[]) != null) {
                boolean[] zArr = (boolean[]) obj;
                afVar.write(91);
                while (i2 < zArr.length) {
                    if (i2 != 0) {
                        afVar.write(44);
                    }
                    if (zArr[i2] != null) {
                        afVar.write("true");
                    } else {
                        afVar.write(av.b);
                    }
                    i2++;
                }
                afVar.write(93);
            } else if ((obj instanceof float[]) != null) {
                float[] fArr = (float[]) obj;
                afVar.write(91);
                while (i2 < fArr.length) {
                    if (i2 != 0) {
                        afVar.write(44);
                    }
                    obj2 = fArr[i2];
                    if (Float.isNaN(obj2)) {
                        afVar.write("null");
                    } else {
                        afVar.a(Float.toString(obj2));
                    }
                    i2++;
                }
                afVar.write(93);
            } else if ((obj instanceof double[]) != null) {
                double[] dArr = (double[]) obj;
                afVar.write(91);
                while (i2 < dArr.length) {
                    if (i2 != 0) {
                        afVar.write(44);
                    }
                    double d = dArr[i2];
                    if (Double.isNaN(d) != null) {
                        afVar.write("null");
                    } else {
                        afVar.a(Double.toString(d));
                    }
                    i2++;
                }
                afVar.write(93);
            } else if ((obj instanceof byte[]) != null) {
                afVar.a((byte[]) obj);
            } else {
                afVar.b(new String((char[]) obj));
            }
        } else if (afVar.b(SerializerFeature.WriteNullListAsEmpty) != null) {
            afVar.write("[]");
        } else {
            afVar.write("null");
        }
    }
}
