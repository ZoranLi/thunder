package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.util.h;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final String TAG = "LocalBroadcastManager";
    private static LocalBroadcastManager mInstance;
    private static final Object mLock = new Object();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap();
    private final Context mAppContext;
    private final Handler mHandler;
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList();
    private final HashMap<BroadcastReceiver, ArrayList<ReceiverRecord>> mReceivers = new HashMap();

    private static final class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    private static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(128);
            stringBuilder.append("Receiver{");
            stringBuilder.append(this.receiver);
            stringBuilder.append(" filter=");
            stringBuilder.append(this.filter);
            if (this.dead) {
                stringBuilder.append(" DEAD");
            }
            stringBuilder.append(h.d);
            return stringBuilder.toString();
        }
    }

    public static LocalBroadcastManager getInstance(Context context) {
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new LocalBroadcastManager(context.getApplicationContext());
            }
            context = mInstance;
        }
        return context;
    }

    private LocalBroadcastManager(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    LocalBroadcastManager.this.executePendingBroadcasts();
                }
            }
        };
    }

    public final void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
            ArrayList arrayList = (ArrayList) this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (broadcastReceiver = null; broadcastReceiver < intentFilter.countActions(); broadcastReceiver++) {
                String action = intentFilter.getAction(broadcastReceiver);
                ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public final void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            ArrayList arrayList = (ArrayList) this.mReceivers.remove(broadcastReceiver);
            if (arrayList == null) {
                return;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ReceiverRecord receiverRecord = (ReceiverRecord) arrayList.get(size);
                receiverRecord.dead = true;
                for (int i = 0; i < receiverRecord.filter.countActions(); i++) {
                    String action = receiverRecord.filter.getAction(i);
                    ArrayList arrayList2 = (ArrayList) this.mActions.get(action);
                    if (arrayList2 != null) {
                        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                            ReceiverRecord receiverRecord2 = (ReceiverRecord) arrayList2.get(size2);
                            if (receiverRecord2.receiver == broadcastReceiver) {
                                receiverRecord2.dead = true;
                                arrayList2.remove(size2);
                            }
                        }
                        if (arrayList2.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean sendBroadcast(android.content.Intent r25) {
        /*
        r24 = this;
        r1 = r24;
        r2 = r25;
        r3 = r1.mReceivers;
        monitor-enter(r3);
        r11 = r25.getAction();	 Catch:{ all -> 0x0115 }
        r4 = r1.mAppContext;	 Catch:{ all -> 0x0115 }
        r4 = r4.getContentResolver();	 Catch:{ all -> 0x0115 }
        r12 = r2.resolveTypeIfNeeded(r4);	 Catch:{ all -> 0x0115 }
        r13 = r25.getData();	 Catch:{ all -> 0x0115 }
        r14 = r25.getScheme();	 Catch:{ all -> 0x0115 }
        r15 = r25.getCategories();	 Catch:{ all -> 0x0115 }
        r4 = r25.getFlags();	 Catch:{ all -> 0x0115 }
        r4 = r4 & 8;
        r10 = 0;
        if (r4 == 0) goto L_0x002d;
    L_0x002a:
        r16 = 1;
        goto L_0x002f;
    L_0x002d:
        r16 = r10;
    L_0x002f:
        if (r16 == 0) goto L_0x004b;
    L_0x0031:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0115 }
        r5 = "Resolving type ";
        r4.<init>(r5);	 Catch:{ all -> 0x0115 }
        r4.append(r12);	 Catch:{ all -> 0x0115 }
        r5 = " scheme ";
        r4.append(r5);	 Catch:{ all -> 0x0115 }
        r4.append(r14);	 Catch:{ all -> 0x0115 }
        r5 = " of intent ";
        r4.append(r5);	 Catch:{ all -> 0x0115 }
        r4.append(r2);	 Catch:{ all -> 0x0115 }
    L_0x004b:
        r4 = r1.mActions;	 Catch:{ all -> 0x0115 }
        r5 = r25.getAction();	 Catch:{ all -> 0x0115 }
        r4 = r4.get(r5);	 Catch:{ all -> 0x0115 }
        r8 = r4;
        r8 = (java.util.ArrayList) r8;	 Catch:{ all -> 0x0115 }
        if (r8 == 0) goto L_0x0112;
    L_0x005a:
        if (r16 == 0) goto L_0x0066;
    L_0x005c:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0115 }
        r5 = "Action list: ";
        r4.<init>(r5);	 Catch:{ all -> 0x0115 }
        r4.append(r8);	 Catch:{ all -> 0x0115 }
    L_0x0066:
        r4 = 0;
        r6 = r4;
        r7 = r10;
    L_0x0069:
        r4 = r8.size();	 Catch:{ all -> 0x0115 }
        if (r7 >= r4) goto L_0x00e0;
    L_0x006f:
        r4 = r8.get(r7);	 Catch:{ all -> 0x0115 }
        r5 = r4;
        r5 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r5;	 Catch:{ all -> 0x0115 }
        if (r16 == 0) goto L_0x0084;
    L_0x0078:
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0115 }
        r9 = "Matching against filter ";
        r4.<init>(r9);	 Catch:{ all -> 0x0115 }
        r9 = r5.filter;	 Catch:{ all -> 0x0115 }
        r4.append(r9);	 Catch:{ all -> 0x0115 }
    L_0x0084:
        r4 = r5.broadcasting;	 Catch:{ all -> 0x0115 }
        if (r4 == 0) goto L_0x0095;
    L_0x0088:
        r19 = r7;
        r20 = r8;
        r18 = r11;
        r21 = r12;
        r22 = r13;
        r13 = 1;
        r11 = r6;
        goto L_0x00d3;
    L_0x0095:
        r4 = r5.filter;	 Catch:{ all -> 0x0115 }
        r17 = "LocalBroadcastManager";
        r9 = r5;
        r5 = r11;
        r18 = r11;
        r11 = r6;
        r6 = r12;
        r19 = r7;
        r7 = r14;
        r20 = r8;
        r8 = r13;
        r21 = r12;
        r22 = r13;
        r13 = 1;
        r12 = r9;
        r9 = r15;
        r10 = r17;
        r4 = r4.match(r5, r6, r7, r8, r9, r10);	 Catch:{ all -> 0x0115 }
        if (r4 < 0) goto L_0x00d3;
    L_0x00b4:
        if (r16 == 0) goto L_0x00c4;
    L_0x00b6:
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0115 }
        r6 = "  Filter matched!  match=0x";
        r5.<init>(r6);	 Catch:{ all -> 0x0115 }
        r4 = java.lang.Integer.toHexString(r4);	 Catch:{ all -> 0x0115 }
        r5.append(r4);	 Catch:{ all -> 0x0115 }
    L_0x00c4:
        if (r11 != 0) goto L_0x00cc;
    L_0x00c6:
        r6 = new java.util.ArrayList;	 Catch:{ all -> 0x0115 }
        r6.<init>();	 Catch:{ all -> 0x0115 }
        goto L_0x00cd;
    L_0x00cc:
        r6 = r11;
    L_0x00cd:
        r6.add(r12);	 Catch:{ all -> 0x0115 }
        r12.broadcasting = r13;	 Catch:{ all -> 0x0115 }
        goto L_0x00d4;
    L_0x00d3:
        r6 = r11;
    L_0x00d4:
        r7 = r19 + 1;
        r11 = r18;
        r8 = r20;
        r12 = r21;
        r13 = r22;
        r10 = 0;
        goto L_0x0069;
    L_0x00e0:
        r11 = r6;
        r13 = 1;
        if (r11 == 0) goto L_0x0110;
    L_0x00e4:
        r4 = 0;
    L_0x00e5:
        r5 = r11.size();	 Catch:{ all -> 0x0115 }
        if (r4 >= r5) goto L_0x00f7;
    L_0x00eb:
        r5 = r11.get(r4);	 Catch:{ all -> 0x0115 }
        r5 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r5;	 Catch:{ all -> 0x0115 }
        r6 = 0;
        r5.broadcasting = r6;	 Catch:{ all -> 0x0115 }
        r4 = r4 + 1;
        goto L_0x00e5;
    L_0x00f7:
        r4 = r1.mPendingBroadcasts;	 Catch:{ all -> 0x0115 }
        r5 = new android.support.v4.content.LocalBroadcastManager$BroadcastRecord;	 Catch:{ all -> 0x0115 }
        r5.<init>(r2, r11);	 Catch:{ all -> 0x0115 }
        r4.add(r5);	 Catch:{ all -> 0x0115 }
        r2 = r1.mHandler;	 Catch:{ all -> 0x0115 }
        r2 = r2.hasMessages(r13);	 Catch:{ all -> 0x0115 }
        if (r2 != 0) goto L_0x010e;
    L_0x0109:
        r2 = r1.mHandler;	 Catch:{ all -> 0x0115 }
        r2.sendEmptyMessage(r13);	 Catch:{ all -> 0x0115 }
    L_0x010e:
        monitor-exit(r3);	 Catch:{ all -> 0x0115 }
        return r13;
    L_0x0110:
        r6 = 0;
        goto L_0x0113;
    L_0x0112:
        r6 = r10;
    L_0x0113:
        monitor-exit(r3);	 Catch:{ all -> 0x0115 }
        return r6;
    L_0x0115:
        r0 = move-exception;
        r2 = r0;
        monitor-exit(r3);	 Catch:{ all -> 0x0115 }
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.LocalBroadcastManager.sendBroadcast(android.content.Intent):boolean");
    }

    public final void sendBroadcastSync(Intent intent) {
        if (sendBroadcast(intent) != null) {
            executePendingBroadcasts();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void executePendingBroadcasts() {
        /*
        r9 = this;
    L_0x0000:
        r0 = r9.mReceivers;
        monitor-enter(r0);
        r1 = r9.mPendingBroadcasts;	 Catch:{ all -> 0x0045 }
        r1 = r1.size();	 Catch:{ all -> 0x0045 }
        if (r1 > 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        return;
    L_0x000d:
        r1 = new android.support.v4.content.LocalBroadcastManager.BroadcastRecord[r1];	 Catch:{ all -> 0x0045 }
        r2 = r9.mPendingBroadcasts;	 Catch:{ all -> 0x0045 }
        r2.toArray(r1);	 Catch:{ all -> 0x0045 }
        r2 = r9.mPendingBroadcasts;	 Catch:{ all -> 0x0045 }
        r2.clear();	 Catch:{ all -> 0x0045 }
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        r0 = 0;
        r2 = r0;
    L_0x001c:
        r3 = r1.length;
        if (r2 >= r3) goto L_0x0000;
    L_0x001f:
        r3 = r1[r2];
        r4 = r3.receivers;
        r4 = r4.size();
        r5 = r0;
    L_0x0028:
        if (r5 >= r4) goto L_0x0042;
    L_0x002a:
        r6 = r3.receivers;
        r6 = r6.get(r5);
        r6 = (android.support.v4.content.LocalBroadcastManager.ReceiverRecord) r6;
        r7 = r6.dead;
        if (r7 != 0) goto L_0x003f;
    L_0x0036:
        r6 = r6.receiver;
        r7 = r9.mAppContext;
        r8 = r3.intent;
        r6.onReceive(r7, r8);
    L_0x003f:
        r5 = r5 + 1;
        goto L_0x0028;
    L_0x0042:
        r2 = r2 + 1;
        goto L_0x001c;
    L_0x0045:
        r1 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0045 }
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.content.LocalBroadcastManager.executePendingBroadcasts():void");
    }
}
