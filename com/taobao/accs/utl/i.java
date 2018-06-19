package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.ChannelService;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.xiaomi.push.service.av;
import com.xunlei.download.Downloads.Impl.RequestHeaders;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
public class i {
    public static final String NAMESPACE = "accs";
    private static boolean a = false;

    /* compiled from: Taobao */
    public static class a implements OrangeConfigListenerV1 {
        public void onConfigUpdate(String str, boolean z) {
            if (GlobalClientInfo.getContext()) {
                try {
                    ALog.i("OrangeAdapter", "onConfigUpdate", "namespace", str);
                    if (!(str == null || "accs".equals(str) == null)) {
                        i.f();
                        i.e();
                    }
                    return;
                } catch (String str2) {
                    ALog.e("OrangeAdapter", "onConfigUpdate", str2, new Object[0]);
                    return;
                }
            }
            ALog.e("OrangeAdapter", "onConfigUpdate context null", new Object[0]);
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "com.taobao.orange.OrangeConfig";	 Catch:{ Exception -> 0x0009 }
        java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0009 }
        r0 = 1;	 Catch:{ Exception -> 0x0009 }
        a = r0;	 Catch:{ Exception -> 0x0009 }
        return;
    L_0x0009:
        r0 = 0;
        a = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.i.<clinit>():void");
    }

    public static void a(String[] strArr, OrangeConfigListenerV1 orangeConfigListenerV1) {
        if (a) {
            OrangeConfig.getInstance().registerListener(strArr, orangeConfigListenerV1);
        } else {
            ALog.w("OrangeAdapter", "no orange sdk", new Object[0]);
        }
    }

    public static String a(String str, String str2, String str3) {
        if (a) {
            return OrangeConfig.getInstance().getConfig(str, str2, str3);
        }
        ALog.w("OrangeAdapter", "no orange sdk", new Object[0]);
        return str3;
    }

    public static boolean a() {
        boolean booleanValue;
        try {
            booleanValue = Boolean.valueOf(a("accs", "main_function_enable", "true")).booleanValue();
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "isAccsEnabled", th, new Object[0]);
            booleanValue = true;
        }
        ALog.i("OrangeAdapter", "isAccsEnabled", "enable", Boolean.valueOf(booleanValue));
        return booleanValue;
    }

    public static boolean b() {
        boolean a;
        try {
            a = a(GlobalClientInfo.getContext(), Constants.SP_KEY_HB_SMART_ENABLE, true);
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "isSmartHb", th, new Object[0]);
            a = true;
        }
        ALog.d("OrangeAdapter", "isSmartHb", "result", Boolean.valueOf(a));
        return a;
    }

    public static boolean a(boolean z) {
        boolean z2;
        try {
            String str = AccsClientConfig.DEFAULT_CONFIGTAG;
            if (z) {
                str = a("accs", Constants.SP_KEY_TNET_LOG_OFF, AccsClientConfig.DEFAULT_CONFIGTAG);
            }
            if (str.equals(AccsClientConfig.DEFAULT_CONFIGTAG)) {
                z = a(GlobalClientInfo.getContext(), Constants.SP_KEY_TNET_LOG_OFF, true);
            } else {
                z = Boolean.valueOf(str).booleanValue();
                try {
                    b(GlobalClientInfo.getContext(), Constants.SP_KEY_TNET_LOG_OFF, z);
                } catch (Throwable th) {
                    Throwable th2 = th;
                    z2 = z;
                    z = th2;
                    ALog.e("OrangeAdapter", "isTnetLogOff", z, new Object[0]);
                    z = z2;
                    ALog.i("OrangeAdapter", "isTnetLogOff", "result", Boolean.valueOf(z));
                    return z;
                }
            }
        } catch (Throwable th3) {
            z = th3;
            z2 = true;
            ALog.e("OrangeAdapter", "isTnetLogOff", z, new Object[0]);
            z = z2;
            ALog.i("OrangeAdapter", "isTnetLogOff", "result", Boolean.valueOf(z));
            return z;
        }
        ALog.i("OrangeAdapter", "isTnetLogOff", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean c() {
        boolean z = GlobalClientInfo.d;
        try {
            z = a(GlobalClientInfo.getContext(), Constants.SP_KEY_ELECTION_ENABLE, GlobalClientInfo.d);
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "isElectionEnable", th, new Object[0]);
        }
        if (!z) {
            ALog.i("OrangeAdapter", "isElectionEnable", "result", Boolean.valueOf(z));
        }
        return z;
    }

    private static boolean a(Context context, String str, boolean z) {
        try {
            return context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(str, z);
        } catch (Context context2) {
            ALog.e("OrangeAdapter", "getConfigFromSP fail:", context2, "key", str);
            return z;
        }
    }

    private static void b(Context context, String str, boolean z) {
        if (context == null) {
            try {
                ALog.e("OrangeAdapter", "saveTLogOffToSP context null", new Object[0]);
            } catch (Context context2) {
                ALog.e("OrangeAdapter", "saveConfigToSP fail:", context2, "key", str, RequestHeaders.COLUMN_VALUE, Boolean.valueOf(z));
            }
        } else {
            context2 = context2.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            context2.putBoolean(str, z);
            context2.apply();
            ALog.i("OrangeAdapter", "saveConfigToSP", "key", str, RequestHeaders.COLUMN_VALUE, Boolean.valueOf(z));
        }
    }

    public static void a(Context context, String str, int i) {
        if (context == null) {
            try {
                ALog.e("OrangeAdapter", "saveTLogOffToSP context null", new Object[0]);
            } catch (Context context2) {
                ALog.e("OrangeAdapter", "saveConfigToSP fail:", context2, "key", str, RequestHeaders.COLUMN_VALUE, Integer.valueOf(i));
            }
        } else {
            context2 = context2.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            context2.putInt(str, i);
            context2.apply();
            ALog.i("OrangeAdapter", "saveConfigToSP", "key", str, RequestHeaders.COLUMN_VALUE, Integer.valueOf(i));
        }
    }

    private static void a(Context context, Map<String, Boolean> map) {
        if (map != null) {
            try {
                if (map.size() != 0) {
                    context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                    for (Entry entry : map.entrySet()) {
                        context.putBoolean((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
                    }
                    context.apply();
                    ALog.i("OrangeAdapter", "saveConfigsToSP", "configs", map.toString());
                }
            } catch (Context context2) {
                ALog.e("OrangeAdapter", "saveConfigsToSP fail:", context2, "configs", map.toString());
            }
        }
    }

    private static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                Editor edit = GlobalClientInfo.getContext().getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putString("pullup", str);
                edit.apply();
            } catch (Throwable th) {
                ALog.e("OrangeAdapter", "savePullupInfo fail:", th, "pullup", str);
            }
            ALog.i("OrangeAdapter", "savePullupInfo", "pullup", str);
        }
    }

    public static String d() {
        try {
            return GlobalClientInfo.getContext().getSharedPreferences(Constants.SP_FILE_NAME, 0).getString("pullup", null);
        } catch (Throwable th) {
            ALog.e("OrangeAdapter", "getPullupInfo fail:", th, new Object[0]);
            return null;
        }
    }

    public static void e() {
        Map hashMap = new HashMap();
        hashMap.put(Constants.SP_KEY_TNET_LOG_OFF, Boolean.valueOf(a("accs", Constants.SP_KEY_TNET_LOG_OFF, av.b)));
        hashMap.put(Constants.SP_KEY_ELECTION_ENABLE, Boolean.valueOf(a("accs", Constants.SP_KEY_ELECTION_ENABLE, String.valueOf(GlobalClientInfo.d))));
        hashMap.put(Constants.SP_KEY_HB_SMART_ENABLE, Boolean.valueOf(a("accs", "heartbeat_smart_enable", "true")));
        a(GlobalClientInfo.getContext(), hashMap);
        a(GlobalClientInfo.getContext(), ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, UtilityImpl.String2Int(a("accs", ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, AgooConstants.REPORT_NOT_ENCRYPT)));
        a(a("accs", "pullup", null));
    }

    public static void f() {
        if (!a()) {
            ALog.e("OrangeAdapter", "force disable service", new Object[0]);
            ACCSManager.forceDisableService(GlobalClientInfo.getContext());
        } else if (UtilityImpl.getFocusDisableStatus(GlobalClientInfo.getContext())) {
            ALog.i("OrangeAdapter", "force enable service", new Object[0]);
            ACCSManager.forceEnableService(GlobalClientInfo.getContext());
        }
    }
}
