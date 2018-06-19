package com.alibaba.sdk.android.feedback.xblink.webview;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.webkit.CookieManager;
import android.webkit.WebBackForwardList;
import com.alibaba.sdk.android.feedback.xblink.b.b;
import com.alibaba.sdk.android.feedback.xblink.c.a;
import com.alibaba.sdk.android.feedback.xblink.c.j;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.alibaba.sdk.android.feedback.xblink.i.h;
import com.alipay.sdk.packet.d;
import com.taobao.accs.common.Constants;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class HybridPlusWebView extends XBHybridWebView implements Callback, j {
    public static final String CHARSET = "charset";
    public static final int DOMREADY = 1016;
    public static final String HTML_CONTENT = "html_content";
    public static final String HTTPSVERIFYERROR = "httpsverifyerror";
    public static final int HTTPS_CERT_EXPIRED = -602;
    public static final int HTTPS_CERT_INVILD = -601;
    public static final int LOAD_BEGIN = 1011;
    public static final int LOAD_ERROR = 1013;
    public static final int LOAD_FINSH = 1012;
    public static final String MIMETYPE = "mimetype";
    public static final int PAGE_FINSH = 1015;
    private static String[] SUPPORTED_MIMETYPE = new String[]{"text/html", "text/plain", "application/xhtml+xml", "application/xml", "image/jpeg", "image/png", "image/webp", "image/gif"};
    private static String[] SUPPORTED_MIMETYPE_CONFIG = null;
    private static final String TAG = "HybridPlusWebView";
    public static final int UNSUPPORTED_MIMETYPE = -400;
    public static final int URL_HITTED = 1014;
    public static final String WEBVIEW_MIMETYPE = "webview_mimetype";
    private final int HTML_FINSH = 200;
    private long beginTime = 0;
    private a htmlDownloader;
    private boolean isLoading;
    private boolean isReload;
    private boolean needDomReady;
    private Map requestHeaders = null;
    private c sslErrorListener;
    private int token;
    private String url;

    public HybridPlusWebView(Context context) {
        super(context);
        init();
    }

    public HybridPlusWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public HybridPlusWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private String addDomReady(String str) {
        if (str == null) {
            return null;
        }
        if (str.indexOf("window.WindVane.call('WVPlusWebView','htmlFinsh',{});\n") != -1) {
            return str;
        }
        int indexOf = str.indexOf("</body>");
        if (indexOf == -1) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.substring(0, indexOf));
        stringBuilder.append("<script type=\"text/javascript\" src=\"http://g.tbcdn.cn/mtb/lib-windvane/1.2.4/bridge.js\"></script>");
        stringBuilder.append("<script type=\"text/javascript\">document.addEventListener( \"DOMContentLoaded\", function() { window.WindVane.call('WVPlusWebView','htmlFinsh',{}); }, false ); </script>");
        stringBuilder.append(str.substring(indexOf));
        return stringBuilder.toString();
    }

    private void init() {
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
        r6 = this;
        r0 = 0;
        r6.token = r0;
        r1 = 1;
        r6.needDomReady = r1;
        r1 = "WVPlusWebView";
        r2 = new com.alibaba.sdk.android.feedback.xblink.webview.b;
        r3 = 0;
        r2.<init>(r6, r3);
        super.addJsObject(r1, r2);
        r1 = SUPPORTED_MIMETYPE_CONFIG;
        if (r1 != 0) goto L_0x0075;
    L_0x0015:
        r1 = r6.context;
        r2 = "webview_mimetype";
        r1 = r1.getSharedPreferences(r2, r0);
        r2 = "";
        r4 = "webview_mimetype";	 Catch:{ ClassCastException -> 0x0028 }
        r5 = "";	 Catch:{ ClassCastException -> 0x0028 }
        r1 = r1.getString(r4, r5);	 Catch:{ ClassCastException -> 0x0028 }
        goto L_0x003c;
    L_0x0028:
        r1 = "HybridPlusWebView";
        r4 = new java.lang.StringBuilder;
        r5 = "get mimeType ClassCastException:";
        r4.<init>(r5);
        r4.append(r2);
        r4 = r4.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r4);
        r1 = r2;
    L_0x003c:
        r2 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r2 == 0) goto L_0x0055;
    L_0x0042:
        r2 = "HybridPlusWebView";
        r4 = new java.lang.StringBuilder;
        r5 = "support mimetype:";
        r4.<init>(r5);
        r4.append(r1);
        r4 = r4.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r2, r4);
    L_0x0055:
        r2 = ";";
        r1 = r1.split(r2);
        SUPPORTED_MIMETYPE_CONFIG = r1;
        if (r1 == 0) goto L_0x0073;
    L_0x005f:
        r1 = SUPPORTED_MIMETYPE_CONFIG;
        r1 = r1.length;
        if (r1 <= 0) goto L_0x0073;
    L_0x0064:
        r1 = SUPPORTED_MIMETYPE_CONFIG;
        r0 = r1[r0];
        r0 = r0.length();
        if (r0 <= 0) goto L_0x0073;
    L_0x006e:
        r0 = SUPPORTED_MIMETYPE_CONFIG;
        SUPPORTED_MIMETYPE = r0;
        return;
    L_0x0073:
        SUPPORTED_MIMETYPE_CONFIG = r3;
    L_0x0075:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView.init():void");
    }

    private void loadUrl(String str, Map map, boolean z) {
        if (this.isAlive) {
            boolean z2 = str != null && str.equals(this.url);
            this.isReload = z2;
            if (str == null || !(str.toLowerCase().startsWith("data:") || str.toLowerCase().startsWith("javascript:") || str.toLowerCase().startsWith("file:"))) {
                if (this.htmlDownloader != null) {
                    this.htmlDownloader.a();
                    this.htmlDownloader.b();
                    this.htmlDownloader.a(null);
                }
                this.token++;
                this.url = str;
                this.isLoading = true;
                this.requestHeaders = null;
                if (map != null) {
                    this.requestHeaders = new HashMap(map);
                }
                this.htmlDownloader = new a(getSettings().getUserAgentString(), this, this.requestHeaders, str, this.token, z);
                new Thread(this.htmlDownloader).start();
                if (this.webViewClient != null && this.isAlive) {
                    this.webViewClient.onPageStarted(this, str, null);
                }
                this.beginTime = System.currentTimeMillis();
                return;
            }
            super.loadUrl(str);
        }
    }

    public boolean back() {
        if (!this.isAlive || !canGoBack()) {
            return false;
        }
        goBack();
        return true;
    }

    public void callback(byte[] bArr, Map map, int i) {
        if (i == this.token) {
            String str;
            Message obtain = Message.obtain();
            obtain.arg1 = i;
            if (map.containsKey(HTTPSVERIFYERROR)) {
                int i2;
                str = (String) map.get(HTTPSVERIFYERROR);
                if (str.equals("EXPIRED")) {
                    i2 = HTTPS_CERT_EXPIRED;
                } else if (str.equals("INVALID")) {
                    i2 = HTTPS_CERT_INVILD;
                }
                obtain.what = i2;
                obtain.obj = map;
                this.mHandler.sendMessage(obtain);
            }
            str = (String) map.get(d.d);
            String str2 = "";
            if (!TextUtils.isEmpty(str)) {
                for (CharSequence charSequence : SUPPORTED_MIMETYPE) {
                    if (str.toLowerCase().contains(charSequence)) {
                        map.put("mimetype", charSequence);
                        str2 = charSequence;
                        break;
                    }
                }
            }
            String encodeToString;
            if (str == null || !TextUtils.isEmpty(str2)) {
                if (bArr != null) {
                    Object str3;
                    str = (String) map.get("charset");
                    if (str2.equalsIgnoreCase("text/html")) {
                        try {
                            str3 = new String(bArr, str);
                        } catch (UnsupportedEncodingException e) {
                            g.b(TAG, String.valueOf(e));
                            str3 = null;
                        }
                        if (this.needDomReady) {
                            str3 = addDomReady(str3);
                        }
                    } else if (str2.startsWith("image")) {
                        encodeToString = Base64.encodeToString(bArr, 0);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("<img src=\"data:");
                        stringBuilder.append(str2);
                        stringBuilder.append(";base64,");
                        stringBuilder.append(encodeToString);
                        stringBuilder.append("\"/>");
                        map.put("mimetype", "text/html");
                        map.put(HTML_CONTENT, stringBuilder.toString());
                    } else {
                        try {
                            str3 = new String(bArr, str);
                        } catch (UnsupportedEncodingException e2) {
                            g.b(TAG, String.valueOf(e2));
                            str3 = null;
                        }
                    }
                    map.put(HTML_CONTENT, str3);
                }
                encodeToString = (String) map.get("set-cookie");
                if (encodeToString != null) {
                    CookieManager instance = CookieManager.getInstance();
                    if (instance.acceptCookie()) {
                        instance.setCookie(this.url, encodeToString);
                    }
                }
                obtain.what = 200;
                obtain.obj = map;
                this.mHandler.sendMessage(obtain);
            } else {
                if (g.a()) {
                    encodeToString = TAG;
                    StringBuilder stringBuilder2 = new StringBuilder("unsupport minitype:");
                    stringBuilder2.append(str);
                    g.a(encodeToString, stringBuilder2.toString());
                }
                obtain.what = -400;
                obtain.obj = map.get("url");
                this.mHandler.sendMessage(obtain);
            }
        }
    }

    public void destroy() {
        if (this.htmlDownloader != null) {
            this.htmlDownloader.a(null);
            this.htmlDownloader.b();
            this.htmlDownloader = null;
        }
        super.destroy();
    }

    public void enableDomReady(boolean z) {
        this.needDomReady = z;
    }

    public String getCurrentUrl() {
        String url = super.getUrl();
        if (!this.isLoading) {
            if (url != null) {
                return super.getUrl();
            }
        }
        return this.url;
    }

    public String getUrl() {
        return getCurrentUrl();
    }

    public void goBack() {
        if (this.isAlive) {
            this.token++;
            if (this.htmlDownloader != null) {
                this.htmlDownloader.a();
                this.htmlDownloader.b();
                this.htmlDownloader.a(null);
            }
            if (!this.isLoading || this.webViewClient == null) {
                if (canGoBack()) {
                    WebBackForwardList copyBackForwardList = copyBackForwardList();
                    String url = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() - 1).getUrl();
                    if (url != null) {
                        if (g.a()) {
                            String str = TAG;
                            StringBuilder stringBuilder = new StringBuilder("goBack: ");
                            stringBuilder.append(url);
                            g.a(str, stringBuilder.toString());
                        }
                        super.goBack();
                    }
                }
                return;
            }
            this.webViewClient.onPageFinished(this, getUrl());
        }
    }

    public void goBackOrForward(int i) {
        if (this.isAlive) {
            if (i != 0) {
                this.token++;
            }
            if (this.htmlDownloader != null) {
                this.htmlDownloader.a();
                this.htmlDownloader.b();
                this.htmlDownloader.a(null);
            }
            if (this.isLoading) {
                if (i < -1) {
                    i++;
                } else if (i < 0) {
                    if (this.webViewClient != null) {
                        this.webViewClient.onPageFinished(this, super.getUrl());
                    } else {
                        return;
                    }
                }
            }
            if (canGoBackOrForward(i)) {
                WebBackForwardList copyBackForwardList = copyBackForwardList();
                String url = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i).getUrl();
                if (url != null && g.a()) {
                    String str = TAG;
                    StringBuilder stringBuilder = new StringBuilder("goBackOrForward: ");
                    stringBuilder.append(url);
                    g.a(str, stringBuilder.toString());
                }
                super.goBackOrForward(i);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r11) {
        /*
        r10 = this;
        super.handleMessage(r11);
        r0 = r11.what;
        r1 = -400; // 0xfffffffffffffe70 float:NaN double:NaN;
        r2 = 0;
        if (r0 == r1) goto L_0x0107;
    L_0x000a:
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3 = 1;
        if (r0 == r1) goto L_0x003f;
    L_0x000f:
        r11 = 1016; // 0x3f8 float:1.424E-42 double:5.02E-321;
        if (r0 == r11) goto L_0x002f;
    L_0x0013:
        switch(r0) {
            case -602: goto L_0x0023;
            case -601: goto L_0x0017;
            default: goto L_0x0016;
        };
    L_0x0016:
        return r2;
    L_0x0017:
        r11 = r10.sslErrorListener;
        if (r11 == 0) goto L_0x0022;
    L_0x001b:
        r11 = r10.sslErrorListener;
        r0 = -601; // 0xfffffffffffffda7 float:NaN double:NaN;
        r11.a(r0);
    L_0x0022:
        return r3;
    L_0x0023:
        r11 = r10.sslErrorListener;
        if (r11 == 0) goto L_0x002e;
    L_0x0027:
        r11 = r10.sslErrorListener;
        r0 = -602; // 0xfffffffffffffda6 float:NaN double:NaN;
        r11.a(r0);
    L_0x002e:
        return r3;
    L_0x002f:
        r11 = r10.isAlive;
        if (r11 == 0) goto L_0x003e;
    L_0x0033:
        r11 = r10.webViewClient;
        if (r11 == 0) goto L_0x003e;
    L_0x0037:
        r11 = r10.webViewClient;
        r0 = "DOMContentLoaded";
        r11.onPageFinished(r10, r0);
    L_0x003e:
        return r3;
    L_0x003f:
        r10.isLoading = r2;
        r0 = r10.token;
        r1 = r11.arg1;
        if (r0 != r1) goto L_0x0102;
    L_0x0047:
        r0 = r10.isAlive;
        if (r0 == 0) goto L_0x0102;
    L_0x004b:
        r11 = r11.obj;
        r11 = (java.util.Map) r11;
        r0 = "url";
        r0 = r11.get(r0);
        r9 = r0;
        r9 = (java.lang.String) r9;
        r0 = "response-code";
        r0 = r11.containsKey(r0);
        if (r0 == 0) goto L_0x006d;
    L_0x0060:
        r0 = "response-code";
        r0 = r11.get(r0);
        r0 = (java.lang.String) r0;
        r0 = java.lang.Integer.parseInt(r0);
        goto L_0x006e;
    L_0x006d:
        r0 = r2;
    L_0x006e:
        r1 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r1 == 0) goto L_0x0087;
    L_0x0074:
        r1 = "HybridPlusWebView";
        r4 = new java.lang.StringBuilder;
        r5 = "html_code:";
        r4.<init>(r5);
        r4.append(r0);
        r4 = r4.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.c(r1, r4);
    L_0x0087:
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r0 < r1) goto L_0x00a3;
    L_0x008d:
        if (r0 >= r4) goto L_0x00a3;
    L_0x008f:
        r1 = "location";
        r1 = r11.containsKey(r1);
        if (r1 == 0) goto L_0x00a3;
    L_0x0097:
        r0 = "location";
        r11 = r11.get(r0);
        r11 = (java.lang.String) r11;
        r10.loadUrl(r11);
        return r3;
    L_0x00a3:
        if (r0 != 0) goto L_0x00b5;
    L_0x00a5:
        r11 = r10.isAlive;
        if (r11 == 0) goto L_0x0102;
    L_0x00a9:
        r11 = r10.webViewClient;
        if (r11 == 0) goto L_0x0102;
    L_0x00ad:
        r11 = r10.webViewClient;
        r0 = "HTML下载失败";
        r11.onReceivedError(r10, r4, r0, r9);
        goto L_0x0102;
    L_0x00b5:
        r0 = "html_content";
        r0 = r11.get(r0);
        r6 = r0;
        r6 = (java.lang.String) r6;
        if (r6 == 0) goto L_0x00d8;
    L_0x00c0:
        r0 = "mimetype";
        r0 = r11.get(r0);
        r7 = r0;
        r7 = (java.lang.String) r7;
        r0 = "charset";
        r11 = r11.get(r0);
        r8 = r11;
        r8 = (java.lang.String) r8;
        r4 = r10;
        r5 = r9;
        super.loadDataWithBaseURL(r5, r6, r7, r8, r9);
        goto L_0x00e7;
    L_0x00d8:
        r11 = r10.isAlive;
        if (r11 == 0) goto L_0x00e7;
    L_0x00dc:
        r11 = r10.webViewClient;
        if (r11 == 0) goto L_0x00e7;
    L_0x00e0:
        r11 = r10.webViewClient;
        r0 = "HTML下载失败";
        r11.onReceivedError(r10, r4, r0, r9);
    L_0x00e7:
        r11 = "HybridPlusWebView";
        r0 = new java.lang.StringBuilder;
        r1 = "dom downloaded time:";
        r0.<init>(r1);
        r3 = java.lang.System.currentTimeMillis();
        r5 = r10.beginTime;
        r7 = r3 - r5;
        r0.append(r7);
        r0 = r0.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.c(r11, r0);
    L_0x0102:
        r11 = r10.htmlDownloader;
        if (r11 == 0) goto L_0x012b;
    L_0x0106:
        goto L_0x0126;
    L_0x0107:
        r10.isLoading = r2;
        r0 = r10.token;
        r3 = r11.arg1;
        if (r0 != r3) goto L_0x0122;
    L_0x010f:
        r0 = r10.isAlive;
        if (r0 == 0) goto L_0x0122;
    L_0x0113:
        r0 = r10.webViewClient;
        if (r0 == 0) goto L_0x0122;
    L_0x0117:
        r0 = r10.webViewClient;
        r3 = "unsupported mini type";
        r11 = r11.obj;
        r11 = (java.lang.String) r11;
        r0.onReceivedError(r10, r1, r3, r11);
    L_0x0122:
        r11 = r10.htmlDownloader;
        if (r11 == 0) goto L_0x012b;
    L_0x0126:
        r11 = r10.htmlDownloader;
        r11.b();
    L_0x012b:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.HybridPlusWebView.handleMessage(android.os.Message):boolean");
    }

    public void loadUrl(String str) {
        if (this.isAlive) {
            if (str.startsWith("http://m.taobao.com") || str.startsWith("https://m.taobao.com")) {
                str = h.a(str, Constants.KEY_TTID, b.a().b());
            }
            loadUrl(str, null, true);
        }
    }

    public void reload() {
        reload(false);
    }

    public void reload(boolean z) {
        if (this.isAlive) {
            String str;
            String url = super.getUrl();
            if (!this.isLoading) {
                if (url != null) {
                    super.reload();
                    if (g.a()) {
                        str = TAG;
                        StringBuilder stringBuilder = new StringBuilder("reload & post： ");
                        stringBuilder.append(url);
                        g.a(str, stringBuilder.toString());
                        return;
                    }
                }
            }
            loadUrl(this.url, this.requestHeaders, z);
            if (g.a()) {
                str = TAG;
                StringBuilder stringBuilder2 = new StringBuilder("reload & loading: ");
                stringBuilder2.append(this.url);
                g.a(str, stringBuilder2.toString());
            }
        }
    }

    public void setSslErrorListener(c cVar) {
        this.sslErrorListener = cVar;
    }

    public void stopLoading() {
        if (this.isAlive) {
            this.token++;
            if (this.htmlDownloader != null) {
                this.htmlDownloader.a();
                this.htmlDownloader.b();
                this.htmlDownloader.a(null);
            }
            super.stopLoading();
        }
    }
}
