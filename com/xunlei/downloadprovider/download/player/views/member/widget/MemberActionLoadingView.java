package com.xunlei.downloadprovider.download.player.views.member.widget;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.player.views.member.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import java.util.HashSet;

public class MemberActionLoadingView extends AppCompatTextView {
    public HashSet<String> a;
    public int b;
    public int c;
    public int d;
    private Runnable e;

    public MemberActionLoadingView(Context context) {
        this(context, null, 0);
    }

    public MemberActionLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MemberActionLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new c(this);
        this.a = new HashSet(5);
        this.b = 0;
        this.c = 0;
        this.d = 0;
        setTextSize(12.0f);
        setTextColor(Color.parseColor("#1294f6"));
        setOnClickListener(new a(this));
    }

    private TaskInfo getTaskInfo() {
        return (TaskInfo) getTag();
    }

    final void a() {
        postDelayed(this.e, 500);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.e);
    }

    static /* synthetic */ boolean b(MemberActionLoadingView memberActionLoadingView) {
        memberActionLoadingView = memberActionLoadingView.getText().toString().trim();
        if (!(TextUtils.equals("会员尊享视频加速特权，告别卡顿畅快观影>", memberActionLoadingView) || TextUtils.equals("开启会员加速，播放更顺畅>", memberActionLoadingView))) {
            if (TextUtils.equals("开启会员加速，享受高速看片>", memberActionLoadingView) == null) {
                return null;
            }
        }
        return true;
    }

    static /* synthetic */ void a(MemberActionLoadingView memberActionLoadingView, TaskInfo taskInfo) {
        String str = "v_an_shoulei_hytq_bxbb_buffer";
        String valueOf;
        String valueOf2;
        if (TextUtils.equals(memberActionLoadingView.getText().toString(), "开启会员加速，播放更顺畅>")) {
            valueOf = String.valueOf(LoginHelper.a().g.c());
            valueOf2 = String.valueOf(LoginHelper.a().g.f());
            StatEvent build = HubbleEventBuilder.build("android_player", "bxbb_buffer_qp_click");
            build.add("product_type", valueOf2);
            build.add("userid", valueOf);
            ThunderReport.reportEvent(build);
        } else {
            int i = 0;
            valueOf = "v_an_shoulei_hytq_bxbb_kadun";
            if (a.c(taskInfo)) {
                i = 1;
                valueOf = "v_an_shoulei_hytq_bxbb_trykd";
            }
            valueOf2 = String.valueOf(LoginHelper.a().g.c());
            String valueOf3 = String.valueOf(LoginHelper.a().g.f());
            StatEvent build2 = HubbleEventBuilder.build("android_player", "bxbb_kadun_click");
            build2.add("product_type", valueOf3);
            build2.add("userid", valueOf2);
            build2.add("vipspeedup_try", i);
            ThunderReport.reportEvent(build2);
            str = valueOf;
        }
        a.a(memberActionLoadingView.getContext(), taskInfo.getTaskId(), str);
    }
}
