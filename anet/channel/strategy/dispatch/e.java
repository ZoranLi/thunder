package anet.channel.strategy.dispatch;

import android.os.Build.VERSION;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import com.taobao.accs.antibrush.b;
import java.util.Map;
import java.util.Set;

/* compiled from: Taobao */
class e {
    public static final String TAG = "amdc.DispatchParamBuilder";

    e() {
    }

    public static Map a(Map<String, Object> map) {
        IAmdcSign b = a.b();
        if (b != null) {
            if (!TextUtils.isEmpty(b.getAppkey())) {
                map.put("appkey", b.getAppkey());
                map.put("v", DispatchConstants.VER_CODE);
                map.put("platform", DispatchConstants.ANDROID);
                map.put(DispatchConstants.PLATFORM_VERSION, VERSION.RELEASE);
                if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getUserId())) {
                    map.put("sid", GlobalAppRuntimeInfo.getUserId());
                }
                if (!TextUtils.isEmpty(GlobalAppRuntimeInfo.getUtdid())) {
                    map.put("deviceId", GlobalAppRuntimeInfo.getUtdid());
                }
                NetworkStatus a = NetworkStatusHelper.a();
                map.put(DispatchConstants.NET_TYPE, a.toString());
                if (a.isWifi()) {
                    map.put(DispatchConstants.BSSID, NetworkStatusHelper.f());
                }
                map.put(DispatchConstants.CARRIER, NetworkStatusHelper.d());
                map.put(DispatchConstants.MNC, NetworkStatusHelper.e());
                map.put(DispatchConstants.LATITUDE, String.valueOf(a.a));
                map.put(DispatchConstants.LONGTITUDE, String.valueOf(a.b));
                c(map);
                map.put(DispatchConstants.DOMAIN, b(map));
                map.put(DispatchConstants.SIGNTYPE, b.useSecurityGuard() ? b.KEY_SEC : "noSec");
                map.put(DispatchConstants.TIMESTAMP, String.valueOf(System.currentTimeMillis()));
                CharSequence a2 = a(b, map);
                if (TextUtils.isEmpty(a2)) {
                    return null;
                }
                map.put("sign", a2);
                return map;
            }
        }
        return null;
    }

    private static String b(Map map) {
        Set<String> set = (Set) map.remove(DispatchConstants.HOSTS);
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : set) {
            stringBuilder.append(append);
            stringBuilder.append(' ');
        }
        if (stringBuilder.length() > null) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static void c(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = anet.channel.GlobalAppRuntimeInfo.getTtid();	 Catch:{ Exception -> 0x0046 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0046 }
        if (r1 != 0) goto L_0x0045;	 Catch:{ Exception -> 0x0046 }
    L_0x000a:
        r1 = "@";	 Catch:{ Exception -> 0x0046 }
        r1 = r0.indexOf(r1);	 Catch:{ Exception -> 0x0046 }
        r2 = 0;	 Catch:{ Exception -> 0x0046 }
        r3 = -1;	 Catch:{ Exception -> 0x0046 }
        if (r1 == r3) goto L_0x001d;	 Catch:{ Exception -> 0x0046 }
    L_0x0014:
        r4 = "channel";	 Catch:{ Exception -> 0x0046 }
        r5 = r0.substring(r2, r1);	 Catch:{ Exception -> 0x0046 }
        r6.put(r4, r5);	 Catch:{ Exception -> 0x0046 }
    L_0x001d:
        r1 = r1 + 1;	 Catch:{ Exception -> 0x0046 }
        r0 = r0.substring(r1);	 Catch:{ Exception -> 0x0046 }
        r1 = "_";	 Catch:{ Exception -> 0x0046 }
        r1 = r0.lastIndexOf(r1);	 Catch:{ Exception -> 0x0046 }
        if (r1 == r3) goto L_0x0040;	 Catch:{ Exception -> 0x0046 }
    L_0x002b:
        r3 = "appName";	 Catch:{ Exception -> 0x0046 }
        r2 = r0.substring(r2, r1);	 Catch:{ Exception -> 0x0046 }
        r6.put(r3, r2);	 Catch:{ Exception -> 0x0046 }
        r2 = "appVersion";	 Catch:{ Exception -> 0x0046 }
        r1 = r1 + 1;	 Catch:{ Exception -> 0x0046 }
        r0 = r0.substring(r1);	 Catch:{ Exception -> 0x0046 }
        r6.put(r2, r0);	 Catch:{ Exception -> 0x0046 }
        return;	 Catch:{ Exception -> 0x0046 }
    L_0x0040:
        r1 = "appName";	 Catch:{ Exception -> 0x0046 }
        r6.put(r1, r0);	 Catch:{ Exception -> 0x0046 }
    L_0x0045:
        return;
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.strategy.dispatch.e.c(java.util.Map):void");
    }

    static String a(IAmdcSign iAmdcSign, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(d.c((String) map.get("appkey")));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.DOMAIN)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get("appName")));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get("appVersion")));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.BSSID)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get("channel")));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get("deviceId")));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.LATITUDE)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.LONGTITUDE)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.MACHINE)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.NET_TYPE)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.OTHER)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get("platform")));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.PLATFORM_VERSION)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.PRE_IP)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get("sid")));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.TIMESTAMP)));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get("v")));
        stringBuilder.append("&");
        stringBuilder.append(d.c((String) map.get(DispatchConstants.SIGNTYPE)));
        try {
            return iAmdcSign.sign(stringBuilder.toString());
        } catch (IAmdcSign iAmdcSign2) {
            ALog.e(TAG, "get sign failed", null, iAmdcSign2, new Object[0]);
            return null;
        }
    }
}
