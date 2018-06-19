package com.qihoo360.replugin.component.provider;

import android.content.ContentProvider;
import android.net.Uri;
import android.text.TextUtils;
import com.qihoo360.replugin.RePlugin;
import com.qihoo360.replugin.b.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: PluginProviderHelper */
public final class a {
    Map<String, ContentProvider> a = new HashMap();
    private final String b;

    /* compiled from: PluginProviderHelper */
    static class a {
        Uri a;
        String b;

        a() {
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(" [");
            stringBuilder.append(this.b);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    a(String str) {
        this.b = str;
    }

    public final a a(Uri uri) {
        if (c.a) {
            new StringBuilder("toPluginUri(): Start... Uri=").append(uri);
        }
        if (TextUtils.equals(uri.getAuthority(), this.b)) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.size() < 2) {
                if (c.a != null) {
                    new StringBuilder("toPluginUri(): Less than 2 fragments, size=").append(pathSegments.size());
                }
                return null;
            }
            String str = (String) pathSegments.get(0);
            if (RePlugin.isPluginInstalled(str)) {
                uri = uri.toString();
                int length = (((10 + this.b.length()) + 1) + str.length()) + 1;
                StringBuilder stringBuilder = new StringBuilder("content://");
                stringBuilder.append(uri.substring(length, uri.length()));
                uri = stringBuilder.toString();
                a aVar = new a();
                aVar.b = str;
                aVar.a = Uri.parse(uri);
                if (c.a != null) {
                    new StringBuilder("toPluginUri(): End! t-uri=").append(aVar);
                }
                return aVar;
            }
            uri = c.a;
            return null;
        }
        if (c.a) {
            new StringBuilder("toPluginUri(): Authority error! auth=").append(uri.getAuthority());
        }
        return null;
    }

    public final ContentProvider a(a aVar) {
        if (c.a) {
            new StringBuilder("getProvider(): Start... pu=").append(aVar);
        }
        String authority = aVar.a.getAuthority();
        ContentProvider contentProvider = (ContentProvider) this.a.get(authority);
        if (contentProvider != null) {
            if (c.a != null) {
                new StringBuilder("getProvider(): Exists! Return now. cp=").append(contentProvider);
            }
            return contentProvider;
        }
        contentProvider = a(aVar, authority);
        if (contentProvider == null) {
            aVar = c.a;
            return null;
        }
        this.a.put(authority, contentProvider);
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder("getProvider(): Okay! pu=");
            stringBuilder.append(aVar);
            stringBuilder.append("; cp=");
            stringBuilder.append(contentProvider);
        }
        return contentProvider;
    }

    private static android.content.ContentProvider a(com.qihoo360.replugin.component.provider.a.a r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.b;
        r0 = com.qihoo360.i.Factory.queryPluginComponentList(r0);
        r1 = 0;
        if (r0 != 0) goto L_0x000c;
    L_0x0009:
        r3 = com.qihoo360.replugin.b.c.a;
        return r1;
    L_0x000c:
        r4 = r0.getProviderByAuthority(r4);
        if (r4 != 0) goto L_0x0015;
    L_0x0012:
        r3 = com.qihoo360.replugin.b.c.a;
        return r1;
    L_0x0015:
        r3 = r3.b;
        r3 = com.qihoo360.i.Factory.queryPluginContext(r3);
        if (r3 != 0) goto L_0x0020;
    L_0x001d:
        r3 = com.qihoo360.replugin.b.c.a;
        return r1;
    L_0x0020:
        r0 = r3.getClassLoader();
        if (r0 != 0) goto L_0x0029;
    L_0x0026:
        r3 = com.qihoo360.replugin.b.c.a;
        return r1;
    L_0x0029:
        r2 = r4.name;	 Catch:{ Throwable -> 0x003c }
        r0 = r0.loadClass(r2);	 Catch:{ Throwable -> 0x003c }
        r0 = r0.newInstance();	 Catch:{ Throwable -> 0x003c }
        r0 = (android.content.ContentProvider) r0;	 Catch:{ Throwable -> 0x003c }
        r0.attachInfo(r3, r4);	 Catch:{ Throwable -> 0x0039 }
        return r0;
    L_0x0039:
        r3 = com.qihoo360.replugin.b.c.a;
        return r1;
    L_0x003c:
        r3 = com.qihoo360.replugin.b.c.a;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.component.provider.a.a(com.qihoo360.replugin.component.provider.a$a, java.lang.String):android.content.ContentProvider");
    }
}
