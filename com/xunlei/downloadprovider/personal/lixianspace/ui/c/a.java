package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.content.Context;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import com.xunlei.xllib.android.d;

/* compiled from: LXSpaceCreateTaskDlg */
public final class a extends XLBaseDialog {
    private OnClickListener a;

    public a(Context context) {
        this(context, (byte) 0);
    }

    private a(Context context, byte b) {
        super(context, (byte) 40);
        this.a = new b(this);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lx_space_create_task_dlg);
        findViewById(R.id.lx_space_create_url_task_btn).setOnClickListener(this.a);
        findViewById(R.id.lx_space_create_bt_task_btn).setOnClickListener(this.a);
        findViewById(R.id.lx_space_create_task_cancel_btn).setOnClickListener(this.a);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        bundle = getWindow();
        LayoutParams attributes = bundle.getAttributes();
        attributes.gravity = 81;
        attributes.width = d.a(getContext().getApplicationContext());
        attributes.height = -2;
        attributes.flags &= -1025;
        attributes.flags |= 2048;
        attributes.windowAnimations = R.style.PopupBottomInAnim;
        bundle.setAttributes(attributes);
    }
}
