package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.l;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.homepage.follow.aa;
import com.xunlei.downloadprovider.homepage.follow.ab;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import java.util.List;

public class ChoicenessRecommendUserView extends FrameLayout implements com.xunlei.downloadprovider.homepage.choiceness.ui.a.b<l> {
    private RecyclerView a;
    private a b;
    private l c;

    private class a extends Adapter<b> {
        List<com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a> a;
        final /* synthetic */ ChoicenessRecommendUserView b;
        private Context c;

        public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
            b bVar = (b) viewHolder;
            com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a aVar = (com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a) this.a.get(i);
            bVar.e = aVar;
            VideoUserInfo videoUserInfo = aVar.c;
            if (videoUserInfo != null) {
                bVar.itemView.setOnClickListener(new af(bVar, videoUserInfo.getUid(), videoUserInfo, i, aVar));
                com.xunlei.downloadprovider.homepage.choiceness.b.a();
                com.xunlei.downloadprovider.homepage.choiceness.b.a(videoUserInfo.getPortraitUrl(), bVar.a);
                bVar.b.setText(videoUserInfo.getNickname());
                bVar.c.setText(aVar.b);
                ab.a().b(bVar.f);
                ab.a().a(bVar.f);
                if (b.a(aVar.a)) {
                    bVar.a(true);
                } else {
                    bVar.a(false);
                    bVar.d.setOnClickListener(new ag(bVar, aVar, i));
                }
                if (i == 4 && !aVar.d) {
                    ChoicenessReporter.b(bVar.g.c, i, aVar);
                    aVar.d = true;
                }
            }
        }

        public a(ChoicenessRecommendUserView choicenessRecommendUserView, Context context) {
            this.b = choicenessRecommendUserView;
            this.c = context;
        }

        public final int getItemCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.size();
        }

        public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new b(this.b, LayoutInflater.from(this.c).inflate(R.layout.choiceness_recommend_user_item_view, viewGroup, false));
        }
    }

    private class b extends ViewHolder {
        ImageView a;
        TextView b;
        TextView c;
        TextView d;
        com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a e;
        aa f = new aj(this);
        final /* synthetic */ ChoicenessRecommendUserView g;

        public b(ChoicenessRecommendUserView choicenessRecommendUserView, View view) {
            this.g = choicenessRecommendUserView;
            super(view);
            this.a = (ImageView) view.findViewById(R.id.user_photo);
            this.b = (TextView) view.findViewById(R.id.nickname);
            this.c = (TextView) view.findViewById(R.id.recommend_reason);
            this.d = (TextView) view.findViewById(R.id.follow_btn);
        }

        static boolean a(String str) {
            return com.xunlei.downloadprovider.homepage.follow.b.a().b(Long.parseLong(str));
        }

        final void a(boolean z) {
            if (z) {
                this.d.setVisibility(0);
                this.d.setEnabled(false);
                this.d.setText("已关注");
                return;
            }
            this.d.setVisibility(0);
            this.d.setEnabled(true);
            this.d.setText("+ 关注");
        }
    }

    public final /* synthetic */ void a(int i, i iVar, int i2, View view, e eVar) {
        l lVar = (l) eVar;
        i = this.c != lVar ? 1 : 0;
        this.c = lVar;
        this.b.a = lVar.a;
        this.b.notifyDataSetChanged();
        if (i != 0) {
            this.a.scrollToPosition(0);
        }
    }

    public ChoicenessRecommendUserView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public ChoicenessRecommendUserView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChoicenessRecommendUserView(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.choiceness_recommend_user_view, this, true);
        this.a = (RecyclerView) findViewById(R.id.recommend_user_recycle_view);
        this.a.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.b = new a(this, context);
        this.a.setAdapter(this.b);
    }
}
