package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

public class LazyList<E> implements Closeable, List<E> {
    private final Cursor cursor;
    private final InternalQueryDaoAccess<E> daoAccess;
    private final List<E> entities;
    private volatile int loadedCount;
    private final ReentrantLock lock;
    private final int size;

    LazyList(InternalQueryDaoAccess<E> internalQueryDaoAccess, Cursor cursor, boolean z) {
        this.cursor = cursor;
        this.daoAccess = internalQueryDaoAccess;
        this.size = cursor.getCount();
        if (z) {
            this.entities = new ArrayList(this.size);
            for (z = false; z < this.size; z++) {
                this.entities.add(null);
            }
        } else {
            this.entities = null;
        }
        if (this.size == null) {
            cursor.close();
        }
        this.lock = new ReentrantLock();
    }

    public void loadRemaining() {
        checkCached();
        int size = this.entities.size();
        for (int i = 0; i < size; i++) {
            get(i);
        }
    }

    protected void checkCached() {
        if (this.entities == null) {
            throw new DaoException("This operation only works with cached lazy lists");
        }
    }

    public E peek(int i) {
        return this.entities != null ? this.entities.get(i) : null;
    }

    public void close() {
        this.cursor.close();
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    public int getLoadedCount() {
        return this.loadedCount;
    }

    public boolean isLoadedCompletely() {
        return this.loadedCount == this.size;
    }

    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object obj) {
        loadRemaining();
        return this.entities.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        loadRemaining();
        return this.entities.containsAll(collection);
    }

    public E get(int i) {
        if (this.entities != null) {
            E e = this.entities.get(i);
            if (e == null) {
                this.lock.lock();
                try {
                    e = this.entities.get(i);
                    if (e == null) {
                        e = loadEntity(i);
                        this.entities.set(i, e);
                        this.loadedCount++;
                        if (this.loadedCount == this.size) {
                            this.cursor.close();
                        }
                    }
                    this.lock.unlock();
                } catch (Throwable th) {
                    this.lock.unlock();
                }
            }
            return e;
        }
        this.lock.lock();
        try {
            i = loadEntity(i);
            return i;
        } finally {
            this.lock.unlock();
        }
    }

    protected E loadEntity(int i) {
        if (this.cursor.moveToPosition(i)) {
            E loadCurrent = this.daoAccess.loadCurrent(this.cursor, 0, true);
            if (loadCurrent != null) {
                return loadCurrent;
            }
            StringBuilder stringBuilder = new StringBuilder("Loading of entity failed (null) at position ");
            stringBuilder.append(i);
            throw new DaoException(stringBuilder.toString());
        }
        stringBuilder = new StringBuilder("Could not move to cursor location ");
        stringBuilder.append(i);
        throw new DaoException(stringBuilder.toString());
    }

    public int indexOf(Object obj) {
        loadRemaining();
        return this.entities.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Iterator<E> iterator() {
        return new LazyIterator(this, 0, false);
    }

    public int lastIndexOf(Object obj) {
        loadRemaining();
        return this.entities.lastIndexOf(obj);
    }

    public CloseableListIterator<E> listIterator() {
        return new LazyIterator(this, 0, false);
    }

    public CloseableListIterator<E> listIteratorAutoClose() {
        return new LazyIterator(this, 0, true);
    }

    public ListIterator<E> listIterator(int i) {
        return new LazyIterator(this, i, false);
    }

    public E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.size;
    }

    public List<E> subList(int i, int i2) {
        checkCached();
        for (int i3 = i; i3 < i2; i3++) {
            get(i3);
        }
        return this.entities.subList(i, i2);
    }

    public Object[] toArray() {
        loadRemaining();
        return this.entities.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        loadRemaining();
        return this.entities.toArray(tArr);
    }
}
