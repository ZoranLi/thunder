package com.xunlei.common.accelerator.base;

import com.xunlei.common.accelerator.bean.AccelInfoResultBean;
import com.xunlei.common.accelerator.bean.AllExpCardsBean;
import com.xunlei.common.accelerator.bean.KeepResultBean;
import com.xunlei.common.accelerator.bean.PortalResultBean;
import com.xunlei.common.accelerator.bean.StartAccelResultBean;
import com.xunlei.common.accelerator.bean.StopAccelResultBean;
import com.xunlei.common.accelerator.bean.TimeCardResultBean;
import com.xunlei.common.accelerator.bean.TryInfoResultBean;

public interface IAcclHttpListener {
    void onAlreadyUpgrade(String str, KeepResultBean keepResultBean);

    void onGetBandInfo(int i, int i2, String str, AccelInfoResultBean accelInfoResultBean);

    void onGetTryAccelInfo(int i, int i2, String str, TryInfoResultBean tryInfoResultBean);

    void onGotALlCards(int i, int i2, String str, AllExpCardsBean allExpCardsBean);

    void onKeepAlive(int i, int i2, String str, KeepResultBean keepResultBean);

    void onQueryPortal(int i, int i2, PortalResultBean portalResultBean, boolean z);

    void onStartAccel(int i, int i2, String str, StartAccelResultBean startAccelResultBean, String str2);

    void onStopAccel(int i, int i2, String str, StopAccelResultBean stopAccelResultBean);

    void onTimeCardUsing(int i, int i2, String str, TimeCardResultBean timeCardResultBean);

    void onTimeCounterTimerTick(int i, int i2, boolean z);
}
