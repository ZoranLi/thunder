package android.support.v4.util;

public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    private void doubleCapacity() {
        int length = this.mElements.length;
        int i = length - this.mHead;
        int i2 = length << 1;
        if (i2 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object obj = new Object[i2];
        System.arraycopy(this.mElements, this.mHead, obj, 0, i);
        System.arraycopy(this.mElements, 0, obj, i, this.mHead);
        this.mElements = (Object[]) obj;
        this.mHead = 0;
        this.mTail = length;
        this.mCapacityBitmask = i2 - 1;
    }

    public CircularArray() {
        this(8);
    }

    public CircularArray(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        } else {
            if (Integer.bitCount(i) != 1) {
                i = Integer.highestOneBit(i - 1) << 1;
            }
            this.mCapacityBitmask = i - 1;
            this.mElements = (Object[]) new Object[i];
        }
    }

    public final void addFirst(E e) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        this.mElements[this.mHead] = e;
        if (this.mHead == this.mTail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e) {
        this.mElements[this.mTail] = e;
        this.mTail = (this.mTail + 1) & this.mCapacityBitmask;
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public final E popFirst() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        E e = this.mElements[this.mHead];
        this.mElements[this.mHead] = null;
        this.mHead = (this.mHead + 1) & this.mCapacityBitmask;
        return e;
    }

    public final E popLast() {
        if (this.mHead == this.mTail) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i = (this.mTail - 1) & this.mCapacityBitmask;
        E e = this.mElements[i];
        this.mElements[i] = null;
        this.mTail = i;
        return e;
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final void removeFromStart(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int length = this.mElements.length;
            if (i < length - this.mHead) {
                length = this.mHead + i;
            }
            for (int i2 = this.mHead; i2 < length; i2++) {
                this.mElements[i2] = null;
            }
            length -= this.mHead;
            i -= length;
            this.mHead = this.mCapacityBitmask & (this.mHead + length);
            if (i > 0) {
                for (length = 0; length < i; length++) {
                    this.mElements[length] = null;
                }
                this.mHead = i;
            }
        }
    }

    public final void removeFromEnd(int i) {
        if (i > 0) {
            if (i > size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i2;
            int i3 = 0;
            if (i < this.mTail) {
                i3 = this.mTail - i;
            }
            for (i2 = i3; i2 < this.mTail; i2++) {
                this.mElements[i2] = null;
            }
            i2 = this.mTail - i3;
            i -= i2;
            this.mTail -= i2;
            if (i > 0) {
                this.mTail = this.mElements.length;
                i3 = this.mTail - i;
                for (i = i3; i < this.mTail; i++) {
                    this.mElements[i] = null;
                }
                this.mTail = i3;
            }
        }
    }

    public final E getFirst() {
        if (this.mHead != this.mTail) {
            return this.mElements[this.mHead];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getLast() {
        if (this.mHead != this.mTail) {
            return this.mElements[(this.mTail - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E get(int i) {
        if (i >= 0) {
            if (i < size()) {
                return this.mElements[this.mCapacityBitmask & (this.mHead + i)];
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public final boolean isEmpty() {
        return this.mHead == this.mTail;
    }
}
