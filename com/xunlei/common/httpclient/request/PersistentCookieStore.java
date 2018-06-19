package com.xunlei.common.httpclient.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;

public class PersistentCookieStore implements CookieStore {
    private static final String COOKIE_NAME_PREFIX = "cookie_";
    private static final String COOKIE_NAME_STORE = "names";
    private static final String COOKIE_PREFS = "CookiePrefsFile";
    private final SharedPreferences cookiePrefs;
    private final ConcurrentHashMap<String, Cookie> cookies = new ConcurrentHashMap();

    public PersistentCookieStore(Context context) {
        int i = 0;
        this.cookiePrefs = context.getSharedPreferences(COOKIE_PREFS, 0);
        context = this.cookiePrefs.getString(COOKIE_NAME_STORE, null);
        if (context != null) {
            context = TextUtils.split(context, Constants.ACCEPT_TIME_SEPARATOR_SP);
            int length = context.length;
            while (i < length) {
                String str = context[i];
                SharedPreferences sharedPreferences = this.cookiePrefs;
                StringBuilder stringBuilder = new StringBuilder(COOKIE_NAME_PREFIX);
                stringBuilder.append(str);
                String string = sharedPreferences.getString(stringBuilder.toString(), null);
                if (string != null) {
                    Cookie decodeCookie = decodeCookie(string);
                    if (decodeCookie != null) {
                        this.cookies.put(str, decodeCookie);
                    }
                }
                i++;
            }
            clearExpired(new Date());
        }
    }

    public void addCookie(Cookie cookie) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cookie.getName());
        stringBuilder.append(cookie.getDomain());
        String stringBuilder2 = stringBuilder.toString();
        if (cookie.isExpired(new Date())) {
            this.cookies.remove(stringBuilder2);
        } else {
            this.cookies.put(stringBuilder2, cookie);
        }
        Editor edit = this.cookiePrefs.edit();
        edit.putString(COOKIE_NAME_STORE, TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, this.cookies.keySet()));
        StringBuilder stringBuilder3 = new StringBuilder(COOKIE_NAME_PREFIX);
        stringBuilder3.append(stringBuilder2);
        edit.putString(stringBuilder3.toString(), encodeCookie(new d(cookie)));
        edit.apply();
    }

    public void clear() {
        Editor edit = this.cookiePrefs.edit();
        for (String str : this.cookies.keySet()) {
            StringBuilder stringBuilder = new StringBuilder(COOKIE_NAME_PREFIX);
            stringBuilder.append(str);
            edit.remove(stringBuilder.toString());
        }
        edit.remove(COOKIE_NAME_STORE);
        edit.apply();
        this.cookies.clear();
    }

    public boolean clearExpired(Date date) {
        Editor edit = this.cookiePrefs.edit();
        boolean z = false;
        for (Entry entry : this.cookies.entrySet()) {
            String str = (String) entry.getKey();
            if (((Cookie) entry.getValue()).isExpired(date)) {
                this.cookies.remove(str);
                StringBuilder stringBuilder = new StringBuilder(COOKIE_NAME_PREFIX);
                stringBuilder.append(str);
                edit.remove(stringBuilder.toString());
                z = true;
            }
        }
        if (z) {
            edit.putString(COOKIE_NAME_STORE, TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, this.cookies.keySet()));
        }
        edit.apply();
        return z;
    }

    public List<Cookie> getCookies() {
        return new ArrayList(this.cookies.values());
    }

    protected String encodeCookie(d dVar) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(dVar);
            return byteArrayToHexString(byteArrayOutputStream.toByteArray());
        } catch (d dVar2) {
            dVar2.printStackTrace();
            return null;
        }
    }

    protected Cookie decodeCookie(String str) {
        try {
            return ((d) new ObjectInputStream(new ByteArrayInputStream(hexStringToByteArray(str))).readObject()).a();
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    protected String byteArrayToHexString(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length << 1);
        for (byte b : bArr) {
            int i = b & 255;
            if (i < 16) {
                stringBuffer.append('0');
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        return stringBuffer.toString().toUpperCase();
    }

    protected byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }
}
