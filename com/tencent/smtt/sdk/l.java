package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class l {
    static boolean a = false;
    private static l c = null;
    private static int f = 0;
    private static int g = 0;
    private static int h = 3;
    private static String j;
    private ba b = null;
    private boolean d = false;
    private boolean e = false;
    private File i = null;

    private l() {
    }

    public static l a(boolean z) {
        if (c == null && z) {
            synchronized (l.class) {
                if (c == null) {
                    c = new l();
                }
            }
        }
        return c;
    }

    static void a(int i) {
        f = i;
    }

    private void b(int i) {
        String valueOf = String.valueOf(i);
        Properties properties = new Properties();
        properties.setProperty(j, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.i, "count.prop")), null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static int d() {
        return f;
    }

    private int i() {
        Exception exception;
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        try {
            File file = new File(this.i, "count.prop");
            if (!file.exists()) {
                return 0;
            }
            InputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream2);
                int intValue = Integer.valueOf(properties.getProperty(j, "1")).intValue();
                try {
                    bufferedInputStream2.close();
                    return intValue;
                } catch (IOException e) {
                    e.printStackTrace();
                    return intValue;
                }
            } catch (Exception e2) {
                InputStream inputStream = bufferedInputStream2;
                exception = e2;
                bufferedInputStream = inputStream;
                try {
                    exception.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return 0;
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            return 0;
                        }
                    }
                    return 0;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e32) {
                            e32.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            exception = e4;
            exception.printStackTrace();
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
                return 0;
            }
            return 0;
        }
    }

    public ba a() {
        return this.d ? this.b : null;
    }

    public synchronized void a(Context context, boolean z, boolean z2) {
        TbsLog.addLog(999, null, new Object[0]);
        TbsLog.initIfNeed(context);
        g++;
        TbsCoreLoadStat.getInstance().a();
        aj.a().b(context, g == 1);
        TbsShareManager.forceToLoadX5ForThirdApp(context, true);
        z = QbSdk.a(context, z, z2);
        z2 = VERSION.SDK_INT >= 7;
        boolean z3 = z && z2;
        if (!z3) {
            StringBuilder stringBuilder = new StringBuilder("can_load_x5=");
            stringBuilder.append(z);
            stringBuilder.append("; is_compatible=");
            stringBuilder.append(z2);
            String stringBuilder2 = stringBuilder.toString();
            stringBuilder = new StringBuilder("SDKEngine.init canLoadTbs=false; failure: ");
            stringBuilder.append(stringBuilder2);
            TbsLog.e("SDKEngine", stringBuilder.toString());
            if (!(QbSdk.a && this.d)) {
                this.d = false;
                TbsCoreLoadStat.getInstance().a(context, 405, new Throwable(stringBuilder2));
            }
        } else if (!this.d) {
            try {
                File file;
                File m;
                Context e;
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_THIRD_MODE, null, new Object[0]);
                    if (TbsShareManager.i(context)) {
                        file = new File(TbsShareManager.c(context));
                        m = aj.a().m(context);
                        e = TbsShareManager.e(context);
                        if (m == null) {
                            this.d = false;
                            QbSdk.a(context, "SDKEngine::useSystemWebView by error_tbs_core_dexopt_dir null!");
                            return;
                        }
                    }
                    this.d = false;
                    QbSdk.a(context, "SDKEngine::useSystemWebView by error_host_unavailable");
                    return;
                }
                TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_SELF_MODE, null, new Object[0]);
                file = aj.a().m(context);
                if (f != 25436) {
                    if (f != 25437) {
                        z2 = false;
                        e = z2 ? context.getApplicationContext() : context;
                        if (file != null) {
                            this.d = false;
                            QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                            return;
                        }
                        m = file;
                    }
                }
                z2 = true;
                if (z2) {
                }
                if (file != null) {
                    m = file;
                } else {
                    this.d = false;
                    QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
                    return;
                }
                Context context2 = e;
                this.b = new ba(context, context2, file.getAbsolutePath(), m.getAbsolutePath(), QbSdk.getDexLoaderFileList(context, context2, file.getAbsolutePath()), QbSdk.d);
                this.d = true;
            } catch (Throwable th) {
                stringBuilder = new StringBuilder("useSystemWebView by exception: ");
                stringBuilder.append(th);
                TbsLog.e("SDKEngine", stringBuilder.toString());
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.TEST_THROWABLE_ISNOT_NULL, th);
                this.d = false;
                StringBuilder stringBuilder3 = new StringBuilder("SDKEngine::useSystemWebView by exception: ");
                stringBuilder3.append(th);
                QbSdk.a(context, stringBuilder3.toString());
            }
        } else {
            return;
        }
        this.i = aj.o(context);
        this.e = true;
    }

    void a(String str) {
        j = str;
    }

    public boolean b() {
        return this.d;
    }

    boolean b(boolean z) {
        a = z;
        return z;
    }

    ba c() {
        return this.b;
    }

    public String e() {
        if (this.b != null) {
            if (!QbSdk.a) {
                return this.b.a();
            }
        }
        return "system webview get nothing...";
    }

    boolean f() {
        if (a) {
            if (j == null) {
                return false;
            }
            int i = i();
            if (i == 0) {
                b(1);
            } else {
                i++;
                if (i > h) {
                    return false;
                }
                b(i);
            }
        }
        return a;
    }

    boolean g() {
        return this.e;
    }

    public boolean h() {
        return QbSdk.useSoftWare();
    }
}
