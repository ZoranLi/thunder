package com.alibaba.baichuan.android.trade.c.b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.utils.l;
import org.android.agoo.common.AgooConstants;

final class e implements OnTouchListener {
    final /* synthetic */ d a;

    e(d dVar) {
        this.a = dVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.a.setTag(l.a(AlibcContext.a, AgooConstants.MESSAGE_ID, "com_taobao_nb_sdk_webview_click"), Boolean.valueOf(true));
        return false;
    }
}
