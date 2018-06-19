package com.xunlei.downloadprovider.download.giftdispatch;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.xunlei.downloadprovider.download.giftdispatch.utils.GiftDispatchingReporter;
import com.xunlei.downloadprovider.download.giftdispatch.utils.GiftDispatchingReporter.ClickIdType;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;

/* compiled from: GiftDispatchingActivity */
final class f implements OnClickListener {
    final /* synthetic */ GiftDispatchingActivity a;

    f(GiftDispatchingActivity giftDispatchingActivity) {
        this.a = giftDispatchingActivity;
    }

    public final void onClick(View view) {
        Context context = this.a;
        context.g = true;
        ViewGroup viewGroup = (ViewGroup) context.getWindow().getDecorView();
        View linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setId(-1);
        linearLayout.setBackgroundResource(17170445);
        viewGroup.addView(linearLayout);
        context.e = linearLayout;
        context.e.addView(context.d);
        int[] iArr = new int[2];
        context.c.getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        GiftDispatchingActivity.a(context.d, i, i2);
        Animator duration = ObjectAnimator.ofFloat(context.d, "translationY", new float[]{0.0f, -50.0f}).setDuration(200);
        Animator duration2 = ObjectAnimator.ofFloat(context.d, "scaleX", new float[]{1.0f, 2.0f}).setDuration(200);
        Animator duration3 = ObjectAnimator.ofFloat(context.d, "scaleY", new float[]{1.0f, 2.0f}).setDuration(200);
        duration.addListener(new i(context, i, i2));
        int[] iArr2 = new int[2];
        context.f.getLocationInWindow(iArr2);
        context.f.setVisibility(4);
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        Animator duration4 = ObjectAnimator.ofFloat(context.d, "translationX", new float[]{0.0f, (float) (i3 - i)}).setDuration(500);
        duration4.setInterpolator(new LinearInterpolator());
        Animator duration5 = ObjectAnimator.ofFloat(context.d, "translationY", new float[]{0.0f, (float) ((i4 - i2) + 50)}).setDuration(500);
        duration5.setInterpolator(new AccelerateInterpolator());
        Animator duration6 = ObjectAnimator.ofFloat(context.d, "scaleX", new float[]{2.0f, PayBaseConstants.HALF_OF_FLOAT}).setDuration(500);
        Animator duration7 = ObjectAnimator.ofFloat(context.d, "scaleY", new float[]{2.0f, PayBaseConstants.HALF_OF_FLOAT}).setDuration(500);
        duration7.addListener(new j(context));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(duration).with(duration2).with(duration3);
        animatorSet.play(duration4).with(duration5).with(duration6).with(duration7).after(duration);
        animatorSet.start();
        GiftDispatchingReporter.a(-1, -1, ClickIdType.CLOSE);
    }
}
