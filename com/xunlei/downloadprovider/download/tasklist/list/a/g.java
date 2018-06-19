package com.xunlei.downloadprovider.download.tasklist.list.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;

/* compiled from: TaskExpandHolder */
public final class g extends f {
    public int a;
    private TextView b;

    public static g a(Context context, ViewGroup viewGroup) {
        return new g(LayoutInflater.from(context).inflate(R.layout.layout_download_center_expand, viewGroup, false));
    }

    private g(View view) {
        super(view);
        this.b = (TextView) view.findViewById(R.id.expand);
    }

    public final void fillData(e eVar) {
        super.fillData(eVar);
        new StringBuilder("expandHeight: ").append(this.a);
        if (this.a < null) {
            this.a = DipPixelUtil.dip2px(7.0f);
        } else {
            this.a += 42;
        }
        this.b.setPadding(0, this.a, 0, 0);
    }
}
