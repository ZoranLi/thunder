package com.xunlei.downloadlib.proguard;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: XLLog */
public final class c {
    final String a;
    final String b;
    final d c;
    final long d;
    private final int e;

    public c(String str) {
        str = a(str);
        long parseLong = Long.parseLong(a(str, "LOG_FILE_SIZE", "0"));
        if (parseLong == 0) {
            parseLong = 20971520;
        }
        this.d = parseLong;
        this.c = d.a(a(str, "LOG_LEVEL", "").toLowerCase());
        this.b = a(str, "LOG_FILE", "");
        this.a = a(str, "LOG_DIR", "");
        if (!TextUtils.isEmpty(this.b)) {
            if (!TextUtils.isEmpty(this.a)) {
                str = Integer.parseInt(a(str, "LOG_DESTINATION_TYPE", "0"));
                if (str > null) {
                    this.e = str;
                    return;
                } else {
                    this.e = 3;
                    return;
                }
            }
        }
        this.e = null;
    }

    public final boolean a() {
        return (this.e & 1) > 0;
    }

    public final boolean b() {
        return (this.e & 2) > 0;
    }

    private String a(Map<String, String> map, String str, String str2) {
        String str3 = (String) map.get(str);
        return str3 == null ? str2 : str3;
    }

    private Map<String, String> a(String str) {
        File file = new File(str);
        str = new HashMap();
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                String str2 = "";
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder stringBuilder2 = new StringBuilder();
                while (true) {
                    int read = fileInputStream.read();
                    if (read != -1) {
                        if (stringBuilder.length() == 0 && read == 35) {
                            do {
                                read = fileInputStream.read();
                                if (read == -1 || read == 13) {
                                    break;
                                }
                            } while (read != 10);
                        } else if (!(read == 32 || read == 9)) {
                            if (read == 61) {
                                str2 = stringBuilder.toString();
                            } else {
                                if (read != 10) {
                                    if (read != 13) {
                                        if (str2.length() == 0) {
                                            stringBuilder.append((char) read);
                                        } else {
                                            stringBuilder2.append((char) read);
                                        }
                                    }
                                }
                                if (stringBuilder.length() != 0) {
                                    str.put(str2, stringBuilder2.toString());
                                    str2 = "";
                                    stringBuilder = new StringBuilder();
                                    stringBuilder2 = new StringBuilder();
                                }
                            }
                        }
                    } else {
                        fileInputStream.close();
                        return str;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }
}
