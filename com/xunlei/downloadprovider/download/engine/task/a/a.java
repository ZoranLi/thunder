package com.xunlei.downloadprovider.download.engine.task.a;

import android.support.annotation.NonNull;
import android.support.v4.util.LongSparseArray;
import android.text.TextUtils;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.kernel.b;
import com.xunlei.downloadprovider.download.engine.kernel.c;
import com.xunlei.downloadprovider.download.engine.shub.GcidInfo;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskRangeInfo;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CoreTaskImpl */
public final class a extends z implements com.xunlei.downloadprovider.download.engine.shub.b.a {
    boolean a = false;
    boolean b = false;
    public TaskInfo c;
    k d;
    private long e = -1;
    private List<BTSubTaskInfo> f;
    private a g;

    /* compiled from: CoreTaskImpl */
    private static class a implements b {
        LongSparseArray<BTSubTaskInfo> a;

        private a() {
            this.a = new LongSparseArray(3);
        }

        public final BTSubTaskInfo a(long j) {
            return (BTSubTaskInfo) this.a.get(j);
        }
    }

    public a(long j, @NonNull TaskInfo taskInfo) {
        this.c = taskInfo;
        this.e = j;
    }

    final synchronized void a(k kVar) {
        this.d = kVar;
    }

    public final long a() {
        return this.e;
    }

    public final int b() {
        return this.c != null ? this.c.getTaskStatus() : 1;
    }

    public final TaskInfo c() {
        return this.c;
    }

    public final boolean d() {
        return this.c != null ? this.c.isTaskInvisible() : false;
    }

    public final long f() {
        return this.c != null ? this.c.getCustomFlags() : 0;
    }

    public final synchronized <T> T a(java.lang.Class<T> r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        monitor-enter(r1);
        if (r2 == 0) goto L_0x0019;
    L_0x0003:
        r0 = r1.d;	 Catch:{ all -> 0x0016 }
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        goto L_0x0019;
    L_0x0008:
        r0 = r1.d;	 Catch:{ ClassCastException -> 0x0010 }
        r0 = r2.cast(r0);	 Catch:{ ClassCastException -> 0x0010 }
        monitor-exit(r1);
        return r0;
    L_0x0010:
        r2 = super.a(r2);	 Catch:{ all -> 0x0016 }
        monitor-exit(r1);
        return r2;
    L_0x0016:
        r2 = move-exception;
        monitor-exit(r1);
        throw r2;
    L_0x0019:
        r2 = 0;
        monitor-exit(r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.a.a(java.lang.Class):T");
    }

    public final List<BTSubTaskInfo> g() {
        if (this.f == null) {
            return Collections.emptyList();
        }
        return this.f;
    }

    public final BTSubTaskInfo b(int i) {
        if (i >= 0) {
            List<BTSubTaskInfo> g = g();
            if (g != null && g.size() > 0) {
                for (BTSubTaskInfo bTSubTaskInfo : g) {
                    if (bTSubTaskInfo.mBTSubIndex == i) {
                        return bTSubTaskInfo;
                    }
                }
            }
        }
        return 0;
    }

    final void i() {
        h();
        if (this.f != null) {
            if (this.g == null) {
                this.g = new a();
            }
            for (BTSubTaskInfo bTSubTaskInfo : this.f) {
                a aVar = this.g;
                long j = bTSubTaskInfo.mTaskId;
                if (bTSubTaskInfo != null) {
                    aVar.a.put(j, bTSubTaskInfo);
                }
            }
        }
    }

    public final void h() {
        if (this.c.mTaskType == TaskType.BT) {
            this.f = Collections.unmodifiableList(new c().a(BrothersApplication.getApplicationInstance(), this.c.getTaskId(), this.g));
            this.b = true;
        }
    }

    private static long[] a(List<TaskRangeInfo> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                long[] jArr = new long[(list.size() * 2)];
                int i = 0;
                for (TaskRangeInfo taskRangeInfo : list) {
                    jArr[i] = taskRangeInfo.getStartPosition();
                    jArr[i + 1] = taskRangeInfo.getLength();
                    i += 2;
                }
                return jArr;
            }
        }
        return null;
    }

    private static List<TaskRangeInfo> a(String str) {
        List<TaskRangeInfo> arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str)) {
                str = new JSONObject(str).getJSONArray("RangeInfo");
                if (str != null) {
                    if (str.length() != 0) {
                        for (int i = 0; i < str.length(); i++) {
                            TaskRangeInfo taskRangeInfo = new TaskRangeInfo();
                            JSONArray jSONArray = str.getJSONArray(i);
                            long j = jSONArray.getLong(0);
                            long j2 = jSONArray.getLong(1);
                            taskRangeInfo.setStartPosition(j);
                            taskRangeInfo.setLength(j2);
                            arrayList.add(taskRangeInfo);
                        }
                        return arrayList;
                    }
                }
                return arrayList;
            }
        } catch (String str2) {
            str2.printStackTrace();
        }
        return arrayList;
    }

    public final void a(GcidInfo gcidInfo) {
        if (gcidInfo != null && !TextUtils.isEmpty(gcidInfo.b)) {
            if (this.c.mExtraInfo == null) {
                this.c.syncExtraInfo();
            }
            if (this.c.mExtraInfo != null) {
                this.c.mExtraInfo.mCID = gcidInfo.a;
                this.c.mExtraInfo.mGCID = gcidInfo.b;
                String str = "UPDATE_GCID";
                if (this.d != null) {
                    this.d.a((z) this, str);
                }
            }
        }
    }

    public final long[] a(int i) {
        List list = null;
        String str;
        if (i >= 0) {
            if (!d.a(this.f)) {
                for (BTSubTaskInfo bTSubTaskInfo : this.f) {
                    if (i == bTSubTaskInfo.mBTSubIndex) {
                        break;
                    }
                }
            }
            BTSubTaskInfo bTSubTaskInfo2 = null;
            if (bTSubTaskInfo2 != null) {
                str = bTSubTaskInfo2.mRangeInfoStr;
                if (!TextUtils.isEmpty(str)) {
                    if (bTSubTaskInfo2.mCacheTaskRangeInfos == null || !bTSubTaskInfo2.mLastRangeInfoStr.equals(str)) {
                        list = a(str);
                        bTSubTaskInfo2.mLastRangeInfoStr = str;
                        if (bTSubTaskInfo2.mCacheTaskRangeInfos == 0) {
                            bTSubTaskInfo2.mCacheTaskRangeInfos = new ArrayList();
                        }
                        bTSubTaskInfo2.mCacheTaskRangeInfos.clear();
                        bTSubTaskInfo2.mCacheTaskRangeInfos.addAll(list);
                    } else {
                        list = bTSubTaskInfo2.mCacheTaskRangeInfos;
                    }
                }
            }
        } else {
            str = this.c.getRangeInfoStr();
            if (!TextUtils.isEmpty(str)) {
                if (this.c.mCacheTaskRangeInfos == null || !this.c.mLastRangeInfoStr.equals(str)) {
                    list = a(str);
                    this.c.mLastRangeInfoStr = str;
                    if (this.c.mCacheTaskRangeInfos == 0) {
                        this.c.mCacheTaskRangeInfos = new ArrayList();
                    }
                    this.c.mCacheTaskRangeInfos.clear();
                    if (d.a(list) == 0) {
                        this.c.mCacheTaskRangeInfos.addAll(list);
                    }
                } else {
                    list = this.c.mCacheTaskRangeInfos;
                }
            }
        }
        return a(list);
    }
}
