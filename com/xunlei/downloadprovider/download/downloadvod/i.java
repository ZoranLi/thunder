package com.xunlei.downloadprovider.download.downloadvod;

import android.text.TextUtils;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.player.PlayProgressRanges;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.vodnew.a.a.a;
import java.io.IOException;

/* compiled from: TaskBxbbPlaySource */
public class i extends a {
    private static final String j = "i";
    public TaskInfo a;
    public BTSubTaskInfo b;
    public TaskPlayInfo c;
    public String d = "";
    public PlayProgressRanges e = new PlayProgressRanges();
    public volatile VideoPlayRecord f;
    private a.a k;
    private a l;
    private int m = 0;

    public i(TaskInfo taskInfo, BTSubTaskInfo bTSubTaskInfo, String str) {
        this.d = str;
        if (taskInfo != null) {
            this.a = taskInfo;
            this.b = bTSubTaskInfo;
            a(taskInfo.getTaskId(), bTSubTaskInfo != null ? bTSubTaskInfo.mBTSubIndex : -1);
            com.xunlei.downloadprovider.download.engine.task.a.a.a.a().c(taskInfo.getTaskId());
        }
    }

    public i(TaskPlayInfo taskPlayInfo, String str) {
        this.d = str;
        if (taskPlayInfo != null) {
            this.c = taskPlayInfo;
            this.g = taskPlayInfo.mPlayUrl;
            if (taskPlayInfo.mTaskId >= 0) {
                a(taskPlayInfo.mTaskId, taskPlayInfo.mBtSubIndex);
                com.xunlei.downloadprovider.download.engine.task.a.a.a.a().c(taskPlayInfo.mTaskId);
            }
        }
    }

    private void a(long j, int i) {
        if (j >= 0) {
            n.a();
            TaskInfo f = n.f(j);
            if (f != null) {
                this.a = f;
                if (i >= 0) {
                    n.a();
                    j = n.e(j);
                    if (j != null) {
                        j = j.b(i);
                        if (j != null) {
                            this.b = j;
                        }
                    }
                }
            }
        }
        if (this.a != null) {
            j = this.a;
            BTSubTaskInfo bTSubTaskInfo = this.b;
            i = 0;
            if (j != null) {
                i = new TaskPlayInfo(j.getTaskId(), -1);
                if (bTSubTaskInfo != null) {
                    if (j.getTaskStatus() == 8 || bTSubTaskInfo.mTaskStatus == 8) {
                        i.mIsLocalPlay = true;
                        i.mPlayUrl = bTSubTaskInfo.mLocalFileName;
                    }
                    i.mBtSubIndex = bTSubTaskInfo.mBTSubIndex;
                    i.mTitle = bTSubTaskInfo.mTitle;
                    i.mCID = bTSubTaskInfo.mCID;
                    i.mGCID = bTSubTaskInfo.mGCID;
                    i.mFileSize = bTSubTaskInfo.mFileSize;
                    i.mLocalFileName = bTSubTaskInfo.mLocalFileName;
                } else {
                    if (j.getTaskStatus() == 8) {
                        i.mIsLocalPlay = true;
                        i.mPlayUrl = j.mLocalFileName;
                    }
                    i.mTitle = j.mTitle;
                    i.mCID = j.mCID;
                    i.mGCID = j.mGCID;
                    i.mFileSize = j.mFileSize;
                    i.mLocalFileName = j.mLocalFileName;
                }
                i.mSourceUrl = j.getTaskDownloadUrl();
            }
            if (i != 0) {
                this.c = i;
            }
        }
    }

    public final TaskPlayInfo a() {
        return this.c;
    }

    public final int b() {
        if (this.b == null) {
            return -1;
        }
        return this.b.mBTSubIndex;
    }

    public final String c() {
        String str;
        if (this.c != null && !TextUtils.isEmpty(this.c.mTitle)) {
            str = this.c.mTitle;
        } else if (this.b != null && !TextUtils.isEmpty(this.b.mTitle)) {
            str = this.b.mTitle;
        } else if (this.a != null && !TextUtils.isEmpty(this.a.mTitle)) {
            str = this.a.mTitle;
        } else if (this.g == null || !this.g.contains("/")) {
            str = this.g;
        } else {
            str = this.g.substring(this.g.lastIndexOf("/") + 1);
        }
        return str != null ? str : "";
    }

    public final String d() {
        return this.g;
    }

    public final boolean e() {
        if (this.b != null && k.a(this.b)) {
            return true;
        }
        if (this.a == null || !k.b(this.a)) {
            return false;
        }
        return true;
    }

    public final void f() {
        this.g = null;
        if (this.h != null) {
            try {
                this.h.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.h = null;
            this.i = null;
        }
        if (this.l != null) {
            this.l.a = true;
        }
    }

    public static void a(TaskPlayInfo taskPlayInfo, int i, int i2, VideoPlayRecord videoPlayRecord) {
        if (taskPlayInfo != null && i2 > 0) {
            String str = taskPlayInfo.mLocalFileName;
            if (!TextUtils.isEmpty(str)) {
                StringBuilder stringBuilder = new StringBuilder("savePlayRecord, position: ");
                stringBuilder.append(i);
                stringBuilder.append(" duration : ");
                stringBuilder.append(i2);
                stringBuilder.append(" savePlayUrl: ");
                stringBuilder.append(str);
                if (videoPlayRecord == null) {
                    videoPlayRecord = new VideoPlayRecord();
                }
                videoPlayRecord.d = taskPlayInfo.mTitle;
                videoPlayRecord.l = taskPlayInfo.mSourceUrl;
                videoPlayRecord.e = str;
                taskPlayInfo = (long) i;
                videoPlayRecord.h = taskPlayInfo;
                videoPlayRecord.i = taskPlayInfo;
                videoPlayRecord.g = (long) i2;
                videoPlayRecord.j = System.currentTimeMillis();
                v.a().a(videoPlayRecord, (boolean) 0);
            }
        }
    }

    public final boolean g() {
        return this.c != null && this.c.mIsLocalPlay;
    }

    public final void a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        if (r4 == 0) goto L_0x0018;
    L_0x0002:
        r0 = "/external/video";
        r0 = r4.startsWith(r0);
        if (r0 == 0) goto L_0x0018;
    L_0x000a:
        r0 = new java.lang.StringBuilder;
        r1 = "content://media";
        r0.<init>(r1);
        r0.append(r4);
        r4 = r0.toString();
    L_0x0018:
        if (r4 == 0) goto L_0x005a;
    L_0x001a:
        r0 = "content://";
        r0 = r4.startsWith(r0);
        if (r0 == 0) goto L_0x005a;
    L_0x0022:
        r0 = r3.h;
        if (r0 == 0) goto L_0x0035;
    L_0x0026:
        r0 = r3.h;	 Catch:{ Exception -> 0x002c }
        r0.close();	 Catch:{ Exception -> 0x002c }
        goto L_0x0030;
    L_0x002c:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0030:
        r0 = 0;
        r3.h = r0;
        r3.i = r0;
    L_0x0035:
        r4 = android.net.Uri.parse(r4);	 Catch:{ Exception -> 0x005a }
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();	 Catch:{ Exception -> 0x005a }
        r1 = r0.getPackageName();	 Catch:{ Exception -> 0x005a }
        r2 = 1;	 Catch:{ Exception -> 0x005a }
        r0.grantUriPermission(r1, r4, r2);	 Catch:{ Exception -> 0x005a }
        r0 = r0.getContentResolver();	 Catch:{ Exception -> 0x005a }
        r1 = "r";	 Catch:{ Exception -> 0x005a }
        r4 = r0.openFileDescriptor(r4, r1);	 Catch:{ Exception -> 0x005a }
        r3.h = r4;	 Catch:{ Exception -> 0x005a }
        r4 = r3.h;	 Catch:{ Exception -> 0x005a }
        r4 = r4.getFileDescriptor();	 Catch:{ Exception -> 0x005a }
        r3.i = r4;	 Catch:{ Exception -> 0x005a }
        return;
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.downloadvod.i.a(java.lang.String):void");
    }

    public final void a(a.a aVar) {
        this.k = aVar;
        if (this.c == null) {
            if (this.k != null) {
                this.k.a(this, "1");
            }
            return;
        }
        if (this.c.mTaskId >= 0) {
            a(this.c.mTaskId, this.c.mBtSubIndex);
        }
        if (this.c.mIsLocalPlay != null) {
            new StringBuilder("fetchPlayUrl，本地播放，返回地址： ").append(this.c.mPlayUrl);
            if (this.k != null) {
                this.g = this.c.mPlayUrl;
                a(this.g);
                this.k.a(this, "0");
            }
        } else if (TextUtils.isEmpty(this.g) == null) {
            new StringBuilder("fetchPlayUrl，mPlayUrl不为空，直接返回旧地址： ").append(this.g);
            a(this.g);
            if (this.k != null) {
                this.k.a(this, "0");
            }
        } else if (this.a == null || this.a.getTaskStatus() != 8) {
            if (this.l != null) {
                this.l.a = true;
            }
            this.l = new a(this, (byte) 0);
            this.l.b = this;
            a.getInstance().a(this.l.b, this.l);
        } else {
            new StringBuilder("fetchPlayUrl，任务已经完成，返回地址： ").append(this.c.mPlayUrl);
            this.g = this.c.mPlayUrl;
            a(this.g);
            if (this.k != null) {
                this.k.a(this, "0");
            }
        }
    }

    public final void h() {
        if (this.l != null) {
            this.l.a = true;
            this.l.c();
        }
        this.k = null;
    }

    public final void i() {
        h();
        if (this.h != null) {
            try {
                this.h.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
