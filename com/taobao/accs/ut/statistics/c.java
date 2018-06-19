package com.taobao.accs.ut.statistics;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class c implements UTInterface {
    public int a;
    public int b;
    public boolean c = false;
    public int d = 0;
    public int e = 0;
    public String f;
    public String g;
    public long h;
    public boolean i;
    public boolean j;
    private long k = 0;

    public void commitUT() {
        Throwable th;
        long currentTimeMillis = System.currentTimeMillis();
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder = new StringBuilder("commitUT interval:");
            stringBuilder.append(currentTimeMillis - this.k);
            stringBuilder.append(" interval1:");
            stringBuilder.append(currentTimeMillis - this.h);
            ALog.d("MonitorStatistic", stringBuilder.toString(), new Object[0]);
        }
        if (currentTimeMillis - this.k > 1200000 && currentTimeMillis - this.h > 60000) {
            Map hashMap = new HashMap();
            String valueOf;
            String valueOf2;
            String str;
            try {
                valueOf = String.valueOf(this.d);
                try {
                    valueOf2 = String.valueOf(this.e);
                } catch (Throwable th2) {
                    th = th2;
                    valueOf2 = null;
                    str = valueOf2;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(UTMini.getCommitInfo(66001, valueOf, valueOf2, str, hashMap));
                    stringBuilder.append(" ");
                    stringBuilder.append(th.toString());
                    ALog.d("MonitorStatistic", stringBuilder.toString(), new Object[0]);
                }
                try {
                    str = "221";
                    try {
                        hashMap.put("connStatus", String.valueOf(this.a));
                        hashMap.put("connType", String.valueOf(this.b));
                        hashMap.put("tcpConnected", String.valueOf(this.c));
                        hashMap.put("proxy", String.valueOf(this.f));
                        hashMap.put("startServiceTime", String.valueOf(this.h));
                        hashMap.put("commitTime", String.valueOf(currentTimeMillis));
                        hashMap.put("networkAvailable", String.valueOf(this.i));
                        hashMap.put("threadIsalive", String.valueOf(this.j));
                        hashMap.put("url", this.g);
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.d("MonitorStatistic", UTMini.getCommitInfo(66001, valueOf, valueOf2, str, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(66001, "MONITOR", (Object) valueOf, (Object) valueOf2, (Object) str, hashMap);
                        this.k = currentTimeMillis;
                    } catch (Throwable th3) {
                        th = th3;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(UTMini.getCommitInfo(66001, valueOf, valueOf2, str, hashMap));
                        stringBuilder.append(" ");
                        stringBuilder.append(th.toString());
                        ALog.d("MonitorStatistic", stringBuilder.toString(), new Object[0]);
                    }
                } catch (Throwable th4) {
                    th = th4;
                    str = null;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(UTMini.getCommitInfo(66001, valueOf, valueOf2, str, hashMap));
                    stringBuilder.append(" ");
                    stringBuilder.append(th.toString());
                    ALog.d("MonitorStatistic", stringBuilder.toString(), new Object[0]);
                }
            } catch (Throwable th5) {
                th = th5;
                valueOf = null;
                valueOf2 = valueOf;
                str = valueOf2;
                stringBuilder = new StringBuilder();
                stringBuilder.append(UTMini.getCommitInfo(66001, valueOf, valueOf2, str, hashMap));
                stringBuilder.append(" ");
                stringBuilder.append(th.toString());
                ALog.d("MonitorStatistic", stringBuilder.toString(), new Object[0]);
            }
        }
    }
}
