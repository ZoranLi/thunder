package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Currency;

/* compiled from: CurrencyCodec */
public final class u implements r, ao {
    public static final u a = new u();

    public final int e_() {
        return 4;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        if (obj == null) {
            afVar.write("null");
        } else {
            afVar.b(((Currency) obj).getCurrencyCode());
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        String str = (String) aVar.a(null);
        if (str != null) {
            if (str.length() != null) {
                return Currency.getInstance(str);
            }
        }
        return null;
    }
}
