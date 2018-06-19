package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* compiled from: DoubleSerializer */
public final class w implements ao {
    public static final w a = new w();
    private DecimalFormat b = null;

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj != null) {
            obj = ((Double) obj).doubleValue();
            if (Double.isNaN(obj) == null) {
                if (Double.isInfinite(obj) == null) {
                    CharSequence d;
                    if (this.b == null) {
                        d = Double.toString(obj);
                        if (d.endsWith(".0") != null) {
                            d = d.substring(null, d.length() - 2);
                        }
                    } else {
                        d = this.b.format(obj);
                    }
                    afVar.a(d);
                    if (afVar.b(SerializerFeature.WriteClassName) != null) {
                        afVar.write(68);
                    }
                    return;
                }
            }
            afVar.write("null");
        } else if (afVar.b(SerializerFeature.WriteNullNumberAsZero) != null) {
            afVar.write(48);
        } else {
            afVar.write("null");
        }
    }
}
