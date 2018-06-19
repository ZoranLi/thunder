package com.ut.mini;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.mtl.log.a;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.p;
import com.alibaba.mtl.log.model.LogField;
import com.ut.mini.base.UTMIVariables;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

public class UTTracker {
    private static Pattern a = Pattern.compile("(\\|\\||[\t\r\n])+");
    private Map<String, String> A = new HashMap();
    private String al = null;

    void p(String str) {
        this.al = str;
    }

    public synchronized void setGlobalProperty(String str, String str2) {
        if (TextUtils.isEmpty(str) || str2 == null) {
            i.b("setGlobalProperty", "key is null or key is empty or value is null,please check it!");
        } else {
            this.A.put(str, str2);
        }
    }

    public synchronized String getGlobalProperty(String str) {
        if (str == null) {
            return null;
        }
        return (String) this.A.get(str);
    }

    public synchronized void removeGlobalProperty(String str) {
        if (str != null) {
            if (this.A.containsKey(str)) {
                this.A.remove(str);
            }
        }
    }

    private static String f(String str) {
        return (str == null || "".equals(str)) ? str : a.matcher(str).replaceAll("");
    }

    private static String d(String str) {
        return f(str);
    }

    private Map<String, String> g(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        Map<String, String> hashMap = new HashMap();
        Iterator it = map.keySet().iterator();
        if (it != null) {
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str != null) {
                    hashMap.put(str, d((String) map.get(str)));
                }
            }
        }
        return hashMap;
    }

    public void send(Map<String, String> map) {
        if (map != null) {
            Map hashMap = new HashMap();
            hashMap.putAll(this.A);
            hashMap.putAll(map);
            Map g = g(hashMap);
            if (TextUtils.isEmpty(this.al) == null) {
                g.put(UTFields.TRACK_ID, this.al);
            }
            UTMIVariables.getInstance().isAliyunOSPlatform();
            f(g);
            d(g);
            g(g);
            h(g);
            a.a((String) g.remove(LogField.PAGE.toString()), (String) g.remove(LogField.EVENTID.toString()), (String) g.remove(LogField.ARG1.toString()), (String) g.remove(LogField.ARG2.toString()), (String) g.remove(LogField.ARG3.toString()), g);
        }
    }

    private static void f(Map<String, String> map) {
        if (map != null) {
            if (map.containsKey(LogField.IMEI.toString())) {
                map.remove(LogField.IMEI.toString());
            }
            if (map.containsKey(LogField.IMSI.toString())) {
                map.remove(LogField.IMSI.toString());
            }
            if (map.containsKey(LogField.CARRIER.toString())) {
                map.remove(LogField.CARRIER.toString());
            }
            if (map.containsKey(LogField.ACCESS.toString())) {
                map.remove(LogField.ACCESS.toString());
            }
            if (map.containsKey(LogField.ACCESS_SUBTYPE.toString())) {
                map.remove(LogField.ACCESS_SUBTYPE.toString());
            }
            if (map.containsKey(LogField.CHANNEL.toString())) {
                map.remove(LogField.CHANNEL.toString());
            }
            if (map.containsKey(LogField.LL_USERNICK.toString())) {
                map.remove(LogField.LL_USERNICK.toString());
            }
            if (map.containsKey(LogField.USERNICK.toString())) {
                map.remove(LogField.USERNICK.toString());
            }
            if (map.containsKey(LogField.LL_USERID.toString())) {
                map.remove(LogField.LL_USERID.toString());
            }
            if (map.containsKey(LogField.USERID.toString())) {
                map.remove(LogField.USERID.toString());
            }
            if (map.containsKey(LogField.SDKVERSION.toString())) {
                map.remove(LogField.SDKVERSION.toString());
            }
            if (map.containsKey(LogField.START_SESSION_TIMESTAMP.toString())) {
                map.remove(LogField.START_SESSION_TIMESTAMP.toString());
            }
            if (map.containsKey(LogField.UTDID.toString())) {
                map.remove(LogField.UTDID.toString());
            }
            if (map.containsKey(LogField.SDKTYPE.toString())) {
                map.remove(LogField.SDKTYPE.toString());
            }
            if (map.containsKey(LogField.RESERVE2.toString())) {
                map.remove(LogField.RESERVE2.toString());
            }
            if (map.containsKey(LogField.RESERVE3.toString())) {
                map.remove(LogField.RESERVE3.toString());
            }
            if (map.containsKey(LogField.RESERVE4.toString())) {
                map.remove(LogField.RESERVE4.toString());
            }
            if (map.containsKey(LogField.RESERVE5.toString())) {
                map.remove(LogField.RESERVE5.toString());
            }
            if (map.containsKey(LogField.RESERVES.toString())) {
                map.remove(LogField.RESERVES.toString());
            }
            if (map.containsKey(LogField.RECORD_TIMESTAMP.toString())) {
                map.remove(LogField.RECORD_TIMESTAMP.toString());
            }
        }
    }

    private static void d(Map<String, String> map) {
        if (map != null) {
            String str;
            if (map.containsKey(UTFields.OS)) {
                str = (String) map.get(UTFields.OS);
                map.remove(UTFields.OS);
                map.put(LogField.OS.toString(), str);
            }
            if (map.containsKey(UTFields.OS_VERSION)) {
                str = (String) map.get(UTFields.OS_VERSION);
                map.remove(UTFields.OS_VERSION);
                map.put(LogField.OSVERSION.toString(), str);
            }
        }
    }

    private static void m12g(Map<String, String> map) {
        map.put(LogField.SDKTYPE.toString(), "mini");
    }

    private static void h(Map<String, String> map) {
        Map hashMap = new HashMap();
        if (map.containsKey(UTFields.TRACK_ID)) {
            String str = (String) map.get(UTFields.TRACK_ID);
            map.remove(UTFields.TRACK_ID);
            if (!TextUtils.isEmpty(str)) {
                hashMap.put("_tkid", str);
            }
        }
        if (hashMap.size() > 0) {
            map.put(LogField.RESERVES.toString(), p.b(hashMap));
        }
        if (!map.containsKey(LogField.PAGE.toString())) {
            map.put(LogField.PAGE.toString(), "UT");
        }
    }

    public void pageAppear(Object obj) {
        UTPageHitHelper.getInstance().pageAppear(obj);
    }

    public void pageAppearDonotSkip(Object obj) {
        UTPageHitHelper.getInstance().a(obj, null, true);
    }

    public void pageAppearDonotSkip(Object obj, String str) {
        UTPageHitHelper.getInstance().a(obj, str, true);
    }

    public void pageAppear(Object obj, String str) {
        UTPageHitHelper.getInstance().pageAppear(obj, str);
    }

    public void pageDisAppear(Object obj) {
        UTPageHitHelper.getInstance().pageDisAppear(obj);
    }

    public void updateNextPageProperties(Map<String, String> map) {
        UTPageHitHelper.getInstance().updateNextPageProperties(map);
    }

    public void updatePageName(Object obj, String str) {
        UTPageHitHelper.getInstance().updatePageName(obj, str);
    }

    public void updatePageProperties(Object obj, Map<String, String> map) {
        UTPageHitHelper.getInstance().updatePageProperties(obj, map);
    }

    public void updatePageStatus(Object obj, UTPageStatus uTPageStatus) {
        UTPageHitHelper.getInstance().updatePageStatus(obj, uTPageStatus);
    }

    public void updatePageUrl(Object obj, Uri uri) {
        UTPageHitHelper.getInstance().updatePageUrl(obj, uri);
    }

    public void skipPage(Object obj) {
        UTPageHitHelper.getInstance().skipPage(obj);
    }
}
