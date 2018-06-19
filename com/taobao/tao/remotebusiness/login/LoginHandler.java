package com.taobao.tao.remotebusiness.login;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.taobao.tao.remotebusiness.a;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;
import mtopsdk.mtop.a.d;
import mtopsdk.mtop.a.e;

class LoginHandler extends Handler implements onLoginListener {
    public static final int LOGIN_CANCEL = 911103;
    public static final int LOGIN_FAILED = 911102;
    public static final int LOGIN_SUCCESS = 911101;
    public static final int LOGIN_TIMEOUT = 911104;
    private static final String TAG = "mtop.rb-LoginHandler";
    private static LoginHandler mHandler;

    private LoginHandler(Looper looper) {
        super(looper);
    }

    public static synchronized LoginHandler instance() {
        LoginHandler loginHandler;
        synchronized (LoginHandler.class) {
            if (mHandler == null) {
                mHandler = new LoginHandler(Looper.getMainLooper());
            }
            loginHandler = mHandler;
        }
        return loginHandler;
    }

    public void handleMessage(Message message) {
        String str;
        String str2;
        j.a("The RemoteBusiness handler message received.");
        switch (message.what) {
            case LOGIN_SUCCESS /*911101*/:
                j.b("onReceive: NOTIFY_LOGIN_SUCCESS.");
                checkXStateSessionInfo();
                a.a();
                break;
            case LOGIN_FAILED /*911102*/:
                j.b("onReceive: NOTIFY_LOGINFAILED.");
                str = "FAIL_SYS_LOGIN_FAIL";
                str2 = "登陆失败";
                break;
            case LOGIN_CANCEL /*911103*/:
                j.b("onReceive: NOTIFY_LOGINCANCEL.");
                str = "FAIL_SYS_LOGIN_CANCEL";
                str2 = "登陆被取消";
                break;
            case LOGIN_TIMEOUT /*911104*/:
                if (RemoteLogin.isSessionValid()) {
                    j.b("Session valid, Broadcast may missed!");
                    checkXStateSessionInfo();
                    a.a();
                    return;
                }
                return;
            default:
                return;
        }
        a.a(str, str2);
        removeMessages(LOGIN_TIMEOUT);
    }

    public void onLoginCancel() {
        sendEmptyMessage(LOGIN_CANCEL);
    }

    public void onLoginFail() {
        sendEmptyMessage(LOGIN_FAILED);
    }

    public void onLoginSuccess() {
        sendEmptyMessage(LOGIN_SUCCESS);
    }

    private static void checkXStateSessionInfo() {
        LoginContext loginContext = RemoteLogin.getLoginContext();
        if (loginContext != null) {
            try {
                if (i.a(loginContext.sid) && !loginContext.sid.equals(mtopsdk.xstate.a.a())) {
                    d.a();
                    mtopsdk.mtop.b.a.a(d.b());
                    e.a(loginContext.sid, loginContext.userId);
                    j.b("[checkXStateSessionInfo] invoked");
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("[checkXStateSessionInfo] error ---");
                stringBuilder.append(e.toString());
                j.e(stringBuilder.toString());
            }
        }
    }
}
