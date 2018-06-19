package com.baidu.mobads.production.c;

import android.content.Context;
import android.view.View;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.AdSize;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.feeds.IXAdDummyContainer;
import com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.v;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.g;
import com.baidu.mobads.utils.m;
import com.baidu.mobads.vo.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class c extends b {
    private d w;
    private ArrayList<IXAdInstanceInfo> x;

    public void a(Context context, int i, int i2, IXAdInstanceInfo iXAdInstanceInfo) {
    }

    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return r();
    }

    public c(Context context) {
        super(context);
    }

    public c(Context context, String str) {
        super(context);
        setId(str);
        setActivity(context);
        setAdSlotBase(null);
        this.o = SlotType.SLOT_TYPE_FEEDS;
        this.w = new d(getApplicationContext(), getActivity(), this.o);
        g adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        List arrayList = new ArrayList();
        arrayList.add(adConstants.getSupportedActionType4RequestingNone());
        arrayList.add(adConstants.getSupportedActionType4RequestingLandingPage());
        arrayList.add(adConstants.a());
        XAdSDKFoundationFacade.getInstance().getPackageUtils();
        if (m.b(context) != null) {
            arrayList.add(adConstants.getSupportedActionType4RequestingDownload());
        }
        this.w.b(XAdSDKFoundationFacade.getInstance().getCommonUtils().a(arrayList));
        this.w.d(600);
        this.w.e(500);
        this.w.h(0);
        this.w.d(str);
        this.w.f(AdSize.FeedNative.getValue());
        this.w.g(1);
        this.w.i(XAdSDKFoundationFacade.getInstance().getAdConstants().getAdCreativeTypeImage());
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        requestParameters = requestParameters.getHeight();
        if (width > 0 && requestParameters > null) {
            this.w.d(width);
            this.w.e(requestParameters);
        }
    }

    protected void h() {
        this.m = 8000;
    }

    public void request() {
        super.a(this.w);
    }

    protected void a(com.baidu.mobads.openad.d.c cVar, v vVar, int i) {
        vVar.a(cVar, (double) i);
    }

    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        iXAdContainer.start();
    }

    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        this.x = iXAdContainer.getAdContainerContext().getAdResponseInfo().getAdInstanceList();
    }

    public ArrayList<IXAdInstanceInfo> q() {
        return this.x;
    }

    public d r() {
        return this.w;
    }

    public void a(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onImpression(view, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(-1, iXAdInstanceInfo.getThirdImpressionTrackingUrls()));
        } catch (View view2) {
            view2.printStackTrace();
        }
    }

    public boolean a(android.content.Context r3, com.baidu.mobads.interfaces.IXAdInstanceInfo r4, com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters r5) {
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
        r2 = this;
        r0 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0047 }
        r0.<init>();	 Catch:{ Exception -> 0x0047 }
        r1 = r4.getHtmlSnippet();	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = "_&_";	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = r4.getQueryKey();	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = "_&_";	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = r4.getAdId();	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = "_&_";	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = r4.getMainPictureUrl();	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = "_&_";	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = r4.getTitle();	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r1 = "_&_";	 Catch:{ Exception -> 0x0047 }
        r0.append(r1);	 Catch:{ Exception -> 0x0047 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0047 }
        com.baidu.mobads.g.q.a = r0;	 Catch:{ Exception -> 0x0047 }
    L_0x0047:
        r0 = r2.h;	 Catch:{ Exception -> 0x0050 }
        r0 = (com.baidu.mobads.interfaces.feeds.IXAdDummyContainer) r0;	 Catch:{ Exception -> 0x0050 }
        r3 = r0.isAdAvailable(r3, r4, r5);	 Catch:{ Exception -> 0x0050 }
        return r3;
    L_0x0050:
        r3 = 0;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.c.c.a(android.content.Context, com.baidu.mobads.interfaces.IXAdInstanceInfo, com.baidu.mobads.interfaces.feeds.IXAdFeedsRequestParameters):boolean");
    }

    public void b(View view, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        a(view, iXAdInstanceInfo, -1, iXAdFeedsRequestParameters);
    }

    public void a(View view, IXAdInstanceInfo iXAdInstanceInfo, int i, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onClick(view, iXAdInstanceInfo, i, iXAdFeedsRequestParameters, a(i, iXAdInstanceInfo.getThirdClickTrackingUrls()));
        } catch (View view2) {
            view2.printStackTrace();
        }
    }

    public void b(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onStart(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(0, iXAdInstanceInfo.getStartTrackers()));
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void c(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onComplete(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, null);
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void a(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onClose(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(i, iXAdInstanceInfo.getCloseTrackers()));
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void d(Context context, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onCstartcard(context, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(0, iXAdInstanceInfo.getCstartcardTrackers()));
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    public void b(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, IXAdFeedsRequestParameters iXAdFeedsRequestParameters) {
        try {
            ((IXAdDummyContainer) this.h).onFullScreen(context, i, iXAdInstanceInfo, iXAdFeedsRequestParameters, a(i, iXAdInstanceInfo.getFullScreenTrackers()));
        } catch (Context context2) {
            context2.printStackTrace();
        }
    }

    private Map<String, Object> a(int i, List<String> list) {
        Map<String, Object> hashMap = new HashMap();
        hashMap.put(XAdSDKFoundationFacade.getInstance().getAdConstants().feedsTrackerParameterKeyProgress(), Integer.valueOf(i));
        hashMap.put(XAdSDKFoundationFacade.getInstance().getAdConstants().feedsTrackerParameterKeyList(), list);
        return hashMap;
    }

    public void g() {
        this.h.load();
    }
}
