package com.xunlei.downloadprovider.publiser.common.guide.interesttag.a;

import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.publiser.common.guide.a;
import com.xunlei.downloadprovider.publiser.common.guide.interesttag.d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: InterestTagModel */
public final class c implements a {
    private List<b> a = null;
    private List<b> b = null;

    public c() {
        d();
        this.b = new ArrayList();
    }

    @NonNull
    public final List<b> a() {
        return this.a;
    }

    public final void a(List<b> list) {
        new StringBuilder("reportShow hobbyTagInfos.size: ").append(list.size());
        d.a("personal_info_interest_show", list);
    }

    public final void b(List<b> list) {
        new StringBuilder("reportChosen hobbyTagInfos.size: ").append(list.size());
        d.a("personal_info_interest_click", list);
    }

    public final void b() {
        a.a().e();
    }

    @NonNull
    public final List<b> c() {
        return new ArrayList(this.b);
    }

    public final void a(b bVar) {
        this.b.add(bVar);
    }

    public final void b(b bVar) {
        this.b.remove(bVar);
    }

    private void d() {
        this.a = new ArrayList();
        r1 = new String[10];
        int i = 0;
        r1[0] = "搞笑";
        r1[1] = "美女";
        r1[2] = "美妆";
        r1[3] = "美食";
        r1[4] = "萌宠";
        r1[5] = "歌舞";
        r1[6] = "影视";
        r1[7] = "娱乐";
        r1[8] = "旅游";
        r1[9] = "游戏";
        while (i < 10) {
            this.a.add(new b(r1[i]));
            i++;
        }
    }
}
