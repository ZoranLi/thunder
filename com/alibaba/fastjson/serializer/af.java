package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.a;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: JSONSerializer */
public class af {
    public final ax a;
    protected List<j> b;
    protected List<c> c;
    protected List<aq> d;
    protected List<az> e;
    protected List<am> f;
    protected List<ar> g;
    protected List<ah> h;
    protected List<t> i;
    public String j;
    public DateFormat k;
    protected IdentityHashMap<Object, at> l;
    protected at m;
    protected TimeZone n;
    protected Locale o;
    private final av p;
    private int q;
    private String r;

    public af() {
        this(new ax(), av.a());
    }

    public af(ax axVar) {
        this(axVar, av.a());
    }

    public af(ax axVar, av avVar) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.q = 0;
        this.r = "\t";
        this.l = null;
        this.n = a.defaultTimeZone;
        this.o = a.defaultLocale;
        this.a = axVar;
        this.p = avVar;
    }

    public final DateFormat a() {
        if (this.k == null && this.j != null) {
            this.k = new SimpleDateFormat(this.j, this.o);
            this.k.setTimeZone(this.n);
        }
        return this.k;
    }

    public final void a(at atVar, Object obj, Object obj2) {
        a(atVar, obj, obj2, 0);
    }

    public final void a(at atVar, Object obj, Object obj2, int i) {
        if (!this.a.j) {
            this.m = new at(atVar, obj, obj2, i);
            if (this.l == null) {
                this.l = new IdentityHashMap();
            }
            this.l.put(obj, this.m);
        }
    }

    public final boolean a(Type type) {
        return (!this.a.b(SerializerFeature.WriteClassName) || (type == null && this.a.b(SerializerFeature.NotWriteRootClassName) != null && this.m.a == null)) ? null : true;
    }

    public final boolean a(Object obj) {
        return (this.l == null || this.l.containsKey(obj) == null) ? null : true;
    }

    public final void b(Object obj) {
        at atVar = this.m;
        if (obj == atVar.b) {
            this.a.write("{\"$ref\":\"@\"}");
            return;
        }
        at atVar2 = atVar.a;
        if (atVar2 == null || obj != atVar2.b) {
            while (atVar.a != null) {
                atVar = atVar.a;
            }
            if (obj == atVar.b) {
                this.a.write("{\"$ref\":\"$\"}");
                return;
            }
            this.a.write("{\"$ref\":\"");
            this.a.write(((at) this.l.get(obj)).toString());
            this.a.write("\"}");
            return;
        }
        this.a.write("{\"$ref\":\"..\"}");
    }

    public final List<az> b() {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        return this.e;
    }

    public final List<t> c() {
        if (this.i == null) {
            this.i = new ArrayList();
        }
        return this.i;
    }

    public final void d() {
        this.q++;
    }

    public final void e() {
        this.q--;
    }

    public final void f() {
        this.a.write(10);
        for (int i = 0; i < this.q; i++) {
            this.a.write(this.r);
        }
    }

    public final List<j> g() {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        return this.b;
    }

    public final List<c> h() {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        return this.c;
    }

    public final List<am> i() {
        if (this.f == null) {
            this.f = new ArrayList();
        }
        return this.f;
    }

    public final List<ar> j() {
        if (this.g == null) {
            this.g = new ArrayList();
        }
        return this.g;
    }

    public final List<ah> k() {
        if (this.h == null) {
            this.h = new ArrayList();
        }
        return this.h;
    }

    public final List<aq> l() {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        return this.d;
    }

    public String toString() {
        return this.a.toString();
    }

    public final void a(SerializerFeature serializerFeature) {
        this.a.a(serializerFeature);
    }

    public final void c(Object obj) {
        if (obj == null) {
            this.a.write("null");
            return;
        }
        try {
            a(obj.getClass()).a(this, obj, null, null, 0);
        } catch (Object obj2) {
            throw new JSONException(obj2.getMessage(), obj2);
        }
    }

    public final void a(Object obj, String str) {
        if (obj instanceof Date) {
            DateFormat a = a();
            if (a == null) {
                a = new SimpleDateFormat(str, this.o);
                a.setTimeZone(this.n);
            }
            this.a.b(a.format((Date) obj));
            return;
        }
        c(obj);
    }

    public final void a(String str) {
        ay ayVar = ay.a;
        ay.a(this, str);
    }

    public final ao a(Class<?> cls) {
        return this.p.a(cls);
    }

    public final Object a(String str, Object obj) {
        if (obj != null && this.a.q && ((obj instanceof Number) || (obj instanceof Boolean))) {
            obj = obj.toString();
        }
        List<az> list = this.e;
        if (list != null) {
            for (az a : list) {
                obj = a.a();
            }
        }
        List<t> list2 = this.i;
        if (list2 != null) {
            ag.a(str);
            for (t a2 : list2) {
                obj = a2.a();
            }
        }
        return obj;
    }

    public final String b(String str) {
        List<am> list = this.f;
        if (list != null) {
            for (am a : list) {
                str = a.a();
            }
        }
        return str;
    }

    public final boolean m() {
        List<ar> list = this.g;
        if (list == null) {
            return true;
        }
        for (ar a : list) {
            if (!a.a()) {
                return false;
            }
        }
        return true;
    }

    public final boolean n() {
        List<aq> list = this.d;
        if (list == null) {
            return true;
        }
        for (aq a : list) {
            if (!a.a()) {
                return false;
            }
        }
        return true;
    }

    public final char a(char c) {
        List list = this.b;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
                j.a.set(this);
                j.b.set(Character.valueOf(c));
                j.a.set(null);
                c = ((Character) j.b.get()).charValue();
            }
        }
        return c;
    }

    public final char b(char c) {
        List list = this.c;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
                c.a.set(this);
                c.b.set(Character.valueOf(c));
                c.a.set(null);
                c = ((Character) c.b.get()).charValue();
            }
        }
        return c;
    }
}
