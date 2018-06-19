package com.umeng.message;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.l;
import java.lang.reflect.Method;
import java.util.Map.Entry;

public class UmengNotificationClickHandler implements UHandler {
    private static final String a = "com.umeng.message.UmengNotificationClickHandler";

    public void dealWithCustomAction(Context context, UMessage uMessage) {
    }

    public void dismissNotification(Context context, UMessage uMessage) {
    }

    public void handleMessage(Context context, UMessage uMessage) {
        try {
            if (!uMessage.clickOrDismiss) {
                dismissNotification(context, uMessage);
            } else if (TextUtils.equals(UMessage.DISPLAY_TYPE_AUTOUPDATE, uMessage.display_type) && PushAgent.getInstance(context).isIncludesUmengUpdateSDK()) {
                autoUpdate(context, uMessage);
            } else {
                if (!TextUtils.isEmpty(uMessage.after_open)) {
                    if (UMessage.DISPLAY_TYPE_NOTIFICATIONPULLAPP.equals(uMessage.display_type)) {
                        if (TextUtils.equals(UMessage.NOTIFICATION_GO_APPURL, uMessage.after_open)) {
                            a(context, uMessage);
                            return;
                        }
                    } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_URL, uMessage.after_open)) {
                        openUrl(context, uMessage);
                        return;
                    } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_ACTIVITY, uMessage.after_open)) {
                        openActivity(context, uMessage);
                        return;
                    } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_CUSTOM, uMessage.after_open)) {
                        dealWithCustomAction(context, uMessage);
                        return;
                    } else if (TextUtils.equals(UMessage.NOTIFICATION_GO_APP, uMessage.after_open)) {
                        launchApp(context, uMessage);
                        return;
                    }
                }
                if (!UMessage.DISPLAY_TYPE_NOTIFICATIONPULLAPP.equals(uMessage.display_type)) {
                    if (uMessage.url != null && !TextUtils.isEmpty(uMessage.url.trim())) {
                        openUrl(context, uMessage);
                    } else if (uMessage.activity != null && !TextUtils.isEmpty(uMessage.activity.trim())) {
                        openActivity(context, uMessage);
                    } else if (uMessage.custom == null || TextUtils.isEmpty(uMessage.custom.trim())) {
                        launchApp(context, uMessage);
                    } else {
                        dealWithCustomAction(context, uMessage);
                    }
                }
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void autoUpdate(Context context, UMessage uMessage) {
        try {
            uMessage = l.a(context).g();
            Class cls = Class.forName("com.umeng.update.UmengUpdateAgent");
            Class cls2 = Class.forName("com.umeng.update.UpdateResponse");
            Method method = cls.getMethod("showUpdateDialog", new Class[]{Context.class, cls2});
            if (uMessage != null) {
                method.invoke(cls, new Object[]{context, cls2.cast(uMessage)});
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    private void a(android.content.Context r12, com.umeng.message.entity.UMessage r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r13.custom;	 Catch:{ JSONException -> 0x0151 }
        if (r0 == 0) goto L_0x0150;	 Catch:{ JSONException -> 0x0151 }
    L_0x0004:
        r1 = "";	 Catch:{ JSONException -> 0x0151 }
        r1 = r0.equals(r1);	 Catch:{ JSONException -> 0x0151 }
        if (r1 == 0) goto L_0x000e;	 Catch:{ JSONException -> 0x0151 }
    L_0x000c:
        goto L_0x0150;	 Catch:{ JSONException -> 0x0151 }
    L_0x000e:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0151 }
        r1.<init>(r0);	 Catch:{ JSONException -> 0x0151 }
        r0 = "p";	 Catch:{ JSONException -> 0x0151 }
        r0 = r1.optString(r0);	 Catch:{ JSONException -> 0x0151 }
        r2 = "pu";	 Catch:{ JSONException -> 0x0151 }
        r2 = r1.optString(r2);	 Catch:{ JSONException -> 0x0151 }
        r3 = "ju";	 Catch:{ JSONException -> 0x0151 }
        r3 = r1.optString(r3);	 Catch:{ JSONException -> 0x0151 }
        r4 = "en";	 Catch:{ JSONException -> 0x0151 }
        r1 = r1.optInt(r4);	 Catch:{ JSONException -> 0x0151 }
        r4 = new android.content.Intent;	 Catch:{ JSONException -> 0x0151 }
        r4.<init>();	 Catch:{ JSONException -> 0x0151 }
        r5 = "://";	 Catch:{ JSONException -> 0x0151 }
        r5 = r2.split(r5);	 Catch:{ JSONException -> 0x0151 }
        r6 = 2;	 Catch:{ JSONException -> 0x0151 }
        if (r5 == 0) goto L_0x003d;	 Catch:{ JSONException -> 0x0151 }
    L_0x0039:
        r7 = r5.length;	 Catch:{ JSONException -> 0x0151 }
        if (r7 >= r6) goto L_0x003d;	 Catch:{ JSONException -> 0x0151 }
    L_0x003c:
        return;	 Catch:{ JSONException -> 0x0151 }
    L_0x003d:
        r7 = 1;	 Catch:{ JSONException -> 0x0151 }
        r5 = r5[r7];	 Catch:{ JSONException -> 0x0151 }
        r8 = "/";	 Catch:{ JSONException -> 0x0151 }
        r5 = r5.split(r8);	 Catch:{ JSONException -> 0x0151 }
        if (r5 == 0) goto L_0x004c;	 Catch:{ JSONException -> 0x0151 }
    L_0x0048:
        r8 = r5.length;	 Catch:{ JSONException -> 0x0151 }
        if (r8 > 0) goto L_0x004c;	 Catch:{ JSONException -> 0x0151 }
    L_0x004b:
        return;	 Catch:{ JSONException -> 0x0151 }
    L_0x004c:
        r8 = 0;	 Catch:{ JSONException -> 0x0151 }
        r5 = r5[r8];	 Catch:{ JSONException -> 0x0151 }
        r9 = "";	 Catch:{ JSONException -> 0x0151 }
        if (r1 != r7) goto L_0x00d5;	 Catch:{ JSONException -> 0x0151 }
    L_0x0053:
        r1 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0151 }
        r1.<init>();	 Catch:{ JSONException -> 0x0151 }
        r1.append(r5);	 Catch:{ JSONException -> 0x0151 }
        r10 = "/";	 Catch:{ JSONException -> 0x0151 }
        r1.append(r10);	 Catch:{ JSONException -> 0x0151 }
        r1 = r1.toString();	 Catch:{ JSONException -> 0x0151 }
        r1 = r2.split(r1);	 Catch:{ JSONException -> 0x0151 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b7 }
        r2.<init>();	 Catch:{ Exception -> 0x00b7 }
        if (r1 == 0) goto L_0x0077;	 Catch:{ Exception -> 0x00b7 }
    L_0x006f:
        r10 = r1.length;	 Catch:{ Exception -> 0x00b7 }
        if (r10 < r6) goto L_0x0077;	 Catch:{ Exception -> 0x00b7 }
    L_0x0072:
        r6 = r1[r7];	 Catch:{ Exception -> 0x00b7 }
        r2.append(r6);	 Catch:{ Exception -> 0x00b7 }
    L_0x0077:
        r6 = "&umessage=";	 Catch:{ Exception -> 0x00b7 }
        r2.append(r6);	 Catch:{ Exception -> 0x00b7 }
        r6 = r13.getRaw();	 Catch:{ Exception -> 0x00b7 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x00b7 }
        r2.append(r6);	 Catch:{ Exception -> 0x00b7 }
        r6 = "&thirdkey=";	 Catch:{ Exception -> 0x00b7 }
        r2.append(r6);	 Catch:{ Exception -> 0x00b7 }
        r6 = com.umeng.message.PushAgent.getInstance(r12);	 Catch:{ Exception -> 0x00b7 }
        r6 = r6.getMessageAppkey();	 Catch:{ Exception -> 0x00b7 }
        r2.append(r6);	 Catch:{ Exception -> 0x00b7 }
        r6 = a;	 Catch:{ Exception -> 0x00b7 }
        r7 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b7 }
        r10 = "url:";	 Catch:{ Exception -> 0x00b7 }
        r7.<init>(r10);	 Catch:{ Exception -> 0x00b7 }
        r10 = r2.toString();	 Catch:{ Exception -> 0x00b7 }
        r7.append(r10);	 Catch:{ Exception -> 0x00b7 }
        r7 = r7.toString();	 Catch:{ Exception -> 0x00b7 }
        com.umeng.message.common.UmLog.d(r6, r7);	 Catch:{ Exception -> 0x00b7 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x00b7 }
        r2 = com.umeng.message.proguard.c.a(r2);	 Catch:{ Exception -> 0x00b7 }
        goto L_0x00bc;
    L_0x00b7:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ JSONException -> 0x0151 }
        r2 = r9;	 Catch:{ JSONException -> 0x0151 }
    L_0x00bc:
        r6 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x0151 }
        r6.<init>();	 Catch:{ JSONException -> 0x0151 }
        r1 = r1[r8];	 Catch:{ JSONException -> 0x0151 }
        r6.append(r1);	 Catch:{ JSONException -> 0x0151 }
        r6.append(r5);	 Catch:{ JSONException -> 0x0151 }
        r1 = "/";	 Catch:{ JSONException -> 0x0151 }
        r6.append(r1);	 Catch:{ JSONException -> 0x0151 }
        r6.append(r2);	 Catch:{ JSONException -> 0x0151 }
        r2 = r6.toString();	 Catch:{ JSONException -> 0x0151 }
    L_0x00d5:
        r1 = android.net.Uri.parse(r2);	 Catch:{ JSONException -> 0x0151 }
        r4.setData(r1);	 Catch:{ JSONException -> 0x0151 }
        r4.setPackage(r0);	 Catch:{ JSONException -> 0x0151 }
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;	 Catch:{ JSONException -> 0x0151 }
        r4.addFlags(r1);	 Catch:{ JSONException -> 0x0151 }
        r5 = com.umeng.message.common.UmengMessageDeviceConfig.getDataData(r0);	 Catch:{ JSONException -> 0x0151 }
        if (r5 == 0) goto L_0x0127;
    L_0x00ea:
        r0 = com.umeng.message.common.UmengMessageDeviceConfig.isIntentExist(r12, r2, r0);	 Catch:{ Exception -> 0x0126 }
        if (r0 == 0) goto L_0x00fd;	 Catch:{ Exception -> 0x0126 }
    L_0x00f0:
        r0 = com.umeng.message.UTrack.getInstance(r12);	 Catch:{ Exception -> 0x0126 }
        r1 = 62;	 Catch:{ Exception -> 0x0126 }
        r0.trackMsgPulled(r13, r1);	 Catch:{ Exception -> 0x0126 }
        r12.startActivity(r4);	 Catch:{ Exception -> 0x0126 }
        return;	 Catch:{ Exception -> 0x0126 }
    L_0x00fd:
        r0 = com.umeng.message.UTrack.getInstance(r12);	 Catch:{ Exception -> 0x0126 }
        r2 = 61;	 Catch:{ Exception -> 0x0126 }
        r0.trackMsgPulled(r13, r2);	 Catch:{ Exception -> 0x0126 }
        if (r3 == 0) goto L_0x0125;	 Catch:{ Exception -> 0x0126 }
    L_0x0108:
        r13 = r3.trim();	 Catch:{ Exception -> 0x0126 }
        r13 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Exception -> 0x0126 }
        if (r13 == 0) goto L_0x0113;	 Catch:{ Exception -> 0x0126 }
    L_0x0112:
        goto L_0x0125;	 Catch:{ Exception -> 0x0126 }
    L_0x0113:
        r13 = new android.content.Intent;	 Catch:{ Exception -> 0x0126 }
        r0 = "android.intent.action.VIEW";	 Catch:{ Exception -> 0x0126 }
        r2 = android.net.Uri.parse(r3);	 Catch:{ Exception -> 0x0126 }
        r13.<init>(r0, r2);	 Catch:{ Exception -> 0x0126 }
        r13.addFlags(r1);	 Catch:{ Exception -> 0x0126 }
        r12.startActivity(r13);	 Catch:{ Exception -> 0x0126 }
        return;
    L_0x0125:
        return;
    L_0x0126:
        return;
    L_0x0127:
        r0 = com.umeng.message.UTrack.getInstance(r12);	 Catch:{ JSONException -> 0x0151 }
        r2 = 60;	 Catch:{ JSONException -> 0x0151 }
        r0.trackMsgPulled(r13, r2);	 Catch:{ JSONException -> 0x0151 }
        if (r3 == 0) goto L_0x014f;	 Catch:{ JSONException -> 0x0151 }
    L_0x0132:
        r13 = r3.trim();	 Catch:{ JSONException -> 0x0151 }
        r13 = android.text.TextUtils.isEmpty(r13);	 Catch:{ JSONException -> 0x0151 }
        if (r13 == 0) goto L_0x013d;	 Catch:{ JSONException -> 0x0151 }
    L_0x013c:
        goto L_0x014f;	 Catch:{ JSONException -> 0x0151 }
    L_0x013d:
        r13 = new android.content.Intent;	 Catch:{ JSONException -> 0x0151 }
        r0 = "android.intent.action.VIEW";	 Catch:{ JSONException -> 0x0151 }
        r2 = android.net.Uri.parse(r3);	 Catch:{ JSONException -> 0x0151 }
        r13.<init>(r0, r2);	 Catch:{ JSONException -> 0x0151 }
        r13.addFlags(r1);	 Catch:{ JSONException -> 0x0151 }
        r12.startActivity(r13);	 Catch:{ JSONException -> 0x0151 }
        return;
    L_0x014f:
        return;
    L_0x0150:
        return;
    L_0x0151:
        r12 = move-exception;
        r12.printStackTrace();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengNotificationClickHandler.a(android.content.Context, com.umeng.message.entity.UMessage):void");
    }

    public void openUrl(Context context, UMessage uMessage) {
        if (uMessage.url != null) {
            if (!TextUtils.isEmpty(uMessage.url.trim())) {
                String str = a;
                StringBuilder stringBuilder = new StringBuilder("handleMessage(): open url: ");
                stringBuilder.append(uMessage.url);
                UmLog.d(str, stringBuilder.toString());
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(uMessage.url));
                a(intent, uMessage);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        }
    }

    public void openActivity(Context context, UMessage uMessage) {
        if (uMessage.activity != null) {
            if (!TextUtils.isEmpty(uMessage.activity.trim())) {
                Intent intent = new Intent();
                a(intent, uMessage);
                intent.setClassName(context, uMessage.activity);
                intent.addFlags(268435456);
                context.startActivity(intent);
            }
        }
    }

    public void launchApp(Context context, UMessage uMessage) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage == null) {
            uMessage = a;
            StringBuilder stringBuilder = new StringBuilder("handleMessage(): cannot find app: ");
            stringBuilder.append(context.getPackageName());
            UmLog.e(uMessage, stringBuilder.toString());
            return;
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(268435456);
        a(launchIntentForPackage, uMessage);
        context.startActivity(launchIntentForPackage);
        uMessage = a;
        stringBuilder = new StringBuilder("handleMessage(): lunach app: ");
        stringBuilder.append(context.getPackageName());
        UmLog.d(uMessage, stringBuilder.toString());
    }

    private Intent a(Intent intent, UMessage uMessage) {
        if (!(intent == null || uMessage == null)) {
            if (uMessage.extra != null) {
                for (Entry entry : uMessage.extra.entrySet()) {
                    String str = (String) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (str != null) {
                        intent.putExtra(str, str2);
                    }
                }
                return intent;
            }
        }
        return intent;
    }
}
