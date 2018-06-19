package com.tencent.connect.common;

import android.content.Intent;
import com.baidu.mobads.openad.c.b;
import com.tencent.open.a.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class UIListenerManager {
    private static UIListenerManager a;
    private Map<String, ApiTask> b = Collections.synchronizedMap(new HashMap());

    /* compiled from: ProGuard */
    public class ApiTask {
        final /* synthetic */ UIListenerManager a;
        public IUiListener mListener;
        public int mRequestCode;

        public ApiTask(UIListenerManager uIListenerManager, int i, IUiListener iUiListener) {
            this.a = uIListenerManager;
            this.mRequestCode = i;
            this.mListener = iUiListener;
        }
    }

    public static UIListenerManager getInstance() {
        if (a == null) {
            a = new UIListenerManager();
        }
        return a;
    }

    private UIListenerManager() {
        if (this.b == null) {
            this.b = Collections.synchronizedMap(new HashMap());
        }
    }

    public Object setListenerWithRequestcode(int i, IUiListener iUiListener) {
        String a = g.a(i);
        if (a == null) {
            StringBuilder stringBuilder = new StringBuilder("setListener action is null! rquestCode=");
            stringBuilder.append(i);
            f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
            return null;
        }
        synchronized (this.b) {
            ApiTask apiTask = (ApiTask) this.b.put(a, new ApiTask(this, i, iUiListener));
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public Object setListnerWithAction(String str, IUiListener iUiListener) {
        int a = g.a(str);
        if (a == -1) {
            StringBuilder stringBuilder = new StringBuilder("setListnerWithAction fail, action = ");
            stringBuilder.append(str);
            f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
            return null;
        }
        synchronized (this.b) {
            ApiTask apiTask = (ApiTask) this.b.put(str, new ApiTask(this, a, iUiListener));
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public IUiListener getListnerWithRequestCode(int i) {
        String a = g.a(i);
        if (a != null) {
            return getListnerWithAction(a);
        }
        StringBuilder stringBuilder = new StringBuilder("getListner action is null! rquestCode=");
        stringBuilder.append(i);
        f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
        return 0;
    }

    public IUiListener getListnerWithAction(String str) {
        if (str == null) {
            f.e("openSDK_LOG.UIListenerManager", "getListnerWithAction action is null!");
            return null;
        }
        synchronized (this.b) {
            ApiTask apiTask = (ApiTask) this.b.get(str);
            this.b.remove(str);
        }
        if (apiTask == null) {
            return null;
        }
        return apiTask.mListener;
    }

    public void handleDataToListener(Intent intent, IUiListener iUiListener) {
        f.c("openSDK_LOG.UIListenerManager", "handleDataToListener");
        if (intent == null) {
            iUiListener.onCancel();
            return;
        }
        String stringExtra = intent.getStringExtra(Constants.KEY_ACTION);
        if ("action_login".equals(stringExtra)) {
            int intExtra = intent.getIntExtra(Constants.KEY_ERROR_CODE, 0);
            if (intExtra == 0) {
                String stringExtra2 = intent.getStringExtra(Constants.KEY_RESPONSE);
                if (stringExtra2 != null) {
                    try {
                        iUiListener.onComplete(i.d(stringExtra2));
                        return;
                    } catch (Throwable e) {
                        iUiListener.onError(new UiError(-4, Constants.MSG_JSON_ERROR, stringExtra2));
                        f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, json error", e);
                        return;
                    }
                }
                f.b("openSDK_LOG.UIListenerManager", "OpenUi, onActivityResult, onComplete");
                iUiListener.onComplete(new JSONObject());
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("OpenUi, onActivityResult, onError = ");
            stringBuilder.append(intExtra);
            f.e("openSDK_LOG.UIListenerManager", stringBuilder.toString());
            iUiListener.onError(new UiError(intExtra, intent.getStringExtra(Constants.KEY_ERROR_MSG), intent.getStringExtra(Constants.KEY_ERROR_DETAIL)));
            return;
        }
        if ("action_share".equals(stringExtra)) {
            stringExtra = intent.getStringExtra("result");
            intent = intent.getStringExtra("response");
            if ("cancel".equals(stringExtra)) {
                iUiListener.onCancel();
            } else if ("error".equals(stringExtra)) {
                iUiListener.onError(new UiError(-6, "unknown error", intent));
            } else if (b.COMPLETE.equals(stringExtra)) {
                try {
                    iUiListener.onComplete(new JSONObject(intent == null ? "{\"ret\": 0}" : intent));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    iUiListener.onError(new UiError(-4, "json error", intent));
                }
            }
        }
    }

    private IUiListener a(int i, IUiListener iUiListener) {
        if (i == 11101) {
            f.e("openSDK_LOG.UIListenerManager", "登录的接口回调不能重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == Constants.REQUEST_SOCIAL_API) {
            f.e("openSDK_LOG.UIListenerManager", "Social Api 的接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        } else if (i == Constants.REQUEST_SOCIAL_H5) {
            f.e("openSDK_LOG.UIListenerManager", "Social Api 的H5接口回调需要使用param来重新构建，暂时无法提供，先记录下来这种情况是否存在");
        }
        return iUiListener;
    }

    public boolean onActivityResult(int r5, int r6, android.content.Intent r7, com.tencent.tauth.IUiListener r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = "openSDK_LOG.UIListenerManager";
        r1 = new java.lang.StringBuilder;
        r2 = "onActivityResult req=";
        r1.<init>(r2);
        r1.append(r5);
        r2 = " res=";
        r1.append(r2);
        r1.append(r6);
        r1 = r1.toString();
        com.tencent.open.a.f.c(r0, r1);
        r0 = r4.getListnerWithRequestCode(r5);
        r1 = 0;
        if (r0 != 0) goto L_0x0031;
    L_0x0022:
        if (r8 == 0) goto L_0x0029;
    L_0x0024:
        r0 = r4.a(r5, r8);
        goto L_0x0031;
    L_0x0029:
        r5 = "openSDK_LOG.UIListenerManager";
        r6 = "onActivityResult can't find the listener";
        com.tencent.open.a.f.e(r5, r6);
        return r1;
    L_0x0031:
        r5 = -1;
        r8 = 1;
        if (r6 != r5) goto L_0x0157;
    L_0x0035:
        r5 = -6;
        if (r7 != 0) goto L_0x0045;
    L_0x0038:
        r6 = new com.tencent.tauth.UiError;
        r7 = "onActivityResult intent data is null.";
        r1 = "onActivityResult intent data is null.";
        r6.<init>(r5, r7, r1);
        r0.onError(r6);
        return r8;
    L_0x0045:
        r6 = "key_action";
        r6 = r7.getStringExtra(r6);
        r2 = "action_login";
        r2 = r2.equals(r6);
        r3 = -4;
        if (r2 == 0) goto L_0x00bb;
    L_0x0054:
        r5 = "key_error_code";
        r5 = r7.getIntExtra(r5, r1);
        if (r5 != 0) goto L_0x0092;
    L_0x005c:
        r5 = "key_response";
        r5 = r7.getStringExtra(r5);
        if (r5 == 0) goto L_0x0081;
    L_0x0064:
        r6 = com.tencent.open.utils.i.d(r5);	 Catch:{ JSONException -> 0x006d }
        r0.onComplete(r6);	 Catch:{ JSONException -> 0x006d }
        goto L_0x015a;
    L_0x006d:
        r6 = move-exception;
        r7 = new com.tencent.tauth.UiError;
        r1 = "服务器返回数据格式有误!";
        r7.<init>(r3, r1, r5);
        r0.onError(r7);
        r5 = "openSDK_LOG.UIListenerManager";
        r7 = "OpenUi, onActivityResult, json error";
        com.tencent.open.a.f.b(r5, r7, r6);
        goto L_0x015a;
    L_0x0081:
        r5 = "openSDK_LOG.UIListenerManager";
        r6 = "OpenUi, onActivityResult, onComplete";
        com.tencent.open.a.f.b(r5, r6);
        r5 = new org.json.JSONObject;
        r5.<init>();
        r0.onComplete(r5);
        goto L_0x015a;
    L_0x0092:
        r6 = "openSDK_LOG.UIListenerManager";
        r1 = new java.lang.StringBuilder;
        r2 = "OpenUi, onActivityResult, onError = ";
        r1.<init>(r2);
        r1.append(r5);
        r1 = r1.toString();
        com.tencent.open.a.f.e(r6, r1);
        r6 = "key_error_msg";
        r6 = r7.getStringExtra(r6);
        r1 = "key_error_detail";
        r7 = r7.getStringExtra(r1);
        r1 = new com.tencent.tauth.UiError;
        r1.<init>(r5, r6, r7);
        r0.onError(r1);
        goto L_0x015a;
    L_0x00bb:
        r2 = "action_share";
        r6 = r2.equals(r6);
        if (r6 == 0) goto L_0x0116;
    L_0x00c3:
        r6 = "result";
        r6 = r7.getStringExtra(r6);
        r1 = "response";
        r7 = r7.getStringExtra(r1);
        r1 = "cancel";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x00dc;
    L_0x00d7:
        r0.onCancel();
        goto L_0x015a;
    L_0x00dc:
        r1 = "error";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x00f0;
    L_0x00e4:
        r6 = new com.tencent.tauth.UiError;
        r1 = "unknown error";
        r6.<init>(r5, r1, r7);
        r0.onError(r6);
        goto L_0x015a;
    L_0x00f0:
        r5 = "complete";
        r5 = r5.equals(r6);
        if (r5 == 0) goto L_0x015a;
    L_0x00f8:
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0107 }
        if (r7 != 0) goto L_0x00ff;	 Catch:{ JSONException -> 0x0107 }
    L_0x00fc:
        r6 = "{\"ret\": 0}";	 Catch:{ JSONException -> 0x0107 }
        goto L_0x0100;	 Catch:{ JSONException -> 0x0107 }
    L_0x00ff:
        r6 = r7;	 Catch:{ JSONException -> 0x0107 }
    L_0x0100:
        r5.<init>(r6);	 Catch:{ JSONException -> 0x0107 }
        r0.onComplete(r5);	 Catch:{ JSONException -> 0x0107 }
        goto L_0x015a;
    L_0x0107:
        r5 = move-exception;
        r5.printStackTrace();
        r5 = new com.tencent.tauth.UiError;
        r6 = "json error";
        r5.<init>(r3, r6, r7);
        r0.onError(r5);
        goto L_0x015a;
    L_0x0116:
        r5 = "key_error_code";
        r5 = r7.getIntExtra(r5, r1);
        if (r5 != 0) goto L_0x0142;
    L_0x011e:
        r5 = "key_response";
        r5 = r7.getStringExtra(r5);
        if (r5 == 0) goto L_0x0139;
    L_0x0126:
        r6 = com.tencent.open.utils.i.d(r5);	 Catch:{ JSONException -> 0x012e }
        r0.onComplete(r6);	 Catch:{ JSONException -> 0x012e }
        goto L_0x015a;
    L_0x012e:
        r6 = new com.tencent.tauth.UiError;
        r7 = "服务器返回数据格式有误!";
        r6.<init>(r3, r7, r5);
        r0.onError(r6);
        goto L_0x015a;
    L_0x0139:
        r5 = new org.json.JSONObject;
        r5.<init>();
        r0.onComplete(r5);
        goto L_0x015a;
    L_0x0142:
        r6 = "key_error_msg";
        r6 = r7.getStringExtra(r6);
        r1 = "key_error_detail";
        r7 = r7.getStringExtra(r1);
        r1 = new com.tencent.tauth.UiError;
        r1.<init>(r5, r6, r7);
        r0.onError(r1);
        goto L_0x015a;
    L_0x0157:
        r0.onCancel();
    L_0x015a:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.common.UIListenerManager.onActivityResult(int, int, android.content.Intent, com.tencent.tauth.IUiListener):boolean");
    }
}
