package org.android.agoo.control;

import android.content.Intent;

/* compiled from: Taobao */
class AgooFactory$b implements Runnable {
    final /* synthetic */ AgooFactory a;
    private String b;
    private Intent c;

    public AgooFactory$b(AgooFactory agooFactory, String str, Intent intent) {
        this.a = agooFactory;
        this.b = str;
        this.c = intent;
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = "AgooFactory";	 Catch:{ Throwable -> 0x00cd }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd }
        r3 = "running tid:";	 Catch:{ Throwable -> 0x00cd }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00cd }
        r3 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x00cd }
        r3 = r3.getId();	 Catch:{ Throwable -> 0x00cd }
        r2.append(r3);	 Catch:{ Throwable -> 0x00cd }
        r3 = ",pack=";	 Catch:{ Throwable -> 0x00cd }
        r2.append(r3);	 Catch:{ Throwable -> 0x00cd }
        r3 = r6.b;	 Catch:{ Throwable -> 0x00cd }
        r2.append(r3);	 Catch:{ Throwable -> 0x00cd }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00cd }
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00cd }
        com.taobao.accs.utl.ALog.d(r1, r2, r3);	 Catch:{ Throwable -> 0x00cd }
        r1 = org.android.agoo.control.AgooFactory.access$000();	 Catch:{ Throwable -> 0x00cd }
        r2 = r6.c;	 Catch:{ Throwable -> 0x00cd }
        r1.sendBroadcast(r2);	 Catch:{ Throwable -> 0x00cd }
        r1 = "AgooFactory";	 Catch:{ Throwable -> 0x00cd }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd }
        r3 = "SendMessageRunnable for accs,pack=";	 Catch:{ Throwable -> 0x00cd }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00cd }
        r3 = r6.b;	 Catch:{ Throwable -> 0x00cd }
        r2.append(r3);	 Catch:{ Throwable -> 0x00cd }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00cd }
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00cd }
        com.taobao.accs.utl.ALog.d(r1, r2, r3);	 Catch:{ Throwable -> 0x00cd }
        r1 = r6.c;	 Catch:{ Throwable -> 0x005f }
        r2 = r6.b;	 Catch:{ Throwable -> 0x005f }
        r1.setPackage(r2);	 Catch:{ Throwable -> 0x005f }
        r1 = r6.c;	 Catch:{ Throwable -> 0x005f }
        r2 = "org.agoo.android.intent.action.RECEIVE";	 Catch:{ Throwable -> 0x005f }
        r1.setAction(r2);	 Catch:{ Throwable -> 0x005f }
        r1 = org.android.agoo.control.AgooFactory.access$000();	 Catch:{ Throwable -> 0x005f }
        r2 = r6.c;	 Catch:{ Throwable -> 0x005f }
        r1.startService(r2);	 Catch:{ Throwable -> 0x005f }
    L_0x005f:
        r1 = new android.content.Intent;	 Catch:{ Throwable -> 0x00cd }
        r2 = "org.android.agoo.client.MessageReceiverService";	 Catch:{ Throwable -> 0x00cd }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00cd }
        r2 = r6.b;	 Catch:{ Throwable -> 0x00cd }
        r1.setPackage(r2);	 Catch:{ Throwable -> 0x00cd }
        r2 = "AgooFactory";	 Catch:{ Throwable -> 0x00cd }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd }
        r4 = "this message pack:";	 Catch:{ Throwable -> 0x00cd }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00cd }
        r4 = r6.b;	 Catch:{ Throwable -> 0x00cd }
        r3.append(r4);	 Catch:{ Throwable -> 0x00cd }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00cd }
        r4 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00cd }
        com.taobao.accs.utl.ALog.d(r2, r3, r4);	 Catch:{ Throwable -> 0x00cd }
        r2 = "AgooFactory";	 Catch:{ Throwable -> 0x00cd }
        r3 = "start to service...";	 Catch:{ Throwable -> 0x00cd }
        r4 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00cd }
        com.taobao.accs.utl.ALog.d(r2, r3, r4);	 Catch:{ Throwable -> 0x00cd }
        r2 = new org.android.agoo.control.AgooFactory$a;	 Catch:{ Throwable -> 0x00cd }
        r3 = r6.a;	 Catch:{ Throwable -> 0x00cd }
        r4 = r6.c;	 Catch:{ Throwable -> 0x00cd }
        r5 = "id";	 Catch:{ Throwable -> 0x00cd }
        r4 = r4.getStringExtra(r5);	 Catch:{ Throwable -> 0x00cd }
        r5 = r6.c;	 Catch:{ Throwable -> 0x00cd }
        r2.<init>(r3, r4, r5);	 Catch:{ Throwable -> 0x00cd }
        r3 = org.android.agoo.control.AgooFactory.access$000();	 Catch:{ Throwable -> 0x00cd }
        org.android.agoo.control.AgooFactory.access$000();	 Catch:{ Throwable -> 0x00cd }
        org.android.agoo.control.AgooFactory.access$000();	 Catch:{ Throwable -> 0x00cd }
        r4 = 17;	 Catch:{ Throwable -> 0x00cd }
        r1 = r3.bindService(r1, r2, r4);	 Catch:{ Throwable -> 0x00cd }
        r2 = "AgooFactory";	 Catch:{ Throwable -> 0x00cd }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00cd }
        r4 = "start service ret:";	 Catch:{ Throwable -> 0x00cd }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00cd }
        r3.append(r1);	 Catch:{ Throwable -> 0x00cd }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00cd }
        r4 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00cd }
        com.taobao.accs.utl.ALog.d(r2, r3, r4);	 Catch:{ Throwable -> 0x00cd }
        if (r1 != 0) goto L_0x00cc;	 Catch:{ Throwable -> 0x00cd }
    L_0x00c3:
        r1 = "AgooFactory";	 Catch:{ Throwable -> 0x00cd }
        r2 = "SendMessageRunnable is error";	 Catch:{ Throwable -> 0x00cd }
        r3 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x00cd }
        com.taobao.accs.utl.ALog.d(r1, r2, r3);	 Catch:{ Throwable -> 0x00cd }
    L_0x00cc:
        return;
    L_0x00cd:
        r1 = move-exception;
        r2 = "AgooFactory";
        r3 = new java.lang.StringBuilder;
        r4 = "SendMessageRunnable is error,e=";
        r3.<init>(r4);
        r1 = r1.toString();
        r3.append(r1);
        r1 = r3.toString();
        r0 = new java.lang.Object[r0];
        com.taobao.accs.utl.ALog.e(r2, r1, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.control.AgooFactory$b.run():void");
    }
}
