package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.f;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.g;
import com.xunlei.downloadprovider.homepage.choiceness.ui.i;
import com.xunlei.downloadprovider.homepage.choiceness.ui.z;
import java.util.ArrayList;
import java.util.List;

public class ChoicenessLiveGroupItemView extends FrameLayout implements com.xunlei.downloadprovider.homepage.choiceness.ui.a.b<f>, z {
    private RecyclerView a;
    private a b;
    private f c;
    private int d;
    private int e = 0;
    private int f = 2;

    private class a extends Adapter {
        List<g> a;
        final /* synthetic */ ChoicenessLiveGroupItemView b;
        private Context c;

        public a(ChoicenessLiveGroupItemView choicenessLiveGroupItemView, Context context) {
            this.b = choicenessLiveGroupItemView;
            this.c = context;
        }

        public final ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 0) {
                return new b(this.b, LayoutInflater.from(this.c).inflate(R.layout.choiceness_live_group_item_view, viewGroup, false));
            } else if (i != 1) {
                return 0;
            } else {
                return new c(this.b, LayoutInflater.from(this.c).inflate(R.layout.choiceness_live_group_more_item_view, viewGroup, false));
            }
        }

        public final void onBindViewHolder(ViewHolder viewHolder, int i) {
            if (viewHolder instanceof b) {
                b bVar = (b) viewHolder;
                if (this.a != null) {
                    g gVar = (g) this.a.get(i);
                    if (gVar != null) {
                        com.xunlei.downloadprovider.homepage.choiceness.b.a().a(gVar.g, bVar.b, null);
                        if (TextUtils.isEmpty(gVar.n)) {
                            bVar.c.setVisibility(8);
                        } else {
                            com.xunlei.downloadprovider.homepage.choiceness.b.a().a(gVar.n, bVar.c, null);
                            bVar.c.setVisibility(0);
                        }
                        bVar.d.setText(gVar.e);
                        bVar.e.setText(b.a(gVar.j));
                    }
                    bVar.a.setOnClickListener(new d(this, gVar, i));
                }
                return;
            }
            if ((viewHolder instanceof c) != 0) {
                ((c) viewHolder).a.setOnClickListener(new e(this));
            }
        }

        public final int getItemCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.size() + 1;
        }

        public final int getItemViewType(int i) {
            return (this.a.size() <= 0 || i != this.a.size()) ? 0 : 1;
        }
    }

    private class b extends ViewHolder {
        View a;
        ImageView b;
        ImageView c;
        TextView d;
        TextView e;
        final /* synthetic */ ChoicenessLiveGroupItemView f;

        public b(ChoicenessLiveGroupItemView choicenessLiveGroupItemView, View view) {
            this.f = choicenessLiveGroupItemView;
            super(view);
            this.a = view.findViewById(R.id.publisher_layout);
            this.b = (ImageView) view.findViewById(R.id.cover);
            this.c = (ImageView) view.findViewById(R.id.tag);
            this.d = (TextView) view.findViewById(R.id.nickname);
            this.e = (TextView) view.findViewById(R.id.online_num);
        }

        static String a(int i) {
            String valueOf = String.valueOf(i);
            if (i < 10000) {
                return valueOf;
            }
            i = String.format("%.1f", new Object[]{Float.valueOf(((float) i) / 1176256512)});
            if (i.endsWith(".0")) {
                i = i.substring(0, i.length() - 2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("万");
            return stringBuilder.toString();
        }
    }

    private class c extends ViewHolder {
        View a;
        final /* synthetic */ ChoicenessLiveGroupItemView b;

        public c(ChoicenessLiveGroupItemView choicenessLiveGroupItemView, View view) {
            this.b = choicenessLiveGroupItemView;
            super(view);
            this.a = view.findViewById(R.id.more_item);
        }
    }

    public final /* synthetic */ void a(int i, i iVar, int i2, View view, e eVar) {
        f fVar = (f) eVar;
        this.c = fVar;
        this.d = i;
        this.b.a = fVar.a;
        this.b.notifyDataSetChanged();
        this.a.scrollToPosition(null);
    }

    public ChoicenessLiveGroupItemView(@NonNull Context context) {
        super(context);
        a(context);
    }

    public ChoicenessLiveGroupItemView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChoicenessLiveGroupItemView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.choiceness_live_group_view, this, true);
        this.a = (RecyclerView) findViewById(R.id.live_group_recycle_view);
        this.a.setLayoutManager(new LinearLayoutManager(context, 0, false));
        this.b = new a(this, context);
        this.a.addItemDecoration(new b(this));
        this.a.setAdapter(this.b);
        this.a.setOnScrollListener(new c(this));
    }

    public final void a() {
        List list = this.c.a;
        List arrayList = new ArrayList();
        if (list != null) {
            if (list.size() <= this.f) {
                this.f = list.size() - 1;
            }
            for (int i = this.e; i <= this.f; i++) {
                arrayList.add(((g) list.get(i)).l);
            }
        }
        if (arrayList.size() > 0) {
            com.xunlei.downloadprovider.homepage.choiceness.f.a((String[]) arrayList.toArray(new String[arrayList.size()]));
        }
    }
}
