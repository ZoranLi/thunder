package com.xunlei.common.new_ptl.member.c;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.sdk.app.AuthTask;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHttpHeader;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.act.XLAlipayParam;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.http.Header;

/* compiled from: XLAlipayAuth */
public class b {
    private static final String a = "b";
    private static String b = "2088911130724615";
    private static String c = "2017091108676466";
    private static int d = 4132;
    private static String e = "http://dynamic.i.xunlei.com/alipay_verify/verify.php?action=sign";
    private static String f = "http://dynamic.i.xunlei.com/alipay_verify/verify.php?action=verify_alipay";
    private d g = null;
    private Activity h = null;
    private c i = null;
    private String j = null;
    private XLAlipayParam k = null;
    private Handler l = new Handler(this) {
        private /* synthetic */ b a;

        {
            this.a = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE) {
                this.a.i = new c((String) message.obj);
                String c = this.a.i.c();
                String a = this.a.i.a();
                if (!TextUtils.isEmpty(c)) {
                    if (!TextUtils.isEmpty(a)) {
                        b.a(this.a, c, a);
                    }
                }
                this.a.a(XLErrorCode.AUTH_USER_CANCLE, null, null, null);
            }
        }
    };

    private static String d() {
        return "sign_type=\"RSA\"";
    }

    public b(d dVar, XLAlipayParam xLAlipayParam, Activity activity) {
        this.g = dVar;
        this.k = xLAlipayParam;
        this.h = activity;
    }

    private String c() {
        String str = this.k.mTargetId;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("apiname=\"com.alipay.account.auth\"");
        stringBuilder.append("&app_id=\"");
        stringBuilder.append("2017091108676466");
        stringBuilder.append("\"");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("&app_name=\"mc\"");
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("&auth_type=\"AUTHACCOUNT\"");
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("&biz_type=\"openservice\"");
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("&pid=\"");
        stringBuilder3.append("2088911130724615");
        stringBuilder3.append("\"");
        stringBuilder2 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append("&product_id=\"WAP_FAST_LOGIN\"");
        stringBuilder2 = stringBuilder4.toString();
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append("&scope=\"kuaijie\"");
        stringBuilder2 = stringBuilder4.toString();
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append("&target_id=\"");
        stringBuilder4.append(str);
        stringBuilder4.append("\"");
        stringBuilder2 = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(stringBuilder2);
        stringBuilder5.append("&sign_date=\"");
        stringBuilder5.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        stringBuilder5.append("\"");
        return stringBuilder5.toString();
    }

    private void a(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("data=");
            stringBuffer.append(str);
            p.a().l().post(p.a().h(), "http://dynamic.i.xunlei.com/alipay_verify/verify.php?action=sign", new Header[]{new XLHttpHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuffer.toString().getBytes(), new BaseHttpClientListener(this) {
                private /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    String str = new String(bArr);
                    headerArr = b.a;
                    bArr = new StringBuilder("remote signRequestData succeed sign = ");
                    bArr.append(str);
                    XLLog.v(headerArr, bArr.toString());
                    this.a.a((int) null, str);
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    bArr = b.a;
                    StringBuilder stringBuilder = new StringBuilder("signRequestData error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e(bArr, stringBuilder.toString());
                    this.a.a((int) -1, null);
                }
            });
        } catch (String str2) {
            str2.printStackTrace();
            String str3 = a;
            StringBuilder stringBuilder = new StringBuilder("signRequestData error = ");
            stringBuilder.append(str2.getMessage());
            XLLog.e(str3, stringBuilder.toString());
            a(-1, null);
        }
    }

    private void a(String str, String str2) {
        XLLog.v(a, String.format("verifySignRespData content = %s, sign = %s", new Object[]{str, str2}));
        try {
            str = URLEncoder.encode(str, "UTF-8");
            str2 = URLEncoder.encode(str2, "UTF-8");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("data=");
            stringBuffer.append(str);
            stringBuffer.append("&sign=");
            stringBuffer.append(str2);
            p.a().l().post(p.a().h(), "http://dynamic.i.xunlei.com/alipay_verify/verify.php?action=verify_alipay", new Header[]{new XLHttpHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuffer.toString().getBytes(), new BaseHttpClientListener(this) {
                private /* synthetic */ b a;

                {
                    this.a = r1;
                }

                public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    i = Integer.valueOf(new String(bArr)).intValue();
                    headerArr = b.a;
                    bArr = new StringBuilder("remote verifySignRespData succeed verify = ");
                    bArr.append(i);
                    XLLog.v(headerArr, bArr.toString());
                    b bVar = this.a;
                    boolean z = true;
                    if (i != 1) {
                        z = null;
                    }
                    bVar.a(z);
                }

                public final void onFailure(Throwable th, byte[] bArr) {
                    bArr = b.a;
                    StringBuilder stringBuilder = new StringBuilder("verifySignRespData error = ");
                    stringBuilder.append(th.getMessage());
                    XLLog.e(bArr, stringBuilder.toString());
                    this.a.a((boolean) null);
                }
            });
        } catch (String str3) {
            str3.printStackTrace();
            str2 = a;
            StringBuilder stringBuilder = new StringBuilder("verifySignRespData error = ");
            stringBuilder.append(str3.getMessage());
            XLLog.e(str2, stringBuilder.toString());
            a(false);
        }
    }

    private static String e() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
    }

    private void a(int i, String str, String str2, String str3) {
        if (this.g != null) {
            this.g.onAlipayAuth(i, str, str2, str3);
        }
    }

    private void a(int i, String str) {
        if (i == 0) {
            try {
                i = URLEncoder.encode(str, "UTF-8");
                str = new StringBuilder();
                str.append(this.j);
                str.append("&sign=\"");
                str.append(i);
                str.append("\"&sign_type=\"RSA\"");
                i = str.toString();
                XLLog.v("XLAlipayAuth", i);
                new Thread(new Runnable(this) {
                    private /* synthetic */ b b;

                    public final void run() {
                        String auth = new AuthTask(this.b.h).auth(i, this.b.k.mNeedLoading != 0);
                        Message message = new Message();
                        message.what = ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE;
                        message.obj = auth;
                        this.b.l.sendMessage(message);
                    }
                }).start();
                return;
            } catch (int i2) {
                i2.printStackTrace();
                a(XLErrorCode.ALI_SIGN_ENCODE_ERROR, null, null, "2017091108676466");
                return;
            }
        }
        a(XLErrorCode.ALI_AUTH_SIGN_ERROR, null, null, null);
    }

    private void a(boolean z) {
        if (z) {
            z = this.i.b();
            String f = this.i.f();
            String e = this.i.e();
            if (TextUtils.equals(z, "9000") && TextUtils.equals(this.i.d(), "200")) {
                a(false, f, e, "2017091108676466");
                return;
            } else if (TextUtils.equals(z, "9000")) {
                a(Integer.valueOf(this.i.d()).intValue() + true, f, e, "2017091108676466");
                return;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(z);
                stringBuilder.append(XLErrorCode.ALI_SIGN_ENCODE_ERROR);
                a(Integer.valueOf(stringBuilder.toString()).intValue(), f, e, "2017091108676466");
                return;
            }
        }
        a(true, null, null, null);
    }

    public final void a() {
        String str = this.k.mTargetId;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("apiname=\"com.alipay.account.auth\"");
        stringBuilder.append("&app_id=\"");
        stringBuilder.append("2017091108676466");
        stringBuilder.append("\"");
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("&app_name=\"mc\"");
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("&auth_type=\"AUTHACCOUNT\"");
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("&biz_type=\"openservice\"");
        stringBuilder2 = stringBuilder3.toString();
        stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("&pid=\"");
        stringBuilder3.append("2088911130724615");
        stringBuilder3.append("\"");
        stringBuilder2 = stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append("&product_id=\"WAP_FAST_LOGIN\"");
        stringBuilder2 = stringBuilder4.toString();
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append("&scope=\"kuaijie\"");
        stringBuilder2 = stringBuilder4.toString();
        stringBuilder4 = new StringBuilder();
        stringBuilder4.append(stringBuilder2);
        stringBuilder4.append("&target_id=\"");
        stringBuilder4.append(str);
        stringBuilder4.append("\"");
        stringBuilder2 = stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(stringBuilder2);
        stringBuilder5.append("&sign_date=\"");
        stringBuilder5.append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date()));
        stringBuilder5.append("\"");
        this.j = stringBuilder5.toString();
        try {
            stringBuilder2 = URLEncoder.encode(this.j, "UTF-8");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("data=");
            stringBuffer.append(stringBuilder2);
            p.a().l().post(p.a().h(), "http://dynamic.i.xunlei.com/alipay_verify/verify.php?action=sign", new Header[]{new XLHttpHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuffer.toString().getBytes(), /* anonymous class already generated */);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str = a;
            stringBuilder4 = new StringBuilder("signRequestData error = ");
            stringBuilder4.append(e.getMessage());
            XLLog.e(str, stringBuilder4.toString());
            a(-1, null);
        }
    }

    static /* synthetic */ void a(b bVar, String str, String str2) {
        XLLog.v(a, String.format("verifySignRespData content = %s, sign = %s", new Object[]{str, str2}));
        try {
            str = URLEncoder.encode(str, "UTF-8");
            str2 = URLEncoder.encode(str2, "UTF-8");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("data=");
            stringBuffer.append(str);
            stringBuffer.append("&sign=");
            stringBuffer.append(str2);
            p.a().l().post(p.a().h(), "http://dynamic.i.xunlei.com/alipay_verify/verify.php?action=verify_alipay", new Header[]{new XLHttpHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuffer.toString().getBytes(), /* anonymous class already generated */);
        } catch (String str3) {
            str3.printStackTrace();
            str2 = a;
            StringBuilder stringBuilder = new StringBuilder("verifySignRespData error = ");
            stringBuilder.append(str3.getMessage());
            XLLog.e(str2, stringBuilder.toString());
            bVar.a(false);
        }
    }
}
