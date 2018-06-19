package com.baidu.mobad.feeds;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobad.feeds.NativeResponse.MaterialType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.vo.XAdInstanceInfo;
import java.util.Map;

public class XAdNativeResponse implements NativeResponse {
    private IXAdInstanceInfo a;
    private BaiduNative b;
    private boolean c = false;
    private IXAdFeedsRequestParameters d;
    private IXAdContainer e;

    public String getAdLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-adIcon_2x.png";
    }

    public String getBaiduLogoUrl() {
        return "https://cpro.baidustatic.com/cpro/ui/noexpire/css/2.1.4/img/mob-logo_2x.png";
    }

    public Map<String, String> getExtras() {
        return null;
    }

    public XAdNativeResponse(IXAdInstanceInfo iXAdInstanceInfo, BaiduNative baiduNative, IXAdFeedsRequestParameters iXAdFeedsRequestParameters, IXAdContainer iXAdContainer) {
        this.a = iXAdInstanceInfo;
        this.b = baiduNative;
        this.e = iXAdContainer;
        if (this.a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload()) {
            this.c = true;
        }
        this.d = iXAdFeedsRequestParameters;
    }

    public String getTitle() {
        return this.a.getTitle();
    }

    public String getDesc() {
        return this.a.getDescription();
    }

    public String getIconUrl() {
        String iconUrl = this.a.getIconUrl();
        return (iconUrl == null || iconUrl.equals("")) ? this.a.getMainPictureUrl() : iconUrl;
    }

    public String getImageUrl() {
        return this.a.getMainPictureUrl();
    }

    public boolean isDownloadApp() {
        return this.c;
    }

    public void setIsDownloadApp(boolean z) {
        this.c = z;
    }

    public boolean isAdAvailable(Context context) {
        return this.b.isAdAvailable(context, this.a, this.d);
    }

    public long getAppSize() {
        return this.a.getAppSize();
    }

    public String getAppPackage() {
        return this.a.getAppPackageName();
    }

    public java.util.List<java.lang.String> getMultiPicUrls() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.a;	 Catch:{ Exception -> 0x002c }
        r1 = r1.getOriginJsonObject();	 Catch:{ Exception -> 0x002c }
        r2 = "morepics";	 Catch:{ Exception -> 0x002c }
        r1 = r1.optJSONArray(r2);	 Catch:{ Exception -> 0x002c }
        if (r1 == 0) goto L_0x002c;	 Catch:{ Exception -> 0x002c }
    L_0x000f:
        r2 = r1.length();	 Catch:{ Exception -> 0x002c }
        if (r2 <= 0) goto L_0x002c;	 Catch:{ Exception -> 0x002c }
    L_0x0015:
        r2 = new java.util.ArrayList;	 Catch:{ Exception -> 0x002c }
        r2.<init>();	 Catch:{ Exception -> 0x002c }
        r0 = 0;
    L_0x001b:
        r3 = r1.length();	 Catch:{ Exception -> 0x002b }
        if (r0 >= r3) goto L_0x002b;	 Catch:{ Exception -> 0x002b }
    L_0x0021:
        r3 = r1.getString(r0);	 Catch:{ Exception -> 0x002b }
        r2.add(r3);	 Catch:{ Exception -> 0x002b }
        r0 = r0 + 1;
        goto L_0x001b;
    L_0x002b:
        r0 = r2;
    L_0x002c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobad.feeds.XAdNativeResponse.getMultiPicUrls():java.util.List<java.lang.String>");
    }

    public void recordImpression(View view) {
        this.b.recordImpression(view, this.a, this.d);
    }

    public void handleClick(View view) {
        handleClick(view, -1);
    }

    public void handleClick(View view, int i) {
        a(view, i, this.a);
    }

    private void a(View view, int i, IXAdInstanceInfo iXAdInstanceInfo) {
        if (isDownloadApp()) {
            Context context = view.getContext();
            if (this.d.getAPPConfirmPolicy() == 3) {
                iXAdInstanceInfo.setActionOnlyWifi(false);
                this.b.handleClick(view, iXAdInstanceInfo, i, this.d);
                return;
            }
            if (this.d.getAPPConfirmPolicy() != 4) {
                if (this.d.getAPPConfirmPolicy() == 2) {
                    a(view, i);
                    return;
                }
                if (this.d.getAPPConfirmPolicy() == 1) {
                    if (XAdSDKFoundationFacade.getInstance().getSystemUtils().is3GConnected(context).booleanValue()) {
                        a(view, i);
                        return;
                    }
                }
                return;
            }
            a(context);
            this.b.handleClick(view, iXAdInstanceInfo, i, this.d);
            return;
        }
        this.b.handleClick(view, this.a, i, this.d);
    }

    private void a(Context context) {
        if (XAdSDKFoundationFacade.getInstance().getSystemUtils().is3GConnected(context).booleanValue() != null) {
            this.a.setActionOnlyWifi(false);
        } else {
            this.a.setActionOnlyWifi(true);
        }
    }

    private void a(final View view, final int i) {
        final Context context = view.getContext();
        Builder builder = new Builder(context);
        StringBuilder stringBuilder = new StringBuilder("确认下载\"");
        stringBuilder.append(getTitle());
        stringBuilder.append("\"?");
        builder.setMessage(stringBuilder.toString());
        builder.setTitle("提示");
        builder.setPositiveButton("确认", new OnClickListener(this) {
            final /* synthetic */ XAdNativeResponse d;

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.d.a(context);
                this.d.b.handleClick(view, this.d.a, i, this.d.d);
            }
        });
        builder.setNegativeButton("取消", new OnClickListener(this) {
            final /* synthetic */ XAdNativeResponse a;

            {
                this.a = r1;
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void onStart(Context context) {
        this.b.handleOnStart(context, this.a, this.d);
    }

    public void onError(Context context, int i, int i2) {
        this.b.handleOnError(context, i, i2, this.a);
    }

    public void onComplete(Context context) {
        this.b.handleOnComplete(context, this.a, this.d);
    }

    public void onClose(Context context, int i) {
        this.b.handleOnClose(context, i, this.a, this.d);
    }

    public void onFullScreen(Context context, int i) {
        this.b.handleOnFullScreen(context, i, this.a, this.d);
    }

    public String getVideoUrl() {
        return this.a.getVideoUrl();
    }

    public int getDuration() {
        return this.a.getVideoDuration();
    }

    public MaterialType getMaterialType() {
        if (this.a.getCreativeType() == CreativeType.VIDEO) {
            return MaterialType.VIDEO;
        }
        if (this.a.getCreativeType() == CreativeType.HTML) {
            return MaterialType.HTML;
        }
        return MaterialType.NORMAL;
    }

    public String getHtmlSnippet() {
        return this.a.getHtmlSnippet();
    }

    public WebView getWebView() {
        return (WebView) this.e.getAdView();
    }

    public void onClickAd(Context context) {
        this.b.handleOnClickAd(context, this.a, this.d);
    }

    public int getMainPicWidth() {
        return this.a.getMainMaterialWidth();
    }

    public int getMainPicHeight() {
        return this.a.getMainMaterialHeight();
    }

    public String getBrandName() {
        return this.a.getAppName();
    }

    protected boolean supportDownloadDirect() {
        return this.a.getAction().equals("video") && this.a.getActionType() == XAdSDKFoundationFacade.getInstance().getAdConstants().getActTypeDownload() && this.a.getCreativeType() == CreativeType.VIDEO;
    }

    protected void handleClickDownloadDirect(View view) {
        if (supportDownloadDirect()) {
            try {
                XAdInstanceInfo xAdInstanceInfo = (XAdInstanceInfo) ((XAdInstanceInfo) this.a).clone();
                xAdInstanceInfo.setAction("");
                a(view, -1, xAdInstanceInfo);
            } catch (View view2) {
                view2.printStackTrace();
            }
        }
    }
}
