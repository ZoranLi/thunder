package com.xunlei.common.commonview;

import android.content.Context;

public class TwiceClickToConfirm {
    private final int mConfirmIntervalInMillis;
    private Context mContext;
    private long mLastKeyTime = 0;
    private OnConfirmListener mOnConfirmListener = null;
    private final String mTips;

    public interface OnConfirmListener {
        void onConfirm();
    }

    public TwiceClickToConfirm(Context context, int i, String str) {
        this.mContext = context.getApplicationContext();
        this.mConfirmIntervalInMillis = i;
        this.mTips = str;
    }

    public void checkConfirm() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastKeyTime > ((long) this.mConfirmIntervalInMillis)) {
            this.mLastKeyTime = currentTimeMillis;
            XLToast.showToastWithDuration(this.mContext, this.mTips, this.mConfirmIntervalInMillis);
            return;
        }
        reset();
        if (this.mOnConfirmListener != null) {
            this.mOnConfirmListener.onConfirm();
        }
    }

    public void setOnConfirmListener(OnConfirmListener onConfirmListener) {
        this.mOnConfirmListener = onConfirmListener;
    }

    public void reset() {
        this.mLastKeyTime = 0;
    }
}
