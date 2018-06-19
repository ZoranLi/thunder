package com.alibaba.sdk.android.feedback.xblink.g;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class b extends SSLSocketFactory {
    private SSLSocketFactory a;
    private String b;
    private int c;
    private String d;

    public b(String str, int i, SSLSocketFactory sSLSocketFactory, String str2) {
        this.b = str;
        this.c = i;
        if (sSLSocketFactory != null) {
            this.a = sSLSocketFactory;
        } else {
            this.a = (SSLSocketFactory) SSLSocketFactory.getDefault();
        }
        this.d = str2;
    }

    private void a(java.net.Socket r7, java.lang.String r8, int r9) {
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
        r6 = this;
        r0 = r7.getOutputStream();
        r1 = new java.lang.StringBuilder;
        r2 = "CONNECT ";
        r1.<init>(r2);
        r1.append(r8);
        r2 = ":";
        r1.append(r2);
        r1.append(r9);
        r9 = " HTTP/1.1\nUser-Agent: ";
        r1.append(r9);
        r9 = r6.d;
        r1.append(r9);
        r9 = "\nHost:";
        r1.append(r9);
        r1.append(r8);
        r8 = "\r\n\r\n";
        r1.append(r8);
        r8 = r1.toString();
        r9 = "ASCII7";	 Catch:{ UnsupportedEncodingException -> 0x0038 }
        r9 = r8.getBytes(r9);	 Catch:{ UnsupportedEncodingException -> 0x0038 }
        goto L_0x003c;
    L_0x0038:
        r9 = r8.getBytes();
    L_0x003c:
        r0.write(r9);
        r0.flush();
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r9 = new byte[r8];
        r7 = r7.getInputStream();
        r0 = 0;
        r1 = r0;
        r2 = r1;
        r3 = r2;
    L_0x004e:
        r4 = 2;
        if (r1 >= r4) goto L_0x0077;
    L_0x0051:
        r4 = r7.read();
        if (r4 >= 0) goto L_0x005f;
    L_0x0057:
        r7 = new java.io.IOException;
        r8 = "Unexpected EOF from proxy";
        r7.<init>(r8);
        throw r7;
    L_0x005f:
        r5 = 10;
        if (r4 != r5) goto L_0x0067;
    L_0x0063:
        r1 = r1 + 1;
        r3 = 1;
        goto L_0x004e;
    L_0x0067:
        r5 = 13;
        if (r4 == r5) goto L_0x004e;
    L_0x006b:
        if (r3 != 0) goto L_0x0075;
    L_0x006d:
        if (r2 >= r8) goto L_0x0075;
    L_0x006f:
        r1 = r2 + 1;
        r4 = (byte) r4;
        r9[r2] = r4;
        r2 = r1;
    L_0x0075:
        r1 = r0;
        goto L_0x004e;
    L_0x0077:
        r7 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x007f }
        r8 = "ASCII7";	 Catch:{ UnsupportedEncodingException -> 0x007f }
        r7.<init>(r9, r0, r2, r8);	 Catch:{ UnsupportedEncodingException -> 0x007f }
        goto L_0x0084;
    L_0x007f:
        r7 = new java.lang.String;
        r7.<init>(r9, r0, r2);
    L_0x0084:
        r8 = r7.toLowerCase();
        r9 = "200 connection established";
        r8 = r8.contains(r9);
        if (r8 != 0) goto L_0x00bd;
    L_0x0090:
        r8 = new java.io.IOException;
        r9 = new java.lang.StringBuilder;
        r0 = "Unable to tunnel through ";
        r9.<init>(r0);
        r0 = r6.b;
        r9.append(r0);
        r0 = ":";
        r9.append(r0);
        r0 = r6.c;
        r9.append(r0);
        r0 = ".  Proxy returns \"";
        r9.append(r0);
        r9.append(r7);
        r7 = "\"";
        r9.append(r7);
        r7 = r9.toString();
        r8.<init>(r7);
        throw r8;
    L_0x00bd:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.g.b.a(java.net.Socket, java.lang.String, int):void");
    }

    public Socket createSocket(String str, int i) {
        return createSocket(null, str, i, true);
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return createSocket(null, str, i, true);
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return createSocket(null, inetAddress.getHostName(), i, true);
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return createSocket(null, inetAddress.getHostName(), i, true);
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        socket = new Socket(this.b, this.c);
        a(socket, str, i);
        SSLSocket sSLSocket = (SSLSocket) this.a.createSocket(socket, str, i, z);
        sSLSocket.addHandshakeCompletedListener(new c(this));
        sSLSocket.startHandshake();
        return sSLSocket;
    }

    public String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    public String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }
}
