package com.xunlei.downloadprovider.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: XLNoTitleTipDialog */
public final class k extends i {
    public TextView a = ((TextView) this.e.findViewById(R.id.dlg_left_btn));
    public TextView b = ((TextView) this.e.findViewById(R.id.dlg_right_btn));
    public TextView c = ((TextView) this.e.findViewById(R.id.dlg_content));
    private Context d;
    private View e = LayoutInflater.from(this.d).inflate(R.layout.xl_no_title_dialog, null);

    protected final int b() {
        return 14;
    }

    public k(Context context) {
        super(context);
        this.d = context;
        setContentView(this.e);
        setCancelable(true);
        setCanceledOnTouchOutside(null);
    }

    protected final void a() {
        super.a();
    }
}
