package com.xunlei.downloadprovider.personal.lixianspace.ui.b;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.downloadprovider.personal.lixianspace.ui.b.a.a;

/* compiled from: LXSpaceTaskAdapter */
final class b implements AnimatorUpdateListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        valueAnimator = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        TextView a = this.a.i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(valueAnimator);
        stringBuilder.append("%");
        a.setText(stringBuilder.toString());
        this.a.j.setProgress(valueAnimator);
        if (100 == valueAnimator) {
            valueAnimator = ((Integer) this.a.i.getTag()).intValue();
            LXTaskInfo lXTaskInfo = (LXTaskInfo) ((a) this.a.c).c(valueAnimator);
            if (lXTaskInfo != null && lXTaskInfo.j) {
                lXTaskInfo.j = false;
                this.a.c.notifyItemChanged(valueAnimator);
            }
        }
    }
}
