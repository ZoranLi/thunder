package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.o;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;

/* compiled from: ChoicenessWebsiteTopicView */
public final class ar extends FrameLayout implements b<o> {
    private o a;
    private TextView b;
    private ImageView c;
    private TextView d;

    public final /* synthetic */ void a(int i, i iVar, int i2, View view, e eVar) {
        o oVar = (o) eVar;
        if (oVar != null) {
            this.a = oVar;
            this.b.setText(oVar.b);
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(oVar.c, this.c, null);
            this.d.setText(oVar.d);
        }
    }

    public ar(@NonNull Context context) {
        super(context);
        context = LayoutInflater.from(context).inflate(R.layout.choiceness_website_topic_item, this, true);
        this.b = (TextView) context.findViewById(R.id.tv_title);
        this.c = (ImageView) context.findViewById(R.id.iv_poster);
        this.d = (TextView) context.findViewById(R.id.tv_website_topic_subtitle);
        setOnClickListener(new as(this));
    }
}
