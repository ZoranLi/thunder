package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.launch.b.a;

/* compiled from: ChoicenessLiveStoryItemView */
final class k implements OnClickListener {
    final /* synthetic */ ChoicenessLiveStoryItemView a;

    k(ChoicenessLiveStoryItemView choicenessLiveStoryItemView) {
        this.a = choicenessLiveStoryItemView;
    }

    public final void onClick(View view) {
        StatEvent build = HubbleEventBuilder.build("android_home", "home_zb_story_other_click");
        build.add("clickid", "view_more");
        ThunderReport.reportEvent(build);
        a.a().getRouteDispatcher().livePage();
    }
}
