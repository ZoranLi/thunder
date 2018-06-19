package com.xunlei.downloadprovider.cardslide.a;

import com.xunlei.downloadprovider.database.b.a;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.util.List;

/* compiled from: CardSlideCacheHelper */
public final class b implements Runnable {
    final /* synthetic */ List a;
    final /* synthetic */ a b;

    public b(a aVar, List list) {
        this.b = aVar;
        this.a = list;
    }

    public final void run() {
        if (this.a != null) {
            try {
                a.a().b().getCardSlideInfoDao().deleteAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (int i = 0; i < this.a.size(); i++) {
                com.xunlei.downloadprovider.cardslide.c.a aVar = (com.xunlei.downloadprovider.cardslide.c.a) this.a.get(i);
                BaseVideoInfo baseVideoInfo = aVar.b;
                VideoUserInfo videoUserInfo = aVar.a;
                e eVar = new e();
                eVar.b = aVar.c;
                eVar.c = baseVideoInfo.getVideoId();
                eVar.d = baseVideoInfo.getPlayUrl();
                eVar.e = baseVideoInfo.getTitle();
                eVar.h = Integer.valueOf(baseVideoInfo.getLikeCount());
                eVar.g = baseVideoInfo.getGcid();
                eVar.f = baseVideoInfo.getCoverUrl();
                eVar.k = videoUserInfo.getUid();
                eVar.i = videoUserInfo.getPortraitUrl();
                eVar.j = videoUserInfo.getNickname();
                eVar.l = videoUserInfo.getSex();
                eVar.m = videoUserInfo.getProvince();
                eVar.n = videoUserInfo.getCity();
                eVar.o = videoUserInfo.getKind();
                eVar.p = Boolean.valueOf(videoUserInfo.isAuthPub());
                eVar.q = Boolean.valueOf(videoUserInfo.isVip());
                eVar.r = Integer.valueOf(videoUserInfo.getVipInfo().b);
                eVar.s = Boolean.valueOf(videoUserInfo.getVipInfo().e);
                eVar.t = Integer.valueOf(videoUserInfo.getVipInfo().b());
                d.a(eVar);
            }
        }
    }
}
