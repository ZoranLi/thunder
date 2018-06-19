package com.xiaomi.push.service;

import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.android.e;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.smack.packet.c;
import com.xiaomi.smack.packet.d;
import com.xiaomi.smack.util.g;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.au;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.u;
import com.xiaomi.xmpush.thrift.z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.thrift.a;

public class x {
    public static Intent a(byte[] bArr, long j) {
        af a = a(bArr);
        if (a == null) {
            return null;
        }
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.putExtra("mipush_payload", bArr);
        intent.putExtra("mrt", Long.toString(j));
        intent.setPackage(a.f);
        return intent;
    }

    public static af a(Context context, af afVar) {
        return a(context, afVar, false, false, false);
    }

    public static af a(Context context, af afVar, boolean z, boolean z2, boolean z3) {
        a zVar = new z();
        zVar.b(afVar.h());
        u m = afVar.m();
        if (m != null) {
            zVar.a(m.b());
            zVar.a(m.d());
            if (!TextUtils.isEmpty(m.f())) {
                zVar.c(m.f());
            }
        }
        zVar.a(au.a(context, afVar));
        zVar.b(au.a(z, z2, z3));
        af a = af.a(afVar.j(), afVar.h(), zVar, com.xiaomi.xmpush.thrift.a.f);
        u a2 = afVar.m().a();
        a2.a("mat", Long.toString(System.currentTimeMillis()));
        a.a(a2);
        return a;
    }

    public static af a(byte[] bArr) {
        Object afVar = new af();
        try {
            au.a(afVar, bArr);
            return afVar;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    private static void a(XMPushService xMPushService, af afVar) {
        xMPushService.a(new y(4, xMPushService, afVar));
    }

    private static void a(XMPushService xMPushService, af afVar, String str) {
        xMPushService.a(new ac(4, xMPushService, afVar, str));
    }

    private static void a(XMPushService xMPushService, af afVar, String str, String str2) {
        xMPushService.a(new ad(4, xMPushService, afVar, str, str2));
    }

    public static void a(XMPushService xMPushService, af afVar, boolean z, boolean z2, boolean z3) {
        a(xMPushService, afVar, z, z2, z3, false);
    }

    public static void a(XMPushService xMPushService, af afVar, boolean z, boolean z2, boolean z3, boolean z4) {
        xMPushService.a(new ae(4, xMPushService, afVar, z, z2, z3, z4));
    }

    public static void a(com.xiaomi.push.service.XMPushService r12, java.lang.String r13, byte[] r14, android.content.Intent r15, boolean r16) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = r12;
        r8 = r14;
        r0 = r15;
        r9 = a(r8);
        r1 = r9.m();
        r2 = c(r9);
        if (r2 == 0) goto L_0x001b;
    L_0x0011:
        r2 = a(r7, r13);
        if (r2 == 0) goto L_0x001b;
    L_0x0017:
        d(r7, r9);
        return;
    L_0x001b:
        r2 = a(r9);
        if (r2 == 0) goto L_0x0031;
    L_0x0021:
        r2 = a(r7, r13);
        if (r2 != 0) goto L_0x0031;
    L_0x0027:
        r2 = b(r9);
        if (r2 != 0) goto L_0x0031;
    L_0x002d:
        e(r7, r9);
        return;
    L_0x0031:
        r2 = com.xiaomi.push.service.ah.b(r9);
        if (r2 == 0) goto L_0x003f;
    L_0x0037:
        r2 = r9.f;
        r2 = com.xiaomi.channel.commonutils.android.a.e(r7, r2);
        if (r2 != 0) goto L_0x0045;
    L_0x003f:
        r2 = a(r7, r0);
        if (r2 == 0) goto L_0x0194;
    L_0x0045:
        r2 = com.xiaomi.xmpush.thrift.a.a;
        r3 = r9.a();
        r10 = 0;
        if (r2 != r3) goto L_0x0064;
    L_0x004e:
        r2 = r9.j();
        r3 = "pref_registered_pkg_names";
        r3 = r7.getSharedPreferences(r3, r10);
        r3 = r3.edit();
        r4 = r9.e;
        r3.putString(r2, r4);
        r3.commit();
    L_0x0064:
        if (r1 == 0) goto L_0x012f;
    L_0x0066:
        r2 = r1.h();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x012f;
    L_0x0070:
        r2 = r1.j();
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x012f;
    L_0x007a:
        r2 = r1.h;
        r11 = 1;
        if (r2 == r11) goto L_0x012f;
    L_0x007f:
        r2 = r1.s();
        r2 = com.xiaomi.push.service.ah.a(r2);
        if (r2 != 0) goto L_0x0093;
    L_0x0089:
        r2 = r9.f;
        r2 = com.xiaomi.push.service.ah.a(r7, r2);
        if (r2 == 0) goto L_0x0093;
    L_0x0091:
        goto L_0x012f;
    L_0x0093:
        r0 = 0;
        if (r1 == 0) goto L_0x00b5;
    L_0x0096:
        r2 = r1.j;
        if (r2 == 0) goto L_0x00a4;
    L_0x009a:
        r0 = r1.j;
        r2 = "jobkey";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
    L_0x00a4:
        r2 = android.text.TextUtils.isEmpty(r0);
        if (r2 == 0) goto L_0x00ae;
    L_0x00aa:
        r0 = r1.b();
    L_0x00ae:
        r1 = r9.f;
        r1 = com.xiaomi.push.service.ai.a(r7, r1, r0);
        goto L_0x00b6;
    L_0x00b5:
        r1 = r10;
    L_0x00b6:
        if (r1 == 0) goto L_0x00ca;
    L_0x00b8:
        r1 = new java.lang.StringBuilder;
        r2 = "drop a duplicate message, key=";
        r1.<init>(r2);
        r1.append(r0);
        r0 = r1.toString();
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        goto L_0x0125;
    L_0x00ca:
        r0 = com.xiaomi.push.service.ah.a(r7, r9, r8);
        r1 = r0.b;
        r3 = 0;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x00eb;
    L_0x00d6:
        r1 = r0.a;
        r1 = android.text.TextUtils.isEmpty(r1);
        if (r1 != 0) goto L_0x00eb;
    L_0x00de:
        r1 = r0.a;
        r2 = r0.b;
        r4 = 1;
        r5 = java.lang.System.currentTimeMillis();
        r0 = r7;
        com.xiaomi.smack.util.g.a(r0, r1, r2, r4, r5);
    L_0x00eb:
        r0 = com.xiaomi.push.service.ah.b(r9);
        if (r0 != 0) goto L_0x0125;
    L_0x00f1:
        r0 = new android.content.Intent;
        r1 = "com.xiaomi.mipush.MESSAGE_ARRIVED";
        r0.<init>(r1);
        r1 = "mipush_payload";
        r0.putExtra(r1, r8);
        r1 = r9.f;
        r0.setPackage(r1);
        r1 = r7.getPackageManager();	 Catch:{ Exception -> 0x011c }
        r1 = r1.queryBroadcastReceivers(r0, r10);	 Catch:{ Exception -> 0x011c }
        if (r1 == 0) goto L_0x0125;	 Catch:{ Exception -> 0x011c }
    L_0x010c:
        r1 = r1.isEmpty();	 Catch:{ Exception -> 0x011c }
        if (r1 != 0) goto L_0x0125;	 Catch:{ Exception -> 0x011c }
    L_0x0112:
        r1 = r9.f;	 Catch:{ Exception -> 0x011c }
        r1 = com.xiaomi.push.service.e.a(r1);	 Catch:{ Exception -> 0x011c }
        r7.sendBroadcast(r0, r1);	 Catch:{ Exception -> 0x011c }
        goto L_0x0125;
    L_0x011c:
        r1 = r9.f;
        r1 = com.xiaomi.push.service.e.a(r1);
        r7.sendBroadcast(r0, r1);
    L_0x0125:
        if (r16 == 0) goto L_0x012b;
    L_0x0127:
        a(r7, r9, r10, r11, r10);
        goto L_0x017c;
    L_0x012b:
        c(r7, r9);
        goto L_0x017c;
    L_0x012f:
        r2 = "com.xiaomi.xmsf";
        r3 = r9.f;
        r2 = r2.contains(r3);
        if (r2 == 0) goto L_0x016c;
    L_0x0139:
        r2 = r9.c();
        if (r2 != 0) goto L_0x016c;
    L_0x013f:
        if (r1 == 0) goto L_0x016c;
    L_0x0141:
        r2 = r1.s();
        if (r2 == 0) goto L_0x016c;
    L_0x0147:
        r2 = r1.s();
        r3 = "ab";
        r2 = r2.containsKey(r3);
        if (r2 == 0) goto L_0x016c;
    L_0x0153:
        c(r7, r9);
        r0 = new java.lang.StringBuilder;
        r2 = "receive abtest message. ack it.";
        r0.<init>(r2);
        r1 = r1.b();
        r0.append(r1);
        r0 = r0.toString();
        com.xiaomi.channel.commonutils.logger.b.c(r0);
        goto L_0x017c;
    L_0x016c:
        r2 = r13;
        r1 = a(r7, r2, r9, r1);
        if (r1 == 0) goto L_0x017c;
    L_0x0173:
        r1 = r9.f;
        r1 = com.xiaomi.push.service.e.a(r1);
        r7.sendBroadcast(r0, r1);
    L_0x017c:
        r0 = r9.a();
        r1 = com.xiaomi.xmpush.thrift.a.b;
        if (r0 != r1) goto L_0x01a5;
    L_0x0184:
        r0 = "com.xiaomi.xmsf";
        r1 = r7.getPackageName();
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x01a5;
    L_0x0190:
        r7.stopSelf();
        return;
    L_0x0194:
        r0 = r9.f;
        r0 = com.xiaomi.channel.commonutils.android.a.e(r7, r0);
        if (r0 != 0) goto L_0x01a0;
    L_0x019c:
        a(r7, r9);
        return;
    L_0x01a0:
        r0 = "receive a mipush message, we can see the app, but we can't see the receiver.";
        com.xiaomi.channel.commonutils.logger.b.a(r0);
    L_0x01a5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(com.xiaomi.push.service.XMPushService, java.lang.String, byte[], android.content.Intent, boolean):void");
    }

    private static void a(XMPushService xMPushService, byte[] bArr, long j) {
        af a = a(bArr);
        if (a != null) {
            if (TextUtils.isEmpty(a.f)) {
                b.a("receive a mipush message without package name");
                return;
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            Intent a2 = a(bArr, valueOf.longValue());
            String a3 = ah.a(a);
            g.a(xMPushService, a3, j, true, System.currentTimeMillis());
            u m = a.m();
            if (m != null) {
                m.a("mrt", Long.toString(valueOf.longValue()));
            }
            String str;
            StringBuilder stringBuilder;
            if (com.xiaomi.xmpush.thrift.a.e == a.a() && u.a((Context) xMPushService).a(a.f) && !ah.b(a)) {
                str = "";
                if (m != null) {
                    str = m.b();
                }
                stringBuilder = new StringBuilder("Drop a message for unregistered, msgid=");
                stringBuilder.append(str);
                b.a(stringBuilder.toString());
                a(xMPushService, a, a.f);
            } else if (com.xiaomi.xmpush.thrift.a.e == a.a() && u.a((Context) xMPushService).c(a.f) && !ah.b(a)) {
                str = "";
                if (m != null) {
                    str = m.b();
                }
                stringBuilder = new StringBuilder("Drop a message for push closed, msgid=");
                stringBuilder.append(str);
                b.a(stringBuilder.toString());
                a(xMPushService, a, a.f);
            } else if (com.xiaomi.xmpush.thrift.a.e != a.a() || TextUtils.equals(xMPushService.getPackageName(), "com.xiaomi.xmsf") || TextUtils.equals(xMPushService.getPackageName(), a.f)) {
                if (!(m == null || m.b() == null)) {
                    b.a(String.format("receive a message, appid=%1$s, msgid= %2$s", new Object[]{a.h(), m.b()}));
                }
                if (m != null) {
                    Map s = m.s();
                    if (s != null && s.containsKey("hide") && "true".equalsIgnoreCase((String) s.get("hide"))) {
                        c(xMPushService, a);
                        return;
                    }
                }
                if (!(m == null || m.s() == null || !m.s().containsKey("__miid"))) {
                    String str2 = (String) m.s().get("__miid");
                    Account a4 = e.a(xMPushService);
                    if (a4 == null || !TextUtils.equals(str2, a4.name)) {
                        r12 = new StringBuilder();
                        r12.append(str2);
                        r12.append(" should be login, but got ");
                        r12.append(a4);
                        b.a(r12.toString() == null ? "nothing" : a4.name);
                        str = "miid already logout or anther already login";
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(str2);
                        stringBuilder.append(" should be login, but got ");
                        stringBuilder.append(a4);
                        a(xMPushService, a, str, stringBuilder.toString() == null ? "nothing" : a4.name);
                        return;
                    }
                }
                boolean z = m != null && a(m.s());
                if (z) {
                    if (k.e(xMPushService)) {
                        boolean z2;
                        boolean z3 = a(m) && k.d(xMPushService);
                        if (!z3) {
                            z2 = true;
                        } else if (b(xMPushService, a)) {
                            z2 = a(xMPushService, m, bArr);
                        } else {
                            return;
                        }
                        a(xMPushService, a, true, false, false);
                        if (!z2) {
                            return;
                        }
                    }
                    a(xMPushService, a, false, false, false, true);
                    return;
                }
                a(xMPushService, a3, bArr, a2, z);
            } else {
                r12 = new StringBuilder("Receive a message with wrong package name, expect ");
                r12.append(xMPushService.getPackageName());
                r12.append(", received ");
                r12.append(a.f);
                b.a(r12.toString());
                stringBuilder = new StringBuilder("package should be ");
                stringBuilder.append(xMPushService.getPackageName());
                stringBuilder.append(", but got ");
                stringBuilder.append(a.f);
                a(xMPushService, a, "unmatched_package", stringBuilder.toString());
            }
        }
    }

    private static boolean a(android.content.Context r2, android.content.Intent r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = r2.getPackageManager();
        r0 = 32;
        r1 = 1;
        r2 = r2.queryBroadcastReceivers(r3, r0);	 Catch:{ Exception -> 0x0016 }
        if (r2 == 0) goto L_0x0014;	 Catch:{ Exception -> 0x0016 }
    L_0x000d:
        r2 = r2.isEmpty();	 Catch:{ Exception -> 0x0016 }
        if (r2 != 0) goto L_0x0014;
    L_0x0013:
        return r1;
    L_0x0014:
        r2 = 0;
        return r2;
    L_0x0016:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.x.a(android.content.Context, android.content.Intent):boolean");
    }

    private static boolean a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.mipush.miui.CLICK_MESSAGE");
        intent.setPackage(str);
        Intent intent2 = new Intent("com.xiaomi.mipush.miui.RECEIVE_MESSAGE");
        intent2.setPackage(str);
        PackageManager packageManager = context.getPackageManager();
        try {
            List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 32);
            List queryIntentServices = packageManager.queryIntentServices(intent, 32);
            if (queryBroadcastReceivers.isEmpty()) {
                if (queryIntentServices.isEmpty()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable e) {
            b.a(e);
            return false;
        }
    }

    private static boolean a(XMPushService xMPushService, u uVar, byte[] bArr) {
        Map s = uVar.s();
        String[] split = ((String) s.get("__geo_ids")).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        ArrayList arrayList = new ArrayList();
        for (String str : split) {
            if (h.a(xMPushService).a(str) != null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("geo_id", str);
                contentValues.put("message_id", uVar.b());
                int parseInt = Integer.parseInt((String) s.get("__geo_action"));
                contentValues.put("action", Integer.valueOf(parseInt));
                contentValues.put("content", bArr);
                contentValues.put("deadline", Long.valueOf(Long.parseLong((String) s.get("__geo_deadline"))));
                if (TextUtils.equals(h.a(xMPushService).c(str), "Enter") && parseInt == 1) {
                    return true;
                }
                arrayList.add(contentValues);
            }
        }
        if (!j.a(xMPushService).a(arrayList)) {
            StringBuilder stringBuilder = new StringBuilder("geofence added some new geofence message failed messagi_id:");
            stringBuilder.append(uVar.b());
            b.c(stringBuilder.toString());
        }
        return false;
    }

    private static boolean a(XMPushService xMPushService, String str, af afVar, u uVar) {
        boolean z = true;
        if (uVar != null && uVar.s() != null && uVar.s().containsKey("__check_alive") && uVar.s().containsKey("__awake")) {
            a aiVar = new ai();
            aiVar.b(afVar.h());
            aiVar.d(str);
            aiVar.c(r.P.W);
            aiVar.a(uVar.b());
            aiVar.h = new HashMap();
            boolean d = com.xiaomi.channel.commonutils.android.a.d(xMPushService.getApplicationContext(), str);
            aiVar.h.put("app_running", Boolean.toString(d));
            if (!d) {
                d = Boolean.parseBoolean((String) uVar.s().get("__awake"));
                aiVar.h.put("awaked", Boolean.toString(d));
                if (!d) {
                    z = false;
                }
            }
            try {
                af.a(xMPushService, af.a(afVar.j(), afVar.h(), aiVar, com.xiaomi.xmpush.thrift.a.i));
                return z;
            } catch (Throwable e) {
                b.a(e);
            }
        }
        return z;
    }

    private static boolean a(af afVar) {
        return "com.xiaomi.xmsf".equals(afVar.f) && afVar.m() != null && afVar.m().s() != null && afVar.m().s().containsKey("miui_package_name");
    }

    public static boolean a(u uVar) {
        if (uVar == null) {
            return false;
        }
        Map s = uVar.s();
        return s == null ? false : TextUtils.equals("1", (CharSequence) s.get("__geo_local_check"));
    }

    private static boolean a(Map<String, String> map) {
        return map != null && map.containsKey("__geo_ids");
    }

    private static boolean b(XMPushService xMPushService, af afVar) {
        if (!k.a(xMPushService) || !k.c(xMPushService)) {
            return false;
        }
        if (com.xiaomi.channel.commonutils.android.a.e(xMPushService, afVar.f)) {
            Map s = afVar.m().s();
            return (s == null || !"12".contains((CharSequence) s.get("__geo_action")) || TextUtils.isEmpty((CharSequence) s.get("__geo_ids"))) ? false : true;
        } else {
            a(xMPushService, afVar);
            return false;
        }
    }

    private static boolean b(af afVar) {
        Map s = afVar.m().s();
        return s != null && s.containsKey("notify_effect");
    }

    private static void c(XMPushService xMPushService, af afVar) {
        xMPushService.a(new z(4, xMPushService, afVar));
    }

    private static boolean c(af afVar) {
        if (afVar.m() != null) {
            if (afVar.m().s() != null) {
                return "1".equals(afVar.m().s().get("obslete_ads_message"));
            }
        }
        return false;
    }

    private static void d(XMPushService xMPushService, af afVar) {
        xMPushService.a(new aa(4, xMPushService, afVar));
    }

    private static void e(XMPushService xMPushService, af afVar) {
        xMPushService.a(new ab(4, xMPushService, afVar));
    }

    public void a(Context context, ap.b bVar, boolean z, int i, String str) {
        if (!z) {
            s a = t.a(context);
            if (a != null && "token-expired".equals(str)) {
                try {
                    t.a(context, a.d, a.e, a.f);
                } catch (Throwable e) {
                    b.a(e);
                } catch (Throwable e2) {
                    b.a(e2);
                }
            }
        }
    }

    public void a(XMPushService xMPushService, com.xiaomi.slim.b bVar, ap.b bVar2) {
        try {
            a(xMPushService, bVar.d(bVar2.i), (long) bVar.l());
        } catch (Throwable e) {
            b.a(e);
        }
    }

    public void a(XMPushService xMPushService, d dVar, ap.b bVar) {
        if (dVar instanceof c) {
            c cVar = (c) dVar;
            com.xiaomi.smack.packet.a p = cVar.p("s");
            if (p != null) {
                try {
                    a(xMPushService, aw.a(aw.a(bVar.i, cVar.k()), p.c()), (long) g.a(dVar.c()));
                    return;
                } catch (Throwable e) {
                    b.a(e);
                }
            }
            return;
        }
        b.a("not a mipush message");
    }
}
