package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.c.d;
import com.alibaba.fastjson.c.j;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.service.av;
import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;

/* compiled from: FieldSerializer */
public final class z implements Comparable<z> {
    public final d a;
    protected final boolean b;
    protected int c;
    protected i d;
    protected boolean e = false;
    protected boolean f = false;
    protected boolean g = false;
    protected boolean h = false;
    protected boolean i = false;
    protected boolean j = false;
    private final String k;
    private String l;
    private String m;
    private String n;
    private a o;

    /* compiled from: FieldSerializer */
    static class a {
        ao a;
        Class<?> b;

        public a(ao aoVar, Class<?> cls) {
            this.a = aoVar;
            this.b = cls;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.a.a(((z) obj).a);
    }

    public z(Class<?> cls, d dVar) {
        int i = 0;
        this.a = dVar;
        this.d = new i(cls, dVar);
        if (dVar.b != null) {
            j.a(dVar.b);
        } else {
            j.a(dVar.c);
        }
        cls = new StringBuilder("\"");
        cls.append(dVar.a);
        cls.append("\":");
        this.k = cls.toString();
        cls = dVar.b();
        if (cls != null) {
            SerializerFeature serializerFeature;
            for (SerializerFeature serializerFeature2 : cls.f()) {
                if (serializerFeature2 == SerializerFeature.WriteMapNullValue) {
                    dVar = 1;
                    break;
                }
            }
            dVar = null;
            this.n = cls.c();
            if (this.n.trim().length() == 0) {
                this.n = null;
            }
            SerializerFeature[] f = cls.f();
            int length = f.length;
            while (i < length) {
                serializerFeature2 = f[i];
                if (serializerFeature2 == SerializerFeature.WriteNullNumberAsZero) {
                    this.e = true;
                } else if (serializerFeature2 == SerializerFeature.WriteNullStringAsEmpty) {
                    this.f = true;
                } else if (serializerFeature2 == SerializerFeature.WriteNullBooleanAsFalse) {
                    this.g = true;
                } else if (serializerFeature2 == SerializerFeature.WriteNullListAsEmpty) {
                    this.h = true;
                } else if (serializerFeature2 == SerializerFeature.WriteEnumUsingToString) {
                    this.i = true;
                } else if (serializerFeature2 == SerializerFeature.WriteEnumUsingName) {
                    this.j = true;
                }
                i++;
            }
            this.c = SerializerFeature.of(cls.f());
        } else {
            dVar = null;
        }
        this.b = dVar;
    }

    public final void a(af afVar) throws IOException {
        afVar = afVar.a;
        StringBuilder stringBuilder;
        if (!afVar.h) {
            if (this.m == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.a);
                stringBuilder.append(Constants.COLON_SEPARATOR);
                this.m = stringBuilder.toString();
            }
            afVar.write(this.m);
        } else if (afVar.g) {
            if (this.l == null) {
                stringBuilder = new StringBuilder("'");
                stringBuilder.append(this.a.a);
                stringBuilder.append("':");
                this.l = stringBuilder.toString();
            }
            afVar.write(this.l);
        } else {
            afVar.write(this.k);
        }
    }

    public final Object a(Object obj) throws Exception {
        try {
            return this.a.a(obj);
        } catch (Object obj2) {
            Member a = this.a.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.getDeclaringClass().getName());
            stringBuilder.append(".");
            stringBuilder.append(a.getName());
            String stringBuilder2 = stringBuilder.toString();
            StringBuilder stringBuilder3 = new StringBuilder("get property error。 ");
            stringBuilder3.append(stringBuilder2);
            throw new JSONException(stringBuilder3.toString(), obj2);
        }
    }

    public final void a(af afVar, Object obj) throws Exception {
        if (this.n != null) {
            afVar.a(obj, this.n);
            return;
        }
        if (this.o == null) {
            Class cls;
            if (obj == null) {
                cls = this.a.d;
            } else {
                cls = obj.getClass();
            }
            this.o = new a(afVar.a(cls), cls);
        }
        a aVar = this.o;
        int i = this.a.h;
        if (obj == null) {
            Object obj2;
            ao aoVar;
            Class cls2 = aVar.b;
            ax axVar = afVar.a;
            if (!this.e) {
                if ((axVar.d & SerializerFeature.WriteNullNumberAsZero.mask) == 0) {
                    obj2 = null;
                    if (obj2 == null && Number.class.isAssignableFrom(cls2)) {
                        axVar.write(48);
                        return;
                    } else if (!this.f && String.class == cls2) {
                        axVar.write("\"\"");
                        return;
                    } else if (!this.g && Boolean.class == cls2) {
                        axVar.write(av.b);
                        return;
                    } else if (this.h || Collection.class.isAssignableFrom(cls2) == null) {
                        aoVar = aVar.a;
                        if (axVar.u != null || (aoVar instanceof a) == null) {
                            aoVar.a(afVar, null, this.a.a, this.a.e, i);
                            return;
                        }
                        axVar.write("null");
                        return;
                    } else {
                        axVar.write("[]");
                        return;
                    }
                }
            }
            obj2 = 1;
            if (obj2 == null) {
            }
            if (!this.f) {
            }
            if (!this.g) {
            }
            if (this.h) {
            }
            aoVar = aVar.a;
            if (axVar.u != null) {
            }
            aoVar.a(afVar, null, this.a.a, this.a.e, i);
            return;
        }
        if (this.a.m) {
            if (this.j) {
                afVar.a.b(((Enum) obj).name());
                return;
            } else if (this.i) {
                afVar.a.b(((Enum) obj).toString());
                return;
            }
        }
        Class cls3 = obj.getClass();
        if (cls3 == aVar.b) {
            aVar.a.a(afVar, obj, this.a.a, this.a.e, i);
            return;
        }
        afVar.a(cls3).a(afVar, obj, this.a.a, this.a.e, i);
    }
}
