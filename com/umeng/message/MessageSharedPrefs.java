package com.umeng.message;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build.VERSION;
import com.qihoo360.replugin.RePlugin;
import com.umeng.message.common.UmLog;
import com.umeng.message.proguard.k;
import com.umeng.message.proguard.l;
import com.umeng.message.provider.a;
import com.xiaomi.push.service.av;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MessageSharedPrefs {
    private static final String a = "com.umeng.message.MessageSharedPrefs";
    private static MessageSharedPrefs c = null;
    private static final String d = "tempkey";
    private static final String e = "tempvalue";
    private Context b;
    private SharedPreferences f;
    private int g = 0;

    private MessageSharedPrefs(Context context) {
        this.b = context;
        if (VERSION.SDK_INT > 11) {
            this.g |= 4;
        }
        this.f = context.getSharedPreferences(MsgConstant.PUSH_SHARED_PREFERENCES_FILE_NAME, this.g);
    }

    public static synchronized MessageSharedPrefs getInstance(Context context) {
        synchronized (MessageSharedPrefs.class) {
            if (c == null) {
                c = new MessageSharedPrefs(context);
            }
            context = c;
        }
        return context;
    }

    public boolean hasAppLaunchLogSentToday() {
        Calendar instance = Calendar.getInstance();
        try {
            instance.setTimeInMillis(l.a(this.b).f());
        } catch (Exception e) {
            e.printStackTrace();
            e.toString();
        }
        Calendar instance2 = Calendar.getInstance();
        if (instance.get(6) == instance2.get(6) && instance.get(1) == instance2.get(1)) {
            return true;
        }
        return false;
    }

    public void setDisplayNotificationNumber(int i) {
        c(MsgConstant.KEY_NOTIFICATION_NUMBER, String.valueOf(i));
    }

    public int getDisplayNotificationNumber() {
        return Integer.valueOf(b(MsgConstant.KEY_NOTIFICATION_NUMBER, "1")).intValue();
    }

    public void setMessageAppKey(String str) {
        this.f.edit().putString(MsgConstant.KEY_UMENG_MESSAGE_APP_KEY, str).commit();
    }

    public void removeMessageAppKey() {
        this.f.edit().remove(MsgConstant.KEY_UMENG_MESSAGE_APP_KEY).commit();
    }

    public String getMessageAppKey() {
        return this.f.getString(MsgConstant.KEY_UMENG_MESSAGE_APP_KEY, "");
    }

    public void setMessageAppSecret(String str) {
        this.f.edit().putString(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET, str).commit();
    }

    public void removeMessageAppSecret() {
        this.f.edit().remove(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET).commit();
    }

    public String getMessageAppSecret() {
        return this.f.getString(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET, "");
    }

    public void setMessageChannel(String str) {
        this.f.edit().putString(MsgConstant.KEY_UMENG_MESSAGE_APP_CHANNEL, str).commit();
    }

    public String getMessageChannel() {
        return this.f.getString(MsgConstant.KEY_UMENG_MESSAGE_APP_CHANNEL, "");
    }

    public void setAppLaunchLogSendPolicy(int i) {
        c(MsgConstant.KEY_APP_LAUNCH_LOG_SEND_POLICY, String.valueOf(i));
    }

    public void setDaRegisterSendPolicy(int i) {
        c(MsgConstant.KEY_APP_DAREGISTER_LOG_SEND_POLICY, String.valueOf(i));
    }

    public int getDaRegisterSendPolicy() {
        return Integer.valueOf(b(MsgConstant.KEY_APP_DAREGISTER_LOG_SEND_POLICY, RePlugin.PROCESS_UI)).intValue();
    }

    public void setTagSendPolicy(int i) {
        c(MsgConstant.KEY_TAG_SEND_POLICY, String.valueOf(i));
    }

    public int getAppLaunchLogSendPolicy() {
        return Integer.valueOf(b(MsgConstant.KEY_APP_LAUNCH_LOG_SEND_POLICY, RePlugin.PROCESS_UI)).intValue();
    }

    public int getTagSendPolicy() {
        return Integer.valueOf(b(MsgConstant.KEY_TAG_SEND_POLICY, RePlugin.PROCESS_UI)).intValue();
    }

    public void addAlias(String str, String str2, int i, int i2, String str3) {
        try {
            a(str2, str3);
            String str4 = "alias=? and type=? and exclusive=?";
            String[] strArr = new String[]{str, str2, String.valueOf(i)};
            ContentResolver contentResolver = this.b.getContentResolver();
            a.a(this.b);
            Cursor query = contentResolver.query(a.d, new String[]{"error"}, str4, strArr, "time desc");
            ContentValues contentValues;
            if (query == null) {
                contentValues = new ContentValues();
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("type", str2);
                contentValues.put("alias", str);
                contentValues.put(k.A, Integer.valueOf(i));
                contentValues.put("error", Integer.valueOf(i2));
                contentValues.put("message", str3);
                str = this.b.getContentResolver();
                a.a(this.b);
                str.insert(a.d, contentValues);
            } else if (query.getCount() > 0) {
                query.moveToFirst();
                contentValues = new ContentValues();
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("type", str2);
                contentValues.put("alias", str);
                contentValues.put(k.A, Integer.valueOf(i));
                contentValues.put("error", Integer.valueOf(i2));
                contentValues.put("message", str3);
                str = this.b.getContentResolver();
                a.a(this.b);
                str.update(a.d, contentValues, str4, strArr);
            } else {
                contentValues = new ContentValues();
                contentValues.put("time", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("type", str2);
                contentValues.put("alias", str);
                contentValues.put(k.A, Integer.valueOf(i));
                contentValues.put("error", Integer.valueOf(i2));
                contentValues.put("message", str3);
                str = this.b.getContentResolver();
                a.a(this.b);
                str.insert(a.d, contentValues);
            }
            if (query != null) {
                query.close();
            }
        } catch (String str5) {
            str5.printStackTrace();
        }
    }

    private void a(String str, String str2) {
        String[] strArr = new String[]{str, str2};
        str = this.b.getContentResolver();
        a.a(this.b);
        str.delete(a.d, "type=? and message=? ", strArr);
    }

    public void removeAlias(int i, String str, String str2) {
        try {
            String[] strArr = new String[]{str2, str, String.valueOf(i)};
            i = this.b.getContentResolver();
            a.a(this.b);
            i.delete(a.d, "type=? and alias=? and exclusive=? ", strArr);
        } catch (int i2) {
            i2.printStackTrace();
        }
    }

    public String getLastAlias(int i, String str) {
        String str2 = "";
        try {
            String[] strArr = new String[]{str, String.valueOf(i), "0", "2"};
            i = this.b.getContentResolver();
            a.a(this.b);
            ContentResolver contentResolver = i;
            i = contentResolver.query(a.d, new String[]{"alias"}, "type=? and exclusive=? and (error=? or error = ?)", strArr, "time desc");
            if (i != 0 && i.getCount() > null) {
                i.moveToFirst();
                str2 = i.getString(i.getColumnIndex("alias"));
            }
            if (i != 0) {
                i.close();
            }
        } catch (int i2) {
            i2.printStackTrace();
        }
        return str2;
    }

    public boolean isAliasSet(int r9, java.lang.String r10, java.lang.String r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = 0;
        r4 = "type=? and alias=? and exclusive=? and (error=? or error = ?)";	 Catch:{ Exception -> 0x00cb }
        r1 = 5;	 Catch:{ Exception -> 0x00cb }
        r5 = new java.lang.String[r1];	 Catch:{ Exception -> 0x00cb }
        r5[r0] = r11;	 Catch:{ Exception -> 0x00cb }
        r7 = 1;	 Catch:{ Exception -> 0x00cb }
        r5[r7] = r10;	 Catch:{ Exception -> 0x00cb }
        r1 = java.lang.String.valueOf(r9);	 Catch:{ Exception -> 0x00cb }
        r2 = 2;	 Catch:{ Exception -> 0x00cb }
        r5[r2] = r1;	 Catch:{ Exception -> 0x00cb }
        r1 = 3;	 Catch:{ Exception -> 0x00cb }
        r3 = "0";	 Catch:{ Exception -> 0x00cb }
        r5[r1] = r3;	 Catch:{ Exception -> 0x00cb }
        r1 = 4;	 Catch:{ Exception -> 0x00cb }
        r3 = "2";	 Catch:{ Exception -> 0x00cb }
        r5[r1] = r3;	 Catch:{ Exception -> 0x00cb }
        r1 = a;	 Catch:{ Exception -> 0x00cb }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cb }
        r6 = "type:";	 Catch:{ Exception -> 0x00cb }
        r3.<init>(r6);	 Catch:{ Exception -> 0x00cb }
        r3.append(r11);	 Catch:{ Exception -> 0x00cb }
        r6 = ",alias:";	 Catch:{ Exception -> 0x00cb }
        r3.append(r6);	 Catch:{ Exception -> 0x00cb }
        r3.append(r10);	 Catch:{ Exception -> 0x00cb }
        r6 = ",exclusive:";	 Catch:{ Exception -> 0x00cb }
        r3.append(r6);	 Catch:{ Exception -> 0x00cb }
        r3.append(r9);	 Catch:{ Exception -> 0x00cb }
        r9 = r3.toString();	 Catch:{ Exception -> 0x00cb }
        com.umeng.message.common.UmLog.d(r1, r9);	 Catch:{ Exception -> 0x00cb }
        r9 = r8.b;	 Catch:{ Exception -> 0x00cb }
        r1 = r9.getContentResolver();	 Catch:{ Exception -> 0x00cb }
        r9 = r8.b;	 Catch:{ Exception -> 0x00cb }
        com.umeng.message.provider.a.a(r9);	 Catch:{ Exception -> 0x00cb }
        r9 = com.umeng.message.provider.a.d;	 Catch:{ Exception -> 0x00cb }
        r3 = new java.lang.String[r2];	 Catch:{ Exception -> 0x00cb }
        r2 = "type";	 Catch:{ Exception -> 0x00cb }
        r3[r0] = r2;	 Catch:{ Exception -> 0x00cb }
        r2 = "alias";	 Catch:{ Exception -> 0x00cb }
        r3[r7] = r2;	 Catch:{ Exception -> 0x00cb }
        r6 = 0;	 Catch:{ Exception -> 0x00cb }
        r2 = r9;	 Catch:{ Exception -> 0x00cb }
        r9 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x00cb }
        if (r9 == 0) goto L_0x00c6;	 Catch:{ Exception -> 0x00cb }
    L_0x005e:
        r1 = r9.getCount();	 Catch:{ Exception -> 0x00cb }
        r2 = a;	 Catch:{ Exception -> 0x00cb }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cb }
        r4 = "count:";	 Catch:{ Exception -> 0x00cb }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00cb }
        r3.append(r1);	 Catch:{ Exception -> 0x00cb }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00cb }
        com.umeng.message.common.UmLog.d(r2, r3);	 Catch:{ Exception -> 0x00cb }
        if (r1 <= 0) goto L_0x00c6;	 Catch:{ Exception -> 0x00cb }
    L_0x0077:
        r9.moveToFirst();	 Catch:{ Exception -> 0x00cb }
        r1 = "type";	 Catch:{ Exception -> 0x00cb }
        r1 = r9.getColumnIndex(r1);	 Catch:{ Exception -> 0x00cb }
        r1 = r9.getString(r1);	 Catch:{ Exception -> 0x00cb }
        r2 = "alias";	 Catch:{ Exception -> 0x00cb }
        r2 = r9.getColumnIndex(r2);	 Catch:{ Exception -> 0x00cb }
        r2 = r9.getString(r2);	 Catch:{ Exception -> 0x00cb }
        r3 = a;	 Catch:{ Exception -> 0x00cb }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00cb }
        r5 = "typeTmp:";	 Catch:{ Exception -> 0x00cb }
        r4.<init>(r5);	 Catch:{ Exception -> 0x00cb }
        r4.append(r1);	 Catch:{ Exception -> 0x00cb }
        r5 = ",aliasTmp:";	 Catch:{ Exception -> 0x00cb }
        r4.append(r5);	 Catch:{ Exception -> 0x00cb }
        r4.append(r2);	 Catch:{ Exception -> 0x00cb }
        r5 = ",type:";	 Catch:{ Exception -> 0x00cb }
        r4.append(r5);	 Catch:{ Exception -> 0x00cb }
        r4.append(r11);	 Catch:{ Exception -> 0x00cb }
        r5 = ",alis:";	 Catch:{ Exception -> 0x00cb }
        r4.append(r5);	 Catch:{ Exception -> 0x00cb }
        r4.append(r10);	 Catch:{ Exception -> 0x00cb }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00cb }
        com.umeng.message.common.UmLog.d(r3, r4);	 Catch:{ Exception -> 0x00cb }
        r11 = r1.equalsIgnoreCase(r11);	 Catch:{ Exception -> 0x00cb }
        if (r11 == 0) goto L_0x00c6;	 Catch:{ Exception -> 0x00cb }
    L_0x00bf:
        r10 = r2.equalsIgnoreCase(r10);	 Catch:{ Exception -> 0x00cb }
        if (r10 == 0) goto L_0x00c6;	 Catch:{ Exception -> 0x00cb }
    L_0x00c5:
        r0 = r7;	 Catch:{ Exception -> 0x00cb }
    L_0x00c6:
        if (r9 == 0) goto L_0x00cb;	 Catch:{ Exception -> 0x00cb }
    L_0x00c8:
        r9.close();	 Catch:{ Exception -> 0x00cb }
    L_0x00cb:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.isAliasSet(int, java.lang.String, java.lang.String):boolean");
    }

    public void addTags(String... strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String format = String.format("UMENG_TAG_%s", new Object[]{strArr[i]});
            if (!Boolean.valueOf(b(format, av.b)).booleanValue()) {
                c(format, "true");
                c("UMENG_TAG_COUNT", String.valueOf(getTagCount() + 1));
            }
        }
    }

    public void removeTags(String... strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            String format = String.format("UMENG_TAG_%s", new Object[]{strArr[i]});
            if (Boolean.valueOf(b(format, av.b)).booleanValue()) {
                removeKeyAndValue(format);
                c("UMENG_TAG_COUNT", String.valueOf(getTagCount() - 1));
            }
        }
    }

    public boolean isTagSet(String str) {
        return Boolean.valueOf(b(String.format("UMENG_TAG_%s", new Object[]{str}), av.b)).booleanValue();
    }

    public int getTagCount() {
        return Integer.valueOf(b("UMENG_TAG_COUNT", "0")).intValue();
    }

    public void setTagRemain(int i) {
        c("UMENG_TAG_REMAIN", String.valueOf(i));
    }

    public int getTagRemain() {
        return Integer.valueOf(b("UMENG_TAG_REMAIN", "64")).intValue();
    }

    public void resetTags() {
        Exception e;
        Throwable th;
        Cursor query;
        try {
            List arrayList = new ArrayList();
            ContentResolver contentResolver = this.b.getContentResolver();
            a.a(this.b);
            query = contentResolver.query(a.c, null, null, null, null);
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        query.moveToFirst();
                        while (!query.isAfterLast()) {
                            String string = query.getString(query.getColumnIndex(d));
                            if (string.contains("UMENG_TAG")) {
                                arrayList.add(string);
                            }
                            query.moveToNext();
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (query != null) {
                            query.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            }
            for (int i = 0; i < arrayList.size(); i++) {
                String[] strArr = new String[]{(String) arrayList.get(i)};
                ContentResolver contentResolver2 = this.b.getContentResolver();
                a.a(this.b);
                contentResolver2.delete(a.c, "tempkey=?", strArr);
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            query = null;
            e = e3;
            e.printStackTrace();
            if (query != null) {
                query.close();
            }
        } catch (Throwable th3) {
            query = null;
            th = th3;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    void a(int i, int i2, int i3, int i4) {
        c(MsgConstant.KEY_NO_DISTURB_START_HOUR, String.valueOf(i));
        c(MsgConstant.KEY_NO_DISTURB_START_HOUR, String.valueOf(i2));
        c(MsgConstant.KEY_NO_DISTURB_END_HOUR, String.valueOf(i3));
        c(MsgConstant.KEY_NO_DISTURB_END_MINUTE, String.valueOf(i4));
    }

    int a() {
        return Integer.valueOf(b(MsgConstant.KEY_NO_DISTURB_START_HOUR, "23")).intValue();
    }

    int b() {
        return Integer.valueOf(b(MsgConstant.KEY_NO_DISTURB_START_MINUTE, "0")).intValue();
    }

    int c() {
        return Integer.valueOf(b(MsgConstant.KEY_NO_DISTURB_END_HOUR, "7")).intValue();
    }

    int d() {
        return Integer.valueOf(b(MsgConstant.KEY_NO_DISTURB_END_MINUTE, "0")).intValue();
    }

    void e() {
        c(MsgConstant.KEY_ENEABLED, "true");
    }

    void f() {
        c(MsgConstant.KEY_ENEABLED, av.b);
    }

    boolean g() {
        return b(MsgConstant.KEY_ENEABLED, av.b).equalsIgnoreCase("true");
    }

    boolean a(String str) {
        return b(MsgConstant.KEY_DEVICE_TOKEN, "").equalsIgnoreCase(str);
    }

    public void setIsEnabled(boolean z) {
        c(MsgConstant.KEY_ISENABLED, String.valueOf(z));
    }

    public boolean isEnabled() {
        String b = b(MsgConstant.KEY_ISENABLED, "");
        if (!b.equalsIgnoreCase("true")) {
            if (!b.equalsIgnoreCase("")) {
                return false;
            }
        }
        return true;
    }

    public boolean hasTransferedCacheFileDataToSQL() {
        return b(MsgConstant.KEY_CACHE_FILE_TRANSFER_TO_SQL, av.b).equalsIgnoreCase("true");
    }

    public boolean finishTransferedCacheFileDataToSQL() {
        return b(MsgConstant.KEY_CACHE_FILE_TRANSFER_TO_SQL, "true").equalsIgnoreCase("true");
    }

    public <U extends UmengMessageService> void setPushIntentServiceClass(Class<U> cls) {
        if (cls == null) {
            removeKeyAndValue(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME);
        } else {
            c(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME, cls.getName());
        }
    }

    public java.lang.String getPushIntentServiceClass() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = "KEY_PUSH_INTENT_SERVICE_CLASSNAME";
        r1 = "";
        r0 = r2.b(r0, r1);
        r1 = "";
        r1 = r0.equalsIgnoreCase(r1);
        if (r1 == 0) goto L_0x0013;
    L_0x0010:
        r0 = "";
        goto L_0x0016;
    L_0x0013:
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0017 }
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.MessageSharedPrefs.getPushIntentServiceClass():java.lang.String");
    }

    public boolean hasMessageResourceDownloaded(String str) {
        StringBuilder stringBuilder = new StringBuilder(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX);
        stringBuilder.append(str);
        return b(stringBuilder.toString(), av.b).equals("true");
    }

    public void setMessageResourceDownloaded(String str) {
        StringBuilder stringBuilder = new StringBuilder(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX);
        stringBuilder.append(str);
        c(stringBuilder.toString(), "true");
    }

    public void removeMessageResouceRecord(String str) {
        StringBuilder stringBuilder = new StringBuilder(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX);
        stringBuilder.append(str);
        removeKeyAndValue(stringBuilder.toString());
    }

    public void setLastMessageMsgID(String str) {
        c(MsgConstant.KEY_LAST_MSG_ID, str);
    }

    public String getLastMessageMsgID() {
        return b(MsgConstant.KEY_LAST_MSG_ID, "");
    }

    public void setMuteDuration(int i) {
        c(MsgConstant.KEY_MUTE_DURATION, String.valueOf(i));
    }

    public int getMuteDuration() {
        return Integer.valueOf(b(MsgConstant.KEY_MUTE_DURATION, "60")).intValue();
    }

    public void setSerialNo(int i) {
        c(MsgConstant.KEY_SERIA_NO, String.valueOf(i));
    }

    public int getSerialNo() {
        return Integer.valueOf(b(MsgConstant.KEY_SERIA_NO, "1")).intValue();
    }

    public boolean getNotificaitonOnForeground() {
        return b(MsgConstant.KEY_SET_NOTIFICATION_ON_FOREGROUND, "true").equals("true");
    }

    public void setNotificaitonOnForeground(boolean z) {
        c(MsgConstant.KEY_SET_NOTIFICATION_ON_FOREGROUND, String.valueOf(z));
    }

    public String getResourcePackageName() {
        return b(MsgConstant.KEY_SET_RESOURCE_PACKAGENAME, "");
    }

    public void setResourcePackageName(String str) {
        c(MsgConstant.KEY_SET_RESOURCE_PACKAGENAME, str);
    }

    public int getNotificationPlayVibrate() {
        return Integer.valueOf(b(MsgConstant.KEY_SET_NOTIFICATION_PLAY_VIBRATE, "0")).intValue();
    }

    public void setNotificationPlayVibrate(int i) {
        c(MsgConstant.KEY_SET_NOTIFICATION_PLAY_VIBRATE, String.valueOf(i));
    }

    public int getNotificationPlayLights() {
        return Integer.valueOf(b(MsgConstant.KEY_SET_NOTIFICATION_PLAY_LIGHTS, "0")).intValue();
    }

    public void setNotificationPlayLights(int i) {
        c(MsgConstant.KEY_SET_NOTIFICATION_PLAY_LIGHTS, String.valueOf(i));
    }

    public int getNotificationPlaySound() {
        return Integer.valueOf(b(MsgConstant.KEY_SET_NOTIFICATION_PLAY_SOUND, "0")).intValue();
    }

    public void setNotificationPlaySound(int i) {
        c(MsgConstant.KEY_SET_NOTIFICATION_PLAY_SOUND, String.valueOf(i));
    }

    public void setAppVersion(String str) {
        if (str == null) {
            removeKeyAndValue("app_version");
        } else {
            c("app_version", str);
        }
    }

    public String getAppVersion() {
        return b("app_version", "");
    }

    public void setDeviceToken(String str) {
        if (str == null) {
            removeKeyAndValue(MsgConstant.KEY_DEVICE_TOKEN);
        } else {
            c(MsgConstant.KEY_DEVICE_TOKEN, str);
        }
    }

    public String getDeviceToken() {
        return b(MsgConstant.KEY_DEVICE_TOKEN, "");
    }

    public void setUmid(String str) {
        this.f.edit().putString("KEY_SET_UMID", str).apply();
    }

    public String getUmid() {
        return this.f.getString("KEY_SET_UMID", "");
    }

    void b(String str) {
        this.f.edit().putString(MsgConstant.KEY_NOTIFICATION_CHANNEL, str).apply();
    }

    String h() {
        return this.f.getString(MsgConstant.KEY_NOTIFICATION_CHANNEL, "");
    }

    public void setLocationInterval(int i) {
        if (i < 2 || i > 1800) {
            UmLog.d("LBS", "The interval of LBS should not be smaller than 2 seconds");
        } else {
            c(MsgConstant.KEY_LOCATION_INTERVAL, String.valueOf(i));
        }
    }

    public int getLocationInterval() {
        return Integer.valueOf(b(MsgConstant.KEY_LOCATION_INTERVAL, "600")).intValue();
    }

    public void setHasResgister(boolean z) {
        c(MsgConstant.KEY_HASREGISTER, String.valueOf(z));
    }

    public boolean getHasRegister() {
        return b(MsgConstant.KEY_HASREGISTER, av.b).equalsIgnoreCase("true");
    }

    public int getRegisterTimes() {
        return Integer.valueOf(getInstance(this.b).b(MsgConstant.KEY_REGISTER_TIMES, "0")).intValue();
    }

    public void setRegisterTimes(int i) {
        c(MsgConstant.KEY_REGISTER_TIMES, String.valueOf(i));
    }

    public String getUcode() {
        return getInstance(this.b).b(MsgConstant.KEY_UCODE, "");
    }

    public void setUcode(String str) {
        c(MsgConstant.KEY_UCODE, str);
    }

    private String b(String str, String str2) {
        Cursor cursor = null;
        try {
            new ContentValues().put(d, str);
            String[] strArr = new String[]{str};
            ContentResolver contentResolver = this.b.getContentResolver();
            a.a(this.b);
            str = contentResolver.query(a.c, new String[]{e}, "tempkey=?", strArr, null);
            if (str == null) {
                if (str != null) {
                    str.close();
                }
                return str2;
            }
            try {
                if (str.moveToFirst()) {
                    str2 = str.getString(str.getColumnIndex(e));
                }
                if (str != null) {
                    str.close();
                }
            } catch (Exception e) {
                Exception exception = e;
                cursor = str;
                str = exception;
                try {
                    str.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                    return str2;
                } catch (Throwable th) {
                    str2 = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw str2;
                }
            } catch (Throwable th2) {
                str2 = th2;
                cursor = str;
                if (cursor != null) {
                    cursor.close();
                }
                throw str2;
            }
            return str2;
        } catch (Exception e2) {
            str = e2;
            str.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
            return str2;
        }
    }

    private void c(final String str, final String str2) {
        new Thread(new Runnable(this) {
            final /* synthetic */ MessageSharedPrefs c;

            public void run() {
                Cursor query;
                Exception e;
                Throwable th;
                try {
                    String str = "tempkey=?";
                    String[] strArr = new String[]{str};
                    ContentResolver contentResolver = this.c.b.getContentResolver();
                    a.a(this.c.b);
                    query = contentResolver.query(a.c, new String[]{MessageSharedPrefs.e}, str, strArr, null);
                    ContentValues contentValues;
                    if (query == null) {
                        try {
                            contentValues = new ContentValues();
                            contentValues.put(MessageSharedPrefs.d, str);
                            contentValues.put(MessageSharedPrefs.e, str2);
                            contentResolver = this.c.b.getContentResolver();
                            a.a(this.c.b);
                            contentResolver.insert(a.c, contentValues);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                e.printStackTrace();
                                if (query != null) {
                                    query.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (query != null) {
                                    query.close();
                                }
                                throw th;
                            }
                        }
                    } else if (query.moveToFirst()) {
                        contentValues = new ContentValues();
                        contentValues.put(MessageSharedPrefs.e, str2);
                        contentResolver = this.c.b.getContentResolver();
                        a.a(this.c.b);
                        contentResolver.update(a.c, contentValues, str, strArr);
                    } else {
                        contentValues = new ContentValues();
                        contentValues.put(MessageSharedPrefs.d, str);
                        contentValues.put(MessageSharedPrefs.e, str2);
                        contentResolver = this.c.b.getContentResolver();
                        a.a(this.c.b);
                        contentResolver.insert(a.c, contentValues);
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e3) {
                    Exception exception = e3;
                    query = null;
                    e = exception;
                    e.printStackTrace();
                    if (query != null) {
                        query.close();
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    query = null;
                    th = th4;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            }
        }).start();
    }

    public void removeKeyAndValue(final String str) {
        new Thread(new Runnable(this) {
            final /* synthetic */ MessageSharedPrefs b;

            public void run() {
                Exception exception;
                Throwable th;
                Cursor cursor = null;
                try {
                    new ContentValues().put(MessageSharedPrefs.d, str);
                    ContentResolver contentResolver = this.b.b.getContentResolver();
                    a.a(this.b.b);
                    Cursor query = contentResolver.query(a.c, new String[]{MessageSharedPrefs.e}, null, null, null);
                    if (query != null) {
                        try {
                            String[] strArr = new String[]{str};
                            ContentResolver contentResolver2 = this.b.b.getContentResolver();
                            a.a(this.b.b);
                            contentResolver2.delete(a.c, "tempkey=?", strArr);
                        } catch (Exception e) {
                            exception = e;
                            cursor = query;
                            try {
                                exception.printStackTrace();
                                if (cursor != null) {
                                    cursor.close();
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = query;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e2) {
                    exception = e2;
                    exception.printStackTrace();
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        }).start();
    }
}
