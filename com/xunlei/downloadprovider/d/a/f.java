package com.xunlei.downloadprovider.d.a;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.app.e;
import com.xunlei.downloadprovider.h.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: ConfigUtils */
public final class f {
    public static String b(String str) {
        e.a("You should not parse json or read file on main thread");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(a(str));
        if (d.b(file) == null) {
            return null;
        }
        try {
            str = new FileInputStream(file);
            byte[] bArr = new byte[str.available()];
            str.read(bArr);
            return new String(bArr);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static String a(String str, String str2) {
        InputStreamReader inputStreamReader;
        char[] cArr;
        int read;
        e.a("You should not parse json or read file on main thread");
        try {
            if (!(str.startsWith("file://") || str.startsWith("/"))) {
                str = a(str);
            }
            File file = new File(str);
            str = file.exists() != null ? new FileInputStream(file) : null;
            if (str == null && !TextUtils.isEmpty(str2)) {
                try {
                    str = BrothersApplication.getApplicationInstance().getAssets().open(str2);
                } catch (String str22) {
                    str22.printStackTrace();
                }
            }
        } catch (String str3) {
            str3.printStackTrace();
            if (TextUtils.isEmpty(str22) == null) {
                try {
                    str3 = BrothersApplication.getApplicationInstance().getAssets().open(str22);
                } catch (String str32) {
                    str32.printStackTrace();
                    str32 = null;
                    if (str32 != null) {
                        str22 = new StringBuilder();
                        try {
                            inputStreamReader = new InputStreamReader(str32);
                            try {
                                cArr = new char[1024];
                                while (true) {
                                    read = inputStreamReader.read(cArr, 0, 1024);
                                    if (read > 0) {
                                        break;
                                    }
                                    str22.append(cArr, 0, read);
                                }
                                str22 = str22.toString();
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                try {
                                    str32.close();
                                    return str22;
                                } catch (String str322) {
                                    str322.printStackTrace();
                                    return str22;
                                }
                            } catch (IOException e2) {
                                str22 = e2;
                                try {
                                    str22.printStackTrace();
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (String str222) {
                                            str222.printStackTrace();
                                        }
                                    }
                                    try {
                                        str322.close();
                                    } catch (String str3222) {
                                        str3222.printStackTrace();
                                    }
                                    return null;
                                } catch (Throwable th) {
                                    str222 = th;
                                    if (inputStreamReader != null) {
                                        try {
                                            inputStreamReader.close();
                                        } catch (IOException e3) {
                                            e3.printStackTrace();
                                        }
                                    }
                                    try {
                                        str3222.close();
                                    } catch (String str32222) {
                                        str32222.printStackTrace();
                                    }
                                    throw str222;
                                }
                            }
                        } catch (IOException e4) {
                            str222 = e4;
                            inputStreamReader = null;
                            str222.printStackTrace();
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            str32222.close();
                            return null;
                        } catch (Throwable th2) {
                            str222 = th2;
                            inputStreamReader = null;
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            str32222.close();
                            throw str222;
                        }
                    }
                    return null;
                }
            }
            str32222 = null;
        } catch (Throwable th3) {
            if (!TextUtils.isEmpty(str222)) {
                try {
                    BrothersApplication.getApplicationInstance().getAssets().open(str222);
                } catch (String str2222) {
                    str2222.printStackTrace();
                }
            }
        }
        if (str32222 != null) {
            str2222 = new StringBuilder();
            inputStreamReader = new InputStreamReader(str32222);
            cArr = new char[1024];
            while (true) {
                read = inputStreamReader.read(cArr, 0, 1024);
                if (read > 0) {
                    break;
                }
                str2222.append(cArr, 0, read);
            }
            str2222 = str2222.toString();
            inputStreamReader.close();
            str32222.close();
            return str2222;
        }
        return null;
    }

    @Nullable
    public static String a(File file) {
        InputStream fileInputStream;
        Exception e;
        Throwable th;
        e.a("You should not parse json or read file on main thread");
        String str = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (File file2) {
            file2.printStackTrace();
            fileInputStream = null;
        }
        if (fileInputStream == null) {
            return null;
        }
        try {
            file2 = new InputStreamReader(fileInputStream, "UTF-8");
            try {
                StringBuilder stringBuilder = new StringBuilder(1024);
                char[] cArr = new char[4096];
                for (int read = file2.read(cArr); read > 0; read = file2.read(cArr)) {
                    stringBuilder.append(cArr, 0, read);
                }
                String stringBuilder2 = stringBuilder.toString();
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                try {
                    file2.close();
                } catch (File file22) {
                    file22.printStackTrace();
                }
                str = stringBuilder2;
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    try {
                        fileInputStream.close();
                    } catch (IOException e22) {
                        e22.printStackTrace();
                    }
                    if (file22 != null) {
                        try {
                            file22.close();
                        } catch (File file222) {
                            file222.printStackTrace();
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        fileInputStream.close();
                    } catch (IOException e222) {
                        e222.printStackTrace();
                    }
                    if (file222 != null) {
                        try {
                            file222.close();
                        } catch (File file2222) {
                            file2222.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e4) {
            e = e4;
            file2222 = null;
            e.printStackTrace();
            fileInputStream.close();
            if (file2222 != null) {
                file2222.close();
            }
            return str;
        } catch (File file22222) {
            th = file22222;
            file22222 = null;
            fileInputStream.close();
            if (file22222 != null) {
                file22222.close();
            }
            throw th;
        }
        return str;
    }

    public static void a(File file, String str) throws IOException {
        e.a("You should not write file on main thread");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }

    public static long a() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        return currentTimeMillis - (currentTimeMillis % TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
    }

    public static String a(String str) {
        File cacheDir = BrothersApplication.getApplicationInstance().getCacheDir();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cacheDir.getAbsolutePath());
        stringBuilder.append(File.separator);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
