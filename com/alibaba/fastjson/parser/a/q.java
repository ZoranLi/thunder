package com.alibaba.fastjson.parser.a;

import com.alibaba.fastjson.c.j;
import com.alibaba.fastjson.parser.a;
import java.lang.reflect.Type;

/* compiled from: NumberDeserializer */
public final class q implements r {
    public static final q a = new q();

    public final int e_() {
        return 2;
    }

    public final <T> T a(a aVar, Type type, Object obj) {
        obj = aVar.e;
        if (obj.a() == 2) {
            if (type != Double.TYPE) {
                if (type != Double.class) {
                    long s = obj.s();
                    obj.a(16);
                    if (type != Short.TYPE) {
                        if (type != Short.class) {
                            if (type != Byte.TYPE) {
                                if (type != Byte.class) {
                                    if (s < Integer.MIN_VALUE || s > Integer.MAX_VALUE) {
                                        return Long.valueOf(s);
                                    }
                                    return Integer.valueOf((int) s);
                                }
                            }
                            return Byte.valueOf((byte) ((int) s));
                        }
                    }
                    return Short.valueOf((short) ((int) s));
                }
            }
            aVar = obj.u();
            obj.a(16);
            return Double.valueOf(Double.parseDouble(aVar));
        } else if (obj.a() == 3) {
            if (type != Double.TYPE) {
                if (type != Double.class) {
                    aVar = obj.k();
                    obj.a(16);
                    if (type != Short.TYPE) {
                        if (type != Short.class) {
                            if (type != Byte.TYPE) {
                                if (type != Byte.class) {
                                    return aVar;
                                }
                            }
                            return Byte.valueOf(aVar.byteValue());
                        }
                    }
                    return Short.valueOf(aVar.shortValue());
                }
            }
            aVar = obj.u();
            obj.a(16);
            return Double.valueOf(Double.parseDouble(aVar));
        } else {
            Object a = aVar.a(null);
            if (a == null) {
                return null;
            }
            if (type != Double.TYPE) {
                if (type != Double.class) {
                    if (type != Short.TYPE) {
                        if (type != Short.class) {
                            if (type != Byte.TYPE) {
                                if (type != Byte.class) {
                                    return j.e(a);
                                }
                            }
                            return j.b(a);
                        }
                    }
                    return j.d(a);
                }
            }
            return j.h(a);
        }
    }
}
