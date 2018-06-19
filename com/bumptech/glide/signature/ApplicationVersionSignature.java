package com.bumptech.glide.signature;

import android.content.Context;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class ApplicationVersionSignature {
    private static final ConcurrentHashMap<String, Key> PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();

    public static Key obtain(Context context) {
        String packageName = context.getPackageName();
        Key key = (Key) PACKAGE_NAME_TO_KEY.get(packageName);
        if (key != null) {
            return key;
        }
        key = obtainVersionSignature(context);
        Key key2 = (Key) PACKAGE_NAME_TO_KEY.putIfAbsent(packageName, key);
        return key2 == null ? key : key2;
    }

    static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }

    private static Key obtainVersionSignature(Context context) {
        try {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (Context context2) {
            context2.printStackTrace();
            context2 = null;
        }
        if (context2 != null) {
            context2 = String.valueOf(context2.versionCode);
        } else {
            context2 = UUID.randomUUID().toString();
        }
        return new StringSignature(context2);
    }

    private ApplicationVersionSignature() {
    }
}
