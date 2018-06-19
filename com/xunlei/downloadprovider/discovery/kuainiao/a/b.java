package com.xunlei.downloadprovider.discovery.kuainiao.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.RemoteViews;
import com.xunlei.common.accelerator.XLAccelUtil;
import com.xunlei.common.accelerator.XLOnAccelListener;
import com.xunlei.common.accelerator.bean.XLAccelBandInfo;
import com.xunlei.common.androidutil.notification.NotificationManagerWrapper;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.stat.base.XLStatCommandID;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.dialog.XLAlarmDialogActivity;
import com.xunlei.downloadprovider.discovery.kuainiao.d;
import com.xunlei.downloadprovider.member.payment.external.PayEntryParam;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.external.PaymentEntryActivity;
import com.xunlei.downloadprovider.pushmessage.c.c;
import com.xunlei.xllib.android.XLIntent;
import java.math.BigDecimal;

/* compiled from: KuaiNiaoAccelerator */
public class b {
    private static b d;
    String a = "";
    private boolean b = true;
    private XLOnAccelListener c = new c(this);

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    private b() {
        XLAccelUtil.getInstance().init(BrothersApplication.getApplicationInstance(), f(), "shoulei");
        XLAccelUtil.getInstance().getAccelerator().attachListener(this.c);
    }

    private static java.lang.String f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.xunlei.common.device.XLDeviceGen.getInstance();	 Catch:{ Exception -> 0x0009 }
        r0 = r0.getDeviceId();	 Catch:{ Exception -> 0x0009 }
        goto L_0x000d;
    L_0x0009:
        r0 = com.xunlei.common.androidutil.AndroidConfig.getHubbleDeviceGUID();
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.discovery.kuainiao.a.b.f():java.lang.String");
    }

    public static boolean c() {
        XLAccelUtil.getInstance().getAccelerator().queryStatus();
        d.f = true;
        return false;
    }

    public static boolean d() {
        XLAccelUtil.getInstance().getAccelerator().queryStatus();
        d.f = true;
        return false;
    }

    public final void b() {
        XLAccelUtil.getInstance().getAccelerator().stopAccel();
        XLAccelUtil.getInstance().getAccelerator().saveAccelState(BrothersApplication.getApplicationInstance());
        XLAccelUtil.getInstance().getAccelerator().detachListener(this.c);
        XLAccelUtil.getInstance().getAccelerator().uninit();
    }

    static /* synthetic */ void e() {
        RemoteViews remoteViews;
        XLAccelBandInfo bandInfoObject = XLAccelUtil.getInstance().getAccelerator().getBandInfoObject();
        CharSequence charSequence = "200M";
        if (!(bandInfoObject == null || bandInfoObject.mMaxBandWidth == null)) {
            BigDecimal divide = new BigDecimal(bandInfoObject.mMaxBandWidth.mDownStream).divide(new BigDecimal(1024), 1, 1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(divide.intValue());
            stringBuilder.append("M");
            charSequence = stringBuilder.toString();
        }
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        Builder builder = new Builder(applicationInstance);
        builder.setSmallIcon(R.drawable.bt_noti_default_logo);
        builder.setTicker(applicationInstance.getResources().getString(R.string.kuainiao_dialog_title));
        builder.setAutoCancel(true);
        builder.setNumber(0);
        if (SettingStateController.getInstance().isSoundOn()) {
            builder.setDefaults(1);
        } else {
            builder.setDefaults(0);
        }
        PayEntryParam payEntryParam = new PayEntryParam(PayFrom.BIRD_PAGE);
        payEntryParam.a("k_an_shoulei_push_kt");
        PendingIntent activity = PendingIntent.getActivity(applicationInstance, 0, PaymentEntryActivity.b(applicationInstance, payEntryParam), 268435456);
        if (c.b(applicationInstance)) {
            remoteViews = new RemoteViews(applicationInstance.getPackageName(), R.layout.noti_kuainiao_black);
        } else {
            remoteViews = new RemoteViews(applicationInstance.getPackageName(), R.layout.noti_kuainiao_white);
        }
        remoteViews.setTextViewText(R.id.max_speed_txt, charSequence);
        builder.setContent(remoteViews);
        builder.setContentIntent(activity);
        NotificationManagerWrapper.getInstance(applicationInstance).postNotification(50001, builder.build());
    }

    static /* synthetic */ void a(String str) {
        Intent xLIntent = new XLIntent(BrothersApplication.getApplicationInstance(), XLAlarmDialogActivity.class);
        xLIntent.putExtra("type", XLStatCommandID.XLCID_WX_LOGIN_ERROR);
        xLIntent.putExtra("bandwidth", str);
        xLIntent.setFlags(268435456);
        BrothersApplication.getApplicationInstance().startActivity(xLIntent);
    }
}
