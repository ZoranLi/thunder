package com.xunlei.common.accelerator.js;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.webkit.JavascriptInterface;
import com.xunlei.common.accelerator.js.KNJsInterface.JumpLisenter;

public class KNJsInterfaceImpl implements KNJsInterface {
    public static final String EXTRA_KEY_CARD = "expcardid";
    public static final String EXTRA_KEY_TIME = "expminute";
    public static final int MSG_JS_KN_QUERY_STATUS = 0;
    public static final int MSG_JS_KN_RECOVER_QUERY = 3;
    public static final int MSG_JS_KN_START_ACCEL = 1;
    public static final int MSG_JS_KN_START_USECARD = 4;
    public static final int MSG_JS_KN_STOP_ACCEL = 2;
    private Handler mHandler;
    private JumpLisenter mJumpLisenter;

    public KNJsInterfaceImpl(JumpLisenter jumpLisenter, Handler handler) {
        this.mJumpLisenter = jumpLisenter;
        this.mHandler = handler;
    }

    @JavascriptInterface
    public void queryStatus(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(0);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    @JavascriptInterface
    public void startAccel(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    @JavascriptInterface
    public void stopAccel(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    @JavascriptInterface
    public void recoverQuery(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(3);
        obtainMessage.obj = str;
        obtainMessage.sendToTarget();
    }

    @JavascriptInterface
    public String getBandInfo() {
        return KNJsUtils.getKnJsUtils().getBandInfo();
    }

    @JavascriptInterface
    public String getTryInfo() {
        return KNJsUtils.getKnJsUtils().getTryInfo();
    }

    @JavascriptInterface
    public String getUserInfo() {
        return KNJsUtils.getKnJsUtils().getUserInfo();
    }

    @JavascriptInterface
    public int getRemainTime() {
        return KNJsUtils.getKnJsUtils().getRemainTime();
    }

    @JavascriptInterface
    public void startLogin() {
        this.mJumpLisenter.jumpToLogin();
    }

    @JavascriptInterface
    public void startPay() {
        this.mJumpLisenter.jumpToPay();
    }

    @JavascriptInterface
    public void startCardAccel(String str, String str2, int i) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        str = new Bundle(2);
        str.putString(EXTRA_KEY_CARD, str2);
        str.putInt(EXTRA_KEY_TIME, i);
        obtainMessage.setData(str);
        obtainMessage.sendToTarget();
    }
}
