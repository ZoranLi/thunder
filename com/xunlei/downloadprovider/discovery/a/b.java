package com.xunlei.downloadprovider.discovery.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.publiser.campaign.TopicDetailActivity;
import com.xunlei.downloadprovider.publiser.campaign.TopicDetailActivity.From;

/* compiled from: HotTopicManager */
final class b implements OnClickListener {
    final /* synthetic */ a$a a;
    final /* synthetic */ a b;

    b(a aVar, a$a com_xunlei_downloadprovider_discovery_a_a_a) {
        this.b = aVar;
        this.a = com_xunlei_downloadprovider_discovery_a_a_a;
    }

    public final void onClick(View view) {
        a.a(this.a);
        TopicDetailActivity.a(a.a(this.b), this.a.b, From.DISCOVERY.name());
    }
}
