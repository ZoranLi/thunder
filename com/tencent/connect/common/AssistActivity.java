package com.tencent.connect.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.i;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AssistActivity extends Activity {
    public static final String EXTRA_INTENT = "openSDK_LOG.AssistActivity.ExtraIntent";
    protected boolean a = false;
    protected Handler b = new Handler(this) {
        final /* synthetic */ AssistActivity a;

        {
            this.a = r1;
        }

        public void handleMessage(Message message) {
            if (message.what == null) {
                if (this.a.isFinishing() == null) {
                    f.d("openSDK_LOG.AssistActivity", "-->finish by timeout");
                    this.a.finish();
                }
            }
        }
    };
    private boolean c = false;
    private String d;

    public static Intent getAssistActivityIntent(Context context) {
        return new Intent(context, AssistActivity.class);
    }

    protected void onCreate(Bundle bundle) {
        int i;
        String str;
        requestWindowFeature(1);
        super.onCreate(bundle);
        setRequestedOrientation(3);
        f.b("openSDK_LOG.AssistActivity", "--onCreate--");
        if (getIntent() == null) {
            f.e("openSDK_LOG.AssistActivity", "-->onCreate--getIntent() returns null");
            finish();
        }
        Intent intent = (Intent) getIntent().getParcelableExtra(EXTRA_INTENT);
        if (intent == null) {
            i = 0;
        } else {
            i = intent.getIntExtra(Constants.KEY_REQUEST_CODE, 0);
        }
        if (intent == null) {
            str = "";
        } else {
            str = intent.getStringExtra("appid");
        }
        this.d = str;
        Bundle bundleExtra = getIntent().getBundleExtra("h5_share_data");
        if (bundle != null) {
            this.c = bundle.getBoolean("RESTART_FLAG");
            this.a = bundle.getBoolean("RESUME_FLAG", false);
        }
        if (this.c != null) {
            f.b("openSDK_LOG.AssistActivity", "is restart");
        } else if (bundleExtra != null) {
            f.d("openSDK_LOG.AssistActivity", "--onCreate--h5 bundle not null, will open browser");
            a(bundleExtra);
        } else if (intent != null) {
            StringBuilder stringBuilder = new StringBuilder("--onCreate--activityIntent not null, will start activity, reqcode = ");
            stringBuilder.append(i);
            f.c("openSDK_LOG.AssistActivity", stringBuilder.toString());
            startActivityForResult(intent, i);
        } else {
            f.e("openSDK_LOG.AssistActivity", "--onCreate--activityIntent is null");
            finish();
        }
    }

    protected void onStart() {
        f.b("openSDK_LOG.AssistActivity", "-->onStart");
        super.onStart();
    }

    protected void onResume() {
        f.b("openSDK_LOG.AssistActivity", "-->onResume");
        super.onResume();
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("is_login", false)) {
            if (!(intent.getBooleanExtra("is_qq_mobile_share", false) || !this.c || isFinishing())) {
                finish();
            }
            if (this.a) {
                this.b.sendMessage(this.b.obtainMessage(0));
                return;
            }
            this.a = true;
        }
    }

    protected void onPause() {
        f.b("openSDK_LOG.AssistActivity", "-->onPause");
        this.b.removeMessages(0);
        super.onPause();
    }

    protected void onStop() {
        f.b("openSDK_LOG.AssistActivity", "-->onStop");
        super.onStop();
    }

    protected void onDestroy() {
        f.b("openSDK_LOG.AssistActivity", "-->onDestroy");
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        f.c("openSDK_LOG.AssistActivity", "--onNewIntent");
        super.onNewIntent(intent);
        intent.putExtra(Constants.KEY_ACTION, "action_share");
        setResult(-1, intent);
        if (isFinishing() == null) {
            f.c("openSDK_LOG.AssistActivity", "--onNewIntent--activity not finished, finish now");
            finish();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        f.b("openSDK_LOG.AssistActivity", "--onSaveInstanceState--");
        bundle.putBoolean("RESTART_FLAG", true);
        bundle.putBoolean("RESUME_FLAG", this.a);
        super.onSaveInstanceState(bundle);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = "openSDK_LOG.AssistActivity";
        StringBuilder stringBuilder = new StringBuilder("--onActivityResult--requestCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" | resultCode: ");
        stringBuilder.append(i2);
        stringBuilder.append("data = null ? ");
        stringBuilder.append(intent == null);
        f.c(str, stringBuilder.toString());
        super.onActivityResult(i, i2, intent);
        if (i != 0) {
            if (intent != null) {
                intent.putExtra(Constants.KEY_ACTION, "action_login");
            }
            setResultData(i, intent);
            finish();
        }
    }

    public void setResultData(int i, Intent intent) {
        if (intent == null) {
            f.d("openSDK_LOG.AssistActivity", "--setResultData--intent is null, setResult ACTIVITY_CANCEL");
            setResult(0);
            if (i == 11101) {
                d.a().a("", this.d, "2", "1", "7", "2");
            }
            return;
        }
        try {
            i = intent.getStringExtra(Constants.KEY_RESPONSE);
            StringBuilder stringBuilder = new StringBuilder("--setResultDataForLogin-- ");
            stringBuilder.append(i);
            f.b("openSDK_LOG.AssistActivity", stringBuilder.toString());
            if (TextUtils.isEmpty(i)) {
                f.d("openSDK_LOG.AssistActivity", "--setResultData--response is empty, setResult ACTIVITY_OK");
                setResult(-1, intent);
                return;
            }
            JSONObject jSONObject = new JSONObject(i);
            Object optString = jSONObject.optString("openid");
            i = jSONObject.optString("access_token");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(i) != 0) {
                f.d("openSDK_LOG.AssistActivity", "--setResultData--openid or token is empty, setResult ACTIVITY_CANCEL");
                setResult(0, intent);
                d.a().a("", this.d, "2", "1", "7", "1");
                return;
            }
            f.c("openSDK_LOG.AssistActivity", "--setResultData--openid and token not empty, setResult ACTIVITY_OK");
            setResult(-1, intent);
            d.a().a(optString, this.d, "2", "1", "7", "0");
        } catch (int i2) {
            f.e("openSDK_LOG.AssistActivity", "--setResultData--parse response failed");
            i2.printStackTrace();
        }
    }

    private void a(Bundle bundle) {
        String string = bundle.getString("viaShareType");
        String string2 = bundle.getString("callbackAction");
        String string3 = bundle.getString("url");
        String string4 = bundle.getString("openId");
        String string5 = bundle.getString("appId");
        bundle = "";
        String str = "";
        if ("shareToQQ".equals(string2)) {
            bundle = Constants.VIA_SHARE_TO_QQ;
            str = "10";
        } else if ("shareToQzone".equals(string2)) {
            bundle = Constants.VIA_SHARE_TO_QZONE;
            str = "11";
        }
        String str2 = str;
        Bundle bundle2 = bundle;
        if (i.a((Context) this, string3) == null) {
            bundle = UIListenerManager.getInstance().getListnerWithAction(string2);
            if (bundle != null) {
                bundle.onError(new UiError(-6, Constants.MSG_OPEN_BROWSER_ERROR, null));
            }
            d.a().a(string4, string5, bundle2, str2, "3", "1", string, "0", "2", "0");
            finish();
        } else {
            d.a().a(string4, string5, bundle2, str2, "3", "0", string, "0", "2", "0");
        }
        getIntent().removeExtra("shareH5");
    }
}
