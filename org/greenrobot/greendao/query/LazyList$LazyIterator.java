package org.greenrobot.greendao.query;

import java.util.NoSuchElementException;

protected class LazyList$LazyIterator implements CloseableListIterator<E> {
    private final boolean closeWhenDone;
    private int index;
    final /* synthetic */ LazyList this$0;

    public LazyList$LazyIterator(LazyList lazyList, int i, boolean z) {
        this.this$0 = lazyList;
        this.index = i;
        this.closeWhenDone = z;
    }

    public void add(E e) {
        throw new UnsupportedOperationException();
    }

    public boolean hasPrevious() {
        return this.index > 0;
    }

    public int nextIndex() {
        return this.index;
    }

    public E previous() {
        if (this.index <= 0) {
            throw new NoSuchElementException();
        }
        this.index--;
        return this.this$0.get(this.index);
    }

    public int previousIndex() {
        return this.index - 1;
    }

    public void set(E e) {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        return this.index < LazyList.access$000(this.this$0);
    }

    public E next() {
        if (this.index >= LazyList.access$000(this.this$0)) {
            throw new NoSuchElementException();
        }
        E e = this.this$0.get(this.index);
        this.index++;
        if (this.index == LazyList.access$000(this.this$0) && this.closeWhenDone) {
            close();
        }
        return e;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void close() {
        this.this$0.close();
    }
}
