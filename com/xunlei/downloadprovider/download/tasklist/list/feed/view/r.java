package com.xunlei.downloadprovider.download.tasklist.list.feed.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.notification.NotificationADInfo;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.a;
import com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.b;
import com.xunlei.downloadprovider.download.tasklist.list.feed.d.a.c;
import com.xunlei.downloadprovider.download.tasklist.list.feed.d.a.d;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: TouTiaoViewHolder */
public abstract class r extends f implements c {
    protected a a = null;
    protected com.xunlei.downloadprovider.download.tasklist.list.feed.b.f b = null;
    protected TextView c = null;
    protected TaskListFeedBottomView d = null;
    private e e;

    public final int a() {
        return 2;
    }

    public r(View view) {
        super(view);
    }

    protected void b() {
        this.c = (TextView) this.itemView.findViewById(R.id.tv_title);
        this.d = (TaskListFeedBottomView) this.itemView.findViewById(R.id.bottom_view);
    }

    protected final void c() {
        this.itemView.setOnClickListener(new s(this));
    }

    public final void a(com.xunlei.downloadprovider.download.tasklist.list.feed.b.f fVar) {
        this.b = fVar;
    }

    public void fillData(e eVar) {
        super.fillData(eVar);
        if (eVar != null) {
            CharSequence string;
            this.a = (a) eVar.c;
            b bVar = this.a.a;
            this.c.setText(bVar.d);
            if (bVar.o) {
                this.d.getSourceTV().setVisibility(0);
                this.d.getCommentCountTV().setVisibility(8);
                this.d.getAdSourceTagTV().setVisibility(0);
            } else {
                this.d.getSourceTV().setVisibility(0);
                this.d.getCommentCountTV().setVisibility(0);
                this.d.getAdSourceTagTV().setVisibility(8);
            }
            this.d.getTmtpTV().setVisibility(8);
            this.d.getSourceTV().setText(bVar.f);
            long toMillis = TimeUnit.SECONDS.toMillis(bVar.h);
            TextView tmtpTV = this.d.getTmtpTV();
            long abs = Math.abs(toMillis - System.currentTimeMillis());
            if ((abs < TimeUnit.MINUTES.toMillis(1) ? 1 : 0) != 0) {
                string = BrothersApplication.getApplicationInstance().getString(R.string.task_list_feed_date_format_less_one_minute);
            } else {
                if ((abs < TimeUnit.HOURS.toMillis(1) ? 1 : 0) != 0) {
                    string = BrothersApplication.getApplicationInstance().getString(R.string.task_list_feed_date_format_less_one_hour, new Object[]{Long.valueOf(abs / TimeUnit.MINUTES.toMillis(1))});
                } else {
                    if ((abs < TimeUnit.DAYS.toMillis(1) ? 1 : 0) != 0) {
                        string = BrothersApplication.getApplicationInstance().getString(R.string.task_list_feed_date_format_less_one_day, new Object[]{Long.valueOf(abs / TimeUnit.HOURS.toMillis(1))});
                    } else {
                        string = new SimpleDateFormat("MM-dd hh:mm", Locale.CHINA).format(new Date(toMillis));
                    }
                }
            }
            tmtpTV.setText(string);
            if (bVar.o) {
                this.d.getAdSourceTagTV().setText(getContext().getString(R.string.task_list_feed_ad_source_toutiao));
            } else {
                this.d.getCommentCountTV().setText(getContext().getString(R.string.task_list_feed_comment, new Object[]{Long.valueOf(bVar.p)}));
            }
            com.xunlei.downloadprovider.download.tasklist.list.feed.c.a aVar = this.a;
            if (!com.xunlei.downloadprovider.download.tasklist.list.feed.b.a(this.mAdapter.a(), aVar.b())) {
                String str;
                com.xunlei.downloadprovider.download.tasklist.list.feed.b.b(this.mAdapter.a(), aVar.b());
                a aVar2 = (a) aVar;
                if (aVar2.c()) {
                    b bVar2 = aVar2.a;
                    if (bVar2 != null) {
                        bVar2.u = System.currentTimeMillis();
                    }
                    com.xunlei.downloadprovider.download.tasklist.list.feed.b.a("ad_show_report");
                    new com.xunlei.downloadprovider.download.tasklist.list.feed.e.a.b().a(NotificationADInfo.REPORT_STATUS_SHOW, bVar2, new c());
                }
                String str2 = aVar.d() ? "ad" : aVar.e() ? "video" : "news";
                String str3 = str2;
                String b = aVar.b();
                int a = this.mAdapter.a();
                if (aVar2.a != null) {
                    str = aVar2.a.c;
                } else {
                    str = "";
                }
                String str4 = str;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.mAdapter.b(eVar));
                com.xunlei.downloadprovider.download.tasklist.list.feed.b.a(b, a, str3, str4, "toutiao", stringBuilder.toString());
            }
            this.e = eVar;
        }
    }

    protected static void a(Context context, @NonNull b.a aVar, ImageView imageView, d.a.a aVar2) {
        List list = aVar.b;
        if (list == null) {
            list = new ArrayList(1);
        }
        list.add(0, aVar.a);
        d.a(context, list, imageView, aVar2);
    }

    static /* synthetic */ void a(r rVar, com.xunlei.downloadprovider.download.tasklist.list.feed.c.a aVar, e eVar) {
        a aVar2 = (a) aVar;
        b bVar;
        if (aVar2.c()) {
            bVar = aVar2.a;
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a("ad_click_report");
            new com.xunlei.downloadprovider.download.tasklist.list.feed.e.a.b().a(NotificationADInfo.REPORT_STATUS_CLICK, bVar, new d());
        } else {
            bVar = aVar2.a;
            com.xunlei.downloadprovider.download.tasklist.list.feed.b.a("news_click_report");
            com.xunlei.downloadprovider.download.tasklist.list.feed.a.a.a().a(new com.xunlei.downloadprovider.download.tasklist.list.feed.e.a.e(new com.xunlei.downloadprovider.download.tasklist.list.feed.e.a.b(), bVar, new com.xunlei.downloadprovider.download.tasklist.list.feed.d.a.b()));
        }
        String str = aVar.d() ? "ad" : aVar.e() ? "video" : "news";
        String str2 = str;
        String b = aVar.b();
        int a = rVar.mAdapter.a();
        if (aVar2.a != null) {
            aVar = aVar2.a.c;
        } else {
            aVar = "";
        }
        com.xunlei.downloadprovider.download.tasklist.list.feed.c.a aVar3 = aVar;
        aVar = new StringBuilder();
        aVar.append(rVar.mAdapter.b(eVar));
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.b(b, a, str2, aVar3, "toutiao", aVar.toString());
    }
}
