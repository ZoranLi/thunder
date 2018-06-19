package org.android.spdy;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class SoInstallMgrSdk {
    private static final String ARMEABI = "armeabi";
    private static final int EventID_SO_INIT = 21033;
    static final String LOGTAG = "INIT_SO";
    private static final String MIPS = "mips";
    private static final String X86 = "x86";
    static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    public static boolean initSo(String str, int i) {
        return initSo(str, i, null);
    }

    public static boolean initSo(String str, int i, ClassLoader classLoader) {
        boolean _loadUnzipSo;
        String _cpuType;
        boolean z = true;
        boolean z2 = false;
        if (classLoader == null) {
            try {
                System.loadLibrary(str);
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
                if (!z) {
                    try {
                        if (isExist(str, i)) {
                            _loadUnzipSo = _loadUnzipSo(str, i, classLoader);
                            if (!_loadUnzipSo) {
                                return _loadUnzipSo;
                            }
                            removeSoIfExit(str, i);
                        }
                        _cpuType = _cpuType();
                        try {
                            z2 = unZipSelectedFiles(str, i, classLoader);
                        } catch (String str2) {
                            str2.printStackTrace();
                        } catch (String str22) {
                            str22.printStackTrace();
                        }
                    } catch (String str222) {
                        str222.printStackTrace();
                    } catch (String str2222) {
                        str2222.printStackTrace();
                    } catch (String str22222) {
                        str22222.printStackTrace();
                    }
                    return z2;
                }
                z2 = z;
                return z2;
            } catch (UnsatisfiedLinkError e2) {
                e2.printStackTrace();
                z = false;
                if (z) {
                    if (isExist(str22222, i)) {
                        _loadUnzipSo = _loadUnzipSo(str22222, i, classLoader);
                        if (!_loadUnzipSo) {
                            return _loadUnzipSo;
                        }
                        removeSoIfExit(str22222, i);
                    }
                    _cpuType = _cpuType();
                    z2 = unZipSelectedFiles(str22222, i, classLoader);
                    return z2;
                }
                z2 = z;
                return z2;
            } catch (Error e3) {
                e3.printStackTrace();
                z = false;
                if (z) {
                    if (isExist(str22222, i)) {
                        _loadUnzipSo = _loadUnzipSo(str22222, i, classLoader);
                        if (!_loadUnzipSo) {
                            return _loadUnzipSo;
                        }
                        removeSoIfExit(str22222, i);
                    }
                    _cpuType = _cpuType();
                    z2 = unZipSelectedFiles(str22222, i, classLoader);
                    return z2;
                }
                z2 = z;
                return z2;
            }
        }
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = Runtime.class.getDeclaredMethod("loadLibrary", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str22222, classLoader});
        if (z) {
            if (isExist(str22222, i)) {
                _loadUnzipSo = _loadUnzipSo(str22222, i, classLoader);
                if (!_loadUnzipSo) {
                    return _loadUnzipSo;
                }
                removeSoIfExit(str22222, i);
            }
            _cpuType = _cpuType();
            if (!(_cpuType.equalsIgnoreCase(MIPS) || _cpuType.equalsIgnoreCase(X86))) {
                z2 = unZipSelectedFiles(str22222, i, classLoader);
                return z2;
            }
        }
        z2 = z;
        return z2;
    }

    private static java.lang.String _getFieldReflectively(android.os.Build r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.class;	 Catch:{ Exception -> 0x000f }
        r2 = r0.getField(r2);	 Catch:{ Exception -> 0x000f }
        r1 = r2.get(r1);	 Catch:{ Exception -> 0x000f }
        r1 = r1.toString();	 Catch:{ Exception -> 0x000f }
        return r1;
    L_0x000f:
        r1 = "Unknown";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.spdy.SoInstallMgrSdk._getFieldReflectively(android.os.Build, java.lang.String):java.lang.String");
    }

    private static String _cpuType() {
        String _getFieldReflectively = _getFieldReflectively(new Build(), "CPU_ABI");
        if (_getFieldReflectively == null || _getFieldReflectively.length() == 0 || _getFieldReflectively.equals("Unknown")) {
            _getFieldReflectively = ARMEABI;
        }
        return _getFieldReflectively.toLowerCase();
    }

    static String _targetSoFile(String str, int i) {
        Context context = mContext;
        if (context == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder("/data/data/");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("/files");
        String stringBuilder2 = stringBuilder.toString();
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            stringBuilder2 = filesDir.getPath();
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append("/lib");
        stringBuilder3.append(str);
        stringBuilder3.append("bk");
        stringBuilder3.append(i);
        stringBuilder3.append(".so");
        return stringBuilder3.toString();
    }

    static void removeSoIfExit(String str, int i) {
        i = new File(_targetSoFile(str, i));
        if (i.exists() != null) {
            i.delete();
        }
    }

    static boolean isExist(String str, int i) {
        return new File(_targetSoFile(str, i)).exists();
    }

    static boolean _loadUnzipSo(String str, int i, ClassLoader classLoader) {
        try {
            if (isExist(str, i)) {
                if (classLoader == null) {
                    System.load(_targetSoFile(str, i));
                } else {
                    Runtime runtime = Runtime.getRuntime();
                    Method declaredMethod = Runtime.class.getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(runtime, new Object[]{_targetSoFile(str, i), classLoader});
                }
            }
            return true;
        } catch (String str2) {
            str2.printStackTrace();
            return false;
        } catch (String str22) {
            str22.printStackTrace();
            return false;
        } catch (String str222) {
            str222.printStackTrace();
            return false;
        }
    }

    static boolean unZipSelectedFiles(String str, int i, ClassLoader classLoader) throws ZipException, IOException {
        InputStream inputStream;
        FileOutputStream openFileOutput;
        StringBuilder stringBuilder = new StringBuilder("lib/armeabi/lib");
        stringBuilder.append(str);
        stringBuilder.append(".so");
        String stringBuilder2 = stringBuilder.toString();
        try {
            String str2 = "";
            Context context = mContext;
            if (context == null) {
                return false;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                str2 = applicationInfo.sourceDir;
            }
            ZipFile zipFile = new ZipFile(str2);
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                if (zipEntry.getName().startsWith(stringBuilder2)) {
                    FileChannel fileChannel = null;
                    try {
                        removeSoIfExit(str, i);
                        inputStream = zipFile.getInputStream(zipEntry);
                        try {
                            StringBuilder stringBuilder3 = new StringBuilder(ShareConstants.SO_PATH);
                            stringBuilder3.append(str);
                            stringBuilder3.append("bk");
                            stringBuilder3.append(i);
                            stringBuilder3.append(".so");
                            openFileOutput = context.openFileOutput(stringBuilder3.toString(), 0);
                        } catch (Throwable th) {
                            str = th;
                            openFileOutput = null;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (int i2) {
                                    i2.printStackTrace();
                                }
                            }
                            if (fileChannel != null) {
                                try {
                                    fileChannel.close();
                                } catch (int i22) {
                                    i22.printStackTrace();
                                }
                            }
                            if (openFileOutput != null) {
                                try {
                                    openFileOutput.close();
                                } catch (int i222) {
                                    i222.printStackTrace();
                                }
                            }
                            zipFile.close();
                            throw str;
                        }
                        try {
                            FileChannel channel = openFileOutput.getChannel();
                            try {
                                byte[] bArr = new byte[1024];
                                int i3 = 0;
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    channel.write(ByteBuffer.wrap(bArr, 0, read));
                                    i3 += read;
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (channel != null) {
                                    try {
                                        channel.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (openFileOutput != null) {
                                    try {
                                        openFileOutput.close();
                                    } catch (Exception e22) {
                                        e22.printStackTrace();
                                    }
                                }
                                zipFile.close();
                                if (i3 > 0) {
                                    return _loadUnzipSo(str, i222, classLoader);
                                }
                                return false;
                            } catch (Throwable th2) {
                                str = th2;
                                fileChannel = channel;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (fileChannel != null) {
                                    fileChannel.close();
                                }
                                if (openFileOutput != null) {
                                    openFileOutput.close();
                                }
                                zipFile.close();
                                throw str;
                            }
                        } catch (Throwable th3) {
                            str = th3;
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                            if (openFileOutput != null) {
                                openFileOutput.close();
                            }
                            zipFile.close();
                            throw str;
                        }
                    } catch (Throwable th4) {
                        str = th4;
                        inputStream = null;
                        openFileOutput = inputStream;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileChannel != null) {
                            fileChannel.close();
                        }
                        if (openFileOutput != null) {
                            openFileOutput.close();
                        }
                        zipFile.close();
                        throw str;
                    }
                }
            }
            return false;
        } catch (String str3) {
            str3.printStackTrace();
        }
    }
}
