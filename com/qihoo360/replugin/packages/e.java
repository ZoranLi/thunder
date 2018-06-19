package com.qihoo360.replugin.packages;

import android.text.TextUtils;
import com.qihoo360.replugin.utils.a.h;
import com.qihoo360.replugin.utils.b;
import com.qihoo360.replugin.utils.c;
import com.qihoo360.replugin.utils.d;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: PluginPublishFileGenerator */
public final class e {
    public static boolean a(String str, String str2, int i, int i2, int i3) {
        Closeable a;
        Closeable b;
        Closeable dataOutputStream;
        Closeable closeable = null;
        try {
            a = c.a(new File(str));
            try {
                b = c.b(new File(str2));
                try {
                    dataOutputStream = new DataOutputStream(b);
                } catch (Throwable th) {
                    str = th;
                    try {
                        str.printStackTrace();
                        b.a(closeable);
                        b.a(b);
                        b.a(a);
                        return false;
                    } catch (Throwable th2) {
                        str = th2;
                        dataOutputStream = closeable;
                        b.a(dataOutputStream);
                        b.a(b);
                        b.a(a);
                        throw str;
                    }
                }
            } catch (Throwable th3) {
                str = th3;
                b = null;
                dataOutputStream = b;
                b.a(dataOutputStream);
                b.a(b);
                b.a(a);
                throw str;
            }
            try {
                Object a2;
                dataOutputStream.writeInt(i);
                dataOutputStream.writeInt(i2);
                dataOutputStream.writeInt(i3);
                i = h.a(new File(str));
                if (i != 0) {
                    a2 = com.qihoo360.replugin.utils.a.e.a(i);
                }
                if (TextUtils.isEmpty(a2) != 0) {
                    b.a(dataOutputStream);
                    b.a(b);
                    b.a(a);
                    return false;
                }
                dataOutputStream.writeUTF(a2);
                dataOutputStream.writeInt(0);
                dataOutputStream.writeInt((int) new File(str).length());
                d.a((InputStream) a, (OutputStream) dataOutputStream);
                b.a(dataOutputStream);
                b.a(b);
                b.a(a);
                return true;
            } catch (Throwable th4) {
                str = th4;
                b.a(dataOutputStream);
                b.a(b);
                b.a(a);
                throw str;
            }
        } catch (Throwable th5) {
            str = th5;
            b = null;
            a = b;
            dataOutputStream = a;
            b.a(dataOutputStream);
            b.a(b);
            b.a(a);
            throw str;
        }
    }
}
