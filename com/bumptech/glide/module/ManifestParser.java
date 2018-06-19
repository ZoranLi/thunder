package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.List;

public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private final Context context;

    public ManifestParser(Context context) {
        this.context = context;
    }

    public final List<GlideModule> parse() {
        List<GlideModule> arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(parseModule(str));
                    }
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }

    private static GlideModule parseModule(String str) {
        StringBuilder stringBuilder;
        try {
            str = Class.forName(str);
            try {
                Object newInstance = str.newInstance();
                if ((newInstance instanceof GlideModule) != null) {
                    return (GlideModule) newInstance;
                }
                StringBuilder stringBuilder2 = new StringBuilder("Expected instanceof GlideModule, but found: ");
                stringBuilder2.append(newInstance);
                throw new RuntimeException(stringBuilder2.toString());
            } catch (Throwable e) {
                stringBuilder = new StringBuilder("Unable to instantiate GlideModule implementation for ");
                stringBuilder.append(str);
                throw new RuntimeException(stringBuilder.toString(), e);
            } catch (Throwable e2) {
                stringBuilder = new StringBuilder("Unable to instantiate GlideModule implementation for ");
                stringBuilder.append(str);
                throw new RuntimeException(stringBuilder.toString(), e2);
            }
        } catch (String str2) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", str2);
        }
    }
}
