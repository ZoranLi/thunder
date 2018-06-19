package com.xunlei.downloadprovider.a;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.dialog.i;
import com.xunlei.downloadprovider.homepage.follow.ae;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: ActivityDlg */
public final class b extends i {
    private g a;
    private boolean b;
    private boolean c;

    public final int b() {
        return 9;
    }

    public b(Context context, g gVar) {
        super(context);
        this.a = gVar;
        context = LayoutInflater.from(this.i).inflate(R.layout.dialog_home_activity, null);
        setContentView(context);
        ((ImageView) context.findViewById(R.id.iv_close)).setOnClickListener(new c(this));
        ImageView imageView = (ImageView) findViewById(R.id.iv_title);
        ae.a();
        Glide.with(imageView.getContext()).load(this.a.c).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.choiceness_icon_default).fallback(R.drawable.choiceness_icon_default).error(R.drawable.choiceness_icon_default).into(imageView);
        Glide.with(imageView.getContext()).load(this.a.c).diskCacheStrategy(DiskCacheStrategy.ALL).listener(new d(this, imageView)).into(imageView);
        ((TextView) findViewById(R.id.tv_msg)).setText(this.a.b);
        TextView textView = (TextView) context.findViewById(R.id.tv_jump);
        textView.setText(this.a.d);
        textView.setOnClickListener(new e(this));
        setOnCancelListener(new f(this));
    }

    protected final void a() {
        super.a();
        i iVar = new i();
        int i = this.a.a;
        Editor edit = iVar.a.edit();
        StringBuilder stringBuilder = new StringBuilder("is_activity_showed_");
        stringBuilder.append(i);
        edit.putBoolean(stringBuilder.toString(), true).apply();
        LoginHelper.a();
        boolean c = l.c();
        StatEvent build = HubbleEventBuilder.build("android_home_activity", "home_activity_alert_show");
        build.add("if_login", c);
        h.a(build);
    }

    public final void show() {
        if (this.b) {
            super.show();
            this.c = false;
            return;
        }
        this.c = true;
    }
}
