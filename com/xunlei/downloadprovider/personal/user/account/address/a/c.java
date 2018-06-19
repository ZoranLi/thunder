package com.xunlei.downloadprovider.personal.user.account.address.a;

import android.content.Context;
import android.support.v4.view.InputDeviceCompat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RecyclerBaseAdapter */
public abstract class c<M, VH extends d> extends a<M, VH> {
    protected List<M> e = new ArrayList();

    public abstract int a();

    public abstract int b(int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public c(Context context) {
        super(context);
    }

    public c(Context context, List<M> list) {
        super(context);
        this.e.addAll(list);
    }

    public final boolean a(List<M> list) {
        this.e.clear();
        list = this.e.addAll(list);
        if (list != null) {
            notifyDataSetChanged();
        }
        return list;
    }

    public int getItemViewType(int i) {
        if (this.a != null && i == 0) {
            return 1024;
        }
        if (this.b == null || i != this.e.size() + c()) {
            return b(i);
        }
        return InputDeviceCompat.SOURCE_GAMEPAD;
    }

    public int getItemCount() {
        return (this.e.size() + b()) + a();
    }

    public final M c(int i) {
        if ((this.a != null && i == 0) || i >= this.e.size() + c()) {
            return null;
        }
        List list;
        if (this.a == null) {
            list = this.e;
        } else {
            list = this.e;
            i--;
        }
        return list.get(i);
    }

    public final boolean d() {
        if (this.e != null) {
            if (!this.e.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
