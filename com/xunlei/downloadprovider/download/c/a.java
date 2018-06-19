package com.xunlei.downloadprovider.download.c;

import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.kernel.g;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.member.a.a.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.notification.c;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DownloadFreeTrialHelper */
public class a {
    public static int a = 0;
    public static int b = 1;
    public static int c = 2;
    public static int d = 3;
    private static a l;
    private static float m;
    public volatile long e = -1;
    public boolean f;
    public boolean g;
    public List<Long> h = new ArrayList();
    public int i = 0;
    public PreferenceHelper j = new PreferenceHelper(BrothersApplication.getApplicationInstance().getApplicationContext(), "freeTrialSP");
    public Map<Long, a> k = p();

    /* compiled from: DownloadFreeTrialHelper */
    public static class a {
        public long a = -1;
        public int b = -1;
        public long c = -1;
        public int d = -1;
        public boolean e;
        public long f = 0;

        public final JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("taskId", this.a);
                jSONObject.put("time", this.c);
                jSONObject.put(XiaomiOAuthConstants.EXTRA_STATE_2, this.b);
                jSONObject.put("closeFlag", this.d);
                jSONObject.put("noti", this.e);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static String i() {
        return "对不起,进入试用失败";
    }

    public static String j() {
        return "开通会员,畅享会员加速";
    }

    public static String n() {
        return "点击反馈";
    }

    public static a a() {
        if (l == null) {
            synchronized (a.class) {
                if (l == null) {
                    l = new a();
                }
            }
        }
        return l;
    }

    private a() {
    }

    public final boolean b() {
        if (this.k != null && this.e > 0 && ((a) this.k.get(Long.valueOf(this.e))).b > 0) {
            return true;
        }
        return false;
    }

    public final void c() {
        if (this.e > 0) {
            ((a) this.k.get(Long.valueOf(this.e))).b = b;
            this.j.putBoolean("isFreeTried", true);
        }
    }

    public final boolean a(long j) {
        if (this.k == null) {
            return false;
        }
        a aVar = (a) this.k.get(Long.valueOf(j));
        if (aVar == null || aVar.b <= a) {
            return false;
        }
        return 1;
    }

    public final boolean b(long j) {
        if (this.k == null) {
            return true;
        }
        a aVar = (a) this.k.get(Long.valueOf(j));
        if (aVar == null) {
            return false;
        }
        if (aVar.d != a) {
            if (aVar.d != c) {
                return false;
            }
        }
        return true;
    }

    private static Map<Long, a> p() {
        Map<Long, a> treeMap = new TreeMap();
        Object a = f.a(BrothersApplication.getApplicationInstance(), "trialed_tasks");
        if (TextUtils.isEmpty(a)) {
            return treeMap;
        }
        try {
            JSONArray jSONArray = new JSONObject(a).getJSONArray("tasks");
            long time = new Date().getTime();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                a aVar = new a();
                aVar.a = jSONObject.optLong("taskId", -1);
                aVar.d = jSONObject.optInt("closeFlag", -1);
                aVar.c = jSONObject.optLong("time", -1);
                aVar.b = jSONObject.optInt(XiaomiOAuthConstants.EXTRA_STATE_2, -1);
                aVar.e = jSONObject.optBoolean("noti", true);
                if (aVar.a > 0 && DateUtil.isTheSameDay(aVar.c, time)) {
                    treeMap.put(Long.valueOf(aVar.a), aVar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return treeMap;
    }

    public final void c(long j) {
        if (this.k != null && this.e > 0) {
            ((a) this.k.get(Long.valueOf(this.e))).f = j;
        }
    }

    public final long d() {
        if (this.k == null) {
            return -1;
        }
        if (this.e > 0) {
            return ((a) this.k.get(Long.valueOf(this.e))).f;
        }
        return 0;
    }

    public final void d(long j) {
        if (this.k != null) {
            this.e = j;
            if (j != -1) {
                a aVar = (a) this.k.get(Long.valueOf(this.e));
                if (aVar == null) {
                    aVar = new a();
                    aVar.a = j;
                    aVar.c = new Date().getTime();
                    aVar.b = a;
                    this.k.put(Long.valueOf(this.e), aVar);
                    return;
                }
                aVar.b = a;
            }
        }
    }

    public final void a(long j, int i) {
        if (this.k != null) {
            a aVar = (a) this.k.get(Long.valueOf(j));
            if (aVar != null) {
                aVar.b = i;
            }
        }
    }

    public final void b(long j, int i) {
        if (this.k != null) {
            a aVar = (a) this.k.get(Long.valueOf(j));
            if (aVar != null) {
                aVar.d = i;
            }
            StringBuilder stringBuilder = new StringBuilder("setCloseFlag ");
            stringBuilder.append(j);
            stringBuilder.append("  ");
            stringBuilder.append(i);
        }
    }

    public final boolean e(long j) {
        a aVar = (a) this.k.get(Long.valueOf(j));
        if (aVar == null || aVar.e == null) {
            return true;
        }
        return 0;
    }

    public final void f(long j) {
        a aVar = (a) this.k.get(Long.valueOf(j));
        if (aVar != null) {
            aVar.e = true;
        }
    }

    public final void a(List<TaskInfo> list) {
        if (this.k != null && this.e != -1 && !d.a(list)) {
            for (TaskInfo taskInfo : list) {
                if (taskInfo.getTaskId() == this.e) {
                    this.e = -1;
                    this.k.remove(Long.valueOf(taskInfo.getTaskId()));
                    return;
                }
            }
        }
    }

    public final void a(TaskInfo taskInfo) {
        List arrayList = new ArrayList();
        arrayList.add(taskInfo);
        a(arrayList);
    }

    public final void b(List<TaskInfo> list) {
        n.a();
        for (TaskInfo taskInfo : list) {
            if (!taskInfo.isTaskInvisible()) {
                taskInfo.mIsEnteredHighSpeedTrial = n.j(taskInfo.getTaskId());
                taskInfo.mFreeTrialTimes = n.i(taskInfo.getTaskId());
                if (this.e == taskInfo.getTaskId()) {
                    LoginHelper.a();
                    if (!(l.b() && LoginHelper.a().l()) && taskInfo.mIsEnteredHighSpeedTrial) {
                        n.a();
                        taskInfo.mFreeTrialRemainTime = (long) n.k(taskInfo.getTaskId());
                        new StringBuilder("  check free trial ----   free_remain time : ").append(taskInfo.mFreeTrialRemainTime);
                        if (k.k(taskInfo)) {
                            List arrayList = new ArrayList();
                            arrayList.add(taskInfo);
                            c a = c.a(BrothersApplication.getApplicationInstance());
                            Message obtainMessage = a.d.obtainMessage();
                            obtainMessage.obj = arrayList;
                            obtainMessage.what = 10001;
                            a.d.sendMessage(obtainMessage);
                        }
                    }
                }
            }
        }
    }

    public final void e() {
        n.a();
        n.l(this.e);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f() {
        /*
        r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r1 = com.xunlei.downloadprovider.member.login.b.l.b();
        if (r1 == 0) goto L_0x0019;
    L_0x000a:
        r1 = r0.l();
        if (r1 != 0) goto L_0x0018;
    L_0x0010:
        r0 = r0.g;
        r0 = r0.g();
        if (r0 == 0) goto L_0x0019;
    L_0x0018:
        return;
    L_0x0019:
        r0 = com.xunlei.downloadprovider.download.engine.task.n.a();
        if (r0 != 0) goto L_0x0020;
    L_0x001f:
        return;
    L_0x0020:
        r0 = com.xunlei.downloadprovider.download.engine.task.n.o();
        if (r0 != 0) goto L_0x002a;
    L_0x0026:
        r0 = 1;
        com.xunlei.downloadprovider.download.engine.task.n.d(r0);
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.c.a.f():void");
    }

    public final void g(long j) {
        n.a();
        LoginHelper.a();
        if (!(l.b() && LoginHelper.a().l())) {
            if (!n.o()) {
                n.d(true);
            }
            g.a().b.enterHighSpeedTrial(j);
        }
        LoginHelper.a();
        if (l.b()) {
            m = 0.2f;
        } else {
            m = 0.1f;
        }
        a(j, b);
    }

    public static float g() {
        return m;
    }

    public static String a(String str) {
        e.a();
        String a = b.a("after_trial-text");
        if (a == null || !a.contains("%s")) {
            a = "试用结束,会员%s内下完";
        }
        return String.format(a, new Object[]{str});
    }

    public final String h() {
        if (this.g && !o()) {
            return BrothersApplication.getApplicationInstance().getString(R.string.free_trial_share_guide_banner_title);
        }
        LoginHelper.a();
        if (!l.b()) {
            return "登录免费试用会员加速特权,下载更快";
        }
        e.a();
        return b.a("before_trial-text");
    }

    public static String b(String str) {
        e.a();
        String a = b.a("on_trial-text");
        if (a == null || !a.contains("%s")) {
            a = "会员加速:还剩%s,会员不限量";
        }
        return String.format(a, new Object[]{str});
    }

    public static String c(String str) {
        e.a();
        String a = b.a("ending_trial-text");
        if (a == null || !a.contains("%s")) {
            a = "试用将结束,会员%s内下完";
        }
        return String.format(a, new Object[]{str});
    }

    public static String k() {
        e.a();
        return b.a("after_trial-button");
    }

    public static String l() {
        e.a();
        return b.a("before_trial-button");
    }

    public static String m() {
        e.a();
        return b.a("on_trial-button");
    }

    public static boolean b(TaskInfo taskInfo) {
        return k.a(taskInfo, k.i(taskInfo));
    }

    public final void c(TaskInfo taskInfo) {
        taskInfo.mIsEnteredHighSpeedTrial = true;
        d(taskInfo.getTaskId());
        g(taskInfo.getTaskId());
        c(taskInfo.mDownloadedSize);
    }

    public final boolean d(TaskInfo taskInfo) {
        if (taskInfo.mFreeTrialTimes <= 0 || a(taskInfo.getTaskId())) {
            return false;
        }
        LoginHelper.a();
        if (!((l.b() && LoginHelper.a().l()) || k.d(taskInfo) || taskInfo.getTaskStatus() == 1 || taskInfo.getTaskStatus() == 16)) {
            if (taskInfo.getTaskStatus() != 1) {
                if (taskInfo.mFileSize < 209715200) {
                    return false;
                }
                if (taskInfo.mFileSize <= 0 || (((float) taskInfo.mDownloadedSize) * 1.0f) / ((float) taskInfo.mFileSize) <= 0.7f) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static boolean o() {
        return !LoginHelper.a().l() && com.xunlei.downloadprovider.download.tasklist.list.banner.c.f.a().c();
    }

    public static boolean a(DownloadTaskInfo downloadTaskInfo) {
        if (a().i >= com.xunlei.downloadprovider.d.d.a().d.m() && downloadTaskInfo.mFreeTrialTimes == com.xunlei.downloadprovider.d.d.a().d.n()) {
            return true;
        }
        return false;
    }
}
