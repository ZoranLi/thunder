package com.bumptech.glide.load.model;

import android.content.Context;
import com.bumptech.glide.load.data.DataFetcher;
import java.util.HashMap;
import java.util.Map;

public class GenericLoaderFactory {
    private static final ModelLoader NULL_MODEL_LOADER = new ModelLoader() {
        public final String toString() {
            return "NULL_MODEL_LOADER";
        }

        public final DataFetcher getResourceFetcher(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }
    };
    private final Map<Class, Map<Class, ModelLoader>> cachedModelLoaders = new HashMap();
    private final Context context;
    private final Map<Class, Map<Class, ModelLoaderFactory>> modelClassToResourceFactories = new HashMap();

    public GenericLoaderFactory(Context context) {
        this.context = context.getApplicationContext();
    }

    public synchronized <T, Y> ModelLoaderFactory<T, Y> unregister(Class<T> cls, Class<Y> cls2) {
        ModelLoaderFactory<T, Y> modelLoaderFactory;
        this.cachedModelLoaders.clear();
        modelLoaderFactory = null;
        Map map = (Map) this.modelClassToResourceFactories.get(cls);
        if (map != null) {
            modelLoaderFactory = (ModelLoaderFactory) map.remove(cls2);
        }
        return modelLoaderFactory;
    }

    public synchronized <T, Y> ModelLoaderFactory<T, Y> register(Class<T> cls, Class<Y> cls2, ModelLoaderFactory<T, Y> modelLoaderFactory) {
        this.cachedModelLoaders.clear();
        Map map = (Map) this.modelClassToResourceFactories.get(cls);
        if (map == null) {
            map = new HashMap();
            this.modelClassToResourceFactories.put(cls, map);
        }
        cls = (ModelLoaderFactory) map.put(cls2, modelLoaderFactory);
        if (cls != null) {
            for (Y containsValue : this.modelClassToResourceFactories.values()) {
                if (containsValue.containsValue(cls) != null) {
                    cls = null;
                    break;
                }
            }
        }
        return cls;
    }

    @Deprecated
    public synchronized <T, Y> ModelLoader<T, Y> buildModelLoader(Class<T> cls, Class<Y> cls2, Context context) {
        return buildModelLoader(cls, cls2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T, Y> com.bumptech.glide.load.model.ModelLoader<T, Y> buildModelLoader(java.lang.Class<T> r3, java.lang.Class<Y> r4) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.getCachedLoader(r3, r4);	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0014;
    L_0x0007:
        r3 = NULL_MODEL_LOADER;	 Catch:{ all -> 0x0029 }
        r3 = r3.equals(r0);	 Catch:{ all -> 0x0029 }
        if (r3 == 0) goto L_0x0012;
    L_0x000f:
        r3 = 0;
        monitor-exit(r2);
        return r3;
    L_0x0012:
        monitor-exit(r2);
        return r0;
    L_0x0014:
        r1 = r2.getFactory(r3, r4);	 Catch:{ all -> 0x0029 }
        if (r1 == 0) goto L_0x0024;
    L_0x001a:
        r0 = r2.context;	 Catch:{ all -> 0x0029 }
        r0 = r1.build(r0, r2);	 Catch:{ all -> 0x0029 }
        r2.cacheModelLoader(r3, r4, r0);	 Catch:{ all -> 0x0029 }
        goto L_0x0027;
    L_0x0024:
        r2.cacheNullLoader(r3, r4);	 Catch:{ all -> 0x0029 }
    L_0x0027:
        monitor-exit(r2);
        return r0;
    L_0x0029:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.buildModelLoader(java.lang.Class, java.lang.Class):com.bumptech.glide.load.model.ModelLoader<T, Y>");
    }

    private <T, Y> void cacheNullLoader(Class<T> cls, Class<Y> cls2) {
        cacheModelLoader(cls, cls2, NULL_MODEL_LOADER);
    }

    private <T, Y> void cacheModelLoader(Class<T> cls, Class<Y> cls2, ModelLoader<T, Y> modelLoader) {
        Map map = (Map) this.cachedModelLoaders.get(cls);
        if (map == null) {
            map = new HashMap();
            this.cachedModelLoaders.put(cls, map);
        }
        map.put(cls2, modelLoader);
    }

    private <T, Y> ModelLoader<T, Y> getCachedLoader(Class<T> cls, Class<Y> cls2) {
        Map map = (Map) this.cachedModelLoaders.get(cls);
        return map != null ? (ModelLoader) map.get(cls2) : null;
    }

    private <T, Y> ModelLoaderFactory<T, Y> getFactory(Class<T> cls, Class<Y> cls2) {
        Map map = (Map) this.modelClassToResourceFactories.get(cls);
        ModelLoaderFactory<T, Y> modelLoaderFactory = map != null ? (ModelLoaderFactory) map.get(cls2) : null;
        if (modelLoaderFactory == null) {
            for (Class cls3 : this.modelClassToResourceFactories.keySet()) {
                if (cls3.isAssignableFrom(cls)) {
                    Map map2 = (Map) this.modelClassToResourceFactories.get(cls3);
                    if (map2 != null) {
                        modelLoaderFactory = (ModelLoaderFactory) map2.get(cls2);
                        if (modelLoaderFactory != null) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return modelLoaderFactory;
    }
}
