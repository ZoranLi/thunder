package com.xunlei.downloadprovider.download.taskdetails.items;

import android.content.Context;
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
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.openwith.d;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.taskdetails.subtask.BTSubTaskItem;
import com.xunlei.downloadprovider.download.taskdetails.subtask.g;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.DownloadError.FailureCode;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.h.e;
import com.xunlei.downloadprovider.personal.playrecord.v;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import java.io.File;

/* compiled from: DetailBtTaskSubFileViewHolder */
public class b extends com.xunlei.downloadprovider.download.taskdetails.items.a.b {
    private static final String c = "b";
    View a;
    public com.xunlei.downloadprovider.download.taskdetails.a b;
    private TextView i;
    private ImageView j;
    private TextView k;
    private TextView l;
    private ProgressBar m;
    private ImageView n;
    private View o;
    private TextView p;
    private ImageView q;
    private View r;
    private View s;
    private TextView t;
    private View u;
    private OnClickListener v = new c(this);
    private a w = new a(this);
    private Handler x = new Handler();
    private Runnable y = new e(this);

    /* compiled from: DetailBtTaskSubFileViewHolder */
    class a extends g {
        final /* synthetic */ b a;

        public final void a() {
        }

        public final void a(BTSubTaskItem bTSubTaskItem) {
        }

        a(b bVar) {
            this.a = bVar;
        }
    }

    public static View a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.download_center_task_detail_btl_list, viewGroup, false);
    }

    public b(View view) {
        super(view);
        this.a = view;
        this.i = (TextView) view.findViewById(R.id.titleTextView);
        this.j = (ImageView) view.findViewById(R.id.iconImageView);
        this.k = (TextView) view.findViewById(R.id.tagSize);
        this.l = (TextView) view.findViewById(R.id.open_text);
        this.q = (ImageView) view.findViewById(R.id.open_icon);
        this.r = view.findViewById(R.id.openContainer);
        this.o = view.findViewById(R.id.select_btn_container);
        this.s = view.findViewById(R.id.taskItemLayout);
        this.t = (TextView) view.findViewById(R.id.play_flag);
        this.m = (ProgressBar) view.findViewById(R.id.progressBar);
        this.n = (ImageView) view.findViewById(R.id.edit_mode_select_btn);
        this.p = (TextView) view.findViewById(R.id.statusTextView);
        this.u = view.findViewById(R.id.bt_expand_white_space);
        view.setOnClickListener(this.v);
        view.setOnTouchListener(new d(this));
    }

    @Nullable
    private BTSubTaskItem e() {
        if (b() == null) {
            return null;
        }
        return (BTSubTaskItem) b().a(BTSubTaskItem.class);
    }

    public final void a(com.xunlei.downloadprovider.download.taskdetails.items.a.a aVar) {
        CharSequence charSequence;
        b(aVar);
        if (DownloadError.a(aVar.d) == FailureCode.TORRENT_NOT_EXIST) {
            this.a.setOnClickListener(null);
        } else {
            this.a.setOnClickListener(this.v);
        }
        BTSubTaskItem bTSubTaskItem = (BTSubTaskItem) aVar.a(BTSubTaskItem.class);
        bTSubTaskItem.setViewModel(this.w);
        this.i.setText(k.a(this.itemView.getContext(), bTSubTaskItem));
        this.i.requestLayout();
        XLFileTypeUtil.getFileCategoryTypeByName(bTSubTaskItem.mLocalFileName);
        int fileIconResId = XLFileTypeUtil.getFileIconResId(bTSubTaskItem.mLocalFileName);
        if (fileIconResId == R.drawable.ic_dl_apk) {
            Drawable a = k.a(bTSubTaskItem.mLocalFileName, this.itemView.getContext());
            if (a != null) {
                this.j.setImageDrawable(a);
            } else {
                this.j.setImageResource(fileIconResId);
            }
        } else {
            this.j.setImageResource(fileIconResId);
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
        this.k.setText(charSequence);
        boolean z = false;
        if (bTSubTaskItem != null) {
            if (c(bTSubTaskItem)) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                float f = 0.0f;
                if (bTSubTaskItem.mFileSize > 0) {
                    f = ((float) bTSubTaskItem.mDownloadedSize) / ((float) bTSubTaskItem.mFileSize);
                }
                this.m.setProgress((int) (f * 100.0f));
            }
        }
        TextView textView = this.p;
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
        this.r.setBackgroundResource(R.drawable.task_btn_normal_blue_bg);
        this.t.setVisibility(8);
        if (c(bTSubTaskItem)) {
            if (bTSubTaskItem.isFileMissing()) {
                this.t.setText("文件已移除");
                this.t.setVisibility(0);
                this.t.setTextColor(this.itemView.getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
                this.r.setBackgroundResource(R.drawable.task_detail_play_downloading_btn_bg_gray);
            } else if (d(bTSubTaskItem) && c(bTSubTaskItem)) {
                v.a().a(bTSubTaskItem.mLocalFileName, new f(this, bTSubTaskItem), null, true);
            }
        } else if (!d(bTSubTaskItem)) {
            this.r.setBackgroundResource(R.drawable.task_detail_play_downloading_btn_bg_gray);
        }
        if (f()) {
            this.o.setVisibility(0);
            this.r.setVisibility(8);
            if (bTSubTaskItem.isSelected() != null) {
                this.n.setImageResource(R.drawable.big_selected);
                return;
            } else {
                this.n.setImageResource(R.drawable.big_unselected);
                return;
            }
        }
        this.o.setVisibility(8);
        this.r.setVisibility(0);
        this.r.setClickable(false);
        this.r.setEnabled(false);
        if (e(bTSubTaskItem) == EFileCategoryType.E_SOFTWARE_CATEGORY) {
            z = true;
        }
        if (z) {
            this.l.setText("安装");
            this.q.setImageResource(R.drawable.download_detail_install);
        } else if (d(bTSubTaskItem)) {
            if (!(bTSubTaskItem.mTaskStatus == 16 || bTSubTaskItem.mTaskStatus == 2)) {
                if (bTSubTaskItem.mTaskStatus != 1) {
                    this.l.setText("播放");
                    this.q.setImageResource(R.drawable.download_detail_play);
                }
            }
            this.l.setText("边下边播");
            this.q.setImageResource(R.drawable.download_detail_play);
        } else {
            this.l.setText("打开");
            this.q.setImageResource(R.drawable.download_detail_open);
        }
    }

    private static boolean c(BTSubTaskItem bTSubTaskItem) {
        return bTSubTaskItem != null && bTSubTaskItem.mTaskStatus == 8;
    }

    private static boolean d(BTSubTaskItem bTSubTaskItem) {
        return e(bTSubTaskItem) == EFileCategoryType.E_VIDEO_CATEGORY ? true : null;
    }

    private static EFileCategoryType e(BTSubTaskItem bTSubTaskItem) {
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

    private boolean f() {
        return this.f != null ? this.f.g : false;
    }

    static /* synthetic */ void a(b bVar, BTSubTaskItem bTSubTaskItem) {
        if (bTSubTaskItem.mTaskStatus != 8) {
            TaskInfo d = bVar.d();
            if (!k.a(bTSubTaskItem.mTitle) || d == null || bVar.c() == null) {
                XLToast.showToast(bVar.c(), "文件下载未完成");
                return;
            }
            com.xunlei.downloadprovider.download.report.a.a("dl_bxbb", d);
            m.a(bVar.d.getTaskId(), bTSubTaskItem.mBTSubIndex, false);
            VodPlayerActivityNew.a(bVar.c(), bVar.d, bTSubTaskItem, "download_detail");
            return;
        }
        String str = bTSubTaskItem.mLocalFileName;
        if (!new File(str).exists()) {
            XLToast.showToast(bVar.c(), "文件不存在");
        } else if (e.f(bTSubTaskItem.mTitle)) {
            DownloadBtFileExplorerActivity.a(bVar.c(), Uri.fromFile(new File(str)).toString(), 9);
        } else if (XLFileTypeUtil.isLocalVodSupport(str)) {
            if (str.contains("/")) {
                str.substring(str.lastIndexOf("/") + 1);
            }
            if (bVar.c() != null) {
                m.a(bVar.d.getTaskId(), bTSubTaskItem.mBTSubIndex, false);
                VodPlayerActivityNew.a(bVar.c(), bVar.d, bTSubTaskItem, "download_detail");
            }
        } else {
            d.a(bVar.c(), str, false);
        }
    }

    static /* synthetic */ void h(b bVar) {
        BTSubTaskItem e = bVar.e();
        if (e != null) {
            e.setSelected(true);
            bVar.n.setImageResource(R.drawable.big_selected);
            if (bVar.b != null) {
                bVar.b.b();
            }
        }
    }
}
