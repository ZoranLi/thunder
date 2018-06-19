package com.android.volley.toolbox;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.o.c;
import com.android.volley.toolbox.o.d;

/* compiled from: NetworkImageView */
final class w implements d {
    final /* synthetic */ boolean a = true;
    final /* synthetic */ NetworkImageView b;

    w(NetworkImageView networkImageView) {
        this.b = networkImageView;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        if (this.b.c != null) {
            this.b.setImageResource(this.b.c);
        }
    }

    public final void a(c cVar, boolean z) {
        if (z && this.a) {
            this.b.post(new x(this, cVar));
        } else if (cVar.a) {
            this.b.setImageBitmap(cVar.a);
        } else {
            if (this.b.b != null) {
                this.b.setImageResource(this.b.b);
            }
        }
    }
}
