package com.xunlei.downloadprovider.vod.dlna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: DeviceAdapter */
public final class r extends BaseAdapter {
    List<s> a = new ArrayList();
    private Context b;

    public final long getItemId(int i) {
        return (long) i;
    }

    public r(Context context) {
        this.b = context;
    }

    public final int getCount() {
        return this.a.size();
    }

    public final Object getItem(int i) {
        return this.a.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dlna_search_result_list_view_item, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.tv_dlna_device_item);
        textView.setMaxLines(1);
        textView.setText(((s) this.a.get(i)).b);
        return view;
    }

    public final void a(List<s> list) {
        this.a.clear();
        if (list != null) {
            this.a.addAll(list);
            notifyDataSetChanged();
        }
    }
}
