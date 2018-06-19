package com.xunlei.downloadprovider.download.center.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.taobao.accs.utl.UtilityImpl;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.businessutil.DownloadConfig;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cooperation.data.CooperationItem;
import com.xunlei.downloadprovider.cooperation.data.CooperationScene;
import com.xunlei.downloadprovider.cooperation.l;
import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.f;
import com.xunlei.xllib.android.b;
import com.xunlei.xllib.b.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadBriefInfoHeaderView extends FrameLayout {
    private OnClickListener A;
    private Context B;
    private PreferenceHelper C;
    private String D;
    private CooperationScene E;
    private ImageView F;
    private TextView G;
    private boolean H;
    private boolean I;
    private a J;
    private String K;
    StatusInfo a;
    public View b;
    public View c;
    public DownloadingTipType d;
    private TextView e;
    private TextView f;
    private TextView g;
    private View h;
    private TextView i;
    private TextView j;
    private ImageView k;
    private int l;
    private View m;
    private View n;
    private TextView o;
    private TextView p;
    private TextView q;
    private ImageView r;
    private ImageView s;
    private TextView t;
    private View u;
    private View v;
    private OnClickListener w;
    private OnClickListener x;
    private OnClickListener y;
    private OnClickListener z;

    enum DownloadingTipType {
        NONE,
        SPEEDUP,
        SUPER_VIP_SPEEDUP,
        PLATINUM_VIP_SPEEDUP,
        OPEN_VIP,
        OPEN_VIP_LOW_SPEED,
        MOBILE_NET_DOWNLOADING,
        KUAINIAO_TIP_NORMAL,
        KUAINIAO_TIP_VIP,
        FREETRIAL_TIP,
        COOPERATION_SPACE
    }

    public static class StatusInfo {
        public boolean a = false;
        public boolean b = false;
        public boolean c = false;
        public boolean d = false;
        public boolean e = false;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        boolean i = false;
        public boolean j = false;
        boolean k = true;
        boolean l = false;
        public String m = "";
        public TasksStatus n;

        public enum TasksStatus {
            NoTasks,
            TasksPaused,
            TasksCopyRightProblem,
            TasksFailed,
            TasksFinished
        }

        public final boolean a() {
            return this.k && this.l;
        }

        public final void a(boolean z, boolean z2) {
            this.k = z;
            this.l = z2;
        }
    }

    public interface a {
        void a();

        void a(int i, String str);

        void b();

        void c();

        void d();
    }

    public DownloadBriefInfoHeaderView(Context context) {
        this(context, null, 0);
    }

    public DownloadBriefInfoHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadBriefInfoHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.l = -1;
        this.d = null;
        this.I = true;
        a(context);
    }

    @TargetApi(21)
    public DownloadBriefInfoHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.l = -1;
        this.d = null;
        this.I = true;
        a(context);
    }

    private void a(Context context) {
        this.B = context;
        context = LayoutInflater.from(context).inflate(R.layout.layout_download_brief_info_header_view, this);
        this.e = (TextView) context.findViewById(R.id.speedTextView);
        this.f = (TextView) context.findViewById(R.id.speedUnitTextView);
        this.b = context.findViewById(R.id.login_tip_container);
        this.g = (TextView) context.findViewById(R.id.login_tip_text);
        this.F = (ImageView) context.findViewById(R.id.login_tip_icon);
        this.h = context.findViewById(R.id.downloading_tip_container);
        this.i = (TextView) context.findViewById(R.id.downloadingTipTextView);
        this.j = (TextView) context.findViewById(R.id.tv_vip_icon_level);
        this.c = context.findViewById(R.id.speedInfo);
        this.m = context.findViewById(R.id.pauseInfo);
        this.n = context.findViewById(R.id.pause_tip_text);
        this.o = (TextView) context.findViewById(R.id.exception_tip_text);
        this.p = (TextView) context.findViewById(R.id.pause_tip_no_net_text);
        this.r = (ImageView) context.findViewById(R.id.icon_click_tip_left);
        this.s = (ImageView) context.findViewById(R.id.icon_click_tip_right);
        this.q = (TextView) context.findViewById(R.id.pause_tip_open_vip_text);
        this.k = (ImageView) context.findViewById(R.id.tip_icon);
        this.t = (TextView) findViewById(R.id.pauseStatusTextView);
        this.u = findViewById(R.id.open_vip_tip_1);
        this.v = findViewById(R.id.click_container);
        this.G = (TextView) findViewById(R.id.member_top_link_tv);
        if (TextUtils.isEmpty(this.K) != null) {
            context = c.a().b(f.a(PayFrom.DOWNLOAD_LIST_TOP_TXT_LINK));
            if (context != null) {
                this.K = context.b;
            }
        }
        if (isInEditMode() == null) {
            setDownloadSpeed(0);
        }
    }

    public void setDownloadSpeed(long j) {
        if (this.e != null) {
            String[] b = com.xunlei.downloadprovider.download.util.a.b(j);
            CharSequence charSequence = b[0];
            CharSequence charSequence2 = b[1];
            if (j == 0) {
                charSequence = "0.0";
                charSequence2 = e.c[1];
            }
            this.e.setText(charSequence);
            this.f.setText(charSequence2);
            a();
        }
    }

    public void setSpeedTipIcon(int i) {
        if (i <= 0) {
            this.k.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        if (this.l != i) {
            this.k.setImageResource(i);
            this.l = i;
        }
    }

    public final void a(boolean z, boolean z2) {
        StatusInfo statusInfo = getStatusInfo();
        statusInfo.a = z;
        statusInfo.b = z2;
        a();
    }

    public final void a() {
        this.E = com.xunlei.downloadprovider.cooperation.c.a().b(1004);
        boolean a = a(this.E);
        StatusInfo statusInfo = getStatusInfo();
        this.p.setVisibility(8);
        this.r.setVisibility(8);
        this.s.setVisibility(8);
        this.v.setOnClickListener(null);
        this.G.setVisibility(8);
        boolean z = true;
        if (statusInfo.n != null) {
            this.m.setVisibility(0);
            this.c.setVisibility(8);
            this.u.setVisibility(8);
            CooperationItem a2;
            if (!statusInfo.k) {
                this.u.setVisibility(0);
                this.p.setVisibility(0);
                this.q.setVisibility(8);
                this.r.setVisibility(8);
                this.s.setVisibility(8);
                this.t.setText(R.string.download_center_head_title_nonet);
                a2 = com.xunlei.downloadprovider.cooperation.c.a().a(16);
                if (a2 != null) {
                    com.xunlei.downloadprovider.cooperation.a.a.a(a2.getDisplayLocationName(), a2.getAppPackageName(), a2.isShowInstallTip());
                    this.p.setText(a2.getCopyWriting());
                    this.v.setOnClickListener(a(16, a2.getDisplayLocationName()));
                    this.u.setOnClickListener(a(16, a2.getDisplayLocationName()));
                    this.p.setOnClickListener(a(16, a2.getDisplayLocationName()));
                    this.r.setVisibility(0);
                    this.s.setVisibility(0);
                } else {
                    this.p.setText(R.string.download_center_check_net_tip);
                    this.v.setOnClickListener(null);
                    this.u.setOnClickListener(null);
                    this.p.setOnClickListener(null);
                }
                this.n.setVisibility(8);
                this.o.setVisibility(8);
            } else if (statusInfo.n == TasksStatus.NoTasks) {
                this.t.setText(R.string.download_center_head_title_notask);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                if (!statusInfo.a || (statusInfo.a && !statusInfo.b)) {
                    this.u.setVisibility(0);
                    this.p.setVisibility(8);
                    this.r.setVisibility(0);
                    this.s.setVisibility(0);
                    this.q.setVisibility(0);
                    this.u.setOnClickListener(getLoginInfoClickListener());
                }
            } else if (statusInfo.n == TasksStatus.TasksFinished) {
                this.t.setText(R.string.download_center_head_title_taskfinished);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                if (!statusInfo.a || (statusInfo.a && !statusInfo.b)) {
                    this.u.setVisibility(0);
                    this.r.setVisibility(0);
                    this.s.setVisibility(0);
                    this.p.setVisibility(8);
                    this.q.setVisibility(0);
                    this.u.setOnClickListener(getLoginInfoClickListener());
                }
            } else if (statusInfo.n == TasksStatus.TasksCopyRightProblem) {
                this.t.setText(R.string.download_center_head_title_cannotDownload);
                this.n.setVisibility(8);
                this.o.setVisibility(0);
                this.o.setText(R.string.download_center_copyright_exception_tip);
            } else if (statusInfo.n == TasksStatus.TasksFailed) {
                this.t.setText(R.string.download_center_head_title_taskException);
                this.n.setVisibility(8);
                this.o.setVisibility(8);
                if (b.d(getContext())) {
                    this.u.setVisibility(0);
                    this.p.setVisibility(0);
                    a2 = com.xunlei.downloadprovider.cooperation.c.a().a(18);
                    if (a2 != null) {
                        com.xunlei.downloadprovider.cooperation.a.a.a(a2.getDisplayLocationName(), a2.getAppPackageName(), a2.isShowInstallTip());
                        this.p.setText(a2.getCopyWriting());
                        this.r.setVisibility(0);
                        this.s.setVisibility(0);
                        this.v.setOnClickListener(a(18, a2.getDisplayLocationName()));
                        this.p.setOnClickListener(a(18, a2.getDisplayLocationName()));
                        this.u.setOnClickListener(a(18, a2.getDisplayLocationName()));
                    } else {
                        this.p.setText(getResources().getString(R.string.download_center_mobile_net_tip));
                        this.r.setVisibility(8);
                        this.s.setVisibility(8);
                    }
                    this.q.setVisibility(8);
                    this.o.setVisibility(8);
                } else {
                    this.p.setVisibility(8);
                    this.r.setVisibility(8);
                    this.s.setVisibility(8);
                    this.o.setVisibility(0);
                    h.e();
                    TaskCountsStatistics c = h.c();
                    int i = c.mTotalCount - c.mSuccessCount;
                    this.o.setText(getResources().getString(R.string.download_center_exception_tip, new Object[]{Integer.valueOf(i)}));
                }
            } else {
                this.o.setVisibility(8);
                this.t.setText(R.string.download_center_head_title_taskpaused);
                if (b.d(getContext())) {
                    a2 = com.xunlei.downloadprovider.cooperation.c.a().a(18);
                    this.u.setVisibility(0);
                    this.p.setVisibility(0);
                    this.q.setVisibility(8);
                    if (a2 != null) {
                        com.xunlei.downloadprovider.cooperation.a.a.a(a2.getDisplayLocationName(), a2.getAppPackageName(), a2.isShowInstallTip());
                        this.p.setText(a2.getCopyWriting());
                        this.v.setOnClickListener(a(18, a2.getDisplayLocationName()));
                        this.u.setOnClickListener(a(18, a2.getDisplayLocationName()));
                        this.p.setOnClickListener(a(18, a2.getDisplayLocationName()));
                        this.r.setVisibility(0);
                        this.s.setVisibility(0);
                    } else {
                        this.p.setText(getResources().getString(R.string.download_center_mobile_net_tip));
                        this.v.setOnClickListener(null);
                        this.u.setOnClickListener(null);
                        this.p.setOnClickListener(null);
                    }
                    this.n.setVisibility(8);
                } else if (a) {
                    this.q.setVisibility(8);
                    if (!this.H) {
                        com.xunlei.downloadprovider.cooperation.a.a.b(l.c(1004));
                        this.H = true;
                    }
                    this.u.setVisibility(0);
                    this.p.setVisibility(0);
                    this.p.setText(this.E.getDescription());
                    this.n.setVisibility(8);
                    this.r.setVisibility(0);
                    this.s.setVisibility(0);
                    this.v.setOnClickListener(getStorageCooperationClickListener());
                    this.u.setOnClickListener(getStorageCooperationClickListener());
                    this.p.setOnClickListener(getStorageCooperationClickListener());
                } else {
                    this.u.setVisibility(8);
                    this.p.setVisibility(8);
                    this.r.setVisibility(8);
                    this.s.setVisibility(8);
                    this.n.setVisibility(0);
                }
            }
        } else {
            this.m.setVisibility(8);
            this.u.setVisibility(8);
            this.c.setVisibility(0);
        }
        if (this.c.getVisibility() == 0) {
            boolean z2 = statusInfo.k && statusInfo.a();
            if (statusInfo.a && statusInfo.b && statusInfo.j) {
                setSpeedTipIcon(R.drawable.ic_download_accelerate);
            } else {
                setSpeedTipIcon(-1);
                setNetworkTypeIcon(statusInfo);
            }
            if (z2) {
                a(DownloadingTipType.MOBILE_NET_DOWNLOADING);
            } else if (a) {
                a(DownloadingTipType.COOPERATION_SPACE);
            } else if (!statusInfo.a && statusInfo.g) {
                d();
                a(DownloadingTipType.KUAINIAO_TIP_NORMAL);
            } else if (statusInfo.a && !statusInfo.b && statusInfo.g && !LoginHelper.a().g.g()) {
                d();
                a(DownloadingTipType.KUAINIAO_TIP_NORMAL);
            } else if (statusInfo.a && statusInfo.e && statusInfo.h) {
                d();
                a(DownloadingTipType.KUAINIAO_TIP_VIP);
            } else if (!statusInfo.a || !statusInfo.b) {
                TaskInfo c2 = h.e().c(com.xunlei.downloadprovider.download.c.a.a().e);
                if (c2 != null) {
                    if (c2.mIsEnteredHighSpeedTrial) {
                        if (c2.getTaskStatus() == 2) {
                            if (c2.mVipChannelStatus != 16) {
                                if (!k.a(c2, k.i(c2))) {
                                    a = true;
                                    if (a) {
                                        a(DownloadingTipType.FREETRIAL_TIP);
                                    } else if (statusInfo.f) {
                                        n.a();
                                        if (n.i() > 0) {
                                            c();
                                        }
                                        a(DownloadingTipType.OPEN_VIP);
                                    } else {
                                        c();
                                        a(DownloadingTipType.OPEN_VIP_LOW_SPEED);
                                    }
                                }
                            }
                        }
                    }
                }
                a = false;
                if (a) {
                    a(DownloadingTipType.FREETRIAL_TIP);
                } else if (statusInfo.f) {
                    n.a();
                    if (n.i() > 0) {
                        c();
                    }
                    a(DownloadingTipType.OPEN_VIP);
                } else {
                    c();
                    a(DownloadingTipType.OPEN_VIP_LOW_SPEED);
                }
            } else if (statusInfo.j && statusInfo.c) {
                setVipIconLevel(true);
                a(DownloadingTipType.SUPER_VIP_SPEEDUP);
            } else if (statusInfo.j && statusInfo.d) {
                setVipIconLevel(false);
                a(DownloadingTipType.PLATINUM_VIP_SPEEDUP);
            } else if (statusInfo.j) {
                a(DownloadingTipType.SPEEDUP);
            } else {
                a(DownloadingTipType.NONE);
            }
        }
        if (this.c.getVisibility() == 0) {
            StatusInfo statusInfo2 = getStatusInfo();
            a = statusInfo2.k && statusInfo2.a();
            if (!a) {
                if (a(com.xunlei.downloadprovider.cooperation.c.a().b(1004))) {
                }
                if (z && !b() && !TextUtils.isEmpty(this.K)) {
                    this.G.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_hui), null, null, null);
                    TextView textView = this.G;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.K);
                    stringBuilder.append(" >");
                    textView.setText(stringBuilder.toString());
                    this.G.setOnClickListener(getActivityTxtLinkClickListener());
                    this.v.setOnClickListener(getActivityTxtLinkClickListener());
                    this.G.setVisibility(0);
                    this.b.setVisibility(8);
                    this.h.setVisibility(8);
                    return;
                }
                return;
            }
        }
        z = false;
        if (z) {
        }
    }

    public void setVipIconLevel(boolean z) {
        int m = LoginHelper.a().m();
        if (z) {
            this.j.setBackgroundResource(R.drawable.ic_super_vip_level);
            setMemberLevel(m);
            return;
        }
        this.j.setBackgroundResource(R.drawable.ic_normal_vip_level);
        setMemberLevel(m);
    }

    private void setMemberLevel(int i) {
        if (i > 0) {
            this.j.setText(String.valueOf(i));
            this.j.setVisibility(0);
            return;
        }
        this.j.setBackgroundResource(R.drawable.ic_normal_vip_no_level);
        this.j.setText("");
    }

    private boolean a(CooperationScene cooperationScene) {
        if (cooperationScene != null) {
            if (!TextUtils.isEmpty(cooperationScene.getAttachment())) {
                try {
                    if ((Long.parseLong(cooperationScene.getAttachment()) * 1024) * 1024 > DownloadConfig.getCachedStorageAvailableSize(this.B)) {
                        return true;
                    }
                } catch (CooperationScene cooperationScene2) {
                    cooperationScene2.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public final boolean b() {
        if (this.b.getVisibility() != 0) {
            return false;
        }
        if (this.d != DownloadingTipType.KUAINIAO_TIP_NORMAL) {
            if (this.d != DownloadingTipType.KUAINIAO_TIP_VIP) {
                return false;
            }
        }
        return true;
    }

    private void a(DownloadingTipType downloadingTipType) {
        this.d = downloadingTipType;
        this.F.setImageResource(R.drawable.download_center_warning);
        if (downloadingTipType != null) {
            switch (f.a[downloadingTipType.ordinal()]) {
                case 1:
                    a(this.B.getString(R.string.download_center_vip_speedup_for_you));
                    return;
                case 2:
                    a(this.B.getString(R.string.download_center_super_speedup_for_you));
                    return;
                case 3:
                    a(this.B.getString(R.string.download_center_platinum_speedup_for_you));
                    return;
                case 4:
                    a(this.B.getString(R.string.download_center_freetrial_tip));
                    return;
                case 5:
                    downloadingTipType = com.xunlei.downloadprovider.cooperation.c.a().a(18);
                    if (downloadingTipType != null) {
                        com.xunlei.downloadprovider.cooperation.a.a.a(downloadingTipType.getDisplayLocationName(), downloadingTipType.getAppPackageName(), downloadingTipType.isShowInstallTip());
                        this.b.setOnClickListener(a(18, downloadingTipType.getDisplayLocationName()));
                        this.v.setOnClickListener(a(18, downloadingTipType.getDisplayLocationName()));
                        this.g.setText(downloadingTipType.getCopyWriting());
                        this.h.setVisibility(8);
                        return;
                    }
                    this.b.setVisibility(8);
                    this.h.setVisibility(0);
                    this.i.setText(R.string.download_center_mobile_net_download_tip);
                    return;
                case 6:
                    this.F.setImageResource(R.drawable.download_center_not_vip);
                    c(this.B.getString(R.string.download_center_open_vip_tip));
                    return;
                case 7:
                    c(this.B.getString(R.string.download_center_open_vip_tip_low_speed));
                    return;
                case 8:
                    this.b.setVisibility(0);
                    this.h.setVisibility(8);
                    this.b.setOnClickListener(getStorageCooperationClickListener());
                    this.v.setOnClickListener(getStorageCooperationClickListener());
                    this.g.setText(this.E.getDescription());
                    return;
                case 9:
                    b(this.B.getString(R.string.download_center_kuainiao_tip_normal));
                    return;
                case 10:
                    b(this.B.getString(R.string.download_center_kuainiao_tip_normal));
                    return;
                default:
                    break;
            }
        }
        this.b.setVisibility(8);
        this.h.setVisibility(8);
    }

    private void setNetworkTypeIcon(StatusInfo statusInfo) {
        if (statusInfo.k && statusInfo.m != null) {
            if (UtilityImpl.NET_TYPE_2G.equals(statusInfo.m)) {
                setSpeedTipIcon(R.drawable.ic_download_net_2g);
            } else if (UtilityImpl.NET_TYPE_3G.equals(statusInfo.m)) {
                setSpeedTipIcon(R.drawable.ic_download_net_3g);
            } else if (UtilityImpl.NET_TYPE_4G.equals(statusInfo.m) != null) {
                setSpeedTipIcon(R.drawable.ic_download_net_4g);
            }
        }
    }

    private void c() {
        if (this.I) {
            this.I = false;
            com.xunlei.downloadprovider.download.report.a.d();
        }
    }

    private void d() {
        if (this.C == null) {
            this.C = new PreferenceHelper(this.B, "tip_kuai_niao_show");
        }
        if (this.D == null) {
            this.D = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        PreferenceHelper preferenceHelper = this.C;
        StringBuilder stringBuilder = new StringBuilder("tip_kuai_niao_show");
        stringBuilder.append(this.D);
        if (TextUtils.isEmpty(preferenceHelper.getString(stringBuilder.toString(), ""))) {
            com.xunlei.downloadprovider.download.report.a.e();
            preferenceHelper = this.C;
            stringBuilder = new StringBuilder("tip_kuai_niao_show");
            stringBuilder.append(this.D);
            preferenceHelper.setString(stringBuilder.toString(), "has_show");
        }
    }

    private OnClickListener getLoginInfoClickListener() {
        if (this.w == null) {
            this.w = new a(this);
        }
        return this.w;
    }

    private OnClickListener a(int i, String str) {
        this.x = new b(this, i, str);
        return this.x;
    }

    private OnClickListener getStorageCooperationClickListener() {
        if (this.y == null) {
            this.y = new c(this);
        }
        return this.y;
    }

    private OnClickListener getKuaiNiaoClickListener() {
        if (this.z == null) {
            this.z = new d(this);
        }
        return this.z;
    }

    public StatusInfo getStatusInfo() {
        if (this.a == null) {
            this.a = new StatusInfo();
        }
        return this.a;
    }

    public void setActionListener(a aVar) {
        this.J = aVar;
    }

    private OnClickListener getActivityTxtLinkClickListener() {
        if (this.A == null) {
            this.A = new e(this);
        }
        return this.A;
    }

    private void a(String str) {
        if (getStatusInfo().j) {
            this.b.setVisibility(8);
            this.G.setVisibility(8);
            this.h.setVisibility(0);
            this.i.setText(str);
            this.h.setOnClickListener(null);
            this.G.setOnClickListener(null);
            this.b.setOnClickListener(null);
            setSpeedTipIcon(R.drawable.ic_download_accelerate);
        }
    }

    private void b(String str) {
        this.h.setVisibility(8);
        this.G.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setOnClickListener(getKuaiNiaoClickListener());
        this.v.setOnClickListener(getKuaiNiaoClickListener());
        this.G.setOnClickListener(null);
        this.h.setOnClickListener(null);
        this.g.setText(str);
        this.F.setImageResource(R.drawable.download_center_warning);
    }

    private void c(String str) {
        this.G.setVisibility(8);
        this.h.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setOnClickListener(getLoginInfoClickListener());
        this.v.setOnClickListener(getLoginInfoClickListener());
        this.G.setOnClickListener(null);
        this.h.setOnClickListener(null);
        this.g.setText(str);
    }
}
