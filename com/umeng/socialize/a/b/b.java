package com.umeng.socialize.a.b;

import android.os.Environment;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.AesHelper;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.Log;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileUtil */
public class b {
    private static b b = new b();
    private String a = "";

    private b() {
        try {
            this.a = ContextUtil.getContext().getCacheDir().getCanonicalPath();
        } catch (IOException e) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(UmengText.FET_CACHE_PATH_ERROR);
            stringBuilder.append(e.getMessage());
            Log.um(stringBuilder.toString());
        }
    }

    public static b a() {
        if (b == null) {
            return new b();
        }
        return b;
    }

    public File b() throws IOException {
        a.b();
        File file = new File(c(), d());
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
        return file;
    }

    public File c() throws IOException {
        String canonicalPath;
        if (Environment.getExternalStorageDirectory() != null && !TextUtils.isEmpty(Environment.getExternalStorageDirectory().getCanonicalPath())) {
            canonicalPath = Environment.getExternalStorageDirectory().getCanonicalPath();
        } else if (TextUtils.isEmpty(this.a)) {
            throw new IOException("dirpath is unknow");
        } else {
            canonicalPath = this.a;
            Log.um(UmengText.SD_NOT_FOUNT);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(canonicalPath);
        stringBuilder.append(c.f);
        File file = new File(stringBuilder.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public byte[] a(File file) {
        InputStream fileInputStream;
        Exception e;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                file = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        file.write(bArr, 0, read);
                    }
                    bArr = file.toByteArray();
                    try {
                        fileInputStream.close();
                        file.close();
                    } catch (File file2) {
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(UmengText.READ_IMAGE_ERROR);
                        stringBuilder3.append(file2.getMessage());
                        Log.um(stringBuilder3.toString());
                    }
                    return bArr;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(UmengText.READ_IMAGE_ERROR);
                        stringBuilder.append(e.getMessage());
                        Log.um(stringBuilder.toString());
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (File file22) {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(UmengText.READ_IMAGE_ERROR);
                                stringBuilder2.append(file22.getMessage());
                                Log.um(stringBuilder2.toString());
                                return null;
                            }
                        }
                        if (file22 != null) {
                            file22.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (File file222) {
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(UmengText.READ_IMAGE_ERROR);
                                stringBuilder2.append(file222.getMessage());
                                Log.um(stringBuilder2.toString());
                                throw th;
                            }
                        }
                        if (file222 != null) {
                            file222.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                file222 = null;
                stringBuilder = new StringBuilder();
                stringBuilder.append(UmengText.READ_IMAGE_ERROR);
                stringBuilder.append(e.getMessage());
                Log.um(stringBuilder.toString());
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (file222 != null) {
                    file222.close();
                }
                return null;
            } catch (File file2222) {
                th = file2222;
                file2222 = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (file2222 != null) {
                    file2222.close();
                }
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            file2222 = null;
            fileInputStream = file2222;
            stringBuilder = new StringBuilder();
            stringBuilder.append(UmengText.READ_IMAGE_ERROR);
            stringBuilder.append(e.getMessage());
            Log.um(stringBuilder.toString());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (file2222 != null) {
                file2222.close();
            }
            return null;
        } catch (File file22222) {
            fileInputStream = null;
            th = file22222;
            file22222 = fileInputStream;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (file22222 != null) {
                file22222.close();
            }
            throw th;
        }
    }

    public String d() {
        return AesHelper.md5(String.valueOf(System.currentTimeMillis()));
    }
}
