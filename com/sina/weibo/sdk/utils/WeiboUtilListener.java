package com.sina.weibo.sdk.utils;

import android.os.Bundle;
import com.sina.weibo.sdk.exception.WeiboException;

public interface WeiboUtilListener {
    void onCancel();

    void onComplete(Bundle bundle);

    void onWeiboException(WeiboException weiboException);
}
