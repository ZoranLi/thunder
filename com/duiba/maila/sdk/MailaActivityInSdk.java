package com.duiba.maila.sdk;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.duiba.maila.sdk.a.e;
import com.duiba.maila.sdk.util.c;
import com.duiba.maila.sdk.util.d;
import com.duiba.maila.sdk.util.h;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MailaActivityInSdk extends Activity {
    WebView a;
    ViewCore b;
    boolean c;
    public String d;
    public String e;
    String[] f;
    int g = 0;
    TextView h;
    ImageView i;
    Map<Integer, d> j;
    Handler k;
    private View l;
    private ProgressBar m;
    private WebViewClient n;
    private WebChromeClient o;
    private AtomicInteger p = new AtomicInteger(0);
    private String q = null;
    private String r = null;

    public class a implements LocationListener {
        final /* synthetic */ MailaActivityInSdk a;
        private Activity b;

        public final void onProviderDisabled(String str) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public a(MailaActivityInSdk mailaActivityInSdk, Context context) {
            this.a = mailaActivityInSdk;
            this.b = (Activity) context;
        }

        public final void onLocationChanged(Location location) {
            this.a.a.post(new l(this, com.alibaba.fastjson.a.toJSONString(new com.duiba.maila.sdk.util.a(this.b, new c(location)))));
        }
    }

    public class b implements LocationListener {
        Activity a;
        final /* synthetic */ MailaActivityInSdk b;

        public final void onLocationChanged(Location location) {
        }

        public final void onProviderDisabled(String str) {
        }

        public final void onProviderEnabled(String str) {
        }

        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public b(MailaActivityInSdk mailaActivityInSdk, Context context) {
            this.b = mailaActivityInSdk;
            this.a = (Activity) context;
        }
    }

    protected void onCreate(android.os.Bundle r12) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r11 = this;
        super.onCreate(r12);
        r12 = com.duiba.maila.sdk.R.layout.activity_maila_in_sdk;
        r11.setContentView(r12);
        r12 = android.os.Build.VERSION.SDK_INT;
        r0 = 19;
        if (r12 < r0) goto L_0x0017;
    L_0x000e:
        r12 = r11.getWindow();	 Catch:{ Exception -> 0x0017 }
        r0 = 16777216; // 0x1000000 float:2.3509887E-38 double:8.289046E-317;	 Catch:{ Exception -> 0x0017 }
        r12.setFlags(r0, r0);	 Catch:{ Exception -> 0x0017 }
    L_0x0017:
        r12 = com.duiba.maila.sdk.R.id.webView;
        r12 = r11.findViewById(r12);
        r12 = (android.webkit.WebView) r12;
        r11.a = r12;
        r12 = com.duiba.maila.sdk.R.id.browser_controller_title;
        r12 = r11.findViewById(r12);
        r12 = (android.widget.TextView) r12;
        r11.h = r12;
        r12 = com.duiba.maila.sdk.R.id.browser_controller_back;
        r12 = r11.findViewById(r12);
        r12 = (android.widget.ImageView) r12;
        r11.i = r12;
        r12 = com.duiba.maila.sdk.R.layout.activity_url_error;
        r0 = 0;
        r12 = android.view.View.inflate(r11, r12, r0);
        r11.l = r12;
        r12 = new android.os.Handler;
        r12.<init>();
        r11.k = r12;
        r12 = new com.duiba.maila.sdk.ViewCore;
        r12.<init>(r11);
        r11.b = r12;
        r12 = new java.util.TreeMap;
        r12.<init>();
        r11.j = r12;
        r12 = com.duiba.maila.sdk.util.h.a;
        r0 = "exp";
        r12 = com.duiba.maila.sdk.util.b.a(r11, r12, r0);
        r11.d = r12;
        r12 = r11.d;
        r0 = 0;
        if (r12 == 0) goto L_0x007a;
    L_0x0062:
        r12 = r11.d;
        r12 = r12.length();
        if (r12 <= 0) goto L_0x007a;
    L_0x006a:
        r12 = r11.d;
        r1 = "\\|\\|\\|";
        r12 = r12.split(r1);
        r11.f = r12;
        r12 = r11.f;
        r12 = r12.length;
        r11.g = r12;
        goto L_0x0080;
    L_0x007a:
        r12 = new java.lang.String[r0];
        r11.f = r12;
        r11.g = r0;
    L_0x0080:
        r12 = r11.getPackageManager();
        r1 = r11.getPackageName();	 Catch:{ NameNotFoundException -> 0x00a3 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x00a3 }
        r12 = r12.getApplicationInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x00a3 }
        r1 = r12.metaData;	 Catch:{ NameNotFoundException -> 0x00a3 }
        r2 = "MAILA_APPKEY";	 Catch:{ NameNotFoundException -> 0x00a3 }
        r1 = r1.getString(r2);	 Catch:{ NameNotFoundException -> 0x00a3 }
        r11.q = r1;	 Catch:{ NameNotFoundException -> 0x00a3 }
        r12 = r12.metaData;	 Catch:{ NameNotFoundException -> 0x00a3 }
        r1 = "MAILA_APPID";	 Catch:{ NameNotFoundException -> 0x00a3 }
        r12 = r12.getString(r1);	 Catch:{ NameNotFoundException -> 0x00a3 }
        r11.r = r12;	 Catch:{ NameNotFoundException -> 0x00a3 }
        goto L_0x00a7;
    L_0x00a3:
        r12 = move-exception;
        r12.printStackTrace();
    L_0x00a7:
        r12 = com.duiba.maila.sdk.R.id.mProgressBar;
        r12 = r11.findViewById(r12);
        r12 = (android.widget.ProgressBar) r12;
        r11.m = r12;
        r12 = r11.i;
        r1 = new com.duiba.maila.sdk.e;
        r1.<init>(r11);
        r12.setOnClickListener(r1);
        r12 = r11.a;
        r12 = r12.getSettings();
        r1 = 1;
        r12.setJavaScriptEnabled(r1);
        r2 = "UTF-8";
        r12.setDefaultTextEncodingName(r2);
        r2 = 2;
        r12.setCacheMode(r2);
        r12.setBuiltInZoomControls(r0);
        r12.setUseWideViewPort(r1);
        r12.setLoadWithOverviewMode(r1);
        r12.setSupportZoom(r0);
        r12.setDomStorageEnabled(r1);
        r12.setLoadsImagesAutomatically(r1);
        r12 = r11.a;
        r12.setScrollContainer(r0);
        r12 = r11.a;
        r12.setVerticalScrollBarEnabled(r0);
        r12 = r11.a;
        r12.setHorizontalScrollBarEnabled(r0);
        r12 = new com.duiba.maila.sdk.f;
        r12.<init>(r11);
        r11.o = r12;
        r12 = r11.a;
        r0 = r11.o;
        r12.setWebChromeClient(r0);
        r12 = new com.duiba.maila.sdk.g;
        r12.<init>(r11);
        r11.n = r12;
        r12 = r11.a;
        r0 = r11.n;
        r12.setWebViewClient(r0);
        r12 = r11.a;
        r0 = new com.duiba.maila.sdk.MailaActivityInSdk$b;
        r0.<init>(r11, r11);
        r1 = "MailaSDK";
        r12.addJavascriptInterface(r0, r1);
        r12 = r11.a;
        r0 = new com.duiba.maila.sdk.MailaActivityInSdk$a;
        r0.<init>(r11, r11);
        r1 = "Android";
        r12.addJavascriptInterface(r0, r1);
        r12 = r11.getIntent();
        r0 = "app_id";
        r12 = r12.getStringExtra(r0);
        r0 = r11.getIntent();
        r1 = "url";
        r0 = r0.getStringExtra(r1);
        r1 = r11.getIntent();
        r2 = "type";
        r3 = 5;
        r1 = r1.getIntExtra(r2, r3);
        r3 = r11.a;
        r4 = r11.n;
        r5 = r11.o;
        r10 = new com.duiba.maila.sdk.MailaActivityInSdk$1;
        r10.<init>(r11);
        switch(r1) {
            case 0: goto L_0x023c;
            case 1: goto L_0x020b;
            case 2: goto L_0x01da;
            case 3: goto L_0x01ad;
            case 4: goto L_0x0180;
            case 5: goto L_0x0152;
            default: goto L_0x0150;
        };
    L_0x0150:
        goto L_0x026d;
    L_0x0152:
        r7 = new com.alibaba.baichuan.android.trade.model.a;
        r1 = com.alibaba.baichuan.android.trade.model.OpenType.H5;
        r7.<init>(r1);
        r8 = new com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
        r1 = "";
        r2 = "";
        r8.<init>(r12, r1, r2);
        r9 = new java.util.HashMap;
        r9.<init>();
        r12 = "isv_code";
        r1 = "appisvcode";
        r9.put(r12, r1);
        r12 = "alibaba";
        r1 = "阿里巴巴";
        r9.put(r12, r1);
        r6 = new com.alibaba.baichuan.android.trade.g.f;
        r6.<init>(r0);
        r2 = r11;
        com.alibaba.baichuan.android.trade.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        goto L_0x026d;
    L_0x0180:
        r6 = new com.alibaba.baichuan.android.trade.g.d;
        r6.<init>();
        r7 = new com.alibaba.baichuan.android.trade.model.a;
        r0 = com.alibaba.baichuan.android.trade.model.OpenType.H5;
        r7.<init>(r0);
        r8 = new com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
        r0 = "";
        r1 = "";
        r8.<init>(r12, r0, r1);
        r9 = new java.util.HashMap;
        r9.<init>();
        r12 = "isv_code";
        r0 = "appisvcode";
        r9.put(r12, r0);
        r12 = "alibaba";
        r0 = "阿里巴巴";
        r9.put(r12, r0);
        r2 = r11;
        com.alibaba.baichuan.android.trade.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L_0x01ad:
        r6 = new com.alibaba.baichuan.android.trade.g.e;
        r6.<init>();
        r7 = new com.alibaba.baichuan.android.trade.model.a;
        r0 = com.alibaba.baichuan.android.trade.model.OpenType.H5;
        r7.<init>(r0);
        r8 = new com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
        r0 = "";
        r1 = "";
        r8.<init>(r12, r0, r1);
        r9 = new java.util.HashMap;
        r9.<init>();
        r12 = "isv_code";
        r0 = "appisvcode";
        r9.put(r12, r0);
        r12 = "alibaba";
        r0 = "阿里巴巴";
        r9.put(r12, r0);
        r2 = r11;
        com.alibaba.baichuan.android.trade.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L_0x01da:
        r6 = new com.alibaba.baichuan.android.trade.g.g;
        r0 = r0.toString();
        r6.<init>(r0);
        r7 = new com.alibaba.baichuan.android.trade.model.a;
        r0 = com.alibaba.baichuan.android.trade.model.OpenType.H5;
        r7.<init>(r0);
        r8 = new com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
        r0 = "";
        r1 = "";
        r8.<init>(r12, r0, r1);
        r9 = new java.util.HashMap;
        r9.<init>();
        r12 = "isv_code";
        r0 = "appisvcode";
        r9.put(r12, r0);
        r12 = "alibaba";
        r0 = "阿里巴巴";
        r9.put(r12, r0);
        r2 = r11;
        com.alibaba.baichuan.android.trade.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L_0x020b:
        r6 = new com.alibaba.baichuan.android.trade.g.a;
        r0 = r0.trim();
        r6.<init>(r0);
        r7 = new com.alibaba.baichuan.android.trade.model.a;
        r0 = com.alibaba.baichuan.android.trade.model.OpenType.H5;
        r7.<init>(r0);
        r8 = new com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
        r0 = "";
        r1 = "";
        r8.<init>(r12, r0, r1);
        r9 = new java.util.HashMap;
        r9.<init>();
        r12 = "isv_code";
        r0 = "appisvcode";
        r9.put(r12, r0);
        r12 = "alibaba";
        r0 = "阿里巴巴";
        r9.put(r12, r0);
        r2 = r11;
        com.alibaba.baichuan.android.trade.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L_0x023c:
        r6 = new com.alibaba.baichuan.android.trade.g.c;
        r0 = r0.trim();
        r6.<init>(r0);
        r7 = new com.alibaba.baichuan.android.trade.model.a;
        r0 = com.alibaba.baichuan.android.trade.model.OpenType.H5;
        r7.<init>(r0);
        r8 = new com.alibaba.baichuan.android.trade.model.AlibcTaokeParams;
        r0 = "";
        r1 = "";
        r8.<init>(r12, r0, r1);
        r9 = new java.util.HashMap;
        r9.<init>();
        r12 = "isv_code";
        r0 = "appisvcode";
        r9.put(r12, r0);
        r12 = "alibaba";
        r0 = "阿里巴巴";
        r9.put(r12, r0);
        r2 = r11;
        com.alibaba.baichuan.android.trade.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
        return;
    L_0x026d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duiba.maila.sdk.MailaActivityInSdk.onCreate(android.os.Bundle):void");
    }

    protected final void a() {
        this.a.setVisibility(8);
        LinearLayout linearLayout = (LinearLayout) this.a.getParent();
        while (linearLayout.getChildCount() > 1) {
            linearLayout.removeViewAt(0);
        }
        this.l.setVisibility(0);
        ((RelativeLayout) this.l.findViewById(R.id.online_error_btn_retry)).setOnClickListener(new h(this));
        linearLayout.addView(this.l, 0, new LayoutParams(-1, -1));
    }

    public final void a(String str, WebView webView) {
        if (this.g > 0) {
            int i = 0;
            while (i < this.g) {
                String[] split = this.f[i].split("\\|&\\|");
                if (split.length >= 3) {
                    if (h.b(str, split[1])) {
                        d dVar = new d();
                        Integer valueOf = Integer.valueOf(this.p.getAndIncrement());
                        this.k.post(new i(this, valueOf, dVar));
                        dVar.a = split[0];
                        split = split[2].split("\\|;\\|");
                        int i2 = 0;
                        while (i2 < split.length) {
                            String[] split2 = split[i2].split("\\|=\\|");
                            String[] split3 = split2[0].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split3.length > 1) {
                                if (split2.length > 1) {
                                    String str2;
                                    String str3;
                                    StringBuilder stringBuilder;
                                    if (split3[1].equals(com.xunlei.downloadprovider.download.tasklist.list.feed.e.c.a)) {
                                        str2 = split2[1];
                                        str3 = split3[0];
                                        stringBuilder = new StringBuilder("javascript:var mlc_uuid=\"");
                                        stringBuilder.append(valueOf);
                                        stringBuilder.append("\";var mlc_key=\"");
                                        stringBuilder.append(str3);
                                        stringBuilder.append("\";var mlc_name=\"");
                                        stringBuilder.append(str2);
                                        stringBuilder.append("\";var mlc_value=\"\";var mlc_arr,mlc_reg=new RegExp(\"(^|)\"+mlc_name+\"=([^;]*)(;|$)\");if(mlc_arr=document.cookie.match(mlc_reg)){mlc_value=mlc_arr[2];};window.MailaSDK.notifyContent(mlc_uuid,mlc_key, mlc_value);");
                                        webView.loadUrl(stringBuilder.toString());
                                    } else if (split3[1].equals(IXAdRequestInfo.HEIGHT)) {
                                        str2 = split2[1];
                                        str3 = split3[0];
                                        stringBuilder = new StringBuilder("javascript:var dm_uuid=");
                                        stringBuilder.append(valueOf);
                                        stringBuilder.append(";var dm_sel = '");
                                        stringBuilder.append(str2);
                                        stringBuilder.append("';var dm_key ='");
                                        stringBuilder.append(str3);
                                        stringBuilder.append("';eval(function(p,a,c,k,e,d){e=function(c){return(c<a?\"\":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\\\b'+e(c)+'\\\\b','g'),k[c]);return p;}('3 4=8.9(a);3 2=\\'\\';5(3 1=0;1<4.7;1++){b(1>0){2+=\\'|,|\\'}2+=4[1].c}d.e.f(g,6,2);',17,17,'|i|dm_values|var|dm_elements|for|dm_key|length|document|querySelectorAll|dm_sel|if|innerText|window|MailaSDK|notifyContent|mlc_uuid'.split('|'),0,{}))");
                                        webView.loadUrl(stringBuilder.toString());
                                    } else if (split3[1].equals("u")) {
                                        this.k.post(new j(this, valueOf, split3[0], str));
                                    } else if (split3[1].equals("p")) {
                                        str2 = split2[1];
                                        str3 = split3[0];
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(str2);
                                        stringBuilder.append("=");
                                        split2 = str.split(stringBuilder.toString());
                                        if (split2.length >= 2) {
                                            this.k.post(new k(this, valueOf, str3, split2[1].split("&")));
                                        } else {
                                            return;
                                        }
                                    } else if (split3[1].equals("po")) {
                                        str2 = split2[1];
                                        str3 = split3[0];
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(str2);
                                        stringBuilder.append("=");
                                        split2 = str.split(stringBuilder.toString());
                                        if (split2.length >= 2) {
                                            this.k.post(new c(this, valueOf, str3, split2[1].split("&")));
                                        } else {
                                            return;
                                        }
                                    } else {
                                        continue;
                                    }
                                    i2++;
                                }
                            }
                            return;
                        }
                        continue;
                    }
                    this.k.post(new d(this));
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public void finish() {
        JSONObject b = b();
        String str = "";
        try {
            str = b.getString("infos");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!str.equals("[]")) {
            com.duiba.maila.sdk.a.c cVar = new com.duiba.maila.sdk.a.c(b.toString());
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new com.duiba.maila.sdk.a.d[]{cVar});
            com.duiba.maila.sdk.util.b.a(this, h.a, "json", "");
        }
        com.alibaba.baichuan.android.trade.b.a();
        super.finish();
    }

    public final com.alibaba.fastjson.JSONObject b() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r0 = new com.alibaba.fastjson.JSONObject;
        r0.<init>();
        r1 = "SDKgetFeild";
        r2 = "SDK_GET_FEILD";
        r1 = com.duiba.maila.sdk.util.b.a(r8, r1, r2);
        r1 = com.alibaba.fastjson.a.parseObject(r1);
        r2 = new com.duiba.maila.sdk.util.i;
        r2.<init>(r8);
        r2 = r2.a;
        r3 = "device_id";	 Catch:{ Exception -> 0x003d }
        r0.put(r3, r2);	 Catch:{ Exception -> 0x003d }
        if (r1 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x003d }
    L_0x001f:
        r2 = r1.keySet();	 Catch:{ Exception -> 0x003d }
        r2 = r2.iterator();	 Catch:{ Exception -> 0x003d }
    L_0x0027:
        r3 = r2.hasNext();	 Catch:{ Exception -> 0x003d }
        if (r3 == 0) goto L_0x0041;	 Catch:{ Exception -> 0x003d }
    L_0x002d:
        r3 = r2.next();	 Catch:{ Exception -> 0x003d }
        r4 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x003d }
        r3 = r1.get(r3);	 Catch:{ Exception -> 0x003d }
        r0.put(r4, r3);	 Catch:{ Exception -> 0x003d }
        goto L_0x0027;
    L_0x003d:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0041:
        r1 = new com.alibaba.fastjson.JSONArray;
        r1.<init>();
        r2 = r8.j;
        r2 = r2.entrySet();
        r2 = r2.iterator();
    L_0x0050:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x00b8;
    L_0x0056:
        r3 = r2.next();
        r3 = (java.util.Map.Entry) r3;
        r4 = new com.alibaba.fastjson.JSONObject;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r4.<init>();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r5 = "type";	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r6 = r3.getValue();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r6 = (com.duiba.maila.sdk.util.d) r6;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r6 = r6.a;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r4.put(r5, r6);	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r5 = "ts";	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r6 = r3.getValue();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r6 = (com.duiba.maila.sdk.util.d) r6;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r6 = r6.b;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r4.put(r5, r6);	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r5 = new com.alibaba.fastjson.JSONObject;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r5.<init>();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r3 = r3.getValue();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r3 = (com.duiba.maila.sdk.util.d) r3;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r3 = r3.c;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r3 = r3.entrySet();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r3 = r3.iterator();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
    L_0x0090:
        r6 = r3.hasNext();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        if (r6 == 0) goto L_0x00aa;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
    L_0x0096:
        r6 = r3.next();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r6 = (java.util.Map.Entry) r6;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r7 = r6.getKey();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r7 = (java.lang.String) r7;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r6 = r6.getValue();	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r5.put(r7, r6);	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        goto L_0x0090;	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
    L_0x00aa:
        r3 = "params";	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r4.put(r3, r5);	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        r1.add(r4);	 Catch:{ JSONException -> 0x00b3, Exception -> 0x0050 }
        goto L_0x0050;
    L_0x00b3:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0050;
    L_0x00b8:
        r2 = "infos";	 Catch:{ JSONException -> 0x00be }
        r0.put(r2, r1);	 Catch:{ JSONException -> 0x00be }
        goto L_0x00c2;
    L_0x00be:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x00c2:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duiba.maila.sdk.MailaActivityInSdk.b():com.alibaba.fastjson.JSONObject");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.a.canGoBack()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.a.goBack();
        return true;
    }
}
