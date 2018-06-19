package com.sina.weibo.sdk.net;

import android.content.Context;
import android.os.AsyncTask;
import com.sina.weibo.sdk.exception.WeiboException;

public class AsyncWeiboRunner {
    private Context mContext;

    private static class AsyncTaskResult<T> {
        private WeiboException error;
        private T result;

        public T getResult() {
            return this.result;
        }

        public WeiboException getError() {
            return this.error;
        }

        public AsyncTaskResult(T t) {
            this.result = t;
        }

        public AsyncTaskResult(WeiboException weiboException) {
            this.error = weiboException;
        }
    }

    public static class RequestRunner extends AsyncTask<Void, Void, AsyncTaskResult<String>> {
        private final Context mContext;
        private final String mHttpMethod;
        private final RequestListener mListener;
        private final WeiboParameters mParams;
        private final String mUrl;

        protected void onPreExecute() {
        }

        public RequestRunner(Context context, String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
            this.mContext = context;
            this.mUrl = str;
            this.mParams = weiboParameters;
            this.mHttpMethod = str2;
            this.mListener = requestListener;
        }

        protected AsyncTaskResult<String> doInBackground(Void... voidArr) {
            try {
                return new AsyncTaskResult(HttpManager.openUrl(this.mContext, this.mUrl, this.mHttpMethod, this.mParams));
            } catch (WeiboException e) {
                return new AsyncTaskResult(e);
            }
        }

        protected void onPostExecute(AsyncTaskResult<String> asyncTaskResult) {
            WeiboException error = asyncTaskResult.getError();
            if (error != null) {
                this.mListener.onWeiboException(error);
            } else {
                this.mListener.onComplete((String) asyncTaskResult.getResult());
            }
        }
    }

    public AsyncWeiboRunner(Context context) {
        this.mContext = context;
    }

    @Deprecated
    public void requestByThread(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        final String str3 = str;
        final String str4 = str2;
        final WeiboParameters weiboParameters2 = weiboParameters;
        final RequestListener requestListener2 = requestListener;
        new Thread() {
            public void run() {
                try {
                    String openUrl = HttpManager.openUrl(AsyncWeiboRunner.this.mContext, str3, str4, weiboParameters2);
                    if (requestListener2 != null) {
                        requestListener2.onComplete(openUrl);
                    }
                } catch (WeiboException e) {
                    if (requestListener2 != null) {
                        requestListener2.onWeiboException(e);
                    }
                }
            }
        }.start();
    }

    public void request4RdirectURL(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        final String str3 = str;
        final String str4 = str2;
        final WeiboParameters weiboParameters2 = weiboParameters;
        final RequestListener requestListener2 = requestListener;
        new Thread() {
            public void run() {
                try {
                    String openRedirectUrl4LocationUri = HttpManager.openRedirectUrl4LocationUri(AsyncWeiboRunner.this.mContext, str3, str4, weiboParameters2);
                    if (requestListener2 != null) {
                        requestListener2.onComplete(openRedirectUrl4LocationUri);
                    }
                } catch (WeiboException e) {
                    if (requestListener2 != null) {
                        requestListener2.onWeiboException(e);
                    }
                }
            }
        }.start();
    }

    public String request(String str, WeiboParameters weiboParameters, String str2) throws WeiboException {
        addAction(this.mContext, weiboParameters.getAppKey());
        return HttpManager.openUrl(this.mContext, str, str2, weiboParameters);
    }

    public String request(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4) throws WeiboException {
        if (!z) {
            return request(str3, weiboParameters, str4);
        }
        weiboParameters.put("source", str);
        weiboParameters.setAnonymousCookie(str2);
        return request(str3, weiboParameters, str4);
    }

    public void requestAsync(String str, WeiboParameters weiboParameters, String str2, RequestListener requestListener) {
        addAction(this.mContext, weiboParameters.getAppKey());
        new RequestRunner(this.mContext, str, weiboParameters, str2, requestListener).execute(new Void[]{null});
    }

    public void requestAsync(String str, boolean z, String str2, String str3, WeiboParameters weiboParameters, String str4, RequestListener requestListener) {
        if (z) {
            weiboParameters.put("source", str);
            weiboParameters.setAnonymousCookie(str2);
        }
        requestAsync(str3, weiboParameters, str4, requestListener);
    }

    private void addAction(android.content.Context r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = "com.sina.weibo.sdk.cmd.WbAppActivator";	 Catch:{ Exception -> 0x0036 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0036 }
        r1 = "getInstance";	 Catch:{ Exception -> 0x0036 }
        r2 = 2;	 Catch:{ Exception -> 0x0036 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0036 }
        r4 = android.content.Context.class;	 Catch:{ Exception -> 0x0036 }
        r5 = 0;	 Catch:{ Exception -> 0x0036 }
        r3[r5] = r4;	 Catch:{ Exception -> 0x0036 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0036 }
        r6 = 1;	 Catch:{ Exception -> 0x0036 }
        r3[r6] = r4;	 Catch:{ Exception -> 0x0036 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x0036 }
        r1 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0036 }
        r1[r5] = r8;	 Catch:{ Exception -> 0x0036 }
        r1[r6] = r9;	 Catch:{ Exception -> 0x0036 }
        r8 = 0;	 Catch:{ Exception -> 0x0036 }
        r9 = r0.invoke(r8, r1);	 Catch:{ Exception -> 0x0036 }
        r9 = r9.getClass();	 Catch:{ Exception -> 0x0036 }
        r0 = "activateApp";	 Catch:{ Exception -> 0x0036 }
        r1 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x0036 }
        r9 = r9.getMethod(r0, r1);	 Catch:{ Exception -> 0x0036 }
        r0 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0036 }
        r9.invoke(r8, r0);	 Catch:{ Exception -> 0x0036 }
        return;
    L_0x0036:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.net.AsyncWeiboRunner.addAction(android.content.Context, java.lang.String):void");
    }
}
