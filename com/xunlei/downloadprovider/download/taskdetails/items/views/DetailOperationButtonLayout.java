package com.xunlei.downloadprovider.download.taskdetails.items.views;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.control.a;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.taskdetails.ag;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.k;

public class DetailOperationButtonLayout extends RelativeLayout {
    private static final String b = "DetailOperationButtonLayout";
    protected ag a;
    private DownloadTaskInfo c;
    private a d;
    private View e;
    private View f;
    private TextView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private View k;
    private LottieAnimationView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private m p;
    private ag.a q;
    private OnClickListener r = new e(this);

    public DetailOperationButtonLayout(Context context) {
        super(context);
    }

    public DetailOperationButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DetailOperationButtonLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.e = findViewById(R.id.operate_container);
        this.f = findViewById(R.id.speedUp);
        this.f.setOnClickListener(new a(this));
        this.g = (TextView) findViewById(R.id.pause);
        this.g.setOnClickListener(new b(this));
        this.h = (TextView) findViewById(R.id.continueTask);
        this.h.setOnClickListener(new c(this));
        this.i = (TextView) findViewById(R.id.retry);
        this.i.setOnClickListener(new d(this));
        this.j = (TextView) findViewById(R.id.play);
        this.k = findViewById(R.id.playing);
        this.l = (LottieAnimationView) findViewById(R.id.lottie_icon_playing);
        this.m = (TextView) findViewById(R.id.text_playing);
        this.n = (TextView) findViewById(R.id.install);
        this.o = (TextView) findViewById(R.id.open);
        this.j.setOnClickListener(this.r);
        this.n.setOnClickListener(this.r);
        this.o.setOnClickListener(this.r);
        if (this.k != null) {
            this.k.setOnClickListener(null);
        }
    }

    public void setDownloadVodPlayerController(m mVar) {
        this.p = mVar;
    }

    public void setRefreshListener(ag.a aVar) {
        this.q = aVar;
    }

    public final void a(DownloadTaskInfo downloadTaskInfo, a aVar, ag agVar) {
        this.a = agVar;
        this.c = downloadTaskInfo;
        this.d = aVar;
        if (this.c != null) {
            downloadTaskInfo = this.c;
            if (downloadTaskInfo != null) {
                this.f.setVisibility(8);
                if (k.d(downloadTaskInfo) == null) {
                    if (downloadTaskInfo.mVipAcceleratedSpeed <= 0) {
                        if ((downloadTaskInfo.getTaskStatus() == 2 || downloadTaskInfo.getTaskStatus() == 1) && downloadTaskInfo.mHasVipChannelSpeedup == null) {
                            this.f.setVisibility(0);
                        }
                    }
                }
                this.g.setVisibility(8);
                this.i.setVisibility(8);
                this.h.setVisibility(8);
                this.j.setVisibility(8);
                if (this.k != null) {
                    this.k.setVisibility(8);
                }
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                this.e.setVisibility(0);
                if (downloadTaskInfo.getTaskStatus() != 2) {
                    if (downloadTaskInfo.getTaskStatus() != 1) {
                        if (downloadTaskInfo.getTaskStatus() == 4) {
                            this.h.setVisibility(0);
                            this.h.setText("继续");
                            return;
                        }
                        if (!(downloadTaskInfo.getTaskStatus() == 16 && DownloadError.c(downloadTaskInfo) == null)) {
                            if (k.d(downloadTaskInfo) != null) {
                                if (k.e(downloadTaskInfo) != null) {
                                    this.e.setVisibility(8);
                                    return;
                                } else if (k.c(downloadTaskInfo) != null) {
                                    aVar = this.p != null ? this.p.E() : null;
                                    if (k.g(downloadTaskInfo) != null) {
                                        aVar = ApkHelper.getApkInfo(getContext(), downloadTaskInfo.mLocalFileName);
                                        if (aVar != null) {
                                            agVar = downloadTaskInfo.mAppInstalledType;
                                            long elapsedRealtime = SystemClock.elapsedRealtime();
                                            if (downloadTaskInfo.mAppInstalledTypeLastModifyTime == 0 || elapsedRealtime - downloadTaskInfo.mAppInstalledTypeLastModifyTime >= 3000) {
                                                agVar = ApkHelper.compareLocalApp(getContext(), aVar);
                                                downloadTaskInfo.mAppInstalledType = agVar;
                                                downloadTaskInfo.mAppInstalledTypeLastModifyTime = elapsedRealtime;
                                            }
                                            if (agVar != 4) {
                                                if (agVar != 5) {
                                                    this.n.setVisibility(0);
                                                    return;
                                                }
                                            }
                                            this.o.setVisibility(0);
                                            return;
                                        }
                                        this.o.setVisibility(0);
                                        return;
                                    }
                                    if (k.a(downloadTaskInfo) == null) {
                                        if (k.b(downloadTaskInfo) == null) {
                                            if (aVar == null) {
                                                this.o.setVisibility(0);
                                            }
                                            return;
                                        }
                                    }
                                    if (aVar == null) {
                                        this.j.setVisibility(0);
                                        if (this.l != null) {
                                            this.l.c();
                                            return;
                                        }
                                    } else if (this.k != null) {
                                        this.k.setVisibility(0);
                                        if (this.l != null) {
                                            this.l.setAnimation("lottie/downloadlist/task_playing.json");
                                            this.l.a(true);
                                            this.l.a();
                                            return;
                                        }
                                    }
                                    return;
                                }
                            }
                        }
                        this.i.setVisibility(0);
                    }
                }
                this.g.setVisibility(0);
                this.g.setText("暂停");
            }
        }
    }
}
