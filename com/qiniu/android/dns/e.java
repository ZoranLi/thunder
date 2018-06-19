package com.qiniu.android.dns;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;

/* compiled from: Network */
public final class e {
    private static String a = "";

    public static String a() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.connect(InetAddress.getByName("114.114.114.114"), 53);
            InetAddress localAddress = datagramSocket.getLocalAddress();
            datagramSocket.close();
            return localAddress.getHostAddress();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static synchronized boolean b() {
        synchronized (e.class) {
            String a = a();
            if (a.equals(a)) {
                return false;
            }
            a = a;
            return true;
        }
    }
}
