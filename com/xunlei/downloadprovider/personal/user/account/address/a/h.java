package com.xunlei.downloadprovider.personal.user.account.address.a;

import android.view.View;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.user.account.address.c.a;

/* compiled from: UserRegionRecyclerHolder */
public final class h extends d {
    private TextView a;

    public h(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R.id.tv_region_name);
    }

    public final void a(a aVar) {
        aVar = aVar.a;
        if (aVar.substring(aVar.length() - 1, aVar.length()).equals("市")) {
            aVar = aVar.substring(0, aVar.length() - 1);
        }
        this.a.setText(aVar);
    }
}
