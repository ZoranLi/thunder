package com.xunlei.common.commonview;

class XLToast$NetworkToastManager {
    boolean mIsNoNetworkToastForbidden;
    long mLastTimeForNoNetworkToastForbidden;

    private XLToast$NetworkToastManager() {
        this.mIsNoNetworkToastForbidden = false;
        this.mLastTimeForNoNetworkToastForbidden = 0;
    }

    void setNoNetworkToastForbidden(boolean z) {
        this.mIsNoNetworkToastForbidden = z;
        this.mLastTimeForNoNetworkToastForbidden = System.currentTimeMillis();
    }

    boolean isNoNetworkToastForbidden() {
        if (!this.mIsNoNetworkToastForbidden || System.currentTimeMillis() - this.mLastTimeForNoNetworkToastForbidden > 10000) {
            return false;
        }
        return true;
    }
}
