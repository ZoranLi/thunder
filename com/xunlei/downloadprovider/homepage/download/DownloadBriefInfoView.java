package com.xunlei.downloadprovider.homepage.download;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taobao.accs.utl.UtilityImpl;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.center.widget.p;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.payment.activity.c;
import com.xunlei.downloadprovider.member.payment.activity.r;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.member.payment.f;
import com.xunlei.downloadprovider.web.website.g.b;
import com.xunlei.xllib.b.e;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadBriefInfoView extends LinearLayout {
    private View A;
    private TextView B;
    private boolean C;
    private String D;
    public StatusInfo a;
    DownloadingTipType b;
    private Context c;
    private p d;
    private ImageView e;
    private View f;
    private TextView g;
    private ImageView h;
    private TextView i;
    private TextView j;
    private View k;
    private View l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private OnClickListener p;
    private OnClickListener q;
    private a r;
    private OnClickListener s;
    private int t;
    private PreferenceHelper u;
    private String v;
    private View w;
    private TextView x;
    private TextView y;
    private ImageView z;

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
        FREETRIAL_TIP
    }

    public static class StatusInfo {
        boolean a = false;
        boolean b = false;
        boolean c = false;
        boolean d = false;
        boolean e = false;
        boolean f = false;
        boolean g = false;
        boolean h = false;
        boolean i = false;
        boolean j = false;
        boolean k = true;
        boolean l = false;
        String m = "";
        TasksStatus n;

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

        void b();

        void c();
    }

    public ImageView getRightImageView2() {
        return this.z;
    }

    public DownloadBriefInfoView(Context context) {
        this(context, null, 0);
    }

    public DownloadBriefInfoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DownloadBriefInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.t = -1;
        this.C = true;
        this.b = null;
        this.c = context;
        context = LayoutInflater.from(context).inflate(R.layout.download_tab_title_bar, null);
        this.e = (ImageView) context.findViewById(R.id.title_bar_right_1_iv);
        this.z = (ImageView) context.findViewById(R.id.title_bar_right_2_iv);
        this.A = context.findViewById(R.id.titlebar_right_3_layout);
        this.B = (TextView) context.findViewById(R.id.collect_update_red_point);
        this.f = context.findViewById(R.id.speed_info_container);
        this.g = (TextView) context.findViewById(R.id.speed_info_tv);
        this.h = (ImageView) context.findViewById(R.id.speed_info_iv);
        this.j = (TextView) context.findViewById(R.id.download_state_two_tv);
        this.i = (TextView) context.findViewById(R.id.download_state_single_tv);
        this.k = context.findViewById(R.id.download_tip_info_container);
        this.l = context.findViewById(R.id.tip_info_open_vip_container);
        this.m = (ImageView) context.findViewById(R.id.login_tip_icon);
        this.n = (TextView) context.findViewById(R.id.login_tip_text);
        this.o = (TextView) context.findViewById(R.id.tip_info_normal);
        this.w = context.findViewById(R.id.downloading_tip_container);
        this.x = (TextView) context.findViewById(R.id.tv_vip_icon_level);
        this.y = (TextView) context.findViewById(R.id.downloadingTipTextView);
        if (isInEditMode() == null) {
            setDownloadSpeed(null);
        }
        b.a();
        if (b.d() != null) {
            this.B.setVisibility(0);
        } else {
            this.B.setVisibility(8);
        }
        this.e.setOnClickListener(new a(this));
        this.A.setOnClickListener(new b(this));
        addView(context);
    }

    public final void a() {
        this.B.setVisibility(8);
    }

    public void setRightImageView2ClickListener(OnClickListener onClickListener) {
        this.z.setOnClickListener(onClickListener);
    }

    public final void a(boolean z, boolean z2) {
        StatusInfo statusInfo = getStatusInfo();
        statusInfo.a = z;
        statusInfo.b = z2;
        b();
    }

    public final void b() {
        StatusInfo statusInfo = getStatusInfo();
        this.m.setImageResource(R.drawable.dl_tab_warning);
        boolean z = true;
        if (statusInfo.n != null) {
            this.i.setVisibility(8);
            this.i.getPaint().setFakeBoldText(false);
            this.j.setVisibility(8);
            this.f.setVisibility(8);
            this.k.setVisibility(8);
            if (!statusInfo.k) {
                this.j.setVisibility(0);
                this.j.setText(R.string.download_center_head_title_nonet);
                this.j.setOnClickListener(null);
                a(getResources().getString(R.string.download_center_check_net_tip));
            } else if (statusInfo.n == TasksStatus.NoTasks) {
                if (statusInfo.a) {
                    if (!statusInfo.a || statusInfo.b) {
                        this.i.setVisibility(0);
                        this.i.setText(R.string.download_center_head_title_notask);
                    }
                }
                this.j.setVisibility(0);
                this.j.setText(R.string.download_center_head_title_notask);
                this.j.setOnClickListener(getLoginInfoClickListener());
                c(getResources().getString(R.string.download_center_open_vip_tip));
            } else if (statusInfo.n == TasksStatus.TasksFinished) {
                if (statusInfo.a) {
                    if (!statusInfo.a || statusInfo.b) {
                        this.i.setVisibility(0);
                        this.i.setText(R.string.download_center_head_title_taskfinished);
                    }
                }
                this.j.setVisibility(0);
                this.j.setText(R.string.download_center_head_title_taskfinished);
                this.j.setOnClickListener(getLoginInfoClickListener());
                c(getResources().getString(R.string.download_center_open_vip_tip));
            } else if (statusInfo.n == TasksStatus.TasksFailed) {
                this.j.setVisibility(0);
                this.j.setText(R.string.download_center_head_title_taskException);
                this.j.setOnClickListener(null);
                if (com.xunlei.xllib.android.b.d(getContext())) {
                    a(getResources().getString(R.string.download_center_mobile_net_tip));
                } else {
                    h.e();
                    int i = h.c().mFailedCount;
                    a(getResources().getString(R.string.download_center_exception_tip, new Object[]{Integer.valueOf(i)}));
                }
            } else if (statusInfo.n == TasksStatus.TasksCopyRightProblem) {
                this.j.setVisibility(0);
                this.j.setText(R.string.download_center_head_title_cannotDownload);
                this.j.setOnClickListener(null);
                a(getResources().getString(R.string.download_center_copyright_exception_tip));
            } else if (com.xunlei.xllib.android.b.d(getContext())) {
                this.j.setVisibility(0);
                this.j.setText(R.string.download_center_head_title_taskpaused);
                this.j.setOnClickListener(null);
                a(getResources().getString(R.string.download_center_mobile_net_tip));
            } else {
                this.i.setVisibility(0);
                this.i.setText(R.string.download_center_head_title_taskpaused);
                this.k.setVisibility(8);
                this.k.setOnClickListener(null);
            }
        } else {
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            this.f.setVisibility(0);
            this.k.setVisibility(8);
        }
        if (this.f.getVisibility() == 0) {
            boolean z2 = statusInfo.k && statusInfo.a();
            if (statusInfo.a && statusInfo.b && statusInfo.j) {
                setSpeedTipIcon(R.drawable.ic_download_accelerate);
            } else {
                setSpeedTipIcon(-1);
                setNetworkTypeIcon(statusInfo);
            }
            if (!(statusInfo.a && statusInfo.b)) {
                this.m.setImageResource(R.drawable.download_center_not_vip);
            }
            if (z2) {
                a(DownloadingTipType.MOBILE_NET_DOWNLOADING);
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
                TaskInfo c = h.e().c(com.xunlei.downloadprovider.download.c.a.a().e);
                if (c != null) {
                    if (c.mIsEnteredHighSpeedTrial) {
                        if (c.getTaskStatus() == 2) {
                            if (c.mVipChannelStatus != 16) {
                                if (!k.a(c, k.i(c))) {
                                    z2 = true;
                                    if (z2) {
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
                z2 = false;
                if (z2) {
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
                a(DownloadingTipType.SUPER_VIP_SPEEDUP);
                setVipIconLevel(true);
            } else if (statusInfo.j && statusInfo.d) {
                a(DownloadingTipType.PLATINUM_VIP_SPEEDUP);
                setVipIconLevel(false);
            } else if (statusInfo.j) {
                a(DownloadingTipType.SPEEDUP);
            } else {
                a(DownloadingTipType.NONE);
            }
        }
        statusInfo = getStatusInfo();
        boolean z3 = statusInfo.k && statusInfo.a();
        if (!z3) {
            if ((this.i.getVisibility() == 0 && !TextUtils.isEmpty(this.g.getText()) && TextUtils.equals(this.g.getText(), this.i.getText())) || this.f.getVisibility() == 0) {
                z3 = true;
                if (z3) {
                    e();
                    if (this.l.getVisibility() == 0) {
                        if (this.b != DownloadingTipType.KUAINIAO_TIP_NORMAL) {
                            if (this.b == DownloadingTipType.KUAINIAO_TIP_VIP) {
                            }
                        }
                        if (!z && !TextUtils.isEmpty(this.D)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(this.D);
                            stringBuilder.append(" >");
                            a(stringBuilder.toString());
                            this.o.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(R.drawable.ic_hui), null, null, null);
                            this.f.setOnClickListener(getActivityTxtLinkClickListener());
                            this.k.setOnClickListener(getActivityTxtLinkClickListener());
                            this.o.setOnClickListener(getActivityTxtLinkClickListener());
                            return;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
        }
        z3 = false;
        if (z3) {
            e();
            if (this.l.getVisibility() == 0) {
                if (this.b != DownloadingTipType.KUAINIAO_TIP_NORMAL) {
                    if (this.b == DownloadingTipType.KUAINIAO_TIP_VIP) {
                    }
                }
                if (!z) {
                }
            }
            z = false;
            if (!z) {
            }
        }
    }

    private void c() {
        if (this.C) {
            this.C = false;
            com.xunlei.downloadprovider.download.report.a.d();
        }
    }

    public void setVipIconLevel(boolean z) {
        this.k.setVisibility(0);
        this.l.setVisibility(8);
        this.w.setVisibility(0);
        this.o.setVisibility(8);
        int m = LoginHelper.a().m();
        this.x.setVisibility(0);
        if (z) {
            this.x.setBackgroundResource(R.drawable.ic_super_vip_level);
            setMemberLevel(m);
            return;
        }
        this.x.setBackgroundResource(R.drawable.ic_normal_vip_level);
        setMemberLevel(m);
    }

    private void setMemberLevel(int i) {
        if (i > 0) {
            this.x.setText(String.valueOf(i));
            this.x.setVisibility(0);
            return;
        }
        this.x.setBackgroundResource(R.drawable.ic_normal_vip_no_level);
        this.x.setText("");
    }

    private void a(DownloadingTipType downloadingTipType) {
        this.b = downloadingTipType;
        if (downloadingTipType == null) {
            this.k.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        switch (g.a[downloadingTipType.ordinal()]) {
            case 1:
                b(getResources().getString(R.string.download_center_vip_speedup_for_you));
                return;
            case 2:
                b(getResources().getString(R.string.download_center_super_speedup_for_you));
                return;
            case 3:
                b(getResources().getString(R.string.download_center_platinum_speedup_for_you));
                return;
            case 4:
                b(getResources().getString(R.string.download_center_freetrial_tip));
                return;
            case 5:
                a(getResources().getString(R.string.download_center_mobile_net_download_tip));
                this.k.setOnClickListener(null);
                this.f.setOnClickListener(null);
                downloadingTipType = com.xunlei.xllib.android.b.c(getContext());
                if (!TextUtils.isEmpty(downloadingTipType)) {
                    if (UtilityImpl.NET_TYPE_2G.equals(downloadingTipType)) {
                        setSpeedTipIcon(R.drawable.dl_tab_2g_icon);
                        return;
                    } else if (UtilityImpl.NET_TYPE_3G.equals(downloadingTipType)) {
                        setSpeedTipIcon(R.drawable.dl_tab_3g_icon);
                        return;
                    } else if (UtilityImpl.NET_TYPE_4G.equals(downloadingTipType) != null) {
                        setSpeedTipIcon(R.drawable.dl_tab_4g_icon);
                        return;
                    }
                }
                setSpeedTipIcon(-1);
                return;
            case 6:
                c(getResources().getString(R.string.download_center_open_vip_tip));
                return;
            case 7:
                c(getResources().getString(R.string.download_center_open_vip_tip_low_speed));
                return;
            case 8:
                d(getResources().getString(R.string.download_center_kuainiao_tip_normal));
                setSpeedTipIcon(-1);
                return;
            case 9:
                d(getResources().getString(R.string.download_center_kuainiao_tip_normal));
                setSpeedTipIcon(R.drawable.dl_tab_speed_up_icon);
                return;
            default:
                e();
                if (TextUtils.isEmpty(this.D) != null) {
                    this.k.setVisibility(8);
                    this.k.setOnClickListener(null);
                    this.f.setOnClickListener(null);
                    this.i.setVisibility(0);
                    this.i.getPaint().setFakeBoldText(true);
                    this.i.setText(this.g.getText());
                    this.f.setVisibility(8);
                    setSpeedTipIcon(-1);
                }
                return;
        }
    }

    private void d() {
        if (this.u == null) {
            this.u = new PreferenceHelper(this.c, "tip_kuai_niao_show");
        }
        if (this.v == null) {
            this.v = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        PreferenceHelper preferenceHelper = this.u;
        StringBuilder stringBuilder = new StringBuilder("tip_kuai_niao_show");
        stringBuilder.append(this.v);
        if (TextUtils.isEmpty(preferenceHelper.getString(stringBuilder.toString(), ""))) {
            com.xunlei.downloadprovider.download.report.a.e();
            preferenceHelper = this.u;
            stringBuilder = new StringBuilder("tip_kuai_niao_show");
            stringBuilder.append(this.v);
            preferenceHelper.putString(stringBuilder.toString(), "has_show");
        }
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

    private void setSpeedTipIcon(int i) {
        if (i <= 0) {
            this.h.setVisibility(8);
            return;
        }
        this.h.setVisibility(0);
        if (this.t != i) {
            this.h.setImageResource(i);
            this.t = i;
        }
    }

    private void a(String str) {
        this.k.setVisibility(0);
        this.l.setVisibility(8);
        this.w.setVisibility(8);
        this.o.setVisibility(0);
        this.o.setText(str);
        this.o.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        this.k.setOnClickListener(null);
        this.f.setOnClickListener(null);
        this.o.setOnClickListener(null);
    }

    private OnClickListener getLoginInfoClickListener() {
        if (this.p == null) {
            this.p = new d(this);
        }
        return this.p;
    }

    private OnClickListener getKuaiNiaoClickListener() {
        if (this.q == null) {
            this.q = new e(this);
        }
        return this.q;
    }

    public StatusInfo getStatusInfo() {
        if (this.a == null) {
            this.a = new StatusInfo();
        }
        return this.a;
    }

    public void setActionListener(a aVar) {
        this.r = aVar;
    }

    public void setDownloadSpeed(long j) {
        if (this.g != null) {
            String[] b = com.xunlei.downloadprovider.download.util.a.b(j);
            String str = b[0];
            String str2 = b[1];
            if (j == 0) {
                str = "0.0";
                str2 = e.c[1];
            }
            j = this.g;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(str2);
            j.setText(stringBuilder.toString());
            b();
        }
    }

    private void e() {
        String a = f.a(PayFrom.DOWNLOAD_LIST_TOP_TXT_LINK);
        if (TextUtils.isEmpty(this.D)) {
            r b = c.a().b(a);
            if (b != null) {
                this.D = b.b;
            }
        }
    }

    private OnClickListener getActivityTxtLinkClickListener() {
        if (this.s == null) {
            this.s = new f(this);
        }
        return this.s;
    }

    private void b(String str) {
        this.k.setVisibility(0);
        this.w.setVisibility(0);
        this.o.setVisibility(8);
        this.l.setVisibility(8);
        this.f.setOnClickListener(null);
        this.k.setOnClickListener(null);
        this.y.setText(str);
        this.x.setVisibility(8);
        setSpeedTipIcon(R.drawable.dl_tab_speed_up_icon);
    }

    private void c(String str) {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.o.setVisibility(8);
        this.w.setVisibility(8);
        this.k.setOnClickListener(getLoginInfoClickListener());
        this.f.setOnClickListener(getLoginInfoClickListener());
        TextView textView = this.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" >");
        textView.setText(stringBuilder.toString());
        setSpeedTipIcon(-1);
    }

    private void d(String str) {
        this.k.setVisibility(0);
        this.l.setVisibility(0);
        this.o.setVisibility(8);
        this.w.setVisibility(8);
        this.f.setOnClickListener(getKuaiNiaoClickListener());
        this.k.setOnClickListener(getKuaiNiaoClickListener());
        TextView textView = this.n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" >");
        textView.setText(stringBuilder.toString());
        this.m.setImageResource(R.drawable.dl_tab_warning);
    }

    static /* synthetic */ void a(DownloadBriefInfoView downloadBriefInfoView) {
        if (downloadBriefInfoView.d == null) {
            downloadBriefInfoView.d = new p(downloadBriefInfoView.c);
            downloadBriefInfoView.d.setOnDismissListener(new c(downloadBriefInfoView));
        }
        downloadBriefInfoView.d.show();
    }
}
