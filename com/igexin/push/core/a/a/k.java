package com.igexin.push.core.a.a;

import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;

public class k implements a {
    private static final String a = "com.igexin.push.core.a.a.k";

    private static void a(android.content.Context r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r4.getPackageManager();	 Catch:{ Exception -> 0x0053 }
        r1 = 0;	 Catch:{ Exception -> 0x0053 }
        r5 = r0.getPackageInfo(r5, r1);	 Catch:{ Exception -> 0x0053 }
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x0053 }
        r2 = "android.intent.action.MAIN";	 Catch:{ Exception -> 0x0053 }
        r3 = 0;	 Catch:{ Exception -> 0x0053 }
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x0053 }
        r2 = "android.intent.category.LAUNCHER";	 Catch:{ Exception -> 0x0053 }
        r0.addCategory(r2);	 Catch:{ Exception -> 0x0053 }
        r5 = r5.packageName;	 Catch:{ Exception -> 0x0053 }
        r0.setPackage(r5);	 Catch:{ Exception -> 0x0053 }
        r5 = r4.getPackageManager();	 Catch:{ Exception -> 0x0053 }
        r5 = r5.queryIntentActivities(r0, r1);	 Catch:{ Exception -> 0x0053 }
        r5 = r5.iterator();	 Catch:{ Exception -> 0x0053 }
        r5 = r5.next();	 Catch:{ Exception -> 0x0053 }
        r5 = (android.content.pm.ResolveInfo) r5;	 Catch:{ Exception -> 0x0053 }
        if (r5 == 0) goto L_0x0053;	 Catch:{ Exception -> 0x0053 }
    L_0x002f:
        r0 = r5.activityInfo;	 Catch:{ Exception -> 0x0053 }
        r0 = r0.packageName;	 Catch:{ Exception -> 0x0053 }
        r5 = r5.activityInfo;	 Catch:{ Exception -> 0x0053 }
        r5 = r5.name;	 Catch:{ Exception -> 0x0053 }
        r1 = new android.content.Intent;	 Catch:{ Exception -> 0x0053 }
        r2 = "android.intent.action.MAIN";	 Catch:{ Exception -> 0x0053 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0053 }
        r2 = "android.intent.category.LAUNCHER";	 Catch:{ Exception -> 0x0053 }
        r1.addCategory(r2);	 Catch:{ Exception -> 0x0053 }
        r2 = 270532608; // 0x10200000 float:3.1554436E-29 double:1.336608677E-315;	 Catch:{ Exception -> 0x0053 }
        r1.setFlags(r2);	 Catch:{ Exception -> 0x0053 }
        r2 = new android.content.ComponentName;	 Catch:{ Exception -> 0x0053 }
        r2.<init>(r0, r5);	 Catch:{ Exception -> 0x0053 }
        r1.setComponent(r2);	 Catch:{ Exception -> 0x0053 }
        r4.startActivity(r1);	 Catch:{ Exception -> 0x0053 }
    L_0x0053:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.k.a(android.content.Context, java.lang.String):void");
    }

    public b a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return b.success;
    }

    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new com.igexin.push.core.bean.l;	 Catch:{ JSONException -> 0x0067 }
        r0.<init>();	 Catch:{ JSONException -> 0x0067 }
        r1 = "startapp";	 Catch:{ JSONException -> 0x0067 }
        r0.setType(r1);	 Catch:{ JSONException -> 0x0067 }
        r1 = "actionid";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x0067 }
        r0.setActionId(r1);	 Catch:{ JSONException -> 0x0067 }
        r1 = "do";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x0067 }
        r0.setDoActionId(r1);	 Catch:{ JSONException -> 0x0067 }
        r1 = "appstartupid";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0067 }
        if (r1 == 0) goto L_0x0033;	 Catch:{ JSONException -> 0x0067 }
    L_0x0024:
        r1 = "appstartupid";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.getJSONObject(r1);	 Catch:{ JSONException -> 0x0067 }
        r2 = "android";	 Catch:{ JSONException -> 0x0067 }
        r1 = r1.getString(r2);	 Catch:{ JSONException -> 0x0067 }
        r0.a(r1);	 Catch:{ JSONException -> 0x0067 }
    L_0x0033:
        r1 = "is_autostart";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0067 }
        if (r1 == 0) goto L_0x0044;	 Catch:{ JSONException -> 0x0067 }
    L_0x003b:
        r1 = "is_autostart";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x0067 }
        r0.d(r1);	 Catch:{ JSONException -> 0x0067 }
    L_0x0044:
        r1 = "appid";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0067 }
        if (r1 == 0) goto L_0x0055;	 Catch:{ JSONException -> 0x0067 }
    L_0x004c:
        r1 = "appid";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.getString(r1);	 Catch:{ JSONException -> 0x0067 }
        r0.b(r1);	 Catch:{ JSONException -> 0x0067 }
    L_0x0055:
        r1 = "noinstall_action";	 Catch:{ JSONException -> 0x0067 }
        r1 = r4.has(r1);	 Catch:{ JSONException -> 0x0067 }
        if (r1 == 0) goto L_0x0066;	 Catch:{ JSONException -> 0x0067 }
    L_0x005d:
        r1 = "noinstall_action";	 Catch:{ JSONException -> 0x0067 }
        r4 = r4.getString(r1);	 Catch:{ JSONException -> 0x0067 }
        r0.c(r4);	 Catch:{ JSONException -> 0x0067 }
    L_0x0066:
        return r0;
    L_0x0067:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.k.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public boolean b(com.igexin.push.core.bean.PushTaskBean r9, com.igexin.push.core.bean.BaseAction r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = 1;
        if (r9 == 0) goto L_0x00e0;
    L_0x0003:
        if (r10 == 0) goto L_0x00e0;
    L_0x0005:
        r1 = r10;
        r1 = (com.igexin.push.core.bean.l) r1;
        r2 = r1.b();
        r3 = "";
        r3 = r2.equals(r3);
        r4 = 0;
        if (r3 == 0) goto L_0x001a;
    L_0x0015:
        r2 = com.igexin.push.core.g.a;
    L_0x0017:
        r3 = r2;
        r2 = r0;
        goto L_0x0029;
    L_0x001a:
        r3 = com.igexin.push.core.g.a;
        r5 = r1.b();
        r3 = r3.equals(r5);
        if (r3 == 0) goto L_0x0027;
    L_0x0026:
        goto L_0x0017;
    L_0x0027:
        r3 = r2;
        r2 = r4;
    L_0x0029:
        r5 = new java.lang.StringBuilder;
        r6 = "doStartApp|";
        r5.<init>(r6);
        r5.append(r2);
        r6 = "|";
        r5.append(r6);
        r5.append(r3);
        r5 = r5.toString();
        com.igexin.b.a.c.a.b(r5);
        r5 = 0;
        if (r2 == 0) goto L_0x0083;
    L_0x0045:
        r2 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x00e0 }
        r4 = r9.getTaskId();	 Catch:{ Exception -> 0x00e0 }
        r6 = r9.getMessageId();	 Catch:{ Exception -> 0x00e0 }
        r2.a(r4, r6, r3, r5);	 Catch:{ Exception -> 0x00e0 }
        r10 = (com.igexin.push.core.bean.l) r10;	 Catch:{ Exception -> 0x00e0 }
        r10 = r10.d();	 Catch:{ Exception -> 0x00e0 }
        r2 = "true";	 Catch:{ Exception -> 0x00e0 }
        r10 = r10.equals(r2);	 Catch:{ Exception -> 0x00e0 }
        if (r10 == 0) goto L_0x0069;	 Catch:{ Exception -> 0x00e0 }
    L_0x0062:
        r10 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x00e0 }
        r2 = com.igexin.push.core.g.e;	 Catch:{ Exception -> 0x00e0 }
        a(r10, r2);	 Catch:{ Exception -> 0x00e0 }
    L_0x0069:
        r10 = r1.getDoActionId();	 Catch:{ Exception -> 0x00e0 }
        if (r10 == 0) goto L_0x00e0;	 Catch:{ Exception -> 0x00e0 }
    L_0x006f:
        r10 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x00e0 }
        r2 = r9.getTaskId();	 Catch:{ Exception -> 0x00e0 }
        r9 = r9.getMessageId();	 Catch:{ Exception -> 0x00e0 }
    L_0x007b:
        r1 = r1.getDoActionId();	 Catch:{ Exception -> 0x00e0 }
    L_0x007f:
        r10.a(r2, r9, r1);	 Catch:{ Exception -> 0x00e0 }
        return r0;	 Catch:{ Exception -> 0x00e0 }
    L_0x0083:
        r2 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x00e0 }
        r6 = r9.getTaskId();	 Catch:{ Exception -> 0x00e0 }
        r7 = r9.getMessageId();	 Catch:{ Exception -> 0x00e0 }
        r2.a(r6, r7, r3, r5);	 Catch:{ Exception -> 0x00e0 }
        r2 = r1.d();	 Catch:{ Exception -> 0x00e0 }
        r3 = "true";	 Catch:{ Exception -> 0x00e0 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x00e0 }
        if (r2 == 0) goto L_0x00b3;	 Catch:{ Exception -> 0x00e0 }
    L_0x009e:
        r2 = r1.a();	 Catch:{ Exception -> 0x00e0 }
        r2 = com.igexin.push.util.a.a(r2);	 Catch:{ Exception -> 0x00e0 }
        if (r2 == 0) goto L_0x00b4;	 Catch:{ Exception -> 0x00e0 }
    L_0x00a8:
        r2 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x00e0 }
        r10 = (com.igexin.push.core.bean.l) r10;	 Catch:{ Exception -> 0x00e0 }
        r10 = r10.a();	 Catch:{ Exception -> 0x00e0 }
        a(r2, r10);	 Catch:{ Exception -> 0x00e0 }
    L_0x00b3:
        r4 = r0;	 Catch:{ Exception -> 0x00e0 }
    L_0x00b4:
        if (r4 == 0) goto L_0x00c9;	 Catch:{ Exception -> 0x00e0 }
    L_0x00b6:
        r10 = r1.getDoActionId();	 Catch:{ Exception -> 0x00e0 }
        if (r10 == 0) goto L_0x00e0;	 Catch:{ Exception -> 0x00e0 }
    L_0x00bc:
        r10 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x00e0 }
        r2 = r9.getTaskId();	 Catch:{ Exception -> 0x00e0 }
        r9 = r9.getMessageId();	 Catch:{ Exception -> 0x00e0 }
        goto L_0x007b;	 Catch:{ Exception -> 0x00e0 }
    L_0x00c9:
        r10 = r1.c();	 Catch:{ Exception -> 0x00e0 }
        if (r10 == 0) goto L_0x00e0;	 Catch:{ Exception -> 0x00e0 }
    L_0x00cf:
        r10 = com.igexin.push.core.a.f.a();	 Catch:{ Exception -> 0x00e0 }
        r2 = r9.getTaskId();	 Catch:{ Exception -> 0x00e0 }
        r9 = r9.getMessageId();	 Catch:{ Exception -> 0x00e0 }
        r1 = r1.c();	 Catch:{ Exception -> 0x00e0 }
        goto L_0x007f;
    L_0x00e0:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.k.b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
