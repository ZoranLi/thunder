package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import android.util.SparseArray;
import com.xunlei.downloadprovider.personal.message.chat.chatengine.model.SingleChatDialog;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: SingleChatDialogCache */
public final class ag {
    public static final SparseArray<SingleChatDialog> a = new SparseArray();
    public ReadWriteLock b = new ReentrantReadWriteLock();

    public final SingleChatDialog a(int i) {
        this.b.readLock().lock();
        try {
            SingleChatDialog singleChatDialog = (SingleChatDialog) a.get(i);
            return singleChatDialog;
        } finally {
            this.b.readLock().unlock();
        }
    }

    public final SingleChatDialog b(int i) {
        this.b.writeLock().lock();
        try {
            SingleChatDialog singleChatDialog = (SingleChatDialog) a.get(i);
            if (singleChatDialog == null) {
                singleChatDialog = new SingleChatDialog(i);
                a.put(i, singleChatDialog);
            }
            this.b.writeLock().unlock();
            return singleChatDialog;
        } catch (Throwable th) {
            this.b.writeLock().unlock();
        }
    }
}
