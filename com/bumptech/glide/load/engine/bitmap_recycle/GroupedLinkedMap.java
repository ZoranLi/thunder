package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupedLinkedMap<K extends Poolable, V> {
    private final LinkedEntry<K, V> head = new LinkedEntry();
    private final Map<K, LinkedEntry<K, V>> keyToEntry = new HashMap();

    private static class LinkedEntry<K, V> {
        private final K key;
        LinkedEntry<K, V> next;
        LinkedEntry<K, V> prev;
        private List<V> values;

        public LinkedEntry() {
            this(null);
        }

        public LinkedEntry(K k) {
            this.prev = this;
            this.next = this;
            this.key = k;
        }

        public V removeLast() {
            int size = size();
            return size > 0 ? this.values.remove(size - 1) : null;
        }

        public int size() {
            return this.values != null ? this.values.size() : 0;
        }

        public void add(V v) {
            if (this.values == null) {
                this.values = new ArrayList();
            }
            this.values.add(v);
        }
    }

    GroupedLinkedMap() {
    }

    public void put(K k, V v) {
        LinkedEntry linkedEntry = (LinkedEntry) this.keyToEntry.get(k);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(k);
            makeTail(linkedEntry);
            this.keyToEntry.put(k, linkedEntry);
        } else {
            k.offer();
        }
        linkedEntry.add(v);
    }

    public V get(K k) {
        LinkedEntry linkedEntry = (LinkedEntry) this.keyToEntry.get(k);
        if (linkedEntry == null) {
            linkedEntry = new LinkedEntry(k);
            this.keyToEntry.put(k, linkedEntry);
        } else {
            k.offer();
        }
        makeHead(linkedEntry);
        return linkedEntry.removeLast();
    }

    public V removeLast() {
        for (LinkedEntry linkedEntry = this.head.prev; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.prev) {
            V removeLast = linkedEntry.removeLast();
            if (removeLast != null) {
                return removeLast;
            }
            removeEntry(linkedEntry);
            this.keyToEntry.remove(linkedEntry.key);
            ((Poolable) linkedEntry.key).offer();
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("GroupedLinkedMap( ");
        Object obj = null;
        for (LinkedEntry linkedEntry = this.head.next; !linkedEntry.equals(this.head); linkedEntry = linkedEntry.next) {
            obj = 1;
            stringBuilder.append('{');
            stringBuilder.append(linkedEntry.key);
            stringBuilder.append(':');
            stringBuilder.append(linkedEntry.size());
            stringBuilder.append("}, ");
        }
        if (obj != null) {
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }

    private void makeHead(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.prev = this.head;
        linkedEntry.next = this.head.next;
        updateEntry(linkedEntry);
    }

    private void makeTail(LinkedEntry<K, V> linkedEntry) {
        removeEntry(linkedEntry);
        linkedEntry.prev = this.head.prev;
        linkedEntry.next = this.head;
        updateEntry(linkedEntry);
    }

    private static <K, V> void updateEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.next.prev = linkedEntry;
        linkedEntry.prev.next = linkedEntry;
    }

    private static <K, V> void removeEntry(LinkedEntry<K, V> linkedEntry) {
        linkedEntry.prev.next = linkedEntry.next;
        linkedEntry.next.prev = linkedEntry.prev;
    }
}
