package com.tencent.wxop.stat;

import android.content.Context;
import com.alipay.sdk.util.h;
import com.tencent.bugly.BuglyStrategy.a;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.e;
import com.tencent.wxop.stat.event.i;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;

class ap implements Runnable {
    private Context a = null;
    private Map<String, Integer> b = null;
    private StatSpecifyReportedInfo c = null;

    public ap(Context context, Map<String, Integer> map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.a = context;
        this.c = statSpecifyReportedInfo;
        if (map != null) {
            this.b = map;
        }
    }

    private NetworkMonitor a(String str, int i) {
        int i2;
        NetworkMonitor networkMonitor = new NetworkMonitor();
        Socket socket = new Socket();
        try {
            networkMonitor.setDomain(str);
            networkMonitor.setPort(i);
            long currentTimeMillis = System.currentTimeMillis();
            SocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            socket.connect(inetSocketAddress, a.MAX_USERDATA_VALUE_LENGTH);
            networkMonitor.setMillisecondsConsume(System.currentTimeMillis() - currentTimeMillis);
            networkMonitor.setRemoteIp(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th) {
                StatServiceImpl.q.e(th);
            }
            i2 = 0;
        } catch (Throwable th2) {
            try {
                StatServiceImpl.q.e(th2);
                socket.close();
            } catch (Throwable th3) {
                StatServiceImpl.q.e(th3);
            }
        } catch (Throwable th22) {
            StatServiceImpl.q.e(th22);
        }
        networkMonitor.setStatusCode(i2);
        return networkMonitor;
        i2 = -1;
        networkMonitor.setStatusCode(i2);
        return networkMonitor;
    }

    private Map<String, Integer> a() {
        Map<String, Integer> hashMap = new HashMap();
        String a = StatConfig.a("__MTA_TEST_SPEED__", null);
        if (a == null || a.trim().length() == 0) {
            return hashMap;
        }
        for (String split : a.split(h.b)) {
            String[] split2 = split.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split2 != null && split2.length == 2) {
                String str = split2[0];
                if (!(str == null || str.trim().length() == 0)) {
                    try {
                        hashMap.put(str, Integer.valueOf(Integer.valueOf(split2[1]).intValue()));
                    } catch (Throwable e) {
                        StatServiceImpl.q.e(e);
                    }
                }
            }
        }
        return hashMap;
    }

    public void run() {
        try {
            if (this.b == null) {
                this.b = a();
            }
            if (this.b != null) {
                if (this.b.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (Entry entry : this.b.entrySet()) {
                        StatLogger f;
                        Object stringBuilder;
                        String str = (String) entry.getKey();
                        if (str != null) {
                            if (str.length() != 0) {
                                if (((Integer) entry.getValue()) == null) {
                                    f = StatServiceImpl.q;
                                    StringBuilder stringBuilder2 = new StringBuilder("port is null for ");
                                    stringBuilder2.append(str);
                                    stringBuilder = stringBuilder2.toString();
                                    f.w(stringBuilder);
                                } else {
                                    jSONArray.put(a((String) entry.getKey(), ((Integer) entry.getValue()).intValue()).toJSONObject());
                                }
                            }
                        }
                        f = StatServiceImpl.q;
                        stringBuilder = "empty domain name.";
                        f.w(stringBuilder);
                    }
                    if (jSONArray.length() != 0) {
                        e iVar = new i(this.a, StatServiceImpl.a(this.a, false, this.c), this.c);
                        iVar.a(jSONArray.toString());
                        new aq(iVar).a();
                        return;
                    }
                    return;
                }
            }
            StatServiceImpl.q.i("empty domain list.");
        } catch (Throwable th) {
            StatServiceImpl.q.e(th);
        }
    }
}
