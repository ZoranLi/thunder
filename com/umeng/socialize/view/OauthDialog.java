package com.umeng.socialize.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.umeng.socialize.Config;
import com.umeng.socialize.SocializeException;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.UmengErrorCode;
import com.umeng.socialize.net.utils.AesHelper;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.DeviceConfig;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.URLBuilder;
import com.umeng.socialize.utils.UmengText;
import com.xiaomi.account.openauth.XiaomiOAuthConstants;
import java.lang.ref.WeakReference;

public class OauthDialog extends BaseDialog {
    private static final String BASE_URL = "https://log.umsns.com/";
    private static final String TAG = "OauthDialog";
    private static String mRedirectUri = "error";
    private a mListener;

    static class a {
        private UMAuthListener a = null;
        private SHARE_MEDIA b;
        private int c;

        public a(UMAuthListener uMAuthListener, SHARE_MEDIA share_media) {
            this.a = uMAuthListener;
            this.b = share_media;
        }

        public void a(Exception exception) {
            if (this.a != null) {
                this.a.onError(this.b, this.c, exception);
            }
        }

        public void a(Bundle bundle) {
            if (this.a != null) {
                this.a.onComplete(this.b, this.c, SocializeUtils.bundleTomap(bundle));
            }
        }

        public void onCancel() {
            if (this.a != null) {
                this.a.onCancel(this.b, this.c);
            }
        }
    }

    private static class b extends WebChromeClient {
        private WeakReference<OauthDialog> a;

        private b(OauthDialog oauthDialog) {
            this.a = new WeakReference(oauthDialog);
        }

        public void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
            webView = this.a == null ? null : (OauthDialog) this.a.get();
            if (webView != null) {
                if (i < 90) {
                    webView.mProgressbar.setVisibility(0);
                    return;
                }
                webView.mHandler.sendEmptyMessage(1);
            }
        }
    }

    private static class c extends WebViewClient {
        private WeakReference<OauthDialog> a;

        private c(OauthDialog oauthDialog) {
            this.a = new WeakReference(oauthDialog);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            OauthDialog oauthDialog = this.a == null ? null : (OauthDialog) this.a.get();
            if (oauthDialog != null) {
                Context applicationContext = oauthDialog.mContext.getApplicationContext();
                if (DeviceConfig.isNetworkAvailable(applicationContext)) {
                    if (str.contains("?ud_get=")) {
                        str = oauthDialog.decrypt(str);
                    }
                    if (str.contains(oauthDialog.mWaitUrl)) {
                        a(str);
                    }
                } else {
                    Toast.makeText(applicationContext, UmengText.NET_INAVALIBLE, null).show();
                    return true;
                }
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            String str3 = OauthDialog.TAG;
            StringBuilder stringBuilder = new StringBuilder("onReceivedError: ");
            stringBuilder.append(str2);
            stringBuilder.append("\nerrCode: ");
            stringBuilder.append(i);
            stringBuilder.append(" description:");
            stringBuilder.append(str);
            Log.e(str3, stringBuilder.toString());
            Dialog dialog = this.a == null ? null : (OauthDialog) this.a.get();
            if (dialog != null) {
                View view = dialog.mProgressbar;
                if (view.getVisibility() == 0) {
                    view.setVisibility(8);
                }
            }
            super.onReceivedError(webView, i, str, str2);
            if (dialog != null) {
                SocializeUtils.safeCloseDialog(dialog);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            OauthDialog oauthDialog = this.a == null ? null : (OauthDialog) this.a.get();
            if (oauthDialog != null) {
                String str2 = "";
                if (str.contains("?ud_get=")) {
                    str2 = oauthDialog.decrypt(str);
                }
                if (str2.contains("access_key") && str2.contains("access_secret")) {
                    if (str.contains(oauthDialog.mWaitUrl) != null) {
                        a(str);
                    }
                    return;
                } else if (str.startsWith(OauthDialog.mRedirectUri)) {
                    b(str);
                }
            }
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            OauthDialog oauthDialog = this.a == null ? null : (OauthDialog) this.a.get();
            if (oauthDialog != null) {
                oauthDialog.mHandler.sendEmptyMessage(1);
                super.onPageFinished(webView, str);
                if (oauthDialog.mFlag == null && str.contains(oauthDialog.mWaitUrl) != null) {
                    a(str);
                }
            }
        }

        private void a(String str) {
            Dialog dialog = this.a == null ? null : (OauthDialog) this.a.get();
            if (dialog != null) {
                dialog.mFlag = 1;
                dialog.mValues = SocializeUtils.parseUrl(str);
                if (dialog.isShowing() != null) {
                    SocializeUtils.safeCloseDialog(dialog);
                }
            }
        }

        private void b(String str) {
            String str2 = OauthDialog.TAG;
            StringBuilder stringBuilder = new StringBuilder(OauthDialog.TAG);
            stringBuilder.append(str);
            Log.d(str2, stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder("gggggg url=");
            stringBuilder2.append(str);
            Log.e(stringBuilder2.toString());
            Dialog dialog = this.a == null ? null : (OauthDialog) this.a.get();
            if (dialog != null) {
                dialog.mFlag = 1;
                dialog.mValues = SocializeNetUtils.parseUrl(str);
                if (dialog.isShowing() != null) {
                    SocializeUtils.safeCloseDialog(dialog);
                }
            }
        }
    }

    public void setmRedirectUri(String str) {
        mRedirectUri = str;
    }

    public OauthDialog(Activity activity, SHARE_MEDIA share_media, UMAuthListener uMAuthListener) {
        super(activity, share_media);
        this.mListener = new a(uMAuthListener, share_media);
        initViews();
    }

    private String getUrl(SHARE_MEDIA share_media) {
        URLBuilder uRLBuilder = new URLBuilder(this.mContext);
        uRLBuilder.setHost(BASE_URL).setPath("share/auth/").setAppkey(SocializeUtils.getAppkey(this.mContext)).setEntityKey(Config.EntityKey).withMedia(share_media).withOpId("10").withSessionId(Config.SessionId).withUID(Config.UID);
        return uRLBuilder.toEncript();
    }

    public void setClient(WebView webView) {
        webView.setWebViewClient(getAdapterWebViewClient());
        this.mWebView.setWebChromeClient(new b());
    }

    private WebViewClient getAdapterWebViewClient() {
        return new c();
    }

    private String decrypt(String str) {
        try {
            String[] split = str.split("ud_get=");
            split[1] = AesHelper.decryptNoPadding(split[1], "UTF-8").trim();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(split[0]);
            stringBuilder.append(split[1]);
            return stringBuilder.toString();
        } catch (Exception e) {
            Log.um(UmengText.DECRPT_ERROR);
            e.printStackTrace();
            return str;
        }
    }

    public void show() {
        super.show();
        this.mValues = null;
        if (this.mPlatform == SHARE_MEDIA.SINA) {
            this.mWebView.loadUrl(this.mWaitUrl);
            return;
        }
        this.mWebView.loadUrl(getUrl(this.mPlatform));
    }

    public void dismiss() {
        if (this.mValues != null) {
            CharSequence string = this.mValues.getString("uid");
            String string2 = this.mValues.getString("error_code");
            Object string3 = this.mValues.getString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2);
            a aVar;
            if (this.mPlatform == SHARE_MEDIA.SINA && !TextUtils.isEmpty(string3)) {
                aVar = this.mListener;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(UmengErrorCode.AuthorizeFailed.getMessage());
                stringBuilder.append("errorcode:");
                stringBuilder.append(string2);
                stringBuilder.append(" message:");
                stringBuilder.append(string3);
                aVar.a(new SocializeException(stringBuilder.toString()));
            } else if (TextUtils.isEmpty(string)) {
                aVar = this.mListener;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(UmengErrorCode.AuthorizeFailed.getMessage());
                stringBuilder2.append("unfetch usid...");
                aVar.a(new SocializeException(stringBuilder2.toString()));
            } else {
                Log.d(TAG, "### dismiss ");
                this.mValues.putString("accessToken", this.mValues.getString("access_key"));
                this.mValues.putString("expiration", this.mValues.getString("expires_in"));
                this.mListener.a(this.mValues);
            }
        } else {
            this.mListener.onCancel();
        }
        super.dismiss();
        releaseWebView();
    }
}
