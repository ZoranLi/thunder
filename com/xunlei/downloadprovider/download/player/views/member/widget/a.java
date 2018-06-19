package com.xunlei.downloadprovider.download.player.views.member.widget;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: MemberActionLoadingView */
final class a implements OnClickListener {
    final /* synthetic */ MemberActionLoadingView a;

    a(MemberActionLoadingView memberActionLoadingView) {
        this.a = memberActionLoadingView;
    }

    public final void onClick(View view) {
        view = this.a.getTaskInfo();
        if (MemberActionLoadingView.b(this.a)) {
            MemberActionLoadingView.a(this.a, view);
            return;
        }
        MemberActionLoadingView memberActionLoadingView = this.a;
        LoginHelper.a();
        if (l.c()) {
            com.xunlei.downloadprovider.download.player.views.member.a.d(view);
            if (com.xunlei.downloadprovider.download.player.views.member.a.a() == null) {
                memberActionLoadingView.a();
            }
        } else {
            n.a();
            n.b(view.getTaskId());
            LoginHelper.a().a(memberActionLoadingView.getContext(), new b(memberActionLoadingView, view), LoginFrom.BXBB_FREE_TRIAL, null);
        }
        if (TextUtils.equals(memberActionLoadingView.getText().toString(), "免费试用会员加速，体验高速看片>") != null) {
            LoginHelper.a();
            view = l.c();
            boolean l = LoginHelper.a().l();
            String valueOf = String.valueOf(LoginHelper.a().g.c());
            StatEvent build = HubbleEventBuilder.build("android_player", "bxbb_buffer_vipspeedup_try_qp_click");
            build.add("is_login", view);
            build.add(SocializeConstants.TENCENT_UID, valueOf);
            build.add("is_vip", l);
            ThunderReport.reportEvent(build);
            return;
        }
        if (TextUtils.equals(memberActionLoadingView.getText().toString(), "免费试用会员加速，立即告别卡顿>") != null) {
            LoginHelper.a();
            view = l.c();
            l = LoginHelper.a().l();
            valueOf = String.valueOf(LoginHelper.a().g.c());
            build = HubbleEventBuilder.build("android_player", "bxbb_kadun_vipspeedup_try_click");
            build.add("is_login", view);
            build.add(SocializeConstants.TENCENT_UID, valueOf);
            build.add("is_vip", l);
            ThunderReport.reportEvent(build);
        }
    }
}
