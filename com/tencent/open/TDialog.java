package com.tencent.open;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.qq.e.comm.constants.Constants.KEYS;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.open.c.b;
import com.tencent.open.utils.i;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class TDialog extends b {
    static final LayoutParams c = new LayoutParams(-1, -1);
    static Toast d;
    private static WeakReference<ProgressDialog> f;
    private WeakReference<Context> e;
    private String g;
    private OnTimeListener h;
    private IUiListener i;
    private FrameLayout j;
    private b k;
    private Handler l;
    private boolean m = false;
    private QQToken n = null;

    /* compiled from: ProGuard */
    private class FbWebViewClient extends WebViewClient {
        final /* synthetic */ TDialog a;

        private FbWebViewClient(TDialog tDialog) {
            this.a = tDialog;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            StringBuilder stringBuilder = new StringBuilder("Redirect URL: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.TDialog", stringBuilder.toString());
            if (str.startsWith(com.tencent.open.utils.f.a().a((Context) this.a.e.get(), "auth://tauth.qq.com/")) != null) {
                this.a.h.onComplete(i.c(str));
                if (this.a.isShowing() != null) {
                    this.a.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CANCEL_URI) != null) {
                this.a.h.onCancel();
                if (this.a.isShowing() != null) {
                    this.a.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.CLOSE_URI) != null) {
                if (this.a.isShowing() != null) {
                    this.a.dismiss();
                }
                return true;
            } else if (str.startsWith(Constants.DOWNLOAD_URI) != null) {
                try {
                    str = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(str.substring(11))));
                    str.addFlags(268435456);
                    if (!(this.a.e == null || this.a.e.get() == null)) {
                        ((Context) this.a.e.get()).startActivity(str);
                    }
                } catch (WebView webView2) {
                    webView2.printStackTrace();
                }
                return true;
            } else if (str.startsWith("auth://progress") != null) {
                return true;
            } else {
                return null;
            }
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            this.a.h.onError(new UiError(i, str, str2));
            if (!(this.a.e == null || this.a.e.get() == null)) {
                Toast.makeText((Context) this.a.e.get(), "网络连接异常或系统错误", null).show();
            }
            this.a.dismiss();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            StringBuilder stringBuilder = new StringBuilder("Webview loading URL: ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.TDialog", stringBuilder.toString());
            super.onPageStarted(webView, str, bitmap);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.a.k.setVisibility(null);
        }
    }

    /* compiled from: ProGuard */
    private class THandler extends Handler {
        final /* synthetic */ TDialog a;
        private OnTimeListener b;

        public THandler(TDialog tDialog, OnTimeListener onTimeListener, Looper looper) {
            this.a = tDialog;
            super(looper);
            this.b = onTimeListener;
        }

        public void handleMessage(Message message) {
            StringBuilder stringBuilder = new StringBuilder("--handleMessage--msg.WHAT = ");
            stringBuilder.append(message.what);
            f.b("openSDK_LOG.TDialog", stringBuilder.toString());
            switch (message.what) {
                case 1:
                    this.b.a((String) message.obj);
                    return;
                case 2:
                    this.b.onCancel();
                    return;
                case 3:
                    if (!(this.a.e == null || this.a.e.get() == null)) {
                        TDialog.c((Context) this.a.e.get(), (String) message.obj);
                        return;
                    }
                case 4:
                    return;
                case 5:
                    if (!(this.a.e == null || this.a.e.get() == null)) {
                        TDialog.d((Context) this.a.e.get(), (String) message.obj);
                        break;
                    }
                default:
                    break;
            }
        }
    }

    /* compiled from: ProGuard */
    private class JsListener extends a.b {
        final /* synthetic */ TDialog a;

        private JsListener(TDialog tDialog) {
            this.a = tDialog;
        }

        public void onAddShare(String str) {
            f.b("openSDK_LOG.TDialog", "JsListener onAddShare");
            onComplete(str);
        }

        public void onInvite(String str) {
            onComplete(str);
        }

        public void onCancelAddShare(String str) {
            StringBuilder stringBuilder = new StringBuilder("JsListener onCancelAddShare");
            stringBuilder.append(str);
            f.e("openSDK_LOG.TDialog", stringBuilder.toString());
            onCancel("cancel");
        }

        public void onCancelLogin() {
            onCancel("");
        }

        public void onCancelInvite() {
            f.e("openSDK_LOG.TDialog", "JsListener onCancelInvite");
            onCancel("");
        }

        public void onComplete(String str) {
            this.a.l.obtainMessage(1, str).sendToTarget();
            StringBuilder stringBuilder = new StringBuilder("JsListener onComplete");
            stringBuilder.append(str);
            f.e("openSDK_LOG.TDialog", stringBuilder.toString());
            this.a.dismiss();
        }

        public void onCancel(String str) {
            StringBuilder stringBuilder = new StringBuilder("JsListener onCancel --msg = ");
            stringBuilder.append(str);
            f.e("openSDK_LOG.TDialog", stringBuilder.toString());
            this.a.l.obtainMessage(2, str).sendToTarget();
            this.a.dismiss();
        }

        public void showMsg(String str) {
            this.a.l.obtainMessage(3, str).sendToTarget();
        }

        public void onLoad(String str) {
            this.a.l.obtainMessage(4, str).sendToTarget();
        }
    }

    /* compiled from: ProGuard */
    private static class OnTimeListener implements IUiListener {
        String a;
        String b;
        private WeakReference<Context> c;
        private String d;
        private IUiListener e;

        public OnTimeListener(Context context, String str, String str2, String str3, IUiListener iUiListener) {
            this.c = new WeakReference(context);
            this.d = str;
            this.a = str2;
            this.b = str3;
            this.e = iUiListener;
        }

        private void a(String str) {
            try {
                onComplete(i.d(str));
            } catch (JSONException e) {
                e.printStackTrace();
                onError(new UiError(-4, Constants.MSG_JSON_ERROR, str));
            }
        }

        public void onComplete(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            g a = g.a();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            stringBuilder.append("_H5");
            a.a(stringBuilder.toString(), SystemClock.elapsedRealtime(), 0, 0, jSONObject.optInt(KEYS.RET, -6), this.a, false);
            if (this.e != null) {
                this.e.onComplete(jSONObject);
                this.e = null;
            }
        }

        public void onError(UiError uiError) {
            StringBuilder stringBuilder;
            String stringBuilder2;
            if (uiError.errorMessage != null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(uiError.errorMessage);
                stringBuilder.append(this.a);
                stringBuilder2 = stringBuilder.toString();
            } else {
                stringBuilder2 = this.a;
            }
            String str = stringBuilder2;
            g a = g.a();
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            stringBuilder.append("_H5");
            a.a(stringBuilder.toString(), SystemClock.elapsedRealtime(), 0, 0, uiError.errorCode, str, false);
            if (this.e != null) {
                this.e.onError(uiError);
                this.e = null;
            }
        }

        public void onCancel() {
            if (this.e != null) {
                this.e.onCancel();
                this.e = null;
            }
        }
    }

    public TDialog(Context context, String str, String str2, IUiListener iUiListener, QQToken qQToken) {
        super(context, 16973840);
        this.e = new WeakReference(context);
        this.g = str2;
        this.h = new OnTimeListener(context, str, str2, qQToken.getAppId(), iUiListener);
        this.l = new THandler(this, this.h, context.getMainLooper());
        this.i = iUiListener;
        this.n = qQToken;
    }

    protected void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        a();
        b();
    }

    public void onBackPressed() {
        if (this.h != null) {
            this.h.onCancel();
        }
        super.onBackPressed();
    }

    private void a() {
        new TextView((Context) this.e.get()).setText("test");
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -1);
        this.k = new b((Context) this.e.get());
        this.k.setLayoutParams(layoutParams);
        this.j = new FrameLayout((Context) this.e.get());
        layoutParams.gravity = 17;
        this.j.setLayoutParams(layoutParams);
        this.j.addView(this.k);
        setContentView(this.j);
    }

    protected void a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = "openSDK_LOG.TDialog";
        r1 = "--onConsoleMessage--";
        com.tencent.open.a.f.b(r0, r1);
        r0 = r2.a;	 Catch:{ Exception -> 0x000f }
        r1 = r2.k;	 Catch:{ Exception -> 0x000f }
        r0.a(r1, r3);	 Catch:{ Exception -> 0x000f }
        return;
    L_0x000f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.TDialog.a(java.lang.String):void");
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void b() {
        this.k.setVerticalScrollBarEnabled(false);
        this.k.setHorizontalScrollBarEnabled(false);
        this.k.setWebViewClient(new FbWebViewClient());
        this.k.setWebChromeClient(this.b);
        this.k.clearFormData();
        WebSettings settings = this.k.getSettings();
        if (settings != null) {
            settings.setSavePassword(false);
            settings.setSaveFormData(false);
            settings.setCacheMode(-1);
            settings.setNeedInitialFocus(false);
            settings.setBuiltInZoomControls(true);
            settings.setSupportZoom(true);
            settings.setRenderPriority(RenderPriority.HIGH);
            settings.setJavaScriptEnabled(true);
            if (!(this.e == null || this.e.get() == null)) {
                settings.setDatabaseEnabled(true);
                settings.setDatabasePath(((Context) this.e.get()).getApplicationContext().getDir("databases", 0).getPath());
            }
            settings.setDomStorageEnabled(true);
            this.a.a(new JsListener(), "sdk_js_if");
            this.k.loadUrl(this.g);
            this.k.setLayoutParams(c);
            this.k.setVisibility(4);
            this.k.getSettings().setSavePassword(false);
        }
    }

    private static void c(Context context, String str) {
        try {
            str = i.d(str);
            int i = str.getInt("type");
            str = str.getString("msg");
            if (i == 0) {
                if (d == null) {
                    d = Toast.makeText(context, str, 0);
                } else {
                    d.setView(d.getView());
                    d.setText(str);
                    d.setDuration(0);
                }
                d.show();
                return;
            }
            if (i == 1) {
                if (d == null) {
                    d = Toast.makeText(context, str, 1);
                } else {
                    d.setView(d.getView());
                    d.setText(str);
                    d.setDuration(1);
                }
                d.show();
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    private static void d(Context context, String str) {
        if (context != null) {
            if (str != null) {
                try {
                    str = i.d(str);
                    int i = str.getInt("action");
                    str = str.getString("msg");
                    if (i == 1) {
                        if (f != null) {
                            if (f.get() != null) {
                                ((ProgressDialog) f.get()).setMessage(str);
                                if (((ProgressDialog) f.get()).isShowing() == null) {
                                    ((ProgressDialog) f.get()).show();
                                    return;
                                }
                            }
                        }
                        ProgressDialog progressDialog = new ProgressDialog(context);
                        progressDialog.setMessage(str);
                        f = new WeakReference(progressDialog);
                        progressDialog.show();
                    } else if (!(i != 0 || f == null || f.get() == null || ((ProgressDialog) f.get()).isShowing() == null)) {
                        ((ProgressDialog) f.get()).dismiss();
                        f = null;
                    }
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        }
    }
}
