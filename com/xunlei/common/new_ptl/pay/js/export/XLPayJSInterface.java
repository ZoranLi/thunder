package com.xunlei.common.new_ptl.pay.js.export;

import android.webkit.JavascriptInterface;
import com.umeng.message.proguard.k;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.pay.XLPayErrorCode;
import com.xunlei.common.new_ptl.pay.a.a;
import com.xunlei.common.new_ptl.pay.js.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class XLPayJSInterface {
    public static final String XL_JS_PREFIX = "javascript:";
    private String TAG = XLPayJSInterface.class.getSimpleName();
    private Map<Integer, a> mRequestCallBackList = new HashMap();
    private c mXLPayJSRegister = null;

    public class XLPayJSMethodName {
        public static final String ALI_PAY = "ALI_PAY";
        public static final String NB_PAY = "NB_PAY";
        public static final String WX_PAY = "WX_PAY";
    }

    public void init(c cVar) {
        this.mXLPayJSRegister = cVar;
    }

    public void unInit() {
        this.mXLPayJSRegister = null;
    }

    public void receiveMessage(int i, String str, Object obj, int i2) {
        obj = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("receive pay callback message errorcode = ");
        stringBuilder.append(i);
        stringBuilder.append("#thread = ");
        stringBuilder.append(Thread.currentThread().getId());
        XLLog.v(obj, stringBuilder.toString());
        a aVar = (a) this.mRequestCallBackList.get(Integer.valueOf(i2));
        if (aVar != null) {
            javaCallBackToJS$5bb80e1f(aVar, i, str);
            this.mRequestCallBackList.remove(Integer.valueOf(i2));
        }
    }

    private int dispatchMessage(String str, String str2) {
        if (XLPayJSMethodName.WX_PAY.equals(str)) {
            return userWxPay(str2);
        }
        return XLPayJSMethodName.ALI_PAY.equals(str) != null ? userAliPay(str2) : null;
    }

    @JavascriptInterface
    public int sendMessage(String str, String str2, String str3, String str4) {
        String str5 = this.TAG;
        StringBuilder stringBuilder = new StringBuilder("receive message from javascript method = ");
        stringBuilder.append(str);
        stringBuilder.append("#param = ");
        stringBuilder.append(str2);
        stringBuilder.append("#Thread = ");
        stringBuilder.append(Thread.currentThread().getId());
        XLLog.v(str5, stringBuilder.toString());
        str2 = dispatchMessage(str, str2);
        if (str2 > null) {
            this.mRequestCallBackList.put(Integer.valueOf(str2), new a(str, str4, str3));
        } else {
            str5 = this.TAG;
            stringBuilder = new StringBuilder("call sdk pay interface error = ");
            stringBuilder.append(str2);
            XLLog.v(str5, stringBuilder.toString());
            javaCallBackToJS(str, str3, str4, 150, XLPayErrorCode.getErrorDesc(150));
        }
        return str2;
    }

    private void javaCallBackToJS$5bb80e1f(a aVar, int i, String str) {
        javaCallBackToJS(aVar.a, aVar.c, aVar.b, i, str);
    }

    private void javaCallBackToJS(String str, String str2, String str3, int i, String str4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("javascript:");
        stringBuffer.append(str2);
        stringBuffer.append(k.s);
        stringBuffer.append(i);
        stringBuffer.append(",'");
        stringBuffer.append(processStringParam(str4));
        stringBuffer.append("','");
        stringBuffer.append(str);
        stringBuffer.append("','");
        stringBuffer.append(processStringParam(str3));
        stringBuffer.append("')");
        str = this.TAG;
        str2 = new StringBuilder("call back to JS url = ");
        str2.append(stringBuffer.toString());
        XLLog.v(str, str2.toString());
        this.mXLPayJSRegister.a(stringBuffer.toString());
    }

    private String processStringParam(String str) {
        return str == null ? "" : str.replace("\\", "\\\\").replace("'", "\\'");
    }

    private int userWxPay(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r6 = r5.getJsonParam(r6);
        r0 = -1;
        if (r6 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = new com.xunlei.common.new_ptl.pay.param.XLWxPayParam;
        r1.<init>();
        r2 = r5.mXLPayJSRegister;	 Catch:{ Exception -> 0x0042 }
        r2 = r2.c();	 Catch:{ Exception -> 0x0042 }
        if (r2 != 0) goto L_0x0016;	 Catch:{ Exception -> 0x0042 }
    L_0x0015:
        return r0;	 Catch:{ Exception -> 0x0042 }
    L_0x0016:
        r3 = r2.userId;	 Catch:{ Exception -> 0x0042 }
        r1.mUserId = r3;	 Catch:{ Exception -> 0x0042 }
        r3 = r2.sessionId;	 Catch:{ Exception -> 0x0042 }
        r1.mSessionId = r3;	 Catch:{ Exception -> 0x0042 }
        r2 = r2.wxAppId;	 Catch:{ Exception -> 0x0042 }
        r1.mAppId = r2;	 Catch:{ Exception -> 0x0042 }
        r2 = "source";	 Catch:{ Exception -> 0x0042 }
        r2 = r6.optString(r2);	 Catch:{ Exception -> 0x0042 }
        r1.mSource = r2;	 Catch:{ Exception -> 0x0042 }
        r2 = "referfrom";	 Catch:{ Exception -> 0x0042 }
        r6 = r6.optString(r2);	 Catch:{ Exception -> 0x0042 }
        r1.mReferFrom = r6;	 Catch:{ Exception -> 0x0042 }
        r6 = com.xunlei.common.new_ptl.pay.a.i.a();
        r0 = "xl-js-wx-pay";
        r2 = new com.xunlei.common.new_ptl.pay.js.a;
        r2.<init>(r5);
        r6 = r6.a(r1, r0, r2);
        return r6;
    L_0x0042:
        r6 = r5.TAG;
        r1 = "js param error";
        com.xunlei.common.base.XLLog.v(r6, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.pay.js.export.XLPayJSInterface.userWxPay(java.lang.String):int");
    }

    private int userAliPay(java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r6 = r5.getJsonParam(r6);
        r0 = -1;
        if (r6 != 0) goto L_0x0008;
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = new com.xunlei.common.new_ptl.pay.param.XLAlipayParam;
        r1.<init>();
        r2 = r5.mXLPayJSRegister;	 Catch:{ Exception -> 0x0046 }
        r2 = r2.c();	 Catch:{ Exception -> 0x0046 }
        if (r2 != 0) goto L_0x0016;	 Catch:{ Exception -> 0x0046 }
    L_0x0015:
        return r0;	 Catch:{ Exception -> 0x0046 }
    L_0x0016:
        r3 = r2.userId;	 Catch:{ Exception -> 0x0046 }
        r1.mUserId = r3;	 Catch:{ Exception -> 0x0046 }
        r2 = r2.sessionId;	 Catch:{ Exception -> 0x0046 }
        r1.mSessionId = r2;	 Catch:{ Exception -> 0x0046 }
        r2 = "source";	 Catch:{ Exception -> 0x0046 }
        r2 = r6.optString(r2);	 Catch:{ Exception -> 0x0046 }
        r1.mSource = r2;	 Catch:{ Exception -> 0x0046 }
        r2 = "referfrom";	 Catch:{ Exception -> 0x0046 }
        r6 = r6.optString(r2);	 Catch:{ Exception -> 0x0046 }
        r1.mReferFrom = r6;	 Catch:{ Exception -> 0x0046 }
        r6 = r5.mXLPayJSRegister;	 Catch:{ Exception -> 0x0046 }
        r6 = r6.b();	 Catch:{ Exception -> 0x0046 }
        r1.mActivity = r6;	 Catch:{ Exception -> 0x0046 }
        r6 = com.xunlei.common.new_ptl.pay.a.i.a();
        r0 = "xl-js-ali-pay";
        r2 = new com.xunlei.common.new_ptl.pay.js.a;
        r2.<init>(r5);
        r6 = r6.a(r1, r0, r2);
        return r6;
    L_0x0046:
        r6 = r5.TAG;
        r1 = "js param error";
        com.xunlei.common.base.XLLog.v(r6, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.pay.js.export.XLPayJSInterface.userAliPay(java.lang.String):int");
    }

    private JSONObject getJsonParam(String str) {
        try {
            return new JSONObject(str);
        } catch (String str2) {
            str2.printStackTrace();
            XLLog.v(this.TAG, "get json param error.");
            return null;
        }
    }
}
