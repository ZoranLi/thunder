package com.xunlei.common.accelerator.js;

public interface KNJsInterface {

    public interface JumpLisenter {
        void jumpToLogin();

        void jumpToPay();
    }

    String getBandInfo();

    int getRemainTime();

    String getTryInfo();

    String getUserInfo();

    void queryStatus(String str);

    void recoverQuery(String str);

    void startAccel(String str);

    void startCardAccel(String str, String str2, int i);

    void startLogin();

    void startPay();

    void stopAccel(String str);
}
