package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.LocalBroadcastManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.taskdetails.ag;
import com.xunlei.downloadprovider.download.taskdetails.items.views.DetailOperationButtonLayout;
import com.xunlei.downloadprovider.download.taskdetails.items.views.DownloadDetailProgressView;
import com.xunlei.downloadprovider.download.taskdetails.items.views.ZHTextViewExpandable;
import com.xunlei.downloadprovider.download.taskdetails.items.views.ZHTextViewExpandable.a;
import com.xunlei.downloadprovider.download.taskdetails.newui.DownloadDetailsActivity;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;
import com.xunlei.xllib.android.XLIntent;

public class DownloadTaskNameAndIconView_New extends FrameLayout implements a {
    private static final String R = "DownloadTaskNameAndIconView_New";
    public View A;
    public View B;
    public View C;
    TextView D;
    TextView E;
    ImageView F;
    String G;
    Context H;
    com.xunlei.downloadprovider.download.tasklist.list.download.a.a I;
    TextView J;
    DownloadDetailProgressView K;
    DetailOperationButtonLayout L;
    DownloadTaskInfo M;
    TaskSpeedCountInfo N;
    boolean O;
    int P;
    com.xunlei.downloadprovider.download.tasklist.list.download.a.a.a Q = new y(this);
    private View S;
    private View T;
    private View U;
    private View V;
    private View W;
    public ImageView a;
    private boolean aa = true;
    private boolean ab = true;
    private boolean ac = true;
    private com.xunlei.downloadprovider.download.control.a ad;
    private ag ae;
    private OnClickListener af = new v(this);
    private ag.a ag;
    public ZHTextView b;
    public TextView c;
    public View d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public View p;
    public TextView q;
    public TextView r;
    public View s;
    public View t;
    public TextView u;
    public View v;
    public ImageView w;
    public ZHTextViewExpandable x;
    public View y;
    public View z;

    public DownloadTaskNameAndIconView_New(Context context) {
        super(context);
        a(context);
    }

    public DownloadTaskNameAndIconView_New(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public DownloadTaskNameAndIconView_New(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setControl(com.xunlei.downloadprovider.download.control.a aVar) {
        this.ad = aVar;
    }

    void setIconImageViewVisible(boolean z) {
        if (z) {
            this.a.setVisibility(8);
            return;
        }
        this.a.setVisibility(0);
        z = this.a.getLayoutParams();
        if (this.P == 0) {
            z.width = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_width);
            z.height = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_height);
        } else if (this.P == 1) {
            z.width = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style1_width);
            z.height = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style1_height);
            this.a.setImageResource(R.drawable.ic_dl_video_default_style1);
        } else {
            z.width = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style2_width);
            z.height = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style2_height);
            this.a.setImageResource(R.drawable.ic_dl_video_default_style1);
        }
        this.a.setLayoutParams(z);
    }

    private void a(Context context) {
        this.P = b.f();
        this.H = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_task_detail_title_new, this);
        this.T = inflate.findViewById(R.id.name_view_when_hide_all_data);
        this.S = inflate.findViewById(R.id.task_icon_title_layout);
        this.a = (ImageView) inflate.findViewById(R.id.iconImageView);
        context = DownloadDetailsActivity.a(context);
        if (context != null) {
            context = context.a.j;
        } else {
            context = 1;
        }
        setIconImageViewVisible(context);
        this.I = new com.xunlei.downloadprovider.download.tasklist.list.download.a.a(inflate.findViewById(R.id.tagSnapshot));
        this.J = (TextView) inflate.findViewById(R.id.tagSnapshot);
        this.b = (ZHTextView) inflate.findViewById(R.id.titleTextView);
        this.c = (TextView) inflate.findViewById(R.id.tagSize);
        this.f = (TextView) inflate.findViewById(R.id.tagEpisode);
        this.d = inflate.findViewById(R.id.tagPlay);
        this.e = (TextView) inflate.findViewById(R.id.tagPlay);
        this.g = (TextView) inflate.findViewById(R.id.speed);
        this.h = (TextView) inflate.findViewById(R.id.tv_download_progress);
        this.i = (TextView) inflate.findViewById(R.id.download_status_text);
        this.w = (ImageView) inflate.findViewById(R.id.arrow_icon);
        this.x = (ZHTextViewExpandable) inflate.findViewById(R.id.task_url_content);
        this.y = inflate.findViewById(R.id.task_detail_info);
        this.y.setVisibility(8);
        this.b.setMaxLines(2);
        this.z = inflate.findViewById(R.id.container_need_fold);
        this.A = inflate.findViewById(R.id.detail_expand_space_view);
        this.B = inflate.findViewById(R.id.download_size_container);
        this.C = inflate.findViewById(R.id.max_speed_container);
        this.j = (TextView) inflate.findViewById(R.id.download_max_speed_text);
        this.k = (TextView) inflate.findViewById(R.id.download_create_time);
        this.l = (TextView) inflate.findViewById(R.id.download_max_speed);
        this.m = (TextView) inflate.findViewById(R.id.download_aver_speed);
        this.o = (TextView) inflate.findViewById(R.id.download_save_time);
        this.n = (TextView) inflate.findViewById(R.id.download_linked_resource);
        this.p = inflate.findViewById(R.id.linked_resource_container);
        this.q = (TextView) inflate.findViewById(R.id.downloaded_size);
        this.s = inflate.findViewById(R.id.progressContainer);
        this.r = (TextView) inflate.findViewById(R.id.progress);
        this.t = inflate.findViewById(R.id.finish_time_container);
        this.u = (TextView) inflate.findViewById(R.id.finish_time);
        this.v = inflate.findViewById(R.id.source_container);
        this.D = (TextView) inflate.findViewById(R.id.task_ref_url);
        this.E = (TextView) inflate.findViewById(R.id.web_site_name);
        this.U = inflate.findViewById(R.id.web_container);
        this.F = (ImageView) inflate.findViewById(R.id.iv_collection);
        this.V = inflate.findViewById(R.id.tagDivider1);
        this.W = inflate.findViewById(R.id.tagDivider2);
        this.K = (DownloadDetailProgressView) inflate.findViewById(R.id.download_detail_progress_bar);
        this.K.setBackgroundPaintColor(Color.parseColor("#efeff0"));
        this.L = (DetailOperationButtonLayout) inflate.findViewById(R.id.operate_container);
        this.U.setOnClickListener(new r(this));
        this.F.setOnClickListener(new s(this));
        this.w.setOnClickListener(this.af);
        this.b.setOnClickListener(this.af);
        this.A.setVisibility(8);
        this.B.setVisibility(0);
        this.C.setVisibility(0);
        a(true);
    }

    public void setCollaped(boolean z) {
        if (z) {
            f();
        } else {
            c();
        }
    }

    public boolean getIsInCollapedState() {
        return this.ac;
    }

    public void setSelected(boolean z) {
        if (this.F != null) {
            this.F.setSelected(z);
        }
    }

    public void setAdapter(ag agVar) {
        this.ae = agVar;
    }

    private void c() {
        this.ac = false;
        this.y.setVisibility(0);
        d();
        a(false);
    }

    private void d() {
        this.w.setImageResource(R.drawable.detail_speed_arrow_up_new_selector);
        this.b.setMaxLines(100);
    }

    private void e() {
        this.w.setImageResource(R.drawable.detail_speed_arrow_down_new_selector);
        this.b.setMaxLines(2);
    }

    private void f() {
        this.ac = true;
        this.y.setVisibility(8);
        e();
        a(true);
    }

    final void a() {
        if (this.V != null) {
            this.V.setVisibility(8);
        }
        if (this.W != null) {
            this.W.setVisibility(8);
        }
        if (this.f.getVisibility() == 0 && this.c.getVisibility() == 0 && this.V != null) {
            this.V.setVisibility(0);
        }
        if (this.c.getVisibility() == 0 && this.I.a() == 0 && this.W != null) {
            this.W.setVisibility(0);
        }
        if (this.f.getVisibility() == 0 && this.c.getVisibility() == 8 && this.I.a() == 0 && this.V != null) {
            this.V.setVisibility(0);
        }
    }

    public void setTaskSpeedCountInfo(TaskSpeedCountInfo taskSpeedCountInfo) {
        this.N = taskSpeedCountInfo;
        new StringBuilder("taskCountInfo :  ").append(taskSpeedCountInfo);
    }

    @SuppressLint({"DefaultLocale"})
    public static void a(DownloadTaskInfo downloadTaskInfo, Context context, ZHTextView zHTextView) {
        context = com.xunlei.downloadprovider.download.util.a.a(downloadTaskInfo, context);
        if (k.b(downloadTaskInfo) == null) {
            zHTextView.setTextIndentPadding(null);
        }
        zHTextView.setText(context);
        zHTextView.requestLayout();
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo != null) {
            new StringBuilder("updateFolderInfo, isNeedFold : ").append(this.aa);
            boolean d = k.d(downloadTaskInfo);
            downloadTaskInfo = k.e(downloadTaskInfo);
            this.x.setListener(this);
            if (downloadTaskInfo != null) {
                if (this.aa != null) {
                    e();
                    a(true);
                    this.y.setVisibility(8);
                    this.ac = true;
                    this.x.setMaxLine(2);
                    if (d) {
                        this.j.setText("最快速度");
                        this.ab = false;
                        return;
                    }
                    this.ab = true;
                }
                d();
                a(false);
                this.y.setVisibility(0);
                this.z.setVisibility(0);
            } else if (this.aa != null) {
                e();
                a(true);
                this.y.setVisibility(8);
                this.ac = true;
                this.x.setMaxLine(2);
                if (d) {
                    this.ab = true;
                }
                this.j.setText("最快速度");
                this.ab = false;
                return;
            } else {
                d();
                a(false);
                this.y.setVisibility(0);
                this.z.setVisibility(0);
                if (d) {
                    this.A.setVisibility(8);
                } else {
                    this.A.setVisibility(0);
                }
            }
            this.ac = false;
            this.x.setMaxLine(2);
            if (d) {
                this.j.setText("最快速度");
                this.ab = false;
                return;
            }
            this.ab = true;
        }
    }

    private void a(boolean z) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.i.getLayoutParams();
        marginLayoutParams.setMargins(0, 0, DipPixelUtil.dip2px((float) (z ? true : false)), 0);
        this.i.setLayoutParams(marginLayoutParams);
    }

    public DownloadTaskInfo getCurrentTask() {
        return this.M;
    }

    public void setNeedFold(boolean z) {
        this.aa = z;
    }

    public static void a(String str, DownloadTaskInfo downloadTaskInfo) {
        k.d(downloadTaskInfo);
        k.e(downloadTaskInfo);
        com.xunlei.downloadprovider.download.report.a.a(str, downloadTaskInfo);
    }

    public final void b() {
        this.x.setListener(null);
    }

    public void setDownloadVodPlayerController(m mVar) {
        if (this.L != null) {
            this.L.setDownloadVodPlayerController(mVar);
        }
    }

    public void setRefreshListener(ag.a aVar) {
        this.ag = aVar;
        if (this.L != null) {
            this.L.setRefreshListener(aVar);
        }
    }

    static /* synthetic */ void e(DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New) {
        Activity c = AppStatusChgObserver.b().c();
        if (c != null) {
            c.runOnUiThread(new x(downloadTaskNameAndIconView_New));
        }
    }

    static /* synthetic */ void f(DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New) {
        Activity c = AppStatusChgObserver.b().c();
        if (c != null) {
            c.runOnUiThread(new w(downloadTaskNameAndIconView_New));
        }
    }

    static /* synthetic */ void l(DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New) {
        Intent xLIntent = new XLIntent("com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment");
        if (downloadTaskNameAndIconView_New.H != null) {
            LocalBroadcastManager.getInstance(downloadTaskNameAndIconView_New.H).sendBroadcast(xLIntent);
        }
    }
}
