package com.taobao.tao.remotebusiness.login;

public interface IRemoteLogin {
    LoginContext getLoginContext();

    boolean isLogining();

    boolean isSessionValid();

    void login(onLoginListener com_taobao_tao_remotebusiness_login_onLoginListener, boolean z);
}
