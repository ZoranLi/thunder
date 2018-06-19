package com.xunlei.downloadprovider.personal.playrecord;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.BTSubTaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.h.a.a.b;
import com.xunlei.downloadprovider.personal.playrecord.VideoPlayRecord.RECORD_TYPE;
import com.xunlei.xllib.b.d;
import com.xunlei.xllib.b.k;
import java.util.regex.Pattern;

/* compiled from: PlayRecordListItemViewHolder */
class ag {
    private final View a;
    protected View d = null;
    protected ImageView e = null;
    protected TextView f = null;
    protected TextView g = null;
    protected View h = null;
    protected TextView i = null;
    protected View j = null;
    protected ImageView k = null;
    protected RelativeLayout l = null;
    protected TextView m;
    protected View n = null;
    protected ImageView o = null;
    protected View p = null;
    protected TextView q = null;

    public ag(View view) {
        this.a = view;
        this.h = view.findViewById(R.id.play_record_list_item_btn_right);
        this.i = (TextView) view.findViewById(R.id.play_record_list_item_btn_right_text);
        this.e = (ImageView) view.findViewById(R.id.play_record_list_item_icon);
        this.g = (TextView) view.findViewById(R.id.play_record_list_item_filesize);
        this.f = (TextView) view.findViewById(R.id.play_record_list_item_name);
        this.d = view.findViewById(R.id.play_record_list_item_layout);
        this.j = view.findViewById(R.id.play_record_list_item_btn_select);
        this.k = (ImageView) view.findViewById(R.id.play_record_list_item_btn_select_icon);
        this.l = (RelativeLayout) view.findViewById(R.id.rl_play_record_title_layout);
        this.m = (TextView) view.findViewById(R.id.title);
        this.n = view.findViewById(R.id.view_0);
        this.p = view.findViewById(R.id.view_1);
        this.o = (ImageView) view.findViewById(R.id.image);
        this.q = (TextView) view.findViewById(R.id.divider_line);
    }

    public Context a() {
        return this.a.getContext();
    }

    private String a(int i) {
        return a().getResources().getString(i);
    }

    protected final void a(String str, @DrawableRes int i) {
        if (this.i != null) {
            this.i.setText(str);
            if (VERSION.SDK_INT >= 21) {
                if (i != -1) {
                    str = a().getResources().getDrawable(i, null);
                    if (str != null) {
                        str.setBounds(0, 0, str.getMinimumWidth(), str.getMinimumHeight());
                        this.i.setPadding(DipPixelUtil.dip2px(8.0f), this.i.getPaddingTop(), 0, this.i.getPaddingBottom());
                        this.i.setGravity(8388627);
                        this.i.setCompoundDrawables(str, null, null, null);
                        return;
                    }
                    this.i.setPadding(0, this.i.getPaddingTop(), 0, this.i.getPaddingBottom());
                    this.i.setGravity(17);
                    this.i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            } else if (i != -1) {
                str = a().getResources().getDrawable(i);
                if (str != null) {
                    this.i.setPadding(0, this.i.getPaddingTop(), 0, this.i.getPaddingBottom());
                    this.i.setGravity(17);
                    this.i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                } else {
                    str.setBounds(0, 0, str.getMinimumWidth(), str.getMinimumHeight());
                    this.i.setPadding(DipPixelUtil.dip2px(8.0f), this.i.getPaddingTop(), 0, this.i.getPaddingBottom());
                    this.i.setGravity(8388627);
                    this.i.setCompoundDrawables(str, null, null, null);
                    return;
                }
            }
            str = null;
            if (str != null) {
                str.setBounds(0, 0, str.getMinimumWidth(), str.getMinimumHeight());
                this.i.setPadding(DipPixelUtil.dip2px(8.0f), this.i.getPaddingTop(), 0, this.i.getPaddingBottom());
                this.i.setGravity(8388627);
                this.i.setCompoundDrawables(str, null, null, null);
                return;
            }
            this.i.setPadding(0, this.i.getPaddingTop(), 0, this.i.getPaddingBottom());
            this.i.setGravity(17);
            this.i.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
    }

    public void a(VideoPlayRecord videoPlayRecord, boolean z, boolean z2, boolean z3) {
        this.m.setText(videoPlayRecord.p);
        int i = 8;
        this.q.setVisibility(z ? 8 : 0);
        this.l.setVisibility(z ? 0 : 8);
        this.n.setVisibility(z ? 0 : 8);
        this.p.setVisibility(z ? 0 : 8);
        this.o.setVisibility(z ? 0 : 8);
        this.m.setVisibility(z ? false : true);
        if (videoPlayRecord.g() == RECORD_TYPE.TAG_LONG_VIDEO) {
            n.a();
            long g = n.g(videoPlayRecord.e);
            if (g == -1) {
                n.a();
                g = n.e(videoPlayRecord.e);
                if (g == -1) {
                    z = videoPlayRecord.l;
                    if (!TextUtils.isEmpty(z)) {
                        if (z.compareToIgnoreCase("http://") != 0) {
                            if (z.compareToIgnoreCase("ed2k://") != 0) {
                                if (z.compareToIgnoreCase("magnet:?") != 0) {
                                    if (z.compareToIgnoreCase("thunder://") != 0) {
                                        if (z.compareToIgnoreCase("ftp://") != 0) {
                                            String toLowerCase = z.toLowerCase();
                                            if (toLowerCase.startsWith("http://") || toLowerCase.startsWith("thunder://") || toLowerCase.startsWith("ed2k://") || toLowerCase.startsWith("ftp://") || toLowerCase.startsWith("magnet:?") || toLowerCase.startsWith("https://")) {
                                                if (TextUtils.isEmpty(z)) {
                                                    z = false;
                                                } else {
                                                    z = Pattern.compile("^[A-Za-z0-9]+$").matcher(z).matches();
                                                }
                                                if (!z) {
                                                    z = true;
                                                    if (z) {
                                                        a(a(true), -1);
                                                        if (z2) {
                                                            this.k.setImageResource(z3 ? true : true);
                                                        } else {
                                                            this.k.setImageDrawable(false);
                                                        }
                                                        this.h.setVisibility(z2 ? true : false);
                                                        z = this.j;
                                                        if (z2) {
                                                            i = 0;
                                                        }
                                                        z.setVisibility(i);
                                                        z = videoPlayRecord.d;
                                                        if (!TextUtils.isEmpty(z)) {
                                                            z = k.f(z.trim());
                                                            z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
                                                            a(videoPlayRecord.f, this.e, z2, z2, z2);
                                                            this.f.setText(z);
                                                        }
                                                        z = this.g;
                                                        if (videoPlayRecord.g == videoPlayRecord.h || videoPlayRecord.h <= 0) {
                                                            videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
                                                            z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
                                                            if (videoPlayRecord.startsWith("00:0") || Integer.parseInt(z2) <= false) {
                                                                z2 = new StringBuilder();
                                                                z2.append(a(true));
                                                                z2.append(" ");
                                                                z2.append(videoPlayRecord);
                                                                videoPlayRecord = z2.toString();
                                                            } else {
                                                                videoPlayRecord = a(R.string.playrecord_less_one_min);
                                                            }
                                                        } else {
                                                            videoPlayRecord = a(R.string.playrecord_replay);
                                                        }
                                                        z.setText(videoPlayRecord);
                                                    }
                                                }
                                                z = false;
                                                if (z) {
                                                    a(a(true), -1);
                                                    if (z2) {
                                                        this.k.setImageDrawable(false);
                                                    } else {
                                                        if (z3) {
                                                        }
                                                        this.k.setImageResource(z3 ? true : true);
                                                    }
                                                    if (z2) {
                                                    }
                                                    this.h.setVisibility(z2 ? true : false);
                                                    z = this.j;
                                                    if (z2) {
                                                        i = 0;
                                                    }
                                                    z.setVisibility(i);
                                                    z = videoPlayRecord.d;
                                                    if (TextUtils.isEmpty(z)) {
                                                        z = k.f(z.trim());
                                                        z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
                                                        a(videoPlayRecord.f, this.e, z2, z2, z2);
                                                        this.f.setText(z);
                                                    }
                                                    z = this.g;
                                                    if (videoPlayRecord.g == videoPlayRecord.h) {
                                                    }
                                                    videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
                                                    z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
                                                    if (videoPlayRecord.startsWith("00:0")) {
                                                    }
                                                    z2 = new StringBuilder();
                                                    z2.append(a(true));
                                                    z2.append(" ");
                                                    z2.append(videoPlayRecord);
                                                    videoPlayRecord = z2.toString();
                                                    z.setText(videoPlayRecord);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    z = true;
                    if (z) {
                        z = true;
                        if (z) {
                            a(a(true), -1);
                            if (z2) {
                                if (z3) {
                                }
                                this.k.setImageResource(z3 ? true : true);
                            } else {
                                this.k.setImageDrawable(false);
                            }
                            if (z2) {
                            }
                            this.h.setVisibility(z2 ? true : false);
                            z = this.j;
                            if (z2) {
                                i = 0;
                            }
                            z.setVisibility(i);
                            z = videoPlayRecord.d;
                            if (TextUtils.isEmpty(z)) {
                                z = k.f(z.trim());
                                z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
                                a(videoPlayRecord.f, this.e, z2, z2, z2);
                                this.f.setText(z);
                            }
                            z = this.g;
                            if (videoPlayRecord.g == videoPlayRecord.h) {
                            }
                            videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
                            z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
                            if (videoPlayRecord.startsWith("00:0")) {
                            }
                            z2 = new StringBuilder();
                            z2.append(a(true));
                            z2.append(" ");
                            z2.append(videoPlayRecord);
                            videoPlayRecord = z2.toString();
                            z.setText(videoPlayRecord);
                        }
                    }
                    z = false;
                    if (z) {
                        a(a(true), -1);
                        if (z2) {
                            this.k.setImageDrawable(false);
                        } else {
                            if (z3) {
                            }
                            this.k.setImageResource(z3 ? true : true);
                        }
                        if (z2) {
                        }
                        this.h.setVisibility(z2 ? true : false);
                        z = this.j;
                        if (z2) {
                            i = 0;
                        }
                        z.setVisibility(i);
                        z = videoPlayRecord.d;
                        if (TextUtils.isEmpty(z)) {
                            z = k.f(z.trim());
                            z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
                            a(videoPlayRecord.f, this.e, z2, z2, z2);
                            this.f.setText(z);
                        }
                        z = this.g;
                        if (videoPlayRecord.g == videoPlayRecord.h) {
                        }
                        videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
                        z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
                        if (videoPlayRecord.startsWith("00:0")) {
                        }
                        z2 = new StringBuilder();
                        z2.append(a(true));
                        z2.append(" ");
                        z2.append(videoPlayRecord);
                        videoPlayRecord = z2.toString();
                        z.setText(videoPlayRecord);
                    }
                }
            }
            n.a();
            TaskInfo f = n.f(g);
            if (com.xunlei.downloadprovider.download.util.k.e(f)) {
                BTSubTaskInfo a = a(f, videoPlayRecord.e);
                if (a != null) {
                    if (a.mTaskStatus) {
                        if (TextUtils.isEmpty(a.mLocalFileName)) {
                        }
                        z = false;
                        if (z) {
                            a(a(true), -1);
                            if (z2) {
                                if (z3) {
                                }
                                this.k.setImageResource(z3 ? true : true);
                            } else {
                                this.k.setImageDrawable(false);
                            }
                            if (z2) {
                            }
                            this.h.setVisibility(z2 ? true : false);
                            z = this.j;
                            if (z2) {
                                i = 0;
                            }
                            z.setVisibility(i);
                            z = videoPlayRecord.d;
                            if (TextUtils.isEmpty(z)) {
                                z = k.f(z.trim());
                                z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
                                a(videoPlayRecord.f, this.e, z2, z2, z2);
                                this.f.setText(z);
                            }
                            z = this.g;
                            if (videoPlayRecord.g == videoPlayRecord.h) {
                            }
                            videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
                            z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
                            if (videoPlayRecord.startsWith("00:0")) {
                            }
                            z2 = new StringBuilder();
                            z2.append(a(true));
                            z2.append(" ");
                            z2.append(videoPlayRecord);
                            videoPlayRecord = z2.toString();
                            z.setText(videoPlayRecord);
                        }
                    }
                    z = true;
                    if (z) {
                        a(a(true), -1);
                        if (z2) {
                            this.k.setImageDrawable(false);
                        } else {
                            if (z3) {
                            }
                            this.k.setImageResource(z3 ? true : true);
                        }
                        if (z2) {
                        }
                        this.h.setVisibility(z2 ? true : false);
                        z = this.j;
                        if (z2) {
                            i = 0;
                        }
                        z.setVisibility(i);
                        z = videoPlayRecord.d;
                        if (TextUtils.isEmpty(z)) {
                            z = k.f(z.trim());
                            z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
                            a(videoPlayRecord.f, this.e, z2, z2, z2);
                            this.f.setText(z);
                        }
                        z = this.g;
                        if (videoPlayRecord.g == videoPlayRecord.h) {
                        }
                        videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
                        z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
                        if (videoPlayRecord.startsWith("00:0")) {
                        }
                        z2 = new StringBuilder();
                        z2.append(a(true));
                        z2.append(" ");
                        z2.append(videoPlayRecord);
                        videoPlayRecord = z2.toString();
                        z.setText(videoPlayRecord);
                    }
                }
            }
            if (f.getTaskStatus() == 8) {
                if (TextUtils.isEmpty(f.mLocalFileName)) {
                }
                z = false;
                if (z) {
                    a(a(true), -1);
                    if (z2) {
                        if (z3) {
                        }
                        this.k.setImageResource(z3 ? true : true);
                    } else {
                        this.k.setImageDrawable(false);
                    }
                    if (z2) {
                    }
                    this.h.setVisibility(z2 ? true : false);
                    z = this.j;
                    if (z2) {
                        i = 0;
                    }
                    z.setVisibility(i);
                    z = videoPlayRecord.d;
                    if (TextUtils.isEmpty(z)) {
                        z = k.f(z.trim());
                        z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
                        a(videoPlayRecord.f, this.e, z2, z2, z2);
                        this.f.setText(z);
                    }
                    z = this.g;
                    if (videoPlayRecord.g == videoPlayRecord.h) {
                    }
                    videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
                    z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
                    if (videoPlayRecord.startsWith("00:0")) {
                    }
                    z2 = new StringBuilder();
                    z2.append(a(true));
                    z2.append(" ");
                    z2.append(videoPlayRecord);
                    videoPlayRecord = z2.toString();
                    z.setText(videoPlayRecord);
                }
            }
            z = true;
            if (z) {
                a(a(true), -1);
                if (z2) {
                    this.k.setImageDrawable(false);
                } else {
                    if (z3) {
                    }
                    this.k.setImageResource(z3 ? true : true);
                }
                if (z2) {
                }
                this.h.setVisibility(z2 ? true : false);
                z = this.j;
                if (z2) {
                    i = 0;
                }
                z.setVisibility(i);
                z = videoPlayRecord.d;
                if (TextUtils.isEmpty(z)) {
                    z = k.f(z.trim());
                    z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
                    a(videoPlayRecord.f, this.e, z2, z2, z2);
                    this.f.setText(z);
                }
                z = this.g;
                if (videoPlayRecord.g == videoPlayRecord.h) {
                }
                videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
                z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
                if (videoPlayRecord.startsWith("00:0")) {
                }
                z2 = new StringBuilder();
                z2.append(a(true));
                z2.append(" ");
                z2.append(videoPlayRecord);
                videoPlayRecord = z2.toString();
                z.setText(videoPlayRecord);
            }
        }
        a(a(true), (int) R.drawable.download_item_play_icon);
        if (z2) {
            if (z3) {
            }
            this.k.setImageResource(z3 ? true : true);
        } else {
            this.k.setImageDrawable(false);
        }
        if (z2) {
        }
        this.h.setVisibility(z2 ? true : false);
        z = this.j;
        if (z2) {
            i = 0;
        }
        z.setVisibility(i);
        z = videoPlayRecord.d;
        if (TextUtils.isEmpty(z)) {
            z = k.f(z.trim());
            z2 = XLFileTypeUtil.getFileIconResIdForVideo(videoPlayRecord.d);
            a(videoPlayRecord.f, this.e, z2, z2, z2);
            this.f.setText(z);
        }
        z = this.g;
        if (videoPlayRecord.g == videoPlayRecord.h) {
        }
        videoPlayRecord = DateUtils.formatElapsedTime(videoPlayRecord.h / 1000);
        z2 = videoPlayRecord.substring(videoPlayRecord.length() - true, videoPlayRecord.length());
        if (videoPlayRecord.startsWith("00:0")) {
        }
        z2 = new StringBuilder();
        z2.append(a(true));
        z2.append(" ");
        z2.append(videoPlayRecord);
        videoPlayRecord = z2.toString();
        z.setText(videoPlayRecord);
    }

    static BTSubTaskInfo a(TaskInfo taskInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        taskInfo = h.e().b(taskInfo.getTaskId());
        if (taskInfo == null) {
            return null;
        }
        TaskInfo<BTSubTaskInfo> g = taskInfo.g();
        if (d.a(g)) {
            return null;
        }
        for (BTSubTaskInfo bTSubTaskInfo : g) {
            if (bTSubTaskInfo != null && TextUtils.equals(str, bTSubTaskInfo.mLocalFileName)) {
                return bTSubTaskInfo;
            }
        }
        return null;
    }

    static void a(String str, ImageView imageView, @DrawableRes int i, @DrawableRes int i2, @DrawableRes int i3) {
        if (TextUtils.isEmpty(str)) {
            imageView.setImageResource(i2);
            return;
        }
        str = Glide.with(imageView.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(i).fallback(i2).error(i3).dontAnimate();
        str.transform(new BitmapTransformation[]{new b(r0)});
        str.into(imageView);
    }
}
