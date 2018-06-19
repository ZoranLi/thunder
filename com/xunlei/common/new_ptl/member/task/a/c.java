package com.xunlei.common.new_ptl.member.task.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import com.taobao.accs.utl.UtilityImpl;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.XLOnUserListener;
import com.xunlei.common.new_ptl.member.XLUserInfo.USERINFOKEY;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* compiled from: UserSetAvatarTask */
public final class c extends a {
    private Bitmap a = null;
    private String b = "http://img.ucenter.xunlei.com/avatar/set_avatar?width=%d&height=%d";

    static /* synthetic */ int a(c cVar, int i) {
        return i == 200 ? 0 : i == 402 ? 13 : i == 406 ? XLErrorCode.UNKNOWN_ERROR : XLErrorCode.UNKNOWN_ERROR;
    }

    private static int g(int i) {
        return i == 200 ? 0 : i == 402 ? 13 : i == 406 ? XLErrorCode.UNKNOWN_ERROR : XLErrorCode.UNKNOWN_ERROR;
    }

    public c(p pVar) {
        super(pVar);
    }

    public final boolean h() {
        return m();
    }

    public final boolean a(XLOnUserListener xLOnUserListener, Bundle bundle) {
        if (xLOnUserListener != null) {
            if (bundle != null) {
                return xLOnUserListener.onUserSetAvatar(bundle.getInt("errorCode"), bundle.getString("errorDesc"), "", f(), g());
            }
        }
        return null;
    }

    public final void a(Bitmap bitmap) {
        this.a = bitmap;
    }

    private void f(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("errorCode", i);
        bundle.putString("errorDesc", XLErrorCode.getErrorDesc(i));
        d().a((a) this, bundle);
    }

    private boolean m() {
        if (this.a == null) {
            XLLog.v(getClass().getSimpleName(), "upload avatar file invalid picture!");
            f(XLErrorCode.INVALID_BITMAP);
            return false;
        }
        String str = "------------swb3ef7ab26eea1cd9fe3dd7ba4ef5aaswb";
        StringBuffer stringBuffer = new StringBuffer();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(UtilityImpl.TNET_FILE_SIZE);
        stringBuffer.append(a("sessionid", e().getStringValue(USERINFOKEY.SessionID), str));
        stringBuffer.append(a("userid", e().getStringValue(USERINFOKEY.UserID), str));
        stringBuffer.append(a("businesstype", String.valueOf(d().d()), str));
        if (a(byteArrayOutputStream, stringBuffer.toString().getBytes(), 0, stringBuffer.toString().getBytes().length)) {
            String str2;
            boolean a;
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuilder stringBuilder = new StringBuilder("--");
            stringBuilder.append(str);
            stringBuilder.append("\r\n");
            stringBuffer2.append(stringBuilder.toString());
            stringBuffer2.append("Content-Disposition:form-data;filename=avatar.jpeg;name=\"");
            stringBuffer2.append("upload_file");
            stringBuffer2.append("\"\r\n");
            stringBuffer2.append("Content-Type:image/jpeg\r\n\r\n");
            if (a(byteArrayOutputStream, stringBuffer2.toString().getBytes(), 0, stringBuffer2.toString().getBytes().length)) {
                this.a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                str2 = "\r\n";
                a = a(byteArrayOutputStream, str2.getBytes(), 0, str2.getBytes().length);
            } else {
                a = false;
            }
            if (a) {
                StringBuilder stringBuilder2 = new StringBuilder("--");
                stringBuilder2.append(str);
                stringBuilder2.append("--\r\n");
                str2 = stringBuilder2.toString();
                if (a(byteArrayOutputStream, str2.getBytes(), 0, str2.getBytes().length)) {
                    str2 = getClass().getSimpleName();
                    StringBuilder stringBuilder3 = new StringBuilder("set avatar buffer = ");
                    stringBuilder3.append(stringBuffer);
                    XLLog.v(str2, stringBuilder3.toString());
                    Header[] headerArr = new Header[1];
                    StringBuilder stringBuilder4 = new StringBuilder("multipart/form-data;boundary=");
                    stringBuilder4.append(str);
                    headerArr[0] = new BasicHeader("Content-Type", stringBuilder4.toString());
                    d().l().post(d().h(), String.format(this.b, new Object[]{Integer.valueOf(this.a.getWidth()), Integer.valueOf(this.a.getHeight())}), headerArr, byteArrayOutputStream.toByteArray(), new 1(this));
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return false;
                }
                XLLog.v(getClass().getSimpleName(), "write stream buffer end boundary error.");
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                f(XLErrorCode.PACKAGE_ERROR);
                return false;
            }
            XLLog.v(getClass().getSimpleName(), "write stream buffer bitmap error.");
            try {
                byteArrayOutputStream.close();
            } catch (IOException e22) {
                e22.printStackTrace();
            }
            f(XLErrorCode.PACKAGE_ERROR);
            return false;
        }
        XLLog.v(getClass().getSimpleName(), "write stream buffer param error.");
        try {
            byteArrayOutputStream.close();
        } catch (IOException e222) {
            e222.printStackTrace();
        }
        f(XLErrorCode.PACKAGE_ERROR);
        return false;
    }

    private static StringBuffer a(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder("--");
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

    private boolean a(ByteArrayOutputStream byteArrayOutputStream, String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuilder stringBuilder = new StringBuilder("--");
        stringBuilder.append(str2);
        stringBuilder.append("\r\n");
        stringBuffer.append(stringBuilder.toString());
        stringBuffer.append("Content-Disposition:form-data;filename=avatar.jpeg;name=\"");
        stringBuffer.append(str);
        stringBuffer.append("\"\r\n");
        stringBuffer.append("Content-Type:image/jpeg\r\n\r\n");
        if (a(byteArrayOutputStream, stringBuffer.toString().getBytes(), 0, stringBuffer.toString().getBytes().length) == null) {
            return false;
        }
        this.a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        str = "\r\n";
        return a(byteArrayOutputStream, str.getBytes(), 0, str.getBytes().length);
    }

    private static boolean a(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, int i, int i2) {
        try {
            byteArrayOutputStream.write(bArr, 0, i2);
            byteArrayOutputStream.flush();
            return true;
        } catch (ByteArrayOutputStream byteArrayOutputStream2) {
            byteArrayOutputStream2.printStackTrace();
            return false;
        }
    }
}
