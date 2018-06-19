package anetwork.channel.cache;

import android.support.v4.media.session.PlaybackStateCompat;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import anetwork.channel.cache.Cache.Entry;
import com.taobao.alivfssdk.cache.AVFSCache;
import com.taobao.alivfssdk.cache.AVFSCacheConfig;
import com.taobao.alivfssdk.cache.AVFSCacheManager;
import com.taobao.alivfssdk.cache.IAVFSCache;
import com.taobao.alivfssdk.cache.IAVFSCache.OnObjectSetCallback;

/* compiled from: Taobao */
final class a implements Cache {
    private static boolean a = false;
    private static Object b;
    private static Object c;

    a() {
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "com.taobao.alivfssdk.cache.AVFSCacheManager";	 Catch:{ ClassNotFoundException -> 0x0014 }
        java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x0014 }
        r0 = new anetwork.channel.cache.b;	 Catch:{ ClassNotFoundException -> 0x0014 }
        r0.<init>();	 Catch:{ ClassNotFoundException -> 0x0014 }
        b = r0;	 Catch:{ ClassNotFoundException -> 0x0014 }
        r0 = new anetwork.channel.cache.c;	 Catch:{ ClassNotFoundException -> 0x0014 }
        r0.<init>();	 Catch:{ ClassNotFoundException -> 0x0014 }
        c = r0;	 Catch:{ ClassNotFoundException -> 0x0014 }
        return;
    L_0x0014:
        r0 = 0;
        a = r0;
        r1 = "anet.AVFSCacheImpl";
        r2 = "no alivfs sdk!";
        r3 = 0;
        r0 = new java.lang.Object[r0];
        anet.channel.util.ALog.w(r1, r2, r3, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.cache.a.<clinit>():void");
    }

    public static void a() {
        if (a) {
            AVFSCache cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
            if (cacheForModule != null) {
                AVFSCacheConfig aVFSCacheConfig = new AVFSCacheConfig();
                aVFSCacheConfig.limitSize = Long.valueOf(5242880);
                aVFSCacheConfig.fileMemMaxSize = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
                cacheForModule.moduleConfig(aVFSCacheConfig);
            }
        }
    }

    public final Entry a(String str) {
        if (!a) {
            return null;
        }
        try {
            IAVFSCache b = b();
            if (b != null) {
                return (Entry) b.objectForKey(StringUtils.md5ToHex(str));
            }
        } catch (String str2) {
            ALog.e("anet.AVFSCacheImpl", "get cache failed", null, str2, new Object[0]);
        }
        return null;
    }

    public final void a(String str, Entry entry) {
        if (a) {
            try {
                IAVFSCache b = b();
                if (b != null) {
                    b.setObjectForKey(StringUtils.md5ToHex(str), entry, (OnObjectSetCallback) b);
                }
            } catch (String str2) {
                ALog.e("anet.AVFSCacheImpl", "put cache failed", null, str2, new Object[0]);
            }
        }
    }

    private static IAVFSCache b() {
        AVFSCache cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
        return cacheForModule != null ? cacheForModule.getFileCache() : null;
    }
}
