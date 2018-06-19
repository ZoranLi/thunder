package anet.channel.flow;

import anet.channel.GlobalAppRuntimeInfo;
import com.taobao.analysis.FlowCenter;

/* compiled from: Taobao */
public class a implements INetworkAnalysis {
    private boolean a;

    public a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r4.<init>();
        r0 = "com.taobao.analysis.FlowCenter";	 Catch:{ Exception -> 0x000c }
        java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x000c }
        r0 = 1;	 Catch:{ Exception -> 0x000c }
        r4.a = r0;	 Catch:{ Exception -> 0x000c }
        return;
    L_0x000c:
        r0 = 0;
        r4.a = r0;
        r1 = "DefaultNetworkAnalysis";
        r2 = "no NWNetworkAnalysisSDK sdk";
        r3 = 0;
        r0 = new java.lang.Object[r0];
        anet.channel.util.ALog.e(r1, r2, r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.flow.a.<init>():void");
    }

    public void commitFlow(b bVar) {
        if (this.a) {
            FlowCenter.getInstance().commitFlow(GlobalAppRuntimeInfo.getContext(), bVar.a, bVar.b, bVar.c, bVar.d, bVar.e);
        }
    }
}
