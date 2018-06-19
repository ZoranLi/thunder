package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;
import com.xunlei.xllib.android.d;

/* compiled from: ItemMoreOptDlg */
public final class c extends XLBaseDialog {
    public a a = null;
    private View b;
    private TextView c;

    /* compiled from: ItemMoreOptDlg */
    public interface a {
        void a();

        void b();
    }

    public c(Context context) {
        super(context, R.style.bt_create_dialog);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.personal_chat_dialogs_item_more_operation_dialog);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        this.b = findViewById(R.id.container);
        this.b.setOnClickListener(new d(this));
        this.c = (TextView) findViewById(R.id.btn_delete);
        this.c.setOnClickListener(new e(this));
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new f(this));
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
