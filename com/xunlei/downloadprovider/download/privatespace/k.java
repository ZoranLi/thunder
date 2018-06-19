package com.xunlei.downloadprovider.download.privatespace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.common.commonview.dialog.XLWaitingDialog;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: OpenPrivateSpaceTipDialog */
final class k extends XLBaseDialog {
    f a;
    private s b;
    private XLWaitingDialog c;

    k(Context context, String str) {
        super(context, R.style.ThunderTheme.Dialog);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_open_private_space, null);
        setContentView(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dlg_cancel_iv);
        TextView textView = (TextView) inflate.findViewById(R.id.dlg_confirm_btn);
        setOnCancelListener(new l(this));
        imageView.setOnClickListener(new m(this));
        this.b = new s(context);
        this.b.setOnCancelListener(new n(this));
        this.b.a(new o(this));
        this.b.b(new p(this, str));
        textView.setOnClickListener(new r(this, context));
    }
}
