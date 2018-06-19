package com.xunlei.common.new_ptl.member.task.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.message.util.HttpRequest;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLHttpHeader;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLThirdUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.act.XLQQLoginActivity;
import com.xunlei.common.new_ptl.member.act.XLSinaLoginActivity;
import com.xunlei.common.new_ptl.member.c.i;
import com.xunlei.common.new_ptl.member.task.a;
import org.apache.http.Header;

/* compiled from: UserGetOtherAccountInfoTask */
public final class c extends a {
    private int a;
    private int b;
    private int c;
    private int d = 1;
    private IWXAPI e = null;
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    private String j;
    private String k;
    private i l = null;
    private XLThirdUserInfo m = null;
    private int n = -1;
    private Object o = null;

    static /* synthetic */ int a(c cVar, int i) {
        return i == 200 ? 0 : i == 600 ? 13 : i == 502 ? 20000 : i == 603 ? XLErrorCode.NOT_BIND_ERROR : XLErrorCode.BIND_ERROR;
    }

    private static int g(int i) {
        return i == 200 ? 0 : i == 600 ? 13 : i == 502 ? 20000 : i == 603 ? XLErrorCode.NOT_BIND_ERROR : XLErrorCode.BIND_ERROR;
    }

    public c(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        int i = 0;
        if (this.d == 1) {
            if (d().r()) {
                Intent intent;
                if (this.n == 21) {
                    this.e = WXAPIFactory.createWXAPI(d().h(), this.f, false);
                    this.e.registerApp(this.f);
                    if (this.e.isWXAppInstalled()) {
                        BaseReq req = new Req();
                        req.scope = "snsapi_userinfo";
                        StringBuilder stringBuilder = new StringBuilder("xl_sdk_get_access_code#");
                        stringBuilder.append(g());
                        req.transaction = stringBuilder.toString();
                        req.state = String.valueOf(g());
                        if (!this.e.sendReq(req)) {
                            i = XLErrorCode.WX_REQ_FAIL;
                        }
                    } else {
                        i = XLErrorCode.WX_NOT_INSTALLED;
                    }
                    if (i != 0) {
                        f(i);
                    }
                }
                if (this.n == 1) {
                    intent = new Intent(p.a().h(), XLSinaLoginActivity.class);
                    intent.putExtra("sina_task", g());
                    intent.putExtra("sina_app_id", this.f);
                    if (this.o != null) {
                        intent.putExtra("sina_app_redirect", (String) this.o);
                    }
                    intent.addFlags(268435456);
                    d().h().startActivity(intent);
                }
                if (this.n == 15) {
                    intent = new Intent(p.a().h(), XLQQLoginActivity.class);
                    intent.putExtra("qq_app_id", this.f);
                    intent.putExtra("qq_task_id", g());
                    intent.addFlags(268435456);
                    d().h().startActivity(intent);
                    XLLog.v(getClass().getSimpleName(), "start XLQQLoginActivity");
                }
            } else {
                XLLog.v(getClass().getSimpleName(), "user is not login!");
                f(XLErrorCode.OPERATION_INVALID);
                return true;
            }
        } else if (this.d == 2) {
            StringBuffer stringBuffer;
            StringBuffer stringBuffer2 = new StringBuffer();
            String encrypt;
            if (this.n == 21) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("nglei^*(352l{eltLNEGwwn");
                stringBuffer.append(this.g);
                stringBuffer.append(this.f);
                stringBuffer.append(100);
                encrypt = MD5.encrypt(stringBuffer.toString());
                stringBuffer2.append("code=");
                stringBuffer2.append(this.g);
                stringBuffer2.append("&appid=");
                stringBuffer2.append(this.f);
                stringBuffer2.append("&version=100&sign=");
                stringBuffer2.append(encrypt);
            } else if (this.n == 1) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("nglei^*(352l{eltLNEGwwn");
                stringBuffer.append(this.h);
                stringBuffer.append(this.i);
                stringBuffer.append(this.f);
                stringBuffer.append(100);
                encrypt = MD5.encrypt(stringBuffer.toString());
                stringBuffer2.append("access_token=");
                stringBuffer2.append(this.i);
                stringBuffer2.append("&appid=");
                stringBuffer2.append(this.f);
                stringBuffer2.append("&third_uid=");
                stringBuffer2.append(this.h);
                stringBuffer2.append("&version=100&sign=");
                stringBuffer2.append(encrypt);
            } else if (this.n == 15) {
                stringBuffer = new StringBuffer();
                stringBuffer.append("nglei^*(352l{eltLNEGwwn");
                stringBuffer.append(this.l.b);
                stringBuffer.append(this.f);
                stringBuffer.append(this.l.a);
                stringBuffer.append(100);
                encrypt = MD5.encrypt(stringBuffer.toString());
                stringBuffer2.append("access_token=");
                stringBuffer2.append(this.l.b);
                stringBuffer2.append("&appid=");
                stringBuffer2.append(this.f);
                stringBuffer2.append("&openid=");
                stringBuffer2.append(this.l.a);
                stringBuffer2.append("&version=100&sign=");
                stringBuffer2.append(encrypt);
            }
            String stringBuffer3 = stringBuffer2.toString();
            stringBuffer = new StringBuffer();
            stringBuffer.append("module=get_third_info&session_id=");
            stringBuffer.append(e().getStringValue(USERINFOKEY.SessionID));
            stringBuffer.append("&uid=");
            stringBuffer.append(e().getLongValue(USERINFOKEY.UserID));
            stringBuffer.append("&business_id=");
            stringBuffer.append(d().d());
            stringBuffer.append("&third_type=");
            int i2 = -1;
            if (this.n == 21) {
                i2 = 21;
            } else if (this.n == 1) {
                i2 = 1;
            } else if (this.n == 15) {
                i2 = 15;
            } else if (this.n == 4) {
                i2 = 4;
            } else {
                int i3 = this.n;
            }
            stringBuffer.append(i2);
            stringBuffer.append("&");
            stringBuffer.append(stringBuffer3);
            stringBuffer3 = getClass().getSimpleName();
            StringBuilder stringBuilder2 = new StringBuilder("request body = ");
            stringBuilder2.append(stringBuffer.toString());
            XLLog.v(stringBuffer3, stringBuilder2.toString());
            d().l().post(d().h(), "http://login.i.xunlei.com/thirdlogin4/entrance.php", new Header[]{new XLHttpHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuffer.toString().getBytes(), new 1(this));
        }
        return true;
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserGetOtherAccountInfo(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", this.n, this.m, f(), g());
            }
        }
        return null;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }

    private int m() {
        if (this.n == 21) {
            return 21;
        }
        if (this.n == 1) {
            return 1;
        }
        if (this.n == 15) {
            return 15;
        }
        if (this.n == 4) {
            return 4;
        }
        int i = this.n;
        return -1;
    }

    private void n() {
        int i = 0;
        this.e = WXAPIFactory.createWXAPI(d().h(), this.f, false);
        this.e.registerApp(this.f);
        if (this.e.isWXAppInstalled()) {
            BaseReq req = new Req();
            req.scope = "snsapi_userinfo";
            StringBuilder stringBuilder = new StringBuilder("xl_sdk_get_access_code#");
            stringBuilder.append(g());
            req.transaction = stringBuilder.toString();
            req.state = String.valueOf(g());
            if (!this.e.sendReq(req)) {
                i = XLErrorCode.WX_REQ_FAIL;
            }
        } else {
            i = XLErrorCode.WX_NOT_INSTALLED;
        }
        if (i != 0) {
            f(i);
        }
    }

    private void o() {
        Intent intent = new Intent(p.a().h(), XLQQLoginActivity.class);
        intent.putExtra("qq_app_id", this.f);
        intent.putExtra("qq_task_id", g());
        intent.addFlags(268435456);
        d().h().startActivity(intent);
        XLLog.v(getClass().getSimpleName(), "start XLQQLoginActivity");
    }

    private void p() {
        Intent intent = new Intent(p.a().h(), XLSinaLoginActivity.class);
        intent.putExtra("sina_task", g());
        intent.putExtra("sina_app_id", this.f);
        if (this.o != null) {
            intent.putExtra("sina_app_redirect", (String) this.o);
        }
        intent.addFlags(268435456);
        d().h().startActivity(intent);
    }

    private String q() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2;
        String encrypt;
        if (this.n == 21) {
            stringBuffer2 = new StringBuffer();
            stringBuffer2.append("nglei^*(352l{eltLNEGwwn");
            stringBuffer2.append(this.g);
            stringBuffer2.append(this.f);
            stringBuffer2.append(100);
            encrypt = MD5.encrypt(stringBuffer2.toString());
            stringBuffer.append("code=");
            stringBuffer.append(this.g);
            stringBuffer.append("&appid=");
            stringBuffer.append(this.f);
            stringBuffer.append("&version=100&sign=");
            stringBuffer.append(encrypt);
        } else if (this.n == 1) {
            stringBuffer2 = new StringBuffer();
            stringBuffer2.append("nglei^*(352l{eltLNEGwwn");
            stringBuffer2.append(this.h);
            stringBuffer2.append(this.i);
            stringBuffer2.append(this.f);
            stringBuffer2.append(100);
            encrypt = MD5.encrypt(stringBuffer2.toString());
            stringBuffer.append("access_token=");
            stringBuffer.append(this.i);
            stringBuffer.append("&appid=");
            stringBuffer.append(this.f);
            stringBuffer.append("&third_uid=");
            stringBuffer.append(this.h);
            stringBuffer.append("&version=100&sign=");
            stringBuffer.append(encrypt);
        } else if (this.n == 15) {
            stringBuffer2 = new StringBuffer();
            stringBuffer2.append("nglei^*(352l{eltLNEGwwn");
            stringBuffer2.append(this.l.b);
            stringBuffer2.append(this.f);
            stringBuffer2.append(this.l.a);
            stringBuffer2.append(100);
            encrypt = MD5.encrypt(stringBuffer2.toString());
            stringBuffer.append("access_token=");
            stringBuffer.append(this.l.b);
            stringBuffer.append("&appid=");
            stringBuffer.append(this.f);
            stringBuffer.append("&openid=");
            stringBuffer.append(this.l.a);
            stringBuffer.append("&version=100&sign=");
            stringBuffer.append(encrypt);
        }
        return stringBuffer.toString();
    }

    private void a(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("module=get_third_info&session_id=");
        stringBuffer.append(e().getStringValue(USERINFOKEY.SessionID));
        stringBuffer.append("&uid=");
        stringBuffer.append(e().getLongValue(USERINFOKEY.UserID));
        stringBuffer.append("&business_id=");
        stringBuffer.append(d().d());
        stringBuffer.append("&third_type=");
        int i = -1;
        if (this.n == 21) {
            i = 21;
        } else if (this.n == 1) {
            i = 1;
        } else if (this.n == 15) {
            i = 15;
        } else if (this.n == 4) {
            i = 4;
        } else {
            int i2 = this.n;
        }
        stringBuffer.append(i);
        stringBuffer.append("&");
        stringBuffer.append(str);
        str = getClass().getSimpleName();
        StringBuilder stringBuilder = new StringBuilder("request body = ");
        stringBuilder.append(stringBuffer.toString());
        XLLog.v(str, stringBuilder.toString());
        d().l().post(d().h(), "http://login.i.xunlei.com/thirdlogin4/entrance.php", new Header[]{new XLHttpHeader("Content-Type", HttpRequest.CONTENT_TYPE_FORM)}, stringBuffer.toString().getBytes(), new 1(this));
    }

    public final void a(int i, String str) {
        XLLog.e("UserWxLoginTask", "recieve wx code.");
        if (i == 0) {
            this.g = str;
            this.d = 2;
            p.a().n().postDelayed(new 2(this), 0);
        } else {
            f(i);
        }
        d().b(g());
    }

    public final void a(int i, i iVar) {
        if (i == 0 && iVar.a()) {
            this.l = iVar;
            this.d = 2;
            p.a().n().postDelayed(new 3(this), 0);
            return;
        }
        f(i);
        this.d = 3;
        d().b(g());
    }

    public final void a(int i, String str, String str2, String str3, String str4) {
        if (i == 0) {
            this.h = str;
            this.i = str2;
            this.d = 2;
            p.a().n().postDelayed(new 4(this), null);
            return;
        }
        f(i);
        this.d = 3;
        d().b(g());
    }

    public final void a(int i, String str, Object obj) {
        this.o = obj;
        this.n = i;
        this.f = str;
    }
}
