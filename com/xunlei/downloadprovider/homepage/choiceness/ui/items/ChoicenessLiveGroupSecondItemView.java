package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.g;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.h;
import com.xunlei.downloadprovider.homepage.choiceness.f;
import com.xunlei.downloadprovider.homepage.choiceness.ui.a.b;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.homepage.choiceness.ui.z;

public class ChoicenessLiveGroupSecondItemView extends FrameLayout implements b<h>, z {
    private AnimationDrawable a;
    private h b;
    private int c;
    private String d;

    private static class a {
        ImageView a;
        ImageView b;
        ImageView c;
        ImageView d;
        ImageView e;
        ImageView f;
        ImageView g;
        TextView h;

        private a() {
        }
    }

    public final /* synthetic */ void a(int i, i iVar, int i2, View view, e eVar) {
        h hVar = (h) eVar;
        a aVar = (a) getTag();
        this.b = hVar;
        this.c = i;
        i = hVar.a;
        if (i != 0) {
            String str;
            view = com.xunlei.downloadprovider.homepage.choiceness.b.a();
            if (TextUtils.isEmpty(i.h)) {
                str = i.g;
            } else {
                str = i.h;
            }
            view.a(str, aVar.a, null);
            view = aVar.h;
            int i3 = i.j;
            String valueOf = String.valueOf(i3);
            if (i3 >= 10000) {
                str = String.format("%.1f", new Object[]{Float.valueOf(((float) i3) / 10000.0f)});
                if (str.endsWith(".0")) {
                    str = str.substring(0, str.length() - 2);
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("万");
                valueOf = stringBuilder.toString();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(valueOf);
            stringBuilder2.append("人观看");
            view.setText(stringBuilder2.toString());
            aVar.a.setOnClickListener(new f(this, i));
        }
        i = hVar.b;
        if (i != 0) {
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(i.g, aVar.b, null);
            aVar.b.setOnClickListener(new g(this, i));
        }
        i = hVar.c;
        if (i != 0) {
            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(i.g, aVar.c, null);
            aVar.c.setOnClickListener(new h(this, i));
        }
    }

    public ChoicenessLiveGroupSecondItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, true);
    }

    public ChoicenessLiveGroupSecondItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, true);
    }

    public ChoicenessLiveGroupSecondItemView(Context context, boolean z) {
        super(context);
        a(context, z);
    }

    private void a(Context context, boolean z) {
        context = LayoutInflater.from(context).inflate(z ? R.layout.choiceness_live_group_left_view : R.layout.choiceness_live_group_right_view, this, true);
        this.d = z ? "left3" : "right3";
        z = new a();
        z.a = (ImageView) findViewById(R.id.iv_cover_first);
        z.b = (ImageView) findViewById(R.id.iv_cover_second);
        z.c = (ImageView) findViewById(R.id.iv_cover_third);
        z.d = (ImageView) findViewById(R.id.live_status_anim_first);
        z.e = (ImageView) findViewById(R.id.live_status_anim_second);
        z.f = (ImageView) findViewById(R.id.live_status_anim_third);
        ((AnimationDrawable) z.d.getDrawable()).start();
        ((AnimationDrawable) z.e.getDrawable()).start();
        ((AnimationDrawable) z.f.getDrawable()).start();
        z.h = (TextView) findViewById(R.id.online_num);
        z.g = (ImageView) context.findViewById(R.id.iv_like_bubble_animation);
        setTag(z);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable drawable = ((a) getTag()).g.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.a = (AnimationDrawable) drawable;
            this.a.start();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.a != null) {
            this.a.stop();
        }
    }

    public final void a() {
        f.a(this.b.a.l, this.b.b.l, this.b.c.l);
    }

    static /* synthetic */ void a(ChoicenessLiveGroupSecondItemView choicenessLiveGroupSecondItemView, int i, String str, g gVar) {
        ChoicenessReporter.a(choicenessLiveGroupSecondItemView.c, i, choicenessLiveGroupSecondItemView.d, gVar, choicenessLiveGroupSecondItemView.b);
        com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(choicenessLiveGroupSecondItemView.getContext(), str, "sl_home_card_item");
    }
}
