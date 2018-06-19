package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.g;

/* compiled from: ChoicenessLiveGroupSecondItemView */
final class h implements OnClickListener {
    final /* synthetic */ g a;
    final /* synthetic */ ChoicenessLiveGroupSecondItemView b;

    h(ChoicenessLiveGroupSecondItemView choicenessLiveGroupSecondItemView, g gVar) {
        this.b = choicenessLiveGroupSecondItemView;
        this.a = gVar;
    }

    public final void onClick(View view) {
        ChoicenessLiveGroupSecondItemView.a(this.b, 2, this.a.i, this.a);
    }
}
