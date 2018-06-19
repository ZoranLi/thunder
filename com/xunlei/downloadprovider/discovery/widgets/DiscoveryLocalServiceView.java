package com.xunlei.downloadprovider.discovery.widgets;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.downloadprovider.R;
import com.xunlei.xllib.b.d;
import java.util.ArrayList;
import java.util.List;

public class DiscoveryLocalServiceView extends FrameLayout {
    private boolean a;
    private View b;
    private DisableScrollGridView c;
    private List<com.xunlei.downloadprovider.d.b.o.a> d;

    class a {
        public RelativeLayout a;
        public ImageView b;
        public TextView c;
        final /* synthetic */ DiscoveryLocalServiceView d;

        a(DiscoveryLocalServiceView discoveryLocalServiceView) {
            this.d = discoveryLocalServiceView;
        }
    }

    private class b extends BaseAdapter {
        final /* synthetic */ DiscoveryLocalServiceView a;

        public final long getItemId(int i) {
            return (long) i;
        }

        private b(DiscoveryLocalServiceView discoveryLocalServiceView) {
            this.a = discoveryLocalServiceView;
        }

        public final /* synthetic */ Object getItem(int i) {
            return a(i);
        }

        public final int getCount() {
            return d.a(this.a.d) ? 0 : this.a.d.size();
        }

        private com.xunlei.downloadprovider.d.b.o.a a(int i) {
            return d.a(this.a.d) ? 0 : (com.xunlei.downloadprovider.d.b.o.a) this.a.d.get(i);
        }

        public final boolean isEnabled(int i) {
            if (this.a.d != null) {
                if (this.a.d.size() >= i) {
                    if (this.a.d.get(i) == 0) {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new a(this.a);
                if (this.a.a == null) {
                    viewGroup = LayoutInflater.from(this.a.getContext()).inflate(R.layout.discovery_item_tip_local_service_item_layout, null);
                } else {
                    viewGroup = LayoutInflater.from(this.a.getContext()).inflate(R.layout.discovery_item_tip_game_center_item_layout, null);
                }
                view.a = (RelativeLayout) viewGroup.findViewById(R.id.rl_sub_layout);
                view.b = (ImageView) viewGroup.findViewById(R.id.iv_sub_icon);
                view.c = (TextView) viewGroup.findViewById(R.id.tv_sub_title);
                viewGroup.setTag(view);
            } else {
                viewGroup = view;
                view = (a) view.getTag();
            }
            com.xunlei.downloadprovider.d.b.o.a a = a(i);
            if (a != null) {
                if (!TextUtils.isEmpty(a.b) && com.xunlei.xllib.android.b.a(this.a.getContext())) {
                    DiscoveryLocalServiceView discoveryLocalServiceView = this.a;
                    String str = a.b;
                    Glide.with(discoveryLocalServiceView.getContext()).load(str).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(view.b);
                }
                if (!TextUtils.isEmpty(a.a)) {
                    view.c.setText(a.a);
                }
                view.a.setOnClickListener(new a(this, a, i));
            }
            return viewGroup;
        }
    }

    public DiscoveryLocalServiceView(Context context, boolean z) {
        super(context);
        this.a = z;
        a(context);
    }

    public DiscoveryLocalServiceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public DiscoveryLocalServiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.b = LayoutInflater.from(context).inflate(R.layout.discovery_item_tip_local_service_layout, null);
        this.c = (DisableScrollGridView) this.b.findViewById(R.id.gv_local_service);
        this.c.setAdapter(new b());
        addView(this.b);
    }

    public void setItemData(List<com.xunlei.downloadprovider.d.b.o.a> list) {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        if (!d.a(this.d)) {
            this.d.clear();
        }
        this.d.addAll(list);
    }
}
