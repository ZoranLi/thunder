package com.xunlei.downloadprovider.download.tasklist.list.feed.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.alibaba.wireless.security.SecExceptionCode;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: GotoTopBtnHelper */
public class a extends OnScrollListener {
    public static final String a = "a";
    public static a d;
    public Map<Integer, a> b = new HashMap();
    public View c;
    public int e;
    private boolean f = true;
    private int g = 8;

    /* compiled from: GotoTopBtnHelper */
    private class a {
        public ViewHolder a;
        public RecyclerView b;
        final /* synthetic */ a c;

        private a(a aVar) {
            this.c = aVar;
        }
    }

    private a() {
    }

    public final void a(boolean z) {
        this.f = z;
        if (this.c != null) {
            if (z) {
                this.c.setVisibility(this.g);
            } else {
                this.g = 8;
                this.c.setVisibility(8);
            }
        }
    }

    public static a a() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public final void a(View view) {
        this.c = view;
        if (this.c != null) {
            this.c.setVisibility(8);
            this.c.setOnClickListener(new b(this));
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        b();
    }

    public final void b() {
        a aVar = (a) this.b.get(Integer.valueOf(this.e));
        if (aVar != null && this.f) {
            int i;
            int i2;
            int i3;
            ViewHolder childViewHolder;
            StringBuilder stringBuilder;
            if (aVar.b != null) {
                if (aVar.a != null) {
                    i = 1;
                    if (i != 0) {
                        i = 0;
                        i2 = i;
                        i3 = i2;
                        while (i < aVar.b.getChildCount()) {
                            childViewHolder = aVar.b.getChildViewHolder(aVar.b.getChildAt(i));
                            if (childViewHolder == null) {
                                if (!(childViewHolder.getItemViewType() == 300 || childViewHolder.getItemViewType() == 301 || childViewHolder.getItemViewType() == 302 || childViewHolder.getItemViewType() == 305 || childViewHolder.getItemViewType() == 304 || childViewHolder.getItemViewType() == 307 || childViewHolder.getItemViewType() == 306 || childViewHolder.getItemViewType() == 308 || childViewHolder.getItemViewType() == 309 || childViewHolder.getItemViewType() == SecExceptionCode.SEC_ERROR_STA_INVALID_ENCRYPTED_DATA)) {
                                    if (childViewHolder.getItemViewType() != SecExceptionCode.SEC_ERROR_STA_DECRYPT_MISMATCH_KEY_DATA) {
                                        if (303 == childViewHolder.getItemViewType()) {
                                            i3 = 1;
                                        }
                                    }
                                }
                                stringBuilder = new StringBuilder("type match ");
                                stringBuilder.append(i);
                                stringBuilder.append(" hasFeedContent true");
                                i2 = 1;
                            }
                            i++;
                        }
                        if (aVar.c.c != null) {
                            if (i2 == 0 && r6 == 0) {
                                if (aVar.c.c.getVisibility() != 0) {
                                    aVar.c.c.setVisibility(0);
                                    b.a(aVar.c.e);
                                    return;
                                }
                            } else if (aVar.c.c.getVisibility() != 8) {
                                aVar.c.c.setVisibility(8);
                            }
                        }
                    } else if (aVar.c.c != null) {
                        aVar.c.c.setVisibility(8);
                    }
                }
            }
            i = 0;
            if (i != 0) {
                i = 0;
                i2 = i;
                i3 = i2;
                while (i < aVar.b.getChildCount()) {
                    childViewHolder = aVar.b.getChildViewHolder(aVar.b.getChildAt(i));
                    if (childViewHolder == null) {
                        if (childViewHolder.getItemViewType() != SecExceptionCode.SEC_ERROR_STA_DECRYPT_MISMATCH_KEY_DATA) {
                            stringBuilder = new StringBuilder("type match ");
                            stringBuilder.append(i);
                            stringBuilder.append(" hasFeedContent true");
                            i2 = 1;
                        } else if (303 == childViewHolder.getItemViewType()) {
                            i3 = 1;
                        }
                    }
                    i++;
                }
                if (aVar.c.c != null) {
                    if (i2 == 0) {
                    }
                    if (aVar.c.c.getVisibility() != 8) {
                        aVar.c.c.setVisibility(8);
                    }
                }
            } else if (aVar.c.c != null) {
                aVar.c.c.setVisibility(8);
            }
        }
    }
}
