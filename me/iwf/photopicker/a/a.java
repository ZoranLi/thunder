package me.iwf.photopicker.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.xunlei.downloadprovider.member.payment.external.PayBaseConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.R;
import me.iwf.photopicker.c.b;

/* compiled from: PhotoGridAdapter */
public final class a extends h<a> {
    public me.iwf.photopicker.c.a a;
    public b b;
    public OnClickListener c;
    public boolean d;
    public boolean e;
    private LayoutInflater i;
    private RequestManager j;
    private int k;
    private int l;

    /* compiled from: PhotoGridAdapter */
    public static class a extends ViewHolder {
        private ImageView a;
        private View b;

        public a(View view) {
            super(view);
            this.a = (ImageView) view.findViewById(R.id.iv_photo);
            this.b = view.findViewById(R.id.v_selected);
        }
    }

    public final /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        a aVar = (a) viewHolder;
        if (getItemViewType(i) == 101) {
            List d = d();
            if (b()) {
                i = (me.iwf.photopicker.b.a) d.get(i - 1);
            } else {
                i = (me.iwf.photopicker.b.a) d.get(i);
            }
            if (me.iwf.photopicker.d.a.a(aVar.a.getContext())) {
                this.j.load(new File(i.a)).centerCrop().dontAnimate().thumbnail(PayBaseConstants.HALF_OF_FLOAT).override(this.k, this.k).placeholder(R.drawable.__picker_ic_photo_black_48dp).error(R.drawable.__picker_ic_broken_image_black_48dp).into(aVar.a);
            }
            boolean a = a(i);
            aVar.b.setSelected(a);
            aVar.a.setSelected(a);
            aVar.a.setOnClickListener(new c(this, aVar));
            aVar.b.setOnClickListener(new d(this, aVar, i));
            return;
        }
        aVar.a.setImageResource(R.drawable.__picker_camera);
    }

    public final /* synthetic */ void onViewRecycled(ViewHolder viewHolder) {
        a aVar = (a) viewHolder;
        Glide.clear(aVar.a);
        super.onViewRecycled(aVar);
    }

    private a(Context context, RequestManager requestManager, List<me.iwf.photopicker.b.b> list) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = true;
        this.e = true;
        this.l = 3;
        this.f = list;
        this.j = requestManager;
        this.i = LayoutInflater.from(context);
        a(context, this.l);
    }

    public a(Context context, RequestManager requestManager, List<me.iwf.photopicker.b.b> list, ArrayList<String> arrayList, int i) {
        this(context, requestManager, list);
        a(context, i);
        this.g = new ArrayList();
        if (arrayList != null) {
            this.g.addAll(arrayList);
        }
    }

    private void a(Context context, int i) {
        this.l = i;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.k = displayMetrics.widthPixels / i;
    }

    public final int getItemViewType(int i) {
        return (b() && i == 0) ? 100 : 101;
    }

    public final int getItemCount() {
        int size = this.f.size() == 0 ? 0 : d().size();
        return b() ? size + 1 : size;
    }

    public final ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList(c());
        for (String add : this.g) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public final boolean b() {
        return this.d && this.h == 0;
    }

    public final /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        ViewHolder aVar = new a(this.i.inflate(R.layout.__picker_item_photo, viewGroup, false));
        if (i == 100) {
            aVar.b.setVisibility(8);
            aVar.a.setScaleType(ScaleType.CENTER);
            aVar.a.setOnClickListener(new b(this));
        }
        return aVar;
    }
}
