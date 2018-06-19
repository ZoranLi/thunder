package com.xunlei.common.new_ptl.member.act;

import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.xiaomi.account.openauth.XiaomiOAuthFuture;
import com.xiaomi.account.openauth.XiaomiOAuthResults;
import com.xiaomi.account.openauth.XiaomiOAuthorize;
import com.xunlei.common.base.XLLog;
import com.xunlei.common.httpclient.BaseHttpClientListener;
import com.xunlei.common.new_ptl.member.XLErrorCode;
import com.xunlei.common.new_ptl.member.a.p;
import com.xunlei.common.new_ptl.member.task.h.e;
import org.apache.http.Header;
import org.json.JSONObject;

public class XLXmLoginActivity extends Activity {
    private final String TAG = XLXmLoginActivity.class.getSimpleName();
    private XiaomiOAuthFuture<XiaomiOAuthResults> mAuthFuture = null;
    private XiaomiOAuthResults mAuthResult = null;
    private String mClientFrom = "";
    private int mFirstLoginFlag = 0;
    private Handler mHandler = new Handler();
    private int mTaskId = 0;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mClientFrom = getIntent().getStringExtra("xm_client_from");
        this.mTaskId = getIntent().getIntExtra("xm_task", 0);
        this.mAuthFuture = new XiaomiOAuthorize().setAppId(2882303761517159179L).setRedirectUrl("https://open-api-auth.xunlei.com").startGetOAuthCode(this);
        waitXiaoMiFutureResult(this.mAuthFuture);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            sendResultToHost(0, intent.getStringExtra("xl_bind_tid"), intent.getStringExtra("xl_bind_ttoken"), intent.getStringExtra("xl_bind_tsign"));
        } else {
            sendResultToHost(i2, null, null, null);
        }
    }

    protected void checkXiaoMiAccountBind(String str) {
        p.a().l().get(p.a().h(), String.format("https://open-api-auth.xunlei.com/platform?m=BindOauthSession&op=getInfo&from=%s&code=%s&version=%s", new Object[]{this.mClientFrom, str, "3.0"}), null, new BaseHttpClientListener() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                if (i == 200) {
                    try {
                        try {
                            headerArr = new JSONObject(new String(bArr, "UTF-8"));
                            if (headerArr.getInt("result") == 0) {
                                i = headerArr.optString("url");
                                if (TextUtils.isEmpty(i) != null) {
                                    XLXmLoginActivity.this.mFirstLoginFlag = 0;
                                    XLXmLoginActivity.this.sendResultToHost(0, headerArr.getString("third_id"), headerArr.getString("mi_token"), headerArr.getString("sign"));
                                    return;
                                }
                                XLXmLoginActivity.this.mFirstLoginFlag = 1;
                                XLXmLoginActivity.this.mHandler.postDelayed(new Runnable() {
                                    public void run() {
                                        XLXmLoginActivity.this.startBindXunleiAccount(i);
                                    }
                                }, 0);
                                return;
                            }
                        } catch (int i2) {
                            i2.printStackTrace();
                        }
                    } catch (int i22) {
                        i22.printStackTrace();
                    }
                }
                XLXmLoginActivity.this.sendResultToHost(16781282, null, null, null);
            }

            public void onFailure(Throwable th, byte[] bArr) {
                XLXmLoginActivity.this.sendResultToHost(XLErrorCode.AUTH_USER_ERROR, null, null, null);
            }
        });
    }

    protected void startBindXunleiAccount(String str) {
        Intent intent = new Intent(this, XLXmBindActivity.class);
        intent.putExtra("xl_bind_url", str);
        startActivityForResult(intent, 9527);
    }

    protected void sendResultToHost(int i, String str, String str2, String str3) {
        e eVar = (e) p.a().a(this.mTaskId);
        if (eVar != null) {
            eVar.f(this.mFirstLoginFlag);
            eVar.a(i, str, str2, str3);
        }
        finish();
    }

    private <V> void waitXiaoMiFutureResult(XiaomiOAuthFuture<V> xiaomiOAuthFuture) {
        new AsyncTask<Void, Void, V>() {
            private Exception e = null;

            protected void onPreExecute() {
                XLLog.v(XLXmLoginActivity.this.TAG, "waiting for Future result...");
            }

            protected V doInBackground(Void... voidArr) {
                try {
                    return XLXmLoginActivity.this.mAuthFuture.getResult();
                } catch (Void[] voidArr2) {
                    this.e = voidArr2;
                    return null;
                } catch (Void[] voidArr22) {
                    this.e = voidArr22;
                    return null;
                } catch (Void[] voidArr222) {
                    this.e = voidArr222;
                    return null;
                }
            }

            protected void onPostExecute(V v) {
                if (v != null && (v instanceof XiaomiOAuthResults)) {
                    XLXmLoginActivity.this.mAuthResult = (XiaomiOAuthResults) v;
                    if (XLXmLoginActivity.this.mAuthResult.getErrorCode() == null) {
                        XLXmLoginActivity.this.mHandler.postDelayed(new Runnable() {
                            public void run() {
                                XLXmLoginActivity.this.checkXiaoMiAccountBind(XLXmLoginActivity.this.mAuthResult.getCode());
                            }
                        }, 0);
                        return;
                    }
                }
                XLXmLoginActivity.this.sendResultToHost((this.e instanceof OperationCanceledException) != null ? XLErrorCode.AUTH_USER_CANCLE : XLErrorCode.AUTH_USER_ERROR, null, null, null);
            }
        }.execute(new Void[0]);
    }
}
