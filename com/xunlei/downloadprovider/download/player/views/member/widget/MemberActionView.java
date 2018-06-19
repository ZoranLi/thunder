package com.xunlei.downloadprovider.download.player.views.member.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.n;
import com.xunlei.downloadprovider.download.player.views.member.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

public class MemberActionView extends AppCompatTextView {
    private Runnable a;

    public MemberActionView(Context context) {
        this(context, null, 0);
    }

    public MemberActionView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MemberActionView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = new f(this);
        setTextSize(11.0f);
        setGravity(17);
        setTextColor(Color.parseColor("#FF733B"));
        setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.accel_button_orange));
        setOnClickListener(new d(this));
    }

    public static int a(TaskInfo taskInfo) {
        if (a.b(taskInfo)) {
            return null;
        }
        return a.c(taskInfo) != null ? 1 : 2;
    }

    public TaskInfo getTaskInfo() {
        return (TaskInfo) getTag();
    }

    private void a() {
        postDelayed(this.a, 500);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.a);
    }

    static /* synthetic */ void a(MemberActionView memberActionView, TaskInfo taskInfo) {
        LoginHelper.a();
        if (l.c()) {
            a.d(taskInfo);
            if (a.a() == null) {
                memberActionView.a();
            }
        } else {
            n.a();
            n.b(taskInfo.getTaskId());
            LoginHelper.a().a(memberActionView.getContext(), new e(memberActionView, taskInfo), LoginFrom.BXBB_FREE_TRIAL, null);
        }
        LoginHelper.a();
        memberActionView = l.c();
        taskInfo = LoginHelper.a().l();
        String valueOf = String.valueOf(LoginHelper.a().g.c());
        StatEvent build = HubbleEventBuilder.build("android_player", "bxbb_vipspeedup_try_btn_click");
        build.add("is_login", memberActionView);
        build.add(SocializeConstants.TENCENT_UID, valueOf);
        build.add("is_vip", taskInfo);
        ThunderReport.reportEvent(build);
    }

    static /* synthetic */ void b(MemberActionView memberActionView, TaskInfo taskInfo) {
        String str = "v_an_shoulei_hytq_bxbb_btnjs";
        if (a.b(taskInfo)) {
            str = "v_an_shoulei_hytq_bxbb_trying";
        } else if (a.c(taskInfo)) {
            str = "v_an_shoulei_hytq_bxbb_tryend";
        }
        a.a(memberActionView.getContext(), taskInfo.getTaskId(), str);
        memberActionView = String.valueOf(LoginHelper.a().g.c());
        str = String.valueOf(LoginHelper.a().g.f());
        taskInfo = a(taskInfo);
        StatEvent build = HubbleEventBuilder.build("android_player", "bxbb_vipspeedup_btn_click");
        build.add("product_type", str);
        build.add("userid", memberActionView);
        build.add("vipspeedup_try", taskInfo);
        ThunderReport.reportEvent(build);
    }
}
