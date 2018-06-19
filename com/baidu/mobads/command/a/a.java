package com.baidu.mobads.command.a;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.mobads.command.b;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader.DownloadStatus;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.d;
import com.baidu.mobads.utils.k;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.net.URL;

public class a extends b {
    public a(IXNonLinearAdSlot iXNonLinearAdSlot, IXAdInstanceInfo iXAdInstanceInfo, IXAdResource iXAdResource) {
        super(iXNonLinearAdSlot, iXAdInstanceInfo, iXAdResource);
    }

    public void a() {
        StringBuilder stringBuilder;
        d commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        XAdSDKFoundationFacade.getInstance().getIoUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        try {
            com.baidu.mobads.command.a a;
            String appPackageName = this.c.getAppPackageName();
            StringBuilder stringBuilder2 = new StringBuilder("download pkg = ");
            stringBuilder2.append(appPackageName);
            this.e.i("XAdDownloadAPKCommand", stringBuilder2.toString());
            if ((appPackageName == null || appPackageName.equals("")) && !TextUtils.isEmpty(this.c.getOriginClickUrl())) {
                this.e.i("XAdDownloadAPKCommand", "start to download but package is empty");
                appPackageName = commonUtils.getMD5(this.c.getOriginClickUrl());
            }
            String str = appPackageName;
            IOAdDownloader adsApkDownloader = com.baidu.mobads.openad.b.d.a(this.a).getAdsApkDownloader(str);
            com.baidu.mobads.openad.b.b a2 = com.baidu.mobads.openad.b.b.a(str);
            if (a2 == null || adsApkDownloader == null) {
                if (adsApkDownloader != null) {
                    adsApkDownloader.cancel();
                    adsApkDownloader.removeObservers();
                }
                com.baidu.mobads.openad.b.b.b(str);
                com.baidu.mobads.openad.b.d.a(this.a).removeAdsApkDownloader(str);
            } else {
                a = a2.a();
                DownloadStatus state = adsApkDownloader.getState();
                StringBuilder stringBuilder3 = new StringBuilder("startDownload>> downloader exist: state=");
                stringBuilder3.append(state);
                this.e.d("XAdDownloadAPKCommand", stringBuilder3.toString());
                if (!(state == DownloadStatus.CANCELLED || state == DownloadStatus.ERROR)) {
                    if (state != DownloadStatus.PAUSED) {
                        if (state == DownloadStatus.COMPLETED) {
                            if (a(this.a, a)) {
                                uRIUitls.pintHttpInNewThread(this.c.getClickThroughUrl());
                                b(a);
                                return;
                            }
                            adsApkDownloader.cancel();
                            adsApkDownloader.removeObservers();
                            com.baidu.mobads.openad.b.b.b(str);
                            com.baidu.mobads.openad.b.d.a(this.a).removeAdsApkDownloader(str);
                        } else if (state == DownloadStatus.DOWNLOADING || state == DownloadStatus.INITING) {
                            String apid;
                            Context context = this.a;
                            String str2 = "downloading";
                            String prodType = this.b != null ? this.b.getProdInfo().getProdType() : "";
                            String appId = commonUtils.getAppId(this.a);
                            if (this.b != null) {
                                apid = this.b.getAdRequestInfo().getApid();
                            } else {
                                apid = "";
                            }
                            commonUtils.sendDownloadAdLog(context, 529, str2, prodType, str, appId, apid, systemUtils.getPhoneOSBrand(), Build.MODEL, VERSION.RELEASE, VERSION.SDK_INT);
                            context = this.a;
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append(adsApkDownloader.getTitle());
                            stringBuilder4.append(adsApkDownloader.getState().getMessage());
                            a(context, stringBuilder4.toString(), 0, Boolean.valueOf(this.c.isPopNotif()));
                            return;
                        }
                    }
                }
                adsApkDownloader.resume();
                uRIUitls.pintHttpInNewThread(this.c.getClickThroughUrl());
                return;
            }
            a = com.baidu.mobads.command.a.a(this.a, str);
            if (a != null) {
                if (a.g == DownloadStatus.COMPLETED && a(this.a, a)) {
                    b(a);
                    return;
                }
                uRIUitls.pintHttpInNewThread(this.c.getClickThroughUrl());
            } else if (b()) {
                commonUtils.sendDownloadAdLog(this.a, 529, "alreadyinstalled1", this.b != null ? this.b.getProdInfo().getProdType() : "", str, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, VERSION.RELEASE, VERSION.SDK_INT);
                XAdSDKFoundationFacade.getInstance().getPackageUtils().openApp(this.a, this.c.getAppPackageName());
                uRIUitls.pintHttpInNewThread(this.c.getClickThroughUrl());
                com.baidu.mobads.production.b.f().getXMonitorActivation(this.a, this.e).startMonitor();
                return;
            } else {
                String appName = this.c.getAppName();
                if (appName == null || appName.equals("")) {
                    appName = this.c.getTitle();
                    if (appName == null || appName.equals("")) {
                        appName = "您点击的应用";
                    }
                }
                a = new com.baidu.mobads.command.a(str, appName);
                a.a(this.c.getQueryKey(), this.c.getAdId(), this.c.getClickThroughUrl(), this.c.isAutoOpen());
                a.m = this.c.isPopNotif();
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(commonUtils.getMD5(a.j));
                stringBuilder5.append(ShareConstants.PATCH_SUFFIX);
                a.a(stringBuilder5.toString(), k.a(this.a));
                if (this.b != null) {
                    a.b(this.b.getAdRequestInfo().getApid(), this.b.getProdInfo().getProdType());
                }
                a.f = com.baidu.mobads.openad.b.b.c(str);
                a.s = this.c.isActionOnlyWifi() ^ true;
                a.a(System.currentTimeMillis());
                a.b(this.c.getAppSize());
                a.a(this.c.isTooLarge());
            }
            a.t = System.currentTimeMillis();
            IOAdDownloader createAdsApkDownloader = XAdSDKFoundationFacade.getInstance().getDownloaderManager(this.a).createAdsApkDownloader(new URL(a.j), a.c, a.b, 3, a.a, a.i);
            if (!(!this.c.getAPOOpen() || this.c.getPage() == null || this.c.getPage().equals(""))) {
                a.w = true;
                a.x = this.c.getPage();
            }
            createAdsApkDownloader.addObserver(new com.baidu.mobads.openad.b.b(this.a, a));
            if (a.s || !systemUtils.is3GConnected(this.a).booleanValue()) {
                commonUtils.sendDownloadAdLog(this.a, 527, "realstart", this.b != null ? this.b.getProdInfo().getProdType() : "", str, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, VERSION.RELEASE, VERSION.SDK_INT);
                createAdsApkDownloader.start();
                return;
            }
            commonUtils.sendDownloadAdLog(this.a, 529, "waitwifi", this.b != null ? this.b.getProdInfo().getProdType() : "", str, commonUtils.getAppId(this.a), this.b != null ? this.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, VERSION.RELEASE, VERSION.SDK_INT);
            createAdsApkDownloader.pause();
            Context context2 = this.a;
            stringBuilder = new StringBuilder();
            stringBuilder.append(createAdsApkDownloader.getTitle());
            stringBuilder.append(" 将在连入Wifi后开始下载");
            a(context2, stringBuilder.toString(), 0, Boolean.valueOf(this.c.isPopNotif()));
        } catch (Throwable e) {
            this.e.e("XAdDownloadAPKCommand", e);
            com.baidu.mobads.c.a a3 = com.baidu.mobads.c.a.a();
            stringBuilder = new StringBuilder("ad app download failed: ");
            stringBuilder.append(e.toString());
            a3.a(stringBuilder.toString());
        }
    }

    public void a(Context context, String str, int i, Boolean bool) {
        if (bool.booleanValue() != null) {
            Toast.makeText(context, str, i).show();
        }
    }

    private boolean b() {
        return XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(this.a, this.c.getAppPackageName());
    }

    protected boolean a(Context context, com.baidu.mobads.command.a aVar) {
        a aVar2 = this;
        Context context2 = context;
        com.baidu.mobads.command.a aVar3 = aVar;
        boolean isInstalled = XAdSDKFoundationFacade.getInstance().getPackageUtils().isInstalled(context2, aVar3.i);
        d commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        if (isInstalled) {
            commonUtils.sendDownloadAdLog(aVar2.a, 529, "alreadyinstalled", aVar2.b != null ? aVar2.b.getProdInfo().getProdType() : "", aVar3.i, commonUtils.getAppId(aVar2.a), aVar2.b != null ? aVar2.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, VERSION.RELEASE, VERSION.SDK_INT);
            XAdSDKFoundationFacade.getInstance().getPackageUtils().openApp(context2, aVar3.i);
            return true;
        }
        commonUtils.sendDownloadAdLog(aVar2.a, 529, "alreadydownloaded", aVar2.b != null ? aVar2.b.getProdInfo().getProdType() : "", aVar3.i, commonUtils.getAppId(aVar2.a), aVar2.b != null ? aVar2.b.getAdRequestInfo().getApid() : "", systemUtils.getPhoneOSBrand(), Build.MODEL, VERSION.RELEASE, VERSION.SDK_INT);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(aVar3.c);
        stringBuilder.append(aVar3.b);
        String stringBuilder2 = stringBuilder.toString();
        File file = new File(stringBuilder2);
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        XAdSDKFoundationFacade.getInstance().getPackageUtils().b(context2, stringBuilder2);
        return true;
    }

    private void b(com.baidu.mobads.command.a aVar) {
        if (com.baidu.mobads.production.b.f() != null) {
            aVar = a(aVar);
            if (aVar != null) {
                com.baidu.mobads.production.b.f().getXMonitorActivation(this.a, this.e).addAppInfoForMonitor(aVar);
                return;
            }
            this.e.e("addAppInfoForMonitor error, appInfo is null");
        }
    }

    public static IXAppInfo a(com.baidu.mobads.command.a aVar) {
        if (aVar == null) {
            return null;
        }
        IXAdContainerFactory f = com.baidu.mobads.production.b.f();
        if (f == null) {
            return null;
        }
        IXAppInfo createAppInfo = f.createAppInfo();
        createAppInfo.setAdId(aVar.g());
        createAppInfo.setAppSize(aVar.e());
        createAppInfo.setClickTime(aVar.c());
        createAppInfo.setPackageName(aVar.d());
        createAppInfo.setQk(aVar.h());
        createAppInfo.setProd(aVar.i());
        createAppInfo.setTooLarge(aVar.f());
        return createAppInfo;
    }
}
