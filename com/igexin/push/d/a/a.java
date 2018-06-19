package com.igexin.push.d.a;

import com.igexin.b.a.b.b;
import com.igexin.b.a.b.d;
import com.igexin.push.d.c.e;
import com.igexin.push.d.c.h;
import com.igexin.push.d.c.j;
import com.igexin.push.d.c.m;
import com.igexin.push.d.c.o;
import com.igexin.push.d.c.p;
import com.igexin.push.d.c.q;
import org.json.JSONObject;

public class a extends b {
    public a(String str, b bVar) {
        super(str, true);
        a(bVar);
    }

    private boolean a(com.igexin.push.d.c.b bVar, e eVar) {
        if (bVar.b != (byte) 26) {
            return false;
        }
        p pVar = (p) eVar;
        if (pVar.a() && pVar.e != null) {
            try {
                JSONObject jSONObject = new JSONObject((String) pVar.e);
                if (jSONObject.has("action")) {
                    String string = jSONObject.getString("action");
                    if (string != null && string.equals("redirect_server")) {
                        return true;
                    }
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("CommandFilter|");
                stringBuilder.append(e.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
            }
        }
        return false;
    }

    public Object a(com.igexin.b.a.b.e eVar, d dVar, Object obj) {
        if (obj instanceof e) {
            e eVar2 = (e) obj;
            com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
            bVar.b = (byte) eVar2.i;
            bVar.a(eVar2.d());
            bVar.c = eVar2.j;
            bVar.d = eVar2.k;
            return bVar;
        } else if (!(obj instanceof e[])) {
            return null;
        } else {
            e[] eVarArr = (e[]) obj;
            Object obj2 = new com.igexin.push.d.c.b[eVarArr.length];
            for (int i = 0; i < eVarArr.length; i++) {
                obj2[i] = new com.igexin.push.d.c.b();
                obj2[i].b = (byte) eVarArr[i].i;
                obj2[i].a(eVarArr[i].d());
            }
            return obj2;
        }
    }

    public com.igexin.b.a.d.a.e b(com.igexin.b.a.b.e eVar, d dVar, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof h) {
            return (com.igexin.b.a.d.a.e) obj;
        }
        com.igexin.push.d.c.b bVar = (com.igexin.push.d.c.b) obj;
        byte b = bVar.b;
        com.igexin.b.a.d.a.e jVar = b != (byte) 5 ? b != (byte) 9 ? b != (byte) 26 ? b != (byte) 28 ? b != (byte) 37 ? b != (byte) 97 ? null : new j() : new o() : new com.igexin.push.d.c.a() : new p() : new q() : new m();
        if ((bVar.f != 1 && bVar.f != 7) || jVar == null) {
            return null;
        }
        jVar.a(bVar.e);
        return bVar.f == 7 ? (bVar.g != (byte) 32 || a(bVar, jVar)) ? jVar : null : a(bVar, jVar) ? jVar : null;
    }

    public /* synthetic */ Object c(com.igexin.b.a.b.e eVar, d dVar, Object obj) {
        return b(eVar, dVar, obj);
    }
}
