package com.xunlei.downloadprovider.download.d;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;

/* compiled from: AppSelectAdapter */
public final class a extends Adapter<b> {
    a a;
    private Context b;
    private ArrayList<f> c;

    /* compiled from: AppSelectAdapter */
    public interface a {
        void a(f fVar);
    }

    /* compiled from: AppSelectAdapter */
    public static class b extends ViewHolder {
        public View a;
        public ImageView b;
        public TextView c;
        public TextView d;
        public View e;

        public b(View view) {
            super(view);
            this.a = view.findViewById(R.id.left_space_view);
            this.b = (ImageView) view.findViewById(R.id.iv_sub_icon);
            this.c = (TextView) view.findViewById(R.id.tv_sub_title);
            this.d = (TextView) view.findViewById(R.id.tv_sub_recommend);
            this.e = view.findViewById(R.id.right_space_view);
        }
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        b bVar = (b) viewHolder;
        f fVar = d.a(this.c) ? null : (f) this.c.get(i);
        if (fVar != null) {
            if (fVar.e) {
                Object appIconUrl = fVar.f.getAppIconUrl();
                ImageView imageView = bVar.b;
                if (imageView != null) {
                    if (!TextUtils.isEmpty(appIconUrl)) {
                        Glide.with(this.b).load(appIconUrl).asBitmap().diskCacheStrategy(DiskCacheStrategy.RESULT).fallback(R.drawable.default_cooperation_item_ic).placeholder(R.drawable.default_cooperation_item_ic).error(R.drawable.default_cooperation_item_ic).into(imageView);
                    }
                }
                int dip2px = DipPixelUtil.dip2px(2.0f);
                bVar.b.setPadding(dip2px, dip2px, dip2px, dip2px);
            }
            if (!(fVar.e || fVar.a == null)) {
                bVar.b.setImageDrawable(fVar.a);
                if (!fVar.d) {
                    bVar.b.setScaleType(ScaleType.CENTER_CROP);
                }
            }
            bVar.c.setText(fVar.b);
            bVar.d.setVisibility(fVar.g ? 0 : 4);
            if (i == 0) {
                bVar.a.setVisibility(0);
            } else if (i <= 0 || i >= getItemCount() - 1) {
                bVar.e.setVisibility(0);
            } else {
                bVar.a.setVisibility(8);
                bVar.e.setVisibility(8);
            }
        }
        if (this.a != 0) {
            bVar.itemView.setOnClickListener(new b(this, bVar));
        }
    }

    public a(Context context) {
        this.b = context;
    }

    public final int getItemCount() {
        return d.a(this.c) ? 0 : this.c.size();
    }

    public final void a(ArrayList<f> arrayList) {
        if (this.c == null) {
            this.c = new ArrayList();
        }
        if (!d.a(this.c)) {
            this.c.clear();
        }
        this.c.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(LayoutInflater.from(this.b).inflate(R.layout.download_task_open_app_select_item_layout, viewGroup, false));
    }
}
