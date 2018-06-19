package com.xunlei.common.accelerator.base;

import android.content.Context;
import com.xunlei.common.accelerator.bean.AccelInfoResultBean;
import com.xunlei.common.accelerator.bean.TryInfoResultBean;
import com.xunlei.common.accelerator.bean.XLAccelUser;
import com.xunlei.common.accelerator.controller.XLAccelController;

public abstract class BaseInteractor {
    protected XLAccelUser mAccelUser = new XLAccelUser();
    protected AccelInfoResultBean mBandInfo;
    protected Context mContext;
    protected int mCurrentStatus = 0;
    protected boolean mHadPortal = false;
    protected boolean mInited = false;
    protected int mIsKuaiNiaoVIP = 0;
    protected boolean mIsLoading = false;
    protected int mKeepAliveRetry = 0;
    protected TryInfoResultBean mTryInfo;
    protected XLAccelController xLAccelController;
}
