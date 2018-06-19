package com.xunlei.downloadprovider.cardslide.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.cardslide.CardSlideActivity;
import com.xunlei.downloadprovider.publiser.common.view.UserInfoTagView;

/* compiled from: CardViewHolder */
public final class a {
    public CardSlideActivity a;
    public ImageView b;
    public TextView c;
    public View d;
    public final ImageView e;
    public final UserInfoTagView f;
    public final TextView g;
    public final TextView h;
    public final TextView i;
    public com.xunlei.downloadprovider.cardslide.c.a j;

    public a(CardSlideActivity cardSlideActivity, View view) {
        this.a = cardSlideActivity;
        this.b = (ImageView) view.findViewById(R.id.card_image_view);
        this.e = (ImageView) view.findViewById(R.id.iv_user_portrait);
        this.f = (UserInfoTagView) view.findViewById(R.id.card_user_info_view);
        this.g = (TextView) view.findViewById(R.id.tv_card_num);
        this.i = (TextView) view.findViewById(R.id.tv_card_total_count);
        this.c = (TextView) view.findViewById(R.id.card_user_name);
        this.h = (TextView) view.findViewById(R.id.tv_distance);
        this.d = view.findViewById(R.id.card_bottom_layout);
    }
}
