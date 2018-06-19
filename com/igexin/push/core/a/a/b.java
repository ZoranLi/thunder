package com.igexin.push.core.a.a;

import com.igexin.push.core.a.f;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;

public class b implements a {
    private boolean a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 0;
        r1 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x000f }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x000f }
        r3 = r1.getPackageInfo(r3, r0);	 Catch:{ Exception -> 0x000f }
        if (r3 == 0) goto L_0x000f;
    L_0x000d:
        r3 = 1;
        return r3;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.b.a(java.lang.String):boolean");
    }

    public com.igexin.push.core.b a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return com.igexin.push.core.b.success;
    }

    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = "type";	 Catch:{ Exception -> 0x0075 }
        r0 = r4.has(r0);	 Catch:{ Exception -> 0x0075 }
        if (r0 == 0) goto L_0x0075;	 Catch:{ Exception -> 0x0075 }
    L_0x0008:
        r0 = "actionid";	 Catch:{ Exception -> 0x0075 }
        r0 = r4.has(r0);	 Catch:{ Exception -> 0x0075 }
        if (r0 == 0) goto L_0x0075;	 Catch:{ Exception -> 0x0075 }
    L_0x0010:
        r0 = new com.igexin.push.core.bean.b;	 Catch:{ Exception -> 0x0075 }
        r0.<init>();	 Catch:{ Exception -> 0x0075 }
        r1 = "checkapp";	 Catch:{ Exception -> 0x0075 }
        r0.setType(r1);	 Catch:{ Exception -> 0x0075 }
        r1 = "actionid";	 Catch:{ Exception -> 0x0075 }
        r1 = r4.getString(r1);	 Catch:{ Exception -> 0x0075 }
        r0.setActionId(r1);	 Catch:{ Exception -> 0x0075 }
        r1 = "appstartupid";	 Catch:{ Exception -> 0x0075 }
        r1 = r4.has(r1);	 Catch:{ Exception -> 0x0075 }
        if (r1 == 0) goto L_0x0075;	 Catch:{ Exception -> 0x0075 }
    L_0x002b:
        r1 = "appstartupid";	 Catch:{ Exception -> 0x0075 }
        r1 = r4.getJSONObject(r1);	 Catch:{ Exception -> 0x0075 }
        r2 = "android";	 Catch:{ Exception -> 0x0075 }
        r2 = r1.has(r2);	 Catch:{ Exception -> 0x0075 }
        if (r2 == 0) goto L_0x0075;	 Catch:{ Exception -> 0x0075 }
    L_0x0039:
        r2 = "android";	 Catch:{ Exception -> 0x0075 }
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x0075 }
        r0.a(r1);	 Catch:{ Exception -> 0x0075 }
        r1 = "do_installed";	 Catch:{ Exception -> 0x0075 }
        r1 = r4.has(r1);	 Catch:{ Exception -> 0x0075 }
        if (r1 != 0) goto L_0x0052;	 Catch:{ Exception -> 0x0075 }
    L_0x004a:
        r1 = "do_uninstalled";	 Catch:{ Exception -> 0x0075 }
        r1 = r4.has(r1);	 Catch:{ Exception -> 0x0075 }
        if (r1 == 0) goto L_0x0075;	 Catch:{ Exception -> 0x0075 }
    L_0x0052:
        r1 = "do_installed";	 Catch:{ Exception -> 0x0075 }
        r1 = r4.has(r1);	 Catch:{ Exception -> 0x0075 }
        if (r1 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x0075 }
    L_0x005a:
        r1 = "do_installed";	 Catch:{ Exception -> 0x0075 }
        r1 = r4.getString(r1);	 Catch:{ Exception -> 0x0075 }
        r0.b(r1);	 Catch:{ Exception -> 0x0075 }
    L_0x0063:
        r1 = "do_uninstalled";	 Catch:{ Exception -> 0x0075 }
        r1 = r4.has(r1);	 Catch:{ Exception -> 0x0075 }
        if (r1 == 0) goto L_0x0074;	 Catch:{ Exception -> 0x0075 }
    L_0x006b:
        r1 = "do_uninstalled";	 Catch:{ Exception -> 0x0075 }
        r4 = r4.getString(r1);	 Catch:{ Exception -> 0x0075 }
        r0.c(r4);	 Catch:{ Exception -> 0x0075 }
    L_0x0074:
        return r0;
    L_0x0075:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.b.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        f a;
        String b;
        com.igexin.push.core.bean.b bVar = (com.igexin.push.core.bean.b) baseAction;
        String taskId = pushTaskBean.getTaskId();
        String messageId = pushTaskBean.getMessageId();
        if (a(bVar.a())) {
            if (!(bVar.b() == null || bVar.b().equals(""))) {
                a = f.a();
                b = bVar.b();
            }
            return true;
        }
        if (!(bVar.c() == null || bVar.c().equals(""))) {
            a = f.a();
            b = bVar.c();
        }
        return true;
        a.a(taskId, messageId, b);
        return true;
    }
}
