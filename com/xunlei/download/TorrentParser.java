package com.xunlei.download;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadlib.parameter.BtIndexSet;
import com.xunlei.downloadlib.parameter.TorrentInfo;
import java.io.File;

public class TorrentParser implements Runnable {
    private static final String a = "TorrentParser";
    private static final int b = 6536;
    private static final int c = 6537;
    private OnTorrentParserListener d;
    private Context e;
    private File f;
    private Thread g;
    private long h;
    private boolean i;
    @SuppressLint({"HandlerLeak"})
    private Handler j = new Handler(this) {
        final /* synthetic */ TorrentParser a;

        {
            this.a = r1;
        }

        public void handleMessage(Message message) {
            if (this.a.d != null) {
                if (message.what == TorrentParser.c) {
                    this.a.d.onTorrentParseCompleted((ParseResult) message.obj);
                } else if (message.what == TorrentParser.b) {
                    this.a.d.onTorrentParseBegin();
                }
            }
        }
    };

    public static class ParseResult {
        public Code code;
        public long mTaskId;
        public BtIndexSet selectedSet;
        public TorrentInfo torrentInfo;

        public enum Code {
            NO_ERROR,
            UNKNOWN_ERROR,
            PARAM_ERROR,
            USER_CANCEL,
            TORRENT_FILE_NOT_EXIST,
            TORRENT_FILE_INVALID,
            DOWNLOADLIB_NOT_INIT
        }

        ParseResult(Code code, TorrentInfo torrentInfo, BtIndexSet btIndexSet) {
            this(code, torrentInfo, btIndexSet, -1);
        }

        ParseResult(Code code, TorrentInfo torrentInfo, BtIndexSet btIndexSet, long j) {
            this.code = code;
            this.torrentInfo = torrentInfo;
            this.selectedSet = btIndexSet;
            this.mTaskId = j;
        }
    }

    public TorrentParser(Context context, OnTorrentParserListener onTorrentParserListener) {
        this.e = context;
        this.d = onTorrentParserListener;
        this.h = -1;
    }

    public void parse(File file) {
        parse(file, -1);
    }

    public void parse(File file, long j) {
        parse(file, j, false);
    }

    public void parse(File file, long j, boolean z) {
        if (this.g != null) {
            this.g.interrupt();
            this.g = null;
        }
        this.h = j;
        this.i = z;
        this.f = file;
        this.g = new Thread(this, "TorrentParserThread");
        this.g.start();
        this.j.obtainMessage(6536).sendToTarget();
    }

    public void cancel() {
        if (this.g != null) {
            this.g.interrupt();
            this.g = null;
        }
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r20 = this;
        r1 = r20;
        r2 = r1.f;
        r3 = 6537; // 0x1989 float:9.16E-42 double:3.2297E-320;
        r4 = 0;
        r5 = 0;
        if (r2 == 0) goto L_0x01eb;
    L_0x000a:
        r2 = r1.e;
        if (r2 == 0) goto L_0x01eb;
    L_0x000e:
        r2 = r1.d;
        if (r2 != 0) goto L_0x0014;
    L_0x0012:
        goto L_0x01eb;
    L_0x0014:
        r2 = r1.f;
        r2 = r2.isFile();
        if (r2 != 0) goto L_0x002d;
    L_0x001c:
        r2 = r1.j;
        r6 = new com.xunlei.download.TorrentParser$ParseResult;
        r7 = com.xunlei.download.TorrentParser.ParseResult.Code.TORRENT_FILE_NOT_EXIST;
        r6.<init>(r7, r4, r4);
        r2 = r2.obtainMessage(r3, r5, r5, r6);
        r2.sendToTarget();
        return;
    L_0x002d:
        r2 = r1.e;
        r2 = com.xunlei.download.DownloadManager.getInstanceFor(r2);
        r2 = r2.isDownloadlibSDKInit();
        if (r2 != 0) goto L_0x004a;
    L_0x0039:
        r2 = r1.j;
        r6 = new com.xunlei.download.TorrentParser$ParseResult;
        r7 = com.xunlei.download.TorrentParser.ParseResult.Code.DOWNLOADLIB_NOT_INIT;
        r6.<init>(r7, r4, r4);
        r2 = r2.obtainMessage(r3, r5, r5, r6);
        r2.sendToTarget();
        return;
    L_0x004a:
        r9 = new com.xunlei.downloadlib.parameter.BtIndexSet;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r9.<init>();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r8 = new com.xunlei.downloadlib.parameter.TorrentInfo;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r8.<init>();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = r1.e;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = com.xunlei.downloadlib.XLDownloadManager.getInstance(r2);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6 = r1.f;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6 = r6.getAbsolutePath();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = r2.getTorrentInfo(r6, r8);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6 = 9000; // 0x2328 float:1.2612E-41 double:4.4466E-320;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        if (r2 == r6) goto L_0x00a5;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x0068:
        r6 = 9302; // 0x2456 float:1.3035E-41 double:4.596E-320;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        if (r2 != r6) goto L_0x007d;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x006c:
        r6 = r1.j;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7 = new com.xunlei.download.TorrentParser$ParseResult;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r8 = com.xunlei.download.TorrentParser.ParseResult.Code.TORRENT_FILE_INVALID;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7.<init>(r8, r4, r4);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6 = r6.obtainMessage(r3, r5, r5, r7);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6.sendToTarget();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        goto L_0x008d;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x007d:
        r6 = r1.j;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7 = new com.xunlei.download.TorrentParser$ParseResult;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r8 = com.xunlei.download.TorrentParser.ParseResult.Code.UNKNOWN_ERROR;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7.<init>(r8, r4, r4);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6 = r6.obtainMessage(r3, r5, r5, r7);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6.sendToTarget();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x008d:
        r6 = "TorrentParser";	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7 = new java.lang.StringBuilder;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r8 = "getTorrentInfo ret=";	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7.<init>(r8);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = com.android.providers.downloads.XlTaskHelper.a(r2);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7.append(r2);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = r7.toString();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        com.xunlei.download.proguard.an.b(r6, r2);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        return;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x00a5:
        r2 = r8.mFileCount;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = new int[r2];	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r9.mIndexSet = r2;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = r5;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x00ac:
        r6 = r8.mFileCount;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        if (r2 >= r6) goto L_0x00bd;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x00b0:
        r6 = r9.mIndexSet;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7 = r8.mSubFileInfo;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7 = r7[r2];	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7 = r7.mFileIndex;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6[r2] = r7;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = r2 + 1;
        goto L_0x00ac;
    L_0x00bd:
        r6 = r1.h;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r10 = -1;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1));	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r6 = 1;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        if (r2 == 0) goto L_0x00eb;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
    L_0x00c6:
        r2 = r1.e;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = com.xunlei.download.DownloadManager.getInstanceFor(r2);	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r12 = r1.h;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r15 = r2.getDownloadUri(r12);	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = r1.e;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r14 = r2.getContentResolver();	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = new java.lang.String[r6];	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r6 = "bt_select_set";	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2[r5] = r6;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r17 = "deleted != '1'";	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r18 = 0;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r19 = 0;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r16 = r2;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = r14.query(r15, r16, r17, r18, r19);	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        goto L_0x0129;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
    L_0x00eb:
        r2 = r1.i;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        if (r2 == 0) goto L_0x0128;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
    L_0x00ef:
        r2 = r1.e;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = com.xunlei.download.DownloadManager.getInstanceFor(r2);	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r13 = r2.getDownloadUri();	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r7 = "(etag='";	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2.<init>(r7);	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r7 = r8.mInfoHash;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2.append(r7);	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r7 = "') AND (deleted != '1')";	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2.append(r7);	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r15 = r2.toString();	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = r1.e;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r12 = r2.getContentResolver();	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = 2;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r14 = new java.lang.String[r2];	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = "bt_select_set";	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r14[r5] = r2;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = "_id";	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r14[r6] = r2;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r16 = 0;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r17 = 0;	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        r2 = r12.query(r13, r14, r15, r16, r17);	 Catch:{ Exception -> 0x01b0, all -> 0x01ac }
        goto L_0x0129;
    L_0x0128:
        r2 = r4;
    L_0x0129:
        r6 = r2.moveToFirst();	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        if (r6 == 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x012f:
        r6 = "bt_select_set";	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r6 = r2.getColumnIndex(r6);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r6 = r2.getString(r6);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r12 = r1.h;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r7 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1));	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        if (r7 != 0) goto L_0x014b;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x013f:
        r7 = "_id";	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r7 = r2.getColumnIndex(r7);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r10 = r2.getLong(r7);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r1.h = r10;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x014b:
        if (r6 == 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x014d:
        r7 = r6.length();	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        if (r7 <= 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x0153:
        r7 = ";";	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r6 = r6.split(r7);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        if (r6 == 0) goto L_0x019f;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x015b:
        r7 = new java.util.ArrayList;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r7.<init>();	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r10 = r5;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x0161:
        r11 = r6.length;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        if (r10 >= r11) goto L_0x0180;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x0164:
        r11 = r6[r10];	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r11 = r11.intValue();	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        if (r11 < 0) goto L_0x017d;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x0170:
        r12 = r8.mFileCount;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        if (r11 >= r12) goto L_0x017d;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x0174:
        r11 = r6[r10];	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r11 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r7.add(r11);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x017d:
        r10 = r10 + 1;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        goto L_0x0161;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x0180:
        r6 = r7.size();	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r6 = new int[r6];	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r9.mIndexSet = r6;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r6 = r5;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x0189:
        r10 = r9.mIndexSet;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r10 = r10.length;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        if (r6 >= r10) goto L_0x019f;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
    L_0x018e:
        r10 = r9.mIndexSet;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r11 = r7.get(r6);	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r11 = (java.lang.Integer) r11;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r11 = r11.intValue();	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r10[r6] = r11;	 Catch:{ Exception -> 0x01a8, all -> 0x01a5 }
        r6 = r6 + 1;
        goto L_0x0189;
    L_0x019f:
        if (r2 == 0) goto L_0x01be;
    L_0x01a1:
        r2.close();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        goto L_0x01be;
    L_0x01a5:
        r0 = move-exception;
        r6 = r2;
        goto L_0x01d3;
    L_0x01a8:
        r0 = move-exception;
        r6 = r2;
        r2 = r0;
        goto L_0x01b3;
    L_0x01ac:
        r0 = move-exception;
        r2 = r0;
        r6 = r4;
        goto L_0x01d4;
    L_0x01b0:
        r0 = move-exception;
        r2 = r0;
        r6 = r4;
    L_0x01b3:
        r2.printStackTrace();	 Catch:{ all -> 0x01d2 }
        com.xunlei.download.proguard.an.a(r2);	 Catch:{ all -> 0x01d2 }
        if (r6 == 0) goto L_0x01be;
    L_0x01bb:
        r6.close();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x01be:
        r2 = r1.j;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r12 = new com.xunlei.download.TorrentParser$ParseResult;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r7 = com.xunlei.download.TorrentParser.ParseResult.Code.NO_ERROR;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r10 = r1.h;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6 = r12;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r6.<init>(r7, r8, r9, r10);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2 = r2.obtainMessage(r3, r5, r5, r12);	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        r2.sendToTarget();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
        return;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x01d2:
        r0 = move-exception;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x01d3:
        r2 = r0;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x01d4:
        if (r6 == 0) goto L_0x01d9;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x01d6:
        r6.close();	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x01d9:
        throw r2;	 Catch:{ UnsatisfiedLinkError -> 0x01da }
    L_0x01da:
        r2 = r1.j;
        r6 = new com.xunlei.download.TorrentParser$ParseResult;
        r7 = com.xunlei.download.TorrentParser.ParseResult.Code.DOWNLOADLIB_NOT_INIT;
        r6.<init>(r7, r4, r4);
        r2 = r2.obtainMessage(r3, r5, r5, r6);
        r2.sendToTarget();
        return;
    L_0x01eb:
        r2 = r1.j;
        r6 = new com.xunlei.download.TorrentParser$ParseResult;
        r7 = com.xunlei.download.TorrentParser.ParseResult.Code.PARAM_ERROR;
        r6.<init>(r7, r4, r4);
        r2 = r2.obtainMessage(r3, r5, r5, r6);
        r2.sendToTarget();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.TorrentParser.run():void");
    }
}
