package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.j;
import com.xunlei.downloadprovider.launch.b.a;

/* compiled from: ChoicenessLiveStoryItemView */
final class m implements OnClickListener {
    final /* synthetic */ j a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    m(b bVar, j jVar, int i) {
        this.c = bVar;
        this.a = jVar;
        this.b = i;
    }

    public final void onClick(View view) {
        view = this.a.a();
        int i = this.b;
        StatEvent build = HubbleEventBuilder.build("android_home", "home_zb_story_click");
        build.add("hostid", view);
        build.add("position", i);
        ThunderReport.reportEvent(build);
        b.a(this.c, this.a.e());
        b.b(this.c, this.a.e());
        a.a().getRouteDispatcher().room(this.a.e(), this.a.a(), j.a(this.a.a, "stream_pull"), this.a.b(), "", "sl_home_story_item");
    }
}
