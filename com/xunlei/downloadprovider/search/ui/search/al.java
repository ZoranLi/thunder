package com.xunlei.downloadprovider.search.ui.search;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.BrowserFrom;
import java.util.List;

/* compiled from: SearchAssociativeAdapter */
public final class al extends com.xunlei.downloadprovider.search.ui.a.a<com.xunlei.downloadprovider.search.a.a> {
    private String a;

    /* compiled from: SearchAssociativeAdapter */
    private class a {
        TextView a;
        TextView b;
        final /* synthetic */ al c;

        private a(al alVar) {
            this.c = alVar;
        }
    }

    /* compiled from: SearchAssociativeAdapter */
    private class b {
        TextView a;
        TextView b;
        final /* synthetic */ al c;

        private b(al alVar) {
            this.c = alVar;
        }
    }

    /* compiled from: SearchAssociativeAdapter */
    private class c {
        TextView a;
        TextView b;
        TextView c;
        final /* synthetic */ al d;

        private c(al alVar) {
            this.d = alVar;
        }
    }

    /* compiled from: SearchAssociativeAdapter */
    public static class d {
        public TextView a;
        public TextView b;
    }

    public final int getViewTypeCount() {
        return 4;
    }

    public al(Context context) {
        super(context);
    }

    public final void a(String str, List<com.xunlei.downloadprovider.search.a.a> list) {
        this.a = str;
        super.a(list);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                if (view == null) {
                    view = LayoutInflater.from(this.d).inflate(R.layout.search_associate_hs_word_item_layout, viewGroup, false);
                    viewGroup = new c();
                    viewGroup.a = (TextView) view.findViewById(R.id.keyword_word);
                    viewGroup.b = (TextView) view.findViewById(R.id.keyword_suffix);
                    viewGroup.c = (TextView) view.findViewById(R.id.tv_search_type);
                    view.setTag(viewGroup);
                } else {
                    viewGroup = (c) view.getTag();
                }
                i = ((com.xunlei.downloadprovider.search.a.a) getItem(i)).o;
                view.setOnClickListener(new ao(this, i));
                if (i.a != null) {
                    if (!i.a.equals("")) {
                        a(viewGroup.a, i.a);
                        viewGroup.b.setText(i.c);
                        viewGroup.b.setVisibility(0);
                        if (i.e != 1) {
                            viewGroup.c.setText("应用内搜索");
                        } else {
                            viewGroup.c.setText("全网搜索");
                        }
                        return view;
                    }
                }
                a(viewGroup.a, i.c);
                viewGroup.b.setVisibility(8);
                if (i.e != 1) {
                    viewGroup.c.setText("全网搜索");
                } else {
                    viewGroup.c.setText("应用内搜索");
                }
                return view;
            case 1:
                i = ((com.xunlei.downloadprovider.search.a.a) getItem(i)).o;
                if (view == null) {
                    view = LayoutInflater.from(this.d).inflate(R.layout.search_history_associate_website_item_layout, viewGroup, false);
                    viewGroup = new b();
                    viewGroup.a = (TextView) view.findViewById(R.id.keyword_word);
                    viewGroup.b = (TextView) view.findViewById(R.id.keyword_url);
                    view.setTag(viewGroup);
                } else {
                    viewGroup = (b) view.getTag();
                }
                a(viewGroup.a, i.a);
                a(viewGroup.b, i.b);
                view.setOnClickListener(new an(this, i));
                return view;
            case 2:
                com.xunlei.downloadprovider.search.a.a aVar = (com.xunlei.downloadprovider.search.a.a) getItem(i);
                if (view == null) {
                    view = LayoutInflater.from(this.d).inflate(R.layout.search_assosiate_collect_item_layout, viewGroup, false);
                    viewGroup = new a();
                    viewGroup.a = (TextView) view.findViewById(R.id.keyword_word);
                    viewGroup.b = (TextView) view.findViewById(R.id.keyword_url);
                    view.setTag(viewGroup);
                } else {
                    viewGroup = (a) view.getTag();
                }
                view.setOnClickListener(new am(this, aVar));
                a(viewGroup.a, aVar.p.b());
                a(viewGroup.b, aVar.p.a());
                return view;
            case 3:
                return a(i, view, viewGroup);
            default:
                return a(i, view, viewGroup);
        }
    }

    public final int getItemViewType(int i) {
        switch (((com.xunlei.downloadprovider.search.a.a) getItem(i)).n) {
            case 0:
                return 3;
            case 1:
                return 0;
            case 2:
                return 2;
            case 3:
                return 1;
            default:
                return 3;
        }
    }

    private void a(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setText("");
        } else if (TextUtils.isEmpty(this.a)) {
            textView.setText(str);
        } else {
            int indexOf = str.toLowerCase().indexOf(this.a.toLowerCase());
            if (indexOf < 0) {
                textView.setText(str);
                return;
            }
            CharSequence spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#1aa3ff")), indexOf, this.a.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    public static void a(TextView textView, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            textView.setText("");
        } else if (TextUtils.isEmpty(str)) {
            textView.setText(str2);
        } else {
            int indexOf = str2.toLowerCase().indexOf(str.toLowerCase());
            if (indexOf < 0) {
                textView.setText(str2);
                return;
            }
            CharSequence spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#1aa3ff")), indexOf, str.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    private View a(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        if (view == null) {
            view = LayoutInflater.from(this.d).inflate(R.layout.associate_item_layout, viewGroup, false);
            viewGroup = new d();
            viewGroup.a = (TextView) view.findViewById(R.id.keyword);
            viewGroup.b = (TextView) view.findViewById(R.id.keyword_suffix);
            view.setTag(viewGroup);
        } else {
            viewGroup = (d) view.getTag();
        }
        com.xunlei.downloadprovider.search.a.a aVar = (com.xunlei.downloadprovider.search.a.a) getItem(i);
        a(viewGroup.a, aVar.b);
        CharSequence charSequence = aVar.m;
        viewGroup.a.setMaxWidth(DipPixelUtil.dip2px(260.0f));
        TextView textView = viewGroup.b;
        if (TextUtils.isEmpty(charSequence)) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (TextUtils.isEmpty(charSequence)) {
            viewGroup.a.setMaxWidth(DipPixelUtil.dip2px(2.14748365E9f));
        } else {
            viewGroup.b.setText(charSequence);
        }
        view.setOnClickListener(new aq(this, aVar));
        return view;
    }

    static /* synthetic */ void a(al alVar, String str, String str2, BrowserFrom browserFrom) {
        XLThreadPool.execute(new ap(alVar, str, str2));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" ");
        stringBuilder.append(str2);
        str = stringBuilder.toString();
        com.xunlei.downloadprovider.web.a.a();
        com.xunlei.downloadprovider.web.a.a(alVar.d, 22, str.trim(), false, browserFrom);
    }
}
