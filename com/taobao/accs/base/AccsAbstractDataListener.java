package com.taobao.accs.base;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.base.TaoBaseService.ConnectInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
public abstract class AccsAbstractDataListener implements AccsDataListener {
    private static final String TAG = "AccsAbstractDataListener";

    public void onAntiBrush(boolean z, TaoBaseService$ExtraInfo taoBaseService$ExtraInfo) {
    }

    public void onConnected(ConnectInfo connectInfo) {
    }

    public void onDisconnected(ConnectInfo connectInfo) {
    }

    public static int onReceiveData(Context context, Intent intent, AccsDataListener accsDataListener) {
        Throwable th;
        StringBuilder stringBuilder;
        Context context2 = context;
        Intent intent2 = intent;
        AccsDataListener accsDataListener2 = accsDataListener;
        if (accsDataListener2 != null) {
            if (context2 != null) {
                if (intent2 != null) {
                    String str = "";
                    String stringExtra;
                    try {
                        int intExtra = intent2.getIntExtra("command", -1);
                        int intExtra2 = intent2.getIntExtra("errorCode", 0);
                        String stringExtra2 = intent2.getStringExtra(Constants.KEY_USER_ID);
                        String stringExtra3 = intent2.getStringExtra(Constants.KEY_DATA_ID);
                        stringExtra = intent2.getStringExtra(Constants.KEY_SERVICE_ID);
                        try {
                            StringBuilder stringBuilder2;
                            if (ALog.isPrintLog(Level.I)) {
                                str = TAG;
                                stringBuilder2 = new StringBuilder("onReceiveData dataId:");
                                stringBuilder2.append(stringExtra3);
                                stringBuilder2.append(" serviceId:");
                                stringBuilder2.append(stringExtra);
                                stringBuilder2.append(" command:");
                                stringBuilder2.append(intExtra);
                                ALog.i(str, stringBuilder2.toString(), new Object[0]);
                            }
                            if (intExtra > 0) {
                                StringBuilder stringBuilder3 = new StringBuilder("commandId=");
                                stringBuilder3.append(intExtra);
                                String stringBuilder4 = stringBuilder3.toString();
                                stringBuilder3 = new StringBuilder("serviceId=");
                                stringBuilder3.append(stringExtra);
                                stringBuilder3.append(" dataId=");
                                stringBuilder3.append(stringExtra3);
                                UTMini.getInstance().commitEvent(66001, "MsgToBuss5", stringBuilder4, stringBuilder3.toString(), Integer.valueOf(221));
                                stringExtra3 = BaseMonitor.COUNT_POINT_TO_BUSS;
                                stringBuilder2 = new StringBuilder("3commandId=");
                                stringBuilder2.append(intExtra);
                                stringBuilder2.append("serviceId=");
                                stringBuilder2.append(stringExtra);
                                b.a("accs", stringExtra3, stringBuilder2.toString(), 0.0d);
                                String str2;
                                boolean booleanExtra;
                                switch (intExtra) {
                                    case 5:
                                        accsDataListener2.onBind(stringExtra, intExtra2, getExtraInfo(intent));
                                        break;
                                    case 6:
                                        accsDataListener2.onUnbind(stringExtra, intExtra2, getExtraInfo(intent));
                                        break;
                                    case 100:
                                        str = intent2.getStringExtra(Constants.KEY_DATA_ID);
                                        if (!TextUtils.equals("res", intent2.getStringExtra(Constants.KEY_SEND_TYPE))) {
                                            accsDataListener2.onSendData(stringExtra, str, intExtra2, getExtraInfo(intent));
                                            break;
                                        }
                                        accsDataListener2.onResponse(stringExtra, str, intExtra2, intent2.getByteArrayExtra("data"), getExtraInfo(intent));
                                        break;
                                    case 101:
                                        byte[] byteArrayExtra = intent2.getByteArrayExtra("data");
                                        boolean booleanExtra2 = intent2.getBooleanExtra(Constants.KEY_NEED_BUSINESS_ACK, false);
                                        if (byteArrayExtra == null) {
                                            ALog.e(TAG, "COMMAND_RECEIVE_DATA msg null", new Object[0]);
                                            b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra, "1", "COMMAND_RECEIVE_DATA msg null");
                                            break;
                                        }
                                        StringBuilder stringBuilder5;
                                        stringExtra3 = intent2.getStringExtra(Constants.KEY_DATA_ID);
                                        if (ALog.isPrintLog(Level.D)) {
                                            str2 = TAG;
                                            stringBuilder5 = new StringBuilder("COMMAND_RECEIVE_DATA onData dataId:");
                                            stringBuilder5.append(stringExtra3);
                                            stringBuilder5.append(" serviceId:");
                                            stringBuilder5.append(stringExtra);
                                            ALog.d(str2, stringBuilder5.toString(), new Object[0]);
                                        }
                                        TaoBaseService$ExtraInfo extraInfo = getExtraInfo(intent);
                                        if (booleanExtra2) {
                                            str = TAG;
                                            stringBuilder5 = new StringBuilder("try to send biz ack dataId ");
                                            stringBuilder5.append(stringExtra3);
                                            ALog.i(str, stringBuilder5.toString(), new Object[0]);
                                            sendBusinessAck(context2, intent2, stringExtra3, extraInfo.oriExtHeader);
                                        }
                                        accsDataListener2.onData(stringExtra, stringExtra2, stringExtra3, byteArrayExtra, extraInfo);
                                        break;
                                    case 103:
                                        booleanExtra = intent2.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
                                        str2 = intent2.getStringExtra("host");
                                        String stringExtra4 = intent2.getStringExtra(Constants.KEY_ERROR_DETAIL);
                                        boolean booleanExtra3 = intent2.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
                                        boolean booleanExtra4 = intent2.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
                                        if (!TextUtils.isEmpty(str2)) {
                                            if (!booleanExtra) {
                                                accsDataListener2.onDisconnected(new ConnectInfo(str2, booleanExtra3, booleanExtra4, intExtra2, stringExtra4));
                                                break;
                                            }
                                            accsDataListener2.onConnected(new ConnectInfo(str2, booleanExtra3, booleanExtra4));
                                            break;
                                        }
                                        break;
                                    case 104:
                                        booleanExtra = intent2.getBooleanExtra(Constants.KEY_ANTI_BRUSH_RET, false);
                                        String str3 = TAG;
                                        stringBuilder3 = new StringBuilder("anti brush result:");
                                        stringBuilder3.append(booleanExtra);
                                        ALog.e(str3, stringBuilder3.toString(), new Object[0]);
                                        accsDataListener2.onAntiBrush(booleanExtra, null);
                                        break;
                                    default:
                                        break;
                                }
                            }
                        } catch (Throwable e) {
                            th = e;
                            try {
                                th.printStackTrace();
                                stringBuilder = new StringBuilder("callback error");
                                stringBuilder.append(th.toString());
                                b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra, "1", stringBuilder.toString());
                                ALog.e(TAG, "onReceiveData", th, new Object[0]);
                                return 2;
                            } catch (Throwable e2) {
                                th = e2;
                            }
                        }
                    } catch (Throwable e22) {
                        th = e22;
                        stringExtra = str;
                        th.printStackTrace();
                        stringBuilder = new StringBuilder("callback error");
                        stringBuilder.append(th.toString());
                        b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, stringExtra, "1", stringBuilder.toString());
                        ALog.e(TAG, "onReceiveData", th, new Object[0]);
                        return 2;
                    }
                }
                return 2;
            }
        }
        ALog.e(TAG, "onReceiveData listener or context null", new Object[0]);
        return 2;
    }

    private static Map<TaoBaseService$ExtHeaderType, String> getExtHeader(Map<Integer, String> map) {
        if (map == null) {
            return null;
        }
        Map<TaoBaseService$ExtHeaderType, String> hashMap;
        try {
            hashMap = new HashMap();
            try {
                for (TaoBaseService$ExtHeaderType taoBaseService$ExtHeaderType : TaoBaseService$ExtHeaderType.values()) {
                    String str = (String) map.get(Integer.valueOf(taoBaseService$ExtHeaderType.ordinal()));
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put(taoBaseService$ExtHeaderType, str);
                    }
                }
            } catch (Exception e) {
                map = e;
                ALog.e(TAG, "getExtHeader", map, new Object[0]);
                return hashMap;
            }
        } catch (Exception e2) {
            map = e2;
            hashMap = null;
            ALog.e(TAG, "getExtHeader", map, new Object[0]);
            return hashMap;
        }
        return hashMap;
    }

    private static TaoBaseService$ExtraInfo getExtraInfo(Intent intent) {
        TaoBaseService$ExtraInfo taoBaseService$ExtraInfo = new TaoBaseService$ExtraInfo();
        try {
            HashMap hashMap = (HashMap) intent.getSerializableExtra(TaoBaseService$ExtraInfo.EXT_HEADER);
            Map extHeader = getExtHeader(hashMap);
            String stringExtra = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
            String stringExtra2 = intent.getStringExtra("host");
            taoBaseService$ExtraInfo.connType = intent.getIntExtra(Constants.KEY_CONN_TYPE, 0);
            taoBaseService$ExtraInfo.extHeader = extHeader;
            taoBaseService$ExtraInfo.oriExtHeader = hashMap;
            taoBaseService$ExtraInfo.fromPackage = stringExtra;
            taoBaseService$ExtraInfo.fromHost = stringExtra2;
        } catch (Intent intent2) {
            ALog.e(TAG, "getExtraInfo", intent2, new Object[0]);
        }
        return taoBaseService$ExtraInfo;
    }

    private static void sendBusinessAck(Context context, Intent intent, String str, Map<Integer, String> map) {
        try {
            ALog.i(TAG, "sendBusinessAck", Constants.KEY_DATA_ID, str);
            if (intent != null) {
                String stringExtra = intent.getStringExtra("host");
                String stringExtra2 = intent.getStringExtra("source");
                String stringExtra3 = intent.getStringExtra("target");
                String stringExtra4 = intent.getStringExtra("appKey");
                String stringExtra5 = intent.getStringExtra(Constants.KEY_CONFIG_TAG);
                short shortExtra = intent.getShortExtra(Constants.KEY_FLAGS, (short) 0);
                IACCSManager accsInstance = ACCSManager.getAccsInstance(context, stringExtra4, stringExtra5);
                if (accsInstance != null) {
                    accsInstance.sendBusinessAck(stringExtra3, stringExtra2, str, shortExtra, stringExtra, map);
                    b.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_SUCC, "", 0.0d);
                    return;
                }
                b.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, "no acsmgr", 0.0d);
            }
        } catch (Context context2) {
            ALog.e(TAG, "sendBusinessAck", context2, new Object[0]);
            b.a("accs", BaseMonitor.COUNT_BUSINESS_ACK_FAIL, context2.toString(), 0.0d);
        }
    }
}
