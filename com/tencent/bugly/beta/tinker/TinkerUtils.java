package com.tencent.bugly.beta.tinker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.util.TinkerLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Formatter;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* compiled from: BUGLY */
public class TinkerUtils {
    public static final int ERROR_PATCH_CONDITION_NOT_SATISFIED = -24;
    public static final int ERROR_PATCH_CRASH_LIMIT = -23;
    public static final int ERROR_PATCH_GOOGLEPLAY_CHANNEL = -20;
    public static final int ERROR_PATCH_MEMORY_LIMIT = -22;
    public static final int ERROR_PATCH_ROM_SPACE = -21;
    public static final int MIN_MEMORY_HEAP_SIZE = 45;
    public static final String PLATFORM = "platform";
    private static final String TAG = "Tinker.TinkerUtils";
    private static boolean background = false;

    /* compiled from: BUGLY */
    public static class ScreenState {

        /* compiled from: BUGLY */
        interface IOnScreenOff {
            void onScreenOff();
        }

        ScreenState(Context context, final IOnScreenOff iOnScreenOff) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            context.registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    TinkerLog.i(TinkerUtils.TAG, "ScreenReceiver action [%s] ", intent == null ? "" : intent.getAction());
                    if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction()) != null) {
                        if (iOnScreenOff != null) {
                            iOnScreenOff.onScreenOff();
                        }
                        context.unregisterReceiver(this);
                    }
                }
            }, intentFilter);
        }
    }

    public static boolean isGooglePlay() {
        return false;
    }

    public static boolean isBackground() {
        return background;
    }

    public static void setBackground(boolean z) {
        background = z;
    }

    public static int checkForPatchRecover(long j, int i) {
        if (isGooglePlay()) {
            return -20;
        }
        if (i < 45) {
            return -22;
        }
        return checkRomSpaceEnough(j) == null ? -21 : 0;
    }

    public static boolean isXposedExists(Throwable th) {
        for (StackTraceElement className : th.getStackTrace()) {
            String className2 = className.getClassName();
            if (className2 != null && className2.contains("de.robv.android.xposed.XposedBridge")) {
                return true;
            }
        }
        return false;
    }

    @java.lang.Deprecated
    public static boolean checkRomSpaceEnough(long r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r2 = android.os.Environment.getDataDirectory();	 Catch:{ Exception -> 0x0026 }
        r3 = new android.os.StatFs;	 Catch:{ Exception -> 0x0026 }
        r2 = r2.getPath();	 Catch:{ Exception -> 0x0026 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0026 }
        r2 = r3.getAvailableBlocks();	 Catch:{ Exception -> 0x0026 }
        r4 = (long) r2;	 Catch:{ Exception -> 0x0026 }
        r2 = r3.getBlockSize();	 Catch:{ Exception -> 0x0026 }
        r6 = (long) r2;
        r4 = r4 * r6;
        r2 = r3.getBlockCount();	 Catch:{ Exception -> 0x0027 }
        r6 = (long) r2;	 Catch:{ Exception -> 0x0027 }
        r2 = r3.getBlockSize();	 Catch:{ Exception -> 0x0027 }
        r2 = (long) r2;
        r2 = r2 * r6;
        goto L_0x0028;
    L_0x0026:
        r4 = r0;
    L_0x0027:
        r2 = r0;
    L_0x0028:
        r6 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1));
        if (r6 == 0) goto L_0x0032;
    L_0x002c:
        r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1));
        if (r0 <= 0) goto L_0x0032;
    L_0x0030:
        r8 = 1;
        return r8;
    L_0x0032:
        r8 = 0;
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.tinker.TinkerUtils.checkRomSpaceEnough(long):boolean");
    }

    public static String getExceptionCauseString(Throwable th) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (th != null) {
            try {
                if (th.getCause() == null) {
                    break;
                }
                th = th.getCause();
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (th != null) {
            th.printStackTrace(printStream);
        }
        th = toVisualString(byteArrayOutputStream.toString());
        try {
            byteArrayOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        return th;
    }

    private static String toVisualString(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > '') {
                toCharArray[i] = '\u0000';
                c = '\u0001';
                break;
            }
            i++;
        }
        c = '\u0000';
        return c != '\u0000' ? new String(toCharArray, 0, i) : str;
    }

    public static boolean copy(File file, File file2) throws IOException {
        if (file != null) {
            if (file2 != null) {
                if (!file.exists()) {
                    return false;
                }
                BufferedInputStream bufferedInputStream = null;
                try {
                    String absolutePath = file2.getAbsolutePath();
                    File file3 = new File(absolutePath.substring(0, absolutePath.lastIndexOf(File.separator)));
                    if (!file3.exists()) {
                        file3.mkdirs();
                    }
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        file = new BufferedOutputStream(new FileOutputStream(file2));
                    } catch (Throwable th) {
                        file = th;
                        file2 = null;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (file2 != null) {
                            try {
                                file2.close();
                            } catch (File file22) {
                                file22.printStackTrace();
                            }
                        }
                        throw file;
                    }
                    try {
                        file22 = new byte[5120];
                        while (true) {
                            int read = bufferedInputStream2.read(file22);
                            if (read == -1) {
                                break;
                            }
                            file.write(file22, 0, read);
                        }
                        file.flush();
                        try {
                            bufferedInputStream2.close();
                        } catch (File file222) {
                            file222.printStackTrace();
                        }
                        try {
                            file.close();
                        } catch (File file4) {
                            file4.printStackTrace();
                        }
                        return true;
                    } catch (File file2222) {
                        bufferedInputStream = bufferedInputStream2;
                        File file5 = file2222;
                        file2222 = file4;
                        file4 = file5;
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (file2222 != null) {
                            file2222.close();
                        }
                        throw file4;
                    }
                } catch (Throwable th2) {
                    file4 = th2;
                    file2222 = null;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (file2222 != null) {
                        file2222.close();
                    }
                    throw file4;
                }
            }
        }
        return false;
    }

    public static String getSignature(Context context) {
        String str = "";
        try {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (context == null || context.length <= 0) {
                return str;
            }
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context[0].toByteArray()));
            MessageDigest.getInstance("SHA-1");
            return new String(x509Certificate.getEncoded());
        } catch (Context context2) {
            context2.printStackTrace();
            return str;
        }
    }

    public static String bytesToHexString(byte[] bArr, boolean z) {
        if (bArr == null) {
            return "";
        }
        int length = bArr.length;
        Appendable stringBuffer = new StringBuffer(length * 2);
        Formatter formatter = new Formatter(stringBuffer);
        for (int i = 0; i < length; i++) {
            formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i])});
        }
        formatter.close();
        return z ? stringBuffer.toString().toUpperCase() : stringBuffer.toString().toLowerCase();
    }

    public static byte[] readJarEntry(File file, String str) {
        if (file != null) {
            try {
                if (file.exists()) {
                    if (!TextUtils.isEmpty(str)) {
                        return readJarEntry(new JarFile(file), str);
                    }
                }
            } catch (File file2) {
                file2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] readJarEntry(JarFile jarFile, String str) {
        if (jarFile != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return readJarEntry(jarFile, jarFile.getJarEntry(str));
                }
            } catch (JarFile jarFile2) {
                jarFile2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static byte[] readJarEntry(JarFile jarFile, JarEntry jarEntry) {
        if (jarFile != null) {
            if (jarEntry != null) {
                try {
                    return readBytes(jarFile.getInputStream(jarEntry));
                } catch (JarFile jarFile2) {
                    jarFile2.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }

    public static byte[] readBytes(InputStream inputStream) {
        try {
            byte[] bArr = new byte[512];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (InputStream inputStream2) {
            inputStream2.printStackTrace();
            return null;
        }
    }

    public static void rollbackPatch(Context context) {
        Tinker.with(context).rollbackPatch();
    }
}
