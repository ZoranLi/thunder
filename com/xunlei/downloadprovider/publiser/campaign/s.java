package com.xunlei.downloadprovider.publiser.campaign;

import android.view.View;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.VideoTagView;
import com.xunlei.downloadprovider.publiser.campaign.a.n;
import com.xunlei.downloadprovider.search.ui.a.d;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.a;

/* compiled from: TopicViewHolder */
public final class s extends d<n> {
    private int a;
    private int b;
    private String c;
    private View d;
    private n e;

    public final /* synthetic */ void a(Object obj) {
        n nVar = (n) obj;
        if (this.e != nVar && this.d != null) {
            String str;
            String str2;
            a aVar = (a) this.d;
            VideoTagView videoTagView = aVar.b.D;
            switch (this.a) {
                case 2:
                    str = "MUSIC";
                    break;
                case 3:
                    str = "LBS";
                    break;
                default:
                    str = "TOPIC";
                    break;
            }
            videoTagView.setFrom(str);
            int adapterPosition = getAdapterPosition();
            BaseVideoInfo baseVideoInfo = nVar.b;
            VideoUserInfo videoUserInfo = nVar.c;
            int i = this.a;
            switch (this.b) {
                case 1:
                    str2 = "hot";
                    break;
                case 2:
                    str2 = "new";
                    break;
                default:
                    str2 = "new";
                    break;
            }
            aVar.a(adapterPosition, baseVideoInfo, videoUserInfo, new o(i, str2));
            aVar.getReportStrategy().b = nVar;
            if (this.a == 3) {
                aVar.b.D.setLbsDetailLocationCode(this.c);
            }
            aVar.b.b.setVisibility(nVar.b.isTop() != null ? null : 8);
        }
    }

    public s(int i, int i2, String str, View view) {
        super(view);
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = view;
    }
}
