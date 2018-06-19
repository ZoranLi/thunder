package me.iwf.photopicker.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.RequestManager;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.R;
import me.iwf.photopicker.b.b;

/* compiled from: PopupDirectoryListAdapter */
public final class g extends BaseAdapter {
    private List<b> a = new ArrayList();
    private RequestManager b;

    /* compiled from: PopupDirectoryListAdapter */
    private class a {
        public ImageView a;
        public TextView b;
        public TextView c;
        final /* synthetic */ g d;

        public a(g gVar, View view) {
            this.d = gVar;
            this.a = (ImageView) view.findViewById(R.id.iv_dir_cover);
            this.b = (TextView) view.findViewById(R.id.tv_dir_name);
            this.c = (TextView) view.findViewById(R.id.tv_dir_count);
        }
    }

    public g(RequestManager requestManager, List<b> list) {
        this.a = list;
        this.b = requestManager;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final long getItemId(int i) {
        return (long) ((b) this.a.get(i)).hashCode();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.__picker_item_directory, viewGroup, false);
            viewGroup = new a(this, view);
            view.setTag(viewGroup);
        } else {
            viewGroup = (a) view.getTag();
        }
        b bVar = (b) this.a.get(i);
        viewGroup.d.b.load(bVar.b).dontAnimate().thumbnail(0.1f).into(viewGroup.a);
        viewGroup.b.setText(bVar.c);
        viewGroup.c.setText(viewGroup.c.getContext().getString(R.string.__picker_image_count, new Object[]{Integer.valueOf(bVar.e.size())}));
        return view;
    }

    public final /* synthetic */ Object getItem(int i) {
        return (b) this.a.get(i);
    }
}
