package com.baidu.mobads.utils;

import android.support.v4.app.NotificationCompat;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainerFactory;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.tencent.smtt.sdk.TbsConfig;

public class g implements IXAdConstants {
    private static String[] a = new String[]{"com.android.chrome", "com.UCMobile", "com.uc.browser", "com.uc.browser.hd", TbsConfig.APP_QB, "com.tencent.padbrowser", "com.baidu.browser.apps", "com.android.browser", "com.oupeng.mini.android", "com.oupeng.mobile", "com.oupeng.browser", "com.opera.mini.android", "com.opera.browser", "com.opera.browser.beta", "com.mediawoz.xbrowser", "com.mx.browser", "com.mx.browser.tablet", "org.mozilla.firefox", "com.tiantianmini.android.browser", "com.ijinshan.browser_fast", "sogou.mobile.explorer", "com.dolphin.browser.cn", "com.qihoo.browser", "com.baidu.searchbox"};

    public String a() {
        return "APO";
    }

    public String deviceNetworkTypeCdma() {
        return "deviceNetworkTypeCdma";
    }

    public String deviceNetworkTypeEdge() {
        return "deviceNetworkTypeEdge";
    }

    public String deviceNetworkTypeEhrpd() {
        return "deviceNetworkTypeEhrpd";
    }

    public String deviceNetworkTypeEvdo0() {
        return "deviceNetworkTypeEvdo0";
    }

    public String deviceNetworkTypeEvdoA() {
        return "deviceNetworkTypeEvdoA";
    }

    public String deviceNetworkTypeEvdoB() {
        return "deviceNetworkTypeEvdoB";
    }

    public String deviceNetworkTypeGprs() {
        return "deviceNetworkTypeGprs";
    }

    public String deviceNetworkTypeHsdpa() {
        return "deviceNetworkTypeHsdpa";
    }

    public String deviceNetworkTypeHspa() {
        return "deviceNetworkTypeHspa";
    }

    public String deviceNetworkTypeHspaPlus() {
        return "deviceNetworkTypeHspaPlus";
    }

    public String deviceNetworkTypeHsupa() {
        return "deviceNetworkTypeHsupa";
    }

    public String deviceNetworkTypeIden() {
        return "deviceNetworkTypeIden";
    }

    public String deviceNetworkTypeLte() {
        return "deviceNetworkTypeLte";
    }

    public String deviceNetworkTypeLxRtt() {
        return "deviceNetworkTypeLxRtt";
    }

    public String deviceNetworkTypeUmts() {
        return "deviceNetworkTypeUmts";
    }

    public String deviceNetworkTypeUnknown() {
        return "deviceNetworkTypeUnknown";
    }

    public String deviceNetworkTypeWifi() {
        return "deviceNetworkTypeWifi";
    }

    public String errorIo() {
        return "errorIo";
    }

    public String errorNullAsset() {
        return "errorNullAsset";
    }

    public String errorTimeout() {
        return "errorTimeout";
    }

    public String errorUnknown() {
        return "errorUnknown";
    }

    public String feedsTrackerParameterKeyList() {
        return "trackerUrl";
    }

    public String feedsTrackerParameterKeyProgress() {
        return NotificationCompat.CATEGORY_PROGRESS;
    }

    public int getActTypeDownload() {
        return 2;
    }

    public int getActTypeLandingPage() {
        return 1;
    }

    public int getActTypeMakeCall() {
        return 32;
    }

    public int getActTypeNothing2Do() {
        return 256;
    }

    public int getActTypeOpenExternalApp() {
        return 512;
    }

    public int getActTypeOpenMap() {
        return 4;
    }

    public int getActTypePlayVideo() {
        return 64;
    }

    public int getActTypeRichMedia() {
        return 128;
    }

    public int getActTypeSendMail() {
        return 16;
    }

    public int getActTypeSendSMS() {
        return 8;
    }

    public int getAdCreativeTypeImage() {
        return 2;
    }

    public int getAdCreativeTypeRichmedia() {
        return 16;
    }

    public int getAdCreativeTypeText() {
        return 1;
    }

    public int getAdCreativeTypeVideo() {
        return 8;
    }

    public int getCanSendCalender() {
        return 4;
    }

    public int getCanSendEmail() {
        return 0;
    }

    public int getCanSendSMS() {
        return 1;
    }

    public int getCanShowDownload() {
        return 3;
    }

    public int getCanShowMap() {
        return 2;
    }

    public String getInfoKeyErrorCode() {
        return "INFO_KEY_ERROR_CODE";
    }

    public String getInfoKeyErrorMessage() {
        return "INFO_KEY_ERROR_MESSAGE";
    }

    public String getInfoKeyErrorModule() {
        return "INFO_KEY_ERROR_MODULE";
    }

    public String getProductionTypeIcon() {
        return "icon";
    }

    public String getProductionTypeNRWall() {
        return "nrwall";
    }

    public String getProductionTypeRWall() {
        return "rwall";
    }

    public String getProductionTypeVideo() {
        return "video";
    }

    public String getProductionTypeWall() {
        return "wall";
    }

    public String getSupportedActionType4RequestingDownload() {
        return "DL";
    }

    public String getSupportedActionType4RequestingLandingPage() {
        return "LP";
    }

    public String getSupportedActionType4RequestingMail() {
        return "MAIL";
    }

    public String getSupportedActionType4RequestingMakeCall() {
        return "PHONE";
    }

    public String getSupportedActionType4RequestingMap() {
        return "MAP";
    }

    public String getSupportedActionType4RequestingNone() {
        return "NA";
    }

    public String getSupportedActionType4RequestingRichMedia() {
        return "RM";
    }

    public String getSupportedActionType4RequestingSMS() {
        return "SMS";
    }

    public String getSupportedActionType4RequestingVideo() {
        return "VIDEO";
    }

    public String mraidNetworkTypeCell() {
        return "mraidNetworkTypeCell";
    }

    public String mraidNetworkTypeOffline() {
        return "mraidNetworkTypeOffline";
    }

    public String mraidNetworkTypeUnknown() {
        return "mraidNetworkTypeUnknown";
    }

    public String mraidNetworkTypeWifi() {
        return "mraidNetworkTypeWifi";
    }

    public String resourceRequestStateFailed() {
        return "resourceRequestStateFailed";
    }

    public String resourceRequestStateIdel() {
        return "resourceRequestStateIdel";
    }

    public String resourceRequestStateRequesting() {
        return "resourceRequestStateRequesting";
    }

    public String resourceRequestStateSuccess() {
        return "resourceRequestStateSuccess";
    }

    public String videoStateError() {
        return "videoStateError";
    }

    public String videoStateIdle() {
        return "videoStateIdle";
    }

    public String videoStatePause() {
        return "videoStatePause";
    }

    public String videoStatePerparing() {
        return "videoStatePerparing";
    }

    public String videoStatePlaybackCompleted() {
        return "videoStatePlaybackCompleted";
    }

    public String videoStatePlaying() {
        return "videoStatePlaying";
    }

    public String videoStatePrepared() {
        return "videoStatePrepared";
    }

    public String getRemoteVersion() {
        IXAdContainerFactory adContainerFactory = XAdSDKFoundationFacade.getInstance().getAdContainerFactory();
        if (adContainerFactory == null) {
            return "0.0.0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(adContainerFactory.getRemoteVersion());
        return stringBuilder.toString();
    }

    public String getSN() {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils().getEncodedSN(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    public String getAppSec() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().getAppSec(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    public String getAppSid() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().getAppId(XAdSDKFoundationFacade.getInstance().getApplicationContext());
    }

    public String getAppPackageNameOfPublisher() {
        return XAdSDKFoundationFacade.getInstance().getApplicationContext().getPackageName();
    }

    public String getProductionTypeBanner() {
        return SlotType.SLOT_TYPE_BANNER.getValue();
    }

    public String getProductionTypeSplash() {
        return SlotType.SLOT_TYPE_SPLASH.getValue();
    }

    public String getProductionTypeInterstitial() {
        return SlotType.SLOT_TYPE_INTERSTITIAL.getValue();
    }

    public String getProductionTypeFeeds() {
        return SlotType.SLOT_TYPE_FEEDS.getValue();
    }

    public String[] getSupportedBrowsers() {
        return a;
    }

    public void setSupportedBrowsers(String[] strArr) {
        a = strArr;
    }
}
