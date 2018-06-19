package org.android.agoo.control;

import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.b;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.android.agoo.message.MessageService;
import org.json.JSONObject;

/* compiled from: Taobao */
class d implements Runnable {
    final /* synthetic */ byte[] a;
    final /* synthetic */ boolean b;
    final /* synthetic */ AgooFactory c;

    d(AgooFactory agooFactory, byte[] bArr, boolean z) {
        this.c = agooFactory;
        this.a = bArr;
        this.b = z;
    }

    public void run() {
        StringBuilder stringBuilder;
        try {
            String str = new String(this.a, "utf-8");
            if (TextUtils.isEmpty(str)) {
                b.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "msg==null", 0.0d);
                return;
            }
            stringBuilder = new StringBuilder("message = ");
            stringBuilder.append(str);
            ALog.i("AgooFactory", stringBuilder.toString(), new Object[0]);
            JSONObject jSONObject = new JSONObject(str);
            Object obj = null;
            CharSequence string = jSONObject.getString("api");
            String string2 = jSONObject.getString(AgooConstants.MESSAGE_ID);
            if (TextUtils.equals(string, "agooReport")) {
                obj = jSONObject.getString("status");
            }
            if (TextUtils.equals(string, AgooConstants.AGOO_SERVICE_AGOOACK)) {
                b.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "handlerACKMessage", 0.0d);
            }
            if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2))) {
                if (!TextUtils.isEmpty(obj)) {
                    if (ALog.isPrintLog(Level.I)) {
                        StringBuilder stringBuilder2 = new StringBuilder("updateMsg data begin,api=");
                        stringBuilder2.append(string);
                        stringBuilder2.append(",id=");
                        stringBuilder2.append(string2);
                        stringBuilder2.append(",status=");
                        stringBuilder2.append(obj);
                        stringBuilder2.append(",reportTimes=");
                        stringBuilder2.append(Config.e(AgooFactory.access$000()));
                        ALog.i("AgooFactory", stringBuilder2.toString(), new Object[0]);
                    }
                    if (TextUtils.equals(string, "agooReport")) {
                        if (TextUtils.equals(obj, "4") && this.b) {
                            AgooFactory.access$100(this.c).a(string2, "1");
                        } else if ((TextUtils.equals(obj, "8") || TextUtils.equals(obj, "9")) && this.b) {
                            AgooFactory.access$100(this.c).a(string2, MessageService.MSG_DB_COMPLETE);
                        }
                        b.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, obj, 0.0d);
                    }
                    return;
                }
            }
            b.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json key null", 0.0d);
        } catch (Throwable th) {
            stringBuilder = new StringBuilder("updateMsg get data error,e=");
            stringBuilder.append(th);
            ALog.e("AgooFactory", stringBuilder.toString(), new Object[0]);
            b.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, "json exception", 0.0d);
        }
    }
}
