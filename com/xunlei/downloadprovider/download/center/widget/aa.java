package com.xunlei.downloadprovider.download.center.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;

/* compiled from: DownloadStorageExchangeDialogPPW */
public class aa extends SafePopupWindow {
    private static final String a = "aa";
    private Context b;
    private TextView c = null;
    private String d = null;

    public aa(Context context) {
        super(context);
        this.b = context;
        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.b).inflate(R.layout.ppw_download_storage_exchange_dialog, null);
        this.c = (TextView) relativeLayout.findViewById(R.id.tv_content);
        setTouchable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(DipPixelUtil.dip2px(100.0f));
        setHeight(DipPixelUtil.dip2px(34.0f));
        setContentView(relativeLayout);
        relativeLayout.setOnClickListener(new ab(this));
    }

    public void dismiss() {
        super.dismiss();
    }
}
