package com.baidu.mobads.production.d;

import android.webkit.WebView;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXHybridAdRenderer;
import com.baidu.mobads.interfaces.IXNonLinearAdSlot;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.v;
import com.baidu.mobads.vo.d;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.util.HashMap;

public class a extends b implements IXNonLinearAdSlot {
    private c w;
    private IXHybridAdRenderer x;
    private WebView y;

    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return q();
    }

    public a(WebView webView) {
        super(webView.getContext());
        this.y = webView;
        setActivity(webView.getContext());
        this.o = SlotType.SLOT_TYPE_JSSDK;
        this.w = new c(getApplicationContext(), getActivity(), this.o);
    }

    public void g() {
        load();
    }

    protected void h() {
        this.m = 10000;
    }

    public void request() {
        a(this.w);
    }

    protected void b(d dVar) {
        this.k = dVar;
        k();
        a(null, null, ReaderCallback.GET_BAR_ANIMATING);
    }

    protected void a(c cVar, v vVar, int i) {
        cVar = new StringBuilder("{'ad':[{'id':99999999,'url':'");
        cVar.append(this.w.b());
        cVar.append("', type='");
        cVar.append(CreativeType.HYBRID.getValue());
        cVar.append("'}],'n':1}");
        try {
            setAdResponseInfo(new com.baidu.mobads.vo.c(cVar.toString()));
        } catch (c cVar2) {
            cVar2.printStackTrace();
        }
        b("XAdMouldeLoader ad-server requesting success");
    }

    protected void c(com.baidu.mobads.interfaces.IXAdContainer r1, java.util.HashMap<java.lang.String, java.lang.Object> r2) {
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
        r0 = this;
        r1 = r0.h;	 Catch:{ Exception -> 0x000e }
        r1 = (com.baidu.mobads.interfaces.IXHybridAdRenderer) r1;	 Catch:{ Exception -> 0x000e }
        r0.x = r1;	 Catch:{ Exception -> 0x000e }
        r1 = r0.x;	 Catch:{ Exception -> 0x000e }
        r2 = r0.y;	 Catch:{ Exception -> 0x000e }
        r1.setCustomerWebView(r2);	 Catch:{ Exception -> 0x000e }
        goto L_0x0011;
    L_0x000e:
        r1 = 0;
        r0.x = r1;
    L_0x0011:
        r0.start();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.d.a.c(com.baidu.mobads.interfaces.IXAdContainer, java.util.HashMap):void");
    }

    public d q() {
        return this.w;
    }

    protected void c() {
        new Thread(new b(this)).start();
    }

    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.p();
        dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_USER_CLOSE));
    }

    public boolean a(WebView webView, String str) {
        return this.x == null ? null : this.x.shouldOverrideUrlLoading(webView, str);
    }
}
