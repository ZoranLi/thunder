package com.xunlei.downloadprovider.download.engine.kernel;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import com.igexin.sdk.PushConsts;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager$Property;
import com.xunlei.download.DownloadManager.DownloadManagerException;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/* compiled from: DownloadKernel */
public class g {
    public static final String a = "g";
    private static g f = new g();
    public DownloadManager b = null;
    public Context c;
    ConnectivityManager d;
    ContentResolver e;
    private NetworkReceiver g = new NetworkReceiver();

    private g() {
    }

    public static g a() {
        return f;
    }

    public final synchronized void b(Context context) {
        this.c = context.getApplicationContext();
        if (this.b == null) {
            if (d()) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(absolutePath);
                stringBuilder.append("/xunlei/ThunderdownDB");
                File file = new File(stringBuilder.toString());
                if (!(file.exists() && file.isDirectory())) {
                    file.mkdirs();
                }
                this.b = DownloadManager.getInstanceFor(context, null, new File(file, "xl_downloads.db"));
            } else {
                this.b = DownloadManager.getInstanceFor(context);
            }
            a(SettingStateController.getInstance().getTaskNum());
        }
        if (this.e == null) {
            this.e = context.getApplicationContext().getContentResolver();
        }
        if (this.d == null) {
            this.d = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        if (AndroidConfig.getAndroidVersion() >= 24) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            context.registerReceiver(this.g, intentFilter);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r2) {
        /*
        r1 = this;
        if (r2 <= 0) goto L_0x000b;
    L_0x0002:
        com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
        r0 = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.e();
        if (r2 <= r0) goto L_0x000c;
    L_0x000b:
        r2 = 3;
    L_0x000c:
        r0 = r1.b;
        if (r0 == 0) goto L_0x0015;
    L_0x0010:
        r0 = r1.b;
        r0.setRecommandMaxConcurrentDownloads(r2);
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.kernel.g.a(int):void");
    }

    public final long c() {
        if (this.b != null) {
            try {
                return this.b.getMaxDownloadSpeed();
            } catch (DownloadManagerException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public static boolean d() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static long[] a(List<Long> list) {
        int i = 0;
        int size = list == null ? 0 : list.size();
        long[] jArr = new long[size];
        if (size > 0) {
            while (i < size) {
                jArr[i] = ((Long) list.get(i)).longValue();
                i++;
            }
        }
        return jArr;
    }

    public final void a(boolean z) {
        if (this.b != null) {
            this.b.setHighSpeedTrialEnable(z);
        }
    }

    public final int a(long... jArr) {
        int i = 0;
        if (!(jArr == null || jArr.length == 0)) {
            if (this.b != null) {
                int i2;
                if (jArr.length > 50) {
                    i2 = 0;
                    while (i < jArr.length) {
                        int min = Math.min(50, jArr.length - i);
                        if (min > 0) {
                            i2 += this.b.pauseDownload(Arrays.copyOfRange(jArr, i, min + i));
                        }
                        i += 50;
                    }
                } else {
                    i2 = this.b.pauseDownload(jArr);
                }
                return i2;
            }
        }
        return 0;
    }

    public final int a(boolean z, long... jArr) {
        int i = 0;
        if (!(jArr == null || jArr.length == 0)) {
            if (this.b != null) {
                boolean z2;
                int i2;
                if (this.d.getActiveNetworkInfo() == null) {
                    z = false;
                    z2 = z;
                } else if (e() && z) {
                    z = true;
                    z2 = true;
                } else {
                    z = true;
                    z2 = false;
                }
                if (jArr.length > 50) {
                    i2 = 0;
                    while (i < jArr.length) {
                        int min = Math.min(50, jArr.length - i);
                        if (min > 0) {
                            long[] copyOfRange = Arrays.copyOfRange(jArr, i, min + i);
                            this.b.setAllowedNetworkTypes(z, copyOfRange);
                            i2 += this.b.resumeDownload(z2, copyOfRange);
                        }
                        i += 50;
                    }
                } else {
                    this.b.setAllowedNetworkTypes(z, jArr);
                    i2 = 0 + this.b.resumeDownload(z2, jArr);
                }
                return i2;
            }
        }
        return 0;
    }

    public final int b(boolean z, long... jArr) {
        int i = 0;
        if (!(jArr == null || jArr.length == 0)) {
            if (this.b != null) {
                int i2;
                if (jArr.length > 50) {
                    i2 = 0;
                    while (i < jArr.length) {
                        int min = Math.min(50, jArr.length - i);
                        if (min > 0) {
                            i2 += this.b.remove(z, Arrays.copyOfRange(jArr, i, min + i));
                        }
                        i += 50;
                    }
                } else {
                    i2 = this.b.remove(z, jArr);
                }
                return i2;
            }
        }
        return 0;
    }

    private int c(long... jArr) {
        int i = 0;
        if (!(jArr == null || jArr.length == 0)) {
            if (this.b != null) {
                int i2;
                this.b.setProperty(DownloadManager$Property.PROP_PRODUCT_ID, "0");
                if (jArr.length > 50) {
                    i2 = 0;
                    while (i < jArr.length) {
                        int min = Math.min(50, jArr.length - i);
                        if (min > 0) {
                            i2 += this.b.openVIPSpeedUp(Arrays.copyOfRange(jArr, i, min + i));
                        }
                        i += 50;
                    }
                } else {
                    i2 = this.b.openVIPSpeedUp(jArr);
                }
                return i2;
            }
        }
        return 0;
    }

    public final void b(long... jArr) {
        new StringBuilder("openDownloadSpeedup ").append(Arrays.toString(jArr));
        c(jArr);
    }

    public final String a(String str) {
        try {
            return this.b.getPlayUrl(str);
        } catch (String str2) {
            str2.getMessage();
            return null;
        }
    }

    public final void a(long j) {
        if (this.b != null) {
            this.b.setPlayTask(j);
        }
    }

    public final void a(long j, long j2) {
        if (this.b != null) {
            int playTask = this.b.setPlayTask(j, j2);
            StringBuilder stringBuilder = new StringBuilder("setPlayTask taskId=");
            stringBuilder.append(j);
            stringBuilder.append(", index = ");
            stringBuilder.append(j2);
            stringBuilder.append(", res=");
            stringBuilder.append(playTask);
        }
    }

    public final int c(boolean z, long... jArr) {
        if (!(jArr == null || jArr.length == 0)) {
            if (this.b != null) {
                if (this.d.getActiveNetworkInfo() != null) {
                    if (e() && z) {
                        a((int) true, jArr);
                    } else {
                        a((int) true, jArr);
                    }
                }
                return this.b.restartDownload(jArr);
            }
        }
        return false;
    }

    public final int b(long j, long j2) {
        if (j >= 0) {
            if (this.b != null) {
                return (int) this.b.setCustomFlags(j, j2);
            }
        }
        return 0;
    }

    public final int b(long j) {
        if (j >= 0) {
            if (this.b != null) {
                return this.b.setHideTaskVisible(j);
            }
        }
        return 0;
    }

    final int a(int i, long... jArr) {
        int i2 = 0;
        if (!(jArr == null || jArr.length == 0)) {
            if (this.b != null) {
                int i3;
                if (jArr.length > 50) {
                    i3 = 0;
                    while (i2 < jArr.length) {
                        int min = Math.min(50, jArr.length - i2);
                        if (min > 0) {
                            i3 += this.b.setAllowedNetworkTypes(i, Arrays.copyOfRange(jArr, i2, min + i2));
                        }
                        i2 += 50;
                    }
                } else {
                    i3 = this.b.setAllowedNetworkTypes(i, jArr);
                }
                return i3;
            }
        }
        return 0;
    }

    final boolean e() {
        NetworkInfo activeNetworkInfo = this.d.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return false;
        }
        int type = activeNetworkInfo.getType();
        if (!(type == 0 || type == 14)) {
            switch (type) {
                case 2:
                case 3:
                case 4:
                case 5:
                    break;
                default:
                    switch (type) {
                        case 10:
                        case 11:
                        case 12:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    public static DownloadManager b() {
        return f.b;
    }

    public static DownloadManager a(Context context) {
        if (f.b == null) {
            f.b(context);
        }
        return f.b;
    }
}
