package com.taobao.accs.ut.statistics;

import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.common.SocializeConstants;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public class d implements UTInterface {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h = false;
    public String i;
    private final String j = "receiveMessage";
    private boolean k = false;

    public void commitUT() {
        Throwable th;
        StringBuilder stringBuilder;
        if (!this.k) {
            this.k = true;
            Map hashMap = new HashMap();
            String str;
            String str2;
            try {
                str = this.a;
                try {
                    str2 = "221";
                    try {
                        hashMap.put("device_id", this.a);
                        hashMap.put("data_id", this.b);
                        hashMap.put("receive_date", this.c);
                        hashMap.put("to_bz_date", this.d);
                        hashMap.put("service_id", this.e);
                        hashMap.put("data_length", this.f);
                        hashMap.put(MsgConstant.INAPP_MSG_TYPE, this.g);
                        hashMap.put("repeat", this.h ? "y" : IXAdRequestInfo.AD_COUNT);
                        hashMap.put(SocializeConstants.TENCENT_UID, this.i);
                        if (ALog.isPrintLog(Level.D)) {
                            ALog.d("accs.ReceiveMessage", UTMini.getCommitInfo(66001, str, null, str2, hashMap), new Object[0]);
                        }
                        UTMini.getInstance().commitEvent(66001, "receiveMessage", str, null, str2, hashMap);
                    } catch (Throwable th2) {
                        th = th2;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(UTMini.getCommitInfo(66001, str, null, str2, hashMap));
                        stringBuilder.append(" ");
                        stringBuilder.append(th.toString());
                        ALog.d("accs.ReceiveMessage", stringBuilder.toString(), new Object[0]);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str2 = null;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(UTMini.getCommitInfo(66001, str, null, str2, hashMap));
                    stringBuilder.append(" ");
                    stringBuilder.append(th.toString());
                    ALog.d("accs.ReceiveMessage", stringBuilder.toString(), new Object[0]);
                }
            } catch (Throwable th4) {
                th = th4;
                str = null;
                str2 = str;
                stringBuilder = new StringBuilder();
                stringBuilder.append(UTMini.getCommitInfo(66001, str, null, str2, hashMap));
                stringBuilder.append(" ");
                stringBuilder.append(th.toString());
                ALog.d("accs.ReceiveMessage", stringBuilder.toString(), new Object[0]);
            }
        }
    }
}
