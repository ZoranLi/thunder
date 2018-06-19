package com.xunlei.downloadprovider.publiser.websitetopic;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.frame.BasePageFragment;
import com.xunlei.downloadprovider.publiser.websitetopic.a.a;
import com.xunlei.downloadprovider.publiser.websitetopic.c.c;
import com.xunlei.downloadprovider.publiser.websitetopic.c.d;
import com.xunlei.downloadprovider.publiser.websitetopic.c.e;
import com.xunlei.xllib.android.b;
import java.util.ArrayList;
import java.util.Collection;

public class WebsiteTopicFragment extends BasePageFragment {
    a a;
    private d b = new d();
    private a c;
    private c d;
    private String e;
    private String f = "0";
    private boolean g = true;
    private boolean h;

    public static WebsiteTopicFragment a(String str) {
        WebsiteTopicFragment websiteTopicFragment = new WebsiteTopicFragment();
        Bundle bundle = new Bundle();
        bundle.putString("website_topic_id", str);
        websiteTopicFragment.setArguments(bundle);
        return websiteTopicFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.e = getArguments().getString("website_topic_id");
        }
        this.d = new c(2);
    }

    protected View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(R.layout.fragment_website_topic, viewGroup, false);
        RecyclerView recyclerView = (RecyclerView) layoutInflater.findViewById(R.id.rv_website_topic);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.c = new a();
        recyclerView.setAdapter(this.c);
        recyclerView.addOnScrollListener(new e(this));
        a(false);
        return layoutInflater;
    }

    final void a(boolean z) {
        XLThreadPool.execute(new e(this.b, this.f, this.e, new f(this, z)));
    }

    static /* synthetic */ boolean b(WebsiteTopicFragment websiteTopicFragment) {
        return (websiteTopicFragment.g && websiteTopicFragment.h == null) ? true : null;
    }

    static /* synthetic */ void c(WebsiteTopicFragment websiteTopicFragment) {
        if (b.a(BrothersApplication.getApplicationInstance()) && !websiteTopicFragment.h) {
            a aVar = websiteTopicFragment.c;
            c cVar = websiteTopicFragment.d;
            if (!(cVar == null || aVar.b.contains(cVar))) {
                Collection arrayList = new ArrayList();
                arrayList.add(cVar);
                aVar.b.addAll(arrayList);
                aVar.notifyDataSetChanged();
            }
            websiteTopicFragment.a(true);
            websiteTopicFragment.h = true;
        }
    }

    static /* synthetic */ void e(WebsiteTopicFragment websiteTopicFragment) {
        a aVar = websiteTopicFragment.c;
        websiteTopicFragment = websiteTopicFragment.d;
        if (websiteTopicFragment != null) {
            aVar.b.remove(websiteTopicFragment);
            aVar.notifyDataSetChanged();
        }
    }
}
