package com.xunlei.downloadprovider.member.payment.activity;

import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.external.PayUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ActivityConfig */
public final class a {
    String a;
    int b;
    String c;
    String d;
    int e;
    List<List<LimitCondition>> f;
    private String g;
    private String h;
    private SparseArray<b> i;
    private SparseArray<b> j;
    private SparseArray<b> k;
    private boolean l;
    private final SimpleDateFormat m = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());

    private boolean c() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = 1;
        r1 = r8.m;	 Catch:{ Exception -> 0x0031 }
        r2 = r8.g;	 Catch:{ Exception -> 0x0031 }
        r1 = r1.parse(r2);	 Catch:{ Exception -> 0x0031 }
        r2 = r8.m;	 Catch:{ Exception -> 0x0031 }
        r3 = r8.h;	 Catch:{ Exception -> 0x0031 }
        r2 = r2.parse(r3);	 Catch:{ Exception -> 0x0031 }
        r3 = new java.util.Date;	 Catch:{ Exception -> 0x0031 }
        r3.<init>();	 Catch:{ Exception -> 0x0031 }
        r4 = r3.getTime();	 Catch:{ Exception -> 0x0031 }
        r6 = r1.getTime();	 Catch:{ Exception -> 0x0031 }
        r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Exception -> 0x0031 }
        if (r1 < 0) goto L_0x0030;	 Catch:{ Exception -> 0x0031 }
    L_0x0022:
        r3 = r3.getTime();	 Catch:{ Exception -> 0x0031 }
        r1 = r2.getTime();	 Catch:{ Exception -> 0x0031 }
        r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));
        if (r5 <= 0) goto L_0x002f;
    L_0x002e:
        goto L_0x0030;
    L_0x002f:
        r0 = 0;
    L_0x0030:
        return r0;
    L_0x0031:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.member.payment.activity.a.c():boolean");
    }

    final boolean a() {
        if ((c() || !a(this.i)) && !a(this.j)) {
            if (!a(this.k)) {
                return false;
            }
        }
        return true;
    }

    final SparseArray<b> a(int i) {
        if (i == 3) {
            return this.i;
        }
        if (i == 5) {
            return this.j;
        }
        return i == 204 ? this.k : 0;
    }

    static a a(JSONObject jSONObject, String str) {
        try {
            int i;
            a aVar = new a();
            aVar.g = jSONObject.getString("begin");
            aVar.h = jSONObject.getString("end");
            aVar.a = str;
            aVar.b = PayUtil.d(jSONObject.optString("sortval")).intValue();
            aVar.c = jSONObject.optString("abtestkey");
            aVar.e = jSONObject.getInt("acttype");
            str = null;
            aVar.l = false;
            JSONArray optJSONArray = jSONObject.optJSONArray("usertype_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                aVar.f = new ArrayList();
                int length = optJSONArray.length();
                for (i = 0; i < length; i++) {
                    JSONArray optJSONArray2 = optJSONArray.optJSONArray(i);
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        List arrayList = new ArrayList();
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            LimitCondition a = LimitCondition.a(optJSONArray2.optJSONObject(i2));
                            if (a != null) {
                                arrayList.add(a);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            aVar.f.add(arrayList);
                        }
                    }
                }
            }
            optJSONArray = jSONObject.optJSONArray("referfrom_list");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                StringBuilder stringBuilder = new StringBuilder();
                i = optJSONArray.length();
                while (str < i) {
                    stringBuilder.append(optJSONArray.getString(str));
                    if (str < i - 1) {
                        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                    str++;
                }
                aVar.d = stringBuilder.toString();
            }
            jSONObject = jSONObject.getJSONObject("payList");
            if (jSONObject != null && jSONObject.length() > null) {
                str = jSONObject.keys();
                aVar.i = new SparseArray();
                aVar.j = new SparseArray();
                aVar.k = new SparseArray();
                while (str.hasNext()) {
                    String str2 = (String) str.next();
                    if (TextUtils.equals("3", str2)) {
                        a(str2, jSONObject, aVar.i, aVar.l, aVar.e, aVar.a);
                    } else if (TextUtils.equals("5", str2)) {
                        a(str2, jSONObject, aVar.j, aVar.l, aVar.e, aVar.a);
                    } else if (TextUtils.equals("204", str2)) {
                        a(str2, jSONObject, aVar.k, aVar.l, aVar.e, aVar.a);
                    }
                }
            }
            return aVar;
        } catch (JSONObject jSONObject2) {
            new StringBuilder("activity config parseData fail = ").append(jSONObject2.toString());
            return null;
        }
    }

    private static void a(String str, JSONObject jSONObject, SparseArray<b> sparseArray, boolean z, int i, String str2) throws Exception {
        str = jSONObject.getJSONArray(str);
        jSONObject = str.length();
        for (int i2 = 0; i2 < jSONObject; i2++) {
            b a = b.a(str.getJSONObject(i2));
            if (a != null) {
                a.k = z;
                a.r = i;
                a.s = str2;
                sparseArray.append(a.h, a);
            }
        }
    }

    final boolean b() {
        if (!TextUtils.equals("vip2017bjautorenew", this.a)) {
            if (!TextUtils.equals("vip2017svipautorenew", this.a)) {
                return false;
            }
        }
        return true;
    }

    private static boolean a(SparseArray<b> sparseArray) {
        if (sparseArray == null || sparseArray.size() <= 0) {
            return false;
        }
        int size = sparseArray.size();
        boolean z = true;
        int i = 0;
        boolean z2 = true;
        while (i < size) {
            boolean z3;
            String str;
            int i2;
            int i3;
            StringBuilder stringBuilder;
            String stringBuilder2;
            int i4;
            b bVar = (b) sparseArray.valueAt(i);
            if (bVar.o <= 0) {
                if (bVar.p <= 0) {
                    z3 = false;
                    if (!z3) {
                        break;
                    }
                    c a = c.a();
                    str = bVar.f;
                    i2 = bVar.o;
                    i3 = bVar.p;
                    if (i3 > 0) {
                        if (i2 > 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(LoginHelper.a().g.c());
                            stringBuilder.append(str);
                            stringBuilder2 = stringBuilder.toString();
                            if (a.c.containsKey(stringBuilder2) && ((Integer) a.c.get(stringBuilder2)).intValue() >= i2) {
                            }
                        }
                        z2 = false;
                        if (!z2) {
                            break;
                        }
                        i++;
                        z2 = false;
                    } else {
                        i4 = 0;
                        for (Entry entry : a.c.entrySet()) {
                            if (((String) entry.getKey()).contains(str)) {
                                i4 += ((Integer) entry.getValue()).intValue();
                            }
                        }
                        if (i4 < i3) {
                            if (i2 > 0) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(LoginHelper.a().g.c());
                                stringBuilder.append(str);
                                stringBuilder2 = stringBuilder.toString();
                                if (a.c.containsKey(stringBuilder2) && ((Integer) a.c.get(stringBuilder2)).intValue() >= i2) {
                                }
                            }
                            z2 = false;
                            if (!z2) {
                                break;
                            }
                            i++;
                            z2 = false;
                        }
                    }
                    z2 = true;
                    if (!z2) {
                        break;
                    }
                    i++;
                    z2 = false;
                }
            }
            z3 = true;
            if (!z3) {
                c a2 = c.a();
                str = bVar.f;
                i2 = bVar.o;
                i3 = bVar.p;
                if (i3 > 0) {
                    if (i2 > 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(LoginHelper.a().g.c());
                        stringBuilder.append(str);
                        stringBuilder2 = stringBuilder.toString();
                    }
                    z2 = false;
                    if (!z2) {
                        break;
                    }
                    i++;
                    z2 = false;
                } else {
                    i4 = 0;
                    for (Entry entry2 : a2.c.entrySet()) {
                        if (((String) entry2.getKey()).contains(str)) {
                            i4 += ((Integer) entry2.getValue()).intValue();
                        }
                    }
                    if (i4 < i3) {
                        if (i2 > 0) {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(LoginHelper.a().g.c());
                            stringBuilder.append(str);
                            stringBuilder2 = stringBuilder.toString();
                        }
                        z2 = false;
                        if (!z2) {
                            break;
                        }
                        i++;
                        z2 = false;
                    }
                }
                z2 = true;
                if (!z2) {
                    break;
                }
                i++;
                z2 = false;
            } else {
                break;
            }
        }
        z = z2;
        return z;
    }
}
