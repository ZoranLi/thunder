package com.xunlei.common.commonview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

public class AnimationDot extends TextView {
    private static final int MAX_DOT_NUM = 3;
    private static final int MIN_DOT_NUM = 1;
    private static final int MSG_DOT_ANI = 506428;
    private static final int PERIOD_DOT_ANI = 250;
    private int dotNum;
    private String mFrontText = "";
    private Handler mHandler;

    private static class DotHandler extends Handler {
        private WeakReference<AnimationDot> mParent;

        public DotHandler(AnimationDot animationDot) {
            this.mParent = new WeakReference(animationDot);
        }

        public void handleMessage(Message message) {
            AnimationDot animationDot = (AnimationDot) this.mParent.get();
            if (animationDot != null) {
                if (message.what == 506428) {
                    message = animationDot.mFrontText;
                    AnimationDot.access$104(animationDot);
                    int i = 1;
                    if (animationDot.dotNum > 3) {
                        animationDot.dotNum = 1;
                    } else if (animationDot.dotNum <= 0) {
                        animationDot.dotNum = 3;
                    }
                    while (i <= animationDot.dotNum) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(message);
                        stringBuilder.append(".");
                        message = stringBuilder.toString();
                        i++;
                    }
                    animationDot.setText(message);
                    sendEmptyMessageDelayed(AnimationDot.MSG_DOT_ANI, 250);
                }
            }
        }
    }

    static /* synthetic */ int access$104(AnimationDot animationDot) {
        int i = animationDot.dotNum + 1;
        animationDot.dotNum = i;
        return i;
    }

    public AnimationDot(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAni();
    }

    public AnimationDot(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initAni();
    }

    public AnimationDot(Context context) {
        super(context);
        initAni();
    }

    private void initAni() {
        this.dotNum = 0;
        if (this.mHandler == null) {
            this.mHandler = new DotHandler(this);
        }
    }

    public void setFrontText(String str) {
        if (str != null) {
            this.mFrontText = str;
        }
    }

    public void show() {
        setVisibility(0);
        this.mHandler.removeMessages(MSG_DOT_ANI);
        this.mHandler.sendEmptyMessage(MSG_DOT_ANI);
    }

    public void hideDot() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MSG_DOT_ANI);
        }
        setText(this.mFrontText);
    }

    public void hide() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MSG_DOT_ANI);
        }
        setVisibility(8);
    }
}
