package com.qiniu.android.dns.local;

import com.qiniu.android.dns.DnsException;
import com.qiniu.android.dns.f;
import com.qiniu.android.dns.util.a;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

/* compiled from: DnsMessage */
public final class c {
    public static byte[] a(String str, int i) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        a aVar = new a();
        aVar.a |= 256;
        try {
            dataOutputStream.writeShort((short) i);
            dataOutputStream.writeShort((short) aVar.a);
            dataOutputStream.writeShort(1);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
            dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            a(byteArrayOutputStream, str);
            dataOutputStream.writeShort(1);
            dataOutputStream.writeShort(1);
            return byteArrayOutputStream.toByteArray();
        } catch (String str2) {
            throw new AssertionError(str2);
        }
    }

    private static void a(OutputStream outputStream, String str) throws IOException {
        for (String toASCII : str.split("[.。．｡]")) {
            byte[] bytes = IDN.toASCII(toASCII).getBytes();
            outputStream.write(bytes.length);
            outputStream.write(bytes, 0, bytes.length);
        }
        outputStream.write(0);
    }

    private static String a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if ((readUnsignedByte & 192) == 192) {
            readUnsignedByte = ((readUnsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(readUnsignedByte));
            return a(bArr, readUnsignedByte, hashSet);
        } else if (readUnsignedByte == 0) {
            return "";
        } else {
            byte[] bArr2 = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr2);
            String toUnicode = IDN.toUnicode(new String(bArr2));
            dataInputStream = a(dataInputStream, bArr);
            if (dataInputStream.length() > null) {
                bArr = new StringBuilder();
                bArr.append(toUnicode);
                bArr.append(".");
                bArr.append(dataInputStream);
                toUnicode = bArr.toString();
            }
            return toUnicode;
        }
    }

    private static String a(byte[] bArr, int i, HashSet<Integer> hashSet) throws IOException {
        while (true) {
            int i2 = bArr[i] & 255;
            if ((i2 & 192) != 192) {
                break;
            }
            i = (bArr[i + 1] & 255) + ((i2 & 63) << 8);
            if (hashSet.contains(Integer.valueOf(i))) {
                throw new DnsException("", "Cyclic offsets detected.");
            }
            hashSet.add(Integer.valueOf(i));
        }
        if (i2 == 0) {
            return "";
        }
        i++;
        String str = new String(bArr, i, i2);
        bArr = a(bArr, i + i2, (HashSet) hashSet);
        if (bArr.length() > 0) {
            i = new StringBuilder();
            i.append(str);
            i.append(".");
            i.append(bArr);
            str = i.toString();
        }
        return str;
    }

    static void a(DataInputStream dataInputStream, byte[] bArr, int i) throws IOException {
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                a(dataInputStream, bArr);
                dataInputStream.readUnsignedShort();
                dataInputStream.readUnsignedShort();
                i = i2;
            } else {
                return;
            }
        }
    }

    static f[] b(DataInputStream dataInputStream, byte[] bArr, int i) throws IOException {
        int i2 = i;
        f[] fVarArr = new f[i2];
        int i3 = 0;
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return fVarArr;
            }
            String hostAddress;
            String str;
            i2 = i3 + 1;
            a(dataInputStream, bArr);
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            dataInputStream.readUnsignedShort();
            long readUnsignedShort2 = (((long) dataInputStream.readUnsignedShort()) << 16) + ((long) dataInputStream.readUnsignedShort());
            int readUnsignedShort3 = dataInputStream.readUnsignedShort();
            if (readUnsignedShort == 1) {
                byte[] bArr2 = new byte[4];
                dataInputStream.readFully(bArr2);
                hostAddress = InetAddress.getByAddress(bArr2).getHostAddress();
            } else if (readUnsignedShort != 5) {
                str = null;
                for (int i5 = 0; i5 < readUnsignedShort3; i5++) {
                    dataInputStream.readByte();
                }
                r12 = dataInputStream;
                if (str != null) {
                    throw new UnknownHostException("no record");
                }
                fVarArr[i3] = new f(str, readUnsignedShort, (int) readUnsignedShort2, System.currentTimeMillis() / 1000);
                i3 = i2;
                i2 = i4;
            } else {
                hostAddress = a(dataInputStream, bArr);
                r12 = dataInputStream;
            }
            str = hostAddress;
            if (str != null) {
                fVarArr[i3] = new f(str, readUnsignedShort, (int) readUnsignedShort2, System.currentTimeMillis() / 1000);
                i3 = i2;
                i2 = i4;
            } else {
                throw new UnknownHostException("no record");
            }
        }
    }
}
