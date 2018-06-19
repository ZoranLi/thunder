package com.xunlei.analytics.c;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.xunlei.downloadprovider.ad.common.adget.b.b;
import com.xunlei.downloadprovider.ad.home.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.c;
import com.xunlei.downloadprovider.pushmessage.e;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;

public class d {
    public static final String a = "guid";
    private static String b = "d";
    private static final String[] c = new String[]{"0", "1", "2", "3", "4", "5", Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", "a", b.a, c.a, com.xunlei.downloadprovider.ad.downloadlist.d.a, e.a, f.a};
    private static final String d = "mac";
    private static final String e = "imei";
    private static final String f = ".mainiconfig";
    private static d l;
    private String g = "999999999999";
    private String h = "020000000000";
    private String i = "999999999999999";
    private Map<String, String> j;
    private Context k;

    private d(Context context) {
        this.k = context;
        this.j = c(context);
        c();
    }

    public static d a(Context context) {
        if (l == null) {
            synchronized (d.class) {
                if (l == null) {
                    l = new d(context);
                }
            }
        }
        return l;
    }

    private static String a(byte b) {
        int i;
        if (b < (byte) 0) {
            i = b + 256;
        }
        int i2 = i / 16;
        i %= 16;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c[i2]);
        stringBuilder.append(c[i]);
        return stringBuilder.toString();
    }

    public static String a(String str) {
        String str2;
        NoSuchAlgorithmException e;
        if (str == null) {
            return "";
        }
        try {
            str2 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                e.printStackTrace();
                return str2;
            }
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            str2 = null;
            e.printStackTrace();
            return str2;
        }
    }

    private static String a(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.toLowerCase());
        stringBuilder.append("_");
        stringBuilder.append(str2);
        return a(stringBuilder.toString());
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte a : bArr) {
            stringBuffer.append(a(a));
        }
        return stringBuffer.toString();
    }

    public static boolean a(Map<String, String> map, Context context) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b(context));
        stringBuilder.append(f);
        File file = new File(stringBuilder.toString());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.exists()) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                JSONObject jSONObject = new JSONObject();
                for (Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
                bufferedWriter.write(jSONObject.toString());
                bufferedWriter.flush();
                bufferedWriter.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String b(Context context) {
        Environment.getExternalStorageDirectory().getAbsolutePath();
        String absolutePath = context.getFilesDir().getAbsolutePath();
        if (absolutePath.endsWith("/")) {
            return absolutePath;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(absolutePath);
        stringBuilder.append("/");
        return stringBuilder.toString();
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new String(""));
        stringBuilder.append(str);
        str = stringBuilder.toString();
        String[] strArr = null;
        if (str != null && str.length() > 2) {
            strArr = str.split(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
            str = "";
        }
        if (strArr != null && strArr.length > 1) {
            for (String str2 : strArr) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(str2);
                str = stringBuilder2.toString();
            }
        }
        return str;
    }

    public static Map<String, String> c(Context context) {
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        Map<String, String> hashMap = new HashMap();
        if (!d(context)) {
            return hashMap;
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(b(context));
            stringBuilder.append(f);
            bufferedReader = new BufferedReader(new FileReader(new File(stringBuilder.toString())));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    JSONObject jSONObject = new JSONObject(readLine);
                    if (jSONObject.has(a)) {
                        hashMap.put(a, (String) jSONObject.get(a));
                    }
                    if (jSONObject.has("mac")) {
                        hashMap.put("mac", (String) jSONObject.get("mac"));
                    }
                    if (jSONObject.has("imei")) {
                        hashMap.put("imei", (String) jSONObject.get("imei"));
                    }
                }
                bufferedReader.close();
                try {
                    bufferedReader.close();
                    return hashMap;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return hashMap;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                        return hashMap;
                    }
                    return hashMap;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e222) {
            e = e222;
            bufferedReader = null;
            e.printStackTrace();
            if (bufferedReader != null) {
                bufferedReader.close();
                return hashMap;
            }
            return hashMap;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    private void c() {
        String str = (String) this.j.get("mac");
        String str2 = (String) this.j.get("imei");
        String str3 = (String) this.j.get(a);
        String b = b(str);
        StringBuilder stringBuilder = new StringBuilder("file saved mac delete colon is : ");
        stringBuilder.append(b);
        e.a(stringBuilder.toString());
        Object obj = null;
        boolean z = (!this.j.containsKey("mac") || TextUtils.isEmpty(str) || this.g.equals(b) || this.h.equals(b)) ? false : true;
        boolean z2 = (!this.j.containsKey("imei") || TextUtils.isEmpty(str2) || this.i.equals(str2)) ? false : true;
        StringBuilder stringBuilder2 = new StringBuilder("file saved mac available : ");
        stringBuilder2.append(z);
        e.a(stringBuilder2.toString());
        stringBuilder2 = new StringBuilder("file saved imei available : ");
        stringBuilder2.append(z2);
        e.a(stringBuilder2.toString());
        if (z && z2) {
            str2 = a(b(str), str2);
            stringBuilder2 = new StringBuilder("current guid is: ");
            stringBuilder2.append(str2);
            stringBuilder2.append("  file saved guid is: ");
            stringBuilder2.append(str3);
            e.a(stringBuilder2.toString());
            if (!str2.equals(str3)) {
                StringBuilder stringBuilder3 = new StringBuilder("guid compared not equal !!!!  rewrite !!!   guid :");
                stringBuilder3.append(str2);
                stringBuilder3.append("    mac :");
                stringBuilder3.append(str.toLowerCase());
                e.a(stringBuilder3.toString());
                this.j.put(a, str2);
                this.j.put("mac", str.toLowerCase());
                a(this.j, this.k);
                return;
            }
        }
        if (!(z2 && z)) {
            str = b.c(this.k);
            str2 = b(str);
            Object obj2;
            if (TextUtils.isEmpty(str2) || this.g.equals(str2) || this.h.equals(str2)) {
                obj2 = null;
            } else {
                this.j.put("mac", str);
                stringBuilder3 = new StringBuilder("mac now get successed and  not default : ");
                stringBuilder3.append(str);
                stringBuilder3.append("       del colon : ");
                stringBuilder3.append(str2);
                e.a(stringBuilder3.toString());
                obj2 = 1;
            }
            str3 = b.b(this.k);
            if (!(TextUtils.isEmpty(str3) || this.i.equals(str3))) {
                this.j.put("imei", str3);
                StringBuilder stringBuilder4 = new StringBuilder("imei now get successed and  not default : ");
                stringBuilder4.append(str3);
                e.a(stringBuilder4.toString());
                obj = 1;
            }
            if (!(obj == null || r0 == null)) {
                str2 = a(str2, str3);
                this.j.put(a, str2);
                stringBuilder3 = new StringBuilder("both sucessed  generate guid : ");
                stringBuilder3.append(str2);
                e.a(stringBuilder3.toString());
            }
            if (!(obj == null && r0 == null)) {
                e.a("rewrite guid file");
                a(this.j, this.k);
            }
        }
    }

    public static boolean d(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b(context));
        stringBuilder.append(f);
        return new File(stringBuilder.toString()).exists();
    }

    public String a() {
        String str = (String) this.j.get(a);
        if (TextUtils.isEmpty(str)) {
            Object obj;
            str = b.c(this.k);
            String b = b(str);
            Object obj2 = 1;
            if (TextUtils.isEmpty(b) || this.g.equals(b) || this.h.equals(b)) {
                obj = null;
            } else {
                this.j.put("mac", str);
                StringBuilder stringBuilder = new StringBuilder("reget mac success   and  not empty and not default : ");
                stringBuilder.append(str);
                stringBuilder.append("   delcolon : ");
                stringBuilder.append(b);
                e.a(stringBuilder.toString());
                obj = 1;
            }
            String b2 = b.b(this.k);
            if (TextUtils.isEmpty(b2) || this.i.equals(b2)) {
                obj2 = null;
            } else {
                this.j.put("imei", b2);
                StringBuilder stringBuilder2 = new StringBuilder("reget imei success   and  not empty and not default : ");
                stringBuilder2.append(b2);
                e.a(stringBuilder2.toString());
            }
            if (obj == null) {
                b = this.g;
            }
            if (obj2 == null) {
                b2 = this.i;
            }
            String a = a(b, b2);
            StringBuilder stringBuilder3 = new StringBuilder("regenerate Guid : ");
            stringBuilder3.append(a);
            stringBuilder3.append("    macColon : ");
            stringBuilder3.append(b);
            stringBuilder3.append("     imei: ");
            stringBuilder3.append(b2);
            e.a(stringBuilder3.toString());
            if (!(obj2 == null && obj == null)) {
                this.j.put(a, a);
                a(this.j, this.k);
                e.a("rewrite guid file");
            }
            return a;
        }
        StringBuilder stringBuilder4 = new StringBuilder("get guid , not empty  return guid : ");
        stringBuilder4.append(str);
        e.a(stringBuilder4.toString());
        return str;
    }

    public void b() {
        e.a("force update : only call after get permission");
        c();
    }
}
