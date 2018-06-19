package com.xunlei.downloadprovider.h;

import android.text.TextUtils;
import com.xunlei.downloadprovider.app.e;
import java.io.File;
import java.io.FileInputStream;
import org.json.JSONObject;

/* compiled from: CacheUtils */
public final class d {
    public static JSONObject a(File file) {
        e.a("You should not parse json or read file on main thread");
        try {
            if (b(file)) {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                Object str = new String(bArr);
                if (!TextUtils.isEmpty(str)) {
                    return new JSONObject(str);
                }
                return null;
            }
            new StringBuilder("file is not exist:").append(file.getName());
            return null;
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("exception when read json:");
            stringBuilder.append(file.getName());
            stringBuilder.append(" ");
            stringBuilder.append(e.getMessage());
            e.printStackTrace();
        }
    }

    public static boolean b(File file) {
        return (file == null || !file.exists() || file.isFile() == null) ? null : true;
    }
}
