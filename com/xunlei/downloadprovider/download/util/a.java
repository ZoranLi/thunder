package com.xunlei.downloadprovider.download.util;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.m;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.xllib.b.e;
import com.xunlei.xllib.b.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: DownloadCenterTaskUtil */
public abstract class a {

    /* compiled from: DownloadCenterTaskUtil */
    private static class a {
        private static final a c = new a();
        b<String> a = new b();
        b<String[]> b = new b();

        private a() {
        }

        public static a a() {
            return c;
        }

        static long a(long j) {
            if (j >= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                return (((((j * 10) * 10) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) + 5) / 10) * PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return j >= 1024 ? (((((j * 10) * 10) / 1024) + 5) / 10) * 1024 : j;
        }
    }

    /* compiled from: DownloadCenterTaskUtil */
    private static class b<T> {
        LruCache<Long, T> a;
        int b;
        int c;

        b() {
            this.a = new LruCache(100);
            this.b = 0;
            this.c = 0;
            this.a = new LruCache(100);
        }

        final T a(Long l) {
            l = this.a.get(l);
            if (l == null) {
                this.b++;
            } else {
                this.c++;
            }
            return l;
        }

        final void a(Long l, T t) {
            this.a.put(l, t);
        }

        final void a() {
            this.b = 0;
            this.c = 0;
        }

        public final String toString() {
            int i = this.c + this.b;
            i = i != 0 ? (100 * this.c) / i : 0;
            String format = String.format(Locale.getDefault(), "SpeedCache{ [maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.a.maxSize()), Integer.valueOf(this.c), Integer.valueOf(this.b), Integer.valueOf(i)});
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(format);
            stringBuilder.append(", mLRUCache=");
            stringBuilder.append(this.a);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public static void a(TaskInfo taskInfo, Context context) {
        if (taskInfo != null) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.addPrimaryClipChangedListener(new b(clipboardManager, context.getApplicationContext()));
                context = taskInfo.getTaskDownloadUrl();
                if (!k.b(context)) {
                    context = k.c(context);
                }
                m.a().a(context);
                ClipData newPlainText = ClipData.newPlainText("thunder", context);
                if (k.a(taskInfo)) {
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str = taskInfo.mTitle;
                        if (!str.contains(".")) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(str);
                            stringBuilder2.append(".mp4");
                            str = stringBuilder2.toString();
                        }
                        stringBuilder.append("thundertask://|file|");
                        stringBuilder.append(k.c(str, "UTF-8"));
                        stringBuilder.append("|size|");
                        stringBuilder.append(taskInfo.mFileSize);
                        stringBuilder.append("|url|");
                        stringBuilder.append(k.c(context, "UTF-8"));
                        taskInfo = ClipData.newPlainText("thunder", stringBuilder.toString());
                    } catch (TaskInfo taskInfo2) {
                        taskInfo2.printStackTrace();
                    }
                    clipboardManager.setPrimaryClip(taskInfo2);
                }
                taskInfo2 = newPlainText;
                clipboardManager.setPrimaryClip(taskInfo2);
            }
        }
    }

    public static List<String> a(Context context) {
        List arrayList = new ArrayList();
        try {
            context = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
            if (context != null && context.getItemCount() > 0) {
                for (int i = 0; i < context.getItemCount(); i++) {
                    CharSequence charSequence = null;
                    Item itemAt = context.getItemAt(i);
                    if (itemAt.getText() != null) {
                        charSequence = itemAt.getText().toString();
                    } else if (itemAt.getUri() != null) {
                        charSequence = itemAt.getUri().toString();
                    }
                    if (!TextUtils.isEmpty(charSequence)) {
                        arrayList.add(charSequence);
                    }
                }
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return arrayList;
    }

    public static String b(Context context) {
        try {
            context = ((ClipboardManager) context.getSystemService("clipboard")).getPrimaryClip();
            if (context == null || context.getItemCount() <= 0) {
                return null;
            }
            context.toString();
            context = context.getItemAt(0);
            if (context.getText() != null) {
                context = context.getText().toString();
            } else if (context.getUri() == null) {
                return null;
            } else {
                context = context.getUri().toString();
            }
            return context;
        } catch (Context context2) {
            context2.printStackTrace();
            return null;
        }
    }

    public static String a(long j) {
        a a = a.a();
        long a2 = a.a(j);
        String str = (String) a.a.a(Long.valueOf(a2));
        int i = a.a.b;
        int i2 = a.a.c;
        long j2 = (long) (i + i2);
        if (j2 % 20 == 0) {
            StringBuilder stringBuilder = new StringBuilder("convertSpeedText - ");
            stringBuilder.append(j2);
            stringBuilder.append("/");
            stringBuilder.append(a.a);
        }
        if (str != null) {
            return str;
        }
        if (i > 500 || (i > i2 && j2 > ((long) a.a.a.maxSize()))) {
            a.a.a.evictAll();
            a.a.a();
        }
        j = e.a(j, 1, e.c, false);
        a.a.a(Long.valueOf(a2), j);
        return j;
    }

    public static String[] b(long j) {
        a a = a.a();
        long a2 = a.a(j);
        String[] strArr = (String[]) a.b.a(Long.valueOf(a2));
        int i = a.b.b;
        int i2 = a.b.c;
        long j2 = (long) (i + i2);
        if (j2 % 20 == 0) {
            StringBuilder stringBuilder = new StringBuilder("convertSpeedTextComponent - ");
            stringBuilder.append(j2);
            stringBuilder.append("/");
            stringBuilder.append(a.b);
        }
        if (strArr != null) {
            return strArr;
        }
        if (i > 500 || (i > i2 && j2 > ((long) a.b.a.maxSize()))) {
            a.b.a.evictAll();
            a.b.a();
        }
        j = e.b(j, 1, e.c, false);
        a.b.a(Long.valueOf(a2), j);
        return j;
    }

    public static String c(long j) {
        return e.a(j, 1, e.a);
    }

    public static String a(DownloadTaskInfo downloadTaskInfo, Context context) {
        if (!TextUtils.isEmpty(downloadTaskInfo.mDisplayName)) {
            return downloadTaskInfo.mDisplayName;
        }
        String str = downloadTaskInfo.mTitle;
        if (XLFileTypeUtil.getFileCategoryTypeByName(downloadTaskInfo.mLocalFileName) == EFileCategoryType.E_SOFTWARE_CATEGORY && 8 == downloadTaskInfo.getTaskStatus()) {
            if (TextUtils.isEmpty(downloadTaskInfo.mAppName)) {
                context = ApkHelper.getApkInfo(context, downloadTaskInfo.mLocalFileName);
                if (context != null) {
                    context = context.getApkLabel();
                    if (context != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(context.toString());
                        stringBuilder.append(ShareConstants.PATCH_SUFFIX);
                        downloadTaskInfo.mAppName = stringBuilder.toString();
                        str = downloadTaskInfo.mAppName;
                        downloadTaskInfo.mDisplayName = str;
                    }
                }
            } else {
                str = downloadTaskInfo.mAppName;
            }
        }
        return str;
    }

    public static String a(String str) {
        String replaceAll;
        PatternSyntaxException patternSyntaxException;
        int lastIndexOf;
        String substring;
        try {
            replaceAll = Pattern.compile("(?:(?i)www|(?i)http).*?(?i)com", 2).matcher(str).replaceAll("");
            try {
                str = replaceAll.replaceAll("\\(.*\\)", "");
                str = str.replaceAll("\\[.*\\]", "");
            } catch (String str2) {
                String str3 = replaceAll;
                patternSyntaxException = str2;
                str2 = str3;
                patternSyntaxException.printStackTrace();
                lastIndexOf = str2.lastIndexOf(".");
                if (lastIndexOf != -1) {
                    try {
                        substring = str2.substring(lastIndexOf + 1);
                        replaceAll = str2.substring(0, lastIndexOf);
                        try {
                            str2 = replaceAll.replaceAll(substring, "");
                        } catch (Exception e) {
                            str2 = e;
                            str2.printStackTrace();
                            str2 = replaceAll;
                            replaceAll = str2.replaceAll("(?i)720p|(?i)1080p|(?i)1080i|(?i)1280p|1280", "");
                            str2 = replaceAll.replaceAll("(?i)BD|(?i)HD|(?i)TC|(?i)TS|(?i)TV", "");
                            replaceAll = str2.replaceAll(" ", "");
                            str2 = replaceAll.replaceAll("天空树|字幕|组|中日|中文|英文|英语|超清|高清|清晰|标清|国语|中字|国粤语|国粤双语|双语|中英|双字|阳光|免费下载|首发|电影天堂|电影|完整|剪辑", "");
                            replaceAll = str2.replaceAll("(?i)Skytree|(?i)dvd|(?i)gb_jp|(?i)quot|(?i)x264|(?i)h264|(?i)ac3|(?i)rarbt|(?i)bt|(?i)czw", "");
                            return replaceAll.replaceAll("[_`~!@#\\$%\\^&\\*\\(\\)\\+=\\|\\{\\}':;,\\-\\[\\]\\.<>/\\?！￥…（）—【】‘；：”“’。，、？]", "");
                        }
                    } catch (Exception e2) {
                        Exception exception = e2;
                        replaceAll = str2;
                        str2 = exception;
                        str2.printStackTrace();
                        str2 = replaceAll;
                        replaceAll = str2.replaceAll("(?i)720p|(?i)1080p|(?i)1080i|(?i)1280p|1280", "");
                        str2 = replaceAll.replaceAll("(?i)BD|(?i)HD|(?i)TC|(?i)TS|(?i)TV", "");
                        replaceAll = str2.replaceAll(" ", "");
                        str2 = replaceAll.replaceAll("天空树|字幕|组|中日|中文|英文|英语|超清|高清|清晰|标清|国语|中字|国粤语|国粤双语|双语|中英|双字|阳光|免费下载|首发|电影天堂|电影|完整|剪辑", "");
                        replaceAll = str2.replaceAll("(?i)Skytree|(?i)dvd|(?i)gb_jp|(?i)quot|(?i)x264|(?i)h264|(?i)ac3|(?i)rarbt|(?i)bt|(?i)czw", "");
                        return replaceAll.replaceAll("[_`~!@#\\$%\\^&\\*\\(\\)\\+=\\|\\{\\}':;,\\-\\[\\]\\.<>/\\?！￥…（）—【】‘；：”“’。，、？]", "");
                    }
                }
                replaceAll = str2.replaceAll("(?i)720p|(?i)1080p|(?i)1080i|(?i)1280p|1280", "");
                str2 = replaceAll.replaceAll("(?i)BD|(?i)HD|(?i)TC|(?i)TS|(?i)TV", "");
                replaceAll = str2.replaceAll(" ", "");
                str2 = replaceAll.replaceAll("天空树|字幕|组|中日|中文|英文|英语|超清|高清|清晰|标清|国语|中字|国粤语|国粤双语|双语|中英|双字|阳光|免费下载|首发|电影天堂|电影|完整|剪辑", "");
                replaceAll = str2.replaceAll("(?i)Skytree|(?i)dvd|(?i)gb_jp|(?i)quot|(?i)x264|(?i)h264|(?i)ac3|(?i)rarbt|(?i)bt|(?i)czw", "");
                return replaceAll.replaceAll("[_`~!@#\\$%\\^&\\*\\(\\)\\+=\\|\\{\\}':;,\\-\\[\\]\\.<>/\\?！￥…（）—【】‘；：”“’。，、？]", "");
            }
        } catch (PatternSyntaxException e3) {
            patternSyntaxException = e3;
            patternSyntaxException.printStackTrace();
            lastIndexOf = str2.lastIndexOf(".");
            if (lastIndexOf != -1) {
                substring = str2.substring(lastIndexOf + 1);
                replaceAll = str2.substring(0, lastIndexOf);
                str2 = replaceAll.replaceAll(substring, "");
            }
            replaceAll = str2.replaceAll("(?i)720p|(?i)1080p|(?i)1080i|(?i)1280p|1280", "");
            str2 = replaceAll.replaceAll("(?i)BD|(?i)HD|(?i)TC|(?i)TS|(?i)TV", "");
            replaceAll = str2.replaceAll(" ", "");
            str2 = replaceAll.replaceAll("天空树|字幕|组|中日|中文|英文|英语|超清|高清|清晰|标清|国语|中字|国粤语|国粤双语|双语|中英|双字|阳光|免费下载|首发|电影天堂|电影|完整|剪辑", "");
            replaceAll = str2.replaceAll("(?i)Skytree|(?i)dvd|(?i)gb_jp|(?i)quot|(?i)x264|(?i)h264|(?i)ac3|(?i)rarbt|(?i)bt|(?i)czw", "");
            return replaceAll.replaceAll("[_`~!@#\\$%\\^&\\*\\(\\)\\+=\\|\\{\\}':;,\\-\\[\\]\\.<>/\\?！￥…（）—【】‘；：”“’。，、？]", "");
        }
        lastIndexOf = str2.lastIndexOf(".");
        if (lastIndexOf != -1) {
            substring = str2.substring(lastIndexOf + 1);
            replaceAll = str2.substring(0, lastIndexOf);
            str2 = replaceAll.replaceAll(substring, "");
        }
        try {
            replaceAll = str2.replaceAll("(?i)720p|(?i)1080p|(?i)1080i|(?i)1280p|1280", "");
            try {
                str2 = replaceAll.replaceAll("(?i)BD|(?i)HD|(?i)TC|(?i)TS|(?i)TV", "");
                replaceAll = str2.replaceAll(" ", "");
                str2 = replaceAll.replaceAll("天空树|字幕|组|中日|中文|英文|英语|超清|高清|清晰|标清|国语|中字|国粤语|国粤双语|双语|中英|双字|阳光|免费下载|首发|电影天堂|电影|完整|剪辑", "");
                replaceAll = str2.replaceAll("(?i)Skytree|(?i)dvd|(?i)gb_jp|(?i)quot|(?i)x264|(?i)h264|(?i)ac3|(?i)rarbt|(?i)bt|(?i)czw", "");
                return replaceAll.replaceAll("[_`~!@#\\$%\\^&\\*\\(\\)\\+=\\|\\{\\}':;,\\-\\[\\]\\.<>/\\?！￥…（）—【】‘；：”“’。，、？]", "");
            } catch (Exception e4) {
                str2 = e4;
                str2.printStackTrace();
                return replaceAll;
            }
        } catch (Exception e22) {
            exception = e22;
            replaceAll = str2;
            str2 = exception;
            str2.printStackTrace();
            return replaceAll;
        }
    }

    public static String a(Context context, long j) {
        if (j > TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            return context.getResources().getString(2131362305);
        }
        StringBuilder stringBuilder;
        if (j < 60) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(j));
            stringBuilder.append("秒");
            j = stringBuilder.toString();
        } else if (j < 3600) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(String.valueOf(j / 60));
            stringBuilder2.append("分钟");
            j = stringBuilder2.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(j / 3600));
            stringBuilder.append("小时");
            j = stringBuilder.toString();
        }
        return context.getResources().getString(R.string.download_item_task_remain_time, new Object[]{j});
    }
}
