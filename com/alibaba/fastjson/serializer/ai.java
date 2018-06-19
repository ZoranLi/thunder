package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* compiled from: ListSerializer */
public final class ai implements ao {
    public static final ai a = new ai();

    public final void a(af afVar, Object obj, Object obj2, Type type, int i) throws IOException {
        af afVar2 = afVar;
        Object obj3 = obj;
        Object obj4 = obj2;
        Type type2 = type;
        boolean z = afVar2.a.m;
        ax axVar = afVar2.a;
        int i2 = 0;
        type2 = (z && (type2 instanceof ParameterizedType)) ? ((ParameterizedType) type2).getActualTypeArguments()[0] : null;
        Type type3 = type2;
        if (obj3 != null) {
            List list = (List) obj3;
            if (list.size() == 0) {
                axVar.a((CharSequence) "[]");
                return;
            }
            at atVar = afVar2.m;
            afVar2.a(atVar, obj3, obj4);
            try {
                int i3 = 93;
                int i4 = 44;
                Object obj5;
                if (axVar.l) {
                    axVar.write(91);
                    afVar.d();
                    int i5 = 0;
                    for (Object obj52 : list) {
                        if (i5 != 0) {
                            axVar.write(i4);
                        }
                        afVar.f();
                        if (obj52 == null) {
                            i2 = i3;
                            afVar2.a.write("null");
                        } else if (afVar2.a(obj52)) {
                            afVar2.b(obj52);
                            i2 = i3;
                        } else {
                            ao a = afVar2.a(obj52.getClass());
                            afVar2.m = new at(atVar, obj3, obj4, i2);
                            i2 = i4;
                            i2 = i3;
                            a.a(afVar2, obj52, Integer.valueOf(i5), type3, 0);
                        }
                        i5++;
                        i3 = i2;
                        i4 = 44;
                        i2 = 0;
                    }
                    i2 = i3;
                    afVar.e();
                    afVar.f();
                    axVar.write(i2);
                    afVar2.m = atVar;
                    return;
                }
                i2 = 93;
                axVar.write(91);
                i3 = list.size();
                i4 = 0;
                while (i4 < i3) {
                    int i6;
                    int i7;
                    int i8;
                    int i9;
                    obj52 = list.get(i4);
                    if (i4 != 0) {
                        i6 = 44;
                        axVar.write(44);
                    } else {
                        i6 = 44;
                    }
                    if (obj52 == null) {
                        axVar.a((CharSequence) "null");
                    } else {
                        Class cls = obj52.getClass();
                        if (cls == Integer.class) {
                            axVar.a(((Integer) obj52).intValue());
                        } else if (cls == Long.class) {
                            long longValue = ((Long) obj52).longValue();
                            if (z) {
                                axVar.a(longValue, 'L');
                            } else {
                                axVar.a(longValue);
                            }
                        } else {
                            int i10;
                            if (axVar.j) {
                                i10 = 0;
                            } else {
                                i10 = 0;
                                afVar2.m = new at(atVar, obj3, obj4, 0);
                            }
                            int i11;
                            if (afVar2.a(obj52)) {
                                afVar2.b(obj52);
                                i11 = i10;
                                i7 = i6;
                                i8 = i4;
                                i9 = i3;
                            } else {
                                i11 = i10;
                                i7 = i6;
                                i8 = i4;
                                i9 = i3;
                                afVar2.a(obj52.getClass()).a(afVar2, obj52, Integer.valueOf(i4), type3, 0);
                            }
                            i4 = i8 + 1;
                            i3 = i9;
                        }
                    }
                    i7 = i6;
                    i8 = i4;
                    i9 = i3;
                    i4 = i8 + 1;
                    i3 = i9;
                }
                axVar.write(i2);
                afVar2.m = atVar;
            } catch (Throwable th) {
                Throwable th2 = th;
                afVar2.m = atVar;
            }
        } else if (axVar.b(SerializerFeature.WriteNullListAsEmpty)) {
            axVar.write("[]");
        } else {
            axVar.write("null");
        }
    }
}
