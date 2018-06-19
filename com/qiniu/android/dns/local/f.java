package com.qiniu.android.dns.local;

import com.alibaba.wireless.security.SecExceptionCode;
import com.qiniu.android.dns.DnsException;
import com.qiniu.android.dns.NetworkInfo;
import com.qiniu.android.dns.b;
import com.qiniu.android.dns.c;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/* compiled from: Resolver */
public final class f implements c {
    private static final Random b = new Random();
    final InetAddress a;
    private final int c;

    public f(InetAddress inetAddress) {
        this(inetAddress, (byte) 0);
    }

    private f(InetAddress inetAddress, byte b) {
        this.a = inetAddress;
        this.c = 10;
    }

    public final com.qiniu.android.dns.f[] a(b bVar, NetworkInfo networkInfo) throws IOException {
        int nextInt;
        synchronized (b) {
            nextInt = b.nextInt() & 255;
        }
        byte[] a = a(c.a(bVar.a, nextInt));
        if (a == null) {
            throw new DnsException(bVar.a, "cant get answer");
        }
        bVar = bVar.a;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(a));
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        if (readUnsignedShort != nextInt) {
            StringBuilder stringBuilder = new StringBuilder("the answer id ");
            stringBuilder.append(readUnsignedShort);
            stringBuilder.append(" is not match ");
            stringBuilder.append(nextInt);
            throw new DnsException(bVar, stringBuilder.toString());
        }
        nextInt = dataInputStream.readUnsignedShort();
        int i = 1;
        readUnsignedShort = ((nextInt >> 8) & 1) == 1 ? 1 : 0;
        if (((nextInt >> 7) & 1) != 1) {
            i = 0;
        }
        if (i != 0) {
            if (readUnsignedShort != 0) {
                int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                nextInt = dataInputStream.readUnsignedShort();
                dataInputStream.readUnsignedShort();
                dataInputStream.readUnsignedShort();
                c.a(dataInputStream, a, readUnsignedShort2);
                return c.b(dataInputStream, a, nextInt);
            }
        }
        throw new DnsException(bVar, "the dns server cant support recursion ");
    }

    private byte[] a(byte[] bArr) throws IOException {
        DatagramSocket datagramSocket;
        try {
            datagramSocket = new DatagramSocket();
            try {
                DatagramPacket datagramPacket = new DatagramPacket(bArr, bArr.length, this.a, 53);
                datagramSocket.setSoTimeout(this.c * 1000);
                datagramSocket.send(datagramPacket);
                bArr = new DatagramPacket(new byte[SecExceptionCode.SEC_ERROR_SIMULATORDETECT], SecExceptionCode.SEC_ERROR_SIMULATORDETECT);
                datagramSocket.receive(bArr);
                bArr = bArr.getData();
                datagramSocket.close();
                return bArr;
            } catch (Throwable th) {
                bArr = th;
                if (datagramSocket != null) {
                    datagramSocket.close();
                }
                throw bArr;
            }
        } catch (Throwable th2) {
            bArr = th2;
            datagramSocket = null;
            if (datagramSocket != null) {
                datagramSocket.close();
            }
            throw bArr;
        }
    }
}
