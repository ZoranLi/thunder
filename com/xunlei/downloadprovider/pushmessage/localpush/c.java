package com.xunlei.downloadprovider.pushmessage.localpush;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.common.commonutil.DateUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v$c;
import com.xunlei.downloadprovider.pushmessage.bean.PushResult;
import com.xunlei.xllib.b.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: LocalPushManager */
final class c implements v$c {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    c(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    public final void a(List<VideoPlayRecord> list) {
        List list2 = list;
        n.a();
        List<z> g = n.g(0);
        Context context = this.a;
        if (!d.a(g)) {
            List list3;
            List list4;
            int i;
            int i2;
            List list5;
            long b = f.b(context, "task_local_push_last_show_time", 0);
            long currentTimeMillis = System.currentTimeMillis();
            boolean isTheSameDay = DateUtil.isTheSameDay(b, currentTimeMillis);
            if (g != null) {
                if (g.size() != 0) {
                    List<z> arrayList = new ArrayList();
                    int i3 = 0;
                    for (z zVar : g) {
                        if (k.a(zVar.c())) {
                            boolean exists;
                            VideoPlayRecord a;
                            TaskInfo c = zVar.c();
                            if (c != null) {
                                if (!TextUtils.isEmpty(c.mLocalFileName)) {
                                    exists = new File(c.mLocalFileName).exists();
                                    if (exists) {
                                        if (zVar.e() || !zVar.c().isUnseen()) {
                                            a = a.a(list2, zVar.c().mLocalFileName);
                                            if (a == null) {
                                                list3 = list4;
                                                if (((double) (((float) a.h) / ((float) a.g))) < 0.6d) {
                                                    arrayList.add(zVar);
                                                    i3++;
                                                }
                                            } else {
                                                list3 = list4;
                                                if (zVar.e()) {
                                                    arrayList.add(zVar);
                                                    i3++;
                                                }
                                            }
                                            list4 = list3;
                                        } else {
                                            arrayList.add(zVar);
                                            i3++;
                                        }
                                    }
                                }
                            }
                            exists = false;
                            if (exists) {
                                if (zVar.e()) {
                                }
                                a = a.a(list2, zVar.c().mLocalFileName);
                                if (a == null) {
                                    list3 = list4;
                                    if (zVar.e()) {
                                        arrayList.add(zVar);
                                        i3++;
                                    }
                                } else {
                                    list3 = list4;
                                    if (((double) (((float) a.h) / ((float) a.g))) < 0.6d) {
                                        arrayList.add(zVar);
                                        i3++;
                                    }
                                }
                                list4 = list3;
                            }
                        }
                        list3 = list4;
                        list4 = list3;
                    }
                    list3 = list4;
                    if (arrayList.size() != 0) {
                        int a2 = d.a(context, "local_push_time_size");
                        list4 = new ArrayList();
                        if (i3 != d.a(context, "local_unfinish_play_count")) {
                            d.a(context, "local_push_time_size", 0);
                            d.a(context, "local_unfinish_play_count", i3);
                            a2 = 0;
                        }
                        int[] a3 = a.a();
                        if (a2 < 4) {
                            StringBuilder stringBuilder;
                            String string;
                            String str;
                            long toMillis = TimeUnit.HOURS.toMillis((long) a3[a2]);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            for (z zVar2 : arrayList) {
                                if (a.a(currentTimeMillis2, zVar2.c().mCreateTime, toMillis)) {
                                    list4.add(zVar2);
                                }
                            }
                            if (!d.a(list4) || isTheSameDay) {
                                i = 2;
                                i2 = 0;
                                list5 = list3;
                            } else {
                                a2 = a.a(list4);
                                stringBuilder = new StringBuilder("showUnfinishPlayNoti: size = ");
                                stringBuilder.append(list4.size());
                                stringBuilder.append(", day = ");
                                stringBuilder.append(a2);
                                string = context.getString(R.string.local_download_unplay_title, new Object[]{Integer.valueOf(list4.size()), Integer.valueOf(a2)});
                                TaskInfo c2 = ((z) list4.get(list4.size() - 1)).c();
                                str = c2.mTitle;
                                if (str != null) {
                                    int lastIndexOf = str.lastIndexOf(46);
                                    if (lastIndexOf != -1) {
                                        str = str.substring(0, lastIndexOf);
                                    }
                                    if (str.length() > 12) {
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(str.substring(0, 12));
                                        stringBuilder.append("...");
                                        str = stringBuilder.toString();
                                    }
                                }
                                VideoPlayRecord a4 = a.a(list2, c2.mLocalFileName);
                                String str2 = "0%";
                                if (a4 != null) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append((int) ((((float) a4.h) / ((float) a4.g)) * 100.0f));
                                    stringBuilder.append("%");
                                    str2 = stringBuilder.toString();
                                }
                                String string2 = context.getString(R.string.local_play_unfinish_des, new Object[]{str, str2});
                                long taskId = c2.getTaskId();
                                e.a(PushResult.UNPLAY_NOTICE, "unplay_notice");
                                i = 2;
                                a.a(context, string, string2, PushResult.UNPLAY_NOTICE, "unplay_notice", taskId);
                                d.a(context, "local_push_time_size", d.a(context, "local_push_time_size") + 1);
                                f.a(context, "task_local_push_last_show_time", currentTimeMillis);
                                list5 = list3;
                                i2 = 1;
                            }
                            list5 = a.a(context, list5);
                            if (i2 == 0 && !d.a(list5) && !isTheSameDay) {
                                int a5 = a.a(list5);
                                StringBuilder stringBuilder2 = new StringBuilder("showUnfinishDownloadNoti: size = ");
                                stringBuilder2.append(list5.size());
                                stringBuilder2.append(", day = ");
                                stringBuilder2.append(a5);
                                Object[] objArr = new Object[i];
                                objArr[0] = Integer.valueOf(list5.size());
                                objArr[1] = Integer.valueOf(a5);
                                string = context.getString(R.string.local_download_unfinish_title, objArr);
                                TaskInfo c3 = ((z) list5.get(list5.size() - 1)).c();
                                StringBuilder stringBuilder3 = new StringBuilder();
                                stringBuilder3.append((int) ((((float) c3.mDownloadedSize) / ((float) c3.mFileSize)) * 100.0f));
                                stringBuilder3.append("%");
                                String stringBuilder4 = stringBuilder3.toString();
                                str = c3.mTitle;
                                if (str.length() > 12) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(str.substring(0, 12));
                                    stringBuilder.append("...");
                                    str = stringBuilder.toString();
                                }
                                Object[] objArr2 = new Object[i];
                                objArr2[0] = str;
                                objArr2[1] = stringBuilder4;
                                Context context2 = context;
                                a.a(context2, string, context.getString(R.string.local_download_unfinish_des, objArr2), PushResult.UNFINISH_DOWNLOAD_NOTICE, "unfinish_download_notice", c3.getTaskId());
                                e.a(PushResult.UNFINISH_DOWNLOAD_NOTICE, "unfinish_download_notice");
                                d.a(context, "local_push_time_size", d.a(context, "local_push_time_size") + 1);
                                f.a(context, "task_local_push_last_show_time", currentTimeMillis);
                                return;
                            }
                            return;
                        }
                    }
                    list4 = null;
                    if (d.a(list4)) {
                    }
                    i = 2;
                    i2 = 0;
                    list5 = list3;
                    list5 = a.a(context, list5);
                    if (i2 == 0) {
                    }
                }
            }
            list3 = g;
            list4 = null;
            if (d.a(list4)) {
            }
            i = 2;
            i2 = 0;
            list5 = list3;
            list5 = a.a(context, list5);
            if (i2 == 0) {
            }
        }
    }
}
