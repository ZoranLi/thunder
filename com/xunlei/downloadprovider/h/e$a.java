package com.xunlei.downloadprovider.h;

import android.support.v4.media.session.PlaybackStateCompat;
import com.xunlei.xllib.b.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: FileUtil */
class e$a {
    public static String a(File file) {
        InputStream fileInputStream;
        long length = file.length();
        length = (length < 0 || length > 134217728) ? (length <= 134217728 || length > 268435456) ? (length <= 268435456 || length > 536870912) ? 2097152 : PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : 524288 : PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
        byte[] bArr = new byte[8192];
        try {
            int i;
            MessageDigest messageDigest;
            String str;
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            fileInputStream = new FileInputStream(file);
            loop0:
            while (true) {
                i = 0;
                messageDigest = null;
                do {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break loop0;
                        }
                        if (messageDigest == null) {
                            messageDigest = MessageDigest.getInstance("SHA-1");
                        }
                        messageDigest.update(bArr, 0, read);
                        i += read;
                    } catch (NoSuchAlgorithmException e) {
                        file = e;
                    } catch (IOException e2) {
                        file = e2;
                    }
                } while (((long) i) < length);
                instance.update(messageDigest.digest());
            }
            if (i > 0) {
                instance.update(messageDigest.digest());
            }
            byte[] digest = instance.digest();
            if (digest != null) {
                if (digest.length != 0) {
                    str = new String(a.a(digest, 0, digest.length, 1));
                    fileInputStream.close();
                    return str;
                }
            }
            str = "";
            try {
                fileInputStream.close();
            } catch (File file2) {
                file2.printStackTrace();
            }
            return str;
        } catch (NoSuchAlgorithmException e3) {
            file2 = e3;
            fileInputStream = null;
            file2.printStackTrace();
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (File file22) {
                    file22.printStackTrace();
                }
            }
            return null;
        } catch (IOException e4) {
            file22 = e4;
            fileInputStream = null;
            try {
                file22.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (File file222) {
                        file222.printStackTrace();
                    }
                }
                return null;
            } catch (Throwable th) {
                file222 = th;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw file222;
            }
        } catch (Throwable th2) {
            file222 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw file222;
        }
    }
}
