package com.xunlei.common.new_ptl.member.task.a;

import android.os.Bundle;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* compiled from: UserSelectRecommendAvatarTask */
public final class b extends a {
    private final String a;
    private int b = -1;

    static /* synthetic */ int a(b bVar, int i) {
        return i == 200 ? 0 : i == 402 ? 13 : i == 406 ? XLErrorCode.UNKNOWN_ERROR : XLErrorCode.UNKNOWN_ERROR;
    }

    private static int h(int i) {
        return i == 200 ? 0 : i == 402 ? 13 : i == 406 ? XLErrorCode.UNKNOWN_ERROR : XLErrorCode.UNKNOWN_ERROR;
    }

    public b(p pVar) {
        super(pVar);
    }

    public final void f(int i) {
        this.b = i;
    }

    public final boolean h() {
        String str = "------------swb3ef7ab26eea1cd9fe3dd7ba4ef5aaswb";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a("sessionid", e().getStringValue(USERINFOKEY.SessionID), str));
        stringBuffer.append(a("userid", e().getStringValue(USERINFOKEY.UserID), str));
        stringBuffer.append(a("businesstype", String.valueOf(d().d()), str));
        stringBuffer.append(a("recommendid", String.valueOf(this.b), str));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("--\r\n");
        stringBuffer.append(stringBuilder.toString());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(stringBuffer.toString().getBytes(), 0, stringBuffer.toString().getBytes().length);
            byteArrayOutputStream.flush();
            String simpleName = getClass().getSimpleName();
            StringBuilder stringBuilder2 = new StringBuilder("select recommend avatar buffer = ");
            stringBuilder2.append(stringBuffer);
            XLLog.v(simpleName, stringBuilder2.toString());
            Header[] headerArr = new Header[1];
            StringBuilder stringBuilder3 = new StringBuilder("multipart/form-data;boundary=");
            stringBuilder3.append(str);
            headerArr[0] = new BasicHeader("Content-Type", stringBuilder3.toString());
            d().l().post(d().h(), "http://img.user.kanimg.com/avatar/select_recommend_avatar", headerArr, byteArrayOutputStream.toByteArray(), new 1(this));
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            g(XLErrorCode.PACKAGE_ERROR);
            return true;
        }
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserSelectRecommendAvatar(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", f(), g());
            }
        }
        return null;
    }

    private void g(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }

    private static StringBuffer a(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str3);
        stringBuilder.append("\r\n");
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append("Content-Disposition:form-data;name=\"");
        stringBuffer.append(str);
        stringBuffer.append("\"\r\n\r\n");
        stringBuffer.append(str2);
        stringBuffer.append("\r\n");
        return stringBuffer;
    }
}
