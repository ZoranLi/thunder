package com.qiniu.android.c.a;

import com.qiniu.android.c.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Date;

/* compiled from: FileRecorder */
public final class a implements j {
    public String a;

    public a(String str) throws IOException {
        this.a = str;
        File file = new File(str);
        if (file.exists() == null) {
            if (file.mkdirs() == null) {
                throw new IOException("mkdir failed");
            }
        } else if (file.isDirectory() == null) {
            throw new IOException("does not mkdir");
        }
    }

    private static String c(String str) {
        try {
            str = MessageDigest.getInstance("SHA-1").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : str) {
                stringBuffer.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return stringBuffer.toString();
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public final void a(String str, byte[] bArr) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(new File(this.a, c(str)));
            try {
                fileOutputStream.write(bArr);
            } catch (String str2) {
                bArr = str2;
                bArr.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (String str22) {
                        str22.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            bArr = e;
            fileOutputStream = null;
            bArr.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
    }

    public final byte[] a(String str) {
        byte[] bArr;
        FileInputStream fileInputStream;
        IOException e;
        File file = new File(this.a, c(str));
        str = null;
        try {
            if ((file.lastModified() + 172800000 < new Date().getTime() ? true : null) != null) {
                file.delete();
                return null;
            }
            bArr = new byte[((int) file.length())];
            try {
                fileInputStream = new FileInputStream(file);
            } catch (IOException e2) {
                e = e2;
                fileInputStream = null;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                if (str != null) {
                    return null;
                }
                return bArr;
            }
            try {
                str = fileInputStream.read(bArr);
            } catch (IOException e4) {
                e3 = e4;
                e3.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (str != null) {
                    return bArr;
                }
                return null;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (str != null) {
                return null;
            }
            return bArr;
        } catch (IOException e5) {
            e3 = e5;
            bArr = null;
            fileInputStream = bArr;
            e3.printStackTrace();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (str != null) {
                return bArr;
            }
            return null;
        }
    }

    public final void b(String str) {
        new File(this.a, c(str)).delete();
    }
}
