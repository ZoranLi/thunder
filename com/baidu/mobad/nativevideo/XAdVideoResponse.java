package com.baidu.mobad.nativevideo;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.BaiduNative;
import com.baidu.mobad.feeds.NativeResponse;
import com.baidu.mobad.feeds.XAdNativeResponse;
import com.baidu.mobad.nativevideo.BaiduVideoResponse.PrerollMaterialType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;

class XAdVideoResponse implements BaiduVideoResponse {
    NativeResponse a;

    public XAdVideoResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.a = new XAdNativeResponse(iXAdInstanceInfo, baiduNative, iXAdFeedsRequestParameters, iXAdContainer);
    }

    public XAdVideoResponse(NativeResponse nativeResponse) {
        this.a = nativeResponse;
    }

    public void recordImpression(View view) {
        this.a.recordImpression(view);
    }

    public void handleClick(View view) {
        this.a.handleClick(view);
    }

    public void handleClick(View view, int i) {
        this.a.handleClick(view, i);
    }

    public void onStart(Context context) {
        this.a.onStart(context);
    }

    public void onError(Context context, int i, int i2) {
        this.a.onError(context, i, i2);
    }

    public void onComplete(Context context) {
        this.a.onComplete(context);
    }

    public void onClose(Context context, int i) {
        this.a.onClose(context, i);
    }

    public void onClickAd(Context context) {
        this.a.onClickAd(context);
    }

    public void onFullScreen(Context context, int i) {
        this.a.onFullScreen(context, i);
    }

    public String getVideoUrl() {
        return this.a.getVideoUrl();
    }

    public int getDuration() {
        return this.a.getDuration();
    }

    public PrerollMaterialType getMaterialType() {
        PrerollMaterialType prerollMaterialType = PrerollMaterialType.NORMAL;
        switch (this.a.getMaterialType()) {
            case VIDEO:
                return PrerollMaterialType.VIDEO;
            case NORMAL:
                if (this.a.getImageUrl().endsWith(".gif")) {
                    return PrerollMaterialType.GIF;
                }
                return prerollMaterialType;
            default:
                return prerollMaterialType;
        }
    }

    public String getImageUrl() {
        return this.a.getImageUrl();
    }

    public boolean isDownloadApp() {
        return this.a.isDownloadApp();
    }

    public String getAdLogoUrl() {
        return this.a.getAdLogoUrl();
    }

    public String getBaiduLogoUrl() {
        return this.a.getBaiduLogoUrl();
    }
}
