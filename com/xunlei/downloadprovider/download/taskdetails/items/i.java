package com.xunlei.downloadprovider.download.taskdetails.items;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;
import com.xunlei.common.androidutil.HandlerUtil.StaticHandler;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;

/* compiled from: DetailOpenBarViewHolder */
public final class i extends b {
    public View a;
    MessageListener b = new k(this);
    StaticHandler c = new StaticHandler(this.b);
    private TextView i;
    private TextView j;
    private ImageView k;
    private View l;
    private TextView m;
    private DownloadTaskInfo n;
    private View o;
    private LottieAnimationView p;
    private TextView q;
    private boolean r;

    public static View a(Context context) {
        return View.inflate(context, R.layout.layout_task_detail_play_downing, null);
    }

    public i(View view) {
        super(view);
        this.a = view.findViewById(R.id.play_downloading_container);
        this.i = (TextView) view.findViewById(R.id.play_downloading_tip);
        this.j = (TextView) view.findViewById(R.id.text);
        this.k = (ImageView) view.findViewById(R.id.icon);
        this.l = view.findViewById(R.id.play_downloading_btn);
        this.m = (TextView) view.findViewById(R.id.re_download);
        this.o = view.findViewById(R.id.playing);
        this.p = (LottieAnimationView) view.findViewById(R.id.lottie_icon_playing);
        this.q = (TextView) view.findViewById(R.id.text_playing);
        this.a.setOnClickListener(new j(this));
    }

    public final void a(a aVar) {
        b(aVar);
        this.n = aVar.d;
        TaskInfo taskInfo = this.n;
        this.m.setVisibility(8);
        this.l.setVisibility(0);
        if (k.d(taskInfo)) {
            this.c.postDelayed(new l(this, aVar), 500);
        } else {
            if ((this.h != null ? this.h.E() : null) != null) {
                this.l.setVisibility(8);
                this.o.setVisibility(0);
                this.p.setAnimation("lottie/downloadlist/task_playing.json");
                this.p.a(true);
                this.p.a();
            } else {
                this.l.setVisibility(0);
                this.j.setText(this.itemView.getContext().getString(R.string.task_detail_new_bxbb));
                this.p.c();
                this.o.setVisibility(8);
            }
            this.i.setText(this.itemView.getContext().getString(R.string.task_detail_new_bxbb_tip));
            this.k.setImageResource(R.drawable.download_detail_play);
        }
        if (this.r == null) {
            this.r = true;
            if (com.xunlei.downloadprovider.download.b.b.e() != null && k.e(this.d) != null) {
                LayoutParams layoutParams = (LayoutParams) this.a.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, DipPixelUtil.dip2px(5.0f));
                this.a.setLayoutParams(layoutParams);
            }
        }
    }

    static /* synthetic */ void a(i iVar, a aVar) {
        if (iVar.f != null) {
            iVar.f.a(aVar);
        }
    }
}
