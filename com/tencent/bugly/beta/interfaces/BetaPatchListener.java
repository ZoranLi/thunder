package com.tencent.bugly.beta.interfaces;

/* compiled from: BUGLY */
public interface BetaPatchListener {
    void onApplyFailure(String str);

    void onApplySuccess(String str);

    void onDownloadFailure(String str);

    void onDownloadReceived(long j, long j2);

    void onDownloadSuccess(String str);

    void onPatchReceived(String str);

    void onPatchRollback();
}
