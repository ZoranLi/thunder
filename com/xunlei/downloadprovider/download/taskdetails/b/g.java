package com.xunlei.downloadprovider.download.taskdetails.b;

import android.view.View;
import android.view.View.OnClickListener;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import org.android.agoo.common.AgooConstants;

/* compiled from: TaskCommentController */
final class g implements OnClickListener {
    final /* synthetic */ b a;

    g(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        view = this.a.u.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ReportActivity.a(this.a.i, -1, view.getBaseCommentInfo().getId(), this.a.l, this.a.m, DispatchConstants.OTHER);
        this.a.u.dismiss();
        String n = this.a.l;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(view.getBaseCommentInfo().getId());
        a.c(n, stringBuilder.toString(), AgooConstants.MESSAGE_REPORT);
    }
}
