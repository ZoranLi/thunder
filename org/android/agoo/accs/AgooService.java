package org.android.agoo.accs;

import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.base.TaoBaseService.ExtraInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.a;
import com.taobao.accs.utl.b;
import java.nio.charset.Charset;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.common.CallBack;
import org.android.agoo.common.Config;
import org.android.agoo.control.AgooFactory;

/* compiled from: Taobao */
public class AgooService extends TaoBaseService {
    public static CallBack a;
    public static CallBack b;
    private AgooFactory c;

    public void onCreate() {
        super.onCreate();
        ALog.d("AgooService", "into--[onCreate]", new Object[0]);
        this.c = new AgooFactory();
        this.c.init(getApplicationContext(), null, null);
    }

    public void onData(String str, String str2, String str3, byte[] bArr, ExtraInfo extraInfo) {
        if (ALog.isPrintLog(Level.I) != null) {
            StringBuilder stringBuilder = new StringBuilder("into--[onData]:serviceId:");
            stringBuilder.append(str);
            stringBuilder.append(",dataId=");
            stringBuilder.append(str3);
            ALog.i("AgooService", stringBuilder.toString(), new Object[0]);
            str2 = new StringBuilder("push data:");
            str2.append(new String(bArr, Charset.forName("UTF-8")));
            ALog.d("AgooService", str2.toString(), new Object[0]);
        }
        UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", a.b(getApplicationContext()), str3);
        try {
            this.c.saveMsg(bArr);
            this.c.msgRecevie(bArr, "accs", extraInfo);
        } catch (String str4) {
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", "onDataError", str4);
            str3 = new StringBuilder("into--[onData,dealMessage]:error:");
            str3.append(str4);
            ALog.e("AgooService", str3.toString(), new Object[0]);
        }
    }

    public void onBind(String str, int i, ExtraInfo extraInfo) {
        if (ALog.isPrintLog(Level.E) != null) {
            StringBuilder stringBuilder = new StringBuilder("into--[onBind]:serviceId:");
            stringBuilder.append(str);
            stringBuilder.append(",errorCode=");
            stringBuilder.append(i);
            ALog.e("AgooService", stringBuilder.toString(), new Object[0]);
        }
        if (!(a == null || GlobalClientInfo.AGOO_SERVICE_ID.equals(str) == null)) {
            if (i == 200) {
                a.onSuccess();
            } else {
                a.onFailure(String.valueOf(i), "bind Agoo service fail");
            }
        }
        a = null;
    }

    public void onUnbind(String str, int i, ExtraInfo extraInfo) {
        if (ALog.isPrintLog(Level.E) != null) {
            StringBuilder stringBuilder = new StringBuilder("into--[onUnbind]:serviceId:");
            stringBuilder.append(str);
            stringBuilder.append(",errorCode=");
            stringBuilder.append(i);
            ALog.e("AgooService", stringBuilder.toString(), new Object[0]);
        }
        if (!(b == null || GlobalClientInfo.AGOO_SERVICE_ID.equals(str) == null)) {
            if (i == 200) {
                b.onSuccess();
            } else {
                b.onFailure(String.valueOf(i), "unbind Agoo service fail");
            }
        }
        b = null;
    }

    public void onSendData(String str, String str2, int i, ExtraInfo extraInfo) {
        try {
            StringBuilder stringBuilder;
            if (ALog.isPrintLog(Level.I)) {
                stringBuilder = new StringBuilder("onSendData,dataId=");
                stringBuilder.append(str2);
                stringBuilder.append(",errorCode=");
                stringBuilder.append(i);
                stringBuilder.append(",serviceId=");
                stringBuilder.append(str);
                ALog.i("AgooService", stringBuilder.toString(), new Object[0]);
            }
            if (i == 200) {
                if (TextUtils.equals(AgooConstants.AGOO_SERVICE_AGOOACK, str) != 0) {
                    b.a("accs", BaseMonitor.COUNT_AGOO_SUCCESS_ACK, "8/9", 0.0d);
                }
                StringBuilder stringBuilder2;
                if (TextUtils.isEmpty(str) != 0 || TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK) == 0 || Long.parseLong(str2) <= 300000000 || Long.parseLong(str2) >= 600000000) {
                    if (TextUtils.isEmpty(str) == 0 && TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK) != 0 && Long.parseLong(str2) > 600000000 && ALog.isPrintLog(Level.I) != 0) {
                        stringBuilder2 = new StringBuilder("onSendData,reportData=");
                        stringBuilder2.append(str2);
                        stringBuilder2.append(",serviceId=");
                        stringBuilder2.append(str);
                        ALog.i("AgooService", stringBuilder2.toString(), new Object[0]);
                        return;
                    }
                } else if (ALog.isPrintLog(Level.I) != 0) {
                    stringBuilder2 = new StringBuilder("onSendData,AckData=");
                    stringBuilder2.append(str2);
                    stringBuilder2.append(",serviceId=");
                    stringBuilder2.append(str);
                    ALog.i("AgooService", stringBuilder2.toString(), new Object[0]);
                    return;
                }
            }
            if (TextUtils.equals(AgooConstants.AGOO_SERVICE_AGOOACK, str)) {
                Config.a(getApplicationContext(), 1);
                b.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, String.valueOf(i), 0.0d);
            }
            if (ALog.isPrintLog(Level.I)) {
                stringBuilder = new StringBuilder("onSendData error,dataId=");
                stringBuilder.append(str2);
                stringBuilder.append(",serviceId=");
                stringBuilder.append(str);
                ALog.i("AgooService", stringBuilder.toString(), new Object[0]);
                ALog.e("AgooService", "into--[parseError]", new Object[0]);
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str2);
            stringBuilder3.append(",serviceId=");
            stringBuilder3.append(str);
            stringBuilder3.append(",errorCode=");
            stringBuilder3.append(i);
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", a.b(getApplicationContext()), "errorCode", stringBuilder3.toString());
        } catch (String str3) {
            if (ALog.isPrintLog(Level.E) != null) {
                i = new StringBuilder("onSendData exception,e=");
                i.append(str3.getMessage());
                i.append(",e.getStackMsg=");
                i.append(a(str3));
                ALog.e("AgooService", i.toString(), new Object[0]);
            }
            UTMini.getInstance().commitEvent(AgooConstants.AGOO_EVENT_ID, "accs.agooService", a.b(getApplicationContext()), "onSendDataException", a(str3));
        }
    }

    public void onResponse(String str, String str2, int i, byte[] bArr, ExtraInfo extraInfo) {
        if (ALog.isPrintLog(Level.I) != null) {
            StringBuilder stringBuilder = new StringBuilder("onResponse,dataId=");
            stringBuilder.append(str2);
            stringBuilder.append(",errorCode=");
            stringBuilder.append(i);
            stringBuilder.append(",data=");
            stringBuilder.append(bArr);
            stringBuilder.append(",serviceId=");
            stringBuilder.append(str);
            ALog.i("AgooService", stringBuilder.toString(), new Object[0]);
        }
        extraInfo = null;
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    extraInfo = new String(bArr, "utf-8");
                }
            } catch (Throwable th) {
                StringBuilder stringBuilder2 = new StringBuilder("onResponse get data error,e=");
                stringBuilder2.append(th);
                ALog.e("AgooService", stringBuilder2.toString(), new Object[0]);
            }
        }
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder3 = new StringBuilder("onResponse,message=");
            stringBuilder3.append(extraInfo);
            ALog.d("AgooService", stringBuilder3.toString(), new Object[0]);
        }
        if (i == 200 && TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK)) {
            if (ALog.isPrintLog(Level.E) != null) {
                ALog.e("AgooService", "request is success", new Object[]{Constants.KEY_DATA_ID, str2});
            }
            this.c.updateMsg(bArr, true);
        } else if (i == 200 || TextUtils.equals(str, AgooConstants.AGOO_SERVICE_AGOOACK) == null) {
            if (ALog.isPrintLog(Level.E) != null) {
                str2 = new StringBuilder("business request is error,message=");
                str2.append(extraInfo);
                ALog.e("AgooService", str2.toString(), new Object[0]);
            }
        } else {
            if (ALog.isPrintLog(Level.E) != null) {
                ALog.e("AgooService", "request is error", new Object[]{Constants.KEY_DATA_ID, str2, "errorid", Integer.valueOf(i)});
            }
            Config.a(getApplicationContext(), 1);
            b.a("accs", BaseMonitor.COUNT_AGOO_FAIL_ACK, String.valueOf(i), null);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private String a(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        th = th.getStackTrace();
        if (th != null && th.length > 0) {
            for (StackTraceElement stackTraceElement : th) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(stackTraceElement.toString());
                stringBuilder.append("\n");
                stringBuffer.append(stringBuilder.toString());
            }
        }
        return stringBuffer.toString();
    }
}
