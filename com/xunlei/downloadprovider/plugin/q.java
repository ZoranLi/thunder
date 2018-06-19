package com.xunlei.downloadprovider.plugin;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.android.volley.Request;
import com.qihoo360.replugin.RePlugin;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.net.volley.BaseJsonObjectRequest;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.d.a.f;
import com.xunlei.downloadprovider.member.payment.a.e.c;
import com.xunlei.downloadprovider.plugin.a.b$b;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: XLPluginManager */
public class q {
    public static final String a = VodPlayerActivityNew.class.getName();
    private static final String b = "q";
    private static q c = new q();
    private Map<String, p> d;
    private Map<String, a> e;

    /* compiled from: XLPluginManager */
    public interface a {
        void onPluginFail(int i);

        void onPluginPrepared();

        void onPluginProgressUpdate(int i);
    }

    private q() {
    }

    public static q a() {
        return c;
    }

    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getExternalCacheDir());
        stringBuilder.append(File.separator);
        stringBuilder.append(str.replace(".", "_"));
        stringBuilder.append(ShareConstants.PATCH_SUFFIX);
        return stringBuilder.toString();
    }

    public final p a(String str) {
        return this.d != null ? (p) this.d.get(str) : null;
    }

    public final void a(String str, c<p> cVar) {
        p a = a(str);
        if (a != null) {
            cVar.onSuccess(a);
        } else {
            a(new r(this, str, cVar), (boolean) null);
        }
    }

    public final void a(c<Map<String, p>> cVar, boolean z) {
        t tVar = new t();
        c sVar = new s(this, cVar);
        cVar = new StringBuilder();
        cVar.append(t.a);
        cVar.append("&rd=");
        cVar.append(f.a());
        c<Map<String, p>> baseJsonObjectRequest = new BaseJsonObjectRequest(0, cVar.toString(), null, new u(tVar, sVar), new v(tVar, sVar));
        baseJsonObjectRequest.setShouldCache(z);
        tVar.a((Request) baseJsonObjectRequest);
    }

    public final void a(String str, a aVar, boolean z) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        a aVar2 = (a) this.e.get(str);
        if (aVar2 == null) {
            aVar2 = new a(str, z);
            this.e.put(str, aVar2);
        }
        aVar2.b = aVar;
        aVar2.a((Context) null);
    }

    public final void b(String str) {
        if (this.e != null) {
            this.e.remove(str);
        }
    }

    public static boolean b() {
        return AppStatusChgObserver.b().a;
    }

    public static boolean a(Activity activity) {
        if (activity != null) {
            activity = activity.getComponentName();
            if (activity != null) {
                return a.equals(activity.getClassName());
            }
        }
        return null;
    }

    public final void a(Activity activity, String str, a aVar) {
        int i;
        if (this.e == null) {
            this.e = new HashMap();
        }
        a aVar2 = (a) this.e.get(str);
        boolean z = true;
        if (aVar2 == null) {
            aVar2 = new a(str, true);
            this.e.put(str, aVar2);
        }
        aVar2.b = new f(aVar2, activity, aVar);
        aVar = null;
        int hashCode = str.hashCode();
        if (hashCode != -1362935340) {
            if (hashCode != 764686919) {
                if (hashCode == 1423090855) {
                    if (str.equals("com.xunlei.plugin.qrcode") != null) {
                        z = true;
                        str = 1072064102;
                        switch (z) {
                            case false:
                                i = 1036831949;
                                break;
                            case true:
                            case true:
                                break;
                        }
                        str = aVar;
                        aVar2.a = str;
                        aVar2.a((Context) activity);
                    }
                }
            } else if (str.equals("com.xunlei.plugin.libdlna") != null) {
                str = 1072064102;
                switch (z) {
                    case false:
                        i = 1036831949;
                        break;
                    case true:
                    case true:
                        break;
                }
                str = aVar;
                aVar2.a = str;
                aVar2.a((Context) activity);
            }
        } else if (str.equals("com.xunlei.plugin.speeddetector") != null) {
            z = false;
            str = 1072064102;
            switch (z) {
                case false:
                    i = 1036831949;
                    break;
                case true:
                case true:
                    break;
            }
            str = aVar;
            aVar2.a = str;
            aVar2.a((Context) activity);
        }
        z = true;
        str = 1072064102;
        switch (z) {
            case false:
                i = 1036831949;
                break;
            case true:
            case true:
                break;
        }
        str = aVar;
        aVar2.a = str;
        aVar2.a((Context) activity);
    }

    public static void c() {
        RePlugin.registerGlobalBinder("com.xunlei.downloadprovider.ipc.download.IDownloadTaskManager", a$a.a);
        RePlugin.registerGlobalBinder("com.xunlei.plugin.thunder.IThunderMemberFacade", b$b.a);
    }
}
