package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.c.b;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.d;
import com.tencent.open.utils.e;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class SocialApiIml extends BaseApi {
    private Activity c;

    /* compiled from: ProGuard */
    private class a implements IUiListener {
        final /* synthetic */ SocialApiIml a;
        private IUiListener b;
        private String c;
        private String d;
        private Bundle e;
        private Activity f;

        a(SocialApiIml socialApiIml, Activity activity, IUiListener iUiListener, String str, String str2, Bundle bundle) {
            this.a = socialApiIml;
            this.b = iUiListener;
            this.c = str;
            this.d = str2;
            this.e = bundle;
        }

        public void onComplete(Object obj) {
            try {
                obj = ((JSONObject) obj).getString(SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (Object obj2) {
                obj2.printStackTrace();
                f.b("openSDK_LOG.SocialApiIml", "OpenApi, EncrytokenListener() onComplete error", obj2);
                obj2 = null;
            }
            this.e.putString("encrytoken", obj2);
            this.a.a(this.a.c, this.c, this.e, this.d, this.b);
            if (TextUtils.isEmpty(obj2) != null) {
                f.b("openSDK_LOG.SocialApiIml", "The token get from qq or qzone is empty. Write temp token to localstorage.");
                this.a.writeEncryToken(this.f);
            }
        }

        public void onError(UiError uiError) {
            StringBuilder stringBuilder = new StringBuilder("OpenApi, EncryptTokenListener() onError");
            stringBuilder.append(uiError.errorMessage);
            f.b("openSDK_LOG.SocialApiIml", stringBuilder.toString());
            this.b.onError(uiError);
        }

        public void onCancel() {
            this.b.onCancel();
        }
    }

    public SocialApiIml(QQToken qQToken) {
        super(qQToken);
    }

    public SocialApiIml(c cVar, QQToken qQToken) {
        super(cVar, qQToken);
    }

    public void gift(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void ask(Activity activity, Bundle bundle, IUiListener iUiListener) {
        a(activity, SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    private void a(Activity activity, String str, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c == null) {
            f.c("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            c = c(SocialConstants.ACTIVITY_ASK_GIFT);
        }
        Intent intent = c;
        bundle.putAll(b());
        if (SocialConstants.ACTION_ASK.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_REQUEST);
        } else if (SocialConstants.ACTION_GIFT.equals(str)) {
            bundle.putString("type", SocialConstants.TYPE_FREEGIFT);
        }
        a(activity, intent, str, bundle, com.tencent.open.utils.f.a().a(d.a(), "http://qzs.qq.com/open/mobile/request/sdk_request.html?"), iUiListener, false);
    }

    public void invite(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c = c(SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (c == null) {
            f.c("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            c = c(SocialConstants.ACTIVITY_INVITE);
        }
        Intent intent = c;
        bundle.putAll(b());
        Activity activity2 = activity;
        a(activity2, intent, SocialConstants.ACTION_INVITE, bundle, com.tencent.open.utils.f.a().a(d.a(), "http://qzs.qq.com/open/mobile/invite/sdk_invite.html?"), iUiListener, false);
    }

    public void story(Activity activity, Bundle bundle, IUiListener iUiListener) {
        this.c = activity;
        Intent c = c(SocialConstants.ACTIVITY_STORY);
        bundle.putAll(b());
        Activity activity2 = activity;
        a(activity2, c, SocialConstants.ACTION_STORY, bundle, com.tencent.open.utils.f.a().a(d.a(), "http://qzs.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html?"), iUiListener, false);
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, String str2, IUiListener iUiListener, boolean z) {
        String str3 = "openSDK_LOG.SocialApiIml";
        StringBuilder stringBuilder = new StringBuilder("-->handleIntent action = ");
        stringBuilder.append(str);
        stringBuilder.append(", activityIntent = null ? ");
        Object obj = null;
        stringBuilder.append(intent == null);
        f.c(str3, stringBuilder.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        intent = e.a(d.a(), this.b.getAppId());
        if (z || intent.b("C_LoginH5") != null) {
            obj = 1;
        }
        if (obj != null) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(Activity activity, Intent intent, String str, Bundle bundle, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder("-->handleIntentWithAgent action = ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.SocialApiIml", stringBuilder.toString());
        intent.putExtra(Constants.KEY_ACTION, str);
        intent.putExtra(Constants.KEY_PARAMS, bundle);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_API, iUiListener);
        a(activity, intent, (int) Constants.REQUEST_SOCIAL_API);
    }

    private void a(Activity activity, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        StringBuilder stringBuilder = new StringBuilder("-->handleIntentWithH5 action = ");
        stringBuilder.append(str);
        f.c("openSDK_LOG.SocialApiIml", stringBuilder.toString());
        Intent b = b("com.tencent.open.agent.AgentActivity");
        a aVar = new a(this, activity, iUiListener, str, str2, bundle);
        str = b("com.tencent.open.agent.EncryTokenActivity");
        if (str == null || b == null || b.getComponent() == null || str.getComponent() == null || b.getComponent().getPackageName().equals(str.getComponent().getPackageName()) == null) {
            f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--token activity not found");
            bundle = new StringBuilder();
            bundle.append("tencent&sdk&qazxc***14969%%");
            bundle.append(this.b.getAccessToken());
            bundle.append(this.b.getAppId());
            bundle.append(this.b.getOpenId());
            bundle.append("qzone3.4");
            activity = i.f(bundle.toString());
            str = new JSONObject();
            try {
                str.put(SocialConstants.PARAM_ENCRY_EOKEN, activity);
            } catch (Activity activity2) {
                activity2.printStackTrace();
            }
            aVar.onComplete(str);
        } else {
            str.putExtra("oauth_consumer_key", this.b.getAppId());
            str.putExtra("openid", this.b.getOpenId());
            str.putExtra("access_token", this.b.getAccessToken());
            str.putExtra(Constants.KEY_ACTION, SocialConstants.ACTION_CHECK_TOKEN);
            if (a((Intent) str) != null) {
                f.c("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5--found token activity");
                UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_SOCIAL_H5, aVar);
                a(activity2, (Intent) str, (int) Constants.REQUEST_SOCIAL_H5);
            }
        }
    }

    private void a(Context context, String str, Bundle bundle, String str2, IUiListener iUiListener) {
        f.a("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.b.getAppId());
        if (this.b.isSessionValid() != null) {
            bundle.putString("access_token", this.b.getAccessToken());
        }
        context = this.b.getOpenId();
        if (context != null) {
            bundle.putString("openid", context);
        }
        try {
            bundle.putString(Constants.PARAM_PLATFORM_ID, d.a().getSharedPreferences(Constants.PREFERENCE_PF, 0).getString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF));
        } catch (Context context2) {
            context2.printStackTrace();
            bundle.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        context2 = new StringBuilder();
        context2.append(str2);
        context2.append(HttpUtils.encodeUrl(bundle));
        String stringBuilder = context2.toString();
        f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (SocialConstants.ACTION_CHALLENGE.equals(str) == null) {
            if (SocialConstants.ACTION_BRAG.equals(str) == null) {
                new TDialog(this.c, str, stringBuilder, iUiListener, this.b).show();
                return;
            }
        }
        f.b("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
        new c(this.c, str, stringBuilder, iUiListener, this.b).show();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(Context context) {
        String str = "tencent&sdk&qazxc***14969%%";
        String accessToken = this.b.getAccessToken();
        String appId = this.b.getAppId();
        String openId = this.b.getOpenId();
        String str2 = "qzone3.4";
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(accessToken);
            stringBuilder.append(appId);
            stringBuilder.append(openId);
            stringBuilder.append(str2);
            str = i.f(stringBuilder.toString());
        }
        b bVar = new b(context);
        WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        StringBuilder stringBuilder2 = new StringBuilder("<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"");
        stringBuilder2.append(this.b.getOpenId());
        stringBuilder2.append("_");
        stringBuilder2.append(this.b.getAppId());
        stringBuilder2.append("\"]=\"");
        stringBuilder2.append(str);
        stringBuilder2.append("\";</script></head><body></body></html>");
        openId = stringBuilder2.toString();
        String a = com.tencent.open.utils.f.a().a(context, "http://qzs.qq.com");
        bVar.loadDataWithBaseURL(a, openId, "text/html", "utf-8", a);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected android.content.Intent b(java.lang.String r5) {
        /*
        r4 = this;
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "com.qzone";
        r0.setClassName(r1, r5);
        r1 = new android.content.Intent;
        r1.<init>();
        r2 = "com.tencent.mobileqq";
        r1.setClassName(r2, r5);
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "com.tencent.minihd.qq";
        r2.setClassName(r3, r5);
        r5 = com.tencent.open.utils.d.a();
        r5 = com.tencent.open.utils.i.d(r5);
        if (r5 == 0) goto L_0x0033;
    L_0x0028:
        r5 = com.tencent.open.utils.d.a();
        r5 = com.tencent.open.utils.g.a(r5, r2);
        if (r5 == 0) goto L_0x0033;
    L_0x0032:
        return r2;
    L_0x0033:
        r5 = com.tencent.open.utils.d.a();
        r5 = com.tencent.open.utils.g.a(r5, r1);
        if (r5 == 0) goto L_0x004a;
    L_0x003d:
        r5 = com.tencent.open.utils.d.a();
        r2 = "4.7";
        r5 = com.tencent.open.utils.g.c(r5, r2);
        if (r5 < 0) goto L_0x004a;
    L_0x0049:
        return r1;
    L_0x004a:
        r5 = com.tencent.open.utils.d.a();
        r5 = com.tencent.open.utils.g.a(r5, r0);
        r1 = 0;
        if (r5 == 0) goto L_0x007d;
    L_0x0055:
        r5 = com.tencent.open.utils.d.a();
        r2 = "com.qzone";
        r5 = com.tencent.open.utils.g.a(r5, r2);
        r2 = "4.2";
        r5 = com.tencent.open.utils.g.a(r5, r2);
        if (r5 < 0) goto L_0x007d;
    L_0x0067:
        r5 = com.tencent.open.utils.d.a();
        r2 = r0.getComponent();
        r2 = r2.getPackageName();
        r3 = "ec96e9ac1149251acbb1b0c5777cae95";
        r5 = com.tencent.open.utils.g.a(r5, r2, r3);
        if (r5 == 0) goto L_0x007c;
    L_0x007b:
        return r0;
    L_0x007c:
        return r1;
    L_0x007d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.SocialApiIml.b(java.lang.String):android.content.Intent");
    }
}
