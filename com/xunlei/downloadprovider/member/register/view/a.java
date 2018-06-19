package com.xunlei.downloadprovider.member.register.view;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.R;
import java.lang.reflect.Field;

/* compiled from: LoginRegisterToast */
public final class a {
    private static long a;
    private static CharSequence b = "";
    private static long c;
    private boolean d;
    private Toast e;
    private Context f;
    private long g = 2000;
    private boolean h = false;
    private Object i;
    private LayoutParams j;
    private View k;
    private Handler l = new Handler();

    private a(Context context, int i, CharSequence charSequence) {
        long currentTimeMillis = System.currentTimeMillis();
        if (charSequence != null) {
            if (!charSequence.equals(b) || currentTimeMillis - a >= c) {
                a = currentTimeMillis;
                b = charSequence;
                c = 3500;
                this.f = context;
                if (this.e == null) {
                    this.e = new Toast(this.f);
                }
                this.k = ((LayoutInflater) this.f.getSystemService("layout_inflater")).inflate(R.layout.toast_login_register, null);
                TextView textView = (TextView) this.k.findViewById(R.id.tv_toast_text);
                textView.setText(charSequence);
                textView.setBackgroundResource(i == 1 ? R.drawable.toast_blue_bg : R.drawable.toast_red_bg);
                this.g = 3500;
                return;
            }
        }
        this.d = true;
    }

    public final void a() {
        if (!this.d) {
            if (!this.h) {
                this.e.setView(this.k);
                try {
                    Field declaredField = this.e.getClass().getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    this.i = declaredField.get(this.e);
                    declaredField = this.i.getClass().getDeclaredField("mParams");
                    declaredField.setAccessible(true);
                    this.j = (LayoutParams) declaredField.get(this.i);
                    this.j.flags = 40;
                    this.j.windowAnimations = R.style.login_register_toast_anim;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.e.setGravity(48, 0, DipPixelUtil.dip2px(105.0f));
                this.e.show();
            }
        }
    }

    public static a a(Context context, int i, CharSequence charSequence) {
        Toast makeText = Toast.makeText(context, charSequence, 0);
        a aVar = new a(context, i, charSequence);
        aVar.e = makeText;
        return aVar;
    }

    public static a a(Context context, int i) throws NotFoundException {
        return a(context, 2, context.getResources().getText(i));
    }

    public static void b(Context context, int i) {
        a(context, 1, context.getString(i)).a();
    }

    public static void c(Context context, int i) {
        a(context, context.getString(i));
    }

    public static void a(Context context, String str) {
        a(context, 2, str).a();
    }
}
