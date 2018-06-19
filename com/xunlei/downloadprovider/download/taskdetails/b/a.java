package com.xunlei.downloadprovider.download.taskdetails.b;

import android.content.Context;
import android.support.annotation.NonNull;
import com.xunlei.downloadprovider.download.taskdetails.ag;
import com.xunlei.downloadprovider.shortvideo.videodetail.a.ap;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.aw;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TaskCommentAdapter */
public final class a {
    public ap a;
    public List<com.xunlei.downloadprovider.download.taskdetails.items.a.a> b;
    private ag c;

    private a(Context context) {
        this.a = new ap(context, null);
    }

    public a(Context context, ag agVar) {
        this(context);
        this.c = agVar;
    }

    public final void a(ArrayList<aw> arrayList) {
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                if (this.b == null) {
                    this.b = new ArrayList();
                }
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    this.b.add(d((aw) arrayList.get(i)));
                }
                this.c.notifyDataSetChanged();
            }
        }
    }

    @NonNull
    private static com.xunlei.downloadprovider.download.taskdetails.items.a.a d(aw awVar) {
        return new com.xunlei.downloadprovider.download.taskdetails.items.a.a(awVar.a + 110, null, awVar, 0);
    }

    public final void a(aw awVar) {
        if (this.b != null) {
            if (this.b.size() != 0) {
                int i = -1;
                for (int i2 = 0; i2 < this.b.size(); i2++) {
                    if (((com.xunlei.downloadprovider.download.taskdetails.items.a.a) this.b.get(i2)).c == awVar) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0 && this.b != null) {
                    if (i <= this.b.size() - 1) {
                        this.b.remove(i);
                        this.c.notifyItemRemoved(this.c.d() + i);
                    }
                }
            }
        }
    }

    public final void b(aw awVar) {
        if (this.b != null) {
            if (awVar != null) {
                int i = -1;
                int a = a();
                for (int i2 = 0; i2 < a; i2++) {
                    if (((com.xunlei.downloadprovider.download.taskdetails.items.a.a) this.b.get(i2)).c == awVar) {
                        i = i2;
                        break;
                    }
                }
                if (i >= 0) {
                    this.c.notifyItemChanged(i + this.c.d());
                }
            }
        }
    }

    public final void a(int i, aw awVar) {
        if (awVar != null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (i >= this.b.size()) {
                this.b.add(d(awVar));
                this.c.notifyItemInserted(this.b.size() + this.c.d());
                return;
            }
            this.b.add(i, d(awVar));
            this.c.notifyItemInserted(i + this.c.d());
        }
    }

    public final int a() {
        return this.b != null ? this.b.size() : 0;
    }

    public final void c(aw awVar) {
        if (awVar != null) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(d(awVar));
            this.c.notifyItemInserted((this.c.d() + this.b.size()) - 1);
        }
    }

    public final void b(ArrayList<aw> arrayList) {
        if (this.b != null) {
            this.b.clear();
        }
        a((ArrayList) arrayList);
    }

    public final void b() {
        if (this.b != null) {
            this.b.clear();
            this.c.notifyDataSetChanged();
        }
    }
}
