package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.account.IXiaomiAuthResponse;
import com.xiaomi.account.IXiaomiAuthResponse.Stub;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import miui.net.IXiaomiAuthService;

public class XiaomiOAuthorize {
    private static final String ACCOUNT_TYPE = "com.xiaomi";
    private static final String TAG = "XiaomiOAuthorize";
    private static final String TYPE_CODE = "code";
    private static final String TYPE_TOKEN = "token";
    private Long mAppId = null;
    private boolean mKeepCookies = false;
    private boolean mNotUseMiui = false;
    private String mRedirectUrl = null;
    private int[] mScopes = null;
    private Boolean mSkipConfirm = null;
    private String mState = null;

    final class AnonymousClass7 extends AsyncTask<Void, Void, XiaomiOAuthResults> {
        Exception e;
        final /* synthetic */ Activity val$activity;
        final /* synthetic */ int val$requestCode;
        final /* synthetic */ String val$typeCode;
        final /* synthetic */ XiaomiOAuthFuture val$y;

        AnonymousClass7(XiaomiOAuthFuture xiaomiOAuthFuture, String str, Activity activity, int i) {
            this.val$y = xiaomiOAuthFuture;
            this.val$typeCode = str;
            this.val$activity = activity;
            this.val$requestCode = i;
        }

        protected final XiaomiOAuthResults doInBackground(Void... voidArr) {
            try {
                return (XiaomiOAuthResults) this.val$y.getResult();
            } catch (Void[] voidArr2) {
                voidArr2.printStackTrace();
                return null;
            } catch (Void[] voidArr22) {
                this.e = voidArr22;
                return null;
            } catch (Void[] voidArr222) {
                this.e = voidArr222;
                return null;
            }
        }

        protected final void onPostExecute(XiaomiOAuthResults xiaomiOAuthResults) {
            int i;
            Bundle bundle = new Bundle();
            if (xiaomiOAuthResults != null) {
                int i2;
                if (xiaomiOAuthResults.hasError()) {
                    i2 = AuthorizeActivity.RESULT_FAIL;
                    bundle.putInt("error", xiaomiOAuthResults.getErrorCode());
                    bundle.putString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2, xiaomiOAuthResults.getErrorMessage());
                } else {
                    i2 = AuthorizeActivity.RESULT_SUCCESS;
                    if ("code".equalsIgnoreCase(this.val$typeCode)) {
                        bundle.putString("code", xiaomiOAuthResults.getCode());
                        bundle.putString(XiaomiOAuthConstants.EXTRA_STATE_2, xiaomiOAuthResults.getState());
                        bundle.putString(XiaomiOAuthConstants.EXTRA_TOKEN_TYPE_2, xiaomiOAuthResults.getTokenType());
                        bundle.putString(XiaomiOAuthConstants.EXTRA_MAC_KEY_2, xiaomiOAuthResults.getMacKey());
                        bundle.putString(XiaomiOAuthConstants.EXTRA_MAC_ALGORITHM_2, xiaomiOAuthResults.getMacAlgorithm());
                    } else {
                        bundle.putString("access_token", xiaomiOAuthResults.getAccessToken());
                        bundle.putString("expires_in", xiaomiOAuthResults.getExpiresIn());
                        bundle.putString("scope", xiaomiOAuthResults.getScopes());
                        bundle.putString(XiaomiOAuthConstants.EXTRA_STATE_2, xiaomiOAuthResults.getState());
                        bundle.putString(XiaomiOAuthConstants.EXTRA_TOKEN_TYPE_2, xiaomiOAuthResults.getTokenType());
                        bundle.putString(XiaomiOAuthConstants.EXTRA_MAC_KEY_2, xiaomiOAuthResults.getMacKey());
                        bundle.putString(XiaomiOAuthConstants.EXTRA_MAC_ALGORITHM_2, xiaomiOAuthResults.getMacAlgorithm());
                    }
                }
                i = i2;
            } else if (this.e == null) {
                i = AuthorizeActivity.RESULT_CANCEL;
                bundle.putInt("error", AuthorizeActivity.RESULT_CANCEL);
                bundle.putString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2, "canceled");
            } else {
                i = AuthorizeActivity.RESULT_FAIL;
                bundle.putInt("error", AuthorizeActivity.RESULT_FAIL);
                bundle.putString(XiaomiOAuthConstants.EXTRA_ERROR_DESCRIPTION_2, this.e.getMessage());
            }
            this.val$activity.startActivityForResult(AuthorizeActivity.asMiddleActivity(this.val$activity, i, bundle), this.val$requestCode);
        }
    }

    private enum OAuthStage {
        INIT,
        ADD_SYSTEM_ACCOUNT,
        OAUTH_FROM_MIUI,
        OAUTH_FROM_MIUI_WITH_RESPONSE,
        OAUTH_FROM_3RD_PARTY
    }

    private static class XiaomiTokenFuture extends FutureTask<Bundle> {
        private final Activity mActivity;
        private final XiaomiOAuthFutureImpl<XiaomiOAuthResults> mRealFuture;

        public XiaomiTokenFuture(Activity activity, XiaomiOAuthFutureImpl<XiaomiOAuthResults> xiaomiOAuthFutureImpl) {
            super(new Callable<Bundle>() {
                public Bundle call() throws Exception {
                    throw new IllegalStateException("this should never be called");
                }
            });
            this.mActivity = activity;
            this.mRealFuture = xiaomiOAuthFutureImpl;
        }

        public Bundle get(long j, TimeUnit timeUnit) {
            throw new IllegalStateException("this should never be called");
        }

        public Bundle get() {
            throw new IllegalStateException("this should never be called");
        }

        public void set(Bundle bundle) {
            if (bundle == null || !bundle.containsKey("extra_intent")) {
                this.mRealFuture.set(XiaomiOAuthResults.parseBundle(bundle));
                return;
            }
            handleIntentResult((Intent) bundle.getParcelable("extra_intent"));
        }

        public boolean handleIntentResult(Intent intent) {
            if (intent == null) {
                return null;
            }
            Bundle extras = intent.getExtras();
            extras.setClassLoader(getClass().getClassLoader());
            if (!extras.containsKey(XiaomiOAuthConstants.EXTRA_RESPONSE)) {
                intent = AuthorizeActivity.asMiddleActivity(this.mActivity, intent, wrapWithinResponse());
            }
            this.mActivity.startActivity(intent);
            return true;
        }

        private IXiaomiAuthResponse wrapWithinResponse() {
            return new Stub() {
                public void onResult(Bundle bundle) throws RemoteException {
                    XiaomiTokenFuture.this.set(bundle);
                }

                public void onCancel() throws RemoteException {
                    XiaomiTokenFuture.this.setException(new OperationCanceledException());
                }
            };
        }

        protected void setException(Throwable th) {
            this.mRealFuture.setException(th);
        }
    }

    final class AnonymousClass3 extends MiuiAuthServiceRunnable<Bundle> {
        final /* synthetic */ IXiaomiAuthResponse val$resp;

        AnonymousClass3(Context context, Account account, Bundle bundle, IXiaomiAuthResponse iXiaomiAuthResponse) {
            this.val$resp = iXiaomiAuthResponse;
            super(context, account, bundle);
        }

        protected final Bundle talkWithMiuiV5(IXiaomiAuthService iXiaomiAuthService) throws RemoteException {
            throw new IllegalStateException("should not be here");
        }

        protected final Bundle talkWithMiuiV6(com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService) throws RemoteException {
            iXiaomiAuthService.getAccessTokenInResponse(this.val$resp, this.options, 1, 0);
            return null;
        }
    }

    final class AnonymousClass4 extends MiuiAuthServiceRunnable<Bundle> {
        AnonymousClass4(Context context, Account account, Bundle bundle) {
            super(context, account, bundle);
        }

        protected final Bundle talkWithMiuiV5(IXiaomiAuthService iXiaomiAuthService) throws RemoteException {
            iXiaomiAuthService.invalidateAccessToken(this.account, this.options);
            return iXiaomiAuthService.getMiCloudAccessToken(this.account, this.options);
        }

        protected final Bundle talkWithMiuiV6(com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService) throws RemoteException {
            return iXiaomiAuthService.getMiCloudAccessToken(this.account, this.options);
        }
    }

    final class AnonymousClass5 extends MiuiAuthServiceRunnable<Boolean> {
        AnonymousClass5(Context context, Account account, Bundle bundle) {
            super(context, account, bundle);
        }

        protected final Boolean talkWithMiuiV5(IXiaomiAuthService iXiaomiAuthService) throws RemoteException {
            return Boolean.valueOf(true);
        }

        protected final Boolean talkWithMiuiV6(com.xiaomi.account.IXiaomiAuthService iXiaomiAuthService) throws RemoteException {
            return Boolean.valueOf(true);
        }
    }

    public XiaomiOAuthorize setScope(int[] iArr) {
        this.mScopes = iArr;
        return this;
    }

    public XiaomiOAuthorize setAppId(long j) {
        this.mAppId = Long.valueOf(j);
        return this;
    }

    public XiaomiOAuthorize setRedirectUrl(String str) {
        this.mRedirectUrl = str;
        return this;
    }

    public XiaomiOAuthorize setSkipConfirm(boolean z) {
        this.mSkipConfirm = Boolean.valueOf(z);
        return this;
    }

    public XiaomiOAuthorize setNoMiui(boolean z) {
        this.mNotUseMiui = z;
        return this;
    }

    public XiaomiOAuthorize setState(String str) {
        this.mState = str;
        return this;
    }

    public XiaomiOAuthorize setKeepCookies(boolean z) {
        this.mKeepCookies = z;
        return this;
    }

    public XiaomiOAuthFuture<XiaomiOAuthResults> startGetAccessToken(Activity activity) {
        return oauth(activity, "token");
    }

    public XiaomiOAuthFuture<XiaomiOAuthResults> startGetOAuthCode(Activity activity) {
        return oauth(activity, "code");
    }

    public XiaomiOAuthFuture<String> callOpenApi(Context context, long j, String str, String str2, String str3, String str4) {
        final Context context2 = context;
        final String str5 = str;
        final long j2 = j;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        return new XiaomiOAuthRunnable<String>() {
            public void doRun() {
                try {
                    this.mFuture.set(AuthorizeApi.doHttpGet(context2, str5, j2, str6, str7, str8));
                } catch (Throwable e) {
                    this.mFuture.setException(e);
                }
            }
        }.start();
    }

    private XiaomiOAuthFutureImpl<XiaomiOAuthResults> oauth(final Activity activity, final String str) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                if (this.mAppId != null) {
                    if (this.mAppId.longValue() > 0) {
                        if (TextUtils.isEmpty(this.mRedirectUrl)) {
                            throw new IllegalArgumentException("redirect url is empty!!!");
                        } else if (!TextUtils.isEmpty(str)) {
                            return new XiaomiOAuthRunnable<XiaomiOAuthResults>() {
                                public void doRun() {
                                    try {
                                        run(new XiaomiTokenFuture(activity, this.mFuture));
                                    } catch (ExecutionException e) {
                                        this.mFuture.setException(e.getCause());
                                    } catch (Throwable e2) {
                                        this.mFuture.setException(e2);
                                    } catch (Throwable e22) {
                                        this.mFuture.setException(e22);
                                    } catch (Throwable e222) {
                                        this.mFuture.setException(e222);
                                    }
                                }

                                private void run(com.xiaomi.account.openauth.XiaomiOAuthorize.XiaomiTokenFuture r12) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.io.IOException, android.accounts.OperationCanceledException {
                                    /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
                                    /*
                                    r11 = this;
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.OAuthStage.INIT;
                                L_0x0002:
                                    r1 = com.xiaomi.account.openauth.XiaomiOAuthorize.AnonymousClass8.$SwitchMap$com$xiaomi$account$openauth$XiaomiOAuthorize$OAuthStage;
                                    r2 = r0.ordinal();
                                    r1 = r1[r2];
                                    switch(r1) {
                                        case 1: goto L_0x00a8;
                                        case 2: goto L_0x006e;
                                        case 3: goto L_0x0058;
                                        case 4: goto L_0x004a;
                                        case 5: goto L_0x000e;
                                        default: goto L_0x000d;
                                    };
                                L_0x000d:
                                    goto L_0x0002;
                                L_0x000e:
                                    r2 = r6;
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r0 = r0.mAppId;
                                    r3 = java.lang.String.valueOf(r0);
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r4 = r0.mRedirectUrl;
                                    r5 = r7;
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r0 = r0.mScopes;
                                    r6 = com.xiaomi.account.openauth.XiaomiOAuthorize.makeScopeString(r0);
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r7 = r0.mState;
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r8 = r0.mSkipConfirm;
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r9 = r0.mKeepCookies;
                                    r10 = r12.wrapWithinResponse();
                                    r0 = com.xiaomi.account.openauth.AuthorizeActivity.getIntent(r2, r3, r4, r5, r6, r7, r8, r9, r10);
                                    r12.handleIntentResult(r0);
                                    return;
                                L_0x004a:
                                    r0 = r6;
                                    r1 = r11.makeOptions();
                                    r12 = r12.wrapWithinResponse();
                                    com.xiaomi.account.openauth.XiaomiOAuthorize.getAccessTokenFromMiuiInResponseWay(r0, r1, r12);
                                    return;
                                L_0x0058:
                                    r0 = r6;
                                    r1 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r2 = r6;
                                    r1 = r1.getXiaomiAccount(r2);
                                    r2 = r11.makeOptions();
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.getAccessTokenFromMiui(r0, r1, r2);
                                    r12.set(r0);
                                    return;
                                L_0x006e:
                                    r0 = r6;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r1 = android.accounts.AccountManager.get(r0);	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r2 = "com.xiaomi";	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r3 = 0;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r4 = 0;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r5 = 0;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r6 = r6;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r7 = 0;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r8 = 0;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r0 = r1.addAccount(r2, r3, r4, r5, r6, r7, r8);	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r0 = r0.getResult();	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r0 = (android.os.Bundle) r0;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    if (r0 == 0) goto L_0x0095;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                L_0x0089:
                                    r1 = "authAccount";	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r0 = r0.containsKey(r1);	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    if (r0 == 0) goto L_0x0095;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                L_0x0091:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.OAuthStage.OAUTH_FROM_MIUI;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    goto L_0x0002;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                L_0x0095:
                                    r0 = new java.lang.Exception;	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r1 = "fail to add account";	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r0.<init>(r1);	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    r12.setException(r0);	 Catch:{ SecurityException -> 0x00a4, AuthenticatorException -> 0x00a0 }
                                    return;
                                L_0x00a0:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.OAuthStage.OAUTH_FROM_3RD_PARTY;
                                    goto L_0x0002;
                                L_0x00a4:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.OAuthStage.OAUTH_FROM_3RD_PARTY;
                                    goto L_0x0002;
                                L_0x00a8:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r0 = r0.mNotUseMiui;
                                    if (r0 != 0) goto L_0x00d9;
                                L_0x00b0:
                                    r0 = r6;
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.isMiui(r0);
                                    if (r0 != 0) goto L_0x00b9;
                                L_0x00b8:
                                    goto L_0x00d9;
                                L_0x00b9:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r1 = r6;
                                    r0 = r0.supportResponseWayWithMiui(r1);
                                    if (r0 == 0) goto L_0x00c7;
                                L_0x00c3:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.OAuthStage.OAUTH_FROM_MIUI_WITH_RESPONSE;
                                    goto L_0x0002;
                                L_0x00c7:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.this;
                                    r1 = r6;
                                    r0 = r0.getXiaomiAccount(r1);
                                    if (r0 == 0) goto L_0x00d5;
                                L_0x00d1:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.OAuthStage.OAUTH_FROM_MIUI;
                                    goto L_0x0002;
                                L_0x00d5:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.OAuthStage.ADD_SYSTEM_ACCOUNT;
                                    goto L_0x0002;
                                L_0x00d9:
                                    r0 = com.xiaomi.account.openauth.XiaomiOAuthorize.OAuthStage.OAUTH_FROM_3RD_PARTY;
                                    goto L_0x0002;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.openauth.XiaomiOAuthorize.2.run(com.xiaomi.account.openauth.XiaomiOAuthorize$XiaomiTokenFuture):void");
                                }

                                private Bundle makeOptions() {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("extra_client_id", String.valueOf(XiaomiOAuthorize.this.mAppId));
                                    bundle.putString("extra_redirect_uri", XiaomiOAuthorize.this.mRedirectUrl);
                                    bundle.putString("extra_response_type", str);
                                    if (XiaomiOAuthorize.this.mSkipConfirm != null) {
                                        bundle.putBoolean("extra_skip_confirm", XiaomiOAuthorize.this.mSkipConfirm.booleanValue());
                                    }
                                    if (!TextUtils.isEmpty(XiaomiOAuthorize.this.mState)) {
                                        bundle.putString("extra_state", XiaomiOAuthorize.this.mState);
                                    }
                                    Object access$1000 = XiaomiOAuthorize.makeScopeString(XiaomiOAuthorize.this.mScopes);
                                    if (!TextUtils.isEmpty(access$1000)) {
                                        bundle.putString("extra_scope", access$1000);
                                    }
                                    return bundle;
                                }
                            }.start();
                        } else {
                            throw new IllegalArgumentException("responseType is empty!!!");
                        }
                    }
                }
                throw new IllegalArgumentException("client id is error!!!");
            }
        }
        throw new IllegalArgumentException("activity should not be null and should be running");
    }

    private static Bundle getAccessTokenFromMiuiInResponseWay(Context context, Bundle bundle, IXiaomiAuthResponse iXiaomiAuthResponse) throws ExecutionException, InterruptedException {
        return (Bundle) new AnonymousClass3(context, null, bundle, iXiaomiAuthResponse).start().get();
    }

    private static Bundle getAccessTokenFromMiui(Context context, Account account, Bundle bundle) throws ExecutionException, InterruptedException {
        return (Bundle) new AnonymousClass4(context, account, bundle).start().get();
    }

    private static boolean isMiui(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new com.xiaomi.account.openauth.XiaomiOAuthorize$5;	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r2 = 0;	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r1.<init>(r3, r2, r2);	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r3 = r1.start();	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r3 = r3.get();	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r3 = r3.booleanValue();	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        return r3;
    L_0x0016:
        return r0;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.openauth.XiaomiOAuthorize.isMiui(android.content.Context):boolean");
    }

    private boolean supportResponseWayWithMiui(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 0;
        r1 = new com.xiaomi.account.openauth.XiaomiOAuthorize$6;	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r2 = 0;	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r1.<init>(r4, r2, r2);	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r4 = r1.start();	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r4 = r4.get();	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r4 = (java.lang.Boolean) r4;	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        r4 = r4.booleanValue();	 Catch:{ InterruptedException -> 0x0017, ExecutionException -> 0x0016 }
        return r4;
    L_0x0016:
        return r0;
    L_0x0017:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.openauth.XiaomiOAuthorize.supportResponseWayWithMiui(android.content.Context):boolean");
    }

    private Account getXiaomiAccount(Context context) {
        context = AccountManager.get(context).getAccountsByType(ACCOUNT_TYPE);
        return context.length == 0 ? null : context[0];
    }

    private static String makeScopeString(int[] iArr) {
        if (iArr == null || iArr.length <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            if (i2 > 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(i3);
            i++;
            i2 = i4;
        }
        return stringBuilder.toString();
    }

    @Deprecated
    public static void startGetAccessToken(Activity activity, long j, String str, Bundle bundle, int i) {
        startGetOAuthorize(activity, j, str, "token", bundle, i);
    }

    @Deprecated
    public static void startGetOAuthCode(Activity activity, long j, String str, Bundle bundle, int i) {
        startGetOAuthorize(activity, j, str, "code", bundle, i);
    }

    @Deprecated
    private static void startGetOAuthorize(Activity activity, long j, String str, String str2, Bundle bundle, int i) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        j = new XiaomiOAuthorize().setAppId(j).setRedirectUrl(str).setScope(scopeStringToIntArray(bundle.getString("extra_scope"))).setState(bundle.getString("extra_state"));
        if (bundle.containsKey("extra_skip_confirm")) {
            j.setSkipConfirm(bundle.getBoolean("extra_skip_confirm"));
        }
        new AnonymousClass7("code".equalsIgnoreCase(str2) ? j.startGetOAuthCode(activity) : j.startGetAccessToken(activity), str2, activity, i).execute(new Void[null]);
    }

    @java.lang.Deprecated
    private static int[] scopeStringToIntArray(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = 0;
        if (r5 == 0) goto L_0x001e;
    L_0x0008:
        r2 = " ";
        r5 = r5.split(r2);
        r2 = r5.length;
        r3 = r1;
    L_0x0010:
        if (r3 >= r2) goto L_0x001e;
    L_0x0012:
        r4 = r5[r3];
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ NumberFormatException -> 0x001b }
        r0.add(r4);	 Catch:{ NumberFormatException -> 0x001b }
    L_0x001b:
        r3 = r3 + 1;
        goto L_0x0010;
    L_0x001e:
        r5 = r0.size();
        r5 = new int[r5];
    L_0x0024:
        r2 = r5.length;
        if (r1 >= r2) goto L_0x0036;
    L_0x0027:
        r2 = r0.get(r1);
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r5[r1] = r2;
        r1 = r1 + 1;
        goto L_0x0024;
    L_0x0036:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.openauth.XiaomiOAuthorize.scopeStringToIntArray(java.lang.String):int[]");
    }
}
