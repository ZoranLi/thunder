package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import com.alibaba.fastjson.parser.a.r;
import com.tencent.tinker.android.dex.DexFormat;
import java.io.IOException;
import java.lang.reflect.Type;

/* compiled from: CharacterCodec */
public final class p implements r, ao {
    public static final p a = new p();

    public final int e_() {
        return 4;
    }

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        afVar = afVar.a;
        Character ch = (Character) obj;
        if (ch == null) {
            afVar.b("");
        } else if (ch.charValue() == null) {
            afVar.b(DexFormat.MAGIC_SUFFIX);
        } else {
            afVar.b(ch.toString());
        }
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        Object a = aVar.a(null);
        if (a == null) {
            return null;
        }
        return j.c(a);
    }
}
