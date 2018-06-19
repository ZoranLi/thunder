package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.homepage.follow.b.a;
import com.xunlei.downloadprovider.search.ui.a.c;
import com.xunlei.downloadprovider.search.ui.a.e;

/* compiled from: FansAndFollowAdapter */
public final class k extends e<a> {
    private int d;
    private long e;

    protected final /* synthetic */ void a(View view, c cVar) {
        a aVar = (a) cVar;
        if (view instanceof l) {
            l lVar = (l) view;
            int i = this.d;
            if (aVar != null) {
                lVar.g = aVar;
                lVar.h = i;
                if (TextUtils.isEmpty(aVar.e)) {
                    lVar.b.setVisibility(8);
                    lVar.b.setText(aVar.e);
                } else {
                    lVar.b.setVisibility(0);
                    lVar.b.setText(aVar.e);
                }
                if (TextUtils.isEmpty(aVar.a())) {
                    lVar.d.setVisibility(8);
                } else {
                    lVar.d.setVisibility(0);
                    lVar.d.setText(aVar.a());
                }
                lVar.c.setUserInfo(aVar.a);
                if (TextUtils.isEmpty(aVar.f)) {
                    lVar.e.setImageResource(R.drawable.ic_default_avatar_new);
                } else {
                    Glide.with(lVar.i).load(aVar.f).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.ic_default_avatar_new).error(R.drawable.ic_default_avatar_new).dontAnimate().into(lVar.e);
                }
                if (lVar.h == 2) {
                    if (lVar.j.g.c() == lVar.a) {
                        lVar.f.setVisibility(8);
                        if ("rad".equals(aVar.c)) {
                            if (TextUtils.isEmpty(aVar.k)) {
                                lVar.d.setVisibility(8);
                            } else {
                                lVar.d.setVisibility(0);
                                lVar.d.setText(aVar.k);
                                return;
                            }
                        }
                    }
                }
                if (aVar.b != 0) {
                    if (lVar.j.g.c() != aVar.b) {
                        if (b.a().b(aVar.b)) {
                            lVar.f.setVisibility(0);
                            lVar.f.setBackgroundResource(R.drawable.btn_unfollow_selector2);
                            lVar.f.setText("已关注");
                        } else {
                            lVar.f.setVisibility(0);
                            lVar.f.setBackgroundResource(R.drawable.btn_follow_selector2);
                            lVar.f.setText("+ 关注");
                        }
                        lVar.f.setOnClickListener(lVar);
                        if ("rad".equals(aVar.c)) {
                            if (TextUtils.isEmpty(aVar.k)) {
                                lVar.d.setVisibility(8);
                            } else {
                                lVar.d.setVisibility(0);
                                lVar.d.setText(aVar.k);
                                return;
                            }
                        }
                    }
                }
                lVar.f.setVisibility(8);
                lVar.f.setOnClickListener(lVar);
                if ("rad".equals(aVar.c)) {
                    if (TextUtils.isEmpty(aVar.k)) {
                        lVar.d.setVisibility(0);
                        lVar.d.setText(aVar.k);
                        return;
                    }
                    lVar.d.setVisibility(8);
                }
            }
        }
    }

    public k(int i, long j, e.a aVar) {
        super(aVar);
        this.d = i;
        this.e = j;
    }

    protected final /* synthetic */ View a(Context context) {
        return new l(context, this.e);
    }
}
