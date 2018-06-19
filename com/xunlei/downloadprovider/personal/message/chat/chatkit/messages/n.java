package com.xunlei.downloadprovider.personal.message.chat.chatkit.messages;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.personal.message.chat.chatkit.commons.b;

/* compiled from: MessagesListStyle */
final class n extends b {
    int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    int d;
    int e;
    int f;
    int g;
    int h;
    int i;
    int j;
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    int r;
    int s;
    int t;
    int u;
    int v;
    int w;
    String x;
    int y;
    int z;

    static n a(Context context, AttributeSet attributeSet) {
        n nVar = new n(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.MessagesList);
        nVar.d = context.getInt(0, 0);
        nVar.e = context.getColor(1, nVar.a());
        nVar.f = context.getColor(2, nVar.a());
        nVar.g = context.getDimensionPixelSize(3, nVar.a(R.dimen.message_avatar_width));
        nVar.h = context.getDimensionPixelSize(4, nVar.a(R.dimen.message_avatar_height));
        nVar.i = context.getDimensionPixelSize(5, nVar.a(R.dimen.message_avatar_width));
        nVar.j = context.getDimensionPixelSize(6, nVar.a(R.dimen.message_avatar_height));
        nVar.B = context.getResourceId(7, -1);
        nVar.C = context.getColor(8, nVar.b(R.color.white_two));
        nVar.D = context.getColor(9, nVar.b(R.color.white_two));
        nVar.E = context.getColor(10, nVar.b(R.color.cornflower_blue_two_24));
        nVar.F = context.getResourceId(11, -1);
        nVar.G = context.getColor(12, nVar.b(R.color.transparent));
        nVar.H = context.getColor(13, nVar.b(R.color.cornflower_blue_light_40));
        nVar.I = context.getDimensionPixelSize(14, nVar.a(R.dimen.message_padding_left));
        nVar.J = context.getDimensionPixelSize(15, nVar.a(R.dimen.message_padding_right));
        nVar.K = context.getDimensionPixelSize(16, nVar.a(R.dimen.message_padding_top));
        nVar.L = context.getDimensionPixelSize(17, nVar.a(R.dimen.message_padding_bottom));
        nVar.k = context.getColor(18, nVar.b(R.color.dark_grey_two));
        nVar.l = context.getDimensionPixelSize(19, nVar.a(R.dimen.message_text_size));
        nVar.m = context.getInt(20, 0);
        nVar.n = context.getColor(21, nVar.b(R.color.warm_grey_four));
        nVar.o = context.getDimensionPixelSize(22, nVar.a(R.dimen.message_time_text_size));
        nVar.p = context.getInt(23, 0);
        nVar.M = context.getColor(24, nVar.b(R.color.warm_grey_four));
        nVar.N = context.getDimensionPixelSize(25, nVar.a(R.dimen.message_time_text_size));
        nVar.O = context.getInt(26, 0);
        nVar.P = context.getResourceId(27, -1);
        nVar.Q = context.getColor(28, nVar.b(R.color.cornflower_blue_two));
        nVar.R = context.getColor(29, nVar.b(R.color.cornflower_blue_two));
        nVar.S = context.getColor(30, nVar.b(R.color.cornflower_blue_two_24));
        nVar.T = context.getResourceId(31, -1);
        nVar.U = context.getColor(32, nVar.b(R.color.transparent));
        nVar.V = context.getColor(33, nVar.b(R.color.cornflower_blue_light_40));
        nVar.W = context.getDimensionPixelSize(34, nVar.a(R.dimen.message_padding_left));
        nVar.X = context.getDimensionPixelSize(35, nVar.a(R.dimen.message_padding_right));
        nVar.Y = context.getDimensionPixelSize(36, nVar.a(R.dimen.message_padding_top));
        nVar.Z = context.getDimensionPixelSize(37, nVar.a(R.dimen.message_padding_bottom));
        nVar.q = context.getColor(38, nVar.b(R.color.white));
        nVar.r = context.getDimensionPixelSize(39, nVar.a(R.dimen.message_text_size));
        nVar.s = context.getInt(40, 0);
        nVar.t = context.getColor(41, nVar.b(R.color.white60));
        nVar.u = context.getDimensionPixelSize(42, nVar.a(R.dimen.message_time_text_size));
        nVar.v = context.getInt(43, 0);
        nVar.aa = context.getColor(44, nVar.b(R.color.warm_grey_four));
        nVar.ab = context.getDimensionPixelSize(45, nVar.a(R.dimen.message_time_text_size));
        nVar.ac = context.getInt(46, 0);
        nVar.w = context.getDimensionPixelSize(47, nVar.a(R.dimen.message_date_header_padding));
        nVar.x = context.getString(48);
        nVar.y = context.getColor(49, nVar.b(R.color.warm_grey_two));
        nVar.z = context.getDimensionPixelSize(50, nVar.a(R.dimen.message_date_header_text_size));
        nVar.A = context.getInt(51, 0);
        nVar.ad = context.getResourceId(52, -1);
        context.recycle();
        return nVar;
    }

    private n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private Drawable a(@ColorInt int i, @ColorInt int i2, @ColorInt int i3, @DrawableRes int i4) {
        i4 = DrawableCompat.wrap(d(i4)).mutate();
        r2 = new int[3][];
        r2[0] = new int[]{16842913};
        r2[1] = new int[]{16842919};
        r2[2] = new int[]{-16842919, -16842913};
        DrawableCompat.setTintList(i4, new ColorStateList(r2, new int[]{i2, i3, i}));
        return i4;
    }

    final Drawable b() {
        if (this.P == -1) {
            return a(this.Q, this.S, this.R, R.drawable.shape_outcoming_message);
        }
        return c(this.P);
    }

    public final Drawable c() {
        return this.ad != -1 ? c(this.ad) : null;
    }

    final Drawable d() {
        if (this.B == -1) {
            return a(this.C, this.E, this.D, R.drawable.shape_incoming_message);
        }
        return c(this.B);
    }
}
