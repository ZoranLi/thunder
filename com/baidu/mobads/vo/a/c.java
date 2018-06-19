package com.baidu.mobads.vo.a;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.taobao.accs.common.Constants;
import com.xiaomi.push.service.av;
import java.util.HashMap;

public class c extends a {
    public boolean o = true;
    private Context p;
    private IXAppInfo q;

    public c(Context context, IXAppInfo iXAppInfo) {
        super(iXAppInfo.getAdId(), iXAppInfo.getQk(), iXAppInfo.getProd());
        this.p = context;
        this.q = iXAppInfo;
    }

    protected HashMap<String, String> b() {
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(systemUtils.getCurrentProcessId(this.p));
        String stringBuilder2 = stringBuilder.toString();
        HashMap<String, String> hashMap = new HashMap();
        try {
            hashMap.put("autoOpen", this.o ? "true" : av.b);
            hashMap.put(IXAdRequestInfo.PACKAGE, this.q.getPackageName());
            hashMap.put(com.xunlei.downloadprovider.download.tasklist.list.feed.e.c.a, "0");
            hashMap.put("clickProcId", stringBuilder2);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.q.getClickTime());
            hashMap.put("clickTime", stringBuilder3.toString());
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(this.q.getAppSize());
            hashMap.put("contentLength", stringBuilder3.toString());
            hashMap.put("dlCnt", "1");
            hashMap.put("dlTime", String.valueOf(System.currentTimeMillis() - this.q.getClickTime()));
            hashMap.put("dlTunnel", "3");
            hashMap.put("dlWay", this.q.isTooLarge() ? "1" : "0");
            hashMap.put("exp_id", "");
            hashMap.put("exp2", "");
            hashMap.put(Constants.KEY_ELECTION_PKG, this.q.getPackageName());
            hashMap.put("typeProcId", stringBuilder2);
            hashMap.put("url2", "");
            hashMap.put("sn", XAdSDKFoundationFacade.getInstance().getBase64().encode(XAdSDKFoundationFacade.getInstance().getSystemUtils().getIMEI(this.p)));
        } catch (Throwable e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d(e);
        }
        return hashMap;
    }
}
