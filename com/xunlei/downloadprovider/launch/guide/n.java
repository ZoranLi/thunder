package com.xunlei.downloadprovider.launch.guide;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.launch.guide.b.h;
import com.xunlei.downloadprovider.launch.guide.p.a;
import com.xunlei.downloadprovider.launch.guide.p.b;
import com.xunlei.downloadprovider.xlui.widget.extendviewpager.e;

/* compiled from: GuideViewPagerAdapter */
public class n extends e {
    private static final String c = "n";
    private final Context d;
    private final b e;
    private final a f;

    public final int a() {
        return 2;
    }

    public n(Context context, b bVar, a aVar) {
        this.d = context;
        this.e = bVar;
        this.f = aVar;
    }

    public final int a(int i) {
        switch (b(i)) {
            case 0:
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return -1;
        }
    }

    public final View a(int i, View view) {
        int b = b(i);
        int a = a(i);
        if (view == null) {
            switch (a) {
                case 0:
                    view = new h(this.d, this.f);
                    break;
                case 1:
                    view = new com.xunlei.downloadprovider.launch.guide.b.e(this.d, this.f);
                    break;
                default:
                    break;
            }
        }
        if (view instanceof com.xunlei.downloadprovider.launch.guide.b.a) {
            com.xunlei.downloadprovider.launch.guide.b.a aVar = (com.xunlei.downloadprovider.launch.guide.b.a) view;
            aVar.setItemTag(b);
            aVar.a(b);
        }
        StringBuilder stringBuilder = new StringBuilder("getView position: ");
        stringBuilder.append(i);
        stringBuilder.append(" realPosition: ");
        stringBuilder.append(b);
        stringBuilder.append(" viewType: ");
        stringBuilder.append(a);
        stringBuilder.append(" convertView: ");
        stringBuilder.append(view == null ? "null" : view.getClass().getSimpleName());
        return view;
    }

    public final int b() {
        return m.d;
    }

    public int getItemPosition(Object obj) {
        if ((obj instanceof com.xunlei.downloadprovider.launch.guide.b.a) && ((com.xunlei.downloadprovider.launch.guide.b.a) obj).getItemTag() == 2) {
            return -2;
        }
        return super.getItemPosition(obj);
    }
}
