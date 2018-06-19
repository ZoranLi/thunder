package com.android.providers.downloads;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.util.h;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import com.xunlei.download.DownloadManager;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.proguard.ai;
import com.xunlei.download.proguard.am;
import com.xunlei.download.proguard.an;
import com.xunlei.download.proguard.d;
import com.xunlei.download.proguard.e;
import com.xunlei.download.proguard.p;
import com.xunlei.download.proguard.q;
import com.xunlei.download.proguard.r;
import com.xunlei.download.proguard.s;
import com.xunlei.download.proguard.z;
import com.xunlei.downloadlib.XLDownloadManager;
import com.xunlei.downloadlib.parameter.BtIndexSet;
import com.xunlei.downloadlib.parameter.BtSubTaskDetail;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import com.xunlei.downloadlib.parameter.XLRangeInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class ExtendEntryTask implements com.xunlei.download.proguard.h.a {
    private static final int a = 80;
    private static final Object b = new Object();

    static class a {
        private long a;
        private long b;
        private long c;
        private long d;
        private long e;
        private long f;

        a() {
        }
    }

    class b extends z {
        HashMap<Integer, Byte> a = new HashMap();
        HashMap<Integer, a> b = new HashMap();
        TorrentInfo c;
        int[] d;
        final /* synthetic */ ExtendEntryTask e;

        public b(ExtendEntryTask extendEntryTask, Context context, r rVar, d dVar, q qVar, e eVar) {
            this.e = extendEntryTask;
            super(context, rVar, dVar, qVar, eVar);
        }

        protected long a(java.lang.String r39, java.lang.String r40, java.lang.String r41, boolean r42) throws com.xunlei.download.proguard.p {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r38 = this;
            r1 = r38;
            r8 = r39;
            r9 = r40;
            r5 = r41;
            r10 = r42;
            r2 = new java.lang.StringBuilder;
            r3 = "create xl task: name = ";
            r2.<init>(r3);
            r2.append(r9);
            r3 = ", path = ";
            r2.append(r3);
            r2.append(r8);
            r3 = ", resuming = ";
            r2.append(r3);
            r2.append(r10);
            r3 = ", uri = ";
            r2.append(r3);
            r2.append(r5);
            r2 = r2.toString();
            r1.a(r2);
            r11 = r1.q;
            r2 = r1.l;
            r12 = com.xunlei.downloadlib.XLDownloadManager.getInstance(r2);
            r2 = com.xunlei.downloadlib.parameter.XLConstant.XLCreateTaskMode.NEW_TASK;
            r2 = r2.ordinal();
            if (r10 == 0) goto L_0x0049;
        L_0x0043:
            r2 = com.xunlei.downloadlib.parameter.XLConstant.XLCreateTaskMode.CONTINUE_TASK;
            r2 = r2.ordinal();
        L_0x0049:
            r6 = r2;
            r2 = r1.i;
            r2 = r2.W;
            r3 = com.xunlei.download.DownloadManager.TaskType.MAGNET;
            r13 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
            if (r2 != r3) goto L_0x0081;
        L_0x0054:
            r2 = new com.xunlei.downloadlib.parameter.MagnetTaskParam;
            r2.<init>();
            r2.mFileName = r9;
            r2.mFilePath = r8;
            r2.mUrl = r5;
            r2 = r12.createBtMagnetTask(r2, r11);
            if (r2 == r13) goto L_0x036a;
        L_0x0065:
            r3 = new com.xunlei.download.proguard.p;
            r4 = com.android.providers.downloads.XlTaskHelper.b(r2);
            r5 = new java.lang.StringBuilder;
            r6 = "create task failed: ";
            r5.<init>(r6);
            r2 = com.android.providers.downloads.XlTaskHelper.a(r2);
            r5.append(r2);
            r2 = r5.toString();
            r3.<init>(r4, r2);
            throw r3;
        L_0x0081:
            r2 = r1.i;
            r2 = r2.W;
            r3 = com.xunlei.download.DownloadManager.TaskType.BT;
            r14 = 0;
            r4 = 0;
            if (r2 != r3) goto L_0x0330;
        L_0x008c:
            r2 = new com.xunlei.downloadlib.parameter.TorrentInfo;
            r2.<init>();
            r1.c = r2;
            r2 = android.net.Uri.parse(r41);
            r2 = r2.getPath();
            r3 = new java.io.File;
            r3.<init>(r2);
            r3 = r3.exists();
            if (r3 != 0) goto L_0x00b2;
        L_0x00a6:
            r2 = r1.i;
            r2 = r2.g;
            r3 = r1.i;
            r3 = r3.x;
            r2 = com.xunlei.download.proguard.ab.a(r2, r3);
        L_0x00b2:
            r3 = r1.c;
            r3 = r12.getTorrentInfo(r2, r3);
            if (r3 == r13) goto L_0x00d6;
        L_0x00ba:
            r2 = new com.xunlei.download.proguard.p;
            r4 = com.android.providers.downloads.XlTaskHelper.b(r3);
            r5 = new java.lang.StringBuilder;
            r6 = "create task failed: ";
            r5.<init>(r6);
            r3 = com.android.providers.downloads.XlTaskHelper.a(r3);
            r5.append(r3);
            r3 = r5.toString();
            r2.<init>(r4, r3);
            throw r2;
        L_0x00d6:
            r3 = r1.j;
            r3 = r3.b;
            r7 = 4;
            if (r3 != 0) goto L_0x01f2;
        L_0x00dd:
            r3 = r1.j;
            r13 = "";
            r3.c = r13;
            r3 = r1.i;
            r3 = r3.i;
            if (r3 != r7) goto L_0x011d;
        L_0x00e9:
            r3 = r1.j;
            r13 = r1.i;
            r13 = r13.f;
            r13 = android.net.Uri.parse(r13);
            r13 = r13.getPath();
            r3.b = r13;
            r3 = r1.j;
            r3 = r3.b;
            r13 = "{filename}";
            r3 = r3.endsWith(r13);
            if (r3 == 0) goto L_0x011b;
        L_0x0105:
            r3 = r1.j;
            r13 = r1.j;
            r13 = r13.b;
            r14 = r1.j;
            r14 = r14.b;
            r14 = r14.length();
            r14 = r14 + -10;
            r13 = r13.substring(r4, r14);
            r3.b = r13;
        L_0x011b:
            r4 = 0;
            goto L_0x0130;
        L_0x011d:
            r3 = r1.j;	 Catch:{ IOException -> 0x01e8 }
            r13 = r1.p;	 Catch:{ IOException -> 0x01e8 }
            r7 = r1.i;	 Catch:{ IOException -> 0x01e8 }
            r7 = r7.i;	 Catch:{ IOException -> 0x01e8 }
            r4 = 0;	 Catch:{ IOException -> 0x01e8 }
            r7 = r13.a(r4, r7, r14);	 Catch:{ IOException -> 0x01e8 }
            r7 = r7.getCanonicalPath();	 Catch:{ IOException -> 0x01e8 }
            r3.b = r7;	 Catch:{ IOException -> 0x01e8 }
        L_0x0130:
            r3 = new java.io.File;
            r7 = r1.j;
            r7 = r7.b;
            r3.<init>(r7);
            r7 = r3.exists();
            if (r7 != 0) goto L_0x014f;
        L_0x013f:
            r7 = r3.mkdirs();
            if (r7 != 0) goto L_0x014f;
        L_0x0145:
            r2 = new com.xunlei.download.proguard.p;
            r3 = "create dir failed";
            r7 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
            r2.<init>(r7, r3);
            throw r2;
        L_0x014f:
            r7 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
            r3 = r3.isDirectory();
            if (r3 != 0) goto L_0x015f;
        L_0x0157:
            r2 = new com.xunlei.download.proguard.p;
            r3 = "dir not exist";
            r2.<init>(r7, r3);
            throw r2;
        L_0x015f:
            r3 = r1.c;
            r3 = r3.mMultiFileBaseFolder;
            r3 = android.text.TextUtils.isEmpty(r3);
            if (r3 == 0) goto L_0x017a;
        L_0x0169:
            r3 = r1.c;
            r7 = r1.c;
            r7 = r7.mSubFileInfo;
            r13 = 0;
            r7 = r7[r13];
            r7 = r7.mFileName;
            r7 = r1.c(r7);
            r3.mMultiFileBaseFolder = r7;
        L_0x017a:
            r3 = r1.c;
            r7 = r1.c;
            r7 = r7.mMultiFileBaseFolder;
            r7 = r1.b(r7);
            r3.mMultiFileBaseFolder = r7;
            r3 = new java.io.File;
            r7 = r1.j;
            r7 = r7.b;
            r13 = r1.c;
            r13 = r13.mMultiFileBaseFolder;
            r3.<init>(r7, r13);
            r7 = 1;
        L_0x0194:
            r13 = r3.exists();
            if (r13 != 0) goto L_0x01aa;
        L_0x019a:
            r13 = r3.mkdirs();
            if (r13 != 0) goto L_0x01aa;
        L_0x01a0:
            r2 = new com.xunlei.download.proguard.p;
            r3 = "create dir failed";
            r4 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
            r2.<init>(r4, r3);
            throw r2;
        L_0x01aa:
            r13 = r3.isDirectory();
            if (r13 != 0) goto L_0x01d4;
        L_0x01b0:
            r3 = new java.io.File;
            r13 = r1.j;
            r13 = r13.b;
            r14 = new java.lang.StringBuilder;
            r14.<init>();
            r15 = r1.c;
            r15 = r15.mMultiFileBaseFolder;
            r14.append(r15);
            r15 = "-";
            r14.append(r15);
            r15 = r7 + 1;
            r14.append(r7);
            r7 = r14.toString();
            r3.<init>(r13, r7);
            r7 = r15;
        L_0x01d4:
            r13 = r3.isDirectory();
            if (r13 == 0) goto L_0x0194;
        L_0x01da:
            r7 = r1.j;
            r3 = r3.getAbsolutePath();
            r7.b = r3;
            r3 = r1.j;
            r3.a();
            goto L_0x01f3;
        L_0x01e8:
            r2 = new com.xunlei.download.proguard.p;
            r3 = "path not exist";
            r4 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
            r2.<init>(r4, r3);
            throw r2;
        L_0x01f2:
            r4 = 0;
        L_0x01f3:
            if (r10 == 0) goto L_0x02d4;
        L_0x01f5:
            r3 = r1.l;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r16 = r3.getContentResolver();	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r17 = com.android.providers.downloads.DownloadProvider.c;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r3 = 6;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7 = "bt_sub_index";	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = 0;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r3[r13] = r7;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7 = "vip_receive_size";	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = 1;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r3[r13] = r7;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7 = 2;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = "lx_receive_size";	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r3[r7] = r13;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7 = 3;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = "p2p_receive_size";	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r3[r7] = r13;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7 = "p2s_receive_size";	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = 4;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r3[r13] = r7;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7 = 5;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = "origin_receive_size";	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r3[r7] = r13;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r19 = "bt_parent_id=?";	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7 = 1;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7 = new java.lang.String[r7];	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13.<init>();	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r14 = r1.i;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r14 = r14.c;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13.append(r14);	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = r13.toString();	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r14 = 0;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r7[r14] = r13;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r21 = 0;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r18 = r3;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r20 = r7;	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13 = r16.query(r17, r18, r19, r20, r21);	 Catch:{ Exception -> 0x02bd, all -> 0x02b9 }
            r13.moveToFirst();	 Catch:{ Exception -> 0x02b6 }
        L_0x0243:
            r3 = r13.isAfterLast();	 Catch:{ Exception -> 0x02b6 }
            if (r3 != 0) goto L_0x02b3;	 Catch:{ Exception -> 0x02b6 }
        L_0x0249:
            r3 = new com.android.providers.downloads.ExtendEntryTask$a;	 Catch:{ Exception -> 0x02b6 }
            r3.<init>();	 Catch:{ Exception -> 0x02b6 }
            r4 = "bt_sub_index";	 Catch:{ Exception -> 0x02b6 }
            r4 = r13.getColumnIndex(r4);	 Catch:{ Exception -> 0x02b6 }
            r4 = r13.getInt(r4);	 Catch:{ Exception -> 0x02b6 }
            r7 = "vip_receive_size";	 Catch:{ Exception -> 0x02b6 }
            r7 = r13.getColumnIndex(r7);	 Catch:{ Exception -> 0x02b6 }
            r14 = r13.getLong(r7);	 Catch:{ Exception -> 0x02b6 }
            r3.a = r14;	 Catch:{ Exception -> 0x02b6 }
            r7 = "lx_receive_size";	 Catch:{ Exception -> 0x02b6 }
            r7 = r13.getColumnIndex(r7);	 Catch:{ Exception -> 0x02b6 }
            r14 = r13.getLong(r7);	 Catch:{ Exception -> 0x02b6 }
            r3.b = r14;	 Catch:{ Exception -> 0x02b6 }
            r7 = "p2p_receive_size";	 Catch:{ Exception -> 0x02b6 }
            r7 = r13.getColumnIndex(r7);	 Catch:{ Exception -> 0x02b6 }
            r14 = r13.getLong(r7);	 Catch:{ Exception -> 0x02b6 }
            r3.d = r14;	 Catch:{ Exception -> 0x02b6 }
            r7 = "p2s_receive_size";	 Catch:{ Exception -> 0x02b6 }
            r7 = r13.getColumnIndex(r7);	 Catch:{ Exception -> 0x02b6 }
            r14 = r13.getLong(r7);	 Catch:{ Exception -> 0x02b6 }
            r3.c = r14;	 Catch:{ Exception -> 0x02b6 }
            r7 = "origin_receive_size";	 Catch:{ Exception -> 0x02b6 }
            r7 = r13.getColumnIndex(r7);	 Catch:{ Exception -> 0x02b6 }
            r14 = r13.getLong(r7);	 Catch:{ Exception -> 0x02b6 }
            r3.e = r14;	 Catch:{ Exception -> 0x02b6 }
            r7 = "dcdn_receive_size";	 Catch:{ Exception -> 0x02b6 }
            r7 = r13.getColumnIndex(r7);	 Catch:{ Exception -> 0x02b6 }
            r14 = r13.getLong(r7);	 Catch:{ Exception -> 0x02b6 }
            r3.f = r14;	 Catch:{ Exception -> 0x02b6 }
            r7 = r1.b;	 Catch:{ Exception -> 0x02b6 }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ Exception -> 0x02b6 }
            r7.put(r4, r3);	 Catch:{ Exception -> 0x02b6 }
            r13.moveToNext();	 Catch:{ Exception -> 0x02b6 }
            goto L_0x0243;
        L_0x02b3:
            if (r13 == 0) goto L_0x02d4;
        L_0x02b5:
            goto L_0x02c8;
        L_0x02b6:
            r0 = move-exception;
            r3 = r0;
            goto L_0x02c0;
        L_0x02b9:
            r0 = move-exception;
            r2 = r0;
            r13 = r4;
            goto L_0x02ce;
        L_0x02bd:
            r0 = move-exception;
            r3 = r0;
            r13 = r4;
        L_0x02c0:
            r3.printStackTrace();	 Catch:{ all -> 0x02cc }
            com.xunlei.download.proguard.an.a(r3);	 Catch:{ all -> 0x02cc }
            if (r13 == 0) goto L_0x02d4;
        L_0x02c8:
            r13.close();
            goto L_0x02d4;
        L_0x02cc:
            r0 = move-exception;
            r2 = r0;
        L_0x02ce:
            if (r13 == 0) goto L_0x02d3;
        L_0x02d0:
            r13.close();
        L_0x02d3:
            throw r2;
        L_0x02d4:
            r3 = new com.xunlei.downloadlib.parameter.BtTaskParam;
            r3.<init>();
            r3.mTorrentPath = r2;
            r2 = r1.j;
            r2 = r2.b;
            r3.mFilePath = r2;
            r3.mCreateMode = r6;
            r2 = r1.l;
            r2 = com.xunlei.download.DownloadManager.getInstanceFor(r2);
            r2 = r2.getRecommandMaxConcurrentBtSubDownloads();
            r3.mMaxConcurrent = r2;
            r6 = r1.o;
            r2 = r1.a(r6, r5);
            r3.mSeqId = r2;
            r2 = r12.createBtTask(r3, r11);
            r3 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
            if (r2 == r3) goto L_0x031b;
        L_0x02ff:
            r3 = new com.xunlei.download.proguard.p;
            r4 = com.android.providers.downloads.XlTaskHelper.b(r2);
            r5 = new java.lang.StringBuilder;
            r6 = "create task failed: ";
            r5.<init>(r6);
            r2 = com.android.providers.downloads.XlTaskHelper.a(r2);
            r5.append(r2);
            r2 = r5.toString();
            r3.<init>(r4, r2);
            throw r3;
        L_0x031b:
            r2 = r11.getTaskId();
            r1.b(r2);
            r2 = r1.i;
            r2 = r2.y;
            r2 = r1.a(r2);
            if (r2 == 0) goto L_0x036a;
        L_0x032c:
            r38.e();
            goto L_0x036a;
        L_0x0330:
            r2 = r1.i;
            r2 = r2.W;
            r3 = com.xunlei.download.DownloadManager.TaskType.ED2K;
            if (r2 != r3) goto L_0x036f;
        L_0x0338:
            r13 = new com.xunlei.downloadlib.parameter.EmuleTaskParam;
            r2 = r1.o;
            r7 = r1.a(r2, r5);
            r2 = r13;
            r3 = r9;
            r4 = r8;
            r2.<init>(r3, r4, r5, r6, r7);
            r2 = r12.createEmuleTask(r13, r11);
            r3 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
            if (r2 == r3) goto L_0x036a;
        L_0x034e:
            r3 = new com.xunlei.download.proguard.p;
            r4 = com.android.providers.downloads.XlTaskHelper.b(r2);
            r5 = new java.lang.StringBuilder;
            r6 = "create task failed: ";
            r5.<init>(r6);
            r2 = com.android.providers.downloads.XlTaskHelper.a(r2);
            r5.append(r2);
            r2 = r5.toString();
            r3.<init>(r4, r2);
            throw r3;
        L_0x036a:
            r3 = r8;
            r4 = r11;
            r6 = r12;
            goto L_0x0516;
        L_0x036f:
            r2 = r1.i;
            r2 = r2.W;
            r3 = com.xunlei.download.DownloadManager.TaskType.CID;
            if (r2 != r3) goto L_0x0577;
        L_0x0377:
            r2 = "\\|";
            r2 = r5.split(r2);
            r3 = "";
            r4 = "";
            r7 = "";
            r13 = "";
            r8 = r7;
            r14 = -1;
            r7 = r4;
            r4 = r3;
            r3 = 0;
        L_0x038b:
            if (r2 == 0) goto L_0x03f0;
        L_0x038d:
            r9 = r2.length;
            if (r3 >= r9) goto L_0x03f0;
        L_0x0390:
            r9 = r2[r3];
            r10 = "cid://";
            r9 = r9.startsWith(r10);
            if (r9 == 0) goto L_0x03a3;
        L_0x039a:
            r4 = r2[r3];
            r9 = 6;
            r4 = r4.substring(r9);
        L_0x03a1:
            r9 = 1;
            goto L_0x03ea;
        L_0x03a3:
            r9 = 6;
            r10 = r2[r3];
            r9 = "size";
            r9 = r10.equals(r9);
            if (r9 == 0) goto L_0x03bc;
        L_0x03ae:
            r3 = r3 + 1;
            r9 = r2[r3];	 Catch:{ Exception -> 0x03b8 }
            r9 = java.lang.Long.parseLong(r9);	 Catch:{ Exception -> 0x03b8 }
            r14 = r9;
            goto L_0x03a1;
        L_0x03b8:
            r9 = 1;
            r14 = -1;
            goto L_0x03ea;
        L_0x03bc:
            r9 = r2[r3];
            r10 = "gcid";
            r9 = r9.equals(r10);
            if (r9 == 0) goto L_0x03cb;
        L_0x03c6:
            r3 = r3 + 1;
            r7 = r2[r3];
            goto L_0x03a1;
        L_0x03cb:
            r9 = r2[r3];
            r10 = "bcid";
            r9 = r9.equals(r10);
            if (r9 == 0) goto L_0x03da;
        L_0x03d5:
            r3 = r3 + 1;
            r8 = r2[r3];
            goto L_0x03a1;
        L_0x03da:
            r9 = r2[r3];
            r10 = "file";
            r9 = r9.equals(r10);
            if (r9 == 0) goto L_0x03a1;
        L_0x03e4:
            r3 = r3 + 1;
            r9 = r2[r3];
            r13 = r9;
            goto L_0x03a1;
        L_0x03ea:
            r3 = r3 + r9;
            r9 = r40;
            r10 = r42;
            goto L_0x038b;
        L_0x03f0:
            r2 = "";
            r2 = r4.equals(r2);
            if (r2 != 0) goto L_0x056d;
        L_0x03f8:
            r2 = 0;
            r9 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
            if (r9 > 0) goto L_0x0400;
        L_0x03fe:
            goto L_0x056d;
        L_0x0400:
            r2 = r1.j;
            r2 = r2.n;
            r2 = android.text.TextUtils.isEmpty(r2);
            if (r2 == 0) goto L_0x040e;
        L_0x040a:
            r2 = r1.j;
            r2.n = r4;
        L_0x040e:
            r2 = r1.j;
            r2 = r2.o;
            r2 = android.text.TextUtils.isEmpty(r2);
            if (r2 == 0) goto L_0x0422;
        L_0x0418:
            r2 = android.text.TextUtils.isEmpty(r7);
            if (r2 != 0) goto L_0x0422;
        L_0x041e:
            r2 = r1.j;
            r2.o = r7;
        L_0x0422:
            r2 = r1.j;
            r2 = r2.b;
            if (r2 != 0) goto L_0x04c0;
        L_0x0428:
            r2 = r1.j;
            r2 = r2.c;
            if (r2 != 0) goto L_0x0436;
        L_0x042e:
            r2 = r1.j;
            r3 = com.xunlei.download.proguard.am.b(r13);
            r2.c = r3;
        L_0x0436:
            r2 = 0;
            r9 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1));
            if (r9 < 0) goto L_0x0441;
        L_0x043c:
            r2 = r1.j;
            r2.g = r14;
            goto L_0x0447;
        L_0x0441:
            r2 = r1.j;
            r9 = -1;
            r2.g = r9;
        L_0x0447:
            r2 = r1.j;
            r3 = r1.l;
            r9 = r1.i;
            r9 = r9.d;
            r10 = r1.i;
            r10 = r10.f;
            r25 = 0;
            r26 = 0;
            r33 = r11;
            r11 = r1.j;
            r11 = r11.c;
            r34 = r12;
            r12 = r1.i;
            r12 = r12.i;
            r5 = r1.j;
            r35 = r6;
            r5 = r5.g;
            r36 = r14;
            r14 = r1.p;
            r22 = r3;
            r23 = r9;
            r24 = r10;
            r27 = r11;
            r28 = r12;
            r29 = r5;
            r31 = r14;
            r32 = r13;
            r3 = com.xunlei.download.proguard.k.a(r22, r23, r24, r25, r26, r27, r28, r29, r31, r32);
            r2.b = r3;
            r2 = r1.j;
            r2.a();
            r2 = r1.i;
            r2 = r2.y;
            r2 = r1.a(r2);
            if (r2 == 0) goto L_0x0495;
        L_0x0492:
            r38.e();
        L_0x0495:
            r2 = r1.j;
            r2 = r2.b;
            r3 = java.io.File.separator;
            r2 = r2.lastIndexOf(r3);
            r3 = -1;
            if (r2 == r3) goto L_0x04b6;
        L_0x04a2:
            r3 = r1.j;
            r3 = r3.b;
            r5 = 0;
            r3 = r3.substring(r5, r2);
            r5 = r1.j;
            r5 = r5.b;
            r6 = 1;
            r2 = r2 + r6;
            r2 = r5.substring(r2);
            goto L_0x04cc;
        L_0x04b6:
            r2 = new com.xunlei.download.proguard.p;
            r3 = "invalid save path!";
            r4 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
            r2.<init>(r4, r3);
            throw r2;
        L_0x04c0:
            r35 = r6;
            r33 = r11;
            r34 = r12;
            r36 = r14;
            r2 = r40;
            r3 = r39;
        L_0x04cc:
            r5 = new com.xunlei.downloadlib.parameter.CIDTaskParam;
            r5.<init>();
            r5.mCid = r4;
            r5.mGcid = r7;
            r5.mBcid = r8;
            r5.mFilePath = r3;
            r5.mFileName = r2;
            r14 = r36;
            r5.mFileSize = r14;
            r4 = r35;
            r5.mCreateMode = r4;
            r6 = r1.o;
            r4 = r41;
            r4 = r1.a(r6, r4);
            r5.mSeqId = r4;
            r4 = r33;
            r6 = r34;
            r5 = r6.createCIDTask(r5, r4);
            r7 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
            if (r5 == r7) goto L_0x0515;
        L_0x04f9:
            r2 = new com.xunlei.download.proguard.p;
            r3 = com.android.providers.downloads.XlTaskHelper.b(r5);
            r4 = new java.lang.StringBuilder;
            r6 = "create task failed: ";
            r4.<init>(r6);
            r5 = com.android.providers.downloads.XlTaskHelper.a(r5);
            r4.append(r5);
            r4 = r4.toString();
            r2.<init>(r3, r4);
            throw r2;
        L_0x0515:
            r9 = r2;
        L_0x0516:
            r4 = r4.getTaskId();
            r2 = r1.i;
            r2 = r2.af;
            r7 = android.text.TextUtils.isEmpty(r2);
            if (r7 == 0) goto L_0x0528;
        L_0x0524:
            r2 = r1.i;
            r2 = r2.p;
        L_0x0528:
            r6.setDownloadTaskOrigin(r4, r2);
            r2 = android.text.TextUtils.isEmpty(r9);
            if (r2 == 0) goto L_0x053c;
        L_0x0531:
            r2 = android.text.TextUtils.isEmpty(r3);
            if (r2 == 0) goto L_0x053c;
        L_0x0537:
            r2 = r42;
            r1.a(r6, r2, r4);
        L_0x053c:
            r2 = r1.i;
            r2 = r2.i;
            r3 = r1.i;
            r3 = r3.f;
            r2 = com.xunlei.download.proguard.k.b(r2, r3);
            r2 = r6.startTask(r4, r2);
            r3 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
            if (r2 == r3) goto L_0x056c;
        L_0x0550:
            r3 = new com.xunlei.download.proguard.p;
            r4 = com.android.providers.downloads.XlTaskHelper.b(r2);
            r5 = new java.lang.StringBuilder;
            r6 = "start task failed:";
            r5.<init>(r6);
            r2 = com.android.providers.downloads.XlTaskHelper.a(r2);
            r5.append(r2);
            r2 = r5.toString();
            r3.<init>(r4, r2);
            throw r3;
        L_0x056c:
            return r4;
        L_0x056d:
            r2 = new com.xunlei.download.proguard.p;
            r3 = 491; // 0x1eb float:6.88E-43 double:2.426E-321;
            r4 = "unsupport url, cid and size must large than 0";
            r2.<init>(r3, r4);
            throw r2;
        L_0x0577:
            r4 = r5;
            r2 = r10;
            r2 = super.a(r39, r40, r41, r42);
            return r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.ExtendEntryTask.b.a(java.lang.String, java.lang.String, java.lang.String, boolean):long");
        }

        protected void a() throws p {
            if (this.i.W != TaskType.BT && this.i.W != TaskType.CID) {
                a("queryTaskInfoFromDownloadLib");
                super.a();
            }
        }

        public void b() {
            super.b();
            this.a.clear();
            this.c = null;
            this.d = null;
            if (this.i.W == TaskType.BT) {
                s.a().d(this.r);
                ContentValues contentValues = new ContentValues();
                contentValues.put("download_speed", Integer.valueOf(0));
                contentValues.put("origin_speed", Integer.valueOf(0));
                contentValues.put("p2p_speed", Integer.valueOf(0));
                contentValues.put("p2s_speed", Integer.valueOf(0));
                contentValues.put("addition_vip_speed", Integer.valueOf(0));
                contentValues.put("addition_lx_speed", Integer.valueOf(0));
                contentValues.put("dcdn_speed", Integer.valueOf(0));
                contentValues.put("status", Integer.valueOf(190));
                try {
                    String[] strArr = new String[2];
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.i.c);
                    strArr[0] = stringBuilder.toString();
                    strArr[1] = "192";
                    this.l.getContentResolver().update(DownloadProvider.c, contentValues, "bt_parent_id=? AND status=?", strArr);
                } catch (Throwable e) {
                    e.printStackTrace();
                    an.a(e);
                }
            }
        }

        private int a(int i, int i2) {
            if (i2 == 192) {
                i2 = 190;
            }
            if (i != 200) {
                if (i2 != 200) {
                    if (i != 0) {
                        if (i != 190) {
                            if (16 == DownloadManager.translateStatus(i2)) {
                                if (i != i2) {
                                    i = 491;
                                }
                            }
                        }
                        return i;
                    }
                    i = i2;
                    return i;
                }
            }
            return 200;
        }

        private void a(XLTaskInfo xLTaskInfo) {
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(this.o);
            stringBuilder.append("] task id:");
            stringBuilder.append(xLTaskInfo.mTaskId);
            stringBuilder.append(",TaskType:");
            stringBuilder.append(this.i.W);
            an.b("DownloadManager", stringBuilder.toString());
            long d = s.a().d();
            boolean c = s.a().c();
            if (d == xLTaskInfo.mTaskId && c) {
                d = s.a().e();
                s.a().a(false);
                this.h.removeNotPlayerBtSubTask(xLTaskInfo, (int) d);
                s.a().e(-1);
            }
        }

        protected void a(int i, XLTaskInfo xLTaskInfo, XLRangeInfo xLRangeInfo) {
            int i2;
            int i3;
            int[] iArr;
            int i4;
            int i5;
            boolean z;
            Throwable e;
            Throwable th;
            int i6 = i;
            XLTaskInfo xLTaskInfo2 = xLTaskInfo;
            super.a(i, xLTaskInfo, xLRangeInfo);
            if (this.i.W == TaskType.BT && xLTaskInfo2 != null) {
                boolean b = b(xLTaskInfo2.mTaskId);
                int i7 = -1;
                if (b) {
                    r1.h.removeNotPlayerBtSubTask(xLTaskInfo2, -1);
                }
                int i8 = 200;
                if ((i6 == 192 || i6 == 200) && r1.d != null && r1.d.length > 0) {
                    a(xLTaskInfo2);
                    int[] iArr2 = r1.d;
                    int length = iArr2.length;
                    int i9 = -1;
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    while (i10 < length) {
                        int i13 = iArr2[i10];
                        if (((Byte) r1.a.get(Integer.valueOf(i13))) == null) {
                            BtSubTaskDetail btSubTaskDetail = new BtSubTaskDetail();
                            i2 = length;
                            if (XLDownloadManager.getInstance(r1.l).getBtSubTaskInfo(xLTaskInfo2.mTaskId, i13, btSubTaskDetail) == 9000) {
                                int i14;
                                int i15;
                                long b2;
                                BtSubTaskDetail btSubTaskDetail2;
                                ContentValues contentValues;
                                BtSubTaskDetail btSubTaskDetail3;
                                a aVar;
                                String str;
                                XLRangeInfo xLRangeInfo2;
                                ContentResolver contentResolver;
                                Uri uri;
                                String str2;
                                String[] strArr;
                                StringBuilder stringBuilder;
                                if (btSubTaskDetail.mTaskInfo.mTaskStatus == 2) {
                                    i14 = i8;
                                } else if (btSubTaskDetail.mTaskInfo.mTaskStatus == 3) {
                                    i14 = btSubTaskDetail.mTaskInfo.mErrorCode;
                                } else if (btSubTaskDetail.mTaskInfo.mTaskStatus == 4) {
                                    i14 = 193;
                                } else if (btSubTaskDetail.mTaskInfo.mTaskStatus == 0) {
                                    i14 = 190;
                                } else {
                                    if (btSubTaskDetail.mTaskInfo.mTaskStatus == 1) {
                                        i3 = i10;
                                        btSubTaskDetail.mTaskInfo.mTaskId = xLTaskInfo2.mTaskId;
                                        i11 = a(i11, r1.h.tryEnterLXChannel(btSubTaskDetail.mTaskInfo, i13, b));
                                        i12 = a(i12, r1.h.tryEnterVipChannel(btSubTaskDetail.mTaskInfo, i13, b));
                                        if (i9 != 0) {
                                            i14 = r1.h.getSubTaskVipErrNo(i13);
                                            if (i14 != 0) {
                                                if (i7 != i14) {
                                                    if (!(i7 == i9 || i9 == i14)) {
                                                        i14 = 192;
                                                        i9 = 1;
                                                    }
                                                }
                                            }
                                            i9 = i14;
                                        }
                                        i14 = 192;
                                    } else {
                                        i3 = i10;
                                        i14 = 491;
                                    }
                                    if (i14 != i8) {
                                        if (i14 == 491) {
                                            i15 = i14;
                                            b2 = s.a().b(r1.i.c);
                                            if (b2 >= 0 && ((long) i13) == b2) {
                                                s.a().a(r1.l, xLTaskInfo2.mTaskId, i13);
                                            }
                                            btSubTaskDetail2 = btSubTaskDetail;
                                            contentValues = new ContentValues();
                                            btSubTaskDetail3 = btSubTaskDetail2;
                                            contentValues.put("total_bytes", Long.valueOf(btSubTaskDetail3.mTaskInfo.mFileSize));
                                            contentValues.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(btSubTaskDetail3.mTaskInfo.mDownloadSize));
                                            contentValues.put("download_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mDownloadSpeed));
                                            contentValues.put("p2s_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2SSpeed));
                                            contentValues.put("origin_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mOriginSpeed));
                                            contentValues.put("addition_vip_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResPeerSpeed));
                                            contentValues.put("cid", btSubTaskDetail3.mTaskInfo.mCid);
                                            contentValues.put("gcid", btSubTaskDetail3.mTaskInfo.mGcid);
                                            contentValues.put("status", Integer.valueOf(i15));
                                            contentValues.put("bt_sub_is_selected", Boolean.valueOf(btSubTaskDetail3.mIsSelect));
                                            contentValues.put("dcdn_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNSpeed));
                                            aVar = (a) r1.b.get(Integer.valueOf(i13));
                                            if (aVar == null) {
                                                iArr = iArr2;
                                                i4 = i11;
                                                i5 = i12;
                                                contentValues.put("vip_receive_size", Long.valueOf(aVar.a + btSubTaskDetail3.mTaskInfo.mAdditionalResPeerBytes));
                                                z = b;
                                                contentValues.put("lx_receive_size", Long.valueOf(aVar.b + btSubTaskDetail3.mTaskInfo.mAdditionalResVipRecvBytes));
                                                contentValues.put("p2p_receive_size", Long.valueOf(aVar.d + btSubTaskDetail3.mTaskInfo.mP2PRecvBytes));
                                                contentValues.put("p2s_receive_size", Long.valueOf(aVar.c + btSubTaskDetail3.mTaskInfo.mP2SRecvBytes));
                                                contentValues.put("origin_receive_size", Long.valueOf(aVar.e + btSubTaskDetail3.mTaskInfo.mOriginRecvBytes));
                                                contentValues.put("dcdn_receive_size", Long.valueOf(aVar.f + btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNBytes));
                                            } else {
                                                iArr = iArr2;
                                                z = b;
                                                i4 = i11;
                                                i5 = i12;
                                                contentValues.put("vip_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResPeerBytes));
                                                contentValues.put("lx_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResVipRecvBytes));
                                                contentValues.put("p2p_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2PRecvBytes));
                                                contentValues.put("p2s_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2SRecvBytes));
                                                contentValues.put("origin_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mOriginRecvBytes));
                                                contentValues.put("dcdn_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNBytes));
                                            }
                                            contentValues.put("addition_lx_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResVipSpeed));
                                            contentValues.put("p2p_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2PSpeed));
                                            str = "";
                                            xLRangeInfo2 = new XLRangeInfo();
                                            XLDownloadManager.getInstance(r1.l).getDownloadRangeInfo(r1.r, i13, xLRangeInfo2);
                                            if (xLRangeInfo2.mRangeInfo != null) {
                                                str = xLRangeInfo2.mRangeInfo;
                                            }
                                            contentValues.put(Impl.COLUMN_RANGE_INFO, str);
                                            contentResolver = r1.l.getContentResolver();
                                            uri = DownloadProvider.c;
                                            str2 = "bt_parent_id=? AND bt_sub_index=?";
                                            strArr = new String[2];
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append(r1.i.c);
                                            strArr[0] = stringBuilder.toString();
                                            strArr[1] = String.valueOf(i13);
                                            contentResolver.update(uri, contentValues, str2, strArr);
                                            i11 = i4;
                                            i12 = i5;
                                            i10 = i3 + 1;
                                            length = i2;
                                            iArr2 = iArr;
                                            b = z;
                                            xLTaskInfo2 = xLTaskInfo;
                                            i7 = -1;
                                            i8 = 200;
                                        }
                                    }
                                    i15 = i14;
                                    r1.a.put(Integer.valueOf(i13), Byte.valueOf((byte) 1));
                                    btSubTaskDetail2 = btSubTaskDetail;
                                    s.a().b(r1.i.c, (long) i13);
                                    contentValues = new ContentValues();
                                    btSubTaskDetail3 = btSubTaskDetail2;
                                    contentValues.put("total_bytes", Long.valueOf(btSubTaskDetail3.mTaskInfo.mFileSize));
                                    contentValues.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(btSubTaskDetail3.mTaskInfo.mDownloadSize));
                                    contentValues.put("download_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mDownloadSpeed));
                                    contentValues.put("p2s_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2SSpeed));
                                    contentValues.put("origin_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mOriginSpeed));
                                    contentValues.put("addition_vip_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResPeerSpeed));
                                    contentValues.put("cid", btSubTaskDetail3.mTaskInfo.mCid);
                                    contentValues.put("gcid", btSubTaskDetail3.mTaskInfo.mGcid);
                                    contentValues.put("status", Integer.valueOf(i15));
                                    contentValues.put("bt_sub_is_selected", Boolean.valueOf(btSubTaskDetail3.mIsSelect));
                                    contentValues.put("dcdn_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNSpeed));
                                    aVar = (a) r1.b.get(Integer.valueOf(i13));
                                    if (aVar == null) {
                                        iArr = iArr2;
                                        z = b;
                                        i4 = i11;
                                        i5 = i12;
                                        contentValues.put("vip_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResPeerBytes));
                                        contentValues.put("lx_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResVipRecvBytes));
                                        contentValues.put("p2p_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2PRecvBytes));
                                        contentValues.put("p2s_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2SRecvBytes));
                                        contentValues.put("origin_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mOriginRecvBytes));
                                        contentValues.put("dcdn_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNBytes));
                                    } else {
                                        iArr = iArr2;
                                        i4 = i11;
                                        i5 = i12;
                                        contentValues.put("vip_receive_size", Long.valueOf(aVar.a + btSubTaskDetail3.mTaskInfo.mAdditionalResPeerBytes));
                                        z = b;
                                        contentValues.put("lx_receive_size", Long.valueOf(aVar.b + btSubTaskDetail3.mTaskInfo.mAdditionalResVipRecvBytes));
                                        contentValues.put("p2p_receive_size", Long.valueOf(aVar.d + btSubTaskDetail3.mTaskInfo.mP2PRecvBytes));
                                        contentValues.put("p2s_receive_size", Long.valueOf(aVar.c + btSubTaskDetail3.mTaskInfo.mP2SRecvBytes));
                                        contentValues.put("origin_receive_size", Long.valueOf(aVar.e + btSubTaskDetail3.mTaskInfo.mOriginRecvBytes));
                                        contentValues.put("dcdn_receive_size", Long.valueOf(aVar.f + btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNBytes));
                                    }
                                    contentValues.put("addition_lx_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResVipSpeed));
                                    contentValues.put("p2p_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2PSpeed));
                                    str = "";
                                    xLRangeInfo2 = new XLRangeInfo();
                                    XLDownloadManager.getInstance(r1.l).getDownloadRangeInfo(r1.r, i13, xLRangeInfo2);
                                    if (xLRangeInfo2.mRangeInfo != null) {
                                        str = xLRangeInfo2.mRangeInfo;
                                    }
                                    contentValues.put(Impl.COLUMN_RANGE_INFO, str);
                                    contentResolver = r1.l.getContentResolver();
                                    uri = DownloadProvider.c;
                                    str2 = "bt_parent_id=? AND bt_sub_index=?";
                                    strArr = new String[2];
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(r1.i.c);
                                    strArr[0] = stringBuilder.toString();
                                    strArr[1] = String.valueOf(i13);
                                    contentResolver.update(uri, contentValues, str2, strArr);
                                    i11 = i4;
                                    i12 = i5;
                                    i10 = i3 + 1;
                                    length = i2;
                                    iArr2 = iArr;
                                    b = z;
                                    xLTaskInfo2 = xLTaskInfo;
                                    i7 = -1;
                                    i8 = 200;
                                }
                                i3 = i10;
                                if (i14 != i8) {
                                    if (i14 == 491) {
                                        i15 = i14;
                                        b2 = s.a().b(r1.i.c);
                                        s.a().a(r1.l, xLTaskInfo2.mTaskId, i13);
                                        btSubTaskDetail2 = btSubTaskDetail;
                                        contentValues = new ContentValues();
                                        btSubTaskDetail3 = btSubTaskDetail2;
                                        contentValues.put("total_bytes", Long.valueOf(btSubTaskDetail3.mTaskInfo.mFileSize));
                                        contentValues.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(btSubTaskDetail3.mTaskInfo.mDownloadSize));
                                        contentValues.put("download_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mDownloadSpeed));
                                        contentValues.put("p2s_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2SSpeed));
                                        contentValues.put("origin_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mOriginSpeed));
                                        contentValues.put("addition_vip_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResPeerSpeed));
                                        contentValues.put("cid", btSubTaskDetail3.mTaskInfo.mCid);
                                        contentValues.put("gcid", btSubTaskDetail3.mTaskInfo.mGcid);
                                        contentValues.put("status", Integer.valueOf(i15));
                                        contentValues.put("bt_sub_is_selected", Boolean.valueOf(btSubTaskDetail3.mIsSelect));
                                        contentValues.put("dcdn_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNSpeed));
                                        aVar = (a) r1.b.get(Integer.valueOf(i13));
                                        if (aVar == null) {
                                            iArr = iArr2;
                                            i4 = i11;
                                            i5 = i12;
                                            contentValues.put("vip_receive_size", Long.valueOf(aVar.a + btSubTaskDetail3.mTaskInfo.mAdditionalResPeerBytes));
                                            z = b;
                                            contentValues.put("lx_receive_size", Long.valueOf(aVar.b + btSubTaskDetail3.mTaskInfo.mAdditionalResVipRecvBytes));
                                            contentValues.put("p2p_receive_size", Long.valueOf(aVar.d + btSubTaskDetail3.mTaskInfo.mP2PRecvBytes));
                                            contentValues.put("p2s_receive_size", Long.valueOf(aVar.c + btSubTaskDetail3.mTaskInfo.mP2SRecvBytes));
                                            contentValues.put("origin_receive_size", Long.valueOf(aVar.e + btSubTaskDetail3.mTaskInfo.mOriginRecvBytes));
                                            contentValues.put("dcdn_receive_size", Long.valueOf(aVar.f + btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNBytes));
                                        } else {
                                            iArr = iArr2;
                                            z = b;
                                            i4 = i11;
                                            i5 = i12;
                                            contentValues.put("vip_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResPeerBytes));
                                            contentValues.put("lx_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResVipRecvBytes));
                                            contentValues.put("p2p_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2PRecvBytes));
                                            contentValues.put("p2s_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2SRecvBytes));
                                            contentValues.put("origin_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mOriginRecvBytes));
                                            contentValues.put("dcdn_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNBytes));
                                        }
                                        contentValues.put("addition_lx_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResVipSpeed));
                                        contentValues.put("p2p_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2PSpeed));
                                        str = "";
                                        xLRangeInfo2 = new XLRangeInfo();
                                        XLDownloadManager.getInstance(r1.l).getDownloadRangeInfo(r1.r, i13, xLRangeInfo2);
                                        if (xLRangeInfo2.mRangeInfo != null) {
                                            str = xLRangeInfo2.mRangeInfo;
                                        }
                                        contentValues.put(Impl.COLUMN_RANGE_INFO, str);
                                        contentResolver = r1.l.getContentResolver();
                                        uri = DownloadProvider.c;
                                        str2 = "bt_parent_id=? AND bt_sub_index=?";
                                        strArr = new String[2];
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(r1.i.c);
                                        strArr[0] = stringBuilder.toString();
                                        strArr[1] = String.valueOf(i13);
                                        contentResolver.update(uri, contentValues, str2, strArr);
                                        i11 = i4;
                                        i12 = i5;
                                        i10 = i3 + 1;
                                        length = i2;
                                        iArr2 = iArr;
                                        b = z;
                                        xLTaskInfo2 = xLTaskInfo;
                                        i7 = -1;
                                        i8 = 200;
                                    }
                                }
                                i15 = i14;
                                r1.a.put(Integer.valueOf(i13), Byte.valueOf((byte) 1));
                                btSubTaskDetail2 = btSubTaskDetail;
                                s.a().b(r1.i.c, (long) i13);
                                contentValues = new ContentValues();
                                btSubTaskDetail3 = btSubTaskDetail2;
                                contentValues.put("total_bytes", Long.valueOf(btSubTaskDetail3.mTaskInfo.mFileSize));
                                contentValues.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(btSubTaskDetail3.mTaskInfo.mDownloadSize));
                                contentValues.put("download_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mDownloadSpeed));
                                contentValues.put("p2s_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2SSpeed));
                                contentValues.put("origin_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mOriginSpeed));
                                contentValues.put("addition_vip_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResPeerSpeed));
                                contentValues.put("cid", btSubTaskDetail3.mTaskInfo.mCid);
                                contentValues.put("gcid", btSubTaskDetail3.mTaskInfo.mGcid);
                                contentValues.put("status", Integer.valueOf(i15));
                                contentValues.put("bt_sub_is_selected", Boolean.valueOf(btSubTaskDetail3.mIsSelect));
                                contentValues.put("dcdn_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNSpeed));
                                aVar = (a) r1.b.get(Integer.valueOf(i13));
                                if (aVar == null) {
                                    iArr = iArr2;
                                    z = b;
                                    i4 = i11;
                                    i5 = i12;
                                    contentValues.put("vip_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResPeerBytes));
                                    contentValues.put("lx_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResVipRecvBytes));
                                    contentValues.put("p2p_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2PRecvBytes));
                                    contentValues.put("p2s_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2SRecvBytes));
                                    contentValues.put("origin_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mOriginRecvBytes));
                                    contentValues.put("dcdn_receive_size", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNBytes));
                                } else {
                                    iArr = iArr2;
                                    i4 = i11;
                                    i5 = i12;
                                    contentValues.put("vip_receive_size", Long.valueOf(aVar.a + btSubTaskDetail3.mTaskInfo.mAdditionalResPeerBytes));
                                    z = b;
                                    contentValues.put("lx_receive_size", Long.valueOf(aVar.b + btSubTaskDetail3.mTaskInfo.mAdditionalResVipRecvBytes));
                                    contentValues.put("p2p_receive_size", Long.valueOf(aVar.d + btSubTaskDetail3.mTaskInfo.mP2PRecvBytes));
                                    contentValues.put("p2s_receive_size", Long.valueOf(aVar.c + btSubTaskDetail3.mTaskInfo.mP2SRecvBytes));
                                    contentValues.put("origin_receive_size", Long.valueOf(aVar.e + btSubTaskDetail3.mTaskInfo.mOriginRecvBytes));
                                    contentValues.put("dcdn_receive_size", Long.valueOf(aVar.f + btSubTaskDetail3.mTaskInfo.mAdditionalResDCDNBytes));
                                }
                                contentValues.put("addition_lx_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mAdditionalResVipSpeed));
                                contentValues.put("p2p_speed", Long.valueOf(btSubTaskDetail3.mTaskInfo.mP2PSpeed));
                                str = "";
                                xLRangeInfo2 = new XLRangeInfo();
                                XLDownloadManager.getInstance(r1.l).getDownloadRangeInfo(r1.r, i13, xLRangeInfo2);
                                if (xLRangeInfo2.mRangeInfo != null) {
                                    str = xLRangeInfo2.mRangeInfo;
                                }
                                contentValues.put(Impl.COLUMN_RANGE_INFO, str);
                                try {
                                    contentResolver = r1.l.getContentResolver();
                                    uri = DownloadProvider.c;
                                    str2 = "bt_parent_id=? AND bt_sub_index=?";
                                    strArr = new String[2];
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(r1.i.c);
                                    try {
                                        strArr[0] = stringBuilder.toString();
                                        strArr[1] = String.valueOf(i13);
                                        contentResolver.update(uri, contentValues, str2, strArr);
                                    } catch (Exception e2) {
                                        e = e2;
                                        th = e;
                                        th.printStackTrace();
                                        an.a(th);
                                        i11 = i4;
                                        i12 = i5;
                                        i10 = i3 + 1;
                                        length = i2;
                                        iArr2 = iArr;
                                        b = z;
                                        xLTaskInfo2 = xLTaskInfo;
                                        i7 = -1;
                                        i8 = 200;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    th = e;
                                    th.printStackTrace();
                                    an.a(th);
                                    i11 = i4;
                                    i12 = i5;
                                    i10 = i3 + 1;
                                    length = i2;
                                    iArr2 = iArr;
                                    b = z;
                                    xLTaskInfo2 = xLTaskInfo;
                                    i7 = -1;
                                    i8 = 200;
                                }
                                i11 = i4;
                                i12 = i5;
                                i10 = i3 + 1;
                                length = i2;
                                iArr2 = iArr;
                                b = z;
                                xLTaskInfo2 = xLTaskInfo;
                                i7 = -1;
                                i8 = 200;
                            } else {
                                iArr = iArr2;
                                z = b;
                            }
                        } else {
                            iArr = iArr2;
                            z = b;
                            i2 = length;
                        }
                        i3 = i10;
                        i10 = i3 + 1;
                        length = i2;
                        iArr2 = iArr;
                        b = z;
                        xLTaskInfo2 = xLTaskInfo;
                        i7 = -1;
                        i8 = 200;
                    }
                    if (i11 != 0) {
                        r1.j.x = i11;
                    }
                    if (i12 != 0) {
                        r1.j.t = i12;
                        if (501 == i12) {
                            i9 = -100;
                        }
                    }
                    if (-1 != i9) {
                        r1.j.u = i9;
                    }
                }
            }
        }

        private String a(long j, String str, BtIndexSet btIndexSet, BtIndexSet btIndexSet2) {
            StringBuilder stringBuilder = new StringBuilder();
            btIndexSet.mIndexSet = new int[this.c.mFileCount];
            HashSet hashSet = new HashSet();
            BtSubTaskDetail btSubTaskDetail = new BtSubTaskDetail();
            int i = 0;
            for (int i2 = 0; i2 < btIndexSet.mIndexSet.length; i2++) {
                btIndexSet.mIndexSet[i2] = this.c.mSubFileInfo[i2].mFileIndex;
                stringBuilder.append(btIndexSet.mIndexSet[i2]);
                stringBuilder.append(h.b);
                XLDownloadManager.getInstance(this.l).getBtSubTaskInfo(j, btIndexSet.mIndexSet[i2], btSubTaskDetail);
                if (btSubTaskDetail.mIsSelect) {
                    hashSet.add(Integer.valueOf(btIndexSet.mIndexSet[i2]));
                }
            }
            if (str != null) {
                if (str.length() > null) {
                    j = str.split(h.b);
                    if (j == null) {
                        return stringBuilder.toString();
                    }
                    ArrayList arrayList = new ArrayList();
                    str = new ArrayList();
                    for (int i3 = 0; i3 < j.length; i3++) {
                        int intValue = Integer.valueOf(j[i3]).intValue();
                        if (intValue >= 0 && intValue < this.c.mFileCount) {
                            Integer valueOf = Integer.valueOf(j[i3]);
                            arrayList.add(valueOf);
                            if (hashSet.contains(valueOf)) {
                                hashSet.remove(valueOf);
                            } else {
                                str.add(valueOf);
                            }
                        }
                    }
                    if (hashSet.size() > null) {
                        btIndexSet2.mIndexSet = new int[hashSet.size()];
                        j = hashSet.iterator();
                        int i4 = 0;
                        while (j.hasNext()) {
                            int i5 = i4 + 1;
                            btIndexSet2.mIndexSet[i4] = ((Integer) j.next()).intValue();
                            i4 = i5;
                        }
                    } else {
                        btIndexSet2.mIndexSet = null;
                    }
                    if (str.size() > null) {
                        btIndexSet.mIndexSet = new int[str.size()];
                        for (j = 0; j < str.size(); j++) {
                            btIndexSet.mIndexSet[j] = ((Integer) str.get(j)).intValue();
                        }
                    } else {
                        btIndexSet.mIndexSet = null;
                    }
                    j = "";
                    while (i < arrayList.size()) {
                        str = new StringBuilder();
                        str.append(j);
                        str.append(arrayList.get(i));
                        str.append(h.b);
                        j = str.toString();
                        i++;
                    }
                    return j;
                }
            }
            return stringBuilder.toString();
        }

        private ArrayList<Integer> a(BtIndexSet btIndexSet) {
            ArrayList<Integer> arrayList = new ArrayList();
            if (btIndexSet.mIndexSet != null) {
                for (int valueOf : btIndexSet.mIndexSet) {
                    arrayList.add(Integer.valueOf(valueOf));
                }
            }
            return arrayList;
        }

        private ArrayList<Integer> a(BtIndexSet btIndexSet, BtIndexSet btIndexSet2) {
            btIndexSet = a(btIndexSet);
            btIndexSet.retainAll(a(btIndexSet2));
            return btIndexSet;
        }

        private ArrayList<Integer> b(BtIndexSet btIndexSet, BtIndexSet btIndexSet2) {
            btIndexSet = a(btIndexSet);
            btIndexSet.removeAll(a(btIndexSet2));
            return btIndexSet;
        }

        private BtIndexSet a(long j) {
            Cursor query;
            BtIndexSet btIndexSet = new BtIndexSet();
            String[] strArr = new String[1];
            int i = 0;
            strArr[0] = "bt_sub_index";
            try {
                query = this.l.getContentResolver().query(DownloadProvider.c, strArr, "bt_parent_id=?", new String[]{String.valueOf(j)}, null);
            } catch (Throwable e) {
                e.printStackTrace();
                an.a(e);
                query = null;
            }
            if (query == null) {
                StringBuilder stringBuilder = new StringBuilder("[");
                stringBuilder.append(j);
                stringBuilder.append("] query subtask is database: cursor is null");
                an.b("DownloadManager", stringBuilder.toString());
            } else {
                btIndexSet.mIndexSet = new int[query.getCount()];
                query.moveToFirst();
                while (query.isAfterLast() == null) {
                    int i2 = i + 1;
                    btIndexSet.mIndexSet[i] = query.getInt(query.getColumnIndex("bt_sub_index"));
                    query.moveToNext();
                    i = i2;
                }
                query.close();
            }
            return btIndexSet;
        }

        private void a(ArrayList<Integer> arrayList, long j, String str) {
            ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                int intValue = ((Integer) arrayList.get(i)).intValue();
                ContentValues contentValues = new ContentValues();
                if (str != null) {
                    StringBuilder stringBuilder;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append(File.separator);
                    String stringBuilder3 = stringBuilder2.toString();
                    if (!(this.c.mSubFileInfo[intValue].mSubPath == null || this.c.mSubFileInfo[intValue].mSubPath.equals(""))) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(stringBuilder3);
                        stringBuilder.append(this.c.mSubFileInfo[intValue].mSubPath);
                        stringBuilder.append(File.separator);
                        stringBuilder3 = stringBuilder.toString();
                    }
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(stringBuilder3);
                    stringBuilder.append(this.c.mSubFileInfo[intValue].mFileName);
                    contentValues.put(Impl._DATA, stringBuilder.toString());
                }
                contentValues.put("bt_parent_id", Long.valueOf(j));
                contentValues.put("bt_sub_index", Integer.valueOf(intValue));
                contentValues.put("title", this.c.mSubFileInfo[intValue].mFileName);
                contentValues.put("mimetype", am.b(this.c.mSubFileInfo[intValue].mFileName));
                contentValues.put("total_bytes", Long.valueOf(this.c.mSubFileInfo[intValue].mFileSize));
                contentValues.put(Impl.COLUMN_CURRENT_BYTES, Integer.valueOf(0));
                contentValues.put("status", Integer.valueOf(190));
                contentValues.put("bt_sub_is_selected", Integer.valueOf(1));
                contentValuesArr[i] = contentValues;
            }
            if (contentValuesArr.length > null) {
                try {
                    arrayList = this.l.getContentResolver().bulkInsert(DownloadProvider.c, contentValuesArr);
                    StringBuilder stringBuilder4 = new StringBuilder("[");
                    stringBuilder4.append(j);
                    stringBuilder4.append("] newly insert subtask count: ");
                    stringBuilder4.append(arrayList);
                    an.b("DownloadManager", stringBuilder4.toString());
                } catch (ArrayList<Integer> arrayList2) {
                    arrayList2.printStackTrace();
                    an.a(arrayList2);
                }
            }
        }

        private void a(ArrayList<Integer> arrayList, long j) {
            StringBuilder stringBuilder = new StringBuilder();
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                stringBuilder.append(((Integer) arrayList.next()).intValue());
                stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            if (stringBuilder.length() > null) {
                try {
                    arrayList = this.l.getContentResolver();
                    Uri uri = DownloadProvider.c;
                    StringBuilder stringBuilder2 = new StringBuilder("bt_parent_id=?AND bt_sub_index IN (");
                    stringBuilder2.append(stringBuilder.subSequence(0, stringBuilder.length() - 1));
                    stringBuilder2.append(k.t);
                    arrayList = arrayList.delete(uri, stringBuilder2.toString(), new String[]{String.valueOf(j)});
                    StringBuilder stringBuilder3 = new StringBuilder("[");
                    stringBuilder3.append(j);
                    stringBuilder3.append("] newly delete subtask count: ");
                    stringBuilder3.append(arrayList);
                    an.b("DownloadManager", stringBuilder3.toString());
                } catch (ArrayList<Integer> arrayList2) {
                    arrayList2.printStackTrace();
                    an.a(arrayList2);
                }
            }
        }

        private boolean b(long j) {
            boolean z;
            b bVar = this;
            long j2 = j;
            synchronized (ExtendEntryTask.b) {
                try {
                    boolean z2;
                    BtIndexSet btIndexSet;
                    BtIndexSet btIndexSet2;
                    String a;
                    String[] split;
                    long j3;
                    int parseInt;
                    long j4;
                    BtIndexSet a2;
                    long j5;
                    StringBuilder stringBuilder;
                    StringBuilder stringBuilder2;
                    String str = bVar.i.M;
                    int i = 0;
                    if (bVar.j.p != null && bVar.j.p.length() > 0) {
                        if (str == null || str.length() <= 0 || bVar.j.p.equals(str)) {
                            z2 = false;
                            if (z2) {
                                z = z2;
                            } else {
                                btIndexSet = new BtIndexSet();
                                btIndexSet2 = new BtIndexSet();
                                a = a(j2, str, btIndexSet, btIndexSet2);
                                split = a.split(h.b);
                                j3 = 0;
                                bVar.d = new int[split.length];
                                while (i < split.length) {
                                    parseInt = Integer.parseInt(split[i]);
                                    j4 = j3 + bVar.c.mSubFileInfo[parseInt].mFileSize;
                                    bVar.d[i] = parseInt;
                                    i++;
                                    j3 = j4;
                                    j2 = j;
                                }
                                bVar.a.clear();
                                bVar.j.g = j3;
                                bVar.j.p = a;
                                a2 = a(bVar.i.c);
                                a(b(btIndexSet, a2), bVar.i.c, bVar.j.b);
                                a(a(btIndexSet2, a2), bVar.i.c);
                                if (btIndexSet.mIndexSet == null) {
                                    j5 = j;
                                    XLDownloadManager.getInstance(bVar.l).selectBtSubTask(j5, btIndexSet);
                                    stringBuilder = new StringBuilder("[");
                                    z = z2;
                                    stringBuilder.append(bVar.o);
                                    stringBuilder.append("] selectIndexSet.mIndexSet=");
                                    stringBuilder.append(Arrays.toString(btIndexSet.mIndexSet));
                                    an.b("DownloadManager", stringBuilder.toString());
                                } else {
                                    z = z2;
                                    j5 = j;
                                }
                                if (btIndexSet2.mIndexSet != null) {
                                    XLDownloadManager.getInstance(bVar.l).deselectBtSubTask(j5, btIndexSet2);
                                    stringBuilder2 = new StringBuilder("[");
                                    stringBuilder2.append(bVar.o);
                                    stringBuilder2.append("] deselectIndexSet.mIndexSet=");
                                    stringBuilder2.append(Arrays.toString(btIndexSet2.mIndexSet));
                                    an.b("DownloadManager", stringBuilder2.toString());
                                }
                                stringBuilder2 = new StringBuilder("[");
                                stringBuilder2.append(bVar.o);
                                stringBuilder2.append("] result=");
                                stringBuilder2.append(a);
                                stringBuilder2.append(", size=");
                                stringBuilder2.append(j3);
                                an.b("DownloadManager", stringBuilder2.toString());
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                        z = z2;
                    } else {
                        btIndexSet = new BtIndexSet();
                        btIndexSet2 = new BtIndexSet();
                        a = a(j2, str, btIndexSet, btIndexSet2);
                        split = a.split(h.b);
                        j3 = 0;
                        bVar.d = new int[split.length];
                        while (i < split.length) {
                            parseInt = Integer.parseInt(split[i]);
                            j4 = j3 + bVar.c.mSubFileInfo[parseInt].mFileSize;
                            bVar.d[i] = parseInt;
                            i++;
                            j3 = j4;
                            j2 = j;
                        }
                        bVar.a.clear();
                        bVar.j.g = j3;
                        bVar.j.p = a;
                        a2 = a(bVar.i.c);
                        a(b(btIndexSet, a2), bVar.i.c, bVar.j.b);
                        a(a(btIndexSet2, a2), bVar.i.c);
                        if (btIndexSet.mIndexSet == null) {
                            z = z2;
                            j5 = j;
                        } else {
                            j5 = j;
                            XLDownloadManager.getInstance(bVar.l).selectBtSubTask(j5, btIndexSet);
                            stringBuilder = new StringBuilder("[");
                            z = z2;
                            stringBuilder.append(bVar.o);
                            stringBuilder.append("] selectIndexSet.mIndexSet=");
                            stringBuilder.append(Arrays.toString(btIndexSet.mIndexSet));
                            an.b("DownloadManager", stringBuilder.toString());
                        }
                        if (btIndexSet2.mIndexSet != null) {
                            XLDownloadManager.getInstance(bVar.l).deselectBtSubTask(j5, btIndexSet2);
                            stringBuilder2 = new StringBuilder("[");
                            stringBuilder2.append(bVar.o);
                            stringBuilder2.append("] deselectIndexSet.mIndexSet=");
                            stringBuilder2.append(Arrays.toString(btIndexSet2.mIndexSet));
                            an.b("DownloadManager", stringBuilder2.toString());
                        }
                        stringBuilder2 = new StringBuilder("[");
                        stringBuilder2.append(bVar.o);
                        stringBuilder2.append("] result=");
                        stringBuilder2.append(a);
                        stringBuilder2.append(", size=");
                        stringBuilder2.append(j3);
                        an.b("DownloadManager", stringBuilder2.toString());
                    }
                } catch (Throwable th) {
                    Throwable th2 = th;
                }
            }
            return z;
        }

        private void a(File file, File file2) {
            if (file.exists() && file.isFile() && file.canRead()) {
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    file = new FileOutputStream(file2);
                    file2 = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(file2);
                        if (read > 0) {
                            file.write(file2, 0, read);
                        } else {
                            fileInputStream.close();
                            file.close();
                            return;
                        }
                    }
                } catch (File file3) {
                    file3.printStackTrace();
                    an.a(file3);
                } catch (File file32) {
                    file32.printStackTrace();
                    an.a(file32);
                }
            }
        }

        public android.content.ContentValues a(android.content.Context r10, android.content.ContentValues r11) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r9 = this;
            r0 = "uri";
            r0 = r11.getAsString(r0);
            r1 = "destination";
            r1 = r11.getAsInteger(r1);
            r1 = r1.intValue();
            r2 = "hint";
            r2 = r11.getAsString(r2);
            r3 = "_data";
            r3 = r11.getAsString(r3);
            r4 = android.text.TextUtils.isEmpty(r0);
            if (r4 == 0) goto L_0x0023;
        L_0x0022:
            return r11;
        L_0x0023:
            r4 = r9.l;
            r4 = com.xunlei.downloadlib.XLDownloadManager.getInstance(r4);
            r5 = new com.xunlei.downloadlib.parameter.TorrentInfo;
            r5.<init>();
            r9.c = r5;
            r6 = android.net.Uri.parse(r0);
            r6 = r6.getPath();
            r4 = r4.getTorrentInfo(r6, r5);
            r6 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;
            if (r4 == r6) goto L_0x007c;
        L_0x0040:
            r10 = "DownloadManager";
            r0 = new java.lang.StringBuilder;
            r1 = "prepareTask failed: ";
            r0.<init>(r1);
            r1 = com.android.providers.downloads.XlTaskHelper.a(r4);
            r0.append(r1);
            r0 = r0.toString();
            com.xunlei.download.proguard.an.d(r10, r0);
            r10 = "errorMsg";
            r0 = new java.lang.StringBuilder;
            r1 = "prepareTask failed: ";
            r0.<init>(r1);
            r1 = com.android.providers.downloads.XlTaskHelper.a(r4);
            r0.append(r1);
            r0 = r0.toString();
            r11.put(r10, r0);
            r10 = "status";
            r0 = com.android.providers.downloads.XlTaskHelper.b(r4);
            r0 = java.lang.Integer.valueOf(r0);
            r11.put(r10, r0);
            return r11;
        L_0x007c:
            r4 = "etag";
            r6 = r5.mInfoHash;
            r11.put(r4, r6);
            r4 = android.text.TextUtils.isEmpty(r3);
            if (r4 == 0) goto L_0x01d4;
        L_0x0089:
            r3 = 4;
            r4 = 0;
            r6 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;
            if (r1 != r3) goto L_0x00aa;
        L_0x008f:
            r10 = android.net.Uri.parse(r2);
            r10 = r10.getPath();
            r1 = "{filename}";
            r1 = r10.endsWith(r1);
            if (r1 == 0) goto L_0x00ba;
        L_0x009f:
            r1 = r10.length();
            r1 = r1 + -10;
            r10 = r10.substring(r4, r1);
            goto L_0x00ba;
        L_0x00aa:
            r2 = new com.xunlei.download.proguard.q;	 Catch:{ IOException -> 0x01c3, p -> 0x01ab }
            r2.<init>(r10);	 Catch:{ IOException -> 0x01c3, p -> 0x01ab }
            r10 = 0;	 Catch:{ IOException -> 0x01c3, p -> 0x01ab }
            r7 = 0;	 Catch:{ IOException -> 0x01c3, p -> 0x01ab }
            r10 = r2.a(r10, r1, r7);	 Catch:{ IOException -> 0x01c3, p -> 0x01ab }
            r10 = r10.getCanonicalPath();	 Catch:{ IOException -> 0x01c3, p -> 0x01ab }
        L_0x00ba:
            r1 = new java.io.File;
            r1.<init>(r10);
            r2 = r1.exists();
            if (r2 != 0) goto L_0x00f3;
        L_0x00c5:
            r2 = r1.mkdirs();
            if (r2 != 0) goto L_0x00f3;
        L_0x00cb:
            r10 = "errorMsg";
            r0 = "create dir failed1";
            r11.put(r10, r0);
            r10 = "status";
            r0 = java.lang.Integer.valueOf(r6);
            r11.put(r10, r0);
            r10 = "DownloadManager";
            r0 = new java.lang.StringBuilder;
            r2 = "prepareSavePath create dir failed1, dir=";
            r0.<init>(r2);
            r1 = r1.getAbsolutePath();
            r0.append(r1);
            r0 = r0.toString();
            com.xunlei.download.proguard.an.b(r10, r0);
            return r11;
        L_0x00f3:
            r2 = r1.isDirectory();
            if (r2 != 0) goto L_0x0121;
        L_0x00f9:
            r10 = "errorMsg";
            r0 = "dir not exist";
            r11.put(r10, r0);
            r10 = "status";
            r0 = java.lang.Integer.valueOf(r6);
            r11.put(r10, r0);
            r10 = "DownloadManager";
            r0 = new java.lang.StringBuilder;
            r2 = "prepareSavePath dir not exist, dir=";
            r0.<init>(r2);
            r1 = r1.getAbsolutePath();
            r0.append(r1);
            r0 = r0.toString();
            com.xunlei.download.proguard.an.b(r10, r0);
            return r11;
        L_0x0121:
            r1 = r5.mMultiFileBaseFolder;
            r1 = android.text.TextUtils.isEmpty(r1);
            if (r1 == 0) goto L_0x0135;
        L_0x0129:
            r1 = r5.mSubFileInfo;
            r1 = r1[r4];
            r1 = r1.mFileName;
            r1 = r9.c(r1);
            r5.mMultiFileBaseFolder = r1;
        L_0x0135:
            r1 = r5.mMultiFileBaseFolder;
            r1 = r9.b(r1);
            r5.mMultiFileBaseFolder = r1;
            r1 = new java.io.File;
            r2 = r5.mMultiFileBaseFolder;
            r1.<init>(r10, r2);
            r2 = 1;
        L_0x0145:
            r3 = r1.exists();
            if (r3 == 0) goto L_0x016a;
        L_0x014b:
            r1 = new java.io.File;
            r3 = new java.lang.StringBuilder;
            r3.<init>();
            r4 = r5.mMultiFileBaseFolder;
            r3.append(r4);
            r4 = "-";
            r3.append(r4);
            r4 = r2 + 1;
            r3.append(r2);
            r2 = r3.toString();
            r1.<init>(r10, r2);
            r2 = r4;
            goto L_0x0145;
        L_0x016a:
            r10 = r1.mkdirs();
            if (r10 != 0) goto L_0x0198;
        L_0x0170:
            r10 = "errorMsg";
            r0 = "create dir failed2";
            r11.put(r10, r0);
            r10 = "status";
            r0 = java.lang.Integer.valueOf(r6);
            r11.put(r10, r0);
            r10 = "DownloadManager";
            r0 = new java.lang.StringBuilder;
            r2 = "prepareSavePath create dir failed2, dir=";
            r0.<init>(r2);
            r1 = r1.getAbsolutePath();
            r0.append(r1);
            r0 = r0.toString();
            com.xunlei.download.proguard.an.b(r10, r0);
            return r11;
        L_0x0198:
            r3 = r1.getAbsolutePath();
            r10 = "_data";
            r11.put(r10, r3);
            r10 = "title";
            r1 = r1.getName();
            r11.put(r10, r1);
            goto L_0x01d4;
        L_0x01ab:
            r10 = move-exception;
            r0 = "errorMsg";
            r1 = "path not exist,StopRequestException";
            r11.put(r0, r1);
            r0 = "status";
            r1 = java.lang.Integer.valueOf(r6);
            r11.put(r0, r1);
            r10.printStackTrace();
            com.xunlei.download.proguard.an.a(r10);
            return r11;
        L_0x01c3:
            r10 = "errorMsg";
            r0 = "path not exist";
            r11.put(r10, r0);
            r10 = "status";
            r0 = java.lang.Integer.valueOf(r6);
            r11.put(r10, r0);
            return r11;
        L_0x01d4:
            r10 = new java.io.File;
            r1 = r5.mInfoHash;
            r1 = com.xunlei.download.proguard.ab.a(r3, r1);
            r10.<init>(r1);
            r1 = r10.exists();
            if (r1 != 0) goto L_0x01f5;
        L_0x01e5:
            r1 = new java.io.File;
            r0 = android.net.Uri.parse(r0);
            r0 = r0.getPath();
            r1.<init>(r0);
            r9.a(r1, r10);
        L_0x01f5:
            return r11;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.ExtendEntryTask.b.a(android.content.Context, android.content.ContentValues):android.content.ContentValues");
        }

        public void a(Context context, long j, String str, String str2, String str3) {
            this.c = new TorrentInfo();
            str3 = XLDownloadManager.getInstance(this.l).getTorrentInfo(str3, this.c);
            if (str3 != 9000) {
                this.c = null;
                j = new StringBuilder("prepareTask,getTorrentInfo ret=");
                j.append(str3);
                an.b("XlDownloadTask2", j.toString());
                return;
            }
            a(context, j, str, str2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.content.Context r25, long r26, java.lang.String r28, java.lang.String r29) {
            /*
            r24 = this;
            r1 = r24;
            r2 = r26;
            r4 = r28;
            r5 = "DownloadManager";
            r6 = new java.lang.StringBuilder;
            r7 = "prepareTask id=";
            r6.<init>(r7);
            r6.append(r2);
            r6 = r6.toString();
            com.xunlei.download.proguard.an.b(r5, r6);
            r5 = r1.c;
            if (r5 != 0) goto L_0x001e;
        L_0x001d:
            return;
        L_0x001e:
            r6 = com.android.providers.downloads.ExtendEntryTask.b;
            monitor-enter(r6);
            r7 = "DownloadManager";
            r8 = "prepareTask mPreparedBtSubTask begin";
            com.xunlei.download.proguard.an.b(r7, r8);	 Catch:{ all -> 0x023d }
            r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x023d }
            r7.<init>();	 Catch:{ all -> 0x023d }
            r8 = new com.xunlei.downloadlib.parameter.BtIndexSet;	 Catch:{ all -> 0x023d }
            r8.<init>();	 Catch:{ all -> 0x023d }
            r9 = r5.mFileCount;	 Catch:{ all -> 0x023d }
            r9 = new int[r9];	 Catch:{ all -> 0x023d }
            r8.mIndexSet = r9;	 Catch:{ all -> 0x023d }
            r9 = 0;
            r10 = r9;
        L_0x003c:
            r11 = r8.mIndexSet;	 Catch:{ all -> 0x023d }
            r11 = r11.length;	 Catch:{ all -> 0x023d }
            if (r10 >= r11) goto L_0x005a;
        L_0x0041:
            r11 = r8.mIndexSet;	 Catch:{ all -> 0x023d }
            r12 = r5.mSubFileInfo;	 Catch:{ all -> 0x023d }
            r12 = r12[r10];	 Catch:{ all -> 0x023d }
            r12 = r12.mFileIndex;	 Catch:{ all -> 0x023d }
            r11[r10] = r12;	 Catch:{ all -> 0x023d }
            r11 = r8.mIndexSet;	 Catch:{ all -> 0x023d }
            r11 = r11[r10];	 Catch:{ all -> 0x023d }
            r7.append(r11);	 Catch:{ all -> 0x023d }
            r11 = ";";
            r7.append(r11);	 Catch:{ all -> 0x023d }
            r10 = r10 + 1;
            goto L_0x003c;
        L_0x005a:
            r7 = com.xunlei.download.DownloadManager.getInstanceFor(r25);	 Catch:{ all -> 0x023d }
            r7 = r7.getDownloadUri(r2);	 Catch:{ all -> 0x023d }
            r15 = 0;
            if (r4 == 0) goto L_0x01d5;
        L_0x0065:
            r10 = r28.length();	 Catch:{ all -> 0x023d }
            if (r10 > 0) goto L_0x006d;
        L_0x006b:
            goto L_0x01d5;
        L_0x006d:
            r14 = 1;
            r12 = new java.lang.String[r14];	 Catch:{ all -> 0x023d }
            r10 = "status";
            r12[r9] = r10;	 Catch:{ all -> 0x023d }
            r10 = r25.getContentResolver();	 Catch:{ Exception -> 0x01c0, all -> 0x01bc }
            r13 = 0;
            r16 = 0;
            r17 = 0;
            r11 = r7;
            r9 = r14;
            r14 = r16;
            r15 = r17;
            r15 = r10.query(r11, r12, r13, r14, r15);	 Catch:{ Exception -> 0x01c0, all -> 0x01bc }
            r10 = r15.moveToFirst();	 Catch:{ Exception -> 0x01b9 }
            if (r10 != 0) goto L_0x009b;
        L_0x008d:
            r2 = "DownloadManager";
            r3 = "prepareTask task not exist";
            com.xunlei.download.proguard.an.d(r2, r3);	 Catch:{ Exception -> 0x01b9 }
            if (r15 == 0) goto L_0x0099;
        L_0x0096:
            r15.close();	 Catch:{ all -> 0x023d }
        L_0x0099:
            monitor-exit(r6);	 Catch:{ all -> 0x023d }
            return;
        L_0x009b:
            r10 = "status";
            r10 = r15.getColumnIndex(r10);	 Catch:{ Exception -> 0x01b9 }
            r10 = r15.getInt(r10);	 Catch:{ Exception -> 0x01b9 }
            if (r15 == 0) goto L_0x00ab;
        L_0x00a7:
            r15.close();	 Catch:{ all -> 0x023d }
            r15 = 0;
        L_0x00ab:
            r11 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r11 != r10) goto L_0x011d;
        L_0x00af:
            r10 = new java.lang.String[r9];	 Catch:{ all -> 0x023d }
            r11 = "bt_sub_index";
            r12 = 0;
            r10[r12] = r11;	 Catch:{ all -> 0x023d }
            r18 = r25.getContentResolver();	 Catch:{ Exception -> 0x010b }
            r19 = com.android.providers.downloads.DownloadProvider.c;	 Catch:{ Exception -> 0x010b }
            r21 = "bt_parent_id=?";
            r9 = new java.lang.String[r9];	 Catch:{ Exception -> 0x010b }
            r11 = java.lang.String.valueOf(r26);	 Catch:{ Exception -> 0x010b }
            r12 = 0;
            r9[r12] = r11;	 Catch:{ Exception -> 0x010b }
            r23 = 0;
            r20 = r10;
            r22 = r9;
            r9 = r18.query(r19, r20, r21, r22, r23);	 Catch:{ Exception -> 0x010b }
            r15 = new java.util.HashSet;	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
            r15.<init>();	 Catch:{ Exception -> 0x0102, all -> 0x00ff }
            r9.moveToFirst();	 Catch:{ Exception -> 0x00fb, all -> 0x00ff }
        L_0x00d9:
            r10 = r9.isAfterLast();	 Catch:{ Exception -> 0x00fb, all -> 0x00ff }
            if (r10 != 0) goto L_0x00f4;
        L_0x00df:
            r10 = "bt_sub_index";
            r10 = r9.getColumnIndex(r10);	 Catch:{ Exception -> 0x00fb, all -> 0x00ff }
            r10 = r9.getInt(r10);	 Catch:{ Exception -> 0x00fb, all -> 0x00ff }
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x00fb, all -> 0x00ff }
            r15.add(r10);	 Catch:{ Exception -> 0x00fb, all -> 0x00ff }
            r9.moveToNext();	 Catch:{ Exception -> 0x00fb, all -> 0x00ff }
            goto L_0x00d9;
        L_0x00f4:
            if (r9 == 0) goto L_0x00f9;
        L_0x00f6:
            r9.close();	 Catch:{ all -> 0x023d }
        L_0x00f9:
            r10 = r15;
            goto L_0x011e;
        L_0x00fb:
            r0 = move-exception;
            r10 = r15;
            r15 = r9;
            goto L_0x0105;
        L_0x00ff:
            r0 = move-exception;
            r2 = r0;
            goto L_0x0117;
        L_0x0102:
            r0 = move-exception;
            r15 = r9;
            r10 = 0;
        L_0x0105:
            r9 = r0;
            goto L_0x010e;
        L_0x0107:
            r0 = move-exception;
            r2 = r0;
            r9 = r15;
            goto L_0x0117;
        L_0x010b:
            r0 = move-exception;
            r9 = r0;
            r10 = 0;
        L_0x010e:
            r9.printStackTrace();	 Catch:{ all -> 0x0107 }
            if (r15 == 0) goto L_0x011e;
        L_0x0113:
            r15.close();	 Catch:{ all -> 0x023d }
            goto L_0x011e;
        L_0x0117:
            if (r9 == 0) goto L_0x011c;
        L_0x0119:
            r9.close();	 Catch:{ all -> 0x023d }
        L_0x011c:
            throw r2;	 Catch:{ all -> 0x023d }
        L_0x011d:
            r10 = 0;
        L_0x011e:
            r9 = ";";
            r4 = r4.split(r9);	 Catch:{ all -> 0x023d }
            if (r4 == 0) goto L_0x01b6;
        L_0x0126:
            r9 = new java.util.ArrayList;	 Catch:{ all -> 0x023d }
            r9.<init>();	 Catch:{ all -> 0x023d }
            r11 = 0;
        L_0x012c:
            r12 = r4.length;	 Catch:{ all -> 0x023d }
            if (r11 >= r12) goto L_0x014b;
        L_0x012f:
            r12 = r4[r11];	 Catch:{ all -> 0x023d }
            r12 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x023d }
            r12 = r12.intValue();	 Catch:{ all -> 0x023d }
            if (r12 < 0) goto L_0x0148;
        L_0x013b:
            r13 = r5.mFileCount;	 Catch:{ all -> 0x023d }
            if (r12 >= r13) goto L_0x0148;
        L_0x013f:
            r12 = r4[r11];	 Catch:{ all -> 0x023d }
            r12 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x023d }
            r9.add(r12);	 Catch:{ all -> 0x023d }
        L_0x0148:
            r11 = r11 + 1;
            goto L_0x012c;
        L_0x014b:
            r4 = "";
            r11 = r9.size();	 Catch:{ all -> 0x023d }
            r11 = new int[r11];	 Catch:{ all -> 0x023d }
            r8.mIndexSet = r11;	 Catch:{ all -> 0x023d }
            r11 = r4;
            r4 = 0;
        L_0x0157:
            r12 = r9.size();	 Catch:{ all -> 0x023d }
            if (r4 >= r12) goto L_0x0186;
        L_0x015d:
            r12 = r8.mIndexSet;	 Catch:{ all -> 0x023d }
            r13 = r9.get(r4);	 Catch:{ all -> 0x023d }
            r13 = (java.lang.Integer) r13;	 Catch:{ all -> 0x023d }
            r13 = r13.intValue();	 Catch:{ all -> 0x023d }
            r12[r4] = r13;	 Catch:{ all -> 0x023d }
            r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x023d }
            r12.<init>();	 Catch:{ all -> 0x023d }
            r12.append(r11);	 Catch:{ all -> 0x023d }
            r11 = r9.get(r4);	 Catch:{ all -> 0x023d }
            r12.append(r11);	 Catch:{ all -> 0x023d }
            r11 = ";";
            r12.append(r11);	 Catch:{ all -> 0x023d }
            r11 = r12.toString();	 Catch:{ all -> 0x023d }
            r4 = r4 + 1;
            goto L_0x0157;
        L_0x0186:
            r4 = new java.util.ArrayList;	 Catch:{ all -> 0x023d }
            r4.<init>();	 Catch:{ all -> 0x023d }
            if (r10 == 0) goto L_0x01b3;
        L_0x018d:
            r10 = r10.iterator();	 Catch:{ all -> 0x023d }
        L_0x0191:
            r11 = r10.hasNext();	 Catch:{ all -> 0x023d }
            if (r11 == 0) goto L_0x01b3;
        L_0x0197:
            r11 = r10.next();	 Catch:{ all -> 0x023d }
            r11 = (java.lang.Integer) r11;	 Catch:{ all -> 0x023d }
            r11 = r11.intValue();	 Catch:{ all -> 0x023d }
            r12 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x023d }
            r12 = r9.contains(r12);	 Catch:{ all -> 0x023d }
            if (r12 != 0) goto L_0x0191;
        L_0x01ab:
            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x023d }
            r4.add(r11);	 Catch:{ all -> 0x023d }
            goto L_0x0191;
        L_0x01b3:
            r1.a(r4, r2);	 Catch:{ all -> 0x023d }
        L_0x01b6:
            r4 = r8.mIndexSet;	 Catch:{ all -> 0x023d }
            goto L_0x01d7;
        L_0x01b9:
            r0 = move-exception;
            r2 = r0;
            goto L_0x01c3;
        L_0x01bc:
            r0 = move-exception;
            r2 = r0;
            r15 = 0;
            goto L_0x01cf;
        L_0x01c0:
            r0 = move-exception;
            r2 = r0;
            r15 = 0;
        L_0x01c3:
            r2.printStackTrace();	 Catch:{ all -> 0x01cd }
            if (r15 == 0) goto L_0x01cb;
        L_0x01c8:
            r15.close();	 Catch:{ all -> 0x023d }
        L_0x01cb:
            monitor-exit(r6);	 Catch:{ all -> 0x023d }
            return;
        L_0x01cd:
            r0 = move-exception;
            r2 = r0;
        L_0x01cf:
            if (r15 == 0) goto L_0x01d4;
        L_0x01d1:
            r15.close();	 Catch:{ all -> 0x023d }
        L_0x01d4:
            throw r2;	 Catch:{ all -> 0x023d }
        L_0x01d5:
            r4 = r8.mIndexSet;	 Catch:{ all -> 0x023d }
        L_0x01d7:
            r8 = r1.a(r2);	 Catch:{ all -> 0x023d }
            r9 = new com.xunlei.downloadlib.parameter.BtIndexSet;	 Catch:{ all -> 0x023d }
            r9.<init>();	 Catch:{ all -> 0x023d }
            r9.mIndexSet = r4;	 Catch:{ all -> 0x023d }
            r8 = r1.b(r9, r8);	 Catch:{ all -> 0x023d }
            r9 = r29;
            r1.a(r8, r2, r9);	 Catch:{ all -> 0x023d }
            r2 = 0;
            r8 = r4.length;	 Catch:{ all -> 0x023d }
            r9 = r2;
            r2 = 0;
        L_0x01f0:
            if (r2 >= r8) goto L_0x0200;
        L_0x01f2:
            r3 = r4[r2];	 Catch:{ all -> 0x023d }
            r11 = r5.mSubFileInfo;	 Catch:{ all -> 0x023d }
            r3 = r11[r3];	 Catch:{ all -> 0x023d }
            r11 = r3.mFileSize;	 Catch:{ all -> 0x023d }
            r13 = r9 + r11;
            r2 = r2 + 1;
            r9 = r13;
            goto L_0x01f0;
        L_0x0200:
            r2 = new android.content.ContentValues;	 Catch:{ all -> 0x023d }
            r2.<init>();	 Catch:{ all -> 0x023d }
            r3 = "control";
            r4 = 0;
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x023d }
            r2.put(r3, r4);	 Catch:{ all -> 0x023d }
            r3 = "status";
            r4 = 190; // 0xbe float:2.66E-43 double:9.4E-322;
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x023d }
            r2.put(r3, r4);	 Catch:{ all -> 0x023d }
            r3 = "total_bytes";
            r4 = java.lang.Long.valueOf(r9);	 Catch:{ all -> 0x023d }
            r2.put(r3, r4);	 Catch:{ all -> 0x023d }
            r3 = r25.getContentResolver();	 Catch:{ Exception -> 0x022c }
            r4 = 0;
            r3.update(r7, r2, r4, r4);	 Catch:{ Exception -> 0x022c }
            goto L_0x0234;
        L_0x022c:
            r0 = move-exception;
            r2 = r0;
            r2.printStackTrace();	 Catch:{ all -> 0x023d }
            com.xunlei.download.proguard.an.a(r2);	 Catch:{ all -> 0x023d }
        L_0x0234:
            r2 = "DownloadManager";
            r3 = "prepareTask mPreparedBtSubTask end";
            com.xunlei.download.proguard.an.b(r2, r3);	 Catch:{ all -> 0x023d }
            monitor-exit(r6);	 Catch:{ all -> 0x023d }
            return;
        L_0x023d:
            r0 = move-exception;
            r2 = r0;
            monitor-exit(r6);	 Catch:{ all -> 0x023d }
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.ExtendEntryTask.b.a(android.content.Context, long, java.lang.String, java.lang.String):void");
        }

        private String b(String str) {
            if (str.length() > 80) {
                str = str.substring(0, 80).trim();
            }
            return TextUtils.isEmpty(str) ? "BT" : str;
        }

        private String c(String str) {
            int lastIndexOf = str.lastIndexOf(46);
            return lastIndexOf > 0 ? str.substring(0, lastIndexOf) : str;
        }
    }

    static class c extends z {
        private static final String a = "DownloadManager.XlTaskGroup";
        private static final HashMap<Integer, Integer> w;
        private long b = null;
        private DownloadManager c = DownloadManager.getInstanceFor(this.l);
        private boolean d = false;
        private boolean e = false;
        private ContentResolver v;

        static final class a {
            private static String[] a = new String[]{Impl.COLUMN_CURRENT_BYTES, "total_bytes", "vip_receive_size", "lx_receive_size", "p2p_receive_size", "p2s_receive_size", "origin_receive_size", "origin_speed", "download_speed", "p2s_speed", "p2p_speed", "addition_vip_speed", "addition_lx_speed", "dcdn_speed", Impl.COLUMN_RES_TOTAL, Impl.COLUMN_RES_USED_TOTAL};

            private a() {
            }

            public static ContentValues a(Cursor cursor) {
                int i;
                ContentValues contentValues = new ContentValues();
                int i2 = 0;
                long[] jArr = new long[a.length];
                int[] iArr = new int[a.length];
                for (i = 0; i < a.length; i++) {
                    iArr[i] = cursor.getColumnIndexOrThrow(a[i]);
                }
                while (cursor.moveToNext()) {
                    for (i = 0; i < a.length; i++) {
                        long j = cursor.getLong(iArr[i]);
                        if (j > 0) {
                            jArr[i] = jArr[i] + j;
                        }
                    }
                }
                while (i2 < jArr.length) {
                    contentValues.put(a[i2], Long.valueOf(jArr[i2]));
                    i2++;
                }
                return contentValues;
            }
        }

        public c(Context context, r rVar, d dVar, q qVar, e eVar) {
            super(context, rVar, dVar, qVar, eVar);
            this.v = context.getContentResolver();
        }

        public void run() {
            Throwable e;
            int finalStatus;
            ContentValues contentValues;
            this.t = this.i.X;
            this.u = SystemClock.elapsedRealtime();
            this.b = 0;
            int i = 192;
            try {
                e();
                r();
                k();
                boolean z = true;
                while (true) {
                    j();
                    p();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (elapsedRealtime - this.b > 500) {
                        this.b = elapsedRealtime;
                        o();
                        if (this.e || this.d) {
                            s();
                        }
                        z = c();
                        i = this.j.d;
                    }
                    if (z) {
                        Thread.sleep(100);
                    } else {
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("status", Integer.valueOf(i));
                        contentValues2.put("errorMsg", null);
                        contentValues2.put("p2s_speed", Integer.valueOf(0));
                        contentValues2.put("p2p_speed", Integer.valueOf(0));
                        contentValues2.put("origin_speed", Integer.valueOf(0));
                        contentValues2.put("download_speed", Integer.valueOf(0));
                        contentValues2.put("addition_vip_speed", Integer.valueOf(0));
                        contentValues2.put("addition_lx_speed", Integer.valueOf(0));
                        contentValues2.put("dcdn_speed", Integer.valueOf(0));
                        contentValues2.put(Impl.COLUMN_RES_TOTAL, Integer.valueOf(0));
                        contentValues2.put(Impl.COLUMN_RES_USED_TOTAL, Integer.valueOf(0));
                        a(contentValues2, null, null);
                        return;
                    }
                }
            } catch (Throwable e2) {
                e2.printStackTrace();
                an.a(e2);
                finalStatus = e2.getFinalStatus();
                String message = e2.getMessage();
                ContentValues contentValues3 = new ContentValues();
                contentValues3.put("status", Integer.valueOf(finalStatus));
                contentValues3.put("errorMsg", message);
                contentValues3.put("p2s_speed", Integer.valueOf(0));
                contentValues3.put("p2p_speed", Integer.valueOf(0));
                contentValues3.put("origin_speed", Integer.valueOf(0));
                contentValues3.put("download_speed", Integer.valueOf(0));
                contentValues3.put("addition_vip_speed", Integer.valueOf(0));
                contentValues3.put("addition_lx_speed", Integer.valueOf(0));
                contentValues3.put("dcdn_speed", Integer.valueOf(0));
                contentValues3.put(Impl.COLUMN_RES_TOTAL, Integer.valueOf(0));
                contentValues3.put(Impl.COLUMN_RES_USED_TOTAL, Integer.valueOf(0));
                a(contentValues3, null, null);
            } catch (Throwable e3) {
                e3.printStackTrace();
                an.a(e3);
                String message2 = e3.getMessage();
                contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(491));
                contentValues.put("errorMsg", message2);
                contentValues.put("p2s_speed", Integer.valueOf(0));
                contentValues.put("p2p_speed", Integer.valueOf(0));
                contentValues.put("origin_speed", Integer.valueOf(0));
                contentValues.put("download_speed", Integer.valueOf(0));
                contentValues.put("addition_vip_speed", Integer.valueOf(0));
                contentValues.put("addition_lx_speed", Integer.valueOf(0));
                contentValues.put("dcdn_speed", Integer.valueOf(0));
                contentValues.put(Impl.COLUMN_RES_TOTAL, Integer.valueOf(0));
                contentValues.put(Impl.COLUMN_RES_USED_TOTAL, Integer.valueOf(0));
                a(contentValues, null, null);
            } catch (Throwable th) {
                e2 = th;
                i = finalStatus;
                contentValues = new ContentValues();
                contentValues.put("status", Integer.valueOf(i));
                contentValues.put("errorMsg", null);
                contentValues.put("p2s_speed", Integer.valueOf(0));
                contentValues.put("p2p_speed", Integer.valueOf(0));
                contentValues.put("origin_speed", Integer.valueOf(0));
                contentValues.put("download_speed", Integer.valueOf(0));
                contentValues.put("addition_vip_speed", Integer.valueOf(0));
                contentValues.put("addition_lx_speed", Integer.valueOf(0));
                contentValues.put("dcdn_speed", Integer.valueOf(0));
                contentValues.put(Impl.COLUMN_RES_TOTAL, Integer.valueOf(0));
                contentValues.put(Impl.COLUMN_RES_USED_TOTAL, Integer.valueOf(0));
                a(contentValues, null, null);
                throw e2;
            }
        }

        static {
            HashMap hashMap = new HashMap();
            w = hashMap;
            hashMap.put(Integer.valueOf(192), Integer.valueOf(0));
            w.put(Integer.valueOf(190), Integer.valueOf(1));
            w.put(Integer.valueOf(194), Integer.valueOf(2));
            w.put(Integer.valueOf(196), Integer.valueOf(3));
            w.put(Integer.valueOf(195), Integer.valueOf(4));
            w.put(Integer.valueOf(193), Integer.valueOf(5));
            w.put(Integer.valueOf(491), Integer.valueOf(6));
            w.put(Integer.valueOf(200), Integer.valueOf(7));
        }

        public boolean c() {
            Cursor query;
            Throwable e;
            Throwable th;
            boolean z = false;
            try {
                query = this.l.getContentResolver().query(q(), null, null, null, null);
                try {
                    ContentValues a = a.a(query);
                    this.j.g = a.getAsLong("total_bytes").longValue();
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("status");
                    query.moveToFirst();
                    int i = 200;
                    do {
                        int i2 = query.getInt(columnIndexOrThrow);
                        if (w.get(Integer.valueOf(i2)) == null) {
                            i2 = 491;
                        }
                        if (((Integer) w.get(Integer.valueOf(i2))).intValue() < ((Integer) w.get(Integer.valueOf(i))).intValue()) {
                            i = i2;
                        }
                    } while (query.moveToNext());
                    columnIndexOrThrow = query.getCount();
                    if (query != null) {
                        query.close();
                    }
                    if (columnIndexOrThrow == 0) {
                        i = 192;
                    }
                    if (i == 190) {
                        i = 192;
                    }
                    a(a, null, null);
                    if (Impl.isStatusCompleted(i)) {
                        this.i.c();
                    }
                    if (this.j.d != i) {
                        this.i.a(i);
                    }
                    this.j.d = i;
                    if (i == 192) {
                        z = true;
                    }
                    return z;
                } catch (Exception e2) {
                    e = e2;
                    try {
                        e.printStackTrace();
                        an.a(e);
                        query.getCount();
                        if (query != null) {
                            query.close();
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        query.getCount();
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
            } catch (Throwable e3) {
                Throwable th3 = e3;
                query = null;
                e = th3;
                e.printStackTrace();
                an.a(e);
                query.getCount();
                if (query != null) {
                    query.close();
                }
                return false;
            } catch (Throwable th4) {
                th = th4;
                query = null;
                query.getCount();
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }

        private void j() throws p {
            synchronized (this.i) {
                if (this.i.k == 1) {
                    l();
                    throw new p(193, "download paused by owner");
                } else if (this.i.k == 10) {
                    m();
                    throw new p(190, "greater than max downloading num");
                } else {
                    if (this.i.l != Impl.STATUS_CANCELED) {
                        if (!this.i.A) {
                        }
                    }
                    n();
                    throw new p((int) Impl.STATUS_CANCELED, "download canceled");
                }
            }
        }

        private void k() {
            DownloadManager downloadManager = this.c;
            boolean z = true;
            if (this.i.I != 1) {
                z = false;
            }
            int resumeDownload = downloadManager.resumeDownload(z, t());
            StringBuilder stringBuilder = new StringBuilder("startSubTasks() count = ");
            stringBuilder.append(resumeDownload);
            a(stringBuilder.toString());
        }

        private void l() {
            int pauseDownload = this.c.pauseDownload(t());
            StringBuilder stringBuilder = new StringBuilder("pauseSubTasks() count = ");
            stringBuilder.append(pauseDownload);
            a(stringBuilder.toString());
        }

        private void m() {
            int suspendDownload = this.c.suspendDownload(t());
            StringBuilder stringBuilder = new StringBuilder("pendSubTasks() count = ");
            stringBuilder.append(suspendDownload);
            a(stringBuilder.toString());
        }

        private void n() {
            int update;
            ContentValues contentValues = new ContentValues();
            if (this.i.A) {
                contentValues.put(Impl.COLUMN_DELETED, Integer.valueOf(1));
            } else {
                contentValues.put("status", Integer.valueOf(Impl.STATUS_CANCELED));
            }
            try {
                update = this.l.getContentResolver().update(q(), contentValues, null, null);
            } catch (Throwable e) {
                e.printStackTrace();
                an.a(e);
                update = 0;
            }
            StringBuilder stringBuilder = new StringBuilder("subtaskOnDelete() count = ");
            stringBuilder.append(update);
            a(stringBuilder.toString());
        }

        private void o() {
            Throwable e;
            r3 = new String[4];
            int i = 0;
            r3[0] = "_id";
            r3[1] = "status";
            r3[2] = "total_bytes";
            r3[3] = Impl.COLUMN_BYPASS_RECOMMENDED_SIZE_LIMIT;
            int maxConcurrentSubDownloads = this.c.getMaxConcurrentSubDownloads();
            HashSet hashSet = new HashSet();
            Cursor cursor = null;
            try {
                Cursor query = this.l.getContentResolver().query(q(), r3, null, null, null);
                try {
                    long j;
                    int i2;
                    int columnIndexOrThrow = query.getColumnIndexOrThrow("_id");
                    int columnIndexOrThrow2 = query.getColumnIndexOrThrow("status");
                    HashSet hashSet2 = new HashSet();
                    while (query.moveToNext()) {
                        j = query.getLong(columnIndexOrThrow);
                        i2 = query.getInt(columnIndexOrThrow2);
                        if (!Impl.isStatusCompleted(i2) && (i2 == 190 || i2 == 192)) {
                            hashSet2.add(Long.valueOf(j));
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("updateSelect() okSet = ");
                    stringBuilder.append(hashSet2.toString());
                    a(stringBuilder.toString());
                    Iterator it = this.i.N.iterator();
                    while (it.hasNext()) {
                        j = ((Long) it.next()).longValue();
                        if (hashSet2.contains(Long.valueOf(j))) {
                            hashSet.add(Long.valueOf(j));
                        }
                    }
                    if (hashSet.size() > maxConcurrentSubDownloads) {
                        hashSet2 = new HashSet();
                        it = hashSet.iterator();
                        while (it.hasNext()) {
                            hashSet2.add(Long.valueOf(((Long) it.next()).longValue()));
                            if (hashSet2.size() >= maxConcurrentSubDownloads) {
                                break;
                            }
                        }
                    }
                    if (hashSet.size() < maxConcurrentSubDownloads) {
                        it = hashSet2.iterator();
                        while (it.hasNext()) {
                            j = ((Long) it.next()).longValue();
                            if (!hashSet.contains(Long.valueOf(j)) && hashSet2.contains(Long.valueOf(j))) {
                                hashSet.add(Long.valueOf(j));
                            }
                            if (hashSet.size() >= maxConcurrentSubDownloads) {
                                break;
                            }
                        }
                    }
                    hashSet2 = hashSet;
                    if (query.moveToFirst()) {
                        List<Long> arrayList = new ArrayList();
                        do {
                            j = query.getLong(columnIndexOrThrow);
                            i2 = query.getInt(columnIndexOrThrow2);
                            if (!this.i.b(j) && i2 == 192) {
                                arrayList.add(Long.valueOf(j));
                            }
                        } while (query.moveToNext());
                        if (arrayList.size() > 0) {
                            long[] jArr = new long[arrayList.size()];
                            for (Long longValue : arrayList) {
                                jArr[i] = longValue.longValue();
                                i++;
                            }
                            this.c.suspendDownload(jArr);
                        }
                        if (query != null) {
                            query.close();
                        }
                        if (!a(hashSet2, this.i.N)) {
                            this.i.N = hashSet2;
                            String a = ai.a(this.i.N);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("bt_select_set", a);
                            a(contentValues, null, null);
                            StringBuilder stringBuilder2 = new StringBuilder("select info changed. ");
                            stringBuilder2.append(a);
                            a(stringBuilder2.toString());
                        }
                        return;
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        an.a(e);
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        e = th;
                        query = cursor;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (query != null) {
                        query.close();
                    }
                    throw e;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                an.a(e);
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        private boolean a(HashSet<Long> hashSet, HashSet<Long> hashSet2) {
            if (hashSet != null) {
                if (hashSet2 != null) {
                    if (hashSet.size() != hashSet2.size()) {
                        return false;
                    }
                    if (hashSet.size() > hashSet2.size()) {
                        hashSet = hashSet.iterator();
                        while (hashSet.hasNext()) {
                            if (!hashSet2.contains(Long.valueOf(((Long) hashSet.next()).longValue()))) {
                                return false;
                            }
                        }
                    }
                    hashSet2 = hashSet2.iterator();
                    while (hashSet2.hasNext()) {
                        if (!hashSet.contains(Long.valueOf(((Long) hashSet2.next()).longValue()))) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            return true;
        }

        private void p() {
            if (this.i.P != this.d || this.i.O != this.e) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_lx_speedup", Boolean.valueOf(this.i.P));
                contentValues.put("is_vip_speedup", Boolean.valueOf(this.i.O));
                try {
                    this.l.getContentResolver().update(q(), contentValues, null, null);
                } catch (Throwable e) {
                    e.printStackTrace();
                    an.a(e);
                }
                this.d = this.i.P;
                this.e = this.i.O;
            }
        }

        private Uri q() {
            return this.c.getTaskGroupUri(this.i.c);
        }

        private void r() throws p {
            if (this.i.G == null) {
                throw new p(491, "mTitle unknown. ");
            }
            File file;
            if (this.j.b == null) {
                if (this.i.i == 4) {
                    file = new File(Uri.parse(this.i.f).getPath());
                } else {
                    file = this.p.a(null, this.i.i, 0);
                }
                File file2 = new File(file, this.i.G);
                this.j.b = file2.getPath();
                ContentValues contentValues = new ContentValues();
                contentValues.put(Impl._DATA, this.j.b);
                a(contentValues, null, null);
            }
            file = new File(this.j.b);
            StringBuilder stringBuilder;
            if (file.exists()) {
                if (file.isFile()) {
                    stringBuilder = new StringBuilder("location is a file. ");
                    stringBuilder.append(file.getPath());
                    throw new p(491, stringBuilder.toString());
                }
            } else if (!file.mkdirs()) {
                stringBuilder = new StringBuilder("create folder failed. ");
                stringBuilder.append(file.getPath());
                throw new p(491, stringBuilder.toString());
            }
        }

        private void s() {
            Throwable e;
            Throwable th;
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            int[] iArr4 = new int[2];
            Cursor query;
            try {
                query = this.l.getContentResolver().query(q(), new String[]{"vip_status", "lx_status", "lx_progress"}, null, null, null);
                try {
                    int count = query.getCount();
                    if (count == 0) {
                        if (query != null) {
                            query.close();
                        }
                        return;
                    }
                    int i;
                    int i2 = 0;
                    while (true) {
                        i = 192;
                        if (!query.moveToNext()) {
                            break;
                        }
                        int i3;
                        if (r1.e) {
                            i3 = query.getInt(0);
                            if (i3 == 190) {
                                iArr[0] = iArr[0] + 1;
                            }
                            if (i3 == 192) {
                                iArr2[0] = iArr2[0] + 1;
                            }
                            if (i3 == 200) {
                                iArr3[0] = iArr3[0] + 1;
                            }
                            if (i3 == 491) {
                                iArr4[0] = iArr4[0] + 1;
                            }
                        }
                        if (r1.d) {
                            int i4;
                            int i5;
                            i3 = query.getInt(1);
                            if (i3 == 190) {
                                iArr[1] = iArr[1] + 1;
                            }
                            if (i3 == 192) {
                                iArr2[1] = iArr2[1] + 1;
                            }
                            if (i3 == 200) {
                                iArr3[1] = iArr3[1] + 1;
                                i4 = 2;
                                i5 = query.getInt(2);
                                if (i5 > i2) {
                                    i2 = i5;
                                }
                            } else {
                                i4 = 2;
                            }
                            if (i3 == 491) {
                                iArr4[1] = iArr4[1] + 1;
                            }
                            i5 = i4;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                    int i6 = iArr3[0] > 0 ? 200 : iArr2[0] > 0 ? 192 : (iArr[0] > 0 || iArr4[0] != count) ? 190 : 491;
                    if (iArr3[1] > 0) {
                        i = 200;
                    } else if (iArr2[1] <= 0) {
                        i = (iArr[1] > 0 || iArr4[1] != count) ? 190 : 491;
                    }
                    ContentValues contentValues = new ContentValues();
                    if (r1.e) {
                        contentValues.put("vip_status", Integer.valueOf(i6));
                    }
                    if (r1.e) {
                        contentValues.put("lx_status", Integer.valueOf(i));
                        if (i2 > 0) {
                            contentValues.put("lx_progress", Integer.valueOf(i2));
                        }
                    }
                    a(contentValues, null, null);
                } catch (Exception e2) {
                    e = e2;
                } catch (Throwable th2) {
                    e = th2;
                }
            } catch (Exception e3) {
                e = e3;
                query = null;
                th = e;
                Cursor cursor = query;
                try {
                    th.printStackTrace();
                    an.a(th);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable e4) {
                    th = e4;
                    query = cursor;
                    if (query != null) {
                        query.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                e4 = th3;
                query = null;
                th = e4;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        }

        private void a(ContentValues contentValues, String str, String[] strArr) {
            if (contentValues != null && contentValues.size() > null) {
                contentValues.put(Impl.COLUMN_LAST_MODIFICATION, Long.valueOf(this.m.a()));
                contentValues.put("download_duration", Long.valueOf((SystemClock.elapsedRealtime() - this.u) + this.t));
                try {
                    this.l.getContentResolver().update(this.i.j(), contentValues, null, null);
                } catch (ContentValues contentValues2) {
                    contentValues2.printStackTrace();
                    an.a(contentValues2);
                }
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private long[] t() {
            /*
            r10 = this;
            r0 = 1;
            r3 = new java.lang.String[r0];
            r0 = "_id";
            r7 = 0;
            r3[r7] = r0;
            r0 = new long[r7];
            r8 = 0;
            r1 = r10.v;	 Catch:{ Exception -> 0x0042 }
            r2 = r10.q();	 Catch:{ Exception -> 0x0042 }
            r4 = 0;
            r5 = 0;
            r6 = 0;
            r1 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ Exception -> 0x0042 }
            r2 = r1.getCount();	 Catch:{ Exception -> 0x0039, all -> 0x0037 }
            r2 = new long[r2];	 Catch:{ Exception -> 0x0039, all -> 0x0037 }
            r0 = r7;
        L_0x001f:
            r3 = r1.moveToNext();	 Catch:{ Exception -> 0x0034, all -> 0x0037 }
            if (r3 == 0) goto L_0x002e;
        L_0x0025:
            r3 = r1.getLong(r7);	 Catch:{ Exception -> 0x0034, all -> 0x0037 }
            r2[r0] = r3;	 Catch:{ Exception -> 0x0034, all -> 0x0037 }
            r0 = r0 + 1;
            goto L_0x001f;
        L_0x002e:
            if (r1 == 0) goto L_0x0050;
        L_0x0030:
            r1.close();
            goto L_0x0050;
        L_0x0034:
            r0 = move-exception;
            r8 = r1;
            goto L_0x0045;
        L_0x0037:
            r0 = move-exception;
            goto L_0x0051;
        L_0x0039:
            r2 = move-exception;
            r8 = r1;
            r9 = r2;
            r2 = r0;
            r0 = r9;
            goto L_0x0045;
        L_0x003f:
            r0 = move-exception;
            r1 = r8;
            goto L_0x0051;
        L_0x0042:
            r1 = move-exception;
            r2 = r0;
            r0 = r1;
        L_0x0045:
            r0.printStackTrace();	 Catch:{ all -> 0x003f }
            com.xunlei.download.proguard.an.a(r0);	 Catch:{ all -> 0x003f }
            if (r8 == 0) goto L_0x0050;
        L_0x004d:
            r8.close();
        L_0x0050:
            return r2;
        L_0x0051:
            if (r1 == 0) goto L_0x0056;
        L_0x0053:
            r1.close();
        L_0x0056:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.providers.downloads.ExtendEntryTask.c.t():long[]");
        }

        protected void a(String str) {
            String str2 = a;
            StringBuilder stringBuilder = new StringBuilder("[");
            stringBuilder.append(this.i.c);
            stringBuilder.append("]");
            stringBuilder.append(str);
            an.b(str2, stringBuilder.toString());
        }
    }

    public void a(Context context) {
    }

    public void b(Context context) {
    }

    public z a(Context context, r rVar, d dVar, q qVar, e eVar) {
        if (dVar == null || dVar.W != TaskType.GROUP) {
            return new b(this, context, rVar, dVar, qVar, eVar);
        }
        return new c(context, rVar, dVar, qVar, eVar);
    }
}
