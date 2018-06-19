package com.xunlei.downloadprovider.shortvideo.videodetail.model;

import java.util.ArrayList;
import java.util.Collection;

public class HistoryRecordList<T> extends ArrayList<T> {
    private int curPos = -1;

    public HistoryRecordList(int i) {
        super(i);
    }

    public final T putHead(T t) {
        if (this.curPos >= 0 && this.curPos < size() - 1) {
            removeRange(this.curPos + 1, size());
        }
        int i = this.curPos + 1;
        this.curPos = i;
        add(i, t);
        return t;
    }

    public final T backward() {
        if (this.curPos <= 0) {
            return null;
        }
        int i = this.curPos - 1;
        this.curPos = i;
        return get(i);
    }

    public final T forward() {
        if (this.curPos >= size() - 1) {
            return null;
        }
        int i = this.curPos + 1;
        this.curPos = i;
        return get(i);
    }

    public final boolean isBackEnd() {
        return this.curPos <= 0;
    }

    public final boolean isForwardEnd() {
        return this.curPos >= size() - 1;
    }

    public final boolean isHead() {
        return this.curPos == size() - 1;
    }

    public void clear() {
        super.clear();
        this.curPos = -1;
    }

    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public void add(int i, T t) {
        super.add(i, t);
    }

    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public T remove(int i) {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public T set(int i, T t) {
        throw new UnsupportedOperationException();
    }
}
