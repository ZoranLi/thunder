package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.serializer.af;
import com.alibaba.fastjson.serializer.ao;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* compiled from: OptionalCodec */
public final class s implements r, ao {
    public static s a = new s();

    public final int e_() {
        return 12;
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        if (type == OptionalInt.class) {
            aVar = j.m(aVar.a((Type) Integer.class, null));
            if (aVar == null) {
                return OptionalInt.empty();
            }
            return OptionalInt.of(aVar.intValue());
        } else if (type == OptionalLong.class) {
            aVar = j.l(aVar.a((Type) Long.class, null));
            if (aVar == null) {
                return OptionalLong.empty();
            }
            return OptionalLong.of(aVar.longValue());
        } else if (type == OptionalDouble.class) {
            aVar = j.h(aVar.a((Type) Double.class, null));
            if (aVar == null) {
                return OptionalDouble.empty();
            }
            return OptionalDouble.of(aVar.doubleValue());
        } else {
            aVar = aVar.a(j.d(type), null);
            if (aVar == null) {
                return Optional.empty();
            }
            return Optional.of(aVar);
        }
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            afVar.a.write("null");
        } else if ((obj instanceof Optional) != null) {
            afVar.c(((Optional) obj).get());
        } else if ((obj instanceof OptionalDouble) != null) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent() != null) {
                afVar.c(Double.valueOf(optionalDouble.getAsDouble()));
            } else {
                afVar.a.write("null");
            }
        } else if ((obj instanceof OptionalInt) != null) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (optionalInt.isPresent() != null) {
                afVar.a.a(optionalInt.getAsInt());
                return;
            }
            afVar.a.write("null");
        } else if ((obj instanceof OptionalLong) != null) {
            OptionalLong optionalLong = (OptionalLong) obj;
            if (optionalLong.isPresent() != null) {
                afVar.a.a(optionalLong.getAsLong());
                return;
            }
            afVar.a.write("null");
        } else {
            obj2 = new StringBuilder("not support optional : ");
            obj2.append(obj.getClass());
            throw new JSONException(obj2.toString());
        }
    }
}
