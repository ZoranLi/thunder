package com.xunlei.downloadprovider.download.tasklist.list.download;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.InputDeviceCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.ApkHelper;
import com.xunlei.common.androidutil.ApkHelper$ApkInfo;
import com.xunlei.common.androidutil.DateTimeUtil;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.businessutil.SettingStateController;
import com.xunlei.common.businessutil.XLFileTypeUtil;
import com.xunlei.common.businessutil.XLFileTypeUtil.EFileCategoryType;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.download.DownloadManager.TaskType;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.l;
import com.xunlei.downloadprovider.download.b.b;
import com.xunlei.downloadprovider.download.center.widget.af;
import com.xunlei.downloadprovider.download.control.p;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.info.TaskSpeedCountInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.player.a.m;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.download.speedup.c;
import com.xunlei.downloadprovider.download.speedup.view.d;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment;
import com.xunlei.downloadprovider.download.tasklist.list.a.e;
import com.xunlei.downloadprovider.download.tasklist.list.a.f;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.list.banner.a.g;
import com.xunlei.downloadprovider.download.tasklist.list.banner.a.h;
import com.xunlei.downloadprovider.download.tasklist.list.banner.a.i;
import com.xunlei.downloadprovider.download.tasklist.list.banner.b.a;
import com.xunlei.downloadprovider.download.tasklist.list.banner.c.f$a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.DownloadError.FailureCode;
import com.xunlei.downloadprovider.download.util.DownloadError.SpeedupFailureCode;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.download.util.r;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo.CollectState;
import com.xunlei.downloadprovider.personal.lixianspace.business.LXSpaceTaskQueryMgr;
import com.xunlei.downloadprovider.personal.lixianspace.business.LXSpaceTaskQueryMgr.LXTaskState;
import com.xunlei.downloadprovider.plugin.q;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.vodnew.VodPlayerActivityNew;
import com.xunlei.downloadprovider.xlui.widget.ZHTextView;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TaskDownloadCardViewHolder extends f {
    public static final String TAG = "TaskDownloadCardViewHolder";
    public static boolean hasReportDl_Try_Show;
    private boolean isTagPlayVisible = false;
    private e mCardItem;
    private int mCardStyle = b.f();
    private Context mContext;
    private a mDownloadExceptionBanner;
    private ImageView mEditModeBtn;
    private View mEditModeLayout;
    private View mFinishedButtonLayout;
    private com.xunlei.downloadprovider.download.tasklist.list.banner.c.a mFreeTrailView;
    f$a mIFreeTrialRedPacketListener = new f(this);
    private af.a mIPrivateItemListener = new e(this);
    private ImageView mIconImageView;
    private TextView mLXSpaceTagTv;
    private View mLXSpaceView;
    private com.xunlei.downloadprovider.download.tasklist.list.banner.d.a mLimitPrivilegeBanner;
    private DownloadTaskInfo mOldTaskInfo;
    private OnClickListener mOnTaskOperateFail2ResumeClickListener = new m(this);
    private OnClickListener mOnTaskOperatePauseClickListener = new k(this);
    private OnClickListener mOnTaskOperateRestartClickListener = new l(this);
    private OnClickListener mOnTaskOperateResumeClickListener = new n(this);
    private OnClickListener mOnTaskVideoPlayClickListener = new j(this);
    private OnClickListener mOnTaskVipSpeedupClickListener = new o(this);
    private TextView mOpenButton;
    private TextView mOpenPlayButton;
    private TextView mOperateButton;
    private int mPageIndex;
    private FrameLayout mProgressBar;
    private d mProgressControl;
    private View mRedownloadButton;
    private TextView mRemainTextView;
    private TextView mRemainTextView2;
    private View mRunningStatusLayout;
    private TextView mSizeTextView;
    private com.xunlei.downloadprovider.download.tasklist.list.download.a.b mSnapshotTagViewHolder;
    private TextView mSpeedTextView;
    private TextView mSpeedupSpeedTextView;
    private ImageView mStatusImageView;
    private View mStatusLayout;
    private TextView mStatusTextView;
    private View mTagDivider1;
    private View mTagDivider2;
    private TextView mTagEpisode;
    private LinearLayout mTagLayout;
    private View mTagNew;
    private View mTagPlay;
    private TextView mTagRefUrlTv;
    private com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.b.a mTaskDownloadRedEnvelopeBanner;
    private View mTaskHideFlagTv;
    private DownloadTaskInfo mTaskInfo;
    private int mTaskInfoRevision = 0;
    private OnClickListener mTaskOpenApkButtonOnClickListener = new i(this);
    private OnClickListener mTaskOpenButtonOnClickListener = new a(this);
    private ZHTextView mTitleTextView;
    private i mTwiceConsumeBanner;
    private View mUnfinishedButtonLayout;
    private View mVipSpeedupButton;
    private com.xunlei.downloadprovider.download.tasklist.list.banner.f.a mVoucherPacketBanner;

    private String getTabid(int i) {
        return i == 0 ? "total" : i == 1 ? "downloading" : i == 2 ? "finish" : "";
    }

    public static TaskDownloadCardViewHolder createViewHolderAndView(Context context, ViewGroup viewGroup, com.xunlei.downloadprovider.download.control.a aVar, com.xunlei.downloadprovider.download.tasklist.list.a aVar2, int i) {
        viewGroup = b.f();
        if (viewGroup == 1) {
            viewGroup = View.inflate(context, R.layout.layout_task_list_download_card_style1, null);
        } else if (viewGroup == null) {
            viewGroup = View.inflate(context, R.layout.layout_task_list_download_card, null);
        } else {
            viewGroup = View.inflate(context, R.layout.layout_task_list_download_card_style2, null);
        }
        TaskDownloadCardViewHolder taskDownloadCardViewHolder = new TaskDownloadCardViewHolder(viewGroup);
        taskDownloadCardViewHolder.setDownloadCenterControl(aVar);
        taskDownloadCardViewHolder.setAdapter(aVar2);
        taskDownloadCardViewHolder.setContext(context);
        taskDownloadCardViewHolder.setPageIndex(i);
        return taskDownloadCardViewHolder;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public int getPageIndex() {
        return this.mPageIndex;
    }

    public void setPageIndex(int i) {
        this.mPageIndex = i;
    }

    public void setDownloadCenterControl(com.xunlei.downloadprovider.download.control.a aVar) {
        super.setDownloadCenterControl(aVar);
        if (this.mFreeTrailView != null) {
            this.mFreeTrailView.f = aVar;
        }
    }

    public TaskDownloadCardViewHolder(View view) {
        super(view);
        this.mStatusLayout = view.findViewById(R.id.statusLayout);
        this.mRunningStatusLayout = view.findViewById(R.id.runningStatusLayout);
        initBanner();
        if (getDownloadCenterControl() != null) {
            this.mFreeTrailView.f = getDownloadCenterControl();
        }
        this.mIconImageView = (ImageView) view.findViewById(R.id.iconImageView);
        this.mTitleTextView = (ZHTextView) view.findViewById(R.id.titleTextView);
        this.mProgressBar = (FrameLayout) view.findViewById(R.id.progressBar);
        this.mStatusImageView = (ImageView) view.findViewById(R.id.statusImageView);
        this.mStatusTextView = (TextView) view.findViewById(R.id.statusTextView);
        this.mSpeedTextView = (TextView) view.findViewById(R.id.speedTextView);
        this.mSpeedupSpeedTextView = (TextView) view.findViewById(R.id.speedupSpeedTextView);
        this.mRemainTextView = (TextView) view.findViewById(R.id.remainTextView);
        this.mRemainTextView2 = (TextView) view.findViewById(R.id.remainTextView2);
        this.mSizeTextView = (TextView) view.findViewById(R.id.tagSize);
        this.mTagPlay = view.findViewById(R.id.tagPlay);
        this.mTagEpisode = (TextView) view.findViewById(R.id.tagEpisode);
        this.mTagNew = view.findViewById(R.id.tagNew);
        this.mSnapshotTagViewHolder = new com.xunlei.downloadprovider.download.tasklist.list.download.a.b(view.findViewById(R.id.cardView), view.findViewById(R.id.tagSnapshot));
        this.mTagRefUrlTv = (TextView) view.findViewById(R.id.refUrl);
        this.mTagDivider1 = view.findViewById(R.id.tagDivider1);
        this.mTagDivider2 = view.findViewById(R.id.tagDivider2);
        this.mTagLayout = (LinearLayout) view.findViewById(R.id.tagLayout);
        this.mFinishedButtonLayout = view.findViewById(R.id.finishedButtonLayout);
        this.mUnfinishedButtonLayout = view.findViewById(R.id.unfinishedButtonLayout);
        this.mOperateButton = (TextView) view.findViewById(R.id.operateButton);
        this.mRedownloadButton = view.findViewById(R.id.redownloadButton);
        this.mOpenButton = (TextView) view.findViewById(R.id.openButton);
        this.mOpenPlayButton = (TextView) view.findViewById(R.id.playButton);
        this.mVipSpeedupButton = view.findViewById(R.id.vipspeedupButton);
        this.mEditModeLayout = view.findViewById(R.id.edit_mode_select_layout);
        this.mEditModeBtn = (ImageView) view.findViewById(R.id.edit_mode_select_btn);
        if (this.mCardStyle == 3) {
            this.mStatusTextView.setTextSize((float) getContext().getResources().getInteger(R.integer.task_card_download_finish_tip_size_style2));
        } else {
            this.mStatusTextView.setTextSize((float) getContext().getResources().getInteger(R.integer.task_card_download_status_tip_size));
        }
        this.mEditModeBtn.setOnClickListener(new p(this));
        view.setOnClickListener(new b(this));
        view.setOnLongClickListener(new c(this));
        this.mTaskHideFlagTv = view.findViewById(R.id.task_hide_flag_tv);
        initProgressType();
        this.mLXSpaceTagTv = (TextView) view.findViewById(R.id.tagLXSpace);
        this.mLXSpaceView = view.findViewById(R.id.tagLXSpaceView);
    }

    private void onApkTaskOnClick(DownloadTaskInfo downloadTaskInfo, boolean z, String str) {
        if (z) {
            ApkHelper.launchAppByPackageName(this.mContext, str);
        } else {
            ApkHelper.installApk(this.mContext, downloadTaskInfo.mLocalFileName);
        }
    }

    private String getTabid() {
        String str = "";
        if (this.mPageIndex == 0) {
            return "total";
        }
        if (this.mPageIndex == 1) {
            return "downloading";
        }
        return this.mPageIndex == 2 ? "finish" : str;
    }

    private void setTaskToSeen() {
        if (this.mTaskInfo != null && this.mTaskInfo.isUnseen() && this.mTaskInfo.getTaskStatus() == 8) {
            this.mTaskInfo.markToSeen();
            if (this.mAdapter != null) {
                this.mAdapter.notifyItemChanged(getAdapterPosition());
            }
            updateTaskName(this.mTaskInfo);
            n.a();
            n.a(this.mTaskInfo);
        }
    }

    private void selectOrDeselectTaskCardItem() {
        this.mCardItem.a(this.mCardItem.a() ^ 1);
        processEditMode(this.mCardItem);
        com.xunlei.downloadprovider.download.tasklist.list.a aVar = this.mAdapter;
        List f = aVar.f();
        TaskListPageFragment taskListPageFragment = aVar.g;
        if (taskListPageFragment.e != null) {
            taskListPageFragment.e.a(f);
        }
    }

    private void showTaskMoreOperationDialog() {
        af afVar = new af(getContext(), this.mTaskInfo, getDownloadCenterControl(), getTabid());
        afVar.a = this.mIPrivateItemListener;
        afVar.show();
    }

    private Drawable getDrawable(int i) {
        if (VERSION.SDK_INT >= 21) {
            return this.itemView.getResources().getDrawable(i, null);
        }
        return this.itemView.getResources().getDrawable(i);
    }

    public void fillData(e eVar) {
        super.fillData(eVar);
        this.mCardItem = eVar;
        this.mTaskInfo = eVar.b();
        if (this.mTaskInfo == null) {
            this.mOldTaskInfo = null;
            this.mTaskInfoRevision = null;
            return;
        }
        if (this.mTaskInfo.mRunningInfo.a() != null) {
            this.mTaskInfo.mRunningInfo.a(-1);
            eVar = this.mTaskInfo;
            eVar.mRevision++;
        }
        if (this.mTaskInfo == this.mOldTaskInfo && this.mTaskInfo.mRevision == this.mTaskInfoRevision && this.mTaskInfoRevision != null) {
            processEditMode(this.mCardItem);
            adjustCardInterval();
            return;
        }
        initBannerVisible();
        eVar = new StringBuilder("fillData - ");
        eVar.append(this);
        eVar.append(" pageIndex:");
        eVar.append(this.mAdapter.a());
        prepareForReuse();
        adjustCardInterval();
        updateTaskBasicInfo();
        updateTaskStatusInfo(this.mTaskInfo);
        checkShowTagDivider();
        updateTaskOperateButton(this.mTaskInfo);
        updateFreeTrail(this.mTaskInfo);
        processEditMode(this.mCardItem);
        processInternalStatus();
        updateBanner(this.mTaskInfo);
        this.mOldTaskInfo = this.mTaskInfo;
        this.mTaskInfoRevision = this.mTaskInfo.mRevision;
        refreshPrivateSpaceUI();
        refreshLXSpaceTagState();
    }

    private void initBannerVisible() {
        if (this.mDownloadExceptionBanner != null) {
            this.mDownloadExceptionBanner.d(8);
            BannerManager.a().a(false, BannerManager$BannerType.TYPE_EXCEPTION, this.mTaskInfo.getTaskId(), null);
        }
        if (this.mTaskDownloadRedEnvelopeBanner != null && this.mTaskDownloadRedEnvelopeBanner.h() == 0 && this.mTaskDownloadRedEnvelopeBanner.a != this.mTaskInfo) {
            this.mTaskDownloadRedEnvelopeBanner.d(8);
        }
    }

    private void adjustCardInterval() {
        int layoutPosition = getLayoutPosition();
        if (layoutPosition != this.mAdapter.getItemCount() - 1 || layoutPosition == 0) {
            this.itemView.setPadding(this.itemView.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), 0);
        } else {
            this.itemView.setPadding(this.itemView.getPaddingLeft(), this.itemView.getPaddingTop(), this.itemView.getPaddingRight(), this.itemView.getResources().getDimensionPixelSize(R.dimen.task_tab_card_interval));
        }
    }

    private void processInternalStatus() {
        if (this.mTaskInfo != null) {
            int i = this.mTaskInfo.mRunningInfo.c;
            if (i > 0) {
                this.mOperateButton.setOnClickListener(null);
                this.mOperateButton.setPressed(true);
                this.mRedownloadButton.setOnClickListener(null);
                this.mRedownloadButton.setPressed(true);
                this.mFinishedButtonLayout.setOnClickListener(null);
                this.mUnfinishedButtonLayout.setOnClickListener(null);
                this.mRunningStatusLayout.setVisibility(8);
                if (this.mCardStyle == 3) {
                    this.mRemainTextView2.setVisibility(8);
                }
                this.mStatusLayout.setVisibility(0);
                this.mStatusImageView.setVisibility(8);
                if (this.mCardStyle == 3) {
                    this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColorStyle2));
                } else {
                    this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
                }
                if (i == 4) {
                    this.mStatusTextView.setText(R.string.download_item_task_status_wait_stop);
                } else {
                    if (i != 2) {
                        if (i != 1) {
                            if (i == 17) {
                                this.mStatusTextView.setText(R.string.download_item_task_status_wait_delete);
                                setVipSpeedupButtonGone();
                                this.mUnfinishedButtonLayout.setVisibility(8);
                                this.mFinishedButtonLayout.setVisibility(8);
                            }
                        }
                    }
                    this.mStatusTextView.setText(R.string.download_item_task_status_wait_start);
                }
                if (this.mCardStyle == 3) {
                    if (i == 4) {
                        this.mOperateButton.setVisibility(0);
                        setOperateButtonType(1);
                    } else if (i == 2 || i == 1) {
                        this.mOperateButton.setVisibility(0);
                        setOperateButtonType(2);
                    }
                }
            }
        }
    }

    private void refreshSelf() {
        if (this.mCardItem != null) {
            fillData(this.mCardItem);
        }
    }

    private void updateTaskBasicInfo() {
        if (this.mTaskInfo != null) {
            updateTaskName(this.mTaskInfo);
            updateTaskIcon(this.mTaskInfo);
            TaskInfo taskInfo = this.mTaskInfo;
            boolean z = (taskInfo == null || taskInfo.mTaskType == TaskType.MAGNET || r.a(taskInfo) != EFileCategoryType.E_VIDEO_CATEGORY) ? false : true;
            if (this.mTaskInfo.mFileSize > 0) {
                this.mSizeTextView.setText(com.xunlei.downloadprovider.download.util.a.c(this.mTaskInfo.mFileSize));
            } else {
                this.mSizeTextView.setText(R.string.download_item_task_unknown_filesize);
            }
            if (!TextUtils.isEmpty(this.mTaskInfo.mEpisodeTagText) && z) {
                this.mTagEpisode.setVisibility(0);
                this.mTagEpisode.setText(this.mTaskInfo.mEpisodeTagText);
            }
            if (!z || this.mTaskInfo.mIsFileMissing) {
                this.mTagPlay.setVisibility(8);
                this.isTagPlayVisible = false;
            } else {
                this.mTagPlay.setVisibility(0);
                if (!this.isTagPlayVisible) {
                    this.isTagPlayVisible = true;
                }
                setVisibleWithRegionConfig();
            }
            CharSequence taskDownloadUrl = this.mTaskInfo.getTaskDownloadUrl();
            String[] strArr = new String[]{"thunder:"};
            if (!TextUtils.isEmpty(taskDownloadUrl)) {
                if (taskDownloadUrl.contains(".xunlei.com/")) {
                    taskDownloadUrl = "";
                } else {
                    for (int i = 0; i <= 0; i++) {
                        String str = strArr[0];
                        if (taskDownloadUrl.startsWith(str)) {
                            taskDownloadUrl = taskDownloadUrl.substring(str.length());
                            break;
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(taskDownloadUrl) || this.mTagRefUrlTv == null) {
                if (this.mTagRefUrlTv != null) {
                    this.mTagRefUrlTv.setVisibility(0);
                    this.mTagRefUrlTv.setText(this.mTagRefUrlTv.getResources().getString(R.string.download_item_task_refurl_from, new Object[]{taskDownloadUrl}));
                }
                return;
            }
            this.mTagRefUrlTv.setVisibility(8);
        }
    }

    private void checkShowTagDivider() {
        if (this.mTagDivider1 != null) {
            this.mTagDivider1.setVisibility(8);
        }
        if (this.mTagDivider2 != null) {
            this.mTagDivider2.setVisibility(8);
        }
        if (this.mTagPlay.getVisibility() == 0 && this.mTagEpisode.getVisibility() == 0 && this.mTagDivider1 != null) {
            this.mTagDivider1.setVisibility(0);
        }
        if (this.mTagEpisode.getVisibility() == 0 && this.mSizeTextView.getVisibility() == 0 && this.mTagDivider2 != null) {
            this.mTagDivider2.setVisibility(0);
        }
        if (this.mTagPlay.getVisibility() == 0 && this.mTagEpisode.getVisibility() == 8 && this.mSizeTextView.getVisibility() == 0 && this.mTagDivider1 != null) {
            this.mTagDivider1.setVisibility(0);
        }
    }

    private void setVisibleWithRegionConfig() {
        boolean z = false;
        this.mTagPlay.setVisibility(l.a().b() ? 0 : 8);
        if (this.mTagPlay.getVisibility() == 0) {
            z = true;
        }
        this.isTagPlayVisible = z;
    }

    private void checkExceptionBanner(DownloadTaskInfo downloadTaskInfo) {
        if (this.mPageIndex == 0) {
            a aVar = this.mDownloadExceptionBanner;
            if (aVar.a == null) {
                aVar.a = new com.xunlei.downloadprovider.download.tasklist.list.banner.b.f(aVar);
            }
            aVar.a.a(downloadTaskInfo);
        }
    }

    private void checkRedEnvelopeBanner(DownloadTaskInfo downloadTaskInfo) {
        if (this.mPageIndex == 0) {
            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.b.a aVar = this.mTaskDownloadRedEnvelopeBanner;
            aVar.f();
            aVar.b.a(downloadTaskInfo);
        }
    }

    private void processEditMode(e eVar) {
        int i = 0;
        if (isEditMode()) {
            this.mFinishedButtonLayout.setVisibility(8);
            setVipSpeedupButtonGone();
            this.mUnfinishedButtonLayout.setVisibility(8);
            this.mEditModeLayout.setVisibility(0);
            if (eVar.a() != null) {
                this.mEditModeBtn.setImageResource(R.drawable.big_selected);
                return;
            } else {
                this.mEditModeBtn.setImageResource(R.drawable.big_unselected);
                return;
            }
        }
        eVar = (this.mTaskInfo == null || this.mTaskInfo.getTaskStatus() != 8) ? null : true;
        this.mFinishedButtonLayout.setVisibility(eVar != null ? 0 : 8);
        View view = this.mUnfinishedButtonLayout;
        if (eVar != null) {
            i = 8;
        }
        view.setVisibility(i);
        if (eVar != null) {
            setVipSpeedupButtonGone();
        }
        this.mEditModeLayout.setVisibility(8);
    }

    private void prepareForReuse() {
        this.mTagEpisode.setVisibility(8);
        this.mTagPlay.setVisibility(8);
        this.isTagPlayVisible = false;
        setVipSpeedupButtonGone();
    }

    private void setTaskProgress(DownloadTaskInfo downloadTaskInfo) {
        d dVar = this.mProgressControl;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.mTaskInfo.mUrl);
        dVar.setSaveKey(stringBuilder.toString());
        StringBuilder stringBuilder2;
        switch (downloadTaskInfo.getTaskStatus()) {
            case 1:
                this.mProgressBar.setVisibility(0);
                this.mProgressControl.d();
                downloadTaskInfo = new StringBuilder();
                downloadTaskInfo.append(this.mProgressControl.getSaveKey());
                downloadTaskInfo.append("=state_waiting");
                return;
            case 2:
                this.mProgressBar.setVisibility(0);
                this.mProgressControl.d();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.mProgressControl.getSaveKey());
                stringBuilder2.append("=state_running");
                break;
            case 4:
                this.mProgressBar.setVisibility(0);
                this.mProgressControl.c();
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(this.mProgressControl.getSaveKey());
                stringBuilder2.append("=state_pause");
                break;
            case 8:
                if (this.mProgressBar.getVisibility() == null) {
                    this.mProgressBar.setVisibility(8);
                    this.mProgressControl.b();
                }
                downloadTaskInfo = new StringBuilder();
                downloadTaskInfo.append(this.mProgressControl.getSaveKey());
                downloadTaskInfo.append("=statesuccess");
                return;
            case 16:
                this.mProgressBar.setVisibility(0);
                this.mProgressControl.b();
                downloadTaskInfo = new StringBuilder();
                downloadTaskInfo.append(this.mProgressControl.getSaveKey());
                downloadTaskInfo.append("=statefailed");
                return;
            case 17:
                if (this.mProgressBar.getVisibility() == null) {
                    this.mProgressBar.setVisibility(8);
                    this.mProgressControl.b();
                }
                downloadTaskInfo = new StringBuilder();
                downloadTaskInfo.append(this.mProgressControl.getSaveKey());
                downloadTaskInfo.append("=statedelete");
                return;
            default:
                break;
        }
        if (downloadTaskInfo.getTaskStatus() == 4 || downloadTaskInfo.getTaskStatus() == 2) {
            long j = 0;
            if (downloadTaskInfo.mFileSize > 0) {
                j = (downloadTaskInfo.mDownloadedSize * 100) / downloadTaskInfo.mFileSize;
            }
            this.mProgressControl.a((int) j);
        }
        if (com.xunlei.downloadprovider.download.tasklist.task.r.a(downloadTaskInfo) != null) {
            this.mProgressControl.a();
        } else {
            this.mProgressControl.b();
        }
    }

    private void updateTaskStatusInfo(DownloadTaskInfo downloadTaskInfo) {
        setTaskProgress(downloadTaskInfo);
        if (downloadTaskInfo.getTaskStatus() == 2) {
            this.mRunningStatusLayout.setVisibility(0);
            this.mStatusLayout.setVisibility(8);
            setRunningTaskStatusInfo(downloadTaskInfo);
            return;
        }
        this.mRunningStatusLayout.setVisibility(8);
        if (this.mCardStyle == 3) {
            this.mRemainTextView2.setVisibility(8);
        }
        this.mStatusLayout.setVisibility(0);
        this.mStatusImageView.setVisibility(8);
        if (downloadTaskInfo.getTaskStatus() == 1) {
            downloadTaskInfo = this.mStatusTextView.getContext().getResources().getString(R.string.download_item_task_status_waiting);
            if (this.mCardStyle == 3) {
                this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColorStyle2));
            } else {
                this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
            }
            this.mStatusTextView.setText(downloadTaskInfo);
        } else if (downloadTaskInfo.getTaskStatus() == 4) {
            CharSequence string = this.mStatusTextView.getContext().getResources().getString(R.string.download_item_task_status_paused);
            if (this.mCardStyle == 3) {
                this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColorStyle2));
            } else {
                this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
            }
            this.mStatusTextView.setText(string);
            if (downloadTaskInfo.mFailureReason == 1006) {
                this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemErrorStatusTextColor));
                if (this.mCardStyle == 3) {
                    this.mStatusImageView.setImageDrawable(getDrawable(R.drawable.ic_detail_download_error_style2));
                } else {
                    this.mStatusImageView.setImageDrawable(getDrawable(R.drawable.ic_detail_download_error));
                }
                this.mStatusImageView.setVisibility(0);
                checkExceptionBanner(downloadTaskInfo);
                if (com.xunlei.downloadprovider.download.tasklist.list.banner.b.d.a().b(downloadTaskInfo) != null) {
                    this.mStatusTextView.setText("下载失败");
                }
            }
        } else if (downloadTaskInfo.getTaskStatus() == 8) {
            setFinishedTaskStatusInfo(downloadTaskInfo);
        } else {
            if (downloadTaskInfo.getTaskStatus() == 16) {
                setFailedTaskStatusInfo(downloadTaskInfo);
                checkExceptionBanner(downloadTaskInfo);
            }
        }
    }

    private void setFinishedTaskStatusInfo(DownloadTaskInfo downloadTaskInfo) {
        setTagLayoutParams(true);
        if (this.mCardStyle == 3) {
            this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColorStyle2));
        } else {
            this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
        }
        EFileCategoryType a = r.a(downloadTaskInfo);
        if (downloadTaskInfo.mIsFileMissing) {
            this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColor));
            this.mStatusTextView.setText(R.string.download_item_task_file_not_exist);
            return;
        }
        if (this.mCardStyle == 3) {
            this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColorStyle2));
        } else {
            this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColor));
        }
        if (a == EFileCategoryType.E_VIDEO_CATEGORY) {
            this.mTagPlay.setVisibility(8);
            this.isTagPlayVisible = false;
            if (downloadTaskInfo.isConsumed()) {
                this.mStatusImageView.setVisibility(8);
                if (this.mCardStyle == 3) {
                    this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColorStyle2));
                } else {
                    this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
                }
                this.mStatusTextView.setText(R.string.download_item_task_status_success);
            } else {
                this.mStatusTextView.setText(R.string.download_item_task_download_finish);
                if (this.mCardStyle == 3) {
                    this.mStatusImageView.setVisibility(0);
                    this.mStatusImageView.setImageDrawable(getDrawable(R.drawable.ic_detail_download_finish));
                    this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemDownloadFinishTextColorStyle2));
                }
            }
            StringBuilder stringBuilder = new StringBuilder("  duration:  ");
            stringBuilder.append(downloadTaskInfo.mVideoDuration);
            stringBuilder.append(" play: ");
            stringBuilder.append(downloadTaskInfo.mVideoPlayedTime);
            if (downloadTaskInfo.mVideoDuration > 0) {
                this.mStatusImageView.setVisibility(8);
                if (downloadTaskInfo.mVideoDuration != downloadTaskInfo.mVideoPlayedTime || downloadTaskInfo.mVideoPlayedTime <= 0) {
                    String str = "0%";
                    if (downloadTaskInfo.mVideoPlayedTime > 0) {
                        if ((downloadTaskInfo.mVideoPlayedTime * 100) / downloadTaskInfo.mVideoDuration <= 1) {
                            str = "1%";
                        } else {
                            stringBuilder = new StringBuilder();
                            stringBuilder.append((downloadTaskInfo.mVideoPlayedTime * 100) / downloadTaskInfo.mVideoDuration);
                            stringBuilder.append("%");
                            str = stringBuilder.toString();
                        }
                    }
                    if (this.mCardStyle == 3) {
                        this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColorStyle2));
                    } else {
                        this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemHintStatusTextColor));
                    }
                    this.mStatusTextView.setText(getContext().getResources().getString(R.string.download_item_task_play_at, new Object[]{str}));
                    return;
                }
                if (this.mCardStyle == 3) {
                    this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColorStyle2));
                } else {
                    this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemStatusTextColor));
                }
                this.mStatusTextView.setText(R.string.download_item_task_played);
            }
        } else if (a == EFileCategoryType.E_SOFTWARE_CATEGORY) {
            if (ApkHelper.isApkPackageFileInstalled(this.mContext, downloadTaskInfo.mLocalFileName) != null) {
                this.mStatusTextView.setText(R.string.download_item_task_have_install);
            } else if (this.mCardStyle == 3) {
                this.mStatusImageView.setVisibility(0);
                this.mStatusImageView.setImageDrawable(getDrawable(R.drawable.ic_detail_download_finish));
                this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemDownloadFinishTextColorStyle2));
                this.mStatusTextView.setText(R.string.download_item_task_download_finish);
            } else {
                this.mStatusTextView.setText(R.string.download_item_task_never_install);
            }
        } else if (this.mCardStyle == 3) {
            if (downloadTaskInfo.isConsumed() != null) {
                this.mStatusTextView.setText(R.string.download_item_task_have_open);
                return;
            }
            this.mStatusImageView.setVisibility(0);
            this.mStatusImageView.setImageDrawable(getDrawable(R.drawable.ic_detail_download_finish));
            this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemDownloadFinishTextColorStyle2));
            this.mStatusTextView.setText(R.string.download_item_task_download_finish);
        } else if (downloadTaskInfo.isConsumed() != null) {
            this.mStatusTextView.setText(R.string.download_item_task_have_open);
        } else {
            this.mStatusTextView.setText(R.string.download_item_task_status_success);
        }
    }

    private void setTagLayoutParams(boolean z) {
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (!z || this.mCardStyle) {
            layoutParams.rightMargin = false;
        } else {
            layoutParams.rightMargin = DipPixelUtil.dip2px(true);
        }
        layoutParams.addRule(3, true);
        this.mTagLayout.setLayoutParams(layoutParams);
    }

    private void updateFreeTrail(DownloadTaskInfo downloadTaskInfo) {
        this.mFreeTrailView.a = null;
        this.mFreeTrailView.a(downloadTaskInfo.getTaskId());
        if (!BannerManager.a().a(BannerManager$BannerType.TYPE_FREE_TRIAL, downloadTaskInfo.getTaskId())) {
            n.a();
            TaskInfo f = n.f(downloadTaskInfo.getTaskId());
            if (downloadTaskInfo != null) {
                if (f != null) {
                    if (!LoginHelper.a().g.g()) {
                        StringBuilder stringBuilder = new StringBuilder("time: ");
                        stringBuilder.append(f.mFreeTrialTimes);
                        stringBuilder.append(" taskId: ");
                        stringBuilder.append(downloadTaskInfo.getTaskId());
                        int i = com.xunlei.downloadprovider.download.c.a.a().e == downloadTaskInfo.getTaskId() ? 1 : 0;
                        if (i != 0) {
                            long d = com.xunlei.downloadprovider.download.c.a.a().d();
                            if (f.mDownloadedSize < d) {
                                stringBuilder = new StringBuilder("title = ");
                                stringBuilder.append(f.mTitle);
                                stringBuilder.append("   mCurrentTask.mDownloadedSize = ");
                                stringBuilder.append(f.mDownloadedSize);
                                stringBuilder.append("   before: ");
                                stringBuilder.append(d);
                                stringBuilder = new StringBuilder("size: ");
                                stringBuilder.append(f.mDownloadedSize);
                                stringBuilder.append("   before: ");
                                stringBuilder.append(d);
                                this.mFreeTrailView.a(downloadTaskInfo.getTaskId());
                                if (com.xunlei.downloadprovider.download.c.a.a().b()) {
                                    com.xunlei.downloadprovider.download.c.a.a().e();
                                }
                                com.xunlei.downloadprovider.download.c.a.a().b(downloadTaskInfo.getTaskId(), com.xunlei.downloadprovider.download.c.a.c);
                                com.xunlei.downloadprovider.download.c.a.a().d(-1);
                                return;
                            }
                        }
                        if (shouldShowFreeTrial(downloadTaskInfo)) {
                            if (com.xunlei.downloadprovider.download.c.a.a().a(downloadTaskInfo.getTaskId())) {
                                BannerManager.a().a(true, BannerManager$BannerType.TYPE_FREE_TRIAL, downloadTaskInfo.getTaskId(), null);
                                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                                com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(downloadTaskInfo.getTaskId());
                                c.a((TaskInfo) downloadTaskInfo);
                                processEnteredFreeTrial(downloadTaskInfo);
                            } else if (f.mFreeTrialTimes > 0 || i != 0) {
                                processCheckFreeTrial(downloadTaskInfo);
                            }
                            if (this.mFreeTrailView.h() == 0 && this.mFreeTrailView.a != null && this.mFreeTrailView.a == this.mTaskInfo) {
                                setVipSpeedupButtonGone();
                                if (downloadTaskInfo.getTaskStatus() == 2 && this.mCardStyle == 3 && this.mRemainTextView.getVisibility() != 0 && downloadTaskInfo.mDownloadRemainTime > 0) {
                                    downloadTaskInfo = com.xunlei.downloadprovider.download.util.a.a(getContext(), downloadTaskInfo.mDownloadRemainTime);
                                    this.mRemainTextView2.setVisibility(0);
                                    this.mRemainTextView2.setText(downloadTaskInfo);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void setVipSpeedupButtonGone() {
        if (this.mVipSpeedupButton != null) {
            if (this.mTaskInfo != null) {
                this.mVipSpeedupButton.setVisibility(8);
                this.mTaskInfo.mShowSpeedupButton = false;
                if (!(this.mAdapter == null || this.mAdapter.g == null)) {
                    List list = this.mAdapter.g.h;
                    if (list.contains(this.mTaskInfo.mUrl)) {
                        list.remove(this.mTaskInfo.mUrl);
                    }
                }
            }
        }
    }

    private void processEnteredFreeTrial(DownloadTaskInfo downloadTaskInfo) {
        DownloadTaskInfo downloadTaskInfo2 = downloadTaskInfo;
        boolean z = false;
        this.mFreeTrailView.d(0);
        this.mFreeTrailView.a(1);
        this.mFreeTrailView.a(downloadTaskInfo2, false);
        this.mFreeTrailView.a = downloadTaskInfo2;
        BannerManager.a().a(true, BannerManager$BannerType.TYPE_FREE_TRIAL, downloadTaskInfo.getTaskId(), null);
        String str = "";
        long j = downloadTaskInfo2.mDownloadRemainTime;
        n.a();
        TaskSpeedCountInfo m = n.m(downloadTaskInfo.getTaskId());
        long j2 = (downloadTaskInfo2.mDownloadedSize <= 0 || downloadTaskInfo2.mDownloadDurationTime <= 0) ? 0 : (long) (((((float) downloadTaskInfo2.mDownloadedSize) * 1.0f) / ((float) downloadTaskInfo2.mDownloadDurationTime)) * 1000.0f);
        if (m == null) {
            m = new TaskSpeedCountInfo();
            m.mHighestSpeed = downloadTaskInfo2.mDownloadSpeed;
        } else if (downloadTaskInfo2.mDownloadSpeed > m.mHighestSpeed) {
            m.mHighestSpeed = downloadTaskInfo2.mDownloadSpeed;
        }
        if (m.mHighestSpeed < j2) {
            m.mHighestSpeed = j2 + (j2 / 3);
        }
        long j3 = m.mHighestSpeed;
        if (j3 > 0) {
            j3 = (downloadTaskInfo2.mFileSize - downloadTaskInfo2.mDownloadedSize) / j3;
            if (j3 > 0) {
                j = j3;
            }
        }
        if (j <= 0) {
            j = 1;
        }
        if (j > 0) {
            long j4 = j / 60;
            StringBuilder stringBuilder;
            if (j4 <= 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(j);
                stringBuilder.append("秒");
                str = stringBuilder.toString();
            } else if (j4 > 99) {
                long hour = DateTimeUtil.getHour(j);
                j = DateTimeUtil.getMinite(j) > 30 ? hour + 1 : hour;
                stringBuilder = new StringBuilder();
                stringBuilder.append(j);
                stringBuilder.append("小时");
                str = stringBuilder.toString();
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(j4);
                stringBuilder.append("分钟");
                str = stringBuilder.toString();
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder(" speed : ");
        stringBuilder2.append(downloadTaskInfo2.mVipAcceleratedSpeed);
        stringBuilder2.append("  ");
        stringBuilder2.append(downloadTaskInfo.getTaskId());
        stringBuilder2.append(" statusCode: ");
        stringBuilder2.append(downloadTaskInfo2.mVipChannelStatus);
        stringBuilder2.append(" code: ");
        stringBuilder2.append(downloadTaskInfo2.mVipChannelStatusCode);
        j = k.i(downloadTaskInfo);
        boolean a = k.a(downloadTaskInfo2, j);
        StringBuilder stringBuilder3 = new StringBuilder("remainSize:  ");
        stringBuilder3.append(j);
        stringBuilder3.append("   freeTrialOver: ");
        stringBuilder3.append(a);
        if (a) {
            boolean z2;
            com.xunlei.downloadprovider.download.tasklist.list.banner.c.a aVar;
            String charSequence;
            com.xunlei.downloadprovider.download.tasklist.list.banner.c.a aVar2;
            String string;
            long b;
            int i;
            int i2;
            StringBuilder stringBuilder4;
            CharSequence spannableStringBuilder;
            com.xunlei.downloadprovider.download.c.a a2 = com.xunlei.downloadprovider.download.c.a.a();
            long taskId = downloadTaskInfo.getTaskId();
            if (a2.k != null) {
                com.xunlei.downloadprovider.download.c.a.a aVar3 = (com.xunlei.downloadprovider.download.c.a.a) a2.k.get(Long.valueOf(taskId));
                if (aVar3 != null && aVar3.b == com.xunlei.downloadprovider.download.c.a.c) {
                    z2 = true;
                    if (!z2) {
                        com.xunlei.downloadprovider.download.c.a.a().a(downloadTaskInfo.getTaskId(), com.xunlei.downloadprovider.download.c.a.c);
                        com.xunlei.downloadprovider.download.c.a.a().e();
                        com.xunlei.downloadprovider.download.c.a.a().d(-1);
                    }
                    r0.mFreeTrailView.a(com.xunlei.downloadprovider.download.c.a.k());
                    aVar = r0.mFreeTrailView;
                    charSequence = (aVar.d != null || aVar.d.h == null) ? "" : aVar.d.h.getText().toString();
                    aVar2 = r0.mFreeTrailView;
                    if (!aVar2.g) {
                        aVar2.g = true;
                        aVar2.e.setBackgroundResource(R.drawable.user_member_btn_bling);
                        aVar2.e.setLayoutParams(new FrameLayout.LayoutParams(aVar2.d.i.getWidth(), aVar2.d.i.getHeight()));
                        aVar2.e.setVisibility(0);
                        c.a(aVar2.e);
                    }
                    string = getContext().getString(R.string.save_time_tip_after_speedup_finish);
                    b = c.b(downloadTaskInfo);
                    if (!c.a(b)) {
                        r0.mFreeTrailView.a(com.xunlei.downloadprovider.download.c.a.a(str));
                        r0.mFreeTrailView.b((int) R.color.task_card_title_color_disable);
                    } else if (!charSequence.contains(string)) {
                        str = getContext().getString(R.string.format_save_time_tip_after_speedup_finish, new Object[]{Long.valueOf(b)});
                        if (b >= 60) {
                            i = (int) b;
                            i2 = i / 60;
                            i %= 60;
                            charSequence = getContext().getString(R.string.format_save_time_h_tip_after_speedup_finish, new Object[]{Integer.valueOf(i2)});
                            if (i <= 0) {
                                stringBuilder4 = new StringBuilder();
                                stringBuilder4.append(charSequence);
                                stringBuilder4.append(getContext().getString(R.string.format_save_time_tip_after_speedup_finish, new Object[]{Integer.valueOf(i)}));
                                str = stringBuilder4.toString();
                            } else {
                                str = charSequence;
                            }
                        }
                        stringBuilder2 = new StringBuilder();
                        stringBuilder2.append(string);
                        stringBuilder2.append(str);
                        spannableStringBuilder = new SpannableStringBuilder(stringBuilder2.toString());
                        i = spannableStringBuilder.length();
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.task_card_title_color_disable)), 0, string.length(), 33);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.task_card_accent_color_orange)), string.length(), i, 33);
                        r0.mFreeTrailView.a(spannableStringBuilder);
                    }
                    if (com.xunlei.downloadprovider.download.c.a.a().e(downloadTaskInfo.getTaskId())) {
                        com.xunlei.downloadprovider.download.c.a.a().f(downloadTaskInfo.getTaskId());
                    }
                    if (k.d(downloadTaskInfo)) {
                        r0.mFreeTrailView.a(downloadTaskInfo.getTaskId());
                    }
                    return;
                }
            }
            z2 = false;
            if (z2) {
                com.xunlei.downloadprovider.download.c.a.a().a(downloadTaskInfo.getTaskId(), com.xunlei.downloadprovider.download.c.a.c);
                com.xunlei.downloadprovider.download.c.a.a().e();
                com.xunlei.downloadprovider.download.c.a.a().d(-1);
            }
            r0.mFreeTrailView.a(com.xunlei.downloadprovider.download.c.a.k());
            aVar = r0.mFreeTrailView;
            if (aVar.d != null) {
            }
            aVar2 = r0.mFreeTrailView;
            if (aVar2.g) {
                aVar2.g = true;
                aVar2.e.setBackgroundResource(R.drawable.user_member_btn_bling);
                aVar2.e.setLayoutParams(new FrameLayout.LayoutParams(aVar2.d.i.getWidth(), aVar2.d.i.getHeight()));
                aVar2.e.setVisibility(0);
                c.a(aVar2.e);
            }
            string = getContext().getString(R.string.save_time_tip_after_speedup_finish);
            b = c.b(downloadTaskInfo);
            if (!c.a(b)) {
                r0.mFreeTrailView.a(com.xunlei.downloadprovider.download.c.a.a(str));
                r0.mFreeTrailView.b((int) R.color.task_card_title_color_disable);
            } else if (charSequence.contains(string)) {
                str = getContext().getString(R.string.format_save_time_tip_after_speedup_finish, new Object[]{Long.valueOf(b)});
                if (b >= 60) {
                    i = (int) b;
                    i2 = i / 60;
                    i %= 60;
                    charSequence = getContext().getString(R.string.format_save_time_h_tip_after_speedup_finish, new Object[]{Integer.valueOf(i2)});
                    if (i <= 0) {
                        str = charSequence;
                    } else {
                        stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(charSequence);
                        stringBuilder4.append(getContext().getString(R.string.format_save_time_tip_after_speedup_finish, new Object[]{Integer.valueOf(i)}));
                        str = stringBuilder4.toString();
                    }
                }
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(str);
                spannableStringBuilder = new SpannableStringBuilder(stringBuilder2.toString());
                i = spannableStringBuilder.length();
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.task_card_title_color_disable)), 0, string.length(), 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.task_card_accent_color_orange)), string.length(), i, 33);
                r0.mFreeTrailView.a(spannableStringBuilder);
            }
            if (com.xunlei.downloadprovider.download.c.a.a().e(downloadTaskInfo.getTaskId())) {
                com.xunlei.downloadprovider.download.c.a.a().f(downloadTaskInfo.getTaskId());
            }
            if (k.d(downloadTaskInfo)) {
                r0.mFreeTrailView.a(downloadTaskInfo.getTaskId());
            }
            return;
        }
        r0.mFreeTrailView.b((int) R.color.task_card_title_color_disable);
        if (downloadTaskInfo2.mVipChannelStatus == 16) {
            if (!com.xunlei.downloadprovider.download.c.a.a().f) {
                com.xunlei.downloadprovider.download.c.a.a().f = true;
            }
            r0.mFreeTrailView.a(2);
            r0.mFreeTrailView.a(com.xunlei.downloadprovider.download.c.a.i());
            return;
        }
        com.xunlei.downloadprovider.download.c.a.a aVar4 = (com.xunlei.downloadprovider.download.c.a.a) com.xunlei.downloadprovider.download.c.a.a().k.get(Long.valueOf(downloadTaskInfo.getTaskId()));
        if (aVar4 != null && aVar4.d >= com.xunlei.downloadprovider.download.c.a.a) {
            z = true;
        }
        if (z) {
            r0.mFreeTrailView.a(downloadTaskInfo.getTaskId());
            return;
        }
        if (downloadTaskInfo.getTaskStatus() != 4) {
            if (downloadTaskInfo.getTaskStatus() != 16) {
                CharSequence c;
                if (j < 10485760) {
                    c = com.xunlei.downloadprovider.download.c.a.c(str);
                } else {
                    c = com.xunlei.downloadprovider.download.c.a.b(ConvertUtil.byteConvert(j));
                }
                r0.mFreeTrailView.a(c);
                return;
            }
        }
        r0.mFreeTrailView.a(com.xunlei.downloadprovider.download.c.a.j());
    }

    private void processCheckFreeTrial(DownloadTaskInfo downloadTaskInfo) {
        long j = com.xunlei.downloadprovider.download.c.a.a().e;
        if (!(k.d(downloadTaskInfo) || downloadTaskInfo.getTaskStatus() == 1 || downloadTaskInfo.getTaskStatus() == 16)) {
            if (downloadTaskInfo.getTaskStatus() != 1) {
                if (downloadTaskInfo.mFileSize < 209715200) {
                    checkFreeTrialTask(downloadTaskInfo.getTaskId(), j);
                    return;
                } else if (!com.xunlei.downloadprovider.download.c.a.a().e(downloadTaskInfo.getTaskId())) {
                    return;
                } else {
                    if (downloadTaskInfo.mFileSize <= 0 || (((float) downloadTaskInfo.mDownloadedSize) * 1.0f) / ((float) downloadTaskInfo.mFileSize) <= 0.7f) {
                        int i = downloadTaskInfo.mFreeTrialTimes;
                        StringBuilder stringBuilder = new StringBuilder("time: ");
                        stringBuilder.append(i);
                        stringBuilder.append(" curentId: ");
                        stringBuilder.append(j);
                        if (downloadTaskInfo.getTaskId() == j || (j == -1 && i > 0)) {
                            this.mFreeTrailView.d(0);
                            BannerManager.a().a(true, BannerManager$BannerType.TYPE_FREE_TRIAL, downloadTaskInfo.getTaskId(), null);
                            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a();
                            com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a.a(downloadTaskInfo.getTaskId());
                            this.mFreeTrailView.a(0);
                            this.mFreeTrailView.a(downloadTaskInfo, true);
                            CharSequence h = com.xunlei.downloadprovider.download.c.a.a().h();
                            this.mFreeTrailView.a = downloadTaskInfo;
                            this.mFreeTrailView.a(h);
                            this.mFreeTrailView.b((int) R.color.task_card_accent_color_orange);
                            if (j == -1) {
                                com.xunlei.downloadprovider.download.c.a.a().d(downloadTaskInfo.getTaskId());
                                com.xunlei.downloadprovider.download.report.a.a(downloadTaskInfo.mDownloadSpeed, com.xunlei.downloadprovider.download.tasklist.list.banner.c.f.a().e(), downloadTaskInfo.getTaskId());
                            }
                            StringBuilder stringBuilder2 = new StringBuilder("the trial task: ");
                            stringBuilder2.append(downloadTaskInfo.getTaskId());
                            stringBuilder2.append(" time: ");
                            stringBuilder2.append(i);
                        }
                        return;
                    }
                    checkFreeTrialTask(downloadTaskInfo.getTaskId(), j);
                    return;
                }
            }
        }
        if (downloadTaskInfo.getTaskId() == com.xunlei.downloadprovider.download.c.a.a().e) {
            com.xunlei.downloadprovider.download.c.a.a().d(-1);
        }
    }

    private void checkFreeTrialTask(long j, long j2) {
        if (j == j2) {
            com.xunlei.downloadprovider.download.c.a.a().d(-1);
            com.xunlei.downloadprovider.download.c.a.a().b(j, com.xunlei.downloadprovider.download.c.a.a);
        }
    }

    private static boolean shouldShowFreeTrial(DownloadTaskInfo downloadTaskInfo) {
        LoginHelper.a();
        if ((!com.xunlei.downloadprovider.member.login.b.l.b() || !LoginHelper.a().l()) && com.xunlei.downloadprovider.download.c.a.a().b(downloadTaskInfo.getTaskId()) == null) {
            return true;
        }
        return false;
    }

    private void setRunningTaskStatusInfo(DownloadTaskInfo downloadTaskInfo) {
        int i = 1;
        if (downloadTaskInfo.mDownloadSpeed < 1) {
            this.mSpeedupSpeedTextView.setVisibility(8);
            this.mSpeedTextView.setText(R.string.download_item_task_status_linking);
        } else {
            this.mSpeedTextView.setText(com.xunlei.downloadprovider.download.util.a.a(downloadTaskInfo.mDownloadSpeed));
            if (!downloadTaskInfo.mHasVipChannelSpeedup) {
                if (downloadTaskInfo.mVipAcceleratedSpeed <= 100) {
                    this.mSpeedupSpeedTextView.setVisibility(8);
                }
            }
            this.mSpeedupSpeedTextView.setVisibility(0);
            SpeedupFailureCode b = DownloadError.b(downloadTaskInfo);
            if (b == null || downloadTaskInfo.mVipAcceleratedSpeed >= 100) {
                if (this.mCardStyle == 3) {
                    this.mSpeedupSpeedTextView.setTextColor(getContext().getResources().getColor(R.color.task_card_accent_color_blue_style2));
                } else {
                    this.mSpeedupSpeedTextView.setTextColor(getContext().getResources().getColor(R.color.task_card_accent_color_blue));
                }
                this.mSpeedupSpeedTextView.setText(String.format("(+ %s)", new Object[]{com.xunlei.downloadprovider.download.util.a.a(downloadTaskInfo.mVipAcceleratedSpeed)}));
                if (downloadTaskInfo.mDownloadRemainTime > 0) {
                    downloadTaskInfo = com.xunlei.downloadprovider.download.util.a.a(getContext(), downloadTaskInfo.mDownloadRemainTime);
                    if (i == 0 && this.mCardStyle == 3 && this.mVipSpeedupButton.getVisibility() != 0) {
                        this.mRemainTextView.setVisibility(8);
                        this.mRemainTextView2.setVisibility(0);
                        setVipSpeedupButtonGone();
                        this.mRemainTextView2.setText(downloadTaskInfo);
                        return;
                    }
                    this.mRemainTextView.setVisibility(0);
                    if (this.mCardStyle == 3) {
                        this.mRemainTextView2.setVisibility(8);
                    }
                    this.mRemainTextView.setText(downloadTaskInfo);
                    return;
                }
                this.mRemainTextView.setVisibility(8);
                if (this.mCardStyle == 3) {
                    this.mRemainTextView2.setVisibility(8);
                }
            }
            String string;
            if (b == SpeedupFailureCode.SENSITIVE_RESOURCE_LIMITED) {
                if (isEditMode() && this.mCardStyle == 3) {
                    string = getContext().getResources().getString(R.string.download_item_task_speedup_fail_sensitive_resource_limited_editmode);
                } else {
                    string = getContext().getResources().getString(R.string.download_item_task_speedup_fail_sensitive_resource_limited);
                }
            } else if (b != SpeedupFailureCode.SHORT_OF_FLOW) {
                string = getContext().getResources().getString(R.string.download_item_task_speedup_fail);
            } else if (isEditMode() && this.mCardStyle == 3) {
                string = getContext().getResources().getString(R.string.download_item_task_speedup_fail_short_of_flow_editmode);
            } else {
                string = getContext().getResources().getString(R.string.download_item_task_speedup_fail_short_of_flow);
            }
            StringBuilder stringBuilder = new StringBuilder(com.umeng.message.proguard.k.s);
            stringBuilder.append(string);
            stringBuilder.append(com.umeng.message.proguard.k.t);
            Object stringBuilder2 = stringBuilder.toString();
            CharSequence spannableString = new SpannableString(stringBuilder2);
            spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.DownloadTaskItemSpeedupErrorStatusTextColor)), 0, stringBuilder2.length(), 34);
            this.mSpeedupSpeedTextView.setText(spannableString);
            if (downloadTaskInfo.mDownloadRemainTime > 0) {
                this.mRemainTextView.setVisibility(8);
                if (this.mCardStyle == 3) {
                    this.mRemainTextView2.setVisibility(8);
                }
            }
            downloadTaskInfo = com.xunlei.downloadprovider.download.util.a.a(getContext(), downloadTaskInfo.mDownloadRemainTime);
            if (i == 0) {
            }
            this.mRemainTextView.setVisibility(0);
            if (this.mCardStyle == 3) {
                this.mRemainTextView2.setVisibility(8);
            }
            this.mRemainTextView.setText(downloadTaskInfo);
            return;
        }
        i = 0;
        if (downloadTaskInfo.mDownloadRemainTime > 0) {
            downloadTaskInfo = com.xunlei.downloadprovider.download.util.a.a(getContext(), downloadTaskInfo.mDownloadRemainTime);
            if (i == 0) {
            }
            this.mRemainTextView.setVisibility(0);
            if (this.mCardStyle == 3) {
                this.mRemainTextView2.setVisibility(8);
            }
            this.mRemainTextView.setText(downloadTaskInfo);
            return;
        }
        this.mRemainTextView.setVisibility(8);
        if (this.mCardStyle == 3) {
            this.mRemainTextView2.setVisibility(8);
        }
    }

    private void setFailedTaskStatusInfo(DownloadTaskInfo downloadTaskInfo) {
        if (this.mCardStyle == 3) {
            this.mStatusImageView.setImageDrawable(getDrawable(R.drawable.ic_detail_download_error_style2));
        } else {
            this.mStatusImageView.setImageDrawable(getDrawable(R.drawable.ic_detail_download_error));
        }
        this.mStatusTextView.setTextColor(getContext().getResources().getColor(R.color.DownloadTaskItemErrorStatusTextColor));
        this.mStatusTextView.setText(getFailureReasonString(downloadTaskInfo));
        this.mStatusImageView.setVisibility(0);
        com.xunlei.downloadprovider.cooperation.ui.b a = com.xunlei.downloadprovider.cooperation.ui.b.a();
        if (!a.d && this.mDownloadCenterControl != null) {
            Activity activity = this.mDownloadCenterControl.a;
            if (activity != null && ((!((activity instanceof ShortMovieDetailActivity) || q.a(activity)) || a.c) && DownloadError.a((TaskInfo) downloadTaskInfo) == FailureCode.INSUFFICIENT_SPACE)) {
                com.xunlei.downloadprovider.cooperation.ui.b.a().a(this.mContext, 1005);
            }
        }
    }

    private String getFailureReasonString(TaskInfo taskInfo) {
        return DownloadError.a(taskInfo, getContext());
    }

    private void updateTaskOperateButton(DownloadTaskInfo downloadTaskInfo) {
        boolean z = true;
        if (downloadTaskInfo.getTaskStatus() == 8) {
            this.mFinishedButtonLayout.setVisibility(0);
            setTagLayoutParams(true);
            this.mUnfinishedButtonLayout.setVisibility(8);
        } else {
            setTagLayoutParams(false);
            this.mFinishedButtonLayout.setVisibility(8);
            FailureCode a = DownloadError.a((TaskInfo) downloadTaskInfo);
            boolean z2 = a != null && (a.equals(FailureCode.TASK_CONTAINS_ILLEGAL_CONTENT) || a.equals(FailureCode.ABNORMAL_ACCOUNT) || a.equals(FailureCode.CONTRARY_LOCAL_LAWS_AND_REQULATIONS) || a.equals(FailureCode.REQUEST_OF_COPYRIGHT_OWNERS));
            this.mUnfinishedButtonLayout.setVisibility(!z2 ? 0 : 8);
            if (z2) {
                setVipSpeedupButtonGone();
            }
        }
        setVipSpeedupButtonGone();
        if ((downloadTaskInfo.getTaskStatus() == 2 || downloadTaskInfo.getTaskStatus() == 1) && !downloadTaskInfo.mHasVipChannelSpeedup) {
            this.mVipSpeedupButton.setVisibility(0);
            if (this.mRemainTextView2 != null) {
                this.mRemainTextView2.setVisibility(8);
            }
            downloadTaskInfo.mShowSpeedupButton = true;
            this.mVipSpeedupButton.setOnClickListener(this.mOnTaskVipSpeedupClickListener);
            if (!(this.mAdapter == null || this.mAdapter.g == null)) {
                List list = this.mAdapter.g.h;
                if (!list.contains(downloadTaskInfo.mUrl)) {
                    list.add(downloadTaskInfo.mUrl);
                }
            }
        }
        this.mOperateButton.setOnClickListener(null);
        this.mUnfinishedButtonLayout.setOnClickListener(null);
        this.mOperateButton.setPressed(false);
        if (downloadTaskInfo.getTaskStatus() == 8) {
            this.mRedownloadButton.setPressed(false);
            if (downloadTaskInfo.mIsFileMissing) {
                this.mRedownloadButton.setVisibility(0);
                this.mRedownloadButton.setOnClickListener(this.mOnTaskOperateRestartClickListener);
                if (this.mCardStyle == 3) {
                    this.mFinishedButtonLayout.setOnClickListener(this.mOnTaskOperateRestartClickListener);
                }
            } else {
                this.mRedownloadButton.setVisibility(8);
                if (z) {
                    setOpenButtonType(0, null);
                } else if (downloadTaskInfo.mTaskType != TaskType.MAGNET) {
                    setOpenButtonType(4, this.mTaskOpenButtonOnClickListener);
                } else {
                    switch (h.a[r.a(downloadTaskInfo).ordinal()]) {
                        case 1:
                            updateTaskButtonForOpenVideo(downloadTaskInfo);
                            return;
                        case 2:
                            updateTaskButtonForOpenApk(downloadTaskInfo);
                            return;
                        default:
                            setOpenButtonType(4, this.mTaskOpenButtonOnClickListener);
                            return;
                    }
                }
            }
        } else if (downloadTaskInfo.getTaskStatus() == 4) {
            this.mOperateButton.setVisibility(0);
            setOperateButtonType(1);
        } else if (downloadTaskInfo.getTaskStatus() == 1) {
            this.mOperateButton.setVisibility(0);
            setOperateButtonType(2);
        } else if (downloadTaskInfo.getTaskStatus() == 2) {
            this.mOperateButton.setVisibility(0);
            setOperateButtonType(2);
        } else if (downloadTaskInfo.getTaskStatus() == 16) {
            if (DownloadError.c(downloadTaskInfo)) {
                this.mOperateButton.setVisibility(8);
            } else {
                this.mOperateButton.setVisibility(0);
                setOperateButtonType(3);
            }
        }
        z = false;
        if (z) {
            setOpenButtonType(0, null);
        } else if (downloadTaskInfo.mTaskType != TaskType.MAGNET) {
            switch (h.a[r.a(downloadTaskInfo).ordinal()]) {
                case 1:
                    updateTaskButtonForOpenVideo(downloadTaskInfo);
                    return;
                case 2:
                    updateTaskButtonForOpenApk(downloadTaskInfo);
                    return;
                default:
                    setOpenButtonType(4, this.mTaskOpenButtonOnClickListener);
                    return;
            }
        } else {
            setOpenButtonType(4, this.mTaskOpenButtonOnClickListener);
        }
    }

    private void setOperateButtonType(int i) {
        int i2 = this.mCardStyle == 3 ? 1 : 0;
        switch (i) {
            case 1:
                this.mOperateButton.setOnClickListener(this.mOnTaskOperateResumeClickListener);
                if (i2 != 0) {
                    this.mOperateButton.setBackgroundResource(R.drawable.task_download_card_resume_btn_style2_selector);
                    this.mUnfinishedButtonLayout.setOnClickListener(this.mOnTaskOperateResumeClickListener);
                    return;
                }
                this.mOperateButton.setText(R.string.download_item_button_start);
                this.mOperateButton.setTextAppearance(this.mOperateButton.getContext(), R.style.TaskCardBlueButtonAppearance);
                this.mOperateButton.setBackgroundResource(R.drawable.task_card_button_blue);
                i = getDrawable(R.drawable.download_item_resume_icon);
                if (i != 0) {
                    i.setBounds(0, 0, i.getMinimumWidth(), i.getMinimumHeight());
                }
                this.mOperateButton.setCompoundDrawables(i, null, null, null);
                return;
            case 2:
                this.mOperateButton.setOnClickListener(this.mOnTaskOperatePauseClickListener);
                if (i2 != 0) {
                    this.mOperateButton.setBackgroundResource(R.drawable.task_download_card_pause_btn_style2_selector);
                    this.mUnfinishedButtonLayout.setOnClickListener(this.mOnTaskOperatePauseClickListener);
                    return;
                }
                this.mOperateButton.setText(R.string.download_item_button_pause);
                this.mOperateButton.setTextAppearance(this.mOperateButton.getContext(), R.style.TaskCardGrayButtonAppearance);
                this.mOperateButton.setBackgroundResource(R.drawable.task_card_button_gray);
                i = getDrawable(R.drawable.download_item_pause_icon);
                if (i != 0) {
                    i.setBounds(0, 0, i.getMinimumWidth(), i.getMinimumHeight());
                }
                this.mOperateButton.setCompoundDrawables(i, null, null, null);
                return;
            case 3:
                this.mOperateButton.setOnClickListener(this.mOnTaskOperateFail2ResumeClickListener);
                if (i2 == 0) {
                    this.mOperateButton.setText(R.string.download_item_button_retry);
                    this.mOperateButton.setTextAppearance(this.mOperateButton.getContext(), R.style.TaskCardGrayButtonAppearance);
                    this.mOperateButton.setBackgroundResource(R.drawable.task_card_button_gray);
                    i = getDrawable(R.drawable.download_item_retry_icon);
                    if (i != 0) {
                        i.setBounds(0, 0, i.getMinimumWidth(), i.getMinimumHeight());
                    }
                    this.mOperateButton.setCompoundDrawables(i, null, null, null);
                    break;
                }
                this.mOperateButton.setBackgroundResource(R.drawable.task_download_card_retry_btn_style2_selector);
                this.mUnfinishedButtonLayout.setOnClickListener(this.mOnTaskOperateFail2ResumeClickListener);
                return;
            default:
                break;
        }
    }

    private void setOpenButtonType(int i, OnClickListener onClickListener) {
        int i2 = this.mCardStyle == 3 ? 1 : 0;
        if (i == 0) {
            this.mOpenButton.setVisibility(8);
            this.mOpenButton.setOnClickListener(null);
            this.mFinishedButtonLayout.setOnClickListener(null);
            this.mOpenPlayButton.setVisibility(8);
            this.mOpenPlayButton.setOnClickListener(null);
            return;
        }
        switch (i) {
            case 4:
                this.mOpenButton.setVisibility(0);
                this.mOpenPlayButton.setVisibility(8);
                if (i2 == 0) {
                    this.mOpenButton.setText(R.string.download_item_button_open);
                } else {
                    this.mFinishedButtonLayout.setOnClickListener(onClickListener);
                }
                this.mOpenButton.setOnClickListener(onClickListener);
                return;
            case 5:
                this.mOpenButton.setVisibility(8);
                this.mOpenPlayButton.setVisibility(0);
                this.mOpenPlayButton.setOnClickListener(onClickListener);
                if (i2 != 0) {
                    this.mFinishedButtonLayout.setOnClickListener(onClickListener);
                    return;
                }
                break;
            case 6:
                this.mOpenButton.setVisibility(0);
                this.mOpenPlayButton.setVisibility(8);
                if (i2 == 0) {
                    this.mOpenButton.setText(R.string.download_item_button_install);
                } else {
                    this.mFinishedButtonLayout.setOnClickListener(onClickListener);
                }
                this.mOpenButton.setOnClickListener(onClickListener);
                break;
            default:
                break;
        }
    }

    private void updateTaskButtonForOpenVideo(DownloadTaskInfo downloadTaskInfo) {
        if (downloadTaskInfo.getTaskStatus() == 8) {
            setOpenButtonType(5, this.mOnTaskVideoPlayClickListener);
        } else {
            setOpenButtonType(null, null);
        }
    }

    private void updateTaskButtonForOpenApk(DownloadTaskInfo downloadTaskInfo) {
        ApkHelper$ApkInfo apkInfo = ApkHelper.getApkInfo(getContext(), downloadTaskInfo.mLocalFileName);
        int i = 4;
        if (apkInfo != null) {
            int i2 = downloadTaskInfo.mAppInstalledType;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (downloadTaskInfo.mAppInstalledTypeLastModifyTime == 0 || elapsedRealtime - downloadTaskInfo.mAppInstalledTypeLastModifyTime >= 3000) {
                i2 = ApkHelper.compareLocalApp(getContext(), apkInfo);
                downloadTaskInfo.mAppInstalledType = i2;
                downloadTaskInfo.mAppInstalledTypeLastModifyTime = elapsedRealtime;
            }
            if (i2 != 4) {
                if (i2 != 5) {
                    i = 6;
                }
            }
        }
        setOpenButtonType(i, this.mTaskOpenApkButtonOnClickListener);
    }

    private void updateTaskIcon(DownloadTaskInfo downloadTaskInfo) {
        if (this.mCardStyle != 3) {
            this.mIconImageView.setAlpha(downloadTaskInfo.mIsFileMissing ? 0.75f : 1.0f);
        } else if (this.mCardStyle == 3 && downloadTaskInfo.mIsFileMissing) {
            this.mFinishedButtonLayout.setBackgroundColor(Color.parseColor("#4D000000"));
        } else if (this.mCardStyle == 3 && !downloadTaskInfo.mIsFileMissing) {
            this.mFinishedButtonLayout.setBackgroundResource(0);
        }
        if (this.mCardStyle == 0) {
            this.mSnapshotTagViewHolder.a(8);
            com.xunlei.downloadprovider.download.util.a.a.a();
            com.xunlei.downloadprovider.download.util.a.a.b(downloadTaskInfo, this.mIconImageView);
            return;
        }
        com.xunlei.downloadprovider.download.util.a.a.a();
        com.xunlei.downloadprovider.download.util.a.a.a(downloadTaskInfo, this.mIconImageView, this.mSnapshotTagViewHolder, b.f(), null);
    }

    @SuppressLint({"DefaultLocale"})
    public void updateTaskName(DownloadTaskInfo downloadTaskInfo) {
        CharSequence a = com.xunlei.downloadprovider.download.util.a.a(downloadTaskInfo, getContext());
        boolean b = k.b(downloadTaskInfo);
        this.mTitleTextView.setEnabled(downloadTaskInfo.mIsFileMissing ^ 1);
        if (b) {
            this.mTagNew.setVisibility(0);
        } else {
            this.mTagNew.setVisibility(8);
        }
        if (b) {
            this.mTitleTextView.setTextIndentPadding((float) Math.max(this.mTagNew.getWidth(), DipPixelUtil.dip2px(10.0f)));
        } else {
            this.mTitleTextView.setTextIndentPadding(0.0f);
        }
        this.mTitleTextView.setText(a);
        this.mTitleTextView.requestLayout();
    }

    public void onViewRecycled() {
        super.onViewRecycled();
        if (this.mSnapshotTagViewHolder != null) {
            this.mSnapshotTagViewHolder.a();
        }
    }

    private void fireOnPlayClick() {
        boolean s = com.xunlei.downloadprovider.d.d.a().d.s();
        boolean e = b.e();
        if (s && e) {
            com.xunlei.downloadprovider.download.control.a.a(getContext(), this.mTaskInfo, "dlcenter_play_btn");
            return;
        }
        com.xunlei.downloadprovider.download.control.a downloadCenterControl = getDownloadCenterControl();
        if (!(downloadCenterControl == null || this.mTaskInfo == null)) {
            if (this.mTaskInfo.getTaskStatus() == 8) {
                TaskInfo taskInfo = this.mTaskInfo;
                String tabid = getTabid();
                String str = "download_list";
                if (!b.e()) {
                    downloadCenterControl.a(taskInfo, tabid, str);
                } else if (!(taskInfo == null || taskInfo.mTaskType == TaskType.BT)) {
                    String str2 = taskInfo.mLocalFileName;
                    if (!TextUtils.isEmpty(str2)) {
                        if (!new File(str2).exists()) {
                            downloadCenterControl.a(taskInfo, tabid);
                        } else if (taskInfo.mFileSize == 0) {
                            XLToast.showToast(downloadCenterControl.a.getApplicationContext(), downloadCenterControl.a.getString(R.string.download_list_invalid_file));
                        } else {
                            taskInfo.setConsumed(true);
                            taskInfo.mRevision++;
                            com.xunlei.downloadprovider.download.engine.task.a.a.a.a().c(taskInfo.getTaskId());
                            if (XLFileTypeUtil.getFileCategoryTypeByName(str2) == EFileCategoryType.E_VIDEO_CATEGORY) {
                                com.xunlei.downloadprovider.download.report.a.a("dl_finish_open_video", "finish", tabid, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo.mCreateOrigin);
                            } else if (taskInfo != null) {
                                com.xunlei.downloadprovider.download.report.a.a("dl_finish_other", "finish", tabid, com.xunlei.downloadprovider.download.report.a.b(taskInfo), taskInfo.mCreateOrigin);
                            }
                            if (XLFileTypeUtil.isLocalVodSupport(str2)) {
                                VodPlayerActivityNew.a(BrothersApplication.getApplicationInstance(), taskInfo, null, str);
                            }
                        }
                    }
                }
                setTaskToSeen();
                return;
            }
            m.a(this.mTaskInfo.getTaskId(), -1, false);
            VodPlayerActivityNew.a(getContext(), this.mTaskInfo, null, "download_list");
        }
    }

    private void fireOnApkOpenClick() {
        com.xunlei.downloadprovider.download.control.a downloadCenterControl = getDownloadCenterControl();
        if (downloadCenterControl != null && this.mTaskInfo != null) {
            downloadCenterControl.a(this.mTaskInfo, getTabid(), "download_list");
            setTaskToSeen();
        }
    }

    private void fireOnTaskOpenClick() {
        com.xunlei.downloadprovider.download.control.a downloadCenterControl = getDownloadCenterControl();
        if (downloadCenterControl != null && this.mTaskInfo != null) {
            downloadCenterControl.a(this.mTaskInfo, getTabid(), "download_list");
            setTaskToSeen();
        }
    }

    private void fireOnTaskOperateClick(int i) {
        com.xunlei.downloadprovider.download.control.a downloadCenterControl = getDownloadCenterControl();
        if (!(downloadCenterControl == null || this.mTaskInfo == null)) {
            switch (i) {
                case 1:
                    com.xunlei.downloadprovider.download.control.a.a(this.mTaskInfo);
                    refreshSelf();
                    return;
                case 2:
                    downloadCenterControl.c(this.mTaskInfo);
                    refreshSelf();
                    return;
                case 3:
                    downloadCenterControl.b(this.mTaskInfo);
                    refreshSelf();
                    reSetWannaState();
                    return;
                case 4:
                    i = this.mTaskInfo;
                    p.a().c(i, false);
                    com.xunlei.downloadprovider.download.c.a.a().a(i);
                    refreshSelf();
                    return;
                case 5:
                    handlerVipSpeedupClick();
                    break;
                default:
                    break;
            }
        }
    }

    private void handlerVipSpeedupClick() {
        LoginHelper a = LoginHelper.a();
        com.xunlei.downloadprovider.download.control.a downloadCenterControl = getDownloadCenterControl();
        boolean g = a.g.g();
        if (com.xunlei.downloadprovider.member.login.b.l.c() && g) {
            n.a();
            n.d(false);
            long taskId = this.mTaskInfo.getTaskId();
            n.a();
            n.c(new long[]{taskId});
            return;
        }
        downloadCenterControl.a(this.mTaskInfo.getTaskId(), PayFrom.DOWNLOAD_LIST_SPEEDUP);
    }

    private void reSetWannaState() {
        if (this.mTaskInfo.getTaskStatus() == 16) {
            new Handler().postDelayed(new d(this), 6000);
        }
    }

    private void refreshPrivateSpaceUI() {
        this.mTaskHideFlagTv.setVisibility(PrivateSpaceMgr.a().a(this.mTaskInfo) ? 0 : 8);
    }

    private void initProgressType() {
        com.xunlei.downloadprovider.download.speedup.view.a aVar = new com.xunlei.downloadprovider.download.speedup.view.a(getContext());
        this.mProgressBar.removeAllViews();
        this.mProgressBar.addView(aVar.b);
        this.mProgressControl = aVar.a;
    }

    private void doVoucherPacketBannerVisibleAction(DownloadTaskInfo downloadTaskInfo) {
        if (!(isTaskInFreetrail(downloadTaskInfo) || downloadTaskInfo.mIsDisplayDownloadException || downloadTaskInfo.getTaskStatus() != 8 || downloadTaskInfo.mIsFileMissing)) {
            if (!BannerManager.a().a(BannerManager$BannerType.TYPE_VOUCHER_PACKET, downloadTaskInfo.getTaskId())) {
                com.xunlei.downloadprovider.download.tasklist.list.banner.f.a aVar = this.mVoucherPacketBanner;
                boolean z = false;
                if (!(downloadTaskInfo.getTaskStatus() == 8)) {
                    aVar.a(false, downloadTaskInfo);
                    return;
                } else if (com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a().a(downloadTaskInfo.getTaskId())) {
                    LoginHelper.a().a(aVar.e);
                    aVar.b = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a().c();
                    if (aVar.b != null) {
                        aVar.a.h.setText(aVar.b.list_page_title);
                        Glide.with(aVar.c).load(aVar.b.list_page_image).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).dontAnimate().into(aVar.a.a);
                    }
                    aVar.d = downloadTaskInfo;
                    aVar.a(true, downloadTaskInfo);
                    com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a().k();
                    aVar.a();
                    com.xunlei.downloadprovider.download.tasklist.list.banner.f.f a = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a();
                    long taskId = downloadTaskInfo.getTaskId();
                    a.o = aVar;
                    a.p = taskId;
                    if (a.c != null) {
                        a.d = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a(a.c.count_down);
                        if (a.d == 0) {
                            a.d = 20;
                        }
                    }
                    if (a.h <= 0) {
                        a.h = a.d;
                    }
                    downloadTaskInfo = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a();
                    if (downloadTaskInfo.d > 0 && downloadTaskInfo.h == downloadTaskInfo.d) {
                        z = true;
                    }
                    if (z) {
                        downloadTaskInfo = com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.a();
                        if (downloadTaskInfo.n == null) {
                            downloadTaskInfo.n = new com.xunlei.downloadprovider.download.tasklist.list.banner.f.p(downloadTaskInfo, downloadTaskInfo.m);
                        }
                        downloadTaskInfo.n.a(true);
                        ThunderReport.reportEvent(HubbleEventBuilder.build("android_dl_center_action", "dl_viphb_gain_show"));
                    }
                    return;
                } else {
                    aVar.a(false, downloadTaskInfo);
                    return;
                }
            }
        }
        this.mVoucherPacketBanner.d(8);
        BannerManager.a().a(false, BannerManager$BannerType.TYPE_VOUCHER_PACKET, downloadTaskInfo.getTaskId(), null);
    }

    public void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        com.xunlei.downloadprovider.download.tasklist.list.banner.c.f a = com.xunlei.downloadprovider.download.tasklist.list.banner.c.f.a();
        f$a com_xunlei_downloadprovider_download_tasklist_list_banner_c_f_a = this.mIFreeTrialRedPacketListener;
        if (com_xunlei_downloadprovider_download_tasklist_list_banner_c_f_a != null) {
            if (a.a == null) {
                a.a = new HashSet();
            }
            a.a.add(com_xunlei_downloadprovider_download_tasklist_list_banner_c_f_a);
        }
    }

    public void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        com.xunlei.downloadprovider.download.tasklist.list.banner.c.f a = com.xunlei.downloadprovider.download.tasklist.list.banner.c.f.a();
        f$a com_xunlei_downloadprovider_download_tasklist_list_banner_c_f_a = this.mIFreeTrialRedPacketListener;
        if (!com.xunlei.xllib.b.d.a(a.a)) {
            if (com_xunlei_downloadprovider_download_tasklist_list_banner_c_f_a != null) {
                a.a.remove(com_xunlei_downloadprovider_download_tasklist_list_banner_c_f_a);
            }
        }
    }

    private void doLimitPrivilegeBannerVisibleAction(DownloadTaskInfo downloadTaskInfo) {
        if (!(isTaskInFreetrail(downloadTaskInfo) || downloadTaskInfo.mIsDisplayDownloadException || downloadTaskInfo.mIsFileMissing || downloadTaskInfo.getTaskStatus() != 1)) {
            if (!BannerManager.a().a(BannerManager$BannerType.TYPE_LIMIT_PRIVILEGE, downloadTaskInfo.getTaskId())) {
                com.xunlei.downloadprovider.download.tasklist.list.banner.d.a aVar = this.mLimitPrivilegeBanner;
                boolean z = false;
                if (downloadTaskInfo.getTaskStatus() != 1) {
                    new StringBuilder("isAvaiable = ").append(downloadTaskInfo.mLocalFileName);
                } else {
                    int taskNum;
                    int intValue;
                    StringBuilder stringBuilder;
                    boolean z2;
                    boolean b;
                    String string;
                    boolean z3;
                    com.xunlei.downloadprovider.download.tasklist.list.banner.d.d a;
                    long taskId;
                    long taskId2;
                    Pair b2 = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.b();
                    com.xunlei.downloadprovider.download.tasklist.list.banner.d.d a2 = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                    long taskId3 = downloadTaskInfo.getTaskId();
                    if (com.xunlei.downloadprovider.d.d.a().h.b() && b2 != null) {
                        if (!a2.c.contains(com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.f())) {
                            taskNum = SettingStateController.getInstance().getTaskNum();
                            if (taskNum < com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.e()) {
                                intValue = ((Integer) b2.first).intValue();
                                stringBuilder = new StringBuilder("[isSettingSwitchOpen] taskId==");
                                stringBuilder.append(taskId3);
                                stringBuilder.append(" ,maxDownloadLimitCount=");
                                stringBuilder.append(taskNum);
                                stringBuilder.append(" ,runningTaskCount=");
                                stringBuilder.append(intValue);
                                stringBuilder.append(" ,firstWaitTaskId=");
                                stringBuilder.append(b2.second);
                                if (((Integer) b2.first).intValue() >= taskNum && ((Long) b2.second).longValue() == taskId3) {
                                    z2 = true;
                                    aVar.a = z2 ? InputDeviceCompat.SOURCE_KEYBOARD : 258;
                                    if (aVar.b()) {
                                        a2 = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                        taskId3 = downloadTaskInfo.getTaskId();
                                        b = com.xunlei.downloadprovider.d.d.a().h.b();
                                        stringBuilder = new StringBuilder("[isCanshowLimitPrivilegeGuide] taskId==");
                                        stringBuilder.append(taskId3);
                                        stringBuilder.append(" ,isAbTestOk=");
                                        stringBuilder.append(b);
                                        if (b) {
                                            if (b2 == null) {
                                                if (!com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.d()) {
                                                    string = a2.a.getString(com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.g(), "");
                                                    if (TextUtils.isEmpty(string) || com.xunlei.downloadprovider.download.tasklist.list.banner.f.f.b(string)) {
                                                        taskNum = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.e();
                                                        intValue = ((Integer) b2.first).intValue();
                                                        stringBuilder = new StringBuilder("[isCanshowLimitPrivilegeGuide] taskId==");
                                                        stringBuilder.append(taskId3);
                                                        stringBuilder.append(" ,maxDownloadLimitCount=");
                                                        stringBuilder.append(taskNum);
                                                        stringBuilder.append(" ,runningTaskCount=");
                                                        stringBuilder.append(intValue);
                                                        stringBuilder.append(" ,firstWaitTaskId=");
                                                        stringBuilder.append(b2.second);
                                                        if (((Integer) b2.first).intValue() >= taskNum && ((Long) b2.second).longValue() == taskId3) {
                                                            z3 = true;
                                                            if (z3) {
                                                                aVar.a(false, downloadTaskInfo);
                                                                return;
                                                            }
                                                            aVar.b.a(aVar.c.getResources().getString(R.string.download_limit_privilege_tip, new Object[]{Integer.valueOf(com.xunlei.downloadprovider.d.d.a().h.c())}));
                                                            aVar.b.b(aVar.c.getResources().getString(R.string.download_limit_open_vip));
                                                            aVar.d = downloadTaskInfo;
                                                            aVar.a(true, downloadTaskInfo);
                                                            a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                                            taskId = downloadTaskInfo.getTaskId();
                                                            if (a.e != null && ((Boolean) a.e.get(taskId, Boolean.valueOf(false))).booleanValue()) {
                                                                z = true;
                                                            }
                                                            if (!Boolean.valueOf(z).booleanValue()) {
                                                                a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                                                taskId2 = downloadTaskInfo.getTaskId();
                                                                if (a.e == null) {
                                                                    a.e = new LongSparseArray();
                                                                }
                                                                a.e.put(taskId2, Boolean.valueOf(true));
                                                                downloadTaskInfo = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_vipkt_show");
                                                                LoginHelper.a();
                                                                downloadTaskInfo.add("is_login", com.xunlei.downloadprovider.member.login.b.l.c());
                                                                ThunderReport.reportEvent(downloadTaskInfo);
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        z3 = false;
                                        if (z3) {
                                            aVar.a(false, downloadTaskInfo);
                                            return;
                                        }
                                        aVar.b.a(aVar.c.getResources().getString(R.string.download_limit_privilege_tip, new Object[]{Integer.valueOf(com.xunlei.downloadprovider.d.d.a().h.c())}));
                                        aVar.b.b(aVar.c.getResources().getString(R.string.download_limit_open_vip));
                                        aVar.d = downloadTaskInfo;
                                        aVar.a(true, downloadTaskInfo);
                                        a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                        taskId = downloadTaskInfo.getTaskId();
                                        z = true;
                                        if (Boolean.valueOf(z).booleanValue()) {
                                            a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                            taskId2 = downloadTaskInfo.getTaskId();
                                            if (a.e == null) {
                                                a.e = new LongSparseArray();
                                            }
                                            a.e.put(taskId2, Boolean.valueOf(true));
                                            downloadTaskInfo = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_vipkt_show");
                                            LoginHelper.a();
                                            downloadTaskInfo.add("is_login", com.xunlei.downloadprovider.member.login.b.l.c());
                                            ThunderReport.reportEvent(downloadTaskInfo);
                                            return;
                                        }
                                    } else if (aVar.a()) {
                                        aVar.b.a(aVar.c.getResources().getString(R.string.download_limit_count_setting_guide));
                                        aVar.b.b(aVar.c.getResources().getString(R.string.download_limit_goto_setting_tip));
                                        aVar.d = downloadTaskInfo;
                                        aVar.a(true, downloadTaskInfo);
                                        a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                        taskId = downloadTaskInfo.getTaskId();
                                        if (a.d != null && ((Boolean) a.d.get(taskId, Boolean.valueOf(false))).booleanValue()) {
                                            z = true;
                                        }
                                        if (!Boolean.valueOf(z).booleanValue()) {
                                            a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                            taskId2 = downloadTaskInfo.getTaskId();
                                            if (a.d == null) {
                                                a.d = new LongSparseArray();
                                            }
                                            a.d.put(taskId2, Boolean.valueOf(true));
                                            downloadTaskInfo = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_set_show");
                                            LoginHelper.a();
                                            downloadTaskInfo.add("is_login", com.xunlei.downloadprovider.member.login.b.l.c());
                                            ThunderReport.reportEvent(downloadTaskInfo);
                                            return;
                                        }
                                    }
                                    return;
                                }
                            }
                        }
                    }
                    z2 = false;
                    if (z2) {
                    }
                    aVar.a = z2 ? InputDeviceCompat.SOURCE_KEYBOARD : 258;
                    if (aVar.b()) {
                        a2 = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                        taskId3 = downloadTaskInfo.getTaskId();
                        b = com.xunlei.downloadprovider.d.d.a().h.b();
                        stringBuilder = new StringBuilder("[isCanshowLimitPrivilegeGuide] taskId==");
                        stringBuilder.append(taskId3);
                        stringBuilder.append(" ,isAbTestOk=");
                        stringBuilder.append(b);
                        if (b) {
                            if (b2 == null) {
                                if (com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.d()) {
                                    string = a2.a.getString(com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.g(), "");
                                    taskNum = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.e();
                                    intValue = ((Integer) b2.first).intValue();
                                    stringBuilder = new StringBuilder("[isCanshowLimitPrivilegeGuide] taskId==");
                                    stringBuilder.append(taskId3);
                                    stringBuilder.append(" ,maxDownloadLimitCount=");
                                    stringBuilder.append(taskNum);
                                    stringBuilder.append(" ,runningTaskCount=");
                                    stringBuilder.append(intValue);
                                    stringBuilder.append(" ,firstWaitTaskId=");
                                    stringBuilder.append(b2.second);
                                    z3 = true;
                                    if (z3) {
                                        aVar.b.a(aVar.c.getResources().getString(R.string.download_limit_privilege_tip, new Object[]{Integer.valueOf(com.xunlei.downloadprovider.d.d.a().h.c())}));
                                        aVar.b.b(aVar.c.getResources().getString(R.string.download_limit_open_vip));
                                        aVar.d = downloadTaskInfo;
                                        aVar.a(true, downloadTaskInfo);
                                        a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                        taskId = downloadTaskInfo.getTaskId();
                                        z = true;
                                        if (Boolean.valueOf(z).booleanValue()) {
                                            a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                                            taskId2 = downloadTaskInfo.getTaskId();
                                            if (a.e == null) {
                                                a.e = new LongSparseArray();
                                            }
                                            a.e.put(taskId2, Boolean.valueOf(true));
                                            downloadTaskInfo = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_vipkt_show");
                                            LoginHelper.a();
                                            downloadTaskInfo.add("is_login", com.xunlei.downloadprovider.member.login.b.l.c());
                                            ThunderReport.reportEvent(downloadTaskInfo);
                                            return;
                                        }
                                    }
                                    aVar.a(false, downloadTaskInfo);
                                    return;
                                }
                            }
                        }
                        z3 = false;
                        if (z3) {
                            aVar.a(false, downloadTaskInfo);
                            return;
                        }
                        aVar.b.a(aVar.c.getResources().getString(R.string.download_limit_privilege_tip, new Object[]{Integer.valueOf(com.xunlei.downloadprovider.d.d.a().h.c())}));
                        aVar.b.b(aVar.c.getResources().getString(R.string.download_limit_open_vip));
                        aVar.d = downloadTaskInfo;
                        aVar.a(true, downloadTaskInfo);
                        a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                        taskId = downloadTaskInfo.getTaskId();
                        z = true;
                        if (Boolean.valueOf(z).booleanValue()) {
                            a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                            taskId2 = downloadTaskInfo.getTaskId();
                            if (a.e == null) {
                                a.e = new LongSparseArray();
                            }
                            a.e.put(taskId2, Boolean.valueOf(true));
                            downloadTaskInfo = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_vipkt_show");
                            LoginHelper.a();
                            downloadTaskInfo.add("is_login", com.xunlei.downloadprovider.member.login.b.l.c());
                            ThunderReport.reportEvent(downloadTaskInfo);
                            return;
                        }
                    } else if (aVar.a()) {
                        aVar.b.a(aVar.c.getResources().getString(R.string.download_limit_count_setting_guide));
                        aVar.b.b(aVar.c.getResources().getString(R.string.download_limit_goto_setting_tip));
                        aVar.d = downloadTaskInfo;
                        aVar.a(true, downloadTaskInfo);
                        a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                        taskId = downloadTaskInfo.getTaskId();
                        z = true;
                        if (Boolean.valueOf(z).booleanValue()) {
                            a = com.xunlei.downloadprovider.download.tasklist.list.banner.d.d.a();
                            taskId2 = downloadTaskInfo.getTaskId();
                            if (a.d == null) {
                                a.d = new LongSparseArray();
                            }
                            a.d.put(taskId2, Boolean.valueOf(true));
                            downloadTaskInfo = HubbleEventBuilder.build("android_dl_center_action", "dl_task_limit_set_show");
                            LoginHelper.a();
                            downloadTaskInfo.add("is_login", com.xunlei.downloadprovider.member.login.b.l.c());
                            ThunderReport.reportEvent(downloadTaskInfo);
                            return;
                        }
                    }
                    return;
                }
                aVar.a(false, downloadTaskInfo);
                return;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("[doLimitPrivilegeBannerVisibleAction] gone bindData = ");
        stringBuilder2.append(downloadTaskInfo.mLocalFileName);
        stringBuilder2.append(" ,taskId=");
        stringBuilder2.append(downloadTaskInfo.getTaskId());
        this.mLimitPrivilegeBanner.d(8);
        BannerManager.a().a(false, BannerManager$BannerType.TYPE_LIMIT_PRIVILEGE, downloadTaskInfo.getTaskId(), null);
    }

    private void initBanner() {
        this.mDownloadExceptionBanner = new a(getContext(), (ViewStub) this.itemView.findViewById(R.id.task_download_exception_banner));
        this.mDownloadExceptionBanner.c(this.mCardStyle);
        this.mTaskDownloadRedEnvelopeBanner = new com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.b.a(getContext(), (ViewStub) this.itemView.findViewById(R.id.task_download_red_envelope));
        this.mTaskDownloadRedEnvelopeBanner.c(this.mCardStyle);
        this.mFreeTrailView = new com.xunlei.downloadprovider.download.tasklist.list.banner.c.a(getContext(), (ViewStub) this.itemView.findViewById(R.id.free_trial_layout_banner));
        this.mFreeTrailView.c(this.mCardStyle);
        this.mFreeTrailView.b = new g(this);
        this.mVoucherPacketBanner = new com.xunlei.downloadprovider.download.tasklist.list.banner.f.a(getContext(), (ViewStub) this.itemView.findViewById(R.id.voucher_packet_layout_banner));
        this.mVoucherPacketBanner.c(this.mCardStyle);
        this.mLimitPrivilegeBanner = new com.xunlei.downloadprovider.download.tasklist.list.banner.d.a(getContext(), (ViewStub) this.itemView.findViewById(R.id.limit_privilege_layout_banner));
        this.mLimitPrivilegeBanner.c(this.mCardStyle);
        this.mTwiceConsumeBanner = new i((ViewStub) this.itemView.findViewById(R.id.task_download_twiceconsume));
        this.mTwiceConsumeBanner.c(this.mCardStyle);
    }

    private void updateBanner(DownloadTaskInfo downloadTaskInfo) {
        doVoucherPacketBannerVisibleAction(downloadTaskInfo);
        doLimitPrivilegeBannerVisibleAction(downloadTaskInfo);
        doTwiceConsumeBannerVisibleAction(downloadTaskInfo);
        checkRedEnvelopeBanner(downloadTaskInfo);
    }

    private void doTwiceConsumeBannerVisibleAction(DownloadTaskInfo downloadTaskInfo) {
        if (!(isTaskInFreetrail(downloadTaskInfo) || downloadTaskInfo.mIsDisplayDownloadException || downloadTaskInfo.mIsFileMissing)) {
            if (!BannerManager.a().a(BannerManager$BannerType.TYPE_TWICE, downloadTaskInfo.getTaskId())) {
                this.mTwiceConsumeBanner.c = this.isVisibleToUser;
                i iVar = this.mTwiceConsumeBanner;
                String str = downloadTaskInfo.mUrl;
                iVar.e = str;
                if (iVar.c && h.c(str)) {
                    boolean z;
                    iVar.d = downloadTaskInfo;
                    boolean z2 = true;
                    iVar.a(true, downloadTaskInfo);
                    downloadTaskInfo = com.xunlei.downloadprovider.download.tasklist.list.banner.a.a.a();
                    int i = i.b;
                    i.a aVar = new i.a(str);
                    String b = com.xunlei.downloadprovider.download.tasklist.list.banner.a.a.b(str);
                    int hashCode = b.hashCode();
                    ArrayList arrayList = (ArrayList) downloadTaskInfo.a.get(hashCode);
                    if (arrayList != null) {
                        int size = arrayList.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (((WeakReference) arrayList.get(i2)).get() == iVar) {
                                z = true;
                                break;
                            }
                        }
                    }
                    z = false;
                    if (!z) {
                        arrayList = (ArrayList) downloadTaskInfo.a.get(hashCode);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            downloadTaskInfo.a.put(hashCode, arrayList);
                        }
                        arrayList.add(new WeakReference(iVar));
                    }
                    if (downloadTaskInfo.d.get(b) == null) {
                        downloadTaskInfo.d.put(b, Integer.valueOf(i));
                        downloadTaskInfo.c.sendMessageDelayed(Message.obtain(downloadTaskInfo.c, 0, b), 1000);
                    }
                    if (downloadTaskInfo.b.get(hashCode) == null) {
                        downloadTaskInfo.b.put(hashCode, aVar);
                    }
                    iVar.a.a(com.xunlei.downloadprovider.download.tasklist.list.banner.a.a.a().a(str));
                    downloadTaskInfo = com.xunlei.downloadprovider.download.tasklist.list.banner.a.e.c().a;
                    long j = downloadTaskInfo.a.getLong(g.a(), 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - j > 86400000) {
                        downloadTaskInfo.a.edit().putLong(g.a(), currentTimeMillis).commit();
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        com.xunlei.downloadprovider.download.report.a.b("10days_sent");
                    }
                    com.xunlei.downloadprovider.download.tasklist.list.banner.a.e.c().c = false;
                    return;
                }
                if (iVar.h() == 0) {
                    iVar.a(false, downloadTaskInfo);
                }
                return;
            }
        }
        this.mTwiceConsumeBanner.d(8);
        BannerManager.a().a(false, BannerManager$BannerType.TYPE_TWICE, downloadTaskInfo.getTaskId(), null);
    }

    private static boolean isTaskInFreetrail(DownloadTaskInfo downloadTaskInfo) {
        if (LoginHelper.a().g.g()) {
            return false;
        }
        boolean z = com.xunlei.downloadprovider.download.c.a.a().e == downloadTaskInfo.getTaskId();
        if (z) {
            if (downloadTaskInfo.mDownloadedSize < com.xunlei.downloadprovider.download.c.a.a().d()) {
                return false;
            }
        }
        if (!shouldShowFreeTrial(downloadTaskInfo)) {
            return false;
        }
        if (!com.xunlei.downloadprovider.download.c.a.a().a(downloadTaskInfo.getTaskId()) && downloadTaskInfo.mFreeTrialTimes <= null) {
            if (!z) {
                return false;
            }
        }
        return true;
    }

    private void refreshLXSpaceTagState() {
        LXTaskState lXTaskState;
        LXSpaceTaskQueryMgr a = a.a;
        TaskInfo taskInfo = this.mTaskInfo;
        if (taskInfo != null && com.xunlei.downloadprovider.personal.lixianspace.a.d()) {
            int taskStatus = taskInfo.getTaskStatus();
            if (!(taskStatus == 16 || taskStatus == 17)) {
                if (taskStatus != 8) {
                    LXTaskInfo lXTaskInfo = (LXTaskInfo) a.a.get(taskInfo.getTaskDownloadUrl());
                    if (lXTaskInfo != null) {
                        CollectState collectState = lXTaskInfo.i;
                        if (lXTaskInfo.e > 0) {
                            if (collectState != CollectState.unknown) {
                                if (collectState == CollectState.complete) {
                                    lXTaskState = LXTaskState.success;
                                } else if (collectState == CollectState.downloading) {
                                    lXTaskState = LXTaskState.downloading;
                                } else {
                                    lXTaskState = LXTaskState.fail;
                                }
                                this.mLXSpaceTagTv.setVisibility(0);
                                if (this.mLXSpaceView != null) {
                                    this.mLXSpaceView.setVisibility(0);
                                }
                                if (lXTaskState != LXTaskState.downloading) {
                                    this.mLXSpaceTagTv.setText("离线采集");
                                    this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_downloading), null, null, null);
                                } else if (lXTaskState != LXTaskState.fail) {
                                    this.mLXSpaceTagTv.setText("离线失败");
                                    this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_fail), null, null, null);
                                } else if (lXTaskState != LXTaskState.success) {
                                    this.mLXSpaceTagTv.setText("离线高速");
                                    this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_success), null, null, null);
                                } else {
                                    if (this.mLXSpaceView != null) {
                                        this.mLXSpaceView.setVisibility(8);
                                    }
                                    this.mLXSpaceTagTv.setVisibility(8);
                                    this.mLXSpaceTagTv.setText("");
                                    this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                                }
                            }
                        }
                        lXTaskState = LXTaskState.unKnown;
                        this.mLXSpaceTagTv.setVisibility(0);
                        if (this.mLXSpaceView != null) {
                            this.mLXSpaceView.setVisibility(0);
                        }
                        if (lXTaskState != LXTaskState.downloading) {
                            this.mLXSpaceTagTv.setText("离线采集");
                            this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_downloading), null, null, null);
                        } else if (lXTaskState != LXTaskState.fail) {
                            this.mLXSpaceTagTv.setText("离线失败");
                            this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_fail), null, null, null);
                        } else if (lXTaskState != LXTaskState.success) {
                            if (this.mLXSpaceView != null) {
                                this.mLXSpaceView.setVisibility(8);
                            }
                            this.mLXSpaceTagTv.setVisibility(8);
                            this.mLXSpaceTagTv.setText("");
                            this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        } else {
                            this.mLXSpaceTagTv.setText("离线高速");
                            this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_success), null, null, null);
                        }
                    }
                }
            }
            lXTaskState = LXTaskState.unKnown;
            this.mLXSpaceTagTv.setVisibility(0);
            if (this.mLXSpaceView != null) {
                this.mLXSpaceView.setVisibility(0);
            }
            if (lXTaskState != LXTaskState.downloading) {
                this.mLXSpaceTagTv.setText("离线采集");
                this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_downloading), null, null, null);
            } else if (lXTaskState != LXTaskState.fail) {
                this.mLXSpaceTagTv.setText("离线失败");
                this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_fail), null, null, null);
            } else if (lXTaskState != LXTaskState.success) {
                this.mLXSpaceTagTv.setText("离线高速");
                this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_success), null, null, null);
            } else {
                if (this.mLXSpaceView != null) {
                    this.mLXSpaceView.setVisibility(8);
                }
                this.mLXSpaceTagTv.setVisibility(8);
                this.mLXSpaceTagTv.setText("");
                this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            }
        }
        lXTaskState = LXTaskState.unKnown;
        this.mLXSpaceTagTv.setVisibility(0);
        if (this.mLXSpaceView != null) {
            this.mLXSpaceView.setVisibility(0);
        }
        if (lXTaskState != LXTaskState.downloading) {
            this.mLXSpaceTagTv.setText("离线采集");
            this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_downloading), null, null, null);
        } else if (lXTaskState != LXTaskState.fail) {
            this.mLXSpaceTagTv.setText("离线失败");
            this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_fail), null, null, null);
        } else if (lXTaskState != LXTaskState.success) {
            if (this.mLXSpaceView != null) {
                this.mLXSpaceView.setVisibility(8);
            }
            this.mLXSpaceTagTv.setVisibility(8);
            this.mLXSpaceTagTv.setText("");
            this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        } else {
            this.mLXSpaceTagTv.setText("离线高速");
            this.mLXSpaceTagTv.setCompoundDrawablesWithIntrinsicBounds(getContext().getResources().getDrawable(R.drawable.ic_lx_space_collect_success), null, null, null);
        }
    }
}
