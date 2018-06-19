package com.xunlei.downloadprovider.download.tasklist.list.feed.e;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.xunlei.downloadprovider.personal.message.data.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* compiled from: TaskListFeedBaseNetwork */
public class b extends a {
    protected static String a(String str) throws NoSuchAlgorithmException {
        str = MessageDigest.getInstance("SHA1").digest(str.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : str) {
            stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    protected static void a(StringBuilder stringBuilder, String str, Object obj) {
        boolean b = b(stringBuilder.toString());
        obj = String.valueOf(obj);
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(obj)) {
                stringBuilder.append(b ? "" : "&");
                stringBuilder.append(str);
                stringBuilder.append("=");
                str = Uri.encode(obj);
                obj = new StringBuilder();
                if (!TextUtils.isEmpty(str)) {
                    for (int i = 0; i < str.length(); i++) {
                        char charAt = str.charAt(i);
                        String valueOf = String.valueOf(charAt);
                        if (charAt == '!') {
                            valueOf = "%21";
                        } else if (charAt == '$') {
                            valueOf = "%24";
                        } else if (charAt == '@') {
                            valueOf = "%40";
                        } else if (charAt == '`') {
                            valueOf = "%60";
                        } else if (charAt != '|') {
                            switch (charAt) {
                                case '\'':
                                    valueOf = "%27";
                                    break;
                                case '(':
                                    valueOf = "%28";
                                    break;
                                case ')':
                                    valueOf = "%29";
                                    break;
                                case '*':
                                    valueOf = "%2A";
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            valueOf = "%7C";
                        }
                        obj.append(valueOf);
                    }
                }
                stringBuilder.append(obj.toString());
            }
        }
    }

    protected static void a(@NonNull Map<String, String> map, String str, Object obj) {
        obj = String.valueOf(obj);
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(obj)) {
                map.put(str, obj);
            }
        }
    }

    protected static boolean b(String str) {
        str = str.substring(str.length() - 1, str.length());
        if (!str.equals("?")) {
            if (str.equals("&") == null) {
                return null;
            }
        }
        return true;
    }

    protected static int a(VolleyError volleyError) {
        return volleyError.networkResponse == null ? -1 : volleyError.networkResponse.a;
    }
}
