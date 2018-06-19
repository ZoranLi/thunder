package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.publiser.websitetopic.WebsiteTopicActivity;

/* compiled from: ChoicenessWebsiteTopicView */
final class as implements OnClickListener {
    final /* synthetic */ ar a;

    as(ar arVar) {
        this.a = arVar;
    }

    public final void onClick(View view) {
        ChoicenessReporter.a(this.a.a);
        WebsiteTopicActivity.a(this.a.getContext(), "home", this.a.a.a, this.a.a.b);
    }
}
