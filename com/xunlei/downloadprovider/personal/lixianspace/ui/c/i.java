package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.xunlei.downloadprovider.personal.lixianspace.bean.LXTaskInfo;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: LXSpaceTaskDeleteDlg */
public final class i extends XLBaseDialog {
    public TextView a;
    public LXTaskInfo b;
    public a c;
    private OnClickListener d;

    /* compiled from: LXSpaceTaskDeleteDlg */
    public interface a {
        void a(LXTaskInfo lXTaskInfo);
    }

    public i(Context context) {
        this(context, (byte) 0);
    }

    private i(Context context, byte b) {
        super(context, (byte) -74);
        this.d = new j(this);
        context = LayoutInflater.from(context).inflate((byte) -19, null);
        this.a = (TextView) context.findViewById((byte) 121);
        context.findViewById((byte) 122).setOnClickListener(this.d);
        context.findViewById((byte) 123).setOnClickListener(this.d);
        setContentView(context);
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }
}
