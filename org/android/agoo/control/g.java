package org.android.agoo.control;

import com.taobao.accs.ACCSManager;
import com.taobao.accs.ACCSManager.AccsRequest;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.a;
import java.util.HashMap;
import java.util.Map;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.Config;
import org.json.JSONObject;

/* compiled from: Taobao */
class g implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ boolean c;
    final /* synthetic */ NotifManager d;

    g(NotifManager notifManager, String str, String str2, boolean z) {
        this.d = notifManager;
        this.a = str;
        this.b = str2;
        this.c = z;
    }

    public void run() {
        try {
            String sendData;
            Map hashMap = new HashMap();
            hashMap.put("thirdTokenType", this.a);
            hashMap.put("token", this.b);
            hashMap.put("appkey", Config.a(NotifManager.access$000()));
            hashMap.put("utdid", a.b(NotifManager.access$000()));
            StringBuilder stringBuilder = new StringBuilder("report,utdid=");
            stringBuilder.append(a.b(NotifManager.access$000()));
            stringBuilder.append(",regId=");
            stringBuilder.append(this.b);
            stringBuilder.append(",type=");
            stringBuilder.append(this.a);
            ALog.d("NotifManager", stringBuilder.toString(), new Object[0]);
            AccsRequest accsRequest = new AccsRequest(null, "agooTokenReport", new JSONObject(hashMap).toString().getBytes("UTF-8"), null, null, null, null);
            IACCSManager accsInstance = ACCSManager.getAccsInstance(NotifManager.access$000(), Config.a(NotifManager.access$000()), Config.b(NotifManager.access$000()));
            if (this.c) {
                sendData = accsInstance.sendData(NotifManager.access$000(), accsRequest);
            } else {
                sendData = accsInstance.sendPushResponse(NotifManager.access$000(), accsRequest, new ExtraInfo());
            }
            if (ALog.isPrintLog(Level.D)) {
                stringBuilder = new StringBuilder("reportThirdPushToken,dataId=");
                stringBuilder.append(sendData);
                stringBuilder.append(",regId=");
                stringBuilder.append(this.b);
                stringBuilder.append(",type=");
                stringBuilder.append(this.a);
                ALog.i("NotifManager", stringBuilder.toString(), new Object[0]);
            }
        } catch (Throwable th) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "reportThirdPushToken", a.b(NotifManager.access$000()), th.toString());
            if (ALog.isPrintLog(Level.E)) {
                ALog.e("NotifManager", "[report] is error", th, new Object[0]);
            }
        }
    }
}
