package com.baidu.mobads.b;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class a extends BroadcastReceiver {
    protected final IXAdLogger a = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private com.baidu.mobads.command.a b;

    public a(com.baidu.mobads.command.a aVar) {
        this.b = aVar;
    }

    @TargetApi(3)
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            String replace = intent.getDataString().replace("package:", "");
            if (replace.equals(this.b.i) != null) {
                IXAdPackageUtils packageUtils = XAdSDKFoundationFacade.getInstance().getPackageUtils();
                if (this.b.w == 1 && this.b.x != null && this.b.x.equals("") == null) {
                    if (packageUtils.sendAPOInfo(context, this.b.x, replace, 381, XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload(), 0) != null) {
                        XAdSDKFoundationFacade.getInstance().getCommonUtils().browserOutside(context, this.b.x);
                    }
                    context.unregisterReceiver(this);
                } else if (this.b.l != null) {
                    try {
                        Thread.sleep(600);
                        intent = context.getPackageManager().getLaunchIntentForPackage(replace);
                        intent.addFlags(268435456);
                        context.startActivity(intent);
                        context.unregisterReceiver(this);
                    } catch (Throwable e) {
                        this.a.d("InstallReceiver", e);
                    }
                }
            }
        }
    }
}
