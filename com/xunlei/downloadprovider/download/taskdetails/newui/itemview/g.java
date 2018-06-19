package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.commonview.dialog.XLAlertDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity;
import com.xunlei.downloadprovider.download.downloadvod.i;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.openwith.d;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.taskdetails.newui.DownloadDetailsActivity;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.DownloadError.FailureCode;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import java.io.File;

/* compiled from: DetailBtSubTaskViewHolder */
public final class g extends com.xunlei.downloadprovider.download.taskdetails.items.a.b {
    public com.xunlei.downloadprovider.download.taskdetails.a a;
    private View b;
    private TextView c;
    private ImageView i;
    private TextView j;
    private TextView k;
    private ProgressBar l;
    private ImageView m;
    private View n;
    private TextView o;
    private ImageView p;
    private View q;
    private View r;
    private LottieAnimationView s;
    private TextView t;
    private TextView u;
    private a v = new a();
    private b w = new b(this);
    private Handler x = new Handler();
    private Runnable y = new i(this);
    private XLAlertDialog z = null;

    /* compiled from: DetailBtSubTaskViewHolder */
    private class a implements OnClickListener {
        final /* synthetic */ g a;

        private a(g gVar) {
            this.a = gVar;
        }

        public final void onClick(View view) {
            if (this.a.f() == null) {
                BTSubTaskItem d = this.a.e();
                if (d != null) {
                    boolean b = g.f(d);
                    boolean c = g.g(d);
                    boolean d2 = g.h(d);
                    if (b || c || d2) {
                        g.a(this.a, d);
                        return;
                    }
                    return;
                }
                return;
            }
            view = this.a.e();
            if (view.isSelected()) {
                view.setSelected(false);
                this.a.m.setImageResource(R.drawable.big_unselected);
            } else {
                view.setSelected(true);
                this.a.m.setImageResource(R.drawable.big_selected);
            }
            if (this.a.a != null) {
                this.a.a.a();
            }
        }
    }

    /* compiled from: DetailBtSubTaskViewHolder */
    class b extends com.xunlei.downloadprovider.download.taskdetails.subtask.g {
        final /* synthetic */ g a;

        b(g gVar) {
            this.a = gVar;
        }

        public final void a() {
            if (this.a.e != null) {
                BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) this.a.e.a(BTSubTaskItem.class);
                if (bTSubTaskItem != null) {
                    this.a.e(bTSubTaskItem);
                }
            }
        }

        public final void a(BTSubTaskItem bTSubTaskItem) {
            this.a.j(bTSubTaskItem);
        }
    }

    public static View a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.download_details_item_bt_sub_task_view, viewGroup, false);
    }

    public g(View view) {
        super(view);
        this.b = view;
        this.c = (TextView) view.findViewById(R.id.titleTextView);
        this.i = (ImageView) view.findViewById(R.id.iconImageView);
        this.j = (TextView) view.findViewById(R.id.tagSize);
        this.k = (TextView) view.findViewById(R.id.open_text);
        this.p = (ImageView) view.findViewById(R.id.open_icon);
        this.q = view.findViewById(R.id.openContainer);
        this.n = view.findViewById(R.id.select_btn_container);
        this.u = (TextView) view.findViewById(R.id.play_flag);
        this.l = (ProgressBar) view.findViewById(R.id.progressBar);
        this.m = (ImageView) view.findViewById(R.id.edit_mode_select_btn);
        this.o = (TextView) view.findViewById(R.id.statusTextView);
        this.r = view.findViewById(R.id.playing);
        this.s = (LottieAnimationView) view.findViewById(R.id.lottie_icon_playing);
        this.t = (TextView) view.findViewById(R.id.text_playing);
        view.setOnClickListener(this.v);
        view.setOnTouchListener(new h(this));
    }

    @Nullable
    private BTSubTaskItem e() {
        if (b() == null) {
            return null;
        }
        return (BTSubTaskItem) b().a(BTSubTaskItem.class);
    }

    public final void a(com.xunlei.downloadprovider.download.taskdetails.items.a.a aVar) {
        b(aVar);
        if (DownloadError.a(aVar.d) == FailureCode.TORRENT_NOT_EXIST) {
            this.b.setOnClickListener(null);
        } else {
            this.b.setOnClickListener(this.v);
        }
        BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) aVar.a(BTSubTaskItem.class);
        bTSubTaskItem.setViewModel(this.w);
        e(bTSubTaskItem);
    }

    private static boolean f(BTSubTaskItem bTSubTaskItem) {
        return bTSubTaskItem != null && bTSubTaskItem.mTaskStatus == 8;
    }

    private static boolean g(BTSubTaskItem bTSubTaskItem) {
        return i(bTSubTaskItem) == EFileCategoryType.E_VIDEO_CATEGORY ? true : null;
    }

    private static boolean h(BTSubTaskItem bTSubTaskItem) {
        return i(bTSubTaskItem) == EFileCategoryType.E_MUSIC_CATEGORY ? true : null;
    }

    private static EFileCategoryType i(BTSubTaskItem bTSubTaskItem) {
        if (bTSubTaskItem == null) {
            return null;
        }
        EFileCategoryType fileCategoryTypeByName;
        if (bTSubTaskItem.mFileCategoryType != null) {
            if (bTSubTaskItem.mFileCategoryType != EFileCategoryType.E_OTHER_CATEGORY) {
                bTSubTaskItem = bTSubTaskItem.mFileCategoryType;
                return bTSubTaskItem;
            }
        }
        if (TextUtils.isEmpty(bTSubTaskItem.mLocalFileName)) {
            fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskItem.mTitle);
        } else {
            fileCategoryTypeByName = XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskItem.mLocalFileName);
        }
        bTSubTaskItem.mFileCategoryType = fileCategoryTypeByName;
        bTSubTaskItem = fileCategoryTypeByName;
        return bTSubTaskItem;
    }

    private void j(BTSubTaskItem bTSubTaskItem) {
        this.u.setVisibility(0);
        if (bTSubTaskItem.mVideoDuration != bTSubTaskItem.mVideoPlayedTime || bTSubTaskItem.mVideoPlayedTime <= 0) {
            String str = "0%";
            if (bTSubTaskItem.mVideoPlayedTime > 0) {
                if ((bTSubTaskItem.mVideoPlayedTime * 100) / bTSubTaskItem.mVideoDuration <= 1) {
                    str = "1%";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((bTSubTaskItem.mVideoPlayedTime * 100) / bTSubTaskItem.mVideoDuration);
                    stringBuilder.append("%");
                    str = stringBuilder.toString();
                }
            }
            this.u.setTextColor(this.itemView.getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColor));
            this.u.setText(this.itemView.getContext().getResources().getString(R.string.download_item_task_play_at, new Object[]{str}));
            return;
        }
        this.u.setTextColor(this.itemView.getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
        this.u.setText(R.string.download_item_task_played);
    }

    private boolean f() {
        return this.f != null ? this.f.g : false;
    }

    public final boolean a(BTSubTaskItem bTSubTaskItem) {
        if (this.f == null || !(this.f instanceof com.xunlei.downloadprovider.download.taskdetails.newui.a)) {
            return false;
        }
        com.xunlei.downloadprovider.download.taskdetails.newui.a aVar = (com.xunlei.downloadprovider.download.taskdetails.newui.a) this.f;
        if (aVar.m != null) {
            return aVar.m.a(bTSubTaskItem);
        }
        return false;
    }

    private void e(BTSubTaskItem bTSubTaskItem) {
        CharSequence charSequence;
        this.c.setText(k.a(this.itemView.getContext(), bTSubTaskItem));
        this.c.requestLayout();
        XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskItem.mLocalFileName);
        int fileIconResId = XLFileTypeUtil.getFileIconResId(bTSubTaskItem.mLocalFileName);
        if (fileIconResId == R.drawable.ic_dl_apk) {
            Drawable a = k.a(bTSubTaskItem.mLocalFileName, this.itemView.getContext());
            if (a != null) {
                this.i.setImageDrawable(a);
            } else {
                this.i.setImageResource(fileIconResId);
            }
        } else {
            this.i.setImageResource(fileIconResId);
        }
        if (bTSubTaskItem.mFileSize == 0) {
            charSequence = bTSubTaskItem.mTaskStatus == 8 ? "0B" : "未知大小";
        } else {
            charSequence = ConvertUtil.byteConvert(bTSubTaskItem.mFileSize);
            if ((bTSubTaskItem.mTaskStatus == 8 || bTSubTaskItem.mTaskStatus == 16) && bTSubTaskItem.mTaskStatus == 8 && bTSubTaskItem.mTitle.endsWith(ShareConstants.PATCH_SUFFIX)) {
                String b = k.b(bTSubTaskItem.mLocalFileName, this.itemView.getContext());
                if (b != null) {
                    StringBuilder stringBuilder = new StringBuilder("版本:");
                    stringBuilder.append(b);
                    stringBuilder.append("  ");
                    stringBuilder.append(charSequence);
                    charSequence = stringBuilder.toString();
                }
            }
        }
        this.j.setText(charSequence);
        if (bTSubTaskItem != null) {
            if (f(bTSubTaskItem)) {
                this.l.setVisibility(8);
            } else {
                this.l.setVisibility(0);
                float f = 0.0f;
                if (bTSubTaskItem.mFileSize > 0) {
                    f = ((float) bTSubTaskItem.mDownloadedSize) / ((float) bTSubTaskItem.mFileSize);
                }
                this.l.setProgress((int) (f * 100.0f));
            }
        }
        TextView textView = this.o;
        CharSequence charSequence2 = "";
        int i = bTSubTaskItem.mTaskStatus;
        if (i == 1) {
            charSequence2 = "等待下载";
        } else if (i == 4) {
            charSequence2 = "下载暂停";
        } else if (i != 8) {
            if (i == 16) {
                charSequence2 = "下载失败";
            }
        }
        if (bTSubTaskItem.mTaskStatus == 2 && bTSubTaskItem.mFileSize != 0 && bTSubTaskItem.mDownloadedSize >= bTSubTaskItem.mFileSize) {
            charSequence2 = "校验中";
        }
        textView.setTextColor(Color.parseColor("#94969f"));
        if (!TextUtils.isEmpty(bTSubTaskItem.mLocalFileName) && bTSubTaskItem.isFileMissing() && bTSubTaskItem.mTaskStatus == 8) {
            charSequence2 = "";
        }
        if (TextUtils.isEmpty(charSequence2)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        textView.setText(charSequence2);
        this.q.setBackgroundResource(R.drawable.task_btn_normal_blue_bg);
        this.u.setVisibility(8);
        if (f(bTSubTaskItem)) {
            if (bTSubTaskItem.isFileMissing()) {
                this.u.setText("文件已移除");
                this.u.setVisibility(0);
                this.u.setTextColor(this.itemView.getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
                this.q.setBackgroundResource(R.drawable.task_detail_play_downloading_btn_bg_gray);
            } else if (g(bTSubTaskItem) && f(bTSubTaskItem)) {
                bTSubTaskItem.loadPlayRecord();
                j(bTSubTaskItem);
            }
        } else if (!(g(bTSubTaskItem) || h(bTSubTaskItem))) {
            this.q.setBackgroundResource(R.drawable.task_detail_play_downloading_btn_bg_gray);
        }
        if (f()) {
            this.n.setVisibility(0);
            this.q.setVisibility(8);
            if (bTSubTaskItem.isSelected() != null) {
                this.m.setImageResource(R.drawable.big_selected);
            } else {
                this.m.setImageResource(R.drawable.big_unselected);
            }
            if (this.r != null) {
                this.r.setVisibility(8);
                this.s.c();
                return;
            }
        }
        this.n.setVisibility(8);
        this.q.setVisibility(0);
        this.q.setClickable(false);
        this.q.setEnabled(false);
        this.r.setVisibility(8);
        this.k.setText("");
        if (i(bTSubTaskItem) == EFileCategoryType.E_SOFTWARE_CATEGORY) {
            this.k.setText("安装");
            this.p.setImageResource(R.drawable.download_detail_install);
            return;
        }
        if (!g(bTSubTaskItem)) {
            if (!h(bTSubTaskItem)) {
                this.k.setText("打开");
                this.p.setImageResource(R.drawable.download_detail_open_new);
            }
        }
        boolean E = this.h != null ? this.h.E() : false;
        DownloadDetailsActivity a2 = DownloadDetailsActivity.a(this.itemView.getContext());
        if (a2 != null) {
            i iVar = a2.a.p;
            if (E && iVar != null && iVar.b() == bTSubTaskItem.mBTSubIndex) {
                this.q.setVisibility(8);
                this.r.setVisibility(0);
                this.s.setAnimation("lottie/downloadlist/task_playing.json");
                this.s.a(true);
                this.s.a();
                return;
            }
        }
        this.r.setVisibility(8);
        this.s.c();
        if (!(bTSubTaskItem.mTaskStatus == 16 || bTSubTaskItem.mTaskStatus == 2)) {
            if (bTSubTaskItem.mTaskStatus != 1) {
                this.k.setText("播放");
                this.p.setImageResource(R.drawable.download_detail_play);
                if (e.c(bTSubTaskItem.mLocalFileName) == null) {
                    this.q.setBackgroundResource(R.drawable.task_btn_normal_blue_bg);
                } else {
                    this.q.setBackgroundResource(R.drawable.task_detail_play_downloading_btn_bg_gray);
                }
            }
        }
        this.k.setText(this.itemView.getContext().getString(R.string.task_detail_new_bxbb));
        this.p.setImageResource(R.drawable.download_detail_play);
        if (e.c(bTSubTaskItem.mLocalFileName) == null) {
            this.q.setBackgroundResource(R.drawable.task_detail_play_downloading_btn_bg_gray);
        } else {
            this.q.setBackgroundResource(R.drawable.task_btn_normal_blue_bg);
        }
    }

    static /* synthetic */ void a(g gVar, BTSubTaskItem bTSubTaskItem) {
        TaskInfo d = gVar.d();
        if (bTSubTaskItem.mTaskStatus == 8) {
            String str = bTSubTaskItem.mLocalFileName;
            if (TextUtils.isEmpty(str)) {
                XLToast.showToast(gVar.c(), "文件不存在");
            } else if (!new File(str).exists()) {
                XLToast.showToast(gVar.c(), "文件不存在");
            } else if (e.f(bTSubTaskItem.mTitle)) {
                DownloadBtFileExplorerActivity.a(gVar.c(), Uri.fromFile(new File(str)).toString(), 9);
            } else if (!((k.b(bTSubTaskItem) || k.a(bTSubTaskItem)) && gVar.a(bTSubTaskItem))) {
                if (XLFileTypeUtil.isLocalVodSupport(str)) {
                    if (str.contains("/")) {
                        str.substring(str.lastIndexOf("/") + 1);
                    }
                    if (gVar.c() != null) {
                        m.a(d.getTaskId(), bTSubTaskItem.mBTSubIndex, false);
                        VodPlayerActivityNew.a(gVar.c(), d, bTSubTaskItem, "download_detail_new");
                    }
                    return;
                }
                d.a(gVar.c(), str, false);
            }
        } else if ((!k.b(bTSubTaskItem) && !k.a(bTSubTaskItem)) || d == null || gVar.c() == null) {
            XLToast.showToast(gVar.c(), "文件下载未完成");
        } else {
            com.xunlei.downloadprovider.download.report.a.a("dl_bxbb", d);
            if (!com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
                XLToast.showToast(BrothersApplication.getApplicationInstance(), BrothersApplication.getApplicationInstance().getString(R.string.net_disable));
            } else if (!com.xunlei.xllib.android.b.f(BrothersApplication.getApplicationInstance()) && (d.getTaskStatus() == 4 || d.getTaskStatus() == 16)) {
                DialogInterface.OnClickListener jVar = new j(gVar, d, bTSubTaskItem);
                if (gVar.z != null) {
                    gVar.z.dismiss();
                    gVar.z = null;
                }
                gVar.z = new XLAlertDialog(gVar.c());
                gVar.z.setMessage(gVar.c().getString(R.string.net_change_mobile_continus_tips));
                gVar.z.setCancelButtonText(gVar.c().getString(R.string.net_change_start_downloading));
                gVar.z.setConfirmButtonText(gVar.c().getString(R.string.net_change_close));
                gVar.z.setCanceledOnTouchOutside(true);
                gVar.z.setOnClickCancelButtonListener(new k(gVar, jVar));
                gVar.z.setOnClickConfirmButtonListener(new l(gVar));
                gVar.z.show();
            } else if (!gVar.a(bTSubTaskItem)) {
                m.a(gVar.d.getTaskId(), bTSubTaskItem.mBTSubIndex, false);
                VodPlayerActivityNew.a(gVar.c(), gVar.d, bTSubTaskItem, "download_detail_new");
            }
        }
    }

    static /* synthetic */ void h(g gVar) {
        BTSubTaskItem e = gVar.e();
        if (e != null) {
            e.setSelected(true);
            gVar.m.setImageResource(R.drawable.big_selected);
            if (gVar.a != null) {
                gVar.a.b();
            }
        }
    }
}
