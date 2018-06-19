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

/* compiled from: MessageInputStyle */
final class i extends b {
    private int A;
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
    boolean d;
    int e;
    int f;
    int g;
    int h;
    int i;
    String j;
    int k;
    int l;
    int m;
    int n;
    String o;
    String p;
    int q;
    int r;
    int s;
    Drawable t;
    Drawable u;
    int v;
    int w;
    int x;
    int y;
    private int z;

    static i a(Context context, AttributeSet attributeSet) {
        i iVar = new i(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.MessageInput);
        iVar.d = context.getBoolean(14, false);
        iVar.z = context.getResourceId(15, -1);
        iVar.A = context.getColor(16, iVar.b(R.color.white_four));
        iVar.B = context.getColor(17, iVar.b(R.color.white_five));
        iVar.C = context.getColor(18, iVar.b(R.color.transparent));
        iVar.D = context.getResourceId(19, -1);
        iVar.E = context.getColor(20, iVar.b(R.color.cornflower_blue_two));
        iVar.F = context.getColor(21, iVar.b(R.color.cornflower_blue_two_dark));
        iVar.G = context.getColor(22, iVar.b(R.color.cornflower_blue_light_40));
        iVar.e = context.getDimensionPixelSize(24, iVar.a(R.dimen.input_button_width));
        iVar.f = context.getDimensionPixelSize(25, iVar.a(R.dimen.input_button_height));
        iVar.g = context.getDimensionPixelSize(23, iVar.a(R.dimen.input_button_margin));
        iVar.H = context.getResourceId(0, -1);
        iVar.I = context.getColor(1, iVar.b(R.color.cornflower_blue_two));
        iVar.J = context.getColor(2, iVar.b(R.color.cornflower_blue_two_dark));
        iVar.K = context.getColor(3, iVar.b(R.color.white_four));
        iVar.L = context.getResourceId(4, -1);
        iVar.M = context.getColor(5, iVar.b(R.color.white));
        iVar.N = context.getColor(6, iVar.b(R.color.white));
        iVar.O = context.getColor(7, iVar.b(R.color.warm_grey));
        iVar.h = context.getDimensionPixelSize(12, iVar.a(R.dimen.input_button_width));
        iVar.i = context.getDimensionPixelSize(13, iVar.a(R.dimen.input_button_height));
        iVar.m = context.getDimensionPixelSize(11, iVar.a(R.dimen.input_button_margin));
        iVar.j = context.getString(8);
        iVar.l = context.getColor(9, iVar.b(R.color.white));
        iVar.k = context.getDimensionPixelSize(10, iVar.a(R.dimen.input_text_size));
        iVar.n = context.getInt(26, 5);
        iVar.o = context.getString(27);
        iVar.p = context.getString(28);
        iVar.q = context.getDimensionPixelSize(29, iVar.a(R.dimen.input_text_size));
        iVar.r = context.getColor(30, iVar.b(R.color.dark_grey_two));
        iVar.s = context.getColor(31, iVar.b(R.color.warm_grey_three));
        iVar.t = context.getDrawable(32);
        iVar.u = context.getDrawable(33);
        context.recycle();
        iVar.v = iVar.a(R.dimen.input_padding_left);
        iVar.w = iVar.a(R.dimen.input_padding_right);
        iVar.x = iVar.a(R.dimen.input_padding_top);
        iVar.y = iVar.a(R.dimen.input_padding_bottom);
        return iVar;
    }

    private i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private Drawable a(@ColorInt int i, @ColorInt int i2, @ColorInt int i3, @DrawableRes int i4) {
        i4 = DrawableCompat.wrap(d(i4)).mutate();
        int[][] iArr = new int[3][];
        iArr[0] = new int[]{16842910, -16842919};
        iArr[1] = new int[]{16842910, 16842919};
        iArr[2] = new int[]{-16842910};
        DrawableCompat.setTintList(i4, new ColorStateList(iArr, new int[]{i, i2, i3}));
        return i4;
    }

    final Drawable b() {
        if (this.z == -1) {
            return a(this.A, this.B, this.C, R.drawable.mask);
        }
        return c(this.z);
    }

    final Drawable c() {
        if (this.D == -1) {
            return a(this.E, this.F, this.G, R.drawable.ic_add_attachment);
        }
        return c(this.D);
    }

    final Drawable d() {
        if (this.H == -1) {
            return a(this.I, this.J, this.K, R.drawable.mask);
        }
        return c(this.H);
    }
}
