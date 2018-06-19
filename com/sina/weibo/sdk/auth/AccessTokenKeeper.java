package com.sina.weibo.sdk.auth;

import android.content.Context;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.net.AsyncWeiboRunner;
import com.sina.weibo.sdk.net.RequestListener;
import com.sina.weibo.sdk.net.WeiboParameters;

public class AccessTokenKeeper {
    private static final String KEY_ACCESS_TOKEN = "access_token";
    private static final String KEY_EXPIRES_IN = "expires_in";
    private static final String KEY_REFRESH_TOKEN = "refresh_token";
    private static final String KEY_UID = "uid";
    private static final String PREFERENCES_NAME = "com_weibo_sdk_android";

    final class AnonymousClass1 implements RequestListener {
        final /* synthetic */ Context val$context;
        final /* synthetic */ RequestListener val$listener;

        AnonymousClass1(Context context, RequestListener requestListener) {
            this.val$context = context;
            this.val$listener = requestListener;
        }

        public final void onComplete(String str) {
            AccessTokenKeeper.writeAccessToken(this.val$context, Oauth2AccessToken.parseAccessToken(str));
            if (this.val$listener != null) {
                this.val$listener.onComplete(str);
            }
        }

        public final void onWeiboException(WeiboException weiboException) {
            if (this.val$listener != null) {
                this.val$listener.onWeiboException(weiboException);
            }
        }
    }

    public static void writeAccessToken(Context context, Oauth2AccessToken oauth2AccessToken) {
        if (context != null) {
            if (oauth2AccessToken != null) {
                context = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
                context.putString("uid", oauth2AccessToken.getUid());
                context.putString("access_token", oauth2AccessToken.getToken());
                context.putString("refresh_token", oauth2AccessToken.getRefreshToken());
                context.putLong("expires_in", oauth2AccessToken.getExpiresTime());
                context.commit();
            }
        }
    }

    public static Oauth2AccessToken readAccessToken(Context context) {
        if (context == null) {
            return null;
        }
        Oauth2AccessToken oauth2AccessToken = new Oauth2AccessToken();
        context = context.getSharedPreferences(PREFERENCES_NAME, 32768);
        oauth2AccessToken.setUid(context.getString("uid", ""));
        oauth2AccessToken.setToken(context.getString("access_token", ""));
        oauth2AccessToken.setRefreshToken(context.getString("refresh_token", ""));
        oauth2AccessToken.setExpiresTime(context.getLong("expires_in", 0));
        return oauth2AccessToken;
    }

    public static void clear(Context context) {
        if (context != null) {
            context = context.getSharedPreferences(PREFERENCES_NAME, 32768).edit();
            context.clear();
            context.commit();
        }
    }

    public static void refreshToken(String str, Context context, RequestListener requestListener) {
        Oauth2AccessToken readAccessToken = readAccessToken(context);
        if (readAccessToken != null) {
            WeiboParameters weiboParameters = new WeiboParameters(str);
            weiboParameters.put("client_id", str);
            weiboParameters.put("grant_type", "refresh_token");
            weiboParameters.put("refresh_token", readAccessToken.getRefreshToken());
            new AsyncWeiboRunner(context).requestAsync("https://api.weibo.com/oauth2/access_token", weiboParameters, "POST", new AnonymousClass1(context, requestListener));
        }
    }
}
