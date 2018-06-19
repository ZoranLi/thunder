package com.igexin.push.core.a.a;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.igexin.b.a.c.a;
import com.igexin.push.config.l;
import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.i;
import com.igexin.push.core.g;
import com.igexin.sdk.GTServiceManager;
import com.igexin.sdk.PushConsts;
import java.util.Random;

public class h implements a {
    private static final String a = l.a;

    private int a(i iVar, boolean z) {
        int identifier;
        int identifier2;
        Throwable th;
        StringBuilder stringBuilder;
        String f;
        if (z) {
            StringBuilder stringBuilder2;
            try {
                identifier = g.f.getResources().getIdentifier("push_small", "drawable", g.e);
                if (identifier == 0) {
                    try {
                        identifier2 = g.f.getResources().getIdentifier("push_small", "mipmap", g.e);
                    } catch (Throwable th2) {
                        th = th2;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(a);
                        stringBuilder.append("|");
                        stringBuilder.append(th.toString());
                        a.b(stringBuilder.toString());
                        identifier2 = identifier;
                        if (identifier2 == 0) {
                            return identifier2;
                        }
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(a);
                        stringBuilder2.append("|push_small.png is missing");
                        a.b(stringBuilder2.toString());
                        identifier2 = g.f.getResources().getIdentifier("push", "drawable", g.e);
                        if (identifier2 == 0) {
                            identifier2 = g.f.getResources().getIdentifier("push", "mipmap", g.e);
                        }
                        if (!TextUtils.isEmpty(iVar.f())) {
                            return identifier2 != 0 ? 17301651 : identifier2;
                        } else {
                            if (!"null".equals(iVar.f())) {
                                return 17301651;
                            }
                            if (iVar.f().startsWith("@")) {
                                identifier = g.f.getResources().getIdentifier(iVar.f(), "drawable", g.e);
                                if (identifier == 0) {
                                    identifier = g.f.getResources().getIdentifier(iVar.f(), "mipmap", g.e);
                                }
                                return identifier != 0 ? identifier2 != 0 ? 17301651 : identifier2 : identifier;
                            } else {
                                f = iVar.f();
                                return f.substring(1, f.length()).endsWith(NotificationCompat.CATEGORY_EMAIL) ? 17301651 : 17301647;
                            }
                        }
                    }
                    if (identifier2 == 0) {
                        return identifier2;
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(a);
                    stringBuilder2.append("|push_small.png is missing");
                    a.b(stringBuilder2.toString());
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                identifier = 0;
                th = th4;
                stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append("|");
                stringBuilder.append(th.toString());
                a.b(stringBuilder.toString());
                identifier2 = identifier;
                if (identifier2 == 0) {
                    return identifier2;
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append("|push_small.png is missing");
                a.b(stringBuilder2.toString());
                identifier2 = g.f.getResources().getIdentifier("push", "drawable", g.e);
                if (identifier2 == 0) {
                    identifier2 = g.f.getResources().getIdentifier("push", "mipmap", g.e);
                }
                if (!TextUtils.isEmpty(iVar.f())) {
                    if (identifier2 != 0) {
                    }
                } else if (!"null".equals(iVar.f())) {
                    return 17301651;
                } else {
                    if (iVar.f().startsWith("@")) {
                        f = iVar.f();
                        if (f.substring(1, f.length()).endsWith(NotificationCompat.CATEGORY_EMAIL)) {
                        }
                    }
                    identifier = g.f.getResources().getIdentifier(iVar.f(), "drawable", g.e);
                    if (identifier == 0) {
                        identifier = g.f.getResources().getIdentifier(iVar.f(), "mipmap", g.e);
                    }
                    if (identifier != 0) {
                    }
                }
            }
            identifier2 = identifier;
            if (identifier2 == 0) {
                return identifier2;
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(a);
            stringBuilder2.append("|push_small.png is missing");
            a.b(stringBuilder2.toString());
        }
        identifier2 = g.f.getResources().getIdentifier("push", "drawable", g.e);
        if (identifier2 == 0) {
            identifier2 = g.f.getResources().getIdentifier("push", "mipmap", g.e);
        }
        if (!TextUtils.isEmpty(iVar.f())) {
            if (identifier2 != 0) {
            }
        } else if (!"null".equals(iVar.f())) {
            return 17301651;
        } else {
            if (iVar.f().startsWith("@")) {
                f = iVar.f();
                if (f.substring(1, f.length()).endsWith(NotificationCompat.CATEGORY_EMAIL)) {
                }
            }
            identifier = g.f.getResources().getIdentifier(iVar.f(), "drawable", g.e);
            if (identifier == 0) {
                identifier = g.f.getResources().getIdentifier(iVar.f(), "mipmap", g.e);
            }
            if (identifier != 0) {
            }
        }
    }

    private PendingIntent a(String str, String str2, String str3, int i) {
        Parcelable intent = new Intent("com.igexin.sdk.action.doaction");
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        intent.putExtra("appid", g.a);
        intent.putExtra("actionid", str3);
        intent.putExtra("accesstoken", g.au);
        intent.putExtra("notifID", i);
        Intent intent2 = new Intent(g.f, GTServiceManager.getInstance().getUserPushService(g.f));
        intent2.putExtra("action", PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
        intent2.putExtra("broadcast_intent", intent);
        return PendingIntent.getService(g.f, new Random().nextInt(1000), intent2, 134217728);
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
        r0 = new com.igexin.push.core.bean.i;	 Catch:{ JSONException -> 0x00ef }
        r0.<init>();	 Catch:{ JSONException -> 0x00ef }
        r1 = "notification";	 Catch:{ JSONException -> 0x00ef }
        r0.setType(r1);	 Catch:{ JSONException -> 0x00ef }
        r1 = "actionid";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getString(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.setActionId(r1);	 Catch:{ JSONException -> 0x00ef }
        r1 = "do";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getString(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.setDoActionId(r1);	 Catch:{ JSONException -> 0x00ef }
        r1 = "title";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getString(r1);	 Catch:{ JSONException -> 0x00ef }
        r2 = "text";	 Catch:{ JSONException -> 0x00ef }
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x00ef }
        r0.a(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.b(r2);	 Catch:{ JSONException -> 0x00ef }
        r1 = "logo";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.has(r1);	 Catch:{ JSONException -> 0x00ef }
        if (r1 == 0) goto L_0x0088;	 Catch:{ JSONException -> 0x00ef }
    L_0x0036:
        r1 = "";	 Catch:{ JSONException -> 0x00ef }
        r2 = "logo";	 Catch:{ JSONException -> 0x00ef }
        r2 = r5.getString(r2);	 Catch:{ JSONException -> 0x00ef }
        r1 = r1.equals(r2);	 Catch:{ JSONException -> 0x00ef }
        if (r1 != 0) goto L_0x0088;	 Catch:{ JSONException -> 0x00ef }
    L_0x0044:
        r1 = "logo";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getString(r1);	 Catch:{ JSONException -> 0x00ef }
        r2 = ".png";	 Catch:{ JSONException -> 0x00ef }
        r2 = r1.lastIndexOf(r2);	 Catch:{ JSONException -> 0x00ef }
        r3 = -1;	 Catch:{ JSONException -> 0x00ef }
        if (r2 != r3) goto L_0x005f;	 Catch:{ JSONException -> 0x00ef }
    L_0x0053:
        r2 = ".jpeg";	 Catch:{ JSONException -> 0x00ef }
        r2 = r1.lastIndexOf(r2);	 Catch:{ JSONException -> 0x00ef }
        if (r2 == r3) goto L_0x005c;	 Catch:{ JSONException -> 0x00ef }
    L_0x005b:
        goto L_0x005f;	 Catch:{ JSONException -> 0x00ef }
    L_0x005c:
        r1 = "";	 Catch:{ JSONException -> 0x00ef }
        goto L_0x0085;	 Catch:{ JSONException -> 0x00ef }
    L_0x005f:
        r2 = ".png";	 Catch:{ JSONException -> 0x00ef }
        r2 = r1.indexOf(r2);	 Catch:{ JSONException -> 0x00ef }
        if (r2 != r3) goto L_0x006d;	 Catch:{ JSONException -> 0x00ef }
    L_0x0067:
        r2 = ".jpeg";	 Catch:{ JSONException -> 0x00ef }
        r2 = r1.indexOf(r2);	 Catch:{ JSONException -> 0x00ef }
    L_0x006d:
        if (r2 == r3) goto L_0x0085;	 Catch:{ JSONException -> 0x00ef }
    L_0x006f:
        r3 = 0;	 Catch:{ JSONException -> 0x00ef }
        r1 = r1.substring(r3, r2);	 Catch:{ JSONException -> 0x00ef }
        r2 = "^\\d+$";	 Catch:{ JSONException -> 0x00ef }
        r2 = java.util.regex.Pattern.compile(r2);	 Catch:{ JSONException -> 0x00ef }
        r2 = r2.matcher(r1);	 Catch:{ JSONException -> 0x00ef }
        r2 = r2.matches();	 Catch:{ JSONException -> 0x00ef }
        if (r2 == 0) goto L_0x0085;	 Catch:{ JSONException -> 0x00ef }
    L_0x0084:
        goto L_0x005c;	 Catch:{ JSONException -> 0x00ef }
    L_0x0085:
        r0.c(r1);	 Catch:{ JSONException -> 0x00ef }
    L_0x0088:
        r1 = "is_noclear";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.has(r1);	 Catch:{ JSONException -> 0x00ef }
        if (r1 == 0) goto L_0x0099;	 Catch:{ JSONException -> 0x00ef }
    L_0x0090:
        r1 = "is_noclear";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getBoolean(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.a(r1);	 Catch:{ JSONException -> 0x00ef }
    L_0x0099:
        r1 = "is_novibrate";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.has(r1);	 Catch:{ JSONException -> 0x00ef }
        if (r1 == 0) goto L_0x00aa;	 Catch:{ JSONException -> 0x00ef }
    L_0x00a1:
        r1 = "is_novibrate";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getBoolean(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.b(r1);	 Catch:{ JSONException -> 0x00ef }
    L_0x00aa:
        r1 = "is_noring";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.has(r1);	 Catch:{ JSONException -> 0x00ef }
        if (r1 == 0) goto L_0x00bb;	 Catch:{ JSONException -> 0x00ef }
    L_0x00b2:
        r1 = "is_noring";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getBoolean(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.c(r1);	 Catch:{ JSONException -> 0x00ef }
    L_0x00bb:
        r1 = "is_chklayout";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.has(r1);	 Catch:{ JSONException -> 0x00ef }
        if (r1 == 0) goto L_0x00cc;	 Catch:{ JSONException -> 0x00ef }
    L_0x00c3:
        r1 = "is_chklayout";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getBoolean(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.d(r1);	 Catch:{ JSONException -> 0x00ef }
    L_0x00cc:
        r1 = "logo_url";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.has(r1);	 Catch:{ JSONException -> 0x00ef }
        if (r1 == 0) goto L_0x00dd;	 Catch:{ JSONException -> 0x00ef }
    L_0x00d4:
        r1 = "logo_url";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.getString(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.d(r1);	 Catch:{ JSONException -> 0x00ef }
    L_0x00dd:
        r1 = "banner_url";	 Catch:{ JSONException -> 0x00ef }
        r1 = r5.has(r1);	 Catch:{ JSONException -> 0x00ef }
        if (r1 == 0) goto L_0x00ee;	 Catch:{ JSONException -> 0x00ef }
    L_0x00e5:
        r1 = "banner_url";	 Catch:{ JSONException -> 0x00ef }
        r5 = r5.getString(r1);	 Catch:{ JSONException -> 0x00ef }
        r0.e(r5);	 Catch:{ JSONException -> 0x00ef }
    L_0x00ee:
        return r0;
    L_0x00ef:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.h.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public void a(java.lang.String r12, java.lang.String r13, com.igexin.push.core.bean.i r14) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = java.lang.System.currentTimeMillis();
        r0 = (int) r0;
        r1 = com.igexin.push.core.g.aj;
        r2 = java.lang.Integer.valueOf(r0);
        r1.put(r12, r2);
        r1 = r14.getDoActionId();
        r12 = r11.a(r12, r13, r1, r0);
        r13 = com.igexin.push.core.g.f;
        r1 = "notification";
        r13 = r13.getSystemService(r1);
        r13 = (android.app.NotificationManager) r13;
        r1 = 0;
        r2 = r11.a(r14, r1);
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 2;
        r5 = 4;
        r6 = 1;
        r7 = 11;
        if (r3 >= r7) goto L_0x0087;
    L_0x002e:
        r3 = new android.app.Notification;
        r3.<init>();
        r3.icon = r2;
        r2 = "android.app.Notification";	 Catch:{ Exception -> 0x0070 }
        r2 = java.lang.Class.forName(r2);	 Catch:{ Exception -> 0x0070 }
        r7 = "setLatestEventInfo";	 Catch:{ Exception -> 0x0070 }
        r8 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0070 }
        r9 = android.content.Context.class;	 Catch:{ Exception -> 0x0070 }
        r8[r1] = r9;	 Catch:{ Exception -> 0x0070 }
        r9 = java.lang.CharSequence.class;	 Catch:{ Exception -> 0x0070 }
        r8[r6] = r9;	 Catch:{ Exception -> 0x0070 }
        r9 = java.lang.CharSequence.class;	 Catch:{ Exception -> 0x0070 }
        r8[r4] = r9;	 Catch:{ Exception -> 0x0070 }
        r9 = android.app.PendingIntent.class;	 Catch:{ Exception -> 0x0070 }
        r10 = 3;	 Catch:{ Exception -> 0x0070 }
        r8[r10] = r9;	 Catch:{ Exception -> 0x0070 }
        r2 = r2.getMethod(r7, r8);	 Catch:{ Exception -> 0x0070 }
        r2.setAccessible(r6);	 Catch:{ Exception -> 0x0070 }
        r7 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0070 }
        r8 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x0070 }
        r7[r1] = r8;	 Catch:{ Exception -> 0x0070 }
        r1 = r14.a();	 Catch:{ Exception -> 0x0070 }
        r7[r6] = r1;	 Catch:{ Exception -> 0x0070 }
        r1 = r14.b();	 Catch:{ Exception -> 0x0070 }
        r7[r4] = r1;	 Catch:{ Exception -> 0x0070 }
        r7[r10] = r12;	 Catch:{ Exception -> 0x0070 }
        r2.invoke(r3, r7);	 Catch:{ Exception -> 0x0070 }
        goto L_0x00ef;
    L_0x0070:
        r12 = new java.lang.StringBuilder;
        r12.<init>();
        r13 = a;
        r12.append(r13);
        r13 = "reflect invoke setLatestEventInfo failed!";
        r12.append(r13);
        r12 = r12.toString();
        com.igexin.b.a.c.a.b(r12);
        return;
    L_0x0087:
        r1 = r11.a(r14, r6);
        r3 = new android.app.Notification$Builder;
        r7 = com.igexin.push.core.g.f;
        r3.<init>(r7);
        r7 = r14.a();
        r3 = r3.setContentTitle(r7);
        r7 = r14.b();
        r3 = r3.setContentText(r7);
        r1 = r3.setSmallIcon(r1);
        r3 = com.igexin.push.core.g.f;
        r3 = r3.getResources();
        r2 = android.graphics.BitmapFactory.decodeResource(r3, r2);
        r1 = r1.setLargeIcon(r2);
        r12 = r1.setContentIntent(r12);
        r3 = r12.getNotification();
        r12 = com.igexin.push.util.a.f();
        if (r12 == 0) goto L_0x00ef;
    L_0x00c2:
        r12 = android.os.Build.VERSION.SDK_INT;
        r1 = 21;
        if (r12 < r1) goto L_0x00ef;
    L_0x00c8:
        r12 = android.os.Build.VERSION.SDK_INT;
        r1 = 24;
        if (r12 >= r1) goto L_0x00ef;
    L_0x00ce:
        r12 = "com.android.internal.R$id";	 Catch:{ Exception -> 0x00ef }
        r12 = java.lang.Class.forName(r12);	 Catch:{ Exception -> 0x00ef }
        r1 = "right_icon";	 Catch:{ Exception -> 0x00ef }
        r12 = r12.getField(r1);	 Catch:{ Exception -> 0x00ef }
        r12.setAccessible(r6);	 Catch:{ Exception -> 0x00ef }
        r1 = 0;	 Catch:{ Exception -> 0x00ef }
        r12 = r12.getInt(r1);	 Catch:{ Exception -> 0x00ef }
        r1 = r3.contentView;	 Catch:{ Exception -> 0x00ef }
        if (r1 == 0) goto L_0x00ef;	 Catch:{ Exception -> 0x00ef }
    L_0x00e6:
        if (r12 == 0) goto L_0x00ef;	 Catch:{ Exception -> 0x00ef }
    L_0x00e8:
        r1 = r3.contentView;	 Catch:{ Exception -> 0x00ef }
        r2 = 8;	 Catch:{ Exception -> 0x00ef }
        r1.setViewVisibility(r12, r2);	 Catch:{ Exception -> 0x00ef }
    L_0x00ef:
        r12 = r14.b();
        r3.tickerText = r12;
        r3.defaults = r5;
        r12 = -16711936; // 0xffffffffff00ff00 float:-1.7146522E38 double:NaN;
        r3.ledARGB = r12;
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3.ledOnMS = r12;
        r12 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
        r3.ledOffMS = r12;
        r3.flags = r6;
        r12 = r14.c();
        if (r12 != 0) goto L_0x0113;
    L_0x010c:
        r12 = r3.flags;
        r12 = r12 | 16;
    L_0x0110:
        r3.flags = r12;
        goto L_0x0118;
    L_0x0113:
        r12 = r3.flags;
        r12 = r12 | 32;
        goto L_0x0110;
    L_0x0118:
        r12 = r14.e();
        if (r12 != 0) goto L_0x0123;
    L_0x011e:
        r12 = r3.defaults;
        r12 = r12 | r6;
        r3.defaults = r12;
    L_0x0123:
        r12 = r14.d();
        if (r12 != 0) goto L_0x012e;
    L_0x0129:
        r12 = r3.defaults;
        r12 = r12 | r4;
        r3.defaults = r12;
    L_0x012e:
        r12 = r14.h();
        if (r12 != 0) goto L_0x013a;
    L_0x0134:
        r12 = r14.g();
        if (r12 == 0) goto L_0x0141;
    L_0x013a:
        r12 = r14.i();
        if (r12 == 0) goto L_0x0141;
    L_0x0140:
        return;
    L_0x0141:
        r13.notify(r0, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.h.a(java.lang.String, java.lang.String, com.igexin.push.core.bean.i):void");
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (!(pushTaskBean == null || baseAction == null || !(baseAction instanceof i))) {
            i iVar = (i) baseAction;
            if (TextUtils.isEmpty(iVar.a()) || TextUtils.isEmpty(iVar.b())) {
                String str = a;
                StringBuilder stringBuilder = new StringBuilder("title = ");
                stringBuilder.append(iVar.a());
                stringBuilder.append(", content = ");
                stringBuilder.append(iVar.b());
                stringBuilder.append(", is invalid, don't show");
                a.a(str, stringBuilder.toString());
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(a);
                stringBuilder2.append(" title = ");
                stringBuilder2.append(iVar.a());
                stringBuilder2.append(", content = ");
                stringBuilder2.append(iVar.b());
                stringBuilder2.append(", is invalid, don't show");
                a.b(stringBuilder2.toString());
            } else {
                a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), iVar);
            }
        }
        return true;
    }
}
