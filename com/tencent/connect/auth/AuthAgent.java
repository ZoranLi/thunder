package com.tencent.connect.auth;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.constants.Constants.KEYS;
import com.sina.weibo.sdk.constant.WBConstants;
import com.tencent.bugly.beta.tinker.TinkerReport;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.BaseApi.TempRequestListener;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.a.f;
import com.tencent.open.b.d;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.e;
import com.tencent.open.utils.g;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.tencent.tinker.android.dx.instruction.Opcodes;
import java.io.IOException;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class AuthAgent extends BaseApi {
    public static final String SECURE_LIB_ARM64_FILE_NAME = "libwbsafeedit_64";
    public static final String SECURE_LIB_ARM_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_FILE_NAME = "libwbsafeedit";
    public static String SECURE_LIB_NAME = null;
    public static final String SECURE_LIB_X86_64_FILE_NAME = "libwbsafeedit_x86_64";
    public static final String SECURE_LIB_X86_FILE_NAME = "libwbsafeedit_x86";
    private IUiListener c;
    private String d;
    private WeakReference<Activity> e;

    /* compiled from: ProGuard */
    private class a implements IUiListener {
        IUiListener a;
        final /* synthetic */ AuthAgent b;

        public a(AuthAgent authAgent, IUiListener iUiListener) {
            this.b = authAgent;
            this.a = iUiListener;
        }

        public void onComplete(Object obj) {
            if (obj == null) {
                f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data is null");
                return;
            }
            JSONObject jSONObject = (JSONObject) obj;
            try {
                int i = jSONObject.getInt(KEYS.RET);
                if (i == 0) {
                    obj = "success";
                } else {
                    obj = jSONObject.getString("msg");
                }
                if (this.a != null) {
                    this.a.onComplete(new JSONObject().put(KEYS.RET, i).put("msg", obj));
                }
            } catch (Object obj2) {
                obj2.printStackTrace();
                f.e("openSDK_LOG.AuthAgent", "CheckLoginListener response data format error");
            }
        }

        public void onError(UiError uiError) {
            if (this.a != null) {
                this.a.onError(uiError);
            }
        }

        public void onCancel() {
            if (this.a != null) {
                this.a.onCancel();
            }
        }
    }

    /* compiled from: ProGuard */
    private class b implements IUiListener {
        IUiListener a;
        final /* synthetic */ AuthAgent b;
        private final String c = "sendinstall";
        private final String d = "installwording";
        private final String e = "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi";

        /* compiled from: ProGuard */
        private abstract class a implements OnClickListener {
            Dialog d;
            final /* synthetic */ b e;

            a(b bVar, Dialog dialog) {
                this.e = bVar;
                this.d = dialog;
            }
        }

        public b(AuthAgent authAgent, IUiListener iUiListener) {
            this.b = authAgent;
            this.a = iUiListener;
        }

        public void onComplete(java.lang.Object r6) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r5 = this;
            if (r6 == 0) goto L_0x0056;
        L_0x0002:
            r0 = r6;
            r0 = (org.json.JSONObject) r0;
            if (r0 == 0) goto L_0x0056;
        L_0x0007:
            r1 = "";
            r2 = 0;
            r3 = "sendinstall";	 Catch:{ JSONException -> 0x001b }
            r3 = r0.getInt(r3);	 Catch:{ JSONException -> 0x001b }
            r4 = 1;	 Catch:{ JSONException -> 0x001b }
            if (r3 != r4) goto L_0x0014;	 Catch:{ JSONException -> 0x001b }
        L_0x0013:
            r2 = r4;	 Catch:{ JSONException -> 0x001b }
        L_0x0014:
            r3 = "installwording";	 Catch:{ JSONException -> 0x001b }
            r0 = r0.getString(r3);	 Catch:{ JSONException -> 0x001b }
            goto L_0x0023;
        L_0x001b:
            r0 = "openSDK_LOG.AuthAgent";
            r3 = "FeedConfirmListener onComplete There is no value for sendinstall.";
            com.tencent.open.a.f.d(r0, r3);
            r0 = r1;
        L_0x0023:
            r0 = java.net.URLDecoder.decode(r0);
            r1 = "openSDK_LOG.AuthAgent";
            r3 = new java.lang.StringBuilder;
            r4 = " WORDING = ";
            r3.<init>(r4);
            r3.append(r0);
            r4 = "xx";
            r3.append(r4);
            r3 = r3.toString();
            com.tencent.open.a.f.a(r1, r3);
            if (r2 == 0) goto L_0x004d;
        L_0x0041:
            r1 = android.text.TextUtils.isEmpty(r0);
            if (r1 != 0) goto L_0x004d;
        L_0x0047:
            r1 = r5.a;
            r5.a(r0, r1, r6);
            return;
        L_0x004d:
            r0 = r5.a;
            if (r0 == 0) goto L_0x0056;
        L_0x0051:
            r0 = r5.a;
            r0.onComplete(r6);
        L_0x0056:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.auth.AuthAgent.b.onComplete(java.lang.Object):void");
        }

        private void a(String str, final IUiListener iUiListener, final Object obj) {
            if (this.b.e != null) {
                Context context = (Activity) this.b.e.get();
                if (context != null) {
                    PackageInfo packageInfo;
                    Dialog dialog = new Dialog(context);
                    dialog.requestWindowFeature(1);
                    PackageManager packageManager = context.getPackageManager();
                    Drawable drawable = null;
                    try {
                        packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                    } catch (NameNotFoundException e) {
                        e.printStackTrace();
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        drawable = packageInfo.applicationInfo.loadIcon(packageManager);
                    }
                    OnClickListener anonymousClass1 = new a(this, dialog) {
                        final /* synthetic */ b c;

                        public void onClick(View view) {
                            this.c.a();
                            if (!(this.d == null || this.d.isShowing() == null)) {
                                this.d.dismiss();
                            }
                            if (iUiListener != null) {
                                iUiListener.onComplete(obj);
                            }
                        }
                    };
                    OnClickListener anonymousClass2 = new a(this, dialog) {
                        final /* synthetic */ b c;

                        public void onClick(View view) {
                            if (!(this.d == null || this.d.isShowing() == null)) {
                                this.d.dismiss();
                            }
                            if (iUiListener != null) {
                                iUiListener.onComplete(obj);
                            }
                        }
                    };
                    Drawable colorDrawable = new ColorDrawable();
                    colorDrawable.setAlpha(0);
                    dialog.getWindow().setBackgroundDrawable(colorDrawable);
                    dialog.setContentView(a(context, drawable, str, anonymousClass1, anonymousClass2));
                    dialog.setOnCancelListener(new OnCancelListener(this) {
                        final /* synthetic */ b c;

                        public void onCancel(DialogInterface dialogInterface) {
                            if (iUiListener != null) {
                                iUiListener.onComplete(obj);
                            }
                        }
                    });
                    if (context != null && context.isFinishing() == null) {
                        dialog.show();
                    }
                }
            }
        }

        private Drawable a(String str, Context context) {
            Drawable ninePatchDrawable;
            try {
                context = context.getApplicationContext().getAssets().open(str);
                if (context == null) {
                    return null;
                }
                if (str.endsWith(".9.png")) {
                    try {
                        str = BitmapFactory.decodeStream(context);
                    } catch (String str2) {
                        str2.printStackTrace();
                        str2 = null;
                    }
                    if (str2 == null) {
                        return null;
                    }
                    context = str2.getNinePatchChunk();
                    NinePatch.isNinePatchChunk(context);
                    ninePatchDrawable = new NinePatchDrawable(str2, context, new Rect(), null);
                } else {
                    str2 = Drawable.createFromStream(context, str2);
                    try {
                        context.close();
                        ninePatchDrawable = str2;
                    } catch (Context context2) {
                        ninePatchDrawable = str2;
                        str2 = context2;
                        str2.printStackTrace();
                        return ninePatchDrawable;
                    }
                }
                return ninePatchDrawable;
            } catch (IOException e) {
                str2 = e;
                ninePatchDrawable = null;
                str2.printStackTrace();
                return ninePatchDrawable;
            }
        }

        private View a(Context context, Drawable drawable, String str, OnClickListener onClickListener, OnClickListener onClickListener2) {
            Context context2 = context;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            float f = displayMetrics.density;
            View relativeLayout = new RelativeLayout(context2);
            View imageView = new ImageView(context2);
            imageView.setImageDrawable(drawable);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setId(1);
            int i = (int) (60.0f * f);
            int i2 = (int) (14.0f * f);
            int i3 = (int) (18.0f * f);
            int i4 = (int) (6.0f * f);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
            layoutParams.addRule(9);
            layoutParams.setMargins(0, i3, i4, i3);
            relativeLayout.addView(imageView, layoutParams);
            imageView = new TextView(context2);
            imageView.setText(str);
            imageView.setTextSize(14.0f);
            imageView.setGravity(3);
            imageView.setIncludeFontPadding(false);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setLines(2);
            imageView.setId(5);
            imageView.setMinWidth((int) (185.0f * f));
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(1, 1);
            layoutParams.addRule(6, 1);
            float f2 = 5.0f * f;
            layoutParams.setMargins(0, 0, (int) f2, 0);
            relativeLayout.addView(imageView, layoutParams);
            imageView = new View(context2);
            imageView.setBackgroundColor(Color.rgb(214, 214, 214));
            imageView.setId(3);
            layoutParams = new RelativeLayout.LayoutParams(-2, 2);
            layoutParams.addRule(3, 1);
            layoutParams.addRule(5, 1);
            layoutParams.addRule(7, 5);
            int i5 = (int) (12.0f * f);
            layoutParams.setMargins(0, 0, 0, i5);
            relativeLayout.addView(imageView, layoutParams);
            imageView = new LinearLayout(context2);
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(5, 1);
            layoutParams.addRule(7, 5);
            layoutParams.addRule(3, 3);
            View button = new Button(context2);
            button.setText("跳过");
            button.setBackgroundDrawable(a("buttonNegt.png", context2));
            button.setTextColor(Color.rgb(36, 97, Opcodes.INT_TO_DOUBLE));
            button.setTextSize(20.0f);
            button.setOnClickListener(onClickListener2);
            button.setId(4);
            i4 = (int) (45.0f * f);
            LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, i4);
            layoutParams2.rightMargin = i2;
            int i6 = (int) (4.0f * f);
            layoutParams2.leftMargin = i6;
            layoutParams2.weight = 1.0f;
            imageView.addView(button, layoutParams2);
            button = new Button(context2);
            button.setText("确定");
            button.setTextSize(20.0f);
            button.setTextColor(Color.rgb(255, 255, 255));
            button.setBackgroundDrawable(a("buttonPost.png", context2));
            button.setOnClickListener(onClickListener);
            LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, i4);
            layoutParams3.weight = 1.0f;
            layoutParams3.rightMargin = i6;
            imageView.addView(button, layoutParams3);
            relativeLayout.addView(imageView, layoutParams);
            LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (279.0f * f), (int) (163.0f * f));
            relativeLayout.setPadding(i2, 0, i5, i5);
            relativeLayout.setLayoutParams(layoutParams4);
            relativeLayout.setBackgroundColor(Color.rgb(247, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 247));
            Drawable paintDrawable = new PaintDrawable(Color.rgb(247, TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION, 247));
            paintDrawable.setCornerRadius(f2);
            relativeLayout.setBackgroundDrawable(paintDrawable);
            return relativeLayout;
        }

        protected void a() {
            Bundle g = this.b.b();
            if (this.b.e != null) {
                Activity activity = (Activity) this.b.e.get();
                if (activity != null) {
                    HttpUtils.requestAsync(this.b.b, activity, "http://appsupport.qq.com/cgi-bin/qzapps/mapp_addapp.cgi", g, "POST", null);
                }
            }
        }

        public void onError(UiError uiError) {
            if (this.a != null) {
                this.a.onError(uiError);
            }
        }

        public void onCancel() {
            if (this.a != null) {
                this.a.onCancel();
            }
        }
    }

    /* compiled from: ProGuard */
    private class c implements IUiListener {
        final /* synthetic */ AuthAgent a;
        private final IUiListener b;
        private final boolean c;
        private final Context d;

        public c(AuthAgent authAgent, Context context, IUiListener iUiListener, boolean z, boolean z2) {
            this.a = authAgent;
            this.d = context;
            this.b = iUiListener;
            this.c = z;
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener()");
        }

        public void onComplete(Object obj) {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete");
            JSONObject jSONObject = (JSONObject) obj;
            try {
                String string = jSONObject.getString("access_token");
                String string2 = jSONObject.getString("expires_in");
                String string3 = jSONObject.getString("openid");
                if (!(string == null || this.a.b == null || string3 == null)) {
                    this.a.b.setAccessToken(string, string2);
                    this.a.b.setOpenId(string3);
                    com.tencent.connect.a.a.d(this.d, this.a.b);
                }
                string = jSONObject.getString(Constants.PARAM_PLATFORM_ID);
                if (string != null) {
                    try {
                        this.d.getSharedPreferences(Constants.PREFERENCE_PF, 0).edit().putString(Constants.PARAM_PLATFORM_ID, string).commit();
                    } catch (Throwable e) {
                        e.printStackTrace();
                        f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e);
                    }
                }
                if (this.c) {
                    CookieSyncManager.getInstance().sync();
                }
            } catch (Throwable e2) {
                e2.printStackTrace();
                f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onComplete error", e2);
            }
            this.b.onComplete(jSONObject);
            this.a.releaseResource();
            f.b();
        }

        public void onError(UiError uiError) {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onError");
            this.b.onError(uiError);
            f.b();
        }

        public void onCancel() {
            f.b("openSDK_LOG.AuthAgent", "OpenUi, TokenListener() onCancel");
            this.b.onCancel();
            f.b();
        }
    }

    static {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(SECURE_LIB_FILE_NAME);
        stringBuilder.append(".so");
        SECURE_LIB_NAME = stringBuilder.toString();
        String str = Build.CPU_ABI;
        if (str == null || str.equals("")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        } else if (str.equalsIgnoreCase("arm64-v8a")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM64_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is arm64-v8a architecture");
        } else if (str.equalsIgnoreCase("x86")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is x86 architecture");
        } else if (str.equalsIgnoreCase("x86_64")) {
            SECURE_LIB_FILE_NAME = SECURE_LIB_X86_64_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is x86_64 architecture");
        } else {
            SECURE_LIB_FILE_NAME = SECURE_LIB_ARM_FILE_NAME;
            stringBuilder = new StringBuilder();
            stringBuilder.append(SECURE_LIB_FILE_NAME);
            stringBuilder.append(".so");
            SECURE_LIB_NAME = stringBuilder.toString();
            f.c("openSDK_LOG.AuthAgent", "is arm(default) architecture");
        }
    }

    public AuthAgent(QQToken qQToken) {
        super(qQToken);
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener) {
        return doLogin(activity, str, iUiListener, false, null);
    }

    public int doLogin(Activity activity, String str, IUiListener iUiListener, boolean z, Fragment fragment) {
        this.d = str;
        this.e = new WeakReference(activity);
        this.c = iUiListener;
        if (e.a((Context) activity, this.b.getAppId()).b("C_LoginWeb") != null || a(activity, fragment, z) == null) {
            d.a().a(this.b.getOpenId(), this.b.getAppId(), "2", "1", "5", "1", "0", "0");
            f.d("openSDK_LOG.AuthAgent", "doLogin startActivity fail show dialog.");
            this.c = new b(this, this.c);
            return a(z, this.c);
        }
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showUi, return Constants.UI_ACTIVITY");
        d.a().a(this.b.getOpenId(), this.b.getAppId(), "2", "1", "5", "0", "0", "0");
        return 1;
    }

    public void releaseResource() {
        this.c = null;
    }

    private int a(boolean z, IUiListener iUiListener) {
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- start");
        CookieSyncManager.createInstance(com.tencent.open.utils.d.a());
        Bundle a = a();
        if (z) {
            a.putString("isadd", "1");
        }
        a.putString("scope", this.d);
        a.putString("client_id", this.b.getAppId());
        if (isOEM) {
            z = Constants.PARAM_PLATFORM_ID;
            StringBuilder stringBuilder = new StringBuilder("desktop_m_qq-");
            stringBuilder.append(installChannel);
            stringBuilder.append("-android-");
            stringBuilder.append(registerChannel);
            stringBuilder.append("-");
            stringBuilder.append(businessId);
            a.putString(z, stringBuilder.toString());
        } else {
            a.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
        }
        z = new StringBuilder();
        z.append(System.currentTimeMillis() / 1000);
        z = z.toString();
        a.putString("sign", g.b(com.tencent.open.utils.d.a(), z));
        a.putString("time", z);
        a.putString("display", "mobile");
        a.putString(WBConstants.AUTH_PARAMS_RESPONSE_TYPE, "token");
        a.putString(WBConstants.AUTH_PARAMS_REDIRECT_URL, "auth://tauth.qq.com/");
        a.putString("cancel_display", "1");
        a.putString("switch", "1");
        a.putString("status_userip", i.a());
        z = new StringBuilder();
        z.append(com.tencent.open.utils.f.a().a(com.tencent.open.utils.d.a(), "https://openmobile.qq.com/oauth2.0/m_authorize?"));
        z.append(HttpUtils.encodeUrl(a));
        z = z.toString();
        final IUiListener cVar = new c(this, com.tencent.open.utils.d.a(), iUiListener, true, false);
        f.b("openSDK_LOG.AuthAgent", "OpenUi, showDialog TDialog");
        h.a(new Runnable(this) {
            final /* synthetic */ AuthAgent c;

            public void run() {
                g.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 3);
                if (this.c.e != null) {
                    final Activity activity = (Activity) this.c.e.get();
                    if (activity != null) {
                        activity.runOnUiThread(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 b;

                            public void run() {
                                a aVar = new a(activity, "action_login", z, cVar, this.b.c.b);
                                if (activity != null && !activity.isFinishing()) {
                                    aVar.show();
                                }
                            }
                        });
                    }
                }
            }
        });
        f.c("openSDK_LOG.AuthAgent", "OpenUi, showDialog -- end");
        return true;
    }

    private boolean a(Activity activity, Fragment fragment, boolean z) {
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- start");
        Intent b = b("com.tencent.open.agent.AgentActivity");
        if (b != null) {
            Bundle a = a();
            if (z) {
                a.putString("isadd", "1");
            }
            a.putString("scope", this.d);
            a.putString("client_id", this.b.getAppId());
            if (isOEM) {
                z = Constants.PARAM_PLATFORM_ID;
                StringBuilder stringBuilder = new StringBuilder("desktop_m_qq-");
                stringBuilder.append(installChannel);
                stringBuilder.append("-android-");
                stringBuilder.append(registerChannel);
                stringBuilder.append("-");
                stringBuilder.append(businessId);
                a.putString(z, stringBuilder.toString());
            } else {
                a.putString(Constants.PARAM_PLATFORM_ID, Constants.DEFAULT_PF);
            }
            a.putString("need_pay", "1");
            a.putString(Constants.KEY_APP_NAME, g.a(com.tencent.open.utils.d.a()));
            b.putExtra(Constants.KEY_ACTION, "action_login");
            b.putExtra(Constants.KEY_PARAMS, a);
            b.putExtra("appid", this.b.getAppId());
            if (a(b)) {
                this.c = new b(this, this.c);
                UIListenerManager.getInstance().setListenerWithRequestcode(11101, this.c);
                if (fragment != null) {
                    f.b("openSDK_LOG.AuthAgent", "startAssitActivity fragment");
                    a(fragment, b, 11101);
                } else {
                    f.b("openSDK_LOG.AuthAgent", "startAssitActivity activity");
                    a(activity, b, 11101);
                }
                f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, found activity for loginIntent");
                d.a().a(0, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "");
                return true;
            }
        }
        d.a().a(1, "LOGIN_CHECK_SDK", Constants.DEFAULT_UIN, this.b.getAppId(), "", Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "startActionActivity fail");
        f.c("openSDK_LOG.AuthAgent", "startActionActivity() -- end, no target activity for loginIntent");
        return null;
    }

    protected void a(IUiListener iUiListener) {
        f.c("openSDK_LOG.AuthAgent", "reportDAU() -- start");
        iUiListener = "tencent&sdk&qazxc***14969%%";
        String str = "qzone3.4";
        Object accessToken = this.b.getAccessToken();
        Object openId = this.b.getOpenId();
        Object appId = this.b.getAppId();
        Object obj = "";
        if (!(TextUtils.isEmpty(accessToken) || TextUtils.isEmpty(openId) || TextUtils.isEmpty(appId))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(iUiListener);
            stringBuilder.append(accessToken);
            stringBuilder.append(appId);
            stringBuilder.append(openId);
            stringBuilder.append(str);
            obj = i.f(stringBuilder.toString());
        }
        if (TextUtils.isEmpty(obj) != null) {
            f.e("openSDK_LOG.AuthAgent", "reportDAU -- encrytoken is null");
            return;
        }
        iUiListener = a();
        iUiListener.putString("encrytoken", obj);
        HttpUtils.requestAsync(this.b, com.tencent.open.utils.d.a(), "https://openmobile.qq.com/user/user_login_statis", iUiListener, "POST", null);
        f.c("openSDK_LOG.AuthAgent", "reportDAU() -- end");
    }

    protected void b(IUiListener iUiListener) {
        Bundle a = a();
        a.putString("reqType", "checkLogin");
        IRequestListener tempRequestListener = new TempRequestListener(this, new a(this, iUiListener));
        HttpUtils.requestAsync(this.b, com.tencent.open.utils.d.a(), "https://openmobile.qq.com/v3/user/get_info", a, "GET", tempRequestListener);
    }
}
