package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        static <A> ModelKey<A> get(A a, int i, int i2) {
            ModelKey<A> modelKey = (ModelKey) KEY_QUEUE.poll();
            if (modelKey == null) {
                modelKey = new ModelKey();
            }
            modelKey.init(a, i, i2);
            return modelKey;
        }

        private ModelKey() {
        }

        private void init(A a, int i, int i2) {
            this.model = a;
            this.width = i;
            this.height = i2;
        }

        public final void release() {
            KEY_QUEUE.offer(this);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model) != null) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (31 * ((this.height * 31) + this.width)) + this.model.hashCode();
        }
    }

    public ModelCache() {
        this(250);
    }

    public ModelCache(int i) {
        this.cache = new LruCache<ModelKey<A>, B>(i) {
            protected void onItemEvicted(ModelKey<A> modelKey, B b) {
                modelKey.release();
            }
        };
    }

    public B get(A a, int i, int i2) {
        a = ModelKey.get(a, i, i2);
        i = this.cache.get(a);
        a.release();
        return i;
    }

    public void put(A a, int i, int i2, B b) {
        this.cache.put(ModelKey.get(a, i, i2), b);
    }
}
