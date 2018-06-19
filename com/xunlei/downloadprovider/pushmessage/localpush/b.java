package com.xunlei.downloadprovider.pushmessage.localpush;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import com.xunlei.downloadprovider.download.engine.task.z;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* compiled from: LocalPushManager */
public class b {
    private static volatile b a;

    /* compiled from: LocalPushManager */
    private static class a {
        static List<z> a(Context context, List<z> list) {
            if (list != null) {
                if (list.size() != 0) {
                    List<z> arrayList = new ArrayList();
                    int i = 0;
                    for (z zVar : list) {
                        if (!(zVar.e() || 16 == zVar.b())) {
                            i++;
                            arrayList.add(zVar);
                        }
                    }
                    if (arrayList.size() == null) {
                        return null;
                    }
                    list = d.a(context, "local_push_time_size");
                    List<z> arrayList2 = new ArrayList();
                    if (i != d.a(context, "local_unfinish_download_count")) {
                        d.a(context, "local_push_time_size", 0);
                        d.a(context, "local_unfinish_download_count", i);
                        list = null;
                    }
                    context = a();
                    if (list >= 4) {
                        return null;
                    }
                    context = TimeUnit.HOURS.toMillis((long) context[list]);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (z zVar2 : arrayList) {
                        if (a(currentTimeMillis, zVar2.c().mCreateTime, context)) {
                            arrayList2.add(zVar2);
                        }
                    }
                    return arrayList2;
                }
            }
            return null;
        }

        static VideoPlayRecord a(List<VideoPlayRecord> list, String str) {
            if (list == null) {
                return null;
            }
            for (VideoPlayRecord videoPlayRecord : list) {
                if (TextUtils.equals(str, videoPlayRecord.e)) {
                    return videoPlayRecord;
                }
            }
            return null;
        }

        static int a(List<z> list) {
            if (d.a(list)) {
                return 1;
            }
            long j = 0;
            for (z zVar : list) {
                if (zVar.c().mCreateTime > j) {
                    j = zVar.c().mCreateTime;
                }
            }
            list = Calendar.getInstance();
            list.setTimeInMillis(j);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(System.currentTimeMillis());
            return instance.get(6) - list.get(6);
        }

        static int[] a() {
            return new int[]{18, 42, 90, Opcodes.DOUBLE_TO_INT};
        }

        static boolean a(long j, long j2, long j3) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j2);
            instance.add(6, 1);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            if (j >= instance.getTimeInMillis() + j3) {
                return true;
            }
            return false;
        }
    }

    public static b a() {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b();
                }
            }
        }
        return a;
    }

    private b() {
    }

    public final void a(Context context) {
        v.a().a(new c(this, context));
    }
}
