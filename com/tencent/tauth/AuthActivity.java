package com.tencent.tauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.taobao.applink.util.TBAppLinkUtil;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.utils.g;
import com.tencent.open.utils.i;

/* compiled from: ProGuard */
public class AuthActivity extends Activity {
    public static final String ACTION_KEY = "action";
    public static final String ACTION_SHARE_PRIZE = "sharePrize";
    private static int a;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            f.d("openSDK_LOG.AuthActivity", "-->onCreate, getIntent() return null");
            finish();
            return;
        }
        bundle = null;
        try {
            bundle = getIntent().getData();
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("-->onCreate, getIntent().getData() has exception! ");
            stringBuilder.append(e.getMessage());
            f.e("openSDK_LOG.AuthActivity", stringBuilder.toString());
        }
        StringBuilder stringBuilder2 = new StringBuilder("-->onCreate, uri: ");
        stringBuilder2.append(bundle);
        f.a("openSDK_LOG.AuthActivity", stringBuilder2.toString());
        a(bundle);
    }

    private void a(Uri uri) {
        f.c("openSDK_LOG.AuthActivity", "-->handleActionUri--start");
        if (!(uri == null || uri.toString() == null)) {
            if (!uri.toString().equals("")) {
                uri = uri.toString();
                uri = i.a(uri.substring(uri.indexOf("#") + 1));
                if (uri == null) {
                    f.d("openSDK_LOG.AuthActivity", "-->handleActionUri, bundle is null");
                    finish();
                    return;
                }
                String string = uri.getString("action");
                StringBuilder stringBuilder = new StringBuilder("-->handleActionUri, action: ");
                stringBuilder.append(string);
                f.c("openSDK_LOG.AuthActivity", stringBuilder.toString());
                if (string == null) {
                    finish();
                    return;
                }
                Intent launchIntentForPackage;
                if (!(string.equals("shareToQQ") || string.equals("shareToQzone") || string.equals("sendToMyComputer"))) {
                    if (!string.equals("shareToTroopBar")) {
                        if (string.equals("addToQQFavorites")) {
                            Intent intent = getIntent();
                            intent.putExtras(uri);
                            intent.putExtra(Constants.KEY_ACTION, "action_share");
                            uri = UIListenerManager.getInstance().getListnerWithAction(string);
                            if (uri != null) {
                                UIListenerManager.getInstance().handleDataToListener(intent, (IUiListener) uri);
                            }
                            finish();
                            return;
                        }
                        if (string.equals(ACTION_SHARE_PRIZE)) {
                            launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
                            String str = "";
                            try {
                                uri = i.d(uri.getString("response")).getString("activityid");
                            } catch (Uri uri2) {
                                f.b("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.", uri2);
                                uri2 = str;
                            }
                            if (!TextUtils.isEmpty(uri2)) {
                                launchIntentForPackage.putExtra(ACTION_SHARE_PRIZE, true);
                                Bundle bundle = new Bundle();
                                bundle.putString("activityid", uri2);
                                launchIntentForPackage.putExtras(bundle);
                            }
                            startActivity(launchIntentForPackage);
                        }
                        finish();
                        return;
                    }
                }
                if (string.equals("shareToQzone") && g.a((Context) this, "com.tencent.mobileqq") != null && g.c(this, TBAppLinkUtil.BASE_TB_VERSION) < 0) {
                    int i = a + 1;
                    a = i;
                    if (i == 2) {
                        a = null;
                        finish();
                        return;
                    }
                }
                f.c("openSDK_LOG.AuthActivity", "-->handleActionUri, most share action, start assistactivity");
                launchIntentForPackage = new Intent(this, AssistActivity.class);
                launchIntentForPackage.putExtras(uri2);
                launchIntentForPackage.setFlags(603979776);
                startActivity(launchIntentForPackage);
                finish();
                return;
            }
        }
        f.d("openSDK_LOG.AuthActivity", "-->handleActionUri, uri invalid");
        finish();
    }
}
