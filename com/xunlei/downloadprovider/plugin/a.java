package com.xunlei.downloadprovider.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.model.PluginInfo;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;
import com.xunlei.xllib.b.g;
import java.io.File;

/* compiled from: XLPluginDownloadManager */
public class a {
    private static final String c = "a";
    float a = 0.0f;
    com.xunlei.downloadprovider.plugin.q.a b;
    private String d;
    private int e = 0;
    private boolean f;
    private com.xunlei.downloadprovider.plugin.b.a g;
    private XLAlertDialog h;
    private boolean i = false;
    private AsyncTask j = null;
    private Handler k;
    private Runnable l = new b(this);

    public a(String str, boolean z) {
        this.d = str;
        this.f = z;
        this.k = new Handler(Looper.getMainLooper());
    }

    public final void a(Context context) {
        p a = q.a().a(this.d);
        if (this.f) {
            this.i = RePlugin.isPluginInstalled(this.d);
        } else {
            this.i = false;
        }
        if (this.i) {
            int version;
            b();
            new StringBuilder("isPluginInstalled : ").append(this.d);
            PluginInfo pluginInfo = RePlugin.getPluginInfo(this.d);
            int version2 = pluginInfo.getVersion();
            pluginInfo = pluginInfo.getPendingUpdate();
            if (pluginInfo != null) {
                version = pluginInfo.getVersion();
                if (version2 < version) {
                    if (a != null) {
                        new StringBuilder("xlPluginInfo version : ").append(a.b);
                    }
                    if (a != null || a.b <= r1 || !b.a(BrothersApplication.getApplicationInstance())) {
                        new StringBuilder("不需要升级 ").append(this.d);
                        q.a().b(this.d);
                        q.a().a(null, false);
                        return;
                    } else if (!b.f(BrothersApplication.getApplicationInstance())) {
                        new StringBuilder("不是wifi环境，所以插件不下载 ").append(this.d);
                        b(7);
                        return;
                    } else if (this.j == null) {
                        a(context, a);
                        return;
                    } else {
                        return;
                    }
                }
            }
            version = version2;
            if (a != null) {
                new StringBuilder("xlPluginInfo version : ").append(a.b);
            }
            if (a != null) {
            }
            new StringBuilder("不需要升级 ").append(this.d);
            q.a().b(this.d);
            q.a().a(null, false);
            return;
        }
        new StringBuilder("plugin not install : ").append(this.d);
        if (a == null) {
            q.a().a(new g(this, context), false);
            return;
        }
        a(context, a);
        q.a().a(null, false);
    }

    private void a(Context context, p pVar) {
        if (!b.a(BrothersApplication.getApplicationInstance())) {
            b(1);
        } else if (!b.e(BrothersApplication.getApplicationInstance())) {
            a(pVar);
        } else if (context != null) {
            OnClickListener hVar = new h(this, pVar);
            pVar = new i(this);
            if (this.h == null) {
                this.h = new XLAlertDialog(context);
            }
            CharSequence string = context.getString(R.string.net_change_mobile_continus_tips);
            if (this.a > 1.0f) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append("（");
                stringBuilder.append((int) this.a);
                stringBuilder.append("M）");
                string = stringBuilder.toString();
            }
            this.h.setMessage(string);
            this.h.setCancelButtonText(context.getString(R.string.quit_dlg_left_str));
            this.h.setConfirmButtonText(context.getString(R.string.vod_dialog_logout_ok));
            this.h.setCanceledOnTouchOutside(true);
            this.h.setOnClickCancelButtonListener(new d(this, pVar));
            this.h.setOnClickConfirmButtonListener(new e(this, hVar));
            try {
                this.h.show();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        } else {
            a(pVar);
        }
    }

    private void a(p pVar) {
        StringBuilder stringBuilder = new StringBuilder("downloadAndInstallPlugin, name : ");
        stringBuilder.append(pVar.a);
        stringBuilder.append(" version : ");
        stringBuilder.append(pVar.b);
        if (b.a(BrothersApplication.getApplicationInstance())) {
            a(1);
            a jVar = new j(this, System.currentTimeMillis(), pVar, pVar.a);
            if (this.j == null) {
                this.j = new o(jVar).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new p[]{pVar});
            }
            return;
        }
        b(1);
    }

    private synchronized void a(p pVar, b bVar) throws RemoteException {
        int i;
        long currentTimeMillis = System.currentTimeMillis();
        String a = q.a(BrothersApplication.getApplicationInstance(), pVar.a);
        File file = new File(a);
        StringBuilder stringBuilder = new StringBuilder("doInstall, download plugin exists : ");
        stringBuilder.append(file.exists());
        stringBuilder.append(" : ");
        stringBuilder.append(a);
        int i2 = 0;
        if (g.a(file).equals(pVar.a())) {
            PluginInfo install = RePlugin.install(a);
            if ((install != null ? 1 : 0) != 0) {
                new StringBuilder("安装成功 : ").append(install.getName());
                RePlugin.preload(install);
                RePlugin.fetchClassLoader(install.getName());
                this.k.post(new n(this, i2, currentTimeMillis, pVar, bVar));
            } else {
                new StringBuilder("安装失败 : ").append(pVar.a);
                i = 5;
            }
        } else {
            new StringBuilder("MD5不匹配 ： ").append(pVar.a);
            i = 6;
        }
        i2 = i;
        this.k.post(new n(this, i2, currentTimeMillis, pVar, bVar));
    }

    private void a(int i) {
        if (this.b != null) {
            this.b.onPluginProgressUpdate(i);
        }
    }

    private void b() {
        if (this.b != null) {
            this.b.onPluginPrepared();
            this.b = null;
        }
    }

    private void b(int i) {
        q.a().b(this.d);
        if (this.b != null) {
            this.b.onPluginFail(i);
            this.b = 0;
        }
    }

    static /* synthetic */ void a(a aVar, Activity activity, int i, boolean z) {
        if (aVar.g == null) {
            aVar.g = new com.xunlei.downloadprovider.plugin.b.a(activity);
            if (aVar.i != null) {
                aVar.g.e.setText(R.string.plugin_download_tip_update);
            }
            aVar.g.f = new c(aVar);
        }
        if (aVar.g != null) {
            if (aVar.g.a() == null) {
                activity = aVar.g;
                if (z) {
                    activity.c.setFocusable(false);
                    activity.c.setOutsideTouchable(true);
                } else {
                    activity.c.setFocusable(false);
                    activity.c.setOutsideTouchable(false);
                }
                activity = aVar.g;
                if (!(!activity.c || activity.a() || activity.a.isFinishing())) {
                    activity.c.showAtLocation(activity.b, 17, 0, 0);
                }
            }
            aVar.g.d.setProgress((long) i);
        }
    }

    static /* synthetic */ void d(a aVar) {
        if (aVar.g != null && aVar.g.a()) {
            com.xunlei.downloadprovider.plugin.b.a aVar2 = aVar.g;
            if (!(aVar2.c == null || !aVar2.a() || aVar2.a.isFinishing())) {
                aVar2.c.dismiss();
            }
        }
        aVar.g = null;
    }

    static /* synthetic */ void b(a aVar, p pVar) {
        b kVar = new k(aVar);
        new StringBuilder("installPlugin() ").append(pVar.a);
        XLThreadPool.execute(new l(aVar, pVar, kVar));
    }
}
