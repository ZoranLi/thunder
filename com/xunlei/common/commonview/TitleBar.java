package com.xunlei.common.commonview;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.xunlei.common.R;
import com.xunlei.common.androidutil.AndroidConfig;

public class TitleBar {
    public static final int ID_FLOWER = R.id.titlebar_flower;
    public static final int ID_LEFT = R.id.titlebar_left;
    public static final int ID_RIGHT = R.id.titlebar_right;
    public static final int ID_RIGHT1 = R.id.titlebar_right_1;
    public static final int ID_TITLE = R.id.titlebar_title;
    protected View mBottomDivider;
    protected View mBottomDivider2;
    public DownloadEntranceView mDownloadEntranceView;
    public ProgressBar mFlower;
    public TextView mHelp;
    public ViewGroup mLayout;
    public ImageView mLeft;
    public TextView mLeftTv;
    public TextView mRight;
    public TextView mRight1;
    public ImageView mRight1Iv;
    public View mRightArea;
    public ImageView mRightIv;
    public TextView mTitle;

    public TitleBar(final Activity activity) {
        this.mLayout = (ViewGroup) activity.findViewById(R.id.common_title_bar);
        this.mLeft = (ImageView) activity.findViewById(R.id.titlebar_left);
        this.mLeftTv = (TextView) activity.findViewById(R.id.titlebar_left_tv);
        this.mTitle = (TextView) activity.findViewById(R.id.titlebar_title);
        this.mRight = (TextView) activity.findViewById(R.id.titlebar_right);
        this.mRight1 = (TextView) activity.findViewById(R.id.titlebar_right_1);
        this.mFlower = (ProgressBar) activity.findViewById(R.id.titlebar_flower);
        this.mRightArea = activity.findViewById(R.id.titlebar_right_container);
        this.mRightIv = (ImageView) activity.findViewById(R.id.titlebar_right_iv);
        this.mRight1Iv = (ImageView) activity.findViewById(R.id.titlebar_right_1_iv);
        this.mDownloadEntranceView = (DownloadEntranceView) activity.findViewById(R.id.titlebar_download_entrance);
        this.mBottomDivider = activity.findViewById(R.id.white_button_line);
        this.mBottomDivider2 = activity.findViewById(R.id.xreader_common_divide);
        this.mLeft.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                try {
                    activity.onBackPressed();
                } catch (View view2) {
                    view2.printStackTrace();
                }
            }
        });
        setTitleMaxWidth();
    }

    public TitleBar(View view) {
        this.mLayout = (ViewGroup) view.findViewById(R.id.common_title_bar);
        this.mLeft = (ImageView) view.findViewById(R.id.titlebar_left);
        this.mLeftTv = (TextView) view.findViewById(R.id.titlebar_left_tv);
        this.mTitle = (TextView) view.findViewById(R.id.titlebar_title);
        this.mRightArea = view.findViewById(R.id.titlebar_right_container);
        this.mRight = (TextView) view.findViewById(R.id.titlebar_right);
        this.mRight1 = (TextView) view.findViewById(R.id.titlebar_right_1);
        this.mFlower = (ProgressBar) view.findViewById(R.id.titlebar_flower);
        this.mRightIv = (ImageView) view.findViewById(R.id.titlebar_right_iv);
        this.mRight1Iv = (ImageView) view.findViewById(R.id.titlebar_right_1_iv);
        this.mDownloadEntranceView = (DownloadEntranceView) view.findViewById(R.id.titlebar_download_entrance);
        this.mBottomDivider = view.findViewById(R.id.white_button_line);
        this.mBottomDivider2 = view.findViewById(R.id.xreader_common_divide);
        setTitleMaxWidth();
    }

    public void setTitleBarBottomDividerVisibility(int i) {
        if (this.mBottomDivider != null) {
            this.mBottomDivider.setVisibility(i);
        }
        if (this.mBottomDivider2 != null) {
            this.mBottomDivider2.setVisibility(i);
        }
    }

    private void setTitleMaxWidth() {
        this.mTitle.setMaxWidth((AndroidConfig.getScreenWidth() * 2) / 3);
    }
}
