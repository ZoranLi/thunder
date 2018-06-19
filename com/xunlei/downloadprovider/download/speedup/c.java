package com.xunlei.downloadprovider.download.speedup;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.util.LongSparseArray;
import android.view.View;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: SpeedupHelper */
public final class c {
    private static LongSparseArray<Long> a = new LongSparseArray();
    private static LongSparseArray<Long> b = new LongSparseArray();

    public static boolean a(long j) {
        if (j >= 1) {
            if (j <= 360) {
                return true;
            }
        }
        return false;
    }

    public static void a(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background != null && (background instanceof AnimationDrawable)) {
            a aVar = new a((AnimationDrawable) view.getBackground());
            aVar.g = new d(view);
            aVar.a();
        }
    }

    public static void a(@NonNull TaskInfo taskInfo) {
        if (((Long) a.get(taskInfo.getTaskId(), Long.valueOf(0))).longValue() <= 0 && taskInfo.mDownloadedSize > 0 && taskInfo.mDownloadDurationTime > 0) {
            long j = (taskInfo.mDownloadedSize / taskInfo.mDownloadDurationTime) * 1000;
            StringBuilder stringBuilder = new StringBuilder("[calAvaNormalSpeedBeforeSpeedup] taskId=");
            stringBuilder.append(taskInfo.getTaskId());
            stringBuilder.append(", averageNormalSpeed=");
            stringBuilder.append(j);
            stringBuilder.append(" ,mDownloadDurationTime=");
            stringBuilder.append(taskInfo.mDownloadDurationTime);
            a.append(taskInfo.getTaskId(), Long.valueOf(j));
            b.append(taskInfo.getTaskId(), Long.valueOf(taskInfo.mDownloadDurationTime));
        }
    }

    public static long b(@NonNull TaskInfo taskInfo) {
        long longValue = ((Long) a.get(taskInfo.getTaskId(), Long.valueOf(0))).longValue();
        if (longValue <= 0) {
            return 0;
        }
        float f = (((float) taskInfo.mFileSize) * 1.0f) / ((float) ((5 * longValue) * 60));
        long longValue2 = ((Long) b.get(taskInfo.getTaskId(), Long.valueOf(0))).longValue();
        StringBuilder stringBuilder = new StringBuilder("[calSaveTimeAfterSpeedupFinish] filesize=");
        stringBuilder.append(taskInfo.mFileSize);
        stringBuilder.append(" ,taskId=");
        stringBuilder.append(taskInfo.getTaskId());
        stringBuilder.append(" ,normalAverageSpeed=");
        stringBuilder.append(longValue);
        stringBuilder.append(" ,saveTime=");
        stringBuilder.append(f);
        stringBuilder.append(" ,beforeSpeedupDownloadCost=");
        stringBuilder.append(longValue2);
        if (longValue < 204800 && longValue2 < 60000) {
            f = 0.0f;
        }
        return (long) f;
    }

    public static void c(TaskInfo taskInfo) {
        if (taskInfo != null) {
            a.remove(taskInfo.getTaskId());
            b.remove(taskInfo.getTaskId());
        }
    }
}
