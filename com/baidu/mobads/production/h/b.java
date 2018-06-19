package com.baidu.mobads.production.h;

import android.content.Context;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.ActivityState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VideoState;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.VisitorAction;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.IXLinearAdSlot;
import com.baidu.mobads.openad.d.a;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.openad.interfaces.event.IOAdEventDispatcher;
import com.baidu.mobads.vo.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends com.baidu.mobads.production.b implements IXLinearAdSlot, IOAdEventDispatcher {
    private a w;
    private boolean x;

    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    public boolean d() {
        return true;
    }

    public Object getParameter(String str) {
        return null;
    }

    public void notifyVisitorAction(VisitorAction visitorAction) {
    }

    public void setActivityState(ActivityState activityState) {
    }

    public void setContentVideoAssetCurrentTimePosition(double d) {
    }

    public void setMaxAdNum(int i) {
    }

    public void setMaxDuration(int i) {
    }

    public void setParameter(String str, Object obj) {
    }

    public void setVideoState(VideoState videoState) {
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return q();
    }

    public b(Context context, String str) {
        super(context);
        setId(str);
        this.o = SlotType.SLOT_TYPE_PREROLL;
        this.x = true;
    }

    protected void h() {
        this.m = 8000;
    }

    public void g() {
        this.s.i("XPrerollAdSlot", "afterAdContainerInit()");
        dispatchEvent(new com.baidu.mobads.openad.c.b(com.baidu.mobads.openad.c.b.COMPLETE));
    }

    public void request() {
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
        r0 = new com.baidu.mobads.production.h.a;
        r1 = r4.getApplicationContext();
        r2 = r4.getActivity();
        r3 = r4.o;
        r0.<init>(r1, r2, r3, r4);
        r4.w = r0;
        r0 = r4.w;
        r1 = r4.getId();
        r0.d(r1);
        r0 = r4.getParameter();
        r1 = "BASE_WIDTH";
        r1 = r0.get(r1);
        r1 = (java.lang.String) r1;
        r2 = "BASE_HEIGHT";
        r0 = r0.get(r2);
        r0 = (java.lang.String) r0;
        r2 = 0;
        if (r1 == 0) goto L_0x0036;
    L_0x0031:
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x0036 }
        goto L_0x0037;
    L_0x0036:
        r1 = r2;
    L_0x0037:
        if (r0 == 0) goto L_0x003e;
    L_0x0039:
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x003e }
        r2 = r0;
    L_0x003e:
        r0 = r4.w;
        r0.d(r1);
        r0 = r4.w;
        r0.e(r2);
        r0 = r4.w;
        super.a(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.h.b.request():void");
    }

    protected void a(com.baidu.mobads.openad.d.c r3, com.baidu.mobads.production.v r4, int r5) {
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
        r0 = r2.getParameter();
        r1 = "AD_REQUESTING_TIMEOUT";
        r0 = r0.get(r1);
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x0013;
    L_0x000e:
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Exception -> 0x0013 }
        r5 = r0;
    L_0x0013:
        r0 = (double) r5;
        r4.a(r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.h.b.a(com.baidu.mobads.openad.d.c, com.baidu.mobads.production.v, int):void");
    }

    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        if (iXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == CreativeType.STATIC_IMAGE || iXAdContainer.getAdContainerContext().getAdInstanceInfo().getCreativeType() == CreativeType.GIF) {
            com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.w.d();
            JSONObject attribute = bVar.getAttribute();
            if (attribute == null) {
                attribute = new JSONObject();
            }
            try {
                attribute.put("supportTipView", this.x);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            bVar.a(attribute);
            start();
        }
    }

    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        hashMap = new HashSet();
        hashMap.addAll(iXAdContainer.getAdContainerContext().getAdInstanceInfo().getStartTrackers());
        a(hashMap);
    }

    private void a(Set<String> set) {
        a aVar = new a();
        for (String cVar : set) {
            c cVar2 = new c(cVar, "");
            cVar2.e = 1;
            aVar.a(cVar2, Boolean.valueOf(true));
        }
    }

    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.e(iXAdContainer, hashMap);
        this.l = SlotState.COMPLETED;
    }

    public d q() {
        return this.w;
    }

    public void setVideoDisplayBase(RelativeLayout relativeLayout) {
        this.e = relativeLayout;
    }

    public int getDuration() {
        if (this.h == null) {
            return super.getDuration();
        }
        return (int) this.h.getDuration();
    }

    public int getPlayheadTime() {
        if (this.h == null) {
            return super.getPlayheadTime();
        }
        return (int) this.h.getPlayheadTime();
    }

    public void load() {
        this.q.set(true);
        super.load();
    }

    public void start() {
        if (this.q.get()) {
            super.start();
        } else {
            load();
        }
    }

    public void stop() {
        StringBuilder stringBuilder = new StringBuilder("stop()");
        stringBuilder.append(getSlotState().getValue());
        this.s.i("XPrerollAdSlot", stringBuilder.toString());
        super.stop();
    }

    public void pause() {
        StringBuilder stringBuilder = new StringBuilder("pause()");
        stringBuilder.append(getSlotState().getValue());
        this.s.i("XPrerollAdSlot", stringBuilder.toString());
        if (getSlotState() == SlotState.PLAYING) {
            super.pause();
        }
    }

    public void resume() {
        StringBuilder stringBuilder = new StringBuilder("resume()");
        stringBuilder.append(getSlotState().getValue());
        this.s.i("XPrerollAdSlot", stringBuilder.toString());
        if (getSlotState() == SlotState.PAUSED) {
            super.resume();
        }
    }

    public void setSupportTipView(boolean z) {
        this.x = z;
    }
}
