package com.xunlei.downloadprovider.personal.a.b.c;

import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.download.center.widget.as;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.download.tasklist.task.h;
import com.xunlei.downloadprovider.personal.UserCenterFragment;
import com.xunlei.downloadprovider.personal.a.f.a;
import com.xunlei.downloadprovider.personal.a.j;

/* compiled from: UserOneGridDlViewHolder */
public final class b extends a implements com.xunlei.downloadprovider.personal.a.b {
    private TextView a;
    private TextView b;
    private ImageView c;
    private TextView d;
    private ImageView e;
    private FragmentActivity f;
    @Nullable
    private as g = new as();
    private com.xunlei.downloadprovider.download.center.widget.as.b h = new c(this);

    public b(View view, FragmentActivity fragmentActivity, UserCenterFragment userCenterFragment) {
        super(view);
        userCenterFragment.a(this, "kye_user_fixed_view");
        this.f = fragmentActivity;
        this.a = (TextView) view.findViewById(R.id.tv_one_grid_title);
        this.b = (TextView) view.findViewById(R.id.tv_one_grid_des);
        this.c = (ImageView) view.findViewById(R.id.iv_me_tab_download_icon);
        this.d = (TextView) view.findViewById(R.id.tv_me_tab_download_num);
        this.e = (ImageView) view.findViewById(R.id.iv_me_tab_download_num_3length);
        view.setOnClickListener(new d(this));
    }

    private void e() {
        h.e();
        int unfinishedUnIllegalCount = h.c().getUnfinishedUnIllegalCount();
        if (unfinishedUnIllegalCount == 0) {
            this.d.setVisibility(8);
            this.e.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        CharSequence valueOf = String.valueOf(unfinishedUnIllegalCount);
        int length = valueOf.length();
        int a = a.a(length);
        this.d.setText(valueOf);
        if (length >= 3) {
            this.d.setVisibility(8);
            this.e.setVisibility(0);
            return;
        }
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.d.setBackgroundResource(a);
    }

    public final void a() {
        e();
    }

    public final void b() {
        if (this.g != null) {
            this.g.d();
        }
    }

    public final void a(Object obj) {
        e();
        if (this.g != null) {
            this.g.b = this.h;
            this.g.a();
        }
        if (obj != null && (obj instanceof com.xunlei.downloadprovider.personal.a.b.h)) {
            com.xunlei.downloadprovider.personal.a.b.h hVar = (com.xunlei.downloadprovider.personal.a.b.h) obj;
            CharSequence charSequence = hVar.d;
            CharSequence charSequence2 = hVar.e;
            int i = hVar.j;
            obj = hVar.f;
            if (TextUtils.isEmpty(charSequence)) {
                this.a.setText("");
                this.b.setText("");
                return;
            }
            if (TextUtils.isEmpty(obj)) {
                this.c.setImageResource(i);
            } else {
                a.a(obj, this.c, R.drawable.ic_user_center_default_gray);
            }
            this.a.setText(charSequence);
            this.b.setText(charSequence2);
        }
    }

    static /* synthetic */ void b(b bVar) {
        j.a("bar_dl_center", false);
        com.xunlei.downloadprovider.download.a.a(bVar.f, DLCenterEntry.personal_center.toString());
    }
}
