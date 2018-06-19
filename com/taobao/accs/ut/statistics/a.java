package com.taobao.accs.ut.statistics;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qq.e.comm.constants.Constants.KEYS;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class a implements UTInterface {
    public String a;
    public String b;
    public boolean c;
    public String d;
    private final String e = "BindApp";
    private boolean f = false;

    public void a(String str) {
        this.d = str;
    }

    public void a(int i) {
        if (i == 200) {
            return;
        }
        if (i != 300) {
            switch (i) {
                case -4:
                    a("msg too large");
                    return;
                case -3:
                    a("service not available");
                    return;
                case -2:
                    a("param error");
                    return;
                case -1:
                    a("network fail");
                    return;
                default:
                    a(String.valueOf(i));
                    return;
            }
        }
        a("app not bind");
    }

    public void commitUT() {
        b("BindApp");
    }

    private void b(String str) {
        StringBuilder stringBuilder;
        if (!this.f) {
            this.f = true;
            Map hashMap = new HashMap();
            String str2;
            String str3;
            try {
                str2 = this.a;
                try {
                    str3 = "221";
                    try {
                        hashMap.put("device_id", this.a);
                        hashMap.put("bind_date", this.b);
                        hashMap.put(KEYS.RET, this.c ? "y" : IXAdRequestInfo.AD_COUNT);
                        hashMap.put("fail_reasons", this.d);
                        hashMap.put("push_token", "");
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.d("accs.BindAppStatistic", UTMini.getCommitInfo(66001, str2, null, str3, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(66001, str, str2, null, str3, hashMap);
                    } catch (Throwable th) {
                        str = th;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(UTMini.getCommitInfo(66001, str2, null, str3, hashMap));
                        stringBuilder.append(" ");
                        stringBuilder.append(str.toString());
                        ALog.d("accs.BindAppStatistic", stringBuilder.toString(), new Object[0]);
                    }
                } catch (Throwable th2) {
                    str = th2;
                    str3 = null;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(UTMini.getCommitInfo(66001, str2, null, str3, hashMap));
                    stringBuilder.append(" ");
                    stringBuilder.append(str.toString());
                    ALog.d("accs.BindAppStatistic", stringBuilder.toString(), new Object[0]);
                }
            } catch (Throwable th3) {
                str = th3;
                str2 = null;
                str3 = str2;
                stringBuilder = new StringBuilder();
                stringBuilder.append(UTMini.getCommitInfo(66001, str2, null, str3, hashMap));
                stringBuilder.append(" ");
                stringBuilder.append(str.toString());
                ALog.d("accs.BindAppStatistic", stringBuilder.toString(), new Object[0]);
            }
        }
    }
}
