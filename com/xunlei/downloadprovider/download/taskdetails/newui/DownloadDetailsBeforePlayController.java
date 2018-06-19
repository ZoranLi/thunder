package com.xunlei.downloadprovider.download.taskdetails.newui;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.a;
import android.arch.lifecycle.g;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.ad.common.report.c;
import com.xunlei.downloadprovider.ad.taskdetailnew.f;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import java.util.concurrent.TimeUnit;

public class DownloadDetailsBeforePlayController implements a {
    private static final long p = TimeUnit.SECONDS.toMillis(15);
    ConstraintLayout a = null;
    View b = null;
    ImageView c = null;
    ImageView d = null;
    ImageView e = null;
    ImageView f = null;
    int g;
    b h = null;
    f i = null;
    DownloadTaskInfo j = null;
    boolean k = false;
    a l = null;
    DownloadDetailsBeforePlayTopBar m;
    boolean n = false;
    c<Boolean> o;
    private Context q = null;
    private boolean r = false;
    private boolean s;
    private int t;
    private Handler u = new Handler(Looper.myLooper(), new as(this));

    public DownloadDetailsBeforePlayController(Context context) {
        this.q = context;
        this.s = false;
        this.t = -1;
    }

    @g(a = Event.ON_CREATE)
    public void onCreate() {
        this.r = false;
        this.k = false;
    }

    @g(a = Event.ON_RESUME)
    public void onResume() {
        a();
    }

    @g(a = Event.ON_PAUSE)
    public void onPause() {
        b();
    }

    @g(a = Event.ON_DESTROY)
    public void onDestroy() {
        this.r = true;
        d();
    }

    public final void a() {
        this.s = false;
        if (!(c() || this.t == -1)) {
            int i = this.t;
            this.t = -1;
            a(i);
        }
    }

    public final void b() {
        if (!c()) {
            this.s = true;
        }
    }

    public final void a(int i) {
        Message obtainMessage = this.u.obtainMessage();
        obtainMessage.what = 1001;
        obtainMessage.arg1 = i;
        this.u.sendMessage(obtainMessage);
    }

    private void a(long j) {
        Message obtainMessage = this.u.obtainMessage();
        obtainMessage.what = 1001;
        obtainMessage.arg1 = 2;
        this.u.sendMessageDelayed(obtainMessage, j);
    }

    public final void b(int i) {
        if (!c() || i != 0) {
            d(i);
        }
    }

    private void d() {
        this.u.removeCallbacksAndMessages(null);
    }

    private void c(int i) {
        if (!c()) {
            if (i == 0) {
                this.c.setImageResource(R.drawable.downloadvod_player_default_bg);
                this.c.setVisibility(i);
            }
            this.d.setVisibility(i);
            this.e.setVisibility(i);
        }
    }

    private void d(int i) {
        this.b.setVisibility(i);
        if (i == 0) {
            if ((this.g == 2 ? 1 : 0) != 0) {
                this.i.a(0);
            }
        } else {
            this.i.a(i);
        }
        this.m.setVisibility(i);
    }

    private boolean c() {
        return this.g == 4;
    }

    static /* synthetic */ void a(DownloadDetailsBeforePlayController downloadDetailsBeforePlayController, int i) {
        int i2;
        if (downloadDetailsBeforePlayController.r) {
            StringBuilder stringBuilder = new StringBuilder("setStateInner. state: ");
            stringBuilder.append(i);
            stringBuilder.append(" but has destroyed");
        } else if (downloadDetailsBeforePlayController.g != i) {
            if (!downloadDetailsBeforePlayController.c() || i == -1) {
                if (downloadDetailsBeforePlayController.s) {
                    downloadDetailsBeforePlayController.t = i;
                } else {
                    i2 = true;
                    if (i2 != 0) {
                        i2 = downloadDetailsBeforePlayController.g;
                        downloadDetailsBeforePlayController.g = i;
                        i = downloadDetailsBeforePlayController.g;
                        if (i != 0) {
                            switch (i) {
                                case 2:
                                    if ((downloadDetailsBeforePlayController.k ^ 1) == 0 && downloadDetailsBeforePlayController.i.a(downloadDetailsBeforePlayController.j) != 0) {
                                        downloadDetailsBeforePlayController.f.setVisibility(8);
                                        downloadDetailsBeforePlayController.d(0);
                                        break;
                                    }
                                    downloadDetailsBeforePlayController.a(3);
                                    break;
                                    break;
                                case 3:
                                    downloadDetailsBeforePlayController.c(8);
                                    downloadDetailsBeforePlayController.c.setVisibility(0);
                                    downloadDetailsBeforePlayController.f.setVisibility(0);
                                    downloadDetailsBeforePlayController.i.a(8);
                                    downloadDetailsBeforePlayController.d(0);
                                    if (downloadDetailsBeforePlayController.j != 0) {
                                        com.xunlei.downloadprovider.download.util.a.a.a();
                                        DownloadTaskInfo downloadTaskInfo = downloadDetailsBeforePlayController.j;
                                        ImageView imageView = downloadDetailsBeforePlayController.c;
                                        com.xunlei.downloadprovider.download.util.a.a.a(downloadTaskInfo, imageView, imageView.getWidth(), imageView.getHeight(), R.drawable.downloadvod_player_default_bg, null, null);
                                    }
                                    downloadDetailsBeforePlayController.a(p);
                                    break;
                                case 4:
                                    downloadDetailsBeforePlayController.k = true;
                                    downloadDetailsBeforePlayController.i.a(8);
                                    downloadDetailsBeforePlayController.d(8);
                                    downloadDetailsBeforePlayController.d();
                                    break;
                                default:
                                    break;
                            }
                        } else if (i2 == -1) {
                            i = new StringBuilder("setStateInner. set state: ");
                            i.append(downloadDetailsBeforePlayController.g);
                            i.append(" fail, because preState is ");
                            i.append(i2);
                            i.append(" not -1");
                        } else {
                            downloadDetailsBeforePlayController.c(0);
                            downloadDetailsBeforePlayController.f.setVisibility(8);
                            downloadDetailsBeforePlayController.i.a(8);
                            downloadDetailsBeforePlayController.d(0);
                            downloadDetailsBeforePlayController.a(1000);
                        }
                        i = new StringBuilder("state changed. pre: ");
                        i.append(i2);
                        i.append(" cur: ");
                        i.append(downloadDetailsBeforePlayController.g);
                        if (downloadDetailsBeforePlayController.h != 0) {
                            downloadDetailsBeforePlayController.h.a(downloadDetailsBeforePlayController.g);
                        }
                    }
                }
            }
        }
        i2 = 0;
        if (i2 != 0) {
            i2 = downloadDetailsBeforePlayController.g;
            downloadDetailsBeforePlayController.g = i;
            i = downloadDetailsBeforePlayController.g;
            if (i != 0) {
                switch (i) {
                    case 2:
                        if ((downloadDetailsBeforePlayController.k ^ 1) == 0) {
                            break;
                        }
                        downloadDetailsBeforePlayController.a(3);
                        break;
                    case 3:
                        downloadDetailsBeforePlayController.c(8);
                        downloadDetailsBeforePlayController.c.setVisibility(0);
                        downloadDetailsBeforePlayController.f.setVisibility(0);
                        downloadDetailsBeforePlayController.i.a(8);
                        downloadDetailsBeforePlayController.d(0);
                        if (downloadDetailsBeforePlayController.j != 0) {
                            com.xunlei.downloadprovider.download.util.a.a.a();
                            DownloadTaskInfo downloadTaskInfo2 = downloadDetailsBeforePlayController.j;
                            ImageView imageView2 = downloadDetailsBeforePlayController.c;
                            com.xunlei.downloadprovider.download.util.a.a.a(downloadTaskInfo2, imageView2, imageView2.getWidth(), imageView2.getHeight(), R.drawable.downloadvod_player_default_bg, null, null);
                        }
                        downloadDetailsBeforePlayController.a(p);
                        break;
                    case 4:
                        downloadDetailsBeforePlayController.k = true;
                        downloadDetailsBeforePlayController.i.a(8);
                        downloadDetailsBeforePlayController.d(8);
                        downloadDetailsBeforePlayController.d();
                        break;
                    default:
                        break;
                }
            } else if (i2 == -1) {
                downloadDetailsBeforePlayController.c(0);
                downloadDetailsBeforePlayController.f.setVisibility(8);
                downloadDetailsBeforePlayController.i.a(8);
                downloadDetailsBeforePlayController.d(0);
                downloadDetailsBeforePlayController.a(1000);
            } else {
                i = new StringBuilder("setStateInner. set state: ");
                i.append(downloadDetailsBeforePlayController.g);
                i.append(" fail, because preState is ");
                i.append(i2);
                i.append(" not -1");
            }
            i = new StringBuilder("state changed. pre: ");
            i.append(i2);
            i.append(" cur: ");
            i.append(downloadDetailsBeforePlayController.g);
            if (downloadDetailsBeforePlayController.h != 0) {
                downloadDetailsBeforePlayController.h.a(downloadDetailsBeforePlayController.g);
            }
        }
    }
}
