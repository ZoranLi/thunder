package com.xunlei.downloadprovider.download.privatespace;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: NoVipUsePrivateSpaceTipDialog */
final class g extends XLBaseDialog {
    g(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        View inflate = LayoutInflater.from(context).inflate(R.layout.dialog_open_private_space, null);
        setContentView(inflate);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.dlg_cancel_iv);
        TextView textView = (TextView) inflate.findViewById(R.id.dlg_confirm_btn);
        setOnCancelListener(new h(this));
        imageView.setOnClickListener(new i(this));
        textView.setOnClickListener(new j(this, context));
    }
}
