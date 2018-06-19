package anet.channel.util;

import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Taobao */
public class h extends SSLSocketFactory {
    private final String a = "awcn.TlsSniSocketFactory";
    private Method b = null;
    private String c;

    public Socket createSocket() throws IOException {
        return null;
    }

    public Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        return null;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return null;
    }

    public h(String str) {
        this.c = str;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        if (this.c == null) {
            this.c = str;
        }
        if (ALog.isPrintLog(1)) {
            ALog.i("awcn.TlsSniSocketFactory", "customized createSocket", null, "host", this.c);
        }
        InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
        SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (VERSION.SDK_INT >= true) {
            sSLCertificateSocketFactory.setHostname(sSLSocket, this.c);
        } else {
            try {
                if (this.b == null) {
                    this.b = sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class});
                    this.b.setAccessible(true);
                }
                this.b.invoke(sSLSocket, new Object[]{this.c});
            } catch (Socket socket2) {
                ALog.w("awcn.TlsSniSocketFactory", "SNI not useable", null, socket2, new Object[0]);
            }
        }
        socket2 = sSLSocket.getSession();
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.TlsSniSocketFactory", null, null, "SSLSession PeerHost", socket2.getPeerHost());
        }
        return sSLSocket;
    }
}
