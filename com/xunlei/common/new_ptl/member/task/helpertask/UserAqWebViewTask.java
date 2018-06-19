package com.xunlei.common.new_ptl.member.task.helpertask;

import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.webkit.WebView;
import com.taobao.accs.common.Constants;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.encrypt.MD5;
import com.xunlei.common.new_ptl.member.XLUserInfo;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class UserAqWebViewTask extends a {
    private static final String d = "xlGetUserInfo";
    private static final String e = "clientSDKMessage";
    private static String f = "javascript:";
    protected String a = getClass().getSimpleName();
    protected String b = "";
    protected WebView c;

    public abstract void a(@NonNull WebView webView);

    public abstract void a(String str);

    public abstract String m();

    public long n() {
        return 0;
    }

    protected String o() {
        return "";
    }

    protected UserAqWebViewTask(p pVar) {
        super(pVar);
    }

    public final void p() {
        if (this.c != null) {
            if (VERSION.SDK_INT >= 11) {
                this.c.removeJavascriptInterface(this.b);
            }
            this.c = null;
        }
    }

    public final boolean h() {
        this.c.loadUrl(m());
        return true;
    }

    protected final String c(String str) {
        try {
            return MD5.getMessageDigest(this.c.getContext().getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
        } catch (String str2) {
            str2.printStackTrace();
            return "";
        }
    }

    protected final void a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("javascript:");
        stringBuffer.append(str);
        stringBuffer.append("('");
        stringBuffer.append(str2);
        stringBuffer.append("')");
        str = this.a;
        str2 = new StringBuilder("call back to JS url = ");
        str2.append(stringBuffer.toString());
        XLLog.v(str, str2.toString());
        p.a().n().post(new 1(this, stringBuffer));
    }

    public final void d(String str) {
        a(e, str);
    }

    private void b(String str, String str2) {
        if (d.equals(str) != null) {
            str = new JSONObject();
            try {
                JSONObject jSONObject = new JSONObject();
                XLUserInfo i = d().i();
                jSONObject.put("sessionID", i.getStringValue(USERINFOKEY.SessionID));
                jSONObject.put("userID", String.valueOf(i.getLongValue(USERINFOKEY.UserID)));
                str.put(Constants.KEY_USER_ID, jSONObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            a(str2, str.toString());
        }
    }

    protected final void e(String str) {
        p.a().n().post(new 2(this, str));
    }

    protected void f(String str) {
        p.a().n().post(new 3(this, str));
    }

    static /* synthetic */ void a(UserAqWebViewTask userAqWebViewTask, String str, String str2, String str3) {
        if (d.equals(str) != null) {
            str = new JSONObject();
            try {
                str2 = new JSONObject();
                XLUserInfo i = userAqWebViewTask.d().i();
                str2.put("sessionID", i.getStringValue(USERINFOKEY.SessionID));
                str2.put("userID", String.valueOf(i.getLongValue(USERINFOKEY.UserID)));
                str.put(Constants.KEY_USER_ID, str2);
            } catch (String str22) {
                str22.printStackTrace();
            }
            userAqWebViewTask.a(str3, str.toString());
        }
    }
}
