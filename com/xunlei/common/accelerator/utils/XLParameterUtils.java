package com.xunlei.common.accelerator.utils;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.common.accelerator.bean.XLAccelUser;
import com.xunlei.common.accelerator.config.Config;

public class XLParameterUtils {
    private static int XLA_SEQ_NUM = 268435456;
    private Context mContext;
    private String mPeerId = "ABCDEF0123456789";

    public XLParameterUtils(Context context, String str) {
        this.mPeerId = str;
        this.mContext = context;
    }

    private String getClientVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(Config.sCurrentKey)) {
            stringBuffer.append("androidunknown-");
            stringBuffer.append(AndroidUtil.getVersionString(this.mContext));
        } else {
            stringBuffer.append(DispatchConstants.ANDROID);
            stringBuffer.append(Config.sCurrentKey);
            stringBuffer.append("-");
            stringBuffer.append(AndroidUtil.getVersionString(this.mContext));
        }
        return stringBuffer.toString();
    }

    private int getValidSeqNum() {
        int i = XLA_SEQ_NUM;
        XLA_SEQ_NUM = i + 1;
        return i;
    }

    private String getClientType() {
        StringBuffer stringBuffer = new StringBuffer();
        if (TextUtils.isEmpty(Config.sCurrentKey)) {
            stringBuffer.append("android-unknownknplugin-3.1");
        } else {
            stringBuffer.append("android-");
            stringBuffer.append(Config.sCurrentKey);
            if (Config.isShoulei()) {
                stringBuffer.append("knplugin");
            }
            stringBuffer.append("-3.1");
        }
        return stringBuffer.toString();
    }

    public StringBuilder parameterToHttpAddress(String str, String str2, XLAccelUser xLAccelUser) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(str2);
        stringBuilder.append("?");
        stringBuilder.append("sequence=");
        stringBuilder.append(getValidSeqNum());
        stringBuilder.append("&");
        stringBuilder.append("peerid=");
        stringBuilder.append(this.mPeerId);
        stringBuilder.append("&");
        stringBuilder.append("client_type=");
        stringBuilder.append(getClientType());
        stringBuilder.append("&");
        stringBuilder.append("client_version=");
        stringBuilder.append(getClientVersion());
        stringBuilder.append("&");
        stringBuilder.append("chanel=");
        str = new StringBuilder("umeng-");
        str.append(AndroidUtil.getChannelFromMeta(this.mContext));
        stringBuilder.append(str.toString());
        stringBuilder.append("&");
        stringBuilder.append("time_and=");
        stringBuilder.append(String.valueOf(System.currentTimeMillis()));
        stringBuilder.append("&");
        if (xLAccelUser != null) {
            stringBuilder.append("userid=");
            stringBuilder.append(xLAccelUser.mUserID);
            stringBuilder.append("&");
            stringBuilder.append("sessionid=");
            stringBuilder.append(xLAccelUser.mSessionID);
            stringBuilder.append("&");
            stringBuilder.append("user_type=");
            stringBuilder.append(xLAccelUser.mUserType);
            stringBuilder.append("&");
        }
        stringBuilder.append("os=");
        stringBuilder.append(AndroidUtil.getOSModel());
        return stringBuilder;
    }

    public String getStopOrAliveAddress(String str, String str2, XLAccelUser xLAccelUser, String str3) {
        str = parameterToHttpAddress(str, str2, xLAccelUser);
        str.append("&dial_account=");
        str.append(str3);
        return str.toString();
    }

    public String getStartAddress(String str, String str2, XLAccelUser xLAccelUser, String str3, String str4) {
        str = parameterToHttpAddress(str, str2, xLAccelUser);
        str.append("&dial_account=");
        str.append(str3);
        if (!(xLAccelUser == null || xLAccelUser.isTryUser() == null || TextUtils.isEmpty(str4) != null)) {
            str.append("&expcardid=");
            str.append(str4);
        }
        if (Config.isKnApp() != null) {
            str.append("&needbind=1");
        }
        return str.toString();
    }

    public String getCheckUsingCardAddress(String str, String str2, XLAccelUser xLAccelUser, String str3) {
        str = parameterToHttpAddress(str, str2, xLAccelUser);
        str.append("&dial_account=");
        str.append(str3);
        return str.toString();
    }
}
