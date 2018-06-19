package com.xunlei.common.commonview.dialog;

import android.content.Context;
import android.os.Bundle;
import com.xunlei.common.R;
import com.xunlei.common.commonview.SimpleLoadingPageView;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

public class XLWaitingDialog extends XLBaseDialog {
    public static final String TAG = "XLWaitingDialog";
    private SimpleLoadingPageView content;

    public XLWaitingDialog(Context context) {
        super(context, R.style.ThunderTheme_UnifiedLoadingDialog);
        this.content = new SimpleLoadingPageView(context, SimpleLoadingPageView.TYPE_GLOBAL);
        setContentView(this.content);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(131072, 131072);
    }

    public void show() {
        super.show();
        this.content.show();
    }

    public void setProHintStr(String str) {
        this.content.setTip(str);
    }
}
