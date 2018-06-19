package com.xunlei.tdlive;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.d;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.tdlive.route.util.Route.IRoute;
import com.xunlei.tdlive.sdk.BasePlugin;
import com.xunlei.thunder.commonui.widget.ErrorBlankView;

public class LivePlugin extends BasePlugin {
    private static LivePlugin sInst;
    IRoute authPhone = new 5(this);
    IRoute home = new 3(this);
    IRoute login = new 4(this);
    private Context mContext;
    d mLoginCompletedObservers = new 7(this);
    private LoginHelper mLoginHelper;
    g mLogoutObservers = new 6(this);
    h mRefreshUserInfoObservers = new 8(this);

    public static LivePlugin getInstance(Context context) {
        if (sInst == null) {
            synchronized (LivePlugin.class) {
                if (sInst == null) {
                    sInst = new LivePlugin(context);
                }
            }
        }
        return sInst;
    }

    private LivePlugin(Context context) {
        super(context, AndroidConfig.getHubbleDeviceGUID(), ThunderStator.getInstance());
        this.mContext = context.getApplicationContext();
        RePlugin.registerGlobalBinder("xllive.plugin.host.route", new LivePluginHostRoute(context));
        LivePluginAppRouteDispatcher.registerLivePluginCallback(new 1(this, context));
        LivePluginAppRouteDispatcher.livePlugin(null);
        getRouteDispatcher().addXLLiveRoute(new 2(this, context));
    }

    public LivePlugin login() {
        if (this.mLoginHelper == null) {
            this.mLoginHelper = LoginHelper.a();
            if (l.b()) {
                this.mLoginCompletedObservers.onLoginCompleted(true, 0, true);
                this.mRefreshUserInfoObservers.onRefreshUserInfoCompleted(true, 0);
            }
            this.mLoginHelper.a(this.mRefreshUserInfoObservers);
            this.mLoginHelper.a(this.mLoginCompletedObservers);
            this.mLoginHelper.a(this.mLogoutObservers);
        }
        return this;
    }

    public View newErrorView(Context context, OnClickListener onClickListener) {
        View errorBlankView = new ErrorBlankView(context);
        errorBlankView.setActionButtonListener(onClickListener);
        return errorBlankView;
    }

    public void setErrorViewType(Context context, View view, int i) {
        if ((view instanceof ErrorBlankView) != null) {
            ((ErrorBlankView) view).setErrorType(i);
        }
    }

    public void openLiveWebView(Context context, String str, String str2, boolean z) {
        getRouteDispatcher().webview(str, str2, z);
    }
}
