package com.xunlei.downloadprovider.member.login.b;

import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: UserLoginImpl */
public class l {
    private static l e;
    public ArrayList<d> a = new ArrayList();
    public ArrayList<c> b = new ArrayList();
    public ArrayList<c> c = new ArrayList();
    public ArrayList<g> d = new ArrayList();

    private l() {
    }

    public static l a() {
        if (e == null) {
            synchronized (l.class) {
                if (e == null) {
                    e = new l();
                }
            }
        }
        return e;
    }

    public static int a(String str, String str2, String str3, String str4, XLOnUserListener xLOnUserListener, Object obj) {
        return XLUserUtil.getInstance().userAccountLogin(str, str2, str3, str4, xLOnUserListener, obj);
    }

    public static int a(XLOnUserListener xLOnUserListener, Object obj) {
        return XLUserUtil.getInstance().userAutoLogin(xLOnUserListener, obj);
    }

    public static int a(int i, Object obj, XLOnUserListener xLOnUserListener, Object obj2) {
        return XLUserUtil.getInstance().userThirdLogin(i, obj, xLOnUserListener, obj2);
    }

    public static Map<String, String> a(String str, String str2) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("loginFrom", str);
        hashMap.put("from", str2);
        return hashMap;
    }

    public static int a(XLOnUserListener xLOnUserListener) {
        return XLUserUtil.getInstance().userLogout(xLOnUserListener, null);
    }

    public static boolean b() {
        return XLUserUtil.getInstance().userIsOnline();
    }

    public static boolean c() {
        return XLUserUtil.getInstance().userIsLogined();
    }

    public static void a(boolean z) {
        XLUserUtil.getInstance().setKeepAlive(z, 300000);
    }

    public final void a(c cVar) {
        if (cVar != null && !this.b.contains(cVar)) {
            this.b.add(cVar);
        }
    }
}
