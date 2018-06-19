package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener;
import anet.channel.strategy.utils.a;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import anet.channel.util.Utils;
import anet.channel.util.c;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* compiled from: Taobao */
class g implements IStrategyInstance, IDispatchEventListener {
    protected StrategyInfoHolder a = null;
    private boolean b = false;
    private long c = 0;
    private CopyOnWriteArraySet<IStrategyListener> d = new CopyOnWriteArraySet();

    g() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize(android.content.Context r6) {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.b;	 Catch:{ all -> 0x0045 }
        if (r0 != 0) goto L_0x0043;
    L_0x0005:
        if (r6 != 0) goto L_0x0008;
    L_0x0007:
        goto L_0x0043;
    L_0x0008:
        r0 = 0;
        r1 = 0;
        r2 = "awcn.StrategyCenter";
        r3 = "StrategyCenter initialize started.";
        r4 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0037 }
        anet.channel.util.ALog.i(r2, r3, r1, r4);	 Catch:{ Exception -> 0x0037 }
        anet.channel.strategy.dispatch.a.a(r6);	 Catch:{ Exception -> 0x0037 }
        anet.channel.strategy.l.a(r6);	 Catch:{ Exception -> 0x0037 }
        anet.channel.status.NetworkStatusHelper.a(r6);	 Catch:{ Exception -> 0x0037 }
        r6 = anet.channel.strategy.dispatch.HttpDispatcher.getInstance();	 Catch:{ Exception -> 0x0037 }
        r6.addListener(r5);	 Catch:{ Exception -> 0x0037 }
        r6 = anet.channel.strategy.StrategyInfoHolder.a();	 Catch:{ Exception -> 0x0037 }
        r5.a = r6;	 Catch:{ Exception -> 0x0037 }
        r6 = 1;
        r5.b = r6;	 Catch:{ Exception -> 0x0037 }
        r6 = "awcn.StrategyCenter";
        r2 = "StrategyCenter initialize finished.";
        r3 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x0037 }
        anet.channel.util.ALog.i(r6, r2, r1, r3);	 Catch:{ Exception -> 0x0037 }
        monitor-exit(r5);
        return;
    L_0x0037:
        r6 = move-exception;
        r2 = "awcn.StrategyCenter";
        r3 = "StrategyCenter initialize failed.";
        r0 = new java.lang.Object[r0];	 Catch:{ all -> 0x0045 }
        anet.channel.util.ALog.e(r2, r3, r1, r6, r0);	 Catch:{ all -> 0x0045 }
        monitor-exit(r5);
        return;
    L_0x0043:
        monitor-exit(r5);
        return;
    L_0x0045:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.g.initialize(android.content.Context):void");
    }

    public synchronized void switchEnv() {
        if (this.a == null) {
            this.a.b();
            this.a = StrategyInfoHolder.a();
        }
        l.a();
        HttpDispatcher.getInstance().switchENV();
    }

    @Deprecated
    public String getSchemeByHost(String str) {
        return getSchemeByHost(str, null);
    }

    public String getSchemeByHost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (a()) {
            return str2;
        }
        String a = this.a.e.a(str);
        if (a != null || TextUtils.isEmpty(str2)) {
            str2 = a;
        }
        if (str2 == null) {
            str2 = a.a.a(str);
            if (str2 == null) {
                str2 = HttpConstant.HTTP;
            }
        }
        ALog.d("awcn.StrategyCenter", "getSchemeByHost", null, "host", str, "scheme", str2);
        return str2;
    }

    public String getCNameByHost(String str) {
        if (!a()) {
            if (!TextUtils.isEmpty(str)) {
                return this.a.d().getCnameByHost(str);
            }
        }
        return null;
    }

    public String getFormalizeUrl(String str) {
        Throwable e;
        c a = c.a(str);
        if (a == null) {
            ALog.e("awcn.StrategyCenter", "url is invalid.", null, "URL", str, "stack", Utils.getStackMsg(new Exception("getFormalizeUrl")));
            return null;
        }
        String concatString;
        try {
            String schemeByHost = getSchemeByHost(a.b(), a.a());
            concatString = !schemeByHost.equalsIgnoreCase(a.a()) ? StringUtils.concatString(schemeByHost, Constants.COLON_SEPARATOR, str.substring(str.indexOf("//"))) : str;
            try {
                if (ALog.isPrintLog(1)) {
                    ALog.d("awcn.StrategyCenter", "", null, ShareConstants.DEXMODE_RAW, StringUtils.simplifyString(str, 128), KEYS.RET, StringUtils.simplifyString(concatString, 128));
                }
            } catch (Exception e2) {
                e = e2;
                ALog.e("awcn.StrategyCenter", "getFormalizeUrl failed", null, e, ShareConstants.DEXMODE_RAW, str);
                return concatString;
            }
        } catch (Throwable e3) {
            e = e3;
            concatString = str;
            ALog.e("awcn.StrategyCenter", "getFormalizeUrl failed", null, e, ShareConstants.DEXMODE_RAW, str);
            return concatString;
        }
        return concatString;
    }

    @Deprecated
    public String getFormalizeUrl(String str, String str2) {
        return getFormalizeUrl(str);
    }

    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!a()) {
                CharSequence cnameByHost = this.a.d().getCnameByHost(str);
                if (!TextUtils.isEmpty(cnameByHost)) {
                    str = cnameByHost;
                }
                List<IConnStrategy> queryByHost = this.a.d().queryByHost(str);
                if (queryByHost.isEmpty()) {
                    queryByHost = this.a.f.a(str);
                }
                if (ALog.isPrintLog(1)) {
                    ALog.d("getConnStrategyListByHost", null, "host", str, "result", queryByHost);
                }
                return queryByHost;
            }
        }
        return Collections.EMPTY_LIST;
    }

    public void forceRefreshStrategy(String str) {
        if (!a()) {
            if (!TextUtils.isEmpty(str)) {
                ALog.i("awcn.StrategyCenter", "force refresh strategy", null, "host", str);
                this.a.d().a(str, true);
            }
        }
    }

    public void registerListener(IStrategyListener iStrategyListener) {
        if (iStrategyListener != null) {
            this.d.add(iStrategyListener);
        }
    }

    public void unregisterListener(IStrategyListener iStrategyListener) {
        this.d.remove(iStrategyListener);
    }

    public String getUnitPrefix(String str, String str2) {
        if (a()) {
            return null;
        }
        return this.a.d.a(str, str2);
    }

    public void setUnitPrefix(String str, String str2, String str3) {
        if (!a()) {
            this.a.d.a(str, str2, str3);
        }
    }

    public String getClientIp() {
        if (a()) {
            return "";
        }
        return this.a.d().b;
    }

    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (!(a() || iConnStrategy == null || !(iConnStrategy instanceof IPConnStrategy))) {
            if (((IPConnStrategy) iConnStrategy).a == 2) {
                this.a.f.a(str, iConnStrategy, connEvent);
                return;
            }
            this.a.d().a(str, iConnStrategy, connEvent);
        }
    }

    private boolean a() {
        if (this.a != null) {
            return false;
        }
        ALog.w("StrategyCenter not initialized", null, "isInitialized", Boolean.valueOf(this.b));
        return true;
    }

    public void onEvent(DispatchEvent dispatchEvent) {
        if (dispatchEvent.eventType == 1 && this.a != null) {
            ALog.d("awcn.StrategyCenter", "receive DNS event", null, new Object[0]);
            k.c a = k.a((JSONObject) dispatchEvent.extraObject);
            if (a != null) {
                this.a.a(a);
                saveData();
                Iterator it = this.d.iterator();
                while (it.hasNext()) {
                    ((IStrategyListener) it.next()).onStrategyUpdated(a);
                }
            }
        }
    }

    public synchronized void saveData() {
        ALog.i("awcn.StrategyCenter", "saveData", null, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.c > 60000) {
            this.c = currentTimeMillis;
            a.a(new h(this), 500);
        }
    }
}
