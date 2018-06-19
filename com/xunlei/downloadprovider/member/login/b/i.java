package com.xunlei.downloadprovider.member.login.b;

import android.graphics.Bitmap;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.XLUserUtil;
import com.xunlei.downloadprovider.member.login.b;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

/* compiled from: UserInfoImpl */
public class i {
    private static final String h = "com.xunlei.downloadprovider.member.login.b.i";
    private static i i;
    public ArrayList<h> a = new ArrayList();
    public ArrayList<k> b = new ArrayList();
    public ArrayList<e$f> c = new ArrayList();
    public ArrayList<e$d> d = new ArrayList();
    public XLUserInfo e;
    public long f = 0;
    public long g = 0;
    private b j;

    public static String b(int i) {
        return i != 1 ? i != 15 ? i != 21 ? "" : "wx3e6556568beeebdd" : "1101105049" : "4286195229";
    }

    private i() {
    }

    public static i a() {
        if (i == null) {
            synchronized (i.class) {
                if (i == null) {
                    i = new i();
                }
            }
        }
        return i;
    }

    public static int a(XLOnUserListener xLOnUserListener) {
        return XLUserUtil.getInstance().userGetInfo(xLOnUserListener, 14, null);
    }

    public final void b() {
        if (this.e == null) {
            this.e = XLUserUtil.getInstance().getCurrentUser();
        }
    }

    public final long c() {
        b();
        return this.e.getLongValue(USERINFOKEY.UserID);
    }

    public final String d() {
        b();
        return this.e.getStringValue(USERINFOKEY.NickName);
    }

    public final String a(int i) {
        b();
        return this.e.getAvatarUrl(i);
    }

    public final int e() {
        b();
        return this.e.getIntValue(USERINFOKEY.IsVip);
    }

    public final int f() {
        b();
        return this.e.getIntValue(USERINFOKEY.VasType);
    }

    public final boolean g() {
        if (e() != 1) {
            b h = h();
            boolean z = h != null && h.a == 1;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final b h() {
        if (this.j == null) {
            i();
        }
        return this.j;
    }

    public static int b(XLOnUserListener xLOnUserListener) {
        return XLUserUtil.getInstance().userGetCityInfo(xLOnUserListener, null);
    }

    public static void c(XLOnUserListener xLOnUserListener) {
        XLUserUtil.getInstance().userGetCityCodeByIp(xLOnUserListener, null);
    }

    public static void d(XLOnUserListener xLOnUserListener) {
        XLUserUtil.getInstance().userGetBindedOtherAccount(xLOnUserListener, null);
    }

    public static void e(XLOnUserListener xLOnUserListener) {
        XLUserUtil.getInstance().userGetHighSpeedCapacity(xLOnUserListener, null);
    }

    public static void f(XLOnUserListener xLOnUserListener) {
        XLUserUtil.getInstance().userGetLixianCapacity(xLOnUserListener, null);
    }

    public static void g(XLOnUserListener xLOnUserListener) {
        XLUserUtil.getInstance().userGetVerifyCode(xLOnUserListener, null);
    }

    public final void i() {
        b();
        this.j = new b();
        this.j.a = this.e.getIntValue(USERINFOKEY.IsVip, 14);
        this.j.b = this.e.getIntValue(USERINFOKEY.vip_level, 14);
        this.j.c = this.e.getStringValue(USERINFOKEY.ExpireDate, 14);
        this.j.d = this.e.getIntValue(USERINFOKEY.VasType, 14);
        this.j.e = this.e.getStringValue(USERINFOKEY.PayName, 14);
        this.j.f = this.e.getIntValue(USERINFOKEY.VipGrow, 14);
        this.j.g = this.e.getIntValue(USERINFOKEY.VipDayGrow, 14);
        this.j.h = this.e.getIntValue(USERINFOKEY.IsAutoDeduct, 14);
        this.j.i = this.e.getIntValue(USERINFOKEY.IsRemind, 14);
        this.j.j = this.e.getIntValue(USERINFOKEY.PayId, 14);
        this.j.k = this.e.getIntValue(USERINFOKEY.IsYear, 14);
        this.j.l = this.e.getStringValue(USERINFOKEY.Rigster, 14);
    }

    public static void j() {
        XLUserUtil.getInstance().getCurrentUser().clearUserData();
    }

    public static void k() {
        XLUserUtil.getInstance().clearAutoLoginPassword(true);
    }

    public final void a(int i, b bVar) {
        ArrayList arrayList = new ArrayList(this.d);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((e$d) arrayList.get(i2)).a(i, bVar);
        }
    }

    public static void a(XLOnUserListener xLOnUserListener, Bitmap bitmap, String str) {
        if (bitmap != null) {
            XLUserUtil.getInstance().userSetAvatar(bitmap, xLOnUserListener, str);
        }
    }

    public static void a(XLOnUserListener xLOnUserListener, Map<USERINFOKEY, String> map, Object obj) {
        StringBuilder stringBuilder = new StringBuilder("{");
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            String str;
            Entry entry = (Entry) map.next();
            USERINFOKEY userinfokey = (USERINFOKEY) entry.getKey();
            switch (j.a[userinfokey.ordinal()]) {
                case 1:
                    str = INoCaptchaComponent.sig;
                    break;
                case 2:
                    str = "citycode";
                    break;
                case 3:
                    str = "provincecode";
                    break;
                default:
                    str = userinfokey.toString().toLowerCase();
                    break;
            }
            String str2 = (String) entry.getValue();
            stringBuilder.append("\"");
            stringBuilder.append(str);
            stringBuilder.append("\":\"");
            stringBuilder.append(str2);
            stringBuilder.append("\",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append('}');
        try {
            XLUserUtil.getInstance().userSetInfo(new JSONObject(stringBuilder.toString()), "", "", xLOnUserListener, obj);
        } catch (XLOnUserListener xLOnUserListener2) {
            xLOnUserListener2.printStackTrace();
        }
    }

    public static void a(String str, XLUserInfo xLUserInfo, int i, String str2) {
        StringBuilder stringBuilder = new StringBuilder("XLUserInfo < ");
        stringBuilder.append(str);
        stringBuilder.append(" >\nerrorCode = ");
        stringBuilder.append(i);
        stringBuilder.append("\nerrorDesc = ");
        stringBuilder.append(str2);
        stringBuilder.append("\nuserId = ");
        stringBuilder.append(xLUserInfo.getLongValue(USERINFOKEY.UserID));
        stringBuilder.append("\nsessionId = ");
        stringBuilder.append(xLUserInfo.getStringValue(USERINFOKEY.SessionID));
        stringBuilder.append("\npayId = ");
        stringBuilder.append(xLUserInfo.getIntValue(USERINFOKEY.PayId));
        stringBuilder.append("\nusername = ");
        stringBuilder.append(xLUserInfo.getStringValue(USERINFOKEY.UserName));
        stringBuilder.append("\nnickName = ");
        stringBuilder.append(xLUserInfo.getStringValue(USERINFOKEY.NickName));
        stringBuilder.append("\npersonalSign = ");
        stringBuilder.append(xLUserInfo.getStringValue(USERINFOKEY.PersonalSign));
        stringBuilder.append("\nisVip = ");
        i = 1;
        if (xLUserInfo.getIntValue(USERINFOKEY.IsVip) != 1) {
            i = 0;
        }
        stringBuilder.append(i);
        stringBuilder.append("\nlevel = ");
        stringBuilder.append(xLUserInfo.getIntValue(USERINFOKEY.vip_level));
        stringBuilder.append("\nmemberType = ");
        stringBuilder.append(xLUserInfo.getIntValue(USERINFOKEY.VasType));
        stringBuilder.append("\nportraitPath = ");
        stringBuilder.append(xLUserInfo.getAvatarUrl(300));
        stringBuilder.append("\nprovince = ");
        stringBuilder.append(xLUserInfo.getStringValue(USERINFOKEY.Province));
        stringBuilder.append("\ncity = ");
        stringBuilder.append(xLUserInfo.getStringValue(USERINFOKEY.City));
    }
}
