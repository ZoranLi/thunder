package com.android.providers.downloads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.android.xlstat.a;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager$Property;
import com.xunlei.download.UpdateLibsSettingManager;
import com.xunlei.download.proguard.ak;
import com.xunlei.download.proguard.an;
import com.xunlei.download.proguard.j;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.parameter.InitParam;
import com.xunlei.vip_channel_v2.VipChannelV2Manager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XlTaskHelper extends BroadcastReceiver {
    public static final int a = 111141;
    public static final int b = 111085;
    private static final int c = 10000;
    private static XlTaskHelper d;
    private long e = 0;
    private boolean f = true;
    private boolean g = false;
    private Set<Long> h = new HashSet();
    private String[] i = new String[]{"libxl_stat.so", "libxluagc.so", "libxl_thunder_sdk.so"};
    private final String j = ShareConstants.SO_PATH;

    public static int b(int i) {
        return i < 9000 ? 491 : i;
    }

    public static synchronized XlTaskHelper a() {
        XlTaskHelper xlTaskHelper;
        synchronized (XlTaskHelper.class) {
            if (d == null) {
                d = new XlTaskHelper();
            }
            xlTaskHelper = d;
        }
        return xlTaskHelper;
    }

    public void a(Context context) {
        b();
        context.registerReceiver(this, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }

    public void b(Context context) {
        context.unregisterReceiver(this);
    }

    public void b() {
        this.f = true;
        this.g = false;
    }

    public static String a(int i) {
        StringBuilder stringBuilder = new StringBuilder("xl engine error: ");
        stringBuilder.append(i);
        return stringBuilder.toString();
    }

    public int a(Context context, Handler handler) {
        synchronized (this) {
            if (this.e > 0) {
                context = 9101;
            } else {
                XLDownloadManager instance;
                StringBuilder stringBuilder = new StringBuilder("initXLEngine() mInitRef = ");
                stringBuilder.append(this.e);
                an.b("DownloadManager", stringBuilder.toString());
                handler = DownloadManager.getInstanceFor(context).getDownloadlibPath();
                StringBuilder stringBuilder2 = new StringBuilder("initXLEngine() downloadlibSrcPath = ");
                stringBuilder2.append(handler);
                an.b("DownloadManager", stringBuilder2.toString());
                if (handler == null) {
                    instance = XLDownloadManager.getInstance(context);
                } else if (f(context) != null) {
                    handler = context.getDir(ShareConstants.SO_PATH, 0).getAbsolutePath();
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(handler);
                    stringBuilder3.append(File.separator);
                    instance = XLDownloadManager.getInstance(stringBuilder3.toString());
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(handler);
                    stringBuilder4.append(File.separator);
                    VipChannelV2Manager.getInstance(stringBuilder4.toString());
                    stringBuilder4 = new StringBuilder();
                    stringBuilder4.append(handler);
                    stringBuilder4.append(File.separator);
                    a.a(context, stringBuilder4.toString());
                    UpdateLibsSettingManager.setLoadLibStat(context, 2);
                } else {
                    throw new UnsatisfiedLinkError();
                }
                try {
                    handler = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                } catch (Handler handler2) {
                    handler2.printStackTrace();
                    handler2 = null;
                }
                InitParam initParam = new InitParam();
                handler2 = (handler2 == null || handler2.versionName == null) ? "1.0" : handler2.versionName;
                initParam.mAppVersion = handler2;
                initParam.mStatSavePath = context.getFilesDir().getPath();
                initParam.mStatCfgSavePath = context.getFilesDir().getPath();
                initParam.mPermissionLevel = 2;
                handler2 = instance.init(context, initParam);
                stringBuilder2 = new StringBuilder("initXLEngine() ret = ");
                stringBuilder2.append(handler2);
                an.b("DownloadManager", stringBuilder2.toString());
                if (9000 == handler2) {
                    instance.setOSVersion(VERSION.INCREMENTAL);
                    j.a(context);
                    Object property = DownloadManager.getInstanceFor(context).getProperty(DownloadManager$Property.PROP_USER_ID, "");
                    if (TextUtils.isEmpty(property)) {
                        XLDownloadManager.getInstance(context).setUserId("0");
                    } else {
                        XLDownloadManager.getInstance(context).setUserId(property);
                    }
                    d(context);
                    this.e++;
                }
                context = handler2;
            }
        }
        return context;
    }

    private void d(Context context) {
        DownloadManager instanceFor = DownloadManager.getInstanceFor(context);
        long downloadSpeedLimit = instanceFor.getDownloadSpeedLimit();
        long uploadSpeedLimit = instanceFor.getUploadSpeedLimit();
        if (downloadSpeedLimit > 0) {
            downloadSpeedLimit *= 1024;
        }
        if (uploadSpeedLimit > 0) {
            uploadSpeedLimit *= 1024;
        }
        XLDownloadManager.getInstance(context).setSpeedLimit(downloadSpeedLimit, uploadSpeedLimit);
    }

    public void c(Context context) {
        synchronized (this) {
            StringBuilder stringBuilder = new StringBuilder("uninitXLEngine() mInitRef = ");
            stringBuilder.append(this.e);
            an.b("DownloadManager", stringBuilder.toString());
            long j = this.e - 1;
            this.e = j;
            if (j == 0) {
                j.b(context);
                context = XLDownloadManager.getInstance(context);
                if (context != null) {
                    try {
                        context.uninit();
                    } catch (Context context2) {
                        StringBuilder stringBuilder2 = new StringBuilder("uninitXLEngine(), e=");
                        stringBuilder2.append(context2.toString());
                        an.b("DownloadManager", stringBuilder2.toString());
                        an.a(context2);
                    }
                }
                an.b("DownloadManager", "uninitXLEngine()");
            }
            if (this.e < 0) {
                this.e = 0;
            }
        }
    }

    public boolean a(NetworkInfo networkInfo) {
        StringBuilder stringBuilder = new StringBuilder("isCaptivePortal() info = ");
        stringBuilder.append(networkInfo);
        an.b("DownloadManager", stringBuilder.toString());
        if (networkInfo.getType() != 1) {
            return false;
        }
        synchronized (this) {
            if (this.f == null) {
                networkInfo = this.g;
                return networkInfo;
            }
            this.f = false;
            return this.g;
        }
    }

    private boolean a(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder("isCaptivePortal() mUrl = ");
        stringBuilder.append(str);
        stringBuilder.append(", expactRespCode = ");
        stringBuilder.append(i);
        an.b("DownloadManager", stringBuilder.toString());
        boolean z = false;
        HttpURLConnection httpURLConnection = null;
        try {
            str = (HttpURLConnection) new URL(str).openConnection();
            try {
                str.setInstanceFollowRedirects(false);
                str.setConnectTimeout(10000);
                str.setReadTimeout(10000);
                str.setUseCaches(false);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                str.getInputStream();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                int responseCode = str.getResponseCode();
                StringBuilder stringBuilder2 = new StringBuilder("isCaptivePortal() rspCode = ");
                stringBuilder2.append(responseCode);
                stringBuilder2.append(", elapsed=");
                stringBuilder2.append(elapsedRealtime2 - elapsedRealtime);
                an.b("DownloadManager", stringBuilder2.toString());
                if (responseCode != i) {
                    z = true;
                }
                if (str != null) {
                    new Thread(this) {
                        final /* synthetic */ XlTaskHelper b;

                        public void run() {
                            str.disconnect();
                        }
                    }.start();
                }
                return z;
            } catch (IOException e) {
                i = e;
                httpURLConnection = str;
                try {
                    i.printStackTrace();
                    an.a(i);
                    if (httpURLConnection != null) {
                        /* anonymous class already generated */.start();
                    }
                    return false;
                } catch (Throwable th) {
                    i = th;
                    str = httpURLConnection;
                    if (str != null) {
                        /* anonymous class already generated */.start();
                    }
                    throw i;
                }
            } catch (Throwable th2) {
                i = th2;
                if (str != null) {
                    /* anonymous class already generated */.start();
                }
                throw i;
            }
        } catch (IOException e2) {
            i = e2;
            i.printStackTrace();
            an.a(i);
            if (httpURLConnection != null) {
                /* anonymous class already generated */.start();
            }
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(intent.getAction()) != null) {
            this.f = true;
            if (e(context) == null) {
                c();
            }
        }
    }

    public static int a(long j, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        stringBuilder.append(str.trim());
        return stringBuilder.toString().hashCode();
    }

    public void a(long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("addMobileOnceTask");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (jArr != null) {
            synchronized (this.h) {
                for (long valueOf : jArr) {
                    this.h.add(Long.valueOf(valueOf));
                }
            }
        }
    }

    public void a(List<Long> list) {
        if (list != null) {
            StringBuilder stringBuilder = new StringBuilder("addMobileOnceTask");
            stringBuilder.append(Arrays.toString(list.toArray()));
            an.b("DownloadManager", stringBuilder.toString());
            synchronized (this.h) {
                this.h.addAll(list);
            }
        }
    }

    public void b(long... jArr) {
        StringBuilder stringBuilder = new StringBuilder("removeMobileOnceTask");
        stringBuilder.append(Arrays.toString(jArr));
        an.b("DownloadManager", stringBuilder.toString());
        if (jArr != null) {
            if (!this.h.isEmpty()) {
                synchronized (this.h) {
                    if (this.h.isEmpty()) {
                        return;
                    }
                    for (long valueOf : jArr) {
                        this.h.remove(Long.valueOf(valueOf));
                    }
                }
            }
        }
    }

    public void b(List<Long> list) {
        if (list != null) {
            StringBuilder stringBuilder = new StringBuilder("removeMobileOnceTask");
            stringBuilder.append(Arrays.toString(list.toArray()));
            an.b("DownloadManager", stringBuilder.toString());
            synchronized (this.h) {
                if (this.h.isEmpty()) {
                    return;
                }
                this.h.removeAll(list);
            }
        }
    }

    public boolean a(long j) {
        boolean contains;
        synchronized (this.h) {
            contains = this.h.contains(Long.valueOf(j));
        }
        StringBuilder stringBuilder = new StringBuilder("isMobileOnceTask id=");
        stringBuilder.append(j);
        stringBuilder.append(", res = ");
        stringBuilder.append(contains);
        an.b("DownloadManager", stringBuilder.toString());
        return contains;
    }

    public void c() {
        an.b("DownloadManager", "clearAllMobileOnceTask");
        synchronized (this.h) {
            this.h.clear();
        }
    }

    private boolean e(Context context) {
        context = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null) {
            return null;
        }
        return ak.a(context.getType());
    }

    private boolean f(Context context) {
        String downloadlibPath = DownloadManager.getInstanceFor(context).getDownloadlibPath();
        String absolutePath = context.getDir(ShareConstants.SO_PATH, 0).getAbsolutePath();
        context = UpdateLibsSettingManager.getLoadLibStat(context);
        if (context == null) {
            return false;
        }
        if (1 == context) {
            if (a(downloadlibPath) == null || a(downloadlibPath, absolutePath) == null) {
                return false;
            }
            return true;
        } else if (2 == context) {
            if (a(absolutePath) == null) {
                if (a(downloadlibPath, absolutePath) == null) {
                    return false;
                }
            }
            return true;
        } else {
            StringBuilder stringBuilder = new StringBuilder("isNeedCopyLibs() unknow command = ");
            stringBuilder.append(context);
            an.d("DownloadManager", stringBuilder.toString());
            return false;
        }
    }

    private boolean a(String str) {
        String[] strArr = this.i;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            File file = new File(str, strArr[i]);
            if (file.exists()) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("isLibsFileExist() lib is not exist ,libpath:");
                stringBuilder.append(file.getAbsolutePath());
                an.c("DownloadManager", stringBuilder.toString());
                return false;
            }
        }
        return true;
    }

    private boolean a(String str, String str2) {
        String[] strArr = this.i;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            String str3 = strArr[i];
            try {
                a(new File(str, str3), new File(str2, str3));
                i++;
            } catch (String str4) {
                str4.printStackTrace();
                return false;
            }
        }
        an.b("DownloadManager", "copyLibs success");
        return true;
    }

    public static void a(File file, File file2) throws IOException {
        FileChannel fileChannel = null;
        try {
            file = new FileInputStream(file).getChannel();
            try {
                file2 = new FileOutputStream(file2).getChannel();
            } catch (File file22) {
                fileChannel = file;
                file = file22;
                file22 = null;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (file22 != null) {
                    file22.close();
                }
                throw file;
            }
            try {
                file22.transferFrom(file, 0, file.size());
                if (file != null) {
                    file.close();
                }
                if (file22 != null) {
                    file22.close();
                }
            } catch (Throwable th) {
                Throwable th2 = th;
                fileChannel = file;
                file = th2;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (file22 != null) {
                    file22.close();
                }
                throw file;
            }
        } catch (Throwable th3) {
            file = th3;
            file22 = null;
            if (fileChannel != null) {
                fileChannel.close();
            }
            if (file22 != null) {
                file22.close();
            }
            throw file;
        }
    }
}
