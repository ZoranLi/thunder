package com.xunlei.downloadprovider.search.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.xunlei.common.commonview.UnifiedLoadingView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.search.ui.search.ab;
import com.xunlei.downloadprovider.search.ui.search.af;
import com.xunlei.downloadprovider.search.ui.search.b;
import com.xunlei.downloadprovider.search.ui.search.o;

public class MultiSearchAssociativeView extends FrameLayout {
    public b a;
    public o b;
    public ab c;
    public af d;
    private ListView e;
    private UnifiedLoadingView f;

    public MultiSearchAssociativeView(Context context) {
        super(context);
        a();
    }

    public MultiSearchAssociativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public MultiSearchAssociativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }

    private void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.search_associative_result_fragment, (ViewGroup) getParent());
        ListView listView = (ListView) inflate.findViewById(R.id.pull_list);
        this.e = (ListView) inflate.findViewById(R.id.listview);
        this.f = (UnifiedLoadingView) inflate.findViewById(R.id.ul_loading_view);
        this.a = new b(this.f);
        this.d = new af();
        this.d.d = listView;
        this.d.e = this.e;
        this.b = new o(getContext(), this.d);
        this.e.setAdapter(this.b);
        addView(inflate);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return super.onKeyUp(i, keyEvent);
    }
}
