package com.xunlei.downloadprovider.homepage.choiceness.ui;

import com.xunlei.android.shortvideo.ShortVideoInterface;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter$RefreshType;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.player.xmp.ak;
import com.xunlei.downloadprovider.search.b.a;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: HomeChoicenessFragment */
final class q implements a<e> {
    final /* synthetic */ HomeChoicenessFragment a;

    q(HomeChoicenessFragment homeChoicenessFragment) {
        this.a = homeChoicenessFragment;
    }

    public final void a(List<e> list) {
        if (this.a.getActivity() != null && this.a.f.a()) {
            this.a.f.a(list);
            if (this.a.f.a()) {
                this.a.a(ChoicenessReporter$RefreshType.auto_pull);
            } else if (d.a().b.i() && b.f(this.a.getActivity())) {
                int min = Math.min(2, list.size());
                ArrayList arrayList = new ArrayList(min);
                for (int i = 0; i < min; i++) {
                    e eVar = (e) list.get(i);
                    if (eVar.e()) {
                        BaseVideoInfo baseVideoInfo = ((m) eVar).b;
                        arrayList.add(new ShortVideoInterface.a(baseVideoInfo.getPlayUrl(), baseVideoInfo.getGcid(), baseVideoInfo.getTitle(), baseVideoInfo.getDuration()));
                    }
                }
                ak.a().a(arrayList, null);
            }
        }
    }
}
