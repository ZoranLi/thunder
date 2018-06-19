package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.AppStatusChgObserver;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.taskdetails.ag;
import com.xunlei.downloadprovider.download.taskdetails.items.views.ZHTextViewExpandable.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;
import com.xunlei.xllib.android.XLIntent;

public class DownloadTaskNameAndIconView extends FrameLayout implements a {
    private static final String R = "DownloadTaskNameAndIconView";
    public ZHTextViewExpandable A;
    public View B;
    public View C;
    public View D;
    public View E;
    public View F;
    public TextView G;
    public TextView H;
    public ImageView I;
    public String J;
    public Context K;
    public com.xunlei.downloadprovider.download.tasklist.list.download.a.a L;
    public DownloadTaskInfo M;
    public TaskSpeedCountInfo N;
    public boolean O;
    public int P;
    public com.xunlei.downloadprovider.download.tasklist.list.download.a.a.a Q = new n(this);
    private View S;
    private View T;
    private View U;
    private View V;
    private View W;
    public ImageView a;
    private View aa;
    private boolean ab = true;
    private boolean ac = true;
    private boolean ad = true;
    private com.xunlei.downloadprovider.download.control.a ae;
    private ag af;
    private OnClickListener ag = new k(this);
    private ag.a ah;
    public ZHTextView b;
    public View c;
    public TextView d;
    public View e;
    public TextView f;
    public TextView g;
    public View h;
    public TextView i;
    public TextView j;
    public ImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public View r;
    public TextView s;
    public TextView t;
    public View u;
    public View v;
    public TextView w;
    public View x;
    public View y;
    public View z;

    public DownloadTaskNameAndIconView(Context context) {
        super(context);
        a(context);
    }

    public DownloadTaskNameAndIconView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    public DownloadTaskNameAndIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setControl(com.xunlei.downloadprovider.download.control.a aVar) {
        this.ae = aVar;
    }

    private void a(Context context) {
        this.P = b.f();
        this.K = context;
        context = LayoutInflater.from(context).inflate(R.layout.layout_task_detail_title, this);
        this.T = context.findViewById(R.id.name_view_when_hide_all_data);
        this.S = context.findViewById(R.id.task_icon_title_layout);
        this.a = (ImageView) context.findViewById(R.id.iconImageView);
        LayoutParams layoutParams = this.a.getLayoutParams();
        if (this.P == 0) {
            layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_width);
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_height);
        } else if (this.P == 1) {
            layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style1_width);
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style1_height);
            this.a.setImageResource(R.drawable.ic_dl_video_default_style1);
        } else {
            layoutParams.width = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style2_width);
            layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.task_card_icon_image_style2_height);
            this.a.setImageResource(R.drawable.ic_dl_video_default_style1);
        }
        this.a.setLayoutParams(layoutParams);
        this.L = new com.xunlei.downloadprovider.download.tasklist.list.download.a.a(context.findViewById(R.id.tagSnapshot));
        this.b = (ZHTextView) context.findViewById(R.id.titleTextView);
        this.c = context.findViewById(R.id.title_fore_ground);
        this.d = (TextView) context.findViewById(R.id.tagSize);
        this.g = (TextView) context.findViewById(R.id.tagEpisode);
        this.e = context.findViewById(R.id.tagPlay);
        this.f = (TextView) context.findViewById(R.id.tagPlay);
        this.h = context.findViewById(R.id.tagNew);
        this.i = (TextView) context.findViewById(R.id.speed);
        this.y = context.findViewById(R.id.download_status_container);
        this.j = (TextView) context.findViewById(R.id.download_status_text);
        this.k = (ImageView) context.findViewById(R.id.download_status_iv);
        this.z = context.findViewById(R.id.arrow_layout);
        this.z.setVisibility(0);
        this.A = (ZHTextViewExpandable) context.findViewById(R.id.task_url_content);
        this.B = context.findViewById(R.id.task_detail_info);
        this.B.setVisibility(8);
        this.b.setMaxLines(4);
        this.C = context.findViewById(R.id.container_need_fold);
        this.D = context.findViewById(R.id.detail_expand_space_view);
        this.E = context.findViewById(R.id.download_size_container);
        this.F = context.findViewById(R.id.max_speed_container);
        this.l = (TextView) context.findViewById(R.id.download_max_speed_text);
        this.m = (TextView) context.findViewById(R.id.download_create_time);
        this.n = (TextView) context.findViewById(R.id.download_max_speed);
        this.o = (TextView) context.findViewById(R.id.download_aver_speed);
        this.q = (TextView) context.findViewById(R.id.download_save_time);
        this.p = (TextView) context.findViewById(R.id.download_linked_resource);
        this.r = context.findViewById(R.id.linked_resource_container);
        this.s = (TextView) context.findViewById(R.id.downloaded_size);
        this.u = context.findViewById(R.id.progressContainer);
        this.t = (TextView) context.findViewById(R.id.progress);
        this.v = context.findViewById(R.id.finish_time_container);
        this.w = (TextView) context.findViewById(R.id.finish_time);
        this.x = context.findViewById(R.id.source_container);
        this.G = (TextView) context.findViewById(R.id.task_ref_url);
        this.H = (TextView) context.findViewById(R.id.web_site_name);
        this.U = context.findViewById(R.id.web_container);
        this.I = (ImageView) context.findViewById(R.id.iv_collection);
        this.V = context.findViewById(R.id.tagDivider1);
        this.W = context.findViewById(R.id.tagDivider2);
        this.aa = context.findViewById(R.id.task_detail_fold_container);
        this.U.setOnClickListener(new f(this));
        this.I.setOnClickListener(new g(this));
        this.z.setOnClickListener(this.ag);
        this.b.setOnClickListener(this.ag);
        this.aa.setOnClickListener(new j(this));
        this.D.setVisibility(8);
        this.E.setVisibility(0);
        this.F.setVisibility(0);
        a(true);
    }

    public void setCollaped(boolean z) {
        if (z) {
            d();
        } else {
            c();
        }
    }

    public boolean getIsInCollapedState() {
        return this.ac;
    }

    public void setSelected(boolean z) {
        if (this.I != null) {
            this.I.setSelected(z);
        }
    }

    public void setAdapter(ag agVar) {
        this.af = agVar;
    }

    private void c() {
        this.ac = false;
        this.B.setVisibility(0);
        this.b.setMaxLines(100);
        this.c.setVisibility(8);
        this.z.setVisibility(8);
        a(false);
    }

    private void d() {
        this.ac = true;
        this.B.setVisibility(8);
        if (this.b.getCurrentLineNum() > 4) {
            this.c.setVisibility(0);
        }
        this.b.setMaxLines(4);
        this.z.setVisibility(0);
        a(true);
    }

    public final void a() {
        if (this.V != null) {
            this.V.setVisibility(8);
        }
        if (this.W != null) {
            this.W.setVisibility(8);
        }
        if (this.g.getVisibility() == 0 && this.d.getVisibility() == 0 && this.V != null) {
            this.V.setVisibility(0);
        }
        if (this.d.getVisibility() == 0 && this.L.a() == 0 && this.W != null) {
            this.W.setVisibility(0);
        }
        if (this.g.getVisibility() == 0 && this.d.getVisibility() == 8 && this.L.a() == 0 && this.V != null) {
            this.V.setVisibility(0);
        }
    }

    public void setTaskSpeedCountInfo(TaskSpeedCountInfo taskSpeedCountInfo) {
        this.N = taskSpeedCountInfo;
        new StringBuilder("taskCountInfo :  ").append(taskSpeedCountInfo);
    }

    public static void a(DownloadTaskInfo downloadTaskInfo, TextView textView, TextView textView2) {
        if (downloadTaskInfo.mFileSize > 0) {
            textView.setText(com.xunlei.downloadprovider.download.util.a.c(downloadTaskInfo.mFileSize));
        } else {
            textView.setText(R.string.download_item_task_unknown_filesize);
        }
        if (TextUtils.isEmpty(downloadTaskInfo.mEpisodeTagText) == null) {
            textView2.setVisibility(null);
            textView2.setText(downloadTaskInfo.mEpisodeTagText);
            return;
        }
        textView2.setVisibility(8);
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo != null) {
            boolean d = k.d(downloadTaskInfo);
            downloadTaskInfo = k.e(downloadTaskInfo);
            this.A.setListener(this);
            if (downloadTaskInfo != null) {
                if (this.ab != null) {
                    this.z.setVisibility(0);
                    a(true);
                    this.B.setVisibility(8);
                    this.b.setMaxLines(4);
                    this.ac = true;
                    this.A.setMaxLine(2);
                    if (d) {
                        this.l.setText("最快速度");
                        this.ad = false;
                        return;
                    }
                    this.ad = true;
                }
                this.z.setVisibility(8);
                a(false);
                this.B.setVisibility(0);
                this.b.setMaxLines(100);
                this.C.setVisibility(0);
            } else if (this.ab != null) {
                this.z.setVisibility(0);
                a(true);
                this.B.setVisibility(8);
                this.b.setMaxLines(4);
                this.ac = true;
                this.A.setMaxLine(2);
                if (d) {
                    this.ad = true;
                }
                this.l.setText("最快速度");
                this.ad = false;
                return;
            } else {
                this.z.setVisibility(8);
                a(false);
                this.B.setVisibility(0);
                this.b.setMaxLines(100);
                this.C.setVisibility(0);
                if (d) {
                    this.D.setVisibility(8);
                } else {
                    this.D.setVisibility(0);
                }
            }
            this.ac = false;
            this.A.setMaxLine(2);
            if (d) {
                this.l.setText("最快速度");
                this.ad = false;
                return;
            }
            this.ad = true;
        }
    }

    private void a(boolean z) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.j.getLayoutParams();
        layoutParams.setMargins(0, 0, DipPixelUtil.dip2px((float) (z ? true : false)), 0);
        this.j.setLayoutParams(layoutParams);
    }

    public DownloadTaskInfo getCurrentTask() {
        return this.M;
    }

    public void setNeedFold(boolean z) {
        this.ab = z;
    }

    public static void a(String str, DownloadTaskInfo downloadTaskInfo) {
        com.xunlei.downloadprovider.download.report.a.a(str, downloadTaskInfo);
    }

    public final void b() {
        this.A.setListener(null);
    }

    public void setRefreshListener(ag.a aVar) {
        this.ah = aVar;
    }

    static /* synthetic */ void e(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        Activity c = AppStatusChgObserver.b().c();
        if (c != null) {
            c.runOnUiThread(new m(downloadTaskNameAndIconView));
        }
    }

    static /* synthetic */ void f(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        Activity c = AppStatusChgObserver.b().c();
        if (c != null) {
            c.runOnUiThread(new l(downloadTaskNameAndIconView));
        }
    }

    static /* synthetic */ void l(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        Intent xLIntent = new XLIntent("com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment");
        if (downloadTaskNameAndIconView.K != null) {
            LocalBroadcastManager.getInstance(downloadTaskNameAndIconView.K).sendBroadcast(xLIntent);
        }
    }
}
