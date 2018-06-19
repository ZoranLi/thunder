package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.RemoteViews;
import anet.channel.util.HttpConstant;
import com.umeng.message.entity.UMessage;
import com.xiaomi.channel.commonutils.android.f;
import com.xiaomi.xmpush.thrift.af;
import com.xiaomi.xmpush.thrift.u;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class ah {
    public static long a;
    private static final LinkedList<Pair<Integer, af>> b = new LinkedList();

    public static class a {
        Notification a;
        long b = 0;
    }

    public static class b {
        public String a;
        public long b = 0;
    }

    private static int a(Context context, String str, String str2) {
        return str.equals(context.getPackageName()) ? context.getResources().getIdentifier(str2, "drawable", str) : 0;
    }

    private static Notification a(Notification notification) {
        Object a = com.xiaomi.channel.commonutils.reflect.a.a(notification, "extraNotification");
        if (a != null) {
            com.xiaomi.channel.commonutils.reflect.a.a(a, "setCustomizedIcon", new Object[]{Boolean.valueOf(true)});
        }
        return notification;
    }

    private static Notification a(Notification notification, String str) {
        try {
            Field declaredField = Notification.class.getDeclaredField("extraNotification");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(notification);
            Method declaredMethod = obj.getClass().getDeclaredMethod("setTargetPkg", new Class[]{CharSequence.class});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, new Object[]{str});
            return notification;
        } catch (Throwable e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return notification;
        }
    }

    private static PendingIntent a(Context context, af afVar, u uVar, byte[] bArr) {
        Intent intent;
        if (uVar != null && !TextUtils.isEmpty(uVar.g)) {
            intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(uVar.g));
            intent.addFlags(268435456);
            return PendingIntent.getActivity(context, 0, intent, 134217728);
        } else if (b(afVar)) {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent.putExtra("mipush_payload", bArr);
            intent.putExtra("mipush_notified", true);
            intent.addCategory(String.valueOf(uVar.q()));
            return PendingIntent.getService(context, 0, intent, 134217728);
        } else {
            Intent intent2 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
            intent2.setComponent(new ComponentName(afVar.f, "com.xiaomi.mipush.sdk.PushMessageHandler"));
            intent2.putExtra("mipush_payload", bArr);
            intent2.putExtra("mipush_notified", true);
            intent2.addCategory(String.valueOf(uVar.q()));
            return PendingIntent.getService(context, 0, intent2, 134217728);
        }
    }

    private static Bitmap a(Context context, int i) {
        return a(context.getResources().getDrawable(i));
    }

    public static Bitmap a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int i = 1;
        if (intrinsicWidth <= 0) {
            intrinsicWidth = 1;
        }
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight > 0) {
            i = intrinsicHeight;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    @SuppressLint({"NewApi"})
    private static a a(Context context, af afVar, byte[] bArr, RemoteViews remoteViews, PendingIntent pendingIntent) {
        com.xiaomi.push.service.al.b a;
        boolean z;
        long currentTimeMillis;
        String str;
        StringBuilder stringBuilder;
        Notification notification;
        a aVar = new a();
        u m = afVar.m();
        String a2 = a(afVar);
        Map s = m.s();
        Builder builder = new Builder(context);
        String[] a3 = a(context, m);
        builder.setContentTitle(a3[0]);
        builder.setContentText(a3[1]);
        if (remoteViews != null) {
            builder.setContent(remoteViews);
        } else if (VERSION.SDK_INT >= 16) {
            builder.setStyle(new BigTextStyle().bigText(a3[1]));
        }
        builder.setWhen(System.currentTimeMillis());
        Bitmap bitmap = null;
        Object obj = s == null ? null : (String) s.get("notification_show_when");
        if (!TextUtils.isEmpty(obj)) {
            builder.setShowWhen(Boolean.parseBoolean(obj));
        } else if (VERSION.SDK_INT >= 24) {
            builder.setShowWhen(true);
        }
        builder.setContentIntent(pendingIntent);
        int a4 = a(context, a2, "mipush_notification");
        int a5 = a(context, a2, "mipush_small_notification");
        if (a4 <= 0 || a5 <= 0) {
            builder.setSmallIcon(f(context, a2));
        } else {
            builder.setLargeIcon(a(context, a4));
            builder.setSmallIcon(a5);
        }
        String str2 = s == null ? null : (String) s.get("__dynamic_icon_uri");
        boolean z2 = s != null && Boolean.parseBoolean((String) s.get("__adiom"));
        if (!z2) {
            if (!f.b()) {
                a5 = 0;
                if (!(str2 == null || r3 == 0)) {
                    if (str2.startsWith(HttpConstant.HTTP)) {
                        bitmap = al.b(context, str2);
                    } else {
                        a = al.a(context, str2);
                        if (a != null) {
                            bitmap = a.a;
                            aVar.b = a.b;
                        }
                    }
                    if (bitmap != null) {
                        builder.setLargeIcon(bitmap);
                        z = true;
                        if (s != null && VERSION.SDK_INT >= 24) {
                            str2 = (String) s.get("notification_group");
                            z2 = Boolean.parseBoolean((String) s.get("notification_is_summary"));
                            com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroup", new Object[]{str2});
                            com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroupSummary", new Object[]{Boolean.valueOf(z2)});
                        }
                        builder.setAutoCancel(true);
                        currentTimeMillis = System.currentTimeMillis();
                        if (s != null && s.containsKey("ticker")) {
                            builder.setTicker((CharSequence) s.get("ticker"));
                        }
                        if (currentTimeMillis - a > 10000) {
                            a = currentTimeMillis;
                            a4 = m.f;
                            if (e(context, a2)) {
                                a4 = c(context, a2);
                            }
                            builder.setDefaults(a4);
                            if (!(s == null || (a4 & 1) == 0)) {
                                str = (String) s.get("sound_uri");
                                if (!TextUtils.isEmpty(str)) {
                                    stringBuilder = new StringBuilder("android.resource://");
                                    stringBuilder.append(a2);
                                    if (str.startsWith(stringBuilder.toString())) {
                                        builder.setDefaults(a4 ^ 1);
                                        builder.setSound(Uri.parse(str));
                                    }
                                }
                            }
                        }
                        notification = builder.getNotification();
                        if (z && f.a()) {
                            a(notification);
                        }
                        aVar.a = notification;
                        return aVar;
                    }
                }
                z = false;
                str2 = (String) s.get("notification_group");
                z2 = Boolean.parseBoolean((String) s.get("notification_is_summary"));
                com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroup", new Object[]{str2});
                com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroupSummary", new Object[]{Boolean.valueOf(z2)});
                builder.setAutoCancel(true);
                currentTimeMillis = System.currentTimeMillis();
                builder.setTicker((CharSequence) s.get("ticker"));
                if (currentTimeMillis - a > 10000) {
                    a = currentTimeMillis;
                    a4 = m.f;
                    if (e(context, a2)) {
                        a4 = c(context, a2);
                    }
                    builder.setDefaults(a4);
                    str = (String) s.get("sound_uri");
                    if (TextUtils.isEmpty(str)) {
                        stringBuilder = new StringBuilder("android.resource://");
                        stringBuilder.append(a2);
                        if (str.startsWith(stringBuilder.toString())) {
                            builder.setDefaults(a4 ^ 1);
                            builder.setSound(Uri.parse(str));
                        }
                    }
                }
                notification = builder.getNotification();
                a(notification);
                aVar.a = notification;
                return aVar;
            }
        }
        a5 = true;
        if (str2.startsWith(HttpConstant.HTTP)) {
            bitmap = al.b(context, str2);
        } else {
            a = al.a(context, str2);
            if (a != null) {
                bitmap = a.a;
                aVar.b = a.b;
            }
        }
        if (bitmap != null) {
            builder.setLargeIcon(bitmap);
            z = true;
            str2 = (String) s.get("notification_group");
            z2 = Boolean.parseBoolean((String) s.get("notification_is_summary"));
            com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroup", new Object[]{str2});
            com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroupSummary", new Object[]{Boolean.valueOf(z2)});
            builder.setAutoCancel(true);
            currentTimeMillis = System.currentTimeMillis();
            builder.setTicker((CharSequence) s.get("ticker"));
            if (currentTimeMillis - a > 10000) {
                a = currentTimeMillis;
                a4 = m.f;
                if (e(context, a2)) {
                    a4 = c(context, a2);
                }
                builder.setDefaults(a4);
                str = (String) s.get("sound_uri");
                if (TextUtils.isEmpty(str)) {
                    stringBuilder = new StringBuilder("android.resource://");
                    stringBuilder.append(a2);
                    if (str.startsWith(stringBuilder.toString())) {
                        builder.setDefaults(a4 ^ 1);
                        builder.setSound(Uri.parse(str));
                    }
                }
            }
            notification = builder.getNotification();
            a(notification);
            aVar.a = notification;
            return aVar;
        }
        z = false;
        str2 = (String) s.get("notification_group");
        z2 = Boolean.parseBoolean((String) s.get("notification_is_summary"));
        com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroup", new Object[]{str2});
        com.xiaomi.channel.commonutils.reflect.a.a(builder, "setGroupSummary", new Object[]{Boolean.valueOf(z2)});
        builder.setAutoCancel(true);
        currentTimeMillis = System.currentTimeMillis();
        builder.setTicker((CharSequence) s.get("ticker"));
        if (currentTimeMillis - a > 10000) {
            a = currentTimeMillis;
            a4 = m.f;
            if (e(context, a2)) {
                a4 = c(context, a2);
            }
            builder.setDefaults(a4);
            str = (String) s.get("sound_uri");
            if (TextUtils.isEmpty(str)) {
                stringBuilder = new StringBuilder("android.resource://");
                stringBuilder.append(a2);
                if (str.startsWith(stringBuilder.toString())) {
                    builder.setDefaults(a4 ^ 1);
                    builder.setSound(Uri.parse(str));
                }
            }
        }
        notification = builder.getNotification();
        a(notification);
        aVar.a = notification;
        return aVar;
    }

    public static b a(Context context, af afVar, byte[] bArr) {
        String stringBuilder;
        Context context2 = context;
        af afVar2 = afVar;
        byte[] bArr2 = bArr;
        b bVar = new b();
        if (com.xiaomi.channel.commonutils.android.a.c(context2, a(afVar)) == com.xiaomi.channel.commonutils.android.a.a.c) {
            StringBuilder stringBuilder2 = new StringBuilder("Do not notify because user block ");
            stringBuilder2.append(a(afVar));
            stringBuilder2.append("‘s notification");
            stringBuilder = stringBuilder2.toString();
        } else if (bg.a(context, afVar)) {
            stringBuilder = bg.a(afVar);
            StringBuilder stringBuilder3 = new StringBuilder("Do not notify because user block ");
            stringBuilder3.append(stringBuilder);
            stringBuilder3.append("‘s notification");
            stringBuilder = stringBuilder3.toString();
        } else {
            NotificationManager notificationManager = (NotificationManager) context2.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            u m = afVar.m();
            RemoteViews b = b(context, afVar, bArr);
            PendingIntent a = a(context2, afVar2, m, bArr2);
            if (a == null) {
                stringBuilder = "The click PendingIntent is null. ";
            } else {
                Notification notification;
                String str = null;
                if (VERSION.SDK_INT >= 11) {
                    a a2 = a(context2, afVar2, bArr2, b, a);
                    bVar.b = a2.b;
                    bVar.a = a(afVar);
                    notification = a2.a;
                } else {
                    notification = new Notification(f(context2, a(afVar)), null, System.currentTimeMillis());
                    String[] a3 = a(context2, m);
                    try {
                        notification.getClass().getMethod("setLatestEventInfo", new Class[]{Context.class, CharSequence.class, CharSequence.class, PendingIntent.class}).invoke(notification, new Object[]{context2, a3[0], a3[1], a});
                    } catch (Throwable e) {
                        com.xiaomi.channel.commonutils.logger.b.a(e);
                    }
                    Map s = m.s();
                    if (s != null && s.containsKey("ticker")) {
                        notification.tickerText = (CharSequence) s.get("ticker");
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - a > 10000) {
                        a = currentTimeMillis;
                        int i = m.f;
                        if (e(context2, a(afVar))) {
                            i = c(context2, a(afVar));
                        }
                        notification.defaults = i;
                        if (!(s == null || (i & 1) == 0)) {
                            String str2 = (String) s.get("sound_uri");
                            if (!TextUtils.isEmpty(str2)) {
                                StringBuilder stringBuilder4 = new StringBuilder("android.resource://");
                                stringBuilder4.append(a(afVar));
                                if (str2.startsWith(stringBuilder4.toString())) {
                                    notification.defaults = i ^ 1;
                                    notification.sound = Uri.parse(str2);
                                }
                            }
                        }
                    }
                    notification.flags |= 16;
                    if (b != null) {
                        notification.contentView = b;
                    }
                }
                if (f.a() && VERSION.SDK_INT >= 19) {
                    if (!TextUtils.isEmpty(m.b())) {
                        notification.extras.putString("message_id", m.b());
                    }
                    Object obj = m.u() == null ? null : (String) m.u().get("score_info");
                    if (!TextUtils.isEmpty(obj)) {
                        notification.extras.putString("score_info", obj);
                    }
                }
                if (m.s() != null) {
                    str = (String) m.s().get("message_count");
                }
                if (f.a() && str != null) {
                    try {
                        a(notification, Integer.parseInt(str));
                    } catch (Throwable e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
                if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
                    a(notification, a(afVar));
                }
                if ("com.xiaomi.xmsf".equals(a(afVar))) {
                    bg.a(context2, afVar2, notification);
                }
                int hashCode = ((a(afVar).hashCode() / 10) * 10) + m.q();
                notificationManager.notify(hashCode, notification);
                Pair pair = new Pair(Integer.valueOf(hashCode), afVar2);
                synchronized (b) {
                    try {
                        b.add(pair);
                        if (b.size() > 100) {
                            b.remove();
                        }
                    } catch (Throwable e22) {
                        Throwable th = e22;
                    }
                }
                return bVar;
            }
        }
        com.xiaomi.channel.commonutils.logger.b.a(stringBuilder);
        return bVar;
    }

    static String a(af afVar) {
        if ("com.xiaomi.xmsf".equals(afVar.f)) {
            u m = afVar.m();
            if (!(m == null || m.s() == null)) {
                String str = (String) m.s().get("miui_package_name");
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return afVar.f;
    }

    private static void a(Notification notification, int i) {
        Object a = com.xiaomi.channel.commonutils.reflect.a.a(notification, "extraNotification");
        if (a != null) {
            com.xiaomi.channel.commonutils.reflect.a.a(a, "setMessageCount", new Object[]{Integer.valueOf(i)});
        }
    }

    public static void a(Context context, String str, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        int hashCode = ((str.hashCode() / 10) * 10) + i;
        LinkedList linkedList = new LinkedList();
        if (i >= 0) {
            notificationManager.cancel(hashCode);
        }
        synchronized (b) {
            Iterator it = b.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                af afVar = (af) pair.second;
                if (afVar != null) {
                    CharSequence a = a(afVar);
                    if (i >= 0) {
                        if (hashCode == ((Integer) pair.first).intValue()) {
                            if (!TextUtils.equals(a, str)) {
                            }
                        }
                    } else if (i == -1 && TextUtils.equals(a, str)) {
                        notificationManager.cancel(((Integer) pair.first).intValue());
                    }
                    linkedList.add(pair);
                }
            }
            if (b != null) {
                b.removeAll(linkedList);
                a(context, linkedList);
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            LinkedList linkedList = new LinkedList();
            synchronized (b) {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    af afVar = (af) pair.second;
                    if (afVar != null) {
                        CharSequence a = a(afVar);
                        u m = afVar.m();
                        if (m != null && TextUtils.equals(a, str)) {
                            String h = m.h();
                            String j = m.j();
                            if (!TextUtils.isEmpty(h) && !TextUtils.isEmpty(j) && a(str2, h) && a(str3, j)) {
                                notificationManager.cancel(((Integer) pair.first).intValue());
                                linkedList.add(pair);
                            }
                        }
                    }
                }
                if (b != null) {
                    b.removeAll(linkedList);
                    a(context, linkedList);
                }
            }
        }
    }

    public static void a(Context context, LinkedList<? extends Object> linkedList) {
        if (linkedList != null && linkedList.size() > 0) {
            be.a(context, "category_clear_notification", "clear_notification", (long) linkedList.size(), "");
        }
    }

    public static boolean a(Context context, String str) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!str2.contains(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey("notify_foreground")) {
                return "1".equals((String) map.get("notify_foreground"));
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String[] a(android.content.Context r3, com.xiaomi.xmpush.thrift.u r4) {
        /*
        r0 = r4.h();
        r1 = r4.j();
        r4 = r4.s();
        if (r4 == 0) goto L_0x0073;
    L_0x000e:
        r2 = r3.getResources();
        r2 = r2.getDisplayMetrics();
        r2 = r2.widthPixels;
        r3 = r3.getResources();
        r3 = r3.getDisplayMetrics();
        r3 = r3.density;
        r2 = (float) r2;
        r2 = r2 / r3;
        r3 = 1056964608; // 0x3f000000 float:0.5 double:5.222099017E-315;
        r2 = r2 + r3;
        r3 = java.lang.Float.valueOf(r2);
        r3 = r3.intValue();
        r2 = 320; // 0x140 float:4.48E-43 double:1.58E-321;
        if (r3 > r2) goto L_0x0051;
    L_0x0033:
        r3 = "title_short";
        r3 = r4.get(r3);
        r3 = (java.lang.String) r3;
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x0042;
    L_0x0041:
        r0 = r3;
    L_0x0042:
        r3 = "description_short";
        r3 = r4.get(r3);
        r3 = (java.lang.String) r3;
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 != 0) goto L_0x0073;
    L_0x0050:
        goto L_0x0072;
    L_0x0051:
        r2 = 360; // 0x168 float:5.04E-43 double:1.78E-321;
        if (r3 <= r2) goto L_0x0073;
    L_0x0055:
        r3 = "title_long";
        r3 = r4.get(r3);
        r3 = (java.lang.String) r3;
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x0064;
    L_0x0063:
        r0 = r3;
    L_0x0064:
        r3 = "description_long";
        r3 = r4.get(r3);
        r3 = (java.lang.String) r3;
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 != 0) goto L_0x0073;
    L_0x0072:
        r1 = r3;
    L_0x0073:
        r3 = 2;
        r3 = new java.lang.String[r3];
        r4 = 0;
        r3[r4] = r0;
        r4 = 1;
        r3[r4] = r1;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ah.a(android.content.Context, com.xiaomi.xmpush.thrift.u):java.lang.String[]");
    }

    private static RemoteViews b(Context context, af afVar, byte[] bArr) {
        u m = afVar.m();
        String a = a(afVar);
        Map s = m.s();
        if (s == null) {
            return null;
        }
        String str = (String) s.get("layout_name");
        String str2 = (String) s.get("layout_value");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(a);
            int identifier = resourcesForApplication.getIdentifier(str, "layout", a);
            if (identifier == 0) {
                return null;
            }
            RemoteViews remoteViews = new RemoteViews(a, identifier);
            try {
                JSONObject jSONObject;
                Iterator keys;
                String str3;
                int identifier2;
                JSONObject jSONObject2 = new JSONObject(str2);
                if (jSONObject2.has("text")) {
                    jSONObject = jSONObject2.getJSONObject("text");
                    keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str3 = (String) keys.next();
                        CharSequence string = jSONObject.getString(str3);
                        identifier2 = resourcesForApplication.getIdentifier(str3, AgooConstants.MESSAGE_ID, a);
                        if (identifier2 > 0) {
                            remoteViews.setTextViewText(identifier2, string);
                        }
                    }
                }
                if (jSONObject2.has("image")) {
                    jSONObject = jSONObject2.getJSONObject("image");
                    keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        str3 = (String) keys.next();
                        String string2 = jSONObject.getString(str3);
                        identifier2 = resourcesForApplication.getIdentifier(str3, AgooConstants.MESSAGE_ID, a);
                        int identifier3 = resourcesForApplication.getIdentifier(string2, "drawable", a);
                        if (identifier2 > 0) {
                            remoteViews.setImageViewResource(identifier2, identifier3);
                        }
                    }
                }
                if (jSONObject2.has("time")) {
                    jSONObject = jSONObject2.getJSONObject("time");
                    Iterator keys2 = jSONObject.keys();
                    while (keys2.hasNext()) {
                        String str4 = (String) keys2.next();
                        str3 = jSONObject.getString(str4);
                        if (str3.length() == 0) {
                            str3 = "yy-MM-dd hh:mm";
                        }
                        int identifier4 = resourcesForApplication.getIdentifier(str4, AgooConstants.MESSAGE_ID, a);
                        if (identifier4 > 0) {
                            remoteViews.setTextViewText(identifier4, new SimpleDateFormat(str3).format(new Date(System.currentTimeMillis())));
                        }
                    }
                }
                return remoteViews;
            } catch (Throwable e) {
                com.xiaomi.channel.commonutils.logger.b.a(e);
                return null;
            }
        } catch (Throwable e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
            return null;
        }
    }

    public static void b(Context context, String str) {
        a(context, str, -1);
    }

    static void b(Context context, String str, int i) {
        context.getSharedPreferences("pref_notify_type", 0).edit().putInt(str, i).commit();
    }

    public static boolean b(af afVar) {
        u m = afVar.m();
        return m != null && m.w();
    }

    static int c(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).getInt(str, Integer.MAX_VALUE);
    }

    static void d(Context context, String str) {
        context.getSharedPreferences("pref_notify_type", 0).edit().remove(str).commit();
    }

    static boolean e(Context context, String str) {
        return context.getSharedPreferences("pref_notify_type", 0).contains(str);
    }

    private static int f(Context context, String str) {
        int a = a(context, str, "mipush_notification");
        int a2 = a(context, str, "mipush_small_notification");
        if (a <= 0) {
            a = a2 <= 0 ? context.getApplicationInfo().icon : a2;
        }
        return (a != 0 || VERSION.SDK_INT < 9) ? a : context.getApplicationInfo().logo;
    }
}
