package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.IAppReceiver;
import com.taobao.accs.IAppReceiverV1;
import com.taobao.accs.base.AccsAbstractDataListener;
import com.taobao.accs.base.TaoBaseService.ConnectInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.common.Constants.Operate;
import com.taobao.accs.common.ThreadPoolExecutorFactory;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.ALog.Level;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UTMini;
import com.taobao.accs.utl.UtilityImpl;
import com.taobao.accs.utl.a;
import com.taobao.accs.utl.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
public class d {
    private static Set<String> a;
    private static volatile d b;

    protected String b() {
        return a.channelService;
    }

    protected String c() {
        return a.msgService;
    }

    public static d a() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public static void a(Context context, Intent intent) {
        try {
            ThreadPoolExecutorFactory.getScheduledExecutor().execute(new e(context, intent));
        } catch (Context context2) {
            ALog.e("MsgDistribute", "distribMessage", context2, new Object[0]);
            StringBuilder stringBuilder = new StringBuilder("distribMessage");
            stringBuilder.append(context2.toString());
            UTMini.getInstance().commitEvent(66001, "MsgToBuss8", stringBuilder.toString(), Integer.valueOf(221));
        }
    }

    private void b(Context context, Intent intent) {
        int intExtra;
        int i;
        Throwable th;
        Throwable th2;
        String str;
        StringBuilder stringBuilder;
        d dVar = this;
        Context context2 = context;
        Intent intent2 = intent;
        Object action = intent.getAction();
        if (ALog.isPrintLog(Level.D)) {
            StringBuilder stringBuilder2 = new StringBuilder("action:");
            stringBuilder2.append(action);
            ALog.d("MsgDistribute", stringBuilder2.toString(), new Object[0]);
        }
        if (TextUtils.isEmpty(action)) {
            ALog.e("MsgDistribute", "action null", new Object[0]);
            UTMini.getInstance().commitEvent(66001, "MsgToBuss9", "action null", Integer.valueOf(221));
            return;
        }
        try {
            if (TextUtils.equals(action, Constants.ACTION_RECEIVE)) {
                String stringExtra;
                int intExtra2;
                String stringExtra2;
                try {
                    intExtra = intent2.getIntExtra("command", -1);
                    try {
                        stringExtra = intent2.getStringExtra(Constants.KEY_USER_ID);
                        intExtra2 = intent2.getIntExtra("errorCode", 0);
                        stringExtra2 = intent2.getStringExtra(Constants.KEY_SERVICE_ID);
                    } catch (Throwable th22) {
                        i = intExtra;
                        th = th22;
                        str = null;
                        ALog.e("MsgDistribute", "distribMessage :", th, Constants.KEY_SERVICE_ID, str);
                        stringBuilder = new StringBuilder("distribute error ");
                        stringBuilder.append(intExtra);
                        stringBuilder.append(UtilityImpl.getStackMsg(th));
                        b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", stringBuilder.toString());
                    }
                } catch (Throwable th222) {
                    th = th222;
                    intExtra = 0;
                    str = null;
                    ALog.e("MsgDistribute", "distribMessage :", th, Constants.KEY_SERVICE_ID, str);
                    stringBuilder = new StringBuilder("distribute error ");
                    stringBuilder.append(intExtra);
                    stringBuilder.append(UtilityImpl.getStackMsg(th));
                    b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", stringBuilder.toString());
                }
                try {
                    String stringExtra3 = intent2.getStringExtra(Constants.KEY_DATA_ID);
                    String stringExtra4 = intent2.getStringExtra("appKey");
                    CharSequence stringExtra5 = intent2.getStringExtra(Constants.KEY_CONFIG_TAG);
                    if (intent.getPackage() == null) {
                        try {
                            intent2.setPackage(context.getPackageName());
                        } catch (Throwable th2222) {
                            th = th2222;
                            str = stringExtra2;
                            ALog.e("MsgDistribute", "distribMessage :", th, Constants.KEY_SERVICE_ID, str);
                            stringBuilder = new StringBuilder("distribute error ");
                            stringBuilder.append(intExtra);
                            stringBuilder.append(UtilityImpl.getStackMsg(th));
                            b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", stringBuilder.toString());
                        }
                    }
                    if ("accs".equals(stringExtra2)) {
                        ALog.e("MsgDistribute", "distribute", "command:", Integer.valueOf(intExtra), " serviceId:", stringExtra2, " dataId:", stringExtra3, "appkey", stringExtra4, "config", stringExtra5);
                    } else {
                        ALog.i("MsgDistribute", "distribute", "command:", Integer.valueOf(intExtra), " serviceId:", stringExtra2, " dataId:", stringExtra3, "appkey", stringExtra4, "config", stringExtra5);
                    }
                    if (!a(context2, intent2, stringExtra3, stringExtra2)) {
                        if (intExtra < 0) {
                            StringBuilder stringBuilder3 = new StringBuilder("command error:");
                            stringBuilder3.append(intExtra);
                            ALog.e("MsgDistribute", stringBuilder3.toString(), Constants.KEY_SERVICE_ID, stringExtra2);
                            return;
                        } else if (!a(intExtra, stringExtra2) && !b(context2, intent2, stringExtra3, stringExtra2)) {
                            IAppReceiver iAppReceiver;
                            Map appReceiver = GlobalClientInfo.getInstance(context).getAppReceiver();
                            if (TextUtils.isEmpty(stringExtra5)) {
                                iAppReceiver = null;
                            } else {
                                iAppReceiver = appReceiver != null ? (IAppReceiver) appReceiver.get(stringExtra5) : null;
                            }
                            Map map = appReceiver;
                            if (!a(context2, stringExtra2, stringExtra3, intent2, iAppReceiver)) {
                                String str2 = stringExtra4;
                                stringExtra4 = stringExtra3;
                                str = stringExtra2;
                                i = intExtra;
                                try {
                                    a(context2, intent2, str2, intExtra, stringExtra, stringExtra2, stringExtra3, iAppReceiver, intExtra2);
                                    if (TextUtils.isEmpty(str)) {
                                        a(context2, map, intent2, i, intExtra2);
                                        return;
                                    } else {
                                        a(context2, iAppReceiver, intent2, str, stringExtra4, i, intExtra2);
                                        return;
                                    }
                                } catch (Throwable th22222) {
                                    th = th22222;
                                    intExtra = i;
                                    ALog.e("MsgDistribute", "distribMessage :", th, Constants.KEY_SERVICE_ID, str);
                                    stringBuilder = new StringBuilder("distribute error ");
                                    stringBuilder.append(intExtra);
                                    stringBuilder.append(UtilityImpl.getStackMsg(th));
                                    b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", stringBuilder.toString());
                                }
                            }
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th222222) {
                    str = stringExtra2;
                    i = intExtra;
                    th = th222222;
                    ALog.e("MsgDistribute", "distribMessage :", th, Constants.KEY_SERVICE_ID, str);
                    stringBuilder = new StringBuilder("distribute error ");
                    stringBuilder.append(intExtra);
                    stringBuilder.append(UtilityImpl.getStackMsg(th));
                    b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", stringBuilder.toString());
                }
            }
            String str3 = "MsgDistribute";
            stringBuilder = new StringBuilder("action error ");
            stringBuilder.append(action);
            String stringBuilder4 = stringBuilder.toString();
            Object[] objArr = new Object[2];
            objArr[0] = Constants.KEY_SERVICE_ID;
            str = null;
            try {
                objArr[1] = null;
                ALog.e(str3, stringBuilder4, objArr);
                UTMini.getInstance().commitEvent(66001, "MsgToBuss10", action, Integer.valueOf(221));
            } catch (Throwable th3) {
                th222222 = th3;
                th = th222222;
                intExtra = 0;
                ALog.e("MsgDistribute", "distribMessage :", th, Constants.KEY_SERVICE_ID, str);
                stringBuilder = new StringBuilder("distribute error ");
                stringBuilder.append(intExtra);
                stringBuilder.append(UtilityImpl.getStackMsg(th));
                b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", stringBuilder.toString());
            }
        } catch (Throwable th4) {
            th222222 = th4;
            str = null;
            th = th222222;
            intExtra = 0;
            ALog.e("MsgDistribute", "distribMessage :", th, Constants.KEY_SERVICE_ID, str);
            stringBuilder = new StringBuilder("distribute error ");
            stringBuilder.append(intExtra);
            stringBuilder.append(UtilityImpl.getStackMsg(th));
            b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", stringBuilder.toString());
        }
    }

    protected boolean a(int i, String str) {
        if (i != 100 && GlobalClientInfo.AGOO_SERVICE_ID.equals(str) == 0) {
            long usableSpace = UtilityImpl.getUsableSpace();
            if (usableSpace != -1 && usableSpace <= 5242880) {
                StringBuilder stringBuilder = new StringBuilder("space low ");
                stringBuilder.append(usableSpace);
                b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", stringBuilder.toString());
                ALog.e("MsgDistribute", "user space low, don't distribute", "size", Long.valueOf(usableSpace), Constants.KEY_SERVICE_ID, str);
                return true;
            }
        }
        return false;
    }

    protected boolean a(Context context, String str, String str2, Intent intent, IAppReceiver iAppReceiver) {
        boolean z = false;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            CharSequence charSequence = null;
            if (iAppReceiver != null) {
                charSequence = iAppReceiver.getService(str);
            }
            if (TextUtils.isEmpty(charSequence) != null) {
                charSequence = GlobalClientInfo.getInstance(context).getService(str);
            }
            if (TextUtils.isEmpty(charSequence) != null && UtilityImpl.isMainProcess(context) == null) {
                if ("accs".equals(str) != null) {
                    ALog.e("MsgDistribute", "start MsgDistributeService", new Object[]{Constants.KEY_DATA_ID, str2});
                } else {
                    ALog.i("MsgDistribute", "start MsgDistributeService", new Object[]{Constants.KEY_DATA_ID, str2});
                }
                intent.setClassName(intent.getPackage(), c());
                context.startService(intent);
                z = true;
            }
            return z;
        } catch (Context context2) {
            ALog.e("MsgDistribute", "handleMsgInChannelProcess", context2, new Object[0]);
        }
    }

    private void a(Context context, Intent intent, String str, int i, String str2, String str3, String str4, IAppReceiver iAppReceiver, int i2) {
        if (iAppReceiver != null) {
            switch (i) {
                case 1:
                    if ((iAppReceiver instanceof IAppReceiverV1) != null) {
                        ((IAppReceiverV1) iAppReceiver).onBindApp(i2, null);
                    } else {
                        iAppReceiver.onBindApp(i2);
                    }
                    if (i2 == 200) {
                        try {
                            ALog.i("MsgDistribute", "start election by bindapp....", Constants.KEY_SERVICE_ID, str3);
                            a(context);
                            break;
                        } catch (Context context2) {
                            ALog.e("MsgDistribute", "start election is error", context2, Constants.KEY_SERVICE_ID, str3);
                            break;
                        }
                    }
                    break;
                case 2:
                    if (i2 == 200) {
                        UtilityImpl.disableService(context2);
                    }
                    iAppReceiver.onUnbindApp(i2);
                    break;
                case 3:
                    iAppReceiver.onBindUser(str2, i2);
                    break;
                case 4:
                    iAppReceiver.onUnbindUser(i2);
                    break;
                default:
                    switch (i) {
                        case 100:
                            if (TextUtils.isEmpty(str3) != null) {
                                iAppReceiver.onSendData(str4, i2);
                                break;
                            }
                            break;
                        case 101:
                            if (TextUtils.isEmpty(str3) != null) {
                                ALog.d("MsgDistribute", "serviceId isEmpty", new Object[0]);
                                context2 = intent.getByteArrayExtra("data");
                                if (context2 != null) {
                                    iAppReceiver.onData(str2, str4, context2);
                                    break;
                                }
                            }
                            break;
                        default:
                            break;
                    }
            }
        }
        if (i != 1 || GlobalClientInfo.b == null || str == null || str.equals(GlobalClientInfo.b.getAppkey()) == null) {
            if (!(iAppReceiver != null || i == 104 || i == 103)) {
                b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str3, "1", "appReceiver null return");
                ALog.w("MsgDistribute", "appReceiver null!", new Object[]{Constants.KEY_SERVICE_ID, str3, "appkey", str});
                context2 = new StringBuilder("commandId=");
                context2.append(i);
                String stringBuilder = context2.toString();
                context2 = new StringBuilder("serviceId=");
                context2.append(str3);
                context2.append(" errorCode=");
                context2.append(i2);
                context2.append(" dataId=");
                context2.append(str4);
                UTMini.getInstance().commitEvent(66001, "MsgToBuss7", stringBuilder, context2.toString(), Integer.valueOf(221));
            }
            return;
        }
        GlobalClientInfo.b.onBindApp(i2, null);
    }

    protected void a(Context context, IAppReceiver iAppReceiver, Intent intent, String str, String str2, int i, int i2) {
        iAppReceiver = iAppReceiver != null ? iAppReceiver.getService(str) : null;
        if (TextUtils.isEmpty(iAppReceiver)) {
            iAppReceiver = GlobalClientInfo.getInstance(context).getService(str);
        }
        if (TextUtils.isEmpty(iAppReceiver)) {
            iAppReceiver = GlobalClientInfo.getInstance(context).getListener(str);
            if (iAppReceiver != null) {
                AccsAbstractDataListener.onReceiveData(context, intent, iAppReceiver);
            } else {
                context = intent.getStringExtra("appKey");
                ALog.e("MsgDistribute", "callback is null", Constants.KEY_DATA_ID, str2, " serviceId", str, " command", Integer.valueOf(i), "appkey", context);
                b.a("accs", BaseMonitor.ALARM_POINT_REQ_ERROR, str, "1", "service is null");
            }
        } else {
            if (ALog.isPrintLog(Level.D)) {
                StringBuilder stringBuilder = new StringBuilder("to start service:");
                stringBuilder.append(iAppReceiver);
                ALog.d("MsgDistribute", stringBuilder.toString(), new Object[0]);
            }
            intent.setClassName(context, iAppReceiver);
            context.startService(intent);
        }
        context = new StringBuilder("commandId=");
        context.append(i);
        String stringBuilder2 = context.toString();
        context = new StringBuilder("serviceId=");
        context.append(str);
        context.append(" errorCode=");
        context.append(i2);
        context.append(" dataId=");
        context.append(str2);
        UTMini.getInstance().commitEvent(66001, "MsgToBuss", stringBuilder2, context.toString(), Integer.valueOf(221));
        iAppReceiver = BaseMonitor.COUNT_POINT_TO_BUSS;
        intent = new StringBuilder("2commandId=");
        intent.append(i);
        intent.append("serviceId=");
        intent.append(str);
        b.a("accs", iAppReceiver, intent.toString(), null);
    }

    protected void a(Context context, Map<String, IAppReceiver> map, Intent intent, int i, int i2) {
        Map hashMap = new HashMap();
        if (map != null) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Map allServices = ((IAppReceiver) ((Entry) map.next()).getValue()).getAllServices();
                if (allServices != null) {
                    hashMap.putAll(allServices);
                }
            }
        }
        String str;
        if (i == 103) {
            map = hashMap.keySet().iterator();
            while (map.hasNext() != 0) {
                str = (String) map.next();
                if ("accs".equals(str) || "windvane".equals(str) || "motu-remote".equals(str)) {
                    Object obj = (String) hashMap.get(str);
                    if (TextUtils.isEmpty(obj)) {
                        obj = GlobalClientInfo.getInstance(context).getService(str);
                    }
                    if (TextUtils.isEmpty(obj) == 0) {
                        intent.setClassName(context, obj);
                        context.startService(intent);
                    }
                }
            }
            map = intent.getBooleanExtra(Constants.KEY_CONNECT_AVAILABLE, false);
            String stringExtra = intent.getStringExtra("host");
            String stringExtra2 = intent.getStringExtra(Constants.KEY_ERROR_DETAIL);
            boolean booleanExtra = intent.getBooleanExtra(Constants.KEY_TYPE_INAPP, false);
            boolean booleanExtra2 = intent.getBooleanExtra(Constants.KEY_CENTER_HOST, false);
            intent = null;
            if (TextUtils.isEmpty(stringExtra) == 0) {
                if (map != null) {
                    intent = new ConnectInfo(stringExtra, booleanExtra, booleanExtra2);
                } else {
                    Intent connectInfo = new ConnectInfo(stringExtra, booleanExtra, booleanExtra2, i2, stringExtra2);
                }
                intent.connected = map;
            }
            if (intent != null) {
                map = new Intent(Constants.ACTION_CONNECT_INFO);
                map.setPackage(context.getPackageName());
                map.putExtra(Constants.KEY_CONNECT_INFO, intent);
                context.sendBroadcast(map);
                return;
            }
            ALog.e("MsgDistribute", "connect info null, host empty", new Object[0]);
        } else if (i == 104) {
            map = hashMap.keySet().iterator();
            while (map.hasNext() != 0) {
                str = (String) map.next();
                i2 = (String) hashMap.get(str);
                if (TextUtils.isEmpty(i2)) {
                    i2 = GlobalClientInfo.getInstance(context).getService(str);
                }
                if (TextUtils.isEmpty(i2) == 0) {
                    intent.setClassName(context, i2);
                    context.startService(intent);
                }
            }
        } else {
            map = new StringBuilder("distribMessage serviceId is null!! command:");
            map.append(i);
            ALog.i("MsgDistribute", map.toString(), new Object[0]);
        }
    }

    private void a(Context context) {
        if (com.taobao.accs.a.a.b()) {
            Intent intent = new Intent(com.taobao.accs.a.a.c());
            intent.putExtra("operate", Operate.TRY_ELECTION);
            intent.setPackage(context.getPackageName());
            intent.setClassName(context.getPackageName(), b());
            context.startService(intent);
        }
    }

    private boolean a(Context context, Intent intent, String str, String str2) {
        boolean booleanExtra = intent.getBooleanExtra("routingAck", false);
        boolean booleanExtra2 = intent.getBooleanExtra("routingMsg", false);
        if (booleanExtra) {
            ALog.e("MsgDistribute", "recieve routiong ack", Constants.KEY_DATA_ID, str, Constants.KEY_SERVICE_ID, str2);
            if (a != null) {
                a.remove(str);
            }
            b.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "");
            booleanExtra = true;
        } else {
            booleanExtra = false;
        }
        if (booleanExtra2) {
            try {
                intent = intent.getStringExtra(Constants.KEY_PACKAGE_NAME);
                ALog.e("MsgDistribute", "send routiong ack", Constants.KEY_DATA_ID, str, "to pkg", intent, Constants.KEY_SERVICE_ID, str2);
                Intent intent2 = new Intent(Constants.ACTION_COMMAND);
                intent2.putExtra("command", 106);
                intent2.setClassName(intent, a.channelService);
                intent2.putExtra("routingAck", true);
                intent2.putExtra(Constants.KEY_PACKAGE_NAME, intent);
                intent2.putExtra(Constants.KEY_DATA_ID, str);
                context.startService(intent2);
            } catch (Context context2) {
                ALog.e("MsgDistribute", "send routing ack", context2, Constants.KEY_SERVICE_ID, str2);
            }
        }
        return booleanExtra;
    }

    private boolean b(Context context, Intent intent, String str, String str2) {
        Intent intent2 = intent;
        String str3 = str;
        if (context.getPackageName().equals(intent.getPackage())) {
            return false;
        }
        try {
            ALog.e("MsgDistribute", "start MsgDistributeService", "receive pkg", context.getPackageName(), "target pkg", intent.getPackage(), Constants.KEY_SERVICE_ID, str2);
            intent2.setClassName(intent.getPackage(), a.msgService);
            intent2.putExtra("routingMsg", true);
            intent2.putExtra(Constants.KEY_PACKAGE_NAME, context.getPackageName());
            context.startService(intent);
            if (a == null) {
                a = new HashSet();
            }
            a.add(str3);
            ThreadPoolExecutorFactory.schedule(new f(this, str3, str2, context, intent2), 10, TimeUnit.SECONDS);
        } catch (Throwable th) {
            Throwable th2 = th;
            b.a("accs", BaseMonitor.ALARM_MSG_ROUTING_RATE, "", "exception", th2.toString());
            ALog.e("MsgDistribute", "routing msg error, try election", th2, Constants.KEY_SERVICE_ID, str2, Constants.KEY_DATA_ID, str3);
            a(context);
        }
        return true;
    }
}
