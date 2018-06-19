package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.alibaba.wireless.security.SecExceptionCode;
import com.igexin.sdk.PushConsts;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.channel.commonutils.android.g;
import com.xiaomi.channel.commonutils.android.h;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.string.d;
import com.xiaomi.mipush.sdk.MiTinyDataClient.a;
import com.xiaomi.push.mpcd.c;
import com.xiaomi.push.service.am;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.k;
import com.xiaomi.push.service.module.PushChannelRegion;
import com.xiaomi.push.service.p;
import com.xiaomi.push.service.receivers.NetworkStatusReceiver;
import com.xiaomi.xmpush.thrift.ad;
import com.xiaomi.xmpush.thrift.ai;
import com.xiaomi.xmpush.thrift.aj;
import com.xiaomi.xmpush.thrift.ao;
import com.xiaomi.xmpush.thrift.aq;
import com.xiaomi.xmpush.thrift.as;
import com.xiaomi.xmpush.thrift.r;
import com.xiaomi.xmpush.thrift.u;
import com.xiaomi.xmpush.thrift.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public abstract class MiPushClient {
    public static final String COMMAND_REGISTER = "register";
    public static final String COMMAND_SET_ACCEPT_TIME = "accept-time";
    public static final String COMMAND_SET_ACCOUNT = "set-account";
    public static final String COMMAND_SET_ALIAS = "set-alias";
    public static final String COMMAND_SUBSCRIBE_TOPIC = "subscribe-topic";
    public static final String COMMAND_UNREGISTER = "unregister";
    public static final String COMMAND_UNSET_ACCOUNT = "unset-account";
    public static final String COMMAND_UNSET_ALIAS = "unset-alias";
    public static final String COMMAND_UNSUBSCRIBE_TOPIC = "unsubscibe-topic";
    public static final String PREF_EXTRA = "mipush_extra";
    private static boolean isOpenHmsPush = false;
    private static an mSyncMIIDHelper;
    private static Context sContext;
    private static long sCurMsgId = System.currentTimeMillis();

    @Deprecated
    public static abstract class MiPushClientCallback {
        private String category;

        protected String getCategory() {
            return this.category;
        }

        public void onCommandResult(String str, long j, String str2, List<String> list) {
        }

        public void onInitializeResult(long j, String str, String str2) {
        }

        public void onReceiveMessage(MiPushMessage miPushMessage) {
        }

        public void onReceiveMessage(String str, String str2, String str3, boolean z) {
        }

        public void onSubscribeResult(long j, String str, String str2) {
        }

        public void onUnsubscribeResult(long j, String str, String str2) {
        }

        protected void setCategory(String str) {
            this.category = str;
        }
    }

    private static boolean acceptTimeSet(Context context, String str, String str2) {
        CharSequence acceptTime = getAcceptTime(context);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        stringBuilder.append(str2);
        return TextUtils.equals(acceptTime, stringBuilder.toString());
    }

    public static long accountSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder stringBuilder = new StringBuilder("account_");
        stringBuilder.append(str);
        return sharedPreferences.getLong(stringBuilder.toString(), -1);
    }

    static synchronized void addAcceptTime(Context context, String str, String str2) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            String str3 = Constants.EXTRA_KEY_ACCEPT_TIME;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuilder.append(str2);
            edit.putString(str3, stringBuilder.toString());
            ak.a(edit);
        }
    }

    static synchronized void addAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder stringBuilder = new StringBuilder("account_");
            stringBuilder.append(str);
            edit.putLong(stringBuilder.toString(), System.currentTimeMillis()).commit();
        }
    }

    static synchronized void addAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder stringBuilder = new StringBuilder("alias_");
            stringBuilder.append(str);
            edit.putLong(stringBuilder.toString(), System.currentTimeMillis()).commit();
        }
    }

    private static void addPullNotificationTime(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_pull_notification", System.currentTimeMillis());
        ak.a(edit);
    }

    private static void addRegRequestTime(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.putLong("last_reg_request", System.currentTimeMillis());
        ak.a(edit);
    }

    static synchronized void addTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder stringBuilder = new StringBuilder("topic_");
            stringBuilder.append(str);
            edit.putLong(stringBuilder.toString(), System.currentTimeMillis()).commit();
        }
    }

    public static long aliasSetTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder stringBuilder = new StringBuilder("alias_");
        stringBuilder.append(str);
        return sharedPreferences.getLong(stringBuilder.toString(), -1);
    }

    public static void awakeApps(Context context, String[] strArr) {
        new Thread(new q(strArr, context)).start();
    }

    private static void awakePushServiceByPackageInfo(android.content.Context r5, android.content.pm.PackageInfo r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = r6.services;
        if (r6 == 0) goto L_0x005a;
    L_0x0004:
        r0 = r6.length;
        r1 = 0;
    L_0x0006:
        if (r1 >= r0) goto L_0x005a;
    L_0x0008:
        r2 = r6[r1];
        r3 = r2.exported;
        if (r3 == 0) goto L_0x0057;
    L_0x000e:
        r3 = r2.enabled;
        if (r3 == 0) goto L_0x0057;
    L_0x0012:
        r3 = "com.xiaomi.mipush.sdk.PushMessageHandler";
        r4 = r2.name;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0057;
    L_0x001c:
        r3 = r5.getPackageName();
        r4 = r2.packageName;
        r3 = r3.equals(r4);
        if (r3 != 0) goto L_0x0057;
    L_0x0028:
        r0 = java.lang.Math.random();	 Catch:{ Throwable -> 0x0056 }
        r3 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;	 Catch:{ Throwable -> 0x0056 }
        r0 = r0 * r3;	 Catch:{ Throwable -> 0x0056 }
        r3 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;	 Catch:{ Throwable -> 0x0056 }
        r0 = r0 + r3;	 Catch:{ Throwable -> 0x0056 }
        r0 = (long) r0;	 Catch:{ Throwable -> 0x0056 }
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Throwable -> 0x0056 }
        r0 = r0 * r3;	 Catch:{ Throwable -> 0x0056 }
        java.lang.Thread.sleep(r0);	 Catch:{ Throwable -> 0x0056 }
        r6 = new android.content.Intent;	 Catch:{ Throwable -> 0x0056 }
        r6.<init>();	 Catch:{ Throwable -> 0x0056 }
        r0 = r2.packageName;	 Catch:{ Throwable -> 0x0056 }
        r1 = r2.name;	 Catch:{ Throwable -> 0x0056 }
        r6.setClassName(r0, r1);	 Catch:{ Throwable -> 0x0056 }
        r0 = "com.xiaomi.mipush.sdk.WAKEUP";	 Catch:{ Throwable -> 0x0056 }
        r6.setAction(r0);	 Catch:{ Throwable -> 0x0056 }
        r0 = "waker_pkgname";	 Catch:{ Throwable -> 0x0056 }
        r1 = r5.getPackageName();	 Catch:{ Throwable -> 0x0056 }
        r6.putExtra(r0, r1);	 Catch:{ Throwable -> 0x0056 }
        r5.startService(r6);	 Catch:{ Throwable -> 0x0056 }
    L_0x0056:
        return;
    L_0x0057:
        r1 = r1 + 1;
        goto L_0x0006;
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.mipush.sdk.MiPushClient.awakePushServiceByPackageInfo(android.content.Context, android.content.pm.PackageInfo):void");
    }

    private static void checkNotNull(Object obj, Object obj2) {
    }

    private static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder("param ");
            stringBuilder.append(str);
            stringBuilder.append(" is not nullable");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    protected static void clearExtras(Context context) {
        Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
        edit.clear();
        edit.commit();
    }

    public static void clearLocalNotificationType(Context context) {
        ac.a(context).g();
    }

    public static void clearNotification(Context context) {
        ac.a(context).a(-1);
    }

    public static void clearNotification(Context context, int i) {
        ac.a(context).a(i);
    }

    public static void clearNotification(Context context, String str, String str2) {
        ac.a(context).a(str, str2);
    }

    public static void disablePush(Context context) {
        ac.a(context).a(true);
    }

    private static void enableGeo(Context context, boolean z) {
        if (Math.abs(System.currentTimeMillis() - getGeoEnableTime(context, String.valueOf(z))) > 60000) {
            k.a(context, z);
            i.a(context, z);
            setGeoEnableTime(context, String.valueOf(z));
        }
    }

    public static void enablePush(Context context) {
        ac.a(context).a(false);
    }

    protected static synchronized String generatePacketID() {
        String stringBuilder;
        synchronized (MiPushClient.class) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(d.a(4));
            stringBuilder2.append(sCurMsgId);
            stringBuilder = stringBuilder2.toString();
            sCurMsgId++;
        }
        return stringBuilder;
    }

    protected static String getAcceptTime(Context context) {
        return context.getSharedPreferences("mipush_extra", 0).getString(Constants.EXTRA_KEY_ACCEPT_TIME, "00:00-23:59");
    }

    public static List<String> getAllAlias(Context context) {
        List<String> arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("alias_")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllTopic(Context context) {
        List<String> arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("topic_") && !str.contains("**ALL**")) {
                arrayList.add(str.substring(6));
            }
        }
        return arrayList;
    }

    public static List<String> getAllUserAccount(Context context) {
        List<String> arrayList = new ArrayList();
        for (String str : context.getSharedPreferences("mipush_extra", 0).getAll().keySet()) {
            if (str.startsWith("account_")) {
                arrayList.add(str.substring(8));
            }
        }
        return arrayList;
    }

    private static boolean getDefaultSwitch() {
        return f.b();
    }

    private static long getGeoEnableTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder stringBuilder = new StringBuilder("geo_");
        stringBuilder.append(str);
        return sharedPreferences.getLong(stringBuilder.toString(), -1);
    }

    protected static boolean getOpenHmsPush() {
        return isOpenHmsPush;
    }

    public static String getRegId(Context context) {
        return c.a(context).i() ? c.a(context).e() : null;
    }

    @Deprecated
    public static void initialize(Context context, String str, String str2, MiPushClientCallback miPushClientCallback) {
        checkNotNull((Object) context, "context");
        checkNotNull((Object) str, "appID");
        checkNotNull((Object) str2, "appToken");
        try {
            Context applicationContext = context.getApplicationContext();
            sContext = applicationContext;
            if (applicationContext == null) {
                sContext = context;
            }
            if (miPushClientCallback != null) {
                PushMessageHandler.a(miPushClientCallback);
            }
            if (h.b(context)) {
                k.a(context);
            }
            boolean z = c.a(sContext).l() != Constants.a();
            if (z || shouldSendRegRequest(sContext)) {
                if (z || !c.a(sContext).a(str, str2) || c.a(sContext).m()) {
                    String a = d.a(6);
                    c.a(sContext).h();
                    c.a(sContext).a(Constants.a());
                    c.a(sContext).a(str, str2, a);
                    a.a().b(MiTinyDataClient.PENDING_REASON_APPID);
                    clearExtras(sContext);
                    aj ajVar = new aj();
                    ajVar.a(generatePacketID());
                    ajVar.b(str);
                    ajVar.e(str2);
                    ajVar.d(context.getPackageName());
                    ajVar.f(a);
                    ajVar.c(com.xiaomi.channel.commonutils.android.a.a(context, context.getPackageName()));
                    ajVar.b(com.xiaomi.channel.commonutils.android.a.b(context, context.getPackageName()));
                    ajVar.g("3_5_1");
                    ajVar.a(30501);
                    ajVar.h(com.xiaomi.channel.commonutils.android.d.b(sContext));
                    ajVar.a(w.Init);
                    str = com.xiaomi.channel.commonutils.android.d.d(sContext);
                    Object f = com.xiaomi.channel.commonutils.android.d.f(sContext);
                    if (!TextUtils.isEmpty(str)) {
                        if (f.b()) {
                            if (!TextUtils.isEmpty(f)) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(str);
                                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                stringBuilder.append(f);
                                str = stringBuilder.toString();
                            }
                            ajVar.i(str);
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(d.a(str));
                        stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        stringBuilder2.append(com.xiaomi.channel.commonutils.android.d.g(sContext));
                        ajVar.k(stringBuilder2.toString());
                    }
                    ajVar.j(com.xiaomi.channel.commonutils.android.d.a());
                    int b = com.xiaomi.channel.commonutils.android.d.b();
                    if (b >= 0) {
                        ajVar.c(b);
                    }
                    ac.a(sContext).a(ajVar, z);
                    a.a(context);
                    bb.a(context).a("mipush_extra", "mipush_registed", true);
                } else {
                    if (1 == PushMessageHelper.getPushMode(context)) {
                        checkNotNull((Object) miPushClientCallback, com.alipay.sdk.authjs.a.c);
                        miPushClientCallback.onInitializeResult(0, null, c.a(context).e());
                    } else {
                        List arrayList = new ArrayList();
                        arrayList.add(c.a(context).e());
                        PushMessageHelper.sendCommandMessageBroadcast(sContext, PushMessageHelper.generateCommandMessage("register", arrayList, 0, null, null));
                    }
                    ac.a(context).a();
                    if (c.a(sContext).a()) {
                        org.apache.thrift.a aiVar = new ai();
                        aiVar.b(c.a(context).c());
                        aiVar.c("client_info_update");
                        aiVar.a(generatePacketID());
                        aiVar.h = new HashMap();
                        aiVar.h.put("app_version", com.xiaomi.channel.commonutils.android.a.a(sContext, sContext.getPackageName()));
                        aiVar.h.put(Constants.EXTRA_KEY_APP_VERSION_CODE, Integer.toString(com.xiaomi.channel.commonutils.android.a.b(sContext, sContext.getPackageName())));
                        aiVar.h.put("push_sdk_vn", "3_5_1");
                        aiVar.h.put("push_sdk_vc", Integer.toString(30501));
                        CharSequence g = c.a(sContext).g();
                        if (!TextUtils.isEmpty(g)) {
                            aiVar.h.put("deviceid", g);
                        }
                        ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, null);
                        a.a(context);
                    }
                    if (!g.a(sContext, "update_devId", false)) {
                        updateIMEI();
                        g.b(sContext, "update_devId", true);
                    }
                    if (shouldUseMIUIPush(sContext) && shouldPullNotification(sContext)) {
                        org.apache.thrift.a aiVar2 = new ai();
                        aiVar2.b(c.a(sContext).c());
                        aiVar2.c(r.PullOfflineMessage.W);
                        aiVar2.a(generatePacketID());
                        aiVar2.a(false);
                        ac.a(sContext).a(aiVar2, com.xiaomi.xmpush.thrift.a.Notification, false, null, false);
                        addPullNotificationTime(sContext);
                    }
                }
                addRegRequestTime(sContext);
                scheduleOcVersionCheckJob();
                scheduleGeoFenceLocUploadJobs();
                scheduleDataCollectionJobs(context);
                al.a(sContext);
                if (mSyncMIIDHelper == null) {
                    mSyncMIIDHelper = new an(sContext);
                }
                mSyncMIIDHelper.a(sContext);
                if ("syncing".equals(u.a(sContext).a(aj.DISABLE_PUSH))) {
                    disablePush(sContext);
                }
                if ("syncing".equals(u.a(sContext).a(aj.ENABLE_PUSH))) {
                    enablePush(sContext);
                }
                if ("syncing".equals(u.a(sContext).a(aj.UPLOAD_TOKEN))) {
                    syncAssemblePushToken(sContext);
                }
                return;
            }
            ac.a(context).a();
            b.a("Could not send  register message within 5s repeatly .");
        } catch (Exception e) {
            b.d(e.toString());
        } catch (Throwable th) {
            b.a(th);
        }
    }

    public static void pausePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 0, 0, str);
    }

    static void reInitialize(Context context, w wVar) {
        if (c.a(context).i()) {
            String a = d.a(6);
            String c = c.a(context).c();
            String d = c.a(context).d();
            c.a(context).h();
            c.a(context).a(c, d, a);
            aj ajVar = new aj();
            ajVar.a(generatePacketID());
            ajVar.b(c);
            ajVar.e(d);
            ajVar.f(a);
            ajVar.d(context.getPackageName());
            ajVar.c(com.xiaomi.channel.commonutils.android.a.a(context, context.getPackageName()));
            ajVar.a(wVar);
            ac.a(context).a(ajVar, false);
        }
    }

    private static void registerNetworkReceiver(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            intentFilter.addCategory("android.intent.category.DEFAULT");
            context.getApplicationContext().registerReceiver(new NetworkStatusReceiver(null), intentFilter);
        } catch (Throwable th) {
            b.a(th);
        }
    }

    public static void registerPush(Context context, String str, String str2) {
        registerPush(context, str, str2, new PushConfiguration());
    }

    public static void registerPush(Context context, String str, String str2, PushConfiguration pushConfiguration) {
        if (!NetworkStatusReceiver.a()) {
            registerNetworkReceiver(context);
        }
        PushChannelRegion region = pushConfiguration.getRegion();
        isOpenHmsPush = pushConfiguration.getOpenHmsPush();
        checkNotNull((Object) region, PushChannelRegion.China);
        com.xiaomi.push.service.a.a(context).a(region);
        enableGeo(context, pushConfiguration.getGeoEnable());
        a.a();
        new Thread(new n(context, str, str2)).start();
    }

    static synchronized void removeAcceptTime(Context context) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            edit.remove(Constants.EXTRA_KEY_ACCEPT_TIME);
            ak.a(edit);
        }
    }

    static synchronized void removeAccount(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder stringBuilder = new StringBuilder("account_");
            stringBuilder.append(str);
            edit.remove(stringBuilder.toString()).commit();
        }
    }

    static synchronized void removeAlias(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder stringBuilder = new StringBuilder("alias_");
            stringBuilder.append(str);
            edit.remove(stringBuilder.toString()).commit();
        }
    }

    static synchronized void removeAllAccounts(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAccount : getAllUserAccount(context)) {
                removeAccount(context, removeAccount);
            }
        }
    }

    static synchronized void removeAllAliases(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeAlias : getAllAlias(context)) {
                removeAlias(context, removeAlias);
            }
        }
    }

    static synchronized void removeAllTopics(Context context) {
        synchronized (MiPushClient.class) {
            for (String removeTopic : getAllTopic(context)) {
                removeTopic(context, removeTopic);
            }
        }
    }

    static synchronized void removeTopic(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder stringBuilder = new StringBuilder("topic_");
            stringBuilder.append(str);
            edit.remove(stringBuilder.toString()).commit();
        }
    }

    static void reportIgnoreRegMessageClicked(Context context, String str, u uVar, String str2, String str3) {
        org.apache.thrift.a aiVar = new ai();
        if (TextUtils.isEmpty(str3)) {
            b.d("do not report clicked message");
            return;
        }
        aiVar.b(str3);
        aiVar.c("bar:click");
        aiVar.a(str);
        aiVar.a(false);
        ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, true, uVar, true, str2, str3);
    }

    public static void reportMessageClicked(Context context, MiPushMessage miPushMessage) {
        u uVar = new u();
        uVar.a(miPushMessage.getMessageId());
        uVar.b(miPushMessage.getTopic());
        uVar.d(miPushMessage.getDescription());
        uVar.c(miPushMessage.getTitle());
        uVar.c(miPushMessage.getNotifyId());
        uVar.a(miPushMessage.getNotifyType());
        uVar.b(miPushMessage.getPassThrough());
        uVar.a(miPushMessage.getExtra());
        reportMessageClicked(context, miPushMessage.getMessageId(), uVar, null);
    }

    @Deprecated
    public static void reportMessageClicked(Context context, String str) {
        reportMessageClicked(context, str, null, null);
    }

    static void reportMessageClicked(Context context, String str, u uVar, String str2) {
        org.apache.thrift.a aiVar = new ai();
        if (TextUtils.isEmpty(str2)) {
            if (c.a(context).b()) {
                str2 = c.a(context).c();
            } else {
                b.d("do not report clicked message");
                return;
            }
        }
        aiVar.b(str2);
        aiVar.c("bar:click");
        aiVar.a(str);
        aiVar.a(false);
        ac.a(context).a(aiVar, com.xiaomi.xmpush.thrift.a.Notification, false, uVar);
    }

    public static void resumePush(Context context, String str) {
        setAcceptTime(context, 0, 0, 23, 59, str);
    }

    private static void scheduleDataCollectionJobs(Context context) {
        if (am.a(sContext).a(com.xiaomi.xmpush.thrift.g.DataCollectionSwitch.a(), getDefaultSwitch())) {
            c.a().a(new e(context));
            com.xiaomi.channel.commonutils.misc.h.a(sContext).a(new o(), 10);
        }
    }

    private static void scheduleGeoFenceLocUploadJobs() {
        if (k.e(sContext) && !TextUtils.equals("com.xiaomi.xmsf", sContext.getPackageName()) && am.a(sContext).a(com.xiaomi.xmpush.thrift.g.UploadGeoAppLocSwitch.a(), true) && !h.e()) {
            g.a(sContext, true);
            int max = Math.max(60, am.a(sContext).a(com.xiaomi.xmpush.thrift.g.UploadWIFIGeoLocFrequency.a(), (int) SecExceptionCode.SEC_ERROR_UMID_VALID));
            com.xiaomi.channel.commonutils.misc.h.a(sContext).a(new g(sContext, max), max, max);
        }
    }

    private static void scheduleOcVersionCheckJob() {
        com.xiaomi.channel.commonutils.misc.h.a(sContext).a(new t(sContext), am.a(sContext).a(com.xiaomi.xmpush.thrift.g.OcVersionCheckFrequency.a(), 86400), 5);
    }

    public static void setAcceptTime(Context context, int i, int i2, int i3, int i4, String str) {
        Context context2 = context;
        int i5 = i;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        if (i5 >= 0 && i5 < 24 && i7 >= 0 && i7 < 24 && i6 >= 0 && i6 < 60 && i8 >= 0) {
            if (i8 < 60) {
                long rawOffset = (long) (((TimeZone.getTimeZone("GMT+08").getRawOffset() - TimeZone.getDefault().getRawOffset()) / 1000) / 60);
                long j = ((((long) ((i5 * 60) + i6)) + rawOffset) + 1440) % 1440;
                rawOffset = ((((long) ((i7 * 60) + i8)) + rawOffset) + 1440) % 1440;
                ArrayList arrayList = new ArrayList();
                arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)}));
                arrayList.add(String.format("%1$02d:%2$02d", new Object[]{Long.valueOf(rawOffset / 60), Long.valueOf(rawOffset % 60)}));
                List arrayList2 = new ArrayList();
                arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
                arrayList2.add(String.format("%1$02d:%2$02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}));
                if (!acceptTimeSet(context2, (String) arrayList.get(0), (String) arrayList.get(1))) {
                    setCommand(context2, COMMAND_SET_ACCEPT_TIME, arrayList, str);
                    return;
                } else if (1 == PushMessageHelper.getPushMode(context)) {
                    PushMessageHandler.a(context2, str, COMMAND_SET_ACCEPT_TIME, 0, null, arrayList2);
                    return;
                } else {
                    PushMessageHelper.sendCommandMessageBroadcast(context2, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCEPT_TIME, arrayList2, 0, null, null));
                    return;
                }
            }
        }
        throw new IllegalArgumentException("the input parameter is not valid.");
    }

    public static void setAlias(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ALIAS, str, str2);
        }
    }

    protected static void setCommand(Context context, String str, String str2, String str3) {
        Context context2 = context;
        String str4 = str;
        String str5 = str2;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str5);
        }
        if (!COMMAND_SET_ALIAS.equalsIgnoreCase(str4) || Math.abs(System.currentTimeMillis() - aliasSetTime(context2, str5)) >= 3600000) {
            StringBuilder stringBuilder;
            if (COMMAND_UNSET_ALIAS.equalsIgnoreCase(str4) && aliasSetTime(context2, str5) < 0) {
                stringBuilder = new StringBuilder("Don't cancel alias for ");
                stringBuilder.append(arrayList);
                stringBuilder.append(" is unseted");
                b.a(stringBuilder.toString());
            } else if (!COMMAND_SET_ACCOUNT.equalsIgnoreCase(str4) || Math.abs(System.currentTimeMillis() - accountSetTime(context2, str5)) >= 3600000) {
                if (!COMMAND_UNSET_ACCOUNT.equalsIgnoreCase(str4) || accountSetTime(context2, str5) >= 0) {
                    setCommand(context2, str4, arrayList, str3);
                    return;
                }
                stringBuilder = new StringBuilder("Don't cancel account for ");
                stringBuilder.append(arrayList);
                stringBuilder.append(" is unseted");
                b.a(stringBuilder.toString());
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context2, str3, str4, 0, null, arrayList);
            } else {
                PushMessageHelper.sendCommandMessageBroadcast(context2, PushMessageHelper.generateCommandMessage(COMMAND_SET_ACCOUNT, arrayList, 0, null, null));
            }
        } else if (1 == PushMessageHelper.getPushMode(context)) {
            PushMessageHandler.a(context2, str3, str4, 0, null, arrayList);
        } else {
            PushMessageHelper.sendCommandMessageBroadcast(context2, PushMessageHelper.generateCommandMessage(COMMAND_SET_ALIAS, arrayList, 0, null, null));
        }
    }

    protected static void setCommand(Context context, String str, ArrayList<String> arrayList, String str2) {
        if (!TextUtils.isEmpty(c.a(context).c())) {
            org.apache.thrift.a adVar = new ad();
            adVar.a(generatePacketID());
            adVar.b(c.a(context).c());
            adVar.c(str);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                adVar.d((String) it.next());
            }
            adVar.f(str2);
            adVar.e(context.getPackageName());
            ac.a(context).a(adVar, com.xiaomi.xmpush.thrift.a.Command, null);
        }
    }

    static synchronized void setGeoEnableTime(Context context, String str) {
        synchronized (MiPushClient.class) {
            Editor edit = context.getSharedPreferences("mipush_extra", 0).edit();
            StringBuilder stringBuilder = new StringBuilder("geo_");
            stringBuilder.append(str);
            edit.putLong(stringBuilder.toString(), System.currentTimeMillis());
            ak.a(edit);
        }
    }

    public static void setLocalNotificationType(Context context, int i) {
        ac.a(context).b(i & -1);
    }

    public static void setUserAccount(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            setCommand(context, COMMAND_SET_ACCOUNT, str, str2);
        }
    }

    private static boolean shouldPullNotification(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_pull_notification", -1)) > 300000;
    }

    private static boolean shouldSendRegRequest(Context context) {
        return Math.abs(System.currentTimeMillis() - context.getSharedPreferences("mipush_extra", 0).getLong("last_reg_request", -1)) > 5000;
    }

    public static boolean shouldUseMIUIPush(Context context) {
        return ac.a(context).d();
    }

    public static void subscribe(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(c.a(context).c()) && !TextUtils.isEmpty(str)) {
            if (Math.abs(System.currentTimeMillis() - topicSubscribedTime(context, str)) > 86400000) {
                org.apache.thrift.a aoVar = new ao();
                aoVar.a(generatePacketID());
                aoVar.b(c.a(context).c());
                aoVar.c(str);
                aoVar.d(context.getPackageName());
                aoVar.e(str2);
                ac.a(context).a(aoVar, com.xiaomi.xmpush.thrift.a.Subscription, null);
            } else if (1 == PushMessageHelper.getPushMode(context)) {
                PushMessageHandler.a(context, str2, 0, null, str);
            } else {
                List arrayList = new ArrayList();
                arrayList.add(str);
                PushMessageHelper.sendCommandMessageBroadcast(context, PushMessageHelper.generateCommandMessage(COMMAND_SUBSCRIBE_TOPIC, arrayList, 0, null, null));
            }
        }
    }

    public static void syncAssemblePushToken(Context context) {
        ac.a(context).c();
    }

    public static long topicSubscribedTime(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_extra", 0);
        StringBuilder stringBuilder = new StringBuilder("topic_");
        stringBuilder.append(str);
        return sharedPreferences.getLong(stringBuilder.toString(), -1);
    }

    public static void unregisterPush(Context context) {
        d.d(context);
        if (c.a(context).b()) {
            aq aqVar = new aq();
            aqVar.a(generatePacketID());
            aqVar.b(c.a(context).c());
            aqVar.c(c.a(context).e());
            aqVar.e(c.a(context).d());
            aqVar.d(context.getPackageName());
            ac.a(context).a(aqVar);
            PushMessageHandler.a();
            c.a(context).j();
            clearLocalNotificationType(context);
            clearNotification(context);
            if (mSyncMIIDHelper != null) {
                p.a(context).b(mSyncMIIDHelper);
            }
            clearExtras(context);
        }
    }

    public static void unsetAlias(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ALIAS, str, str2);
    }

    public static void unsetUserAccount(Context context, String str, String str2) {
        setCommand(context, COMMAND_UNSET_ACCOUNT, str, str2);
    }

    public static void unsubscribe(Context context, String str, String str2) {
        if (!c.a(context).b()) {
            return;
        }
        if (topicSubscribedTime(context, str) < 0) {
            StringBuilder stringBuilder = new StringBuilder("Don't cancel subscribe for ");
            stringBuilder.append(str);
            stringBuilder.append(" is unsubscribed");
            b.a(stringBuilder.toString());
            return;
        }
        org.apache.thrift.a asVar = new as();
        asVar.a(generatePacketID());
        asVar.b(c.a(context).c());
        asVar.c(str);
        asVar.d(context.getPackageName());
        asVar.e(str2);
        ac.a(context).a(asVar, com.xiaomi.xmpush.thrift.a.UnSubscription, null);
    }

    private static void updateIMEI() {
        new Thread(new p()).start();
    }
}
