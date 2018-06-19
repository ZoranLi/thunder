package com.xunlei.common.commonview;

import android.content.Context;
import android.support.annotation.AnyRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.xunlei.common.R;

public class NumberView extends FrameLayout {
    private int currentNum = 0;
    private boolean isAnimating = false;
    private ViewHolder mViewHolder;
    private int newNum = 0;

    static class ViewHolder {
        public FrameLayout mBkgLayout;
        public View mDotView;
        public TextView mNumView;
        protected View mRootView;

        public ViewHolder(View view) {
            this.mRootView = view;
            this.mBkgLayout = (FrameLayout) view.findViewById(R.id.dl_bg_ly);
            this.mDotView = view.findViewById(R.id.dl_entrance_dot);
            this.mNumView = (TextView) view.findViewById(R.id.dl_entrance_num);
            this.mNumView.setVisibility(8);
            if (view.isInEditMode() == null) {
                this.mNumView.setText("");
            }
        }

        public void showDot() {
            this.mDotView.setVisibility(0);
        }

        public void showNothing() {
            clearNumber();
            clearDot();
        }

        public void clearDot() {
            this.mDotView.setVisibility(8);
        }

        public void clearNumber() {
            this.mNumView.setVisibility(8);
        }

        public boolean isDotShow() {
            return this.mDotView.getVisibility() == 0;
        }

        public void setNumText(int i) {
            if (i <= 0) {
                clearNumber();
                return;
            }
            i = String.valueOf(i);
            if (i.length() <= 2) {
                this.mNumView.setVisibility(0);
                this.mNumView.setText(i);
                return;
            }
            this.mNumView.setVisibility(0);
            this.mNumView.setText("...");
        }

        public boolean isNumberShowing() {
            return this.mNumView.getVisibility() == 0;
        }
    }

    public NumberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    public NumberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public NumberView(Context context) {
        super(context);
        init(null, 0);
    }

    private void init(AttributeSet attributeSet, int i) {
        initUI(getContext());
    }

    private void initUI(Context context) {
        this.mViewHolder = new ViewHolder((ViewGroup) LayoutInflater.from(context).inflate(R.layout.number_view, this));
    }

    public boolean isDotShow() {
        return this.mViewHolder != null && this.mViewHolder.isDotShow();
    }

    private void startNumAnimation() {
        this.isAnimating = true;
        final Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.download_entrance_diminish_to_normal);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                NumberView.this.isAnimating = false;
            }
        });
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.download_entrance_diminish_enlarge);
        loadAnimation2.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                NumberView.this.mViewHolder.mNumView.startAnimation(loadAnimation);
            }
        });
        loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.download_entrance_diminish_little);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                NumberView.this.mViewHolder.mNumView.startAnimation(loadAnimation2);
            }
        });
        loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.download_entrance_enlarge);
        loadAnimation2.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                NumberView.this.setNumText(NumberView.this.newNum);
                NumberView.this.mViewHolder.mNumView.startAnimation(loadAnimation);
            }
        });
        this.mViewHolder.mNumView.startAnimation(loadAnimation2);
    }

    public void cancelNewTaskAnimation() {
        this.mViewHolder.mNumView.clearAnimation();
        this.isAnimating = false;
    }

    public boolean isAnimating() {
        return this.isAnimating;
    }

    public void setNumTextAnimate(int i) {
        if (i > 0) {
            if (this.currentNum <= 0) {
                setNumText(i);
                this.currentNum = i;
                return;
            }
            this.newNum = i;
            if ((this.newNum > this.currentNum ? 1 : null) != null) {
                startNumAnimation();
            } else {
                setNumText(i);
            }
        }
    }

    public void setNumText(int i) {
        this.mViewHolder.setNumText(i);
    }

    public void showDot() {
        if (this.mViewHolder != null) {
            this.mViewHolder.showDot();
        }
    }

    public void clearDot() {
        if (this.mViewHolder != null) {
            this.mViewHolder.clearDot();
        }
    }

    public void showNothing() {
        if (this.mViewHolder != null) {
            this.mViewHolder.showNothing();
        }
    }

    public boolean isNumberShowing() {
        return this.mViewHolder != null ? this.mViewHolder.isNumberShowing() : false;
    }

    public void setNumberBackground(@AnyRes int i) {
        if (this.mViewHolder != null) {
            this.mViewHolder.mNumView.setBackgroundResource(i);
        }
    }
}
