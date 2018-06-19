package com.xunlei.downloadprovider.download.taskdetails.items;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DateTimeUtil;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.download.DownloadManager;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;
import com.xunlei.downloadprovider.download.taskdetails.items.views.DownloadTaskNameAndIconView;
import com.xunlei.downloadprovider.download.taskdetails.items.views.o;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.DownloadError.SpeedupFailureCode;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;

/* compiled from: DetailTaskBasicInfoViewHolder */
public final class p extends b {
    public final DownloadTaskNameAndIconView a;

    public static View a(Context context) {
        return new DownloadTaskNameAndIconView(context);
    }

    public p(View view) {
        super(view);
        this.a = (DownloadTaskNameAndIconView) view;
    }

    public final void a() {
        if (this.a != null) {
            DownloadTaskNameAndIconView downloadTaskNameAndIconView = this.a;
            if (!(downloadTaskNameAndIconView.M == null || downloadTaskNameAndIconView.I == null)) {
                downloadTaskNameAndIconView.O = com.xunlei.downloadprovider.web.website.g.b.a().a(downloadTaskNameAndIconView.J);
                if (downloadTaskNameAndIconView.O) {
                    downloadTaskNameAndIconView.I.setSelected(true);
                    return;
                }
                downloadTaskNameAndIconView.I.setSelected(false);
            }
        }
    }

    public final void a(boolean z) {
        if (this.a != null) {
            this.a.setSelected(z);
        }
    }

    public final void a(a aVar) {
        a aVar2 = aVar;
        b(aVar);
        DownloadTaskInfo currentTask = this.a.getCurrentTask();
        DownloadTaskInfo downloadTaskInfo = aVar2.d;
        if (downloadTaskInfo != currentTask) {
            r1.a.a(downloadTaskInfo);
        } else if (r1.f != null && r1.f.j) {
            r1.a.a(downloadTaskInfo);
            r1.f.j = false;
        }
        DownloadTaskNameAndIconView downloadTaskNameAndIconView = r1.a;
        boolean z = true;
        int i = 8;
        if (!(downloadTaskInfo == null || downloadTaskInfo == downloadTaskNameAndIconView.M)) {
            boolean z2;
            if (!(downloadTaskInfo == null || TextUtils.isEmpty(downloadTaskInfo.mWebsiteName))) {
                if (!TextUtils.isEmpty(downloadTaskInfo.mRefUrl)) {
                    downloadTaskNameAndIconView.J = downloadTaskInfo.mRefUrl;
                } else if (!(downloadTaskInfo.mExtraInfo == null || TextUtils.isEmpty(downloadTaskInfo.mExtraInfo.mRefUrl))) {
                    downloadTaskNameAndIconView.J = downloadTaskInfo.mExtraInfo.mRefUrl;
                }
                if (!TextUtils.isEmpty(downloadTaskNameAndIconView.J)) {
                    z2 = true;
                    if (!z2 && downloadTaskNameAndIconView.x != null) {
                        downloadTaskNameAndIconView.x.setVisibility(0);
                        if (downloadTaskNameAndIconView.x.getVisibility() == 0) {
                            if (TextUtils.isEmpty(downloadTaskInfo.mWebsiteName)) {
                                downloadTaskNameAndIconView.H.setVisibility(8);
                            } else {
                                downloadTaskNameAndIconView.H.setVisibility(0);
                                downloadTaskNameAndIconView.H.setText(downloadTaskInfo.mWebsiteName);
                            }
                            if (!TextUtils.isEmpty(downloadTaskNameAndIconView.J)) {
                                downloadTaskNameAndIconView.G.setText(downloadTaskNameAndIconView.J);
                            }
                            downloadTaskNameAndIconView.O = com.xunlei.downloadprovider.web.website.g.b.a().a(downloadTaskNameAndIconView.J);
                            if (downloadTaskNameAndIconView.O) {
                                downloadTaskNameAndIconView.I.setSelected(true);
                            } else {
                                downloadTaskNameAndIconView.I.setSelected(false);
                            }
                        }
                    } else if (downloadTaskNameAndIconView.x != null) {
                        downloadTaskNameAndIconView.x.setVisibility(8);
                    }
                }
            }
            z2 = false;
            if (!z2) {
            }
            if (downloadTaskNameAndIconView.x != null) {
                downloadTaskNameAndIconView.x.setVisibility(8);
            }
        }
        r1.a.setControl(r1.g);
        r1.a.setAdapter(r1.f);
        r1.a.setTaskSpeedCountInfo((TaskSpeedCountInfo) aVar2.a(TaskSpeedCountInfo.class));
        DownloadTaskNameAndIconView downloadTaskNameAndIconView2 = r1.a;
        if (downloadTaskInfo != null) {
            Context context = downloadTaskNameAndIconView2.getContext();
            ZHTextView zHTextView = downloadTaskNameAndIconView2.b;
            View view = downloadTaskNameAndIconView2.h;
            CharSequence a = com.xunlei.downloadprovider.download.util.a.a(downloadTaskInfo, context);
            boolean b = k.b(downloadTaskInfo);
            if (b) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            if (b) {
                zHTextView.setTextIndentPadding((float) Math.max(view.getWidth(), DipPixelUtil.dip2px(14.0f)));
            } else {
                zHTextView.setTextIndentPadding(0.0f);
            }
            zHTextView.setText(a);
            zHTextView.requestLayout();
            zHTextView.getViewTreeObserver().addOnGlobalLayoutListener(new o(downloadTaskNameAndIconView2, zHTextView));
            ImageView imageView = downloadTaskNameAndIconView2.a;
            if (downloadTaskNameAndIconView2.P == 0) {
                if (downloadTaskNameAndIconView2.L != null) {
                    downloadTaskNameAndIconView2.L.a(8);
                }
                com.xunlei.downloadprovider.download.util.a.a.a();
                com.xunlei.downloadprovider.download.util.a.a.b(downloadTaskInfo, imageView);
            } else {
                if (downloadTaskNameAndIconView2.L != null) {
                    downloadTaskNameAndIconView2.L.a(8);
                }
                if (downloadTaskNameAndIconView2.M == null || downloadTaskInfo != downloadTaskNameAndIconView2.M) {
                    com.xunlei.downloadprovider.download.util.a.a.a();
                    com.xunlei.downloadprovider.download.util.a.a.a(downloadTaskInfo, imageView);
                }
                com.xunlei.downloadprovider.download.util.a.a.a();
                com.xunlei.downloadprovider.download.util.a.a.a(downloadTaskInfo, imageView, downloadTaskNameAndIconView2.L, com.xunlei.downloadprovider.download.b.b.f(), downloadTaskNameAndIconView2.Q);
            }
            DownloadTaskNameAndIconView.a(downloadTaskInfo, downloadTaskNameAndIconView2.d, downloadTaskNameAndIconView2.g);
        }
        downloadTaskNameAndIconView2 = r1.a;
        if (downloadTaskInfo != null) {
            String a2;
            long j;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2;
            CharSequence c;
            int i2;
            TextView textView;
            int i3;
            downloadTaskNameAndIconView2.M = downloadTaskInfo;
            TaskInfo taskInfo = downloadTaskNameAndIconView2.M;
            downloadTaskNameAndIconView2.y.setVisibility(8);
            downloadTaskNameAndIconView2.i.setVisibility(8);
            if (taskInfo != null) {
                downloadTaskNameAndIconView2.j.setTextColor(downloadTaskNameAndIconView2.getContext().getResources().getColor(R.color.download_list_detail_color_t1));
                if (taskInfo.getTaskStatus() == 8) {
                    downloadTaskNameAndIconView2.i.setVisibility(8);
                    downloadTaskNameAndIconView2.y.setVisibility(0);
                    if (taskInfo.mIsFileMissing) {
                        downloadTaskNameAndIconView2.j.setTextColor(downloadTaskNameAndIconView2.getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColor));
                        downloadTaskNameAndIconView2.k.setVisibility(8);
                        downloadTaskNameAndIconView2.j.setText(R.string.download_item_task_file_not_exist);
                    } else {
                        downloadTaskNameAndIconView2.k.setVisibility(0);
                        downloadTaskNameAndIconView2.k.setImageDrawable(downloadTaskNameAndIconView2.getContext().getResources().getDrawable(R.drawable.ic_detail_download_finish));
                        downloadTaskNameAndIconView2.j.setText(R.string.download_item_task_download_finish);
                    }
                } else if (4 == taskInfo.getTaskStatus()) {
                    downloadTaskNameAndIconView2.y.setVisibility(0);
                    downloadTaskNameAndIconView2.j.setText(downloadTaskNameAndIconView2.getContext().getResources().getString(R.string.download_item_task_status_paused));
                    downloadTaskNameAndIconView2.k.setVisibility(8);
                } else {
                    if (2 == taskInfo.getTaskStatus()) {
                        downloadTaskNameAndIconView2.i.setVisibility(0);
                        if (taskInfo.mDownloadSpeed < 1) {
                            downloadTaskNameAndIconView2.i.setText(R.string.download_item_task_status_linking);
                        } else {
                            if (!taskInfo.mHasVipChannelSpeedup) {
                                if (taskInfo.mVipAcceleratedSpeed <= 100) {
                                    if (taskInfo.mDownloadSpeed < 1) {
                                        a = downloadTaskNameAndIconView2.getContext().getString(R.string.download_item_task_status_linking);
                                    } else {
                                        a = com.xunlei.downloadprovider.download.util.a.a(taskInfo.mDownloadSpeed);
                                    }
                                    downloadTaskNameAndIconView2.i.setText(a);
                                }
                            }
                            a2 = com.xunlei.downloadprovider.download.util.a.a(taskInfo.mDownloadSpeed);
                            SpeedupFailureCode b2 = DownloadError.b(taskInfo);
                            String format;
                            StringBuilder stringBuilder3;
                            CharSequence spannableString;
                            if (b2 == null || taskInfo.mVipAcceleratedSpeed >= 100) {
                                format = String.format("(+ %s)", new Object[]{com.xunlei.downloadprovider.download.util.a.a(taskInfo.mVipAcceleratedSpeed)});
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(a2);
                                stringBuilder3.append(format);
                                a2 = stringBuilder3.toString();
                                spannableString = new SpannableString(a2);
                                spannableString.setSpan(new ForegroundColorSpan(downloadTaskNameAndIconView2.getContext().getResources().getColor(R.color.common_blue_button_normal)), a2.length() - format.length(), a2.length(), 34);
                                spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(12.0f)), a2.length() - format.length(), a2.length(), 34);
                                downloadTaskNameAndIconView2.i.setText(spannableString);
                            } else {
                                if (b2 == SpeedupFailureCode.SENSITIVE_RESOURCE_LIMITED) {
                                    format = downloadTaskNameAndIconView2.getResources().getString(R.string.download_item_task_speedup_fail_sensitive_resource_limited);
                                } else {
                                    format = downloadTaskNameAndIconView2.getResources().getString(R.string.download_item_task_speedup_fail);
                                }
                                stringBuilder3 = new StringBuilder(com.umeng.message.proguard.k.s);
                                stringBuilder3.append(format);
                                stringBuilder3.append(com.umeng.message.proguard.k.t);
                                format = stringBuilder3.toString();
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append(a2);
                                stringBuilder3.append(format);
                                a2 = stringBuilder3.toString();
                                spannableString = new SpannableString(a2);
                                spannableString.setSpan(new ForegroundColorSpan(downloadTaskNameAndIconView2.getResources().getColor(R.color.DownloadTaskItemSpeedupErrorStatusTextColor)), a2.length() - format.length(), a2.length(), 34);
                                spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(12.0f)), a2.length() - format.length(), a2.length(), 34);
                                downloadTaskNameAndIconView2.i.setText(spannableString);
                            }
                        }
                    } else if (taskInfo.getTaskStatus() == 16) {
                        downloadTaskNameAndIconView2.y.setVisibility(0);
                        downloadTaskNameAndIconView2.k.setVisibility(0);
                        downloadTaskNameAndIconView2.k.setImageDrawable(downloadTaskNameAndIconView2.getContext().getResources().getDrawable(R.drawable.ic_detail_download_error_style2));
                        downloadTaskNameAndIconView2.j.setText(DownloadError.a(taskInfo, downloadTaskNameAndIconView2.getContext()));
                    } else if (taskInfo.getTaskStatus() == 1) {
                        downloadTaskNameAndIconView2.y.setVisibility(0);
                        i = 8;
                        downloadTaskNameAndIconView2.k.setVisibility(8);
                        downloadTaskNameAndIconView2.j.setText(downloadTaskNameAndIconView2.getContext().getResources().getString(R.string.download_item_task_status_waiting));
                    } else {
                        i = 8;
                        downloadTaskNameAndIconView2.y.setVisibility(8);
                        downloadTaskNameAndIconView2.i.setVisibility(8);
                    }
                    i = 8;
                }
            }
            currentTask = downloadTaskNameAndIconView2.M;
            if (currentTask.getTaskStatus() == i) {
                long j2;
                if (currentTask.mDownloadedSize != 0) {
                    try {
                        j = (long) ((((((float) (currentTask.mDcdnReceivedSize + currentTask.mVipChannelReceivedSize)) * 1.0f) / ((float) currentTask.mDownloadedSize)) * ((float) currentTask.mDownloadDurationTime)) / 1000.0f);
                        j2 = 0;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (j > j2) {
                        a = DateTimeUtil.getTimeString((int) j, downloadTaskNameAndIconView2.getContext());
                        if (a.contains("-")) {
                            a = "--";
                        }
                        downloadTaskNameAndIconView2.q.setText(a);
                        downloadTaskNameAndIconView2.m.setText(DateTimeUtil.formatTimeWithDefault(downloadTaskNameAndIconView2.M.mCreateTime));
                        currentTask = downloadTaskNameAndIconView2.M;
                        j = (currentTask.mDownloadedSize > 0 || currentTask.mDownloadDurationTime <= 0) ? 0 : (long) (((((float) currentTask.mDownloadedSize) * 1.0f) / ((float) currentTask.mDownloadDurationTime)) * 1000.0f);
                        if (downloadTaskNameAndIconView2.N != null) {
                            downloadTaskNameAndIconView2.N = new TaskSpeedCountInfo();
                            downloadTaskNameAndIconView2.N.mHighestSpeed = currentTask.mDownloadSpeed;
                        } else if (currentTask.mDownloadSpeed > downloadTaskNameAndIconView2.N.mHighestSpeed) {
                            downloadTaskNameAndIconView2.N.mHighestSpeed = currentTask.mDownloadSpeed;
                        }
                        if (downloadTaskNameAndIconView2.N.mHighestSpeed < j) {
                            downloadTaskNameAndIconView2.N.mHighestSpeed = j + (j / 3);
                        }
                        new StringBuilder(" High speed: ").append(downloadTaskNameAndIconView2.N.mHighestSpeed);
                        if (downloadTaskNameAndIconView2.N.mHighestSpeed == 0) {
                            a = "--";
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(ConvertUtil.byteConvert(downloadTaskNameAndIconView2.N.mHighestSpeed));
                            stringBuilder.append("/s");
                            a = stringBuilder.toString();
                        }
                        downloadTaskNameAndIconView2.n.setText(a);
                        currentTask = downloadTaskNameAndIconView2.M;
                        a2 = "";
                        if (currentTask.mDownloadedSize > 0 || currentTask.mDownloadDurationTime <= 0) {
                            z = false;
                            a = a2;
                        } else {
                            j2 = (long) (((((float) currentTask.mDownloadedSize) * 1.0f) / ((float) currentTask.mDownloadDurationTime)) * 1000.0f);
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(ConvertUtil.byteConvert(j2));
                            stringBuilder.append("/s");
                            a = stringBuilder.toString();
                            if (j2 < DownloadManager.MAX_BYTES_OVER_MOBILE) {
                                z = false;
                            }
                        }
                        if (TextUtils.isEmpty(a)) {
                            a = "--";
                        }
                        if (z) {
                            downloadTaskNameAndIconView2.o.setTextColor(downloadTaskNameAndIconView2.K.getResources().getColor(R.color.download_list_detail_color_t4));
                        } else {
                            downloadTaskNameAndIconView2.o.setTextColor(downloadTaskNameAndIconView2.K.getResources().getColor(R.color.download_list_detail_color_t3));
                        }
                        downloadTaskNameAndIconView2.o.setText(a);
                        currentTask = downloadTaskNameAndIconView2.M;
                        if (2 == currentTask.getTaskStatus()) {
                            downloadTaskNameAndIconView2.r.setVisibility(0);
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(String.valueOf(currentTask.mResLinkUsed));
                            stringBuilder2.append("/");
                            stringBuilder2.append(String.valueOf(currentTask.mResLinkTotal));
                            downloadTaskNameAndIconView2.p.setText(stringBuilder2.toString());
                        }
                        currentTask = downloadTaskNameAndIconView2.M;
                        if (currentTask.mFileSize > 0) {
                            c = com.xunlei.downloadprovider.download.util.a.c(currentTask.mFileSize);
                        } else {
                            c = downloadTaskNameAndIconView2.getContext().getString(R.string.download_item_task_unknown_filesize);
                        }
                        downloadTaskNameAndIconView2.s.setText(c);
                        if (8 != currentTask.getTaskStatus()) {
                            downloadTaskNameAndIconView2.u.setVisibility(0);
                            if (currentTask.mFileSize == 0) {
                                downloadTaskNameAndIconView2.t.setText("--");
                            } else {
                                i2 = (int) ((((float) currentTask.mDownloadedSize) / ((float) currentTask.mFileSize)) * 100.0f);
                                textView = downloadTaskNameAndIconView2.t;
                                stringBuilder2 = new StringBuilder();
                                stringBuilder2.append(i2);
                                stringBuilder2.append("%");
                                textView.setText(stringBuilder2.toString());
                            }
                            i3 = 8;
                        } else {
                            i3 = 8;
                            downloadTaskNameAndIconView2.u.setVisibility(8);
                        }
                        currentTask = downloadTaskNameAndIconView2.M;
                        if (currentTask.getTaskStatus() != i3) {
                            downloadTaskNameAndIconView2.w.setText("--");
                        } else {
                            downloadTaskNameAndIconView2.w.setText(DateTimeUtil.formatTimeWithDefault(currentTask.mLastModifiedTime));
                        }
                        a = downloadTaskInfo.getTaskDownloadUrl();
                        if (!a.startsWith("thunder:")) {
                            a = a.substring(8);
                        } else if (a.startsWith("thunder")) {
                            a = a.substring(7);
                        }
                        downloadTaskNameAndIconView2.A.setText(a);
                        downloadTaskNameAndIconView2.a();
                    }
                }
                j2 = 0;
                j = 0;
                if (j > j2) {
                    a = DateTimeUtil.getTimeString((int) j, downloadTaskNameAndIconView2.getContext());
                    if (a.contains("-")) {
                        a = "--";
                    }
                    downloadTaskNameAndIconView2.q.setText(a);
                    downloadTaskNameAndIconView2.m.setText(DateTimeUtil.formatTimeWithDefault(downloadTaskNameAndIconView2.M.mCreateTime));
                    currentTask = downloadTaskNameAndIconView2.M;
                    if (currentTask.mDownloadedSize > 0) {
                    }
                    if (downloadTaskNameAndIconView2.N != null) {
                        downloadTaskNameAndIconView2.N = new TaskSpeedCountInfo();
                        downloadTaskNameAndIconView2.N.mHighestSpeed = currentTask.mDownloadSpeed;
                    } else if (currentTask.mDownloadSpeed > downloadTaskNameAndIconView2.N.mHighestSpeed) {
                        downloadTaskNameAndIconView2.N.mHighestSpeed = currentTask.mDownloadSpeed;
                    }
                    if (downloadTaskNameAndIconView2.N.mHighestSpeed < j) {
                        downloadTaskNameAndIconView2.N.mHighestSpeed = j + (j / 3);
                    }
                    new StringBuilder(" High speed: ").append(downloadTaskNameAndIconView2.N.mHighestSpeed);
                    if (downloadTaskNameAndIconView2.N.mHighestSpeed == 0) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(ConvertUtil.byteConvert(downloadTaskNameAndIconView2.N.mHighestSpeed));
                        stringBuilder.append("/s");
                        a = stringBuilder.toString();
                    } else {
                        a = "--";
                    }
                    downloadTaskNameAndIconView2.n.setText(a);
                    currentTask = downloadTaskNameAndIconView2.M;
                    a2 = "";
                    if (currentTask.mDownloadedSize > 0) {
                    }
                    z = false;
                    a = a2;
                    if (TextUtils.isEmpty(a)) {
                        a = "--";
                    }
                    if (z) {
                        downloadTaskNameAndIconView2.o.setTextColor(downloadTaskNameAndIconView2.K.getResources().getColor(R.color.download_list_detail_color_t3));
                    } else {
                        downloadTaskNameAndIconView2.o.setTextColor(downloadTaskNameAndIconView2.K.getResources().getColor(R.color.download_list_detail_color_t4));
                    }
                    downloadTaskNameAndIconView2.o.setText(a);
                    currentTask = downloadTaskNameAndIconView2.M;
                    if (2 == currentTask.getTaskStatus()) {
                        downloadTaskNameAndIconView2.r.setVisibility(0);
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(String.valueOf(currentTask.mResLinkUsed));
                        stringBuilder2.append("/");
                        stringBuilder2.append(String.valueOf(currentTask.mResLinkTotal));
                        downloadTaskNameAndIconView2.p.setText(stringBuilder2.toString());
                    }
                    currentTask = downloadTaskNameAndIconView2.M;
                    if (currentTask.mFileSize > 0) {
                        c = downloadTaskNameAndIconView2.getContext().getString(R.string.download_item_task_unknown_filesize);
                    } else {
                        c = com.xunlei.downloadprovider.download.util.a.c(currentTask.mFileSize);
                    }
                    downloadTaskNameAndIconView2.s.setText(c);
                    if (8 != currentTask.getTaskStatus()) {
                        i3 = 8;
                        downloadTaskNameAndIconView2.u.setVisibility(8);
                    } else {
                        downloadTaskNameAndIconView2.u.setVisibility(0);
                        if (currentTask.mFileSize == 0) {
                            i2 = (int) ((((float) currentTask.mDownloadedSize) / ((float) currentTask.mFileSize)) * 100.0f);
                            textView = downloadTaskNameAndIconView2.t;
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(i2);
                            stringBuilder2.append("%");
                            textView.setText(stringBuilder2.toString());
                        } else {
                            downloadTaskNameAndIconView2.t.setText("--");
                        }
                        i3 = 8;
                    }
                    currentTask = downloadTaskNameAndIconView2.M;
                    if (currentTask.getTaskStatus() != i3) {
                        downloadTaskNameAndIconView2.w.setText(DateTimeUtil.formatTimeWithDefault(currentTask.mLastModifiedTime));
                    } else {
                        downloadTaskNameAndIconView2.w.setText("--");
                    }
                    a = downloadTaskInfo.getTaskDownloadUrl();
                    if (!a.startsWith("thunder:")) {
                        a = a.substring(8);
                    } else if (a.startsWith("thunder")) {
                        a = a.substring(7);
                    }
                    downloadTaskNameAndIconView2.A.setText(a);
                    downloadTaskNameAndIconView2.a();
                }
            }
            a = "--";
            downloadTaskNameAndIconView2.q.setText(a);
            downloadTaskNameAndIconView2.m.setText(DateTimeUtil.formatTimeWithDefault(downloadTaskNameAndIconView2.M.mCreateTime));
            currentTask = downloadTaskNameAndIconView2.M;
            if (currentTask.mDownloadedSize > 0) {
            }
            if (downloadTaskNameAndIconView2.N != null) {
                downloadTaskNameAndIconView2.N = new TaskSpeedCountInfo();
                downloadTaskNameAndIconView2.N.mHighestSpeed = currentTask.mDownloadSpeed;
            } else if (currentTask.mDownloadSpeed > downloadTaskNameAndIconView2.N.mHighestSpeed) {
                downloadTaskNameAndIconView2.N.mHighestSpeed = currentTask.mDownloadSpeed;
            }
            if (downloadTaskNameAndIconView2.N.mHighestSpeed < j) {
                downloadTaskNameAndIconView2.N.mHighestSpeed = j + (j / 3);
            }
            new StringBuilder(" High speed: ").append(downloadTaskNameAndIconView2.N.mHighestSpeed);
            if (downloadTaskNameAndIconView2.N.mHighestSpeed == 0) {
                a = "--";
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(ConvertUtil.byteConvert(downloadTaskNameAndIconView2.N.mHighestSpeed));
                stringBuilder.append("/s");
                a = stringBuilder.toString();
            }
            downloadTaskNameAndIconView2.n.setText(a);
            currentTask = downloadTaskNameAndIconView2.M;
            a2 = "";
            if (currentTask.mDownloadedSize > 0) {
            }
            z = false;
            a = a2;
            if (TextUtils.isEmpty(a)) {
                a = "--";
            }
            if (z) {
                downloadTaskNameAndIconView2.o.setTextColor(downloadTaskNameAndIconView2.K.getResources().getColor(R.color.download_list_detail_color_t4));
            } else {
                downloadTaskNameAndIconView2.o.setTextColor(downloadTaskNameAndIconView2.K.getResources().getColor(R.color.download_list_detail_color_t3));
            }
            downloadTaskNameAndIconView2.o.setText(a);
            currentTask = downloadTaskNameAndIconView2.M;
            if (2 == currentTask.getTaskStatus()) {
                downloadTaskNameAndIconView2.r.setVisibility(0);
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(String.valueOf(currentTask.mResLinkUsed));
                stringBuilder2.append("/");
                stringBuilder2.append(String.valueOf(currentTask.mResLinkTotal));
                downloadTaskNameAndIconView2.p.setText(stringBuilder2.toString());
            }
            currentTask = downloadTaskNameAndIconView2.M;
            if (currentTask.mFileSize > 0) {
                c = com.xunlei.downloadprovider.download.util.a.c(currentTask.mFileSize);
            } else {
                c = downloadTaskNameAndIconView2.getContext().getString(R.string.download_item_task_unknown_filesize);
            }
            downloadTaskNameAndIconView2.s.setText(c);
            if (8 != currentTask.getTaskStatus()) {
                downloadTaskNameAndIconView2.u.setVisibility(0);
                if (currentTask.mFileSize == 0) {
                    downloadTaskNameAndIconView2.t.setText("--");
                } else {
                    i2 = (int) ((((float) currentTask.mDownloadedSize) / ((float) currentTask.mFileSize)) * 100.0f);
                    textView = downloadTaskNameAndIconView2.t;
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(i2);
                    stringBuilder2.append("%");
                    textView.setText(stringBuilder2.toString());
                }
                i3 = 8;
            } else {
                i3 = 8;
                downloadTaskNameAndIconView2.u.setVisibility(8);
            }
            currentTask = downloadTaskNameAndIconView2.M;
            if (currentTask.getTaskStatus() != i3) {
                downloadTaskNameAndIconView2.w.setText("--");
            } else {
                downloadTaskNameAndIconView2.w.setText(DateTimeUtil.formatTimeWithDefault(currentTask.mLastModifiedTime));
            }
            a = downloadTaskInfo.getTaskDownloadUrl();
            if (!a.startsWith("thunder:")) {
                a = a.substring(8);
            } else if (a.startsWith("thunder")) {
                a = a.substring(7);
            }
            downloadTaskNameAndIconView2.A.setText(a);
            downloadTaskNameAndIconView2.a();
        }
    }
}
