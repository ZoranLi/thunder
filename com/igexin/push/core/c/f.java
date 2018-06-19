package com.igexin.push.core.c;

import com.igexin.push.f.a.b;

public class f extends b {
    public static final String a = "com.igexin.push.core.c.f";

    public f(String str) {
        super(str);
        a();
    }

    private void c(byte[] r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = new java.lang.String;	 Catch:{ Throwable -> 0x04ae }
        r0.<init>(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x04ae }
        r7.<init>(r0);	 Catch:{ Throwable -> 0x04ae }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x04ae }
        r0.<init>();	 Catch:{ Throwable -> 0x04ae }
        r1 = a;	 Catch:{ Throwable -> 0x04ae }
        r0.append(r1);	 Catch:{ Throwable -> 0x04ae }
        r1 = "|parse sdk config from server resp = ";	 Catch:{ Throwable -> 0x04ae }
        r0.append(r1);	 Catch:{ Throwable -> 0x04ae }
        r0.append(r7);	 Catch:{ Throwable -> 0x04ae }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Throwable -> 0x04ae }
        r0 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x04ae }
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x04ae }
        r0.e(r1);	 Catch:{ Throwable -> 0x04ae }
        r0 = "result";	 Catch:{ Throwable -> 0x04ae }
        r0 = r7.has(r0);	 Catch:{ Throwable -> 0x04ae }
        if (r0 == 0) goto L_0x04ad;	 Catch:{ Throwable -> 0x04ae }
    L_0x0036:
        r0 = "ok";	 Catch:{ Throwable -> 0x04ae }
        r1 = "result";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.getString(r1);	 Catch:{ Throwable -> 0x04ae }
        r0 = r0.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r0 == 0) goto L_0x04ad;	 Catch:{ Throwable -> 0x04ae }
    L_0x0044:
        r0 = "config";	 Catch:{ Throwable -> 0x04ae }
        r0 = r7.has(r0);	 Catch:{ Throwable -> 0x04ae }
        if (r0 != 0) goto L_0x004d;	 Catch:{ Throwable -> 0x04ae }
    L_0x004c:
        return;	 Catch:{ Throwable -> 0x04ae }
    L_0x004d:
        r0 = "tag";	 Catch:{ Throwable -> 0x04ae }
        r0 = r7.has(r0);	 Catch:{ Throwable -> 0x04ae }
        if (r0 == 0) goto L_0x005d;	 Catch:{ Throwable -> 0x04ae }
    L_0x0055:
        r0 = "tag";	 Catch:{ Throwable -> 0x04ae }
        r0 = r7.getString(r0);	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.F = r0;	 Catch:{ Throwable -> 0x04ae }
    L_0x005d:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x04ae }
        r1 = "config";	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.getString(r1);	 Catch:{ Throwable -> 0x04ae }
        r0.<init>(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = "sdk.uploadapplist.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0090;	 Catch:{ Throwable -> 0x04ae }
    L_0x0070:
        r7 = "sdk.uploadapplist.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r1 = "true";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 != 0) goto L_0x0086;	 Catch:{ Throwable -> 0x04ae }
    L_0x007e:
        r1 = "false";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 == 0) goto L_0x0090;	 Catch:{ Throwable -> 0x04ae }
    L_0x0086:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.h = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x0090:
        r7 = "sdk.feature.sendmessage.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x00b8;	 Catch:{ Throwable -> 0x04ae }
    L_0x0098:
        r7 = "sdk.feature.sendmessage.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r1 = "true";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 != 0) goto L_0x00ae;	 Catch:{ Throwable -> 0x04ae }
    L_0x00a6:
        r1 = "false";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 == 0) goto L_0x00b8;	 Catch:{ Throwable -> 0x04ae }
    L_0x00ae:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.i = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x00b8:
        r7 = "sdk.readlocalcell.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x00e0;	 Catch:{ Throwable -> 0x04ae }
    L_0x00c0:
        r7 = "sdk.readlocalcell.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r1 = "true";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 != 0) goto L_0x00d6;	 Catch:{ Throwable -> 0x04ae }
    L_0x00ce:
        r1 = "false";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 == 0) goto L_0x00e0;	 Catch:{ Throwable -> 0x04ae }
    L_0x00d6:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.g = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x00e0:
        r7 = "sdk.snl.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0108;	 Catch:{ Throwable -> 0x04ae }
    L_0x00e8:
        r7 = "sdk.snl.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r1 = "true";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 != 0) goto L_0x00fe;	 Catch:{ Throwable -> 0x04ae }
    L_0x00f6:
        r1 = "false";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 == 0) goto L_0x0108;	 Catch:{ Throwable -> 0x04ae }
    L_0x00fe:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.n = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x0108:
        r7 = "sdk.domainbackup.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0130;	 Catch:{ Throwable -> 0x04ae }
    L_0x0110:
        r7 = "sdk.domainbackup.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r1 = "true";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 != 0) goto L_0x0126;	 Catch:{ Throwable -> 0x04ae }
    L_0x011e:
        r1 = "false";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 == 0) goto L_0x0130;	 Catch:{ Throwable -> 0x04ae }
    L_0x0126:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.f = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x0130:
        r7 = "sdk.feature.setsilenttime.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        r1 = 0;	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x016a;	 Catch:{ Throwable -> 0x04ae }
    L_0x0139:
        r7 = "sdk.feature.setsilenttime.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x014f;	 Catch:{ Throwable -> 0x04ae }
    L_0x0147:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x016a;	 Catch:{ Throwable -> 0x04ae }
    L_0x014f:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.k = r7;	 Catch:{ Throwable -> 0x04ae }
        if (r7 != 0) goto L_0x016a;	 Catch:{ Throwable -> 0x04ae }
    L_0x015b:
        r7 = com.igexin.push.config.m.b;	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x016a;	 Catch:{ Throwable -> 0x04ae }
    L_0x015f:
        r7 = com.igexin.push.core.a.f.a();	 Catch:{ Throwable -> 0x04ae }
        r2 = 12;	 Catch:{ Throwable -> 0x04ae }
        r3 = "server";	 Catch:{ Throwable -> 0x04ae }
        r7.a(r2, r1, r3);	 Catch:{ Throwable -> 0x04ae }
    L_0x016a:
        r7 = "sdk.snl.maxactiveflow";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x017e;	 Catch:{ Throwable -> 0x04ae }
    L_0x0172:
        r7 = "sdk.snl.maxactiveflow";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = java.lang.Long.parseLong(r7);	 Catch:{ Exception -> 0x017e }
        com.igexin.push.config.m.o = r2;	 Catch:{ Exception -> 0x017e }
    L_0x017e:
        r7 = "sdk.feature.settag.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x01a6;	 Catch:{ Throwable -> 0x04ae }
    L_0x0186:
        r7 = "sdk.feature.settag.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x019c;	 Catch:{ Throwable -> 0x04ae }
    L_0x0194:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x01a6;	 Catch:{ Throwable -> 0x04ae }
    L_0x019c:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.j = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x01a6:
        r7 = "sdk.feature.setheartbeatinterval.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x01ce;	 Catch:{ Throwable -> 0x04ae }
    L_0x01ae:
        r7 = "sdk.feature.setheartbeatinterval.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x01c4;	 Catch:{ Throwable -> 0x04ae }
    L_0x01bc:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x01ce;	 Catch:{ Throwable -> 0x04ae }
    L_0x01c4:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.l = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x01ce:
        r7 = "sdk.feature.setsockettimeout.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x01f6;	 Catch:{ Throwable -> 0x04ae }
    L_0x01d6:
        r7 = "sdk.feature.setsockettimeout.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x01ec;	 Catch:{ Throwable -> 0x04ae }
    L_0x01e4:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x01f6;	 Catch:{ Throwable -> 0x04ae }
    L_0x01ec:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.m = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x01f6:
        r7 = "sdk.guard.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x021e;	 Catch:{ Throwable -> 0x04ae }
    L_0x01fe:
        r7 = "sdk.guard.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x0214;	 Catch:{ Throwable -> 0x04ae }
    L_0x020c:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x021e;	 Catch:{ Throwable -> 0x04ae }
    L_0x0214:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.p = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x021e:
        r7 = "sdk.needlook.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x024d;	 Catch:{ Throwable -> 0x04ae }
    L_0x0226:
        r7 = "sdk.needlook.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x023c;	 Catch:{ Throwable -> 0x04ae }
    L_0x0234:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x024d;	 Catch:{ Throwable -> 0x04ae }
    L_0x023c:
        r2 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = r2.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.w = r2;	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.getBytes();	 Catch:{ Throwable -> 0x04ae }
        r6.d(r7);	 Catch:{ Throwable -> 0x04ae }
    L_0x024d:
        r7 = "sdk.report.initialize.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0275;	 Catch:{ Throwable -> 0x04ae }
    L_0x0255:
        r7 = "sdk.report.initialize.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x026b;	 Catch:{ Throwable -> 0x04ae }
    L_0x0263:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x0275;	 Catch:{ Throwable -> 0x04ae }
    L_0x026b:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.x = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x0275:
        r7 = "sdk.wakeupsdk.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x029d;	 Catch:{ Throwable -> 0x04ae }
    L_0x027d:
        r7 = "sdk.wakeupsdk.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x0293;	 Catch:{ Throwable -> 0x04ae }
    L_0x028b:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x029d;	 Catch:{ Throwable -> 0x04ae }
    L_0x0293:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.q = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x029d:
        r7 = "sdk.feature.feedback.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x02c5;	 Catch:{ Throwable -> 0x04ae }
    L_0x02a5:
        r7 = "sdk.feature.feedback.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x02bb;	 Catch:{ Throwable -> 0x04ae }
    L_0x02b3:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x02c5;	 Catch:{ Throwable -> 0x04ae }
    L_0x02bb:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.r = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x02c5:
        r7 = "sdk.watchout.app";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x02d5;	 Catch:{ Throwable -> 0x04ae }
    L_0x02cd:
        r7 = "sdk.watchout.app";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.t = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x02d5:
        r7 = "sdk.watchout.service";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x02e5;	 Catch:{ Throwable -> 0x04ae }
    L_0x02dd:
        r7 = "sdk.watchout.service";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.u = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x02e5:
        r7 = "sdk.daemon.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x030d;	 Catch:{ Throwable -> 0x04ae }
    L_0x02ed:
        r7 = "sdk.daemon.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x0303;	 Catch:{ Throwable -> 0x04ae }
    L_0x02fb:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x030d;	 Catch:{ Throwable -> 0x04ae }
    L_0x0303:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.v = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x030d:
        r7 = "sdk.guardactivity.first";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0335;	 Catch:{ Throwable -> 0x04ae }
    L_0x0315:
        r7 = "sdk.guardactivity.first";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = "true";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x032b;	 Catch:{ Throwable -> 0x04ae }
    L_0x0323:
        r2 = "false";	 Catch:{ Throwable -> 0x04ae }
        r2 = r7.equals(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r2 == 0) goto L_0x0335;	 Catch:{ Throwable -> 0x04ae }
    L_0x032b:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.G = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x0335:
        r7 = "sdk.polling.dis.cnt";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x034d;	 Catch:{ Throwable -> 0x04ae }
    L_0x033d:
        r7 = "sdk.polling.dis.cnt";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.intValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.H = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x034d:
        r7 = "sdk.polling.login.interval";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0368;	 Catch:{ Throwable -> 0x04ae }
    L_0x0355:
        r7 = "sdk.polling.login.interval";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.intValue();	 Catch:{ Throwable -> 0x04ae }
        r7 = r7 * 1000;	 Catch:{ Throwable -> 0x04ae }
        r2 = (long) r7;	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.I = r2;	 Catch:{ Throwable -> 0x04ae }
    L_0x0368:
        r7 = "sdk.polling.exit.heartbeat.cnt";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0380;	 Catch:{ Throwable -> 0x04ae }
    L_0x0370:
        r7 = "sdk.polling.exit.heartbeat.cnt";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.intValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.J = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x0380:
        r7 = "sdk.reset.reconnect.delay";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0397;	 Catch:{ Throwable -> 0x04ae }
    L_0x0388:
        r7 = "sdk.reset.reconnect.delay";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r2 = java.lang.Long.parseLong(r7);	 Catch:{ Exception -> 0x0397 }
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0397 }
        r2 = r2 * r4;	 Catch:{ Exception -> 0x0397 }
        com.igexin.push.config.m.y = r2;	 Catch:{ Exception -> 0x0397 }
    L_0x0397:
        r7 = "sdk.guard.maxcnt";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x03ab;	 Catch:{ Throwable -> 0x04ae }
    L_0x039f:
        r7 = "sdk.guard.maxcnt";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x03ab }
        com.igexin.push.config.m.E = r7;	 Catch:{ Exception -> 0x03ab }
    L_0x03ab:
        r7 = "ext_infos";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0406;	 Catch:{ Throwable -> 0x04ae }
    L_0x03b3:
        r7 = "ext_infos";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0406;	 Catch:{ Throwable -> 0x04ae }
    L_0x03bb:
        r2 = "";	 Catch:{ Throwable -> 0x04ae }
        r2 = r2.equals(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r2 != 0) goto L_0x0406;	 Catch:{ Throwable -> 0x04ae }
    L_0x03c3:
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x04ae }
        r2.<init>(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = "version";	 Catch:{ Throwable -> 0x04ae }
        r7 = r2.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0406;	 Catch:{ Throwable -> 0x04ae }
    L_0x03d0:
        r7 = "version";	 Catch:{ Throwable -> 0x04ae }
        r7 = r2.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r3 = 1;	 Catch:{ Throwable -> 0x04ae }
        r4 = com.igexin.push.config.m.s;	 Catch:{ Throwable -> 0x04ae }
        if (r4 == 0) goto L_0x03e8;	 Catch:{ Throwable -> 0x04ae }
    L_0x03db:
        r4 = com.igexin.push.config.m.s;	 Catch:{ Throwable -> 0x04ae }
        r4 = r4.a();	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.equals(r4);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x03e8;	 Catch:{ Throwable -> 0x04ae }
    L_0x03e7:
        goto L_0x03e9;	 Catch:{ Throwable -> 0x04ae }
    L_0x03e8:
        r1 = r3;	 Catch:{ Throwable -> 0x04ae }
    L_0x03e9:
        if (r1 == 0) goto L_0x0406;	 Catch:{ Throwable -> 0x04ae }
    L_0x03eb:
        r7 = com.igexin.push.core.a.f.a();	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.a(r2);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0406;	 Catch:{ Throwable -> 0x04ae }
    L_0x03f5:
        r1 = android.os.Message.obtain();	 Catch:{ Throwable -> 0x04ae }
        r2 = com.igexin.push.core.a.h;	 Catch:{ Throwable -> 0x04ae }
        r1.what = r2;	 Catch:{ Throwable -> 0x04ae }
        r1.obj = r7;	 Catch:{ Throwable -> 0x04ae }
        r7 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x04ae }
        r7.a(r1);	 Catch:{ Throwable -> 0x04ae }
    L_0x0406:
        r7 = "sdk.httpdata.maxsize";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x041e;	 Catch:{ Throwable -> 0x04ae }
    L_0x040e:
        r7 = "sdk.httpdata.maxsize";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.intValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.K = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x041e:
        r7 = "sdk.hide.righticon.blacklist";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x042e;	 Catch:{ Throwable -> 0x04ae }
    L_0x0426:
        r7 = "sdk.hide.righticon.blacklist";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.L = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x042e:
        r7 = "sdk.miuipush.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x0456;	 Catch:{ Throwable -> 0x04ae }
    L_0x0436:
        r7 = "sdk.miuipush.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r1 = "true";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 != 0) goto L_0x044c;	 Catch:{ Throwable -> 0x04ae }
    L_0x0444:
        r1 = "false";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 == 0) goto L_0x0456;	 Catch:{ Throwable -> 0x04ae }
    L_0x044c:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.M = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x0456:
        r7 = "sdk.flymepush.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x047e;	 Catch:{ Throwable -> 0x04ae }
    L_0x045e:
        r7 = "sdk.flymepush.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r1 = "true";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 != 0) goto L_0x0474;	 Catch:{ Throwable -> 0x04ae }
    L_0x046c:
        r1 = "false";	 Catch:{ Throwable -> 0x04ae }
        r1 = r7.equals(r1);	 Catch:{ Throwable -> 0x04ae }
        if (r1 == 0) goto L_0x047e;	 Catch:{ Throwable -> 0x04ae }
    L_0x0474:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.N = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x047e:
        r7 = "sdk.hmspush.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.has(r7);	 Catch:{ Throwable -> 0x04ae }
        if (r7 == 0) goto L_0x04a6;	 Catch:{ Throwable -> 0x04ae }
    L_0x0486:
        r7 = "sdk.hmspush.enable";	 Catch:{ Throwable -> 0x04ae }
        r7 = r0.getString(r7);	 Catch:{ Throwable -> 0x04ae }
        r0 = "true";	 Catch:{ Throwable -> 0x04ae }
        r0 = r7.equals(r0);	 Catch:{ Throwable -> 0x04ae }
        if (r0 != 0) goto L_0x049c;	 Catch:{ Throwable -> 0x04ae }
    L_0x0494:
        r0 = "false";	 Catch:{ Throwable -> 0x04ae }
        r0 = r7.equals(r0);	 Catch:{ Throwable -> 0x04ae }
        if (r0 == 0) goto L_0x04a6;	 Catch:{ Throwable -> 0x04ae }
    L_0x049c:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Throwable -> 0x04ae }
        r7 = r7.booleanValue();	 Catch:{ Throwable -> 0x04ae }
        com.igexin.push.config.m.O = r7;	 Catch:{ Throwable -> 0x04ae }
    L_0x04a6:
        r7 = com.igexin.push.config.a.a();	 Catch:{ Throwable -> 0x04ae }
        r7.f();	 Catch:{ Throwable -> 0x04ae }
    L_0x04ad:
        return;
    L_0x04ae:
        r7 = move-exception;
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = a;
        r0.append(r1);
        r1 = "|";
        r0.append(r1);
        r1 = r7.toString();
        r0.append(r1);
        r0 = r0.toString();
        com.igexin.b.a.c.a.b(r0);
        r0 = com.igexin.push.core.a.f.a();
        r7 = r7.toString();
        r0.b(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.f.c(byte[]):void");
    }

    private void d(byte[] r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = com.igexin.b.a.b.c.b();	 Catch:{ Exception -> 0x000e }
        r1 = new com.igexin.push.core.c.g;	 Catch:{ Exception -> 0x000e }
        r1.<init>(r3, r4);	 Catch:{ Exception -> 0x000e }
        r4 = 0;	 Catch:{ Exception -> 0x000e }
        r2 = 1;	 Catch:{ Exception -> 0x000e }
        r0.a(r1, r4, r2);	 Catch:{ Exception -> 0x000e }
    L_0x000e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.f.d(byte[]):void");
    }

    public void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "action";	 Catch:{ Exception -> 0x0033 }
        r2 = "sdkconfig";	 Catch:{ Exception -> 0x0033 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0033 }
        r1 = "cid";	 Catch:{ Exception -> 0x0033 }
        r2 = com.igexin.push.core.g.r;	 Catch:{ Exception -> 0x0033 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0033 }
        r1 = "appid";	 Catch:{ Exception -> 0x0033 }
        r2 = com.igexin.push.core.g.a;	 Catch:{ Exception -> 0x0033 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0033 }
        r1 = "sdk_version";	 Catch:{ Exception -> 0x0033 }
        r2 = "2.11.1.0";	 Catch:{ Exception -> 0x0033 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0033 }
        r1 = "tag";	 Catch:{ Exception -> 0x0033 }
        r2 = com.igexin.push.config.m.F;	 Catch:{ Exception -> 0x0033 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0033 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0033 }
        r0 = r0.getBytes();	 Catch:{ Exception -> 0x0033 }
        r3.b(r0);	 Catch:{ Exception -> 0x0033 }
    L_0x0033:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.f.a():void");
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            c(bArr);
        }
    }

    public int b() {
        return 0;
    }
}
