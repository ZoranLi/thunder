package com.taobao.accs.ut.statistics;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class e implements UTInterface {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    private final String g = "sendAck";
    private boolean h = false;

    public void commitUT() {
        String str;
        String str2;
        Throwable th;
        StringBuilder stringBuilder;
        if (!this.h) {
            this.h = true;
            Map hashMap = new HashMap();
            try {
                str = this.a;
                try {
                    str2 = "221";
                    try {
                        hashMap.put("device_id", this.a);
                        hashMap.put("session_id", this.b);
                        hashMap.put("data_id", this.c);
                        hashMap.put("ack_date", this.d);
                        hashMap.put("service_id", this.e);
                        hashMap.put("fail_reasons", this.f);
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, null, str2, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(66001, "sendAck", str, null, str2, hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(UTMini.getCommitInfo(66001, str, null, str2, hashMap));
                        stringBuilder.append(" ");
                        stringBuilder.append(th.toString());
                        ALog.d("accs.SendAckStatistic", stringBuilder.toString(), new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str2 = null;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(UTMini.getCommitInfo(66001, str, null, str2, hashMap));
                    stringBuilder.append(" ");
                    stringBuilder.append(th.toString());
                    ALog.d("accs.SendAckStatistic", stringBuilder.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                str = null;
                str2 = str;
                stringBuilder = new StringBuilder();
                stringBuilder.append(UTMini.getCommitInfo(66001, str, null, str2, hashMap));
                stringBuilder.append(" ");
                stringBuilder.append(th.toString());
                ALog.d("accs.SendAckStatistic", stringBuilder.toString(), new Object[0]);
            }
        }
    }
}
