package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;

public class ChoicenessTopicItemView extends FrameLayout implements b<m> {

    private static class a {
        ImageView a;

        private a() {
        }
    }

    public final /* bridge */ /* synthetic */ void a(int i, i iVar, int i2, View view, e eVar) {
    }

    public ChoicenessTopicItemView(Context context) {
        super(context);
        a(context);
    }

    public ChoicenessTopicItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChoicenessTopicItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        context = LayoutInflater.from(context).inflate(R.layout.choiceness_topic_item, this, true);
        a aVar = new a();
        aVar.a = (ImageView) context.findViewById(R.id.iv_cover);
        setTag(aVar);
    }
}
