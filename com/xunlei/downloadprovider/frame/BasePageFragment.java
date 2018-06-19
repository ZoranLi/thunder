package com.xunlei.downloadprovider.frame;

import android.content.Intent;
import android.os.Bundle;

public abstract class BasePageFragment extends BaseCacheViewFragment {
    private static final String TAG = "BasePageFragment";
    private boolean mIsFirstInvisible = true;
    private boolean mIsFirstVisible = true;
    private boolean mIsResume = false;
    protected boolean mIsUserVisible = false;

    public String getTabId() {
        return "";
    }

    public void onCustomActivityResult(int i, int i2, Intent intent) {
    }

    public void onExitApp() {
    }

    public void onFullScreenChange(boolean z) {
    }

    public void onMainTabClick(boolean z) {
    }

    public void onPageOff() {
    }

    public void onPageSelected() {
    }

    public void onUserInvisible(boolean z) {
    }

    public void onUserVisible(boolean z) {
    }

    public void onStart() {
        super.onStart();
        new StringBuilder("onStart--").append(this);
        this.mIsResume = true;
        if (getUserVisibleHint()) {
            visible();
        }
    }

    public void onStop() {
        super.onStop();
        new StringBuilder("onStop--").append(this);
        this.mIsResume = false;
        if (getUserVisibleHint()) {
            invisible();
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        StringBuilder stringBuilder = new StringBuilder("setUserVisibleHint--isVisibleToUser=");
        stringBuilder.append(z);
        stringBuilder.append("|");
        stringBuilder.append(this);
        if (z) {
            visible();
        } else {
            invisible();
        }
    }

    private void visible() {
        if (!this.mIsUserVisible && this.mIsResume) {
            this.mIsUserVisible = true;
            if (this.mIsFirstVisible) {
                onUserVisible(true);
                this.mIsFirstVisible = false;
                return;
            }
            onUserVisible(false);
        }
    }

    private void invisible() {
        if (this.mIsUserVisible) {
            this.mIsUserVisible = false;
            if (this.mIsFirstInvisible) {
                onUserInvisible(true);
                this.mIsFirstInvisible = false;
                return;
            }
            onUserInvisible(false);
        }
    }

    public void onNewExtras(Bundle bundle) {
        setExtras(bundle);
        new StringBuilder("onNewExtras--extras=").append(bundle);
    }
}
