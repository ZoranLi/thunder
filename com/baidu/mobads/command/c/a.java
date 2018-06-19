package com.baidu.mobads.command.c;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Parcelable;
import com.baidu.mobads.AppActivity;
import com.baidu.mobads.AppActivityImp;
import com.baidu.mobads.command.XAdCommandExtraInfo;
import com.baidu.mobads.command.XAdLandingPageExtraInfo;
import com.baidu.mobads.command.b;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.d;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.vo.XAdInstanceInfo;
import java.util.concurrent.atomic.AtomicBoolean;

public class a extends b {
    public static AtomicBoolean h = new AtomicBoolean(false);
    public String f = "";
    public String g = "";
    private String i = null;
    private IXAdActivityUtils j;
    private BroadcastReceiver k = new b(this);

    public a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource, String str) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
        this.i = str;
    }

    public void a() {
        try {
            d commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            IXAdActivityUtils activityUtils = XAdSDKFoundationFacade.getInstance().getActivityUtils();
            Parcelable xAdLandingPageExtraInfo = new XAdLandingPageExtraInfo(this.b.getProdInfo().getProdType(), this.c);
            xAdLandingPageExtraInfo.mIntTesting4LM = 999;
            xAdLandingPageExtraInfo.mStringTesting4LM = "this is the test string";
            xAdLandingPageExtraInfo.url = this.i;
            xAdLandingPageExtraInfo.e75 = 1;
            xAdLandingPageExtraInfo.from = 0;
            xAdLandingPageExtraInfo.adid = this.c.getAdId();
            xAdLandingPageExtraInfo.qk = this.c.getQueryKey();
            xAdLandingPageExtraInfo.packageNameOfPubliser = this.a.getPackageName();
            xAdLandingPageExtraInfo.appsid = commonUtils.getAppId(this.a);
            xAdLandingPageExtraInfo.appsec = commonUtils.getAppSec(this.a);
            xAdLandingPageExtraInfo.title = this.c.getTitle();
            xAdLandingPageExtraInfo.lpShoubaiStyle = this.f;
            xAdLandingPageExtraInfo.lpMurl = this.g;
            Intent intent = new Intent(this.a, AppActivity.getActivityClass());
            if (this.b.getActivity() != null) {
                xAdLandingPageExtraInfo.isFullScreen = activityUtils.isFullScreen(this.b.getActivity()).booleanValue();
            }
            xAdLandingPageExtraInfo.orientation = this.a.getResources().getConfiguration().orientation;
            if (AppActivity.isAnti()) {
                intent.putExtra(AppActivityImp.EXTRA_LANDINGPAGE_EXTRA_INFO, AppActivityImp.classToString(XAdLandingPageExtraInfo.class, xAdLandingPageExtraInfo));
                intent.putExtra(AppActivityImp.EXTRA_COMMAND_EXTRA_INFO, AppActivityImp.classToString(XAdCommandExtraInfo.class, xAdLandingPageExtraInfo));
                intent.putExtra(AppActivityImp.EXTRA_AD_INSTANCE_INFO, AppActivityImp.classToString(XAdInstanceInfo.class, xAdLandingPageExtraInfo.getAdInstanceInfo()));
            } else {
                intent.putExtra(AppActivityImp.EXTRA_DATA, xAdLandingPageExtraInfo);
            }
            intent.putExtra("theme", AppActivity.getActionBarColorTheme());
            intent.putExtra("showWhenLocked", AppActivity.getLpShowWhenLocked());
            intent.addFlags(268435456);
            this.j = XAdSDKFoundationFacade.getInstance().getActivityUtils();
            if (this.j.webviewMultiProcess(this.b.getActivity())) {
                if (!h.get()) {
                    b();
                    this.a.startActivity(intent);
                }
            } else if (!AppActivityImp.isAppActivityOpening()) {
                this.a.startActivity(intent);
            }
        } catch (Throwable e) {
            l.a().e(e);
        }
    }

    private void b() {
        try {
            if (this.a != null) {
                h.set(true);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("AppActivity_onDestroy");
                this.a.registerReceiver(this.k, intentFilter);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void c() {
        try {
            if (this.a != null) {
                this.a.unregisterReceiver(this.k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
