package com.xunlei.downloadprovider.web.browser.a.a;

import android.support.annotation.Nullable;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.xunlei.downloadprovider.app.BrothersApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdBlockConfig */
public final class b implements a {
    private static final b b = new b();
    private static String c;
    public HashMap<String, Collection<String>> a = new HashMap(2);

    /* compiled from: AdBlockConfig */
    private static class a {
        private String a;
        private InputStream b;

        a(InputStream inputStream) {
            this.b = inputStream;
        }

        a(File file) {
            if (file.exists()) {
                try {
                    this.b = new FileInputStream(file);
                } catch (File file2) {
                    file2.printStackTrace();
                }
            }
        }

        public final JSONObject a() {
            if (this.a != null) {
                try {
                    return new JSONObject(this.a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        public final a b() {
            Exception e;
            Throwable th;
            if (this.b == null) {
                return this;
            }
            InputStreamReader inputStreamReader;
            try {
                inputStreamReader = new InputStreamReader(this.b, "UTF-8");
                try {
                    StringBuilder stringBuilder = new StringBuilder(1024);
                    char[] cArr = new char[4096];
                    for (int read = inputStreamReader.read(cArr); read > 0; read = inputStreamReader.read(cArr)) {
                        stringBuilder.append(cArr, 0, read);
                    }
                    this.a = stringBuilder.toString();
                    try {
                        this.b.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        try {
                            this.b.close();
                        } catch (IOException e22) {
                            e22.printStackTrace();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            this.b.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                try {
                    inputStreamReader.close();
                } catch (IOException e222) {
                    e222.printStackTrace();
                }
            } catch (Exception e6) {
                Exception exception = e6;
                inputStreamReader = null;
                e = exception;
                e.printStackTrace();
                this.b.close();
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                return this;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                inputStreamReader = null;
                th = th4;
                this.b.close();
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                throw th;
            }
            return this;
        }
    }

    /* compiled from: AdBlockConfig */
    private static class b {
        static File a() {
            return new File(BrothersApplication.getApplicationInstance().getCacheDir(), "adblock_blacklist.json");
        }
    }

    public static b a() {
        return b;
    }

    @Nullable
    private static JSONObject c() {
        try {
            File a = b.a();
            if (a.exists() && a.canRead()) {
                return new a(a).b().a();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        InputStream inputStream = null;
        try {
            inputStream = b("shoulei/adblock/blacklist.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new a(inputStream).b().a();
    }

    public final b b() {
        JSONObject c = c();
        if (c != null) {
            c = c.optJSONObject(com.taobao.accs.internal.b.ELECTION_KEY_BLACKLIST);
            if (c != null) {
                Iterator keys = c.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    JSONObject optJSONObject = c.optJSONObject(str);
                    if (optJSONObject != null) {
                        HashSet hashSet = new HashSet(2);
                        JSONArray optJSONArray = optJSONObject.optJSONArray("blackwords");
                        if (optJSONArray != null) {
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                if (optJSONArray.optString(i, null) != null) {
                                    hashSet.add(optJSONArray.optString(i));
                                }
                            }
                        }
                        if (!hashSet.isEmpty()) {
                            this.a.put(str, hashSet);
                        }
                    }
                }
            }
        }
        return this;
    }

    public final boolean a(java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 0;
        if (r0 != 0) goto L_0x0044;
    L_0x0007:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        goto L_0x0044;
    L_0x000e:
        r5 = android.net.Uri.parse(r5);	 Catch:{ Exception -> 0x0043 }
        r0 = r3.a;	 Catch:{ Exception -> 0x0043 }
        r2 = r5.getHost();	 Catch:{ Exception -> 0x0043 }
        r0 = r0.containsKey(r2);	 Catch:{ Exception -> 0x0043 }
        if (r0 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x0043 }
    L_0x001e:
        return r1;	 Catch:{ Exception -> 0x0043 }
    L_0x001f:
        r0 = r3.a;	 Catch:{ Exception -> 0x0043 }
        r5 = r5.getHost();	 Catch:{ Exception -> 0x0043 }
        r5 = r0.get(r5);	 Catch:{ Exception -> 0x0043 }
        r5 = (java.util.Collection) r5;	 Catch:{ Exception -> 0x0043 }
        r5 = r5.iterator();	 Catch:{ Exception -> 0x0043 }
    L_0x002f:
        r0 = r5.hasNext();	 Catch:{ Exception -> 0x0043 }
        if (r0 == 0) goto L_0x0043;	 Catch:{ Exception -> 0x0043 }
    L_0x0035:
        r0 = r5.next();	 Catch:{ Exception -> 0x0043 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x0043 }
        r0 = r4.contains(r0);	 Catch:{ Exception -> 0x0043 }
        if (r0 == 0) goto L_0x002f;
    L_0x0041:
        r4 = 1;
        return r4;
    L_0x0043:
        return r1;
    L_0x0044:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.browser.a.a.b.a(java.lang.String, java.lang.String):boolean");
    }

    public final WebResourceResponse a(String str) {
        WebResourceResponse webResourceResponse = null;
        if (str.startsWith("http://static.m.sjzhushou.com/pss/static/android/blockads.js") == null) {
            return null;
        }
        try {
            webResourceResponse = new WebResourceResponse("text/javascript", "UTF-8", b("shoulei/adblock/blockads.js"));
        } catch (String str2) {
            str2.printStackTrace();
        }
        return webResourceResponse;
    }

    private static InputStream b(String str) throws IOException {
        return BrothersApplication.getApplicationInstance().getAssets().open(str);
    }

    public final void a(WebView webView) {
        String str;
        if (c != null) {
            str = c;
        } else {
            str = String.format(Locale.getDefault(), "(function() {\n    var e = document.createElement('script');\n    e.src = \"%s\";\n    var head = document.getElementsByTagName(\"head\")[0];\n    head.appendChild(e);\n})();", new Object[]{"http://static.m.sjzhushou.com/pss/static/android/blockads.js"});
            c = str;
        }
        com.xunlei.downloadprovider.web.browser.a.a.a(webView, str);
    }
}
