package com.xunlei.downloadprovider.download.center.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.cooperation.c;
import com.xunlei.downloadprovider.download.center.DownloadCenterActivity;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.xllib.b.d;
import com.xunlei.xllib.b.e;
import java.io.File;
import java.util.Collection;

public class DownloadStorageView extends FrameLayout {
    a a;
    private ProgressBar b;
    private TextView c;
    private TextView d;
    private View e;

    private static class a extends AsyncTask<Long, Long, b> {
        private a() {
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        private static b a() {
            b bVar = new b();
            try {
                Context applicationInstance = BrothersApplication.getApplicationInstance();
                if (DownloadConfig.isStoragePathExist(applicationInstance)) {
                    long j;
                    PrivateSpaceMgr a = PrivateSpaceMgr.a();
                    long j2 = 0;
                    if (a.f()) {
                        Collection<TaskInfo> values = a.a.values();
                        if (!d.a(values)) {
                            j = 0;
                            for (TaskInfo taskInfo : values) {
                                long j3;
                                if (!(taskInfo.getTaskStatus() == 1 || taskInfo.getTaskStatus() == 2)) {
                                    if (taskInfo.getTaskStatus() != 4) {
                                        if (!TextUtils.isEmpty(taskInfo.mLocalFileName) && new File(taskInfo.mLocalFileName).exists()) {
                                            j3 = j + taskInfo.mDownloadedSize;
                                            j = j3;
                                        }
                                    }
                                }
                                j3 = j + taskInfo.mDownloadedSize;
                                j = j3;
                            }
                            n.a();
                            bVar.a = n.k() - j;
                            if (bVar.a >= 0) {
                                j2 = bVar.a;
                            }
                            bVar.a = j2;
                            bVar.b = DownloadConfig.getStorageAvailableSize(applicationInstance) + j;
                        }
                    }
                    j = 0;
                    n.a();
                    bVar.a = n.k() - j;
                    if (bVar.a >= 0) {
                        j2 = bVar.a;
                    }
                    bVar.a = j2;
                    bVar.b = DownloadConfig.getStorageAvailableSize(applicationInstance) + j;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bVar;
        }
    }

    private static class b {
        long a;
        long b;

        private b() {
        }
    }

    public DownloadStorageView(Context context) {
        super(context);
        a(context);
    }

    public DownloadStorageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DownloadStorageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @TargetApi(21)
    public DownloadStorageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context);
    }

    private void a(Context context) {
        this.e = LayoutInflater.from(context).inflate(R.layout.layout_download_storage_view, this);
        this.b = (ProgressBar) this.e.findViewById(R.id.progressBar);
        this.c = (TextView) this.e.findViewById(R.id.textViewLeft);
        this.d = (TextView) this.e.findViewById(R.id.textViewRight);
        if (isInEditMode() == null) {
            setProgress(null);
        }
        this.e.setOnClickListener(new ac(this));
    }

    public void setItemViewClickable(boolean z) {
        if (this.e != null) {
            this.e.setClickable(z);
        }
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (this.b != null) {
            this.b.setProgress(i);
        }
    }

    public void setRemainStorageText(CharSequence charSequence) {
        if (this.d != null) {
            this.d.setText(charSequence);
        }
    }

    public void setRemainStorageText(int i) {
        if (this.d != null) {
            this.d.setText(i);
        }
    }

    public void setUsedStorageText(CharSequence charSequence) {
        if (this.c != null) {
            this.c.setText(charSequence);
        }
    }

    public void setUsedStorageText(int i) {
        if (this.c != null) {
            this.c.setText(i);
        }
    }

    public final void a() {
        if ((VERSION.SDK_INT < 19 || isAttachedToWindow()) && !isInEditMode()) {
            try {
                if (!(this.a == null || this.a.isCancelled())) {
                    this.a.cancel(false);
                }
                this.a = new ad(this);
                this.a.execute(new Long[]{Long.valueOf(0)});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static /* synthetic */ void a(DownloadStorageView downloadStorageView, b bVar) {
        long j = bVar.a;
        long j2 = bVar.b;
        long j3 = j + j2;
        downloadStorageView.setProgress((int) (j3 == 0 ? null : (float) ((100 * j) / j3)));
        downloadStorageView.setUsedStorageText(downloadStorageView.getContext().getString(R.string.download_storage_used_fmt, new Object[]{e.a(j, 2)}));
        downloadStorageView.setRemainStorageText(downloadStorageView.getContext().getString(R.string.download_storage_remain_fmt, new Object[]{e.a(j2, 2)}));
        bVar = c.a().b(1003);
        if (!(bVar == null || TextUtils.isEmpty(bVar.getAttachment()))) {
            try {
                boolean e;
                com.xunlei.downloadprovider.cooperation.ui.b a = com.xunlei.downloadprovider.cooperation.ui.b.a();
                long parseLong = (Long.parseLong(bVar.getAttachment()) * 1024) * 1024;
                if (downloadStorageView.getContext() instanceof DownloadCenterActivity) {
                    e = com.xunlei.downloadprovider.cooperation.ui.b.e();
                } else {
                    e = true;
                }
                if (e) {
                    if (parseLong > j2) {
                        a.b = true;
                        downloadStorageView.b.setProgressDrawable(downloadStorageView.getResources().getDrawable(R.drawable.download_storage_progress_cooperation));
                        if (a.f == null) {
                            com.xunlei.downloadprovider.cooperation.a.a.b(bVar.getDisplayLocationName());
                            a.f = true;
                            return;
                        }
                    }
                    a.b = false;
                    downloadStorageView.b.setProgressDrawable(downloadStorageView.getResources().getDrawable(R.drawable.download_storage_progress));
                } else if (parseLong > j2) {
                    new aa(downloadStorageView.getContext()).showAsDropDown(downloadStorageView, ((WindowManager) downloadStorageView.getContext().getSystemService("window")).getDefaultDisplay().getWidth() - DipPixelUtil.dip2px(113.0f), -DipPixelUtil.dip2px(54.0f));
                    com.xunlei.downloadprovider.cooperation.ui.b.a();
                    com.xunlei.downloadprovider.cooperation.ui.b.d();
                    downloadStorageView.b.setProgressDrawable(downloadStorageView.getResources().getDrawable(R.drawable.download_storage_progress_cooperation));
                    a.b = true;
                    if (a.f == null) {
                        com.xunlei.downloadprovider.cooperation.a.a.b(bVar.getDisplayLocationName());
                        a.f = true;
                    }
                } else {
                    a.b = false;
                    downloadStorageView.b.setProgressDrawable(downloadStorageView.getResources().getDrawable(R.drawable.download_storage_progress));
                }
            } catch (DownloadStorageView downloadStorageView2) {
                downloadStorageView2.printStackTrace();
            }
        }
    }
}
