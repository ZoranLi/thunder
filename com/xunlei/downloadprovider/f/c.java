package com.xunlei.downloadprovider.f;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.d.b.q;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.homepage.cinecism.data.CinecismInfo;
import com.xunlei.downloadprovider.homepage.photoarticle.data.PhotoArticleInfo;
import com.xunlei.downloadprovider.homepage.redpacket.RedPacketShareHeaderView;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.c.a;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.a.h;
import com.xunlei.downloadprovidershare.a.i;
import com.xunlei.downloadprovidershare.b.b;
import com.xunlei.downloadprovidershare.j;

/* compiled from: ShareInfoCreator */
public final class c {
    public static i a(String str, BaseVideoInfo baseVideoInfo) {
        String str2 = str;
        BaseVideoInfo iVar = new i(str2, d.a().n.b(), baseVideoInfo.getCoverUrl(), baseVideoInfo.getTitle(), baseVideoInfo.getVideoId(), String.valueOf(baseVideoInfo.getPublisherId()));
        iVar.b = String.valueOf(LoginHelper.a().g.c());
        return iVar;
    }

    public static com.xunlei.downloadprovidershare.a.c a(String str, TaskInfo taskInfo, CooperationItem cooperationItem, String str2, String str3) {
        int i;
        int i2;
        boolean c;
        String d;
        String e;
        boolean l;
        long j;
        TaskSpeedCountInfo m;
        long j2;
        f cVar;
        CooperationItem cooperationItem2;
        TaskInfo taskInfo2 = taskInfo;
        CooperationItem cooperationItem3 = cooperationItem;
        LoginHelper a = LoginHelper.a();
        String a2 = d.a().n.a();
        String str4 = taskInfo2.mUrl;
        String taskDownloadUrl = taskInfo.getTaskDownloadUrl();
        String str5 = TextUtils.isEmpty(str2) ? taskInfo2.mTitle : str2;
        long j3 = taskInfo2.mFileSize;
        long taskId = taskInfo.getTaskId();
        String str6 = taskInfo2.mAppName;
        String str7 = taskInfo2.mGCID;
        String str8 = taskInfo2.mCID;
        String str9 = taskInfo2.mRefUrl;
        if (taskInfo2.mTaskType == TaskType.BT) {
            i = R.drawable.share_ic_task_file_bt;
        } else if (taskInfo2.mTaskType == TaskType.MAGNET) {
            i = R.drawable.share_ic_task_file_magnet;
        } else if (taskInfo2.mTitle != null) {
            i = j.a(taskInfo2.mTitle.trim());
        } else {
            i2 = 0;
            c = l.c();
            d = a.g.d();
            e = a.e();
            l = a.l();
            j = taskInfo2.mDownloadSpeed;
            n.a();
            m = n.m(taskId);
            if (m != null) {
                j = m.mHighestSpeed;
            }
            j2 = j;
            j = taskInfo2.mDownloadDurationTime;
            cVar = new com.xunlei.downloadprovidershare.a.c(str, a2, i2, str5, taskInfo2.mTitle, j3, taskId, str6, str4, taskDownloadUrl, str8, str7, str9, c, e, l, d, j2, j <= 0 ? (taskInfo2.mDownloadedSize / j) * 1000 : 0, j);
            if (!TextUtils.isEmpty(str3)) {
                cVar.d = str3;
            }
            cooperationItem2 = cooperationItem;
            if (cooperationItem2 != null) {
                cVar.b = new a(new b(cooperationItem.getTitle(), cooperationItem.getAppIconUrl(), ShareOperationType.COOPERATION), cooperationItem2);
            }
            return cVar;
        }
        i2 = i;
        c = l.c();
        d = a.g.d();
        e = a.e();
        l = a.l();
        j = taskInfo2.mDownloadSpeed;
        n.a();
        m = n.m(taskId);
        if (m != null) {
            j = m.mHighestSpeed;
        }
        j2 = j;
        j = taskInfo2.mDownloadDurationTime;
        if (j <= 0) {
        }
        cVar = new com.xunlei.downloadprovidershare.a.c(str, a2, i2, str5, taskInfo2.mTitle, j3, taskId, str6, str4, taskDownloadUrl, str8, str7, str9, c, e, l, d, j2, j <= 0 ? (taskInfo2.mDownloadedSize / j) * 1000 : 0, j);
        if (TextUtils.isEmpty(str3)) {
            cVar.d = str3;
        }
        cooperationItem2 = cooperationItem;
        if (cooperationItem2 != null) {
            cVar.b = new a(new b(cooperationItem.getTitle(), cooperationItem.getAppIconUrl(), ShareOperationType.COOPERATION), cooperationItem2);
        }
        return cVar;
    }

    public static i a(Context context, String str, BaseVideoInfo baseVideoInfo, int i) {
        return a(context, str, baseVideoInfo.getVideoId(), baseVideoInfo.getTitle(), String.valueOf(baseVideoInfo.getPublisherId()), baseVideoInfo.getCoverUrl(), baseVideoInfo.getDuration(), baseVideoInfo.getPlayCount(), i, true);
    }

    public static i a(Context context, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, boolean z) {
        String e;
        i.a aVar;
        LoginHelper a;
        int i4 = i3;
        String c = d.a().l.c();
        f iVar = new i(str, c, str5, str3, str2, str4);
        iVar.f = c;
        LoginHelper.a();
        if (l.c()) {
            iVar.b = String.valueOf(LoginHelper.a().g.c());
        }
        c = "";
        if (i4 == com.xunlei.downloadprovider.d.b.n.c) {
            e = d.a().l.e();
            if (!TextUtils.isEmpty(e)) {
                c = str3;
                iVar.c = e;
                iVar.d = c;
                aVar = new i.a();
                a = LoginHelper.a();
                aVar.a = a.c();
                aVar.b = l.c();
                aVar.f = a.g.d();
                aVar.e = a.e();
                aVar.d = str4;
                aVar.h = e;
                aVar.g = str5;
                aVar.j = i;
                aVar.i = (long) i2;
                aVar.c = str2;
                if (z) {
                    aVar.l = new RedPacketShareHeaderView(context, str);
                }
                aVar.k = "http://api-shoulei-ssl.xunlei.com/ares/api/operation/earn";
                if (i4 != com.xunlei.downloadprovider.d.b.n.b) {
                    aVar.m = true;
                    iVar.l = 2;
                } else {
                    aVar.m = false;
                }
                iVar.m = aVar;
                return iVar;
            }
        }
        e = str3;
        iVar.c = e;
        iVar.d = c;
        aVar = new i.a();
        a = LoginHelper.a();
        aVar.a = a.c();
        aVar.b = l.c();
        aVar.f = a.g.d();
        aVar.e = a.e();
        aVar.d = str4;
        aVar.h = e;
        aVar.g = str5;
        aVar.j = i;
        aVar.i = (long) i2;
        aVar.c = str2;
        if (z) {
            aVar.l = new RedPacketShareHeaderView(context, str);
        }
        aVar.k = "http://api-shoulei-ssl.xunlei.com/ares/api/operation/earn";
        if (i4 != com.xunlei.downloadprovider.d.b.n.b) {
            aVar.m = false;
        } else {
            aVar.m = true;
            iVar.l = 2;
        }
        iVar.m = aVar;
        return iVar;
    }

    public static com.xunlei.downloadprovidershare.a.l a(String str, WebsiteInfo websiteInfo, VideoUserInfo videoUserInfo) {
        return new com.xunlei.downloadprovidershare.a.l(str, d.a().n.c(), websiteInfo.e, websiteInfo.d, websiteInfo.g, websiteInfo.a, String.valueOf(websiteInfo.b), videoUserInfo.getNickname());
    }

    public static h a(String str, PhotoArticleInfo photoArticleInfo) {
        String str2;
        q qVar = d.a().n;
        if (qVar.a == null) {
            str2 = "http://m.sjzhushou.com/h5/page/share-2.0/article/index.html";
        } else {
            str2 = (String) qVar.a.get("photo_article_url");
            if (TextUtils.isEmpty(str2)) {
                str2 = "http://m.sjzhushou.com/h5/page/share-2.0/article/index.html";
            }
        }
        f hVar = new h(str, str2, photoArticleInfo.c, photoArticleInfo.a);
        hVar.h = photoArticleInfo.d;
        return hVar;
    }

    public static com.xunlei.downloadprovidershare.a.b a(String str, CinecismInfo cinecismInfo) {
        q qVar = d.a().n;
        f bVar = new com.xunlei.downloadprovidershare.a.b(str, q.d(), cinecismInfo.b, cinecismInfo.a);
        bVar.h = cinecismInfo.d;
        return bVar;
    }
}
