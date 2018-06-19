package com.xunlei.downloadprovider.web.browser;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.sdk.app.statistic.c;
import com.qihoo360.replugin.RePlugin;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.website.b.d;
import com.xunlei.downloadprovider.web.website.b.e;
import java.util.ArrayList;
import java.util.Iterator;

public class InputAutoCompleteView extends LinearLayout {
    static final String[] a = new String[]{"wap", "www", "http://", "https://"};
    static final String[] b = new String[]{"com", "com.cn", "cn", "edu.cn", c.a, "org"};
    static final String[] c = new String[]{"apk", "avi", "mp4", "mp3", "rmvb", "rm", "mpg", "mpeg", "html"};
    private static final String m = "InputAutoCompleteView";
    ArrayList<d> d = new ArrayList();
    ArrayList<d> e = new ArrayList();
    ArrayList<String> f;
    a g = null;
    Context h = null;
    View i;
    EditText j;
    ListView k;
    ArrayList<d> l = new ArrayList();
    private b n;

    public interface b {
        void a();

        void a(String str, boolean z);
    }

    private class a extends com.xunlei.downloadprovider.c.a.a.a {
        final /* synthetic */ InputAutoCompleteView a;
        private LayoutInflater b;

        public class a {
            public TextView a;
            public TextView b;
            public TextView c;
            public ImageView d;
            final /* synthetic */ a e;

            public a(a aVar) {
                this.e = aVar;
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final /* synthetic */ Object getItem(int i) {
            return a(i);
        }

        public a(InputAutoCompleteView inputAutoCompleteView, Context context) {
            this.a = inputAutoCompleteView;
            this.b = LayoutInflater.from(context);
        }

        public final int getCount() {
            return !com.xunlei.xllib.b.d.a(this.a.e) ? this.a.e.size() : 0;
        }

        private e a(int i) {
            return (com.xunlei.xllib.b.d.a(this.a.e) || i < 0 || i >= this.a.e.size()) ? 0 : (d) this.a.e.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.b.inflate(R.layout.autocomplete_list_item, null);
                viewGroup = new a(this);
                viewGroup.a = (TextView) view.findViewById(R.id.url);
                viewGroup.c = (TextView) view.findViewById(R.id.name);
                viewGroup.b = (TextView) view.findViewById(R.id.auto_complete);
                viewGroup.d = (ImageView) view.findViewById(R.id.website_delete);
                view.setTag(viewGroup);
            } else {
                viewGroup = (a) view.getTag();
            }
            e a = a(i);
            if (a != null) {
                int i2 = 8;
                viewGroup.b.setVisibility(a.b().equals(RePlugin.PROCESS_UI) ? 0 : 8);
                viewGroup.c.setVisibility(a.b().equals(RePlugin.PROCESS_UI) ? 8 : 0);
                TextView textView = viewGroup.a;
                if (!a.b().equals(RePlugin.PROCESS_UI)) {
                    i2 = 0;
                }
                textView.setVisibility(i2);
                if (a.b().equals(RePlugin.PROCESS_UI)) {
                    viewGroup.b.setText(a(i).a());
                } else {
                    viewGroup.c.setText(a.b());
                    viewGroup.a.setText(a(i).a());
                }
                viewGroup.d.setVisibility(0);
                viewGroup.d.setOnClickListener(new aw(this, a));
                view.setOnClickListener(new ax(this, a));
            }
            return view;
        }

        static /* synthetic */ void a(a aVar, e eVar) {
            if (eVar != null) {
                aVar.a.e.remove(eVar);
                Object obj = null;
                Iterator it = aVar.a.d.iterator();
                while (it.hasNext()) {
                    e eVar2 = (e) it.next();
                    if (eVar2.b().equalsIgnoreCase(eVar.b())) {
                        obj = eVar2;
                        break;
                    }
                }
                if (obj != null) {
                    aVar.a.d.remove(obj);
                    com.xunlei.downloadprovider.web.website.g.b.a().a(eVar.a(), new av(aVar));
                }
                aVar.notifyDataSetChanged();
            }
        }
    }

    public InputAutoCompleteView(Context context) {
        super(context);
        this.h = context;
    }

    public InputAutoCompleteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = context;
    }

    public void setUIClient(b bVar) {
        this.n = bVar;
    }

    public final void a() {
        XLThreadPool.execute(new au(this));
    }

    public void setViewHeight(boolean z) {
        float f = getResources().getDisplayMetrics().density;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.common_title_height);
        if (z) {
            layoutParams.setMargins(0, 0, 0, (int) (true * f));
        } else {
            layoutParams.setMargins(0, dimensionPixelOffset, 0, 0);
        }
        this.i.setLayoutParams(layoutParams);
    }
}
