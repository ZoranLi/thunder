package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
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
    Node<K, V> root;
    int size;

    class EntrySet extends AbstractSet<Entry<K, V>> {
        EntrySet() {
        }

        public int size() {
            return LinkedTreeMap.this.size;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new LinkedTreeMapIterator<Entry<K, V>>() {
                {
                    EntrySet entrySet = LinkedTreeMap.this;
                }

                public Entry<K, V> next() {
                    return nextNode();
                }
            };
        }

        public boolean contains(Object obj) {
            return (!(obj instanceof Entry) || LinkedTreeMap.this.findByEntry((Entry) obj) == null) ? null : true;
        }

        public boolean remove(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            obj = LinkedTreeMap.this.findByEntry((Entry) obj);
            if (obj == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(obj, true);
            return true;
        }

        public void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        public final int size() {
            return LinkedTreeMap.this.size;
        }

        public final Iterator<K> iterator() {
            return new LinkedTreeMapIterator<K>() {
                {
                    KeySet keySet = LinkedTreeMap.this;
                }

                public K next() {
                    return nextNode().key;
                }
            };
        }

        public final boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        public final boolean remove(Object obj) {
            return LinkedTreeMap.this.removeInternalByKey(obj) != null ? true : null;
        }

        public final void clear() {
            LinkedTreeMap.this.clear();
        }
    }

    private abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount = LinkedTreeMap.this.modCount;
        Node<K, V> lastReturned = null;
        Node<K, V> next = LinkedTreeMap.this.header.next;

        LinkedTreeMapIterator() {
        }

        public final boolean hasNext() {
            return this.next != LinkedTreeMap.this.header;
        }

        final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            if (node == LinkedTreeMap.this.header) {
                throw new NoSuchElementException();
            } else if (LinkedTreeMap.this.modCount != this.expectedModCount) {
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
            LinkedTreeMap.this.removeInternal(this.lastReturned, true);
            this.lastReturned = null;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }
    }

    static final class Node<K, V> implements Entry<K, V> {
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
            this.prev = this;
            this.next = this;
        }

        Node(Node<K, V> node, K k, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k;
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.Node.equals(java.lang.Object):boolean");
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

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new Node();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        this.comparator = comparator;
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
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node node = this.header;
        node.prev = node;
        node.next = node;
    }

    public final V remove(Object obj) {
        obj = removeInternalByKey(obj);
        return obj != null ? obj.value : null;
    }

    final Node<K, V> find(K k, boolean z) {
        Comparator comparator = this.comparator;
        Node node = this.root;
        int compareTo;
        if (node != null) {
            Comparable comparable = comparator == NATURAL_ORDER ? (Comparable) k : null;
            while (true) {
                if (comparable != null) {
                    compareTo = comparable.compareTo(node.key);
                } else {
                    compareTo = comparator.compare(k, node.key);
                }
                if (compareTo != 0) {
                    Node node2;
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
        if (!z) {
            return null;
        }
        Node<K, V> node3;
        z = this.header;
        if (node != null) {
            node3 = new Node(node, k, z, z.prev);
            if (compareTo < 0) {
                node.left = node3;
            } else {
                node.right = node3;
            }
            rebalance(node, true);
        } else if (comparator != NATURAL_ORDER || (k instanceof Comparable)) {
            node3 = new Node(node, k, z, z.prev);
            this.root = node3;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(k.getClass().getName());
            stringBuilder.append(" is not Comparable");
            throw new ClassCastException(stringBuilder.toString());
        }
        this.size += 1;
        this.modCount += 1;
        return node3;
    }

    final com.google.gson.internal.LinkedTreeMap.Node<K, V> findByObject(java.lang.Object r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.LinkedTreeMap.findByObject(java.lang.Object):com.google.gson.internal.LinkedTreeMap$Node<K, V>");
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
            this.root = node2;
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

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }
}
