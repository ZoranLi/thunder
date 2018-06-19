package com.xunlei.common.accelerator.js;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.WebView;
import com.xunlei.common.accelerator.XLAccelUtil;
import com.xunlei.common.accelerator.XLAccelerator;
import com.xunlei.common.accelerator.js.KNJsInterface.JumpLisenter;

public class KNJsProxy {
    private static final String JS_INTERFACE_NAME = "share";
    private static KNJsProxy mKnJsProxy;
    private XLAccelerator mAccelerator = XLAccelUtil.getInstance().getAccelerator();
    private final Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    KNJsProxy.this.xLOnAccelListenerImpl.setCallBackName((String) message.obj);
                    KNJsProxy.this.mAccelerator.queryStatus();
                    return;
                case 1:
                    KNJsProxy.this.xLOnAccelListenerImpl.setCallBackName((String) message.obj);
                    KNJsProxy.this.mAccelerator.startAccel();
                    return;
                case 2:
                    KNJsProxy.this.xLOnAccelListenerImpl.setCallBackName((String) message.obj);
                    KNJsProxy.this.mAccelerator.stopAccel();
                    return;
                case 3:
                    KNJsProxy.this.xLOnAccelListenerImpl.setCallBackName((String) message.obj);
                    KNJsProxy.this.mAccelerator.recoverQuery();
                    return;
                case 4:
                    KNJsProxy.this.xLOnAccelListenerImpl.setCallBackName((String) message.obj);
                    message = message.getData();
                    KNJsProxy.this.mAccelerator.startAccelWithCard(message.getString(KNJsInterfaceImpl.EXTRA_KEY_CARD), message.getInt(KNJsInterfaceImpl.EXTRA_KEY_TIME));
                    break;
                default:
                    break;
            }
        }
    };
    private WebView mWebView;
    public XLOnAccelListenerImpl xLOnAccelListenerImpl;

    private KNJsProxy() {
    }

    public static KNJsProxy getKNJsProxy() {
        if (mKnJsProxy == null) {
            synchronized (KNJsProxy.class) {
                if (mKnJsProxy == null) {
                    mKnJsProxy = new KNJsProxy();
                }
            }
        }
        return mKnJsProxy;
    }

    public boolean initJsInterface(WebView webView, JumpLisenter jumpLisenter) {
        if (webView != null) {
            if (jumpLisenter != null) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mWebView = webView;
                webView.addJavascriptInterface(new KNJsInterfaceImpl(jumpLisenter, this.mHandler), JS_INTERFACE_NAME);
                this.xLOnAccelListenerImpl = new XLOnAccelListenerImpl(webView);
                this.mAccelerator.attachListener(this.xLOnAccelListenerImpl);
                return true;
            }
        }
        return null;
    }

    public boolean uninitJsInterface() {
        if (this.mWebView == null || this.xLOnAccelListenerImpl == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            this.mWebView.removeJavascriptInterface(JS_INTERFACE_NAME);
        } else {
            this.mWebView.addJavascriptInterface(null, "");
        }
        this.mWebView.loadUrl("");
        this.mHandler.removeCallbacksAndMessages(null);
        this.mAccelerator.detachListener(this.xLOnAccelListenerImpl);
        this.mWebView = null;
        return true;
    }

    public String getBandInfo() {
        Object bandInfo = this.mAccelerator.getBandInfo();
        return TextUtils.isEmpty(bandInfo) ? "" : bandInfo;
    }

    public String getTryInfo() {
        Object tryInfo = this.mAccelerator.getTryInfo();
        return TextUtils.isEmpty(tryInfo) ? "" : tryInfo;
    }

    public String getUserInfo() {
        Object userInfo = this.mAccelerator.getUserInfo();
        return TextUtils.isEmpty(userInfo) ? "" : userInfo;
    }

    public int getRemainTime() {
        return this.mAccelerator.getRemainTime();
    }

    public void updateUserInfo() {
        this.mAccelerator.updateUserInfo();
    }
}
