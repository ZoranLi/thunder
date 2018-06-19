package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.i;
import com.xunlei.downloadprovider.launch.b.a;

/* compiled from: ChoicenessLivestreamItemView */
final class s implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ i b;
    final /* synthetic */ a c;
    final /* synthetic */ ChoicenessLivestreamItemView d;

    s(ChoicenessLivestreamItemView choicenessLivestreamItemView, int i, i iVar, a aVar) {
        this.d = choicenessLivestreamItemView;
        this.a = i;
        this.b = iVar;
        this.c = aVar;
    }

    public final void onClick(View view) {
        ChoicenessReporter.a(this.a, this.b);
        this.d.a(0);
        view = a.a();
        Context context = this.d.getContext();
        String str = this.b.u;
        String str2 = (this.b.a() && this.c.r.getVisibility() == 0) ? "sl_new_user_gift_pack" : "sl_home_card_item";
        view.openUserLivePlayRoom(context, str, str2);
        if (this.b.a() != null) {
            this.c.r.setVisibility(8);
        }
    }
}
