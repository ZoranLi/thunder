package com.taobao.accs.client;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.ILoginInfo;
import com.taobao.accs.a.a$a;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class GlobalClientInfo {
    public static final String AGOO_SERVICE_ID = "agooSend";
    public static final boolean SUPPORT_AUTO_UNIT = false;
    public static Context a = null;
    public static IAgooAppReceiver b = null;
    public static String c = null;
    public static boolean d = false;
    private static volatile GlobalClientInfo e;
    private static Map<String, String> m;
    private ConcurrentHashMap<String, ILoginInfo> f;
    private ConcurrentHashMap<String, IAppReceiver> g;
    private ActivityManager h;
    private ConnectivityManager i;
    private Map<String, Set<Integer>> j;
    private a$a k;
    private PackageInfo l;
    private Map<String, AccsAbstractDataListener> n = new ConcurrentHashMap();

    static {
        Map concurrentHashMap = new ConcurrentHashMap();
        m = concurrentHashMap;
        concurrentHashMap.put(AGOO_SERVICE_ID, "org.android.agoo.accs.AgooService");
        m.put(AgooConstants.AGOO_SERVICE_AGOOACK, "org.android.agoo.accs.AgooService");
        m.put("agooTokenReport", "org.android.agoo.accs.AgooService");
    }

    public static GlobalClientInfo getInstance(Context context) {
        if (e == null) {
            synchronized (GlobalClientInfo.class) {
                if (e == null) {
                    e = new GlobalClientInfo(context);
                }
            }
        }
        return e;
    }

    public static Context getContext() {
        return a;
    }

    private GlobalClientInfo(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        ThreadPoolExecutorFactory.execute(new c(this));
    }

    public ActivityManager getActivityManager() {
        if (this.h == null) {
            this.h = (ActivityManager) a.getSystemService("activity");
        }
        return this.h;
    }

    public ConnectivityManager getConnectivityManager() {
        if (this.i == null) {
            this.i = (ConnectivityManager) a.getSystemService("connectivity");
        }
        return this.i;
    }

    public void setLoginInfoImpl(String str, ILoginInfo iLoginInfo) {
        if (this.f == null) {
            this.f = new ConcurrentHashMap(1);
        }
        if (iLoginInfo != null) {
            this.f.put(str, iLoginInfo);
        }
    }

    public void clearLoginInfoImpl() {
        this.f = null;
    }

    public String getSid(String str) {
        if (this.f == null) {
            return null;
        }
        ILoginInfo iLoginInfo = (ILoginInfo) this.f.get(str);
        if (iLoginInfo == null) {
            return null;
        }
        return iLoginInfo.getSid();
    }

    public String getUserId(String str) {
        if (this.f == null) {
            return null;
        }
        ILoginInfo iLoginInfo = (ILoginInfo) this.f.get(str);
        if (iLoginInfo == null) {
            return null;
        }
        return iLoginInfo.getUserId();
    }

    public String getNick(String str) {
        if (this.f == null) {
            return null;
        }
        ILoginInfo iLoginInfo = (ILoginInfo) this.f.get(str);
        if (iLoginInfo == null) {
            return null;
        }
        return iLoginInfo.getNick();
    }

    public void setAppReceiver(String str, IAppReceiver iAppReceiver) {
        if (iAppReceiver != null) {
            if (iAppReceiver instanceof IAgooAppReceiver) {
                b = (IAgooAppReceiver) iAppReceiver;
                return;
            }
            if (this.g == null) {
                this.g = new ConcurrentHashMap(2);
            }
            this.g.put(str, iAppReceiver);
        }
    }

    public Map<String, IAppReceiver> getAppReceiver() {
        return this.g;
    }

    public void registerService(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                m.put(str, str2);
            }
        }
    }

    public void unRegisterService(String str) {
        if (!TextUtils.isEmpty(str)) {
            m.remove(str);
        }
    }

    public String getService(String str) {
        return (String) m.get(str);
    }

    public void registerListener(String str, AccsAbstractDataListener accsAbstractDataListener) {
        if (!TextUtils.isEmpty(str)) {
            if (accsAbstractDataListener != null) {
                this.n.put(str, accsAbstractDataListener);
            }
        }
    }

    public void unregisterListener(String str) {
        this.n.remove(str);
    }

    public AccsAbstractDataListener getListener(String str) {
        return (AccsAbstractDataListener) this.n.get(str);
    }

    public void setElectionBlackList(Map<String, Set<Integer>> map) {
        this.j = map;
    }

    public Map<String, Set<Integer>> getElectionBlackList() {
        return this.j;
    }

    public void setElectionReslt(a$a com_taobao_accs_a_a_a) {
        this.k = com_taobao_accs_a_a_a;
    }

    public a$a getElectionResult() {
        return this.k;
    }

    public PackageInfo getPackageInfo() {
        try {
            if (this.l == null) {
                this.l = a.getPackageManager().getPackageInfo(a.getPackageName(), 0);
            }
        } catch (Throwable th) {
            ALog.e("GlobalClientInfo", "getPackageInfo", th, new Object[0]);
        }
        return this.l;
    }
}
