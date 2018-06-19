package com.getui.gtc.c.a;

import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import com.getui.gtc.a.e;
import com.getui.gtc.a.h;
import com.getui.gtc.e.i;
import com.getui.gtc.e.j;
import com.getui.gtc.entity.a;
import com.getui.gtc.entity.d;
import com.umeng.message.common.inter.ITagManager;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.json.JSONObject;

public final class b extends com.getui.gtc.c.b {
    private d a;

    public b(d dVar) {
        this.a = dVar;
    }

    private void a() {
        e c = e.c();
        d dVar = this.a;
        Message obtain = Message.obtain();
        com.getui.gtc.a.b b = com.getui.gtc.a.b.b();
        int i = dVar.a;
        com.getui.gtc.d.a.d dVar2 = b.a.c;
        Object obj = null;
        if (dVar2.b != null) {
            obj = (d) dVar2.b.get(i, null);
        }
        obtain.obj = obj;
        obtain.what = 6;
        c.a.sendMessageDelayed(obtain, 43200000);
    }

    private void b() {
        if (!TextUtils.isEmpty(com.getui.gtc.a.b.b().a(this.a.a))) {
            com.getui.gtc.a.b b = com.getui.gtc.a.b.b();
            b.a.b.a(this.a.a);
        }
    }

    public final void a(int i) {
        a();
        super.a(i);
    }

    public final void a(Throwable th) {
        a();
        super.a(th);
    }

    public final void a(byte[] bArr) {
        try {
            String str = new String(j.b(Base64.decode(bArr, 0)));
            String[] strArr = new String[1];
            StringBuilder stringBuilder = new StringBuilder("fetchconfig sdk id :");
            stringBuilder.append(this.a.a);
            stringBuilder.append("response config data = ");
            stringBuilder.append(str);
            strArr[0] = stringBuilder.toString();
            CharSequence charSequence = null;
            JSONObject jSONObject = new JSONObject(str);
        } catch (Exception e) {
            new String[1][0] = e.toString();
            jSONObject = null;
        } catch (Throwable th) {
            new String[1][0] = th.toString();
            return;
        }
        if (jSONObject == null) {
            a();
        } else if (jSONObject.has("result")) {
            try {
                str = jSONObject.getString("result");
            } catch (Exception e2) {
                new String[1][0] = e2.toString();
                str = null;
            }
            if (!ITagManager.SUCCESS.equalsIgnoreCase(str)) {
                a();
            } else if (jSONObject.has("config")) {
                JSONObject jSONObject2;
                try {
                    jSONObject2 = jSONObject.getJSONObject("config");
                } catch (Exception e22) {
                    new String[1][0] = e22.toString();
                    jSONObject2 = null;
                }
                if (jSONObject2 == null) {
                    a();
                    return;
                }
                e c;
                Parcelable parcelable;
                Message obtain;
                Bundle bundle;
                String jSONObject3;
                Class cls;
                AccessibleObject[] declaredConstructors;
                Constructor constructor;
                Method declaredMethod;
                if (jSONObject.has("tag")) {
                    String string = jSONObject.getString("tag");
                    if (!TextUtils.isEmpty(string)) {
                        com.getui.gtc.a.b b = com.getui.gtc.a.b.b();
                        int i = this.a.a;
                        com.getui.gtc.d.a.d dVar = b.a.c;
                        if (dVar.b != null) {
                            d dVar2 = (d) dVar.b.get(i);
                            if (dVar2 != null) {
                                dVar2.c = string;
                                dVar.b.put(i, dVar2);
                            }
                        }
                        dVar.a(i, 8, i.a(string.getBytes(), h.b));
                    }
                }
                if (jSONObject2.has("ext_infos")) {
                    try {
                        JSONObject jSONObject4;
                        try {
                            jSONObject4 = new JSONObject(jSONObject2.getString("ext_infos"));
                        } catch (Exception e3) {
                            new String[1][0] = e3.toString();
                            jSONObject4 = null;
                        }
                        if (jSONObject4 != null && jSONObject4.has("version")) {
                            try {
                                charSequence = jSONObject4.getString("version");
                            } catch (Exception e32) {
                                new String[1][0] = e32.toString();
                            }
                            if (!TextUtils.isEmpty(charSequence)) {
                                Parcelable a = a.a(jSONObject4);
                                if (a != null) {
                                    c = e.c();
                                    parcelable = this.a;
                                    obtain = Message.obtain();
                                    bundle = new Bundle();
                                    bundle.putParcelable("sif", parcelable);
                                    bundle.putParcelable("et", a);
                                    obtain.setData(bundle);
                                    obtain.what = 1;
                                    c.a(obtain);
                                }
                            }
                        }
                    } catch (Exception e4) {
                        new String[1][0] = e4.toString();
                    }
                } else {
                    e.c().a(this.a.a);
                    com.getui.gtc.a.b.b().b(this.a.a, this.a.f);
                }
                int i2;
                if (jSONObject2.has("localExtensions")) {
                    Object string2 = jSONObject2.getString("localExtensions");
                    if (TextUtils.isEmpty(string2)) {
                        i2 = this.a.a;
                    } else {
                        c = e.c();
                        parcelable = this.a;
                        obtain = Message.obtain();
                        obtain.what = 4;
                        bundle = new Bundle();
                        bundle.putParcelable("sif", parcelable);
                        bundle.putString("let", string2);
                        obtain.setData(bundle);
                        c.a(obtain);
                        jSONObject3 = jSONObject2.toString();
                        cls = Class.forName(this.a.b);
                        declaredConstructors = cls.getDeclaredConstructors();
                        AccessibleObject.setAccessible(declaredConstructors, true);
                        constructor = declaredConstructors[0];
                        declaredMethod = cls.getDeclaredMethod("receiveEvent", new Class[]{String.class});
                        declaredMethod.setAccessible(true);
                        declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[]{new String(Base64.encode(j.c(jSONObject3.getBytes()), 0))});
                        a();
                    }
                }
                i2 = this.a.a;
                b();
                jSONObject3 = jSONObject2.toString();
                try {
                    cls = Class.forName(this.a.b);
                    declaredConstructors = cls.getDeclaredConstructors();
                    AccessibleObject.setAccessible(declaredConstructors, true);
                    constructor = declaredConstructors[0];
                    declaredMethod = cls.getDeclaredMethod("receiveEvent", new Class[]{String.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(constructor.newInstance(new Object[0]), new Object[]{new String(Base64.encode(j.c(jSONObject3.getBytes()), 0))});
                } catch (Throwable th2) {
                    new String[1][0] = th2.toString();
                }
                a();
            } else {
                a();
            }
        } else {
            a();
        }
    }
}
