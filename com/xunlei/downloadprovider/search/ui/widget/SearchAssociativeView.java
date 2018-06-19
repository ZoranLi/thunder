package com.xunlei.downloadprovider.search.ui.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.bugly.crashreport.CrashReport;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.d.m;
import com.xunlei.downloadprovider.h.k.a;
import com.xunlei.downloadprovider.search.b.c;
import com.xunlei.downloadprovider.search.ui.search.al;
import com.xunlei.downloadprovider.search.ui.search.al.d;
import com.xunlei.downloadprovider.web.website.b.e;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class SearchAssociativeView extends FrameLayout {
    public al a;
    public d b;
    public String c = "";
    private View d;
    private ListView e;
    private View f;
    private View g;
    private TextView h;

    public SearchAssociativeView(Context context) {
        super(context);
        a(context);
    }

    public SearchAssociativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SearchAssociativeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.d = LayoutInflater.from(context).inflate(R.layout.search_associative_fragment, (ViewGroup) getParent());
        this.e = (ListView) this.d.findViewById(R.id.listview);
        context = LayoutInflater.from(getContext()).inflate(R.layout.associate_head_item_layout, this.e, false);
        this.g = context.findViewById(R.id.search_associative_title_tv);
        this.e.addHeaderView(context);
        context = LayoutInflater.from(getContext()).inflate(R.layout.associate_item_layout, this.e, false);
        this.f = context.findViewById(R.id.search_associative_container);
        this.b = new d();
        this.b.a = (TextView) this.f.findViewById(R.id.keyword);
        this.b.b = (TextView) this.f.findViewById(R.id.keyword_suffix);
        this.e.addHeaderView(context);
        context.setOnClickListener(new d(this));
        context = LayoutInflater.from(getContext()).inflate(R.layout.associate_third_item_layout, this.e, false);
        this.h = (TextView) context.findViewById(R.id.quangwang_title);
        this.e.addHeaderView(context);
        this.e.addFooterView(new View(getContext()), null, false);
        this.a = new al(getContext());
        this.e.setAdapter(this.a);
        if (this.b != null) {
            a(this.b.a, this.b.b, this.c);
        }
        addView(this.d);
    }

    public final void a(TextView textView, TextView textView2, String str) {
        if (!(this.f == null || this.b == null || textView2 == null)) {
            if (textView != null) {
                if (TextUtils.isEmpty(str)) {
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                    this.e.setHeaderDividersEnabled(false);
                } else if (a.d(str)) {
                    this.f.setVisibility(8);
                    this.g.setVisibility(8);
                    this.h.setText("访问网站");
                    this.e.requestLayout();
                } else {
                    al.a(textView, str, str);
                    textView2.setVisibility(8);
                    this.f.setVisibility(0);
                    this.g.setVisibility(0);
                    this.h.setText("全网搜索");
                    this.e.requestLayout();
                    this.e.setHeaderDividersEnabled(true);
                }
            }
        }
    }

    private List<com.xunlei.downloadprovider.search.a.a> a(String str, List<com.xunlei.downloadprovider.search.a.a> list) {
        List<com.xunlei.downloadprovider.search.a.a> arrayList;
        if (com.xunlei.xllib.b.d.a(list)) {
            list = new com.xunlei.downloadprovider.search.a.a();
            list.b = str;
            arrayList = new ArrayList();
            arrayList.add(list);
            list = arrayList;
        }
        arrayList = new ArrayList();
        ArrayList b = m.a().b();
        if (b.isEmpty()) {
            return list;
        }
        try {
            int size = b.size();
            Random random = new Random();
            for (com.xunlei.downloadprovider.search.a.a aVar : list) {
                if (aVar != null) {
                    if (!a.d(aVar.b)) {
                        String str2 = (String) b.get(random.nextInt(size));
                        StringBuilder stringBuilder = new StringBuilder("title --> ");
                        stringBuilder.append(aVar.b);
                        stringBuilder.append(", suffix --> ");
                        stringBuilder.append(str2);
                        stringBuilder.append(", title1 --> ");
                        stringBuilder.append(this.b.a.getText());
                        stringBuilder.append(", suffix1 --> ");
                        stringBuilder.append(this.b.b.getText());
                        stringBuilder.append(", match_result --> ");
                        boolean z = aVar.b.equals(this.b.a.getText().toString()) && str2.equals(this.b.b.getText().toString());
                        stringBuilder.append(z);
                        aVar.m = str2;
                    }
                    arrayList.add(aVar);
                }
            }
        } catch (List<com.xunlei.downloadprovider.search.a.a> list2) {
            CrashReport.postCatchedException(list2);
            list2.printStackTrace();
        }
        b(str, arrayList);
        return arrayList;
    }

    private static void b(String str, List<com.xunlei.downloadprovider.search.a.a> list) {
        if (!TextUtils.isEmpty(str)) {
            int i;
            com.xunlei.downloadprovider.search.a.a aVar;
            Set hashSet = new HashSet();
            if (!com.xunlei.xllib.b.d.a(c.a().a)) {
                i = 0;
                for (SearchHistoryListView.c cVar : c.a().a) {
                    if (a(cVar.a, str) || (!TextUtils.isEmpty(cVar.b) && a(cVar.b, str))) {
                        i++;
                        aVar = new com.xunlei.downloadprovider.search.a.a();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(cVar.a);
                        stringBuilder.append(" ");
                        stringBuilder.append(cVar.c);
                        aVar.b = stringBuilder.toString();
                        if (a.d(cVar.a) || !TextUtils.isEmpty(cVar.b)) {
                            aVar.n = 3;
                            hashSet.add(cVar.b);
                        } else {
                            aVar.n = 1;
                        }
                        aVar.o = cVar;
                        if (list.size() > 0) {
                            list.add(1, aVar);
                            continue;
                        } else {
                            list.add(0, aVar);
                            continue;
                        }
                    }
                    if (i >= 2) {
                        break;
                    }
                }
            }
            i = 0;
            Object<e> a = com.xunlei.downloadprovider.web.website.c.a.a();
            if (!com.xunlei.xllib.b.d.a(a)) {
                for (e eVar : a) {
                    if ((a(eVar.a(), str) || a(eVar.b(), str)) && !a(hashSet, eVar.a())) {
                        i++;
                        aVar = new com.xunlei.downloadprovider.search.a.a();
                        aVar.b = eVar.a();
                        aVar.n = 2;
                        aVar.p = eVar;
                        if (list.size() > 0) {
                            list.add(1, aVar);
                            continue;
                        } else {
                            list.add(0, aVar);
                            continue;
                        }
                    }
                    if (i >= 2) {
                        break;
                    }
                }
            }
        }
    }

    private static boolean a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                return str.toLowerCase().contains(str2.toLowerCase());
            }
        }
        return null;
    }

    private static boolean a(Set<String> set, String str) {
        for (String str2 : set) {
            if (str2.equals(str)) {
                return true;
            }
            try {
                URL url = new URL(str);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(url.getHost());
                String path = (url.getPath() == null || url.getPath().equals("/")) ? "" : url.getPath();
                stringBuilder.append(path);
                stringBuilder.append(url.getQuery() != null ? "?" : "");
                stringBuilder.append(url.getQuery() != null ? url.getQuery() : "");
                if (stringBuilder.toString().equals(str2)) {
                    return true;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
