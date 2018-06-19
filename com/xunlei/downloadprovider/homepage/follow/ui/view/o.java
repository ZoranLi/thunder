package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.follow.ae;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.homepage.follow.b.e;
import com.xunlei.downloadprovider.homepage.follow.ui.widget.AvatarImageView;
import com.xunlei.downloadprovider.homepage.follow.ui.widget.HorizontalAvatarList;
import com.xunlei.downloadprovider.personal.user.account.m;
import java.util.List;

/* compiled from: MyFollowingTitleViewHolder */
public final class o extends ViewHolder {
    private View a;
    private HorizontalAvatarList b;
    private TextView c;

    public final void a(ap apVar) {
        e eVar = (e) apVar.b;
        List list = eVar.a;
        HorizontalAvatarList horizontalAvatarList = this.b;
        horizontalAvatarList.removeAllViews();
        int i = 0;
        if (list != null) {
            if (!list.isEmpty()) {
                int min = Math.min(list.size(), horizontalAvatarList.a);
                for (int i2 = 0; i2 < min; i2++) {
                    a aVar = (a) list.get(i2);
                    View avatarImageView = new AvatarImageView(horizontalAvatarList.getContext());
                    avatarImageView.setLayoutParams(new LayoutParams(-2, -2));
                    avatarImageView.setPadding(0, 0, horizontalAvatarList.b, 0);
                    ae.a();
                    String str = aVar.f;
                    ImageView imageView = avatarImageView.a;
                    Glide.with(imageView.getContext()).load(str).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.xllive_avatar_default).fallback(R.drawable.xllive_avatar_default).error(R.drawable.xllive_avatar_default).transform(new BitmapTransformation[]{new com.xunlei.downloadprovider.h.a.a.a(imageView.getContext())}).into(imageView);
                    m.a(avatarImageView.b, aVar.d, aVar.c);
                    horizontalAvatarList.addView(avatarImageView);
                }
            }
        }
        TextView textView = this.c;
        if (eVar.b == null) {
            i = 8;
        }
        textView.setVisibility(i);
    }

    public o(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater.inflate(R.layout.follow_tab_my_following_title, viewGroup, false));
        layoutInflater = this.itemView;
        this.a = layoutInflater.findViewById(R.id.layout_title);
        this.a.setOnClickListener(new p(this));
        this.b = (HorizontalAvatarList) layoutInflater.findViewById(R.id.avatars);
        this.c = (TextView) layoutInflater.findViewById(R.id.tv_no_feed);
    }
}
