package anet.channel.request;

import android.text.TextUtils;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.c;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";
    private String bizId;
    private BodyEntry body;
    private String charset;
    private int connectTimeout;
    private c formattedUrl;
    private Map<String, String> headers;
    private HostnameVerifier hostnameVerifier;
    private boolean isRedirectEnable;
    private String method;
    private c originUrl;
    private Map<String, String> params;
    private int readTimeout;
    private int redirectTimes;
    public final RequestStatistic rs;
    private c sendUrl;
    private String seq;
    private SSLSocketFactory sslSocketFactory;
    private URL url;

    /* compiled from: Taobao */
    public static class Builder {
        private String bizId;
        private BodyEntry body;
        private String charset;
        private int connectTimeout = 0;
        private c formattedUrl;
        private Map<String, String> headers = new HashMap();
        private HostnameVerifier hostnameVerifier;
        private boolean isRedirectEnable = true;
        private String method = "GET";
        private c originUrl;
        private Map<String, String> params;
        private int readTimeout = 0;
        private int redirectTimes = 0;
        private RequestStatistic rs = null;
        private String seq;
        private SSLSocketFactory sslSocketFactory;

        public Builder setUrl(c cVar) {
            this.originUrl = cVar;
            this.formattedUrl = null;
            return this;
        }

        public Builder setUrl(String str) {
            this.originUrl = c.a(str);
            this.formattedUrl = null;
            if (this.originUrl != null) {
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder("toURL is invalid! toURL = ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        public Builder setMethod(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("method is null or empty");
            }
            if (!"GET".equalsIgnoreCase(str)) {
                if ("POST".equalsIgnoreCase(str)) {
                    this.method = "POST";
                } else if ("OPTIONS".equalsIgnoreCase(str)) {
                    this.method = "OPTIONS";
                } else if ("HEAD".equalsIgnoreCase(str)) {
                    this.method = "HEAD";
                } else if ("PUT".equalsIgnoreCase(str)) {
                    this.method = "PUT";
                } else if ("DELETE".equalsIgnoreCase(str) != null) {
                    this.method = "DELETE";
                }
                return this;
            }
            this.method = "GET";
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.headers.clear();
            if (map != null) {
                this.headers.putAll(map);
            }
            return this;
        }

        public Builder addHeader(String str, String str2) {
            this.headers.put(str, str2);
            return this;
        }

        public Builder setParams(Map<String, String> map) {
            this.params = map;
            this.formattedUrl = null;
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.params == null) {
                this.params = new HashMap();
            }
            this.params.put(str, str2);
            this.formattedUrl = null;
            return this;
        }

        public Builder setCharset(String str) {
            this.charset = str;
            this.formattedUrl = null;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.body = bodyEntry;
            return this;
        }

        public Builder setRedirectEnable(boolean z) {
            this.isRedirectEnable = z;
            return this;
        }

        public Builder setRedirectTimes(int i) {
            this.redirectTimes = i;
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        public Builder setBizId(String str) {
            this.bizId = str;
            return this;
        }

        public Builder setSeq(String str) {
            this.seq = str;
            return this;
        }

        public Builder setReadTimeout(int i) {
            this.readTimeout = i;
            return this;
        }

        public Builder setConnectTimeout(int i) {
            this.connectTimeout = i;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.rs = requestStatistic;
            return this;
        }

        public Request build() {
            if (this.body == null && this.params == null && Method.requiresRequestBody(this.method)) {
                StringBuilder stringBuilder = new StringBuilder("method ");
                stringBuilder.append(this.method);
                stringBuilder.append(" must have a request body");
                ALog.e("awcn.Request", stringBuilder.toString(), null, new Object[0]);
            }
            if (!(this.body == null || Method.permitsRequestBody(this.method))) {
                stringBuilder = new StringBuilder("method ");
                stringBuilder.append(this.method);
                stringBuilder.append(" should not have a request body");
                ALog.e("awcn.Request", stringBuilder.toString(), null, new Object[0]);
                this.body = null;
            }
            if (!(this.body == null || this.body.getContentType() == null)) {
                addHeader("Content-Type", this.body.getContentType());
            }
            return new Request();
        }
    }

    /* compiled from: Taobao */
    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        static boolean requiresRequestBody(String str) {
            if (!str.equals("POST")) {
                if (str.equals("PUT") == null) {
                    return null;
                }
            }
            return true;
        }

        static boolean permitsRequestBody(String str) {
            if (!(requiresRequestBody(str) || str.equals("DELETE"))) {
                if (str.equals("OPTIONS") == null) {
                    return null;
                }
            }
            return true;
        }
    }

    private Request(Builder builder) {
        this.method = "GET";
        this.isRedirectEnable = true;
        this.redirectTimes = 0;
        this.connectTimeout = 10000;
        this.readTimeout = 10000;
        this.method = builder.method;
        this.headers = builder.headers;
        this.params = builder.params;
        this.body = builder.body;
        this.charset = builder.charset;
        this.isRedirectEnable = builder.isRedirectEnable;
        this.redirectTimes = builder.redirectTimes;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.bizId = builder.bizId;
        this.seq = builder.seq;
        this.connectTimeout = builder.connectTimeout;
        this.readTimeout = builder.readTimeout;
        this.originUrl = builder.originUrl;
        this.formattedUrl = builder.formattedUrl;
        if (this.formattedUrl == null) {
            formatUrl();
        }
        this.rs = builder.rs != null ? builder.rs : new RequestStatistic(getHost(), this.bizId);
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.method = this.method;
        builder.headers = this.headers;
        builder.params = this.params;
        builder.body = this.body;
        builder.charset = this.charset;
        builder.isRedirectEnable = this.isRedirectEnable;
        builder.redirectTimes = this.redirectTimes;
        builder.hostnameVerifier = this.hostnameVerifier;
        builder.sslSocketFactory = this.sslSocketFactory;
        builder.originUrl = this.originUrl;
        builder.formattedUrl = this.formattedUrl;
        builder.bizId = this.bizId;
        builder.seq = this.seq;
        builder.connectTimeout = this.connectTimeout;
        builder.readTimeout = this.readTimeout;
        builder.rs = this.rs;
        return builder;
    }

    public c getHttpUrl() {
        return this.formattedUrl;
    }

    public String getUrlString() {
        return this.formattedUrl.e();
    }

    public URL getUrl() {
        if (this.url == null) {
            this.url = (this.sendUrl != null ? this.sendUrl : this.formattedUrl).f();
        }
        return this.url;
    }

    public void setDnsOptimize(String str, int i) {
        if (str != null && i != 0) {
            if (this.sendUrl == null) {
                this.sendUrl = new c(this.formattedUrl);
            }
            this.sendUrl.a(str, i);
            this.rs.setIPAndPort(str, i);
            this.url = null;
        }
    }

    public void setUrlScheme(boolean z) {
        if (this.sendUrl == null) {
            this.sendUrl = new c(this.formattedUrl);
        }
        this.sendUrl.b(z ? "https" : HttpConstant.HTTP);
        this.url = false;
    }

    public int getRedirectTimes() {
        return this.redirectTimes;
    }

    public String getHost() {
        return this.formattedUrl.b();
    }

    public String getMethod() {
        return this.method;
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.headers);
    }

    public String getContentEncoding() {
        return this.charset != null ? this.charset : "UTF-8";
    }

    public boolean isRedirectEnable() {
        return this.isRedirectEnable;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public int postBody(OutputStream outputStream) throws IOException {
        return this.body != null ? this.body.writeTo(outputStream) : null;
    }

    public byte[] getBodyBytes() {
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
        r2 = this;
        r0 = r2.body;
        if (r0 == 0) goto L_0x0013;
    L_0x0004:
        r0 = new java.io.ByteArrayOutputStream;
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0.<init>(r1);
        r2.postBody(r0);	 Catch:{ IOException -> 0x000e }
    L_0x000e:
        r0 = r0.toByteArray();
        return r0;
    L_0x0013:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.request.Request.getBodyBytes():byte[]");
    }

    public boolean containsBody() {
        return this.body != null;
    }

    public String getBizId() {
        return this.bizId;
    }

    public String getSeq() {
        return this.seq;
    }

    public int getReadTimeout() {
        return this.readTimeout;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    private void formatUrl() {
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
        r5 = this;
        r0 = r5.params;
        r1 = r5.getContentEncoding();
        r0 = anet.channel.strategy.utils.d.b(r0, r1);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x0080;
    L_0x0010:
        r1 = r5.method;
        r1 = anet.channel.request.Request.Method.requiresRequestBody(r1);
        if (r1 == 0) goto L_0x0046;
    L_0x0018:
        r1 = r5.body;
        if (r1 == 0) goto L_0x001d;
    L_0x001c:
        goto L_0x0046;
    L_0x001d:
        r1 = new anet.channel.request.ByteArrayEntry;	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r2 = r5.getContentEncoding();	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r0 = r0.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r1.<init>(r0);	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r5.body = r1;	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r0 = r5.headers;	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r1 = "Content-Type";	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r2 = new java.lang.StringBuilder;	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r3 = "application/x-www-form-urlencoded; charset=";	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r2.<init>(r3);	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r3 = r5.getContentEncoding();	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r2.append(r3);	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r2 = r2.toString();	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        r0.put(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0080 }
        goto L_0x0080;
    L_0x0046:
        r1 = r5.originUrl;
        r1 = r1.e();
        r2 = new java.lang.StringBuilder;
        r2.<init>(r1);
        r3 = "?";
        r3 = r2.indexOf(r3);
        r4 = -1;
        if (r3 != r4) goto L_0x0060;
    L_0x005a:
        r1 = 63;
        r2.append(r1);
        goto L_0x0071;
    L_0x0060:
        r3 = r1.length();
        r3 = r3 + -1;
        r1 = r1.charAt(r3);
        r3 = 38;
        if (r1 == r3) goto L_0x0071;
    L_0x006e:
        r2.append(r3);
    L_0x0071:
        r2.append(r0);
        r0 = r2.toString();
        r0 = anet.channel.util.c.a(r0);
        if (r0 == 0) goto L_0x0080;
    L_0x007e:
        r5.formattedUrl = r0;
    L_0x0080:
        r0 = r5.formattedUrl;
        if (r0 != 0) goto L_0x0088;
    L_0x0084:
        r0 = r5.originUrl;
        r5.formattedUrl = r0;
    L_0x0088:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.request.Request.formatUrl():void");
    }
}
