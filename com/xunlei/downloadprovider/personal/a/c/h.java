package com.xunlei.downloadprovider.personal.a.c;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.UserCenterFragment;
import com.xunlei.downloadprovider.personal.a.b.a.a;
import com.xunlei.downloadprovider.personal.a.b.g;
import java.util.ArrayList;

/* compiled from: UserDynamicGridViewHolder */
public final class h extends a {
    private FragmentActivity a;
    private UserCenterFragment b;
    private RecyclerView c;

    public h(View view, FragmentActivity fragmentActivity, UserCenterFragment userCenterFragment) {
        super(view);
        this.b = userCenterFragment;
        this.a = fragmentActivity;
        this.c = (RecyclerView) view.findViewById(R.id.rv_grid_view);
    }

    public final void a(Object obj) {
        this.c.setLayoutManager(new GridLayoutManager(this.a, 3));
        this.c.addItemDecoration(new g());
        Adapter aVar = new a(this.a, this.b);
        this.c.setAdapter(aVar);
        if (obj != null && (obj instanceof ArrayList)) {
            aVar.a = (ArrayList) obj;
        }
    }
}
