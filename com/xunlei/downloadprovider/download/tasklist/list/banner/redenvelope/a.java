package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope;

import android.os.Environment;
import android.text.TextUtils;
import com.alipay.sdk.cons.c;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.list.banner.p;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RedEnvelopeBannerHelper */
public class a {
    private static a e;
    public List<RedPacketConditionsInfo> a;
    public List<Integer> b = new ArrayList();
    public boolean c = false;
    public boolean d = false;
    private DownloadTaskInfo f;

    /* compiled from: RedEnvelopeBannerHelper */
    public interface a {
        void a();

        void a(DownloadTaskInfo downloadTaskInfo, RedPacketConditionsInfo redPacketConditionsInfo, long j);

        void a(boolean z);
    }

    private a() {
    }

    public static a a() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    e = new a();
                }
            }
        }
        return e;
    }

    public static void a(long j) {
        new PreferenceHelper(BrothersApplication.getApplicationInstance(), "red_envelope_pfhelper").putBoolean(String.valueOf(j), true);
    }

    public static void a(TaskInfo taskInfo) {
        if (taskInfo != null) {
            if (!TextUtils.isEmpty(taskInfo.mTitle)) {
                new PreferenceHelper(BrothersApplication.getApplicationInstance(), "delete_task_on_red_envelope_show").putBoolean(taskInfo.mTitle, true);
            }
        }
    }

    public static com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a b(long j) {
        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a aVar = new com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a();
        int i = 0;
        if (j < 60) {
            j = (int) j;
        } else if (j % 60 == 0) {
            i = ((int) j) / 60;
            j = 0;
        } else {
            j = (int) j;
            i = j / 60;
            j %= 60;
        }
        if (i >= 10 || i < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i / 10);
            aVar.a = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(i % 10);
            aVar.b = stringBuilder.toString();
        } else {
            aVar.a = "0";
            aVar.b = String.valueOf(i);
        }
        if (j >= 10 || j < null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(j / 10);
            aVar.c = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(j % 10);
            aVar.d = stringBuilder.toString();
        } else {
            aVar.c = "0";
            aVar.d = String.valueOf(j);
        }
        return aVar;
    }

    public static String[] a(List<String> list) {
        String[] strArr = new String[list.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = (String) list.get(i);
        }
        return strArr;
    }

    public static long c(long j) {
        if (j < 0) {
            return 0;
        }
        return new PreferenceHelper(BrothersApplication.getApplicationInstance(), "red_envelope_first_count_down").getLong(String.valueOf(j), 0);
    }

    private static String d() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    private static boolean e() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long b() {
        String d = d();
        long j = 0;
        if (e()) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(absolutePath);
            stringBuilder.append("/xunlei/.redEnvelope");
            File file = new File(stringBuilder.toString());
            if (!file.exists()) {
                return 0;
            }
            try {
                InputStream fileInputStream = new FileInputStream(file);
                String readLine = new BufferedReader(new InputStreamReader(fileInputStream)).readLine();
                fileInputStream.close();
                if (!readLine.isEmpty()) {
                    String[] split = readLine.split(Constants.COLON_SEPARATOR);
                    if (split.length == 2) {
                        j = d.equals(split[0]) ? Long.parseLong(split[1]) : 0;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return j;
    }

    public static List<RedPacketConditionsInfo> c() {
        return a(f());
    }

    private static List<RedPacketConditionsInfo> a(JSONObject jSONObject) {
        List<RedPacketConditionsInfo> list = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            jSONObject = jSONObject.getJSONArray("redpacket_conditions");
            if (jSONObject != null) {
                List<RedPacketConditionsInfo> arrayList = new ArrayList();
                int i = 0;
                while (i < jSONObject.length()) {
                    try {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(i);
                        RedPacketConditionsInfo redPacketConditionsInfo = new RedPacketConditionsInfo();
                        redPacketConditionsInfo.count_down = jSONObject2.optString("count_down");
                        redPacketConditionsInfo.detatil_page_image = jSONObject2.optString("detatil_page_image");
                        redPacketConditionsInfo.detatil_page_subtitle = jSONObject2.optString("detatil_page_subtitle");
                        redPacketConditionsInfo.detatil_page_title = jSONObject2.optString("detatil_page_title");
                        redPacketConditionsInfo.list_page_image = jSONObject2.optString("list_page_image");
                        redPacketConditionsInfo.list_page_title = jSONObject2.optString("list_page_title");
                        redPacketConditionsInfo.name = jSONObject2.optString(c.e);
                        redPacketConditionsInfo.download_type = jSONObject2.optInt("opp");
                        redPacketConditionsInfo.limitSpeed = jSONObject2.optLong("network_speed");
                        JSONArray jSONArray = jSONObject2.getJSONArray("redpack_type");
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            redPacketConditionsInfo.redpack_type.add(jSONArray.optString(i2));
                        }
                        redPacketConditionsInfo.task_finish_count = jSONObject2.optString("task_finish_count");
                        redPacketConditionsInfo.user_type = jSONObject2.optString("user_type");
                        arrayList.add(redPacketConditionsInfo);
                        i++;
                    } catch (Exception e) {
                        jSONObject = e;
                        list = arrayList;
                    }
                }
                list = arrayList;
            }
        } catch (Exception e2) {
            jSONObject = e2;
            jSONObject.printStackTrace();
            return list;
        }
        return list;
    }

    private static org.json.JSONObject f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new com.xunlei.common.androidutil.PreferenceHelper;
        r1 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r2 = "redEnvelopeSP";
        r0.<init>(r1, r2);
        r1 = "redEnvelopeJson";	 Catch:{ Exception -> 0x001f }
        r2 = "";	 Catch:{ Exception -> 0x001f }
        r0 = r0.getString(r1, r2);	 Catch:{ Exception -> 0x001f }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x001f }
        if (r1 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x001f }
    L_0x0019:
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x001f }
        r1.<init>(r0);	 Catch:{ Exception -> 0x001f }
        return r1;
    L_0x001f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.f():org.json.JSONObject");
    }

    public static long d(long j) {
        if (j < 0) {
            return 0;
        }
        PreferenceHelper preferenceHelper = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "successTask");
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append("&");
        stringBuilder.append(j);
        return preferenceHelper.getLong(stringBuilder.toString(), 0);
    }

    public static long e(long j) {
        if (j < 0) {
            return 0;
        }
        PreferenceHelper preferenceHelper = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "runningTask");
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(format);
        stringBuilder.append("&");
        stringBuilder.append(j);
        return preferenceHelper.getLong(stringBuilder.toString(), 0);
    }

    public static void f(long j) {
        if (j >= 0) {
            PreferenceHelper preferenceHelper = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "runningTask");
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (e(j) == 0) {
                long j2 = preferenceHelper.getLong(format, 0) + 1;
                preferenceHelper.putLong(format, j2);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(format);
                stringBuilder.append("&");
                stringBuilder.append(j);
                preferenceHelper.putLong(stringBuilder.toString(), j2);
            }
        }
    }

    public static boolean a(DownloadTaskInfo downloadTaskInfo) {
        if (!BannerManager.a().a(BannerManager$BannerType.TYPE_RED_PACKET, downloadTaskInfo.getTaskId()) && d.a().l.a()) {
            boolean z;
            a();
            if (downloadTaskInfo != null) {
                if (!TextUtils.isEmpty(downloadTaskInfo.mTitle)) {
                    z = new PreferenceHelper(BrothersApplication.getApplicationInstance(), "delete_task_on_red_envelope_show").getBoolean(downloadTaskInfo.mTitle, false);
                    if (z) {
                        if (downloadTaskInfo.getTaskStatus() == 2) {
                            a();
                            if (new PreferenceHelper(BrothersApplication.getApplicationInstance(), "red_envelope_pfhelper").getBoolean(String.valueOf(downloadTaskInfo.getTaskId()), false) && BannerManager.a(downloadTaskInfo) != null) {
                                return true;
                            }
                        } else if (downloadTaskInfo.mIsFileMissing && downloadTaskInfo.getTaskStatus() == 8) {
                            return true;
                        } else {
                            return false;
                        }
                        return false;
                    }
                }
            }
            z = false;
            if (z) {
                if (downloadTaskInfo.getTaskStatus() == 2) {
                    a();
                    if (new PreferenceHelper(BrothersApplication.getApplicationInstance(), "red_envelope_pfhelper").getBoolean(String.valueOf(downloadTaskInfo.getTaskId()), false)) {
                        return false;
                    }
                    return true;
                } else if (downloadTaskInfo.mIsFileMissing) {
                }
                return false;
            }
        }
        return false;
    }

    public static void a(boolean z, long j, p pVar) {
        BannerManager.a().a(z, BannerManager$BannerType.TYPE_RED_PACKET, j, pVar);
    }

    public static boolean b(DownloadTaskInfo downloadTaskInfo) {
        return BannerManager.a().a(BannerManager$BannerType.TYPE_RED_PACKET, downloadTaskInfo.getTaskId());
    }

    public static void a(RedPacketConditionsInfo redPacketConditionsInfo, DownloadTaskInfo downloadTaskInfo, a aVar) {
        BannerManager.a();
        BannerManager.a(redPacketConditionsInfo, downloadTaskInfo, aVar);
    }

    public static void a(DownloadTaskInfo downloadTaskInfo, RedPacketConditionsInfo redPacketConditionsInfo, a aVar) {
        BannerManager.a();
        BannerManager.a(downloadTaskInfo, redPacketConditionsInfo, aVar);
    }

    static /* synthetic */ void g(long j) {
        long j2 = j + 1;
        j = d();
        if (e()) {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(absolutePath);
            stringBuilder.append("/xunlei/.redEnvelope");
            File file = new File(stringBuilder.toString());
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(j);
                stringBuilder2.append(Constants.COLON_SEPARATOR);
                stringBuilder2.append(j2);
                bufferedWriter.write(stringBuilder2.toString());
                bufferedWriter.close();
            } catch (long j3) {
                j3.printStackTrace();
            }
        }
    }
}
