package com.xunlei.downloadprovider.vod.subtitle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.vod.player.d;
import java.util.List;

/* compiled from: VodPlayerSubtitlePopupWindow */
public final class u extends d {
    public b a;
    public a b;
    private ListView d;
    private View e;
    private TextView f;
    private int g = -100;
    private View h;

    /* compiled from: VodPlayerSubtitlePopupWindow */
    public interface a {
        void a();

        void a(int i, SubtitleInfo subtitleInfo, boolean z);

        void b();
    }

    /* compiled from: VodPlayerSubtitlePopupWindow */
    private static class b extends BaseAdapter {
        public List<SubtitleInfo> a;
        private final LayoutInflater b;
        private final Context c;

        public final boolean hasStableIds() {
            return true;
        }

        public final boolean isEnabled(int i) {
            return true;
        }

        public final /* synthetic */ Object getItem(int i) {
            return a(i);
        }

        public b(Context context) {
            this.c = context;
            this.b = LayoutInflater.from(context);
        }

        public final int getCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.size();
        }

        public final SubtitleInfo a(int i) {
            if (this.a != null) {
                if (i < this.a.size()) {
                    return (SubtitleInfo) this.a.get(i);
                }
            }
            return 0;
        }

        public final long getItemId(int i) {
            if (a(i) == null) {
                return 0;
            }
            return a(i).getId();
        }

        public final boolean isEmpty() {
            return getCount() == 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null || (view instanceof CheckBox) == null) {
                view = LayoutInflater.from(this.c).inflate(R.layout.layout_subtitle_item, null);
                view.setLayoutParams(new LayoutParams(-1, DipPixelUtil.dip2px(50.0f)));
            }
            i = a(i);
            if (i != 0) {
                ((CheckBox) view).setText(i.getUiDisplayName());
            }
            return view;
        }
    }

    public u(Context context) {
        super(context);
        context = LayoutInflater.from(context).inflate(R.layout.vod_player_subtitle_popuwindow, null);
        setContentView(context);
        this.e = context.findViewById(R.id.tv_local_file);
        this.e.setOnClickListener(new v(this));
        this.d = (ListView) context.findViewById(R.id.list_subtitle);
        this.a = new b(context.getContext());
        this.d.setAdapter(this.a);
        this.d.setChoiceMode(1);
        this.f = (TextView) context.findViewById(R.id.lyt_empty);
        this.d.setEmptyView(this.f);
        this.d.setOnItemClickListener(new w(this));
        this.h = context.findViewById(R.id.tv_subtitle_adjust);
        this.h.setEnabled(false);
        this.h.setOnClickListener(new x(this));
        context.setFocusable(true);
        context.setFocusableInTouchMode(true);
    }

    public final void a(View view) {
        super.showAtLocation(view, 5, 0, 0);
        view = this.d.getCheckedItemPosition();
        this.d.setAdapter(this.a);
        if (view != -1) {
            this.d.clearChoices();
            this.d.setItemChecked(view, true);
            this.d.smoothScrollToPosition(view);
            this.g = view;
        }
    }

    public final void a(int i, boolean z) {
        int i2 = this.g;
        if (i == -1) {
            this.g = i;
            this.d.setItemChecked(i2, false);
            this.d.clearChoices();
            this.h.setEnabled(false);
            if (this.b != null) {
                this.b.a(i, null, z ^ true);
            }
            return;
        }
        if (i >= 0) {
            if (i < this.a.getCount()) {
                this.g = i;
                if (z) {
                    this.d.setItemChecked(i, true);
                }
                this.h.setEnabled(true);
                if (this.b != null) {
                    this.b.a(i, this.a.a(i), z ^ true);
                }
            }
        }
    }
}
