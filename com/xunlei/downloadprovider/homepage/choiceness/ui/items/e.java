package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.launch.b.a;

/* compiled from: ChoicenessLiveGroupItemView */
final class e implements OnClickListener {
    final /* synthetic */ a a;

    e(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        a.a().getRouteDispatcher().livePage();
    }
}
