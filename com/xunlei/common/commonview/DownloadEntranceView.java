package com.xunlei.common.commonview;

import android.content.Context;
import android.support.annotation.AnyRes;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.R;

public class DownloadEntranceView extends FrameLayout {
    private int currentNum = 0;
    private boolean isAnimating = false;
    private EntranceStyle mEntranceStyle = EntranceStyle.STYLE_GRAY;
    private ViewHolder mViewHolder;
    private int newNum = 0;

    public enum EntranceStyle {
        STYLE_GRAY,
        STYLE_WHITE_IN_BLUE,
        STYLE_BLUE
    }

    static class ViewHolder {
        public FrameLayout mBkgLayout;
        public View mDotView;
        protected EntranceStyle mEntranceStyle;
        public ImageView mIcon;
        public TextView mNum2View;
        public ImageView mNum3length;
        public TextView mNumView;
        protected View mRootView;

        public ViewHolder(View view, EntranceStyle entranceStyle) {
            this.mEntranceStyle = entranceStyle;
            this.mRootView = view;
            this.mBkgLayout = (FrameLayout) view.findViewById(R.id.dl_bg_ly);
            this.mIcon = (ImageView) view.findViewById(R.id.dl_entrance_icon);
            this.mDotView = view.findViewById(R.id.dl_entrance_dot);
            this.mNumView = (TextView) view.findViewById(R.id.dl_entrance_num);
            this.mNumView.setVisibility(8);
            this.mNum2View = (TextView) view.findViewById(R.id.dl_entrance_2_num);
            this.mNum2View.setVisibility(8);
            this.mNum3length = (ImageView) view.findViewById(R.id.dl_entrance_num_for_3length);
            this.mNum3length.setVisibility(8);
            if (view.isInEditMode() == null) {
                this.mNumView.setText("");
                this.mNum2View.setText("");
            }
        }

        public void showUnread() {
            this.mDotView.setVisibility(0);
            this.mNumView.setVisibility(4);
            this.mNum3length.setVisibility(4);
            this.mNum2View.setVisibility(4);
        }

        public void clearUnread() {
            this.mDotView.setVisibility(4);
        }

        public void showNothing() {
            this.mNumView.setVisibility(4);
            this.mNum2View.setVisibility(4);
            this.mNum3length.setVisibility(4);
            this.mDotView.setVisibility(4);
        }

        public boolean isUnreadShow() {
            return this.mDotView.getVisibility() == 0;
        }

        public void setNumText(int i) {
            if (i > 0) {
                i = String.valueOf(i);
                int length = i.length();
                if (length == 1) {
                    this.mNumView.setVisibility(0);
                    this.mNumView.setText(i);
                    this.mNum2View.setVisibility(8);
                    this.mNum3length.setVisibility(8);
                } else if (length == 2) {
                    this.mNumView.setVisibility(8);
                    this.mNum2View.setVisibility(0);
                    this.mNum2View.setText(i);
                    this.mNum3length.setVisibility(8);
                } else {
                    if (length >= 3) {
                        this.mNumView.setVisibility(8);
                        this.mNum2View.setVisibility(8);
                        this.mNum3length.setVisibility(0);
                    }
                }
            }
        }
    }

    public DownloadEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i);
    }

    public DownloadEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public DownloadEntranceView(Context context) {
        super(context);
        init(null, 0);
    }

    public EntranceStyle getEntranceStyle() {
        return this.mEntranceStyle;
    }

    public void setEntranceStyle(EntranceStyle entranceStyle) {
        if (entranceStyle == null) {
            entranceStyle = EntranceStyle.STYLE_GRAY;
        }
        this.mEntranceStyle = entranceStyle;
    }

    private void init(AttributeSet attributeSet, int i) {
        attributeSet = getContext().obtainStyledAttributes(attributeSet, R.styleable.DownloadEntranceView, i, 0);
        if (attributeSet.hasValue(R.styleable.DownloadEntranceView_entranceStyle) != 0) {
            i = attributeSet.getInteger(R.styleable.DownloadEntranceView_entranceStyle, 0);
            if (i > 0) {
                this.mEntranceStyle = EntranceStyle.values()[i];
            }
        }
        attributeSet.recycle();
        initUI(getContext());
    }

    private void initUI(Context context) {
        if (this.mEntranceStyle == EntranceStyle.STYLE_WHITE_IN_BLUE) {
            context = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.download_entrance_white_in_blue, this);
        } else if (this.mEntranceStyle == EntranceStyle.STYLE_BLUE) {
            context = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.download_entrance_blue, this);
        } else {
            context = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.download_entrance_gray, this);
        }
        this.mViewHolder = new ViewHolder(context, this.mEntranceStyle);
    }

    public boolean isUnreadShow() {
        return this.mViewHolder != null && this.mViewHolder.isUnreadShow();
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
                DownloadEntranceView.this.isAnimating = false;
            }
        });
        final Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.download_entrance_diminish_enlarge);
        loadAnimation2.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                DownloadEntranceView.this.mViewHolder.mNumView.startAnimation(loadAnimation);
            }
        });
        loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.download_entrance_diminish_little);
        loadAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                DownloadEntranceView.this.mViewHolder.mNumView.startAnimation(loadAnimation2);
            }
        });
        loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.download_entrance_enlarge);
        loadAnimation2.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                DownloadEntranceView.this.setNumText(DownloadEntranceView.this.newNum);
                DownloadEntranceView.this.mViewHolder.mNumView.startAnimation(loadAnimation);
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

    public void showUnread() {
        if (this.mViewHolder != null) {
            this.mViewHolder.showUnread();
        }
    }

    public void clearUnread() {
        if (this.mViewHolder != null) {
            this.mViewHolder.clearUnread();
        }
    }

    public void showNothing() {
        if (this.mViewHolder != null) {
            this.mViewHolder.showNothing();
        }
    }

    public void setEntranceIconResource(@DrawableRes int i) {
        this.mViewHolder.mIcon.setImageResource(i);
    }

    public void setEntranceNumberBackground(@AnyRes int i) {
        if (this.mEntranceStyle != EntranceStyle.STYLE_WHITE_IN_BLUE) {
            this.mViewHolder.mNumView.setBackgroundResource(i);
        }
    }
}
