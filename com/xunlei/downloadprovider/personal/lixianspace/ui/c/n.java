package com.xunlei.downloadprovider.personal.lixianspace.ui.c;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.payment.a.j;
import com.xunlei.downloadprovider.member.payment.external.PayAction;
import com.xunlei.downloadprovider.member.payment.external.PayUtil$OrderType;
import com.xunlei.downloadprovider.member.payment.i;
import com.xunlei.downloadprovider.personal.lixianspace.a;
import com.xunlei.thunder.commonui.dialog.XLBaseDialog;

/* compiled from: LXSpaceUpgradeTaskCountDlg */
public final class n extends XLBaseDialog {
    private PayAction a;

    public n(Context context) {
        this(context, (byte) 0);
    }

    private n(Context context, byte b) {
        super(context, (byte) -66);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.lx_space_upgrade_dlg);
        Button button = (Button) findViewById(R.id.lx_space_open_vip_btn);
        button.setOnClickListener(new o(this));
        findViewById(R.id.lx_space_close_iv).setOnClickListener(new p(this));
        ImageView imageView = (ImageView) findViewById(R.id.lx_space_tip_iv);
        TextView textView = (TextView) findViewById(R.id.lx_space_open_vip_tip_tv);
        int d = j.a().d();
        boolean b = i.b(d);
        int i = R.string.lx_space_task_count_open_tip;
        if (b) {
            if (!j.a().e()) {
                Context context = getContext();
                Object[] objArr = new Object[2];
                objArr[0] = getContext().getString(R.string.lx_space_super_year_vip);
                objArr[1] = getContext().getString(R.string.lx_space_count_format, new Object[]{Integer.valueOf(240)});
                textView.setText(Html.fromHtml(context.getString(R.string.lx_space_task_count_open_tip, objArr)));
                imageView.setBackgroundResource(R.drawable.lx_space_task_count_up_limit);
                button.setText(getContext().getString(R.string.lx_space_open_vip_format, new Object[]{getContext().getString(R.string.lx_space_year_vip)}));
            }
            PayAction payAction = new PayAction(PayUtil$OrderType.OPEN);
            payAction.c = 12;
            r0.a = payAction;
        } else {
            int c = a.c();
            boolean a = i.a(d);
            Context context2 = getContext();
            if (a) {
                i = R.string.lx_space_task_count_upgrade_tip;
            }
            Object[] objArr2 = new Object[2];
            objArr2[0] = getContext().getString(R.string.lx_space_super_vip);
            objArr2[1] = getContext().getString(R.string.lx_space_count_format, new Object[]{Integer.valueOf(c)});
            textView.setText(Html.fromHtml(context2.getString(i, objArr2)));
            imageView.setBackgroundResource(R.drawable.lx_space_task_count_up_limit);
            button.setText(getContext().getString(a ? R.string.lx_space_upgrade_vip_format : R.string.lx_space_open_vip_format, new Object[]{getContext().getString(R.string.lx_space_super_vip)}));
            if (a) {
                r0.a = new PayAction(PayUtil$OrderType.UPGRADE);
            }
        }
        setCancelable(true);
        setCanceledOnTouchOutside(true);
    }
}
