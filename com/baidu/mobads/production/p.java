package com.baidu.mobads.production;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdContainerContext;
import com.baidu.mobads.interfaces.IXAdContainerEventListener;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdResource;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.error.IXAdErrorCode;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdActivityUtils;
import com.baidu.mobads.interfaces.utils.IXAdBitmapUtils;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.mobads.interfaces.utils.IXAdConstants;
import com.baidu.mobads.interfaces.utils.IXAdIOUtils;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.interfaces.utils.IXAdViewUtils;
import com.baidu.mobads.openad.c.b;
import com.baidu.mobads.openad.c.c;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloaderManager;
import com.baidu.mobads.openad.interfaces.utils.IOAdTimer;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import java.util.HashMap;

public class p extends c implements IXAdContainerContext {
    public IXAdContainerEventListener a;
    private Context b;
    private Activity d;
    private RelativeLayout e;
    private IXAdResponseInfo f;
    private IXAdInstanceInfo g;
    private View h;
    private IXAdProdInfo i;
    private long j = 0;
    private HashMap<String, Integer> k = new HashMap();

    public class a extends b {
        final /* synthetic */ p a;
        private String b;
        private HashMap<String, Object> c;

        public a(p pVar, String str, String str2, HashMap<String, Object> hashMap) {
            this.a = pVar;
            super(str);
            this.b = str2;
            this.c = hashMap;
        }

        public HashMap<String, Object> getData() {
            return this.c;
        }
    }

    public String getProxyVersion() {
        return "8.7036";
    }

    public p(Context context, Activity activity, IXAdProdInfo iXAdProdInfo, RelativeLayout relativeLayout, IXAdContainerEventListener iXAdContainerEventListener, IXAdResponseInfo iXAdResponseInfo, View view) {
        this.b = context;
        this.d = activity;
        this.i = iXAdProdInfo;
        this.e = relativeLayout;
        this.a = iXAdContainerEventListener;
        this.f = iXAdResponseInfo;
        this.g = iXAdResponseInfo.getPrimaryAdInstanceInfo();
        this.h = view;
    }

    public Context getApplicationContext() {
        return this.b;
    }

    public Activity getActivity() {
        if (this.d == null && this.e != null) {
            this.d = (Activity) this.e.getContext();
        }
        return this.d;
    }

    public IXAdContainerEventListener getAdContainerListener() {
        return this.a;
    }

    public RelativeLayout getAdProdBase() {
        return this.e;
    }

    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.g;
    }

    public IXAdResponseInfo getAdResponseInfo() {
        return this.f;
    }

    public View getAdLeadingView() {
        return this.h;
    }

    public void processCommand(String str, HashMap<String, Object> hashMap) {
        if (System.currentTimeMillis() - this.j > 1000) {
            this.j = System.currentTimeMillis();
            dispatchEvent(new a(this, "process_command", str, hashMap));
        }
    }

    public void registerAdService(String str, HashMap<String, Object> hashMap) {
        if (!this.k.containsKey(str)) {
            this.k.put(str, Integer.valueOf(1));
            dispatchEvent(new a(this, "regsiter_adservice", str, hashMap));
        }
    }

    public void unregisterAdService(String str) {
        if (this.k.containsKey(str)) {
            this.k.remove(str);
            dispatchEvent(new a(this, "unregsiter_adservice", str, new HashMap()));
        }
    }

    public void fireAdMetrics(String str, HashMap<String, String> hashMap) {
        str = XAdSDKFoundationFacade.getInstance().getURIUitls().addParameters(str, hashMap);
        hashMap = new com.baidu.mobads.openad.d.a();
        com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(str, "");
        cVar.e = 1;
        hashMap.a(cVar, Boolean.valueOf(true));
    }

    public IXAdConstants getAdConstants() {
        return XAdSDKFoundationFacade.getInstance().getAdConstants();
    }

    public IXAdURIUitls getAdUitls4URI() {
        return XAdSDKFoundationFacade.getInstance().getURIUitls();
    }

    public IXAdBitmapUtils getAdUtils4Bitmap() {
        return XAdSDKFoundationFacade.getInstance().getBitmapUtils();
    }

    public IXAdViewUtils getAdUtils4View() {
        return XAdSDKFoundationFacade.getInstance().getViewUtils();
    }

    public IXAdIOUtils getAdUtils4IO() {
        return XAdSDKFoundationFacade.getInstance().getIoUtils();
    }

    public IXAdPackageUtils getAdUtils4Package() {
        return XAdSDKFoundationFacade.getInstance().getPackageUtils();
    }

    public IXAdActivityUtils getAdUtils4Activity() {
        return XAdSDKFoundationFacade.getInstance().getActivityUtils();
    }

    public IXAdCommonUtils getAdUtils4Common() {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils();
    }

    public IXAdSystemUtils getAdUtils4System() {
        return XAdSDKFoundationFacade.getInstance().getSystemUtils();
    }

    public IOAdDownloaderManager getDownloaderManager(Context context) {
        return XAdSDKFoundationFacade.getInstance().getDownloaderManager(context);
    }

    public IBase64 getBase64() {
        return XAdSDKFoundationFacade.getInstance().getBase64();
    }

    public IXAdLogger getAdLogger() {
        return XAdSDKFoundationFacade.getInstance().getAdLogger();
    }

    public IXAdResource getAdResource() {
        return XAdSDKFoundationFacade.getInstance().getAdResource();
    }

    public IXAdErrorCode getErrorCode() {
        return XAdSDKFoundationFacade.getInstance().getErrorCode();
    }

    public IXAdProdInfo getAdProdInfo() {
        return this.i;
    }

    public IOAdTimer createOAdTimer(int i) {
        return new com.baidu.mobads.openad.e.a(i);
    }

    public IOAdTimer createOAdTimer(int i, int i2) {
        return new com.baidu.mobads.openad.e.a(i, i2);
    }
}
