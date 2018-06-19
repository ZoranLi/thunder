package com.xunlei.downloadprovider.download.player.a;

import android.content.BroadcastReceiver;
import android.text.SpannableString;
import android.text.TextUtils;
import com.umeng.message.proguard.k;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.commonutil.ConvertUtil;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.player.views.DownloadVodPlayerView;
import com.xunlei.downloadprovider.download.player.views.member.widget.MemberActionLoadingView;
import com.xunlei.downloadprovider.download.player.views.member.widget.MemberActionStatusView;
import com.xunlei.downloadprovider.download.player.views.member.widget.MemberActionView;
import com.xunlei.downloadprovider.download.player.views.member.widget.MemberActionViewGroup;
import com.xunlei.downloadprovider.download.player.views.member.widget.MemberSpeedTextView;
import com.xunlei.downloadprovider.download.util.DownloadError;
import com.xunlei.downloadprovider.download.util.DownloadError.FailureCode;
import com.xunlei.downloadprovider.h.c;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.h;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.vod.speedplayback.a;
import com.xunlei.downloadprovider.vod.speeduptrial.BubbleBarView;
import com.xunlei.downloadprovider.vod.speeduptrial.BubbleTipBar;
import com.xunlei.downloadprovider.vod.speeduptrial.d;
import com.xunlei.downloadprovider.vod.speeduptrial.f;
import com.xunlei.downloadprovider.vodnew.a.e.o.e;

/* compiled from: VipAccelerateTryController */
public final class bn extends f {
    private TaskInfo a;
    private MemberActionViewGroup b;
    private MemberActionLoadingView c;
    private f d;
    private boolean g = false;
    private Runnable h = new bq(this);
    private long i = 0;
    private boolean j = false;
    private BroadcastReceiver k = new bt(this);
    private a l;
    private e m = new bw(this);
    private h n = new bx(this);
    private BroadcastReceiver o = new bp(this);

    public bn(com.xunlei.downloadprovider.download.player.a aVar, DownloadVodPlayerView downloadVodPlayerView) {
        super(aVar, downloadVodPlayerView);
        if (downloadVodPlayerView != null) {
            this.b = (MemberActionViewGroup) downloadVodPlayerView.getPlayerBottomViewGroup().findViewById(R.id.member_action_view_group);
            this.c = (MemberActionLoadingView) downloadVodPlayerView.getPlayerCenterViewGroup().findViewById(R.id.member_action_loading_view);
            BubbleTipBar bubbleTipBar = (BubbleTipBar) downloadVodPlayerView.findViewById(R.id.bottom_bubble_tip_bar);
            if (bubbleTipBar != null) {
                this.d = new f(downloadVodPlayerView.getContext(), bubbleTipBar);
                this.d.g = new br(this);
            }
            downloadVodPlayerView.getPlayerBottomViewGroup().setIViewStateChangeListener(new bs(this));
            m();
            if (downloadVodPlayerView != null) {
                this.l = new a(downloadVodPlayerView, new bu(this));
                this.l.e = new bv(this);
            }
        }
        c.a(downloadVodPlayerView.getContext(), "ACTION_PLAYERVIEW_PROGRESS_BAR_StopTrackingTouch", this.k);
        c.a(downloadVodPlayerView.getContext(), "DownloadVodPlayerController.ACTION_PLAY_COMPLETION", this.o);
        if (f() != null) {
            f().a(this.m);
        }
        LoginHelper.a().a(this.n);
    }

    public final void d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.e;
        if (r0 == 0) goto L_0x0021;
    L_0x0004:
        r0 = r2.e;
        r1 = r2.h;
        r0.removeCallbacks(r1);
        r0 = r2.e;	 Catch:{ Exception -> 0x0021 }
        r0 = r0.getContext();	 Catch:{ Exception -> 0x0021 }
        r1 = r2.k;	 Catch:{ Exception -> 0x0021 }
        com.xunlei.downloadprovider.h.c.a(r0, r1);	 Catch:{ Exception -> 0x0021 }
        r0 = r2.e;	 Catch:{ Exception -> 0x0021 }
        r0 = r0.getContext();	 Catch:{ Exception -> 0x0021 }
        r1 = r2.o;	 Catch:{ Exception -> 0x0021 }
        com.xunlei.downloadprovider.h.c.a(r0, r1);	 Catch:{ Exception -> 0x0021 }
    L_0x0021:
        r2.m();
        r0 = r2.l;
        if (r0 == 0) goto L_0x002d;
    L_0x0028:
        r0 = r2.l;
        r0.a();
    L_0x002d:
        r0 = r2.f();
        if (r0 == 0) goto L_0x003c;
    L_0x0033:
        r0 = r2.f();
        r1 = r2.m;
        r0.b(r1);
    L_0x003c:
        r0 = com.xunlei.downloadprovider.member.login.LoginHelper.a();
        r1 = r2.n;
        r0.b(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.player.a.bn.d():void");
    }

    public final void a(long j) {
        n.a();
        j = n.f(j);
        if (this.e != null) {
            this.a = j;
            this.e.post(this.h);
        }
    }

    public final void a(boolean z) {
        super.a(z);
        if (this.e != null) {
            this.g = z;
            if (z) {
                this.e.postDelayed(new bo(this), 1000);
                if (this.i <= 0 && r()) {
                    this.i = System.currentTimeMillis();
                }
            } else {
                m();
                if (this.l != null) {
                    this.l.a();
                }
            }
            this.e.getPlayerBottomViewGroup().setFullScreeBtnVisible(z);
            if (this.l != null) {
                this.l.a(z);
            }
        }
    }

    private void m() {
        if (this.b != null) {
            this.b.setVisibility(8);
        }
        if (this.c != null) {
            this.c.setVisibility(8);
            MemberActionLoadingView memberActionLoadingView = this.c;
            memberActionLoadingView.a.clear();
            memberActionLoadingView.c = 0;
            memberActionLoadingView.d = 0;
        }
    }

    private boolean r() {
        if (f() == null) {
            return false;
        }
        m f = f();
        boolean z = f.a != null && f.a.r();
        if (!z) {
            f = f();
            z = f.a != null && f.a.s();
            if (!z) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ void a(bn bnVar) {
        if (bnVar.b != null) {
            bnVar = bnVar.b;
            if (bnVar.a.getVisibility() == 0) {
                bnVar = bnVar.a;
                String valueOf;
                StatEvent build;
                if (TextUtils.equals(bnVar.getText(), "加速试用")) {
                    LoginHelper.a();
                    bnVar = l.c();
                    boolean l = LoginHelper.a().l();
                    valueOf = String.valueOf(LoginHelper.a().g.c());
                    build = HubbleEventBuilder.build("android_player", "bxbb_vipspeedup_try_btn_show");
                    build.add("is_login", bnVar);
                    build.add(SocializeConstants.TENCENT_UID, valueOf);
                    build.add("is_vip", l);
                    ThunderReport.reportEvent(build);
                    return;
                }
                String valueOf2 = String.valueOf(LoginHelper.a().g.c());
                valueOf = String.valueOf(LoginHelper.a().g.f());
                bnVar = MemberActionView.a(bnVar.getTaskInfo());
                build = HubbleEventBuilder.build("android_player", "bxbb_vipspeedup_btn_show");
                build.add("product_type", valueOf);
                build.add("userid", valueOf2);
                build.add("vipspeedup_try", bnVar);
                ThunderReport.reportEvent(build);
            }
        }
    }

    static /* synthetic */ void c(bn bnVar) {
        if (bnVar.b != null) {
            int indexOf;
            int i;
            MemberActionView memberActionView;
            MemberActionViewGroup memberActionViewGroup = bnVar.b;
            bnVar = bnVar.a;
            int i2 = 8;
            if (bnVar != null) {
                MemberActionView memberActionView2;
                int i3;
                MemberSpeedTextView memberSpeedTextView = memberActionViewGroup.c;
                if (!(bnVar == null || com.xunlei.downloadprovider.download.player.views.member.a.f(bnVar))) {
                    if (bnVar.getTaskStatus() != 4) {
                        memberSpeedTextView.setVisibility(0);
                        Object obj = "";
                        boolean l = j.a().a.l();
                        if (com.xunlei.downloadprovider.download.player.views.member.a.c(bnVar) && !l) {
                            obj = "加速试用已结束，会员不限量";
                        } else if (l || com.xunlei.downloadprovider.download.player.views.member.a.b(bnVar)) {
                            StringBuilder stringBuilder = new StringBuilder("(+");
                            stringBuilder.append(com.xunlei.downloadprovider.download.util.a.a(bnVar.mVipAcceleratedSpeed));
                            stringBuilder.append(k.t);
                            String stringBuilder2 = stringBuilder.toString();
                            String a = MemberSpeedTextView.a(memberSpeedTextView.getContext(), bnVar.mDownloadSpeed);
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(a);
                            stringBuilder3.append(stringBuilder2);
                            obj = stringBuilder3.toString();
                        }
                        if (TextUtils.isEmpty(obj)) {
                            memberSpeedTextView.setText("");
                        } else {
                            indexOf = obj.indexOf(k.s);
                            int indexOf2 = obj.indexOf(k.t) + 1;
                            CharSequence spannableString = new SpannableString(obj);
                            if (indexOf >= 0 && indexOf2 > 0) {
                                spannableString.setSpan(memberSpeedTextView.a, indexOf, indexOf2, 18);
                            } else if (com.xunlei.downloadprovider.download.player.views.member.a.c(bnVar)) {
                                spannableString.setSpan(memberSpeedTextView.b, 0, obj.length(), 18);
                            }
                            memberSpeedTextView.setText(spannableString);
                        }
                        memberActionView2 = memberActionViewGroup.a;
                        memberActionView2.setTag(bnVar);
                        if (!com.xunlei.downloadprovider.download.player.views.member.a.f(bnVar)) {
                            memberActionView2.setText(com.xunlei.downloadprovider.download.player.views.member.a.a(bnVar));
                            if (TextUtils.isEmpty(memberActionView2.getText().toString())) {
                                i3 = 0;
                                memberActionView2.setVisibility(i3);
                            }
                        }
                        i3 = 8;
                        memberActionView2.setVisibility(i3);
                    }
                }
                memberSpeedTextView.setText("");
                memberSpeedTextView.setVisibility(8);
                memberActionView2 = memberActionViewGroup.a;
                memberActionView2.setTag(bnVar);
                if (com.xunlei.downloadprovider.download.player.views.member.a.f(bnVar)) {
                    memberActionView2.setText(com.xunlei.downloadprovider.download.player.views.member.a.a(bnVar));
                    if (TextUtils.isEmpty(memberActionView2.getText().toString())) {
                        i3 = 0;
                        memberActionView2.setVisibility(i3);
                    }
                }
                i3 = 8;
                memberActionView2.setVisibility(i3);
            }
            MemberActionStatusView memberActionStatusView = memberActionViewGroup.b;
            CharSequence charSequence = "本地";
            if (bnVar != null) {
                if (bnVar.getTaskStatus() == 8) {
                    charSequence = "本地";
                } else if (bnVar.getTaskStatus() == 16 && DownloadError.a(bnVar.mOriginalStatusCode) == FailureCode.INSUFFICIENT_SPACE) {
                    charSequence = "存储空间不足";
                } else {
                    indexOf = com.xunlei.downloadprovider.download.player.views.member.a.e(bnVar);
                    if (bnVar.mDownloadSpeed <= 1 || indexOf != 1) {
                        charSequence = indexOf == 2 ? "加速失败" : "";
                    } else {
                        if (LoginHelper.a().t()) {
                            charSequence = "超级会员加速中";
                            i = R.drawable.ic_super_member;
                        } else if (LoginHelper.a().s()) {
                            charSequence = "白金会员加速中";
                            i = R.drawable.ic_platium_member;
                        } else if (LoginHelper.a().l()) {
                            charSequence = "加速中";
                            i = R.drawable.ic_download_accelerate_48;
                        }
                        memberActionStatusView.setText(charSequence);
                        if (i == 0) {
                            memberActionStatusView.setCompoundDrawablesWithIntrinsicBounds(memberActionStatusView.getContext().getResources().getDrawable(i), null, null, null);
                        } else {
                            memberActionStatusView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                        }
                        memberActionStatusView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
                        if (memberActionViewGroup.a.getVisibility() == 0) {
                            memberActionView = memberActionViewGroup.a;
                            if (memberActionViewGroup.b.getVisibility() != 0) {
                                if (com.xunlei.downloadprovider.download.player.views.member.a.f(bnVar) != null) {
                                    i2 = 0;
                                }
                            }
                            memberActionView.setVisibility(i2);
                        }
                        memberActionViewGroup.setVisibility(0);
                    }
                }
            }
            i = 0;
            memberActionStatusView.setText(charSequence);
            if (i == 0) {
                memberActionStatusView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
            } else {
                memberActionStatusView.setCompoundDrawablesWithIntrinsicBounds(memberActionStatusView.getContext().getResources().getDrawable(i), null, null, null);
            }
            if (TextUtils.isEmpty(charSequence)) {
            }
            memberActionStatusView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
            if (memberActionViewGroup.a.getVisibility() == 0) {
                memberActionView = memberActionViewGroup.a;
                if (memberActionViewGroup.b.getVisibility() != 0) {
                    if (com.xunlei.downloadprovider.download.player.views.member.a.f(bnVar) != null) {
                        i2 = 0;
                    }
                }
                memberActionView.setVisibility(i2);
            }
            memberActionViewGroup.setVisibility(0);
        }
    }

    static /* synthetic */ void d(bn bnVar) {
        if (!(bnVar.c == null || bnVar.e == null)) {
            int i = bnVar.f() != null ? bnVar.f().l + 1 : 0;
            boolean z = bnVar.e.getViewState() == 1 && com.xunlei.downloadprovider.download.player.views.member.a.a.contains(Integer.valueOf(i)) && !bnVar.j;
            boolean z2 = bnVar.i > 0 && System.currentTimeMillis() - bnVar.i >= 3000;
            z2 = bnVar.r() && z2;
            MemberActionLoadingView memberActionLoadingView = bnVar.c;
            bnVar = bnVar.a;
            if (bnVar != null) {
                memberActionLoadingView.setTag(bnVar);
                if (com.xunlei.downloadprovider.download.player.views.member.a.e(bnVar) == 0) {
                    if (!com.xunlei.downloadprovider.download.player.views.member.a.b(bnVar)) {
                        if (com.xunlei.downloadprovider.download.player.views.member.a.c(bnVar)) {
                            memberActionLoadingView.setText("开启会员加速，享受高速看片>");
                            if (memberActionLoadingView.a.contains("开启会员加速，享受高速看片>") == null) {
                                memberActionLoadingView.a.add("开启会员加速，享受高速看片>");
                                com.xunlei.downloadprovider.player.a.a(String.valueOf(LoginHelper.a().g.c()), String.valueOf(LoginHelper.a().g.f()), true);
                            }
                            memberActionLoadingView.setVisibility(0);
                            return;
                        } else if (!z2 || com.xunlei.downloadprovider.download.player.views.member.a.b(bnVar)) {
                            if (z) {
                                if (com.xunlei.downloadprovider.download.c.a.a().d(bnVar) != null) {
                                    memberActionLoadingView.setText("免费试用会员加速，立即告别卡顿>");
                                    if (memberActionLoadingView.b != i && memberActionLoadingView.d < com.xunlei.downloadprovider.download.player.views.member.a.a.size()) {
                                        memberActionLoadingView.d += 1;
                                        LoginHelper.a();
                                        bnVar = l.c();
                                        boolean l = LoginHelper.a().l();
                                        String valueOf = String.valueOf(LoginHelper.a().g.c());
                                        StatEvent build = HubbleEventBuilder.build("android_player", "bxbb_kadun_vipspeedup_try_show");
                                        build.add("is_login", bnVar);
                                        build.add(SocializeConstants.TENCENT_UID, valueOf);
                                        build.add("is_vip", l);
                                        ThunderReport.reportEvent(build);
                                    }
                                    memberActionLoadingView.b = i;
                                    memberActionLoadingView.setVisibility(0);
                                    return;
                                }
                                memberActionLoadingView.setText("会员尊享视频加速特权，告别卡顿畅快观影>");
                                if (memberActionLoadingView.b != i && memberActionLoadingView.c < com.xunlei.downloadprovider.download.player.views.member.a.a.size()) {
                                    memberActionLoadingView.c += 1;
                                    com.xunlei.downloadprovider.player.a.a(String.valueOf(LoginHelper.a().g.c()), String.valueOf(LoginHelper.a().g.f()), false);
                                }
                                memberActionLoadingView.b = i;
                                memberActionLoadingView.setVisibility(0);
                                return;
                            }
                        } else if (com.xunlei.downloadprovider.download.c.a.a().d(bnVar) != null) {
                            memberActionLoadingView.setText("免费试用会员加速，体验高速看片>");
                            if (memberActionLoadingView.a.contains("免费试用会员加速，体验高速看片>") == null) {
                                memberActionLoadingView.a.add("免费试用会员加速，体验高速看片>");
                                LoginHelper.a();
                                bnVar = l.c();
                                boolean l2 = LoginHelper.a().l();
                                String valueOf2 = String.valueOf(LoginHelper.a().g.c());
                                StatEvent build2 = HubbleEventBuilder.build("android_player", "bxbb_buffer_vipspeedup_try_qp_show");
                                build2.add("is_login", bnVar);
                                build2.add(SocializeConstants.TENCENT_UID, valueOf2);
                                build2.add("is_vip", l2);
                                ThunderReport.reportEvent(build2);
                            }
                            memberActionLoadingView.setVisibility(0);
                            return;
                        } else {
                            memberActionLoadingView.setText("开启会员加速，播放更顺畅>");
                            if (memberActionLoadingView.a.contains("开启会员加速，播放更顺畅>") == null) {
                                memberActionLoadingView.a.add("开启会员加速，播放更顺畅>");
                                bnVar = String.valueOf(LoginHelper.a().g.c());
                                String valueOf3 = String.valueOf(LoginHelper.a().g.f());
                                StatEvent build3 = HubbleEventBuilder.build("android_player", "bxbb_buffer_qp_show");
                                build3.add("product_type", valueOf3);
                                build3.add("userid", bnVar);
                                ThunderReport.reportEvent(build3);
                            }
                            memberActionLoadingView.setVisibility(0);
                            return;
                        }
                    }
                }
                memberActionLoadingView.setVisibility(8);
                return;
            }
            memberActionLoadingView.setText("");
            memberActionLoadingView.setVisibility(8);
        }
    }

    static /* synthetic */ void f(bn bnVar) {
        if (bnVar.d != null) {
            f fVar = bnVar.d;
            bnVar = bnVar.a;
            if (bnVar != null) {
                fVar.f = bnVar;
                if (!(fVar.b() == null || fVar.b == null || com.xunlei.downloadprovider.download.c.a.a().a(fVar.f.getTaskId()) == null)) {
                    BubbleBarView bubbleBarView;
                    BubbleBarView bubbleBarView2;
                    long j;
                    long i;
                    StringBuilder stringBuilder;
                    int i2 = 0;
                    if (com.xunlei.downloadprovider.download.c.a.b(fVar.f) == null) {
                        if (fVar.d.b(16) == null) {
                            bnVar = null;
                            if (bnVar == null) {
                                if (fVar.d.b(8) != null) {
                                    if (fVar.d.b(16) != null) {
                                        fVar.d.a(4);
                                        fVar.d.a(16);
                                        if (fVar.a.a.g != null) {
                                            bnVar = fVar.a;
                                            bubbleBarView = bnVar.a;
                                            bubbleBarView.c.end();
                                            bubbleBarView.d.end();
                                            bubbleBarView.clearAnimation();
                                            bubbleBarView.g = false;
                                            bnVar.clearAnimation();
                                            fVar.a.a();
                                        } else if (fVar.a.c() == null) {
                                            fVar.a.a();
                                        } else {
                                            fVar.e.c();
                                        }
                                        bnVar = HubbleEventBuilder.build("android_player", "bxbb_xfc_tryendkt_show");
                                        bnVar.add("is_login", d.a());
                                        ThunderReport.reportEvent(bnVar);
                                    }
                                }
                                if (fVar.d.b(4) == null) {
                                    fVar.c();
                                }
                            } else {
                                if (fVar.d.b(8) == null) {
                                    fVar.d.a(8);
                                    bnVar = fVar.a;
                                    if (bnVar.getVisibility() != 0) {
                                        bnVar.setVisibility(0);
                                    }
                                    bnVar = bnVar.a;
                                    if (bnVar.h != null) {
                                        bnVar.h.g(bnVar);
                                    }
                                    bnVar.b = BubbleBarView.a;
                                    bnVar.requestLayout();
                                    if (bnVar.h != null) {
                                        bnVar.h.h(bnVar);
                                    }
                                    bnVar = fVar.a;
                                    bubbleBarView2 = bnVar.a;
                                    if (bnVar != null) {
                                        if (bnVar.getVisibility() != 0) {
                                            bnVar.setVisibility(0);
                                        }
                                        bnVar.startAnimation(bubbleBarView2.e);
                                    }
                                }
                                fVar.a.setVisibility(0);
                            }
                            if (fVar.d.b(16) == null) {
                                fVar.a.setProgress(100);
                                fVar.c.b();
                                fVar.a("试用已结束", "开通会员>>");
                                return;
                            }
                            bnVar = fVar.a;
                            j = com.xunlei.downloadprovider.download.util.k.j(fVar.f);
                            i = com.xunlei.downloadprovider.download.util.k.i(fVar.f);
                            if (j > 0) {
                                i2 = (int) (((j - i) * 100) / j);
                            }
                            bnVar.setProgress(i2);
                            bnVar = new StringBuilder("+");
                            bnVar.append(com.xunlei.downloadprovider.download.util.a.a(fVar.f.mVipAcceleratedSpeed));
                            bnVar = bnVar.toString();
                            stringBuilder = new StringBuilder("试用");
                            stringBuilder.append(ConvertUtil.byteConvert(com.xunlei.downloadprovider.download.util.k.j(fVar.f)));
                            fVar.a(bnVar, stringBuilder.toString());
                            return;
                        }
                    }
                    bnVar = true;
                    if (bnVar == null) {
                        if (fVar.d.b(8) == null) {
                            fVar.d.a(8);
                            bnVar = fVar.a;
                            if (bnVar.getVisibility() != 0) {
                                bnVar.setVisibility(0);
                            }
                            bnVar = bnVar.a;
                            if (bnVar.h != null) {
                                bnVar.h.g(bnVar);
                            }
                            bnVar.b = BubbleBarView.a;
                            bnVar.requestLayout();
                            if (bnVar.h != null) {
                                bnVar.h.h(bnVar);
                            }
                            bnVar = fVar.a;
                            bubbleBarView2 = bnVar.a;
                            if (bnVar != null) {
                                if (bnVar.getVisibility() != 0) {
                                    bnVar.setVisibility(0);
                                }
                                bnVar.startAnimation(bubbleBarView2.e);
                            }
                        }
                        fVar.a.setVisibility(0);
                    } else {
                        if (fVar.d.b(8) != null) {
                            if (fVar.d.b(16) != null) {
                                fVar.d.a(4);
                                fVar.d.a(16);
                                if (fVar.a.a.g != null) {
                                    bnVar = fVar.a;
                                    bubbleBarView = bnVar.a;
                                    bubbleBarView.c.end();
                                    bubbleBarView.d.end();
                                    bubbleBarView.clearAnimation();
                                    bubbleBarView.g = false;
                                    bnVar.clearAnimation();
                                    fVar.a.a();
                                } else if (fVar.a.c() == null) {
                                    fVar.e.c();
                                } else {
                                    fVar.a.a();
                                }
                                bnVar = HubbleEventBuilder.build("android_player", "bxbb_xfc_tryendkt_show");
                                bnVar.add("is_login", d.a());
                                ThunderReport.reportEvent(bnVar);
                            }
                        }
                        if (fVar.d.b(4) == null) {
                            fVar.c();
                        }
                    }
                    if (fVar.d.b(16) == null) {
                        bnVar = fVar.a;
                        j = com.xunlei.downloadprovider.download.util.k.j(fVar.f);
                        i = com.xunlei.downloadprovider.download.util.k.i(fVar.f);
                        if (j > 0) {
                            i2 = (int) (((j - i) * 100) / j);
                        }
                        bnVar.setProgress(i2);
                        bnVar = new StringBuilder("+");
                        bnVar.append(com.xunlei.downloadprovider.download.util.a.a(fVar.f.mVipAcceleratedSpeed));
                        bnVar = bnVar.toString();
                        stringBuilder = new StringBuilder("试用");
                        stringBuilder.append(ConvertUtil.byteConvert(com.xunlei.downloadprovider.download.util.k.j(fVar.f)));
                        fVar.a(bnVar, stringBuilder.toString());
                        return;
                    }
                    fVar.a.setProgress(100);
                    fVar.c.b();
                    fVar.a("试用已结束", "开通会员>>");
                    return;
                }
            }
            fVar.c();
        }
    }

    static /* synthetic */ void i(bn bnVar) {
        if (bnVar.d != null) {
            bnVar.d.c();
        }
    }
}
