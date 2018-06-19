package org.android.spdy;

import anet.channel.util.HttpConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public final class SpdyRequest {
    public static final String GET_METHOD = "GET";
    public static final String POST_METHOD = "POST";
    private int connectionTimeoutMs = 0;
    private String domain;
    private Map<String, String> extHead;
    private String host;
    private String method;
    private int port;
    private RequestPriority priority;
    private String proxyIp = "0.0.0.0";
    private int proxyPort = 0;
    private int requestTimeoutMs = 0;
    private int retryTimes = 0;
    private URL url;

    public SpdyRequest(URL url, String str, int i, String str2, int i2, String str3, RequestPriority requestPriority, int i3, int i4, int i5) {
        this.url = url;
        this.domain = "";
        this.host = str;
        this.port = i;
        if (!(str2 == null || i2 == 0)) {
            this.proxyIp = str2;
            this.proxyPort = i2;
        }
        this.method = str3;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i3;
        this.connectionTimeoutMs = i4;
        this.retryTimes = i5;
    }

    public SpdyRequest(URL url, String str, int i, String str2, RequestPriority requestPriority) {
        this.url = url;
        this.domain = "";
        this.host = str;
        this.port = i;
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, RequestPriority requestPriority) {
        this.url = url;
        this.domain = "";
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, RequestPriority requestPriority, int i, int i2) {
        this.url = url;
        this.domain = "";
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i;
        this.connectionTimeoutMs = i2;
    }

    public SpdyRequest(URL url, String str) {
        this.url = url;
        this.domain = "";
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < 0) {
            this.port = url.getDefaultPort();
        }
        this.method = str;
        this.extHead = new HashMap(5);
        this.priority = RequestPriority.DEFAULT_PRIORITY;
    }

    public SpdyRequest(URL url, String str, String str2, int i, String str3, int i2, String str4, RequestPriority requestPriority, int i3, int i4, int i5) {
        this.url = url;
        this.domain = str;
        this.host = str2;
        this.port = i;
        if (!(str3 == null || i2 == 0)) {
            this.proxyIp = str3;
            this.proxyPort = i2;
        }
        this.method = str4;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i3;
        this.connectionTimeoutMs = i4;
        this.retryTimes = i5;
    }

    public SpdyRequest(URL url, String str, String str2, int i, String str3, RequestPriority requestPriority) {
        this.url = url;
        this.domain = str;
        this.host = str2;
        this.port = i;
        this.method = str3;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, String str2, RequestPriority requestPriority) {
        this.url = url;
        this.domain = str;
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < null) {
            this.port = url.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
    }

    public SpdyRequest(URL url, String str, String str2, RequestPriority requestPriority, int i, int i2) {
        this.url = url;
        this.domain = str;
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < null) {
            this.port = url.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = requestPriority;
        if (requestPriority == null) {
            this.priority = RequestPriority.DEFAULT_PRIORITY;
        }
        this.requestTimeoutMs = i;
        this.connectionTimeoutMs = i2;
    }

    public SpdyRequest(URL url, String str, String str2) {
        this.url = url;
        this.domain = str;
        this.host = url.getHost();
        this.port = url.getPort();
        if (this.port < null) {
            this.port = url.getDefaultPort();
        }
        this.method = str2;
        this.extHead = new HashMap(5);
        this.priority = RequestPriority.DEFAULT_PRIORITY;
    }

    public final void addHeader(String str, String str2) {
        this.extHead.put(str, str2);
    }

    public final void addHeaders(Map<String, String> map) {
        this.extHead.putAll(map);
    }

    final URL getUrl() {
        return this.url;
    }

    final String getMethod() {
        return this.method;
    }

    final int getPriority() {
        return this.priority.getPriorityInt();
    }

    private String getPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.url.getPath());
        if (this.url.getQuery() != null) {
            stringBuilder.append("?");
            stringBuilder.append(this.url.getQuery());
        }
        if (this.url.getRef() != null) {
            stringBuilder.append("#");
            stringBuilder.append(this.url.getRef());
        }
        return stringBuilder.toString();
    }

    final Map<String, String> getHeaders() {
        Map<String, String> hashMap = new HashMap(5);
        hashMap.put(":path", getPath());
        hashMap.put(":method", this.method);
        hashMap.put(":version", "HTTP/1.1");
        hashMap.put(":host", this.url.getAuthority());
        hashMap.put(":scheme", this.url.getProtocol());
        if (this.extHead != null && this.extHead.size() > 0) {
            hashMap.putAll(this.extHead);
        }
        return hashMap;
    }

    final String getUrlPath() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.url.getProtocol());
        stringBuilder.append(HttpConstant.SCHEME_SPLIT);
        stringBuilder.append(this.url.getAuthority());
        stringBuilder.append(getPath());
        return stringBuilder.toString();
    }

    final String getHost() {
        return this.host;
    }

    final int getPort() {
        return this.port < 0 ? 80 : this.port;
    }

    final String getProxyIp() {
        return this.proxyIp;
    }

    final int getProxyPort() {
        return this.proxyPort;
    }

    public final void setDomain(String str) {
        this.domain = str;
    }

    final String getDomain() {
        return this.domain;
    }

    public final String getAuthority() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.host);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(Integer.toString(this.port));
        stringBuilder.append("/");
        stringBuilder.append(this.proxyIp);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(this.proxyPort);
        return stringBuilder.toString();
    }

    public final int getRequestTimeoutMs() {
        return this.requestTimeoutMs;
    }

    public final int getConnectionTimeoutMs() {
        return this.connectionTimeoutMs;
    }

    public final int getRetryTimes() {
        return this.retryTimes;
    }
}
