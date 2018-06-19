package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedHashTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() {
        public final int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> comparator;
    private EntrySet entrySet;
    final Node<K, V> header;
    private KeySet keySet;
    int modCount;
    int size;
    Node<K, V>[] table;
    int threshold;

    static final class AvlBuilder<K, V> {
        private int leavesSkipped;
        private int leavesToSkip;
        private int size;
        private Node<K, V> stack;

        AvlBuilder() {
        }

        final void reset(int i) {
            this.leavesToSkip = ((Integer.highestOneBit(i) * 2) - 1) - i;
            this.size = 0;
            this.leavesSkipped = 0;
            this.stack = 0;
        }

        final void add(Node<K, V> node) {
            node.right = null;
            node.parent = null;
            node.left = null;
            node.height = 1;
            if (this.leavesToSkip > 0 && (this.size & 1) == 0) {
                this.size++;
                this.leavesToSkip--;
                this.leavesSkipped++;
            }
            node.parent = this.stack;
            this.stack = node;
            this.size += 1;
            if (this.leavesToSkip > null && (this.size & 1) == null) {
                this.size += 1;
                this.leavesToSkip -= 1;
                this.leavesSkipped += 1;
            }
            node = 4;
            while (true) {
                int i = node - 1;
                if ((this.size & i) == i) {
                    Node node2;
                    Node node3;
                    if (this.leavesSkipped == 0) {
                        node2 = this.stack;
                        Node node4 = node2.parent;
                        node3 = node4.parent;
                        node4.parent = node3.parent;
                        this.stack = node4;
                        node4.left = node3;
                        node4.right = node2;
                        node4.height = node2.height + 1;
                        node3.parent = node4;
                        node2.parent = node4;
                    } else if (this.leavesSkipped == 1) {
                        node2 = this.stack;
                        node3 = node2.parent;
                        this.stack = node3;
                        node3.right = node2;
                        node3.height = node2.height + 1;
                        node2.parent = node3;
                        this.leavesSkipped = 0;
                    } else if (this.leavesSkipped == 2) {
                        this.leavesSkipped = 0;
                    }
                    node *= 2;
                } else {
                    return;
                }
            }
        }

        final Node<K, V> root() {
            Node<K, V> node = this.stack;
            if (node.parent == null) {
                return node;
            }
            throw new IllegalStateException();
        }
    }

    static class AvlIterator<K, V> {
        private Node<K, V> stackTop;

        AvlIterator() {
        }

        void reset(Node<K, V> node) {
            Node<K, V> node2 = null;
            while (true) {
                Node<K, V> node3 = node2;
                node2 = node;
                node = node3;
                if (node2 != null) {
                    node2.parent = node;
                    node = node2.left;
                } else {
                    this.stackTop = node;
                    return;
                }
            }
        }

        public Node<K, V> next() {
            Node<K, V> node = this.stackTop;
            if (node == null) {
                return null;
            }
            Node node2 = node.parent;
            node.parent = null;
            Node node3 = node.right;
            while (true) {
                Node node4 = node2;
                node2 = node3;
                node3 = node4;
                if (node2 != null) {
                    node2.parent = node3;
                    node3 = node2.left;
                } else {
                    this.stackTop = node3;
                    return node;
                }
            }
        }
    }

    final class EntrySet extends AbstractSet<Entry<K, V>> {
        EntrySet() {
        }

        public final int size() {
            return LinkedHashTreeMap.this.size;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new LinkedTreeMapIterator<Entry<K, V>>() {
                {
                    EntrySet entrySet = LinkedHashTreeMap.this;
                }

                public Entry<K, V> next() {
                    return nextNode();
                }
            };
        }

        public final boolean contains(Object obj) {
            return (!(obj instanceof Entry) || LinkedHashTreeMap.this.findByEntry((Entry) obj) == null) ? null : true;
        }

        public final boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            obj = LinkedHashTreeMap.this.findByEntry((Entry) obj);
            if (obj == null) {
                return false;
            }
            LinkedHashTreeMap.this.removeInternal(obj, true);
            return true;
        }

        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        public final int size() {
            return LinkedHashTreeMap.this.size;
        }

        public final Iterator<K> iterator() {
            return new LinkedTreeMapIterator<K>() {
                {
                    KeySet keySet = LinkedHashTreeMap.this;
                }

                public K next() {
                    return nextNode().key;
                }
            };
        }

        public final boolean contains(Object obj) {
            return LinkedHashTreeMap.this.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return LinkedHashTreeMap.this.removeInternalByKey(obj) != null ? true : null;
        }

        public final void clear() {
            LinkedHashTreeMap.this.clear();
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount = LinkedHashTreeMap.this.modCount;
        Node<K, V> lastReturned = null;
        Node<K, V> next = LinkedHashTreeMap.this.header.next;

        LinkedTreeMapIterator() {
        }

        public final boolean hasNext() {
            return this.next != LinkedHashTreeMap.this.header;
        }

        final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            if (node == LinkedHashTreeMap.this.header) {
                throw new NoSuchElementException();
            } else if (LinkedHashTreeMap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            } else {
                this.next = node.next;
                this.lastReturned = node;
                return node;
            }
        }

        public final void remove() {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            LinkedHashTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedHashTreeMap.this.modCount;
        }
    }

    static final class Node<K, V> implements Entry<K, V> {
        final int hash;
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        Node() {
            this.key = null;
            this.hash = -1;
            this.prev = this;
            this.next = this;
        }

        Node(Node<K, V> node, K k, int i, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k;
            this.hash = i;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }

        public final K getKey() {
            return this.key;
        }

        public final V getValue() {
            return this.value;
        }

        public final V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
            r3 = this;
            r0 = r4 instanceof java.util.Map.Entry;
            r1 = 0;
            if (r0 == 0) goto L_0x0038;
        L_0x0005:
            r4 = (java.util.Map.Entry) r4;
            r0 = r3.key;
            if (r0 != 0) goto L_0x0012;
        L_0x000b:
            r0 = r4.getKey();
            if (r0 != 0) goto L_0x0037;
        L_0x0011:
            goto L_0x001e;
        L_0x0012:
            r0 = r3.key;
            r2 = r4.getKey();
            r0 = r0.equals(r2);
            if (r0 == 0) goto L_0x0037;
        L_0x001e:
            r0 = r3.value;
            if (r0 != 0) goto L_0x0029;
        L_0x0022:
            r4 = r4.getValue();
            if (r4 != 0) goto L_0x0037;
        L_0x0028:
            goto L_0x0035;
        L_0x0029:
            r0 = r3.value;
            r4 = r4.getValue();
            r4 = r0.equals(r4);
            if (r4 == 0) goto L_0x0037;
        L_0x0035:
            r4 = 1;
            return r4;
        L_0x0037:
            return r1;
        L_0x0038:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedHashTreeMap.Node.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i = 0;
            int hashCode = this.key == null ? 0 : this.key.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.key);
            stringBuilder.append("=");
            stringBuilder.append(this.value);
            return stringBuilder.toString();
        }

        public final Node<K, V> first() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.left; node2 != null; node2 = node2.left) {
                node = node2;
            }
            return node;
        }

        public final Node<K, V> last() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.right; node2 != null; node2 = node2.right) {
                node = node2;
            }
            return node;
        }
    }

    private static int secondaryHash(int i) {
        i ^= (i >>> 20) ^ (i >>> 12);
        return (i >>> 4) ^ ((i >>> 7) ^ i);
    }

    public LinkedHashTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedHashTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        this.comparator = comparator;
        this.header = new Node();
        this.table = new Node[16];
        this.threshold = (this.table.length / 2) + (this.table.length / 4);
    }

    public final int size() {
        return this.size;
    }

    public final V get(Object obj) {
        obj = findByObject(obj);
        return obj != null ? obj.value : null;
    }

    public final boolean containsKey(Object obj) {
        return findByObject(obj) != null ? true : null;
    }

    public final V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        k = find(k, true);
        V v2 = k.value;
        k.value = v;
        return v2;
    }

    public final void clear() {
        Arrays.fill(this.table, null);
        this.size = 0;
        this.modCount++;
        Node node = this.header;
        Node node2 = node.next;
        while (node2 != node) {
            Node node3 = node2.next;
            node2.prev = null;
            node2.next = null;
            node2 = node3;
        }
        node.prev = node;
        node.next = node;
    }

    public final V remove(Object obj) {
        obj = removeInternalByKey(obj);
        return obj != null ? obj.value : null;
    }

    final Node<K, V> find(K k, boolean z) {
        int compareTo;
        Comparator comparator = this.comparator;
        Node[] nodeArr = this.table;
        int secondaryHash = secondaryHash(k.hashCode());
        int length = secondaryHash & (nodeArr.length - 1);
        Node<K, V> node = nodeArr[length];
        if (node != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compareTo = comparable.compareTo(node.key);
                } else {
                    compareTo = comparator.compare(k, node.key);
                }
                if (compareTo != 0) {
                    Node<K, V> node2;
                    if (compareTo < 0) {
                        node2 = node.left;
                    } else {
                        node2 = node.right;
                    }
                    if (node2 == null) {
                        break;
                    }
                    node = node2;
                } else {
                    return node;
                }
            }
        }
        compareTo = 0;
        Node<K, V> node3 = node;
        int i = compareTo;
        if (!z) {
            return null;
        }
        Node node4 = this.header;
        Node node5;
        if (node3 != null) {
            node5 = new Node(node3, k, secondaryHash, node4, node4.prev);
            if (i < 0) {
                node3.left = node5;
            } else {
                node3.right = node5;
            }
            rebalance(node3, true);
        } else if (comparator != NATURAL_ORDER || (k instanceof Comparable)) {
            node5 = new Node(node3, k, secondaryHash, node4, node4.prev);
            nodeArr[length] = node5;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(k.getClass().getName());
            stringBuilder.append(" is not Comparable");
            throw new ClassCastException(stringBuilder.toString());
        }
        k = this.size;
        this.size = k + 1;
        if (k > this.threshold) {
            doubleCapacity();
        }
        this.modCount += 1;
        return z;
    }

    final com.google.gson.internal.LinkedHashTreeMap.Node<K, V> findByObject(java.lang.Object r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = 0;
        if (r3 == 0) goto L_0x000a;
    L_0x0003:
        r1 = 0;
        r3 = r2.find(r3, r1);	 Catch:{ ClassCastException -> 0x0009 }
        return r3;
    L_0x0009:
        return r0;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedHashTreeMap.findByObject(java.lang.Object):com.google.gson.internal.LinkedHashTreeMap$Node<K, V>");
    }

    final Node<K, V> findByEntry(Entry<?, ?> entry) {
        Node<K, V> findByObject = findByObject(entry.getKey());
        entry = (findByObject == null || equal(findByObject.value, entry.getValue()) == null) ? null : true;
        return entry != null ? findByObject : null;
    }

    private boolean equal(Object obj, Object obj2) {
        if (obj != obj2) {
            if (obj == null || obj.equals(obj2) == null) {
                return null;
            }
        }
        return true;
    }

    final void removeInternal(Node<K, V> node, boolean z) {
        if (z) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
        z = node.left;
        Node node2 = node.right;
        Node node3 = node.parent;
        int i = 0;
        if (!z || node2 == null) {
            if (z) {
                replaceInParent(node, z);
                node.left = null;
            } else if (node2 != null) {
                replaceInParent(node, node2);
                node.right = null;
            } else {
                replaceInParent(node, null);
            }
            rebalance(node3, false);
            this.size--;
            this.modCount++;
            return;
        }
        int i2;
        z = z.height > node2.height ? z.last() : node2.first();
        removeInternal(z, false);
        node2 = node.left;
        if (node2 != null) {
            i2 = node2.height;
            z.left = node2;
            node2.parent = z;
            node.left = null;
        } else {
            i2 = 0;
        }
        node2 = node.right;
        if (node2 != null) {
            i = node2.height;
            z.right = node2;
            node2.parent = z;
            node.right = null;
        }
        z.height = Math.max(i2, i) + 1;
        replaceInParent(node, z);
    }

    final Node<K, V> removeInternalByKey(Object obj) {
        obj = findByObject(obj);
        if (obj != null) {
            removeInternal(obj, true);
        }
        return obj;
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 == null) {
            this.table[node.hash & (this.table.length - 1)] = node2;
        } else if (node3.left == node) {
            node3.left = node2;
        } else {
            node3.right = node2;
        }
    }

    private void rebalance(Node<K, V> node, boolean z) {
        while (node != null) {
            Node node2 = node.left;
            Node node3 = node.right;
            int i = 0;
            int i2 = node2 != null ? node2.height : 0;
            int i3 = node3 != null ? node3.height : 0;
            int i4 = i2 - i3;
            Node node4;
            if (i4 != -2) {
                if (i4 != 2) {
                    if (i4 != 0) {
                        node.height = Math.max(i2, i3) + 1;
                        if (!z) {
                            break;
                        }
                    } else {
                        node.height = i2 + 1;
                        if (z) {
                            return;
                        }
                    }
                } else {
                    node3 = node2.left;
                    node4 = node2.right;
                    i2 = node4 != null ? node4.height : 0;
                    if (node3 != null) {
                        i = node3.height;
                    }
                    i -= i2;
                    if (i != 1) {
                        if (i != 0 || z) {
                            rotateLeft(node2);
                            rotateRight(node);
                            if (!z) {
                                break;
                            }
                        }
                    }
                    rotateRight(node);
                    if (!z) {
                        break;
                    }
                }
            } else {
                node2 = node3.left;
                node4 = node3.right;
                i2 = node4 != null ? node4.height : 0;
                if (node2 != null) {
                    i = node2.height;
                }
                i -= i2;
                if (i != -1) {
                    if (i != 0 || z) {
                        rotateRight(node3);
                        rotateLeft(node);
                        if (!z) {
                            break;
                        }
                    }
                }
                rotateLeft(node);
                if (!z) {
                    break;
                }
            }
            node = node.parent;
        }
    }

    private void rotateLeft(Node<K, V> node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node3.left;
        Node node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int i = 0;
        node.height = Math.max(node2 != null ? node2.height : 0, node4 != null ? node4.height : 0) + 1;
        node = node.height;
        if (node5 != null) {
            i = node5.height;
        }
        node3.height = Math.max(node, i) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        Node node2 = node.left;
        Node node3 = node.right;
        Node node4 = node2.left;
        Node node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int i = 0;
        node.height = Math.max(node3 != null ? node3.height : 0, node5 != null ? node5.height : 0) + 1;
        node = node.height;
        if (node4 != null) {
            i = node4.height;
        }
        node2.height = Math.max(node, i) + 1;
    }

    public final Set<Entry<K, V>> entrySet() {
        Set set = this.entrySet;
        if (set != null) {
            return set;
        }
        set = new EntrySet();
        this.entrySet = set;
        return set;
    }

    public final Set<K> keySet() {
        Set set = this.keySet;
        if (set != null) {
            return set;
        }
        set = new KeySet();
        this.keySet = set;
        return set;
    }

    private void doubleCapacity() {
        this.table = doubleCapacity(this.table);
        this.threshold = (this.table.length / 2) + (this.table.length / 4);
    }

    static <K, V> Node<K, V>[] doubleCapacity(Node<K, V>[] nodeArr) {
        int length = nodeArr.length;
        Node<K, V>[] nodeArr2 = new Node[(length * 2)];
        AvlIterator avlIterator = new AvlIterator();
        AvlBuilder avlBuilder = new AvlBuilder();
        AvlBuilder avlBuilder2 = new AvlBuilder();
        for (int i = 0; i < length; i++) {
            Node node = nodeArr[i];
            if (node != null) {
                avlIterator.reset(node);
                int i2 = 0;
                int i3 = i2;
                while (true) {
                    Node next = avlIterator.next();
                    if (next == null) {
                        break;
                    } else if ((next.hash & length) == 0) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                avlBuilder.reset(i2);
                avlBuilder2.reset(i3);
                avlIterator.reset(node);
                while (true) {
                    node = avlIterator.next();
                    if (node == null) {
                        break;
                    } else if ((node.hash & length) == 0) {
                        avlBuilder.add(node);
                    } else {
                        avlBuilder2.add(node);
                    }
                }
                node = null;
                nodeArr2[i] = i2 > 0 ? avlBuilder.root() : null;
                i2 = i + length;
                if (i3 > 0) {
                    node = avlBuilder2.root();
                }
                nodeArr2[i2] = node;
            }
        }
        return nodeArr2;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
