package com.baidu.mobads.production.g;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.baidu.mobads.interfaces.IXAdConstants4PDK.SlotType;
import com.baidu.mobads.interfaces.IXAdContainer;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdInstanceInfo.CreativeType;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.IXAdResponseInfo;
import com.baidu.mobads.interfaces.event.IXAdEvent;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.openad.b.f;
import com.baidu.mobads.openad.d.c;
import com.baidu.mobads.openad.interfaces.download.IOAdDownloader;
import com.baidu.mobads.production.b;
import com.baidu.mobads.production.v;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.m;
import com.baidu.mobads.vo.XAdInstanceInfo;
import com.baidu.mobads.vo.d;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends b {
    private static boolean D = false;
    private static int E;
    private String A;
    private String B;
    private int C;
    private Observer F;
    protected final IXAdLogger w;
    private e x;
    private Context y;
    private boolean z;

    public void c(IXAdResponseInfo iXAdResponseInfo) {
    }

    public boolean d() {
        return true;
    }

    public /* synthetic */ IXAdRequestInfo getAdRequestInfo() {
        return q();
    }

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z, int i, int i2, int i3) {
        this(context, relativeLayout, str, z, i, i2);
        this.C = i3;
    }

    public a(Context context, RelativeLayout relativeLayout, String str, boolean z, int i, int i2) {
        super(context);
        this.z = false;
        this.w = XAdSDKFoundationFacade.getInstance().getAdLogger();
        this.F = new c(this);
        setId(str);
        setActivity(context);
        setAdSlotBase(relativeLayout);
        this.o = SlotType.SLOT_TYPE_SPLASH;
        this.y = context;
        this.x = new e(getApplicationContext(), this.o);
        this.x.a(z);
        relativeLayout = XAdSDKFoundationFacade.getInstance().getAdConstants();
        if (z) {
            List arrayList = new ArrayList();
            arrayList.add(relativeLayout.getSupportedActionType4RequestingNone());
            arrayList.add(relativeLayout.getSupportedActionType4RequestingLandingPage());
            arrayList.add(relativeLayout.a());
            XAdSDKFoundationFacade.getInstance().getPackageUtils();
            if (m.b(context) != null) {
                arrayList.add(relativeLayout.getSupportedActionType4RequestingDownload());
            }
            context = XAdSDKFoundationFacade.getInstance().getCommonUtils().a(arrayList);
        } else {
            context = relativeLayout.getSupportedActionType4RequestingNone();
        }
        this.x.b(context);
        this.x.d(i);
        this.x.e(i2);
        this.x.d(str);
        e(str);
    }

    protected void h() {
        this.m = 4200;
    }

    public void request() {
        com.baidu.mobads.a.a.m = System.currentTimeMillis();
        m();
        a(this.x);
        try {
            new WebView(getActivity()).loadDataWithBaseURL(null, "", "text/html", "UTF-8", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void a(c cVar, v vVar, int i) {
        com.baidu.mobads.vo.b bVar = (com.baidu.mobads.vo.b) this.k.d();
        JSONObject attribute = bVar.getAttribute();
        if (attribute == null) {
            attribute = new JSONObject();
        }
        try {
            attribute.put("needRequestVR", D);
            attribute.put("bitmapDisplayMode", E);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        bVar.a(attribute);
        vVar.a(cVar, (double) i);
    }

    protected void c(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        com.baidu.mobads.a.a.r = System.currentTimeMillis();
        try {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("m_new_rsplash", String.valueOf(com.baidu.mobads.a.a.l));
            hashMap2.put("m_start_request", String.valueOf(com.baidu.mobads.a.a.m));
            hashMap2.put("m_end_request", String.valueOf(com.baidu.mobads.a.a.n));
            hashMap2.put("m_start_dex", String.valueOf(com.baidu.mobads.a.a.o));
            hashMap2.put("m_end_dex", String.valueOf(com.baidu.mobads.a.a.p));
            hashMap2.put("m_start_load", String.valueOf(com.baidu.mobads.a.a.q));
            hashMap2.put("m_end_load", String.valueOf(com.baidu.mobads.a.a.r));
            hashMap2.put("isRequestAndLoadAdTimeout", String.valueOf(this.z));
            iXAdContainer = getAdResponseInfo();
            IXAdInstanceInfo primaryAdInstanceInfo = iXAdContainer != null ? iXAdContainer.getPrimaryAdInstanceInfo() : null;
            JSONObject attribute = this.x.d().getAttribute();
            if (attribute == null) {
                attribute = new JSONObject();
            }
            try {
                attribute.put("splashTipStyle", this.C);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            ((com.baidu.mobads.vo.b) this.x.d()).a(attribute);
            com.baidu.mobads.c.a.a().a(this.y, "386", primaryAdInstanceInfo, this.x.d(), hashMap2);
        } catch (Throwable e2) {
            this.w.e(e2);
        }
        if (this.z == null) {
            start();
            Handler handler = new Handler(this.y.getMainLooper());
            dispatchEvent(new com.baidu.mobads.f.a(IXAdEvent.AD_LOADED));
            if (hashMap == null) {
                try {
                    a(handler);
                    return;
                } catch (IXAdContainer iXAdContainer2) {
                    iXAdContainer2.printStackTrace();
                    return;
                }
            }
            IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo) hashMap.get("AdInstance");
            hashMap = iXAdInstanceInfo.getCreativeType();
            if (hashMap == CreativeType.VIDEO || hashMap == CreativeType.RM) {
                com.baidu.mobads.c.a.a().a(this.y, "383", iXAdInstanceInfo, this.x.d(), "processAdLoaded");
            } else {
                a(handler);
            }
        }
    }

    private void a(Handler handler) {
        handler.postDelayed(new b(this), 5000);
    }

    public void b() {
        this.z = true;
        try {
            IXAdResponseInfo adResponseInfo = getAdResponseInfo();
            IXAdInstanceInfo iXAdInstanceInfo = null;
            if (adResponseInfo != null) {
                iXAdInstanceInfo = adResponseInfo.getPrimaryAdInstanceInfo();
            }
            com.baidu.mobads.c.a.a().a(this.y, "382", iXAdInstanceInfo, this.x.d(), null);
        } catch (Throwable e) {
            this.w.e(e);
        }
    }

    protected void d(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        if (hashMap != null) {
            IXAdInstanceInfo iXAdInstanceInfo = (IXAdInstanceInfo) hashMap.get("AdInstance");
            iXAdContainer = iXAdInstanceInfo.getCreativeType();
            if (iXAdContainer == CreativeType.VIDEO || iXAdContainer == CreativeType.RM) {
                com.baidu.mobads.c.a.a().a(this.y, "383", iXAdInstanceInfo, this.x.d(), "processAdStart");
            }
        }
    }

    public d q() {
        return this.x;
    }

    public void g() {
        com.baidu.mobads.a.a.q = System.currentTimeMillis();
        if (this.h != null) {
            this.h.load();
        } else {
            this.w.e("container is null");
        }
    }

    public void a(boolean z, IXAdInstanceInfo iXAdInstanceInfo) {
        if (d(iXAdInstanceInfo)) {
            IXAdProdInfo d = this.x.d();
            Object[] objArr = new Object[1];
            StringBuilder stringBuilder = new StringBuilder("file_exist_");
            stringBuilder.append(z);
            objArr[0] = stringBuilder.toString();
            com.baidu.mobads.c.a.a().a(this.y, "383", iXAdInstanceInfo, d, objArr);
            if (!z) {
                a("开屏因为请求到未在wifi下缓存的视频广告跳过");
            }
        }
    }

    public boolean a(IXAdInstanceInfo iXAdInstanceInfo) {
        return d(iXAdInstanceInfo);
    }

    protected void e(IXAdContainer iXAdContainer, HashMap<String, Object> hashMap) {
        super.e(iXAdContainer, hashMap);
        if (hashMap != null) {
            try {
                if (TextUtils.isEmpty((String) hashMap.get("video_close_reason")) == null) {
                    com.baidu.mobads.c.a.a().a(this.y, "383", null, this.x.d(), "closead", r8);
                }
            } catch (IXAdContainer iXAdContainer2) {
                iXAdContainer2.printStackTrace();
            }
        }
    }

    public String b(IXAdInstanceInfo iXAdInstanceInfo) {
        if (c(iXAdInstanceInfo)) {
            return iXAdInstanceInfo.getMainPictureUrl();
        }
        return super.b(iXAdInstanceInfo);
    }

    public boolean e(IXAdInstanceInfo iXAdInstanceInfo) {
        if (c(iXAdInstanceInfo) == null) {
            if (e() == null) {
                return null;
            }
        }
        return true;
    }

    protected void a() {
        if (e()) {
            this.A = XAdSDKFoundationFacade.getInstance().getIoUtils().getStoreagePath(this.y);
            this.B = XAdSDKFoundationFacade.getInstance().getCommonUtils().md5("http://mobads.baidu.com/ads/img/3d_bg.jpg");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.A);
            stringBuilder.append(this.B);
            File file = new File(stringBuilder.toString());
            try {
                URL url = new URL("http://mobads.baidu.com/ads/img/3d_bg.jpg");
                if (a(file, url)) {
                    ((XAdInstanceInfo) this.d).setSplash3DLocalUrl(null);
                    IOAdDownloader fVar = new f(this.y, url, this.A, this.B, false);
                    fVar.addObserver(this.F);
                    fVar.start();
                    return;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.A);
                stringBuilder2.append(this.B);
                f(stringBuilder2.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
    }

    private void f(String str) {
        ((XAdInstanceInfo) this.d).setSplash3DLocalUrl(str);
        if (e() == null || TextUtils.isEmpty(((XAdInstanceInfo) this.d).getLocalCreativeURL()) == null) {
            b("splash back pic ready");
        } else {
            this.w.e("zip pic no download");
        }
    }

    private boolean a(File file, URL url) {
        if (file.exists()) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("HEAD");
                int parseInt = Integer.parseInt(httpURLConnection.getHeaderField("content-length"));
                httpURLConnection.disconnect();
                if (parseInt > 0 && file.length() == ((long) parseInt)) {
                    httpURLConnection.disconnect();
                    return null;
                }
            } catch (File file2) {
                file2.printStackTrace();
            }
        }
        return true;
    }

    public static boolean r() {
        return D;
    }

    public static void b(int i) {
        E = i;
    }
}
