package com.xunlei.downloadprovider.download.tasklist.list.banner.c;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.ColorRes;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.androidutil.PreferenceHelper;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.net.volley.BaseStringRequest;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.tasklist.list.a.b;
import com.xunlei.downloadprovider.download.tasklist.list.a.c;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager;
import com.xunlei.downloadprovider.download.tasklist.list.banner.BannerManager$BannerType;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.download.util.k;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.member.payment.activity.r;
import com.xunlei.downloadprovider.member.payment.external.PayFrom;
import com.xunlei.downloadprovider.personal.a.i;
import com.xunlei.downloadprovider.web.base.CustomWebViewActivity;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: DownloadFreeTrialBanner */
public final class a extends c {
    public DownloadTaskInfo a;
    public OnClickListener b;
    Context c;
    public b d;
    public ImageView e;
    public com.xunlei.downloadprovider.download.control.a f;
    public boolean g = null;
    private int j;
    private ImageView k;
    private View l;
    private OnClickListener m = new c(this);

    public a(Context context, ViewStub viewStub) {
        super(viewStub);
        this.c = context;
    }

    public final void onInflate(ViewStub viewStub, View view) {
        super.onInflate(viewStub, view);
        this.e = (ImageView) view.findViewById(R.id.actionAnimationButton);
        this.d = new b(view);
        this.d.a(com.xunlei.downloadprovider.download.c.a.a().h());
        this.d.b(com.xunlei.downloadprovider.download.c.a.l());
        view.findViewById(R.id.actionAreaLayout).setOnClickListener(this.m);
        this.d.g.setOnClickListener(new b(this));
        if (g() == null) {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.titleTextView), viewStub);
        } else {
            viewStub = view.getResources().getDimensionPixelSize(R.dimen.task_card_banner_style1_content_padding_left);
            c.a(view.findViewById(R.id.task_card_banner_divider), viewStub);
            c.a(view.findViewById(R.id.titleTextView), viewStub);
        }
        this.k = (ImageView) view.findViewById(R.id.red_packet_iv);
        this.l = view.findViewById(R.id.red_packet_container);
    }

    private void a() {
        if (this.a != null) {
            String format = new SimpleDateFormat("yyyyMMdd").format(new Date());
            PreferenceHelper preferenceHelper = com.xunlei.downloadprovider.download.c.a.a().j;
            StringBuilder stringBuilder = new StringBuilder("firstTriedTaskId");
            stringBuilder.append(format);
            if (preferenceHelper.getLong(stringBuilder.toString(), 0) == this.a.getTaskId()) {
                preferenceHelper = com.xunlei.downloadprovider.download.c.a.a().j;
                stringBuilder = new StringBuilder("isFirstTrialAction");
                stringBuilder.append(format);
                preferenceHelper.setBoolean(stringBuilder.toString(), true);
            }
        }
    }

    public final void a(int i) {
        this.j = i;
        if (i == 1) {
            a(com.xunlei.downloadprovider.download.c.a.m());
        } else if (i == 0) {
            a(com.xunlei.downloadprovider.download.c.a.l());
        } else {
            if (i == 2) {
                a(com.xunlei.downloadprovider.download.c.a.n());
            }
        }
    }

    public final void b(@ColorRes int i) {
        if (!(this.d == null || this.d.h == null)) {
            if (this.j == 0 || !f.a().b()) {
                this.d.h.setTextColor(this.c.getResources().getColor(i));
            } else {
                this.d.h.setTextColor(this.c.getResources().getColor(R.color.task_card_accent_color_orange));
            }
        }
    }

    private void a(String str) {
        if (this.d != null) {
            CharSequence charSequence;
            f a = f.a();
            if (a.g()) {
                r f = a.f();
                if (!(f == null || TextUtils.isEmpty(f.b))) {
                    charSequence = f.b;
                    if (this.j == 0) {
                        charSequence = str;
                    }
                    if (TextUtils.isEmpty(charSequence)) {
                        str = charSequence;
                    }
                    this.d.b(str);
                }
            }
            charSequence = "开通会员";
            if (this.j == 0) {
                charSequence = str;
            }
            if (TextUtils.isEmpty(charSequence)) {
                str = charSequence;
            }
            this.d.b(str);
        }
    }

    public final void a(CharSequence charSequence) {
        if (this.d != null) {
            CharSequence charSequence2;
            f a = f.a();
            if (a.g()) {
                r f = a.f();
                charSequence2 = (f == null || TextUtils.isEmpty(f.d)) ? "恭喜您获得一次开通会员的机会" : f.d;
            } else {
                charSequence2 = "";
            }
            if (this.j == 0) {
                charSequence2 = charSequence;
            }
            if (!TextUtils.isEmpty(charSequence2)) {
                charSequence = charSequence2;
            }
            this.d.a(charSequence);
        }
    }

    public final void a(DownloadTaskInfo downloadTaskInfo, boolean z) {
        LayoutParams layoutParams;
        if (this.j == 0) {
            if (com.xunlei.downloadprovider.download.c.a.o()) {
                this.l.setVisibility(0);
                this.l.setBackgroundResource(R.drawable.task_card_button_sold_yellow_left_radius);
                downloadTaskInfo = DipPixelUtil.dip2px(4.0f);
                this.l.setPadding(downloadTaskInfo, 0, downloadTaskInfo, 0);
                this.k.setImageResource(true);
                layoutParams = (LayoutParams) this.k.getLayoutParams();
                layoutParams.gravity = true;
                this.k.setLayoutParams(layoutParams);
                this.d.i.setBackgroundResource(true);
                this.d.i.setTextColor(-1);
                com.xunlei.downloadprovider.download.c.a.a().g = false;
            } else if (com.xunlei.downloadprovider.download.c.a.a(downloadTaskInfo)) {
                this.l.setVisibility(8);
                this.d.i.setText(R.string.free_trial_share_guide_banner_btn);
                boolean z2 = true;
                if (z) {
                    com.xunlei.downloadprovider.download.c.a.a().g = true;
                }
                z = com.xunlei.downloadprovider.download.c.a.a();
                long taskId = downloadTaskInfo.getTaskId();
                if (taskId < 0 || z.h == null || z.h.isEmpty() || !z.h.contains(Long.valueOf(taskId))) {
                    z2 = false;
                }
                if (!z2) {
                    com.xunlei.downloadprovider.download.report.a.j("download_bar_try");
                    z = com.xunlei.downloadprovider.download.c.a.a();
                    long taskId2 = downloadTaskInfo.getTaskId();
                    if (taskId2 >= 0 && (z.h.isEmpty() != null || z.h.contains(Long.valueOf(taskId2)) == null)) {
                        z.h.add(Long.valueOf(taskId2));
                    }
                }
            } else {
                this.l.setVisibility(8);
                this.d.i.setBackgroundResource(R.drawable.task_card_button_sold_orange_selector);
                this.d.i.setTextColor(-1);
            }
        } else if (f.a().g() != null) {
            this.l.setVisibility(0);
            this.l.setBackgroundResource(R.drawable.task_card_button_sold_yellow_left_radius);
            this.l.setPadding(DipPixelUtil.dip2px(7.0f), 0, 0, 0);
            layoutParams = (LayoutParams) this.k.getLayoutParams();
            layoutParams.gravity = true;
            this.k.setLayoutParams(layoutParams);
            this.k.setImageResource(true);
            this.d.i.setBackgroundResource(true);
            this.d.i.setTextColor(Color.parseColor("#fD5634"));
        } else {
            this.l.setVisibility(8);
            this.d.i.setBackgroundResource(R.drawable.task_card_button_sold_orange_selector);
            this.d.i.setTextColor(-1);
        }
    }

    public final void a(long j) {
        BannerManager.a().a(false, BannerManager$BannerType.TYPE_FREE_TRIAL, j, null);
        d(8);
    }

    static /* synthetic */ void b(a aVar) {
        aVar = aVar.a.mIsEnteredHighSpeedTrial ? k.a(aVar.a) != null ? "finish" : "in" : com.xunlei.downloadprovider.download.c.a.a().b() != null ? "finish" : "before";
        com.xunlei.downloadprovider.download.report.a.d(aVar);
    }

    static /* synthetic */ void a(a aVar, View view) {
        aVar.f.a(aVar.a, "", "", "download_bar_try", new d(aVar, (Activity) aVar.c, aVar.a, "", view));
        com.xunlei.downloadprovider.download.report.a.k("download_bar_try");
    }

    static /* synthetic */ void a(a aVar, View view, boolean z) {
        aVar.a();
        if (aVar.j == 1) {
            if (aVar.a != null) {
                com.xunlei.downloadprovider.download.report.a.a(k.d(aVar.a) != null ? "using" : "finish", f.a().e(), aVar.a);
            }
            view = f.a();
            if (view.g()) {
                view = view.f();
                if (!(view == null || TextUtils.isEmpty(view.g))) {
                    view = view.g;
                    if (TextUtils.isEmpty(view)) {
                        CustomWebViewActivity.a(aVar.c, "", view, "", CustomWebViewActivity.class);
                    } else {
                        com.xunlei.downloadprovider.download.control.a.a(aVar.c, PayFrom.DOWNLOAD_TASK_FREE_TRIAL, aVar.a == null ? aVar.a.getTaskId() : 0);
                    }
                }
            }
            view = "";
            if (TextUtils.isEmpty(view)) {
                if (aVar.a == null) {
                }
                com.xunlei.downloadprovider.download.control.a.a(aVar.c, PayFrom.DOWNLOAD_TASK_FREE_TRIAL, aVar.a == null ? aVar.a.getTaskId() : 0);
            } else {
                CustomWebViewActivity.a(aVar.c, "", view, "", CustomWebViewActivity.class);
            }
        } else if (aVar.j != 0 || aVar.a == null) {
            if (aVar.j) {
                if (aVar.b) {
                    aVar.b.onClick(view);
                }
                if (aVar.a != null) {
                    BannerManager.a().a(false, BannerManager$BannerType.TYPE_FREE_TRIAL, aVar.a.getTaskId(), null);
                    com.xunlei.downloadprovider.download.c.a.a().b(aVar.a.getTaskId(), com.xunlei.downloadprovider.download.c.a.c);
                }
                i.a(aVar.c, com.xunlei.downloadprovider.personal.a.b.a.b, "DownloadFreeTrialBanner");
            }
        } else {
            if (com.xunlei.downloadprovider.download.c.a.o() != null) {
                view = f.a();
                StringBuilder stringBuilder = new StringBuilder("http://dypay.vip.xunlei.com/lxtry/getprize");
                LoginHelper.a();
                if (l.b()) {
                    stringBuilder.append("?userid=");
                    stringBuilder.append(LoginHelper.a().g.c());
                    stringBuilder.append("&sessionid=");
                    stringBuilder.append(LoginHelper.a().c());
                }
                view.a(new BaseStringRequest(stringBuilder.toString(), new l(view), new m(view)));
            }
            aVar.j = 1;
            com.xunlei.downloadprovider.download.report.a.a(f.a().e(), aVar.a);
            LoginHelper.a();
            if (l.b() == null) {
                if (z) {
                    LoginHelper.a().a(aVar.c, new e(aVar), LoginFrom.BASE_PAY, null);
                    return;
                }
            }
            aVar.d.b(com.xunlei.downloadprovider.download.c.a.m());
            aVar.a(com.xunlei.downloadprovider.download.c.a.b(ConvertUtil.byteConvert((long) (((double) aVar.a.mFileSize) * 0.2d))));
            if (aVar.a.getTaskStatus() == true && aVar.f != null) {
                aVar.f.c(aVar.a);
            }
            aVar.a.mIsEnteredHighSpeedTrial = true;
            com.xunlei.downloadprovider.download.c.a.a().g(aVar.a.getTaskId());
            com.xunlei.downloadprovider.download.c.a.a().d(aVar.a.getTaskId());
            view = new StringBuilder("title = ");
            view.append(aVar.a.mTitle);
            view.append("   mCurrentTask.mDownloadedSize = ");
            view.append(aVar.a.mDownloadedSize);
            com.xunlei.downloadprovider.download.c.a.a().c(aVar.a.mDownloadedSize);
            com.xunlei.downloadprovider.download.c.a.a().c();
        }
    }
}
