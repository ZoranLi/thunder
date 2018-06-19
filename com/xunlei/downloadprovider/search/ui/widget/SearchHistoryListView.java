package com.xunlei.downloadprovider.search.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.BrowserFrom;
import java.util.ArrayList;

public class SearchHistoryListView extends ListView {
    public b a;
    public a b;
    public View c;
    public View d;
    private final int e = null;
    private final int f = 1;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static class c {
        public String a;
        public String b;
        public String c;
        public int d;
        public int e;
    }

    private class b extends com.xunlei.downloadprovider.c.a.a.a {
        ArrayList<c> a = new ArrayList();
        final /* synthetic */ SearchHistoryListView b;

        class a {
            TextView a;
            TextView b;
            TextView c;
            final /* synthetic */ b d;

            a(b bVar) {
                this.d = bVar;
            }
        }

        class b {
            TextView a;
            TextView b;
            final /* synthetic */ b c;

            b(b bVar) {
                this.c = bVar;
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public b(SearchHistoryListView searchHistoryListView) {
            this.b = searchHistoryListView;
        }

        public final int getCount() {
            return this.a.size();
        }

        public final Object getItem(int i) {
            return this.a.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar = (c) this.a.get(i);
            if (getItemViewType(i) != 0) {
                if (view == null) {
                    view = LayoutInflater.from(this.b.getContext()).inflate(R.layout.search_history_word_item_layout, this.b, false);
                    i = new a(this);
                    i.a = (TextView) view.findViewById(R.id.keyword_word);
                    i.b = (TextView) view.findViewById(R.id.keyword_suffix);
                    i.c = (TextView) view.findViewById(R.id.tv_search_type);
                    view.setTag(i);
                } else {
                    i = (a) view.getTag();
                }
                view.setOnClickListener(new l(this, cVar));
                if (cVar.a != null) {
                    if (!cVar.a.equals("")) {
                        i.a.setText(cVar.a);
                        i.b.setText(cVar.c);
                        i.b.setVisibility(0);
                        if (cVar.e != 1) {
                            i.c.setText("应用内搜索");
                        } else {
                            i.c.setText("全网搜索");
                        }
                    }
                }
                i.a.setText(cVar.c);
                i.b.setVisibility(8);
                if (cVar.e != 1) {
                    i.c.setText("全网搜索");
                } else {
                    i.c.setText("应用内搜索");
                }
            } else {
                if (view == null) {
                    view = LayoutInflater.from(this.b.getContext()).inflate(R.layout.search_history_website_item_layout, this.b, false);
                    i = new b(this);
                    i.a = (TextView) view.findViewById(R.id.keyword_word);
                    i.b = (TextView) view.findViewById(R.id.keyword_url);
                    view.setTag(i);
                } else {
                    i = (b) view.getTag();
                }
                view.setOnClickListener(new k(this, cVar));
                i.a.setText(cVar.a);
                i.b.setText(cVar.b);
            }
            return view;
        }

        public final int getItemViewType(int i) {
            if (this.a != null) {
                return ((c) this.a.get(i)).d == 0 ? 0 : 1;
            } else {
                return super.getItemViewType(i);
            }
        }

        static /* synthetic */ void a(b bVar, String str, String str2) {
            XLThreadPool.execute(new m(bVar, str, str2));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" ");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a(bVar.b.getContext(), 22, str.trim(), true, BrowserFrom.SEARCH_HIS);
        }
    }

    public SearchHistoryListView(Context context) {
        super(context);
    }

    public SearchHistoryListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SearchHistoryListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private static java.lang.String b(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r8 == 0) goto L_0x00d9;
    L_0x0002:
        r0 = r8.isEmpty();
        if (r0 == 0) goto L_0x000a;
    L_0x0008:
        goto L_0x00d9;
    L_0x000a:
        r0 = 0;
        r1 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0013 }
        r1.<init>(r7);	 Catch:{ MalformedURLException -> 0x0013 }
        r0 = r1;
        goto L_0x0088;
    L_0x0013:
        r1 = r8.keySet();
        r1 = r1.iterator();
    L_0x001b:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0088;
    L_0x0021:
        r2 = r1.next();
        r2 = (java.lang.String) r2;
        r3 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0083 }
        r3.<init>(r2);	 Catch:{ MalformedURLException -> 0x0083 }
        r4 = new java.lang.StringBuilder;	 Catch:{ MalformedURLException -> 0x0083 }
        r4.<init>();	 Catch:{ MalformedURLException -> 0x0083 }
        r5 = r3.getHost();	 Catch:{ MalformedURLException -> 0x0083 }
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x0083 }
        r5 = r3.getPath();	 Catch:{ MalformedURLException -> 0x0083 }
        if (r5 == 0) goto L_0x004f;	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x003e:
        r5 = r3.getPath();	 Catch:{ MalformedURLException -> 0x0083 }
        r6 = "/";	 Catch:{ MalformedURLException -> 0x0083 }
        r5 = r5.equals(r6);	 Catch:{ MalformedURLException -> 0x0083 }
        if (r5 != 0) goto L_0x004f;	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x004a:
        r5 = r3.getPath();	 Catch:{ MalformedURLException -> 0x0083 }
        goto L_0x0051;	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x004f:
        r5 = "";	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x0051:
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x0083 }
        r5 = r3.getQuery();	 Catch:{ MalformedURLException -> 0x0083 }
        if (r5 == 0) goto L_0x005d;	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x005a:
        r5 = "?";	 Catch:{ MalformedURLException -> 0x0083 }
        goto L_0x005f;	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x005d:
        r5 = "";	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x005f:
        r4.append(r5);	 Catch:{ MalformedURLException -> 0x0083 }
        r5 = r3.getQuery();	 Catch:{ MalformedURLException -> 0x0083 }
        if (r5 == 0) goto L_0x006d;	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x0068:
        r3 = r3.getQuery();	 Catch:{ MalformedURLException -> 0x0083 }
        goto L_0x006f;	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x006d:
        r3 = "";	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x006f:
        r4.append(r3);	 Catch:{ MalformedURLException -> 0x0083 }
        r3 = r4.toString();	 Catch:{ MalformedURLException -> 0x0083 }
        r3 = r3.equals(r7);	 Catch:{ MalformedURLException -> 0x0083 }
        if (r3 == 0) goto L_0x001b;	 Catch:{ MalformedURLException -> 0x0083 }
    L_0x007c:
        r2 = r8.get(r2);	 Catch:{ MalformedURLException -> 0x0083 }
        r2 = (java.lang.String) r2;	 Catch:{ MalformedURLException -> 0x0083 }
        return r2;
    L_0x0083:
        r2 = move-exception;
        r2.printStackTrace();
        goto L_0x001b;
    L_0x0088:
        if (r0 == 0) goto L_0x00d8;
    L_0x008a:
        r1 = r8.keySet();	 Catch:{ MalformedURLException -> 0x00d4 }
        r1 = r1.iterator();	 Catch:{ MalformedURLException -> 0x00d4 }
    L_0x0092:
        r2 = r1.hasNext();	 Catch:{ MalformedURLException -> 0x00d4 }
        if (r2 == 0) goto L_0x00d8;	 Catch:{ MalformedURLException -> 0x00d4 }
    L_0x0098:
        r2 = r1.next();	 Catch:{ MalformedURLException -> 0x00d4 }
        r2 = (java.lang.String) r2;	 Catch:{ MalformedURLException -> 0x00d4 }
        r3 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00d4 }
        r3.<init>(r2);	 Catch:{ MalformedURLException -> 0x00d4 }
        r4 = r3.getProtocol();	 Catch:{ MalformedURLException -> 0x00d4 }
        r5 = r0.getProtocol();	 Catch:{ MalformedURLException -> 0x00d4 }
        r4 = android.text.TextUtils.equals(r4, r5);	 Catch:{ MalformedURLException -> 0x00d4 }
        if (r4 == 0) goto L_0x0092;	 Catch:{ MalformedURLException -> 0x00d4 }
    L_0x00b1:
        r4 = r3.getHost();	 Catch:{ MalformedURLException -> 0x00d4 }
        r5 = r0.getHost();	 Catch:{ MalformedURLException -> 0x00d4 }
        r4 = android.text.TextUtils.equals(r4, r5);	 Catch:{ MalformedURLException -> 0x00d4 }
        if (r4 == 0) goto L_0x0092;	 Catch:{ MalformedURLException -> 0x00d4 }
    L_0x00bf:
        r3 = r3.getQuery();	 Catch:{ MalformedURLException -> 0x00d4 }
        r4 = r0.getQuery();	 Catch:{ MalformedURLException -> 0x00d4 }
        r3 = android.text.TextUtils.equals(r3, r4);	 Catch:{ MalformedURLException -> 0x00d4 }
        if (r3 == 0) goto L_0x0092;	 Catch:{ MalformedURLException -> 0x00d4 }
    L_0x00cd:
        r8 = r8.get(r2);	 Catch:{ MalformedURLException -> 0x00d4 }
        r8 = (java.lang.String) r8;	 Catch:{ MalformedURLException -> 0x00d4 }
        return r8;
    L_0x00d4:
        r8 = move-exception;
        r8.printStackTrace();
    L_0x00d8:
        return r7;
    L_0x00d9:
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.search.ui.widget.SearchHistoryListView.b(java.lang.String, java.util.Map):java.lang.String");
    }

    static /* synthetic */ void a(SearchHistoryListView searchHistoryListView) {
        searchHistoryListView.c.setVisibility(8);
        searchHistoryListView.d.setVisibility(8);
        XLThreadPool.execute(new i(searchHistoryListView));
        com.xunlei.downloadprovider.search.c.a.a("histroy", "delete", "", "", "", "");
    }
}
