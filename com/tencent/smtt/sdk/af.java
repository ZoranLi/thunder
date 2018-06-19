package com.tencent.smtt.sdk;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

class af {
    private static af a;
    private static Context b;

    private af() {
    }

    static af a(Context context) {
        if (a == null) {
            synchronized (af.class) {
                if (a == null) {
                    a = new af();
                }
            }
        }
        b = context.getApplicationContext();
        return a;
    }

    private Properties e() {
        Properties properties;
        InputStream bufferedInputStream;
        Exception e;
        Throwable th;
        InputStream inputStream;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File a = a();
            properties = new Properties();
            if (a != null) {
                try {
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(a));
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                                return properties;
                            } catch (IOException e3) {
                                e3.printStackTrace();
                                return properties;
                            }
                        }
                        return properties;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e32) {
                                e32.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream2 = bufferedInputStream;
                } catch (Exception e4) {
                    inputStream = bufferedInputStream;
                    e = e4;
                    bufferedInputStream2 = inputStream;
                    e.printStackTrace();
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                        return properties;
                    }
                    return properties;
                } catch (Throwable th3) {
                    inputStream = bufferedInputStream;
                    th = th3;
                    bufferedInputStream2 = inputStream;
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                    return properties;
                } catch (IOException e322) {
                    e322.printStackTrace();
                }
            }
            return properties;
        } catch (Exception e5) {
            e = e5;
            properties = null;
            e.printStackTrace();
            if (bufferedInputStream2 != null) {
                bufferedInputStream2.close();
                return properties;
            }
            return properties;
        }
    }

    File a() {
        aj.a();
        File file = new File(aj.o(b), "tbscoreinstall.txt");
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    void a(int i) {
        a("dexopt_retry_num", i);
    }

    void a(int i, int i2) {
        a("copy_core_ver", i);
        a("copy_status", i2);
    }

    void a(String str) {
        a("install_apk_path", str);
    }

    void a(String str, int i) {
        a(str, String.valueOf(i));
    }

    void a(String str, String str2) {
        Exception e;
        Throwable th;
        FileOutputStream fileOutputStream = null;
        try {
            Properties e2 = e();
            if (e2 != null) {
                e2.setProperty(str, str2);
                File a = a();
                if (a != null) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(a);
                    try {
                        StringBuilder stringBuilder = new StringBuilder("update ");
                        stringBuilder.append(str);
                        stringBuilder.append(" and status!");
                        e2.store(fileOutputStream2, stringBuilder.toString());
                        fileOutputStream = fileOutputStream2;
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        try {
                            e.printStackTrace();
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e42) {
                    e42.printStackTrace();
                }
            }
        } catch (Exception e6) {
            e = e6;
            e.printStackTrace();
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    int b() {
        return c("install_core_ver");
    }

    int b(String str) {
        Properties e = e();
        return (e == null || e.getProperty(str) == null) ? -1 : Integer.parseInt(e.getProperty(str));
    }

    void b(int i) {
        a("unzip_retry_num", i);
    }

    void b(int i, int i2) {
        a("install_core_ver", i);
        a("install_status", i2);
    }

    int c() {
        return b("install_status");
    }

    int c(String str) {
        Properties e = e();
        return (e == null || e.getProperty(str) == null) ? 0 : Integer.parseInt(e.getProperty(str));
    }

    void c(int i) {
        a("incrupdate_status", i);
    }

    int d() {
        return b("incrupdate_status");
    }

    String d(String str) {
        Properties e = e();
        return (e == null || e.getProperty(str) == null) ? null : e.getProperty(str);
    }

    void d(int i) {
        a("unlzma_status", i);
    }
}
