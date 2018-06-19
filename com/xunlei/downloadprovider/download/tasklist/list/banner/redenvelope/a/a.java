package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.download.tasklist.list.banner.p;
import com.xunlei.downloadprovider.download.tasklist.list.banner.q;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.RedPacketConditionsInfo;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.i;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.c;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.xllib.android.b;
import com.xunlei.xllib.b.d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* compiled from: RedEnvelopeBannerPresenter */
public final class a implements p {
    q a = null;
    Handler b = new Handler(Looper.getMainLooper());
    boolean c;
    com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a d = new c(this);
    private i e = new b(this, this.b);
    private c f = new f(this);

    public a(q qVar) {
        this.a = qVar;
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        p pVar = this;
        DownloadTaskInfo downloadTaskInfo2 = downloadTaskInfo;
        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
        if (com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(downloadTaskInfo)) {
            List list;
            Object stringBuilder;
            RedPacketConditionsInfo redPacketConditionsInfo;
            boolean z = downloadTaskInfo.getTaskStatus() == 8;
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a a = com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
            if (a.a == null) {
                a.a = com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.c();
            }
            if (d.a(a.a)) {
                list = null;
            } else {
                list = new ArrayList();
                if (z) {
                    for (RedPacketConditionsInfo redPacketConditionsInfo2 : a.a) {
                        if (redPacketConditionsInfo2.download_type == 1) {
                            list.add(redPacketConditionsInfo2);
                        }
                    }
                } else {
                    for (RedPacketConditionsInfo redPacketConditionsInfo22 : a.a) {
                        if (redPacketConditionsInfo22.download_type == 0) {
                            list.add(redPacketConditionsInfo22);
                        }
                    }
                }
            }
            StringBuilder stringBuilder2;
            if (z) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.d(downloadTaskInfo.getTaskId()));
                stringBuilder = stringBuilder2.toString();
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.e(downloadTaskInfo.getTaskId()));
                stringBuilder = stringBuilder2.toString();
            }
            if (!(downloadTaskInfo2 == null || list == null || list.size() <= 0)) {
                if (!"0".equals(stringBuilder)) {
                    LoginHelper.a();
                    boolean c = l.c();
                    boolean l = LoginHelper.a().l();
                    com.xunlei.downloadprovider.discovery.kuainiao.d a2 = com.xunlei.downloadprovider.discovery.kuainiao.d.a();
                    boolean z2 = a2.b.getBoolean("has_try_accel", false);
                    if (!z2) {
                        z2 = a2.d;
                    }
                    boolean z3 = com.xunlei.downloadprovider.download.c.a.a().j.getBoolean("isFreeTried", false);
                    if (!c) {
                        if (z3) {
                            a.b.add(Integer.valueOf(3));
                        }
                        if (z2) {
                            a.b.add(Integer.valueOf(4));
                        }
                        if (a.d) {
                            a.b.add(Integer.valueOf(6));
                        }
                        a.b.add(Integer.valueOf(5));
                    } else if (l) {
                        a.b.add(Integer.valueOf(1));
                    } else {
                        String o = LoginHelper.a().o();
                        if (!TextUtils.isEmpty(o) && o.length() == 8) {
                            if (Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date())) - Long.parseLong(o) > 0) {
                                a.b.add(Integer.valueOf(2));
                            }
                        }
                        if (z3) {
                            a.b.add(Integer.valueOf(3));
                        }
                        if (z2) {
                            a.b.add(Integer.valueOf(4));
                        }
                        if (a.d) {
                            a.b.add(Integer.valueOf(6));
                        }
                        a.b.add(Integer.valueOf(5));
                    }
                    List list2 = a.b;
                    loop2:
                    for (int i = 0; i < list2.size(); i++) {
                        int i2 = 0;
                        while (i2 < list.size()) {
                            String str = ((RedPacketConditionsInfo) list.get(i2)).user_type;
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(list2.get(i));
                            if (str.equals(stringBuilder3.toString()) && ((RedPacketConditionsInfo) list.get(i2)).task_finish_count.equals(stringBuilder)) {
                                redPacketConditionsInfo = (RedPacketConditionsInfo) list.get(i2);
                                break loop2;
                            }
                            i2++;
                        }
                    }
                }
            }
            redPacketConditionsInfo = null;
            if (redPacketConditionsInfo != null) {
                long parseLong = Long.parseLong(redPacketConditionsInfo.count_down);
                long currentTimeMillis = System.currentTimeMillis();
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                long c2 = com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.c(downloadTaskInfo.getTaskId());
                if (c2 != 0) {
                    pVar.a.a(downloadTaskInfo2, redPacketConditionsInfo, false);
                    if (currentTimeMillis - c2 < 1000 * parseLong) {
                        pVar.a.a(downloadTaskInfo2, currentTimeMillis, c2, parseLong);
                        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(true, downloadTaskInfo.getTaskId(), pVar);
                        return;
                    }
                    b();
                } else if ((downloadTaskInfo2.mDownloadSpeed >= redPacketConditionsInfo.limitSpeed || z) && pVar.a.a() == null && !downloadTaskInfo2.hasRequestRedList) {
                    pVar.a.a(downloadTaskInfo2, redPacketConditionsInfo, true);
                }
            }
        }
    }

    public final void a() {
        this.e.a(true);
    }

    public final com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.bean.a a(long j) {
        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
        return com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.b(j);
    }

    public final void a(RedPacketConditionsInfo redPacketConditionsInfo, DownloadTaskInfo downloadTaskInfo) {
        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
        com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(redPacketConditionsInfo, downloadTaskInfo, this.d);
    }

    public final void b() {
        if (this.e != null) {
            this.e.b();
        }
        if (this.b != null) {
            this.b.removeCallbacksAndMessages(null);
            this.b = null;
        }
        if (this.a != null) {
            DownloadTaskInfo a = this.a.a();
            if (a != null) {
                a.mHasShowRedEnvelopeBanner = false;
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(false, a.getTaskId(), null);
            }
            this.a.a(8);
        }
    }

    public final void a(Context context) {
        if (b.a(context)) {
            if (this.a != null) {
                LoginHelper.a();
                if (l.b()) {
                    com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                    com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(this.a.a());
                    b();
                    this.a.c();
                    return;
                }
                LoginHelper.a().a(context, this.f, LoginFrom.DLCENTER_DETAIL_PACKET, "RedEnvelopeBannerPresenter");
            }
            return;
        }
        XLToast.showToast(context, "无网络，请检查网络设置。");
    }
}
