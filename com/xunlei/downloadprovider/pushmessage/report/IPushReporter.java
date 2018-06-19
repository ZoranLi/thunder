package com.xunlei.downloadprovider.pushmessage.report;

import android.content.Context;
import com.xunlei.downloadprovider.pushmessage.bean.BasePushMessageInfo;
import java.io.Serializable;

public interface IPushReporter<INFO extends BasePushMessageInfo> extends Serializable {
    public static final String TAG = "push.IPushReporter";

    void reportClick(Context context, INFO info);

    void reportError(Context context, INFO info, String str);

    void reportReceive(Context context, INFO info);

    void reportShow(Context context, INFO info);
}
