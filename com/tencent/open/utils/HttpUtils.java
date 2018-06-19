package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import anet.channel.util.HttpConstant;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.f;
import com.tencent.tauth.IRequestListener;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.InvalidPropertiesFormatException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.X509TrustManager;
import org.apache.http.ConnectionClosedException;
import org.apache.http.HttpResponse;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONObject;

/* compiled from: ProGuard */
public class HttpUtils {

    /* compiled from: ProGuard */
    final class AnonymousClass1 extends Thread {
        final /* synthetic */ QQToken a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ Bundle d;
        final /* synthetic */ String e;
        final /* synthetic */ IRequestListener f;

        AnonymousClass1(QQToken qQToken, Context context, String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
            this.a = qQToken;
            this.b = context;
            this.c = str;
            this.d = bundle;
            this.e = str2;
            this.f = iRequestListener;
        }

        public final void run() {
            try {
                JSONObject request = HttpUtils.request(this.a, this.b, this.c, this.d, this.e);
                if (this.f != null) {
                    this.f.onComplete(request);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi onComplete");
                }
            } catch (Throwable e) {
                if (this.f != null) {
                    this.f.onMalformedURLException(e);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync MalformedURLException", e);
                }
            } catch (Throwable e2) {
                if (this.f != null) {
                    this.f.onConnectTimeoutException(e2);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onConnectTimeoutException", e2);
                }
            } catch (Throwable e22) {
                if (this.f != null) {
                    this.f.onSocketTimeoutException(e22);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onSocketTimeoutException", e22);
                }
            } catch (Throwable e222) {
                if (this.f != null) {
                    this.f.onNetworkUnavailableException(e222);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onNetworkUnavailableException", e222);
                }
            } catch (Throwable e2222) {
                if (this.f != null) {
                    this.f.onHttpStatusException(e2222);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onHttpStatusException", e2222);
                }
            } catch (Throwable e22222) {
                if (this.f != null) {
                    this.f.onIOException(e22222);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync IOException", e22222);
                }
            } catch (Throwable e222222) {
                if (this.f != null) {
                    this.f.onJSONException(e222222);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync JSONException", e222222);
                }
            } catch (Throwable e2222222) {
                if (this.f != null) {
                    this.f.onUnknowException(e2222222);
                    f.b("openSDK_LOG.HttpUtils", "OpenApi requestAsync onUnknowException", e2222222);
                }
            }
        }
    }

    /* compiled from: ProGuard */
    public static class HttpStatusException extends Exception {
        public static final String ERROR_INFO = "http status code error:";

        public HttpStatusException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    public static class NetworkUnavailableException extends Exception {
        public static final String ERROR_INFO = "network unavailable";

        public NetworkUnavailableException(String str) {
            super(str);
        }
    }

    /* compiled from: ProGuard */
    public static class a extends SSLSocketFactory {
        private final SSLContext a = SSLContext.getInstance("TLS");

        public a(java.security.KeyStore r5) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException, java.security.KeyStoreException, java.security.UnrecoverableKeyException {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r4.<init>(r5);
            r5 = "TLS";
            r5 = javax.net.ssl.SSLContext.getInstance(r5);
            r4.a = r5;
            r5 = 0;
            r0 = new com.tencent.open.utils.HttpUtils$b;	 Catch:{ Exception -> 0x0012 }
            r0.<init>();	 Catch:{ Exception -> 0x0012 }
            goto L_0x0013;
        L_0x0012:
            r0 = r5;
        L_0x0013:
            r1 = r4.a;
            r2 = 1;
            r2 = new javax.net.ssl.TrustManager[r2];
            r3 = 0;
            r2[r3] = r0;
            r1.init(r5, r2, r5);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.a.<init>(java.security.KeyStore):void");
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }

        public Socket createSocket() throws IOException {
            return this.a.getSocketFactory().createSocket();
        }
    }

    /* compiled from: ProGuard */
    public static class b implements X509TrustManager {
        X509TrustManager a;

        b() throws java.lang.Exception {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r4 = this;
            r4.<init>();
            r0 = 0;
            r1 = "JKS";	 Catch:{ Exception -> 0x000b }
            r1 = java.security.KeyStore.getInstance(r1);	 Catch:{ Exception -> 0x000b }
            goto L_0x000c;
        L_0x000b:
            r1 = r0;
        L_0x000c:
            if (r1 == 0) goto L_0x003c;
        L_0x000e:
            r2 = new java.io.FileInputStream;	 Catch:{ all -> 0x0033 }
            r3 = "trustedCerts";	 Catch:{ all -> 0x0033 }
            r2.<init>(r3);	 Catch:{ all -> 0x0033 }
            r0 = "passphrase";	 Catch:{ all -> 0x0031 }
            r0 = r0.toCharArray();	 Catch:{ all -> 0x0031 }
            r1.load(r2, r0);	 Catch:{ all -> 0x0031 }
            r0 = "SunX509";	 Catch:{ all -> 0x0031 }
            r3 = "SunJSSE";	 Catch:{ all -> 0x0031 }
            r0 = javax.net.ssl.TrustManagerFactory.getInstance(r0, r3);	 Catch:{ all -> 0x0031 }
            r0.init(r1);	 Catch:{ all -> 0x0031 }
            r0 = r0.getTrustManagers();	 Catch:{ all -> 0x0031 }
            r2.close();
            goto L_0x004b;
        L_0x0031:
            r0 = move-exception;
            goto L_0x0036;
        L_0x0033:
            r1 = move-exception;
            r2 = r0;
            r0 = r1;
        L_0x0036:
            if (r2 == 0) goto L_0x003b;
        L_0x0038:
            r2.close();
        L_0x003b:
            throw r0;
        L_0x003c:
            r1 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm();
            r1 = javax.net.ssl.TrustManagerFactory.getInstance(r1);
            r1.init(r0);
            r0 = r1.getTrustManagers();
        L_0x004b:
            r1 = 0;
        L_0x004c:
            r2 = r0.length;
            if (r1 >= r2) goto L_0x005f;
        L_0x004f:
            r2 = r0[r1];
            r2 = r2 instanceof javax.net.ssl.X509TrustManager;
            if (r2 == 0) goto L_0x005c;
        L_0x0055:
            r0 = r0[r1];
            r0 = (javax.net.ssl.X509TrustManager) r0;
            r4.a = r0;
            return;
        L_0x005c:
            r1 = r1 + 1;
            goto L_0x004c;
        L_0x005f:
            r0 = new java.lang.Exception;
            r1 = "Couldn't initialize";
            r0.<init>(r1);
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.b.<init>():void");
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.a.checkClientTrusted(x509CertificateArr, str);
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.a.checkServerTrusted(x509CertificateArr, str);
        }

        public X509Certificate[] getAcceptedIssuers() {
            return this.a.getAcceptedIssuers();
        }
    }

    /* compiled from: ProGuard */
    public static class c {
        public final String a;
        public final int b;

        private c(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    private HttpUtils() {
    }

    public static org.json.JSONObject request(com.tencent.connect.auth.QQToken r18, android.content.Context r19, java.lang.String r20, android.os.Bundle r21, java.lang.String r22) throws java.io.IOException, org.json.JSONException, com.tencent.open.utils.HttpUtils.NetworkUnavailableException, com.tencent.open.utils.HttpUtils.HttpStatusException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r19;
        r2 = r20;
        r3 = "openSDK_LOG.HttpUtils";
        r4 = "OpenApi request";
        com.tencent.open.a.f.a(r3, r4);
        r3 = r20.toLowerCase();
        r4 = "http";
        r3 = r3.startsWith(r4);
        if (r3 != 0) goto L_0x004d;
    L_0x0017:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = com.tencent.open.utils.f.a();
        r5 = "https://openmobile.qq.com/";
        r4 = r4.a(r1, r5);
        r3.append(r4);
        r3.append(r2);
        r3 = r3.toString();
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = com.tencent.open.utils.f.a();
        r6 = "https://openmobile.qq.com/";
        r5 = r5.a(r1, r6);
        r4.append(r5);
        r4.append(r2);
        r4 = r4.toString();
        r5 = r3;
        r3 = r18;
        goto L_0x0051;
    L_0x004d:
        r3 = r18;
        r4 = r2;
        r5 = r4;
    L_0x0051:
        a(r1, r3, r2);
        r2 = 0;
        r6 = android.os.SystemClock.elapsedRealtime();
        r8 = 0;
        r9 = r18.getAppId();
        r9 = com.tencent.open.utils.e.a(r1, r9);
        r10 = "Common_HttpRetryCount";
        r9 = r9.a(r10);
        r10 = "OpenConfig_test";
        r11 = new java.lang.StringBuilder;
        r12 = "config 1:Common_HttpRetryCount            config_value:";
        r11.<init>(r12);
        r11.append(r9);
        r12 = "   appid:";
        r11.append(r12);
        r12 = r18.getAppId();
        r11.append(r12);
        r12 = "     url:";
        r11.append(r12);
        r11.append(r4);
        r11 = r11.toString();
        com.tencent.open.a.f.a(r10, r11);
        if (r9 != 0) goto L_0x0092;
    L_0x0091:
        r9 = 3;
    L_0x0092:
        r10 = "OpenConfig_test";
        r11 = new java.lang.StringBuilder;
        r12 = "config 1:Common_HttpRetryCount            result_value:";
        r11.<init>(r12);
        r11.append(r9);
        r12 = "   appid:";
        r11.append(r12);
        r3 = r18.getAppId();
        r11.append(r3);
        r3 = "     url:";
        r11.append(r3);
        r11.append(r4);
        r3 = r11.toString();
        com.tencent.open.a.f.a(r10, r3);
    L_0x00b9:
        r8 = r8 + 1;
        r3 = r21;
        r12 = r22;
        r13 = openUrl2(r1, r5, r12, r3);	 Catch:{ ConnectTimeoutException -> 0x017f, SocketTimeoutException -> 0x015f, HttpStatusException -> 0x0131, NetworkUnavailableException -> 0x012b, MalformedURLException -> 0x0114, IOException -> 0x00fb, JSONException -> 0x00e4 }
        r14 = r13.a;	 Catch:{ ConnectTimeoutException -> 0x017f, SocketTimeoutException -> 0x015f, HttpStatusException -> 0x0131, NetworkUnavailableException -> 0x012b, MalformedURLException -> 0x0114, IOException -> 0x00fb, JSONException -> 0x00e4 }
        r14 = com.tencent.open.utils.i.d(r14);	 Catch:{ ConnectTimeoutException -> 0x017f, SocketTimeoutException -> 0x015f, HttpStatusException -> 0x0131, NetworkUnavailableException -> 0x012b, MalformedURLException -> 0x0114, IOException -> 0x00fb, JSONException -> 0x00e4 }
        r2 = "ret";	 Catch:{ JSONException -> 0x00d8, ConnectTimeoutException -> 0x00d4, SocketTimeoutException -> 0x00d0, HttpStatusException -> 0x0131, NetworkUnavailableException -> 0x012b, MalformedURLException -> 0x0114, IOException -> 0x00fb }
        r2 = r14.getInt(r2);	 Catch:{ JSONException -> 0x00d8, ConnectTimeoutException -> 0x00d4, SocketTimeoutException -> 0x00d0, HttpStatusException -> 0x0131, NetworkUnavailableException -> 0x012b, MalformedURLException -> 0x0114, IOException -> 0x00fb }
        goto L_0x00d9;
    L_0x00d0:
        r0 = move-exception;
        r10 = r0;
        goto L_0x0162;
    L_0x00d4:
        r0 = move-exception;
        r10 = r0;
        goto L_0x0182;
    L_0x00d8:
        r2 = -4;
    L_0x00d9:
        r10 = r13.b;	 Catch:{ ConnectTimeoutException -> 0x00d4, SocketTimeoutException -> 0x00d0, HttpStatusException -> 0x0131, NetworkUnavailableException -> 0x012b, MalformedURLException -> 0x0114, IOException -> 0x00fb, JSONException -> 0x00e4 }
        r17 = r2;	 Catch:{ ConnectTimeoutException -> 0x00d4, SocketTimeoutException -> 0x00d0, HttpStatusException -> 0x0131, NetworkUnavailableException -> 0x012b, MalformedURLException -> 0x0114, IOException -> 0x00fb, JSONException -> 0x00e4 }
        r1 = r13.c;	 Catch:{ ConnectTimeoutException -> 0x00d4, SocketTimeoutException -> 0x00d0, HttpStatusException -> 0x0131, NetworkUnavailableException -> 0x012b, MalformedURLException -> 0x0114, IOException -> 0x00fb, JSONException -> 0x00e4 }
        r15 = r1;
        r9 = r17;
        goto L_0x0195;
    L_0x00e4:
        r0 = move-exception;
        r10 = r0;
        r10.printStackTrace();
        r1 = com.tencent.open.b.g.a();
        r8 = 0;
        r11 = 0;
        r13 = -4;
        r2 = r4;
        r3 = r6;
        r5 = r8;
        r7 = r11;
        r9 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x00fb:
        r0 = move-exception;
        r10 = r0;
        r10.printStackTrace();
        r9 = getErrorCodeFromException(r10);
        r1 = com.tencent.open.b.g.a();
        r11 = 0;
        r13 = 0;
        r2 = r4;
        r3 = r6;
        r5 = r11;
        r7 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x0114:
        r0 = move-exception;
        r10 = r0;
        r10.printStackTrace();
        r1 = com.tencent.open.b.g.a();
        r8 = 0;
        r11 = 0;
        r13 = -3;
        r2 = r4;
        r3 = r6;
        r5 = r8;
        r7 = r11;
        r9 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x012b:
        r0 = move-exception;
        r1 = r0;
        r1.printStackTrace();
        throw r1;
    L_0x0131:
        r0 = move-exception;
        r10 = r0;
        r10.printStackTrace();
        r1 = r10.getMessage();
        r2 = "http status code error:";	 Catch:{ Exception -> 0x0147 }
        r3 = "";	 Catch:{ Exception -> 0x0147 }
        r1 = r1.replace(r2, r3);	 Catch:{ Exception -> 0x0147 }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x0147 }
        goto L_0x014e;
    L_0x0147:
        r0 = move-exception;
        r1 = r0;
        r1.printStackTrace();
        r1 = -9;
    L_0x014e:
        r9 = r1;
        r1 = com.tencent.open.b.g.a();
        r11 = 0;
        r13 = 0;
        r2 = r4;
        r3 = r6;
        r5 = r11;
        r7 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x015f:
        r0 = move-exception;
        r10 = r0;
        r14 = r2;
    L_0x0162:
        r10.printStackTrace();
        r1 = -8;
        if (r8 >= r9) goto L_0x016d;
    L_0x0168:
        r6 = android.os.SystemClock.elapsedRealtime();
        goto L_0x018c;
    L_0x016d:
        r1 = com.tencent.open.b.g.a();
        r8 = 0;
        r11 = 0;
        r13 = -8;
        r2 = r4;
        r3 = r6;
        r5 = r8;
        r7 = r11;
        r9 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
    L_0x017f:
        r0 = move-exception;
        r10 = r0;
        r14 = r2;
    L_0x0182:
        r10.printStackTrace();
        r1 = -7;
        if (r8 >= r9) goto L_0x01a5;
    L_0x0188:
        r6 = android.os.SystemClock.elapsedRealtime();
    L_0x018c:
        r2 = r14;
        if (r8 < r9) goto L_0x01a1;
    L_0x018f:
        r9 = r1;
        r14 = r2;
        r10 = 0;
        r15 = 0;
    L_0x0195:
        r1 = com.tencent.open.b.g.a();
        r2 = r4;
        r3 = r6;
        r5 = r10;
        r7 = r15;
        r1.a(r2, r3, r5, r7, r9);
        return r14;
    L_0x01a1:
        r1 = r19;
        goto L_0x00b9;
    L_0x01a5:
        r1 = com.tencent.open.b.g.a();
        r8 = 0;
        r11 = 0;
        r13 = -7;
        r2 = r4;
        r3 = r6;
        r5 = r8;
        r7 = r11;
        r9 = r13;
        r1.a(r2, r3, r5, r7, r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.request(com.tencent.connect.auth.QQToken, android.content.Context, java.lang.String, android.os.Bundle, java.lang.String):org.json.JSONObject");
    }

    public static void requestAsync(QQToken qQToken, Context context, String str, Bundle bundle, String str2, IRequestListener iRequestListener) {
        f.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
        new AnonymousClass1(qQToken, context, str, bundle, str2, iRequestListener).start();
    }

    private static void a(Context context, QQToken qQToken, String str) {
        if (str.indexOf("add_share") >= 0 || str.indexOf("upload_pic") >= 0 || str.indexOf("add_topic") >= 0 || str.indexOf("set_user_face") >= 0 || str.indexOf("add_t") >= 0 || str.indexOf("add_pic_t") >= 0 || str.indexOf("add_pic_url") >= 0 || str.indexOf("add_video") >= 0) {
            com.tencent.connect.a.a.a(context, qQToken, "requireApi", str);
        }
    }

    public static int getErrorCodeFromException(IOException iOException) {
        if (iOException instanceof CharConversionException) {
            return -20;
        }
        if (iOException instanceof MalformedInputException) {
            return -21;
        }
        if (iOException instanceof UnmappableCharacterException) {
            return -22;
        }
        if (iOException instanceof HttpResponseException) {
            return -23;
        }
        if (iOException instanceof ClosedChannelException) {
            return -24;
        }
        if (iOException instanceof ConnectionClosedException) {
            return -25;
        }
        if (iOException instanceof EOFException) {
            return -26;
        }
        if (iOException instanceof FileLockInterruptionException) {
            return -27;
        }
        if (iOException instanceof FileNotFoundException) {
            return -28;
        }
        if (iOException instanceof HttpRetryException) {
            return -29;
        }
        if (iOException instanceof ConnectTimeoutException) {
            return -7;
        }
        if (iOException instanceof SocketTimeoutException) {
            return -8;
        }
        if (iOException instanceof InvalidPropertiesFormatException) {
            return -30;
        }
        if (iOException instanceof MalformedChunkCodingException) {
            return -31;
        }
        if (iOException instanceof MalformedURLException) {
            return -3;
        }
        if (iOException instanceof NoHttpResponseException) {
            return -32;
        }
        if (iOException instanceof InvalidClassException) {
            return -33;
        }
        if (iOException instanceof InvalidObjectException) {
            return -34;
        }
        if (iOException instanceof NotActiveException) {
            return -35;
        }
        if (iOException instanceof NotSerializableException) {
            return -36;
        }
        if (iOException instanceof OptionalDataException) {
            return -37;
        }
        if (iOException instanceof StreamCorruptedException) {
            return -38;
        }
        if (iOException instanceof WriteAbortedException) {
            return -39;
        }
        if (iOException instanceof ProtocolException) {
            return -40;
        }
        if (iOException instanceof SSLHandshakeException) {
            return -41;
        }
        if (iOException instanceof SSLKeyException) {
            return -42;
        }
        if (iOException instanceof SSLPeerUnverifiedException) {
            return -43;
        }
        if (iOException instanceof SSLProtocolException) {
            return -44;
        }
        if (iOException instanceof BindException) {
            return -45;
        }
        if (iOException instanceof ConnectException) {
            return -46;
        }
        if (iOException instanceof NoRouteToHostException) {
            return -47;
        }
        if (iOException instanceof PortUnreachableException) {
            return -48;
        }
        if (iOException instanceof SyncFailedException) {
            return -49;
        }
        if (iOException instanceof UTFDataFormatException) {
            return -50;
        }
        if (iOException instanceof UnknownHostException) {
            return -51;
        }
        if (iOException instanceof UnknownServiceException) {
            return -52;
        }
        if (iOException instanceof UnsupportedEncodingException) {
            return -53;
        }
        return (iOException instanceof ZipException) != null ? -54 : -2;
    }

    public static com.tencent.open.utils.i.a openUrl2(Context context, String str, String str2, Bundle bundle) throws MalformedURLException, IOException, NetworkUnavailableException, HttpStatusException {
        Bundle bundle2;
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                    throw new NetworkUnavailableException(NetworkUnavailableException.ERROR_INFO);
                }
            }
        }
        if (bundle != null) {
            bundle2 = new Bundle(bundle);
        } else {
            bundle2 = new Bundle();
        }
        bundle = bundle2.getString("appid_for_getting_config");
        bundle2.remove("appid_for_getting_config");
        context = getHttpClient(context, bundle, str);
        bundle = null;
        int i = -1;
        int i2 = 0;
        if (str2.equals("GET")) {
            str2 = encodeUrl(bundle2);
            i2 = 0 + str2.length();
            StringBuilder stringBuilder = new StringBuilder("-->openUrl2 before url =");
            stringBuilder.append(str);
            f.a("openSDK_LOG.HttpUtils", stringBuilder.toString());
            if (str.indexOf("?") == -1) {
                bundle = new StringBuilder();
                bundle.append(str);
                bundle.append("?");
                str = bundle.toString();
            } else {
                bundle = new StringBuilder();
                bundle.append(str);
                bundle.append("&");
                str = bundle.toString();
            }
            stringBuilder = new StringBuilder("-->openUrl2 encodedParam =");
            stringBuilder.append(str2);
            stringBuilder.append(" -- url = ");
            stringBuilder.append(str);
            f.a("openSDK_LOG.HttpUtils", stringBuilder.toString());
            bundle = new StringBuilder();
            bundle.append(str);
            bundle.append(str2);
            bundle = new HttpGet(bundle.toString());
            bundle.addHeader("Accept-Encoding", "gzip");
        } else if (str2.equals("POST")) {
            bundle = new HttpPost(str);
            bundle.addHeader("Accept-Encoding", "gzip");
            str = new Bundle();
            for (String str3 : bundle2.keySet()) {
                Object obj = bundle2.get(str3);
                if (obj instanceof byte[]) {
                    str.putByteArray(str3, (byte[]) obj);
                }
            }
            if (!bundle2.containsKey("method")) {
                bundle2.putString("method", str2);
            }
            bundle.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            bundle.setHeader(HttpConstant.CONNECTION, "Keep-Alive");
            str2 = new ByteArrayOutputStream();
            str2.write(i.i("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
            str2.write(i.i(encodePostBody(bundle2, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
            if (!str.isEmpty()) {
                int size = str.size();
                str2.write(i.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                for (String str32 : str.keySet()) {
                    i++;
                    StringBuilder stringBuilder2 = new StringBuilder("Content-Disposition: form-data; name=\"");
                    stringBuilder2.append(str32);
                    stringBuilder2.append("\"; filename=\"");
                    stringBuilder2.append(str32);
                    stringBuilder2.append("\"\r\n");
                    str2.write(i.i(stringBuilder2.toString()));
                    str2.write(i.i("Content-Type: content/unknown\r\n\r\n"));
                    byte[] byteArray = str.getByteArray(str32);
                    if (byteArray != null) {
                        str2.write(byteArray);
                    }
                    if (i < size - 1) {
                        str2.write(i.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
                    }
                }
            }
            str2.write(i.i("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
            str = str2.toByteArray();
            i2 = 0 + str.length;
            str2.close();
            bundle.setEntity(new ByteArrayEntity(str));
        }
        HttpResponse execute = context.execute(bundle);
        str = execute.getStatusLine().getStatusCode();
        if (str == 200) {
            return new com.tencent.open.utils.i.a(a(execute), i2);
        }
        str2 = new StringBuilder(HttpStatusException.ERROR_INFO);
        str2.append(str);
        throw new HttpStatusException(str2.toString());
    }

    private static String a(HttpResponse httpResponse) throws IllegalStateException, IOException {
        InputStream content = httpResponse.getEntity().getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        httpResponse = httpResponse.getFirstHeader("Content-Encoding");
        httpResponse = (httpResponse == null || httpResponse.getValue().toLowerCase().indexOf("gzip") < null) ? content : new GZIPInputStream(content);
        byte[] bArr = new byte[512];
        while (true) {
            int read = httpResponse.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                String str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                httpResponse.close();
                return str;
            }
        }
    }

    public static org.apache.http.client.HttpClient getHttpClient(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = new org.apache.http.conn.scheme.SchemeRegistry;
        r7.<init>();
        r0 = new org.apache.http.conn.scheme.Scheme;
        r1 = "http";
        r2 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory();
        r3 = 80;
        r0.<init>(r1, r2, r3);
        r7.register(r0);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;
        r2 = 0;
        r3 = 16;
        if (r0 >= r3) goto L_0x004d;
    L_0x001e:
        r0 = java.security.KeyStore.getDefaultType();	 Catch:{ Exception -> 0x003e }
        r0 = java.security.KeyStore.getInstance(r0);	 Catch:{ Exception -> 0x003e }
        r0.load(r2, r2);	 Catch:{ Exception -> 0x003e }
        r3 = new com.tencent.open.utils.HttpUtils$a;	 Catch:{ Exception -> 0x003e }
        r3.<init>(r0);	 Catch:{ Exception -> 0x003e }
        r0 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;	 Catch:{ Exception -> 0x003e }
        r3.setHostnameVerifier(r0);	 Catch:{ Exception -> 0x003e }
        r0 = new org.apache.http.conn.scheme.Scheme;	 Catch:{ Exception -> 0x003e }
        r4 = "https";	 Catch:{ Exception -> 0x003e }
        r0.<init>(r4, r3, r1);	 Catch:{ Exception -> 0x003e }
        r7.register(r0);	 Catch:{ Exception -> 0x003e }
        goto L_0x005b;
    L_0x003e:
        r0 = new org.apache.http.conn.scheme.Scheme;
        r3 = "https";
        r4 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
        r0.<init>(r3, r4, r1);
        r7.register(r0);
        goto L_0x005b;
    L_0x004d:
        r0 = new org.apache.http.conn.scheme.Scheme;
        r3 = "https";
        r4 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
        r0.<init>(r3, r4, r1);
        r7.register(r0);
    L_0x005b:
        r0 = new org.apache.http.params.BasicHttpParams;
        r0.<init>();
        if (r5 == 0) goto L_0x0066;
    L_0x0062:
        r2 = com.tencent.open.utils.e.a(r5, r6);
    L_0x0066:
        r6 = 0;
        if (r2 == 0) goto L_0x0076;
    L_0x0069:
        r6 = "Common_HttpConnectionTimeout";
        r6 = r2.a(r6);
        r1 = "Common_SocketConnectionTimeout";
        r1 = r2.a(r1);
        goto L_0x0077;
    L_0x0076:
        r1 = r6;
    L_0x0077:
        if (r6 != 0) goto L_0x007b;
    L_0x0079:
        r6 = 15000; // 0x3a98 float:2.102E-41 double:7.411E-320;
    L_0x007b:
        if (r1 != 0) goto L_0x007f;
    L_0x007d:
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
    L_0x007f:
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r6);
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r1);
        r6 = org.apache.http.HttpVersion.HTTP_1_1;
        org.apache.http.params.HttpProtocolParams.setVersion(r0, r6);
        r6 = "UTF-8";
        org.apache.http.params.HttpProtocolParams.setContentCharset(r0, r6);
        r6 = new java.lang.StringBuilder;
        r1 = "AndroidSDK_";
        r6.<init>(r1);
        r1 = android.os.Build.VERSION.SDK;
        r6.append(r1);
        r1 = "_";
        r6.append(r1);
        r1 = android.os.Build.DEVICE;
        r6.append(r1);
        r1 = "_";
        r6.append(r1);
        r1 = android.os.Build.VERSION.RELEASE;
        r6.append(r1);
        r6 = r6.toString();
        org.apache.http.params.HttpProtocolParams.setUserAgent(r0, r6);
        r6 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
        r6.<init>(r0, r7);
        r7 = new org.apache.http.impl.client.DefaultHttpClient;
        r7.<init>(r6, r0);
        r5 = getProxy(r5);
        if (r5 == 0) goto L_0x00d8;
    L_0x00c6:
        r6 = new org.apache.http.HttpHost;
        r0 = r5.a;
        r5 = r5.b;
        r6.<init>(r0, r5);
        r5 = r7.getParams();
        r0 = "http.route.default-proxy";
        r5.setParameter(r0, r6);
    L_0x00d8:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.getHttpClient(android.content.Context, java.lang.String, java.lang.String):org.apache.http.client.HttpClient");
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 1;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if ((obj instanceof String) || (obj instanceof String[])) {
                int i2 = 0;
                StringBuilder stringBuilder2;
                if (obj instanceof String[]) {
                    if (i != 0) {
                        i = 0;
                    } else {
                        stringBuilder.append("&");
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(URLEncoder.encode(str));
                    stringBuilder2.append("=");
                    stringBuilder.append(stringBuilder2.toString());
                    String[] stringArray = bundle.getStringArray(str);
                    if (stringArray != null) {
                        while (i2 < stringArray.length) {
                            if (i2 == 0) {
                                stringBuilder.append(URLEncoder.encode(stringArray[i2]));
                            } else {
                                stringBuilder2 = new StringBuilder(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                stringBuilder2.append(stringArray[i2]);
                                stringBuilder.append(URLEncoder.encode(stringBuilder2.toString()));
                            }
                            i2++;
                        }
                    }
                } else {
                    if (i != 0) {
                        i = 0;
                    } else {
                        stringBuilder.append("&");
                    }
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(URLEncoder.encode(str));
                    stringBuilder2.append("=");
                    stringBuilder2.append(URLEncoder.encode(bundle.getString(str)));
                    stringBuilder.append(stringBuilder2.toString());
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String encodePostBody(Bundle bundle, String str) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = -1;
        int size = bundle.size();
        for (String str2 : bundle.keySet()) {
            i++;
            Object obj = bundle.get(str2);
            if (obj instanceof String) {
                StringBuilder stringBuilder2 = new StringBuilder("Content-Disposition: form-data; name=\"");
                stringBuilder2.append(str2);
                stringBuilder2.append("\"\r\n\r\n");
                stringBuilder2.append((String) obj);
                stringBuilder.append(stringBuilder2.toString());
                if (i < size - 1) {
                    StringBuilder stringBuilder3 = new StringBuilder("\r\n--");
                    stringBuilder3.append(str);
                    stringBuilder3.append("\r\n");
                    stringBuilder.append(stringBuilder3.toString());
                }
            }
        }
        return stringBuilder.toString();
    }

    public static c getProxy(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
            Object b = b(context);
            context = a(context);
            if (!TextUtils.isEmpty(b) && context >= null) {
                return new c(b, context);
            }
        }
        return null;
    }

    private static int a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 >= r1) goto L_0x0018;
    L_0x0006:
        if (r2 == 0) goto L_0x0013;
    L_0x0008:
        r2 = android.net.Proxy.getPort(r2);
        if (r2 >= 0) goto L_0x002a;
    L_0x000e:
        r2 = android.net.Proxy.getDefaultPort();
        goto L_0x002a;
    L_0x0013:
        r2 = android.net.Proxy.getDefaultPort();
        goto L_0x002a;
    L_0x0018:
        r2 = "http.proxyPort";
        r2 = java.lang.System.getProperty(r2);
        r0 = android.text.TextUtils.isEmpty(r2);
        if (r0 != 0) goto L_0x0029;
    L_0x0024:
        r2 = java.lang.Integer.parseInt(r2);	 Catch:{ NumberFormatException -> 0x0029 }
        goto L_0x002a;
    L_0x0029:
        r2 = -1;
    L_0x002a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.HttpUtils.a(android.content.Context):int");
    }

    private static String b(Context context) {
        if (VERSION.SDK_INT >= 11) {
            return System.getProperty("http.proxyHost");
        }
        if (context == null) {
            return Proxy.getDefaultHost();
        }
        context = Proxy.getHost(context);
        if (TextUtils.isEmpty(context)) {
            return Proxy.getDefaultHost();
        }
        return context;
    }
}
