package com.xunlei.downloadprovider.member.login.b;

/* compiled from: LoginCompletedListener */
public abstract class c {
    private boolean mCanceled;

    public void onLoginCanceled(boolean z) {
    }

    public abstract void onLoginCompleted(boolean z, int i, Object obj);

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public void cancel() {
        this.mCanceled = true;
    }
}
