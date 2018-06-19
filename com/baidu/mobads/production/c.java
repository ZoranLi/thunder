package com.baidu.mobads.production;

import com.baidu.mobads.openad.interfaces.event.IOAdEventListener;

class c implements IOAdEventListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run(com.baidu.mobads.openad.interfaces.event.IOAdEvent r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.a;
        r0.k();
        r0 = "URLLoader.Load.Complete";
        r1 = r4.getType();
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x00b9;
    L_0x0011:
        r4 = r4.getData();
        r0 = "message";
        r4 = r4.get(r0);
        r4 = (java.lang.String) r4;
        r0 = r3.a;	 Catch:{ Exception -> 0x009b }
        r1 = new com.baidu.mobads.vo.c;	 Catch:{ Exception -> 0x009b }
        r1.<init>(r4);	 Catch:{ Exception -> 0x009b }
        r0.setAdResponseInfo(r1);	 Catch:{ Exception -> 0x009b }
        r4 = r3.a;	 Catch:{ Exception -> 0x009b }
        r4 = r4.x;	 Catch:{ Exception -> 0x009b }
        if (r4 == 0) goto L_0x006a;	 Catch:{ Exception -> 0x009b }
    L_0x002f:
        r4 = r3.a;	 Catch:{ Exception -> 0x009b }
        r4 = r4.x;	 Catch:{ Exception -> 0x009b }
        r4 = r4.getAdInstanceList();	 Catch:{ Exception -> 0x009b }
        r4 = r4.size();	 Catch:{ Exception -> 0x009b }
        if (r4 <= 0) goto L_0x006a;	 Catch:{ Exception -> 0x009b }
    L_0x003f:
        r4 = r3.a;	 Catch:{ Exception -> 0x009b }
        r0 = r3.a;	 Catch:{ Exception -> 0x009b }
        r0 = r0.x;	 Catch:{ Exception -> 0x009b }
        r0 = r0.getPrimaryAdInstanceInfo();	 Catch:{ Exception -> 0x009b }
        r4.d = r0;	 Catch:{ Exception -> 0x009b }
        r4 = r3.a;	 Catch:{ Exception -> 0x009b }
        r4 = r4.d;	 Catch:{ Exception -> 0x009b }
        r4 = r4.getOriginJsonObject();	 Catch:{ Exception -> 0x009b }
        r0 = r3.a;	 Catch:{ Exception -> 0x009b }
        r1 = "mimetype";	 Catch:{ Exception -> 0x009b }
        r4 = r4.optString(r1);	 Catch:{ Exception -> 0x009b }
        r0.r = r4;	 Catch:{ Exception -> 0x009b }
        r4 = r3.a;	 Catch:{ Exception -> 0x009b }
        r4.q();	 Catch:{ Exception -> 0x009b }
        r4 = r3.a;	 Catch:{ Exception -> 0x009b }
        r4.a();	 Catch:{ Exception -> 0x009b }
        return;	 Catch:{ Exception -> 0x009b }
    L_0x006a:
        r4 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();	 Catch:{ Exception -> 0x009b }
        r4 = r4.getErrorCode();	 Catch:{ Exception -> 0x009b }
        r0 = r3.a;	 Catch:{ Exception -> 0x009b }
        r0 = r0.x;	 Catch:{ Exception -> 0x009b }
        r0 = r0.getErrorCode();	 Catch:{ Exception -> 0x009b }
        r1 = r3.a;	 Catch:{ Exception -> 0x009b }
        r1 = r1.x;	 Catch:{ Exception -> 0x009b }
        r1 = r1.getErrorMessage();	 Catch:{ Exception -> 0x009b }
        r2 = "";	 Catch:{ Exception -> 0x009b }
        r4.printErrorMessage(r0, r1, r2);	 Catch:{ Exception -> 0x009b }
        r4 = r3.a;	 Catch:{ Exception -> 0x009b }
        r0 = r3.a;	 Catch:{ Exception -> 0x009b }
        r0 = r0.x;	 Catch:{ Exception -> 0x009b }
        r0 = r0.getErrorMessage();	 Catch:{ Exception -> 0x009b }
        r4.d(r0);	 Catch:{ Exception -> 0x009b }
        return;
    L_0x009b:
        r4 = "response json parsing error";
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r0 = r0.getErrorCode();
        r1 = "";
        r2 = "";
        r0.printErrorMessage(r1, r4, r2);
        r0 = r3.a;
        r0.d(r4);
        r0 = com.baidu.mobads.c.a.a();
        r0.a(r4);
        return;
    L_0x00b9:
        r4 = "request ad-server error, io_err/timeout";
        r0 = com.baidu.mobads.utils.XAdSDKFoundationFacade.getInstance();
        r0 = r0.getErrorCode();
        r1 = "";
        r2 = "";
        r0.printErrorMessage(r1, r4, r2);
        r0 = r3.a;
        r0.d(r4);
        r0 = com.baidu.mobads.c.a.a();
        r0.a(r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.c.run(com.baidu.mobads.openad.interfaces.event.IOAdEvent):void");
    }
}
