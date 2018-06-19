package com.umeng.message.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class HttpRequest {
    private static final String BOUNDARY = "00content0boundary00";
    public static final String CHARSET_UTF8 = "UTF-8";
    private static ConnectionFactory CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
    public static final String CONTENT_TYPE_FORM = "application/x-www-form-urlencoded";
    public static final String CONTENT_TYPE_JSON = "application/json";
    private static final String CONTENT_TYPE_MULTIPART = "multipart/form-data; boundary=00content0boundary00";
    private static final String CRLF = "\r\n";
    private static final String[] EMPTY_STRINGS = new String[0];
    public static final String ENCODING_GZIP = "gzip";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_ACCEPT_CHARSET = "Accept-Charset";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_CONTENT_ENCODING = "Content-Encoding";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_DATE = "Date";
    public static final String HEADER_ETAG = "ETag";
    public static final String HEADER_EXPIRES = "Expires";
    public static final String HEADER_IF_NONE_MATCH = "If-None-Match";
    public static final String HEADER_LAST_MODIFIED = "Last-Modified";
    public static final String HEADER_LOCATION = "Location";
    public static final String HEADER_PROXY_AUTHORIZATION = "Proxy-Authorization";
    public static final String HEADER_REFERER = "Referer";
    public static final String HEADER_SERVER = "Server";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String METHOD_DELETE = "DELETE";
    public static final String METHOD_GET = "GET";
    public static final String METHOD_HEAD = "HEAD";
    public static final String METHOD_OPTIONS = "OPTIONS";
    public static final String METHOD_POST = "POST";
    public static final String METHOD_PUT = "PUT";
    public static final String METHOD_TRACE = "TRACE";
    public static final String PARAM_CHARSET = "charset";
    private static SSLSocketFactory TRUSTED_FACTORY = null;
    private static HostnameVerifier TRUSTED_VERIFIER = null;
    private static int connectTimeout = 60000;
    private static int readTimeOut = 60000;
    private int bufferSize = 8192;
    private HttpURLConnection connection = null;
    private boolean form;
    private String httpProxyHost;
    private int httpProxyPort;
    private boolean ignoreCloseExceptions = true;
    private boolean multipart;
    private e output;
    private final String requestMethod;
    private boolean uncompress = false;
    private final URL url;

    private static String getValidCharset(String str) {
        return (str == null || str.length() <= 0) ? "UTF-8" : str;
    }

    private static HostnameVerifier getTrustedVerifier() {
        if (TRUSTED_VERIFIER == null) {
            TRUSTED_VERIFIER = new 1();
        }
        return TRUSTED_VERIFIER;
    }

    private static HostnameVerifier getTrustedVerifier(HttpsURLConnection httpsURLConnection) {
        if (TRUSTED_VERIFIER == null) {
            TRUSTED_VERIFIER = new 3(httpsURLConnection);
        }
        return TRUSTED_VERIFIER;
    }

    private static StringBuilder addPathSeparator(String str, StringBuilder stringBuilder) {
        if (str.indexOf(58) + 2 == str.lastIndexOf(47)) {
            stringBuilder.append('/');
        }
        return stringBuilder;
    }

    private static StringBuilder addParamPrefix(String str, StringBuilder stringBuilder) {
        int indexOf = str.indexOf(63);
        int length = stringBuilder.length() - 1;
        if (indexOf == -1) {
            stringBuilder.append('?');
        } else if (indexOf < length && str.charAt(length) != 38) {
            stringBuilder.append('&');
        }
        return stringBuilder;
    }

    public static void setConnectionFactory(ConnectionFactory connectionFactory) {
        if (connectionFactory == null) {
            CONNECTION_FACTORY = ConnectionFactory.DEFAULT;
        } else {
            CONNECTION_FACTORY = connectionFactory;
        }
    }

    public static String encode(CharSequence charSequence) throws HttpRequestException {
        try {
            URL url = new URL(charSequence.toString());
            charSequence = url.getHost();
            int port = url.getPort();
            if (port != -1) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(charSequence);
                stringBuilder.append(':');
                stringBuilder.append(Integer.toString(port));
                charSequence = stringBuilder.toString();
            }
            try {
                charSequence = new URI(url.getProtocol(), charSequence, url.getPath(), url.getQuery(), null).toASCIIString();
                int indexOf = charSequence.indexOf(63);
                if (indexOf <= 0) {
                    return charSequence;
                }
                indexOf++;
                if (indexOf >= charSequence.length()) {
                    return charSequence;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(charSequence.substring(0, indexOf));
                stringBuilder2.append(charSequence.substring(indexOf).replace("+", "%2B"));
                return stringBuilder2.toString();
            } catch (CharSequence charSequence2) {
                IOException iOException = new IOException("Parsing URI failed");
                iOException.initCause(charSequence2);
                throw new HttpRequestException(iOException);
            }
        } catch (CharSequence charSequence22) {
            throw new HttpRequestException(charSequence22);
        }
    }

    public static String append(CharSequence charSequence, Map<?, ?> map) {
        charSequence = charSequence.toString();
        if (map != null) {
            if (!map.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(charSequence);
                addPathSeparator(charSequence, stringBuilder);
                addParamPrefix(charSequence, stringBuilder);
                charSequence = map.entrySet().iterator();
                Entry entry = (Entry) charSequence.next();
                stringBuilder.append(entry.getKey().toString());
                stringBuilder.append('=');
                map = entry.getValue();
                if (map != null) {
                    stringBuilder.append(map);
                }
                while (charSequence.hasNext() != null) {
                    stringBuilder.append('&');
                    entry = (Entry) charSequence.next();
                    stringBuilder.append(entry.getKey().toString());
                    stringBuilder.append('=');
                    map = entry.getValue();
                    if (map != null) {
                        stringBuilder.append(map);
                    }
                }
                return stringBuilder.toString();
            }
        }
        return charSequence;
    }

    public static String append(CharSequence charSequence, Object... objArr) {
        charSequence = charSequence.toString();
        if (objArr != null) {
            if (objArr.length != 0) {
                int i = 2;
                if (objArr.length % 2 != 0) {
                    throw new IllegalArgumentException("Must specify an even number of parameter names/values");
                }
                StringBuilder stringBuilder = new StringBuilder(charSequence);
                addPathSeparator(charSequence, stringBuilder);
                addParamPrefix(charSequence, stringBuilder);
                stringBuilder.append(objArr[null]);
                stringBuilder.append('=');
                Object obj = objArr[1];
                if (obj != null) {
                    stringBuilder.append(obj);
                }
                while (i < objArr.length) {
                    stringBuilder.append('&');
                    stringBuilder.append(objArr[i]);
                    stringBuilder.append('=');
                    obj = objArr[i + 1];
                    if (obj != null) {
                        stringBuilder.append(obj);
                    }
                    i += 2;
                }
                return stringBuilder.toString();
            }
        }
        return charSequence;
    }

    public static HttpRequest get(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "GET");
    }

    public static HttpRequest get(URL url) throws HttpRequestException {
        return new HttpRequest(url, "GET");
    }

    public static HttpRequest get(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = append(charSequence, (Map) map);
        if (z) {
            charSequence = encode(charSequence);
        }
        return get(charSequence);
    }

    public static HttpRequest get(CharSequence charSequence, boolean z, Object... objArr) {
        charSequence = append(charSequence, objArr);
        if (z) {
            charSequence = encode(charSequence);
        }
        return get(charSequence);
    }

    public static HttpRequest post(CharSequence charSequence) throws HttpRequestException {
        HttpRequest httpRequest = new HttpRequest(charSequence, "POST");
        httpRequest.getConnection().setConnectTimeout(connectTimeout);
        httpRequest.getConnection().setReadTimeout(readTimeOut);
        return httpRequest;
    }

    public static HttpRequest post(URL url) throws HttpRequestException {
        HttpRequest httpRequest = new HttpRequest(url, "POST");
        httpRequest.getConnection().setConnectTimeout(connectTimeout);
        httpRequest.getConnection().setReadTimeout(readTimeOut);
        return httpRequest;
    }

    public static HttpRequest post(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = append(charSequence, (Map) map);
        if (z) {
            charSequence = encode(charSequence);
        }
        return post(charSequence);
    }

    public static HttpRequest post(CharSequence charSequence, boolean z, Object... objArr) {
        charSequence = append(charSequence, objArr);
        if (z) {
            charSequence = encode(charSequence);
        }
        return post(charSequence);
    }

    public static HttpRequest put(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "PUT");
    }

    public static HttpRequest put(URL url) throws HttpRequestException {
        return new HttpRequest(url, "PUT");
    }

    public static HttpRequest put(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = append(charSequence, (Map) map);
        if (z) {
            charSequence = encode(charSequence);
        }
        return put(charSequence);
    }

    public static HttpRequest put(CharSequence charSequence, boolean z, Object... objArr) {
        charSequence = append(charSequence, objArr);
        if (z) {
            charSequence = encode(charSequence);
        }
        return put(charSequence);
    }

    public static HttpRequest delete(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "DELETE");
    }

    public static HttpRequest delete(URL url) throws HttpRequestException {
        return new HttpRequest(url, "DELETE");
    }

    public static HttpRequest delete(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = append(charSequence, (Map) map);
        if (z) {
            charSequence = encode(charSequence);
        }
        return delete(charSequence);
    }

    public static HttpRequest delete(CharSequence charSequence, boolean z, Object... objArr) {
        charSequence = append(charSequence, objArr);
        if (z) {
            charSequence = encode(charSequence);
        }
        return delete(charSequence);
    }

    public static HttpRequest head(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "HEAD");
    }

    public static HttpRequest head(URL url) throws HttpRequestException {
        return new HttpRequest(url, "HEAD");
    }

    public static HttpRequest head(CharSequence charSequence, Map<?, ?> map, boolean z) {
        charSequence = append(charSequence, (Map) map);
        if (z) {
            charSequence = encode(charSequence);
        }
        return head(charSequence);
    }

    public static HttpRequest head(CharSequence charSequence, boolean z, Object... objArr) {
        charSequence = append(charSequence, objArr);
        if (z) {
            charSequence = encode(charSequence);
        }
        return head(charSequence);
    }

    public static HttpRequest options(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, "OPTIONS");
    }

    public static HttpRequest options(URL url) throws HttpRequestException {
        return new HttpRequest(url, "OPTIONS");
    }

    public static HttpRequest trace(CharSequence charSequence) throws HttpRequestException {
        return new HttpRequest(charSequence, METHOD_TRACE);
    }

    public static HttpRequest trace(URL url) throws HttpRequestException {
        return new HttpRequest(url, METHOD_TRACE);
    }

    public static void keepAlive(boolean z) {
        setProperty("http.keepAlive", Boolean.toString(z));
    }

    public static void proxyHost(String str) {
        setProperty("http.proxyHost", str);
        setProperty("https.proxyHost", str);
    }

    public static void proxyPort(int i) {
        i = Integer.toString(i);
        setProperty("http.proxyPort", i);
        setProperty("https.proxyPort", i);
    }

    public static void nonProxyHosts(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            setProperty("http.nonProxyHosts", null);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(strArr[i]);
            stringBuilder.append('|');
        }
        stringBuilder.append(strArr[length]);
        setProperty("http.nonProxyHosts", stringBuilder.toString());
    }

    private static String setProperty(String str, String str2) {
        PrivilegedAction 4;
        if (str2 != null) {
            4 = new 4(str, str2);
        } else {
            4 = new 5(str);
        }
        return (String) AccessController.doPrivileged(4);
    }

    public HttpRequest(CharSequence charSequence, String str) throws HttpRequestException {
        try {
            this.url = new URL(charSequence.toString());
            this.requestMethod = str;
        } catch (CharSequence charSequence2) {
            throw new HttpRequestException(charSequence2);
        }
    }

    public HttpRequest(URL url, String str) throws HttpRequestException {
        this.url = url;
        this.requestMethod = str;
    }

    private Proxy createProxy() {
        return new Proxy(Type.HTTP, new InetSocketAddress(this.httpProxyHost, this.httpProxyPort));
    }

    private HttpURLConnection createConnection() {
        try {
            HttpURLConnection create;
            if (this.httpProxyHost != null) {
                create = CONNECTION_FACTORY.create(this.url, createProxy());
            } else {
                create = CONNECTION_FACTORY.create(this.url);
            }
            create.setRequestMethod(this.requestMethod);
            return create;
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(method());
        stringBuilder.append(' ');
        stringBuilder.append(url());
        return stringBuilder.toString();
    }

    public HttpURLConnection getConnection() {
        if (this.connection == null) {
            this.connection = createConnection();
        }
        return this.connection;
    }

    public HttpRequest ignoreCloseExceptions(boolean z) {
        this.ignoreCloseExceptions = z;
        return this;
    }

    public boolean ignoreCloseExceptions() {
        return this.ignoreCloseExceptions;
    }

    public int code() throws HttpRequestException {
        try {
            closeOutput();
            return getConnection().getResponseCode();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest code(AtomicInteger atomicInteger) throws HttpRequestException {
        atomicInteger.set(code());
        return this;
    }

    public boolean ok() throws HttpRequestException {
        return 200 == code();
    }

    public boolean created() throws HttpRequestException {
        return 201 == code();
    }

    public boolean serverError() throws HttpRequestException {
        return 500 == code();
    }

    public boolean badRequest() throws HttpRequestException {
        return 400 == code();
    }

    public boolean notFound() throws HttpRequestException {
        return 404 == code();
    }

    public boolean notModified() throws HttpRequestException {
        return 304 == code();
    }

    public String message() throws HttpRequestException {
        try {
            closeOutput();
            return getConnection().getResponseMessage();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest disconnect() {
        getConnection().disconnect();
        return this;
    }

    public HttpRequest chunk(int i) {
        getConnection().setChunkedStreamingMode(i);
        return this;
    }

    public HttpRequest bufferSize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Size must be greater than zero");
        }
        this.bufferSize = i;
        return this;
    }

    public int bufferSize() {
        return this.bufferSize;
    }

    public HttpRequest uncompress(boolean z) {
        this.uncompress = z;
        return this;
    }

    protected ByteArrayOutputStream byteStream() {
        int contentLength = contentLength();
        if (contentLength > 0) {
            return new ByteArrayOutputStream(contentLength);
        }
        return new ByteArrayOutputStream();
    }

    public String body(String str) throws HttpRequestException {
        OutputStream byteStream = byteStream();
        try {
            copy(buffer(), byteStream);
            return byteStream.toString(getValidCharset(str));
        } catch (String str2) {
            throw new HttpRequestException(str2);
        }
    }

    public String body() throws HttpRequestException {
        return body(charset());
    }

    public HttpRequest body(AtomicReference<String> atomicReference) throws HttpRequestException {
        atomicReference.set(body());
        return this;
    }

    public HttpRequest body(AtomicReference<String> atomicReference, String str) throws HttpRequestException {
        atomicReference.set(body(str));
        return this;
    }

    public boolean isBodyEmpty() throws HttpRequestException {
        return contentLength() == 0;
    }

    public byte[] bytes() throws HttpRequestException {
        OutputStream byteStream = byteStream();
        try {
            copy(buffer(), byteStream);
            return byteStream.toByteArray();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public BufferedInputStream buffer() throws HttpRequestException {
        return new BufferedInputStream(stream(), this.bufferSize);
    }

    public InputStream stream() throws HttpRequestException {
        InputStream inputStream;
        if (code() < 400) {
            try {
                inputStream = getConnection().getInputStream();
            } catch (IOException e) {
                throw new HttpRequestException(e);
            }
        }
        inputStream = getConnection().getErrorStream();
        if (inputStream == null) {
            try {
                inputStream = getConnection().getInputStream();
            } catch (IOException e2) {
                throw new HttpRequestException(e2);
            }
        }
        if (this.uncompress) {
            if ("gzip".equals(contentEncoding())) {
                try {
                    return new GZIPInputStream(inputStream);
                } catch (IOException e22) {
                    throw new HttpRequestException(e22);
                }
            }
        }
        return inputStream;
    }

    public InputStreamReader reader(String str) throws HttpRequestException {
        try {
            return new InputStreamReader(stream(), getValidCharset(str));
        } catch (String str2) {
            throw new HttpRequestException(str2);
        }
    }

    public InputStreamReader reader() throws HttpRequestException {
        return reader(charset());
    }

    public BufferedReader bufferedReader(String str) throws HttpRequestException {
        return new BufferedReader(reader(str), this.bufferSize);
    }

    public BufferedReader bufferedReader() throws HttpRequestException {
        return bufferedReader(charset());
    }

    public HttpRequest receive(File file) throws HttpRequestException {
        try {
            Object bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.bufferSize);
            return (HttpRequest) new 6(this, bufferedOutputStream, this.ignoreCloseExceptions, bufferedOutputStream).call();
        } catch (File file2) {
            throw new HttpRequestException(file2);
        }
    }

    public HttpRequest receive(OutputStream outputStream) throws HttpRequestException {
        try {
            return copy(buffer(), outputStream);
        } catch (OutputStream outputStream2) {
            throw new HttpRequestException(outputStream2);
        }
    }

    public HttpRequest receive(PrintStream printStream) throws HttpRequestException {
        return receive((OutputStream) printStream);
    }

    public HttpRequest receive(Appendable appendable) throws HttpRequestException {
        BufferedReader bufferedReader = bufferedReader();
        return (HttpRequest) new 7(this, bufferedReader, this.ignoreCloseExceptions, bufferedReader, appendable).call();
    }

    public HttpRequest receive(Writer writer) throws HttpRequestException {
        BufferedReader bufferedReader = bufferedReader();
        return (HttpRequest) new 8(this, bufferedReader, this.ignoreCloseExceptions, bufferedReader, writer).call();
    }

    public HttpRequest readTimeout(int i) {
        getConnection().setReadTimeout(i);
        return this;
    }

    public HttpRequest connectTimeout(int i) {
        getConnection().setConnectTimeout(i);
        return this;
    }

    public HttpRequest header(String str, String str2) {
        getConnection().setRequestProperty(str, str2);
        return this;
    }

    public HttpRequest header(String str, Number number) {
        return header(str, number != null ? number.toString() : null);
    }

    public HttpRequest headers(Map<String, String> map) {
        if (!map.isEmpty()) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                header((Entry) map.next());
            }
        }
        return this;
    }

    public HttpRequest header(Entry<String, String> entry) {
        return header((String) entry.getKey(), (String) entry.getValue());
    }

    public String header(String str) throws HttpRequestException {
        closeOutputQuietly();
        return getConnection().getHeaderField(str);
    }

    public Map<String, List<String>> headers() throws HttpRequestException {
        closeOutputQuietly();
        return getConnection().getHeaderFields();
    }

    public long dateHeader(String str) throws HttpRequestException {
        return dateHeader(str, -1);
    }

    public long dateHeader(String str, long j) throws HttpRequestException {
        closeOutputQuietly();
        return getConnection().getHeaderFieldDate(str, j);
    }

    public int intHeader(String str) throws HttpRequestException {
        return intHeader(str, -1);
    }

    public int intHeader(String str, int i) throws HttpRequestException {
        closeOutputQuietly();
        return getConnection().getHeaderFieldInt(str, i);
    }

    public String[] headers(String str) {
        Map headers = headers();
        if (headers != null) {
            if (!headers.isEmpty()) {
                List list = (List) headers.get(str);
                if (list == null || list.isEmpty()) {
                    return EMPTY_STRINGS;
                }
                return (String[]) list.toArray(new String[list.size()]);
            }
        }
        return EMPTY_STRINGS;
    }

    public String parameter(String str, String str2) {
        return getParam(header(str), str2);
    }

    public Map<String, String> parameters(String str) {
        return getParams(header(str));
    }

    protected Map<String, String> getParams(String str) {
        if (str != null) {
            if (str.length() != 0) {
                int length = str.length();
                int indexOf = str.indexOf(59) + 1;
                if (indexOf != 0) {
                    if (indexOf != length) {
                        int indexOf2 = str.indexOf(59, indexOf);
                        if (indexOf2 == -1) {
                            indexOf2 = length;
                        }
                        Map<String, String> linkedHashMap = new LinkedHashMap();
                        while (indexOf < indexOf2) {
                            int indexOf3 = str.indexOf(61, indexOf);
                            if (indexOf3 != -1 && indexOf3 < indexOf2) {
                                String trim = str.substring(indexOf, indexOf3).trim();
                                if (trim.length() > 0) {
                                    String trim2 = str.substring(indexOf3 + 1, indexOf2).trim();
                                    int length2 = trim2.length();
                                    if (length2 != 0) {
                                        if (length2 > 2 && '\"' == trim2.charAt(0)) {
                                            length2--;
                                            if ('\"' == trim2.charAt(length2)) {
                                                linkedHashMap.put(trim, trim2.substring(1, length2));
                                            }
                                        }
                                        linkedHashMap.put(trim, trim2);
                                    }
                                }
                            }
                            indexOf = indexOf2 + 1;
                            indexOf2 = str.indexOf(59, indexOf);
                            if (indexOf2 == -1) {
                                indexOf2 = length;
                            }
                        }
                        return linkedHashMap;
                    }
                }
                return Collections.emptyMap();
            }
        }
        return Collections.emptyMap();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected java.lang.String getParam(java.lang.String r9, java.lang.String r10) {
        /*
        r8 = this;
        r0 = 0;
        if (r9 == 0) goto L_0x0071;
    L_0x0003:
        r1 = r9.length();
        if (r1 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0071;
    L_0x000a:
        r1 = r9.length();
        r2 = 59;
        r3 = r9.indexOf(r2);
        r4 = 1;
        r3 = r3 + r4;
        if (r3 == 0) goto L_0x0070;
    L_0x0018:
        if (r3 != r1) goto L_0x001b;
    L_0x001a:
        goto L_0x0070;
    L_0x001b:
        r5 = r9.indexOf(r2, r3);
        r6 = -1;
        if (r5 != r6) goto L_0x0023;
    L_0x0022:
        r5 = r1;
    L_0x0023:
        if (r3 >= r5) goto L_0x006f;
    L_0x0025:
        r7 = 61;
        r7 = r9.indexOf(r7, r3);
        if (r7 == r6) goto L_0x0066;
    L_0x002d:
        if (r7 >= r5) goto L_0x0066;
    L_0x002f:
        r3 = r9.substring(r3, r7);
        r3 = r3.trim();
        r3 = r10.equals(r3);
        if (r3 == 0) goto L_0x0066;
    L_0x003d:
        r7 = r7 + 1;
        r3 = r9.substring(r7, r5);
        r3 = r3.trim();
        r7 = r3.length();
        if (r7 == 0) goto L_0x0066;
    L_0x004d:
        r9 = 2;
        if (r7 <= r9) goto L_0x0065;
    L_0x0050:
        r9 = 0;
        r9 = r3.charAt(r9);
        r10 = 34;
        if (r10 != r9) goto L_0x0065;
    L_0x0059:
        r7 = r7 - r4;
        r9 = r3.charAt(r7);
        if (r10 != r9) goto L_0x0065;
    L_0x0060:
        r9 = r3.substring(r4, r7);
        return r9;
    L_0x0065:
        return r3;
    L_0x0066:
        r3 = r5 + 1;
        r5 = r9.indexOf(r2, r3);
        if (r5 != r6) goto L_0x0023;
    L_0x006e:
        goto L_0x0022;
    L_0x006f:
        return r0;
    L_0x0070:
        return r0;
    L_0x0071:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.HttpRequest.getParam(java.lang.String, java.lang.String):java.lang.String");
    }

    public String charset() {
        return parameter("Content-Type", "charset");
    }

    public HttpRequest userAgent(String str) {
        return header(HEADER_USER_AGENT, str);
    }

    public HttpRequest referer(String str) {
        return header(HEADER_REFERER, str);
    }

    public HttpRequest useCaches(boolean z) {
        getConnection().setUseCaches(z);
        return this;
    }

    public HttpRequest acceptEncoding(String str) {
        return header("Accept-Encoding", str);
    }

    public HttpRequest acceptGzipEncoding() {
        return acceptEncoding("gzip");
    }

    public HttpRequest acceptCharset(String str) {
        return header(HEADER_ACCEPT_CHARSET, str);
    }

    public String contentEncoding() {
        return header("Content-Encoding");
    }

    public String server() {
        return header(HEADER_SERVER);
    }

    public long date() {
        return dateHeader(HEADER_DATE);
    }

    public String cacheControl() {
        return header("Cache-Control");
    }

    public String eTag() {
        return header(HEADER_ETAG);
    }

    public long expires() {
        return dateHeader(HEADER_EXPIRES);
    }

    public long lastModified() {
        return dateHeader(HEADER_LAST_MODIFIED);
    }

    public String location() {
        return header("Location");
    }

    public HttpRequest authorization(String str) {
        return header("Authorization", str);
    }

    public HttpRequest proxyAuthorization(String str) {
        return header(HEADER_PROXY_AUTHORIZATION, str);
    }

    public HttpRequest basic(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("Basic ");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(':');
        stringBuilder2.append(str2);
        stringBuilder.append(a.a(stringBuilder2.toString()));
        return authorization(stringBuilder.toString());
    }

    public HttpRequest proxyBasic(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder("Basic ");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append(':');
        stringBuilder2.append(str2);
        stringBuilder.append(a.a(stringBuilder2.toString()));
        return proxyAuthorization(stringBuilder.toString());
    }

    public HttpRequest ifModifiedSince(long j) {
        getConnection().setIfModifiedSince(j);
        return this;
    }

    public HttpRequest ifNoneMatch(String str) {
        return header(HEADER_IF_NONE_MATCH, str);
    }

    public HttpRequest contentType(String str) {
        return contentType(str, null);
    }

    public HttpRequest contentType(String str, String str2) {
        if (str2 == null || str2.length() <= 0) {
            return header("Content-Type", str);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("; charset=");
        stringBuilder.append(str2);
        return header("Content-Type", stringBuilder.toString());
    }

    public String contentType() {
        return header("Content-Type");
    }

    public int contentLength() {
        return intHeader("Content-Length");
    }

    public HttpRequest contentLength(String str) {
        return contentLength(Integer.parseInt(str));
    }

    public HttpRequest contentLength(int i) {
        getConnection().setFixedLengthStreamingMode(i);
        return this;
    }

    public HttpRequest accept(String str) {
        return header("Accept", str);
    }

    public HttpRequest acceptJson() {
        return accept(CONTENT_TYPE_JSON);
    }

    protected HttpRequest copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        return (HttpRequest) new 9(this, inputStream, this.ignoreCloseExceptions, inputStream, outputStream).call();
    }

    protected HttpRequest copy(Reader reader, Writer writer) throws IOException {
        return (HttpRequest) new 10(this, reader, this.ignoreCloseExceptions, reader, writer).call();
    }

    protected com.umeng.message.util.HttpRequest closeOutput() throws java.io.IOException {
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
        r2 = this;
        r0 = r2.output;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return r2;
    L_0x0005:
        r0 = r2.multipart;
        if (r0 == 0) goto L_0x0010;
    L_0x0009:
        r0 = r2.output;
        r1 = "\r\n--00content0boundary00--\r\n";
        r0.a(r1);
    L_0x0010:
        r0 = r2.ignoreCloseExceptions;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r2.output;	 Catch:{ IOException -> 0x001f }
        r0.close();	 Catch:{ IOException -> 0x001f }
        goto L_0x001f;
    L_0x001a:
        r0 = r2.output;
        r0.close();
    L_0x001f:
        r0 = 0;
        r2.output = r0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.HttpRequest.closeOutput():com.umeng.message.util.HttpRequest");
    }

    protected HttpRequest closeOutputQuietly() throws HttpRequestException {
        try {
            return closeOutput();
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    protected HttpRequest openOutput() throws IOException {
        if (this.output != null) {
            return this;
        }
        getConnection().setDoOutput(true);
        this.output = new e(getConnection().getOutputStream(), getParam(getConnection().getRequestProperty("Content-Type"), "charset"), this.bufferSize);
        return this;
    }

    protected HttpRequest startPart() throws IOException {
        if (this.multipart) {
            this.output.a("\r\n--00content0boundary00\r\n");
        } else {
            this.multipart = true;
            contentType(CONTENT_TYPE_MULTIPART).openOutput();
            this.output.a("--00content0boundary00\r\n");
        }
        return this;
    }

    protected HttpRequest writePartHeader(String str, String str2) throws IOException {
        return writePartHeader(str, str2, null);
    }

    protected HttpRequest writePartHeader(String str, String str2, String str3) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"");
        stringBuilder.append(str);
        if (str2 != null) {
            stringBuilder.append("\"; filename=\"");
            stringBuilder.append(str2);
        }
        stringBuilder.append('\"');
        partHeader("Content-Disposition", stringBuilder.toString());
        if (str3 != null) {
            partHeader("Content-Type", str3);
        }
        return send(CRLF);
    }

    public HttpRequest part(String str, String str2) {
        return part(str, null, str2);
    }

    public HttpRequest part(String str, String str2, String str3) throws HttpRequestException {
        return part(str, str2, null, str3);
    }

    public HttpRequest part(String str, String str2, String str3, String str4) throws HttpRequestException {
        try {
            startPart();
            writePartHeader(str, str2, str3);
            this.output.a(str4);
            return this;
        } catch (String str5) {
            throw new HttpRequestException(str5);
        }
    }

    public HttpRequest part(String str, Number number) throws HttpRequestException {
        return part(str, null, number);
    }

    public HttpRequest part(String str, String str2, Number number) throws HttpRequestException {
        return part(str, str2, number != null ? number.toString() : null);
    }

    public HttpRequest part(String str, File file) throws HttpRequestException {
        return part(str, null, file);
    }

    public HttpRequest part(String str, String str2, File file) throws HttpRequestException {
        return part(str, str2, null, file);
    }

    public HttpRequest part(String str, String str2, String str3, File file) throws HttpRequestException {
        try {
            return part(str, str2, str3, new BufferedInputStream(new FileInputStream(file)));
        } catch (String str4) {
            throw new HttpRequestException(str4);
        }
    }

    public HttpRequest part(String str, InputStream inputStream) throws HttpRequestException {
        return part(str, null, null, inputStream);
    }

    public HttpRequest part(String str, String str2, String str3, InputStream inputStream) throws HttpRequestException {
        try {
            startPart();
            writePartHeader(str, str2, str3);
            copy(inputStream, this.output);
            return this;
        } catch (String str4) {
            throw new HttpRequestException(str4);
        }
    }

    public HttpRequest partHeader(String str, String str2) throws HttpRequestException {
        return send((CharSequence) str).send((CharSequence) ": ").send((CharSequence) str2).send(CRLF);
    }

    public HttpRequest send(File file) throws HttpRequestException {
        try {
            return send(new BufferedInputStream(new FileInputStream(file)));
        } catch (File file2) {
            throw new HttpRequestException(file2);
        }
    }

    public HttpRequest send(byte[] bArr) throws HttpRequestException {
        return send(new ByteArrayInputStream(bArr));
    }

    public HttpRequest send(InputStream inputStream) throws HttpRequestException {
        try {
            openOutput();
            copy(inputStream, this.output);
            return this;
        } catch (InputStream inputStream2) {
            throw new HttpRequestException(inputStream2);
        }
    }

    public HttpRequest send(Reader reader) throws HttpRequestException {
        try {
            openOutput();
            Object outputStreamWriter = new OutputStreamWriter(this.output, e.a(this.output).charset());
            return (HttpRequest) new 2(this, outputStreamWriter, reader, outputStreamWriter).call();
        } catch (Reader reader2) {
            throw new HttpRequestException(reader2);
        }
    }

    public HttpRequest send(CharSequence charSequence) throws HttpRequestException {
        try {
            openOutput();
            this.output.a(charSequence.toString());
            return this;
        } catch (CharSequence charSequence2) {
            throw new HttpRequestException(charSequence2);
        }
    }

    public OutputStreamWriter writer() throws HttpRequestException {
        try {
            openOutput();
            return new OutputStreamWriter(this.output, e.a(this.output).charset());
        } catch (IOException e) {
            throw new HttpRequestException(e);
        }
    }

    public HttpRequest form(Map<?, ?> map) throws HttpRequestException {
        return form((Map) map, "UTF-8");
    }

    public HttpRequest form(Entry<?, ?> entry) throws HttpRequestException {
        return form((Entry) entry, "UTF-8");
    }

    public HttpRequest form(Entry<?, ?> entry, String str) throws HttpRequestException {
        return form(entry.getKey(), entry.getValue(), str);
    }

    public HttpRequest form(Object obj, Object obj2) throws HttpRequestException {
        return form(obj, obj2, "UTF-8");
    }

    public HttpRequest form(Object obj, Object obj2, String str) throws HttpRequestException {
        int i = this.form ^ 1;
        if (i != 0) {
            contentType(CONTENT_TYPE_FORM, str);
            this.form = true;
        }
        str = getValidCharset(str);
        try {
            openOutput();
            if (i == 0) {
                this.output.write(38);
            }
            this.output.a(URLEncoder.encode(obj.toString(), str));
            this.output.write(61);
            if (obj2 != null) {
                this.output.a(URLEncoder.encode(obj2.toString(), str));
            }
            return this;
        } catch (Object obj3) {
            throw new HttpRequestException(obj3);
        }
    }

    public HttpRequest form(Map<?, ?> map, String str) throws HttpRequestException {
        if (!map.isEmpty()) {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                form((Entry) map.next(), str);
            }
        }
        return this;
    }

    public HttpRequest trustAllHosts() {
        HttpURLConnection connection = getConnection();
        if (connection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) connection).setHostnameVerifier(getTrustedVerifier());
        }
        return this;
    }

    public HttpRequest trustHosts() {
        HttpURLConnection connection = getConnection();
        if (connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) connection;
            httpsURLConnection.setHostnameVerifier(getTrustedVerifier(httpsURLConnection));
        }
        return this;
    }

    public URL url() {
        return getConnection().getURL();
    }

    public String method() {
        return getConnection().getRequestMethod();
    }

    public HttpRequest useProxy(String str, int i) {
        if (this.connection != null) {
            throw new IllegalStateException("The connection has already been created. This method must be called before reading or writing to the request.");
        }
        this.httpProxyHost = str;
        this.httpProxyPort = i;
        return this;
    }

    public HttpRequest followRedirects(boolean z) {
        getConnection();
        HttpURLConnection.setFollowRedirects(z);
        return this;
    }
}
