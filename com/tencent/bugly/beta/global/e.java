package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.b;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.upgrade.BetaUploadStrategy;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.umeng.message.MsgConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BUGLY */
public class e {
    public static e E = new e();
    public static int a;
    public SharedPreferences A;
    public DisplayMetrics B;
    public boolean C = true;
    public boolean D = false;
    public BetaUploadStrategy F;
    public File G;
    public File H;
    public File I;
    public String J = "";
    public String K = "";
    public String L = "";
    public String M = "";
    public boolean N = false;
    public int O = 0;
    public String P = "";
    public boolean Q = false;
    public boolean R = true;
    public boolean S = false;
    public boolean T = true;
    public boolean U = true;
    public BetaPatchListener V;
    public boolean W = false;
    public boolean X = true;
    public boolean Y = false;
    public final List<String> Z = new ArrayList();
    public boolean aa = false;
    public boolean ab = false;
    public int ac = 1;
    public long b = 3000;
    public long c = 0;
    public boolean d = true;
    public boolean e = true;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public UILifecycleListener<UpgradeInfo> k;
    public File l;
    public final List<Class<? extends Activity>> m = new ArrayList();
    public final List<Class<? extends Activity>> n = new ArrayList();
    public int o;
    public b p;
    public DownloadListener q;
    public File r;
    public Context s;
    public File t;
    public String u;
    public String v;
    public int w = Integer.MIN_VALUE;
    public String x = "";
    public String y = "";
    public PackageInfo z;

    public synchronized void a(Context context) {
        StringBuilder stringBuilder;
        E.s = context.getApplicationContext();
        PackageManager packageManager = this.s.getPackageManager();
        try {
            this.z = packageManager.getPackageInfo(this.s.getPackageName(), 16384);
            if (this.w == Integer.MIN_VALUE) {
                this.w = this.z.versionCode;
            }
            if (TextUtils.isEmpty(this.x)) {
                this.x = this.z.versionName;
            }
            this.y = (String) this.z.applicationInfo.loadLabel(packageManager);
            if (TextUtils.isEmpty(this.P)) {
                this.P = a.a(this.s, "BUGLY_CHANNEL");
            }
        } catch (Throwable e) {
            if (!an.b(e)) {
                e.printStackTrace();
            }
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.B = new DisplayMetrics();
        if (!(windowManager == null || windowManager.getDefaultDisplay() == null)) {
            windowManager.getDefaultDisplay().getMetrics(this.B);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(this.s.getPackageName());
        stringBuilder2.append("/.beta/");
        String str = "/apk/";
        String str2 = "/res/";
        if (this.l != null) {
            if (this.l.exists()) {
                File file = this.l;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(stringBuilder2.toString());
                stringBuilder3.append(str);
                this.t = new File(file, stringBuilder3.toString());
                File file2 = this.l;
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append(stringBuilder2.toString());
                stringBuilder4.append(str2);
                this.r = new File(file2, stringBuilder4.toString());
                if (packageManager.checkPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE, this.z.packageName) != 0) {
                    try {
                        if ("mounted".equals(Environment.getExternalStorageState()) && (this.t.exists() || this.t.mkdirs())) {
                            if (!(this.r.exists() || this.r.mkdirs())) {
                            }
                            an.a("apkSaveDir: %s, resSaveDir: %s", this.t.getAbsolutePath(), this.r.getAbsolutePath());
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(context.getPackageName());
                            stringBuilder.append(".BETA_VALUES");
                            this.A = ap.a(stringBuilder.toString(), this.s);
                            this.C = a.b("isFirstRun", true);
                            if (this.C != null) {
                                a.a("isFirstRun", false);
                            }
                            if (a.b() != null) {
                                this.Q = a.b().I;
                            }
                            this.F = (BetaUploadStrategy) a.a("us.bch", BetaUploadStrategy.CREATOR);
                            if (this.F == null) {
                                this.F = new BetaUploadStrategy();
                            }
                        }
                    } catch (Throwable e2) {
                        if (!an.b(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                this.t = this.s.getExternalFilesDir("apk");
                this.r = this.s.getExternalFilesDir("res");
                if (this.t == null || !this.t.exists() || this.r == null || !this.r.exists()) {
                    this.t = this.s.getDir("apk", 2);
                    this.r = this.s.getDir("res", 0);
                }
                an.a("apkSaveDir: %s, resSaveDir: %s", this.t.getAbsolutePath(), this.r.getAbsolutePath());
                stringBuilder = new StringBuilder();
                stringBuilder.append(context.getPackageName());
                stringBuilder.append(".BETA_VALUES");
                this.A = ap.a(stringBuilder.toString(), this.s);
                this.C = a.b("isFirstRun", true);
                if (this.C != null) {
                    a.a("isFirstRun", false);
                }
                if (a.b() != null) {
                    this.Q = a.b().I;
                }
                this.F = (BetaUploadStrategy) a.a("us.bch", BetaUploadStrategy.CREATOR);
                if (this.F == null) {
                    this.F = new BetaUploadStrategy();
                }
            }
        }
        this.l = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), stringBuilder2.toString());
        this.t = new File(this.l, str);
        this.r = new File(this.l, str2);
        if (packageManager.checkPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE, this.z.packageName) != 0) {
        }
        if (packageManager.checkPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE, this.z.packageName) != 0) {
        }
        this.t = this.s.getExternalFilesDir("apk");
        this.r = this.s.getExternalFilesDir("res");
        this.t = this.s.getDir("apk", 2);
        this.r = this.s.getDir("res", 0);
        an.a("apkSaveDir: %s, resSaveDir: %s", this.t.getAbsolutePath(), this.r.getAbsolutePath());
        stringBuilder = new StringBuilder();
        stringBuilder.append(context.getPackageName());
        stringBuilder.append(".BETA_VALUES");
        this.A = ap.a(stringBuilder.toString(), this.s);
        this.C = a.b("isFirstRun", true);
        if (this.C != null) {
            a.a("isFirstRun", false);
        }
        if (a.b() != null) {
            this.Q = a.b().I;
        }
        this.F = (BetaUploadStrategy) a.a("us.bch", BetaUploadStrategy.CREATOR);
        if (this.F == null) {
            this.F = new BetaUploadStrategy();
        }
    }
}
