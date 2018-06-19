package com.xunlei.downloadprovider.thirdpart.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Base64;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

public class XLContentProvider extends ContentProvider {
    private static String a = "com.xunlei.downloadprovider.info";

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        return false;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        XLContentProvider.class.getSimpleName();
        strArr = new StringBuilder("niux : ");
        strArr.append(uri.toString());
        strArr.append(str2);
        strArr = new b();
        if ("xl863mmc6cg".equals(str2) != null) {
            uri = uri.getAuthority();
            str = LoginHelper.a();
            if (!(a.equals(uri) == null || l.b() == null)) {
                strArr.a = a(str.c());
                strArr.b = (int) str.g.c();
                strArr.c = str.d();
                strArr.d = str.g.d();
            }
        }
        return strArr;
    }

    private String a(String str) {
        String str2 = "";
        try {
            return new String(Base64.encode(a.a(str.getBytes(), a.a(getContext().getResources().getAssets().open("rsa_public_key.pem"))), 2));
        } catch (String str3) {
            str3.printStackTrace();
            return str2;
        }
    }
}
