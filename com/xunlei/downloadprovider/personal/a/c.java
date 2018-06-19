package com.xunlei.downloadprovider.personal.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: RenewalDialog */
public final class c extends XLBaseDialog {
    public TextView a;
    public TextView b;
    public TextView c;
    public RelativeLayout d;
    private Context e;
    private ImageView f;
    private OnClickListener g = null;

    public c(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        this.e = context;
        context = LayoutInflater.from(this.e).inflate(R.layout.dialog_usercenter_renewal, null);
        this.a = (TextView) context.findViewById(R.id.dlg_content);
        this.f = (ImageView) context.findViewById(R.id.dlg_cancel_iv);
        this.c = (TextView) context.findViewById(R.id.dlg_title);
        this.b = (TextView) context.findViewById(R.id.dlg_bottom_btn);
        this.d = (RelativeLayout) context.findViewById(R.id.dlg_bg_top);
        this.b.setVisibility(0);
        if (this.g == null) {
            a(new d(this));
        }
        this.f.setOnClickListener(new e(this));
        setContentView(context);
    }

    public final void a(OnClickListener onClickListener) {
        this.g = onClickListener;
        this.b.setTag(onClickListener);
        this.b.setOnClickListener(new f(this));
    }
}
