package com.xunlei.common.commonview.dialog;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.R;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

public class XLCheckBoxDialog extends XLBaseDialog {
    private OnBackPressedCallBack mBPCallBack = null;
    private TextView mBtnLeft = null;
    private OnClickListener mBtnLeftClickListener = null;
    private String mBtnLeftStr = null;
    private TextView mBtnRight = null;
    private OnClickListener mBtnRightClickListener = null;
    private String mBtnRightStr = null;
    private CheckBox mCheckBox = null;
    private String mCheckStr;
    private TextView mContent = null;
    private Context mCtx;
    private RelativeLayout mLayout = null;
    private String mSizeStr = null;
    private TextView mSizeText = null;
    private TextView mTitle = null;

    public interface OnBackPressedCallBack {
        void OnDlgBackPressed();
    }

    public XLCheckBoxDialog(Context context) {
        super(context, R.style.ThunderTheme_Dialog);
        this.mCtx = context;
        this.mCheckStr = context.getString(R.string.no_more_warn);
        initUI();
    }

    public XLCheckBoxDialog(Context context, String str, String str2) {
        super(context, R.style.ThunderTheme_Dialog);
        this.mCtx = context;
        this.mBtnLeftStr = str;
        this.mBtnRightStr = str2;
        initUI();
    }

    public void setTitle(String str) {
        if (str == null) {
            this.mTitle.setVisibility(4);
        } else {
            this.mTitle.setText(str);
        }
    }

    public void setContent(String str) {
        this.mContent.setText(str);
        if (str == null) {
            LinearLayout linearLayout = (LinearLayout) this.mLayout.findViewById(R.id.cb_xl_dlg_content_layout);
            linearLayout.removeView(this.mSizeText);
            linearLayout.removeView(this.mContent);
            LayoutParams layoutParams = (LayoutParams) this.mCheckBox.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.mCheckBox.setLayoutParams(layoutParams);
        }
    }

    protected TextView getmContentText() {
        return this.mContent;
    }

    protected TextView getmSizeText() {
        return this.mSizeText;
    }

    public void setCheckStr(String str) {
        this.mCheckStr = str;
        if (this.mCheckStr != null) {
            this.mCheckBox.setVisibility(0);
            this.mCheckBox.setText(this.mCheckStr);
            return;
        }
        this.mCheckBox.setVisibility(8);
    }

    public void setChecked(boolean z) {
        this.mCheckBox.setChecked(z);
    }

    public boolean getChecked() {
        return this.mCheckBox.isChecked();
    }

    public void setBtnLeftClickListener(OnClickListener onClickListener) {
        this.mBtnLeftClickListener = onClickListener;
    }

    public void setBtnRightClickListener(OnClickListener onClickListener) {
        this.mBtnRightClickListener = onClickListener;
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.mBPCallBack != null) {
            this.mBPCallBack.OnDlgBackPressed();
        }
    }

    public void setSizeTextGone() {
        this.mSizeText.setVisibility(8);
    }

    private void initUI() {
        this.mLayout = (RelativeLayout) LayoutInflater.from(this.mCtx).inflate(R.layout.xl_checkbox_dialog, null);
        this.mTitle = (TextView) this.mLayout.findViewById(R.id.cb_xl_dlg_title_txt);
        this.mContent = (TextView) this.mLayout.findViewById(R.id.cb_xl_dlg_content);
        this.mSizeText = (TextView) this.mLayout.findViewById(R.id.cb_xl_dlg_size);
        this.mCheckBox = (CheckBox) this.mLayout.findViewById(R.id.cb_xl_dlg_cb);
        if (VERSION.SDK_INT < 17) {
            this.mCheckBox.setPadding(this.mCheckBox.getPaddingLeft() + DipPixelUtil.dip2px(22.0f), this.mCheckBox.getPaddingTop(), this.mCheckBox.getPaddingRight(), this.mCheckBox.getPaddingBottom());
        }
        this.mBtnLeft = (TextView) this.mLayout.findViewById(R.id.cb_xl_dlg_left_btn);
        this.mBtnRight = (TextView) this.mLayout.findViewById(R.id.cb_xl_dlg_right_btn);
        setContentView(this.mLayout);
        if (this.mSizeStr != null) {
            this.mSizeText.setVisibility(0);
            this.mSizeText.setText(this.mSizeStr);
        }
        if (this.mCheckStr != null) {
            this.mCheckBox.setText(this.mCheckStr);
        } else {
            this.mCheckBox.setVisibility(8);
        }
        if (this.mBtnLeftStr != null) {
            this.mBtnLeft.setText(this.mBtnLeftStr);
        }
        if (this.mBtnRightStr != null) {
            this.mBtnRight.setText(this.mBtnRightStr);
        }
        this.mBtnLeft.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (XLCheckBoxDialog.this.mBtnLeftClickListener == null) {
                    XLCheckBoxDialog.this.dismiss();
                } else {
                    XLCheckBoxDialog.this.mBtnLeftClickListener.onClick(XLCheckBoxDialog.this, 0);
                }
            }
        });
        this.mBtnRight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (XLCheckBoxDialog.this.mBtnRightClickListener == null) {
                    XLCheckBoxDialog.this.dismiss();
                } else {
                    XLCheckBoxDialog.this.mBtnRightClickListener.onClick(XLCheckBoxDialog.this, 1);
                }
            }
        });
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    protected void setLeftBtnGone() {
        if (this.mBtnLeft != null) {
            this.mBtnLeft.setVisibility(8);
        }
    }

    protected void setRightBtnGone() {
        if (this.mBtnRight != null) {
            this.mBtnRight.setVisibility(8);
        }
    }
}
