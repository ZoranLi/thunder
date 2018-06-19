package com.ali.auth.third.core.e;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class b {
    private static Map<Integer, a> a = new HashMap();
    private static ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final a c;
    private static final a d;
    private static a e;
    private static a f;
    private static final Object g = new Object();

    static {
        a aVar = new a();
        c = aVar;
        aVar.a = 1;
        c.c = "未在消息文件中找到 id 为 {0} 的消息";
        c.d = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        c.b = "E";
        aVar = new a();
        d = aVar;
        aVar.a = 2;
        d.c = "检索消息时发生如下错误 {0}";
        d.d = "请检查所依赖的 SDK 项目，或若是手动拷贝 SDK 至当前开发应用所在项目，请检查是否漏拷文件 res/values 下文件";
        d.b = "E";
    }

    private static com.ali.auth.third.core.e.a a(int r4) {
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
        r0 = e;
        r1 = 1;
        if (r0 != 0) goto L_0x001d;
    L_0x0005:
        r0 = g;
        monitor-enter(r0);
        r2 = e;	 Catch:{ all -> 0x001a }
        if (r2 != 0) goto L_0x0018;	 Catch:{ all -> 0x001a }
    L_0x000c:
        r2 = b(r1);	 Catch:{ all -> 0x001a }
        e = r2;	 Catch:{ all -> 0x001a }
        if (r2 != 0) goto L_0x0018;	 Catch:{ all -> 0x001a }
    L_0x0014:
        r2 = c;	 Catch:{ all -> 0x001a }
        e = r2;	 Catch:{ all -> 0x001a }
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        goto L_0x001d;	 Catch:{ all -> 0x001a }
    L_0x001a:
        r4 = move-exception;	 Catch:{ all -> 0x001a }
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r4;
    L_0x001d:
        r0 = e;	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r0 = r0.clone();	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r0 = (com.ali.auth.third.core.e.a) r0;	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r2 = r0.c;	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r1 = new java.lang.Object[r1];	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r3 = 0;	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r4 = java.lang.String.valueOf(r4);	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r1[r3] = r4;	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r4 = java.text.MessageFormat.format(r2, r1);	 Catch:{ CloneNotSupportedException -> 0x0037 }
        r0.c = r4;	 Catch:{ CloneNotSupportedException -> 0x0037 }
        return r0;
    L_0x0037:
        r4 = e;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.e.b.a(int):com.ali.auth.third.core.e.a");
    }

    public static a a(int i, Object... objArr) {
        try {
            b.readLock().lock();
            a aVar = (a) a.get(Integer.valueOf(i));
            if (aVar == null) {
                b.readLock().unlock();
                b.writeLock().lock();
                aVar = b(i);
                if (aVar != null) {
                    a.put(Integer.valueOf(i), aVar);
                }
                b.readLock().lock();
                b.writeLock().unlock();
            }
            a a;
            if (aVar == null) {
                a = a(i);
                b.readLock().unlock();
                return a;
            } else if (objArr.length == 0) {
                b.readLock().unlock();
                return aVar;
            } else {
                a = (a) aVar.clone();
                a.c = MessageFormat.format(aVar.c, objArr);
                b.readLock().unlock();
                return a;
            }
        } catch (Exception e) {
            return a(e.getMessage());
        } catch (Throwable th) {
            b.writeLock().unlock();
        }
    }

    private static com.ali.auth.third.core.e.a a(java.lang.String r4) {
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
        r0 = f;
        if (r0 != 0) goto L_0x001d;
    L_0x0004:
        r0 = g;
        monitor-enter(r0);
        r1 = f;	 Catch:{ all -> 0x001a }
        if (r1 != 0) goto L_0x0018;	 Catch:{ all -> 0x001a }
    L_0x000b:
        r1 = 2;	 Catch:{ all -> 0x001a }
        r1 = b(r1);	 Catch:{ all -> 0x001a }
        f = r1;	 Catch:{ all -> 0x001a }
        if (r1 != 0) goto L_0x0018;	 Catch:{ all -> 0x001a }
    L_0x0014:
        r1 = d;	 Catch:{ all -> 0x001a }
        f = r1;	 Catch:{ all -> 0x001a }
    L_0x0018:
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        goto L_0x001d;	 Catch:{ all -> 0x001a }
    L_0x001a:
        r4 = move-exception;	 Catch:{ all -> 0x001a }
        monitor-exit(r0);	 Catch:{ all -> 0x001a }
        throw r4;
    L_0x001d:
        r0 = f;	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r0 = r0.clone();	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r0 = (com.ali.auth.third.core.e.a) r0;	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r1 = r0.c;	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r2 = 1;	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r2 = new java.lang.Object[r2];	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r3 = 0;	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r2[r3] = r4;	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r4 = java.text.MessageFormat.format(r1, r2);	 Catch:{ CloneNotSupportedException -> 0x0034 }
        r0.c = r4;	 Catch:{ CloneNotSupportedException -> 0x0034 }
        return r0;
    L_0x0034:
        r4 = f;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.e.b.a(java.lang.String):com.ali.auth.third.core.e.a");
    }

    private static com.ali.auth.third.core.e.a b(int r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:17:0x008c in {4, 7, 9, 12, 14, 16, 20} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.visit(BlockProcessor.java:38)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        r1 = com.ali.auth.third.core.c.a.c;	 Catch:{ Exception -> 0x008d }
        r2 = "string";	 Catch:{ Exception -> 0x008d }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008d }
        r4 = "auth_sdk_message_";	 Catch:{ Exception -> 0x008d }
        r3.<init>(r4);	 Catch:{ Exception -> 0x008d }
        r3.append(r6);	 Catch:{ Exception -> 0x008d }
        r4 = "_message";	 Catch:{ Exception -> 0x008d }
        r3.append(r4);	 Catch:{ Exception -> 0x008d }
        r3 = r3.toString();	 Catch:{ Exception -> 0x008d }
        r1 = com.ali.auth.third.core.j.e.a(r1, r2, r3);	 Catch:{ Exception -> 0x008d }
        if (r1 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x008d }
    L_0x001e:
        return r0;	 Catch:{ Exception -> 0x008d }
    L_0x001f:
        r2 = new com.ali.auth.third.core.e.a;	 Catch:{ Exception -> 0x008d }
        r2.<init>();	 Catch:{ Exception -> 0x008d }
        r2.a = r6;	 Catch:{ Exception -> 0x008d }
        r3 = com.ali.auth.third.core.c.a.c;	 Catch:{ Exception -> 0x008d }
        r3 = r3.getResources();	 Catch:{ Exception -> 0x008d }
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x008d }
        r2.c = r1;	 Catch:{ Exception -> 0x008d }
        r1 = com.ali.auth.third.core.c.a.c;	 Catch:{ Exception -> 0x008d }
        r3 = "string";	 Catch:{ Exception -> 0x008d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008d }
        r5 = "auth_sdk_message_";	 Catch:{ Exception -> 0x008d }
        r4.<init>(r5);	 Catch:{ Exception -> 0x008d }
        r4.append(r6);	 Catch:{ Exception -> 0x008d }
        r5 = "_action";	 Catch:{ Exception -> 0x008d }
        r4.append(r5);	 Catch:{ Exception -> 0x008d }
        r4 = r4.toString();	 Catch:{ Exception -> 0x008d }
        r1 = com.ali.auth.third.core.j.e.a(r1, r3, r4);	 Catch:{ Exception -> 0x008d }
        if (r1 == 0) goto L_0x005c;	 Catch:{ Exception -> 0x008d }
    L_0x004f:
        r3 = com.ali.auth.third.core.c.a.c;	 Catch:{ Exception -> 0x008d }
        r3 = r3.getResources();	 Catch:{ Exception -> 0x008d }
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x008d }
    L_0x0059:
        r2.d = r1;	 Catch:{ Exception -> 0x008d }
        goto L_0x005f;	 Catch:{ Exception -> 0x008d }
    L_0x005c:
        r1 = "";	 Catch:{ Exception -> 0x008d }
        goto L_0x0059;	 Catch:{ Exception -> 0x008d }
    L_0x005f:
        r1 = com.ali.auth.third.core.c.a.c;	 Catch:{ Exception -> 0x008d }
        r3 = "string";	 Catch:{ Exception -> 0x008d }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x008d }
        r5 = "auth_sdk_message_";	 Catch:{ Exception -> 0x008d }
        r4.<init>(r5);	 Catch:{ Exception -> 0x008d }
        r4.append(r6);	 Catch:{ Exception -> 0x008d }
        r5 = "_type";	 Catch:{ Exception -> 0x008d }
        r4.append(r5);	 Catch:{ Exception -> 0x008d }
        r4 = r4.toString();	 Catch:{ Exception -> 0x008d }
        r1 = com.ali.auth.third.core.j.e.a(r1, r3, r4);	 Catch:{ Exception -> 0x008d }
        if (r1 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x008d }
    L_0x007c:
        r3 = com.ali.auth.third.core.c.a.c;	 Catch:{ Exception -> 0x008d }
        r3 = r3.getResources();	 Catch:{ Exception -> 0x008d }
        r1 = r3.getString(r1);	 Catch:{ Exception -> 0x008d }
    L_0x0086:
        r2.b = r1;	 Catch:{ Exception -> 0x008d }
        return r2;	 Catch:{ Exception -> 0x008d }
    L_0x0089:
        r1 = "I";	 Catch:{ Exception -> 0x008d }
        goto L_0x0086;
        return r2;
    L_0x008d:
        r1 = move-exception;
        r2 = new java.lang.StringBuilder;
        r3 = "Fail to get message of the code ";
        r2.<init>(r3);
        r2.append(r6);
        r6 = ", the error message is ";
        r2.append(r6);
        r6 = r1.getMessage();
        r2.append(r6);
        r6 = com.ali.auth.third.core.config.a.a;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.e.b.b(int):com.ali.auth.third.core.e.a");
    }
}
