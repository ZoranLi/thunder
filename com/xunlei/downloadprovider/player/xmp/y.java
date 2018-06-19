package com.xunlei.downloadprovider.player.xmp;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView.ScaleType;
import com.xunlei.downloadprovider.shortvideo.entity.LiveExtra;
import java.lang.ref.WeakReference;

/* compiled from: VideoInfo */
public final class y {
    public String a;
    String b;
    public String c;
    public String d;
    public int e;
    public String f;
    public boolean g;
    public boolean h;
    int i;
    String j;
    public String k;
    String l;
    String m;
    public String n;
    public String o;
    public ScaleType p;
    public boolean q;
    public long r;
    public boolean s;
    public LiveExtra t;
    int u;
    private WeakReference<Drawable> v;

    public y(String str, String str2, String str3) {
        this(str, str2, str3, null);
    }

    public y(String str, String str2, String str3, String str4) {
        this.h = true;
        this.p = ScaleType.FIT_CENTER;
        this.d = str;
        this.b = str2;
        this.c = str3;
        this.k = str4;
        this.a = str2;
    }

    public final Drawable a() {
        return this.v != null ? (Drawable) this.v.get() : null;
    }

    public final void a(Drawable drawable) {
        if (this.v != null) {
            this.v.clear();
        }
        this.v = new WeakReference(drawable);
    }

    public final String b() {
        if (TextUtils.isEmpty(this.a)) {
            return this.b;
        }
        return this.a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("VideoInfo{startPosition=");
        stringBuilder.append(this.i);
        stringBuilder.append(", sourceUrl='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", title='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", movieId='");
        stringBuilder.append(this.d);
        stringBuilder.append('\'');
        stringBuilder.append(", gcid='");
        stringBuilder.append(this.f);
        stringBuilder.append('\'');
        stringBuilder.append(", playSilence=");
        stringBuilder.append(this.g);
        stringBuilder.append(", shouldInsertRecord=");
        stringBuilder.append(this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
