package com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.ui;

import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.umeng.message.common.inter.ITagManager;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.personal.redenvelope.f;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.a.a;
import com.xunlei.downloadprovider.personal.redenvelope.redenvelopelist.b.e;
import java.util.List;

/* compiled from: RedEnvelopesActivity */
final class h implements a {
    final /* synthetic */ RedEnvelopesActivity a;

    h(RedEnvelopesActivity redEnvelopesActivity) {
        this.a = redEnvelopesActivity;
    }

    public final void a(List<e> list, String str, int i) {
        List list2 = list;
        this.a.c.hide();
        if (str.equals(ITagManager.SUCCESS) && list2 != null && list.size() != 0) {
            r0.a.i = i;
            int size = r0.a.j.size();
            r0.a.j.addAll(list2);
            r0.a.h.a(r0.a.j);
            r0.a.f.onRefreshComplete();
            if (list2 != null && list.size() > 0) {
                r0.a.a.scrollToPosition(size);
            }
            r0.a.q.postDelayed(new l(r0.a), 60000);
            if (!r0.a.k) {
                r0.a.k = true;
                String str2 = "personal_center_packet";
                if (list2 != null) {
                    int i2 = 0;
                    a aVar = new a();
                    a aVar2 = new a();
                    a aVar3 = new a();
                    a aVar4 = new a();
                    a aVar5 = new a();
                    a aVar6 = new a();
                    String str3 = "";
                    String str4 = "";
                    String str5 = "";
                    String str6 = "";
                    String str7 = "";
                    String str8 = "";
                    while (i2 < list.size()) {
                        e eVar = (e) list2.get(i2);
                        switch (eVar.f) {
                            case 1:
                                str4 = aVar2.a(eVar);
                                break;
                            case 2:
                                str3 = aVar.a(eVar);
                                break;
                            case 3:
                                str5 = aVar3.a(eVar);
                                break;
                            case 4:
                                str6 = aVar4.a(eVar);
                                break;
                            case 5:
                                str7 = aVar5.a(eVar);
                                break;
                            case 6:
                                str8 = aVar6.a(eVar);
                                break;
                            default:
                                break;
                        }
                        i2++;
                        List<e> list3 = list;
                    }
                    StatEvent build = HubbleEventBuilder.build("android_packet", "packet_list_show");
                    build.add("from", str2);
                    if (!str3.isEmpty()) {
                        build.add("packet_2", str3);
                    }
                    if (!str4.isEmpty()) {
                        build.add("packet_1", str4);
                    }
                    if (!str5.isEmpty()) {
                        build.add("packet_3", str5);
                    }
                    if (!str6.isEmpty()) {
                        build.add("packet_4", str6);
                    }
                    if (!str7.isEmpty()) {
                        build.add("packet_5", str7);
                    }
                    if (!str8.isEmpty()) {
                        build.add("packet_6", str8);
                    }
                    f.a(build);
                }
            }
        } else if (r0.a.j == null || r0.a.j.size() <= 0) {
            RedEnvelopesActivity.j(r0.a);
        } else {
            r0.a.h.a(r0.a.j);
            r0.a.f.onRefreshComplete();
            r0.a.f.setMode(Mode.DISABLED);
        }
    }

    public final void a(VolleyError volleyError) {
        new StringBuilder("onGetRedEnvelopesError volleyError = ").append(volleyError.toString());
        this.a.c();
    }
}
