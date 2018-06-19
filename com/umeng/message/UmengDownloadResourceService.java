package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.umeng.message.common.UmLog;
import com.umeng.message.entity.UMessage;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

public class UmengDownloadResourceService extends Service {
    public static final String TAG = "UmengDownloadResourceService";
    private static final String d = ".tmp";
    private static final String e = "RETRY_TIME";
    private static final String f = "OPERATIOIN";
    private static final int g = 1;
    private static final int h = 2;
    private static final long i = 1048576;
    private static final long j = 86400000;
    private static final int k = 300000;
    private static final int l = 3;
    private static Thread m;
    ScheduledThreadPoolExecutor a;
    Context b;
    ArrayList<String> c;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        this.a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4);
        this.b = this;
        this.c = new ArrayList();
    }

    @SuppressLint({"NewApi"})
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        int intExtra = intent.getIntExtra(f, 2);
        int intExtra2 = intent.getIntExtra(e, 3);
        try {
            UMessage uMessage = new UMessage(new JSONObject(intent.getStringExtra(AgooConstants.MESSAGE_BODY)));
            uMessage.message_id = intent.getStringExtra(AgooConstants.MESSAGE_ID);
            uMessage.task_id = intent.getStringExtra(AgooConstants.MESSAGE_TASK_ID);
            if (this.c.contains(uMessage.msg_id)) {
                return super.onStartCommand(intent, i, i2);
            }
            this.c.add(uMessage.msg_id);
            switch (intExtra) {
                case 1:
                    deleteAlarm(uMessage, intExtra2);
                    UmLog.i(TAG, "Show Notification After Downloaded Resource");
                    notification(uMessage);
                    this.c.remove(uMessage.msg_id);
                    if (this.c.size() == 0) {
                        stopSelf();
                        break;
                    }
                    break;
                case 2:
                    UmLog.i(TAG, "Start Download Resource");
                    intExtra2--;
                    setAlarm(uMessage, intExtra2);
                    checkCache();
                    downloadResource(uMessage, intExtra2);
                    break;
                default:
                    break;
            }
            return super.onStartCommand(intent, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void notification(UMessage uMessage) {
        UHandler adHandler;
        if (UMessage.DISPLAY_TYPE_NOTIFICATIONPULLAPP.equals(uMessage.display_type)) {
            adHandler = PushAgent.getInstance(this).getAdHandler();
        } else {
            adHandler = PushAgent.getInstance(this).getMessageHandler();
        }
        if (adHandler != null) {
            if (TextUtils.equals(UMessage.DISPLAY_TYPE_AUTOUPDATE, uMessage.display_type)) {
                UmengMessageHandler umengMessageHandler = (UmengMessageHandler) PushAgent.getInstance(this.b).getMessageHandler();
                if (umengMessageHandler != null) {
                    umengMessageHandler.dealWithNotificationMessage(this.b, uMessage);
                }
                return;
            }
            adHandler.handleMessage(this, uMessage);
        }
    }

    @SuppressLint({"NewApi"})
    public void downloadResource(UMessage uMessage, int i) {
        DownloadResourceTask downloadResourceTask = new DownloadResourceTask(this, uMessage, i);
        if (VERSION.SDK_INT >= 11) {
            downloadResourceTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            downloadResourceTask.execute(new Void[0]);
        }
    }

    public void setAlarm(UMessage uMessage, int i) {
        UmLog.i(TAG, "setAlarm");
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 300000, a(uMessage, i));
    }

    public void deleteAlarm(UMessage uMessage, int i) {
        UmLog.i(TAG, "deleteAlarm");
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(a(uMessage, i));
    }

    private PendingIntent a(UMessage uMessage, int i) {
        String jSONObject = uMessage.getRaw().toString();
        int hashCode = uMessage.msg_id.hashCode();
        Intent intent = new Intent(this.b, UmengDownloadResourceService.class);
        intent.putExtra(AgooConstants.MESSAGE_BODY, jSONObject);
        intent.putExtra(AgooConstants.MESSAGE_ID, uMessage.message_id);
        intent.putExtra(AgooConstants.MESSAGE_TASK_ID, uMessage.task_id);
        intent.putExtra(f, 2);
        intent.putExtra(e, i);
        PendingIntent service = PendingIntent.getService(this.b, hashCode, intent, 134217728);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("PendingIntent: msgId:");
        stringBuilder.append(uMessage.msg_id);
        stringBuilder.append(",requestCode:");
        stringBuilder.append(hashCode);
        stringBuilder.append(",retryTime:");
        stringBuilder.append(i);
        UmLog.i(str, stringBuilder.toString());
        return service;
    }

    public void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Closeable closeable2) {
                closeable2.printStackTrace();
            }
        }
    }

    public void checkCache() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = new java.io.File;	 Catch:{ Throwable -> 0x0016 }
        r1 = r5.b;	 Catch:{ Throwable -> 0x0016 }
        r2 = 0;	 Catch:{ Throwable -> 0x0016 }
        r1 = getMessageResourceFolder(r1, r2);	 Catch:{ Throwable -> 0x0016 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0016 }
        r1 = 1048576; // 0x100000 float:1.469368E-39 double:5.180654E-318;	 Catch:{ Throwable -> 0x0016 }
        r3 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Throwable -> 0x0016 }
        checkDir(r0, r1, r3);	 Catch:{ Throwable -> 0x0016 }
        return;
    L_0x0016:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UmengDownloadResourceService.checkCache():void");
    }

    public static void checkDir(File file, long j, long j2) throws IOException {
        if (file.exists() && a(file.getCanonicalFile()) > j) {
            if (m == null) {
                m = new Thread(new 1(file, j2));
            }
            synchronized (m) {
                m.start();
            }
        }
    }

    private static long a(File file) {
        long j = 0;
        if (file != null && file.exists()) {
            if (file.isDirectory()) {
                Stack stack = new Stack();
                stack.clear();
                stack.push(file);
                while (stack.isEmpty() == null) {
                    for (File file2 : ((File) stack.pop()).listFiles()) {
                        if (!file2.isDirectory()) {
                            j += file2.length();
                        }
                    }
                }
                return j;
            }
        }
        return 0;
    }

    private static void b(File file, long j) {
        if (file != null && file.exists() && file.canWrite()) {
            if (file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    if (!file2.isDirectory() && System.currentTimeMillis() - file2.lastModified() > j) {
                        file2.delete();
                    }
                }
            }
        }
    }

    public static String getMessageResourceFolder(Context context, UMessage uMessage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getCacheDir());
        stringBuilder.append("/umeng_push/");
        context = stringBuilder.toString();
        if (uMessage == null || uMessage.msg_id == null) {
            return context;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(context);
        stringBuilder.append(uMessage.msg_id);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }
}
