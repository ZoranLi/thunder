package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.a;
import java.lang.reflect.Type;

/* compiled from: EnumDeserializer */
public final class g implements r {
    private final Class<?> a;
    private final Enum[] b;

    public final int e_() {
        return 2;
    }

    public g(Class<?> cls) {
        this.a = cls;
        this.b = (Enum[]) cls.getEnumConstants();
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        try {
            type = aVar.e;
            obj = type.a();
            if (obj == 2) {
                aVar = type.n();
                type.a(16);
                if (aVar >= null) {
                    if (aVar <= this.b.length) {
                        return this.b[aVar];
                    }
                }
                obj = new StringBuilder("parse enum ");
                obj.append(this.a.getName());
                obj.append(" error, value : ");
                obj.append(aVar);
                throw new JSONException(obj.toString());
            } else if (obj == 4) {
                aVar = type.l();
                type.a(16);
                if (aVar.length() == null) {
                    return null;
                }
                return Enum.valueOf(this.a, aVar);
            } else if (obj == 8) {
                type.a(16);
                return null;
            } else {
                aVar = aVar.a(null);
                obj = new StringBuilder("parse enum ");
                obj.append(this.a.getName());
                obj.append(" error, value : ");
                obj.append(aVar);
                throw new JSONException(obj.toString());
            }
        } catch (a aVar2) {
            throw aVar2;
        } catch (a aVar22) {
            throw new JSONException(aVar22.getMessage(), aVar22);
        }
    }
}
