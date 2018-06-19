package com.xunlei.downloadprovider.member.payment.external;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.common.new_ptl.pay.XLAllContractResp;
import com.xunlei.common.new_ptl.pay.XLContractResp;
import com.xunlei.common.new_ptl.pay.XLOnPayListener;
import com.xunlei.common.new_ptl.pay.XLPayUtil;
import com.xunlei.common.new_ptl.pay.param.XLAliPayContractParam;
import com.xunlei.common.new_ptl.pay.param.XLAlipayParam;
import com.xunlei.common.new_ptl.pay.param.XLContractParam;
import com.xunlei.common.new_ptl.pay.param.XLPayParam;
import com.xunlei.common.new_ptl.pay.param.XLPriceParam;
import com.xunlei.common.new_ptl.pay.param.XLWxContractParam;
import com.xunlei.common.new_ptl.pay.param.XLWxPayParam;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.a;
import com.xunlei.downloadprovider.member.payment.h;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: XLPaySDKManager */
public class l {
    private static volatile l b;
    public XLPayUtil a = XLPayUtil.getInstance();

    /* compiled from: XLPaySDKManager */
    public static class b implements XLOnPayListener {
        public void onAliPay(int i, String str, Object obj, String str2, int i2) {
        }

        public void onContractOperate(int i, String str, Object obj, int i2, XLContractResp xLContractResp) {
        }

        public void onGetPrice(int i, String str, Object obj, int i2, String str2) {
        }

        public void onQueryContract(int i, String str, Object obj, int i2, XLAllContractResp xLAllContractResp) {
        }

        public void onWxPay(int i, String str, Object obj, String str2, int i2) {
        }
    }

    /* compiled from: XLPaySDKManager */
    public static final class c implements XLPayParam {
        public int a;
        public int b;
        private String c;
        private int d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private boolean k;

        private c(int i, int i2) {
            this.a = -1;
            this.b = -1;
            this.g = "";
            this.h = "";
            this.k = false;
            this.a = i;
            this.b = i2;
            this.c = a.a(i, i2);
        }

        private c(String str) {
            this.a = -1;
            this.b = -1;
            this.g = "";
            this.h = "";
            this.k = false;
            h a = a.a(str);
            if (a != null) {
                this.a = a.a;
                this.b = a.b;
            }
            this.c = str;
        }

        public final long getUserId() {
            return LoginHelper.a().g.c();
        }

        public final String getSessionId() {
            return LoginHelper.a().c();
        }

        public final String getBizNo() {
            return TextUtils.isEmpty(this.c) ? "" : this.c;
        }

        public final int getNum() {
            if (this.d <= 0) {
                return 1;
            }
            return this.d;
        }

        public final String getCash() {
            return TextUtils.isEmpty(this.j) ? "" : this.j;
        }

        public final String getSource() {
            return TextUtils.isEmpty(this.e) ? "" : "shoulei_android";
        }

        public final String getReferFrom() {
            return TextUtils.isEmpty(this.f) ? "" : this.f;
        }

        public final String getAidFrom() {
            return TextUtils.isEmpty(this.g) ? "" : this.g;
        }

        public final String getUniqueOrderFlag() {
            return TextUtils.isEmpty(this.h) ? "" : this.h;
        }

        public final String getParamExt() {
            return TextUtils.isEmpty(this.i) ? "" : this.i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append(this.a);
            stringBuilder.append("|");
            stringBuilder.append(this.b);
            stringBuilder.append("|");
            stringBuilder.append(this.c);
            stringBuilder.append("|");
            stringBuilder.append(this.d);
            stringBuilder.append("|");
            stringBuilder.append(this.j);
            stringBuilder.append("|");
            stringBuilder.append(this.k);
            stringBuilder.append("|");
            stringBuilder.append(this.e);
            stringBuilder.append("|");
            stringBuilder.append(this.f);
            stringBuilder.append("|");
            stringBuilder.append(this.g);
            stringBuilder.append("|");
            stringBuilder.append(this.h);
            stringBuilder.append("|");
            stringBuilder.append(this.i);
            stringBuilder.append("|");
            return stringBuilder.toString();
        }
    }

    public static l a() {
        if (b == null) {
            synchronized (l.class) {
                if (b == null) {
                    b = new l();
                }
            }
        }
        return b;
    }

    private l() {
        this.a.init(BrothersApplication.getApplicationInstance(), 40, "5.60.2.5510", AndroidConfig.getHubbleDeviceGUID(BrothersApplication.getApplicationInstance()), "34a062aaa22f906fca4fefe9fb3a3021", false);
    }

    public final void a(XLOnPayListener xLOnPayListener) {
        this.a.attachListener(xLOnPayListener);
    }

    public final void b(XLOnPayListener xLOnPayListener) {
        this.a.detachListener(xLOnPayListener);
    }

    public final int a(int i, int i2, String str) {
        c cVar = new c(i, i2);
        cVar.f = str;
        a(cVar, 0);
        i = new XLPriceParam();
        i.mUserId = cVar.getUserId();
        i.mSessionId = cVar.getSessionId();
        i.mBizNo = cVar.getBizNo();
        i.mParamExt = cVar.getParamExt();
        return this.a.userGetPrice(i, cVar);
    }

    public final int a(@NonNull String str, int i, String str2, JSONObject jSONObject, Object obj) {
        StringBuilder stringBuilder = new StringBuilder("[wxPay] bizNo=");
        stringBuilder.append(str);
        stringBuilder.append(" ,reportRefer=");
        stringBuilder.append(str2);
        c cVar = new c(str);
        cVar.d = i;
        cVar.f = str2;
        a(cVar, jSONObject);
        if (obj == null) {
            obj = cVar;
        }
        str = new XLWxPayParam();
        str.mAppId = "wx3e6556568beeebdd";
        str.mActPay = cVar.k;
        str.mUserId = cVar.getUserId();
        str.mSessionId = cVar.getSessionId();
        str.mBizNo = cVar.getBizNo();
        str.mCash = cVar.getCash();
        str.mSource = cVar.getSource();
        str.mNum = cVar.getNum();
        str.mReferFrom = cVar.getReferFrom();
        str.mParamExt = cVar.getParamExt();
        str.mAidfrom = cVar.getAidFrom();
        str.mUniqueOrderFlag = cVar.getUniqueOrderFlag();
        return this.a.userWxPay(str, obj);
    }

    public final int a(@NonNull String str, int i, String str2, JSONObject jSONObject, @NonNull Activity activity, Object obj) {
        c cVar = new c(str);
        cVar.d = i;
        cVar.f = str2;
        a(cVar, jSONObject);
        str = new XLAlipayParam();
        str.mActivity = activity;
        str.mUserId = cVar.getUserId();
        str.mSessionId = cVar.getSessionId();
        str.mActPay = cVar.k;
        str.mBizNo = cVar.getBizNo();
        str.mNum = cVar.getNum();
        str.mCash = cVar.getCash();
        str.mSource = cVar.getSource();
        str.mReferFrom = cVar.getReferFrom();
        str.mAidfrom = cVar.getAidFrom();
        str.mUniqueOrderFlag = cVar.getUniqueOrderFlag();
        str.mParamExt = cVar.getParamExt();
        if (obj == null) {
            obj = cVar;
        }
        return this.a.userAliPay(str, obj);
    }

    private static void a(@NonNull c cVar, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("key:voucher");
            String optString2 = jSONObject.optString("key:ext");
            cVar.g = jSONObject.optString("key:aid_from");
            cVar.j = optString;
            cVar.i = optString2;
            jSONObject = jSONObject.optString("key:activity_id");
            if (!TextUtils.isEmpty(jSONObject)) {
                cVar.c = jSONObject;
                cVar.k = true;
            }
        }
        if (TextUtils.isEmpty(cVar.e) != null) {
            cVar.e = "shoulei_android";
        }
        new StringBuilder("[pkgCommonXlPayParam] before encode extParam：").append(cVar.i);
        jSONObject = new StringBuilder();
        jSONObject.append("source=");
        jSONObject.append(cVar.e);
        if (TextUtils.isEmpty(cVar.i)) {
            cVar.i = URLEncoder.encode(jSONObject.toString());
        } else {
            jSONObject.append("&");
            if (TextUtils.equals(cVar.i, URLDecoder.decode(cVar.i))) {
                jSONObject.append(cVar.i);
                cVar.i = URLEncoder.encode(jSONObject.toString());
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(URLEncoder.encode(jSONObject.toString()));
                stringBuilder.append(cVar.i);
                cVar.i = stringBuilder.toString();
            }
        }
        new StringBuilder("[pkgCommonXlPayParam] after encode ：").append(cVar.toString());
    }

    public static XLAliPayContractParam a(int i, int i2, int i3, @NonNull String str, JSONObject jSONObject, String str2) {
        c cVar = new c(i, i2);
        cVar.d = i3;
        cVar.f = str2;
        a(cVar, jSONObject);
        i2 = new XLAliPayContractParam();
        i2.mContractResultScheme = str;
        i2.mUserId = cVar.getUserId();
        i2.mSessionId = cVar.getSessionId();
        i2.mBizNo = i3 == Integer.MAX_VALUE ? a.a(i) : cVar.getBizNo();
        if (i3 == Integer.MAX_VALUE) {
            i = 1;
        } else {
            i = cVar.getNum();
        }
        i2.mNum = i;
        i2.mCash = cVar.getCash();
        i2.mSource = cVar.getSource();
        i2.mReferFrom = cVar.getReferFrom();
        i2.mAidfrom = cVar.getAidFrom();
        i2.mUniqueOrderFlag = cVar.getUniqueOrderFlag();
        i2.mParamExt = cVar.getParamExt();
        return i2;
    }

    public static XLWxContractParam a(int i, int i2, int i3, JSONObject jSONObject, String str) {
        c cVar = new c(i, i2);
        cVar.d = i3;
        cVar.f = str;
        a(cVar, jSONObject);
        i2 = new XLWxContractParam();
        i2.mWxAppId = "wx3e6556568beeebdd";
        i2.mUserId = cVar.getUserId();
        i2.mSessionId = cVar.getSessionId();
        i2.mBizNo = i3 == Integer.MAX_VALUE ? a.a(i) : cVar.getBizNo();
        if (i3 == Integer.MAX_VALUE) {
            i = 1;
        } else {
            i = cVar.getNum();
        }
        i2.mNum = i;
        i2.mCash = cVar.getCash();
        i2.mSource = cVar.getSource();
        i2.mReferFrom = cVar.getReferFrom();
        i2.mAidfrom = cVar.getAidFrom();
        i2.mUniqueOrderFlag = cVar.getUniqueOrderFlag();
        i2.mParamExt = cVar.getParamExt();
        return i2;
    }

    public static JSONObject a(String str, String str2, String str3, String str4) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("key:voucher", str);
            }
            if (TextUtils.isEmpty(str2) == null) {
                jSONObject.put("key:ext", b(str2));
            }
            if (TextUtils.isEmpty(str3) == null) {
                jSONObject.put("key:activity_id", str3);
            }
            if (TextUtils.isEmpty(str4) == null) {
                jSONObject.put("key:aid_from", str4);
            }
            return jSONObject;
        } catch (String str5) {
            str5.printStackTrace();
            return null;
        }
    }

    public static JSONObject a(String str, String str2, String str3) {
        return a(str, str2, null, str3);
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder(64);
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("&");
                }
                String str2 = (String) keys.next();
                String string = jSONObject.getString(str2);
                if (TextUtils.equals(str2, URLDecoder.decode(str2))) {
                    stringBuilder.append(str2);
                } else {
                    stringBuilder.append(URLEncoder.encode(str2));
                }
                stringBuilder.append("=");
                if (TextUtils.equals(string, URLDecoder.decode(string))) {
                    stringBuilder.append(string);
                } else {
                    stringBuilder.append(URLEncoder.encode(string));
                }
            }
            str = stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public final int b() {
        c cVar = new c("");
        XLContractParam xLContractParam = new XLContractParam();
        if (!TextUtils.isEmpty(cVar.getBizNo())) {
            xLContractParam.mBizNo = cVar.getBizNo();
            xLContractParam.mPayType = -1;
        }
        xLContractParam.mUserId = cVar.getUserId();
        xLContractParam.mSessionId = cVar.getSessionId();
        return this.a.userQueryContract(xLContractParam, cVar);
    }
}
