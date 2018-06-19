package com.xunlei.common.accelerator;

import android.content.Context;
import com.xunlei.common.accelerator.bean.KnParams;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;

public interface XLAccelerator {

    public static class AccelStatus {
        public static final int AS_ACCEL = 1;
        public static final int AS_NOT_ACCEL = 2;
        public static final int AS_UNKNOW = 0;
    }

    void attachListener(XLOnAccelListener xLOnAccelListener);

    void detachListener(XLOnAccelListener xLOnAccelListener);

    String getBandInfo();

    XLAccelBandInfo getBandInfoObject();

    KnParams getKnParams();

    String getPortalUrl();

    int getRemainTime();

    String getTryInfo();

    String getUserInfo();

    String getUsingCardInfo();

    String getVersion();

    boolean init(Context context, String str, String str2);

    int isKuaiNiao();

    void queryAllExpCards(XLOnAllCardsListener xLOnAllCardsListener);

    void queryStatus();

    void reInit();

    void recoverQuery();

    void saveAccelState(Context context);

    void startAccel();

    void startAccelWithCard(String str, int i);

    void stopAccel();

    boolean uninit();

    void updateUserInfo();
}
