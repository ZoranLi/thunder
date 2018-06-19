package me.iwf.photopicker.a;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import anet.channel.util.HttpConstant;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.R;
import me.iwf.photopicker.d.a;

/* compiled from: PhotoPagerAdapter */
public final class e extends PagerAdapter {
    private List<String> a = new ArrayList();
    private RequestManager b;

    public final int getItemPosition(Object obj) {
        return -2;
    }

    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public e(RequestManager requestManager, List<String> list) {
        this.a = list;
        this.b = requestManager;
    }

    public final Object instantiateItem(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.__picker_picker_item_pager, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_pager);
        String str = (String) this.a.get(i);
        if (str.startsWith(HttpConstant.HTTP)) {
            i = Uri.parse(str);
        } else {
            i = Uri.fromFile(new File(str));
        }
        if (a.a(context)) {
            this.b.load(i).thumbnail(0.1f).dontAnimate().dontTransform().override(800, 800).placeholder(R.drawable.__picker_ic_photo_black_48dp).error(R.drawable.__picker_ic_broken_image_black_48dp).into(imageView);
        }
        imageView.setOnClickListener(new f(this, context));
        viewGroup.addView(inflate);
        return inflate;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        Glide.clear(view);
    }
}
