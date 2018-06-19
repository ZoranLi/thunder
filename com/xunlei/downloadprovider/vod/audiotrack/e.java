package com.xunlei.downloadprovider.vod.audiotrack;

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

/* compiled from: VodPlayerAudioTrackPopupWindow */
public final class e extends d {
    public a a;
    public b b;
    private ListView d;
    private TextView e;
    private int f = -100;

    /* compiled from: VodPlayerAudioTrackPopupWindow */
    private static class a extends BaseAdapter {
        public List<a> a;
        private final LayoutInflater b;
        private final Context c;

        public final long getItemId(int i) {
            return (long) i;
        }

        public final boolean hasStableIds() {
            return true;
        }

        public final boolean isEnabled(int i) {
            return true;
        }

        public final /* synthetic */ Object getItem(int i) {
            return a(i);
        }

        public a(Context context) {
            this.c = context;
            this.b = LayoutInflater.from(context);
        }

        public final int getCount() {
            if (this.a == null) {
                return 0;
            }
            return this.a.size();
        }

        public final a a(int i) {
            if (this.a != null) {
                if (i < this.a.size()) {
                    return (a) this.a.get(i);
                }
            }
            return 0;
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
                ((CheckBox) view).setText(i.c);
            }
            return view;
        }
    }

    /* compiled from: VodPlayerAudioTrackPopupWindow */
    public interface b {
        void a(a aVar, boolean z);
    }

    public e(Context context) {
        super(context);
        context = LayoutInflater.from(context).inflate(R.layout.vod_player_audiotrack_popuwindow, null);
        setContentView(context);
        this.d = (ListView) context.findViewById(R.id.list_view);
        this.a = new a(context.getContext());
        this.d.setAdapter(this.a);
        this.d.setChoiceMode(1);
        this.e = (TextView) context.findViewById(R.id.empty_view);
        this.d.setEmptyView(this.e);
        this.d.setOnItemClickListener(new f(this));
        context.setFocusable(true);
        context.setFocusableInTouchMode(true);
    }

    public final void a(View view) {
        super.showAtLocation(view, 5, 0, 0);
        view = this.d.getCheckedItemPosition();
        if (view != -1) {
            this.d.smoothScrollToPosition(view);
            this.f = view;
        }
    }

    public final void a(int i, boolean z) {
        int i2 = this.f;
        if (i == -1) {
            this.f = i;
            this.d.setItemChecked(i2, false);
            this.d.clearChoices();
            if (this.b != 0) {
                this.b.a(null, z ^ true);
            }
            return;
        }
        if (i >= 0) {
            if (i < this.a.getCount()) {
                this.f = i;
                if (z) {
                    this.d.setItemChecked(i, true);
                }
                if (this.b != null) {
                    this.b.a(this.a.a(i), z ^ true);
                }
            }
        }
    }
}
