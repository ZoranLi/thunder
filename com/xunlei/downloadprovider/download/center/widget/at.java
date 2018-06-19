package com.xunlei.downloadprovider.download.center.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;

/* compiled from: TaskQrDialog */
public final class at extends Dialog {
    public ImageView a;
    public TextView b;
    public ImageView c;
    private View d;
    private ImageView e;

    public at(Context context) {
        super(context, R.style.ThunderTheme.Dialog);
        this.a = null;
        this.d = null;
        this.d = getLayoutInflater().inflate(R.layout.task_detail_qrcode_dlg, null);
        this.a = (ImageView) this.d.findViewById(R.id.task_detail_qrcode_img);
        this.b = (TextView) this.d.findViewById(R.id.qr_task_name);
        this.c = (ImageView) this.d.findViewById(R.id.qr_top_task_icon);
        this.e = (ImageView) this.d.findViewById(R.id.qr_close_btn);
        this.e.setOnClickListener(new au(this));
        setCancelable(true);
        setCanceledOnTouchOutside(null);
        setContentView(this.d);
    }
}
