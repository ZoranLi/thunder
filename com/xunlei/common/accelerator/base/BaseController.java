package com.xunlei.common.accelerator.base;

import android.content.Context;
import com.xunlei.common.accelerator.http.XLAccelHttpReqInfo;
import com.xunlei.common.httpclient.AsyncHttpClient;
import com.xunlei.common.httpclient.BaseHttpClientListener;

public abstract class BaseController<ICBack, M extends BaseModel> {
    private AsyncHttpClient mAsyncHttpClient = null;
    private Context mContext;
    protected ICBack mInterator;
    protected M mModel;

    public BaseController(Context context, ICBack iCBack) {
        this.mContext = context;
        this.mInterator = iCBack;
        this.mAsyncHttpClient = new AsyncHttpClient();
        this.mAsyncHttpClient.setTimeout(XLAccelHttpReqInfo.HTTP_CLIENT_SOCKET_TIMEOUT);
    }

    protected void excuteRequest(String str, BaseHttpClientListener baseHttpClientListener) {
        this.mAsyncHttpClient.get(this.mContext, str, null, baseHttpClientListener);
    }
}
