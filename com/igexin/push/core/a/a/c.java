package com.igexin.push.core.a.a;

import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.f;
import com.igexin.push.util.e;

public class c implements a {
    private boolean a(f fVar) {
        String c = fVar.c();
        return c != null && e.b(c);
    }

    public b a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return b.success;
    }

    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "ids";
        r0 = r5.has(r0);
        if (r0 == 0) goto L_0x004f;
    L_0x0008:
        r0 = "ids";	 Catch:{ Exception -> 0x004f }
        r0 = r5.getString(r0);	 Catch:{ Exception -> 0x004f }
        r1 = new org.json.JSONArray;	 Catch:{ Exception -> 0x004f }
        r1.<init>(r0);	 Catch:{ Exception -> 0x004f }
        r0 = r1.length();	 Catch:{ Exception -> 0x004f }
        if (r0 <= 0) goto L_0x004f;	 Catch:{ Exception -> 0x004f }
    L_0x0019:
        r0 = r1.length();	 Catch:{ Exception -> 0x004f }
        r0 = new int[r0];	 Catch:{ Exception -> 0x004f }
        r2 = 0;	 Catch:{ Exception -> 0x004f }
    L_0x0020:
        r3 = r1.length();	 Catch:{ Exception -> 0x004f }
        if (r2 >= r3) goto L_0x002f;	 Catch:{ Exception -> 0x004f }
    L_0x0026:
        r3 = r1.getInt(r2);	 Catch:{ Exception -> 0x004f }
        r0[r2] = r3;	 Catch:{ Exception -> 0x004f }
        r2 = r2 + 1;	 Catch:{ Exception -> 0x004f }
        goto L_0x0020;	 Catch:{ Exception -> 0x004f }
    L_0x002f:
        r1 = new com.igexin.push.core.bean.d;	 Catch:{ Exception -> 0x004f }
        r1.<init>();	 Catch:{ Exception -> 0x004f }
        r2 = "cleanext";	 Catch:{ Exception -> 0x004f }
        r1.setType(r2);	 Catch:{ Exception -> 0x004f }
        r1.a(r0);	 Catch:{ Exception -> 0x004f }
        r0 = "actionid";	 Catch:{ Exception -> 0x004f }
        r0 = r5.getString(r0);	 Catch:{ Exception -> 0x004f }
        r1.setActionId(r0);	 Catch:{ Exception -> 0x004f }
        r0 = "do";	 Catch:{ Exception -> 0x004f }
        r5 = r5.getString(r0);	 Catch:{ Exception -> 0x004f }
        r1.setDoActionId(r5);	 Catch:{ Exception -> 0x004f }
        return r1;
    L_0x004f:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.c.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.igexin.push.core.bean.PushTaskBean r9, com.igexin.push.core.bean.BaseAction r10) {
        /*
        r8 = this;
        r0 = com.igexin.push.config.m.s;
        r1 = 0;
        if (r0 == 0) goto L_0x0096;
    L_0x0005:
        r0 = com.igexin.push.config.m.s;
        r0 = r0.b();
        if (r0 == 0) goto L_0x0096;
    L_0x000d:
        r0 = com.igexin.push.config.m.s;
        r0 = r0.b();
        r0 = r0.size();
        if (r0 != 0) goto L_0x001a;
    L_0x0019:
        return r1;
    L_0x001a:
        r0 = 1;
        if (r9 == 0) goto L_0x0076;
    L_0x001d:
        if (r10 == 0) goto L_0x0076;
    L_0x001f:
        r2 = r10;
        r2 = (com.igexin.push.core.bean.d) r2;
        r3 = com.igexin.push.config.m.s;
        r3 = r3.b();
        r4 = r2.a();
        if (r4 == 0) goto L_0x006d;
    L_0x002e:
        r5 = r4.length;
        if (r5 <= 0) goto L_0x006d;
    L_0x0031:
        r5 = r1;
        r6 = r5;
    L_0x0033:
        r7 = r2.a();
        r7 = r7.length;
        if (r1 >= r7) goto L_0x0063;
    L_0x003a:
        r7 = r4[r1];
        r7 = java.lang.Integer.valueOf(r7);
        r7 = r3.containsKey(r7);
        if (r7 == 0) goto L_0x0060;
    L_0x0046:
        r5 = r4[r1];
        r5 = java.lang.Integer.valueOf(r5);
        r5 = r3.get(r5);
        r5 = (com.igexin.push.core.bean.f) r5;
        r8.a(r5);
        r5 = r4[r1];
        r5 = java.lang.Integer.valueOf(r5);
        r3.remove(r5);
        r5 = r0;
        r6 = r5;
    L_0x0060:
        r1 = r1 + 1;
        goto L_0x0033;
    L_0x0063:
        if (r5 == 0) goto L_0x006c;
    L_0x0065:
        r1 = com.igexin.push.config.a.a();
        r1.g();
    L_0x006c:
        r1 = r6;
    L_0x006d:
        if (r1 == 0) goto L_0x0076;
    L_0x006f:
        r1 = android.os.Process.myPid();
        android.os.Process.killProcess(r1);
    L_0x0076:
        r1 = r10.getDoActionId();
        r2 = "";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x0095;
    L_0x0082:
        r1 = com.igexin.push.core.a.f.a();
        r2 = r9.getTaskId();
        r9 = r9.getMessageId();
        r10 = r10.getDoActionId();
        r1.a(r2, r9, r10);
    L_0x0095:
        return r0;
    L_0x0096:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.c.b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
