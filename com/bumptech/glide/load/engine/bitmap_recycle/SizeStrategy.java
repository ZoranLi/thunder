package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.Util;
import java.util.TreeMap;

@TargetApi(19)
class SizeStrategy implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap = new GroupedLinkedMap();
    private final KeyPool keyPool = new KeyPool();
    private final TreeMap<Integer, Integer> sortedSizes = new PrettyPrintTreeMap();

    static final class Key implements Poolable {
        private final KeyPool pool;
        private int size;

        Key(KeyPool keyPool) {
            this.pool = keyPool;
        }

        public final void init(int i) {
            this.size = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            if (this.size == ((Key) obj).size) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.size;
        }

        public final String toString() {
            return SizeStrategy.getBitmapString(this.size);
        }

        public final void offer() {
            this.pool.offer(this);
        }
    }

    static class KeyPool extends BaseKeyPool<Key> {
        KeyPool() {
        }

        public Key get(int i) {
            Key key = (Key) get();
            key.init(i);
            return key;
        }

        protected Key create() {
            return new Key(this);
        }
    }

    SizeStrategy() {
    }

    public void put(Bitmap bitmap) {
        Key key = this.keyPool.get(Util.getBitmapByteSize(bitmap));
        this.groupedMap.put(key, bitmap);
        Integer num = (Integer) this.sortedSizes.get(Integer.valueOf(key.size));
        TreeMap treeMap = this.sortedSizes;
        Integer valueOf = Integer.valueOf(key.size);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        treeMap.put(valueOf, Integer.valueOf(i));
    }

    public Bitmap get(int i, int i2, Config config) {
        int bitmapByteSize = Util.getBitmapByteSize(i, i2, config);
        Poolable poolable = this.keyPool.get(bitmapByteSize);
        Integer num = (Integer) this.sortedSizes.ceilingKey(Integer.valueOf(bitmapByteSize));
        if (!(num == null || num.intValue() == bitmapByteSize || num.intValue() > bitmapByteSize * 8)) {
            this.keyPool.offer(poolable);
            poolable = this.keyPool.get(num.intValue());
        }
        Bitmap bitmap = (Bitmap) this.groupedMap.get(poolable);
        if (bitmap != null) {
            bitmap.reconfigure(i, i2, config);
            decrementBitmapOfSize(num);
        }
        return bitmap;
    }

    public Bitmap removeLast() {
        Bitmap bitmap = (Bitmap) this.groupedMap.removeLast();
        if (bitmap != null) {
            decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(bitmap)));
        }
        return bitmap;
    }

    private void decrementBitmapOfSize(Integer num) {
        Integer num2 = (Integer) this.sortedSizes.get(num);
        if (num2.intValue() == 1) {
            this.sortedSizes.remove(num);
        } else {
            this.sortedSizes.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public String logBitmap(Bitmap bitmap) {
        return getBitmapString(bitmap);
    }

    public String logBitmap(int i, int i2, Config config) {
        return getBitmapString(Util.getBitmapByteSize(i, i2, config));
    }

    public int getSize(Bitmap bitmap) {
        return Util.getBitmapByteSize(bitmap);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SizeStrategy:\n  ");
        stringBuilder.append(this.groupedMap);
        stringBuilder.append("\n  SortedSizes");
        stringBuilder.append(this.sortedSizes);
        return stringBuilder.toString();
    }

    private static String getBitmapString(Bitmap bitmap) {
        return getBitmapString(Util.getBitmapByteSize(bitmap));
    }

    private static String getBitmapString(int i) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(i);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
