package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class DiskCacheWriteLocker {
    private final Map<Key, WriteLock> locks = new HashMap();
    private final WriteLockPool writeLockPool = new WriteLockPool();

    private static class WriteLock {
        int interestedThreads;
        final Lock lock;

        private WriteLock() {
            this.lock = new ReentrantLock();
        }
    }

    private static class WriteLockPool {
        private static final int MAX_POOL_SIZE = 10;
        private final Queue<WriteLock> pool;

        private WriteLockPool() {
            this.pool = new ArrayDeque();
        }

        WriteLock obtain() {
            WriteLock writeLock;
            synchronized (this.pool) {
                writeLock = (WriteLock) this.pool.poll();
            }
            return writeLock == null ? new WriteLock() : writeLock;
        }

        void offer(WriteLock writeLock) {
            synchronized (this.pool) {
                if (this.pool.size() < 10) {
                    this.pool.offer(writeLock);
                }
            }
        }
    }

    DiskCacheWriteLocker() {
    }

    final void acquire(Key key) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) this.locks.get(key);
            if (writeLock == null) {
                writeLock = this.writeLockPool.obtain();
                this.locks.put(key, writeLock);
            }
            writeLock.interestedThreads++;
        }
        writeLock.lock.lock();
    }

    final void release(Key key) {
        WriteLock writeLock;
        synchronized (this) {
            writeLock = (WriteLock) this.locks.get(key);
            if (writeLock != null) {
                if (writeLock.interestedThreads > 0) {
                    int i = writeLock.interestedThreads - 1;
                    writeLock.interestedThreads = i;
                    if (i == 0) {
                        WriteLock writeLock2 = (WriteLock) this.locks.remove(key);
                        if (writeLock2.equals(writeLock)) {
                            this.writeLockPool.offer(writeLock2);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder("Removed the wrong lock, expected to remove: ");
                            stringBuilder.append(writeLock);
                            stringBuilder.append(", but actually removed: ");
                            stringBuilder.append(writeLock2);
                            stringBuilder.append(", key: ");
                            stringBuilder.append(key);
                            throw new IllegalStateException(stringBuilder.toString());
                        }
                    }
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("Cannot release a lock that is not held, key: ");
            stringBuilder2.append(key);
            stringBuilder2.append(", interestedThreads: ");
            stringBuilder2.append(writeLock == null ? null : writeLock.interestedThreads);
            throw new IllegalArgumentException(stringBuilder2.toString());
        }
        writeLock.lock.unlock();
    }
}
