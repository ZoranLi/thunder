package com.xunlei.common.commonview.dialog;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.xunlei.common.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

public class XLAlertDialog extends XLBaseDialog {
    protected View mButtonDivider;
    protected TextView mCancelButton;
    protected TextView mConfirmButton;
    protected TextView mContentText;
    protected View mDialogView;
    protected OnClickListener mOnClickCancelListener;
    protected OnClickListener mOnClickConfirmListener;
    protected TextView mTitleText;

    public static class ViewHolder {
        public View mButtonDivider = this.mDialogView.findViewById(R.id.dlg_btn_vertical_divider);
        public TextView mCancelButton = ((TextView) this.mDialogView.findViewById(R.id.dlg_cancel_btn));
        public TextView mConfirmButton = ((TextView) this.mDialogView.findViewById(R.id.dlg_confirm_btn));
        public TextView mContentText = ((TextView) this.mDialogView.findViewById(R.id.dlg_content));
        public View mDialogView;
        public TextView mTitleText = ((TextView) this.mDialogView.findViewById(R.id.dlg_title));

        public ViewHolder(View view) {
            this.mDialogView = view;
        }

        public void updateButtonVisibility() {
            if (this.mConfirmButton != null) {
                if (this.mCancelButton != null) {
                    int i = 0;
                    int i2 = this.mConfirmButton.getVisibility() == 0 ? 1 : 0;
                    if (this.mCancelButton.getVisibility() == 0) {
                        i2++;
                    }
                    View view = this.mButtonDivider;
                    if (this.mCancelButton.getVisibility() != 0 || this.mConfirmButton.getVisibility() != 0) {
                        i = 8;
                    }
                    view.setVisibility(i);
                    if (i2 == 1) {
                        if (this.mCancelButton.getVisibility() == 0) {
                            XLAlertDialog.setViewBackgroundDrawable(this.mCancelButton, R.drawable.bottom_button_selector);
                        }
                        if (this.mConfirmButton.getVisibility() == 0) {
                            XLAlertDialog.setViewBackgroundDrawable(this.mConfirmButton, R.drawable.bottom_button_selector);
                            return;
                        }
                    }
                    XLAlertDialog.setViewBackgroundDrawable(this.mCancelButton, R.drawable.left_button_selector);
                    XLAlertDialog.setViewBackgroundDrawable(this.mConfirmButton, R.drawable.right_button_selector);
                }
            }
        }
    }

    public XLAlertDialog(Context context, boolean z, OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.mDialogView = LayoutInflater.from(context).inflate(R.layout.xl_alert_dialog, null);
        setContentView(this.mDialogView);
        initUI(context);
    }

    public XLAlertDialog(Context context, int i) {
        super(context, i);
        this.mDialogView = LayoutInflater.from(context).inflate(R.layout.xl_alert_dialog, null);
        setContentView(this.mDialogView);
        initUI(context);
    }

    public XLAlertDialog(Context context) {
        super(context, R.style.ThunderTheme_Dialog);
        this.mDialogView = LayoutInflater.from(context).inflate(R.layout.xl_alert_dialog, null);
        setContentView(this.mDialogView);
        initUI(context);
    }

    public void setOnClickCancelButtonListener(OnClickListener onClickListener) {
        this.mOnClickCancelListener = onClickListener;
    }

    public void setOnClickConfirmButtonListener(OnClickListener onClickListener) {
        this.mOnClickConfirmListener = onClickListener;
    }

    public void setTitle(CharSequence charSequence) {
        if (this.mTitleText != null) {
            if (charSequence != null) {
                this.mTitleText.setText(charSequence);
                return;
            }
            this.mTitleText.setText(R.string.tips);
        }
    }

    public void setTitle(int i) {
        if (this.mTitleText != null) {
            if (i != 0) {
                this.mTitleText.setText(i);
                return;
            }
            this.mTitleText.setText(R.string.tips);
        }
    }

    public void setMessage(int i) {
        if (this.mContentText != null) {
            this.mContentText.setText(i);
        }
    }

    public void setMessage(CharSequence charSequence) {
        if (this.mContentText != null) {
            TextView textView = this.mContentText;
            if (charSequence == null) {
                charSequence = "";
            }
            textView.setText(charSequence);
        }
    }

    public void setCancelButtonText(int i) {
        if (this.mCancelButton != null) {
            this.mCancelButton.setText(i);
        }
    }

    public void setCancelButtonText(CharSequence charSequence) {
        if (this.mCancelButton != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.mCancelButton.setText(R.string.cancel);
            } else {
                this.mCancelButton.setText(charSequence);
            }
        }
    }

    public void setConfirmButtonText(int i) {
        if (this.mConfirmButton != null) {
            this.mConfirmButton.setText(i);
        }
    }

    public void setConfirmButtonText(CharSequence charSequence) {
        if (this.mConfirmButton != null) {
            if (TextUtils.isEmpty(charSequence)) {
                this.mConfirmButton.setText(R.string.ok);
            } else {
                this.mConfirmButton.setText(charSequence);
            }
        }
    }

    public void setConfirmButtonTextColor(@ColorInt int i) {
        this.mConfirmButton.setTextColor(i);
    }

    public void setCancelButtonHidden(boolean z) {
        if (this.mCancelButton != null) {
            int i = 0;
            if (z) {
                this.mCancelButton.setVisibility(8);
                z = this.mButtonDivider;
            } else {
                this.mCancelButton.setVisibility(0);
                z = this.mButtonDivider;
                if (this.mConfirmButton.getVisibility() == 0) {
                    z.setVisibility(i);
                    updateForButtonVisibilityChange();
                }
            }
            i = 8;
            z.setVisibility(i);
            updateForButtonVisibilityChange();
        }
    }

    public void setConfirmButtonHidden(boolean z) {
        if (this.mConfirmButton != null) {
            int i = 0;
            if (z) {
                this.mConfirmButton.setVisibility(8);
                z = this.mButtonDivider;
            } else {
                this.mConfirmButton.setVisibility(0);
                z = this.mButtonDivider;
                if (this.mCancelButton.getVisibility() == 0) {
                    z.setVisibility(i);
                    updateForButtonVisibilityChange();
                }
            }
            i = 8;
            z.setVisibility(i);
            updateForButtonVisibilityChange();
        }
    }

    private static void setViewBackgroundDrawable(View view, int i) {
        if (VERSION.SDK_INT >= 21) {
            i = view.getResources().getDrawable(i, null);
        } else {
            i = view.getResources().getDrawable(i);
        }
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(i);
        } else {
            view.setBackgroundDrawable(i);
        }
    }

    private void updateForButtonVisibilityChange() {
        if (this.mConfirmButton != null) {
            if (this.mCancelButton != null) {
                int i = 0;
                int i2 = this.mConfirmButton.getVisibility() == 0 ? 1 : 0;
                if (this.mCancelButton.getVisibility() == 0) {
                    i2++;
                }
                View view = this.mButtonDivider;
                if (this.mCancelButton.getVisibility() != 0 || this.mConfirmButton.getVisibility() != 0) {
                    i = 8;
                }
                view.setVisibility(i);
                if (i2 == 1) {
                    if (this.mCancelButton.getVisibility() == 0) {
                        setViewBackgroundDrawable(this.mCancelButton, R.drawable.bottom_button_selector);
                    }
                    if (this.mConfirmButton.getVisibility() == 0) {
                        setViewBackgroundDrawable(this.mConfirmButton, R.drawable.bottom_button_selector);
                        return;
                    }
                }
                setViewBackgroundDrawable(this.mCancelButton, R.drawable.left_button_selector);
                setViewBackgroundDrawable(this.mConfirmButton, R.drawable.right_button_selector);
            }
        }
    }

    protected void initUI(Context context) {
        this.mTitleText = (TextView) this.mDialogView.findViewById(R.id.dlg_title);
        this.mContentText = (TextView) this.mDialogView.findViewById(R.id.dlg_content);
        this.mButtonDivider = this.mDialogView.findViewById(R.id.dlg_btn_vertical_divider);
        this.mCancelButton = (TextView) this.mDialogView.findViewById(R.id.dlg_cancel_btn);
        this.mCancelButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (XLAlertDialog.this.mOnClickCancelListener != null) {
                    XLAlertDialog.this.mOnClickCancelListener.onClick(XLAlertDialog.this, -2);
                } else {
                    XLAlertDialog.this.dismiss();
                }
            }
        });
        this.mConfirmButton = (TextView) this.mDialogView.findViewById(R.id.dlg_confirm_btn);
        this.mConfirmButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (XLAlertDialog.this.mOnClickConfirmListener != null) {
                    XLAlertDialog.this.mOnClickConfirmListener.onClick(XLAlertDialog.this, -1);
                } else {
                    XLAlertDialog.this.dismiss();
                }
            }
        });
        updateForButtonVisibilityChange();
    }

    public TextView getMessageTextView() {
        return this.mContentText;
    }

    protected boolean isOutOfBounds(Context context, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        motionEvent = (int) motionEvent.getY();
        context = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        View decorView = getWindow().getDecorView();
        int i = -context;
        if (x >= i && motionEvent >= i && x <= decorView.getWidth() + context) {
            if (motionEvent <= decorView.getHeight() + context) {
                return null;
            }
        }
        return true;
    }
}
