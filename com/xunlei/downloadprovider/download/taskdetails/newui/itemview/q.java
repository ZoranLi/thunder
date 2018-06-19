package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.message.proguard.k;
import com.xunlei.common.androidutil.DateTimeUtil;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.download.DownloadManager;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.taskdetails.ag;
import com.xunlei.downloadprovider.download.taskdetails.items.a.a;
import com.xunlei.downloadprovider.download.taskdetails.items.a.b;
import com.xunlei.downloadprovider.download.taskdetails.newui.DownloadDetailsActivity;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.DownloadError.SpeedupFailureCode;

/* compiled from: DetailTaskBasicInfoViewHolder_New */
public final class q extends b {
    public final DownloadTaskNameAndIconView_New a;

    public static View a(Context context) {
        return new DownloadTaskNameAndIconView_New(context);
    }

    public q(View view) {
        super(view);
        this.a = (DownloadTaskNameAndIconView_New) view;
    }

    public final void a() {
        if (this.a != null) {
            DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New = this.a;
            if (!(downloadTaskNameAndIconView_New.M == null || downloadTaskNameAndIconView_New.F == null)) {
                downloadTaskNameAndIconView_New.O = com.xunlei.downloadprovider.web.website.g.b.a().a(downloadTaskNameAndIconView_New.G);
                if (downloadTaskNameAndIconView_New.O) {
                    downloadTaskNameAndIconView_New.F.setSelected(true);
                    return;
                }
                downloadTaskNameAndIconView_New.F.setSelected(false);
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
        r1.a.setDownloadVodPlayerController(r1.h);
        DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New = r1.a;
        if (!(downloadTaskInfo == null || downloadTaskInfo == downloadTaskNameAndIconView_New.M)) {
            boolean z;
            if (!(downloadTaskInfo == null || TextUtils.isEmpty(downloadTaskInfo.mWebsiteName))) {
                if (!TextUtils.isEmpty(downloadTaskInfo.mRefUrl)) {
                    downloadTaskNameAndIconView_New.G = downloadTaskInfo.mRefUrl;
                } else if (!(downloadTaskInfo.mExtraInfo == null || TextUtils.isEmpty(downloadTaskInfo.mExtraInfo.mRefUrl))) {
                    downloadTaskNameAndIconView_New.G = downloadTaskInfo.mExtraInfo.mRefUrl;
                }
                if (!TextUtils.isEmpty(downloadTaskNameAndIconView_New.G)) {
                    z = true;
                    if (!z && downloadTaskNameAndIconView_New.v != null) {
                        downloadTaskNameAndIconView_New.v.setVisibility(0);
                        if (downloadTaskNameAndIconView_New.v.getVisibility() == 0) {
                            if (TextUtils.isEmpty(downloadTaskInfo.mWebsiteName)) {
                                downloadTaskNameAndIconView_New.E.setVisibility(8);
                            } else {
                                downloadTaskNameAndIconView_New.E.setVisibility(0);
                                downloadTaskNameAndIconView_New.E.setText(downloadTaskInfo.mWebsiteName);
                            }
                            if (!TextUtils.isEmpty(downloadTaskNameAndIconView_New.G)) {
                                downloadTaskNameAndIconView_New.D.setText(downloadTaskNameAndIconView_New.G);
                            }
                            downloadTaskNameAndIconView_New.O = com.xunlei.downloadprovider.web.website.g.b.a().a(downloadTaskNameAndIconView_New.G);
                            if (downloadTaskNameAndIconView_New.O) {
                                downloadTaskNameAndIconView_New.F.setSelected(true);
                            } else {
                                downloadTaskNameAndIconView_New.F.setSelected(false);
                            }
                        }
                    } else if (downloadTaskNameAndIconView_New.v != null) {
                        downloadTaskNameAndIconView_New.v.setVisibility(8);
                    }
                }
            }
            z = false;
            if (!z) {
            }
            if (downloadTaskNameAndIconView_New.v != null) {
                downloadTaskNameAndIconView_New.v.setVisibility(8);
            }
        }
        r1.a.setControl(r1.g);
        r1.a.setAdapter(r1.f);
        r1.a.setTaskSpeedCountInfo((TaskSpeedCountInfo) aVar2.a(TaskSpeedCountInfo.class));
        DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New2 = r1.a;
        if (downloadTaskInfo != null) {
            boolean z2;
            DownloadTaskNameAndIconView_New.a(downloadTaskInfo, downloadTaskNameAndIconView_New2.getContext(), downloadTaskNameAndIconView_New2.b);
            if (downloadTaskNameAndIconView_New2.a.getVisibility() == 0) {
                ImageView imageView = downloadTaskNameAndIconView_New2.a;
                if (downloadTaskNameAndIconView_New2.P == 0) {
                    if (downloadTaskNameAndIconView_New2.I != null) {
                        downloadTaskNameAndIconView_New2.I.a(8);
                    }
                    com.xunlei.downloadprovider.download.util.a.a.a();
                    com.xunlei.downloadprovider.download.util.a.a.b(downloadTaskInfo, imageView);
                } else {
                    if (downloadTaskNameAndIconView_New2.I != null) {
                        downloadTaskNameAndIconView_New2.I.a(8);
                    }
                    if (downloadTaskNameAndIconView_New2.M == null || downloadTaskInfo != downloadTaskNameAndIconView_New2.M) {
                        com.xunlei.downloadprovider.download.util.a.a.a();
                        com.xunlei.downloadprovider.download.util.a.a.a(downloadTaskInfo, imageView);
                    }
                    com.xunlei.downloadprovider.download.util.a.a.a();
                    com.xunlei.downloadprovider.download.util.a.a.a(downloadTaskInfo, imageView, downloadTaskNameAndIconView_New2.I, com.xunlei.downloadprovider.download.b.b.f(), downloadTaskNameAndIconView_New2.Q);
                }
            }
            TextView textView = downloadTaskNameAndIconView_New2.c;
            TextView textView2 = downloadTaskNameAndIconView_New2.f;
            if (downloadTaskInfo.mFileSize > 0) {
                textView.setText(com.xunlei.downloadprovider.download.util.a.c(downloadTaskInfo.mFileSize));
            } else {
                textView.setText(R.string.download_item_task_unknown_filesize);
            }
            if (TextUtils.isEmpty(downloadTaskInfo.mEpisodeTagText)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(downloadTaskInfo.mEpisodeTagText);
            }
            if (downloadTaskInfo.getTaskStatus() == 8) {
                downloadTaskNameAndIconView_New2.J.setText(R.string.download_item_task_download_finish);
            } else {
                downloadTaskNameAndIconView_New2.J.setText(R.string.download_item_task_downloaded_can_play);
            }
            DownloadDetailsActivity a = DownloadDetailsActivity.a(downloadTaskNameAndIconView_New2.H);
            if (a != null) {
                z2 = a.a.j;
            } else {
                z2 = true;
            }
            downloadTaskNameAndIconView_New2.setIconImageViewVisible(z2);
        }
        downloadTaskNameAndIconView_New2 = r1.a;
        com.xunlei.downloadprovider.download.control.a aVar3 = r1.g;
        ag agVar = r1.f;
        if (downloadTaskInfo != null) {
            CharSequence string;
            String format;
            StringBuilder stringBuilder;
            long j;
            StringBuilder stringBuilder2;
            Object obj;
            StringBuilder stringBuilder3;
            CharSequence c;
            int i;
            TextView textView3;
            int i2;
            downloadTaskNameAndIconView_New2.M = downloadTaskInfo;
            TaskInfo taskInfo = downloadTaskNameAndIconView_New2.M;
            downloadTaskNameAndIconView_New2.i.setVisibility(8);
            downloadTaskNameAndIconView_New2.g.setVisibility(8);
            if (taskInfo != null) {
                downloadTaskNameAndIconView_New2.i.setTextColor(downloadTaskNameAndIconView_New2.getContext().getResources().getColor(R.color.download_list_detail_color_t1));
                downloadTaskNameAndIconView_New2.i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                if (taskInfo.getTaskStatus() == 8) {
                    downloadTaskNameAndIconView_New2.g.setVisibility(8);
                    downloadTaskNameAndIconView_New2.i.setVisibility(0);
                    if (taskInfo.mIsFileMissing) {
                        downloadTaskNameAndIconView_New2.i.setTextColor(downloadTaskNameAndIconView_New2.getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColor));
                        downloadTaskNameAndIconView_New2.i.setText(R.string.download_item_task_file_not_exist);
                    } else {
                        downloadTaskNameAndIconView_New2.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_task_detail_download_success, 0, 0, 0);
                        downloadTaskNameAndIconView_New2.i.setTextColor(downloadTaskNameAndIconView_New2.getResources().getColor(R.color.common_blue_button_normal));
                        downloadTaskNameAndIconView_New2.i.setText(R.string.download_item_task_download_finish);
                    }
                } else if (4 == taskInfo.getTaskStatus()) {
                    downloadTaskNameAndIconView_New2.i.setVisibility(0);
                    downloadTaskNameAndIconView_New2.i.setText(downloadTaskNameAndIconView_New2.getContext().getResources().getString(R.string.download_item_task_status_paused));
                } else if (2 == taskInfo.getTaskStatus()) {
                    downloadTaskNameAndIconView_New2.g.setVisibility(0);
                    if (taskInfo.mDownloadSpeed < 1) {
                        downloadTaskNameAndIconView_New2.g.setText(R.string.download_item_task_status_linking);
                    } else {
                        if (!taskInfo.mHasVipChannelSpeedup) {
                            if (taskInfo.mVipAcceleratedSpeed <= 100) {
                                if (taskInfo.mDownloadSpeed < 1) {
                                    string = downloadTaskNameAndIconView_New2.getContext().getString(R.string.download_item_task_status_linking);
                                } else {
                                    string = com.xunlei.downloadprovider.download.util.a.a(taskInfo.mDownloadSpeed);
                                }
                                downloadTaskNameAndIconView_New2.g.setText(string);
                            }
                        }
                        String a2 = com.xunlei.downloadprovider.download.util.a.a(taskInfo.mDownloadSpeed);
                        SpeedupFailureCode b = DownloadError.b(taskInfo);
                        CharSequence spannableString;
                        if (b == null || taskInfo.mVipAcceleratedSpeed >= 100) {
                            format = String.format("(+ %s)", new Object[]{com.xunlei.downloadprovider.download.util.a.a(taskInfo.mVipAcceleratedSpeed)});
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(a2);
                            stringBuilder.append(format);
                            a2 = stringBuilder.toString();
                            spannableString = new SpannableString(a2);
                            spannableString.setSpan(new ForegroundColorSpan(downloadTaskNameAndIconView_New2.getContext().getResources().getColor(R.color.common_blue_button_normal)), a2.length() - format.length(), a2.length(), 34);
                            spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(14.0f)), a2.length() - format.length(), a2.length(), 34);
                            downloadTaskNameAndIconView_New2.g.setText(spannableString);
                        } else {
                            if (b == SpeedupFailureCode.SENSITIVE_RESOURCE_LIMITED) {
                                format = downloadTaskNameAndIconView_New2.getResources().getString(R.string.download_item_task_speedup_fail_sensitive_resource_limited);
                            } else {
                                format = downloadTaskNameAndIconView_New2.getResources().getString(R.string.download_item_task_speedup_fail);
                            }
                            stringBuilder = new StringBuilder(k.s);
                            stringBuilder.append(format);
                            stringBuilder.append(k.t);
                            format = stringBuilder.toString();
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(a2);
                            stringBuilder.append(format);
                            a2 = stringBuilder.toString();
                            spannableString = new SpannableString(a2);
                            spannableString.setSpan(new ForegroundColorSpan(downloadTaskNameAndIconView_New2.getResources().getColor(R.color.DownloadTaskItemSpeedupErrorStatusTextColor)), a2.length() - format.length(), a2.length(), 34);
                            spannableString.setSpan(new AbsoluteSizeSpan(DipPixelUtil.dip2px(12.0f)), a2.length() - format.length(), a2.length(), 34);
                            downloadTaskNameAndIconView_New2.g.setText(spannableString);
                        }
                    }
                } else if (taskInfo.getTaskStatus() == 16) {
                    downloadTaskNameAndIconView_New2.i.setVisibility(0);
                    string = DownloadError.a(taskInfo, downloadTaskNameAndIconView_New2.getContext());
                    downloadTaskNameAndIconView_New2.i.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_task_detail_download_failed, 0, 0, 0);
                    downloadTaskNameAndIconView_New2.i.setText(string);
                } else if (taskInfo.getTaskStatus() == 1) {
                    downloadTaskNameAndIconView_New2.i.setVisibility(0);
                    downloadTaskNameAndIconView_New2.i.setText(downloadTaskNameAndIconView_New2.getContext().getResources().getString(R.string.download_item_task_status_waiting));
                } else {
                    downloadTaskNameAndIconView_New2.i.setVisibility(8);
                    downloadTaskNameAndIconView_New2.g.setVisibility(8);
                }
            }
            currentTask = downloadTaskNameAndIconView_New2.M;
            if (currentTask.getTaskStatus() == 8) {
                long j2;
                if (currentTask.mDownloadedSize != 0) {
                    try {
                        j = (long) ((((((float) (currentTask.mDcdnReceivedSize + currentTask.mVipChannelReceivedSize)) * 1.0f) / ((float) currentTask.mDownloadedSize)) * ((float) currentTask.mDownloadDurationTime)) / 1000.0f);
                        j2 = 0;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (j > j2) {
                        string = DateTimeUtil.getTimeString((int) j, downloadTaskNameAndIconView_New2.getContext());
                        if (string.contains("-")) {
                            string = "--";
                        }
                        downloadTaskNameAndIconView_New2.o.setText(string);
                        downloadTaskNameAndIconView_New2.k.setText(DateTimeUtil.formatTimeWithDefault(downloadTaskNameAndIconView_New2.M.mCreateTime));
                        currentTask = downloadTaskNameAndIconView_New2.M;
                        j = (currentTask.mDownloadedSize > 0 || currentTask.mDownloadDurationTime <= 0) ? 0 : (long) (((((float) currentTask.mDownloadedSize) * 1.0f) / ((float) currentTask.mDownloadDurationTime)) * 1000.0f);
                        if (downloadTaskNameAndIconView_New2.N != null) {
                            downloadTaskNameAndIconView_New2.N = new TaskSpeedCountInfo();
                            downloadTaskNameAndIconView_New2.N.mHighestSpeed = currentTask.mDownloadSpeed;
                        } else if (currentTask.mDownloadSpeed > downloadTaskNameAndIconView_New2.N.mHighestSpeed) {
                            downloadTaskNameAndIconView_New2.N.mHighestSpeed = currentTask.mDownloadSpeed;
                        }
                        if (downloadTaskNameAndIconView_New2.N.mHighestSpeed < j) {
                            downloadTaskNameAndIconView_New2.N.mHighestSpeed = j + (j / 3);
                        }
                        new StringBuilder(" High speed: ").append(downloadTaskNameAndIconView_New2.N.mHighestSpeed);
                        if (downloadTaskNameAndIconView_New2.N.mHighestSpeed == 0) {
                            string = "--";
                        } else {
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(ConvertUtil.byteConvert(downloadTaskNameAndIconView_New2.N.mHighestSpeed));
                            stringBuilder2.append("/s");
                            string = stringBuilder2.toString();
                        }
                        downloadTaskNameAndIconView_New2.l.setText(string);
                        currentTask = downloadTaskNameAndIconView_New2.M;
                        format = "";
                        if (currentTask.mDownloadedSize > 0 || currentTask.mDownloadDurationTime <= 0) {
                            string = format;
                        } else {
                            j2 = (long) (((((float) currentTask.mDownloadedSize) * 1.0f) / ((float) currentTask.mDownloadDurationTime)) * 1000.0f);
                            stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(ConvertUtil.byteConvert(j2));
                            stringBuilder2.append("/s");
                            string = stringBuilder2.toString();
                            if (j2 >= DownloadManager.MAX_BYTES_OVER_MOBILE) {
                                obj = 1;
                                if (TextUtils.isEmpty(string)) {
                                    string = "--";
                                }
                                if (obj == null) {
                                    downloadTaskNameAndIconView_New2.m.setTextColor(downloadTaskNameAndIconView_New2.H.getResources().getColor(R.color.download_list_detail_color_t4));
                                } else {
                                    downloadTaskNameAndIconView_New2.m.setTextColor(downloadTaskNameAndIconView_New2.H.getResources().getColor(R.color.download_list_detail_color_t3));
                                }
                                downloadTaskNameAndIconView_New2.m.setText(string);
                                currentTask = downloadTaskNameAndIconView_New2.M;
                                if (2 == currentTask.getTaskStatus()) {
                                    downloadTaskNameAndIconView_New2.p.setVisibility(0);
                                    stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append(String.valueOf(currentTask.mResLinkUsed));
                                    stringBuilder3.append("/");
                                    stringBuilder3.append(String.valueOf(currentTask.mResLinkTotal));
                                    downloadTaskNameAndIconView_New2.n.setText(stringBuilder3.toString());
                                }
                                currentTask = downloadTaskNameAndIconView_New2.M;
                                if (currentTask.mFileSize <= 0) {
                                    c = com.xunlei.downloadprovider.download.util.a.c(currentTask.mFileSize);
                                } else {
                                    c = downloadTaskNameAndIconView_New2.getContext().getString(R.string.download_item_task_unknown_filesize);
                                }
                                downloadTaskNameAndIconView_New2.q.setText(c);
                                if (8 == currentTask.getTaskStatus()) {
                                    downloadTaskNameAndIconView_New2.s.setVisibility(0);
                                    if (currentTask.mFileSize != 0) {
                                        downloadTaskNameAndIconView_New2.r.setText("--");
                                    } else {
                                        i = (int) ((((float) currentTask.mDownloadedSize) / ((float) currentTask.mFileSize)) * 100.0f);
                                        textView3 = downloadTaskNameAndIconView_New2.r;
                                        stringBuilder = new StringBuilder();
                                        stringBuilder.append(i);
                                        stringBuilder.append("%");
                                        textView3.setText(stringBuilder.toString());
                                    }
                                    i2 = 8;
                                } else {
                                    i2 = 8;
                                    downloadTaskNameAndIconView_New2.s.setVisibility(8);
                                }
                                currentTask = downloadTaskNameAndIconView_New2.M;
                                if (currentTask.getTaskStatus() == i2) {
                                    downloadTaskNameAndIconView_New2.u.setText("--");
                                } else {
                                    downloadTaskNameAndIconView_New2.u.setText(DateTimeUtil.formatTimeWithDefault(currentTask.mLastModifiedTime));
                                }
                                string = downloadTaskInfo.getTaskDownloadUrl();
                                if (!string.startsWith("thunder:")) {
                                    string = string.substring(8);
                                } else if (string.startsWith("thunder")) {
                                    string = string.substring(7);
                                }
                                downloadTaskNameAndIconView_New2.x.setText(string);
                                downloadTaskNameAndIconView_New2.a();
                                downloadTaskNameAndIconView_New2.K.setTaskProgress(downloadTaskInfo);
                                downloadTaskNameAndIconView_New2.h.setVisibility(downloadTaskNameAndIconView_New2.K.getVisibility());
                                downloadTaskNameAndIconView_New2.h.setText(downloadTaskNameAndIconView_New2.H.getString(R.string.task_detail_download_progress_text, new Object[]{Integer.valueOf(downloadTaskNameAndIconView_New2.K.getProgress())}));
                                downloadTaskNameAndIconView_New2.L.a(downloadTaskNameAndIconView_New2.M, aVar3, agVar);
                            }
                        }
                        obj = null;
                        if (TextUtils.isEmpty(string)) {
                            string = "--";
                        }
                        if (obj == null) {
                            downloadTaskNameAndIconView_New2.m.setTextColor(downloadTaskNameAndIconView_New2.H.getResources().getColor(R.color.download_list_detail_color_t3));
                        } else {
                            downloadTaskNameAndIconView_New2.m.setTextColor(downloadTaskNameAndIconView_New2.H.getResources().getColor(R.color.download_list_detail_color_t4));
                        }
                        downloadTaskNameAndIconView_New2.m.setText(string);
                        currentTask = downloadTaskNameAndIconView_New2.M;
                        if (2 == currentTask.getTaskStatus()) {
                            downloadTaskNameAndIconView_New2.p.setVisibility(0);
                            stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(String.valueOf(currentTask.mResLinkUsed));
                            stringBuilder3.append("/");
                            stringBuilder3.append(String.valueOf(currentTask.mResLinkTotal));
                            downloadTaskNameAndIconView_New2.n.setText(stringBuilder3.toString());
                        }
                        currentTask = downloadTaskNameAndIconView_New2.M;
                        if (currentTask.mFileSize <= 0) {
                            c = downloadTaskNameAndIconView_New2.getContext().getString(R.string.download_item_task_unknown_filesize);
                        } else {
                            c = com.xunlei.downloadprovider.download.util.a.c(currentTask.mFileSize);
                        }
                        downloadTaskNameAndIconView_New2.q.setText(c);
                        if (8 == currentTask.getTaskStatus()) {
                            i2 = 8;
                            downloadTaskNameAndIconView_New2.s.setVisibility(8);
                        } else {
                            downloadTaskNameAndIconView_New2.s.setVisibility(0);
                            if (currentTask.mFileSize != 0) {
                                i = (int) ((((float) currentTask.mDownloadedSize) / ((float) currentTask.mFileSize)) * 100.0f);
                                textView3 = downloadTaskNameAndIconView_New2.r;
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(i);
                                stringBuilder.append("%");
                                textView3.setText(stringBuilder.toString());
                            } else {
                                downloadTaskNameAndIconView_New2.r.setText("--");
                            }
                            i2 = 8;
                        }
                        currentTask = downloadTaskNameAndIconView_New2.M;
                        if (currentTask.getTaskStatus() == i2) {
                            downloadTaskNameAndIconView_New2.u.setText(DateTimeUtil.formatTimeWithDefault(currentTask.mLastModifiedTime));
                        } else {
                            downloadTaskNameAndIconView_New2.u.setText("--");
                        }
                        string = downloadTaskInfo.getTaskDownloadUrl();
                        if (!string.startsWith("thunder:")) {
                            string = string.substring(8);
                        } else if (string.startsWith("thunder")) {
                            string = string.substring(7);
                        }
                        downloadTaskNameAndIconView_New2.x.setText(string);
                        downloadTaskNameAndIconView_New2.a();
                        downloadTaskNameAndIconView_New2.K.setTaskProgress(downloadTaskInfo);
                        downloadTaskNameAndIconView_New2.h.setVisibility(downloadTaskNameAndIconView_New2.K.getVisibility());
                        downloadTaskNameAndIconView_New2.h.setText(downloadTaskNameAndIconView_New2.H.getString(R.string.task_detail_download_progress_text, new Object[]{Integer.valueOf(downloadTaskNameAndIconView_New2.K.getProgress())}));
                        downloadTaskNameAndIconView_New2.L.a(downloadTaskNameAndIconView_New2.M, aVar3, agVar);
                    }
                }
                j2 = 0;
                j = 0;
                if (j > j2) {
                    string = DateTimeUtil.getTimeString((int) j, downloadTaskNameAndIconView_New2.getContext());
                    if (string.contains("-")) {
                        string = "--";
                    }
                    downloadTaskNameAndIconView_New2.o.setText(string);
                    downloadTaskNameAndIconView_New2.k.setText(DateTimeUtil.formatTimeWithDefault(downloadTaskNameAndIconView_New2.M.mCreateTime));
                    currentTask = downloadTaskNameAndIconView_New2.M;
                    if (currentTask.mDownloadedSize > 0) {
                    }
                    if (downloadTaskNameAndIconView_New2.N != null) {
                        downloadTaskNameAndIconView_New2.N = new TaskSpeedCountInfo();
                        downloadTaskNameAndIconView_New2.N.mHighestSpeed = currentTask.mDownloadSpeed;
                    } else if (currentTask.mDownloadSpeed > downloadTaskNameAndIconView_New2.N.mHighestSpeed) {
                        downloadTaskNameAndIconView_New2.N.mHighestSpeed = currentTask.mDownloadSpeed;
                    }
                    if (downloadTaskNameAndIconView_New2.N.mHighestSpeed < j) {
                        downloadTaskNameAndIconView_New2.N.mHighestSpeed = j + (j / 3);
                    }
                    new StringBuilder(" High speed: ").append(downloadTaskNameAndIconView_New2.N.mHighestSpeed);
                    if (downloadTaskNameAndIconView_New2.N.mHighestSpeed == 0) {
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(ConvertUtil.byteConvert(downloadTaskNameAndIconView_New2.N.mHighestSpeed));
                        stringBuilder2.append("/s");
                        string = stringBuilder2.toString();
                    } else {
                        string = "--";
                    }
                    downloadTaskNameAndIconView_New2.l.setText(string);
                    currentTask = downloadTaskNameAndIconView_New2.M;
                    format = "";
                    if (currentTask.mDownloadedSize > 0) {
                    }
                    string = format;
                    obj = null;
                    if (TextUtils.isEmpty(string)) {
                        string = "--";
                    }
                    if (obj == null) {
                        downloadTaskNameAndIconView_New2.m.setTextColor(downloadTaskNameAndIconView_New2.H.getResources().getColor(R.color.download_list_detail_color_t4));
                    } else {
                        downloadTaskNameAndIconView_New2.m.setTextColor(downloadTaskNameAndIconView_New2.H.getResources().getColor(R.color.download_list_detail_color_t3));
                    }
                    downloadTaskNameAndIconView_New2.m.setText(string);
                    currentTask = downloadTaskNameAndIconView_New2.M;
                    if (2 == currentTask.getTaskStatus()) {
                        downloadTaskNameAndIconView_New2.p.setVisibility(0);
                        stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(String.valueOf(currentTask.mResLinkUsed));
                        stringBuilder3.append("/");
                        stringBuilder3.append(String.valueOf(currentTask.mResLinkTotal));
                        downloadTaskNameAndIconView_New2.n.setText(stringBuilder3.toString());
                    }
                    currentTask = downloadTaskNameAndIconView_New2.M;
                    if (currentTask.mFileSize <= 0) {
                        c = com.xunlei.downloadprovider.download.util.a.c(currentTask.mFileSize);
                    } else {
                        c = downloadTaskNameAndIconView_New2.getContext().getString(R.string.download_item_task_unknown_filesize);
                    }
                    downloadTaskNameAndIconView_New2.q.setText(c);
                    if (8 == currentTask.getTaskStatus()) {
                        downloadTaskNameAndIconView_New2.s.setVisibility(0);
                        if (currentTask.mFileSize != 0) {
                            downloadTaskNameAndIconView_New2.r.setText("--");
                        } else {
                            i = (int) ((((float) currentTask.mDownloadedSize) / ((float) currentTask.mFileSize)) * 100.0f);
                            textView3 = downloadTaskNameAndIconView_New2.r;
                            stringBuilder = new StringBuilder();
                            stringBuilder.append(i);
                            stringBuilder.append("%");
                            textView3.setText(stringBuilder.toString());
                        }
                        i2 = 8;
                    } else {
                        i2 = 8;
                        downloadTaskNameAndIconView_New2.s.setVisibility(8);
                    }
                    currentTask = downloadTaskNameAndIconView_New2.M;
                    if (currentTask.getTaskStatus() == i2) {
                        downloadTaskNameAndIconView_New2.u.setText("--");
                    } else {
                        downloadTaskNameAndIconView_New2.u.setText(DateTimeUtil.formatTimeWithDefault(currentTask.mLastModifiedTime));
                    }
                    string = downloadTaskInfo.getTaskDownloadUrl();
                    if (!string.startsWith("thunder:")) {
                        string = string.substring(8);
                    } else if (string.startsWith("thunder")) {
                        string = string.substring(7);
                    }
                    downloadTaskNameAndIconView_New2.x.setText(string);
                    downloadTaskNameAndIconView_New2.a();
                    downloadTaskNameAndIconView_New2.K.setTaskProgress(downloadTaskInfo);
                    downloadTaskNameAndIconView_New2.h.setVisibility(downloadTaskNameAndIconView_New2.K.getVisibility());
                    downloadTaskNameAndIconView_New2.h.setText(downloadTaskNameAndIconView_New2.H.getString(R.string.task_detail_download_progress_text, new Object[]{Integer.valueOf(downloadTaskNameAndIconView_New2.K.getProgress())}));
                    downloadTaskNameAndIconView_New2.L.a(downloadTaskNameAndIconView_New2.M, aVar3, agVar);
                }
            }
            string = "--";
            downloadTaskNameAndIconView_New2.o.setText(string);
            downloadTaskNameAndIconView_New2.k.setText(DateTimeUtil.formatTimeWithDefault(downloadTaskNameAndIconView_New2.M.mCreateTime));
            currentTask = downloadTaskNameAndIconView_New2.M;
            if (currentTask.mDownloadedSize > 0) {
            }
            if (downloadTaskNameAndIconView_New2.N != null) {
                downloadTaskNameAndIconView_New2.N = new TaskSpeedCountInfo();
                downloadTaskNameAndIconView_New2.N.mHighestSpeed = currentTask.mDownloadSpeed;
            } else if (currentTask.mDownloadSpeed > downloadTaskNameAndIconView_New2.N.mHighestSpeed) {
                downloadTaskNameAndIconView_New2.N.mHighestSpeed = currentTask.mDownloadSpeed;
            }
            if (downloadTaskNameAndIconView_New2.N.mHighestSpeed < j) {
                downloadTaskNameAndIconView_New2.N.mHighestSpeed = j + (j / 3);
            }
            new StringBuilder(" High speed: ").append(downloadTaskNameAndIconView_New2.N.mHighestSpeed);
            if (downloadTaskNameAndIconView_New2.N.mHighestSpeed == 0) {
                string = "--";
            } else {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(ConvertUtil.byteConvert(downloadTaskNameAndIconView_New2.N.mHighestSpeed));
                stringBuilder2.append("/s");
                string = stringBuilder2.toString();
            }
            downloadTaskNameAndIconView_New2.l.setText(string);
            currentTask = downloadTaskNameAndIconView_New2.M;
            format = "";
            if (currentTask.mDownloadedSize > 0) {
            }
            string = format;
            obj = null;
            if (TextUtils.isEmpty(string)) {
                string = "--";
            }
            if (obj == null) {
                downloadTaskNameAndIconView_New2.m.setTextColor(downloadTaskNameAndIconView_New2.H.getResources().getColor(R.color.download_list_detail_color_t3));
            } else {
                downloadTaskNameAndIconView_New2.m.setTextColor(downloadTaskNameAndIconView_New2.H.getResources().getColor(R.color.download_list_detail_color_t4));
            }
            downloadTaskNameAndIconView_New2.m.setText(string);
            currentTask = downloadTaskNameAndIconView_New2.M;
            if (2 == currentTask.getTaskStatus()) {
                downloadTaskNameAndIconView_New2.p.setVisibility(0);
                stringBuilder3 = new StringBuilder();
                stringBuilder3.append(String.valueOf(currentTask.mResLinkUsed));
                stringBuilder3.append("/");
                stringBuilder3.append(String.valueOf(currentTask.mResLinkTotal));
                downloadTaskNameAndIconView_New2.n.setText(stringBuilder3.toString());
            }
            currentTask = downloadTaskNameAndIconView_New2.M;
            if (currentTask.mFileSize <= 0) {
                c = downloadTaskNameAndIconView_New2.getContext().getString(R.string.download_item_task_unknown_filesize);
            } else {
                c = com.xunlei.downloadprovider.download.util.a.c(currentTask.mFileSize);
            }
            downloadTaskNameAndIconView_New2.q.setText(c);
            if (8 == currentTask.getTaskStatus()) {
                i2 = 8;
                downloadTaskNameAndIconView_New2.s.setVisibility(8);
            } else {
                downloadTaskNameAndIconView_New2.s.setVisibility(0);
                if (currentTask.mFileSize != 0) {
                    i = (int) ((((float) currentTask.mDownloadedSize) / ((float) currentTask.mFileSize)) * 100.0f);
                    textView3 = downloadTaskNameAndIconView_New2.r;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(i);
                    stringBuilder.append("%");
                    textView3.setText(stringBuilder.toString());
                } else {
                    downloadTaskNameAndIconView_New2.r.setText("--");
                }
                i2 = 8;
            }
            currentTask = downloadTaskNameAndIconView_New2.M;
            if (currentTask.getTaskStatus() == i2) {
                downloadTaskNameAndIconView_New2.u.setText(DateTimeUtil.formatTimeWithDefault(currentTask.mLastModifiedTime));
            } else {
                downloadTaskNameAndIconView_New2.u.setText("--");
            }
            string = downloadTaskInfo.getTaskDownloadUrl();
            if (!string.startsWith("thunder:")) {
                string = string.substring(8);
            } else if (string.startsWith("thunder")) {
                string = string.substring(7);
            }
            downloadTaskNameAndIconView_New2.x.setText(string);
            downloadTaskNameAndIconView_New2.a();
            downloadTaskNameAndIconView_New2.K.setTaskProgress(downloadTaskInfo);
            downloadTaskNameAndIconView_New2.h.setVisibility(downloadTaskNameAndIconView_New2.K.getVisibility());
            downloadTaskNameAndIconView_New2.h.setText(downloadTaskNameAndIconView_New2.H.getString(R.string.task_detail_download_progress_text, new Object[]{Integer.valueOf(downloadTaskNameAndIconView_New2.K.getProgress())}));
            downloadTaskNameAndIconView_New2.L.a(downloadTaskNameAndIconView_New2.M, aVar3, agVar);
        }
    }
}
