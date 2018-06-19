package com.igexin.push.core.a.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import com.igexin.push.config.m;
import com.igexin.push.core.a;
import com.igexin.push.core.b;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.o;
import com.igexin.push.core.f;
import com.igexin.push.core.g;
import com.igexin.sdk.PushConsts;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class l implements a {
    private static final String b = a.n;
    private static final String c = a.p;
    private static final String d = a.o;
    private PackageManager a;

    private String a(String str) {
        try {
            List<PackageInfo> installedPackages = g.f.getPackageManager().getInstalledPackages(4);
            if (installedPackages != null) {
                for (PackageInfo packageInfo : installedPackages) {
                    if (str.equals(packageInfo.packageName)) {
                        ServiceInfo[] serviceInfoArr = packageInfo.services;
                        int length = serviceInfoArr.length;
                        int i = 0;
                        while (i < length) {
                            ServiceInfo serviceInfo = serviceInfoArr[i];
                            if (!(b.equals(serviceInfo.name) || d.equals(serviceInfo.name))) {
                                if (!c.equals(serviceInfo.name)) {
                                    i++;
                                }
                            }
                            return serviceInfo.name;
                        }
                        continue;
                    }
                }
            }
        } catch (Exception e) {
            com.igexin.b.a.c.a.b(e.toString());
        }
        return null;
    }

    private List<String> a(int i, String str) {
        InputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        Exception exception;
        StringBuilder stringBuilder;
        Throwable th;
        String str2 = str;
        File file = new File("/sdcard/libs/");
        if (!file.exists()) {
            return null;
        }
        String[] list = file.list();
        if (list == null) {
            return null;
        }
        List<String> list2 = null;
        int i2 = 0;
        while (i2 < list.length) {
            if (!(list[i2].indexOf(".db") <= 0 || list[i2].equals("app.db") || list[i2].equals("imsi.db") || list[i2].equals("com.igexin.sdk.deviceId.db"))) {
                List<String> arrayList;
                try {
                    String substring = list[i2].substring(0, list[i2].length() - 3);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(file);
                    stringBuilder2.append("/");
                    stringBuilder2.append(list[i2]);
                    File file2 = new File(stringBuilder2.toString());
                    byte[] bArr = new byte[1024];
                    fileInputStream = new FileInputStream(file2);
                    try {
                        String str3;
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = fileInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                        String[] split = new String(com.igexin.b.a.a.a.c(byteArrayOutputStream.toByteArray(), com.igexin.b.b.a.a(g.t == null ? "cantgetimei" : g.t))).split("\\|");
                        PrintStream printStream = System.out;
                        StringBuilder stringBuilder3 = new StringBuilder("length=");
                        stringBuilder3.append(split.length);
                        printStream.println(stringBuilder3.toString());
                        if (split[0].startsWith("v")) {
                            if (split[0].contains("null")) {
                                split[0] = split[0].substring(7);
                            } else {
                                split[0] = split[0].substring(20);
                            }
                        }
                        if (split.length > 2) {
                            str3 = split[2];
                            if (str3 != null) {
                                if (str3.equals("null")) {
                                    str3 = null;
                                }
                                stringBuilder3 = new StringBuilder("WakeupAction get check form db file : ");
                                stringBuilder3.append(str3);
                                com.igexin.b.a.c.a.b(stringBuilder3.toString());
                            }
                        } else {
                            str3 = null;
                        }
                        if (str3 == null) {
                            str3 = com.igexin.b.b.a.a(split[0]);
                            stringBuilder3 = new StringBuilder("WakeupAction check cid form md5 session : ");
                            stringBuilder3.append(str3);
                            com.igexin.b.a.c.a.b(stringBuilder3.toString());
                        }
                        String str4 = str3;
                        if (i == 0) {
                            if (str2.equals(str4)) {
                                arrayList = new ArrayList();
                                try {
                                    arrayList.add(substring);
                                    try {
                                        fileInputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                        return arrayList;
                                    } catch (IOException e32) {
                                        e32.printStackTrace();
                                        return arrayList;
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    exception = e;
                                    try {
                                        stringBuilder = new StringBuilder("WakeupAction");
                                        stringBuilder.append(exception.toString());
                                        com.igexin.b.a.c.a.b(stringBuilder.toString());
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (IOException e322) {
                                                e322.printStackTrace();
                                            }
                                        }
                                        if (byteArrayOutputStream != null) {
                                            try {
                                                byteArrayOutputStream.close();
                                            } catch (IOException e3222) {
                                                e3222.printStackTrace();
                                            }
                                        }
                                        list2 = arrayList;
                                        i2++;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                            }
                        } else if (split.length > 1) {
                            if (str2.equals(split[1])) {
                                if (list2 == null) {
                                    list2 = new ArrayList();
                                }
                                list2.add(substring);
                            }
                            stringBuilder3 = new StringBuilder("check from appid=");
                            stringBuilder3.append(split[1]);
                            com.igexin.b.a.c.a.a("WakeupAction", stringBuilder3.toString());
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e32222) {
                            e32222.printStackTrace();
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e322222) {
                            e322222.printStackTrace();
                        }
                    } catch (Exception e5) {
                        e = e5;
                        byteArrayOutputStream = null;
                        arrayList = list2;
                        exception = e;
                        stringBuilder = new StringBuilder("WakeupAction");
                        stringBuilder.append(exception.toString());
                        com.igexin.b.a.c.a.b(stringBuilder.toString());
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        list2 = arrayList;
                        i2++;
                    } catch (Throwable th22) {
                        th = th22;
                        byteArrayOutputStream = null;
                    }
                } catch (Exception e6) {
                    e = e6;
                    byteArrayOutputStream = null;
                    fileInputStream = byteArrayOutputStream;
                    arrayList = list2;
                    exception = e;
                    stringBuilder = new StringBuilder("WakeupAction");
                    stringBuilder.append(exception.toString());
                    com.igexin.b.a.c.a.b(stringBuilder.toString());
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    list2 = arrayList;
                    i2++;
                } catch (Throwable th222) {
                    th = th222;
                    byteArrayOutputStream = null;
                    fileInputStream = byteArrayOutputStream;
                }
            }
            i2++;
        }
        if (list2 != null && list2.size() == 1) {
            StringBuilder stringBuilder4 = new StringBuilder("WakeupAction check finished, final pkg is  : ");
            stringBuilder4.append((String) list2.get(0));
            com.igexin.b.a.c.a.b(stringBuilder4.toString());
        }
        return list2;
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e3222222) {
                e3222222.printStackTrace();
            }
        }
        if (byteArrayOutputStream != null) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e32222222) {
                e32222222.printStackTrace();
            }
        }
        throw th;
        throw th;
        if (byteArrayOutputStream != null) {
            byteArrayOutputStream.close();
        }
        throw th;
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(g.f.getPackageName());
        stringBuilder.append("#");
        stringBuilder.append(str4);
        stringBuilder.append("#");
        stringBuilder.append(str5);
        stringBuilder.append("#");
        stringBuilder.append(RePlugin.PROCESS_UI);
        b("30025", stringBuilder.toString(), str, str2, str3);
        StringBuilder stringBuilder2 = new StringBuilder("feedback actionId=30025 result=");
        stringBuilder2.append(stringBuilder.toString());
        com.igexin.b.a.c.a.b(stringBuilder2.toString());
    }

    private void a(String str, boolean z, PushTaskBean pushTaskBean, BaseAction baseAction) {
        String messageId;
        String taskId;
        String a;
        StringBuffer stringBuffer;
        try {
            String a2 = a(str);
            messageId = pushTaskBean.getMessageId();
            taskId = pushTaskBean.getTaskId();
            a = ((o) baseAction).a();
            b(str);
            if (a2 != null) {
                StringBuilder stringBuilder;
                Map hashMap = new HashMap();
                hashMap.put(PushResult.MSG_ID, messageId);
                hashMap.put("taskId", taskId);
                hashMap.put(AgooConstants.MESSAGE_ID, a);
                hashMap.put("pkgName", str);
                stringBuffer = new StringBuffer();
                stringBuffer.append(g.f.getPackageName());
                stringBuffer.append("#");
                stringBuffer.append(d(str));
                stringBuffer.append("#");
                stringBuffer.append(str);
                stringBuffer.append("/");
                if (a2.equals(b)) {
                    stringBuffer.append(b);
                    stringBuffer.append("#");
                    if (a(str, b)) {
                        str = "0";
                    } else {
                        if (z) {
                            Intent intent = new Intent();
                            intent.setClassName(str, a2);
                            intent.putExtra("action", PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
                            intent.putExtra("op_app", g.e);
                            intent.putExtra("isSlave", true);
                            g.f.startService(intent);
                        } else if (!b(str, a2)) {
                            a(stringBuffer, messageId, taskId, a);
                            return;
                        }
                        hashMap.put("serviceName", b);
                        a(hashMap);
                        str = "1";
                    }
                } else if (a2.equals(d)) {
                    stringBuffer.append(d);
                    stringBuffer.append("#");
                    if (a(str, d)) {
                        str = "0";
                    } else if (b(str, a2)) {
                        hashMap.put("serviceName", d);
                        a(hashMap);
                        str = "1";
                    } else {
                        a(stringBuffer, messageId, taskId, a);
                        return;
                    }
                } else {
                    if (a2.equals(c)) {
                        stringBuffer.append(c);
                        stringBuffer.append("#");
                        if (a(str, c)) {
                            str = "0";
                        } else if (b(str, a2)) {
                            hashMap.put("serviceName", c);
                            a(hashMap);
                            str = "1";
                        } else {
                            a(stringBuffer, messageId, taskId, a);
                            return;
                        }
                    }
                    b("30025", stringBuffer.toString(), messageId, taskId, a);
                    stringBuilder = new StringBuilder("feedback actionId=30025 result=");
                    stringBuilder.append(stringBuffer.toString());
                    com.igexin.b.a.c.a.b(stringBuilder.toString());
                    return;
                }
                stringBuffer.append(str);
                b("30025", stringBuffer.toString(), messageId, taskId, a);
                stringBuilder = new StringBuilder("feedback actionId=30025 result=");
                stringBuilder.append(stringBuffer.toString());
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                return;
            }
            a(messageId, taskId, a, ((o) baseAction).d() != null ? ((o) baseAction).d() : "", ((o) baseAction).c() != null ? ((o) baseAction).c() : "");
        } catch (Exception e) {
            com.igexin.b.a.c.a.b(e.toString());
            a(stringBuffer, messageId, taskId, a);
        } catch (Throwable th) {
            StringBuilder stringBuilder2 = new StringBuilder("WakeupAction|");
            stringBuilder2.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder2.toString());
        }
    }

    private void a(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append(RePlugin.PROCESS_UI);
        b("30025", stringBuffer.toString(), str, str2, str3);
        StringBuilder stringBuilder = new StringBuilder("feedback actionId=30025 result=");
        stringBuilder.append(stringBuffer.toString());
        com.igexin.b.a.c.a.b(stringBuilder.toString());
    }

    private void a(Map<String, String> map) {
        f.a().a(new m(this, 180000, map));
    }

    public static boolean a(String str, String str2) {
        List runningServices = ((ActivityManager) g.f.getSystemService("activity")).getRunningServices(2000);
        if (runningServices.size() <= 0) {
            return false;
        }
        int i = 0;
        while (i < runningServices.size()) {
            if (((RunningServiceInfo) runningServices.get(i)).service.getClassName().equals(str2) && ((RunningServiceInfo) runningServices.get(i)).service.getPackageName().equals(str)) {
                return true;
            }
            i++;
        }
        return false;
    }

    private void b(String str) {
        if (c(str)) {
            try {
                ContentResolver contentResolver = g.f.getContentResolver();
                StringBuilder stringBuilder = new StringBuilder("content://downloads.");
                stringBuilder.append(str);
                stringBuilder.append("/download");
                Cursor query = contentResolver.query(Uri.parse(stringBuilder.toString()), null, null, null, null);
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                com.igexin.b.a.c.a.b(e.toString());
            }
        }
    }

    private void b(String str, String str2, String str3, String str4, String str5) {
        PushTaskBean pushTaskBean = new PushTaskBean();
        pushTaskBean.setAppid(g.a);
        pushTaskBean.setMessageId(str3);
        pushTaskBean.setTaskId(str4);
        pushTaskBean.setId(str5);
        pushTaskBean.setAppKey(g.b);
        com.igexin.push.core.a.f.a().a(pushTaskBean, str, str2);
    }

    private boolean b(String str, String str2) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, str2);
            g.f.startService(intent);
            return true;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("WakeupAction|");
            stringBuilder.append(e.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            return false;
        }
    }

    private boolean c(java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x0047 }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x0047 }
        r7.a = r1;	 Catch:{ Exception -> 0x0047 }
        r1 = r7.a;	 Catch:{ Exception -> 0x0047 }
        r2 = 8;	 Catch:{ Exception -> 0x0047 }
        r1 = r1.getPackageInfo(r8, r2);	 Catch:{ Exception -> 0x0047 }
        if (r1 != 0) goto L_0x0014;	 Catch:{ Exception -> 0x0047 }
    L_0x0013:
        return r0;	 Catch:{ Exception -> 0x0047 }
    L_0x0014:
        r1 = r1.providers;	 Catch:{ Exception -> 0x0047 }
        if (r1 == 0) goto L_0x0047;	 Catch:{ Exception -> 0x0047 }
    L_0x0018:
        r2 = r1.length;	 Catch:{ Exception -> 0x0047 }
        if (r2 != 0) goto L_0x001c;	 Catch:{ Exception -> 0x0047 }
    L_0x001b:
        return r0;	 Catch:{ Exception -> 0x0047 }
    L_0x001c:
        r2 = r1.length;	 Catch:{ Exception -> 0x0047 }
        r3 = r0;	 Catch:{ Exception -> 0x0047 }
    L_0x001e:
        if (r3 >= r2) goto L_0x0047;	 Catch:{ Exception -> 0x0047 }
    L_0x0020:
        r4 = r1[r3];	 Catch:{ Exception -> 0x0047 }
        r5 = r4.name;	 Catch:{ Exception -> 0x0047 }
        r6 = "com.igexin.download.DownloadProvider";	 Catch:{ Exception -> 0x0047 }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x0047 }
        if (r5 == 0) goto L_0x0044;	 Catch:{ Exception -> 0x0047 }
    L_0x002c:
        r4 = r4.authority;	 Catch:{ Exception -> 0x0047 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0047 }
        r6 = "downloads.";	 Catch:{ Exception -> 0x0047 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0047 }
        r5.append(r8);	 Catch:{ Exception -> 0x0047 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0047 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0047 }
        if (r4 == 0) goto L_0x0044;
    L_0x0042:
        r8 = 1;
        return r8;
    L_0x0044:
        r3 = r3 + 1;
        goto L_0x001e;
    L_0x0047:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.l.c(java.lang.String):boolean");
    }

    private java.lang.String d(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x0039 }
        r0 = r0.getPackageManager();	 Catch:{ Exception -> 0x0039 }
        r3.a = r0;	 Catch:{ Exception -> 0x0039 }
        r0 = r3.a;	 Catch:{ Exception -> 0x0039 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0039 }
        r4 = r0.getApplicationInfo(r4, r1);	 Catch:{ Exception -> 0x0039 }
        r4 = r4.metaData;	 Catch:{ Exception -> 0x0039 }
        if (r4 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x0039 }
    L_0x0014:
        r0 = r4.keySet();	 Catch:{ Exception -> 0x0039 }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x0039 }
    L_0x001c:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x0039 }
        if (r1 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x0039 }
    L_0x0022:
        r1 = r0.next();	 Catch:{ Exception -> 0x0039 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0039 }
        r2 = "PUSH_APPID";	 Catch:{ Exception -> 0x0039 }
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x0039 }
        if (r2 == 0) goto L_0x001c;	 Catch:{ Exception -> 0x0039 }
    L_0x0030:
        r4 = r4.get(r1);	 Catch:{ Exception -> 0x0039 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x0039 }
        return r4;
    L_0x0039:
        r4 = "";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.l.d(java.lang.String):java.lang.String");
    }

    public b a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return b.success;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            if (m.q && jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has("type") && (jSONObject.has("pkgname") || jSONObject.has("appid") || jSONObject.has("cid"))) {
                BaseAction oVar = new o();
                oVar.setType("wakeupsdk");
                oVar.setActionId(jSONObject.getString("actionid"));
                oVar.setDoActionId(jSONObject.getString("do"));
                if (jSONObject.has("pkgname")) {
                    oVar.b(jSONObject.getString("pkgname"));
                } else if (jSONObject.has("cid")) {
                    oVar.d(jSONObject.getString("cid"));
                } else if (jSONObject.has("appid")) {
                    oVar.c(jSONObject.getString("appid"));
                }
                if (jSONObject.has("is_forcestart")) {
                    oVar.a(jSONObject.getBoolean("is_forcestart"));
                }
                if (jSONObject.has(AgooConstants.MESSAGE_ID)) {
                    oVar.a(jSONObject.getString(AgooConstants.MESSAGE_ID));
                }
                return oVar;
            }
        } catch (JSONException e) {
            com.igexin.b.a.c.a.b(e.toString());
        }
        return null;
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (!(pushTaskBean == null || baseAction == null)) {
            int i;
            List<String> a;
            o oVar = (o) baseAction;
            String c = oVar.c();
            int i2 = 0;
            if (c == null && oVar.e() != null) {
                List a2 = a(0, oVar.e());
                if (a2 == null || a2.size() != 1) {
                    i = 0;
                    if (c != null) {
                        a(c, oVar.b(), pushTaskBean, baseAction);
                    } else if (oVar.d() != null) {
                        a = a(1, oVar.d());
                        if (a != null && a.size() > 0) {
                            for (String a3 : a) {
                                a(a3, oVar.b(), pushTaskBean, baseAction);
                            }
                        }
                        if (i2 == 0) {
                            a(pushTaskBean.getMessageId(), pushTaskBean.getTaskId(), oVar.a(), oVar.d() != null ? oVar.d() : "", oVar.c() != null ? oVar.c() : "");
                        }
                        if (!baseAction.getDoActionId().equals("")) {
                            com.igexin.push.core.a.f.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
                        }
                    }
                    i2 = i;
                    if (i2 == 0) {
                        if (oVar.d() != null) {
                        }
                        if (oVar.c() != null) {
                        }
                        a(pushTaskBean.getMessageId(), pushTaskBean.getTaskId(), oVar.a(), oVar.d() != null ? oVar.d() : "", oVar.c() != null ? oVar.c() : "");
                    }
                    if (baseAction.getDoActionId().equals("")) {
                        com.igexin.push.core.a.f.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
                    }
                } else {
                    c = (String) a2.get(0);
                }
            }
            i = true;
            if (c != null) {
                a(c, oVar.b(), pushTaskBean, baseAction);
            } else if (oVar.d() != null) {
                a = a(1, oVar.d());
                while (r2.hasNext()) {
                    a(a3, oVar.b(), pushTaskBean, baseAction);
                }
            }
            i2 = i;
            if (i2 == 0) {
                if (oVar.d() != null) {
                }
                if (oVar.c() != null) {
                }
                a(pushTaskBean.getMessageId(), pushTaskBean.getTaskId(), oVar.a(), oVar.d() != null ? oVar.d() : "", oVar.c() != null ? oVar.c() : "");
            }
            if (baseAction.getDoActionId().equals("")) {
                com.igexin.push.core.a.f.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
            }
        }
        return true;
    }
}
