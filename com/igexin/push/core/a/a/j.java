package com.igexin.push.core.a.a;

import com.igexin.push.config.l;
import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.m;

public class j implements a {
    private static final String a = l.a;

    private void a(m mVar, String str) {
        String a = mVar.a();
        if (a != null) {
            int indexOf = a.indexOf(str);
            if (indexOf != -1) {
                String str2 = "";
                String str3 = null;
                int indexOf2 = a.indexOf("&");
                if (indexOf2 == -1) {
                    str2 = a.substring(0, indexOf - 1);
                    str = a.substring(indexOf);
                    if (str.contains("=")) {
                        str3 = str.substring(str.indexOf("=") + 1);
                    }
                } else {
                    int i = indexOf - 1;
                    if (a.charAt(i) == '?') {
                        String substring = a.substring(0, indexOf);
                        str2 = a.substring(indexOf2 + 1);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(substring);
                        stringBuilder.append(str2);
                        str2 = stringBuilder.toString();
                        str = a.substring(indexOf, indexOf2);
                        if (str.contains("=")) {
                            str3 = str.substring(str.indexOf("=") + 1);
                        }
                    } else if (a.charAt(i) == '&') {
                        str2 = a.substring(0, i);
                        str = a.substring(indexOf);
                        a = "";
                        int indexOf3 = str.indexOf("&");
                        if (indexOf3 != -1) {
                            a = str.substring(indexOf3);
                            str = str.substring(0, indexOf3);
                        }
                        str3 = str.substring(str.indexOf("=") + 1);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(str2);
                        stringBuilder2.append(a);
                        str2 = stringBuilder2.toString();
                    }
                }
                mVar.a(str2);
                mVar.b(str3);
            }
        }
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
        r0 = "url";	 Catch:{ JSONException -> 0x0079 }
        r0 = r5.has(r0);	 Catch:{ JSONException -> 0x0079 }
        if (r0 == 0) goto L_0x0079;	 Catch:{ JSONException -> 0x0079 }
    L_0x0008:
        r0 = "do";	 Catch:{ JSONException -> 0x0079 }
        r0 = r5.has(r0);	 Catch:{ JSONException -> 0x0079 }
        if (r0 == 0) goto L_0x0079;	 Catch:{ JSONException -> 0x0079 }
    L_0x0010:
        r0 = "actionid";	 Catch:{ JSONException -> 0x0079 }
        r0 = r5.has(r0);	 Catch:{ JSONException -> 0x0079 }
        if (r0 == 0) goto L_0x0079;	 Catch:{ JSONException -> 0x0079 }
    L_0x0018:
        r0 = "url";	 Catch:{ JSONException -> 0x0079 }
        r0 = r5.getString(r0);	 Catch:{ JSONException -> 0x0079 }
        r1 = "";	 Catch:{ JSONException -> 0x0079 }
        r1 = r0.equals(r1);	 Catch:{ JSONException -> 0x0079 }
        if (r1 != 0) goto L_0x0079;	 Catch:{ JSONException -> 0x0079 }
    L_0x0026:
        r1 = new com.igexin.push.core.bean.m;	 Catch:{ JSONException -> 0x0079 }
        r1.<init>();	 Catch:{ JSONException -> 0x0079 }
        r2 = "startweb";	 Catch:{ JSONException -> 0x0079 }
        r1.setType(r2);	 Catch:{ JSONException -> 0x0079 }
        r2 = "actionid";	 Catch:{ JSONException -> 0x0079 }
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x0079 }
        r1.setActionId(r2);	 Catch:{ JSONException -> 0x0079 }
        r2 = "do";	 Catch:{ JSONException -> 0x0079 }
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x0079 }
        r1.setDoActionId(r2);	 Catch:{ JSONException -> 0x0079 }
        r1.a(r0);	 Catch:{ JSONException -> 0x0079 }
        r0 = "is_withcid";	 Catch:{ JSONException -> 0x0079 }
        r0 = r5.has(r0);	 Catch:{ JSONException -> 0x0079 }
        r2 = 1;	 Catch:{ JSONException -> 0x0079 }
        if (r0 == 0) goto L_0x005f;	 Catch:{ JSONException -> 0x0079 }
    L_0x004e:
        r0 = "is_withcid";	 Catch:{ JSONException -> 0x0079 }
        r0 = r5.getString(r0);	 Catch:{ JSONException -> 0x0079 }
        r3 = "true";	 Catch:{ JSONException -> 0x0079 }
        r0 = r0.equals(r3);	 Catch:{ JSONException -> 0x0079 }
        if (r0 == 0) goto L_0x005f;	 Catch:{ JSONException -> 0x0079 }
    L_0x005c:
        r1.a(r2);	 Catch:{ JSONException -> 0x0079 }
    L_0x005f:
        r0 = "is_withnettype";	 Catch:{ JSONException -> 0x0079 }
        r0 = r5.has(r0);	 Catch:{ JSONException -> 0x0079 }
        if (r0 == 0) goto L_0x0078;	 Catch:{ JSONException -> 0x0079 }
    L_0x0067:
        r0 = "is_withnettype";	 Catch:{ JSONException -> 0x0079 }
        r5 = r5.getString(r0);	 Catch:{ JSONException -> 0x0079 }
        r0 = "true";	 Catch:{ JSONException -> 0x0079 }
        r5 = r5.equals(r0);	 Catch:{ JSONException -> 0x0079 }
        if (r5 == 0) goto L_0x0078;	 Catch:{ JSONException -> 0x0079 }
    L_0x0075:
        r1.b(r2);	 Catch:{ JSONException -> 0x0079 }
    L_0x0078:
        return r1;
    L_0x0079:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.j.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public boolean b(com.igexin.push.core.bean.PushTaskBean r4, com.igexin.push.core.bean.BaseAction r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r5;
        r0 = (com.igexin.push.core.bean.m) r0;
        r1 = "targetpkgname";
        r3.a(r0, r1);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = "android.intent.action.VIEW";
        r1.setAction(r2);
        r2 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r1.setFlags(r2);
        r2 = r0.b();
        r1.setPackage(r2);
        r0 = r0.c();
        r0 = android.net.Uri.parse(r0);
        r1.setData(r0);
        r0 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x002e }
        r0.startActivity(r1);	 Catch:{ Exception -> 0x002e }
    L_0x002e:
        r0 = r5.getDoActionId();
        r1 = "";
        r0 = r0.equals(r1);
        if (r0 != 0) goto L_0x004d;
    L_0x003a:
        r0 = com.igexin.push.core.a.f.a();
        r1 = r4.getTaskId();
        r4 = r4.getMessageId();
        r5 = r5.getDoActionId();
        r0.a(r1, r4, r5);
    L_0x004d:
        r4 = 1;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.j.b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
