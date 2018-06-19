package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.g;
import com.xunlei.downloadprovider.launch.b.a;

/* compiled from: ChoicenessLiveGroupItemView */
final class d implements OnClickListener {
    final /* synthetic */ g a;
    final /* synthetic */ int b;
    final /* synthetic */ a c;

    d(a aVar, g gVar, int i) {
        this.c = aVar;
        this.a = gVar;
        this.b = i;
    }

    public final void onClick(View view) {
        a.a().openUserLivePlayRoom(this.c.b.getContext(), this.a.i, "sl_home_card_item");
        ChoicenessReporter.a(this.c.b.d, this.b, "slide", this.a, this.c.b.c);
    }
}
